package com.peniel.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.Folder;
import com.peniel.bus.vo.sqlhelpers.SQLHelper;
import com.peniel.dao.helper.SqlFieldHelper;

/**
 * User: todds
 * Date: 11/8/11
 * Time: 11:08 PM
 */
public abstract class DAOHelper<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DAOHelper.class);

    protected String MODULE_NAME;
    protected SQLHelper<T> sqlHelper;

    protected DAOHelper(String moduleName, SQLHelper<T> sqlHelper) {
        this.sqlHelper = sqlHelper;
        this.MODULE_NAME = moduleName;
    }

    public String createUserSessionId(String username) {
        //generate a new sessionId for this user
        java.util.Date today = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());

        Random generator = new Random();

        return username + timestamp + generator.nextInt();
    }

    
    public long getNextId(String sequence) throws PenielException {
        long retval = 0;
        DBManager db = DBManager.getInstance();
        Connection conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);
        String sqlStatement = "select  " + sequence + ".nextval from dual";

        System.out.println("sql" + sqlStatement);
        try {
            dbobject rdo = new dbobject(conn);

            retval = rdo.getNextId(sqlStatement);
        } catch (Exception ex) {
            throw (new PenielException(ex, "Exception in " + MODULE_NAME + " : getAppUserList() " + ex.getMessage()));
        } finally {
            db.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
        }

        return retval;
    }
    

    public long getNextId() throws PenielException {
        return getNextId(getDocumentDataSeq());
    }
    public long getNextId1() throws PenielException {
        return getNextId(getBatchUploadSeq());
    }

    public long executeInsert(String sqlStatement) throws PenielException {
        DBManager db = DBManager.getInstance();
        Connection conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);

        System.out.println("sql" + sqlStatement);
        try {
            dbobject rdo = new dbobject(conn);
            return rdo.doInsert(sqlStatement);
        }catch (Exception ex) {
            throw (new PenielException(ex));
        } finally {
            db.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
        }
    }

    public long executeUpdate(String sqlStatement) throws PenielException {
        DBManager db = DBManager.getInstance();
        Connection conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);

        System.out.println("update sql" + sqlStatement);
        try {
            dbobject rdo = new dbobject(conn);
            return rdo.doUpdate(sqlStatement);
        } catch (Exception ex) {
            throw (new PenielException(ex, "Exception in " + MODULE_NAME + " : getAppUserList() " + ex.getMessage()));
        } finally {
            db.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
        }
    }
    
	 public long executeUpdateMethod(String sqlStatement) throws PenielException {
	        DBManager db = DBManager.getInstance();
	        Connection conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);

	        System.out.println("update  executeUpdateMethod sql" + sqlStatement);
	        try {
	            dbobject rdo = new dbobject(conn);
	            return rdo.doUpdate(sqlStatement);
	        } catch (Exception ex) {
	            throw (new PenielException(ex, "Exception in " + MODULE_NAME + " : getAppUserList() " + ex.getMessage()));
	        } finally {
	        	System.out.println("FINALLY");
	            db.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
	        }
	    }
    
    
    public List<AppRoles> findByRoleNames(String userId){
    	//Map<String,List<String>> userRoleMap = new HashMap<String,List<String>>();
    	List<AppRoles> userRoleList = new ArrayList<AppRoles>();
    	String sqlStatement = "SELECT * from APP_ROLES where ROLE_ID IN(select ROLE_ID from APP_USER_ROLES where USER_ID="+userId+")ORDER BY ROLE_NAME";
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
				AppRoles approle = new AppRoles();
	         
	        	approle.setRoleName(rs.getString("ROLE_NAME"));
	        	approle.setRoleId(rs.getInt("ROLE_ID"));
	        	userRoleList.add(approle);
        	
        	
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
    
    	return userRoleList;
    }   
      
    

    public Vector<T> findByProperty1(String propertyName, String value) {
        Vector<T> appRolesList = new Vector<T>();
        String alias = null;

        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sqlHelper.buildSelect(alias))
                    .append(sqlHelper.buildFrom(alias))
                    .append(sqlHelper.buildWhere(alias, propertyName, "=", value))
                     .append(" order by DOCUMENT_TYPE asc");

            String sqlStatement = stringBuilder.toString();
                    //"select role_id, role_name  from app_roles where " + propertyName + " = '" + value + "'";

            System.out.println("DocumentTypeDAO findByProperty1 query********** : " + sqlStatement);

            //appRolesList = getAppRolesList(DatabaseConnection.getResultSet(sqlStatement));
            appRolesList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            LOGGER.info("Error :" + e.getMessage());
        }

        return appRolesList;
    }
    
    public Vector<T> findByProperty2(String propertyName, String value, String orderBy) {
        Vector<T> appRolesList = new Vector<T>();
        String alias = null;

        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sqlHelper.buildSelect(alias))
                    .append(sqlHelper.buildFrom(alias))
                    .append(sqlHelper.buildWhere(alias, propertyName, "=", value))
                     .append(" order by "+orderBy);

            String sqlStatement = stringBuilder.toString();
                    //"select role_id, role_name  from app_roles where " + propertyName + " = '" + value + "'";

            System.out.println("DAOHELPER IndexTypeDAO findByProperty2 query********** : " + sqlStatement);

            //appRolesList = getAppRolesList(DatabaseConnection.getResultSet(sqlStatement));
            appRolesList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            LOGGER.info("Error :" + e.getMessage());
        }

        return appRolesList;
    }
    
    public Vector<T> findByProperty(String propertyName, String value) {
        Vector<T> appRolesList = new Vector<T>();
        String alias = null;

        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sqlHelper.buildSelect(alias))
                    .append(sqlHelper.buildFrom(alias))
                    .append(sqlHelper.buildWhere(alias, propertyName, "=", value));

            String sqlStatement = stringBuilder.toString();
                    //"select role_id, role_name  from app_roles where " + propertyName + " = '" + value + "'";

            System.out.println("DocumentTypeDAO findByProperty query********** : " + sqlStatement);

            //appRolesList = getAppRolesList(DatabaseConnection.getResultSet(sqlStatement));
            appRolesList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            LOGGER.info("Error :" + e.getMessage());
        }

        return appRolesList;
    }
    public Vector<T> findByFolderName(String folderName, String cId) {
        Vector<T> appRolesList = new Vector<T>();
        try{
        String sqlStatement = "select * from document_data where folder_id in (select folder_id from folders where folder_name like '"+folderName+"%') and company_id = "+cId;
        LOGGER.info("query findByFolderName: " + sqlStatement);
        appRolesList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            LOGGER.info("Error :" + e.getMessage());
        }

        return appRolesList;
    }

    public Vector<T> findBy(String propertyName, String value, String orderBy,String folderPatteren) {
        Vector<T> appRolesList = new Vector<T>();
        String alias = null;
        
     //   if(folderPatteren.isEmpty())
     //      	folderPatteren="/FHA232/*|/MFD/*";

        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sqlHelper.buildSelect(alias))
                    .append(sqlHelper.buildFrom(alias))
                    .append(sqlHelper.buildWhere(alias, propertyName, "=",  value))
                    .append(" and  FOLDER_NAME REGEXP'("+folderPatteren+")'")
                    // .append(" and regexp_like(FOLDER_NAME,'("+folderPatteren+")')")
                     .append(" order by ")
                     .append(orderBy )
                     .append("  asc");

            String sqlStatement = stringBuilder.toString();
        //  String sqlStatement="SELECT FOLDER_ID, FOLDER_NAME, COMPANY_ID FROM Folders WHERE regexp_like(FOLDER_NAME,'/*/*/Production/00_HUD_UW/') and Company_ID = 1 order by Folder_Name  asc";
                    //"select role_id, role_name  from app_roles where " + propertyName + " = '" + value + "'";

            System.out.println("DAOHELPER IndexTypeDAO findByProperty2 query********** : " + sqlStatement);

            //appRolesList = getAppRolesList(DatabaseConnection.getResultSet(sqlStatement));
            appRolesList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            LOGGER.info("Error :" + e.getMessage());
        }

        return appRolesList;
    }
    
    public List<String> findByFolder(String propertyName, String value, String orderBy,String folderPatteren) {
      	 List<String> appRolesList = new ArrayList<String>();
          String alias = null;
//         String sqlStatement="SELECT FOLDER_NAME FROM Folders WHERE regexp_like(FOLDER_NAME,'("+folderPatteren+")') and COMPANY_ID ="+value+" order by Folder_Name  asc";
                      //"select role_id, role_name  from app_roles where " + propertyName + " = '" + value + "'";
          String sqlStatement="SELECT FOLDER_NAME FROM Folders WHERE FOLDER_NAME LIKE '"+folderPatteren+"%' and COMPANY_ID ="+value+" order by Folder_Name  asc";
              System.out.println("DAOHELPER IndexTypeDAO findByFolder query********** : " + sqlStatement);
            
              Connection conn=null;
              PreparedStatement st=null;
      	    ResultSet rs=null;
      	    DBManager dbm=null;
      	    try{
      	    	dbm=DBManager.getInstance();
      	    conn=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
      	    
      		Folder folder=null;
      		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");    

      		long startTime = System.currentTimeMillis();
      		System.out.println("Added folder structure successfully   "+sdf.format(startTime));
       
     	    	 if(conn!=null){
     	    		 st=conn.prepareStatement(sqlStatement);
     	    		st.setFetchSize(1000); 
     	    		 rs= st.executeQuery(sqlStatement);
     	    		 while(rs.next()){
     	    					//	folder.setCompanyId(rs.getLong("COMPANY_ID"));   	    			
     	    			appRolesList.add(rs.getString("FOLDER_NAME"));
     	    		 }
     	    	 }
     	    	 
     	    	long endTime   = System.currentTimeMillis();
     	 	//	long totalTime = endTime - startTime;
     	 		System.out.println("Added folder structure successfully   "+sdf.format(endTime));
     	    }catch(Exception e){
     	    	
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
     	    	
     	    	dbm.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
     	    }
     		
     		return appRolesList;
      }
    
    
    public Vector<T> findAll() {
        Vector<T> appRolesList = new Vector<T>();

        try {
            String sqlStatement = "select role_id, role_name  from app_roles ";
            LOGGER.info("query : " + sqlStatement);
            appRolesList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            LOGGER.info("Error :" + e.getMessage());
        }

        return appRolesList;
    }
    
    public Vector<T> findAll(String companyId) {
        Vector<T> appRolesList = new Vector<T>();

        try {
            String sqlStatement = "select role_id, role_name  from app_roles where company_id = '"+companyId+"' ";
            LOGGER.info("query : " + sqlStatement);
            appRolesList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            LOGGER.info("Error :" + e.getMessage());
        }

        return appRolesList;
    }
    
   /* public List<AppRoles> findAllDemo(String companyId) {
    	List<AppRoles> userRoleListCID = new ArrayList<AppRoles>();
    	String sqlStatement = "select role_id, role_name  from app_roles where company_id = '"+companyId+"' ";
    	Statement st =null;
    	ResultSet rs =null;
    	Connection conn = null;
    	DBManager db;
    	System.out.println("Entered");
		try {
			db = DBManager.getInstance();
			conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);
			st =conn.createStatement();
			rs=st.executeQuery(sqlStatement);
			while(rs.next()){
				AppRoles approle = new AppRoles();
	         
	        	approle.setRoleName(rs.getString("ROLE_NAME"));
	        	approle.setRoleId(rs.getInt("ROLE_ID"));
	        	userRoleListCID.add(approle);
        	
        	
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
        return userRoleListCID;
    }*/
    

    public T findById(Long id) {
        String key = null;

        for (SqlFieldHelper sqlFieldHelpers : sqlHelper.getSqlFieldHelpers()) {
            if (sqlFieldHelpers.isPrimaryKey()) {
                key = sqlFieldHelpers.getSqlFieldName();
            }
        }

        List<T> vec = findByProperty(key, id.toString());

        return vec.get(0);
    }

    /**
     * Finds the
     * @param id
     * @return
     */
    public Vector<T> findById(String id) {
        String key = null;

        for (SqlFieldHelper sqlFieldHelpers : sqlHelper.getSqlFieldHelpers()) {
            if (sqlFieldHelpers.isPrimaryKey()) {
                key = sqlFieldHelpers.getSqlFieldName();
            }
        }

        return findByProperty(key, id);
    }

    /**
     * Call to process and return a list of Objects of type T.
     *
     * @param sqlStatement
     * @return  Vector< T > the vector of the
     * @throws PenielException
     */
    public Vector<T> processSelectMulti(String sqlStatement) throws PenielException {
        Vector<T> outputList = null;
        DBManager db = DBManager.getInstance();
        System.out.println("Before conn ");
        Connection conn = null;

       System.out.println("SQL: " + sqlStatement);
        try {
        	conn=db.getPDBConnection(DbManagerValues.CONN_SOURCE);
        	System.out.println("processSelectMulti");
            dbobject rdo = new dbobject(conn);
            Vector<dbobject.dbrow> vRows = rdo.selectrowset(conn, sqlStatement);
            	System.out.println("vRows");
            outputList = processDbLinesToObjects(vRows);

        } catch (PenielException e) {
        	e.printStackTrace();
            throw (new PenielException("Exception in " + MODULE_NAME + " : getAppUserList() " + e.getExceptionMessage()));
        } catch (Exception ex) {
        	ex.printStackTrace();
            throw (new PenielException(ex, "Exception in " + MODULE_NAME + " : getAppUserList() " + ex.getMessage()));
        } finally {
        	    db.releaseConnection(DbManagerValues.CONN_SOURCE, conn);  	
        }

        return outputList;

    }

     /**
     * Call to process and return a list of Objects of type T.
     *
     * @param sqlStatement
     * @return  Vector< T > the vector of the
     * @throws PenielException
     */
    public Vector<HashMap> processSelectMultiIntoHashMap(String sqlStatement) throws PenielException {
        Vector<HashMap> outputList = null;
        DBManager db = DBManager.getInstance();
        Connection conn = null;

        //System.out.println("SQL: " + sqlStatement);
        try {
            dbobject rdo = new dbobject(conn);
//            Vector<dbobject.dbrow> vRows = rdo.selectrowset(conn, sqlStatement);
//
//            outputList = new Vector<HashMap>();
//            for (dbobject.dbrow row : vRows) {
//                HashMap record = new HashMap();
//
//                record.put("USER_ID", row.getColumn("USER_ID").getValue());
//                record.put("DIFF", ((Double)row.getColumn("DIFF").getValue()).toString());
//                outputList.add(record);
 //           }
            conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);
          	  PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
              ResultSet rs = pstmt.executeQuery();
              outputList = new Vector<HashMap>();
              HashMap record = new HashMap();
              if(rs.next()) {
              record.put("USER_ID", rs.getObject("USER_ID"));
              record.put("DIFF", (rs.getObject("DIFF")));
              }
          LOGGER.info(sqlStatement+"-------------------------------"+conn);
            outputList = new Vector<HashMap>();
            LOGGER.info(sqlStatement+"--------------record-----------------"+record);
                outputList.add(record);
 } catch (Exception ex) {
            throw (new PenielException(ex, "Exception in " + MODULE_NAME + " : getAppUserList() " + ex.getMessage()));
        } finally {
        	try {
        		if(null!=conn) {
                	
					conn.close();
        	}
        	if(null != db) {
            db.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
        	}
        	} catch (SQLException e) {
				e.printStackTrace();
			}
        }

        return outputList;

    }

    public Vector<T> processSelectMulti(String sqlStatement, ProcessRecordSetList<T> listFunction) throws PenielException {
        Vector<T> outputList = null;
        DBManager db =null;
        Connection conn =null;
        try {
        	/*try {
        	    TimeUnit.NANOSECONDS.sleep(100);
        	   
        	} catch (InterruptedException e) {
        	    //Handle exception
        	}*/
        db = DBManager.getInstance();
        conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);

        //System.out.println("SQL: " + sqlStatement);
       
            dbobject rdo = new dbobject(conn);
            Vector<dbobject.dbrow> vRows = rdo.selectrowset(conn, sqlStatement);
LOGGER.info("vRows-----"+vRows.size());
            outputList = listFunction.processRecords(vRows);
            LOGGER.info("outputList-----"+outputList.size());

        } catch (PenielException e) {
            throw (new PenielException("Exception in " + MODULE_NAME + " : getAppUserList() " + e.getExceptionMessage()));
        } catch (Exception ex) {
            throw (new PenielException(ex, "Exception in " + MODULE_NAME + " : getAppUserList() " + ex.getMessage()));
        } finally {
            db.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
        }

        return outputList;

    }

    public T processSelectSingle(String sqlStatement) throws PenielException {
        Vector<T> outputList = processSelectMulti(sqlStatement);
        if (outputList != null && outputList.size() > 0) {
            return outputList.get(0);
        }
        return null;
    }

    public T processSelectSingle(String sqlStatement, ProcessRecordSetList<T> function) throws PenielException {
        Vector<T> outputList = processSelectMulti(sqlStatement, function);
        if (outputList != null && outputList.size() > 0) {
            return outputList.get(0);
        }
        return null;
    }

    public Vector<T> processDbLinesToObjects(Vector<dbobject.dbrow> rows) {
        Vector<T> outputList = new Vector<T>();

        for (dbobject.dbrow dbrow : rows) {
            HashMap<String, dbobject.dbcol> hashMap = dbrow.getrow();

            if (hashMap.size() > 0) {
                outputList.add(processDbLineToObject(sqlHelper, dbrow));
            }
        }

        return outputList;
    }

//    public Vector<AppUser> extractAppUserList(Vector<dbobject.dbrow> vrows) {
//        Vector<AppUser> appUserList = new Vector<AppUser>();
//
//        for (dbobject.dbrow dbrow : vrows) {
//            HashMap<String, dbobject.dbcol> hashMap = dbrow.getrow();
//
//            if (hashMap.size() > 0) {
//                appUserList.add(processDbLineToObject(dbrow));
//            }
//        }
//        return appUserList;
//    }


    public T processDbLineToObject(SQLHelper<T> helper, dbobject.dbrow row) {
        return helper.buildFromDbRow(row);
    }

    public T processDbLineToObject(dbobject.dbrow row) {
        return sqlHelper.buildFromDbRow(row);
    }

    /**
     * returns the document id fetcher
     *
     * @return
     */
    public String getDocumentDataSeq() {
        return sqlHelper.getSequenceName();
    }
    public String getBatchUploadSeq() {
        return sqlHelper.getSequenceName();
    }


}