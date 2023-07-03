package com.peniel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import com.peniel.bus.vo.States;
import com.peniel.common.DAOHelper;
import com.peniel.common.dbobject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.UserSession;
import com.peniel.database.DatabaseConnection;




public class UserSessionDAO extends DAOHelper<UserSession>
{
	private static Logger logger = LogManager.getLogger(UserSessionDAO.class);
	
    public UserSessionDAO() {
        super("UserSessionDAO", UserSession.getUserSessionSQLHelper());
    }

	public Vector<UserSession> findByProperty(String propertyName, String value)
	{
		Vector<UserSession> userSessionList = new Vector<UserSession>();

		try 
		{
			String sqlStatement="select session_id, last_updated, user_id, closed_on, username, compid, ipaddress from user_session where " + propertyName + " = '" + value + "'";
			logger.info("query : "+sqlStatement);

			userSessionList = processSelectMulti(sqlStatement);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return userSessionList;
	}

	public Vector<UserSession> findByUserId(String userId)
	{
		return findByProperty("USER_ID", userId);
	}
	
	public Vector<UserSession> findById(String sessionId)
	{
		return findByProperty("SESSION_ID", sessionId);
	}
	
	public void updatedLastUpdatedById(String sessionId)
	{
		try
		{
			
			//DatabaseConnection dbConnection = new DatabaseConnection();
			String sqlStatement = "UPDATE user_session SET last_updated=sysdate() WHERE session_id = '"+ sessionId +"'";
			logger.info("query : "+sqlStatement);
			
			executeUpdate(sqlStatement);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
	}
	
	
	public void updateClosedOnById(String sessionId)
	{
		try
		{
			//DatabaseConnection dbConnection = new DatabaseConnection();
			String sqlStatement = "UPDATE user_session SET closed_on = sysdate() WHERE session_id = '"+ sessionId +"'";
			logger.info("query : "+sqlStatement);
			
			executeUpdate(sqlStatement);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
	}
	
	
	public Vector<HashMap> getSessionTimeDiff(String sessionString)
	{
		Vector<HashMap> userSessionList = new Vector<HashMap>();
		String sqlStatement = "select user_id,((DATEDIFF(sysdate(),last_updated))*60*24) as DIFF from user_session where session_id = '"+sessionString+"'";
		
		
		try
		{
			logger.info("query @@@@@@@@@@@@@@@@@@@@@: "+sqlStatement);
			userSessionList = processSelectMultiIntoHashMap(sqlStatement);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return userSessionList;
		
	}

//	public static Vector getUserSessionList(Vector hashMapList)
//	{
//		Vector userSessionList = null;
//		UserSession userSession;
//
//		userSessionList = new Vector();
//        try
//        {
//        	for(int y = 0; y < hashMapList.size(); y++)
//    		{
//    			HashMap hashMap = new HashMap();
//    			hashMap = (HashMap)hashMapList.get(y);
//
//
//			   userSession = new UserSession();
//			   userSession.setClosedOn((String)hashMap.get("CLOSED_ON"));
//			   userSession.setLastUpdated((String)hashMap.get("LAST_UPDATED"));
//			   userSession.setSessionId((String)hashMap.get("SESSION_ID"));
//			   userSession.setUserId(Long.parseLong((String)hashMap.get("USER_ID")));
//			   userSession.setUsername((String)hashMap.get("USERNAME"));
//			   userSession.setIpAddress((String)hashMap.get("IPADDRESS"));
//			   userSession.setCompanyId(Long.parseLong((String)hashMap.get("COMPID")));
//
//			   userSessionList.add(userSession);
//			}
//		}
//        catch (Exception e)
//        {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			logger.info("Error :"+e.getMessage());
//		}
//
//		return userSessionList;
//	}
	
	
	public void insertIntoUserSession(String sessionId, long userId, String closedOn, String username, long compid, String ipAddress )
	{
		try
		{
			
			String sqlstatement = "insert into user_session (session_id, last_updated, user_id, username, compid, ipaddress) values ('" 
				+ sessionId + "', sysdate(), '" + userId+ "', '" + username + "', '" + compid + "', '" + ipAddress + "')";
			//DatabaseConnection dbConnection = new DatabaseConnection();
			logger.info("query : "+sqlstatement);
			executeUpdate(sqlstatement);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
	}
	
	public UserSession insertIntoUserSession(String userId, String closedOn, String username, String compId, String ipAddress )
	{
        int userid = Integer.valueOf(userId);
        int compid = Integer.valueOf(compId);
        
        String sessionId = compid + "-" + userId + "-" + (new Date()).getTime();
        insertIntoUserSession(sessionId, userid, closedOn, username, compid, ipAddress);
        Vector<UserSession> userSessionVector = findByProperty("session_id", sessionId);

        if (userSessionVector != null && userSessionVector.size() > 0){
            return userSessionVector.firstElement();
        }

        return null;
	}
	
	
}



