package com.peniel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.BatchUpload;
import com.peniel.bus.vo.DocumentData;
import com.peniel.common.DAOHelper;
import com.peniel.database.DatabaseConnection;

public class BatchUploadDAO extends DAOHelper<BatchUpload> {
	 private static Logger logger = LogManager.getLogger(BatchUploadDAO.class);
	    public static final String batchUploadSeq = "BATCH_SEQ";

	    public BatchUploadDAO() {
	        super("BatchUploadDAO", BatchUpload.getBatchUploadSQLHelper());
	    }


	    public String getBatchUploadSeq() {
	        return batchUploadSeq;
	    }

	 

	    public void InsertBatchUploadData(String uid, String batchFileName,String cid,String sessionid,String description
	            ) throws Exception {
	        DatabaseConnection dbConnection = new DatabaseConnection();
	        try {
	            dbConnection.setCommit(false);
	            String sqlStatement = "INSERT INTO BATCH_UPLOAD ";
	            sqlStatement += "(USER_ID,BATCH_FILENAME,COMPANY_ID,UPLOAD_DATE,STATUS,LAST_SESSION_ID,DESCRIPTION) VALUES ("+uid+",'"+batchFileName+"',"+ cid +"," + "sysdate," + "'Pending'"+",'" + sessionid + "','"+description+"')";

	            logger.info("query : " + sqlStatement);
	            dbConnection.executeUpdate(sqlStatement);
	           

	            dbConnection.doCommit();
	            dbConnection.setCommit(true);

	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            logger.info("Error :" + e.getMessage());
	            throw e;
	        }
	    }
	    
	    public Vector<BatchUpload> findByUserId(String propertyName, String value, String cId) {
	        try {
	            String sqlStatement = "select * from batch_upload where " + propertyName + " = '" + value + "'"+
	            		 " and company_id="+cId+" and to_char(upload_date,'YYYY-MM-DD') >= to_char((sysdate-7),'YYYY-MM-DD')";
	            logger.info("query : " + sqlStatement);

	            return processSelectMulti(sqlStatement);
	        } catch (Exception e) {
	            e.printStackTrace();
	            logger.info("Error :" + e.getMessage());
	            return null;
	        }
	    }

	}
