package com.peniel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import com.peniel.bus.vo.UserSession;
import com.peniel.common.DAOHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.peniel.bus.vo.UserType;
import com.peniel.database.DatabaseConnection;




public class UserTypeDAO  extends DAOHelper<UserType>
{
	private static Logger logger = LogManager.getLogger(UserTypeDAO.class);
	
    public UserTypeDAO() {
        super("UserTypeDAO", UserType.getUserTypeSQLHelper());
    }

	public Vector<UserType> findByProperty(String propertyName, String value)
	{
	    Vector<UserType> userTypeList = new Vector<UserType>();
		 
		try
		{
			String sqlStatement="select user_type_id, user_type from user_type where " + propertyName + " = '" + value + "'";
			logger.info("query : "+sqlStatement);

			userTypeList = processSelectMulti(sqlStatement);
			//userTypeList = getUserTypeList(DatabaseConnection.getResultSet(sqlStatement));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return userTypeList;
	}
	
	
//	public static Vector<UserType> findAll()
//	{
//		Vector userTypeList = new Vector();
//
//		try
//		{
//			String sqlStatement="select user_type_id, user_type from user_type ";
//			logger.info("query : "+sqlStatement);
//
//			DatabaseConnection dbConnection = new DatabaseConnection();
//			userTypeList = getUserTypeList(dbConnection.getResultSet(sqlStatement));
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			logger.info("Error :"+e.getMessage());
//		}
//
//		return userTypeList;
//	}
	

	public Vector<UserType> findByUserType(String userType)
	{
		return findByProperty("USER_TYPE", userType);
	}
	
	public UserType findById(Long userTypeId)
	{
//		ResultSet resultSet = null;
//		 Vector userTypeList = new Vector();
		 UserType userType = null;
		 
		 
		try 
		{
			String sqlStatement="select * from user_type where user_type_id = " + userTypeId;
			logger.info("query : "+sqlStatement);

			userType = processSelectSingle(sqlStatement);
			//userTypeList = getUserTypeList(DatabaseConnection.getResultSet(sqlStatement));

//			userType = (UserType)userTypeList.get(0);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return userType;
	}
	
	
//	public  Vector<UserType> getUserTypeList(Vector hashMapList)
//	{
//		Vector<UserType> userTypeList = null;
//		UserType userType;
//
//		userTypeList = new Vector<UserType>();
//        try
//        {
//        	for(int y = 0; y < hashMapList.size(); y++)
//    		{
//    			HashMap hashMap = new HashMap();
//    			hashMap = (HashMap)hashMapList.get(y);
//
//
//			   userType = new UserType();
//			   userType.setUserTypeId(Long.parseLong((String)hashMap.get("USER_TYPE_ID")));
//			   userType.setUserType((String)hashMap.get("USER_TYPE"));
//
//			   userTypeList.add(userType);
//			}
//		}
//        catch (Exception e)
//        {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			logger.info("Error :"+e.getMessage());
//		}
//
//
//		return userTypeList;
//	}
	
}



