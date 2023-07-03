package com.peniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.peniel.common.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.DocumentData;
import com.peniel.database.DatabaseConnection;


public class DocumentFoldersDAO  {
    private static Logger logger = LogManager.getLogger(DocumentFoldersDAO.class);
    public static final String documentDataSeq = "DOCUMENT_SEQ";

    

    
/*
    public DocumentData findById(Long documentTypeId, Long documentId) {
        try {
            String sqlStatement = "select * from document_data where document_type_id = " + documentTypeId + " and document_id = " + documentId;
            logger.info("query : " + sqlStatement);

            return processSelectSingle(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            return null;
        }
    }
*/
	public String getFolderNames(String documentId)
	{
		ResultSet resultSet = null;
		
		String folderName = ""; 
		 
		try 
		{
			
			String sqlstr = "";
			sqlstr += "(SELECT GROUP_CONCAT(folder_name,'</br>') as FOLDER_NAME ";
            sqlstr += "FROM folders where folder_id in ";
            sqlstr += "(SELECT folder_id ";
            sqlstr += "FROM document_folders where document_id = '"+documentId+"')) ORDER BY folder_id ";
			
			logger.info("query : "+sqlstr);

			Vector vc = DatabaseConnection.getResultSet(sqlstr);
			for(int y = 0; y < vc.size(); y++)
			{
				HashMap hashMap = new HashMap();
    			hashMap = (HashMap)vc.get(y);
    			
    			folderName = (String)hashMap.get("FOLDER_NAME");
    			
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return folderName;
	}

}



