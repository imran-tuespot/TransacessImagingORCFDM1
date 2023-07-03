package com.peniel.beans;


import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.dao.DropDownDAO;

public class getDropD {
	private static Logger logger = LogManager.getLogger(getDropD.class);
	
	public getDropD() {
	}
	
	public String getDoctype(String id) {
		String select = "select /*+ result_cache */ document_type from document_type where document_type_id = '"+id+"'";
		String output = "";
		String param = "document_type1";
		try {
			DropDownDAO dropDownDAO = new DropDownDAO();			
			output = dropDownDAO.findByQuery(param,select);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
        }
		return StringUtils.replace(output, "\\\\", "'");
	}
	
	public String getIndex(String id) {
		
		String select = "select /*+ result_cache */ index_type from index_type where index_type_id = '"+id+"'";
		String outputstr = "";
		String param = "index_type1";
		try {
			
			DropDownDAO dropDownDAO = new DropDownDAO();
			outputstr = dropDownDAO.findByQuery(param,select);
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
        }
		
		return outputstr;
	}	
	
public String getProperty(String id) {
		
		String select = "select /*+ result_cache */ property_id from property where id = '"+id+"'";
		String outputstr = "";
		String param = "property_type";
		try {
			
			DropDownDAO dropDownDAO = new DropDownDAO();
			outputstr = dropDownDAO.findByQuery(param,select);
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
        }
		
		return outputstr;
	}	

	
public String getFolder(String id) {
		
		String select = "select /*+ result_cache */ folder_name from folders where folder_id = '"+id+"'";
		String outputstr = "";
		String param = "folder_name1";
		try {
			
			DropDownDAO dropDownDAO = new DropDownDAO();
			outputstr = dropDownDAO.findByQuery(param,select);
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
        }
		System.out.println("outputstr --------------------------->"+outputstr);
		return StringUtils.replace(outputstr, "|", "");
	}

}
