package com.peniel.utilities;

import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileAlreadyExistsException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.pdfclown.documents.Page;
import org.pdfclown.documents.contents.ITextString;
import org.pdfclown.tools.TextExtractor;

import com.google.common.io.Files;
import com.peniel.common.DBManager;
import com.peniel.common.DbManagerValues;

public class PDFUtility {

	String cmmd = "";
	String sourceFolderPath = "";
	String destnFolderPath = "";
	
	public PDFUtility(){
		
		try{
	    	javax.naming.Context ctx = new javax.naming.InitialContext();
	    	cmmd = (String) ctx.lookup("java:comp/env/pdf2txt");
	    	sourceFolderPath = (String) ctx.lookup("java:comp/env/repository");
	    	destnFolderPath = (String) ctx.lookup("java:comp/env/repositoryOCR");
	    	
			
	    } catch(Exception e){
	    	System.out.println("Exception retrieving config param pdf2txt -->"+e.getMessage());
	    }
		
		for(int i=1; i<2; i++){
			
			sourceFolderPath = sourceFolderPath + i;
			destnFolderPath = destnFolderPath + i;
			
			File directory = new File(sourceFolderPath);
			
	    	File[] fileList = directory.listFiles();
	    	String fileName = "";
	    	String fullPath = "";
	    	
	    	String sourceFile = "";
	    	String destnFile = "";
	    	String batchNo = "";
	    	String dbFilePath = "";
	    	
	    	String outTextFileName = sourceFolderPath + File.separator + "temptext.txt";
	    	
	    	for(File file : fileList){
	    		
	    		fileName = file.getName();
	    		
	    		if(!fileName.substring(0, 3).equals("Copy")){
	    				    			
	    			sourceFile = sourceFolderPath + File.separator + fileName; 
	    			destnFile = destnFolderPath + File.separator + fileName;
	    			
	    			System.out.println("sourceFile-->"+sourceFile+"<-- destnFile -->"+destnFile+"<--");
	    			
	    			
	    			batchNo = sourceFile.substring(sourceFile.lastIndexOf("\\") + 1, sourceFile.length());
	    			dbFilePath = "FHA232" + File.separator + batchNo + fileName;
	    			
	    			System.out.println("dbfilePath-->"+dbFilePath+"<--");
	    			
	    			String docId = getDocId(dbFilePath);
	                 
	    			try {
						parsePdf(docId, sourceFile, outTextFileName);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                 
	                if(!isPDFSearchable(sourceFile)){ 
	                 	// PDF is not Searchable
	                 	pdfToSearchablePdf(sourceFile, destnFile);
	                 } else {
	                 	try {
	                   	    Files.copy(new File(sourceFile), new File(destnFile));
	                   	} catch(FileAlreadyExistsException e) {
	                   	    //destination file already exists
	                   		System.out.println("*** destination file already exists-->"+e.getMessage());
	                   	} catch (IOException e) {
	                   	    //something else went wrong
	                   		System.out.println("Exception in copying file-->"+e.getMessage());
	                   	}
	                 	
	                 	
	                 }
	    			
	    			
	    		}
	    	}
    	}
    	
    	
    	//parsePdf("16.pdf", "C:\\input\\16.pdf");
    	
    	//pdfToSearchablePdf();
	    
	}
	
	
    /** The original PDF that will be parsed. */
    //public  String cmmd = "C:\\pdf2txtocrcmd\\pdf2txtocr.exe";
    
    /**
     * Parses a PDF to a plain text file and inserting txt to database.
     * @param fileName of the original PDF
     * @param fullPath of the original PDF
     * @throws IOException
     */
    public void parsePdf(String documentId, String fullPath, String outputTextFile) throws IOException {
    	
    	try{
        	System.out.println("*******in parsePdf *******"+cmmd);
    		
    		fullPath = fullPath.replaceAll("\\\\", "/");
        	outputTextFile = outputTextFile.replaceAll("\\\\", "/");
        	
        	fullPath = "\""+fullPath+"\"";
        	String outFile = "\""+outputTextFile+"\"";
        	
        	String[] commands = {"cmd", "/c", cmmd, fullPath, outFile };

        	Process p = Runtime.getRuntime().exec(commands);
        	
        	 /* handling the streams so that dead lock situation never occurs.  */
        	ProcessHandler inputStream =
        	new ProcessHandler(p.getInputStream(),"INPUT");
        	ProcessHandler errorStream =
        	new ProcessHandler(p.getErrorStream(),"ERROR");

        	/* start the stream threads */
        	inputStream.start();
        	errorStream.start();
        	
	        int i = p.waitFor(); // i=0 is success.
	        
	        if(i == 0){
	        	
	        	System.out.println("PDF file successful OCR.");
	        	
	        	textToDB(documentId, outputTextFile);
	        	
	        	File outputFile = new File(outputTextFile);
	            outputFile.delete();
	            
	            System.out.println("output file deleted successfull ");
	        
	        }
	        
	        System.out.println("OCR process for document id "+documentId+" is successfull ");
	            
        }catch(Exception e){
        	System.out.println("Exception -->"+e.getMessage());
        }
        
        
    }
    
    /**
     * This method reads a txt file and inserts the txt to database
     * @param documentId 
     * @param outputTextFile file to read
     * @insertMode insert or update to database
     */
    public void textToDB(String documentId, String outputTextFile){
    	
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
            ips.close();
            //System.out.println("CLOB value-->"+clobValue);

            db = DBManager.getInstance();
        	
        	//insert into database CLOB
        	
            conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);
            	
        	pstmt = conn.prepareStatement("insert into imgnew.HUD_PDF (DOCUMENT_ID, PDF_STR) values (?, ?)");
    		
        	pstmt.setString(1, documentId);
    		pstmt.setString(2, clobValue);
    		pstmt.executeUpdate();
    		
    		System.out.println("********** 1 ************");
    		pstmt.execute("begin  ctx_ddl.sync_index('imgnew.hud_pdf_context'); end;");
    		
    		System.out.println("********** 2 ************");
    		
    		System.out.println("Document with id "+documentId+": successful inserted to database");
        		
                		
        }catch(Exception ex){
        	System.out.println("exception in executing insert -->"+ex.getMessage());
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
     * This method reads a txt file and inserts the txt to database
     * @param documentId 
     * @param outputTextFile file to read
     * @insertMode insert or update to database
     */
    public String getDocId(String filePath){
    	
    	Connection conn;
        conn = null;
        PreparedStatement pstmt = null;
        DBManager db = null;
        ResultSet recordSet = null;
        String documentId = "";
        try{
        	db = DBManager.getInstance();
        	conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);
        	
        	String sql = "Select document_id from document_data where filename = '"+filePath+"' " ;
        	
        	pstmt = conn.prepareStatement(sql);
        	recordSet = pstmt.executeQuery();
			
        	
        	
        	while(recordSet.next())
        	{
        		documentId = recordSet.getString("document_id");

    			System.out.println(" filePath -->"+filePath+"<-- document id -->"+documentId+"<--");
	    		
        	}	
                		
        }catch(Exception ex){
        	System.out.println("exception in executing insert -->"+ex.getMessage());
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

        return documentId;
    }

    
    /**
     * This method converts input pdf to searchable pdf
     * and the searchable pdf replaces the current pdf
     * @param outfilename input non searchable pdf  
     * @param newOutfilename input complete file path for the new converted pdf  
     */
    
    public void pdfToSearchablePdf(String outfilename, String newOutfilename){
    	try{
    		
    		outfilename = outfilename.replaceAll("\\\\", "/");
    		
    		System.out.println(" **** in pdfToSearchablePdf ****");
    		
    		System.out.println("outfilename-->"+outfilename+"<--");
    		
    		System.out.println("newOutfilename-->"+newOutfilename+"<--");
    		
    		// Convert original pdf to searchable pdf
    		String commd = "cmd /c "+ cmmd +" -bitcount 8 -ocrmode 4 -ocr "+ "\""+outfilename+"\"" +" "+ "\""+newOutfilename+"\"";
        	
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
        	
        	//p.destroy();
        	
        	if(i == 0){
	        	
	        	System.out.println("PDF file successful OCR.");
	        	
	        	//System.out.println("**** Trying to delete the file after destroy  ***");
	        	
	        	// Delete original pdf
	        	//java.nio.file.Files origFile = new java.nio.file.Files();
	        	/*try{
	        		Path ps = Paths.get(outfilename);
	        		java.nio.file.Files.delete(ps);
	        	}catch(Exception e){
	        		System.out.println(" deleted file exception-->"+e.getMessage());
	        	}
		       // System.out.println(outfilename+" deleted successfully-->"+orgFile);
		        
		        /*
		        // Rename searchable pdf to original pdf
		        File replaceNewFile = new File(newOutfilename);
		        boolean replFile = replaceNewFile.renameTo(origFile);
		        */
		        
		        //   System.out.println(newOutfilename+" renamed successfully-->"+replFile);
	        }
	        // end
        	
	        
	        
	        
    	}catch(Exception e){
    		System.out.println("Exception in pdfToSearchablePdf-->"+e.getMessage()+"<--");
    	}
	        
    }
    
    /**
     * This method checks if the input pdf is searchable.
     * @param filePath for the pdf to be checked
     * @return boolean true if pdf is searchable else false
     */
    public boolean isPDFSearchable(String filePath){
		boolean result = false;
		try{
			org.pdfclown.files.File file = new org.pdfclown.files.File(filePath);
	    				
    		final String keySearch = "a";
            Pattern pattern = Pattern.compile("a", Pattern.CASE_INSENSITIVE);

            TextExtractor textExtractor = new TextExtractor(true, true);
            for(final Page page : file.getDocument().getPages())
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

		return result;
	} 

    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    	
    	PDFUtility pdfUtility = new PDFUtility();
    	/*
    	File directory = new File(sourceFolderPath);
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
    	*/
    }
	
}
