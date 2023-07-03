package com.peniel.bus.vo;


import com.peniel.bus.vo.sqlhelpers.AppRolesSQLHelper;
import com.peniel.bus.vo.sqlhelpers.AppUserSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppRoles implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppRoles.class);
    private static AppRolesSQLHelper appRolesSQLHelper;

	private long roleId;
	private String roleName;
	
    public static AppRolesSQLHelper getAppRolesSQLHelper() {
        if (appRolesSQLHelper == null) {
            try {
                appRolesSQLHelper = new AppRolesSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("appUserSQLHelper had an error", e);
            }
        }
        return appRolesSQLHelper;
    }


	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}