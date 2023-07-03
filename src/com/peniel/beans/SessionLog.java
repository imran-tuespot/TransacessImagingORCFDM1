package com.peniel.beans;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.dao.SessionLogDAO;

public class SessionLog {
	
	private static Logger logger = LogManager.getLogger(SessionLog.class);
	
	public static void insertIntoSessionLog(String sessionId, long userId, long compid, String action, long docId, long version, String description ) 
	{
		try
		{
            SessionLogDAO sessionLogDao = new SessionLogDAO();

			//insert into session log table
			sessionLogDao.insertIntoSessionLog(sessionId, userId, compid, action, docId, version, description);
		}
		catch (Exception e) 
		{
			logger.error("insertSessionLog() : Error : "+e.getMessage());
			e.printStackTrace();
        }
	}	

	public static void insertIntoSessionLog(String sessionId, long userId, long compid, String action,long docId, String fieldName, String oldValue, String newValue, String description ) 
	{
		try
		{
            SessionLogDAO sessionLogDao = new SessionLogDAO();

			//insert into session log table
			sessionLogDao.insertIntoSessionLog(sessionId, userId, compid, action,docId, fieldName, oldValue, newValue, description);
			System.out.println("****Inserted values in SessionLog successfully!****");
		}
		catch (Exception e) 
		{
			logger.error("insertSessionLog() : Error : "+e.getMessage());
			e.printStackTrace();
        }
	}	

}
