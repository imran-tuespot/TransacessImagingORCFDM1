package com.peniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jmesa.worksheet.WorksheetRow;

import com.peniel.bus.vo.Property;
import com.peniel.common.DAOHelper;
import com.peniel.common.PenielException;
import com.peniel.common.dbobject;
import com.peniel.database.DatabaseConnection;


public class PropertyDAO extends DAOHelper<Property> {
    private static Logger logger = LogManager.getLogger(PropertyDAO.class);
    public static final String propertyDataSeq = "property_seq";
	List<Property> properties;

    
    public PropertyDAO() {
        super("PropertyDAO", Property.getPropertySQLHelper());
    }

    @Override
    public String getDocumentDataSeq() {
        return propertyDataSeq;
    }

    @Override
    public Property processDbLineToObject(dbobject.dbrow row) {
        return null;
    }

    public boolean deleteProperty(String id){
    	boolean deleted = false;
    	try{
    		String sql = "delete from property where id = '"+id+"'";
    		logger.info("sql-->"+sql);
    		executeUpdate(sql);
    		deleted = true;
    	}catch(Exception e){
    		System.out.println("Exception encountered while deleting property-->"+e.getMessage());
    	}
    	
    	return deleted;
    	
    }
    public  boolean insertIntoProperty(int seq,long companyId, String propertyId,
    		String fhaNum,String accountExec,String workloadMgr,String lenderNum,
    		String lenderName,String servicerNum,String servicerName,String propertyName,String city,String state,
    		String zip,String congressionalArea,String troubleCode,String reacScore,
    		String activeDeacAssignment) {
    	
    	boolean inserted = false;
			try {
				String sqlStatement = "insert into property (id,company_Id, property_Id,fha_Num,account_Exec,workload_Mgr,lender_Num,"+
        		               	      " lender_Name,servicer_Num,servicer_Name,property_Name,city,state,zip,congressional_Area,trouble_Code,reac_Scrore,"+
        			                  " active_Deac_Assignement) values (" +seq+","+ companyId + ", '" + propertyId + "'" +
        			                  ", '" + fhaNum + "', '" + accountExec +"', '" + workloadMgr +"', '" + lenderNum +"', '" + lenderName +
        			                  "', '" + servicerNum +"','"+servicerName +"', '" + propertyName +"', '" + city +"', '" + state +"', '" + zip +"', '"  + 
        			                  congressionalArea +"', '" + troubleCode +"', '" + reacScore+"','"+activeDeacAssignment+"' )";
				logger.info("insert into property query : " + sqlStatement);
				executeInsert(sqlStatement);
				inserted = true;
			
			} catch (PenielException e) {
				inserted = false;
				e.printStackTrace();
				
			}
	
	return inserted;
	}
    
    public  boolean insertNewProperty(int companyId, WorksheetRow worksheetRow) {
    	
    	boolean inserted = false;
			try {
				int seq = (int) getNextId();
				String propertyId = worksheetRow.getColumn("propertyId").getChangedValue();
				String propertyName = worksheetRow.getColumn("propertyName").getChangedValue();
				String zip = worksheetRow.getColumn("zip").getChangedValue();
				String lenderNum = worksheetRow.getColumn("lenderNum").getChangedValue();
				String lenderName = worksheetRow.getColumn("lenderName").getChangedValue();
				String activeDeacAssignment = worksheetRow.getColumn("activeDeacAssignment").getChangedValue();
				String state = worksheetRow.getColumn("state").getChangedValue();
				String city = worksheetRow.getColumn("city").getChangedValue();
				String congressionalArea = worksheetRow.getColumn("congressionalArea").getChangedValue();
				String accountExec = worksheetRow.getColumn("accountExec").getChangedValue();
				String servicerNum = worksheetRow.getColumn("servicerNum").getChangedValue();
				String workloadMgr = worksheetRow.getColumn("workloadMgr").getChangedValue();
				String servicerName = worksheetRow.getColumn("servicerName").getChangedValue();
				String troubleCode = worksheetRow.getColumn("troubleCode").getChangedValue();
				String reacScore = worksheetRow.getColumn("reacScore").getChangedValue();
				
				String sqlStatement = "insert into property (id,company_Id, property_Id,account_Exec,workload_Mgr,lender_Num,"+
        		               	      " lender_Name,servicer_Num,servicer_Name,property_Name,city,state,zip,congressional_Area,trouble_Code,reac_Scrore,"+
        			                  " active_Deac_Assignement) values (" +seq+","+ companyId + ", '" + propertyId + "'" +
        			                  ", '" + accountExec +"', '" + workloadMgr +"', '" + lenderNum +"', '" + lenderName +
        			                  "', '" + servicerNum +"','"+servicerName +"', '" + propertyName +"', '" + city +"', '" + state +"', '" + zip +"', '"  + 
        			                  congressionalArea +"', '" + troubleCode +"', '" + reacScore+"','"+activeDeacAssignment+"' )";
				logger.info("insert into property query : " + sqlStatement);
				executeInsert(sqlStatement);
				inserted = true;
			
			} catch (PenielException e) {
				inserted = false;
				e.printStackTrace();
				
			}
	
	return inserted;
	}
    
    
    public static long getNewPropertyId()
	{
        try {
            PropertyDAO propertyDao = new PropertyDAO();
            return propertyDao.getNextId();
        } catch (PenielException e) {
            System.out.println("Cannot Get new property ID");
        }
        return 0;
	}
    
    public Vector<Property> findByProperty(String propertyName, String value) {
        ResultSet resultSet = null;
        Vector<Property> propertyList = new Vector<Property>();


        try {
            String sqlStatement = "select *  from property where " + propertyName + " = '" + value + "'";

            logger.info("query : " + sqlStatement);

            propertyList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            logger.info("Error :" + e.getMessage());
        }

        return propertyList;
    }
    
    public Vector<Property> findByPropertyId(String value) {
        ResultSet resultSet = null;
        Vector<Property> propertyList = new Vector<Property>();


        try {
            String sqlStatement = "select *  from property where property_id='" + value+"'";

            logger.info("query : " + sqlStatement);

            propertyList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            logger.info("Error :" + e.getMessage());
        }

        return propertyList;
    }
    
    

    public Vector<Property> findByPropertyId(String cId, String propertyId) {
        ResultSet resultSet = null;
        Vector<Property> propertyList = new Vector<Property>();


        try {
            String sqlStatement = "select *  from property where  company_id =" + cId + " and upper(property_Id) = '"+propertyId.toUpperCase()+"'";

            logger.info("query : " + sqlStatement);

            propertyList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            logger.info("Error :" + e.getMessage());
        }

        return propertyList;
    }
    public static Property getNewProperty() {
    	Property property = new Property();
    	property.setPropertyId("");
    	property.setPropertyName("");
    	property.setLenderNum("");
    	property.setLenderName("");

    	
        
        return property;
	}
    
    public Vector<Property> findProperties(String cId) {
        ResultSet resultSet = null;
        Vector<Property> propertyList = new Vector<Property>();


        try {
            String sqlStatement = "select /*+ result_cache */ property_id,id from property where  company_id =" + cId + " order by property_id";

            logger.info("query : " + sqlStatement);

            propertyList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            logger.info("Error :" + e.getMessage());
        }

        return propertyList;
    }
    public List<String> findPropertiesdata(String cId) {
        List<String> propertyList = new ArrayList<String>();
         Connection conn=null;
         PreparedStatement st=null;
 	    ResultSet rs=null;
 	    Property property=null;	    

         try {
             String sqlStatement = "select /*+ result_cache */ property_id,id from property where  company_id =" + cId + " order by property_id";

             logger.info("query : " + sqlStatement);
             
     	    conn=DatabaseConnection.getDatabaseConnection();
     	    try{
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
       	    			propertyList.add(rs.getString("property_id"));
       	    		 }
       	    		}
       	    	 }
       	    	 
       	    
       	    }catch(Exception e){
       	    	
       	    }finally{
       	    	rs.close();
       	    	st.close();
       	    	DatabaseConnection.disconnectdb();
       	    }

             //propertyList = processSelectMulti(sqlStatement);
         } catch (Exception e) {
             logger.info("Error :" + e.getMessage());
         }

         return propertyList;
     }
    public Vector<Property> findPropertiesNames(String cId) {
        ResultSet resultSet = null;
        Vector<Property> propertyList = new Vector<Property>();


        try {
            String sqlStatement = "select /*+ result_cache */ property_name,id from property where  company_id =" + cId + " order by property_name";

            logger.info("query : " + sqlStatement);

            propertyList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            logger.info("Error :" + e.getMessage());
        }

        return propertyList;
    }
    public Vector<Property> findByCompanyId(String cId) {
        ResultSet resultSet = null;
        Vector<Property> propertyList = new Vector<Property>();


        try {
            String sqlStatement = "select *  from property where  company_id =" + cId ;

            logger.info("query : " + sqlStatement);

            propertyList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            logger.info("Error :" + e.getMessage());
        }

        return propertyList;
    }
    
    public Vector<Property> findById(String id) {
        ResultSet resultSet = null;
        Vector<Property> propertyList = new Vector<Property>();

        
    	try {
            String sqlStatement = "select *  from property where  id =" + id ;

            logger.info("query : " + sqlStatement);

            propertyList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            logger.info("Error :" + e.getMessage());
        }
        	
        return propertyList;
    }

    
    public Map<String, Property> getPropertiesAsMap(List<String> paramValue) {

        Map<String, Property> results = new HashMap<String, Property>();

        for(String id : paramValue){
	        for (Property property : findById(id)) {
	        	System.out.println("getPropertiesAsMap property id -->"+property.getId());
	            results.put(String.valueOf(property.getId()), property);
	        }
        }
        
        return results;
    }


   public Vector<Property> findByPropertyName(String propertyName) {
        return findByProperty("Property_Name", propertyName);
    }

    public Vector<Property> findById(String cId,String propertyId) {
        return findByPropertyId(cId,propertyId);
    }

    public boolean updateProperty(Property property) {
    	boolean success = false;
        try {
            StringBuffer sqlStatement = new StringBuffer();
            sqlStatement.append("update property set  ");

            sqlStatement.append("property_id = '" + property.getPropertyId() + "', ");
            sqlStatement.append("property_name = '" + property.getPropertyName() + "', ");
            sqlStatement.append("city = '" + property.getCity() + "', ");
            sqlStatement.append("state = '" + property.getState() + "', ");
            sqlStatement.append("zip = '" + property.getZip() + "', ");
            sqlStatement.append("fha_Num = '" + property.getFhaNum() + "', ");
            sqlStatement.append("account_Exec = '" + property.getAccountExec() + "', ");
            sqlStatement.append("workload_Mgr = '" + property.getWorkloadMgr() + "', ");
            sqlStatement.append("lender_Num = '" + property.getLenderNum() + "', ");
            sqlStatement.append("lender_Name = '" + property.getLenderName() + "', ");
            sqlStatement.append("servicer_Num = '" + property.getServicerNum() + "', ");
            sqlStatement.append("servicer_Name = '" + property.getServicerName() + "', ");
            sqlStatement.append("congressional_Area = '" + property.getCongressionalArea() + "', ");
            sqlStatement.append("trouble_Code = '" + property.getTroubleCode() + "', ");
            sqlStatement.append("reac_Scrore = '" + property.getReacScore() + "', ");
            sqlStatement.append("active_Deac_Assignement = '" + property.getActiveDeacAssignment() + "' ");

            sqlStatement.append(" where id = " + property.getId());

            logger.info("query1 : " + sqlStatement);

            executeUpdate(sqlStatement.toString());
            success = true;
            
            
        } catch (Exception e) {
        	success = false;
            e.printStackTrace();
        }
        return success;
    }

//	public static Property findById(Long companyId)
//	{
//		ResultSet resultSet = null;
//		 Vector companyList = new Vector();
//		 Property company = null;
//		 
//		 
//		try 
//		{
//			String sqlStatement="select company_id, company_name, address1, address2, city, state, zip  from company where company_id = " + companyId;
//			//System.out.println(sqlStatement);
//
//			companyList = getCompanyList(DatabaseConnection.getResultSet(sqlStatement));
//			
//			company = (Property)companyList.get(0);
//			
//			
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		
//		return company;
//	}


//    public Vector<Property> getCompanyList(Vector hashMapList) {
//        Vector<Property> companyList = null;
//        Property company;
//
//        companyList = new Vector<Property>();
//        try {
//            for (int y = 0; y < hashMapList.size(); y++) {
//                HashMap hashMap = new HashMap();
//                hashMap = (HashMap) hashMapList.get(y);
//
//                company = new Property();
//                company.setCompanyId(Long.parseLong((String) hashMap.get("COMPANY_ID")));
//                company.setCompanyName((String) hashMap.get("COMPANY_NAME"));
//                company.setAddress1((String) hashMap.get("ADDRESS1"));
//                company.setAddress2((String) hashMap.get("ADDRESS2"));
//                company.setCity((String) hashMap.get("CITY"));
//                company.setState((String) hashMap.get("STATE"));
//                company.setZip((String) hashMap.get("ZIP"));
//
//                companyList.add(company);
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            logger.info("Error :" + e.getMessage());
//        }
//
//
//        return companyList;
//    }
    
    
    
    
	public Collection<Property> getProperties(int companyId) {
		List<Property> properties;
		
    	properties = new ArrayList<Property>();
    	
    	String sqlStatement = "select * from property where  company_id =" + companyId + " order by id desc";
    	logger.info("query : " + sqlStatement);
        try{
        	Vector<Property> prop = processSelectMulti(sqlStatement);
        	
        	for(int i=0; i<prop.size(); i++){
        		properties.add((Property)prop.get(i));
        	}
        }catch(PenielException ex){
        	logger.info("Exception in getProperties -->"+ex.getMessage());
        }
        /*
        for(Property d:properties) {
            System.out.println("List of properties "+d.getPropertyId());
        } */    
        return properties;
    }
	
	public Collection<Property> getPropertyDocuments(int companyId, String propertyId) {
		List<Property> properties;
		
    	properties = new ArrayList<Property>();
    	
    	String sqlStatement = "select d.document_id documentId, d.actualfilename actualfilename, to_char(d.create_date,'mm/dd/yyyy') createDate, f.folder_name folderName " +
    			"from property p,document_data d,folders f where p.company_id = " + companyId + " and p.property_id = upper('" + propertyId + "') and p.id = d.property_id and d.folder_id = f.folder_id";
    	
    	logger.info("query : " + sqlStatement);
        try{
        	
        	properties = getPropertyDocsList(DatabaseConnection.getResultSet(sqlStatement));
        	/*
        	for(int i=0; i<prop.size(); i++){
        		Property p = (Property)prop.get(i);
        		System.out.println("docid -->"+p.getDocumentId());
        		System.out.println("actualfilename -->"+p.getActualfilename());
        		System.out.println("foldername -->"+p.getFolderName());
        		System.out.println("create date -->"+p.getCreateDate());
        		
        		properties.add((Property)prop.get(i));
        	}*/
        }catch(Exception ex){
        	logger.info("Exception in getPropertyDocuments -->"+ex.getMessage());
        }
       
        return properties;
    }
	
	public Vector<Property> getPropertyDocsList(Vector hashMapList) {
        Vector propDocList = null;
        propDocList = new Vector();
        try {
            for(int y = 0; y < hashMapList.size(); y++){
	            if (hashMapList.size() > 0) {
	                
	            	HashMap hashMap = new HashMap();
	                Property property = new Property();
	                
	                hashMap = (HashMap) hashMapList.get(y);
	                property.setDocumentId((String) hashMap.get("DOCUMENTID"));
	                property.setActualfilename(((String) hashMap.get("ACTUALFILENAME")));
	                property.setFolderName(((String) hashMap.get("FOLDERNAME")));
	                property.setCreateDate((String) hashMap.get("CREATEDATE"));
	                
	
	                propDocList.add(property);
	            }
        	}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.info("Error :" + e.getMessage());
        }

        return propDocList;
    }
	    

}












