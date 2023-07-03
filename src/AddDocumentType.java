import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.peniel.beans.DocTypeBean;
import com.peniel.beans.IndexTypeBean;
import com.peniel.bus.vo.DocumentData;
import com.peniel.bus.vo.DocumentType;
import com.peniel.common.PenielException;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.dao.DocumentTypeDAO;
import com.peniel.dao.IndexTypeDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddDocumentType extends HttpServlet {

	
	private static Logger logger = LogManager.getLogger(AddDocumentType.class);
	public AddDocumentType() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("In add document type file ");
			
		String success = "";
		
		String cId = (String)request.getParameter("cId");
		String documentType = (String)request.getParameter("documentType");
		String mode = (String)request.getParameter("mode");
		String doctypemaster =request.getParameter("doctypemaster");	
		String selectedfolder = request.getParameter("selectfolder");
	int newFolderFlag=Integer.parseInt(request.getParameter("newFolderFlag"));
	int folderId=Integer.parseInt(request.getParameter("folderId"));
		// Add the record to the db		
		DocumentTypeDAO documentTypeDAO = new DocumentTypeDAO();
		if(mode.equalsIgnoreCase("add"))
		{	
			try
			{												
				//documentTypeDAO.insertNewDocType(cId, documentType);
				documentTypeDAO.insertNewDocTypeAndDocMaster(cId, documentType,doctypemaster,selectedfolder,newFolderFlag,folderId);
				DocTypeBean docTypeBean = new DocTypeBean();  
				String htmlGrid = docTypeBean.getDocumentTypeGridHTML(cId);  

				success = htmlGrid+"^add";
				
			}
			catch(Exception e){
				success = "no^add";
			}
		}else if(mode.equalsIgnoreCase("delete"))
		{
			// delete record from db		
			Vector<DocumentType> documentTypeVector = documentTypeDAO.findByDocumentType(documentType);
			if(documentTypeVector.get(0) != null)
			{
				
			long documentTypeId = documentTypeVector.get(0).getDocumentTypeId();
			/* Check if document type has associated documents */
			DocumentDataDAO documentDataDAO = new DocumentDataDAO();
			Vector<DocumentData> searchDataVector = documentDataDAO.findByDocTypeId("DOCUMENT_TYPE_ID",Long.toString(documentTypeId),cId);
			System.out.println("searchDataVector "+searchDataVector.size());
			
			if(searchDataVector.size() > 0) //Document Type has documents associated with it; can not be deleted
			{
				System.out.println("Document Type has "+searchDataVector.size()+ " docs ");
				success = "no^delete";
			}
			else
			{
				try
				{												
					if(documentTypeDAO.DeleteDocumentType(cId, documentType))
					{
						DocTypeBean documentTypeBean = new DocTypeBean();  
						String htmlGrid = documentTypeBean.getDocumentTypeGridHTML(cId);  

						success = htmlGrid+"^delete";
					}
					else
						success = "no^delete";
					
				}
				catch(Exception e){
					success = "no^delete";
				}
			}
			}
		}
		else if(mode.equalsIgnoreCase("edit"))
		{
			String oldDocType = request.getParameter("oldDocType");
			try
			{										
				
				if(documentTypeDAO.editDocumentType(cId, documentType, oldDocType))
				{
					DocTypeBean documentTypeBean = new DocTypeBean();  
					String htmlGrid = documentTypeBean.getDocumentTypeGridHTML(cId); 
					success = htmlGrid+"^edit";
				}
				else
				{
					success = "no^edit";
				}
				
			}
			catch(Exception e){
				
				System.out.println("Error message "+e.getMessage());
				success = "no^edit";
			}

			
		}
		//logger.info("success after insert in document type -->"+success);
		(response.getWriter()).write(success);
		
	}

	
	public void init() throws ServletException {
		
	}

}
