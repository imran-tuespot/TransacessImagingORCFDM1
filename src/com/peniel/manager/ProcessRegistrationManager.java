package com.peniel.manager;

import java.util.Random;
import java.util.Vector;

import com.peniel.bus.vo.Company;
import com.peniel.common.PenielException;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.AppUserRolesDAO;
import com.peniel.dao.CompanyDAO;
import com.peniel.dao.UserSessionDAO;



public class ProcessRegistrationManager
{
	
	
	public static String insertNewUser(long userId, String userTypeId, String username, String companyId,
			String firstName, String lastName, String address1, String address2, String city, String state, 
			String zip, String email, String phoneNo, String cellPhone, String secondEmail, String jobTitle, String acceptMails)
	{
		AppUserDAO appUserDao =  new AppUserDAO();

		String verifyMessage = appUserDao.insertIntoAppUser(userId, userTypeId, username, companyId, firstName, lastName, address1, address2, city, state, zip, email, phoneNo, cellPhone, secondEmail, jobTitle, acceptMails);
		
		
		return verifyMessage;
	}
	
	public static String getCompanyNameById(String companyId)
	{
		AppUserDAO appUserDao = new AppUserDAO();
		Company company = new Company();
		CompanyDAO companyDao = new CompanyDAO();
		UserSessionDAO userSessionDao = new UserSessionDAO();
		
		Vector companyList = companyDao.findById(companyId);
		
		company = (Company) companyList.get(0);
		
		//username is equal to companyName/username
		return company.getCompanyName();
	}
	
	public static long getNewUserId()
	{
        try {
            AppUserDAO appUserDao = new AppUserDAO();
            return appUserDao.getMaxUserId();
        } catch (PenielException e) {
            System.out.println("Cannot Get new UserID");
        }
        return 0;
	}
	
	public static String getNewUserSessionId(String username)
	{
		AppUserDAO appUserDao = new AppUserDAO();
		return appUserDao.createUserSessionId(username);
	}
	
	public static void insertUserSessionTimedLogin(long userId, String sessionId, String username, String companyId)
	{
		UserSessionDAO userSessionDao = new UserSessionDAO();
		
		userSessionDao.insertIntoUserSession(sessionId, userId, "", username, Long.parseLong(companyId), "");
		
	}
	
	public static void insertIntoAppUserRoles(long roleId, long userId)
	{
		AppUserRolesDAO appUserRolesDao = new AppUserRolesDAO();
		
		appUserRolesDao.insertIntoAppUserRoles(roleId, userId);
	}
	
	
}

