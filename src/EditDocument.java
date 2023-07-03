

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.AuditTrailSessionLog;
import com.peniel.bus.vo.DocumentData;
import com.peniel.bus.vo.DocumentType;
import com.peniel.bus.vo.Property;
import com.peniel.bus.vo.SearchData;
import com.peniel.bus.vo.SessionLog;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.dao.DocumentFoldersDAO;
import com.peniel.dao.DocumentTypeDAO;
import com.peniel.dao.PropertyDAO;
import com.peniel.dao.SearchDataDAO;
import com.peniel.dao.SessionLogDAO;

/**
 * Servlet implementation class for Servlet: DisplayPdf
 *
 */
 public class EditDocument extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(EditDocument.class);
   
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public EditDocument() {
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
		// TODO Auto-generated method stub
		System.out.println("naveen");
		String comid = request.getParameter("comid");
		String sessionid = request.getParameter("sessionid");
		String documentType1 = request.getParameter("documentType");
		String propertyName1 = request.getParameter("propertyName");
		//String docId = request.getParameter("docId");		
		String status = request.getParameter("status");				
		String formAction = request.getParameter("formAction");
		String fileName = request.getParameter("id");
		
		
		
		
		Vector searchDataList = new Vector();
		SearchData searchData = null;
		Vector propertyList = new Vector();
		Property property = null;
        SessionLogDAO sessionLogDAO = new SessionLogDAO();


        Vector fileList = new Vector();

		//Get docId from fileName		
		DocumentDataDAO docDataDAO = new DocumentDataDAO();
		fileList = docDataDAO.findByFilename(fileName);
		
		DocumentData documentData = new DocumentData();
		String docId = "";	
		int ver = 0;		

		if(fileList.size() > 0)
		{
			documentData = (DocumentData)fileList.get(0);
			docId = ""+documentData.getDocumentId();
			ver = (int) documentData.getVersion();
            if (ver < 0) {
                status = "Inactive";
            }
            else
            {
            	status = "Active";
            }
           
		}
		
		try{
//			SearchDataDAO searchDataDAO = new SearchDataDAO();
//			  	String sqlStmt = "SELECT A.COMPANY_ID COMPANY_ID, A.DOCUMENT_ID DOCUMENT_ID, A.INDEX_DATA INDEX_DATA, A.INDEX_TYPE_ID INDEX_TYPE_ID, B.INDEX_TYPE INDEX_TYPE " +
//			  			"FROM SEARCH_DATA A, INDEX_TYPE B WHERE " +
//			  			"A.DOCUMENT_ID='"+docId+"' AND A.COMPANY_ID = "+comid+" AND A.INDEX_TYPE_ID = B.INDEX_TYPE_ID AND A.COMPANY_ID = B.COMPANY_ID";
//			  
//			  	searchDataList = searchDataDAO.findByQuery(sqlStmt, "docProfile");
//			  				  	
//			  	Vector vector = new Vector();
//			  	for(int i=0; i< searchDataList.size(); i++){
//			  		searchData = (SearchData)searchDataList.get(i);
//			  		
//			  		String values = searchData.getIndexData();
//			  		vector.add(i, values);
//			  	}
//			  					  	
//			  	request.setAttribute("indexTypeIdVal", vector);
//			  	
//			  	
			 // Document Detail Information.
			  	DocumentDataDAO documentDataDAO = new DocumentDataDAO();
			  	logger.info("=========docId========>>>"+docId+"----comid---"+comid+"----status----"+status);

			  	DocumentData docData = documentDataDAO.findDocDetail(docId, comid, status);
			  	logger.info("=========docdata========>>>"+docData);
				Long version = 0L;
				version = docData.getVersion();
				
				String propertyId = docData.getPropertyId();
				String docTypeId = ""+docData.getDocumentTypeId();				
			//	String folderId = docData.getFolderId();
			//	String folderName = "";
				
				/*
				FolderDAO folderDao = new FolderDAO();
				Vector folderV = folderDao.findByProperty("Folder_id",folderId);
				if(folderV.size() > 0)
				{
					folderName  =((Folder) folderV.get(0)).getFolderName();
					System.out.println("folderName in  Document.java "+folderName);	
				}
				*/
				
			//	DocumentFoldersDAO docFoldersDao = new DocumentFoldersDAO();
			//	folderName = docFoldersDao.getFolderNames(docId);
				
				
				DocumentTypeDAO docTypeDao = new DocumentTypeDAO();
				Vector documentType = docTypeDao.findByDocumentTypeId(docTypeId);
				String docType = "";
				//Get Document Type
				if(documentType.size() > 0)
				{
					docType +=((DocumentType) documentType.get(0)).getDocumentType();
				}
				
				String createAndUpdateDates = "";
				createAndUpdateDates = docData.getCreateDate();
				String updateDate ="";
				String createDate ="";
				if(null!=createAndUpdateDates) {
				updateDate = createAndUpdateDates.substring(0, createAndUpdateDates.indexOf("^"));
				 createDate = createAndUpdateDates.substring(createAndUpdateDates.indexOf("^")+1, createAndUpdateDates.length());
				}
				request.setAttribute("docType", documentType1);

				if(propertyName1 != null)
				{
					request.setAttribute("propertyId",propertyName1);				  	

					request.setAttribute("propertyIdHtml", "<span href=\"\" id=\"trigger\" ><label class=\"infoLbl\">"+propertyName1+"</label></span>");	
					
					//Property Information
					PropertyDAO propertyDao = new  PropertyDAO();
					propertyList = propertyDao.findByPropertyId(propertyName1);
			  		System.out.println("EditDocument property len = "+propertyList.size());

				  	for(int i=0; i< propertyList.size(); i++){
				  		property = (Property)propertyList.get(i);
				  		request.setAttribute("property",property);		  		
				  	}
				  		

				}else{
					request.setAttribute("propertyId","NA");				  	

					request.setAttribute("propertyIdHtml", "<label class=\"infoLbl\">NA</label>");
				}
				
				request.setAttribute("docId", docId);
				request.setAttribute("status", status);
				request.setAttribute("docTypeId", docTypeId);
				request.setAttribute("folderName","");			
				request.setAttribute("versionNum", version);
				request.setAttribute("createDate", createDate);
				request.setAttribute("updateDate", updateDate);
				
				
				// Audit Trail
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
				
				
				request.setAttribute("htmlTableAuditTrail", htmlTableAuditTrail);
				
				Vector sessionLogList = new Vector();		        
				sessionLog = sessionLogDAO.getSessionLog(docId, comid);
				sessionLogList =  sessionLogDAO.getAllSessionLog(docId, comid);
				request.setAttribute("sessionLogList",sessionLogList);	
				
				//RequestDispatcher rd = request.getRequestDispatcher("/editDocument.jsp?formAction="+formAction);
				RequestDispatcher rd = request.getRequestDispatcher("/editDoc.jsp?formAction="+formAction);

				rd.forward(request, response);
			  
		  } catch ( Exception e) {
				e.printStackTrace();
		  }
		  
	}   	  	    
}