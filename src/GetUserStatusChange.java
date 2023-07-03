


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.PasswordReset;
import com.peniel.beans.ProcessRegistration;
import com.peniel.beans.UserInformation;
import com.peniel.bus.vo.AppUser;

import com.peniel.dao.AppUserDAO;


/**
 * Servlet implementation class for Servlet: GetFiles
 *
 */
 public class GetUserStatusChange extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   
	 private static Logger logger = LogManager.getLogger(ProcessRegistration.class);
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GetUserStatusChange() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		//take the user's username, toggle the status field
		UserInformation userInformation = new UserInformation();
		String status = userInformation.getUserStatusChange(request.getParameter("username"), request.getParameter("sessionId"));
		
		(response.getWriter()).write(status);
		
	}  
	

	

}