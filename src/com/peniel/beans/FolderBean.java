package com.peniel.beans;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import com.peniel.bus.vo.Folder;
import com.peniel.common.PenielException;
import com.peniel.dao.FolderDAO;
import com.peniel.dao.PropertyDAO;


public class FolderBean 
{
	FolderDAO folderDao = new FolderDAO();
	Folder folderData = new Folder();
    // Vector indexTypeList = new Vector();
	public String getFolderName(String folderId, String cId)
	{/*
		 * String folderName = ""; folderData =
		 * folderDao.findByIdCompany(folderId, cId);
		 * 
		 * folderName = folderData.getFolderName(); return folderName;
		 */
		Vector folders = new Vector();

		String folderName = "";
		if (folderId.contains("/")) {
			if (!folderId.endsWith("/")) {
				folderId = folderId + "/";
			}
			folders = folderDao.findByFolderNames(folderId);
			if (!folders.isEmpty()) {
				folderName = folderId;
			}

		} else {
			folderData = folderDao.findByIdCompany(folderId, cId);
			folderName = folderData.getFolderName();
		}

		return folderName;

	}
	public void insertFolderName(String folderId, String cId)
	{
               try {
				folderDao.insertFolder(cId,folderId);
			} catch (PenielException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	  //	folderName = folderData.getFolderName();
	  	//return folderName;
	}
	/*public static String getFolderNameGridHTML(String cId,String folderPatteren)
	{
		Vector folderList = new Vector();
		StringBuffer htmlGrid = new StringBuffer();
		FolderDAO folderDAO = new FolderDAO();
		Folder folder = new Folder();
		//Get the projects from the database
		folderList = folderDAO.findBy("Company_ID",cId,"Folder_Name",folderPatteren);		
		
		 String html = "";
         for(int i=0; i< folderList.size(); i++)
         {
         	
         	if(((Folder)folderList.get(i)).getFolderName() != null)
              html += ((Folder)folderList.get(i)).getFolderName()+",";

         }
         //System.out.println("FolderBean html------> "+html);
         

		
	return html;
	}*/
	
	public static List<String> getFolderNameGridHTML(String cId,String folderPatteren)
	{
		List<String> folderList = new ArrayList<String>();
		StringBuffer htmlGrid = new StringBuffer();
		FolderDAO folderDAO = new FolderDAO();
		Folder folder = new Folder();
		//Get the projects from the database
		//folderList = folderDAO.findBy("Company_ID",cId,"Folder_Name",folderPatteren);	
		if(!StringUtils.isEmpty(folderPatteren)){
		folderList = folderDAO.findByFolder("Company_ID",cId,"Folder_Name",folderPatteren);	
		System.out.println("folderList"+folderList.size());
		
		}
	return folderList;
	}
	
	/*public static Integer findByDataDocFolder(String cId,String folderPatteren)
	{
	     int count=0;
		FolderDAO folderDAO = new FolderDAO();
		Folder folder = new Folder();
		//Get the projects from the database
		//folderList = folderDAO.findBy("Company_ID",cId,"Folder_Name",folderPatteren);		
		if(!StringUtils.isEmpty(folderPatteren)){
		count = folderDAO.findByDataDocFolder(cId,folderPatteren);	
		System.out.println("Document List"+count);
		}
		
	return count;
	}*/
	
	public static Map<String,Integer> findByDataDocFolderMap(String cId,List<String> folderList)
	{
	      
		FolderDAO folderDAO = new FolderDAO();
		System.out.println(folderList+"==========folderList============"+folderList.size());
		if(folderList.size() > 0) {
    	 Map<String,Integer> countMap=folderDAO.findByDataDocFolder(cId,folderList);

    	 System.out.println("Document List123 Latest"+countMap);
		
		
	
	return countMap;
		}
		return null;
	}
	
	public static List<String> getPropertyNameGridHTML(String cId,String folderPatteren)
	{
		List<String> folderList = new ArrayList<String>();
		PropertyDAO propertyDao = new PropertyDAO();
		List<String> properties = propertyDao.findPropertiesdata("" + cId);

		System.out.println("properties List" + properties.size());

		/*for (Property property : properties) {

			folderList.add(property.getPropertyId());

		}*/

		return properties;
	}
	
	
	public static String[] splitString(String list,String delimiter) 
	{
		String[] temp;		 
		temp = list.split(delimiter);
		return temp;
	}
	
	public HashMap<String, Integer> sortHashMapByValues(
	        HashMap<String, Integer> passedMap) {
	    List<String> mapKeys = new ArrayList<String>(passedMap.keySet());
	    List<Integer> mapValues = new ArrayList<Integer>(passedMap.values());
	    Collections.sort(mapValues);
	    Collections.sort(mapKeys);

	    HashMap<String, Integer> sortedMap =
	        new HashMap<String, Integer>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        int val = valueIt.next();
	        Iterator<String> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	        	String key = keyIt.next();
	            int comp1 = passedMap.get(key);
	            int comp2 = val;

	            if (comp1==(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}
	
}

