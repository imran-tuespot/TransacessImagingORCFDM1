package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.AppUserSQLHelper;
import com.peniel.bus.vo.sqlhelpers.DocumentDataSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * DocumentDataSQLHelper entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class DocumentData implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentData.class);
    static DocumentDataSQLHelper documentDataSQLHelper;

	// Fields
	private long documentId;
	private String propertyId;
	private long documentTypeId;
	private long companyId;
	private String filename;
	private String folderId;
	private long version;
	private String createDate;
	private String ocrFlag;
	   private String transactionTypeId;
	    public String getActualfilename() {
		return actualfilename;
	}


	public void setActualfilename(String actualfilename) {
		this.actualfilename = actualfilename;
	}


	    private String transactionDate;
	    private String transactionStatus;
	    private String actualfilename;
	
	
	//private Set searchDatas = new HashSet(0);

    public static DocumentDataSQLHelper getDocumentDataSQLHelper() {
        if (documentDataSQLHelper == null) {
            try {
                documentDataSQLHelper = new DocumentDataSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("documentDataSQLHelper had an error", e);
            }
        }
        return documentDataSQLHelper;
    }


    // Constructors

	/** default constructor */
	public DocumentData() {
	}

	/** minimal constructor */
	public DocumentData(long documentId, String filename) {
		this.documentId = documentId;
		this.filename = filename;
	}

	/** full constructor */
	public DocumentData(long documentId, long documentTypeId,
			long companyId, String filename, Set searchDatas, long version,String folderId) {
		this.documentId = documentId;
		this.documentTypeId = documentTypeId;
		this.companyId = companyId;
		this.filename = filename;
		this.version = version;
		this.folderId = folderId;
		
		//this.searchDatas = searchDatas;
	}
	public String getPropertyId() {
		return propertyId;
	}


	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	// Property accessors
	public String getFolderId() {
		return folderId;
	}


	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}
	public long getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	

	


	public String getTransactionTypeId() {
		return transactionTypeId;
	}


	public void setTransactionTypeId(String transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}


	public String getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public long getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(long documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	/**
	 * @return the ocrFlag
	 */
	public String getOcrFlag() {
		return ocrFlag;
	}


	/**
	 * @param ocrFlag the ocrFlag to set
	 */
	public void setOcrFlag(String ocrFlag) {
		this.ocrFlag = ocrFlag;
	}

	
	

//	public Set getSearchDatas() {
//		return this.searchDatas;
//	}
//
//	public void setSearchDatas(Set searchDatas) {
//		this.searchDatas = searchDatas;
//	}

}