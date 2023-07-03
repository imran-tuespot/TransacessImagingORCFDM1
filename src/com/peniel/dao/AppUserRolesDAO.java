package com.peniel.dao;


import java.util.Vector;

import com.peniel.common.DAOHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.AppUserRoles;


public class AppUserRolesDAO extends DAOHelper<AppUserRoles>
{
	private static Logger logger = LogManager.getLogger(AppUserRolesDAO.class);

    public AppUserRolesDAO() {
        super("AppUserRolesDAO", AppUserRoles.getAppRolesSQLHelper());
    }

	public Vector<AppUserRoles> findByUserId(String userId)
	{
		return findByProperty("USER_ID", userId);
	}
	
	public Vector<AppUserRoles> findById(String id)
	{
		return findByProperty("ROLE_ID", id);
	}
	public void updateAppUserRoles(double roleIdVal1, double userId, String sessionId,double userRoleId)
	{
		try {
		//DatabaseConnection dbConnection = new DatabaseConnection();
	
		String sqlStatement="update app_user_roles set role_id = " +roleIdVal1 +" , user_session_id = '" + sessionId + "' where user_id = " + userId+" and USER_ROLE_ID ="+userRoleId;
		
		logger.info("query : "+sqlStatement);
		executeUpdate(sqlStatement);
		
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	
	public Vector<AppUserRoles> findAll(long userId,long userroleID)
	{
		 Vector appRolesList = new Vector();
		 
		 
			try 
			{
				String sqlStatement="select user_id, role_id, effective_date  from app_user_roles where user_id ="+userId+" and USER_ROLE_ID="+userroleID;
				
				logger.info("query : "+sqlStatement);
				
				appRolesList = processSelectMulti(sqlStatement);
                //getAppUserRolesList(DatabaseConnection.getResultSet(sqlStatement));
				
				
			} 
			catch (Exception e) 
			{
				logger.info("Error :"+e.getMessage());
			}
			
			return appRolesList;
	}
	public void insertIntoAppUserRoles(long roleIdVal1, long userId,long userRoleId)
	{
		try {
		//DatabaseConnection dbConnection = new DatabaseConnection();
	
		String sqlStatement="insert into app_user_roles (role_id, user_id, effective_date,USER_ROLE_ID,USER_SESSION_ID) values (" + roleIdVal1 + ", " + userId + ", sysdate() ,'"+userRoleId+"',null)";
		
		logger.info("query : "+sqlStatement);
		executeUpdate(sqlStatement);
		
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	
	public Vector<AppUserRoles> findAll()
	{
		 Vector appRolesList = new Vector();
		 
		 
			try 
			{
				String sqlStatement="select user_id, role_id, effective_date  from app_user_roles ";
				
				logger.info("query : "+sqlStatement);
				
				appRolesList = processSelectMulti(sqlStatement);
                //getAppUserRolesList(DatabaseConnection.getResultSet(sqlStatement));
				
				
			} 
			catch (Exception e) 
			{
				logger.info("Error :"+e.getMessage());
			}
			
			return appRolesList;
	}
	
	

	public void insertIntoAppUserRoles(long roleId, long userId)
	{
		try {
		//DatabaseConnection dbConnection = new DatabaseConnection();

		String sqlStatement="insert into app_user_roles (role_id, user_id, effective_date) values (" + roleId + ", " + userId + ", sysdate())";
		
		logger.info("query : "+sqlStatement);
		executeUpdate(sqlStatement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateAppUserRoles(long roleIdVal1, long userId, String sessionId)
	{
		try {
		//DatabaseConnection dbConnection = new DatabaseConnection();
	
		String sqlStatement="update app_user_roles set role_id = " +roleIdVal1 +" , user_session_id = '" + sessionId + "' where user_id = " + userId;
		
		logger.info("query : "+sqlStatement);
		executeUpdate(sqlStatement);
		
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	
//    public static Vector findByProperty(String propertyName, String value) {
//
//		 Vector appUserRolesList = new Vector();
//
//
//		try
//		{
//			String sqlStatement="select user_id, role_id, effective_date  from app_user_roles where " + propertyName + " = '" + value + "'";
//
//			logger.info("query : "+sqlStatement);
//
//			appUserRolesList = getAppUserRolesList(DatabaseConnection.getResultSet(sqlStatement));
//
//
//		}
//		catch (Exception e)
//		{
//			logger.info("Error :"+e.getMessage());
//		}
//
//		return appUserRolesList;
//	}

//	public Vector<AppUserRoles> getAppUserRolesList(Vector hashMapList)
//	{
//		Vector appUserRolesList = null;
//		AppUserRoles appUserRoles;
//
//		appUserRolesList = new Vector();
//
//		try
//        {
//			for(int y = 0; y < hashMapList.size(); y++)
//			{
//				HashMap hashMap = new HashMap();
//    			hashMap = (HashMap)hashMapList.get(y);
//
//			   appUserRoles = new AppUserRoles();
//			   appUserRoles.setRoleId(Long.parseLong((String)hashMap.get("ROLE_ID")));
//			   appUserRoles.setUserId(Long.parseLong((String)hashMap.get("USER_ID")));
//			   appUserRoles.setEffectiveDate((String)hashMap.get("EFFECTIVE_DATE"));
//
//			    appUserRolesList.add(appUserRoles);
//			}
//		}
//        catch (Exception e)
//        {
//			// TODO Auto-generated catch block
//        	logger.info("Error :"+e.getMessage());
//		}
//
//
//		return appUserRolesList;
//	}

}












