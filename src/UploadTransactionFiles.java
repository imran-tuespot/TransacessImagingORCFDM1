

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import com.peniel.beans.FolderBean;
import com.peniel.beans.getDropD;
import com.peniel.bus.vo.CheckboxValue;
import com.peniel.bus.vo.Company;
import com.peniel.bus.vo.Property;
import com.peniel.common.PenielException;
import com.peniel.dao.CompanyDAO;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.dao.DocumentTypeDAO;
import com.peniel.dao.FolderDAO;
import com.peniel.dao.PropertyDAO;
import com.peniel.database.DatabaseConnection;
import com.peniel.utilities.FileNameProcessor;
import com.peniel.utilities.PDFToText;
import com.peniel.utilities.ToPDF;
import com.penielsolutions.converter.Converter;
import com.penielsolutions.converter.ConverterService;
import com.penielsolutions.converter.ConverterServiceLocator;

/**
 * Servlet implementation class UploadFile
 */
public class UploadTransactionFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(UploadTransactionFiles.class);
	   final PDFToText pdfToText = new PDFToText();
	final ConverterData converterData=new ConverterData();
	   ExecutorService executorService=null;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadTransactionFiles() {
    	
        super();
        // TODO Auto-generated constructor stub
        executorService = Executors.newFixedThreadPool(10);
    }
    
    public void destroy() {
        super.destroy();
        converterData.waitStop();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName = "";
	    String doctype = "";
	    String folderNameFView ="";
	    String propertytype = "";
	    String folderval ="";
	    String folderNameFViewData ="";
	    String folderNameFViewDataName ="";
		 String transactiontype="";
		 String transactionDate="";
		 String transactionStatus="";
	    
	    String fhaNumber="";
	    
	   String indextype = "";	    
	  String indexval = "";
	    ArrayList<Integer> indextypelist = new ArrayList<Integer>();
        ArrayList<String> indexvallist = new ArrayList<String>();
        
	    boolean success = false;
	    String docId = null;
	    String version = "";
	    String cId = "";
	    String sessionid = "";
	    String chkConvert ="off";
	    String confirmParam = "";
	    String actualFileName = "";
	    String strResponse = "";
	    String companyName = "";
	    String fileUploadSize = "";
	    String FileSize = "";
	    String webFolder = "";
	    String rawFileName;
	    CheckboxValue checkboxValue=null;
	    String checkedvalue="";
	    int i=0;
	    HttpSession session = request.getSession();
	    String appuserrole = (String)request.getSession().getAttribute("appuserrole");
        System.out.println("appuserrole "+appuserrole);
       
      
	   // List<CheckboxValue> list =new ArrayList<CheckboxValue>();
	    
	    //Set<CheckboxValue> list =new TreeSet<CheckboxValue>();
	    
	    Set<CheckboxValue> list =new LinkedHashSet<CheckboxValue>();
	
	    boolean fileSaved = false;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		String documentIds = "";
		// process only if its multipart content
		//System.out.println("Inside UploadFile servlet ");
		
		try
        {
        	javax.naming.Context ctx = new javax.naming.InitialContext();
        	webFolder = (String) ctx.lookup("java:comp/env/webfolder");
            fileUploadSize = (String) ctx
					.lookup("java:comp/env/fileUploadSize");
			
        } catch(Exception e)
        {
        	System.out.println("Exception retrieving config param webfolder -->"+e.getMessage());
        }
        
		System.out.println("******** documentIds -------->"+documentIds+"<-----");
		
		if (isMultipart) {	     
			
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			// checkedvalue="true";
			
			

			try {
				// Parse the request
				List<FileItem> multiparts = upload.parseRequest(request);
				for (FileItem item : multiparts) 
				{
					synchronized(this) {
									
					if (!item.isFormField()) {
					

						actualFileName = item.getName();
						System.out.println("Actual file name "+actualFileName);
						
						String origFileName = null;
						String outfilename = null;
						  String mode = "add";
						  
						  String outTextFileName = buildDestinationFileName(companyName, webFolder, "temptext.txt");

	                                    
	                    try {
	                    
	                        DocumentDataDAO documentDataDAO = new DocumentDataDAO();
	                        //docId = Long.toString(documentDataDAO.getMaxDocId()); 
	                        //synchronized (this) {
	                        	 docId = Long.toString(documentDataDAO.getMaxiDocId()); 
							//}
	                        if(!StringUtils.isEmpty(docId)) {
	                    System.out.println("========###########imaging######===========>>"+docId);
	                        System.out.println("list"+list + "" +actualFileName); 
	                        CheckboxValue checkValue=(CheckboxValue) list.toArray()[0];
	                        	if(!checkValue.getCheckboxValue().isEmpty() && checkValue.getCheckboxValue().equalsIgnoreCase("true")){
	                         	System.out.println("count"+ ++i);
	                    		 if(FileNameProcessor.fileType(actualFileName) == 4 || FileNameProcessor.fileType(actualFileName) == 5) {
	                    			/* docId = Long.toString(documentDataDAO.getMaxiDocId()); 
	         	                    System.out.println("========###########imaging######===========>>"+docId);*/
	                    			 
	                    			  origFileName =   buildDestinationFileName(companyName, webFolder, actualFileName);
	 	                        	fileName = docId + ".pdf";
	 	                       /*	rawFileName = buildTempDestinationFileName(docId
										+ "."
										+ FileNameProcessor.fileExtension(item.getName()));*/
	 	                        	
	 	                        	rawFileName =   buildDestinationFileName(companyName, webFolder, docId
											+ "."
											+ FileNameProcessor.fileExtension(item.getName()));
	 	                        	
	 	                   	System.out.println("Raw file name " + rawFileName);
							/*String convertedFileName = buildDestinationFileName(
									getConverterCommonUrl(), fileName);*/
							

								String convertedFileName = buildDestinationFileName(companyName, webFolder, fileName);
								
								System.out.println("****** convertedFileName -->"+convertedFileName+"<----");
							
	 	                   	
	 	                   //String convertedFileName = buildDestinationFileName(companyName, webFolder, fileName);
	 	                   	
							/*System.out.println("Convered file name "
									+ convertedFileName);*/

							outfilename = buildDestinationFileName(companyName,
									webFolder, fileName);
							System.out.println("outfilename " + outfilename);

							// save file to local file name on shared drive
							try{
                             	saveFile(item,origFileName, rawFileName);
								//saveFile(item, rawFileName);
                             	System.out.println("**** after save file ****");
                             }catch(Exception e){
                             	System.out.println("Exception in saving file-->"+e.getMessage());
                             } // save file into the
							// Convert the File from whatever to .pdf
							if(FileNameProcessor.fileType(actualFileName) == 5 ){
								// Convert the File from whatever to .pdf
								ToPDF toPDF = new ToPDF();
								toPDF.simpleImagesTiff(rawFileName, outfilename);

							}
							
							// Convert the File from whatever to .pdf
							else if(FileNameProcessor.fileType(actualFileName) == 4 ){
							ToPDF toPDF = new ToPDF();							
							toPDF.simpleImagesJpg(rawFileName, outfilename);
							}
							
								// delete the uploaded file and the conversion file
							logger.debug("Deleting old file ");
							File x = new File(rawFileName);
							x.delete();
							
							
							
							String file = actualFileName.substring(0, actualFileName.indexOf("."));
							actualFileName= file+ ".pdf";
							System.out.println("actualFileName "
									+ actualFileName);

	 	                        } 
	 	                                 
	 	                        else if(FileNameProcessor.fileType(actualFileName) == 3 || FileNameProcessor.fileType(actualFileName) == 2){
	 	                        	
	 	                        	System.out.println("Processing "
	 										+ FileNameProcessor.WORD_FILE);
		                    		//docId = Long.toString(documentDataDAO.getMaxiDocId()); 
	 	                        	
	 	                        
	 	                      		origFileName =   buildDestinationFileName(companyName, webFolder, actualFileName);
	 								
	 								fileName = docId + ".pdf";

	 							/*	rawFileName = buildCommonDirectory(docId
	 										+ "."
	 										+ FileNameProcessor.fileExtension(item.getName()));*/
	 								
	 								rawFileName = buildDestinationFileName(companyName, webFolder, docId
	 										+ "."
	 										+ FileNameProcessor.fileExtension(item.getName()));
	 								
	 								System.out.println("rawFileName  &&&& "+rawFileName);
	 										
	 								// rawFileName = docId + "." +
	 								// FileNameProcessor.fileExtension(pMF.getFilename());
	 								//String convertedFileName = buildCommonDirectory(fileName);

	 								String convertedFileName = buildDestinationFileName(companyName, webFolder, fileName);
	 								
	 								System.out.println("****** convertedFileName -->"+convertedFileName+"<----");
	 								// String convertedFileName = "/backup/" + fileName;

	 								outfilename = buildDestinationFileName(companyName,
	 										webFolder, fileName);

	 								// save file to local file name on shared drive
	 								System.out.println("Saving file ------> "
	 										+ rawFileName + " on shared drive" + outfilename);
	 								try {
	 								saveFile(item,origFileName,  rawFileName); // save file into the
	 								}catch(Exception e)
	 								{
	 									 response.setStatus(HttpServletResponse.SC_BAD_REQUEST);	 				           				
	 				           				System.out.println("File upload failed" );
	 				           				e.printStackTrace();
	 								}

	 								//try {
	 									javax.naming.Context ctx = new javax.naming.InitialContext();
	 									fileUploadSize = (String) ctx
	 											.lookup("java:comp/env/fileUploadSize");
	 									File inputFile = new File(rawFileName);
	 									System.out
	 											.println("Checking file size...........size="
	 													+ inputFile.length());

	 									if (inputFile.length() < Long
	 											.parseLong(fileUploadSize)) {
	 										final String rawFileName1=rawFileName;
	 										// new Thread(new Runnable() {
	 		                                  //   @Override
	 		                                    // public void run() {
	 		                                    	
	 								//	 try {
	 										converterData.convertFile(
													rawFileName1, convertedFileName,
														false, getConverterPort());
										//} catch (Exception e) {
											// TODO Auto-generated catch block
										//	e.printStackTrace();
										//}
	 		                                 // }
	 		                                   // }).start();
	 										
	 										
	 										
	 									}// end if check file size
	 									/*else {
	 										// file size too large
	 										// delete the uploaded file
	 										logger.info("Deleting old file "
	 												+ rawFileName);
	 										File x = new File(rawFileName);
	 										x.delete();

	 										logger.info("Too large file" + rawFileName);
	 										
	 										FileSize = "error_lagre_file_size";
	 										 response.setStatus(HttpServletResponse.SC_BAD_REQUEST);	 				           				
	 				           				System.out.println("File upload failed" );

	 									}*/

	 							//	} catch (Exception e) {
	 							//		e.printStackTrace();
	 							//		System.out.println("Exception retrieving config param fileUploadSize -->"
	 									//		+ e.getMessage());
	 							//	
	 							//	}
	 								
	 								 
	 								String file = actualFileName.substring(0, actualFileName.indexOf("."));
	 								actualFileName= file+ ".pdf";
	 								System.out.println("actualFileName "
	 										+ actualFileName);
	 	                        }
	        	        		
	        	        	}
	                        
	                    	else{                     
	                        
	                    		//docId = Long.toString(documentDataDAO.getMaxiDocId()); 
	    	                  //  System.out.println("========###########imaging######===========>>"+docId);
                       	 	//System.out.println("*** docid --->"+docId+"<--");
	                        if(FileNameProcessor.fileType(actualFileName) == 1) {
	                        	fileName = docId + ".pdf";
	                        } 
	                        else if(FileNameProcessor.fileType(actualFileName) == 4){
	                        	fileName = docId + ".jpeg";
	                        }
	                        else if(FileNameProcessor.fileType(actualFileName) == 2){
	                        	fileName = docId + ".xls";
	                        }
	                        
	                        else if(FileNameProcessor.fileType(actualFileName) == 5){
	                        	fileName = docId + ".tiff";
	                        }
	                        else if(FileNameProcessor.fileType(actualFileName) == 3){
	                        	fileName = docId + ".docx";
	                        }
	                        
                       	  outfilename = buildDestinationFileName(companyName, webFolder, fileName);
                          origFileName =   buildDestinationFileName(companyName, webFolder, actualFileName);
                          System.out.println("save file before"+docId);
                             	saveFile(item,origFileName, outfilename);
                             	System.out.println("**** after save file ****" + docId);
                            
                      
	                    	}   
                       	  
                        
                       	 String webFileName = companyName + "/" + webFolder + "/" + fileName;
                       	 System.out.println("docId%%%"+docId);
     	                //if(!StringUtils.isEmpty(docId) && !StringUtils.isEmpty(fileName)) {
                       	if(!StringUtils.isEmpty(fileName)) {
     	                	int docID = Integer.parseInt(docId);   
     	                	documentDataDAO.InsertTransactionMultipleDocData(actualFileName,doctype, docID, webFileName, cId, "0", docID, sessionid, indextype, indexval,propertytype,appuserrole,folderNameFView,transactiontype,transactionDate,transactionStatus);
     	                	 response.setStatus(HttpServletResponse.SC_OK);
     	                }     
     	                else {
     	                	System.out.println("*****************************Error"+docId);
     	                	 response.setStatus(HttpServletResponse.SC_NOT_FOUND);
     	                }
                       	  	
                       	  	
                       	  	
	                        }
                       	  	
                       } catch (Exception e) 
                       {                        
                           e.printStackTrace();
                           System.out.println("error in upbean store -->" + e.getMessage());
                           response.setStatus(HttpServletResponse.SC_NOT_FOUND);
           				
           				System.out.println("File upload failed" );
                       }
						
					}
					if (item.isFormField()) {
						checkboxValue=new CheckboxValue();
						String k = item.getFieldName();

		                String v = item.getString();
	           
						System.out.println("item : "+item.getFieldName()+ " val :"+item.getString());
							
						 	if (k.equalsIgnoreCase("sessionid")) 
		                    {
		                        sessionid = v;
		                    }//sribala
						 	if(k.equals("filecount")) {
						 		System.out.println("=======v=======>>>"+v);
						 		if(session.getAttribute("filecount")==null && v!=null && !"".equals(v)) {
						 			session.setAttribute("filecount",Integer.parseInt(v)-1);
						 		}
						 	}
						 	//sribala
		                    if (k.startsWith("fileName")) 
		                    {
		                        fileName = v;
		                        
		                  	}
		                    
		                    if (k.compareToIgnoreCase("fileName") == 0) 
		                    {
		                        fileName = v;
		                        System.out.println("fileName 123--->  "+fileName +" "+ k);
		                  	}

		                    if (k.compareToIgnoreCase("version") == 0) 
		                    {
		                        version = v;
		                    }
		                    if (k.startsWith("doctype")) 
		                    {
		                        doctype = v;
		                    	
		                    }
		                 
		                    if (k.equalsIgnoreCase("folderNameFView")) 
		                    {
		                    	folderNameFView = v;
		                    	//System.out.println("Folder Name ***************"+folderNameFView);

		                    }
		                    if (k.equalsIgnoreCase("propertytype")) 
		                    {
		                    	propertytype = v;
		                    		                    	
		                    }
		                    if (k.startsWith("hiddencheckbox")) {
								checkedvalue = v;
								
								checkboxValue.setCheckboxName(k);
								checkboxValue.setCheckboxValue(checkedvalue);
								list.add(checkboxValue);
							
								  System.out.println("checkedvalue in param--->  "+checkedvalue +" "+ k);
							}
		                    if (k.compareToIgnoreCase("folderval") == 0) 
		                    {
		                        folderval = v;
		                    }
		                   if (k.startsWith("indextype")) 
		                    {
		                    	indextype = v;
		                    	//indextypelist.add(Integer.parseInt(v));

		                    }
		                    if (k.startsWith("folderNameFViewData")) 
		                    {
		                    	folderNameFViewData = v;
		                    	//indextypelist.add(Integer.parseInt(v));

		                    }
		                   if (k.startsWith("indexval")) {
		                        indexval = v;
		                    	//indexvallist.add(v);
		                    
		                    }
		                    
		                    if (k.startsWith("fhanumber")) {
		                    	fhaNumber = v;
		                    	//indexvallist.add(v);
		                    
		                    }
		                    if (k.startsWith("transactiontype")) {
		                    	transactiontype = v;
		                    	//indexvallist.add(v);
		                    
		                    }
		                    if (k.startsWith("transactionDate")) {
		                    	transactionDate = v;
		                    	//indexvallist.add(v);
		                    
		                    }
		                    
		                    if (k.startsWith("transactionStatus")) {
		                    	transactionStatus = v;
		                    	//indexvallist.add(v);
		                    
		                    }
		                                        
		                    
		                    
		                    if ("cid".equalsIgnoreCase(k)) 
		                    {
		                        cId = v;
		                        
		                        CompanyDAO companyDao = new CompanyDAO();
		                        Vector companyList = new Vector();
		                        Company company = new Company();

		                        companyList = companyDao.findById(cId);
		                        company = (Company) companyList.get(0);
		                        companyName = company.getCompanyName();
		                    
		                    }	                    
					}
					
				}
					  
				}//For loop end
				
				// Add the record to the db
	            System.out.println("Adding doument to DB with docId --->"+docId);
	           
	            System.out.println("doctype --->"+doctype);
	            
	            System.out.println("transactiontype --->"+transactiontype + "transactionStatus"+transactionStatus);
	            
	            System.out.println("Folder Name ***************"+folderNameFView);
	            
	            System.out.println("folderNameFViewData Name ***************"+folderNameFViewData);
	            
	           /* if(!folderNameFViewData.isEmpty())
		          {
	           folderNameFViewDataName = new FolderBean().getFolderName(folderNameFViewData,cId);
	          
	          System.out.println("folderNameFViewDataName ***************"+folderNameFViewDataName);
		          }*/
	            
	            if(!folderNameFViewData.isEmpty())
				{

					folderNameFViewDataName = new FolderBean().getFolderName(folderNameFViewData, cId);

					if (folderNameFViewDataName.isEmpty()) {
						if (!folderNameFViewData.endsWith("/")) {
							folderNameFViewData = folderNameFViewData + "/";
						}
						new FolderBean().insertFolderName(folderNameFViewData, cId);
						folderNameFViewDataName = folderNameFViewData;

					}

					System.out.println("folderNameFViewDataName ***************" + folderNameFViewDataName);

				}
	            
	          if(!folderNameFViewDataName.isEmpty())
	          {
	        	  folderNameFView = folderNameFViewDataName;
	          }
	          
	            
	            if(!folderNameFView.isEmpty()){
	            	folderNameFView.replace("//", "/");
	            	String[] folderNameFViewArray= folderNameFView.split("[\\\\|/]");
	            	System.out.println("Folder Name ***************"+folderNameFViewArray[1]);
	           	        	PropertyDAO propertyDao = new PropertyDAO();
	           	        //	Vector<Property>  properties = propertyDao.findByPropertyId(folderNameFViewArray[1]);
	           	        //	propertytype=String.valueOf(properties.get(0).getId());
	           	     	System.out.println("propertytype ***************"+propertytype);
	           	     	
	           	     //indexval=folderNameFViewArray[2];
	           	     
	           		//System.out.println("indexval ***************"+indexval);
	            }
	            /********************sribala********************/
				 if(session.getAttribute("filecount")!=null){
			      	  int filecount=(Integer)session.getAttribute("filecount");
			      	 System.out.println(filecount+"==filecount=====0000000000==========");
			      	  if(filecount==0){
			      		session.removeAttribute("filecount");
			      		 if(propertytype!=null && !"".equals(propertytype) ) {
				        	   Vector<Property> propname= new Vector<Property>();
				        	   PropertyDAO propertyDao = new PropertyDAO();
				        	   propname=propertyDao.findById(propertytype);
							 try {
						            System.out.println("====in Upload files before proc ui==try===="+propname.get(0).getPropertyId());				
								new FolderDAO().callProcFolderStructure("/"+propname.get(0).getPropertyId()+"/",cId);
							} catch (PenielException e) {
								e.printStackTrace();
							}
				           }
			       		  System.out.println(filecount+"==filecount=====0000000000==========");
			      	  }else{
			      		session.setAttribute("filecount",filecount-1);
			      	  System.out.println(filecount-1+"==filecount=====0000000000==========");
			      	  }
			        }
					/********************sribala********************/
				
			}catch (Exception e) 
			{
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				e.printStackTrace();
				System.out.println("File upload failed" );
			}
	}
		
	System.out.println("documentIds OUT -->"+documentIds+"<--");	

}
	
	
	public void associateFolders(String docId, String cId, String propertyId, String doctype, String indexval){
		
		getDropD getDD = new getDropD();
		String propertyValue = getDD.getProperty(propertyId);
        
        DocumentTypeDAO docTypeDao = new DocumentTypeDAO();
		
		Vector hashMapList = docTypeDao.findByIds(doctype, cId);
		String folderIds = "";
		String folderName = "";
		for (int y = 0; y < hashMapList.size(); y++) {
            HashMap hashMap = new HashMap();
            hashMap = (HashMap) hashMapList.get(y);
   
            String subFolderId = (String) hashMap.get("SUB_FOLDER_ID");
            String subFolderName1 = (String) hashMap.get("SUB_FOLDER_NAME_1");
            String subFolderName2 = (String) hashMap.get("SUB_FOLDER_NAME_2");
        
			folderName = propertyValue + "/" + indexval + "/"+ subFolderName1 + "/"+ subFolderName2 ;
	        System.out.println("Folder Name ---------------------> " + folderName);
			
			folderName = "/" + folderName + "/";
			//System.out.println("Folder Id before ---------------------> " + folderId);
			
			int folderId = 0;
			try {
				
				FolderDAO folderDao = new FolderDAO();
				Vector folderVector = folderDao.findByFolderNames(folderName);
				
				if (folderVector.size() <= 0) {
					// Insert folder
					folderId = folderDao.addFolder(cId, folderName);
					System.out.println("EXISTING Folder Id  ---> " + folderId+"<--- folderName -->"+folderName+"<----");
					
				} else {
					//Folder folder = (Folder) folderVector.get(0);
					//folderId = Integer.parseInt(folder.getFolderId() + "");
					 HashMap hashMap1 = new HashMap();
			         hashMap1 = (HashMap) folderVector.get(0);
			   
			         folderId = (Integer) hashMap1.get("FOLDER_ID");
			         System.out.println("EXISTING Folder Id  ---> " + folderId+"<--- folderName -->"+folderName+"<----");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PenielException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Folder Id after ---------------------> " + folderId);
			
			String sqlStatement = "insert into document_folders (document_id, company_id, folder_id ) values ('"+ docId +"', '" + cId + "','"+folderId+"') ";
    		logger.info("DocumentDataDAO Insert query : " + sqlStatement);
            
    		
    		DatabaseConnection dbConn = new DatabaseConnection();
    		try {
				dbConn.executeUpdate(sqlStatement);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println("folderIds-->" + folderIds);
			
		}	

		
	}
	
	
	
	
	public void saveFile(FileItem item, String origFileName, String outfilename) throws IOException {
        //FileOutputStream OutFile = new FileOutputStream(outfilename);
      
        try {
        	  File savedFile = new File(origFileName);
			item.write(savedFile);
			
			savedFile.renameTo(new File(outfilename));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in save file-->"+e.getMessage());
		}
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

    public String buildDestinationFileName(String webFolder, String infile) {
        String retval =  getDestinationBaseDirectory() + File.separator + webFolder + File.separator + infile;
        logger.debug("Destination directory without company name " + retval);
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
    
    public String buildTempDestinationFileName(String infile) {
		String retval = getTempDirectory() + File.separator + infile;
		System.out.println("Temp Directory " + retval);
		return retval;
	}
    public String getConverterCommonUrl() {
		try {
			return getFromEnv("converterCommonUrl");
		} catch (NamingException e) {
			return null;
		}
	}

	public Integer getConverterPort() {
		try {
			String hostPort = getFromEnv("converterUrl");
			String port = hostPort.substring(hostPort.lastIndexOf(":") + 1);
			try {
				return Integer.parseInt(port);
			} catch (NumberFormatException e) {
				logger.error("Error in Convert Port/Host");
			}
		} catch (NamingException e) {
			return null;
		}
		return null;
	}
	public String getTempDirectory() {
		try {
			return getFromEnv("converterTempDirectory");
		} catch (NamingException e) {
			return null;
		}
	}
	public String buildCommonDirectory(String infile) {
		String retval = getConverterCommonUrl() + File.separator + infile;
		// String retval = getConverterCommonUrl() + infile;
		System.out.println("Common Directory " + retval);
		logger.debug("Common Directory " + retval);
		return retval;
	}
}