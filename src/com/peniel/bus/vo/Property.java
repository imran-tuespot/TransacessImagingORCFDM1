package com.peniel.bus.vo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peniel.bus.vo.sqlhelpers.CompanySQLHelper;
import com.peniel.bus.vo.sqlhelpers.PropertySQLHelper;

/**
 * 
 * @author MyEclipse Persistence Tools
 */

public class Property implements java.io.Serializable {
	 private static final Logger LOGGER = LoggerFactory.getLogger(Property.class);
	 private static PropertySQLHelper propertySQLHelper;

	// Fields
	private long id;
	private String propertyId;
	private long companyId;
	private String fhaNum;
	private String accountExec;
	private String workloadMgr;
	private String lenderNum;
	private String lenderName;
	private String servicerNum;
	private String servicerName;
	private String propertyName;
	private String city;
	private String state;
	private String zip;
	private String congressionalArea;
	private String troubleCode;
	private String reacScore;
	private String activeDeacAssignment;
	
	private String documentId;
	private String actualfilename;
	private String folderName;
	private String createDate;
	
	
	public static PropertySQLHelper getPropertySQLHelper() {
	        if (propertySQLHelper == null) {
	            try {
	                propertySQLHelper = new PropertySQLHelper();
	            } catch (Exception e) {
	                LOGGER.warn("propertySQLHelper had an error", e);
	            }
	        }
	        return propertySQLHelper;
	    }

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}


	public String getFhaNum() {
		if(fhaNum != null)
			return fhaNum;
		else
			return "";
	}

	public void setFhaNum(String fhaNum) {
		this.fhaNum = fhaNum;
	}

	public String getAccountExec() {
		if(accountExec != null)
			return accountExec;
		else
			return "";
	}

	public void setAccountExec(String accountExec) {
		this.accountExec = accountExec;
	}

	public String getWorkloadMgr() {
		if(workloadMgr != null)
			return workloadMgr;
		else
			return "";
	}

	public void setWorkloadMgr(String workloadMgr) {
		this.workloadMgr = workloadMgr;
	}

	public String getLenderNum() {
		if(lenderNum != null)
			return lenderNum;
		else
			return "";
		
	}

	public void setLenderNum(String lenderNum) {
		this.lenderNum = lenderNum;
	}

	public String getLenderName() {
		if(lenderName != null)
			return lenderName;
		else
			return "";
	}

	public void setLenderName(String lenderName) {
		this.lenderName = lenderName;
	}

	public String getServicerNum() {
		if(servicerNum != null)
			return servicerNum;
		else
			return "";
	}

	public void setServicerNum(String servicerNum) {
		this.servicerNum = servicerNum;
	}

	public String getServicerName() {
		if(servicerName != null)
			return servicerName;
		else
			return "";
	}

	public void setServicerName(String servicerName) {
		this.servicerName = servicerName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		if(city != null)
			return city;
		else
			return "";
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		if(zip != null)
			return zip;
		else
			return "";
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCongressionalArea() {
		if(congressionalArea != null)
			return congressionalArea;
		else 
			return "";
	}

	public void setCongressionalArea(String congressionalArea) {
		this.congressionalArea = congressionalArea;
	}

	public String getTroubleCode() {
		if(troubleCode != null)
			return troubleCode;
		else
			return "";
	}

	public void setTroubleCode(String troubleCode) {
		this.troubleCode = troubleCode;
	}

	public String getReacScore() {
		if(reacScore != null)
			return reacScore;
		else
			return "";
	}

	public void setReacScore(String reacScore) {
		this.reacScore = reacScore;
	}

	public String getActiveDeacAssignment() {
		if(activeDeacAssignment != null)
			return activeDeacAssignment;
		else
			return "";
	}

	public void setActiveDeacAssignment(String activeDeacAssignment) {
		this.activeDeacAssignment = activeDeacAssignment;
	}

	
	
	// Constructors	

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getActualfilename() {
		return actualfilename;
	}

	public void setActualfilename(String actualfilename) {
		this.actualfilename = actualfilename;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/** default constructor */
	public Property() {
	}

	
}

