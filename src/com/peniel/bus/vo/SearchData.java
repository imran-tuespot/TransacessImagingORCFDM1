package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.AppRolesSQLHelper;
import com.peniel.bus.vo.sqlhelpers.SearchDataSQLHelper;
import com.peniel.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SearchData entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SearchData implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchData.class);
    static SearchDataSQLHelper searchDataSQLHelper;
    
	// Fields

	private long documentId;
	private long companyId;
	private String indexData;
	private long indexTypeId;
    private String rowid;
	// Constructors

    public static SearchDataSQLHelper getSearchDataSQLHelper() {
        if (searchDataSQLHelper == null) {
            try {
                searchDataSQLHelper = new SearchDataSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("searchDataSQLHelper had an error", e);
            }
        }
        return searchDataSQLHelper;
    }

	/** default constructor */
	public SearchData() {
	}

	/** minimal constructor */
//	public SearchData(SearchDataId id) {
//		this.id = id;
//	}

	/** full constructor */
	public SearchData(long documentId, long companyId, String indexData, long indexTypeId) {
		this.documentId = documentId;
		this.companyId = companyId;
		this.indexData = indexData;
		this.indexTypeId = indexTypeId;
	}

	// Property accessors

	public String getIndexData() {
		return this.indexData;
	}

	public void setIndexData(String indexData) {
		this.indexData = indexData;
	}

	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getIndexTypeId() {
		return indexTypeId;
	}

	public void setIndexTypeId(long indexTypeId) {
		this.indexTypeId = indexTypeId;
	}

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	

}