import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.CheckUsername;
import com.peniel.beans.Login;
import com.peniel.beans.SessionLog;

import com.peniel.beans.UsersGrid;




public class GetSupervisorGridLinks extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	
	   private static Logger logger = LogManager.getLogger(GetUsernameValidation.class);

	/**
	 * Constructor of the object.
	 */
	public GetSupervisorGridLinks() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


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
		String html = "";
		try 
		{
			System.out.println("Inside getSupervisorGridLinks Servelet ");
	        html = UsersGrid.getUserGridLinks();
			(response.getWriter()).write(html);
			
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		
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
