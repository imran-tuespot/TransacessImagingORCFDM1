package com.peniel.manager;

import java.util.Vector;

import com.peniel.dao.AppUserDAO;




public class LoginManager
{

		public static Vector authenticateUser(String username)
		{
			Vector userList = new Vector();
			AppUserDAO appUserDao = new AppUserDAO();
			
			userList = appUserDao.findByUserame(username); 
			return userList;
		}
		
		
		
}



