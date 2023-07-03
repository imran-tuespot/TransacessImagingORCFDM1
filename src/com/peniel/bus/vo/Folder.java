package com.peniel.bus.vo;

import com.peniel.bus.vo.sqlhelpers.FolderSQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * IndexType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Folder implements java.io.Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Folder.class);
    private static FolderSQLHelper folderSQLHelper;

	// Fields

	private long folderId;
	private String folderName;
	private long companyId;
	//private Set searchDatas = new HashSet(0);

    public static FolderSQLHelper getFolderSQLHelper() {
        if (folderSQLHelper == null) {
            try {
            	folderSQLHelper = new FolderSQLHelper();
            } catch (Exception e) {
                LOGGER.warn("FolderSQLHelper had an error", e);
            }
        }
        return folderSQLHelper;
    }

	// Constructors

	/** default constructor */
	public Folder() {
	}

	/** minimal constructor */
	public Folder(long folderId) {
		this.folderId = folderId;
	}

	/** full constructor */
	public Folder(long folderId, String folderName, long companyId,
			Set searchDatas) {
		this.folderId = folderId;
		this.folderName = folderName;
		this.companyId = companyId;
		//this.searchDatas = searchDatas;
	}

	// Property accessors

	public long getFolderId() {
		return this.folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	public String getFolderName() {
		return this.folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return folderName;
	}

}