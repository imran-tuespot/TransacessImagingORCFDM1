import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.DocTypeBean;
import com.peniel.beans.IndexTypeBean;
import com.peniel.bus.vo.DocumentData;
import com.peniel.bus.vo.DocumentType;
import com.peniel.bus.vo.IndexType;
import com.peniel.bus.vo.SearchData;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.dao.DocumentTypeDAO;
import com.peniel.dao.IndexTypeDAO;
import com.peniel.dao.SearchDataDAO;


public class DeleteDocumentType extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static Logger logger = LogManager.getLogger(DeleteDocumentType.class);
	public DeleteDocumentType() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("In delete document type.java servlet ");
		
		String success = "";
		
		String cId = (String)request.getParameter("cId");
		String documentType = (String)request.getParameter("documentType");
		
		// delete record from db		
		DocumentTypeDAO documentTypeDAO = new DocumentTypeDAO();
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
			success = "no";
		}
		else
		{
			try
			{												
				if(documentTypeDAO.DeleteDocumentType(cId, documentType))
				{
					DocTypeBean documentTypeBean = new DocTypeBean();  
					String htmlGrid = documentTypeBean.getDocumentTypeGridHTML(cId);  

					success = htmlGrid;
				}
				else
					success = "no";
				
			}
			catch(Exception e){
				success = "no";
			}
		}
		}
		logger.info("success after delete in DeleteDocumentType -->"+success);
		(response.getWriter()).write(success);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
