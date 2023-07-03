package com.peniel.bus.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peniel.bus.vo.sqlhelpers.BatchUploadSQLHelper;
import com.peniel.bus.vo.sqlhelpers.DocumentDataSQLHelper;

public class BatchUpload implements java.io.Serializable{
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchUpload.class);
    private static BatchUploadSQLHelper batchUploadSQLHelper;
    
 // Fields
    private String batchFilename;
    public String getBatchFilename() {
		return batchFilename;
	}
	public void setBatchFilename(String batchFilename) {
		this.batchFilename = batchFilename;
	}
	private long companyId;
 	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getProcessDate() {
		return processDate;
	}
	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}
	private String uploadDate;
 	private String processDate;
 	private String status;
 	private String description;
 	private String userId;
 	
 	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	} 	
 	
 	
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public static BatchUploadSQLHelper getBatchUploadSQLHelper() {
	        if (batchUploadSQLHelper == null) {
	            try {
	            	batchUploadSQLHelper = new BatchUploadSQLHelper();
	            } catch (Exception e) {
	                LOGGER.warn("BatchUploadSQLHelper had an error", e);
	            }
	        }
	        return batchUploadSQLHelper;
	    }

}
