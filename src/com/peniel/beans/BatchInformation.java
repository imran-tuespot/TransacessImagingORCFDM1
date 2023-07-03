package com.peniel.beans;

import java.util.HashMap;
import java.util.Vector;

import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.AppUserRoles;
import com.peniel.bus.vo.BatchUpload;
import com.peniel.dao.AppUserRolesDAO;
import com.peniel.dao.BatchUploadDAO;

public class BatchInformation {
	public static HashMap getUserBatchInformation(String userid,String cId)
	{
		HashMap hashMap = new HashMap();
		
		Vector usersBatchList = new Vector();
		BatchUploadDAO batchUploadDAO = new BatchUploadDAO();

		//Get the user's batch information from the database
        usersBatchList = batchUploadDAO.findByUserId("USER_ID",userid,cId);
		
		
		return getInformation(usersBatchList);
	}
	public static HashMap getInformation(Vector usersBatchList)
	{
		HashMap hashMap = new HashMap();
		System.out.println("hashMap.size() in BatchInformation.java"+hashMap.size());
		try 
		{			
	        //There should only be one record for this userid
	        BatchUpload batchUpload = new BatchUpload();
	        System.out.println("usersBatchList.size()----> "+usersBatchList.size() );
	        if(usersBatchList.size() > 0)
	        {
	        	
				for(int i=0; i < usersBatchList.size(); i++ )
				{
			        batchUpload = (BatchUpload) usersBatchList.get(i);        
			             
			        hashMap.put("uploadDate"+i, batchUpload.getUploadDate());
			        hashMap.put("processDate"+i, batchUpload.getProcessDate());
			        hashMap.put("status"+i, batchUpload.getStatus());	     
			        hashMap.put("batchFilename"+i, batchUpload.getBatchFilename());
				}
	        }
			
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("hashMap.size() in BatchInformation.java"+hashMap.size());
		return hashMap;
	}

}
