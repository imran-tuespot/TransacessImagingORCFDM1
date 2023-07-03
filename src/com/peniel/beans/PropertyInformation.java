package com.peniel.beans;



import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.peniel.bus.vo.Property;
import com.peniel.dao.PropertyDAO;

public class PropertyInformation 
{
	public static HashMap getPropertyInformation(HttpServletRequest request)
	{
		HashMap hashMap = new HashMap();
		
		Vector propertyList = new Vector();
		PropertyDAO propertyDAO = new PropertyDAO();
		
		//Get the property information from the database
		if(request.getAttribute("propertyId").toString() != null && request.getAttribute("propertyId").toString() != "NA")
		{
			//System.out.println("Property ID = "+request.getAttribute("propertyId").toString());
			propertyList = propertyDAO.findByProperty("PROPERTY_ID",request.getAttribute("propertyId").toString());        
			//System.out.println("Property List before method "+propertyList.size());
			hashMap =  getInformation(propertyList);
		}
		
		return hashMap;
	}
	
	public static HashMap getPropertyDetails(HttpServletRequest request)
	{
		HashMap hashMap = new HashMap();
		
		Vector propertyList = new Vector();
		PropertyDAO propertyDAO = new PropertyDAO();
		
		//Get the property information from the database
		if(request.getParameter("id").toString() != null)
		{
			propertyList = propertyDAO.findByProperty("ID",request.getParameter("id").toString());        
			//System.out.println("Property List before method "+propertyList.size());
			hashMap =  getInformation(propertyList);
		}
		
		return hashMap;
	}
	
	/*public static HashMap getpropertyInformation(String cId,String propertyId)
	{
		HashMap hashMap = new HashMap();
		
		Vector propertyList = new Vector();
		PropertyDAO propertyDAO = new PropertyDAO();

		//Get the user's information from the database
		propertyList = propertyDAO.findById(cId,propertyId);
		
		
		return getInformation(propertyList);
	}*/
	
	
	
	
	public static HashMap getInformation(Vector propertyList)
	{
		HashMap hashMap = new HashMap();
		
		try 
		{
			
	        //There should only be one record for this propertyid
	        Property property = new Property();
	        
	        property = (Property) propertyList.get(0);
	       // System.out.println("Property List len "+propertyList.size());
	       // System.out.println("accountExec "+property.getAccountExec());
	             
	        hashMap.put("companyId", property.getCompanyId());
	        hashMap.put("id", property.getId());  
	        hashMap.put("propertyId", property.getPropertyId());   
	        hashMap.put("accountExec", property.getAccountExec());
	        hashMap.put("activeDeacAssignment",property.getActiveDeacAssignment());
	        hashMap.put("city",property.getCity());
	        hashMap.put("congressionalArea",property.getCongressionalArea());
	        hashMap.put("fhaNum",property.getFhaNum());
	        hashMap.put("lenderName",property.getLenderName());
	        hashMap.put("lenderNum",property.getLenderNum());
	        hashMap.put("propertyName",property.getPropertyName());
	        hashMap.put("reacScore",property.getReacScore());
	        hashMap.put("servicerName",property.getServicerName());
	        hashMap.put("servicerNum",property.getServicerNum());
	        hashMap.put("troubleCode",property.getTroubleCode());
	        hashMap.put("workloadMgr",property.getWorkloadMgr());
	        hashMap.put("zip",property.getZip());
	        hashMap.put("state",property.getState());

	         
	        
	        //get the state list and select the one that is accurate
	        FormInformation formInformation = new FormInformation();
	        String stateList = formInformation.getStatesInformation(property.getState());	      
	        hashMap.put("stateList", stateList);
			
			
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		
		return hashMap;
	}
		
	
	
	
}
