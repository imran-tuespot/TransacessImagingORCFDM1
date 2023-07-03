
import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.dao.AppUserDAO;
import com.peniel.dao.AppUserRolesDAO;
import com.peniel.dao.CompanyDAO;


/**
 * Servlet implementation class for Servlet: GetFiles
 *
 */
 public class CompanyProfile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(MyProfile.class);
   
   private String userName = "";

      
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CompanyProfile() {
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
		
		CompanyDAO companyDao = new CompanyDAO();
		System.out.println("request.getParameter "+request.getParameter("indextype"));
			
		String verification = companyDao.updateCompanyById(request.getParameter("comid"),
				(String)request.getParameter("address1"), (String)request.getParameter("address2"), (String)request.getParameter("city"), 
				(String)request.getParameter("state"), (String)request.getParameter("zip"),(String)request.getParameter("indextype"));
		
		
		try{
			
			request.setAttribute("sessionid", request.getParameter("sessionid"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("companyProfile.jsp?sessionid="+(String)request.getParameter("sessionid")+"&successMsg="+verification);
			dispatcher.forward(request, response);
		} catch(Exception e){
			System.out.println("Exception -->"+e.getMessage());
		
		}
	}   	
	
}
