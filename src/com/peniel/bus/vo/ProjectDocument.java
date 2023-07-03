package com.peniel.bus.vo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DocumentType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ProjectDocument implements java.io.Serializable {

	// Fields
	private long  project_document_id;
	private String projectId;
	private long companyId;
	private long documentTypeId;
	private String entry_date;
	private String due_Date;
	private String emails;
	

	// Constructors

	

	/** default constructor */
	public ProjectDocument() {
	}

	public String getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}

	public String getDue_Date() {
		return due_Date;
	}

	public void setDue_Date(String due_Date) {
		this.due_Date = due_Date;
	}

	/** minimal constructor */
	public ProjectDocument(String projectId) {
		this.projectId = projectId;
	}

	/** full constructor */
	public ProjectDocument(long id,String projectId,long companyId,long documentTypeId)
	{
		this. project_document_id = id;
		this.projectId = projectId;
		this.documentTypeId = documentTypeId;
		this.companyId = companyId;
		
	}

	// Property accessors
	

	public long getCompanyId() {
		return companyId;
	}

	public long getId() {
		return  project_document_id;
	}

	public void setId(long id) {
		this. project_document_id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public long getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(long documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}


}

