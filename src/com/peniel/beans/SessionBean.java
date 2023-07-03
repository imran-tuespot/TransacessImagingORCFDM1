package com.peniel.beans;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import com.peniel.bus.vo.Company;
import com.peniel.bus.vo.UserSession;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.CompanyDAO;
import com.peniel.dao.UserSessionDAO;

public class SessionBean 
{
	private static Logger logger = LogManager.getLogger(SessionBean.class);
	
	private String date2str(java.util.Date dt)
	{
		String sdt;
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(dt);
		
		sdt=""+cal.YEAR+"-"+cal.MONTH+"-"+cal.DAY_OF_MONTH+" "+cal.HOUR_OF_DAY+":"+cal.MINUTE+":"+cal.SECOND;
		return sdt;
	}	
	
	public static void insertSessionString( String sessionString , java.sql.Timestamp timstamp, int userid ,int flag, String userName, long companyId, String ipAddress) 
	{
		
		UserSessionDAO userSessionDao = new UserSessionDAO();
		
		int rv=-1;
        		
		try 
		{
			//insert into user session table session record
			userSessionDao.insertIntoUserSession(sessionString, userid, null, userName, companyId, ipAddress);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
        }
	}	
	
	
	public int getUserSessionList(String sessionId, HttpServletRequest request)
	{
		int id = checkSession(sessionId);
	  	return id;
	}
	
	
	public static int checkSession(String sessionId)
	{
		HashMap userSessionHashMap = new HashMap();
		UserSessionDAO userSessionDao = new UserSessionDAO();
		Vector<HashMap> userSessionList = new Vector<HashMap>();
		
		int id = -1;
		
		//Check to see if there is a record for the current session
		//and get the time difference
		userSessionList = userSessionDao.getSessionTimeDiff(sessionId);
		
		try
		{
			long timediff = 0;

	        //see if the vector has a time difference in it
	        //if it does, get the time difference value
	        if(!userSessionList.isEmpty())
	        {
	        	userSessionHashMap = userSessionList.get(0);
	        	//timediff = Float.parseFloat((String) userSessionHashMap.get("DIFF"));
	        	timediff= (long) userSessionHashMap.get("DIFF");
			} 
	        
	        //if time difference is greater than 0 and less than 10,
	        //update that record in the user session table
	        if ( timediff >= 0  && timediff < 20) 
	        {	
	        	
	        	userSessionDao.updatedLastUpdatedById(sessionId);
	        	id = 1;
	        	
	        } 
	        
	        
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return id;
	}
	

	public int checkTimeOut(String sessionId)
	{
		HashMap userSessionHashMap = new HashMap();
		UserSessionDAO userSessionDao = new UserSessionDAO();
		Vector userSessionList = new Vector();
		
		int id = -1;
		
		//Check to see if there is a record for the current session
		//and get the time difference
		userSessionList = userSessionDao.getSessionTimeDiff(sessionId);
		
		try
		{
			float timediff = 0;

	        //see if the vector has a time difference in it
	        //if it does, get the time difference value
	        if(!userSessionList.isEmpty())
	        {
	        	userSessionHashMap = (HashMap) userSessionList.get(0);
	        	timediff = Float.parseFloat((String)userSessionHashMap.get("DIFF"));
	        	
			} 
	        
	        //if time difference is greater than 0 and less than 10,
	        //update that record in the user session table
	        if ( timediff == 5) 
	        {	
	        	id = 5;
	        	
	        } 
	        
	        
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return id;
	}

	
	
	public static void endSession(String sessionId)
	{
		logger.info("sessionid -->"+sessionId+"<--");
		UserSessionDAO userSessionDao = new UserSessionDAO();
		
		userSessionDao.updateClosedOnById(sessionId);
		
		UserSession userSession = new UserSession();
		Vector userSessionList = new Vector();
		
		userSessionList = userSessionDao.findById(sessionId);
		userSession = (UserSession) userSessionList.get(0);
		
		long logged = userSession.getUserId();
		long comid = userSession.getCompanyId();

		
		long docid = 0L;
		long version = 0L;
		SessionLog sessionLog = new SessionLog();
		sessionLog.insertIntoSessionLog(sessionId, logged, comid, "Logout", docid, version, "Logout Successful");
		
		
	}
	
	public static String getNewSessionId(String username)
	{
		AppUserDAO appUserDao = new AppUserDAO();
		return appUserDao.createUserSessionId(username);
	}
	
	
	public static void updateSessionTime(String sessionId)
	{
		logger.info("sessionid -->"+sessionId+"<--");
		UserSessionDAO userSessionDao = new UserSessionDAO();
		userSessionDao.updatedLastUpdatedById(sessionId);
	}
}
