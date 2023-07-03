package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.AppRolesSQLHelper;
import com.peniel.bus.vo.sqlhelpers.UserTypeSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * UserType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class UserType implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserType.class);
    private static UserTypeSQLHelper userTypeSQLHelper;

	// Fields

	private long userTypeId;
	private String userType;
	//private Set appUsers = new HashSet(0);

    public static UserTypeSQLHelper getUserTypeSQLHelper() {
        if (userTypeSQLHelper == null) {
            try {
                userTypeSQLHelper = new UserTypeSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("userTypeSQLHelper had an error", e);
            }
        }
        return userTypeSQLHelper;
    }

	// Constructors

	/** default constructor */
	public UserType() {
	}

	/** minimal constructor */
	public UserType(long userTypeId, String userType) {
		this.userTypeId = userTypeId;
		this.userType = userType;
	}

	/** full constructor */
	public UserType(long userTypeId, String userType, Set appUsers) {
		this.userTypeId = userTypeId;
		this.userType = userType;
		//this.appUsers = appUsers;
	}

	// Property accessors

	public long getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(long userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

//	public Set getAppUsers() {
//		return this.appUsers;
//	}
//
//	public void setAppUsers(Set appUsers) {
//		this.appUsers = appUsers;
//	}

}