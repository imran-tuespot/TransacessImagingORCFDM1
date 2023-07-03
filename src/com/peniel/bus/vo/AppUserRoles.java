package com.peniel.bus.vo;


import com.peniel.bus.vo.sqlhelpers.AppUserRolesSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppUserRoles implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppRoles.class);

    private static AppUserRolesSQLHelper appUserRolesSQLHelper;

	private long roleId;
	private long userId;
	private String effectiveDate;
	
    public static AppUserRolesSQLHelper getAppRolesSQLHelper() {
        if (appUserRolesSQLHelper == null) {
            try {
                appUserRolesSQLHelper = new AppUserRolesSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("appUserSQLHelper had an error", e);
            }
        }
        return appUserRolesSQLHelper;
    }

	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
}