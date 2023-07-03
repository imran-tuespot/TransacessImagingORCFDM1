package com.peniel.bus.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peniel.bus.vo.sqlhelpers.SessionLogSQLHelper;
import com.peniel.bus.vo.sqlhelpers.UserLogSQLHelper;

public class UserLog implements java.io.Serializable {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLog.class);
    private static UserLogSQLHelper userLogSQLHelper;


	// Fields
	private String userSessionId;
	private String firstName;
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

	private String lastName;
	
	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDateOfChg() {
		return dateOfChg;
	}

	public void setDateOfChg(String dateOfChg) {
		this.dateOfChg = dateOfChg;
	}

	public String getFieldChanged() {
		return fieldChanged;
	}

	public void setFieldChanged(String fieldChanged) {
		this.fieldChanged = fieldChanged;
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

	private int userId;
	private String dateOfChg;	
	private String fieldChanged;
	private String oldValue;
	private String newValue;

	
    public static UserLogSQLHelper getUserLogSQLHelper() {
        if (userLogSQLHelper == null) {
            try {
                userLogSQLHelper = new UserLogSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("userLogSQLHelper had an error", e);
            }
        }
        return userLogSQLHelper;
    }

	// Constructors

	@Override
	public String toString() {
		return "UserLog [userSessionId=" + userSessionId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userId=" + userId + ", dateOfChg=" + dateOfChg + ", fieldChanged=" + fieldChanged + ", oldValue="
				+ oldValue + ", newValue=" + newValue + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getUserSessionId()=" + getUserSessionId() + ", getUserId()=" + getUserId()
				+ ", getDateOfChg()=" + getDateOfChg() + ", getFieldChanged()=" + getFieldChanged() + ", getOldValue()="
				+ getOldValue() + ", getNewValue()=" + getNewValue() + "]";
	}

	/** default constructor */
	public UserLog() {
	}

	
	
}
