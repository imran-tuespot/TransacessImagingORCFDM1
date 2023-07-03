package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.AppUserSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractAppUser entity provides the base persistence definition of the
 * AppUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AppUser implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppUser.class);

    private static AppUserSQLHelper appUserSQLHelper;

	// Fields
	private long userId;
	private long companyId;
	private long userTypeId;
	private String userRoleId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String phoneNo;
	private String status;
	private String cellPhone;
	private String secondEmail;
	private String jobTitle;
	private String PasswordStatus;
	private String AcceptMails;
	
	private Set userSessions = new HashSet(0);
	public String role;
	public String roleId;
	public int authId;
	public int mfaStatus;
	public String otp;
	// Constructors

	/** default constructor */
	public AppUser() {
	}

	/** minimal constructor */
	public AppUser(long userId, long companyId, String username) {
		this.userId = userId;
		this.companyId = companyId;
		this.username = username;
	}

	/** full constructor */
	

	// Property accessors

    public static AppUserSQLHelper getAppUserSQLHelper() {
        if (appUserSQLHelper == null) {
            try {
                appUserSQLHelper = new AppUserSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("appUserSQLHelper had an error", e);
            }
        }
        return appUserSQLHelper;
    }

    public AppUser(long userId, long companyId, long userTypeId, String userRoleId, String username, String password,
			String firstName, String lastName, String address1, String address2, String city, String state, String zip,
			String email, String phoneNo, String status, String cellPhone, String secondEmail, String jobTitle,
			String passwordStatus, String acceptMails, Set userSessions, String role, String roleId,int authId,int mfaStatus,String otp) {
		super();
		this.userId = userId;
		this.companyId = companyId;
		this.userTypeId = userTypeId;
		this.userRoleId = userRoleId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.phoneNo = phoneNo;
		this.status = status;
		this.cellPhone = cellPhone;
		this.secondEmail = secondEmail;
		this.jobTitle = jobTitle;
		PasswordStatus = passwordStatus;
		AcceptMails = acceptMails;
		this.userSessions = userSessions;
		this.role = role;
		this.roleId = roleId;
		this.authId = authId;
		this.mfaStatus = mfaStatus;
		this.otp=otp;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public int getMfaStatus() {
		return mfaStatus;
	}

	public void setMfaStatus(int mfaStatus) {
		this.mfaStatus = mfaStatus;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
    public long getUserId() {
		return this.userId;
	}

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }



	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}



	public long getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(long userTypeId) {
		this.userTypeId = userTypeId;
	}

	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Set getUserSessions() {
		return this.userSessions;
	}

	public void setUserSessions(Set userSessions) {
		this.userSessions = userSessions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getSecondEmail() {
		return secondEmail;
	}

	public void setSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPasswordStatus() {
		return this.PasswordStatus;
	}

	public void setPasswordStatus(String PasswordStatus) {
		this.PasswordStatus = PasswordStatus;
	}
	public String getAcceptMails() {
		return this.AcceptMails;
	}

	public void setAcceptMails(String AcceptMails) {
		this.AcceptMails = AcceptMails;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", companyId=" + companyId + ", userTypeId=" + userTypeId + ", userRoleId="
				+ userRoleId + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", email=" + email + ", phoneNo=" + phoneNo + ", status="
				+ status + ", cellPhone=" + cellPhone + ", secondEmail=" + secondEmail + ", jobTitle=" + jobTitle
				+ ", PasswordStatus=" + PasswordStatus + ", AcceptMails=" + AcceptMails + ", userSessions="
				+ userSessions + ", role=" + role + ", roleId=" + roleId + "]";
	}
	
	
	
	
}