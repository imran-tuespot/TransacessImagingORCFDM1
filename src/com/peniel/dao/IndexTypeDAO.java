package com.peniel.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

import com.peniel.bus.vo.DocumentType;
import com.peniel.common.DAOHelper;
import com.peniel.common.PenielException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.peniel.bus.vo.IndexType;
import com.peniel.database.DatabaseConnection;




public class IndexTypeDAO  extends DAOHelper<IndexType>
{
	private static Logger logger = LogManager.getLogger(IndexTypeDAO.class);

    public IndexTypeDAO() {
        super("IndexTypeDAO", IndexType.getIndexTypeSQLHelper());
    }

	public static Vector<IndexType> findIndexTypeByProperty(String propertyName, String value)
	{
		 ResultSet resultSet = null;
		 Vector indexTypeList = new Vector();


		try
		{
			String sqlStatement="select /*+ result_cache */ company_id,index_type,index_type_id from index_type where " + propertyName + " = '" + value + "'";
			logger.info("query : "+sqlStatement);

			indexTypeList = getIndexTypeList(DatabaseConnection.getResultSet(sqlStatement));

		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}

		return indexTypeList;
	}

	public Vector<IndexType> findByIndexType(String indexType)
	{
		return findByProperty("INDEX_TYPE", indexType);
	}
	
	public IndexType findById(Long indexTypeId)
	{
		ResultSet resultSet = null;
		 Vector indexTypeList = new Vector();
		 IndexType indexType = null;


		try
		{
			String sqlStatement="select * from index_type where index_type_id = " + indexTypeId ;
			logger.info("query : "+sqlStatement);

			indexTypeList = getIndexTypeList(DatabaseConnection.getResultSet(sqlStatement));
			indexType = (IndexType)indexTypeList.get(0);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}

		return indexType;
	}
	
	
	public IndexType findByIdCompany(String indexTypeId, String companyId)
	{
		ResultSet resultSet = null;
		 Vector indexTypeList = new Vector();
		 IndexType indexType = null;
		 
		 
		try 
		{
			String sqlStatement="select * from index_type where index_type_id = '" + indexTypeId +"' and company_id = '"+companyId +"'";
			logger.info("query  : "+sqlStatement);

            indexType = processSelectSingle(sqlStatement);
			//indexTypeList = getIndexTypeList(DatabaseConnection.getResultSet(sqlStatement));
			//indexType = (IndexType)indexTypeList.get(0);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return indexType;
	}
	
	public static Vector getIndexTypeList(Vector hashMapList)
	{
		Vector indexTypeList = null;
		IndexType indexType;

		indexTypeList = new Vector();
        try
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);


			   indexType = new IndexType();
			   indexType.setCompanyId(Long.parseLong((String)hashMap.get("COMPANY_ID")));
			   indexType.setIndexTypeId(Long.parseLong((String)hashMap.get("INDEX_TYPE_ID")));
			   indexType.setIndexType((String)hashMap.get("INDEX_TYPE"));

			   indexTypeList.add(indexType);
			}
		}
        catch (Exception e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}


		return indexTypeList;
	}
	
	public void InsertIndexType(String companyId,String indexType)throws PenielException 
	{
	        //long id = getNextId("index_type_seq");
	        executeInsert("insert into index_type (Company_id, Index_type_id, index_type) values " +
	                "(" + companyId + ", null" + ",'" + indexType + "')");
	    
	}

	public  Boolean DeleteIndexType(String companyId,String indexType )
	{
		DatabaseConnection dbConnection = new DatabaseConnection();
		try {		
					
			/*  delete indexType */
			String sqlStatement =" delete from INDEX_TYPE where company_id="+companyId+" and index_type ='" + indexType+"'";
			logger.info("sqlStatement: "+sqlStatement);			
			int rowCount = dbConnection.execute_Update(sqlStatement);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
			return false;
		}
		return true;
	}
	
}



