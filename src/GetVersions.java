import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.DocumentData;
import com.peniel.dao.SearchDataDAO;


public class GetVersions extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static Logger logger = LogManager.getLogger(GetFiles.class);
	public GetVersions() {
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

		doPost(request,response);
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

		String docid = (String)request.getParameter("docid");
		String sessionid = (String)request.getParameter("sessionid");
		System.out.println("In get Versions docid = "+docid);
		Vector fileList = new Vector();
		SessionBean s = new SessionBean();
		int sid = s.checkSession(sessionid);
		logger.debug("In Get Versions : Return value from checkSession "+sid);
		if ( sid <= -1) { 
			request.getSession().setAttribute("expired", "expired");
			(response.getWriter()).write("expired");
			logger.debug("In Get Versions : Session Expired ");
		} else {
		logger.debug("In Get Versions : Getting Versions ");
		com.peniel.dao.DocumentDataDAO docDataDAO = new com.peniel.dao.DocumentDataDAO();
		fileList = docDataDAO.findByProperty1("document_id", docid);
		}
		Iterator itr = fileList.iterator();
		HashMap hashMap = new HashMap();
		DocumentData documentData = new DocumentData();
		String output = "";
		for (int i=0;i<fileList.size();i++){
			documentData = (DocumentData)fileList.get(i);
			output += documentData.getFilename()+"^";
		}
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
