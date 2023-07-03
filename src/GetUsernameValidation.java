import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.CheckUsername;
import com.peniel.beans.Login;
import com.peniel.beans.SessionLog;
import com.peniel.bus.vo.AppUser;
import com.peniel.dao.AppUserDAO;




public class GetUsernameValidation extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
  
   
   private static Logger logger = LogManager.getLogger(GetUsernameValidation.class);
   
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GetUsernameValidation() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		doPost(request, response);
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//check to see if the username is in the database already
		
		if(request.getParameter("userstatuscheck") != null)
		{
			String strStatus = "";
			
			try
			{
				String username = "";
				if(request.getParameter("username") != null)
					username = (String)request.getParameter("username").toUpperCase();

				
				
				Vector appUserList = new Vector();
				AppUserDAO appUserDao = new AppUserDAO();
				AppUser appUser =  new AppUser();
				appUserList = appUserDao.findByUserame(username.toUpperCase());
				appUser = (AppUser) appUserList.get(0);
				
				
				if(appUser != null)	
					strStatus = appUser.getStatus();
				
				System.out.println(strStatus);
				
				
			}
			catch(Exception e)
			{
				//there is no such username like the one typed in by the user
				strStatus = "none";
				
			}
			finally
			{
				(response.getWriter()).write(strStatus);
			}
			
			
		}
		else
		{
			

			CheckUsername checkUsername = new CheckUsername();
			String validateUsername = checkUsername.checkUsername(request.getParameter("companyId"), request.getParameter("username"));
			(response.getWriter()).write(validateUsername);
		}
		
	}   
	
	
}
