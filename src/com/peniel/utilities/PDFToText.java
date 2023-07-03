package com.peniel.utilities;

import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.pdfclown.documents.Page;
import org.pdfclown.documents.contents.ITextString;
import org.pdfclown.tools.TextExtractor;

import com.peniel.common.DBManager;
import com.peniel.common.DbManagerValues;

public class PDFToText {

	String cmmd = "";
	String outfilename = "";
	String newOutfilename = "";
	 ExecutorService executorService=null;
	
	public PDFToText(){
		
		try{
	    	javax.naming.Context ctx = new javax.naming.InitialContext();
	    	cmmd = (String) ctx.lookup("java:comp/env/pdf2txt");
			
	    } catch(Exception e){
	    	System.out.println("Exception retrieving config param pdf2txt -->"+e.getMessage());
	    }
		
		executorService = Executors.newFixedThreadPool(10);
	}
	
	
    /** The original PDF that will be parsed. */
    //public  String cmmd = "C:\\pdf2txtocrcmd\\pdf2txtocr.exe";

	/**
     * Parses a PDF to a plain text file and inserting txt to database.
     * @param fileName of the original PDF
     * @param fullPath of the original PDF
	 * @param executorService 
     * @throws IOException
     */
    public void parsePdf(final String documentId, final String fullPath, final String outputTextFile, final String insertMode) {
    	/*executorService.submit(new Runnable(){
            public void run() { */        	
    
    	try{
        	//System.out.println("*******in parsePdf *******"+cmmd);  		
    	
        	
        	System.out.println("*******in parsePdf fullPath *******"+fullPath+"<-- outFile -->"+ "\""+outputTextFile.replaceAll("\\\\", "/")+"\""+"<--");
        	
        	String[] commands = {"cmd", "/c", cmmd, "\""+fullPath.replaceAll("\\\\", "/")+"\"", "\""+outputTextFile.replaceAll("\\\\", "/")+"\"" };
        	//String commd = "cmd /c start cmd /C"+ cmmd +" -bitcount 8 -ocrmode 4 -ocr "+ "\""+outfilename+"\"" +" "+ "\""+newOutfilename+"\"";
        	

        	Process p = Runtime.getRuntime().exec(commands);
        	
        	  //handling the streams so that dead lock situation never occurs.  
        	try
        	{
        	ProcessHandler inputStream =
        	new ProcessHandler(p.getInputStream(),"INPUT");
        	ProcessHandler errorStream =
        	new ProcessHandler(p.getErrorStream(),"ERROR");

        	// start the stream threads 
        	inputStream.start();
        	errorStream.start();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
        	
	       int i = p.waitFor(); // i=0 is success.
        	
	        System.out.println("OCR i = "+i+"<----");
	        p.getInputStream().close();
	        p.getErrorStream().close();
	        p.destroy();
	        
	        if(i == 0){
	        
	       	System.out.println("Parse PDF file successful OCR.");
	        	
	        	textToDB(documentId, outputTextFile.replaceAll("\\\\", "/"), insertMode);
	        	
	        	File outputFile = new File(outputTextFile);
	            boolean delTxt = outputFile.delete();                
	            
	            System.out.println(outputFile +" file deleted --> "+delTxt);
	                
	       }
	        
	        System.out.println("OCR process for document id "+documentId+" is successfull ");
	            
        }catch(Exception e){
         	System.out.println("Exception during ocr -->"+e.getMessage());
        }
    	
    	  /*}
    	}); */      
    	
    }
    
    /**
     * This method reads a txt file and inserts the txt to database
     * @param documentId 
     * @param outputTextFile file to read
     * @insertMode insert or update to database
     */
    public void textToDB(String documentId, String outputTextFile, String insertMode){
    	
    	Connection conn;
        conn = null;
        PreparedStatement pstmt = null;
        String clobValue = "";
        DBManager db = null;
        try{
        	outputTextFile = outputTextFile.replaceAll("\\\\", "/");
        	InputStream ips=new FileInputStream(outputTextFile); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String line;
            
            while ((line=br.readLine())!=null){
                clobValue+=line+"\n";
            }
            
            br.close();
            ipsr.close();
            ips.close();
            //System.out.println("CLOB value-->"+clobValue);

            db = DBManager.getInstance();
        	
        	//insert into database CLOB
        	
            conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);
            
            //System.out.println("mode-->"+insertMode);
            
            if("add".equals(insertMode)){
            	
            	pstmt = conn.prepareStatement("insert into HUD_PDF (DOCUMENT_ID, PDF_STR) values (?, ?)");
        		
            	pstmt.setString(1, documentId);
        		pstmt.setString(2, clobValue);
        		pstmt.executeUpdate();
        		
        		System.out.println("********** 1 ************");
        		pstmt.execute("begin  ctx_ddl.sync_index('hud_pdf_context'); end;");
        		
        		System.out.println("********** 2 ************");
        		
        		System.out.println("Document with id "+documentId+": successful inserted to database");
        		
            } else if("update".equals(insertMode)){
            	
            	pstmt = conn.prepareStatement("update hud_pdf set pdf_str = ? where document_id = ? ");
        		
            	pstmt.setString(1, clobValue);
        		pstmt.setString(2, documentId);
        		pstmt.executeUpdate();
        		
        		
        		pstmt.execute("begin  ctx_ddl.sync_index('hud_pdf_context'); end;");
        		
        		System.out.println("********** 2 ************");
        		
        		
        		System.out.println("Document with id "+documentId+": successful updated to database");
            }
    		
    		
        	
    		
        }catch(Exception ex){
        	System.out.println("exception in executing insert to HUD_PDF -->"+ex.getMessage());
        }finally{
        	if(pstmt != null){
        		try{
        			pstmt.close();
        			pstmt = null;
        		}catch(Exception st){
        			
        		}
	        }
        	try{
        		db.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
        	}catch(Exception st){
    			
    		}
        }

    }
    
    
    /**
     * This method converts input pdf to searchable pdf
     * and the searchable pdf replaces the current pdf
     * @param outfilename input non searchable pdf  
     * @param newOutfilename input complete file path for the new converted pdf  
     * @param mode 
     * @param outTextFileName 
     * @param docId 
     */
    
    public void pdfToSearchablePdf(final String outfilename, final String newOutfilename, final String docId, final String outTextFileName, final String mode){
      	executorService.submit(new Runnable(){
            public void run() {         	
    	
    	try{
    		
    	  		  
    		
    		System.out.println(" **** in pdfToSearchablePdf ****");
    		
    		System.out.println("outfilename-->"+outfilename+"<--");
    		
    		System.out.println("newOutfilename-->"+newOutfilename+"<--");
    		
    		
    		   		
    		// Convert original pdf to searchable pdf
    		String commd = "cmd /c "+ cmmd +" -bitcount 8 -ocrmode 4 -ocr "+ "\""+outfilename.replaceAll("\\\\", "/")+"\"" +" "+ "\""+newOutfilename+"\"";
    		
    	      System.out.println("commd() : " + commd);
        	
    	      Process p = Runtime.getRuntime().exec(commd);
          	
          	
          	/* handling the streams so that dead lock situation never occurs.*/  
          	ProcessHandler inputStream =
          	new ProcessHandler(p.getInputStream(),"INPUT");
          	ProcessHandler errorStream =
          	new ProcessHandler(p.getErrorStream(),"ERROR");

          	/* start the stream threads */
          	inputStream.start();
          	errorStream.start();
          	
        
          	int i = p.waitFor(); // value of i should be 0 after successful processing.
          	/* start */
          	
          	System.out.println("PDF file OCR. i -->"+i+"<--");
        	p.getInputStream().close();
        	p.getErrorStream().close();
          	p.destroy();
          	
          	parsePdf(docId, outfilename,
                     outTextFileName, mode);
        	
        	if(i == 0){
	        	
	        	System.out.println("PDF file successful OCR.");
	        	
	        	//System.out.println("**** Trying to delete the file after destroy  ***");
	        	
	        	// Delete original pdf
	        	//java.nio.file.Files origFile = new java.nio.file.Files();	        	
	        	
                                       
	        	   System.out.println(outfilename+" outfilename successfully-->");
        		  // Thread.sleep(2000);
        		
	        	try{
	        		Path ps = Paths.get(outfilename);	        			       
	        		boolean delFile=java.nio.file.Files.deleteIfExists(ps);
	        		
	        		System.out.println(outfilename+" File deleted successfully-->"+delFile);
	        	
		            File replaceNewFile = new File(newOutfilename);
			        boolean replFile = replaceNewFile.renameTo(new File(outfilename));
	        	   	
			        System.out.println(newOutfilename+" ocr file renamed successfully the file-->"+replFile);
			        
		         
	        	}catch(Exception e){
	        		e.printStackTrace();
	        		System.out.println(" deleted file exception-->"+e.getMessage());
	        	}
		      	        	
	        }
	      
	        
    	}catch(Exception e){
    		System.out.println("Exception in pdfToSearchablePdf-->"+e.getMessage()+"<--");
    	}
    	
    }
});
	     
    }
    
    /**
     * This method checks if the input pdf is searchable.
     * @param filePath for the pdf to be checked
     * @return boolean true if pdf is searchable else false
     */
    public boolean isPDFSearchable(String filePath){
		boolean result = false;
		org.pdfclown.files.File filedata = null;
		try{
			System.out.println("*** in isPDFSearchable filePath -->"+filePath+"<--");
			
			filedata = new org.pdfclown.files.File(filePath);
	    				
    		final String keySearch = "a";
            Pattern pattern = Pattern.compile("a", Pattern.CASE_INSENSITIVE);

            TextExtractor textExtractor = new TextExtractor(true, true);
            for(final Page page : filedata.getDocument().getPages())
            {
            	Map<Rectangle2D,List<ITextString>> textStrings = textExtractor.extract(page);		                
            	
            	final Matcher matcher = pattern.matcher(TextExtractor.toString(textStrings));
            	
            	if(matcher.find() == true) {
            		result = true;
            		break;
            		
            	}
            }
	            
		}catch(Exception e){
			System.out.println("Exception e-->"+e.getMessage());
		}
		finally{
		    try {
		        filedata.close();
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		}
		return result;
	}



	
	public void waitStop() {
        executorService.shutdown();
        try {
			executorService.awaitTermination(99999999L, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }

    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws IOException
     *
    public static void main(String[] args) throws IOException {
    	
    	File directory = new File(SOURCE_FOLDER_PATH);
    	File[] fileList = directory.listFiles();
    	String fileName = "";
    	String fullPath = "";
    	/*
    	for(File file : fileList){
    		
    		fileName = file.getName();
    		fullPath = SOURCE_FOLDER_PATH+"\\"+fileName;
    		
    		new PDFToText().parsePdf(fileName, fullPath);
    	}
    	*
    	
    	new PDFToText().parsePdf("16.pdf", "C:\\input\\16.pdf");
    	
    	new PDFToText().pdfToSearchablePdf();
    }
	*/
}
