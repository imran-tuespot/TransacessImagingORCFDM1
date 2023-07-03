
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.Company;
import com.peniel.dao.CompanyDAO;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.utilities.PDFToText;
import com.peniel.utilities.ParseMultiForm;

/**
 * Servlet implementation class for Servlet: FileUpload
 * 
 */
public class FileUpload extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	private static Logger logger = LogManager.getLogger(FileUpload.class);

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public FileUpload() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("In upload file ");
		String fileName = "";
		String oldFile="";
		String indTyp = "";
		String val = "";
		String dcTyp = "";
		String success = "";
		String docId = "";
		String version = "";
		String comid = "";
		String status = "";
		String actualFileName = "";
		String infile = "";
		
		String docTypeId = "";
		String confirmParam = "";
		String strResponse ="";
				
		String sessionid="";
        String companyName ="";

        ParseMultiForm pMF = new ParseMultiForm( request );
        String param;
        StringBuffer g = new StringBuffer( strResponse );
        String mode = "add";
        final PDFToText pdfToText = new PDFToText();
        String outTextFileName = "";
        
        String webFolder = "";
        String outfilename = "";
        String webFileName = "";

        while ( (param = pMF.getNextParameter(g)) != null ){
        	  
              if ("browseFile".equals(param) ) {

	                System.out.println("A file param detected");
	                infile=pMF.getFilename();
	                String k=param;
	                String v=infile;
	                
	                actualFileName = infile;
	                
	                if (infile!=null){
	                	
	                      try{
	                    	  webFolder = getFromEnv("webfolder");
	                  		
	                          outTextFileName = buildDestinationFileName(companyName, webFolder, "temptext.txt");
	                    	  
	                    	  
	                    	  DocumentDataDAO documentDataDAO = new DocumentDataDAO();
	                    	  String newDocId = Long.toString(documentDataDAO.getMaxiDocId()); 
                         	  //System.out.println("*** newDocId --->"+newDocId+"<--");
                         	 
                         	  fileName = newDocId + ".pdf";
                         	  
                         	  outfilename = buildDestinationFileName(companyName, webFolder, fileName);
                               
                         	  try{
                               	saveFile(pMF, outfilename);
                               	//System.out.println("**** after save file ****");
                               }catch(Exception e){
                               	System.out.println("Exception in saving file-->"+e.getMessage());
                               }
                                 
                             // Perform OCR on the pdf. Insert txt to database for searching.
                             //String newOutfilename = buildDestinationFileName(companyName, webFolder, "new"+fileName);
                         	  
                         	  String newOutfilename = buildDestinationFileNameOCR(companyName, webFolder, "ocr_"+fileName);  
                              if(!pdfToText.isPDFSearchable(outfilename)){ 
                             	// PDF is not Searchable
                             	pdfToText.pdfToSearchablePdf(outfilename, newOutfilename,newDocId, outTextFileName, mode);
                             	
                             }
                             else
                             {
                              	  pdfToText.parsePdf(newDocId, outfilename, outTextFileName, mode);
                                  
                                   
                             }
                             	
                              webFileName = companyName + "/" + webFolder + "/" + fileName;	
                           	   
			                  success = "yes";
	                      } catch (Exception e) {
	      					// TODO Auto-generated catch block
	                    	  success="error";
	      					e.printStackTrace();
	      					System.out.println("error in upbean store -->"+e.getMessage());
	      				}
	               }

              }else{

	                String k=param;
	
	                String v="";
	
	                if (k.equalsIgnoreCase("message")){
	                      v=pMF.getMessage();
	                }
	                else{
	
		                 v=pMF.getParameter();
		                 
		                 if("status".equals(k)) status = v;
		                 
		                 if("sessionid".equals(k)) sessionid = v;
		                 
		                 if("indTyp".equals(k)) indTyp = v;
		         		
		         		 if("val".equals(k)) val = v;
		         		
		         		 if("dcTyp".equals(k)) dcTyp = v;
		     			  
		       			 if("fileName".equals(k)) {
		       				 fileName = v;
		       				 oldFile = v;
		       				 
		       			 }
		       			 
		       			if("actualFileName".equals(k)) actualFileName = v;
		       			
		       			if("docId".equals(k)) docId = v;
		       			 
		       			if("docTypeId".equals(k)) docTypeId = v;
		       			 
		       			 if("version".equals(k)) version = v;
		       			 
		       			if("version".equals(k)) version = v;
		       			 
		       			
		       			 
		       			 if("comid".equals(k)) {
		       				comid = v;
		       				
		       				CompanyDAO companyDao = new CompanyDAO();
		       				Vector companyList = new Vector();
		       				Company company = new Company();
		       			
		       				companyList = companyDao.findById(comid);
		       				company = (Company) companyList.get(0);
		       				companyName = company.getCompanyName();
		       			}
	       			
	       			
		       			if("confirmParam".equals(param)){
		       				confirmParam = v;
		       				
		       				if("Yes".equals(confirmParam)){
		    					
		    					success = "confirmed";
		    					
		    					// Add the record to the db
		    					int currentVersion = 0;
		    					int newVersion = 0;
		    					if(!"".equals(version) && version != null){
		    						currentVersion = Integer.parseInt(version);
		    						newVersion = currentVersion + 1;
		    					}
		    					
		    					DocumentDataDAO docDataDAO = new DocumentDataDAO();
		    					try{
		    						
		    						webFileName = fileName;
		    						docDataDAO.insertDocVersion(docId, sessionid, currentVersion, newVersion,webFileName, actualFileName );
		    					}
		    					catch(Exception e){
		    						success = "error";
		    					}
		    					logger.info("success after insert -->"+success);
		    			  }
		       			}
	
	                }

	                //System.out.println("kv="+k+"---"+v);
              	}   
            }
			request.setAttribute("sessionid", sessionid);
			request.setAttribute("companyName", companyName);
			
			//System.out.println("**** id --->"+webFileName);
			//System.out.println("**** actualFileName --->"+actualFileName);
			
			RequestDispatcher dispatcher= request.getRequestDispatcher("/replaceDocument.jsp?id="+webFileName+"&success="+success+"&docId="+docId+"&version="+version+"&comid="+comid+"&actualFileName="+actualFileName+"&status="+status+"&indTyp="+indTyp+"&dcTyp="+dcTyp+"&val="+val+"&docTypeId="+docTypeId+"&oldFile="+oldFile);
			dispatcher.forward(request, response);
		    
		}
	
	public void saveFile(ParseMultiForm pMF, String outfilename) throws IOException {
        FileOutputStream OutFile = new FileOutputStream(outfilename);

        // Copies the file from
        pMF.getParameter(OutFile);
        OutFile.flush();
        OutFile.close();
    }
	
	public String buildDestinationFileName(String companyName, String webFolder, String infile) {
        String retval =  getDestinationBaseDirectory() + File.separator + companyName + File.separator + webFolder + File.separator + infile;
        logger.debug("Destination with company name Directory " + retval);
        return retval;
    }
    
    public String buildDestinationFileNameOCR(String companyName, String webFolder, String infile) {
        String retval =  getDestinationBaseDirectoryOCR() + File.separator + companyName + File.separator + webFolder + File.separator + infile;
        logger.debug("Destination with company name Directory " + retval);
        return retval;
    }
    
    public String getDestinationBaseDirectory() {
        try {
        	return  getFromEnv("repository");
        } catch (NamingException e) {
            return null;
        }
    }
    
    public String getDestinationBaseDirectoryOCR() {
        try {
        	return  getFromEnv("repositoryOCR");
        } catch (NamingException e) {
            return null;
        }
    }

    public String getFromEnv(String val) throws NamingException {
        javax.naming.Context ctx = new javax.naming.InitialContext();
        return (String) ctx.lookup("java:comp/env/" + val);
    }
}