
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.Mail;
import com.peniel.manager.ProcessRegistrationManager;

/**
 * Servlet implementation class for Servlet: GetFiles
 *
 */
 public class ProcessRegistration extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(ProcessRegistration.class);
   
   private String userName = "";

      
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ProcessRegistration() {
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
		
		//Insert new record into database
		//Let pass over all the values to insert into the database
		//Get the company name first and combine with username for complete username
		
		ProcessRegistrationManager processRegistrationManager = new ProcessRegistrationManager();
		
		String username = processRegistrationManager.getCompanyNameById(request.getParameter("companyId")) + "/" + request.getParameter("username");
		
		//Get new userId to insert into table
		long userId = processRegistrationManager.getNewUserId();

		String acceptMails = (String)request.getParameter("acceptMails");
		
		if (acceptMails != null) 
		{
			acceptMails = "Y";
		} else
		{ 
			acceptMails = "N";
		}
		String verification = processRegistrationManager.insertNewUser(userId, "1", username.toUpperCase(), request.getParameter("companyId"), (String)request.getParameter("first_name"), 
				(String)request.getParameter("last_name"), (String)request.getParameter("address1"), (String)request.getParameter("address2"), (String)request.getParameter("city"), 
				(String)request.getParameter("state"), (String)request.getParameter("zip"), (String)request.getParameter("email"), (String)request.getParameter("phone_no"),
				(String)request.getParameter("cellPhone"), (String)request.getParameter("secondEmail"), (String)request.getParameter("jobTitle"),acceptMails);
		
		logger.info("===========request.getParameter(\"userRoles\")=============>>>>"+request.getParameter("userRoles"));
		//insert user and role into app_user_roles
		processRegistrationManager.insertIntoAppUserRoles(Long.parseLong(request.getParameter("userRoles")), userId);
		
		

		String subject = "Your registration for Transaccess Imaging has been approved";
		StringBuffer message = new StringBuffer();
		
		message.append("Greetings, <br />")
		 .append("<br /><br />")
		    .append("Your administrator for the TransAccess Imaging System has granted you access. Please take the time to sign in to the application via the link provided below. The link will be valid for 4 days. If you have not activated during this time, your login credentials must be reset. Also included is your permanent user name.")
		 	.append("<br /><br />")
		 	.append("Once you click on the link below you will be prompted to enter in a new password. Please make sure that you keep this information confidential and in a safe place. ")
		 	.append("")
		 	.append("<br /><br />")
		 	.append("User Log In ID:   " + username.toUpperCase() + "<br />")
		 	 .append("<br /><br />");

		try
		{
			//Send the email to user
			Mail.getEmailCriteria(username, userId, Long.parseLong(request.getParameter("companyId")), request.getParameter("email"), subject, message.toString(), "Registration");
			//Send email to all Admins
			/*String subjectForAdminMail = "A new user has been added to the system";
			StringBuffer messageForAdminMail = new StringBuffer();
			
			messageForAdminMail.append("Greetings, <br />")
			 	.append("A new user has been added to the system. Please take the time to sign in to the application via the link provided below.  The link will be valid for 4 days.  After this period, your login credentials will have to be reset. Also included is your permanent user name.")
			 	.append("<br /><br />")
			 	.append("Once you click on the link below you will be prompted to enter in a new password. Please make sure that you have this information in a safe place.   ")
			 	.append("")
			 	.append("<br /><br />");
			 	
			Mail.sendEmailToAdmins(Long.parseLong(request.getParameter("companyId")),"ADMIN", subjectForAdminMail, messageForAdminMail.toString(), "Registration");*/
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
			
		}
		//return verification;
		
		try{
			
			request.setAttribute("sessionid", request.getParameter("sessionid"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("supervisorGrid.jsp?sessionid="+(String)request.getParameter("sessionid")+"&successMsg="+verification);
			dispatcher.forward(request, response);
		} catch(Exception e){
			System.out.println("Exception -->"+e.getMessage());
		
		}	
	}   	
	
}
