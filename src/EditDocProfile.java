

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import com.peniel.beans.AuditTrailSessionLog;
import com.peniel.beans.Mail;
import com.peniel.bus.vo.DocumentData;
import com.peniel.bus.vo.Folder;
import com.peniel.bus.vo.IndexType;
import com.peniel.bus.vo.Property;
import com.peniel.bus.vo.SearchData;
import com.peniel.bus.vo.SessionLog;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.dao.FolderDAO;
import com.peniel.dao.IndexTypeDAO;
import com.peniel.dao.PropertyDAO;
import com.peniel.dao.SearchDataDAO;
import com.peniel.dao.SessionLogDAO;

/**
 * Servlet implementation class for Servlet: DisplayPdf
 *
 */
 public class EditDocProfile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(EditDocProfile.class);
   
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public EditDocProfile() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  logger.info("In edit doc profile servlet ");
		  
		  String comid = request.getParameter("comid");
		  String exceptions = "";
		  String sessionid = request.getParameter("sessionid");
		  
		  String docId = request.getParameter("docId");
		  String doctype = request.getParameter("doctype");
		  String transactionType = request.getParameter("transactionType");
					String transactionDate = request.getParameter("transactionDate");
			String transactionStatus = request.getParameter("transactionStatus");
			 System.out.println("transactionStatus-->"+transactionStatus+"6535354 "+transactionType);
		  
		  System.out.println("doctype-->"+doctype);
		  Vector searchDataList = new Vector();
		  SearchData searchData = null;
		  
		  Vector indexTypeList = new Vector();
		  IndexType indexTypeData = null;
		  
		  // Index type used when enabled on the screen.
		  String indextype1 = request.getParameter("indextype1");
		  
		  
		// Index vals used when enabled on the screen.
		  String indexval1 = request.getParameter("indexval1");
		  
		// Index type used when disabled on the screen.
		  String indextype1Dis = request.getParameter("indextype1Dis");
		  
		// Index vals used when disabled on the screen.
		  String indexval1Dis = request.getParameter("indexval1Dis");
		  
		  
		  String rowid1 = request.getParameter("rowid1");
		  
		  
		  String status = request.getParameter("status");
		  String docStatus = request.getParameter("docStatus");
		  
		  String propertytype = request.getParameter("propertytype");
		  System.out.println("propertytype = "+propertytype);
		  String propertyId = "";
		  PropertyDAO propertyDao = new PropertyDAO();
		  Vector<Property> prop = propertyDao.findById(propertytype);
		  if(prop.size() > 0)
			  propertyId = prop.get(0).getPropertyId();		  
		  
		  request.setAttribute("propertyId",propertyId);
		  System.out.println("propertyId editDocProfile.java"+propertyId);
		  
		  
		  //String folderId = request.getParameter("folderId");
		  String folderName = "";
		  Vector<Folder> folder=new Vector<Folder>();
		  String[] folderId = request.getParameterValues("folderId");

		  FolderDAO folderDao = new FolderDAO();
		  if(folderId!=null && folderId.length>0){
		  for(int i=0;i<folderId.length;i++){
		  folder=folderDao.findByFolderId(folderId[i]);
		
		 
	
		 
		 /* if(folder.size() > 0)
			  folderName = folder.get(0).getFolderName();*/
		  for(Folder folders:folder)
		  {
			  folderName= folders.getFolderName(); 
		  request.setAttribute("folderName",folderName);
		  System.out.println("folderName in editDocProfile.java"+folderName);

		  }
		  }
		  }
		  
		  
		  String formAction = "";
		  formAction = request.getParameter("formAction");
		  
		  logger.info("*** status -->"+status+"<--");	
		  logger.info("*** docStatus -->"+docStatus+"<--");
		  logger.info("*** formAction -->"+formAction+"<--");

		  
		  if("save".equals(formAction)){
			  Vector vector = new Vector();
			  int i =0;
			  
			  try{
				  
				  if("Active".equals(status)){
					  if(!"".equals(indexval1) && indexval1 != null){
						  String indIdVal = indextype1+"^"+indexval1+"^"+rowid1; 
						  logger.info("indIdVal-->"+indIdVal+"<--");
						  vector.add(i, indIdVal);
						  i++;
					  }
					 
					  SearchDataDAO searchDataDao = new SearchDataDAO();
					  
					  String transactionTypeId=searchDataDao.getTransactionType(transactionType);
					  System.out.println("transactionTypeId"+transactionTypeId);
					 
					  searchDataDao.editDocProfile(vector, docId, comid, sessionid, doctype, propertytype, folderId,transactionTypeId,transactionDate,transactionStatus);
					  /* This functionality has been removed temporarily **********************
					  //Document metadata has been changed
					  try
						{								
							//Send email to all Admins
							String subjectForAdminMail = "A document metada has been changed.";
							StringBuffer messageForAdminMail = new StringBuffer();
							
							messageForAdminMail.append("Greetings, <br />")
							 	.append("A document metadata has been changed. Please take the time to sign in to the application.")
							 	.append("<br /><br />");
							 	
							Mail.sendEmailToAdmins(Long.parseLong(request.getParameter("comid")),"ADMIN", subjectForAdminMail, messageForAdminMail.toString(), "Registration");
							
						}
						catch(Exception e)
						{
							e.printStackTrace();
							logger.info("Error :"+e.getMessage());
							
						}
						************************************************************************/
				  }
				  
				  //Maintain Doc Status (Active & Inactive)
				  //Check if the admin changed the status from the previous one.
				  //Process only when the status got changed, otherwise ignore.
				  if(!status.equals(docStatus)){
					  if("Active".equals(docStatus)){ 
						  // Document is changed to "Active"
						  // Multiply all versions by (-1) AND change version (999) to version (0)
						  
						  int newVersion = -1;
						  DocumentDataDAO docDataDAO = new DocumentDataDAO();
						  docDataDAO.activateDocVersion(docId, sessionid, newVersion);
						  
						  //get the correct document type
						  doctype = request.getParameter("docTypeId");
						  
						// assign disabled indextype and vals.
						  indextype1 = indextype1Dis;
						  
						  // assign disabled indextype and vals.
						  indexval1 = indexval1Dis;
						  
					  }
					  else {
						  // Document status is changed to "Inactive"
						  // Multiply all versions by (-1) And add (-999) to version (0)
						  
						  int newVersion = -1;
						  DocumentDataDAO docDataDAO = new DocumentDataDAO();
						  docDataDAO.inactivateDocVersion(docId, sessionid, newVersion);
						  
						  /* This functionality has been removed temporarily **********************
						  // Document status is changed to "Inactive"
						  try
							{								
								//Send email to all Admins
								String subjectForAdminMail = "A document has been made inactive.";
								StringBuffer messageForAdminMail = new StringBuffer();
								
								messageForAdminMail.append("Greetings, <br />")
								 	.append("A document has been made inactive. Please take the time to sign in to the application.")
								 	.append("<br /><br />");
								 	
								Mail.sendEmailToAdmins(Long.parseLong(request.getParameter("companyId")),"ADMIN", subjectForAdminMail, messageForAdminMail.toString(), "Registration");
								
							}
							catch(Exception e)
							{
								e.printStackTrace();
								logger.info("Error :"+e.getMessage());								
							}
							************************************************************************/
					  }
					  
					  
				  }
				  
				  GetDropDown dropDown = new GetDropDown();
				  String dcTyp = dropDown.getDocType(doctype, comid);
				  
				  //RequestDispatcher rd = request.getRequestDispatcher("./EditDocument?status="+docStatus+"&docTypeId="+doctype+"&dcTyp="+dcTyp+"&formAction=save");
				  //rd.forward(request, response);
			      
				  vector.removeAllElements();
				  i = 0;
				  IndexTypeDAO indexTypeDao = new IndexTypeDAO();
				  
				  if(!"".equals(indexval1) && indexval1 != null){
					  
					  indexTypeData = null;
					  indexTypeData = indexTypeDao.findByIdCompany(indextype1, comid);
				  	//  logger.info("*** 1 ***");
				  	  
				  	  String indexType = "";
				  	  indexType = indexTypeData.getIndexType();
				  	  //logger.info("*** indexType 1 ***"+indexType+"<--");
				  	  
				  	  
					  vector.add(i, indexType+"^"+indexval1);
					  //logger.info("*** 1.1 ***");
					  i++;
				  }
				  
				  				  					  	
				  request.setAttribute("indexTypeIdVal", vector);
				  
				  
				  getDocDetails(request, docId, comid, docStatus);
				  	
				  getAuditTrail(request, docId, comid);
				// logger.info("Status -->"+docStatus+"<--");
				  String[] folderIds = request.getParameterValues("folderId");
				  String foldernamesdata = "";
			          if(folderIds!=null && folderIds.length>0){
					  for(int x=0;x<folderIds.length;x++){
					  folder=folderDao.findByFolderId(folderIds[x]);
							
					 
					
					  for(Folder folders:folder)
					  { 
						
						  foldernamesdata= foldernamesdata+"\n"+folders.getFolderName(); 
					  
					 
					  }
					  }
				  }
			      request.getSession().removeAttribute("transactionStatus");
			  	  request.getSession().setAttribute("transactionStatus",transactionStatus);
			      RequestDispatcher rd = request.getRequestDispatcher("/editDocument.jsp?status="+docStatus+"&docTypeId="+doctype+"&dcTyp="+dcTyp+"&formAction=save&folderName="+foldernamesdata+"&transactionType="+transactionType+"&transactionDate="+transactionDate+"&transactionStatus="+transactionStatus);
         		  rd.forward(request, response);

			  }
			  catch (Exception e) {
					logger.info("Error occured while editing document profile. -->"+e.getMessage());
					exceptions = "Error occured while editing document profile. Please contact system coordinator.";
					request.setAttribute("exceptions", exceptions);
					formAction = "";
			  }
			  
		  }
		  
		  if("".equals(formAction) || formAction == null){
			  try{
				  	
				  //logger.info("formAction-->"+formAction+"<--");
				  //String sqlStmt = "SELECT * FROM SEARCH_DATA WHERE DOCUMENT_ID='"+docId+"'";
				   
				    String sqlStmt = "SELECT INDEX_TYPE_ID, DOCUMENT_ID, INDEX_DATA, COMPANY_ID, (@row_number:=@row_number + 1) AS ROWID FROM SEARCH_DATA,(SELECT @row_number:=0) AS t WHERE DOCUMENT_ID='"+docId+"'";
				    logger.info("sqlStmt  -->"+sqlStmt);
				  	SearchDataDAO searchDataDao = new SearchDataDAO();
				  	searchDataList = searchDataDao.findByQuery(sqlStmt, "docProfile");
				  	
				  	Vector vector = new Vector();
				  	for(int i=0; i< searchDataList.size(); i++){
				  		
				  		searchData = (SearchData)searchDataList.get(i);
				  		
				  		String indexData = searchData.getIndexData();
				  		indexData = indexData.substring(indexData.lastIndexOf("^")+1, indexData.length());
				  		
				  		String rowId = searchData.getRowid();
				  		
				  		String values = searchData.getIndexTypeId() +"^"+ indexData +"^"+ rowId;
				  		
				  		vector.add(i, values);
				  	}
				  					  	
				  	request.setAttribute("indexTypeIdVal", vector);
				  	
				  	getDocDetails(request, docId, comid, status);
				  	
				  	getAuditTrail(request, docId, comid);
				  					  	
				  	RequestDispatcher rd = request.getRequestDispatcher("/editDocProfile.jsp");
					rd.forward(request, response);
				  
			  } catch ( Exception e) {
					e.printStackTrace();
			  }
		  }	
		  
		  
	}
	
	public void getDocDetails(HttpServletRequest request, String docId, String comid, String status){
		
		// Document Detail Information.
	  	
	  	DocumentDataDAO docDataDAO = new DocumentDataDAO();
		DocumentData docData = docDataDAO.findDocDetail(docId, comid, status);
	  	
		Long version = 0L;
		version = docData.getVersion();
		
		String createAndUpdateDates = "";
		createAndUpdateDates = docData.getCreateDate();
		
		String createDate = createAndUpdateDates.substring(createAndUpdateDates.indexOf("^")+1, createAndUpdateDates.length());
		String updateDate = createAndUpdateDates.substring(0, createAndUpdateDates.indexOf("^"));
	  	
		request.setAttribute("versionNum", version);
		request.setAttribute("createDate", createDate);
		request.setAttribute("updateDate", updateDate);
	  	
	}
	
	public void getAuditTrail(HttpServletRequest request, String docId, String comid){
		// Audit Trail
        SessionLogDAO sessionLogDAO = new SessionLogDAO();
        Vector sessionLogList = new Vector();        
		SessionLog sessionLog = sessionLogDAO.getSessionLog(docId, comid);
		request.setAttribute("auditTrailDate", (String)sessionLog.getDtm());
		request.setAttribute("firstName", (String)sessionLog.getFirstName());
		request.setAttribute("lastName", (String)sessionLog.getLastName());
		request.setAttribute("fieldModified", (String)sessionLog.getFieldName());
		request.setAttribute("oldValue",(String)sessionLog.getOldValue());
		request.setAttribute("newValue",(String) sessionLog.getNewValue());
		
		//get audit trail table to show on the page
		AuditTrailSessionLog auditTrailSessionLog = new AuditTrailSessionLog();
		String htmlTableAuditTrail = auditTrailSessionLog.getAuditTrailSessionLog(comid, docId);
		
		sessionLogList =  sessionLogDAO.getAllSessionLog(docId, comid);
		request.setAttribute("sessionLogList",sessionLogList);	
		
		
		request.setAttribute("htmlTableAuditTrail", htmlTableAuditTrail);
		request.setAttribute("exceptions", "noError");

		
	}
}