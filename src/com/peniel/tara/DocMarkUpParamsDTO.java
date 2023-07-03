/**
 * DocMarkUpParamsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class DocMarkUpParamsDTO  implements java.io.Serializable {
    private int documentId;

    private int reviewId;

    private int editId;

    private int subjectId;

    private boolean origFormat;

    private boolean showMarkup;

    private boolean showEdit;

    private boolean showBookmark;

    private boolean showEditDownload;

    private boolean includeParagraphIds;

    private java.lang.String sectionId;

    private java.lang.String documentPart;

    private java.lang.String trackedChangeMode;

    private boolean highlightParagraph;

    private java.lang.String inlineEditing;

    private boolean isTabletModeAllowed;

    private com.peniel.tara.ListCommentParamsDTO listCommentParamsDTO;

    private com.peniel.tara.DocMarkUpParamsDTOCustomSelection customSelection;

    private boolean reconReport;

    private int modificationCount;

    private int editVersion;

    private boolean savedEditZone;

    private java.lang.String vid;

    private boolean xmlMode;

    private java.util.Calendar lastUpdate;

    private java.lang.String[] commentParaIds;

    private java.lang.String[] bookmarkParaIds;

    private java.lang.String[] editParaIds;

    private java.lang.String[] deletedParaIds;

    private int refreshInterval;

    private boolean isInOfflineMode;

    private boolean isPreview;

    private java.lang.String serverVersion;

    private boolean referenceOnly;

    private java.lang.String reviewStatus;

    private java.lang.String defaultReviewZoneRole;

    private boolean hasContributorRight;

    private boolean hasAuthorRight;

    private boolean hasReviewerRight;

    private boolean isReviewZoneEnabled;

    private boolean isRequiredUpdateFieldCode;

    private java.lang.String temporaryDirectoryForZip;

    private java.lang.String temporaryDirectoryForAllReconcileReport;

    private boolean hasDelegates;

    private boolean protectDownloadedDocument;

    private boolean showPageBorders;

    private boolean isHTML5Mode;

    private boolean isFlightMode;

    public DocMarkUpParamsDTO() {
    }

    public DocMarkUpParamsDTO(
           int documentId,
           int reviewId,
           int editId,
           int subjectId,
           boolean origFormat,
           boolean showMarkup,
           boolean showEdit,
           boolean showBookmark,
           boolean showEditDownload,
           boolean includeParagraphIds,
           java.lang.String sectionId,
           java.lang.String documentPart,
           java.lang.String trackedChangeMode,
           boolean highlightParagraph,
           java.lang.String inlineEditing,
           boolean isTabletModeAllowed,
           com.peniel.tara.ListCommentParamsDTO listCommentParamsDTO,
           com.peniel.tara.DocMarkUpParamsDTOCustomSelection customSelection,
           boolean reconReport,
           int modificationCount,
           int editVersion,
           boolean savedEditZone,
           java.lang.String vid,
           boolean xmlMode,
           java.util.Calendar lastUpdate,
           java.lang.String[] commentParaIds,
           java.lang.String[] bookmarkParaIds,
           java.lang.String[] editParaIds,
           java.lang.String[] deletedParaIds,
           int refreshInterval,
           boolean isInOfflineMode,
           boolean isPreview,
           java.lang.String serverVersion,
           boolean referenceOnly,
           java.lang.String reviewStatus,
           java.lang.String defaultReviewZoneRole,
           boolean hasContributorRight,
           boolean hasAuthorRight,
           boolean hasReviewerRight,
           boolean isReviewZoneEnabled,
           boolean isRequiredUpdateFieldCode,
           java.lang.String temporaryDirectoryForZip,
           java.lang.String temporaryDirectoryForAllReconcileReport,
           boolean hasDelegates,
           boolean protectDownloadedDocument,
           boolean showPageBorders,
           boolean isHTML5Mode,
           boolean isFlightMode) {
           this.documentId = documentId;
           this.reviewId = reviewId;
           this.editId = editId;
           this.subjectId = subjectId;
           this.origFormat = origFormat;
           this.showMarkup = showMarkup;
           this.showEdit = showEdit;
           this.showBookmark = showBookmark;
           this.showEditDownload = showEditDownload;
           this.includeParagraphIds = includeParagraphIds;
           this.sectionId = sectionId;
           this.documentPart = documentPart;
           this.trackedChangeMode = trackedChangeMode;
           this.highlightParagraph = highlightParagraph;
           this.inlineEditing = inlineEditing;
           this.isTabletModeAllowed = isTabletModeAllowed;
           this.listCommentParamsDTO = listCommentParamsDTO;
           this.customSelection = customSelection;
           this.reconReport = reconReport;
           this.modificationCount = modificationCount;
           this.editVersion = editVersion;
           this.savedEditZone = savedEditZone;
           this.vid = vid;
           this.xmlMode = xmlMode;
           this.lastUpdate = lastUpdate;
           this.commentParaIds = commentParaIds;
           this.bookmarkParaIds = bookmarkParaIds;
           this.editParaIds = editParaIds;
           this.deletedParaIds = deletedParaIds;
           this.refreshInterval = refreshInterval;
           this.isInOfflineMode = isInOfflineMode;
           this.isPreview = isPreview;
           this.serverVersion = serverVersion;
           this.referenceOnly = referenceOnly;
           this.reviewStatus = reviewStatus;
           this.defaultReviewZoneRole = defaultReviewZoneRole;
           this.hasContributorRight = hasContributorRight;
           this.hasAuthorRight = hasAuthorRight;
           this.hasReviewerRight = hasReviewerRight;
           this.isReviewZoneEnabled = isReviewZoneEnabled;
           this.isRequiredUpdateFieldCode = isRequiredUpdateFieldCode;
           this.temporaryDirectoryForZip = temporaryDirectoryForZip;
           this.temporaryDirectoryForAllReconcileReport = temporaryDirectoryForAllReconcileReport;
           this.hasDelegates = hasDelegates;
           this.protectDownloadedDocument = protectDownloadedDocument;
           this.showPageBorders = showPageBorders;
           this.isHTML5Mode = isHTML5Mode;
           this.isFlightMode = isFlightMode;
    }


    /**
     * Gets the documentId value for this DocMarkUpParamsDTO.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this DocMarkUpParamsDTO.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the reviewId value for this DocMarkUpParamsDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this DocMarkUpParamsDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the editId value for this DocMarkUpParamsDTO.
     * 
     * @return editId
     */
    public int getEditId() {
        return editId;
    }


    /**
     * Sets the editId value for this DocMarkUpParamsDTO.
     * 
     * @param editId
     */
    public void setEditId(int editId) {
        this.editId = editId;
    }


    /**
     * Gets the subjectId value for this DocMarkUpParamsDTO.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this DocMarkUpParamsDTO.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the origFormat value for this DocMarkUpParamsDTO.
     * 
     * @return origFormat
     */
    public boolean isOrigFormat() {
        return origFormat;
    }


    /**
     * Sets the origFormat value for this DocMarkUpParamsDTO.
     * 
     * @param origFormat
     */
    public void setOrigFormat(boolean origFormat) {
        this.origFormat = origFormat;
    }


    /**
     * Gets the showMarkup value for this DocMarkUpParamsDTO.
     * 
     * @return showMarkup
     */
    public boolean isShowMarkup() {
        return showMarkup;
    }


    /**
     * Sets the showMarkup value for this DocMarkUpParamsDTO.
     * 
     * @param showMarkup
     */
    public void setShowMarkup(boolean showMarkup) {
        this.showMarkup = showMarkup;
    }


    /**
     * Gets the showEdit value for this DocMarkUpParamsDTO.
     * 
     * @return showEdit
     */
    public boolean isShowEdit() {
        return showEdit;
    }


    /**
     * Sets the showEdit value for this DocMarkUpParamsDTO.
     * 
     * @param showEdit
     */
    public void setShowEdit(boolean showEdit) {
        this.showEdit = showEdit;
    }


    /**
     * Gets the showBookmark value for this DocMarkUpParamsDTO.
     * 
     * @return showBookmark
     */
    public boolean isShowBookmark() {
        return showBookmark;
    }


    /**
     * Sets the showBookmark value for this DocMarkUpParamsDTO.
     * 
     * @param showBookmark
     */
    public void setShowBookmark(boolean showBookmark) {
        this.showBookmark = showBookmark;
    }


    /**
     * Gets the showEditDownload value for this DocMarkUpParamsDTO.
     * 
     * @return showEditDownload
     */
    public boolean isShowEditDownload() {
        return showEditDownload;
    }


    /**
     * Sets the showEditDownload value for this DocMarkUpParamsDTO.
     * 
     * @param showEditDownload
     */
    public void setShowEditDownload(boolean showEditDownload) {
        this.showEditDownload = showEditDownload;
    }


    /**
     * Gets the includeParagraphIds value for this DocMarkUpParamsDTO.
     * 
     * @return includeParagraphIds
     */
    public boolean isIncludeParagraphIds() {
        return includeParagraphIds;
    }


    /**
     * Sets the includeParagraphIds value for this DocMarkUpParamsDTO.
     * 
     * @param includeParagraphIds
     */
    public void setIncludeParagraphIds(boolean includeParagraphIds) {
        this.includeParagraphIds = includeParagraphIds;
    }


    /**
     * Gets the sectionId value for this DocMarkUpParamsDTO.
     * 
     * @return sectionId
     */
    public java.lang.String getSectionId() {
        return sectionId;
    }


    /**
     * Sets the sectionId value for this DocMarkUpParamsDTO.
     * 
     * @param sectionId
     */
    public void setSectionId(java.lang.String sectionId) {
        this.sectionId = sectionId;
    }


    /**
     * Gets the documentPart value for this DocMarkUpParamsDTO.
     * 
     * @return documentPart
     */
    public java.lang.String getDocumentPart() {
        return documentPart;
    }


    /**
     * Sets the documentPart value for this DocMarkUpParamsDTO.
     * 
     * @param documentPart
     */
    public void setDocumentPart(java.lang.String documentPart) {
        this.documentPart = documentPart;
    }


    /**
     * Gets the trackedChangeMode value for this DocMarkUpParamsDTO.
     * 
     * @return trackedChangeMode
     */
    public java.lang.String getTrackedChangeMode() {
        return trackedChangeMode;
    }


    /**
     * Sets the trackedChangeMode value for this DocMarkUpParamsDTO.
     * 
     * @param trackedChangeMode
     */
    public void setTrackedChangeMode(java.lang.String trackedChangeMode) {
        this.trackedChangeMode = trackedChangeMode;
    }


    /**
     * Gets the highlightParagraph value for this DocMarkUpParamsDTO.
     * 
     * @return highlightParagraph
     */
    public boolean isHighlightParagraph() {
        return highlightParagraph;
    }


    /**
     * Sets the highlightParagraph value for this DocMarkUpParamsDTO.
     * 
     * @param highlightParagraph
     */
    public void setHighlightParagraph(boolean highlightParagraph) {
        this.highlightParagraph = highlightParagraph;
    }


    /**
     * Gets the inlineEditing value for this DocMarkUpParamsDTO.
     * 
     * @return inlineEditing
     */
    public java.lang.String getInlineEditing() {
        return inlineEditing;
    }


    /**
     * Sets the inlineEditing value for this DocMarkUpParamsDTO.
     * 
     * @param inlineEditing
     */
    public void setInlineEditing(java.lang.String inlineEditing) {
        this.inlineEditing = inlineEditing;
    }


    /**
     * Gets the isTabletModeAllowed value for this DocMarkUpParamsDTO.
     * 
     * @return isTabletModeAllowed
     */
    public boolean isIsTabletModeAllowed() {
        return isTabletModeAllowed;
    }


    /**
     * Sets the isTabletModeAllowed value for this DocMarkUpParamsDTO.
     * 
     * @param isTabletModeAllowed
     */
    public void setIsTabletModeAllowed(boolean isTabletModeAllowed) {
        this.isTabletModeAllowed = isTabletModeAllowed;
    }


    /**
     * Gets the listCommentParamsDTO value for this DocMarkUpParamsDTO.
     * 
     * @return listCommentParamsDTO
     */
    public com.peniel.tara.ListCommentParamsDTO getListCommentParamsDTO() {
        return listCommentParamsDTO;
    }


    /**
     * Sets the listCommentParamsDTO value for this DocMarkUpParamsDTO.
     * 
     * @param listCommentParamsDTO
     */
    public void setListCommentParamsDTO(com.peniel.tara.ListCommentParamsDTO listCommentParamsDTO) {
        this.listCommentParamsDTO = listCommentParamsDTO;
    }


    /**
     * Gets the customSelection value for this DocMarkUpParamsDTO.
     * 
     * @return customSelection
     */
    public com.peniel.tara.DocMarkUpParamsDTOCustomSelection getCustomSelection() {
        return customSelection;
    }


    /**
     * Sets the customSelection value for this DocMarkUpParamsDTO.
     * 
     * @param customSelection
     */
    public void setCustomSelection(com.peniel.tara.DocMarkUpParamsDTOCustomSelection customSelection) {
        this.customSelection = customSelection;
    }


    /**
     * Gets the reconReport value for this DocMarkUpParamsDTO.
     * 
     * @return reconReport
     */
    public boolean isReconReport() {
        return reconReport;
    }


    /**
     * Sets the reconReport value for this DocMarkUpParamsDTO.
     * 
     * @param reconReport
     */
    public void setReconReport(boolean reconReport) {
        this.reconReport = reconReport;
    }


    /**
     * Gets the modificationCount value for this DocMarkUpParamsDTO.
     * 
     * @return modificationCount
     */
    public int getModificationCount() {
        return modificationCount;
    }


    /**
     * Sets the modificationCount value for this DocMarkUpParamsDTO.
     * 
     * @param modificationCount
     */
    public void setModificationCount(int modificationCount) {
        this.modificationCount = modificationCount;
    }


    /**
     * Gets the editVersion value for this DocMarkUpParamsDTO.
     * 
     * @return editVersion
     */
    public int getEditVersion() {
        return editVersion;
    }


    /**
     * Sets the editVersion value for this DocMarkUpParamsDTO.
     * 
     * @param editVersion
     */
    public void setEditVersion(int editVersion) {
        this.editVersion = editVersion;
    }


    /**
     * Gets the savedEditZone value for this DocMarkUpParamsDTO.
     * 
     * @return savedEditZone
     */
    public boolean isSavedEditZone() {
        return savedEditZone;
    }


    /**
     * Sets the savedEditZone value for this DocMarkUpParamsDTO.
     * 
     * @param savedEditZone
     */
    public void setSavedEditZone(boolean savedEditZone) {
        this.savedEditZone = savedEditZone;
    }


    /**
     * Gets the vid value for this DocMarkUpParamsDTO.
     * 
     * @return vid
     */
    public java.lang.String getVid() {
        return vid;
    }


    /**
     * Sets the vid value for this DocMarkUpParamsDTO.
     * 
     * @param vid
     */
    public void setVid(java.lang.String vid) {
        this.vid = vid;
    }


    /**
     * Gets the xmlMode value for this DocMarkUpParamsDTO.
     * 
     * @return xmlMode
     */
    public boolean isXmlMode() {
        return xmlMode;
    }


    /**
     * Sets the xmlMode value for this DocMarkUpParamsDTO.
     * 
     * @param xmlMode
     */
    public void setXmlMode(boolean xmlMode) {
        this.xmlMode = xmlMode;
    }


    /**
     * Gets the lastUpdate value for this DocMarkUpParamsDTO.
     * 
     * @return lastUpdate
     */
    public java.util.Calendar getLastUpdate() {
        return lastUpdate;
    }


    /**
     * Sets the lastUpdate value for this DocMarkUpParamsDTO.
     * 
     * @param lastUpdate
     */
    public void setLastUpdate(java.util.Calendar lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    /**
     * Gets the commentParaIds value for this DocMarkUpParamsDTO.
     * 
     * @return commentParaIds
     */
    public java.lang.String[] getCommentParaIds() {
        return commentParaIds;
    }


    /**
     * Sets the commentParaIds value for this DocMarkUpParamsDTO.
     * 
     * @param commentParaIds
     */
    public void setCommentParaIds(java.lang.String[] commentParaIds) {
        this.commentParaIds = commentParaIds;
    }


    /**
     * Gets the bookmarkParaIds value for this DocMarkUpParamsDTO.
     * 
     * @return bookmarkParaIds
     */
    public java.lang.String[] getBookmarkParaIds() {
        return bookmarkParaIds;
    }


    /**
     * Sets the bookmarkParaIds value for this DocMarkUpParamsDTO.
     * 
     * @param bookmarkParaIds
     */
    public void setBookmarkParaIds(java.lang.String[] bookmarkParaIds) {
        this.bookmarkParaIds = bookmarkParaIds;
    }


    /**
     * Gets the editParaIds value for this DocMarkUpParamsDTO.
     * 
     * @return editParaIds
     */
    public java.lang.String[] getEditParaIds() {
        return editParaIds;
    }


    /**
     * Sets the editParaIds value for this DocMarkUpParamsDTO.
     * 
     * @param editParaIds
     */
    public void setEditParaIds(java.lang.String[] editParaIds) {
        this.editParaIds = editParaIds;
    }


    /**
     * Gets the deletedParaIds value for this DocMarkUpParamsDTO.
     * 
     * @return deletedParaIds
     */
    public java.lang.String[] getDeletedParaIds() {
        return deletedParaIds;
    }


    /**
     * Sets the deletedParaIds value for this DocMarkUpParamsDTO.
     * 
     * @param deletedParaIds
     */
    public void setDeletedParaIds(java.lang.String[] deletedParaIds) {
        this.deletedParaIds = deletedParaIds;
    }


    /**
     * Gets the refreshInterval value for this DocMarkUpParamsDTO.
     * 
     * @return refreshInterval
     */
    public int getRefreshInterval() {
        return refreshInterval;
    }


    /**
     * Sets the refreshInterval value for this DocMarkUpParamsDTO.
     * 
     * @param refreshInterval
     */
    public void setRefreshInterval(int refreshInterval) {
        this.refreshInterval = refreshInterval;
    }


    /**
     * Gets the isInOfflineMode value for this DocMarkUpParamsDTO.
     * 
     * @return isInOfflineMode
     */
    public boolean isIsInOfflineMode() {
        return isInOfflineMode;
    }


    /**
     * Sets the isInOfflineMode value for this DocMarkUpParamsDTO.
     * 
     * @param isInOfflineMode
     */
    public void setIsInOfflineMode(boolean isInOfflineMode) {
        this.isInOfflineMode = isInOfflineMode;
    }


    /**
     * Gets the isPreview value for this DocMarkUpParamsDTO.
     * 
     * @return isPreview
     */
    public boolean isIsPreview() {
        return isPreview;
    }


    /**
     * Sets the isPreview value for this DocMarkUpParamsDTO.
     * 
     * @param isPreview
     */
    public void setIsPreview(boolean isPreview) {
        this.isPreview = isPreview;
    }


    /**
     * Gets the serverVersion value for this DocMarkUpParamsDTO.
     * 
     * @return serverVersion
     */
    public java.lang.String getServerVersion() {
        return serverVersion;
    }


    /**
     * Sets the serverVersion value for this DocMarkUpParamsDTO.
     * 
     * @param serverVersion
     */
    public void setServerVersion(java.lang.String serverVersion) {
        this.serverVersion = serverVersion;
    }


    /**
     * Gets the referenceOnly value for this DocMarkUpParamsDTO.
     * 
     * @return referenceOnly
     */
    public boolean isReferenceOnly() {
        return referenceOnly;
    }


    /**
     * Sets the referenceOnly value for this DocMarkUpParamsDTO.
     * 
     * @param referenceOnly
     */
    public void setReferenceOnly(boolean referenceOnly) {
        this.referenceOnly = referenceOnly;
    }


    /**
     * Gets the reviewStatus value for this DocMarkUpParamsDTO.
     * 
     * @return reviewStatus
     */
    public java.lang.String getReviewStatus() {
        return reviewStatus;
    }


    /**
     * Sets the reviewStatus value for this DocMarkUpParamsDTO.
     * 
     * @param reviewStatus
     */
    public void setReviewStatus(java.lang.String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }


    /**
     * Gets the defaultReviewZoneRole value for this DocMarkUpParamsDTO.
     * 
     * @return defaultReviewZoneRole
     */
    public java.lang.String getDefaultReviewZoneRole() {
        return defaultReviewZoneRole;
    }


    /**
     * Sets the defaultReviewZoneRole value for this DocMarkUpParamsDTO.
     * 
     * @param defaultReviewZoneRole
     */
    public void setDefaultReviewZoneRole(java.lang.String defaultReviewZoneRole) {
        this.defaultReviewZoneRole = defaultReviewZoneRole;
    }


    /**
     * Gets the hasContributorRight value for this DocMarkUpParamsDTO.
     * 
     * @return hasContributorRight
     */
    public boolean isHasContributorRight() {
        return hasContributorRight;
    }


    /**
     * Sets the hasContributorRight value for this DocMarkUpParamsDTO.
     * 
     * @param hasContributorRight
     */
    public void setHasContributorRight(boolean hasContributorRight) {
        this.hasContributorRight = hasContributorRight;
    }


    /**
     * Gets the hasAuthorRight value for this DocMarkUpParamsDTO.
     * 
     * @return hasAuthorRight
     */
    public boolean isHasAuthorRight() {
        return hasAuthorRight;
    }


    /**
     * Sets the hasAuthorRight value for this DocMarkUpParamsDTO.
     * 
     * @param hasAuthorRight
     */
    public void setHasAuthorRight(boolean hasAuthorRight) {
        this.hasAuthorRight = hasAuthorRight;
    }


    /**
     * Gets the hasReviewerRight value for this DocMarkUpParamsDTO.
     * 
     * @return hasReviewerRight
     */
    public boolean isHasReviewerRight() {
        return hasReviewerRight;
    }


    /**
     * Sets the hasReviewerRight value for this DocMarkUpParamsDTO.
     * 
     * @param hasReviewerRight
     */
    public void setHasReviewerRight(boolean hasReviewerRight) {
        this.hasReviewerRight = hasReviewerRight;
    }


    /**
     * Gets the isReviewZoneEnabled value for this DocMarkUpParamsDTO.
     * 
     * @return isReviewZoneEnabled
     */
    public boolean isIsReviewZoneEnabled() {
        return isReviewZoneEnabled;
    }


    /**
     * Sets the isReviewZoneEnabled value for this DocMarkUpParamsDTO.
     * 
     * @param isReviewZoneEnabled
     */
    public void setIsReviewZoneEnabled(boolean isReviewZoneEnabled) {
        this.isReviewZoneEnabled = isReviewZoneEnabled;
    }


    /**
     * Gets the isRequiredUpdateFieldCode value for this DocMarkUpParamsDTO.
     * 
     * @return isRequiredUpdateFieldCode
     */
    public boolean isIsRequiredUpdateFieldCode() {
        return isRequiredUpdateFieldCode;
    }


    /**
     * Sets the isRequiredUpdateFieldCode value for this DocMarkUpParamsDTO.
     * 
     * @param isRequiredUpdateFieldCode
     */
    public void setIsRequiredUpdateFieldCode(boolean isRequiredUpdateFieldCode) {
        this.isRequiredUpdateFieldCode = isRequiredUpdateFieldCode;
    }


    /**
     * Gets the temporaryDirectoryForZip value for this DocMarkUpParamsDTO.
     * 
     * @return temporaryDirectoryForZip
     */
    public java.lang.String getTemporaryDirectoryForZip() {
        return temporaryDirectoryForZip;
    }


    /**
     * Sets the temporaryDirectoryForZip value for this DocMarkUpParamsDTO.
     * 
     * @param temporaryDirectoryForZip
     */
    public void setTemporaryDirectoryForZip(java.lang.String temporaryDirectoryForZip) {
        this.temporaryDirectoryForZip = temporaryDirectoryForZip;
    }


    /**
     * Gets the temporaryDirectoryForAllReconcileReport value for this DocMarkUpParamsDTO.
     * 
     * @return temporaryDirectoryForAllReconcileReport
     */
    public java.lang.String getTemporaryDirectoryForAllReconcileReport() {
        return temporaryDirectoryForAllReconcileReport;
    }


    /**
     * Sets the temporaryDirectoryForAllReconcileReport value for this DocMarkUpParamsDTO.
     * 
     * @param temporaryDirectoryForAllReconcileReport
     */
    public void setTemporaryDirectoryForAllReconcileReport(java.lang.String temporaryDirectoryForAllReconcileReport) {
        this.temporaryDirectoryForAllReconcileReport = temporaryDirectoryForAllReconcileReport;
    }


    /**
     * Gets the hasDelegates value for this DocMarkUpParamsDTO.
     * 
     * @return hasDelegates
     */
    public boolean isHasDelegates() {
        return hasDelegates;
    }


    /**
     * Sets the hasDelegates value for this DocMarkUpParamsDTO.
     * 
     * @param hasDelegates
     */
    public void setHasDelegates(boolean hasDelegates) {
        this.hasDelegates = hasDelegates;
    }


    /**
     * Gets the protectDownloadedDocument value for this DocMarkUpParamsDTO.
     * 
     * @return protectDownloadedDocument
     */
    public boolean isProtectDownloadedDocument() {
        return protectDownloadedDocument;
    }


    /**
     * Sets the protectDownloadedDocument value for this DocMarkUpParamsDTO.
     * 
     * @param protectDownloadedDocument
     */
    public void setProtectDownloadedDocument(boolean protectDownloadedDocument) {
        this.protectDownloadedDocument = protectDownloadedDocument;
    }


    /**
     * Gets the showPageBorders value for this DocMarkUpParamsDTO.
     * 
     * @return showPageBorders
     */
    public boolean isShowPageBorders() {
        return showPageBorders;
    }


    /**
     * Sets the showPageBorders value for this DocMarkUpParamsDTO.
     * 
     * @param showPageBorders
     */
    public void setShowPageBorders(boolean showPageBorders) {
        this.showPageBorders = showPageBorders;
    }


    /**
     * Gets the isHTML5Mode value for this DocMarkUpParamsDTO.
     * 
     * @return isHTML5Mode
     */
    public boolean isIsHTML5Mode() {
        return isHTML5Mode;
    }


    /**
     * Sets the isHTML5Mode value for this DocMarkUpParamsDTO.
     * 
     * @param isHTML5Mode
     */
    public void setIsHTML5Mode(boolean isHTML5Mode) {
        this.isHTML5Mode = isHTML5Mode;
    }


    /**
     * Gets the isFlightMode value for this DocMarkUpParamsDTO.
     * 
     * @return isFlightMode
     */
    public boolean isIsFlightMode() {
        return isFlightMode;
    }


    /**
     * Sets the isFlightMode value for this DocMarkUpParamsDTO.
     * 
     * @param isFlightMode
     */
    public void setIsFlightMode(boolean isFlightMode) {
        this.isFlightMode = isFlightMode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocMarkUpParamsDTO)) return false;
        DocMarkUpParamsDTO other = (DocMarkUpParamsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.documentId == other.getDocumentId() &&
            this.reviewId == other.getReviewId() &&
            this.editId == other.getEditId() &&
            this.subjectId == other.getSubjectId() &&
            this.origFormat == other.isOrigFormat() &&
            this.showMarkup == other.isShowMarkup() &&
            this.showEdit == other.isShowEdit() &&
            this.showBookmark == other.isShowBookmark() &&
            this.showEditDownload == other.isShowEditDownload() &&
            this.includeParagraphIds == other.isIncludeParagraphIds() &&
            ((this.sectionId==null && other.getSectionId()==null) || 
             (this.sectionId!=null &&
              this.sectionId.equals(other.getSectionId()))) &&
            ((this.documentPart==null && other.getDocumentPart()==null) || 
             (this.documentPart!=null &&
              this.documentPart.equals(other.getDocumentPart()))) &&
            ((this.trackedChangeMode==null && other.getTrackedChangeMode()==null) || 
             (this.trackedChangeMode!=null &&
              this.trackedChangeMode.equals(other.getTrackedChangeMode()))) &&
            this.highlightParagraph == other.isHighlightParagraph() &&
            ((this.inlineEditing==null && other.getInlineEditing()==null) || 
             (this.inlineEditing!=null &&
              this.inlineEditing.equals(other.getInlineEditing()))) &&
            this.isTabletModeAllowed == other.isIsTabletModeAllowed() &&
            ((this.listCommentParamsDTO==null && other.getListCommentParamsDTO()==null) || 
             (this.listCommentParamsDTO!=null &&
              this.listCommentParamsDTO.equals(other.getListCommentParamsDTO()))) &&
            ((this.customSelection==null && other.getCustomSelection()==null) || 
             (this.customSelection!=null &&
              this.customSelection.equals(other.getCustomSelection()))) &&
            this.reconReport == other.isReconReport() &&
            this.modificationCount == other.getModificationCount() &&
            this.editVersion == other.getEditVersion() &&
            this.savedEditZone == other.isSavedEditZone() &&
            ((this.vid==null && other.getVid()==null) || 
             (this.vid!=null &&
              this.vid.equals(other.getVid()))) &&
            this.xmlMode == other.isXmlMode() &&
            ((this.lastUpdate==null && other.getLastUpdate()==null) || 
             (this.lastUpdate!=null &&
              this.lastUpdate.equals(other.getLastUpdate()))) &&
            ((this.commentParaIds==null && other.getCommentParaIds()==null) || 
             (this.commentParaIds!=null &&
              java.util.Arrays.equals(this.commentParaIds, other.getCommentParaIds()))) &&
            ((this.bookmarkParaIds==null && other.getBookmarkParaIds()==null) || 
             (this.bookmarkParaIds!=null &&
              java.util.Arrays.equals(this.bookmarkParaIds, other.getBookmarkParaIds()))) &&
            ((this.editParaIds==null && other.getEditParaIds()==null) || 
             (this.editParaIds!=null &&
              java.util.Arrays.equals(this.editParaIds, other.getEditParaIds()))) &&
            ((this.deletedParaIds==null && other.getDeletedParaIds()==null) || 
             (this.deletedParaIds!=null &&
              java.util.Arrays.equals(this.deletedParaIds, other.getDeletedParaIds()))) &&
            this.refreshInterval == other.getRefreshInterval() &&
            this.isInOfflineMode == other.isIsInOfflineMode() &&
            this.isPreview == other.isIsPreview() &&
            ((this.serverVersion==null && other.getServerVersion()==null) || 
             (this.serverVersion!=null &&
              this.serverVersion.equals(other.getServerVersion()))) &&
            this.referenceOnly == other.isReferenceOnly() &&
            ((this.reviewStatus==null && other.getReviewStatus()==null) || 
             (this.reviewStatus!=null &&
              this.reviewStatus.equals(other.getReviewStatus()))) &&
            ((this.defaultReviewZoneRole==null && other.getDefaultReviewZoneRole()==null) || 
             (this.defaultReviewZoneRole!=null &&
              this.defaultReviewZoneRole.equals(other.getDefaultReviewZoneRole()))) &&
            this.hasContributorRight == other.isHasContributorRight() &&
            this.hasAuthorRight == other.isHasAuthorRight() &&
            this.hasReviewerRight == other.isHasReviewerRight() &&
            this.isReviewZoneEnabled == other.isIsReviewZoneEnabled() &&
            this.isRequiredUpdateFieldCode == other.isIsRequiredUpdateFieldCode() &&
            ((this.temporaryDirectoryForZip==null && other.getTemporaryDirectoryForZip()==null) || 
             (this.temporaryDirectoryForZip!=null &&
              this.temporaryDirectoryForZip.equals(other.getTemporaryDirectoryForZip()))) &&
            ((this.temporaryDirectoryForAllReconcileReport==null && other.getTemporaryDirectoryForAllReconcileReport()==null) || 
             (this.temporaryDirectoryForAllReconcileReport!=null &&
              this.temporaryDirectoryForAllReconcileReport.equals(other.getTemporaryDirectoryForAllReconcileReport()))) &&
            this.hasDelegates == other.isHasDelegates() &&
            this.protectDownloadedDocument == other.isProtectDownloadedDocument() &&
            this.showPageBorders == other.isShowPageBorders() &&
            this.isHTML5Mode == other.isIsHTML5Mode() &&
            this.isFlightMode == other.isIsFlightMode();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getDocumentId();
        _hashCode += getReviewId();
        _hashCode += getEditId();
        _hashCode += getSubjectId();
        _hashCode += (isOrigFormat() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isShowMarkup() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isShowEdit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isShowBookmark() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isShowEditDownload() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeParagraphIds() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSectionId() != null) {
            _hashCode += getSectionId().hashCode();
        }
        if (getDocumentPart() != null) {
            _hashCode += getDocumentPart().hashCode();
        }
        if (getTrackedChangeMode() != null) {
            _hashCode += getTrackedChangeMode().hashCode();
        }
        _hashCode += (isHighlightParagraph() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getInlineEditing() != null) {
            _hashCode += getInlineEditing().hashCode();
        }
        _hashCode += (isIsTabletModeAllowed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getListCommentParamsDTO() != null) {
            _hashCode += getListCommentParamsDTO().hashCode();
        }
        if (getCustomSelection() != null) {
            _hashCode += getCustomSelection().hashCode();
        }
        _hashCode += (isReconReport() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getModificationCount();
        _hashCode += getEditVersion();
        _hashCode += (isSavedEditZone() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getVid() != null) {
            _hashCode += getVid().hashCode();
        }
        _hashCode += (isXmlMode() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLastUpdate() != null) {
            _hashCode += getLastUpdate().hashCode();
        }
        if (getCommentParaIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCommentParaIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCommentParaIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBookmarkParaIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBookmarkParaIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBookmarkParaIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEditParaIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEditParaIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEditParaIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeletedParaIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeletedParaIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeletedParaIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getRefreshInterval();
        _hashCode += (isIsInOfflineMode() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsPreview() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getServerVersion() != null) {
            _hashCode += getServerVersion().hashCode();
        }
        _hashCode += (isReferenceOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getReviewStatus() != null) {
            _hashCode += getReviewStatus().hashCode();
        }
        if (getDefaultReviewZoneRole() != null) {
            _hashCode += getDefaultReviewZoneRole().hashCode();
        }
        _hashCode += (isHasContributorRight() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHasAuthorRight() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHasReviewerRight() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsReviewZoneEnabled() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsRequiredUpdateFieldCode() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getTemporaryDirectoryForZip() != null) {
            _hashCode += getTemporaryDirectoryForZip().hashCode();
        }
        if (getTemporaryDirectoryForAllReconcileReport() != null) {
            _hashCode += getTemporaryDirectoryForAllReconcileReport().hashCode();
        }
        _hashCode += (isHasDelegates() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isProtectDownloadedDocument() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isShowPageBorders() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsHTML5Mode() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsFlightMode() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocMarkUpParamsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocMarkUpParamsDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OrigFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showMarkup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ShowMarkup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showEdit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ShowEdit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showBookmark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ShowBookmark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showEditDownload");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ShowEditDownload"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeParagraphIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IncludeParagraphIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sectionId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SectionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentPart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentPart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackedChangeMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TrackedChangeMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highlightParagraph");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "HighlightParagraph"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inlineEditing");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "InlineEditing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTabletModeAllowed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsTabletModeAllowed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listCommentParamsDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListCommentParamsDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListCommentParamsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customSelection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CustomSelection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">DocMarkUpParamsDTO>CustomSelection"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reconReport");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReconReport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modificationCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ModificationCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("savedEditZone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SavedEditZone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Vid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "XmlMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastUpdate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LastUpdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentParaIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentParaIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookmarkParaIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "BookmarkParaIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editParaIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditParaIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deletedParaIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DeletedParaIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refreshInterval");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "refreshInterval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isInOfflineMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsInOfflineMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPreview");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsPreview"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serverVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ServerVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenceOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReferenceOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultReviewZoneRole");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DefaultReviewZoneRole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasContributorRight");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "HasContributorRight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasAuthorRight");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "HasAuthorRight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasReviewerRight");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "HasReviewerRight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isReviewZoneEnabled");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsReviewZoneEnabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRequiredUpdateFieldCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsRequiredUpdateFieldCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temporaryDirectoryForZip");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TemporaryDirectoryForZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temporaryDirectoryForAllReconcileReport");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TemporaryDirectoryForAllReconcileReport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasDelegates");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "HasDelegates"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protectDownloadedDocument");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ProtectDownloadedDocument"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showPageBorders");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ShowPageBorders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isHTML5Mode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsHTML5Mode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFlightMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsFlightMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
