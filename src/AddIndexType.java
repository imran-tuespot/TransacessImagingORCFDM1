import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.peniel.beans.IndexTypeBean;
import com.peniel.dao.IndexTypeDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddIndexType extends HttpServlet {

	
	private static Logger logger = LogManager.getLogger(AddDocument.class);
	public AddIndexType() {
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

		logger.info("In add index type file ");
			
		String success = "";
		
		String cId = (String)request.getParameter("cId");
		String indexType = (String)request.getParameter("indexType");
		
		// Add the record to the db		
		IndexTypeDAO indexTypeDAO = new IndexTypeDAO();
		
		try
		{												
			indexTypeDAO.InsertIndexType(cId, indexType);
			IndexTypeBean indexTypeBean = new IndexTypeBean();  
			String htmlGrid = indexTypeBean.getIndexTypeGridHTML(cId);  

			success = htmlGrid;
			
		}
		catch(Exception e){
			success = "no";
		}
		logger.info("success after insert in index type -->"+success);
		(response.getWriter()).write(success);
		
	}

	
	public void init() throws ServletException {
		
	}

}
