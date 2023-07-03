package com.peniel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.peniel.bus.vo.ProjectDocument;
import com.peniel.database.DatabaseConnection;



public class ProjectDocumentDAO
{
	private static Logger logger = LogManager.getLogger(ProjectDocumentDAO.class);
	
	public static HashMap getProjectDocuments(int companyId,String beginDate, String endDate) 
	{
		Vector projectIdList = new Vector();	 
		
		StringBuilder strProjetIds =new StringBuilder(300);
		HashMap projectDocumentList = new HashMap();
		try 
		{
			String sqlStatement="select distinct index_data,company_id from REQUIRED_DOCUMENTS where company_id="+
								 companyId + " and  entry_date >= DATE '"+beginDate+"'"+
							    " and entry_date <= DATE '"+ endDate+"' order by index_data ";
			logger.info("query in projectDoumentDAO 1 : "+sqlStatement);

			projectIdList = DatabaseConnection.getResultSet(sqlStatement);		
			
				   
			for(int y = 0; y < projectIdList.size(); y++)
    		{
				HashMap hashMapProjectId = new HashMap();
				hashMapProjectId =(HashMap)projectIdList.get(y);
				
				strProjetIds.append(hashMapProjectId.get("INDEX_DATA")).append(":");
				
    		}
			projectDocumentList.put("ProjectDocumentList", strProjetIds);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		//System.out.println("projectDocumentList "+projectDocumentList.size());
		return projectDocumentList;
	}

	
	
	public static ProjectDocument findById(String projectId, int companyId, String beginDate, String endDate)
	{
		ResultSet resultSet = null;
		 Vector projectDocumentList = new Vector();
		 ProjectDocument projectDocument = null;		 
		 
		try 
		{
			String sqlStatement="select * from REQUIRED_DOCUMENTS where index_data = '" + projectId +"'"+
								" and company_id="+ companyId + " and  entry_date >= DATE '"+beginDate+"'"+
							    " and entry_date <= DATE '"+ endDate+"' order by index_data ";
			logger.info("query in ProjectDocumentDAO 2 : "+sqlStatement);

			projectDocumentList = getProjectDocumentList(DatabaseConnection.getResultSet(sqlStatement));
			projectDocument = (ProjectDocument)projectDocumentList.get(0);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return projectDocument;
	}
	
	
	public static Vector getProjectDocumentList(Vector hashMapList)
	{
		Vector projectDocumentList = null;
		ProjectDocument projectDocument;
		
		projectDocumentList = new Vector();
        try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);    			
    			
    			projectDocument = new ProjectDocument();
    			projectDocument.setProjectId((String)hashMap.get("INDEX_DATA"));
    			projectDocument.setCompanyId(Long.parseLong((String)hashMap.get("COMPANY_ID")));
    			projectDocument.setEntry_date((String)hashMap.get("ENTRY_DATE"));
    			projectDocument.setDue_Date((String)hashMap.get("DUE_DATE"));
    			projectDocument.setEmails((String)hashMap.get("RESPONSIBLE_PARTY_EMAILS"));
			   
    			projectDocumentList.add(projectDocument);
			}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		
		return projectDocumentList;
	}
	
	
	 public static java.sql.Date getCurrentJavaSqlDate() {
		    java.util.Date today = new java.util.Date();
		    return new java.sql.Date(today.getTime());
		  }


	public void InsertProjectDocumentData( String cid, String projectId,
										   String entryDate, String dueDate, String emails) throws Exception 
	{
		
		DatabaseConnection dbConnection = new DatabaseConnection();
		try {
			dbConnection.setCommit(false);
						
			/*  insert REQUIRED_DOCUMENTS data */				
			String pstmt =" insert into REQUIRED_DOCUMENTS(company_id,index_data," +
					" entry_date,due_date, responsible_party_emails)" +
					" values(?,?,?,?,?)";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dtEntryDate = dateFormat.parse(entryDate);
			java.sql.Date sqlEntryDate = new java.sql.Date(dtEntryDate.getTime());
						
			Date dtDueDate = dateFormat.parse(dueDate);
			java.sql.Date sqlDueDate = new java.sql.Date(dtDueDate.getTime());
						
			PreparedStatement pst = dbConnection.connectdb(pstmt);
			
			//Iterator<String> itr = documentTypeIdList.iterator();			
			
		   // while (itr.hasNext()) {
		    	//String docTypeId = itr.next();			   
		    	pst.setInt(1, Integer.parseInt(cid));
				pst.setString(2,projectId);
			//	pst.setInt(3, Integer.parseInt(docTypeId));	
				
				pst.setDate(3,sqlEntryDate );
				pst.setDate(4,sqlDueDate);
				
				pst.setString(5,emails);
				
				pst.execute();				
			//}
			
			dbConnection.doCommit();
			dbConnection.setCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
			throw e;
		}
	}

public int DeleteProjectDocumentData( String cid, String projectId) throws Exception {
		
		DatabaseConnection dbConnection = new DatabaseConnection();
		try {		
					
			/*  delete REQUIRED_DOCUMENTS data */				
			String sqlStatement =" delete from REQUIRED_DOCUMENTS where company_id="+cid+" and index_data ='" + projectId+"'";
			logger.info("sqlStatement: "+sqlStatement);			
			int rowCount = dbConnection.execute_Update(sqlStatement);
			return rowCount;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
			throw e;
		}
	}

public void EditProjectDocumentData( String cid, String projectId,
									 String entryDate, String dueDate, String emails) throws Exception	
{
	
	DatabaseConnection dbConnection = new DatabaseConnection();
	try {		
			
		int rowCount = DeleteProjectDocumentData(cid,projectId);
		//System.out.println("rowCount "+rowCount);
		if(rowCount > 0)
		{
			InsertProjectDocumentData(cid,projectId,entryDate,dueDate, emails);
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		logger.info("Error :"+e.getMessage());
		throw e;
	}
}
/*
public void EditProjectDocumentData( String cid, String projectId,
		   String entryDate, String dueDate, String emails) throws Exception 
{

	DatabaseConnection dbConnection = new DatabaseConnection();
	try {
	dbConnection.setCommit(false);
	
			
	String pstmt =" update REQUIRED_DOCUMENTS set entry_date =? ,due_date = ?, responsible_party_emails = ? "+
				  " where company_id ="+ cid+" and index_data = "+projectId;


	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date dtEntryDate = dateFormat.parse(entryDate);
	java.sql.Date sqlEntryDate = new java.sql.Date(dtEntryDate.getTime());
	
	Date dtDueDate = dateFormat.parse(dueDate);
	java.sql.Date sqlDueDate = new java.sql.Date(dtDueDate.getTime());
	
	PreparedStatement pst = dbConnection.connectdb(pstmt);
	
	
	pst.setDate(1,sqlEntryDate );
	pst.setDate(2,sqlDueDate);	
	pst.setString(3,emails);	
	pst.execute();				
	
	
	dbConnection.doCommit();
	dbConnection.setCommit(true);
	
	} catch (Exception e) {
	e.printStackTrace();
	logger.info("Error :"+e.getMessage());
	throw e;
	}
}*/


	
}


