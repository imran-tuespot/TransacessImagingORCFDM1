package com.peniel.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.peniel.bus.vo.DocumentType;
import com.peniel.bus.vo.Folder;
import com.peniel.common.DAOHelper;
import com.peniel.common.DBManager;
import com.peniel.common.DbManagerValues;
import com.peniel.common.PenielException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.IndexType;
import com.peniel.database.DatabaseConnection;




public class FolderDAO  extends DAOHelper<Folder>
{
	private static Logger logger = LogManager.getLogger(FolderDAO.class);

    public FolderDAO() {
        super("FolderDAO", Folder.getFolderSQLHelper());
    }


	public Vector<Folder> findByFolderName(String folderName)
	{
		return findByProperty("FOLDER_NAME", folderName);
	}
	public Vector<Folder> findByFolderId(String folderId)
	{
		return findByProperty("FOLDER_Id", folderId);
	}
	
	
	public Vector findByFolderNames(String folderName) {
	       

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
	        	
	        	String sqlStatement = "	select company_id, folder_id, folder_name from folders where "
	            		+ "folder_name = '"+folderName +"' ";
	        	
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
			        //	System.out.println("columnNames.get(z)-->"+columnNames.get(z)+"<-- resultSet.getString(z+1) -->"+rs.getString(z+1)+"<---");
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
	 public Map<String,Integer> findByDataDocFolder(String cId,List<String> folderPatteren) {
	     	int count=0;  
	     	 Map<String,Integer> countMap=new HashMap<String,Integer>();
	     /*	
	        String sqlStatement="select count(*) as count from document_data a , document_type b, index_type c, search_data d,folders e, document_folders f, "
	        		+ "property p where a.document_type_id=b.document_type_id and d.index_type_id = c.index_type_id and "
	        		+ "a.document_id = d.document_id and a.document_id = f.document_id and e.folder_id = f.folder_id "
	        		+ "and a.PROPERTY_ID = p.id and  upper(e.folder_name) = upper('"+folderPatteren+"')"
	        		+ "and p.COMPANY_ID="+cId+" order by a.filename,index_type,index_data, b.document_type_id ";
	                  
	             System.out.println("DAOHELPER IndexTypeDAO findByDataDocFolder query********** : " + sqlStatement);*/
	           
	             Connection conn=null;
	             PreparedStatement st=null;
	     	    ResultSet rs=null;
	     	    DBManager dbm=null;
	     	    		/*conn=DatabaseConnection.getDatabaseConnection();
	     	    		 System.out.println("folderPatteren 45654"+folderPatteren);*/
	    	    	 //if(conn!=null){
	     	   try{
	     		   dbm=DBManager.getInstance();
	     		  conn=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
	     		  System.out.println("================"+folderPatteren);
	    	    		 for(String folderdata:folderPatteren){    	    			
	    	    			
		     	    		//System.out.println("folderPatteren 45654"+folderPatteren);
	    	    		/* st=conn.prepareStatement("select count(*) as count from document_data a , document_type b, index_type c, search_data d,folders e, document_folders f, "
	    	    	        		+ "property p where a.document_type_id=b.document_type_id and d.index_type_id = c.index_type_id and "
	    	    	        		+ "a.document_id = d.document_id and a.document_id = f.document_id and e.folder_id = f.folder_id "
	    	    	        		+ "and a.PROPERTY_ID = p.id and  upper(e.folder_name) = upper('"+folderdata+"')"
	    	    	        		+ "and p.COMPANY_ID="+cId+" order by a.filename,index_type,index_data, b.document_type_id ");   */ 	    	
//	    	    			 st=conn.prepareStatement("select count(*) as count from document_data a , index_type c, search_data d,folders e, document_folders f, "
//	     	    	        		+ "property p where d.index_type_id = c.index_type_id and "
//	     	    	        		+ "a.document_id = d.document_id and a.document_id = f.document_id and e.folder_id = f.folder_id "
//	     	    	        		+ "and a.PROPERTY_ID = p.id and  upper(e.folder_name) = upper('"+folderdata+"')"
//	     	    	        		+ "and p.COMPANY_ID="+cId+" order by a.filename,index_type,index_data ");
	    	    			 st=conn.prepareStatement("select count(*) as count from document_data a ,folders e, document_folders f, property p where a.document_id = f.document_id and "+
	    			 	            " e.folder_id = f.folder_id and a.PROPERTY_ID = p.id and "+
	    			 		"e.folder_name ='"+folderdata+"' and p.COMPANY_ID="+cId+" and a.version=(select max(q.version) from document_data q where q.document_id=a.document_id) order by e.folder_Name  asc");
		    	    		// System.out.println("======st======"+st);
	    	    		 rs= st.executeQuery();
	    	    		 while(rs.next()){
	    	    					//	folder.setCompanyId(rs.getLong("COMPANY_ID"));   	    			
	    	    			 count=rs.getInt("count");
	    	    		 }
	    	    		 String[] folderinfo=folderdata.split("/");
	    	    		// System.out.println(folderinfo[folderinfo.length-1]+"=====148===="+count);
	    	    		  countMap.put(folderinfo[folderinfo.length-1], count);
	    	    		
	    	    	// }
	    	    	 
	    	    	// System.out.println("countmap for asset management"+countMap);
	    	    		 }
	    	    }catch(Exception e){
	    	    		    	    	
	    	    	try {
	    	    		if(rs!=null)
	    	    		{
	  				rs.close();
	    	    		}
	    	    		if(st!=null){
	  				st.close();
	    	    	}
	  			} catch (SQLException ex) {
	  				// TODO Auto-generated catch block
	  				ex.printStackTrace();
	  			}
	    	    	//System.out.println("countmap87687");
	    	    	//DatabaseConnection.disconnectdb();
	    	    	dbm.releaseConnection(DbManagerValues.CONN_SOURCE,conn);
	    	    }finally{
	    	    	try {
	    	    		if(rs!=null)
	    	    		{
	  				rs.close();
	    	    		}
	    	    		if(st!=null){
	  				st.close();
	    	    	}
	  			} catch (SQLException e) {
	  				// TODO Auto-generated catch block
	  				e.printStackTrace();
	  			}
	    	    	//System.out.println("countmap87687");
	    	    	DatabaseConnection.disconnectdb();
	    	    }
	     	  
	    		return countMap;
	     }
	
	public Folder findByIdCompany(String folderId, String companyId)
	{
		 Folder folder = null;
		 
		 
		try 
		{
			String sqlStatement="select * from folders where folder_id = '" + folderId +"' and company_id = '"+companyId +"'";
			logger.info("query  : "+sqlStatement);

            folder = processSelectSingle(sqlStatement);
			//indexTypeList = getIndexTypeList(DatabaseConnection.getResultSet(sqlStatement));
			//indexType = (IndexType)indexTypeList.get(0);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return folder;
	}
	
	
	public synchronized void insertFolder(String companyId,String folderName) throws PenielException 
	{
	        //long id = getNextId("index_type_seq");
		   // int  id = getMax();
	       //executeInsert("insert into folders (Company_id, folder_id, folder_name) values " +
	        //        "(" + companyId + ", " + id + ", '" + folderName + "')");
		addFolder(companyId,folderName);
	    
	}
	
	public synchronized Integer addFolder(String companyId,String folderName) throws PenielException 
	{
	        //long id = getNextId("index_type_seq");
		    int id =  getMax();
		    System.out.println("id in add folder===="+id);
		    String sql = "insert into folders (Company_id, folder_id, folder_name) values (" + companyId + ", " + id + ", '" + folderName + "')";
		    System.out.println("sql-->"+sql);
	        //executeInsert(sql);
		    Connection con=null;
	        Statement stmt=null;
	        DBManager dbm=null;
	        try {
		       dbm =DBManager.getInstance();
	        	con=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
	        	stmt=con.createStatement();
	        	stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
	        	 dbm.releaseConnection(DbManagerValues.CONN_SOURCE, con);
			}
	                
	        
	        return id;
	    
	}
	
	public void editFolder(String companyId,String oldFolderName,String folderName)throws PenielException 
	{
	        long id = getNextId("index_type_seq");
	        executeUpdate("update folders set folder_Name = " +"'" + folderName + "' where company_Id ='"+companyId +"' and " +
	        		" folder_name = '"+oldFolderName+"'");
	    
	}

	public  Boolean deleteFolder(String companyId,String folderName ) throws PenielException
	{
		DatabaseConnection dbConnection = new DatabaseConnection();
		try {		
					
			/*  delete folder */
			String sqlStatement =" delete from Folders where company_id="+companyId+" and folder_name ='" + folderName+"'";
			logger.info("sqlStatement: "+sqlStatement);			
			int rowCount = dbConnection.execute_Update(sqlStatement);
					
		} catch (Exception e) {
			//e.printStackTrace();
			logger.info("Error :"+e.getMessage());
			return false;
		}
		return true;
	}
	public  int  getMax1() throws PenielException
	{
		DatabaseConnection dbConnection = new DatabaseConnection();
		int folderId = 0;
		try {		
					
			String sqlStatement =" select CAST((max(folder_id)) AS DOUBLE) as RESULT from Folders";
			logger.info("sqlStatement: "+sqlStatement);			
			folderId = dbConnection.getSingleValue(sqlStatement);
					
		} catch (Exception e) {
			//e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		return folderId;
	}
	public  int  getMax() throws PenielException{
  		// TODO Auto-generated method stub
      	  Connection conn=null;
      	CallableStatement stmt=null;
      	ResultSet rs= null;
      	DBManager dbm=null;
      	 long nextId =0;
    	    try{
    	    	dbm=DBManager.getInstance();
    	    conn=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
  			
  		stmt = (CallableStatement)conn.prepareCall("{CALL get_folder_seq(?)}");
       stmt.registerOutParameter(1, java.sql.Types.DOUBLE);
       stmt.executeUpdate();
       nextId = stmt.getLong(1);     
            	
  		System.out.println("sqlQuery:MAXiii FOLDER ID%%%%img UI%%%%%%%%%%%"+nextId + "***");
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
   	    	
   	    	//DatabaseConnection.disconnectdb();
   	    	dbm.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
   	    }
    	  return (int)(long)nextId;
    }
	
	public synchronized void callProcFolderStructure(String propertyId,String compId) throws PenielException{
	  	Connection conn=null;
	  	CallableStatement stmt=null;
	  	DBManager dbm=null;
		    try{
		    	dbm=DBManager.getInstance();
		    conn=dbm.getPDBConnection(DbManagerValues.CONN_SOURCE);
		System.out.println(compId+"*********CALL PROC START *********"+propertyId);	
			stmt = (CallableStatement)conn.prepareCall("{CALL p_folder_structure_test1(?,?)}");
	   stmt.setString(1,propertyId );
	   stmt.setInt(2, Integer.parseInt(compId));
	   stmt.executeUpdate();
		System.out.println("*********call proc end*********");

		    }catch(Exception e){
		    	logger.info("sqlQuery callProcFolderStructure:"+e.getMessage());
		    }finally{
		    	try {
		    		 
		    		 if(stmt !=null){
		    			stmt.close();
		    		 }
		    		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    	
		    	//DatabaseConnection.disconnectdb();
		    	dbm.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
		    }
	}
	    
}


