package com.peniel.beans;


import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.peniel.bus.vo.AppUser;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.UserSessionDAO;

public class PasswordReset
{
	private static Logger logger = LogManager.getLogger(PasswordReset.class);
	
	public static String getPasswordReset(String username, String sessionId)
	{
		//see if this user is in the database and not have a status of disabled
		AppUser appUser = new AppUser();
		AppUserDAO appUserDao = new AppUserDAO();
		Vector appUserList = new Vector();
		Mail mail = new Mail();
		String confirmationMessage = "";
		
		appUserList = appUserDao.findByUserameUpper(username);
		System.out.println("appUserList"+appUserList.size());
		
		if(!appUserList.isEmpty())
		{
			appUser = (AppUser) appUserList.get(0);
			System.out.println("appUser"+appUser.getUsername()+ " "+ appUser.getStatus());
			
			if(!StringUtils.isEmpty(appUser.getStatus()) && !appUser.getStatus().equals("D"))
			{
				
				//change the status to disabled and send an email to the user with the 
				//link that will allow the user to insert a new password
				//appUserDao.updateStatusById(appUser.getUserId(), "D");
				appUserDao.updatePasswordStatusById(appUser.getUserId(), "D");
				
				String subject = "Your password for Transaccess Imaging needs to be updated";
				StringBuffer message = new StringBuffer();
				
				//Generate the email to be sent 
				//the link with be added in the getEmailCriteria method
				message.append("Greetings, <br />")
				    .append("<br /><br />")
				 	.append("Your account has been disabled.  Please take the time to click the link provided below within 4 days.")
				 	.append("<br /><br />")
				 	.append("Once you click on the link below you will be prompted to enter in a new password.  Please make sure that you have this information in a safe place.  ")
				 	.append("")
				 	.append("<br /><br />")
				 	.append("User Log In ID:   " + appUser.getUsername() + "<br />")
				 	 .append("<br /><br />");

				try
				{
					mail.getEmailCriteria(username, appUser.getUserId(), appUser.getCompanyId(), appUser.getEmail(), subject, message.toString(), "Forgot Password");
					confirmationMessage = "Your information has been validated.  An email with further instructions has been sent to the email address on file.  Please follow the directions in the email to reset your password.";
					
					//Check to see if the sessionId is empty, if not insert record into Session Log table
					//insertIntoSessionLog(sessionId, userId, companyId, emailType);
					if(!StringUtils.isBlank(sessionId))
					{
						SessionLog sessionLog = new SessionLog();
						sessionLog.insertIntoSessionLog(sessionId, appUser.getUserId(), appUser.getCompanyId(), "Forgot Password", 0L, 0L, "Forgot Password Successful");
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					logger.info("Error :"+e.getMessage());	
				}
			}
			else
			{
				confirmationMessage = "Your account has been disabled.  Please contact an administrator to help reset your password.";
			}
		}
		else
		{
			confirmationMessage = username + " does not exist in the system.  Please go back and enter correct User Log In ID.";
		}

		return confirmationMessage;
	}
	
	public static void insertUserSessionTimedLogin(long userId, String sessionId, String username, long companyId)
	{
		UserSessionDAO userSessionDao = new UserSessionDAO();
		userSessionDao.insertIntoUserSession(sessionId, userId, "", username, companyId, "");
		
	}
	
	public static String getNewUserSessionId(String username)
	{
		AppUserDAO appUserDao = new AppUserDAO();
		return appUserDao.createUserSessionId(username);
	}

}





