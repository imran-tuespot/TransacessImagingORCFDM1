package com.peniel.dao;

import java.util.Vector;

import com.peniel.common.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.AppRoles;



public class AppRolesDAO  extends DAOHelper<AppRoles>
{
	private static Logger logger = LogManager.getLogger(CompanyDAO.class);

    //private AppRolesSQLHelper appRolesSQLHelper;

    @Override
    public String getDocumentDataSeq() {
        return null;
    }

    @Override
    public AppRoles processDbLineToObject(dbobject.dbrow row) {
        return null;
    }

    public AppRolesDAO() {
        super("AppRolesDAO", AppRoles.getAppRolesSQLHelper());
        //appRolesSQLHelper = ;
    }

//    public Vector<AppRoles> findByProperty(String propertyName, String value)
//	{
//	    Vector<AppRoles> appRolesList = new Vector();
//
//		try
//		{
//			String sqlStatement="select role_id, role_name  from app_roles where " + propertyName + " = '" + value + "'";
//
//			logger.info("query : "+sqlStatement);
//
//			//appRolesList = getAppRolesList(DatabaseConnection.getResultSet(sqlStatement));
//			appRolesList = processSelectMulti(sqlStatement);
//		}
//		catch (Exception e)
//		{
//			logger.info("Error :"+e.getMessage());
//		}
//
//		return appRolesList;
//	}

	public Vector<AppRoles> findByRoleName(String companyName)
	{
		return findByProperty("ROLE_NAME", companyName);
	}
	
//	public Vector<AppRoles> findById(String id)
//	{
//		return findByProperty("ROLE_ID", id);
//	}
	
//	public Vector<AppRoles> findAll()
//	{
//        Vector<AppRoles> appRolesList = new Vector();
//
//        try
//        {
//            String sqlStatement="select role_id, role_name  from app_roles ";
//            logger.info("query : "+sqlStatement);
//            appRolesList = processSelectMulti(sqlStatement);
//        }
//        catch (Exception e)
//        {
//            logger.info("Error :"+e.getMessage());
//        }
//
//        return appRolesList;
//	}
	
	
//	public Vector<AppRoles> getAppRolesList(Vector hashMapList)
//	{
//		Vector<AppRoles> appRolesList = null;
//		AppRoles appRoles;
//
//		appRolesList = new Vector<AppRoles>();
//        try
//        {
//			for(int y = 0; y < hashMapList.size(); y++)
//			{
//				HashMap hashMap = new HashMap();
//    			hashMap = (HashMap)hashMapList.get(y);
//
//			   appRoles = new AppRoles();
//			   appRoles.setRoleId(Long.parseLong((String)hashMap.get("ROLE_ID")));
//			   appRoles.setRoleName((String)hashMap.get("ROLE_NAME"));
//
//
//			    appRolesList.add(appRoles);
//			}
//		}
//        catch (Exception e)
//        {
//			// TODO Auto-generated catch block
//        	logger.info("Error :"+e.getMessage());
//		}
//
//
//		return appRolesList;
//	}

}












