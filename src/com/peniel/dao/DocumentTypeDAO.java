package com.peniel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.DocumentType;
import com.peniel.common.DAOHelper;
import com.peniel.common.DBManager;
import com.peniel.common.DbManagerValues;
import com.peniel.common.PenielException;
import com.peniel.database.DatabaseConnection;


public class DocumentTypeDAO extends DAOHelper<DocumentType> {
    private static Logger logger = LogManager.getLogger(DocumentTypeDAO.class);

    public DocumentTypeDAO() {
        super("DocumentTypeDAO", DocumentType.getDocumentTypeSQLHelper());
    }

    public Vector<DocumentType> findByDocumentType(String documentType) {
        return findByProperty("DOCUMENT_TYPE", documentType);
    }

    public Vector<DocumentType> findByCompanyId(String documentType) {
        return findByProperty("COMPANY_ID", documentType);
    }
    public Vector<DocumentType> findByCompanyId1(String documentType) {
        return findByProperty1("COMPANY_ID", documentType);
    }

    public Vector<DocumentType> findByDocumentTypeId(String documentType) {
        return findByProperty("DOCUMENT_TYPE_ID", documentType);
    }

    public DocumentType findByDocumentNameAndCompany(String documentType, String compId) {
        try {
            String sql = "Select Company_id, Document_type_id, document_type from document_type where " +
                "company_id = " + compId + " AND upper(Document_type) = '" + documentType.toUpperCase() + "'";

            return processSelectSingle(sql);
        } catch (PenielException e) {
            return null;
        }
    }

    public void insertNewDocType(String companyId, String value) throws PenielException {
       // long id = getNextId("document_type_seq");
        executeInsert("insert into document_type (Company_id, Document_type_id, document_type) values " +
                "(" + companyId + ", null" + ", '" + value + "')");
    }
    public  Boolean DeleteDocumentType(String companyId,String docType )
	{
		DatabaseConnection dbConnection = new DatabaseConnection();
		try {		
					
			/*  delete indexType */
			String sqlStatement =" delete from DOCUMENT_TYPE where company_id="+companyId+" and document_type ='" + docType+"'";
			logger.info("sqlStatement: "+sqlStatement);			
			int rowCount = dbConnection.execute_Update(sqlStatement);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
			return false;
		}
		return true;
	}
    
    public  Boolean editDocumentType(String companyId,String newDocType, String oldDocType )
   	{
   		DatabaseConnection dbConnection = new DatabaseConnection();
   		try {		
   					
   			/*  delete indexType */
   			String sqlStatement =" Update DOCUMENT_TYPE set document_type = '"+newDocType+ "' where company_id="+companyId+" and document_type ='" + oldDocType+"'";
   			logger.info("sqlStatement: "+sqlStatement);			
   			int rowCount = dbConnection.execute_Update(sqlStatement);
   			
   			
   			
   		} catch (Exception e) {
   			e.printStackTrace();
   			logger.info("Error :"+e.getMessage());
   			return false;
   		}
   		return true;
   	}

    public Collection<DocumentType> getDocumentTypes(int companyId) {
		List<DocumentType> documentTypes;
		
		documentTypes = new ArrayList<DocumentType>();
    	
    	String sqlStatement = "select *  from Document_Type where  company_id =" + companyId ;
    	logger.info("query : " + sqlStatement);
        try{
        	Vector<DocumentType> documentType = processSelectMulti(sqlStatement);
        	
        	for(int i=0; i<documentType.size(); i++){
        		documentTypes.add((DocumentType)documentType.get(i));
        	}
        }catch(PenielException ex){
        	logger.info("Exception in getProperties -->"+ex.getMessage());
        }
       
        return documentTypes;
    }
    public Vector<DocumentType> getAllDocumentTypes(int companyId) {
		
    	Vector<DocumentType> documentType = new Vector();
    	String sqlStatement = "select *  from Document_Type where  company_id =" + companyId +" order by document_type" ;
    	logger.info("query : " + sqlStatement);
        try{
        	documentType = processSelectMulti(sqlStatement);
        	
        	
        }catch(PenielException ex){
        	logger.info("Exception in getProperties -->"+ex.getMessage());
        }
       
        return documentType;
    }
    public DocumentType findByIdCompany(String documentTypeId, String companyId)
	{
		ResultSet resultSet = null;
		 Vector indexTypeList = new Vector();
		 DocumentType documentType = null;
		 
		 
		try 
		{
			String sqlStatement="select * from document_type where document_type_id = '" + documentTypeId +"' and company_id = '"+companyId +"'";
			System.out.println("query  : "+sqlStatement);

			documentType = processSelectSingle(sqlStatement);
			//indexTypeList = getIndexTypeList(DatabaseConnection.getResultSet(sqlStatement));
			//indexType = (IndexType)indexTypeList.get(0);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return documentType;
	}
	
//    public Vector<DocumentType> findByProperty(String propertyName, String value) {
//        ResultSet resultSet = null;
//        Vector<DocumentType> documentTypeList = new Vector<DocumentType>();
//
//        try {
//            String sqlStatement = "select * from document_type where " + propertyName + " = '" + value + "'";
//            logger.info("query : " + sqlStatement);
//
//            documentTypeList = getDocumentTypeList(DatabaseConnection.getResultSet(sqlStatement));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.info("Error :" + e.getMessage());
//        }
//
//        return documentTypeList;
//    }
//
    public Vector findByIds(String documentTypeId, String companyId) {
       

       // String subDesc = "";
        Vector hashMapList = new Vector();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs= null;
        DBManager dbm=null;
        try {
        	dbm =DBManager.getInstance();
        	con=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
        	stmt=con.createStatement();

            /*
        	String sqlStatement = "	select sub_folder_id, sub_folder_name_1, sub_folder_name_2 from sub_folders where "
            		+ "sub_folder_id in (select sub_folder_id from doc_type_folder where company_id = '"+companyId +"' and document_type_id = '"+documentTypeId +"')";
            */
        	
        	String sqlStatement = "	select sub_folder_id, sub_folder_name_1, sub_folder_name_2 from doc_type_folder where "
            		+ "company_id = '"+companyId +"' and document_type_id = '"+documentTypeId +"' ";
        	
            logger.info("query : " + sqlStatement);
            
            
            rs=stmt.executeQuery(sqlStatement);
            Vector columnNames = new Vector();
            for(int y = 0; y < rs.getMetaData().getColumnCount(); y++)
	        {
	        	columnNames.addElement(rs.getMetaData().getColumnName(y + 1));
	        }

	        while (rs.next())
	        {
	        	HashMap hashMap = new HashMap();
	        	//now put the values in a hashmap column name/value
		        for(int z = 0; z < columnNames.size(); z++)
		        {
		        	//System.out.println("columnNames.get(z)-->"+columnNames.get(z)+"<-- resultSet.getString(z+1) -->"+rs.getString(z+1)+"<---");
		        	hashMap.put(columnNames.get(z), rs.getString(z+1));
		        	//logger.info("hashMap -->"+hashMap);
		        }
		        
		        hashMapList.addElement(hashMap);
	       
	        }
  
                        
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
        } finally {
       	 dbm.releaseConnection(DbManagerValues.CONN_SOURCE, con);
        }

        return hashMapList;
    }


    public String getDocumentTypeList(Vector hashMapList) {
        
        String subFolderName = "";
        
        try {
            for (int y = 0; y < hashMapList.size(); y++) {
                HashMap hashMap = new HashMap();
                hashMap = (HashMap) hashMapList.get(y);
       
                subFolderName = (String) hashMap.get("SUB_FOLDER_NAME");
                
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
        }


        return subFolderName;
    }

	public void insertNewDocTypeAndDocMaster(String cId, String documentType, String doctypemaster,String selectedfolder,int newFolderFlag,int folderId) throws PenielException {
		  executeInsert("insert into document_type (Company_id, Document_type_id, document_type,SUB_DOC_TYPE_ID) values " +
	                "(" + cId + ", null" + ", '" + documentType + "','"+doctypemaster+"')");
		if("1".equalsIgnoreCase(doctypemaster)){
			 double maxSubfolderId=0;
			if(newFolderFlag==0) {
				maxSubfolderId=folderId;
			}else {
				 maxSubfolderId=getMaxSubFolderId(cId);				
			}
			double maxDocTypeId=getMaxDocumentTypeId(cId);
		  executeInsert("insert into DOC_TYPE_FOLDER(COMPANY_ID, DOCUMENT_TYPE_ID, SUB_FOLDER_ID,SUB_FOLDER_NAME_1,SUB_FOLDER_NAME_2) values " +
	                "('" + cId + "',"+maxDocTypeId+","+maxSubfolderId+",'Production','"+selectedfolder+"')");
		}
	}

	private double getMaxDocumentTypeId(String cId) {
		 Connection con=null;
	        Statement stmt=null;
	        ResultSet rs= null;
	        DBManager dbm=null;
	        double maxdoctypeid=0;
	    	String sqlStatement = "select CAST(max(DOCUMENT_TYPE_ID) AS DOUBLE) AS DOCUMENT_TYPE_ID from Document_Type where  company_id =" + cId ;
	        try {
	        	dbm =DBManager.getInstance();
	        	con=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
	        	stmt=con.createStatement();
	        	rs=stmt.executeQuery(sqlStatement);
	        	if(rs.next()) {
	        		maxdoctypeid=rs.getDouble("DOCUMENT_TYPE_ID");
	        	}
	        			
    	logger.info("query : " + sqlStatement);
	        } catch (Exception e) {
	            e.printStackTrace();
	            logger.info("Error :" + e.getMessage());
	        } finally {
	       	 dbm.releaseConnection(DbManagerValues.CONN_SOURCE, con);
	        }
	        return maxdoctypeid;
	}
	
	private double getMaxSubFolderId(String cId) {
		 Connection con=null;
	        Statement stmt=null;
	        ResultSet rs= null;
	        DBManager dbm=null;
	        double maxSubfolderId=0;
	    	String sqlStatement = "select CAST(max(SUB_FOLDER_ID) AS DOUBLE) AS SUB_FOLDER_ID from DOC_TYPE_FOLDER where  company_id =" + cId ;
	        try {
	        	dbm =DBManager.getInstance();
	        	con=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
	        	stmt=con.createStatement();
	        	rs=stmt.executeQuery(sqlStatement);
	        	if(rs.next()) {
	        		maxSubfolderId=rs.getDouble("SUB_FOLDER_ID")+1;
	        	}
	        			
   	logger.info("query : " + sqlStatement);
	        } catch (Exception e) {
	            e.printStackTrace();
	            logger.info("Error :" + e.getMessage());
	        } finally {
	       	 dbm.releaseConnection(DbManagerValues.CONN_SOURCE, con);
	        }
	        return maxSubfolderId;
	}

	public Vector getAllDocumentTypes(int comid, String doctypeId) {
		
    	Vector<DocumentType> documentType = new Vector();
    	String sqlStatement = "select *  from Document_Type where  company_id =" + comid ;
    	if(doctypeId != null) {
    	sqlStatement+=" and SUB_DOC_TYPE_ID='"+doctypeId+"'";
    	}
    	sqlStatement+= " order by document_type" ;
    	logger.info("query : " + sqlStatement);
        try{
        	documentType = processSelectMulti(sqlStatement);
        	
        	
        }catch(PenielException ex){
        	logger.info("Exception in getProperties -->"+ex.getMessage());
        }
       
        return documentType;
	}
	
}


