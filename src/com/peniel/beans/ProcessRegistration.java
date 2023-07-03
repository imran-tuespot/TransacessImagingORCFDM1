package com.peniel.beans;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import com.peniel.dao.AppUserDAO;
import com.peniel.manager.*;


public class ProcessRegistration
{
	private static Logger logger = LogManager.getLogger(ProcessRegistration.class);
	
	public static String processRequest(HttpServletRequest request)
	{
		System.out.println("ProcessRegistration");
		
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
		
		//insert user and role into app_user_roles
		processRegistrationManager.insertIntoAppUserRoles(Long.parseLong(request.getParameter("userRoles")), userId);
		
		Mail mail = new Mail();

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
			mail.getEmailCriteria(username, userId, Long.parseLong(request.getParameter("companyId")), request.getParameter("email"), subject, message.toString(), "Registration");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
			
		}
		return verification;
	}

}

