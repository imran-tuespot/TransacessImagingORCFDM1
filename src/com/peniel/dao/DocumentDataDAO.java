package com.peniel.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import com.peniel.beans.getDropD;
import com.peniel.bus.vo.DocRoles;
import com.peniel.bus.vo.DocumentData;
import com.peniel.bus.vo.Folder;
import com.peniel.common.DAOHelper;
import com.peniel.common.DBManager;
import com.peniel.common.DbManagerValues;
import com.peniel.common.PenielException;
import com.peniel.database.DatabaseConnection;


public class DocumentDataDAO extends DAOHelper<DocumentData> {
    private static Logger logger = LogManager.getLogger(DocumentDataDAO.class);
    public static final String documentDataSeq = "DOCUMENT_SEQ";
    ReentrantLock lock = new ReentrantLock();

    public DocumentDataDAO() {
        super("DocumentDataDAO", DocumentData.getDocumentDataSQLHelper());
    }


    public String getDocumentDataSeq() {
        return documentDataSeq;
    }

    public Vector<DocumentData> findByFilename(String filename) {
        return findByProperty("FILENAME", filename);
    }

    public Vector<DocumentData> findByDocumentId(String documentId) {
        return findByProperty("DOCUMENT_ID", documentId);
    }

    public Vector<DocumentData> findByProperty(String propertyName, String value) {
        try {
            String sqlStatement = "select * from DOCUMENT_DATA where " + propertyName + " = '" + value + "'";
            logger.info("query : " + sqlStatement);

            return processSelectMulti(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            return null;
        }
    }
    public Vector<DocumentData> findByDocTypeId(String propertyName, String value, String cId) {
        try {
            String sqlStatement = "select * from document_data where " + propertyName + " = '" + value + "'"+
            		 " and company_id="+cId;
            logger.info("query : " + sqlStatement);

            return processSelectMulti(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            return null;
        }
    }

    public Vector<DocumentData> findByProperty1(String propertyName, String value) {
        try {
            String sqlStatement = "select * from document_data where " + propertyName + " = '" + value + "' order by version";
            logger.info("query : " + sqlStatement);

            return processSelectMulti(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            return null;
        }
    }

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

	public DocumentData findFilenameByVersion(long documentId, long version)
	{
		ResultSet resultSet = null;
		Vector documentDataList = new Vector();
		DocumentData documentData = null;
		
		 
		try 
		{
			StringBuilder sqlStmt = new StringBuilder(500);
			sqlStmt.append("select DATE_FORMAT(CREATE_DATE,'%m-%d-%Y') as CREATE_DATE,ACTUALFILENAME,VERSION,COMPANY_ID,FILENAME,DOCUMENT_ID,DOCUMENT_TYPE_ID from DOCUMENT_DATA where document_id = ").append(documentId).
			   append(" and version = ").append(version);
			
			logger.info("query : findFilenameByVersion "+sqlStmt);

			documentDataList = getDocumentDataList(DatabaseConnection.getResultSet(sqlStmt.toString()));
			if(documentDataList.size()>0) {
				documentData = (DocumentData)documentDataList.get(0);
			}
			

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return documentData;
	}

    public DocumentData findByCompIdFileName(Long compId, String fileName) {
        try {
            String sqlStatement = "select * from document_data where company_id = '" + compId + "' and filename = '" + fileName + "'";
            logger.info("query : " + sqlStatement);

            return processSelectSingle(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            return null;
        }
    }

    public DocumentData findDocDetail(String docId, String compId, String status) {
        ResultSet resultSet = null;
        Vector documentDataList = new Vector();
        DocumentData documentData = null;
        String version = "";
        
        System.out.println("docID-----> "+docId + " compId "+compId + " status "+status);
        try {
            String sqlStatement = "SELECT * from (SELECT UDATE FROM (SELECT CREATE_DATE AS UDATE FROM DOCUMENT_DATA WHERE DOCUMENT_ID = " + docId + " ORDER BY CREATE_DATE DESC)as cdate limit 1)as UDATE,  ";

            if ("Active".equals(status)) version = "MAX(version)";
            if ("Inactive".equals(status)) version = "MIN(version)";

            sqlStatement += " (select " + version + " as VERSION from DOCUMENT_DATA  where DOCUMENT_ID = " + docId + " AND COMPANY_ID = " + compId + ")as VERSION, ";
           // sqlStatement += " (select folder_id from document_data  where DOCUMENT_ID = " + docId + " AND COMPANY_ID = " + compId + " and version = (select " + version + " from document_data  where DOCUMENT_ID = " + docId + " AND COMPANY_ID = " + compId + ")) FOLDER_ID, ";
            sqlStatement += "  (SELECT DOCUMENT_TYPE_ID FROM DOCUMENT_DATA WHERE DOCUMENT_ID ="+docId+" and version = (select " + version + " from DOCUMENT_DATA  where DOCUMENT_ID = " + docId + " AND COMPANY_ID = " + compId + "))as DOCUMENT_TYPE_ID, ";
            sqlStatement += "(SELECT PROPERTY.PROPERTY_ID from property,DOCUMENT_DATA  where PROPERTY.ID = DOCUMENT_DATA.PROPERTY_ID AND DOCUMENT_DATA.DOCUMENT_ID = "+ docId +" AND PROPERTY.COMPANY_ID = "+ compId +" AND DOCUMENT_DATA.VERSION = (SELECT " + version + " from DOCUMENT_DATA  where DOCUMENT_ID = " + docId + " AND COMPANY_ID = " + compId + ") )as PROPERTY_ID,";
            sqlStatement += "(SELECT CDATE FROM (SELECT CREATE_DATE as CDATE FROM DOCUMENT_DATA WHERE DOCUMENT_ID = " + docId + " ORDER BY CREATE_DATE ASC)as crdate limit 1)as CDATE ";
//            sqlStatement += "  FROM DUAL ";

            logger.info("DocumentData findDocDetail query : " + sqlStatement);

            documentData = getDocDetailList(DatabaseConnection.getResultSet(sqlStatement));
            //documentData = (DocumentDataSQLHelper)documentDataList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
        }

        return documentData;
    }

    public DocumentData getDocDetailList(Vector hashMapList) {
        //Vector documentDataList = null;
        DocumentData documentData = new DocumentData();

        //documentDataList = new Vector();
        try {
            //for(int y = 0; y < hashMapList.size(); y++)
            if (hashMapList.size() > 0) {
                HashMap hashMap = new HashMap();
                hashMap = (HashMap) hashMapList.get(0);
                documentData.setPropertyId((String) hashMap.get("PROPERTY_ID"));
               // documentData.setFolderId((String) hashMap.get("FOLDER_ID"));
                logger.info(":::::::::::::::==="+hashMap.get("DOCUMENT_TYPE_ID"));
                if(hashMap.get("DOCUMENT_TYPE_ID") != null) {
                documentData.setDocumentTypeId(Long.parseLong((String) hashMap.get("DOCUMENT_TYPE_ID")));
                }else {
                	documentData.setDocumentTypeId(0);
                }
                documentData.setVersion(Long.parseLong((String) hashMap.get("VERSION")));
                documentData.setCreateDate((String) hashMap.get("UDATE") + "^" + (String) hashMap.get("CDATE"));
                logger.info("------(String) hashMap.get(\"UDATE\") + \"^\" + (String) hashMap.get(\"CDATE\")--------->>>"+(String) hashMap.get("UDATE") + "^" + (String) hashMap.get("CDATE"));


                //documentDataList.add(documentData);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
        }

        return documentData;
    }

	public static Vector<DocumentData> getDocumentDataList(Vector hashMapList)
	{
		Vector<DocumentData> documentDataList = null;
		DocumentData documentData;;
		
		documentDataList = new Vector<DocumentData>();
        try 
        {
			for(int y = 0; y < hashMapList.size(); y++)
			{
				HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
				
			   documentData = new DocumentData();
			   documentData.setDocumentTypeId(Long.parseLong((String)hashMap.get("DOCUMENT_TYPE_ID")));
			   documentData.setDocumentId(Long.parseLong((String)hashMap.get("DOCUMENT_ID")));
			   documentData.setFilename((String)hashMap.get("FILENAME"));
			   documentData.setCompanyId(Long.parseLong((String)hashMap.get("COMPANY_ID")));
			   documentData.setVersion(Long.parseLong((String)hashMap.get("VERSION")));
			   documentData.setActualfilename((String)hashMap.get("ACTUALFILENAME"));
			   documentData.setCreateDate((String)hashMap.get("CREATE_DATE"));
			    documentDataList.add(documentData);
			}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return documentDataList;
	}
	
	public static int findSeq(String sequence)
	{
		int dbSequence = 0;
		 		 
		try 
		{
			dbSequence = DatabaseConnection.createID(sequence);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return dbSequence;
	}
	
    public String insertDocVersion(String docId, String sessionId, int currentVersion, int newVersion, String fileName, String actualFileName) throws Exception {
        DatabaseConnection dbConnection = new DatabaseConnection();
        int documentId = 0;
        try {
            String sqlStatement = "INSERT INTO DOCUMENT_DATA (DOCUMENT_TYPE_ID, DOCUMENT_ID, FILENAME, COMPANY_ID, VERSION,PAGES,CREATE_DATE, " +
            					  " ORIG_DOC_ID,LAST_SESSION_ID,ACTUALFILENAME,PROPERTY_ID) ";
            sqlStatement += " SELECT DOCUMENT_TYPE_ID, DOCUMENT_ID, '" + fileName + "', COMPANY_ID, " + newVersion +
            				", 0, sysdate(), ORIG_DOC_ID,  '" + sessionId + "','" + actualFileName.replaceAll("\'","")+ "', PROPERTY_ID " +
            				" FROM DOCUMENT_DATA WHERE DOCUMENT_ID =" + docId + " AND VERSION = " + currentVersion;

            logger.info("DocumentDataDAO insert query : " + sqlStatement);
            dbConnection.executeUpdate(sqlStatement);

            /*sqlStatement = "SELECT DOCUMENT_ID RESULT FROM DOCUMENT_DATA WHERE ORIG_DOC_ID = "+docId+" AND VERSION = "+newVersion;
               logger.info("query : "+sqlStatement);

               documentId = dbConnection.getSingleValue(sqlStatement);
               logger.info("New documentId -->"+documentId);

               sqlStatement = "INSERT INTO SEARCH_DATA ";
               sqlStatement +="SELECT INDEX_TYPE_ID, "+documentId+", COMPANY_ID, INDEX_DATA FROM SEARCH_DATA WHERE DOCUMENT_ID = "+docId;

               logger.info("query : "+sqlStatement);
               dbConnection.executeUpdate(sqlStatement);
               */
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            throw e;
        }

        return documentId + "";
    }


    public void activateDocVersion(String docId, String sessionId, int newVersion) throws Exception {
        DatabaseConnection dbConnection = new DatabaseConnection();

        try {
            String sqlStatement = "UPDATE DOCUMENT_DATA SET";
            sqlStatement += " VERSION = VERSION * " + newVersion + ", LAST_SESSION_ID = '" + sessionId + "' WHERE DOCUMENT_ID = " + docId + "  ";

            logger.info("query : " + sqlStatement);
            dbConnection.executeUpdate(sqlStatement);

            sqlStatement = "UPDATE DOCUMENT_DATA SET";
            sqlStatement += " VERSION = 0, LAST_SESSION_ID = '" + sessionId + "' WHERE DOCUMENT_ID = " + docId + "   AND VERSION = 999 ";

            logger.info("query : " + sqlStatement);
            dbConnection.executeUpdate(sqlStatement);

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            throw e;
        }
    }

    public void inactivateDocVersion(String docId, String sessionId, int newVersion) throws Exception {
        DatabaseConnection dbConnection = new DatabaseConnection();

        try {
            String sqlStatement = "UPDATE DOCUMENT_DATA SET";
            sqlStatement += " VERSION = VERSION * " + newVersion + ", LAST_SESSION_ID = '" + sessionId + "' WHERE DOCUMENT_ID = " + docId + " ";

            logger.info("query : " + sqlStatement);
            dbConnection.executeUpdate(sqlStatement);

            sqlStatement = "UPDATE DOCUMENT_DATA SET";
            sqlStatement += " VERSION = VERSION + -999, LAST_SESSION_ID = '" + sessionId + "' WHERE DOCUMENT_ID = " + docId + " AND VERSION = 0 ";

            logger.info("query : " + sqlStatement);
            dbConnection.executeUpdate(sqlStatement);

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            throw e;
        }
    }


    
    public void InsertDocData(String actualFileName,String doctype, int docId, String filename, String cid, String version, int odocId, String sessionid
            , ArrayList<Integer> indexType, ArrayList<String> indexValue,String propertyId) throws Exception {
        DatabaseConnection dbConnection = new DatabaseConnection();
        try {
           // dbConnection.setCommit(false);
            String sqlStatement = "INSERT INTO DOCUMENT_DATA ";
            sqlStatement += "(DOCUMENT_TYPE_ID,DOCUMENT_ID,FILENAME,COMPANY_ID,VERSION,PAGES,CREATE_DATE,ORIG_DOC_ID,LAST_SESSION_ID,ACTUALFILENAME,PROPERTY_ID) VALUES (" +
            doctype + "," + docId + ",'" + filename + "'," + cid + "," + version + "," + "0," + "sysdate()," + odocId + ",'" + sessionid + "','"+actualFileName.replaceAll("\'","")+ "','"+propertyId+"')";

           // logger.info("DocumentDataDAO Insert query : " + sqlStatement);
            dbConnection.executeUpdate(sqlStatement);

            //  search_data 
            String pstmt = " insert into search_data(index_type_id,document_id,company_id,index_data) values(?,?,?,?)";
            PreparedStatement pst = dbConnection.connectdb(pstmt);
           
            String inval = "";

            Iterator<Integer> itr = indexType.iterator();
            Iterator<String> itr1 = indexValue.iterator();

            while (itr.hasNext()) {
                int i = itr.next();
                while (itr1.hasNext()) {
                    inval = itr1.next();
                    break;
                }
                System.out.println("Parameters : "+i+" *** "+docId+" *** "+Integer.parseInt(cid)+" *** "+inval);
                pst.setInt(1, i);
                pst.setInt(2, docId);
                pst.setInt(3, Integer.parseInt(cid));
                pst.setString(4, inval);
                pst.execute();
                // }
            }

            //dbConnection.doCommit();
            //dbConnection.setCommit(true);

        } catch (Exception e) {
        	
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            throw e;
        }
    }

    public void InsertDocData(int folderId,String actualFileName,String doctype, int docId, String filename, String cid, String version, int odocId, String sessionid
            , ArrayList<Integer> indexType, ArrayList<String> indexValue,String propertyId) throws Exception {
        
    	DatabaseConnection dbConnection = new DatabaseConnection();
    	Connection con = dbConnection.getDBConnection();  
    	PreparedStatement pst = null;
        try {
           
        	//dbConnection.setCommit(false);
            System.out.println("Inside insert docdata");
            String sqlStatement = "INSERT INTO DOCUMENT_DATA ";
            sqlStatement += "(DOCUMENT_TYPE_ID,DOCUMENT_ID,FILENAME,COMPANY_ID,VERSION,PAGES,CREATE_DATE,ORIG_DOC_ID,LAST_SESSION_ID,FOLDER_ID,ACTUALFILENAME,PROPERTY_ID) VALUES (" +
            doctype + "," + docId + ",'" + filename + "'," + cid + "," + version + "," + "0," + "sysdate()," + odocId + ",'" + sessionid + "',"+folderId+",'"+actualFileName.replaceAll("\'","")+"','"+propertyId+"')";

           
            logger.info("DocumentDataDAO Insert query : " + sqlStatement);
            dbConnection.executeUpdateQuery(sqlStatement,con);

            /*  search_data */
            String pstmt = " insert into search_data(index_type_id,document_id,company_id,index_data) values(?,?,?,?)";         
            
                       
            String inval = "";

            Iterator<Integer> itr = indexType.iterator();
            Iterator<String> itr1 = indexValue.iterator();

            while (itr.hasNext()) {
                int i = itr.next();
                while (itr1.hasNext()) {
                    inval = itr1.next();
                    break;
                }
                //logger.info("Parameters : "+i+" *** "+docId+" *** "+Integer.parseInt(cid)+" *** "+inval);
                pst = dbConnection.executePreparedStmt(pstmt,con);
                pst.setInt(1, i);
                pst.setInt(2, docId);
                pst.setInt(3, Integer.parseInt(cid));
                pst.setString(4, inval);
                pst.execute();
                
            }          
            
            //dbConnection.doCommit();
            //dbConnection.setCommit(true);

        } catch (Exception e) {
        	
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            throw e;
        }
    	finally{
    		try
			{
				//make sure that the connection is closed
				dbConnection.disconnectdb();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.error("Exception in finally : " + e.getMessage());
			}
    	}
    }
    
    
    public void InsertDocData(String folderIds,String actualFileName,String doctype, int docId, String filename, String cid, String version, int odocId, String sessionid
            , String indexType, String indexValue,String propertyId) throws Exception {
        DatabaseConnection dbConnection = new DatabaseConnection();
        try {
            
        	String sqlStatement = "INSERT INTO DOCUMENT_DATA ";
            sqlStatement += "(DOCUMENT_TYPE_ID,DOCUMENT_ID,FILENAME,COMPANY_ID,VERSION,PAGES,CREATE_DATE,ORIG_DOC_ID,LAST_SESSION_ID,ACTUALFILENAME,PROPERTY_ID,OCR_FLAG) VALUES (" +
            doctype + "," + docId + ",'" + filename + "'," + cid + "," + version + "," + "0," + "sysdate()," + odocId + ",'" + sessionid + "','"+actualFileName.replaceAll("\'","")+"','"+propertyId+"','YES')";

            logger.info("DocumentDataDAO Insert query : " + sqlStatement);
            dbConnection.executeUpdate(sqlStatement);

            StringTokenizer st = new StringTokenizer(folderIds,"/");
    	    while (st.hasMoreElements()) {
    	    		
    	    		String folderId = (String)st.nextElement();
    	    		//System.out.println("nextElement -->"+nextElement);
    	    
    	    		sqlStatement = "insert into document_folders (document_id, company_id, folder_id ) values ('"+ docId +"', '" + cid + "','"+folderId+"') ";
    	    		logger.info("DocumentDataDAO Insert query : " + sqlStatement);
    	            dbConnection.executeUpdate(sqlStatement);
    		}
            
            
            /*  search_data */
            String pstmt = " insert into search_data(index_type_id,document_id,company_id,index_data) values(?,?,?,?)";
            PreparedStatement pst = dbConnection.connectdb(pstmt);
            
            pst.setInt(1, Integer.parseInt(indexType));
            pst.setInt(2, docId);
            pst.setInt(3, Integer.parseInt(cid));
            pst.setString(4, indexValue);
            pst.execute();
            
            

        } catch (Exception e) {
        	
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            throw e;
        }
    }
    
    /*
     * Multiple Upload Documents
     */
    
    
    public String findByTrasaction(String transactionType) {
        String transactionName = null;
        Connection conn=null;
        PreparedStatement st=null;
	    ResultSet rs=null;
	   DBManager dbm = null;
        try {
            String sqlStatement = "SELECT TRANSACTION_TYPE FROM TRANSACTION_TYPE WHERE TRANSACTION_TYPE_ID =" + transactionType;

            logger.info("query : " + sqlStatement);
          
    	    try{
    	    	  dbm=DBManager.getInstance();
    	            conn=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
      	    	 if(conn!=null){
      	    		 st=conn.prepareStatement(sqlStatement);
      	    	//	st.setFetchSize(1000); 
      	    		 rs= st.executeQuery(sqlStatement);
      	    		if (rs != null) { 
      	    		 while(rs.next()){
      	    			//property= new Property();
      	    		//	property.setPropertyId(rs.getString("property_id"));
      	    			//property.setId(rs.getLong("id"));
      	    					//	folder.setCompanyId(rs.getLong("COMPANY_ID"));   	    			
      	    			transactionName = rs.getString("TRANSACTION_TYPE");
      	    		 }
      	    		}
      	    	 }
      	    	 System.out.println(transactionName+"transactionName");
      	    
      	    }catch(Exception e){
      	    	logger.info("exception in find by transaction-"+e.getMessage());
      	    }finally{
      	    	rs.close();
      	    	st.close();
      	    	dbm.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
      	    	//DatabaseConnection.disconnectdb();
      	    }

            //propertyList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            logger.info("Error :" + e.getMessage());
        }

        return transactionName;
    }
    
    public synchronized void InsertTransactionMultipleDocData(String actualFileName,String doctype, int docId, String filename, String cid, String version, int odocId, String sessionid
            , String indexType, String indexValue,String propertyId,String appuserrole ,String folderNameFView, String transactiontype, String transactionDate, String transactionStatus) throws Exception {
    	Connection con=null;
        Statement stmt=null;
        DBManager dbm=null;
        ResultSet rs=null;
        try {
	       dbm =DBManager.getInstance();
        	con=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
        	int folderId = 0;
        	String folderIds = "";
    		String folderName =null;
    		 int year = 0 ;
        	
        	getDropD getDD = new getDropD();
    		String propertyValue = getDD.getProperty(propertyId);
    		
    		System.out.println("propertyValue123"+propertyValue);
    		System.out.println("propertyId134"+propertyId);
    		
    		
    		
            
          if(!StringUtils.isEmpty(folderNameFView))
              {
            	  folderName=(folderNameFView);
      			try {
      				
      				FolderDAO folderDao = new FolderDAO();
      				Vector folderVector = folderDao.findByFolderNames(folderName);
      				
      				folderId = 0;
      				System.out.println("folderVector.size() -->"+folderVector.size()+"<-- docId -->"+docId+"<-- folderName -->"+folderName+"<---");
      				if (folderVector.size() <= 0) {
      					// Insert folder
      					folderId = folderDao.addFolder(cid, folderName);
      					folderIds = folderId+"/"+docId;
      					System.out.println("NEW Folder Id  ---> " + folderId+"<--- folderName -->"+folderName+"<----docId -->"+docId+"<--");
      					
      				} else {
      					//Folder folder = (Folder) folderVector.get(0);
      					//folderId = Integer.parseInt(folder.getFolderId() + "");
      					 HashMap hashMap1 = new HashMap();
      			         hashMap1 = (HashMap) folderVector.get(0);
      			   System.out.println("folder id==============>>"+ hashMap1.get("FOLDER_ID"));
      			         folderId =Integer.parseInt(hashMap1.get("FOLDER_ID").toString());
      			         System.out.println("folderId data"+ folderId);
      			         folderIds = folderId+"/"+docId;
      			         System.out.println("EXISTING Folder Id  ---> " + folderId+"<--- folderName -->"+folderName+"<----docId -->"+docId+"<--");
      				}
      			} catch (NumberFormatException e) {
      				// TODO Auto-generated catch block
      				e.printStackTrace();
      			} catch (PenielException e) {
      				// TODO Auto-generated catch block
      				e.printStackTrace();
      			}
      			
      			
      			
      			System.out.println("folderIds -->"+folderIds+"<----");
      			if(folderIds.contains("/")){
  	    			String[] parts = folderIds.split("/");
  	    			String partFolderId = parts[0]; //folderId
  	    			String partDocId = parts[1]; // docId
  	        	    		
  		    		stmt=con.createStatement();
  		    		String sql = "select * from document_folders where document_id = '"+ partDocId +"' and folder_id = '"+partFolderId+"'";
		    		rs=stmt.executeQuery(sql);
  		    		stmt.close();
  		    		if(!rs.next()){
  		    			stmt=con.createStatement();
  		    		sql = "insert into document_folders (document_id, company_id, folder_id ) values ('"+ partDocId +"', '" + cid + "','"+partFolderId+"') ";
  		    		logger.info("DocumentDataDAO Insert query : " + sql);
  		    		stmt.executeUpdate(sql);
  	        		
  		    		}
  		    		rs.close();
  		    		stmt.close();
      			} 
              }
    		
          else {
            
            DocumentTypeDAO docTypeDao = new DocumentTypeDAO();
            
            if ("Transaction Date".equals(transactionDate))
            		{
            	transactionDate="";
            		}
            
    		
    		//Vector hashMapList = docTypeDao.findByIds(doctype, cid);
    		DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
    		if(!StringUtils.isEmpty(transactionDate)) {
    		Date date = format.parse(transactionDate);
    		Calendar calendar = new GregorianCalendar();
    		calendar.setTime(date);
    		  year = calendar.get(Calendar.YEAR);
    		}
    		
	    		
    		
    		//for (int y = 0; y <= hashMapList.size(); y++) {
             //   HashMap hashMap = new HashMap();
             //   hashMap = (HashMap) hashMapList.get(y);
       
                //String subFolderId = (String) hashMap.get("SUB_FOLDER_ID");
             //   String subFolderName1 = (String) hashMap.get("SUB_FOLDER_NAME_1");
             //   String subFolderName2 = (String) hashMap.get("SUB_FOLDER_NAME_2");
            
    			//folderName = propertyValue + "/" + indexValue + "/"+ subFolderName1 + "/"+ subFolderName2 ;
                
            	System.out.println("findByTrasaction(transactiontype) ---> " +findByTrasaction(transactiontype));
                
                folderName=propertyValue;
                if(!StringUtils.isEmpty(indexValue) && (!"Select FHA Number".equals(indexValue)))
                {
                	 folderName=folderName + "/" + indexValue;
                }
                folderName=(folderName+  "/" + "Asset Management" + "/"+ findByTrasaction(transactiontype));
                if(!StringUtils.isEmpty(transactionDate)) {
                folderName=(folderName +"/"+year+"/"+transactionDate); 
                }
    	        
    			System.out.println("Folder Name***" +folderName+"<-- docId -->"+docId+"<--");
    			
    			
    			
    			folderName= ("/" + folderName + "/");
    			//System.out.println("Folder Id before ---------------------> " + folderId);
    		
    			
    			try {
    				
    				FolderDAO folderDao = new FolderDAO();
    				Vector folderVector = folderDao.findByFolderNames(folderName.toString());
    				
    				folderId = 0;
    				System.out.println("folderVector.size() -->"+folderVector.size()+"<-- docId -->"+docId+"<-- folderName -->"+folderName+"<---");
    				if (folderVector.size() <= 0) {
    					// Insert folder
    					folderId = folderDao.addFolder(cid, folderName.toString());
    					folderIds = folderId+"/"+docId;
    					System.out.println("NEW Folder Id  ---> " + folderId+"<--- folderName -->"+folderName+"<----docId -->"+docId+"<--");
    					
    				} else {
    					//Folder folder = (Folder) folderVector.get(0);
    					//folderId = Integer.parseInt(folder.getFolderId() + "");
    					 HashMap hashMap1 = new HashMap();
    			         hashMap1 = (HashMap) folderVector.get(0);
    			   System.out.println("folder id"+ hashMap1.get("FOLDER_ID"));
    			         folderId =Integer.parseInt(hashMap1.get("FOLDER_ID").toString());
    			         System.out.println("folderId data"+ folderId);
    			         folderIds = folderId+"/"+docId;
    			         System.out.println("EXISTING Folder Id  ---> " + folderId+"<--- folderName -->"+folderName+"<----docId -->"+docId+"<--");
    				}
    			} catch (NumberFormatException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (PenielException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    			
    			
    			System.out.println("folderIds -->"+folderIds+"<----");
    			if(folderIds.contains("/")){
	    			String[] parts = folderIds.split("/");
	    			String partFolderId = parts[0]; //folderId
	    			String partDocId = parts[1]; // docId
	        	    		
	            	stmt=con.createStatement();
		    		String sql = "select 1 from document_folders where document_id = '"+ partDocId +"' and folder_id = '"+partFolderId+"'";
		    		rs=stmt.executeQuery(sql);
		    		
		    		//Vector sqlRes = DatabaseConnection.getResultSet(sql);
		    		stmt.close();
		    		if(!rs.next()) {
		    		stmt=con.createStatement();
		    		sql = "insert into document_folders (document_id, company_id, folder_id ) values ('"+ partDocId +"', '" + cid + "','"+partFolderId+"') ";
		    		logger.info("DocumentDataDAO Insert query : " + sql);
		    		stmt.executeUpdate(sql);
		    		}
    			}
    		//}	

             }
  
        	
          stmt.close();
          stmt=con.createStatement();
        	String sqlStatement = "INSERT INTO DOCUMENT_DATA ";
            sqlStatement += "(DOCUMENT_TYPE_ID,DOCUMENT_ID,FILENAME,COMPANY_ID,VERSION,PAGES,CREATE_DATE,ORIG_DOC_ID,LAST_SESSION_ID,ACTUALFILENAME,PROPERTY_ID,OCR_FLAG,TRANSACTION_TYPE_ID,TRANSACTION_DATE,TRANSACTION_STATUS) VALUES (" + 
            
            (!StringUtils.isEmpty(doctype)?(doctype + ","):(null + ",")) + docId + ",'" + filename + "'," + cid + "," + version + "," + "0," + "sysdate()," + odocId + ",'" + sessionid + "','"+actualFileName.replaceAll("\'","")+"','"+propertyId+"','YES','"+transactiontype+"',str_to_date('"+transactionDate+"','%m-%d-%Y'),'"+transactionStatus+"')";

            logger.info("DocumentDataDAO Insert query : " + sqlStatement);
            stmt.executeUpdate(sqlStatement);
       
            stmt.close();
            stmt=con.createStatement();          
            /*  search_data */
            if("Select FHA Number".equals(indexValue)) {
            	indexValue="";
            }
            String pstmt = " insert into search_data(index_type_id,document_id,company_id,index_data) values("+Integer.parseInt(indexType)+",'"+docId+"',"+Integer.parseInt(cid)+",'"+indexValue+"')";
            logger.info("pstmt-->"+pstmt);
            stmt.executeUpdate(pstmt);

        } catch (Exception e) {
        	
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            throw e;
        }finally {
        	rs.close();
        	stmt.close();
        	con.close();
       	 dbm.releaseConnection(DbManagerValues.CONN_SOURCE, con);
		}
               
    }

    
    
    
    /*
     * Multiple Upload Documents
     */
    public synchronized void InsertMultipleDocData(String actualFileName,String doctype, int docId, String filename, String cid, String version, int odocId, String sessionid
            , String indexType, String indexValue,String propertyId,String appuserrole ,String folderNameFView) throws Exception {
        DatabaseConnection dbConnection = new DatabaseConnection();
        try {
        	int folderId = 0;
        	String folderIds = "";
    		String folderName = "";
        	
        	getDropD getDD = new getDropD();
    		String propertyValue = getDD.getProperty(propertyId);
    		
    		
            
          if(!StringUtils.isEmpty(folderNameFView))
              {
            	  folderName = folderNameFView;
      			try {
      				
      				FolderDAO folderDao = new FolderDAO();
      				Vector folderVector = folderDao.findByFolderNames(folderName);
      				
      				folderId = 0;
      				System.out.println("folderVector.size() -->"+folderVector.size()+"<-- docId -->"+docId+"<-- folderName -->"+folderName+"<---");
      				if (folderVector.size() <= 0) {
      					// Insert folder
      					folderId = folderDao.addFolder(cid, folderName);
      					folderIds = folderId+"/"+docId;
      					System.out.println("NEW Folder Id  ---> " + folderId+"<--- folderName -->"+folderName+"<----docId -->"+docId+"<--");
      					
      				} else {
      					//Folder folder = (Folder) folderVector.get(0);
      					//folderId = Integer.parseInt(folder.getFolderId() + "");
      					 HashMap hashMap1 = new HashMap();
      			         hashMap1 = (HashMap) folderVector.get(0);
      			   System.out.println("folder id"+ hashMap1.get("FOLDER_ID"));
      			         folderId =Integer.parseInt(hashMap1.get("FOLDER_ID").toString());
      			         System.out.println("folderId data"+ folderId);
      			         folderIds = folderId+"/"+docId;
      			         System.out.println("EXISTING Folder Id  ---> " + folderId+"<--- folderName -->"+folderName+"<----docId -->"+docId+"<--");
      				}
      			} catch (NumberFormatException e) {
      				// TODO Auto-generated catch block
      				e.printStackTrace();
      			} catch (PenielException e) {
      				// TODO Auto-generated catch block
      				e.printStackTrace();
      			}
      			
      			
      			
      			System.out.println("folderIds -->"+folderIds+"<----");
      			if(folderIds.contains("/")){
  	    			String[] parts = folderIds.split("/");
  	    			String partFolderId = parts[0]; //folderId
  	    			String partDocId = parts[1]; // docId
  	        	    		
  		    		DatabaseConnection dbConn = new DatabaseConnection();
  		    		
  		    		String sql = "select * from document_folders where document_id = '"+ partDocId +"' and folder_id = '"+partFolderId+"'";
  		    		Vector sqlRes = DatabaseConnection.getResultSet(sql);
  		    		
  		    		if(sqlRes.size() <= 0){
  		    		
  		    		sql = "insert into document_folders (document_id, company_id, folder_id ) values ('"+ partDocId +"', '" + cid + "','"+partFolderId+"') ";
  		    		logger.info("DocumentDataDAO Insert query : " + sql);
  		            dbConn.executeUpdate(sql);
  	        		
  		    		}
      			} 
              }
    		
          else {
            
            DocumentTypeDAO docTypeDao = new DocumentTypeDAO();
    		
    		Vector hashMapList = docTypeDao.findByIds(doctype, cid);
    		
    	
    		
    		for (int y = 0; y < hashMapList.size(); y++) {
                HashMap hashMap = new HashMap();
                hashMap = (HashMap) hashMapList.get(y);
       
                //String subFolderId = (String) hashMap.get("SUB_FOLDER_ID");
                String subFolderName1 = (String) hashMap.get("SUB_FOLDER_NAME_1");
                String subFolderName2 = (String) hashMap.get("SUB_FOLDER_NAME_2");
            
    			folderName = propertyValue + "/" + indexValue + "/"+ subFolderName1 + "/"+ subFolderName2 ;
    	        
    			System.out.println("Folder Name ---> " +folderName+"<-- docId -->"+docId+"<--");
    			
    			
    			
    			folderName = "/" + folderName + "/";
    			//System.out.println("Folder Id before ---------------------> " + folderId);
    		
    			
    			try {
    				
    				FolderDAO folderDao = new FolderDAO();
    				Vector folderVector = folderDao.findByFolderNames(folderName);
    				
    				folderId = 0;
    				System.out.println("folderVector.size() -->"+folderVector.size()+"<-- docId -->"+docId+"<-- folderName -->"+folderName+"<---");
    				if (folderVector.size() <= 0) {
    					// Insert folder
    					folderId = folderDao.addFolder(cid, folderName);
    					folderIds = folderId+"/"+docId;
    					System.out.println("NEW Folder Id  ---> " + folderId+"<--- folderName -->"+folderName+"<----docId -->"+docId+"<--");
    					
    				} else {
    					//Folder folder = (Folder) folderVector.get(0);
    					//folderId = Integer.parseInt(folder.getFolderId() + "");
    					 HashMap hashMap1 = new HashMap();
    			         hashMap1 = (HashMap) folderVector.get(0);
    			   System.out.println("folder id"+ hashMap1.get("FOLDER_ID"));
    			         folderId =Integer.parseInt(hashMap1.get("FOLDER_ID").toString());
    			         System.out.println("folderId data"+ folderId);
    			         folderIds = folderId+"/"+docId;
    			         System.out.println("EXISTING Folder Id  ---> " + folderId+"<--- folderName -->"+folderName+"<----docId -->"+docId+"<--");
    				}
    			} catch (NumberFormatException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (PenielException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    			
    			
    			System.out.println("folderIds -->"+folderIds+"<----");
    			if(folderIds.contains("/")){
	    			String[] parts = folderIds.split("/");
	    			String partFolderId = parts[0]; //folderId
	    			String partDocId = parts[1]; // docId
	        	    		
		    		DatabaseConnection dbConn = new DatabaseConnection();
		    		
		    		String sql = "select * from document_folders where document_id = '"+ partDocId +"' and folder_id = '"+partFolderId+"'";
		    		Vector sqlRes = DatabaseConnection.getResultSet(sql);
		    		
		    		if(sqlRes.size() <= 0){
		    		
		    		sql = "insert into document_folders (document_id, company_id, folder_id ) values ('"+ partDocId +"', '" + cid + "','"+partFolderId+"') ";
		    		logger.info("DocumentDataDAO Insert query : " + sql);
		            dbConn.executeUpdate(sql);
	        		
		    		}
    			}
    		}	

             }
  
        	
        	
        	String sqlStatement = "INSERT INTO DOCUMENT_DATA ";
            sqlStatement += "(DOCUMENT_TYPE_ID,DOCUMENT_ID,FILENAME,COMPANY_ID,VERSION,PAGES,CREATE_DATE,ORIG_DOC_ID,LAST_SESSION_ID,ACTUALFILENAME,PROPERTY_ID,OCR_FLAG) VALUES (" +
            doctype + "," + docId + ",'" + filename + "'," + cid + "," + version + "," + "0," + "sysdate()," + odocId + ",'" + sessionid + "','"+actualFileName.replaceAll("\'","")+"','"+propertyId+"','YES')";

            logger.info("DocumentDataDAO Insert query : " + sqlStatement);
            dbConnection.executeUpdate(sqlStatement);
           
                        
            /*  search_data */
            String pstmt = " insert into search_data(index_type_id,document_id,company_id,index_data) values("+Integer.parseInt(indexType)+",'"+docId+"',"+Integer.parseInt(cid)+",'"+indexValue+"')";
            logger.info("pstmt-->"+pstmt);
            
            
            dbConnection.executeUpdate(pstmt);
            
            
            
            
            
            
            

        } catch (Exception e) {
        	
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            throw e;
        }
    }

    
    public void InsertDocData(String actualFileName,String doctype, int docId, String filename, String cid, String version, int odocId, String sessionid
            , String indexType, String indexValue,String propertyId) throws Exception {
        DatabaseConnection dbConnection = new DatabaseConnection();
        
        try {
            //dbConnection.setCommit(false);
            String sqlStatement = "INSERT INTO DOCUMENT_DATA ";
            sqlStatement += "(DOCUMENT_TYPE_ID,DOCUMENT_ID,FILENAME,COMPANY_ID,VERSION,PAGES,CREATE_DATE,ORIG_DOC_ID,LAST_SESSION_ID,ACTUALFILENAME,PROPERTY_ID) VALUES (" +
            doctype + "," + docId + ",'" + filename + "'," + cid + "," + version + "," + "0," + "sysdate()," + odocId + ",'" + sessionid + "','"+actualFileName.replaceAll("\'","")+ "','"+propertyId+"')";

            logger.info("DocumentDataDAO Insert query : " + sqlStatement);
            dbConnection.executeUpdate(sqlStatement);

            /*  search_data */
            String pstmt = " insert into search_data(index_type_id,document_id,company_id,index_data) values(?,?,?,?)";
            PreparedStatement pst = dbConnection.connectdb(pstmt);
           
            pst.setInt(1, Integer.parseInt(indexType));
            pst.setInt(2, docId);
            pst.setInt(3, Integer.parseInt(cid));
            pst.setString(4, indexValue);
            

            //dbConnection.doCommit();
            //dbConnection.setCommit(true);
            
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
            
            throw e;
        }
    }
   /* public synchronized long getMaxDocId() {
		// TODO Auto-generated method stub
    	  Connection conn=null;
          Statement st=null;
  	      ResultSet rs=null;
  	      long docIdValue = 0;
  	    try{
  	    conn=DatabaseConnection.getDatabaseConnection();
		String sqlQuery = "Select MAX(DOCUMENT_ID)as DOCUMENT_ID  from DOCUMENT_DATA ;"; 
		st=conn.createStatement();
		rs=st.executeQuery(sqlQuery);
    	logger.debug("sqlQuery:MAXDOCID%%%%img%%%%%%%%%%%"+sqlQuery);
    	if(rs.next()) {
    		docIdValue=(long) rs.getDouble("DOCUMENT_ID");
    	}
  	    }catch(Exception e){
  	    	logger.info("sqlQuery:"+e.getMessage());
 	    }finally{
 	    	try {
 	    		 if(rs!=null){
				rs.close();
 	    		 }
 	    		 if(st !=null){
				st.close();
 	    		 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	    	
 	    	DatabaseConnection.disconnectdb();
 	    }
  	  return docIdValue+1;
  	  }*/

  public synchronized long   getMaxiDocId1() {
	 // int i=0;
	  //long start = System.currentTimeMillis();
	  
		// TODO Auto-generated method stub
    	  Connection conn=null;
          Statement st1=null,st2=null;
  	      ResultSet rs1=null;
  	      long docIdValue = 0;
  	    try{
  	    	//System.out.println("start ------>"+start+ " "+ i++);
  	    	//lock.lock();
  	    conn=DatabaseConnection.getDatabaseConnection();
	
		st1=conn.createStatement();
		rs1=st1.executeQuery("select CURRENT_SEQ from gen_seq");
		
    	//System.out.println("sqlQuery:MAXDOCID%%%%img%%%%%%%%%%%"+sqlQuery);
    	if(rs1.next()) {
    		docIdValue=(long) rs1.getDouble("CURRENT_SEQ");
    	}
    	docIdValue=docIdValue+1;
    	
    	  
		String sqlQuery1 = "update gen_seq set CURRENT_SEQ="+docIdValue; 

		//st2=conn.createStatement();
		st1.executeQuery(sqlQuery1);
    	
		System.out.println("sqlQuery:MAXDOCID%%%%img%%%%%%%%%%%"+docIdValue);
  	    }catch(Exception e){
  	    	logger.info("sqlQuery:"+e.getMessage());
 	    }finally{
 	    	try {
 	    		
 	    		 if(rs1!=null){
 					rs1.close();
 	 	    		 }
 	 	    		 if(st1 !=null){
 					st1.close();
 	 	    		 }
 	 	    		 if(st2 !=null){
 	 					st2.close();
 	 	 	    		 }
 	 	    		 //lock.unlock();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	    	
 	    	DatabaseConnection.disconnectdb();
 	    	 //long result = System.currentTimeMillis() - start;

 	       // System.out.println(docIdValue +"Date():***** " + result);
 	    }
  	  return docIdValue;
  	  }
    /*public  long  getMaxiDocId() {
  		// TODO Auto-generated method stub
      	  Connection conn=null;
      	CallableStatement stmt=null;
        long seqEnd =0;
    	      long docIdValue = 0;
    	    try{
    	    conn=DatabaseConnection.getDatabaseConnection();
  		String sqlQuery = "update gen_seq set CURRENT_SEQ = (select max(document_id) from document_data) where CURRENT_SEQ > 0 "; 
  		st=conn.createStatement();
  		st.executeQuery(sqlQuery);
  		
  		
  		
  		stmt = (CallableStatement)conn.prepareCall("{CALL get_seq(?,?,?,?)}");
  		
  	   stmt.setString(1, "GEN_SEQ");
       stmt.setInt(2, 1000000);
       stmt.registerOutParameter(3, java.sql.Types.INTEGER);
       stmt.registerOutParameter(4, java.sql.Types.INTEGER);
       stmt.execute();
       long seqStart = stmt.getLong(3);
        seqEnd   = stmt.getLong(4);
     
      
      	
  		System.out.println("sqlQuery:MAXDOCID%%%%img%%%%%%%%%%%"+seqStart + "***"+ seqEnd);
    	    }catch(Exception e){
    	    	logger.info("sqlQuery:"+e.getMessage());
   	    }finally{
   	    	try {
   	    		 
   	    		 if(stmt !=null){
   	    			stmt.close();
   	    		 }
   	    		
  			} catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
   	    	
   	    	DatabaseConnection.disconnectdb();
   	    }
    	  return seqEnd;
    	  }*/
	    
  public  long  getMaxiDocId() {
		// TODO Auto-generated method stub
    	  Connection conn=null;
    	CallableStatement stmt=null;
    	ResultSet rs= null;
    	DBManager dbm=null;
    	 long nextId =0;
  	    try{
  	    	dbm=DBManager.getInstance();
  	    	conn=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
			
		stmt = (CallableStatement)conn.prepareCall("{CALL get_seq(?)}");
     stmt.registerOutParameter(1, java.sql.Types.DOUBLE);
     stmt.executeUpdate();
     nextId = stmt.getLong(1);     
          	
		System.out.println("sqlQuery:MAXiiiDOCID%%%%img%%%%%%%%%%%"+nextId + "***");
  	    }catch(Exception e){
  	    	logger.info("sqlQuery:"+e.getMessage());
 	    }finally{
 	    	try {
 	    		 
 	    		 if(stmt !=null){
 	    			stmt.close();
 	    		 }
 	    		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	    	
 	    //	DatabaseConnection.disconnectdb();
 	    	dbm.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
 	    }
  	  return nextId;
  	  }
  public List<DocRoles> getDocroles(){
  	//Map<String,List<String>> userRoleMap = new HashMap<String,List<String>>();
  	List<DocRoles> docRoleList = new ArrayList<DocRoles>();
  	String sqlStatement = "SELECT * FROM document_roles";
  	Statement st =null;
  	ResultSet rs =null;
  	Connection conn = null;
  	DBManager db;
		try {
			db = DBManager.getInstance();
			conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);
			st =conn.createStatement();
			rs=st.executeQuery(sqlStatement);
			while(rs.next()){
				DocRoles docrole = new DocRoles();
	         
				docrole.setRole_name(rs.getString("role_name"));
				docrole.setRole_doctype(rs.getString("role_doctype"));
	        	docRoleList.add(docrole);
      	
      	
			}
		} catch (PenielException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null){
				try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(conn!=null){
				try {
					conn.close();
			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
  
  	return docRoleList;
  }
	    
    

}



