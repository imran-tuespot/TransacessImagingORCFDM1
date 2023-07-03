package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.AppRolesSQLHelper;
import com.peniel.bus.vo.sqlhelpers.IndexTypeSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * IndexType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IndexType implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexType.class);
    private static IndexTypeSQLHelper indexTypeSQLHelper;

	// Fields

	private long indexTypeId;
	private String indexType;
	private long companyId;
	//private Set searchDatas = new HashSet(0);

    public static IndexTypeSQLHelper getIndexTypeSQLHelper() {
        if (indexTypeSQLHelper == null) {
            try {
                indexTypeSQLHelper = new IndexTypeSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("appUserSQLHelper had an error", e);
            }
        }
        return indexTypeSQLHelper;
    }

	// Constructors

	/** default constructor */
	public IndexType() {
	}

	/** minimal constructor */
	public IndexType(long indexTypeId) {
		this.indexTypeId = indexTypeId;
	}

	/** full constructor */
	public IndexType(long indexTypeId, String indexType, long companyId,
			Set searchDatas) {
		this.indexTypeId = indexTypeId;
		this.indexType = indexType;
		this.companyId = companyId;
		//this.searchDatas = searchDatas;
	}

	// Property accessors

	public long getIndexTypeId() {
		return this.indexTypeId;
	}

	public void setIndexTypeId(long indexTypeId) {
		this.indexTypeId = indexTypeId;
	}

	public String getIndexType() {
		return this.indexType;
	}

	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}

	public long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

//	public Set getSearchDatas() {
//		return this.searchDatas;
//	}
//
//	public void setSearchDatas(Set searchDatas) {
//		this.searchDatas = searchDatas;
//	}

}