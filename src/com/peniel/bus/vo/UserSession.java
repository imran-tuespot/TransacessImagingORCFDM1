package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.AppRolesSQLHelper;
import com.peniel.bus.vo.sqlhelpers.UserSessionSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * UserSession entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class UserSession implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSession.class);
    private static UserSessionSQLHelper userSessionSQLHelper;

	// Fields

	private String sessionId;
	private long userId;
	private String lastUpdated;
	private String closedOn;
	private long companyId;
	private String username;
	private String ipAddress;

    public static UserSessionSQLHelper getUserSessionSQLHelper() {
        if (userSessionSQLHelper == null) {
            try {
                userSessionSQLHelper = new UserSessionSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("userSessionSQLHelper had an error", e);
            }
        }
        return userSessionSQLHelper;
    }

	// Constructors

	/** default constructor */
	public UserSession() {
	}

	/** minimal constructor */
	public UserSession(String sessionId, String lastUpdated) {
		this.sessionId = sessionId;
		this.lastUpdated = lastUpdated;
	}

	/** full constructor */
	public UserSession(String sessionId, long userId, String lastUpdated,
			String closedOn) {
		this.sessionId = sessionId;
		this.userId = userId;
		this.lastUpdated = lastUpdated;
		this.closedOn = closedOn;
	}

	// Property accessors

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getClosedOn() {
		return this.closedOn;
	}

	public void setClosedOn(String closedOn) {
		this.closedOn = closedOn;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}