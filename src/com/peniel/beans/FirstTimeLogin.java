package com.peniel.beans;

import java.util.HashMap;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import com.peniel.bus.vo.UserSession;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.UserSessionDAO;



public class FirstTimeLogin
{
	
	
	public static HashMap firstTimeLoginTimeDiff(String sessionId)
	{
		System.out.println(sessionId);
		HashMap hasItBeen48hrs = new HashMap();;

		
		
		if(!StringUtils.isBlank(sessionId))
		{
			//If this is the first time a user logs in, check to see if it 
			//has been 48 hrs since the account was created
			
			hasItBeen48hrs = getFirstLoginTimeDiff(sessionId);
			
			//if so, send to add password page
			//if not, send to another page that will instruct the user to contact the system administrator
			
		}
		
		
		return hasItBeen48hrs;
	}
	
	
	public static HashMap getFirstLoginTimeDiff(String sessionId)
	{
		HashMap userSessionHashMap = new HashMap();
		HashMap userResults = new HashMap();
		HashMap user = new HashMap();
		
		UserSession userSession = new UserSession();
		
		
		UserSessionDAO userSessionDao = new UserSessionDAO();
		Vector userSessionList = new Vector();
		float timediff = 0;
		Boolean timeCheck = true;

		
		//Check to see if there is a record for the current session
		//and get the time difference
		userSessionList = userSessionDao.getSessionTimeDiff(sessionId);
		
		
		if(!userSessionList.isEmpty())
        {
        	userSessionHashMap = (HashMap) userSessionList.get(0);
        	timediff = Float.parseFloat((String)userSessionHashMap.get("DIFF"));
		} 

        //if time difference is greater than 0,
        //update the value in the hash map to false
        if ( timediff >= 0 && timediff <= 5760  ) 
        {	
        	timeCheck = false;
        	userResults.put("booleanValue", timeCheck);
        	
        } 
        
        //get the username and pass back
        userSessionList.clear();
        userSessionList = userSessionDao.findById(sessionId);
        if(!userSessionList.isEmpty())
        {
        userSession = (UserSession) userSessionList.get(0);
        }
		
        userResults.put("username", userSession.getUsername());
        
        
		return userResults;
	}
	
	
	public static String updateUserPassword(String username, String password, String sessionId)
	{
		AppUserDAO appUserDao = new AppUserDAO();
		UserSessionDAO userSessionDao = new UserSessionDAO();
		UserSession userSession = new UserSession();
		Vector userSessionList = new Vector();
		
		userSessionList = userSessionDao.findById(sessionId);
		userSession = (UserSession) userSessionList.get(0);
		
		String verifyMessage = appUserDao.updatePasswordByUsername(username, password);
		
		appUserDao.updatePasswordStatusById(userSession.getUserId(), "A");
		
		SessionLog sessionLog = new SessionLog();
		sessionLog.insertIntoSessionLog(sessionId, userSession.getUserId(), userSession.getCompanyId(), "Forgot Password", 0L, 0L, "Forgot Password Successful");
		
		
		return verifyMessage;
	}
	
}




