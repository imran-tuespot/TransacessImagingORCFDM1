package com.peniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.peniel.bus.vo.SearchData;
import com.peniel.bus.vo.SearchDataObj;
import com.peniel.common.DAOHelper;
import com.peniel.database.DatabaseConnection;




public class SearchDataDAO extends DAOHelper<SearchData> 
{
	private static Logger logger = LogManager.getLogger(SearchDataDAO.class);
	public SearchDataDAO() {
        super("SearchDataDAO", SearchData.getSearchDataSQLHelper());
    }

	
/*	public static Vector findByProperty(String propertyName, String value) 
	{
		 ResultSet resultSet = null;
		 Vector searchDataList = new Vector();
		 
		 
		try 
		{
			String sqlStatement="select * from search_data where " + propertyName + " = '" + value + "'";
			logger.info("query : "+sqlStatement);

			searchDataList = getSearchDataList(DatabaseConnection.getResultSet(sqlStatement));

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return searchDataList;
	}*/
	public  Vector findByIndexVals(String propertyName, String value) 
	{
	 try {
         String sqlStatement = "select distinct(index_data) as index_data from Search_data where " + propertyName + " = '" + value + "'";
         System.out.println("query : " + sqlStatement);

         return processSelectMulti(sqlStatement);
     } catch (Exception e) {
         e.printStackTrace();
         logger.info("Error :" + e.getMessage());
         return null;
     }
	}
	public  Vector findByIndexValues(String comId,String indexType) 
	{
	 try {
         String sqlStatement = "select index_data from Search_data where  " + 
	                           " company_id = '" + comId + "' and index_type_id  = "+indexType+ " group by index_data" ;
         System.out.println("Time: "+Calendar.getInstance().getTime()+"query : " + sqlStatement);

         return processSelectMulti(sqlStatement);
     } catch (Exception e) {
         e.printStackTrace();
         logger.info("Error :" + e.getMessage());
         return null;
     }
	}

	public  Vector findByProperty(String propertyName, String value) 
	{
	 try {
         String sqlStatement = "select * from Search_data where " + propertyName + " = '" + value + "'";
         logger.info("query : " + sqlStatement);

         return processSelectMulti(sqlStatement);
     } catch (Exception e) {
         e.printStackTrace();
         logger.info("Error :" + e.getMessage());
         return null;
     }
	}
	public  Vector findByIndexId(String propertyName, String value,String cId) 
	{
	 try {
         String sqlStatement = "select * from Search_data where " + propertyName + " = '" + value + "'"+
        		 " and company_id='"+cId+"'";
         logger.info("query : " + sqlStatement);

         return processSelectMulti(sqlStatement);
     } catch (Exception e) {
         e.printStackTrace();
         logger.info("Error :" + e.getMessage());
         return null;
     }
	}
	 public Vector<SearchData> findBy(String propertyName, String value) {
	        try {
	            String sqlStatement = "select * from Search_data where " + propertyName + " = '" + value + "'";
	            logger.info("query : " + sqlStatement);

	            return processSelectMulti(sqlStatement);
	        } catch (Exception e) {
	            e.printStackTrace();
	            logger.info("Error :" + e.getMessage());
	            return null;
	        }
	    }

	public  Vector findByIndexData(String indexData) 
	{
		return findByProperty("INDEX_DATA", indexData);
	}
	
	public  Vector findByDocId(long indexData)
	{
		return findByProperty("DOCUMENT_ID", ""+indexData);
	}

	public  SearchData findById(Long searchDataId)
	{
		ResultSet resultSet = null;
		 Vector searchDataList = new Vector();
		 SearchData searchData = null;
		 
		 
		try 
		{
			String sqlStatement="select * from index_type where index_type_id = " + searchDataId ;
			logger.info("query : "+sqlStatement);

			searchDataList = getSearchDataList(DatabaseConnection.getResultSet(sqlStatement));
			searchData = (SearchData)searchDataList.get(0);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return searchData;
	}
	
	
	public static Vector findByQuery(String sqlStatement, String module)
	{
		Vector searchDataList = new Vector();
		 		 
		try 
		{
			logger.info("query : "+sqlStatement);
			
			if(module.equals("search")){
				searchDataList = getFileList(DatabaseConnection.getResultSet(sqlStatement));
			}
			
			if(module.equals("docMgmt")){
				searchDataList = getDocList(DatabaseConnection.getResultSet(sqlStatement));
			}
			
			if(module.equals("docMgmtList")){
				searchDataList = getDocList(DatabaseConnection.getResultSet(sqlStatement));
			}

			if(module.equals("docProfile")){
				searchDataList = getSearchData(DatabaseConnection.getResultSet(sqlStatement));
			}
			if(module.equals("docMgmtFolderView")){
				searchDataList = getDocList(DatabaseConnection.getResultSet(sqlStatement));
			}
			
			if(module.equals("docMgmtFolderSearch")){
				searchDataList = getDocLists(DatabaseConnection.getResultSet(sqlStatement));
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return searchDataList;
	}
	
	
	public static Vector getSearchDataList(Vector hashMapList)
	{
		Vector searchDataList = null;
		SearchData searchData;
		
		searchDataList = new Vector();
        try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
    			
			   searchData = new SearchData();
			   searchData.setCompanyId(Long.parseLong((String)hashMap.get("company_id".toUpperCase())));
			   searchData.setDocumentId(Long.parseLong((String)hashMap.get("document_id".toUpperCase())));
			   searchData.setIndexData((String)hashMap.get("index_data".toUpperCase()));
			   searchData.setIndexTypeId(Long.parseLong((String)hashMap.get("index_type_id".toUpperCase())));
			   searchDataList.add(searchData);
			}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return searchDataList;
	}

	public static Vector getFileList(Vector hashMapList)
	{
		Vector searchDataList = null;
		SearchDataObj searchDataObj;
		
		searchDataList = new Vector();
        try 
        {
        	int i = 1;
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			searchDataObj = new SearchDataObj();
			    searchDataObj.setSrNo(i);
				searchDataObj.setFileName((String)hashMap.get("FILENAME"));
				searchDataObj.setDocumentType((String)hashMap.get("DOCUMENT_TYPE"));
				searchDataObj.setIndexType((String)hashMap.get("INDEX_TYPE"));
				searchDataObj.setIndexValue((String)hashMap.get("VALUE"));
				int version = Integer.parseInt((String)hashMap.get("VERSION"));
				searchDataObj.setVersion(version);

				i++;
			   
			    searchDataList.add(searchDataObj);
			}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return searchDataList;
	}

	public static Vector getDocId(Vector hashMapList)
	{
		Vector searchDataList = null;
		SearchDataObj searchDataObj;
		
		searchDataList = new Vector();
        try 
        {
        	int i = 1;
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			searchDataObj = new SearchDataObj();
			    
				int docId = Integer.parseInt((String)hashMap.get("DOCUMENT_ID"));
				searchDataObj.setDocId(docId);
				
				i++;
			   
			   searchDataList.add(searchDataObj);
			}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
				
		return searchDataList;
	}

	
	public static Vector getDocList(Vector hashMapList)
	{
		Vector searchDataList = null;
		SearchDataObj searchDataObj;
		
		searchDataList = new Vector();
        try 
        {
        	int i = 1;
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			searchDataObj = new SearchDataObj();
			    searchDataObj.setSrNo(i);
				searchDataObj.setFileName((String)hashMap.get("FILENAME"));
				searchDataObj.setFolderName((String)hashMap.get("FOLDER_NAME"));
				//searchDataObj.setFolderIds((String)hashMap.get("FOLDER_IDS"));
				searchDataObj.setActualFileName((String)hashMap.get("ACTUALFILENAME"));

					
				searchDataObj.setDocumentType((String)hashMap.get("DOCUMENT_TYPE"));
				searchDataObj.setIndexType((String)hashMap.get("INDEX_TYPE"));
				searchDataObj.setIndexValue((String)hashMap.get("VALUE"));
				
				int version = Integer.parseInt((String)hashMap.get("VERSION"));
				searchDataObj.setVersion(version);

				int docId = Integer.parseInt((String)hashMap.get("DOCUMENT_ID"));
				searchDataObj.setDocId(docId);
				
				searchDataObj.setIndexTypeId((String)hashMap.get("INDEX_TYPE_ID"));
				
				int docTypeId = Integer.parseInt((String)hashMap.get("DOCUMENT_TYPE_ID"));
				searchDataObj.setDocTypeId(docTypeId);
				
				i++;
			   
			   searchDataList.add(searchDataObj);
			}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
				
		return searchDataList;
	}
	
	public static Vector getDocLists(Vector hashMapList)
	{
		Vector searchDataList = null;
		SearchDataObj searchDataObj;
		
		searchDataList = new Vector();
        try 
        {
        	int i = 1;
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
    			searchDataObj = new SearchDataObj();
			    searchDataObj.setSrNo(i);
				searchDataObj.setFileName((String)hashMap.get("FILENAME"));
								
				i++;
			   
			   searchDataList.add(searchDataObj);
			}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
				
		return searchDataList;
	}

	
	public static Vector getSearchData(Vector hashMapList)
	{
		Vector searchDataList = null;
		SearchData searchData;
		
		searchDataList = new Vector();
        try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    		   HashMap hashMap = new HashMap();
    		   hashMap = (HashMap)hashMapList.get(y);
    			
			   searchData = new SearchData();
			   searchData.setCompanyId(Long.parseLong((String)hashMap.get("COMPANY_ID")));
			   searchData.setDocumentId(Long.parseLong((String)hashMap.get("DOCUMENT_ID")));
			   searchData.setIndexData((String)hashMap.get("INDEX_TYPE")+"^"+(String)hashMap.get("INDEX_DATA"));
			   searchData.setIndexTypeId(Long.parseLong((String)hashMap.get("INDEX_TYPE_ID")));
			   //logger.info("rowid -->"+(String)hashMap.get("rowid")+"<--");
			   searchData.setRowid((String)hashMap.get("ROWID"));
			   searchDataList.add(searchData);
			}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return searchDataList;
	}

	/*
	public void editDocProfile(Vector vector, String docId, String comid, String sessionid, String doctype) throws Exception
	{
		DatabaseConnection dbConnection = new DatabaseConnection();
		int documentId = 0;
		try{
			String sqlStatement="DELETE FROM SEARCH_DATA ";
			sqlStatement +="WHERE DOCUMENT_ID = "+docId+" AND COMPANY_ID = "+comid;
					
			logger.info("query : "+sqlStatement);
			dbConnection.executeUpdate(sqlStatement);
			
			for(int i=0; i<vector.size(); i++){
				
				String indexIdVal = (String)vector.get(i);
				
				String indexId = indexIdVal.substring(0, indexIdVal.indexOf("^"));
				
				String val = indexIdVal.substring(indexIdVal.indexOf("^")+1, indexIdVal.length());
				
				//dbConnection.setCommit(false);
				
							
				sqlStatement = "INSERT INTO SEARCH_DATA ";
				sqlStatement +="VALUES ("+indexId+", "+docId+", "+comid+", '"+val+"')";
				
				logger.info("query : "+sqlStatement);
				dbConnection.executeUpdate(sqlStatement);
				
				
				//dbConnection.doCommit();
				//dbConnection.setCommit(true);

			}
			
			
			
			//sqlStatement = "UPDATE DOCUMENT_DATA SET ";
			//sqlStatement +=" DOCUMENT_TYPE_ID = '"+doctype+"', LAST_SESSION_ID ='"+sessionid+"' WHERE DOCUMENT_ID = "+docId+" AND COMPANY_ID = "+comid+"";
			
			
			sqlStatement = "UPDATE DOCUMENT_DATA SET ";
			sqlStatement +=" DOCUMENT_TYPE_ID = '"+doctype+"', LAST_SESSION_ID ='"+sessionid+"' WHERE DOCUMENT_ID = "+docId+" AND COMPANY_ID = "+comid+"";
			sqlStatement +=" AND VERSION = (SELECT MAX(VERSION) FROM DOCUMENT_DATA WHERE DOCUMENT_ID = "+docId+" ) ";
			
			logger.info("query : "+sqlStatement);
			dbConnection.executeUpdate(sqlStatement);
			
		}
		catch (Exception e) 
		{
			logger.info("Error in editDocProfile :"+e.getMessage());
			e.printStackTrace();
			
			throw e;
		}
		
	}

	*/

	public void editDocProfile(Vector vector, String docId, String comid, String sessionid, String doctype, String propertyId, String[] folderIds,String transactionType,String transactionDate,String transactionStatus) throws Exception
	{
		DatabaseConnection dbConnection = new DatabaseConnection();
		int documentId = 0;
		Vector searchDataList = new Vector();
		 SearchData searchData = null;
		 
		// transactionStatus="Approved";

		try{
			String sqlStatement ="";
			for(int i=0; i<vector.size(); i++){
				
				String indexIdVal = (String)vector.get(i);
				logger.info("indexIdVal --->"+indexIdVal+"<---");
				String indexId = indexIdVal.substring(0, indexIdVal.indexOf("^"));
				
				String val = indexIdVal.substring(indexIdVal.indexOf("^")+1, indexIdVal.lastIndexOf("^"));
				
				String rowid = indexIdVal.substring(indexIdVal.lastIndexOf("^")+1, indexIdVal.length());
				logger.info("rowid --->"+rowid+"<---");
	            if(val !=null && ! "Select FHA Number".equals(val) && !"".equals(val.trim())) {

				if(!"".equals(rowid) && rowid != null){
					
					sqlStatement="UPDATE SEARCH_DATA ";
					sqlStatement +="SET  INDEX_TYPE_ID = "+indexId+" , INDEX_DATA = '"+val+"'";
					sqlStatement +=" WHERE DOCUMENT_ID = "+docId+" AND @rowid := '"+rowid+"'";
					
					logger.info("query : "+sqlStatement);
					dbConnection.executeUpdate(sqlStatement);
				}
				else {
					sqlStatement = "INSERT INTO SEARCH_DATA ";
					sqlStatement += "(INDEX_TYPE_ID, DOCUMENT_ID, COMPANY_ID, INDEX_DATA) ";
					sqlStatement +="VALUES ("+indexId+", "+docId+", "+comid+", '"+val+"')";
					
					logger.info("query : "+sqlStatement);
					dbConnection.executeUpdate(sqlStatement);
				}
	            }
				
			}
			/*
			sqlStatement = "UPDATE DOCUMENT_DATA SET ";
			sqlStatement +=" DOCUMENT_TYPE_ID = '"+doctype+"', PROPERTY_ID = '"+propertyId+"', FOLDER_ID = '"+folderId+"', LAST_SESSION_ID ='"+sessionid+"' WHERE DOCUMENT_ID = "+docId+" AND COMPANY_ID = "+comid+"";
			sqlStatement +=" AND VERSION = (SELECT MAX(VERSION) FROM DOCUMENT_DATA WHERE DOCUMENT_ID = "+docId+" ) ";
			*/
			
    	    System.out.println("transactionStatus==>"+transactionStatus.trim()+"<==" );
    		
			sqlStatement = "UPDATE DOCUMENT_DATA SET ";
			sqlStatement +=" DOCUMENT_TYPE_ID = '"+doctype+"', PROPERTY_ID = '"+propertyId+"'";
			if(!StringUtils.isEmpty(transactionType))
			sqlStatement += ",TRANSACTION_TYPE_ID = '"+transactionType+"'";
			if( !StringUtils.isEmpty(transactionDate))
			sqlStatement +=",TRANSACTION_DATE= str_to_date('"+transactionDate+"','%m/%d/%Y')";
			if(!StringUtils.isEmpty(transactionStatus.trim()))
			sqlStatement +=",TRANSACTION_STATUS = '"+transactionStatus+"'";
			
			
			
			sqlStatement +=", LAST_SESSION_ID ='"+sessionid+"' WHERE DOCUMENT_ID = "+docId+" AND COMPANY_ID = "+comid+"";
			sqlStatement +=" AND VERSION = (select * from (SELECT MAX(VERSION) FROM DOCUMENT_DATA WHERE DOCUMENT_ID = "+docId+" )as t) ";
			
			logger.info("query : "+sqlStatement);
			dbConnection.executeUpdate(sqlStatement);
			
			sqlStatement = "DELETE FROM DOCUMENT_FOLDERS WHERE DOCUMENT_ID = "+docId+" AND COMPANY_ID = "+comid+" ";
			logger.info("query : "+sqlStatement);
			dbConnection.executeUpdate(sqlStatement);
			for(String folderId:folderIds){
			sqlStatement = "INSERT INTO DOCUMENT_FOLDERS (DOCUMENT_ID, COMPANY_ID, FOLDER_ID) VALUES ("+docId+","+comid+",'"+folderId+"') ";
			logger.info("query : "+sqlStatement);
			dbConnection.executeUpdate(sqlStatement);
			}
			
			
		}
		catch (Exception e) 
		{
			logger.info("Error in editDocProfile :"+e.getMessage());
			e.printStackTrace();
			
			throw e;
		}
		
	}


	public String getTransactionType(String transactionType) {
		DatabaseConnection databaseConnection=new DatabaseConnection();
		Connection  conn=null;
		Statement st = null;
		ResultSet rs=null;
		 String transactionTypeid =null;
		 
		String sqlStatement = "select transaction_type_id FROM TRANSACTION_TYPE WHERE TRANSACTION_TYPE like '%"+transactionType+"%'";
		  System.out.println(sqlStatement);
		try {
		conn = databaseConnection.getDBConnection();
		  st = conn.createStatement();
		   rs = st.executeQuery(sqlStatement);
		   while ( rs.next() ) {
			   transactionTypeid = rs.getString("transaction_type_id");
              
           }
		   System.out.println(transactionTypeid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				st.close();
				conn.close();
				databaseConnection.disconnectdb();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		}
		return transactionTypeid;
	}

	
}



