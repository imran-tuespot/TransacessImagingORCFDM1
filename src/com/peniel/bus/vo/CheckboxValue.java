package com.peniel.bus.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IndexType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CheckboxValue {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckboxValue.class);
    
	// Fields

	private String checkboxName;
	private String checkboxValue;
	
	/**
	 * @return the checkboxName
	 */
	public String getCheckboxName() {
		return checkboxName;
	}
	/**
	 * @param checkboxName the checkboxName to set
	 */
	public void setCheckboxName(String checkboxName) {
		this.checkboxName = checkboxName;
	}
	/**
	 * @return the checkboxValue
	 */
	public String getCheckboxValue() {
		return checkboxValue;
	}
	/**
	 * @param checkboxValue the checkboxValue to set
	 */
	public void setCheckboxValue(String checkboxValue) {
		this.checkboxValue = checkboxValue;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CheckboxValue [checkboxName=" + checkboxName
				+ ", checkboxValue=" + checkboxValue + "]";
	}
	
}