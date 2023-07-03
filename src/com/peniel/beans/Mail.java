package com.peniel.beans;

import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.AppUser;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.UserSessionDAO;
import com.peniel.utilities.GeneratePassword;

public class Mail {
	
	private static Logger logger = LogManager.getLogger(Mail.class);
	private static String url = "";
	private static EmailValidator emailValidator = new EmailValidator();
	
	private static  String SMTP_ADDR = "";
    private static  int SMTP_PORT  ;
    private static  String SMTP_EMAIL = "";
    private static  String SMTP_PWD = "";

       
	
	public Mail () {
	}
	
	public static void postMail( String recipients[], String subject, String message) throws MessagingException
	{
	     //Set the host smtp address
	     Properties props = new Properties();
	     String smtp = "";
	     String semail = "";
	     String from = "";
	 	 try
		 {
	 		 javax.naming.Context ctx = 	new javax.naming.InitialContext();
	 		 smtp = (String) ctx.lookup("java:comp/env/smtp");
	 		 semail = (String) ctx.lookup("java:comp/env/semail");
	 		 
		 } 
	 	 catch (Exception e) 
	 	 {
			 e.printStackTrace();
			 logger.info("Error :"+e.getMessage());
		 }
		
		 if (smtp == null) smtp="10.1.0.5";

	     props.put("mail.smtp.host", smtp);
	     
	     if (semail!=null) from="noreply@fhaoutreach.com";

	     // create some properties and get the default Session
	     Session session = Session.getDefaultInstance(props, null);

	     // create a message
	     Message msg = new MimeMessage(session);

	     // set the from and to address
	     InternetAddress addressFrom = new InternetAddress(from);
	     msg.setFrom(addressFrom);

	     InternetAddress[] addressTo = new InternetAddress[recipients.length]; 
	     
	     for (int i = 0; i < recipients.length; i++)
	     {
	        addressTo[i] = new InternetAddress(recipients[i]);
	     }
	     msg.setRecipients(Message.RecipientType.TO, addressTo);

	     msg.addHeader("MyHeaderName", "Email From Imaging Application");

	     // Setting the Subject and Content Type
	     msg.setSubject(subject);
	     msg.setContent(message, "text/html");
	     Transport.send(msg);
	}
	
	public static String postMailWithCC_BCC( String recipientsTo[],String recipientsCC[],String recipientsBCC[],
										   String subject, String message) throws MessagingException
	{
	     //Set the host smtp address
	     Properties props = new Properties();
	     String smtp = "";
	     String semail = "";
	     String from = "";
	     String success = "";
	    
	 	 try
		 {
	 		 javax.naming.Context ctx = 	new javax.naming.InitialContext();
	 		 smtp = (String) ctx.lookup("java:comp/env/smtp");
	 		 semail = (String) ctx.lookup("java:comp/env/semail");	 
		
			 if (smtp == null) smtp="10.1.0.5";
	
		     props.put("mail.smtp.host", smtp);
		     
		     if (semail!=null) from="noreply@fhaoutreach.com";
	
		     // create some properties and get the default Session
		     Session session = Session.getDefaultInstance(props, null);
	
		     // create a message
		     Message msg = new MimeMessage(session);
	
		     // set the from and to address
		     InternetAddress addressFrom = new InternetAddress(from);
		     msg.setFrom(addressFrom);
	
		     InternetAddress[] addressTo = new InternetAddress[recipientsTo.length]; 
		     
		     for (int i = 0; i < recipientsTo.length; i++)
		     {
		    	 if(emailValidator.validate(recipientsTo[i]))
		    		 addressTo[i] = new InternetAddress(recipientsTo[i]);
		     }
		     msg.setRecipients(Message.RecipientType.TO, addressTo);
		     
		     InternetAddress[] addressCC = new InternetAddress[recipientsCC.length]; 
		     
		     for (int k = 0; k < recipientsCC.length; k++)
		     {
		    	 if(emailValidator.validate(recipientsCC[k]))
		    		 addressCC[k] = new InternetAddress(recipientsCC[k]);		    	 
		     }
		    
		     msg.setRecipients(Message.RecipientType.CC, addressCC);
		     
		     InternetAddress[] addressBCC = new InternetAddress[recipientsBCC.length]; 
		     
		     for (int j= 0; j < recipientsBCC.length; j++)
		     {
		    	 if(emailValidator.validate(recipientsBCC[j])) 
		    		 addressBCC[j] = new InternetAddress(recipientsBCC[j]);
		     }
		     msg.setRecipients(Message.RecipientType.BCC, addressBCC);
		     
		     // Optional : You can also set your custom headers in the Email if you Want
		     msg.addHeader("MyHeaderName", "Email From Imaging Application");
	
		     // Setting the Subject and Content Type
		     msg.setSubject(subject);
		     msg.setContent(message, "text/html");
		     Transport.send(msg);
		     success = "yes";
		 } 
	 	 catch (Exception e) 
	 	 {
	 		 success = "no";
			 e.printStackTrace();
			 logger.info("Error :"+e.getMessage());
		 }
	 	 return success;
	}
	
	
	public static String getEmailCriteria(String username, long userId, long companyId, String email, String emailSubject,  String emailMessage, String emailType)
	{
		AppUserDAO appUserDao = new AppUserDAO();
		UserSessionDAO userSessionDao = new UserSessionDAO();
		javax.naming.Context ctx;
		try 
		{
			ctx = new javax.naming.InitialContext();
			url = (String) ctx.lookup("java:comp/env/URL");
			SMTP_ADDR = (String) ctx.lookup("java:comp/env/SMTP_ADDR");
	 		SMTP_PORT = Integer.parseInt((String) ctx.lookup("java:comp/env/SMTP_PORT"));
	 		SMTP_EMAIL = (String) ctx.lookup("java:comp/env/SMTP_EMAIL");
	 		SMTP_PWD = (String) ctx.lookup("java:comp/env/SMTP_PWD");
	 		String appProperty = (String) ctx.lookup("java:comp/env/appProperty");
			GeneratePassword generatePassphrase = new GeneratePassword(appProperty);
			SMTP_PWD = generatePassphrase.decrypt(SMTP_PWD);
			
		} 
		catch (NamingException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		//insert a record with current date into session table for 48 hour login
		String sessionIdForUserEmail = appUserDao.createUserSessionId(username);

		userSessionDao.insertIntoUserSession(sessionIdForUserEmail, userId, "", username, companyId, "");
		

		//Now, send an email to the user
		String[] strArray = new String[1];
		
		strArray[0] = email;
		
		logger.info("************  Here is the URL:  " + url);
		
		emailMessage = emailMessage + "<a href=\""+url+"firstTimeLogin.jsp?firstTime=" + sessionIdForUserEmail + "\">TransAccess Imaging<br/><br /><br /></a>"; 	

		try
		{
			//postMail(strArray, emailSubject, emailMessage);
			postOffice365Mail(strArray, emailSubject, emailMessage);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
			
		}
		
		return "";
	}
	public static  String sendEmailToAdmins(long companyId,String roleName,String emailSubject,  String emailMessage, String emailType)
	{
		AppUser appUser = new AppUser();
		AppUserDAO appUserDao = new AppUserDAO();
		Vector appUserList = new Vector();
		 

		appUserList = appUserDao.findByComapnyAndRole(Long.toString(companyId), roleName);
		for (Iterator it = appUserList.iterator (); it.hasNext();) 
		{
			appUser = (AppUser) it.next();
		    
			if(!appUser.getStatus().equals("D"))
			{
				String[] strArray = new String[1];
				
				strArray[0] = appUser.getEmail();
				try
				{
					logger.info("Sending mail to admin :"+strArray[0].toString());
					postMail(strArray, emailSubject, emailMessage);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					logger.info("Error :"+e.getMessage());					
				}			
				    
			  } 			

			}	
		
		return "";
	}
	
	 public static void postOffice365Mail(String recipients[], String subject, String msg) throws MessagingException
	 {
	     final Session session = Session.getInstance(getEmailProperties(), new Authenticator() {

	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(SMTP_EMAIL, SMTP_PWD);
	            }

	        });

	        try {
	        	final Message message = new MimeMessage(session);
	            
	            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients[0]));
	            message.setFrom(new InternetAddress("transaccess@penielsolutions.com"));
	            message.setSubject(subject);
	            message.setContent(msg, "text/html");
	           
	            Transport.send(message);
	            
	        } catch (final MessagingException ex) {
	        	logger.info("Error in send mail " + ex.getMessage());
	        	ex.printStackTrace();
	        }
	    }

	 public static Properties getEmailProperties() {
	        final Properties config = new Properties();
	        config.put("mail.smtp.auth", "true");
	        config.put("mail.smtp.starttls.enable", "true");
	        config.put("mail.smtp.host", SMTP_ADDR);
	        config.put("mail.smtp.port", SMTP_PORT);
	        config.put("mail.smtp.ssl.protocols", "TLSv1.2");
	        return config;
	}
}
