package com.peniel.beans;



import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.peniel.bus.vo.Company;
import com.peniel.dao.CompanyDAO;

public class CompanyInformation 
{
	public static HashMap getCompanyInformation(HttpServletRequest request)
	{
		HashMap hashMap = new HashMap();
		
		Vector companyList = new Vector();
		CompanyDAO companyDAO = new CompanyDAO();
		
		//Get the company information from the database
		companyList = companyDAO.findById(request.getSession().getAttribute("comid").toString());        
		
		return getInformation(companyList);
	}
	
	public static HashMap getcompanyInformation(String companyId)
	{
		HashMap hashMap = new HashMap();
		
		Vector companyList = new Vector();
		CompanyDAO companyDAO = new CompanyDAO();

		//Get the user's information from the database
		companyList = companyDAO.findById(companyId);
		
		
		return getInformation(companyList);
	}
	
	
	
	
	public static HashMap getInformation(Vector companyList)
	{
		HashMap hashMap = new HashMap();
		
		try 
		{
			
	        //There should only be one record for this userid
	        Company company = new Company();
	        
	        company = (Company) companyList.get(0);
	        
	             
	        hashMap.put("companyId", company.getCompanyId());
	        hashMap.put("companyName", company.getCompanyName());
	        hashMap.put("address1", company.getAddress1());
	        hashMap.put("address2", company.getAddress2());
	        hashMap.put("city", company.getCity());
	        hashMap.put("zip", company.getZip());
	        hashMap.put("defaultIndex", company.getDefaultIndex());
	       
	        
	        //get the state list and select the one that is accurate
	        FormInformation formInformation = new FormInformation();
	        String stateList = formInformation.getStatesInformation(company.getState());	      
	        hashMap.put("stateList", stateList);
			
			
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		
		return hashMap;
	}
		
	public static String processProfileUpdate(HttpServletRequest request)
	{
		CompanyDAO companyDAO = new CompanyDAO();		
		
		String verification = companyDAO.updateCompanyById(request.getParameter("comid"),  
				(String)request.getParameter("address1"), (String)request.getParameter("address2"), (String)request.getParameter("city"), 
				(String)request.getParameter("state"), (String)request.getParameter("zip"), (String)request.getParameter("indextype"));
		
		
		return verification;
	}
	
	
}
