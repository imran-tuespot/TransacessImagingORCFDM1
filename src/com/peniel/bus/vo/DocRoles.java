
package com.peniel.bus.vo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocRoles implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppRoles.class);
 

	private int role_id;
	private String role_name;
	private String role_doctype;
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_doctype() {
		return role_doctype;
	}
	public void setRole_doctype(String role_doctype) {
		this.role_doctype = role_doctype;
	}
	@Override
	public String toString() {
		return "DocRoles [role_id=" + role_id + ", role_name=" + role_name + ", role_doctype=" + role_doctype + "]";
	}
	
   

	
	
}