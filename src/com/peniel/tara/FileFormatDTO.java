/**
 * FileFormatDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class FileFormatDTO  implements java.io.Serializable {
    private java.lang.String formatName;

    private java.lang.String defaultFileExtension;

    private java.lang.String[] fileExtensions;

    private java.lang.String[] defaultFormatFileExtensions;

    private java.lang.String defaultContentType;

    private java.lang.String[] contentTypes;

    private java.lang.String[] defaultFormatContentTypes;

    private boolean supportsDocumentMap;

    private boolean supportsHeadings;

    private boolean supportsParagraphIds;

    private boolean numericParagraphIds;

    private boolean reviewDownloadUseDirect;

    private boolean reviewDownloadBlankTarget;

    private boolean reviewDownloadUseAttachment;

    private boolean reviewDownloadIsHtml;

    private boolean otherDownloadUseDirect;

    private boolean otherDownloadBlankTarget;

    private boolean otherDownloadUseAttachment;

    private boolean otherDownloadIsHtml;

    private boolean browserPlugin;

    private boolean canGetParagraphText;

    private boolean implementsReconcileDownload;

    private boolean implementsOfflineDownload;

    private boolean implementsCompare;

    private boolean requiresPreparation;

    private boolean isImage;

    private java.lang.String BSAdapterClass;

    private java.lang.String webAdapterClass;

    private com.peniel.tara.FileFormatViewModeDTO[] viewModes;

    private java.lang.String reconcileReportTemplate;

    private java.lang.String extraJavascript;

    private java.lang.String commentSelector;

    private com.peniel.tara.ArrayOfXmlElementXmlElement[] customProperties;

    private boolean supportsRichTextEditing;

    private boolean supportsCollaborativeEditing;

    private boolean supportsFeedback;

    public FileFormatDTO() {
    }

    public FileFormatDTO(
           java.lang.String formatName,
           java.lang.String defaultFileExtension,
           java.lang.String[] fileExtensions,
           java.lang.String[] defaultFormatFileExtensions,
           java.lang.String defaultContentType,
           java.lang.String[] contentTypes,
           java.lang.String[] defaultFormatContentTypes,
           boolean supportsDocumentMap,
           boolean supportsHeadings,
           boolean supportsParagraphIds,
           boolean numericParagraphIds,
           boolean reviewDownloadUseDirect,
           boolean reviewDownloadBlankTarget,
           boolean reviewDownloadUseAttachment,
           boolean reviewDownloadIsHtml,
           boolean otherDownloadUseDirect,
           boolean otherDownloadBlankTarget,
           boolean otherDownloadUseAttachment,
           boolean otherDownloadIsHtml,
           boolean browserPlugin,
           boolean canGetParagraphText,
           boolean implementsReconcileDownload,
           boolean implementsOfflineDownload,
           boolean implementsCompare,
           boolean requiresPreparation,
           boolean isImage,
           java.lang.String BSAdapterClass,
           java.lang.String webAdapterClass,
           com.peniel.tara.FileFormatViewModeDTO[] viewModes,
           java.lang.String reconcileReportTemplate,
           java.lang.String extraJavascript,
           java.lang.String commentSelector,
           com.peniel.tara.ArrayOfXmlElementXmlElement[] customProperties,
           boolean supportsRichTextEditing,
           boolean supportsCollaborativeEditing,
           boolean supportsFeedback) {
           this.formatName = formatName;
           this.defaultFileExtension = defaultFileExtension;
           this.fileExtensions = fileExtensions;
           this.defaultFormatFileExtensions = defaultFormatFileExtensions;
           this.defaultContentType = defaultContentType;
           this.contentTypes = contentTypes;
           this.defaultFormatContentTypes = defaultFormatContentTypes;
           this.supportsDocumentMap = supportsDocumentMap;
           this.supportsHeadings = supportsHeadings;
           this.supportsParagraphIds = supportsParagraphIds;
           this.numericParagraphIds = numericParagraphIds;
           this.reviewDownloadUseDirect = reviewDownloadUseDirect;
           this.reviewDownloadBlankTarget = reviewDownloadBlankTarget;
           this.reviewDownloadUseAttachment = reviewDownloadUseAttachment;
           this.reviewDownloadIsHtml = reviewDownloadIsHtml;
           this.otherDownloadUseDirect = otherDownloadUseDirect;
           this.otherDownloadBlankTarget = otherDownloadBlankTarget;
           this.otherDownloadUseAttachment = otherDownloadUseAttachment;
           this.otherDownloadIsHtml = otherDownloadIsHtml;
           this.browserPlugin = browserPlugin;
           this.canGetParagraphText = canGetParagraphText;
           this.implementsReconcileDownload = implementsReconcileDownload;
           this.implementsOfflineDownload = implementsOfflineDownload;
           this.implementsCompare = implementsCompare;
           this.requiresPreparation = requiresPreparation;
           this.isImage = isImage;
           this.BSAdapterClass = BSAdapterClass;
           this.webAdapterClass = webAdapterClass;
           this.viewModes = viewModes;
           this.reconcileReportTemplate = reconcileReportTemplate;
           this.extraJavascript = extraJavascript;
           this.commentSelector = commentSelector;
           this.customProperties = customProperties;
           this.supportsRichTextEditing = supportsRichTextEditing;
           this.supportsCollaborativeEditing = supportsCollaborativeEditing;
           this.supportsFeedback = supportsFeedback;
    }


    /**
     * Gets the formatName value for this FileFormatDTO.
     * 
     * @return formatName
     */
    public java.lang.String getFormatName() {
        return formatName;
    }


    /**
     * Sets the formatName value for this FileFormatDTO.
     * 
     * @param formatName
     */
    public void setFormatName(java.lang.String formatName) {
        this.formatName = formatName;
    }


    /**
     * Gets the defaultFileExtension value for this FileFormatDTO.
     * 
     * @return defaultFileExtension
     */
    public java.lang.String getDefaultFileExtension() {
        return defaultFileExtension;
    }


    /**
     * Sets the defaultFileExtension value for this FileFormatDTO.
     * 
     * @param defaultFileExtension
     */
    public void setDefaultFileExtension(java.lang.String defaultFileExtension) {
        this.defaultFileExtension = defaultFileExtension;
    }


    /**
     * Gets the fileExtensions value for this FileFormatDTO.
     * 
     * @return fileExtensions
     */
    public java.lang.String[] getFileExtensions() {
        return fileExtensions;
    }


    /**
     * Sets the fileExtensions value for this FileFormatDTO.
     * 
     * @param fileExtensions
     */
    public void setFileExtensions(java.lang.String[] fileExtensions) {
        this.fileExtensions = fileExtensions;
    }


    /**
     * Gets the defaultFormatFileExtensions value for this FileFormatDTO.
     * 
     * @return defaultFormatFileExtensions
     */
    public java.lang.String[] getDefaultFormatFileExtensions() {
        return defaultFormatFileExtensions;
    }


    /**
     * Sets the defaultFormatFileExtensions value for this FileFormatDTO.
     * 
     * @param defaultFormatFileExtensions
     */
    public void setDefaultFormatFileExtensions(java.lang.String[] defaultFormatFileExtensions) {
        this.defaultFormatFileExtensions = defaultFormatFileExtensions;
    }


    /**
     * Gets the defaultContentType value for this FileFormatDTO.
     * 
     * @return defaultContentType
     */
    public java.lang.String getDefaultContentType() {
        return defaultContentType;
    }


    /**
     * Sets the defaultContentType value for this FileFormatDTO.
     * 
     * @param defaultContentType
     */
    public void setDefaultContentType(java.lang.String defaultContentType) {
        this.defaultContentType = defaultContentType;
    }


    /**
     * Gets the contentTypes value for this FileFormatDTO.
     * 
     * @return contentTypes
     */
    public java.lang.String[] getContentTypes() {
        return contentTypes;
    }


    /**
     * Sets the contentTypes value for this FileFormatDTO.
     * 
     * @param contentTypes
     */
    public void setContentTypes(java.lang.String[] contentTypes) {
        this.contentTypes = contentTypes;
    }


    /**
     * Gets the defaultFormatContentTypes value for this FileFormatDTO.
     * 
     * @return defaultFormatContentTypes
     */
    public java.lang.String[] getDefaultFormatContentTypes() {
        return defaultFormatContentTypes;
    }


    /**
     * Sets the defaultFormatContentTypes value for this FileFormatDTO.
     * 
     * @param defaultFormatContentTypes
     */
    public void setDefaultFormatContentTypes(java.lang.String[] defaultFormatContentTypes) {
        this.defaultFormatContentTypes = defaultFormatContentTypes;
    }


    /**
     * Gets the supportsDocumentMap value for this FileFormatDTO.
     * 
     * @return supportsDocumentMap
     */
    public boolean isSupportsDocumentMap() {
        return supportsDocumentMap;
    }


    /**
     * Sets the supportsDocumentMap value for this FileFormatDTO.
     * 
     * @param supportsDocumentMap
     */
    public void setSupportsDocumentMap(boolean supportsDocumentMap) {
        this.supportsDocumentMap = supportsDocumentMap;
    }


    /**
     * Gets the supportsHeadings value for this FileFormatDTO.
     * 
     * @return supportsHeadings
     */
    public boolean isSupportsHeadings() {
        return supportsHeadings;
    }


    /**
     * Sets the supportsHeadings value for this FileFormatDTO.
     * 
     * @param supportsHeadings
     */
    public void setSupportsHeadings(boolean supportsHeadings) {
        this.supportsHeadings = supportsHeadings;
    }


    /**
     * Gets the supportsParagraphIds value for this FileFormatDTO.
     * 
     * @return supportsParagraphIds
     */
    public boolean isSupportsParagraphIds() {
        return supportsParagraphIds;
    }


    /**
     * Sets the supportsParagraphIds value for this FileFormatDTO.
     * 
     * @param supportsParagraphIds
     */
    public void setSupportsParagraphIds(boolean supportsParagraphIds) {
        this.supportsParagraphIds = supportsParagraphIds;
    }


    /**
     * Gets the numericParagraphIds value for this FileFormatDTO.
     * 
     * @return numericParagraphIds
     */
    public boolean isNumericParagraphIds() {
        return numericParagraphIds;
    }


    /**
     * Sets the numericParagraphIds value for this FileFormatDTO.
     * 
     * @param numericParagraphIds
     */
    public void setNumericParagraphIds(boolean numericParagraphIds) {
        this.numericParagraphIds = numericParagraphIds;
    }


    /**
     * Gets the reviewDownloadUseDirect value for this FileFormatDTO.
     * 
     * @return reviewDownloadUseDirect
     */
    public boolean isReviewDownloadUseDirect() {
        return reviewDownloadUseDirect;
    }


    /**
     * Sets the reviewDownloadUseDirect value for this FileFormatDTO.
     * 
     * @param reviewDownloadUseDirect
     */
    public void setReviewDownloadUseDirect(boolean reviewDownloadUseDirect) {
        this.reviewDownloadUseDirect = reviewDownloadUseDirect;
    }


    /**
     * Gets the reviewDownloadBlankTarget value for this FileFormatDTO.
     * 
     * @return reviewDownloadBlankTarget
     */
    public boolean isReviewDownloadBlankTarget() {
        return reviewDownloadBlankTarget;
    }


    /**
     * Sets the reviewDownloadBlankTarget value for this FileFormatDTO.
     * 
     * @param reviewDownloadBlankTarget
     */
    public void setReviewDownloadBlankTarget(boolean reviewDownloadBlankTarget) {
        this.reviewDownloadBlankTarget = reviewDownloadBlankTarget;
    }


    /**
     * Gets the reviewDownloadUseAttachment value for this FileFormatDTO.
     * 
     * @return reviewDownloadUseAttachment
     */
    public boolean isReviewDownloadUseAttachment() {
        return reviewDownloadUseAttachment;
    }


    /**
     * Sets the reviewDownloadUseAttachment value for this FileFormatDTO.
     * 
     * @param reviewDownloadUseAttachment
     */
    public void setReviewDownloadUseAttachment(boolean reviewDownloadUseAttachment) {
        this.reviewDownloadUseAttachment = reviewDownloadUseAttachment;
    }


    /**
     * Gets the reviewDownloadIsHtml value for this FileFormatDTO.
     * 
     * @return reviewDownloadIsHtml
     */
    public boolean isReviewDownloadIsHtml() {
        return reviewDownloadIsHtml;
    }


    /**
     * Sets the reviewDownloadIsHtml value for this FileFormatDTO.
     * 
     * @param reviewDownloadIsHtml
     */
    public void setReviewDownloadIsHtml(boolean reviewDownloadIsHtml) {
        this.reviewDownloadIsHtml = reviewDownloadIsHtml;
    }


    /**
     * Gets the otherDownloadUseDirect value for this FileFormatDTO.
     * 
     * @return otherDownloadUseDirect
     */
    public boolean isOtherDownloadUseDirect() {
        return otherDownloadUseDirect;
    }


    /**
     * Sets the otherDownloadUseDirect value for this FileFormatDTO.
     * 
     * @param otherDownloadUseDirect
     */
    public void setOtherDownloadUseDirect(boolean otherDownloadUseDirect) {
        this.otherDownloadUseDirect = otherDownloadUseDirect;
    }


    /**
     * Gets the otherDownloadBlankTarget value for this FileFormatDTO.
     * 
     * @return otherDownloadBlankTarget
     */
    public boolean isOtherDownloadBlankTarget() {
        return otherDownloadBlankTarget;
    }


    /**
     * Sets the otherDownloadBlankTarget value for this FileFormatDTO.
     * 
     * @param otherDownloadBlankTarget
     */
    public void setOtherDownloadBlankTarget(boolean otherDownloadBlankTarget) {
        this.otherDownloadBlankTarget = otherDownloadBlankTarget;
    }


    /**
     * Gets the otherDownloadUseAttachment value for this FileFormatDTO.
     * 
     * @return otherDownloadUseAttachment
     */
    public boolean isOtherDownloadUseAttachment() {
        return otherDownloadUseAttachment;
    }


    /**
     * Sets the otherDownloadUseAttachment value for this FileFormatDTO.
     * 
     * @param otherDownloadUseAttachment
     */
    public void setOtherDownloadUseAttachment(boolean otherDownloadUseAttachment) {
        this.otherDownloadUseAttachment = otherDownloadUseAttachment;
    }


    /**
     * Gets the otherDownloadIsHtml value for this FileFormatDTO.
     * 
     * @return otherDownloadIsHtml
     */
    public boolean isOtherDownloadIsHtml() {
        return otherDownloadIsHtml;
    }


    /**
     * Sets the otherDownloadIsHtml value for this FileFormatDTO.
     * 
     * @param otherDownloadIsHtml
     */
    public void setOtherDownloadIsHtml(boolean otherDownloadIsHtml) {
        this.otherDownloadIsHtml = otherDownloadIsHtml;
    }


    /**
     * Gets the browserPlugin value for this FileFormatDTO.
     * 
     * @return browserPlugin
     */
    public boolean isBrowserPlugin() {
        return browserPlugin;
    }


    /**
     * Sets the browserPlugin value for this FileFormatDTO.
     * 
     * @param browserPlugin
     */
    public void setBrowserPlugin(boolean browserPlugin) {
        this.browserPlugin = browserPlugin;
    }


    /**
     * Gets the canGetParagraphText value for this FileFormatDTO.
     * 
     * @return canGetParagraphText
     */
    public boolean isCanGetParagraphText() {
        return canGetParagraphText;
    }


    /**
     * Sets the canGetParagraphText value for this FileFormatDTO.
     * 
     * @param canGetParagraphText
     */
    public void setCanGetParagraphText(boolean canGetParagraphText) {
        this.canGetParagraphText = canGetParagraphText;
    }


    /**
     * Gets the implementsReconcileDownload value for this FileFormatDTO.
     * 
     * @return implementsReconcileDownload
     */
    public boolean isImplementsReconcileDownload() {
        return implementsReconcileDownload;
    }


    /**
     * Sets the implementsReconcileDownload value for this FileFormatDTO.
     * 
     * @param implementsReconcileDownload
     */
    public void setImplementsReconcileDownload(boolean implementsReconcileDownload) {
        this.implementsReconcileDownload = implementsReconcileDownload;
    }


    /**
     * Gets the implementsOfflineDownload value for this FileFormatDTO.
     * 
     * @return implementsOfflineDownload
     */
    public boolean isImplementsOfflineDownload() {
        return implementsOfflineDownload;
    }


    /**
     * Sets the implementsOfflineDownload value for this FileFormatDTO.
     * 
     * @param implementsOfflineDownload
     */
    public void setImplementsOfflineDownload(boolean implementsOfflineDownload) {
        this.implementsOfflineDownload = implementsOfflineDownload;
    }


    /**
     * Gets the implementsCompare value for this FileFormatDTO.
     * 
     * @return implementsCompare
     */
    public boolean isImplementsCompare() {
        return implementsCompare;
    }


    /**
     * Sets the implementsCompare value for this FileFormatDTO.
     * 
     * @param implementsCompare
     */
    public void setImplementsCompare(boolean implementsCompare) {
        this.implementsCompare = implementsCompare;
    }


    /**
     * Gets the requiresPreparation value for this FileFormatDTO.
     * 
     * @return requiresPreparation
     */
    public boolean isRequiresPreparation() {
        return requiresPreparation;
    }


    /**
     * Sets the requiresPreparation value for this FileFormatDTO.
     * 
     * @param requiresPreparation
     */
    public void setRequiresPreparation(boolean requiresPreparation) {
        this.requiresPreparation = requiresPreparation;
    }


    /**
     * Gets the isImage value for this FileFormatDTO.
     * 
     * @return isImage
     */
    public boolean isIsImage() {
        return isImage;
    }


    /**
     * Sets the isImage value for this FileFormatDTO.
     * 
     * @param isImage
     */
    public void setIsImage(boolean isImage) {
        this.isImage = isImage;
    }


    /**
     * Gets the BSAdapterClass value for this FileFormatDTO.
     * 
     * @return BSAdapterClass
     */
    public java.lang.String getBSAdapterClass() {
        return BSAdapterClass;
    }


    /**
     * Sets the BSAdapterClass value for this FileFormatDTO.
     * 
     * @param BSAdapterClass
     */
    public void setBSAdapterClass(java.lang.String BSAdapterClass) {
        this.BSAdapterClass = BSAdapterClass;
    }


    /**
     * Gets the webAdapterClass value for this FileFormatDTO.
     * 
     * @return webAdapterClass
     */
    public java.lang.String getWebAdapterClass() {
        return webAdapterClass;
    }


    /**
     * Sets the webAdapterClass value for this FileFormatDTO.
     * 
     * @param webAdapterClass
     */
    public void setWebAdapterClass(java.lang.String webAdapterClass) {
        this.webAdapterClass = webAdapterClass;
    }


    /**
     * Gets the viewModes value for this FileFormatDTO.
     * 
     * @return viewModes
     */
    public com.peniel.tara.FileFormatViewModeDTO[] getViewModes() {
        return viewModes;
    }


    /**
     * Sets the viewModes value for this FileFormatDTO.
     * 
     * @param viewModes
     */
    public void setViewModes(com.peniel.tara.FileFormatViewModeDTO[] viewModes) {
        this.viewModes = viewModes;
    }


    /**
     * Gets the reconcileReportTemplate value for this FileFormatDTO.
     * 
     * @return reconcileReportTemplate
     */
    public java.lang.String getReconcileReportTemplate() {
        return reconcileReportTemplate;
    }


    /**
     * Sets the reconcileReportTemplate value for this FileFormatDTO.
     * 
     * @param reconcileReportTemplate
     */
    public void setReconcileReportTemplate(java.lang.String reconcileReportTemplate) {
        this.reconcileReportTemplate = reconcileReportTemplate;
    }


    /**
     * Gets the extraJavascript value for this FileFormatDTO.
     * 
     * @return extraJavascript
     */
    public java.lang.String getExtraJavascript() {
        return extraJavascript;
    }


    /**
     * Sets the extraJavascript value for this FileFormatDTO.
     * 
     * @param extraJavascript
     */
    public void setExtraJavascript(java.lang.String extraJavascript) {
        this.extraJavascript = extraJavascript;
    }


    /**
     * Gets the commentSelector value for this FileFormatDTO.
     * 
     * @return commentSelector
     */
    public java.lang.String getCommentSelector() {
        return commentSelector;
    }


    /**
     * Sets the commentSelector value for this FileFormatDTO.
     * 
     * @param commentSelector
     */
    public void setCommentSelector(java.lang.String commentSelector) {
        this.commentSelector = commentSelector;
    }


    /**
     * Gets the customProperties value for this FileFormatDTO.
     * 
     * @return customProperties
     */
    public com.peniel.tara.ArrayOfXmlElementXmlElement[] getCustomProperties() {
        return customProperties;
    }


    /**
     * Sets the customProperties value for this FileFormatDTO.
     * 
     * @param customProperties
     */
    public void setCustomProperties(com.peniel.tara.ArrayOfXmlElementXmlElement[] customProperties) {
        this.customProperties = customProperties;
    }


    /**
     * Gets the supportsRichTextEditing value for this FileFormatDTO.
     * 
     * @return supportsRichTextEditing
     */
    public boolean isSupportsRichTextEditing() {
        return supportsRichTextEditing;
    }


    /**
     * Sets the supportsRichTextEditing value for this FileFormatDTO.
     * 
     * @param supportsRichTextEditing
     */
    public void setSupportsRichTextEditing(boolean supportsRichTextEditing) {
        this.supportsRichTextEditing = supportsRichTextEditing;
    }


    /**
     * Gets the supportsCollaborativeEditing value for this FileFormatDTO.
     * 
     * @return supportsCollaborativeEditing
     */
    public boolean isSupportsCollaborativeEditing() {
        return supportsCollaborativeEditing;
    }


    /**
     * Sets the supportsCollaborativeEditing value for this FileFormatDTO.
     * 
     * @param supportsCollaborativeEditing
     */
    public void setSupportsCollaborativeEditing(boolean supportsCollaborativeEditing) {
        this.supportsCollaborativeEditing = supportsCollaborativeEditing;
    }


    /**
     * Gets the supportsFeedback value for this FileFormatDTO.
     * 
     * @return supportsFeedback
     */
    public boolean isSupportsFeedback() {
        return supportsFeedback;
    }


    /**
     * Sets the supportsFeedback value for this FileFormatDTO.
     * 
     * @param supportsFeedback
     */
    public void setSupportsFeedback(boolean supportsFeedback) {
        this.supportsFeedback = supportsFeedback;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FileFormatDTO)) return false;
        FileFormatDTO other = (FileFormatDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.formatName==null && other.getFormatName()==null) || 
             (this.formatName!=null &&
              this.formatName.equals(other.getFormatName()))) &&
            ((this.defaultFileExtension==null && other.getDefaultFileExtension()==null) || 
             (this.defaultFileExtension!=null &&
              this.defaultFileExtension.equals(other.getDefaultFileExtension()))) &&
            ((this.fileExtensions==null && other.getFileExtensions()==null) || 
             (this.fileExtensions!=null &&
              java.util.Arrays.equals(this.fileExtensions, other.getFileExtensions()))) &&
            ((this.defaultFormatFileExtensions==null && other.getDefaultFormatFileExtensions()==null) || 
             (this.defaultFormatFileExtensions!=null &&
              java.util.Arrays.equals(this.defaultFormatFileExtensions, other.getDefaultFormatFileExtensions()))) &&
            ((this.defaultContentType==null && other.getDefaultContentType()==null) || 
             (this.defaultContentType!=null &&
              this.defaultContentType.equals(other.getDefaultContentType()))) &&
            ((this.contentTypes==null && other.getContentTypes()==null) || 
             (this.contentTypes!=null &&
              java.util.Arrays.equals(this.contentTypes, other.getContentTypes()))) &&
            ((this.defaultFormatContentTypes==null && other.getDefaultFormatContentTypes()==null) || 
             (this.defaultFormatContentTypes!=null &&
              java.util.Arrays.equals(this.defaultFormatContentTypes, other.getDefaultFormatContentTypes()))) &&
            this.supportsDocumentMap == other.isSupportsDocumentMap() &&
            this.supportsHeadings == other.isSupportsHeadings() &&
            this.supportsParagraphIds == other.isSupportsParagraphIds() &&
            this.numericParagraphIds == other.isNumericParagraphIds() &&
            this.reviewDownloadUseDirect == other.isReviewDownloadUseDirect() &&
            this.reviewDownloadBlankTarget == other.isReviewDownloadBlankTarget() &&
            this.reviewDownloadUseAttachment == other.isReviewDownloadUseAttachment() &&
            this.reviewDownloadIsHtml == other.isReviewDownloadIsHtml() &&
            this.otherDownloadUseDirect == other.isOtherDownloadUseDirect() &&
            this.otherDownloadBlankTarget == other.isOtherDownloadBlankTarget() &&
            this.otherDownloadUseAttachment == other.isOtherDownloadUseAttachment() &&
            this.otherDownloadIsHtml == other.isOtherDownloadIsHtml() &&
            this.browserPlugin == other.isBrowserPlugin() &&
            this.canGetParagraphText == other.isCanGetParagraphText() &&
            this.implementsReconcileDownload == other.isImplementsReconcileDownload() &&
            this.implementsOfflineDownload == other.isImplementsOfflineDownload() &&
            this.implementsCompare == other.isImplementsCompare() &&
            this.requiresPreparation == other.isRequiresPreparation() &&
            this.isImage == other.isIsImage() &&
            ((this.BSAdapterClass==null && other.getBSAdapterClass()==null) || 
             (this.BSAdapterClass!=null &&
              this.BSAdapterClass.equals(other.getBSAdapterClass()))) &&
            ((this.webAdapterClass==null && other.getWebAdapterClass()==null) || 
             (this.webAdapterClass!=null &&
              this.webAdapterClass.equals(other.getWebAdapterClass()))) &&
            ((this.viewModes==null && other.getViewModes()==null) || 
             (this.viewModes!=null &&
              java.util.Arrays.equals(this.viewModes, other.getViewModes()))) &&
            ((this.reconcileReportTemplate==null && other.getReconcileReportTemplate()==null) || 
             (this.reconcileReportTemplate!=null &&
              this.reconcileReportTemplate.equals(other.getReconcileReportTemplate()))) &&
            ((this.extraJavascript==null && other.getExtraJavascript()==null) || 
             (this.extraJavascript!=null &&
              this.extraJavascript.equals(other.getExtraJavascript()))) &&
            ((this.commentSelector==null && other.getCommentSelector()==null) || 
             (this.commentSelector!=null &&
              this.commentSelector.equals(other.getCommentSelector()))) &&
            ((this.customProperties==null && other.getCustomProperties()==null) || 
             (this.customProperties!=null &&
              java.util.Arrays.equals(this.customProperties, other.getCustomProperties()))) &&
            this.supportsRichTextEditing == other.isSupportsRichTextEditing() &&
            this.supportsCollaborativeEditing == other.isSupportsCollaborativeEditing() &&
            this.supportsFeedback == other.isSupportsFeedback();
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
        if (getFormatName() != null) {
            _hashCode += getFormatName().hashCode();
        }
        if (getDefaultFileExtension() != null) {
            _hashCode += getDefaultFileExtension().hashCode();
        }
        if (getFileExtensions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFileExtensions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFileExtensions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDefaultFormatFileExtensions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDefaultFormatFileExtensions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDefaultFormatFileExtensions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDefaultContentType() != null) {
            _hashCode += getDefaultContentType().hashCode();
        }
        if (getContentTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContentTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContentTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDefaultFormatContentTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDefaultFormatContentTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDefaultFormatContentTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isSupportsDocumentMap() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSupportsHeadings() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSupportsParagraphIds() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isNumericParagraphIds() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isReviewDownloadUseDirect() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isReviewDownloadBlankTarget() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isReviewDownloadUseAttachment() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isReviewDownloadIsHtml() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOtherDownloadUseDirect() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOtherDownloadBlankTarget() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOtherDownloadUseAttachment() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOtherDownloadIsHtml() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isBrowserPlugin() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCanGetParagraphText() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isImplementsReconcileDownload() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isImplementsOfflineDownload() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isImplementsCompare() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRequiresPreparation() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsImage() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getBSAdapterClass() != null) {
            _hashCode += getBSAdapterClass().hashCode();
        }
        if (getWebAdapterClass() != null) {
            _hashCode += getWebAdapterClass().hashCode();
        }
        if (getViewModes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getViewModes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getViewModes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReconcileReportTemplate() != null) {
            _hashCode += getReconcileReportTemplate().hashCode();
        }
        if (getExtraJavascript() != null) {
            _hashCode += getExtraJavascript().hashCode();
        }
        if (getCommentSelector() != null) {
            _hashCode += getCommentSelector().hashCode();
        }
        if (getCustomProperties() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomProperties());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomProperties(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isSupportsRichTextEditing() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSupportsCollaborativeEditing() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSupportsFeedback() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FileFormatDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileFormatDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formatName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FormatName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultFileExtension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DefaultFileExtension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileExtensions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileExtensions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultFormatFileExtensions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DefaultFormatFileExtensions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultContentType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DefaultContentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ContentTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultFormatContentTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DefaultFormatContentTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportsDocumentMap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SupportsDocumentMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportsHeadings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SupportsHeadings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportsParagraphIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SupportsParagraphIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numericParagraphIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "NumericParagraphIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewDownloadUseDirect");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDownloadUseDirect"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewDownloadBlankTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDownloadBlankTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewDownloadUseAttachment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDownloadUseAttachment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewDownloadIsHtml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDownloadIsHtml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherDownloadUseDirect");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OtherDownloadUseDirect"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherDownloadBlankTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OtherDownloadBlankTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherDownloadUseAttachment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OtherDownloadUseAttachment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherDownloadIsHtml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OtherDownloadIsHtml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("browserPlugin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "BrowserPlugin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canGetParagraphText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CanGetParagraphText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("implementsReconcileDownload");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ImplementsReconcileDownload"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("implementsOfflineDownload");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ImplementsOfflineDownload"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("implementsCompare");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ImplementsCompare"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requiresPreparation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "RequiresPreparation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isImage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsImage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BSAdapterClass");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "BSAdapterClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("webAdapterClass");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WebAdapterClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viewModes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ViewModes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileFormatViewModeDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileFormatViewModeDTO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reconcileReportTemplate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReconcileReportTemplate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extraJavascript");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ExtraJavascript"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentSelector");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentSelector"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customProperties");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CustomProperties"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ArrayOfXmlElement>XmlElement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "XmlElement"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportsRichTextEditing");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SupportsRichTextEditing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportsCollaborativeEditing");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SupportsCollaborativeEditing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportsFeedback");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SupportsFeedback"));
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
