package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.AppRolesSQLHelper;
import com.peniel.bus.vo.sqlhelpers.DocumentTypeSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * DocumentType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class DocumentType implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentType.class);
    private static DocumentTypeSQLHelper documentTypeSQLHelper;

	// Fields

	private long documentTypeId;
	private long companyId;
	private String documentType;
	private String subDocTypeId;
	//private Set documentDatas = new HashSet(0);

    public static DocumentTypeSQLHelper getDocumentTypeSQLHelper() {
        if (documentTypeSQLHelper == null) {
            try {
                documentTypeSQLHelper = new DocumentTypeSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("documentTypeSQLHelper had an error", e);
            }
        }
        return documentTypeSQLHelper;
    }

	// Constructors

	/** default constructor */
	public DocumentType() {
	}

	/** minimal constructor */
	public DocumentType(long documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	/** full constructor */
	public DocumentType(long documentTypeId, long companyId,
			String documentType, Set documentDatas) {
		this.documentTypeId = documentTypeId;
		this.companyId = companyId;
		this.documentType = documentType;
		//this.documentDatas = documentDatas;
	}

	// Property accessors

	public long getDocumentTypeId() {
		return this.documentTypeId;
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

	public String getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getSubDocTypeId() {
		return subDocTypeId;
	}

	public void setSubDocTypeId(String subDocTypeId) {
		this.subDocTypeId = subDocTypeId;
	}
	
	

//	public Set getDocumentDatas() {
//		return this.documentDatas;
//	}
//
//	public void setDocumentDatas(Set documentDatas) {
//		this.documentDatas = documentDatas;
//	}

}