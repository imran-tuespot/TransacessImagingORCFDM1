
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.io.File;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.getDropD;
import com.peniel.bus.vo.Company;
import com.peniel.bus.vo.Folder;
import com.peniel.bus.vo.Property;
import com.peniel.common.PenielException;
import com.peniel.dao.CompanyDAO;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.dao.DocumentTypeDAO;
import com.peniel.dao.FolderDAO;
import com.peniel.dao.PropertyDAO;
import com.peniel.utilities.FileNameProcessor;
import com.peniel.utilities.PDFToText;
import com.peniel.utilities.ParseMultiForm;
import com.peniel.utilities.ToPDF;
import com.penielsolutions.converter.Converter;
import com.penielsolutions.converter.ConverterService;
import com.penielsolutions.converter.ConverterServiceLocator;

public class AddDocument extends HttpServlet {
	
	final PDFToText pdfToText = new PDFToText();

	private static Logger logger = LogManager.getLogger(AddDocument.class);

	public AddDocument() {
		super();
	}

	public void destroy() {
		super.destroy();
		pdfToText.waitStop();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("In addDocument doPost ");
		response.setContentType("text/html;charset=UTF-8");
		String fileName = "";
		String checkedvalue="";
		String doctype = "";
		String folderName = "";
		String folderval = "";
		String propertytype = "";

		String indextype = "";
		String indexval = "";
		String success = "";
		String successAfterInsert = "";
		String docId = "";
		String version = "";
		String cId = "";
		String sessionid = "";
		String confirmParam = "";
		String actualFileName = "";
		String strResponse = "";
		String companyName = "";
		String fileUploadSize = "";
		String FileSize = "";
		int paramCount = 0;
		ParseMultiForm pMF = new ParseMultiForm(request);
		System.out.println("Request " + request.getContextPath());
		StringBuffer g = new StringBuffer(strResponse);
		String param;
		String filePath = "";
		String webFolder = "";
		 String appuserrole = (String)request.getSession().getAttribute("appuserrole");
		  System.out.println("appuserrole "+appuserrole);
		try {
			javax.naming.Context ctx = new javax.naming.InitialContext();
			webFolder = (String) ctx.lookup("java:comp/env/webfolder");
			filePath = companyName + "/" + webFolder + "/" + fileName;
			System.out.println("*** filePath in AddDocument -->" + filePath
					+ "<--");

		} catch (Exception e) {
			logger.debug("Exception retrieving config param webfolder -->"
					+ e.getMessage());
		}
		
		while ((param = pMF.getNextParameter(g)) != null) {
			System.out.println("param count " + paramCount++);
			if ("file".equals(param)) {

				System.out.println("A file param detected");
				String infile = pMF.getFilename();
				String rawFileName;

				if (infile != null) {
					String outfilename = null;
					String mode = "add";
				
					String outTextFileName = buildDestinationFileName(
							companyName, webFolder, "temptext.txt");

					try {
						System.out.println("Company Name ---> " + companyName);
						DocumentDataDAO documentDataDAO = new DocumentDataDAO();
						
						// process the infile file name for .pdf or other.
						// This has 3 paths -
						// 1) pdf file - normal processing.
						// 2) not recognized - should not have gotten here so
						// error out.
						// 3) convertable file - save file under new name to the
						// common dir. convert the file. then copy back
						// to the proper position and continue pdf processing as
						// normal.
						System.out.println("checkedvalue ---> " + checkedvalue);
						if(!checkedvalue.isEmpty() && checkedvalue.equalsIgnoreCase("true")){
						switch (FileNameProcessor.fileType(pMF.getFilename())) {
						case FileNameProcessor.JPG_FILE: {
							docId = Long.toString(documentDataDAO.getNextId());
							fileName = docId + ".pdf";

							rawFileName = buildTempDestinationFileName(docId
									+ "."
									+ FileNameProcessor.fileExtension(pMF
											.getFilename()));
							System.out.println("Raw file name " + rawFileName);
							String convertedFileName = buildDestinationFileName(
									getConverterCommonUrl(), fileName);
							System.out.println("Convered file name "
									+ convertedFileName);

							outfilename = buildDestinationFileName(companyName,
									webFolder, fileName);
							System.out.println("outfilename " + outfilename);

							// save file to local file name on shared drive
							saveFile(pMF, rawFileName); // save file into the

							// Convert the File from whatever to .pdf
							ToPDF toPDF = new ToPDF();
							toPDF.simpleImagesJpg(rawFileName, outfilename);

							// delete the uploaded file and the conversion file
							logger.debug("Deleting old file ");
							File x = new File(rawFileName);
							x.delete();

							// Perform OCR on the pdf. Insert txt to database
							// for searching.
							String newOutfilename = buildDestinationFileName(
									companyName, webFolder, "ocr_" + fileName);
							

							if (!pdfToText.isPDFSearchable(outfilename)) {
								// PDF is not Searchable
								pdfToText.pdfToSearchablePdf(outfilename,
										newOutfilename,docId,outTextFileName, mode);
							}
							else
							{
								pdfToText.parsePdf(docId, outfilename,
										outTextFileName, mode);
							}
							String file = actualFileName.substring(0, actualFileName.indexOf("."));
							actualFileName= file+ ".pdf";
							System.out.println("actualFileName "
									+ actualFileName);

						}
							break;
						case FileNameProcessor.TIFF_FILE: {
							docId = Long.toString(documentDataDAO.getNextId());
							fileName = docId + ".pdf";

							rawFileName = buildTempDestinationFileName(docId
									+ "."
									+ FileNameProcessor.fileExtension(pMF
											.getFilename()));
							// String convertedFileName =
							// buildDestinationFileName(getConverterCommonUrl(),
							// fileName);
							outfilename = buildDestinationFileName(companyName,
									webFolder, fileName);

							// save file to local file name on shared drive
							saveFile(pMF, rawFileName); // save file into the

							// Convert the File from whatever to .pdf
							ToPDF toPDF = new ToPDF();
							toPDF.simpleImagesTiff(rawFileName, outfilename);

							// delete the uploaded file and the conversion file
							logger.debug("Deleting old file ");
							File x = new File(rawFileName);
							x.delete();

							// Perform OCR on the pdf. Insert txt to database
							// for searching.
							String newOutfilename = buildDestinationFileName(
									companyName, webFolder, "ocr_" + fileName);
							
							if (!pdfToText.isPDFSearchable(outfilename)) {
								// PDF is not Searchable
								pdfToText.pdfToSearchablePdf(outfilename,
										newOutfilename,docId,outTextFileName, mode);
							}
							else
							{
								pdfToText.parsePdf(docId, outfilename,
										outTextFileName, mode);
	
							}
							String file = actualFileName.substring(0, actualFileName.indexOf("."));
							actualFileName= file+ ".pdf";
							System.out.println("actualFileName "
									+ actualFileName);

						}
							break;
						case FileNameProcessor.EXCEL_FILE:
						case FileNameProcessor.WORD_FILE: {
							System.out.println("Processing "
									+ FileNameProcessor.WORD_FILE);

							docId = Long.toString(documentDataDAO.getNextId());
							fileName = docId + ".pdf";

							rawFileName = buildCommonDirectory(docId
									+ "."
									+ FileNameProcessor.fileExtension(pMF
											.getFilename()));

							// rawFileName = docId + "." +
							// FileNameProcessor.fileExtension(pMF.getFilename());
							String convertedFileName = buildCommonDirectory(fileName);

							// String convertedFileName = "/backup/" + fileName;

							outfilename = buildDestinationFileName(companyName,
									webFolder, fileName);

							// save file to local file name on shared drive
							System.out.println("Saving file ------> "
									+ rawFileName + " on shared drive");
							saveFile(pMF, rawFileName); // save file into the

							try {
								javax.naming.Context ctx = new javax.naming.InitialContext();
								fileUploadSize = (String) ctx
										.lookup("java:comp/env/fileUploadSize");
								File inputFile = new File(rawFileName);
								System.out
										.println("Checking file size...........size="
												+ inputFile.length());

								if (inputFile.length() < Long
										.parseLong(fileUploadSize)) {
									// Convert the File from word/Excel to .pdf
									System.out.println("Converting file "
											+ rawFileName + " to file "
											+ convertedFileName);
									// ConvertUtil convertUtil = new
									// ConvertUtil();
									// ConvertUtil.convertFile(rawFileName,
									// convertedFileName, false,
									// getConverterHost(), getConverterPort());

									/***********************************************************************************/

									ConverterService service = new ConverterServiceLocator();
									System.out
											.println("Calling web service....."
													+ service.getServiceName());
									Converter converter = service
											.getConverter();
									System.out.println("Converting file....");
									String results = converter.convertFile(
											rawFileName, convertedFileName,
											false, getConverterPort());
									System.out
											.println("Result from web service --->"
													+ results);
									if (results.equalsIgnoreCase("true")) // if
																			// conversion
																			// is
																			// successful
									{
										/**********************************************************************************/

										System.out.println("Copying file...................");
										File convertedFile = new File(
												convertedFileName);
										File destinationFile = new File(
												outfilename);
										System.out.println("Copying file --->"
												+ convertedFile);
										System.out.println("convertedFile --->"
												+ convertedFile);
										System.out
												.println("destination file --->"
														+ destinationFile);

										for (int i = 0; i < 3; i++) {
											boolean convertedFileExists = convertedFile
													.exists();

											System.out
													.println("Checking if converted file exists.....");
											if (convertedFileExists) {

												System.out.println("File "
														+ convertedFileName
														+ " exists---->"+destinationFile+"<----");
												// copy file from shared folder
												// to actual distination
												///FileUtils.copyFile(
													//	convertedFile,
														//destinationFile);
												
												//System.out.println();

												// delete the uploaded file and
												// the conversion file
												System.out.println("Deleting old file "
														+ rawFileName);
												File x = new File(rawFileName);
												x.delete();
												
												System.out.println("Not remove -->"
														+ convertedFileName);
												//x = new File(convertedFileName);
												///x.delete();
												break;

											}// End if
											else {
												System.out
														.println("Sleeping......:");
												try {
													Thread.sleep(4000);

												} catch (InterruptedException ie) {
													System.out.println(ie
															.getMessage());
												}
											}
										}// end For

										// Perform OCR on the pdf. Insert txt to
										// database for searching.
										String newOutfilename = buildDestinationFileName(
												companyName, webFolder, "ocr_"
														+ fileName);
										

										if (!pdfToText
												.isPDFSearchable(outfilename)) {
											// PDF is not Searchable
											pdfToText
													.pdfToSearchablePdf(
															outfilename,
															newOutfilename,docId,outTextFileName, mode);
										}
										else
										{
											pdfToText.parsePdf(docId, outfilename,
													outTextFileName, mode);
										}

									}// end if check results from web service
									else {
										System.out
												.println("Error in converting file "
														+ rawFileName);
										success = "error";
									}

								}// end if check file size
								else {
									// file size too large
									// delete the uploaded file
									logger.info("Deleting old file "
											+ rawFileName);
									File x = new File(rawFileName);
									x.delete();

									logger.info("Too large file" + rawFileName);
									success = "error";
									FileSize = "error_lagre_file_size";

								}

							} catch (Exception e) {
								System.out.println("Exception retrieving config param fileUploadSize -->"
										+ e.getMessage());
								success = "error";
							}
							String file = actualFileName.substring(0, actualFileName.indexOf("."));
							actualFileName= file+ ".pdf";
							System.out.println("actualFileName "
									+ actualFileName);
						}
							break;
						/*case FileNameProcessor.PDF_FILE:
							docId = Long.toString(documentDataDAO.getNextId());
							System.out
									.println("*** docid --->" + docId + "<--");

							fileName = docId + ".pdf";

							outfilename = buildDestinationFileName(companyName,
									webFolder, fileName);

							try {
								saveFile(pMF, outfilename);
								System.out.println("**** after save file ****");
							} catch (Exception e) {
								System.out
										.println("Exception in saving file-->"
												+ e.getMessage());
							}

							// Perform OCR on the pdf. Insert txt to database
							// for searching.
							String newOutfilename =
							 buildDestinationFileName(companyName, webFolder,
							 "ocr_"+fileName);

							//String newOutfilename = buildDestinationFileNameOCR(
								//	companyName, webFolder, fileName);
							


							break;*/
						default:
							throw new Exception("Upload file type is invalid");
						}
						}else
						{
							docId = Long.toString(documentDataDAO.getNextId());
							System.out
									.println("*** docid --->" + docId + "<--");
							
							System.out
							.println("*** FileTYpe --->" + pMF.getFilename() + "<--");
							
							String extension=pMF.getFilename().substring(pMF.getFilename().lastIndexOf(".") + 1);
                             
							fileName = docId+"."+extension.toLowerCase();

							outfilename = buildDestinationFileName(companyName,
									webFolder, fileName);

							try {
								saveFile(pMF, outfilename);
								System.out.println("**** after save file ****");
							} catch (Exception e) {
								e.printStackTrace();
								System.out
										.println("Exception in saving file-->"
												+ e.getMessage());
							}
							// Perform OCR on the pdf. Insert txt to database
							// for searching.
							String newOutfilename =
							 buildDestinationFileName(companyName, webFolder,
							 "ocr_"+fileName);
							if(extension.equalsIgnoreCase("pdf"))
									{
								

								if (!pdfToText.isPDFSearchable(outfilename)) {
									// PDF is not Searchable
									pdfToText.pdfToSearchablePdf(outfilename,
											newOutfilename,docId,outTextFileName, mode);
																		
								} 
								else
								{
								pdfToText.parsePdf(docId, outfilename,
										outTextFileName, mode);
								}			
								
									}	

						
						}
						if (!success.equalsIgnoreCase("error")) {
							strResponse = strResponse + " +++Uploading "
									+ fileName;
							strResponse = strResponse + " +++Uploaded to "
									+ outfilename;

							success = "yes";
						}
					} catch (Exception e) {
						success = "error";
						e.printStackTrace();
						System.out.println("error in upbean store -->"
								+ e.getMessage());
					}
				}

			} else {
				String k = param;

				String v = "";
				System.out.println("k = " + k + " v= " + v);
				if (k.equalsIgnoreCase("message")) {
					v = pMF.getMessage();
				} else {
					v = pMF.getParameter();

					if (k.equalsIgnoreCase("sessionid")) {
						sessionid = v;
					}
					if (k.compareToIgnoreCase("fileName") == 0) {
						fileName = v;
					}

					if (k.compareToIgnoreCase("version") == 0) {
						version = v;
					}
					if (k.compareToIgnoreCase("checkbox2") == 0) {
						checkedvalue = v;
					}
					if (k.compareToIgnoreCase("doctype") == 0) {
						doctype = v;
					}
					if (k.compareToIgnoreCase("propertytype") == 0) {
						propertytype = v;
					}
					if (k.compareToIgnoreCase("folderNameFView") == 0) {
						folderName = v;
					}
					if (k.compareToIgnoreCase("folderval") == 0) {
						folderval = v;
					}
					if (k.compareToIgnoreCase("indextype") == 0) {
						indextype = v;
					}

					if (k.compareToIgnoreCase("value") == 0) {
						indexval = v;
					}

					if ("cid".equals(k)) {
						cId = v;

						CompanyDAO companyDao = new CompanyDAO();
						Vector companyList = new Vector();
						Company company = new Company();

						companyList = companyDao.findById(cId);
						company = (Company) companyList.get(0);
						companyName = company.getCompanyName();
					}
					if ("confirmParam".equals(param)) {
						confirmParam = v;
					}
					if ("actualFileName".equals(param)) {
						actualFileName = v;
					}

					if ("docId".equals(param)) {
						docId = v;
					}

				}

				System.out.println("key = " + k + " value = " + v);
			}
		}

		String displayPath = "";
		try {
			javax.naming.Context ctx = new javax.naming.InitialContext();
			webFolder = (String) ctx.lookup("java:comp/env/webfolder");
			displayPath = companyName + "/" + webFolder + "/" + fileName;
			System.out.println("*** filePath in AddDocument -->" + displayPath
					+ "<--");

		} catch (Exception e) {
			logger.debug("Exception retrieving config param webfolder -->"
					+ e.getMessage());
		}

		getDropD getDD = new getDropD();
		String propertyValue = getDD.getProperty(propertytype);

		// folderName = propertyValue+"/"+indexval+"/Application";
		// System.out.println("folderName--->"+folderName+"<---");
		
		if(folderName.isEmpty() && !folderval.isEmpty())
		{
		
			if(!folderval.startsWith("/"))
			 folderName = "/"+folderval.replaceAll("</br>", "");
			else
				 folderName = folderval.replaceAll("</br>", "");
		}
		
		 System.out.println("folderName"+folderName);
		 if(!folderName.isEmpty()/* && indexval.isEmpty()*/)
		 {
		
			 String[] filename=folderName.split("[\\\\|/]");
			 
			 System.out.println("filename[0]"+filename[1]);
			 
	        	PropertyDAO propertyDao = new PropertyDAO();
   	        //	Vector<Property>  properties = propertyDao.findByPropertyId(filename[1]);
   	        //	propertytype=String.valueOf(properties.get(0).getId());
   	     	 
   	     //	propertytype=filename[1];
   	     System.out.println("propertytype ***************"+propertytype);
			 folderval=folderName;
			// indexval=filename[2];
			 
			 
		//	 doctype="550";
			 
		//	 indextype="1";
		 }

		request.setAttribute("sessionid", sessionid);
		request.setAttribute("fileName", fileName);
		request.setAttribute("docId", docId);
		request.setAttribute("version", version);
		request.setAttribute("doctype", doctype);
		request.setAttribute("folderval", folderval);
		
		request.setAttribute("folderval", folderval);

		request.setAttribute("propertytype", propertytype);

		request.setAttribute("actualFileName", actualFileName);

		request.setAttribute("indextype", indextype);

		request.setAttribute("indexval", indexval);

		request.setAttribute("filePath", displayPath);

		System.out.println("companyName=" + companyName + "***" + "cid=" + cId
				+ "***" + "fileName=" + fileName + "***" + "docId=" + docId
				+ "***" + "version=" + version + "***" + "doctype=" + doctype
				+ "***" + "indextype=" + indextype + "*** indexval=" + indexval
				+ "*** propertytype= " + propertytype);

		DocumentTypeDAO docTypeDao = new DocumentTypeDAO();
		//DocumentType docTypeObj = docTypeDao.findByIds(doctype, cId);
		
		//String subFolderName = docTypeDao.findByIds(doctype, cId);
		
		Vector hashMapList = docTypeDao.findByIds(doctype, cId);
		String folderIds = "";
		String folderNames = "";
		if(!hashMapList.isEmpty()){
		for (int y = 0; y < hashMapList.size(); y++) {
            HashMap hashMap = new HashMap();
            hashMap = (HashMap) hashMapList.get(y);
   
            String subFolderId = (String) hashMap.get("SUB_FOLDER_ID");
            String subFolderName1 = (String) hashMap.get("SUB_FOLDER_NAME_1");
            String subFolderName2 = (String) hashMap.get("SUB_FOLDER_NAME_2");
        
		
		
            //System.out.println("subFolderName---------------------> " + subFolderName);

            if(folderName.isEmpty() || appuserrole.toLowerCase().contains("production")){
			folderName = propertyValue + "/" + indexval + "/"+ subFolderName1 + "/"+ subFolderName2 ;
	        folderNames += folderName +"</br>";
             System.out.println("Folder---------------------> " + folderNames);
			
            
			
			folderName = "/" + folderName + "/";
			
            }
            else {
            	

    			if(!folderName.startsWith("/"))
    			 folderName = "/"+folderName.replaceAll("</br>", "");
    			else
    				folderName = folderName.replaceAll("</br>", "");
    			if(!folderName.endsWith("/"))
    			{
    				folderName =folderName.replaceAll("</br>", "") + "/";		
    			}
            	
            	
            	 folderNames =  folderName +"</br>";
            } 
			
			int folderId = 0;
			try {
				FolderDAO folderDao = new FolderDAO();
				Vector folderVector = folderDao.findByFolderName(folderName);
				
				if (folderVector.size() <= 0) {
					// Insert folder
					folderId = folderDao.addFolder(cId, folderName);	
				} else {
					Folder folder = (Folder) folderVector.get(0);
					folderId = Integer.parseInt(folder.getFolderId() + "");
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PenielException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			folderIds += folderId + "/";
			
			System.out.println("folderIds-->" + folderIds+ "<-- folderNames -->"+folderNames);
			
		}	
		}
		else
		{
			if(!folderName.startsWith("/"))
   			 folderName = "/"+folderName.replaceAll("</br>", "");
   			else
   				folderName = folderName.replaceAll("</br>", "");
			if(!folderName.endsWith("/"))
			{
				folderName =folderName.replaceAll("</br>", "") + "/";		
			}
           	
           	
           	 folderNames =  folderName +"</br>";
			int folderId = 0;
			try {
				FolderDAO folderDao = new FolderDAO();
				Vector folderVector = folderDao.findByFolderName(folderName);
				
				if (folderVector.size() <= 0) {
					// Insert folder
					folderId = folderDao.addFolder(cId, folderName);
					
				} else {
					Folder folder = (Folder) folderVector.get(0);
					folderId = Integer.parseInt(folder.getFolderId() + "");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PenielException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			folderIds += folderId + "/";
			
			System.out.println("folderIds-->" + folderIds+ "<-- folderNames -->"+folderNames);
				
			
		}
		request.setAttribute("folderName", folderNames);
	
			if ("Yes".equalsIgnoreCase(confirmParam)
						|| "Yes1".equalsIgnoreCase(confirmParam)) {
					// success = "yes";
					successAfterInsert = "yes";
		
					// Folder Name added automatically.
					// FolderName = PropertyId/FHANumber/Subfolder
					// (Application||Construction...)
		
					//int folderId = 0;
		
					//folderName = "/" + folderName + "/";
					System.out.println("Folder---------------------> " + folderName);
					if (folderName != null && folderName != "" && !folderName.isEmpty()) {
						
						//FolderDAO folderDao = new FolderDAO();
						//Vector folderVector = folderDao.findByFolderName(folderName);
		
						try {
		/*
							if (folderVector.size() <= 0) {
								// Insert folder
								folderId = folderDao.addFolder(cId, folderName);
							} else {
								Folder folder = (Folder) folderVector.get(0);
								folderId = Integer.parseInt(folder.getFolderId() + "");
							}
		
							System.out.println("folderId-->" + folderId);
		*/
							DocumentDataDAO docDataDAO = new DocumentDataDAO();
		
							int docID = Integer.parseInt(docId);
							System.out.println("docID = " + docID);
							String webFileName = companyName + "/" + webFolder + "/"
									+ fileName;
							System.out.println("**********   doctype  = " + doctype
									+ "folderval " + folderval + " **** docID = "
									+ docID + " **** webFileName = " + "\n"
									+ webFileName + " ****** cId = " + cId
									+ " *** sessionid = " + sessionid);
		
							docDataDAO.InsertDocData(folderIds, actualFileName, doctype,
									docID, webFileName, cId, "0", docID, sessionid,
									indextype, indexval, propertytype);
		
						} catch (Exception e) {
							successAfterInsert = "no";
							e.printStackTrace();
							logger.info("Error :" + e.getMessage());
						}
		
						//System.out.println("folderId " + folderId);
		
					}
		
					System.out.println("Folder---------------------> " + folderName);
		
					logger.info("success after insert -->" + successAfterInsert);
		

					if ("Yes".equalsIgnoreCase(confirmParam)) {
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/addDocConfirm.jsp?id="
										+ fileName + "&success=" + success
										+ "&successAfterInsert=" + successAfterInsert
										+ "&docId=" + docId + "&version=" + version);
						dispatcher.forward(request, response);
					} else if ("Yes1".equalsIgnoreCase(confirmParam)) {
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/addDoc.jsp?id=" + fileName
										+ "&success=" + success
										+ "&successAfterInsert=" + successAfterInsert
										+ "&docId=" + docId + "&version=" + version);
						dispatcher.forward(request, response);
					}
				} else {
					request.setAttribute("flipTab", 2);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/addDoc2.jsp?id=" + fileName
									+ "&success=" + success + "&docId=" + docId
									+ "&version=" + version + "&FileSize=" + FileSize);
					dispatcher.forward(request, response);
				}
					//}
	}

	public void saveFile(ParseMultiForm pMF, String outfilename)
			throws IOException {
		FileOutputStream OutFile = new FileOutputStream(outfilename);

		// Copies the file from
		pMF.getParameter(OutFile);
		OutFile.flush();
		OutFile.close();
	}

	public String buildDestinationFileName(String companyName,
			String webFolder, String infile) {
		String retval = getDestinationBaseDirectory() + File.separator
				+ companyName + File.separator + webFolder + File.separator
				+ infile;
		logger.debug("Destination with company name Directory " + retval);
		return retval;
	}

	public String buildDestinationFileNameOCR(String companyName,
			String webFolder, String infile) {
		String retval = getDestinationBaseDirectoryOCR() + File.separator
				+ companyName + File.separator + webFolder + File.separator
				+ infile;
		logger.debug("Destination with company name Directory " + retval);
		return retval;
	}

	public String buildDestinationFileName(String webFolder, String infile) {
		String retval = getDestinationBaseDirectory() + File.separator
				+ webFolder + File.separator + infile;
		logger.debug("Destination directory without company name " + retval);
		return retval;
	}

	public String buildTempDestinationFileName(String infile) {
		String retval = getTempDirectory() + File.separator + infile;
		logger.debug("Temp Directory " + retval);
		return retval;
	}

	public String buildCommonDirectory(String infile) {
		String retval = getConverterCommonUrl() + File.separator + infile;
		// String retval = getConverterCommonUrl() + infile;
		System.out.println("Common Directory " + retval);
		logger.debug("Common Directory " + retval);
		return retval;
	}

	public String getDestinationBaseDirectory() {
		try {
			return getFromEnv("repository");
		} catch (NamingException e) {
			return null;
		}
	}

	public String getDestinationBaseDirectoryOCR() {
		try {
			return getFromEnv("repositoryOCR");
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

	public String getConverterHost() {
		try {
			String hostPort = getFromEnv("converterUrl");
			return hostPort.substring(0, hostPort.lastIndexOf(":"));
		} catch (NamingException e) {
			return null;
		}
	}

	public String getConverterCommonUrl() {
		try {
			return getFromEnv("converterCommonUrl");
		} catch (NamingException e) {
			return null;
		}
	}

	public String getTempDirectory() {
		try {
			return getFromEnv("converterTempDirectory");
		} catch (NamingException e) {
			return null;
		}
	}

	public String getFromEnv(String val) throws NamingException {
		javax.naming.Context ctx = new javax.naming.InitialContext();
		return (String) ctx.lookup("java:comp/env/" + val);
	}

	public void init() throws ServletException {

	}

}
