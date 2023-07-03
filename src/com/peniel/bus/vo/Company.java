package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.AppRolesSQLHelper;
import com.peniel.bus.vo.sqlhelpers.CompanySQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Company entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Company implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Company.class);
    private static CompanySQLHelper companySQLHelper;

	// Fields

	private long companyId;
	private String companyName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private long defaultIndex;
	private String companyFullname;


    public static CompanySQLHelper getCompanySQLHelper() {
        if (companySQLHelper == null) {
            try {
                companySQLHelper = new CompanySQLHelper();
            } catch (Exception e) {
                LOGGER.warn("companySQLHelper had an error", e);
            }
        }
        return companySQLHelper;
    }

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** minimal constructor */
	public Company(long companyId) {
		this.companyId = companyId;
	}

	/** full constructor */
	public Company(long companyId, String companyName, String address1,
			String address2, String city, String state, String zip,long defaultIndex,
			Set appUsers, Set searchDatas, Set documentDatas, Set documentTypes) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.defaultIndex = defaultIndex;

	}

	// Property accessors
   
	
	
	public long getCompanyId() {
		return this.companyId;
	}

	

	public String getCompanyFullname() {
		return companyFullname;
	}

	public void setCompanyFullname(String companyFullname) {
		this.companyFullname = companyFullname;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public long getDefaultIndex() {
		return this.defaultIndex;
	}

	public void setDefaultIndex(long defaultIndex) {
		this.defaultIndex = defaultIndex;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", defaultIndex="
				+ defaultIndex + ", company_Fullname=" + companyFullname + "]";
	}



}