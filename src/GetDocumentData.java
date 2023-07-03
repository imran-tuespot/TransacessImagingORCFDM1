import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peniel.bus.vo.DocumentData;
import com.peniel.bus.vo.DocumentType;
import com.peniel.bus.vo.Folder;
import com.peniel.bus.vo.IndexType;
import com.peniel.bus.vo.Property;
import com.peniel.bus.vo.SearchData;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.dao.DocumentTypeDAO;
import com.peniel.dao.FolderDAO;
import com.peniel.dao.IndexTypeDAO;
import com.peniel.dao.PropertyDAO;
import com.peniel.dao.SearchDataDAO;


public class GetDocumentData extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetDocumentData() {
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

		String fileName = request.getParameter("id");
		System.out.println("Inside GetDocumentData id="+fileName);
		Vector fileList = new Vector();

		//Get documentType, indexType, indexValue from fileName
		
		DocumentDataDAO docDataDAO = new DocumentDataDAO();
		fileList = docDataDAO.findByFilename(fileName);
		
		DocumentData documentData = new DocumentData();
		String output = fileName+"^";
		String docId = "";
		long indexId = 0;
		String folderId ="";
		String folderName = "";
		String docTypeId = "";
		String status = "Active";
		long version = 0;
		String propertyId = "";

		int cId = (Integer)request.getSession().getAttribute("comid");
		if(fileList.size() > 0)
		{
			documentData = (DocumentData)fileList.get(0);
			DocumentTypeDAO docTypeDao = new DocumentTypeDAO();
			docTypeId = ""+documentData.getDocumentTypeId();
			Vector documentType = docTypeDao.findByDocumentTypeId(docTypeId);
			
			//Get Document Type
			if(documentType.size() > 0)
			{
				output +=((DocumentType) documentType.get(0)).getDocumentType();
				docId =""+ documentData.getDocumentId();
				System.out.println("Document Type "+output + " docId "+docId);				
						
			}
			folderId = documentData.getFolderId();
			version = documentData.getVersion();
			propertyId = documentData.getPropertyId();
			PropertyDAO propertyDao = new PropertyDAO();
			System.out.println("propertyId ==  "+propertyId);

			Vector propertyV = propertyDao.findByProperty("ID", propertyId);
			System.out.println("propertyV size "+propertyV.size());
			if(propertyV.size() > 0)
			{
				propertyId  =((Property) propertyV.get(0)).getPropertyId();
				System.out.println("propertyId ---> "+propertyId);				
						
			}
			
			System.out.println("folderId "+folderId);
			
			//Get Folder name from folderId
			FolderDAO folderDao = new FolderDAO();
			Vector folderV = folderDao.findByProperty("Folder_id",folderId);
			if(folderV.size() > 0)
			{
				folderName  +=((Folder) folderV.get(0)).getFolderName();
				System.out.println("folderName "+folderName);				
						
			}

			
		}
		
		//Get indexType and indexData from documentId
		SearchDataDAO searchDataDAO = new SearchDataDAO();
		SearchData searchData = new SearchData();
		Vector fileList1 = searchDataDAO.findByProperty("DOCUMENT_ID",docId);
		if(fileList1.size() > 0)
		{
			System.out.println("filelist1 "+fileList1.size());
			searchData = (SearchData)fileList1.get(0);
			IndexTypeDAO indexTypeDao = new IndexTypeDAO();
			System.out.println("searchData.getIndexTypeId() "+searchData.getIndexTypeId());
			indexId = searchData.getIndexTypeId();
			IndexType indexType = indexTypeDao.findById(indexId);
			
				output +="^"+ indexType.getIndexType();
				System.out.println("Index Type "+output);
				output +="^"+ searchData.getIndexData();
						
			
		}
		output +="^"+ folderName+ "^"+status+"^"+docTypeId + "^"+version+"^"+indexId+"^"+docId+"^"+propertyId;
		
	     // getpdf1(Id,docType,indexType,indexVal,folderVal,status,docTypeId,version,indexId,docId);

		System.out.println("output = "+output);
		(response.getWriter()).write(output);
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
