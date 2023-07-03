package com.peniel.bus.vo;


import com.peniel.bus.vo.sqlhelpers.AppRolesSQLHelper;
import com.peniel.bus.vo.sqlhelpers.StatesSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class States implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(States.class);
    private static StatesSQLHelper statesSQLHelper;

	private String country;
	private String state;
	private String name;

    public static StatesSQLHelper getStatesSQLHelper() {
        if (statesSQLHelper == null) {
            try {
                statesSQLHelper = new StatesSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("statesSQLHelper had an error", e);
            }
        }
        return statesSQLHelper;
    }

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}