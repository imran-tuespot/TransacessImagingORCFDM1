package com.peniel.beans;

import java.util.HashMap;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.Company;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.CompanyDAO;




public class CheckUsername
{
	
	public static String checkUsername(String companyId, String username)
	{
		Vector appUserList = new Vector();
		AppUserDAO appUserDao = new AppUserDAO();
		String checkUserNameMessage = "";
		
		CompanyDAO companyDao = new CompanyDAO();
		Vector companyList = new Vector();
		Company company = new Company();
		
		companyList = companyDao.findById(companyId);
		company = (Company) companyList.get(0);
		
		
		if(!StringUtils.isBlank(username))
		{
			String userLoginId = company.getCompanyName() + "/" + username;
			appUserList = appUserDao.findByUserame(userLoginId.toUpperCase());
			
			if(appUserList.isEmpty())
			{
				checkUserNameMessage = "<input size=\"40\" type=\"text\" value=\"" + userLoginId.toUpperCase() + "\" readonly=\"readonly\"  />";
			}
			else
			{
				checkUserNameMessage = "<span style=\"font:Verdana, Arial, Helvetica, sans-serif; color:#FF3300\" >Username Taken!</span>";
			}
		}
		else
		{
			checkUserNameMessage = "<span style=\"font:Verdana, Arial, Helvetica, sans-serif; color:#FF3300\" >Fill Username!</span>";
		}
		
		
		
		return checkUserNameMessage;
	}
	
	public static String getEmails(String companyId)
	{
		HashMap emailList = new HashMap();
		AppUserDAO appUserDAO = new AppUserDAO();
		String html = "";
		try
		{
			emailList = appUserDAO.getAppUserEmails(companyId);
			UsersGrid usersGrid = new UsersGrid();
	        
			html = usersGrid.getUserEmailsHTML(emailList);			
			
		}  catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return html;
	}
	
}



