import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.IndexTypeBean;
import com.peniel.bus.vo.IndexType;
import com.peniel.bus.vo.SearchData;
import com.peniel.dao.IndexTypeDAO;
import com.peniel.dao.SearchDataDAO;


public class DeleteIndexType extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static Logger logger = LogManager.getLogger(DeleteIndexType.class);
	public DeleteIndexType() {
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

		System.out.println("In delete index type.java servlet ");
		
		String success = "";
		
		String cId = (String)request.getParameter("cId");
		String indexType = (String)request.getParameter("indexType");
		
		// delete record from db		
		IndexTypeDAO indexTypeDAO = new IndexTypeDAO();
		Vector<IndexType> indexTypeVector = indexTypeDAO.findByIndexType(indexType);
		if(indexTypeVector.get(0) != null)
		{
			
		long indexTypeId = indexTypeVector.get(0).getIndexTypeId();
		/* Check if index type has associated documents */
		SearchDataDAO searchDataDAO = new SearchDataDAO();
		Vector<SearchData> searchDataVector = searchDataDAO.findByIndexId("INDEX_TYPE_ID",Long.toString(indexTypeId),cId);
		System.out.println("searchDataVector "+searchDataVector.size());
		if(searchDataVector.size() > 0) //Index Type has documents associated with it; can not be deleted
		{
			System.out.println("Index Type has "+searchDataVector.size()+ " docs ");
			success = "no";
		}
		else
		{
			try
			{												
				if(indexTypeDAO.DeleteIndexType(cId, indexType))
				{
					IndexTypeBean indexTypeBean = new IndexTypeBean();  
					String htmlGrid = indexTypeBean.getIndexTypeGridHTML(cId);  

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
		logger.info("success after delete in DeleteIndexType -->"+success);
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
