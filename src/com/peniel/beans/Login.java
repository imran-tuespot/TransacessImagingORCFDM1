package com.peniel.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.AppUser;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.UserSessionDAO;



public class Login {
	private static Logger logger = LogManager.getLogger(Login.class);
	   
	
	public int getAuthentication( String username , String password ) 
	{
		AppUserDAO appUserDao = new AppUserDAO();
		AppUser appUser = new AppUser();
		Vector appUserList = new Vector();

		int userid = 0;
		int comid=0;
		String pwd = "";
		
		try 
		{
			//Check to see if there is a user with this name
			appUserList = appUserDao.findByUserame(username.toUpperCase());
	        if(!appUserList.isEmpty())
	        {
	        	appUser = (AppUser) appUserList.get(0);
	        	
	        	userid = (int) appUser.getUserId();
	        	System.out.println("userid ---> "+userid);

	        	System.out.println("status ---> "+appUser.getStatus());
	        	System.out.println("password status ---> "+appUser.getPasswordStatus());

	        	pwd = appUser.getPassword();

	        	comid = (int) appUser.getCompanyId();
	        	System.out.println("comid ---> "+comid);
	    		if ( pwd.trim().equals(password.trim()) && !appUser.getStatus().equals("D") && !appUser.getPasswordStatus().equals("D") ) {
	    			System.out.println("Returning "+comid*1000000+userid);
	    			return comid*1000000+userid;
	    		} else {
	    			System.out.println("Returning -1");

	    			return -1;
	    		}
	    		
	        	
			} 
        
		} catch (Exception e) {
			logger.error("Data Error"+e);
			e.printStackTrace();
			return -1;
			
        }
		
		return -1;
		
	}	
	
	
	public List<AppUser> getAuthenticated( String username , String password ) 
	{
		AppUserDAO appUserDao = new AppUserDAO();
		AppUser appUser = new AppUser();
		Vector appUserList = new Vector();

		String pwd = "";
		
		try 
		{
			//Check to see if there is a user with this name
			appUserList = appUserDao.findByUserame(username.toUpperCase());
			System.out.println(appUserList.size());
	        if(!appUserList.isEmpty())
	        {
	        	appUser = (AppUser) appUserList.get(0);
	        	System.out.println(appUser);
	        	
	        	pwd = appUser.getPassword();
	        	
	        	if (null!=pwd && pwd.trim().equals(password.trim())  && !appUser.getPasswordStatus().equals("D") ) {
	    			//System.out.println("Returning "+comid*1000000+userid);

	    			return appUserList;
	    		} else {
	    			return null;
	    		}
	    	} 
        
		} catch (Exception e) {
			logger.error("Data Error"+e);
			e.printStackTrace();
			return null;
			
        }
		
		return null;
		
	}
	
	
	

}
