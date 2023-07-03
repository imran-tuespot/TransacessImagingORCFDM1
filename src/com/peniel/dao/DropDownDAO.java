package com.peniel.dao;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.database.DatabaseConnection;




public class DropDownDAO
{
	private static Logger logger = LogManager.getLogger(DropDownDAO.class);
	
	public static String findByQuery(String param, String sqlStatement)
	{
		String outputStr = "";
		 		 
		try 
		{
			//logger.info("query : "+sqlStatement);
			System.out.println("query : "+sqlStatement);
			
			if(param.equals("document_count")){
				outputStr = getDocumentCount(DatabaseConnection.getResultSet(sqlStatement));
			}
			
			if(param.equals("index_type")){
				outputStr = getIndexDropDownValues(DatabaseConnection.getResultSet(sqlStatement));
			}
			
			if(param.equals("index_type1")){
				outputStr = getIndexDropDownValues1(DatabaseConnection.getResultSet(sqlStatement));
			}
			
			if(param.equals("document_type")){
					outputStr = getDocDropDownValues(DatabaseConnection.getResultSet(sqlStatement));
			}	
			if(param.equals("document_type1")){
				outputStr = getDocDropDownValues1(DatabaseConnection.getResultSet(sqlStatement));
			}	
			
			if(param.equals("property_id")){
				outputStr = getPropertyDropDownValues(DatabaseConnection.getResultSet(sqlStatement));
			}
			if(param.equals("property_type")){
				outputStr = getPropertyDropDownValues1(DatabaseConnection.getResultSet(sqlStatement));
			}
			if(param.equals("folder_id")){
				outputStr = getFolderDropDownValues(DatabaseConnection.getResultSet(sqlStatement));
			}
			if(param.equals("folder_id1")){
				outputStr = getFolderDropDownValues1(DatabaseConnection.getResultSet(sqlStatement));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return outputStr;
	}
	
	public static String getPropertyDropDownValues1(Vector hashMapList)
	{
		String  dropDownVals = "";
		try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			dropDownVals += (String)hashMap.get("PROPERTY_ID");
    			logger.debug("Property dropDownVals -->"+dropDownVals);
    		}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return dropDownVals;
	}
	
	
	public static String getDocumentCount(Vector hashMapList)
	{
		String  countValues = "";
		try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
    			
    			
    			String projects = "";
    			projects = (String)hashMap.get("NO_OF_PROJECTS");
    			
    			String documents = "";
    			documents = (String)hashMap.get("NO_OF_DOCUMENTS");
    			
    			String pages = "";
    			pages = (String)hashMap.get("NO_OF_PAGES");
    			
    			DecimalFormat myFormatter = new DecimalFormat("###,###.###");
    			
    			if(projects != null && !projects.equals("")){
    			   	projects = myFormatter.format(Double.parseDouble(projects));
    			}
    			
    			if(documents != null && !documents.equals("")){
    				documents = myFormatter.format(Double.parseDouble(documents));
    			}
    			
    			if(pages != null && !pages.equals("")){
    				pages = myFormatter.format(Double.parseDouble(pages));
    			}
    			
    			countValues += projects+"^"+documents+"^"+pages+"|";
    			logger.info("countValues -->"+countValues);
    		}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return countValues;
	}
	
	
	public static String getIndexDropDownValues(Vector hashMapList)
	{
		String  dropDownVals = "";
		try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			dropDownVals += (String)hashMap.get("INDEX_TYPE")+"^"+(String)hashMap.get("INDEX_TYPE_ID")+"|";
    			logger.debug("dropDownVals -->"+dropDownVals);
    		}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return dropDownVals;
	}
	
	public static String getIndexDropDownValues1(Vector hashMapList)
	{
		String  dropDownVals = "";
		try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			dropDownVals += (String)hashMap.get("INDEX_TYPE");
    			logger.debug("dropDownVals -->"+dropDownVals);
    		}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return dropDownVals;
	}

	
	public static String getDocDropDownValues(Vector hashMapList)
	{
		String  dropDownVals = "";
		try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			dropDownVals += (String)hashMap.get("DOCUMENT_TYPE")+"^"+(String)hashMap.get("DOCUMENT_TYPE_ID")+"|";
    			logger.debug("dropDownVals -->"+dropDownVals);
    		}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return dropDownVals;
	}
	
	public static String getDocDropDownValues1(Vector hashMapList)
	{
		String  dropDownVals = "";
		try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			dropDownVals = (String)hashMap.get("DOCUMENT_TYPE");
    			logger.debug("dropDownVals -->"+dropDownVals);
    		}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return dropDownVals;
	}
	
	public static String getFolderDropDownValues(Vector hashMapList)
	{
		String  dropDownVals = "";
		try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			dropDownVals += (String)hashMap.get("FOLDER_NAME")+"^"+(String)hashMap.get("FOLDER_ID")+"|";
    			logger.debug("FOLDER dropDownVals -->"+dropDownVals);
    		}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return dropDownVals;
	}
	
	public static String getPropertyDropDownValues(Vector hashMapList)
	{
		String  dropDownVals = "";
		try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			dropDownVals += (String)hashMap.get("PROPERTY_ID")+"^"+(String)hashMap.get("ID")+"|";
    			logger.debug("Property dropDownVals -->"+dropDownVals);
    		}
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return dropDownVals;
	}
	
	public static String getFolderDropDownValues1(Vector hashMapList)
	{
		String  dropDownVals = "";
		try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			dropDownVals += (String)hashMap.get("FOLDER_NAME")+"|";
    			logger.debug("FOLDER dropDownVals -->"+dropDownVals);
    		}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return dropDownVals;
	}
	
	
	
	
	
}



