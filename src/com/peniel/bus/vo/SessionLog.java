package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.AppRolesSQLHelper;
import com.peniel.bus.vo.sqlhelpers.SessionLogSQLHelper;
import com.peniel.bus.vo.sqlhelpers.StatesSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * SearchData entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SessionLog implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionLog.class);
    private static SessionLogSQLHelper sessionLogSQLHelper;

	// Fields
	private String sessionId;
	private int userId;
	private int companyId;
	private String dtm;
	private String action;
	private int docId;
	private int version;
	private String description;
	private String fieldName;
	private String oldValue;
	private String newValue;
	
	private String firstName;
	private String lastName;
	
    public static SessionLogSQLHelper getSessionLogSQLHelper() {
        if (sessionLogSQLHelper == null) {
            try {
                sessionLogSQLHelper = new SessionLogSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("statesSQLHelper had an error", e);
            }
        }
        return sessionLogSQLHelper;
    }

	// Constructors

	/** default constructor */
	public SessionLog() {
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getDtm() {
		return dtm;
	}

	public void setDtm(String dtm) {
		this.dtm = dtm;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
}