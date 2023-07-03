package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.AppRolesSQLHelper;
import com.peniel.bus.vo.sqlhelpers.SearchDataObjSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchDataObj implements java.io.Serializable{
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchDataObj.class);
    private static SearchDataObjSQLHelper searchDataObjSQLHelper;

	private int srNo;
	private String fileName;
	private String folderName;
	private String indexTypeId;
	private String indexType;
	private String indexValue;
	private String documentType;
	private int version;
	private int docId;
	private int docTypeId;
	private String actualFileName;
	private String folderIds;
	
    public static SearchDataObjSQLHelper getSearchDataObjSQLHelper() {
        if (searchDataObjSQLHelper == null) {
            try {
                searchDataObjSQLHelper = new SearchDataObjSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("searchDataObjSQLHelper had an error", e);
            }
        }
        return searchDataObjSQLHelper;
    }
	
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getActualFileName() {
		if(actualFileName != null)
			return actualFileName;
		else 
			return "";
	}
	public void setActualFileName(String actualFileName) {
		this.actualFileName = actualFileName;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	
	public String getIndexTypeId() {
		return indexTypeId;
	}
	public void setIndexTypeId(String indexTypeId) {
		this.indexTypeId = indexTypeId;
	}
	public String getIndexType() {
		return indexType;
	}
	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}
	public String getIndexValue() {
		return indexValue;
	}
	public void setIndexValue(String indexValue) {
		this.indexValue = indexValue;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public int getDocTypeId() {
		return docTypeId;
	}
	public void setDocTypeId(int docTypeId) {
		this.docTypeId = docTypeId;
	}

	public String getFolderIds() {
		return folderIds;
	}

	public void setFolderIds(String folderIds) {
		this.folderIds = folderIds;
	}
	
	
	
	
	
}