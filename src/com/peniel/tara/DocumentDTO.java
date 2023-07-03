/**
 * DocumentDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class DocumentDTO  implements java.io.Serializable {
    private int objectId;

    private int reviewId;

    private int workgroupId;

    private int folderId;

    private java.lang.String fileName;

    private java.lang.String formatName;

    private java.lang.String contentType;

    private int tocLevel;

    private int docSequence;

    private java.lang.String title;

    private java.util.Calendar createDate;

    private java.lang.String convertStatus;

    private java.lang.String extRef;

    private java.lang.String extSource;

    private java.lang.String serverVersion;

    private int modificationCount;

    private boolean referenceOnly;

    private java.lang.String documentType;

    private boolean alwaysCreateReview;

    private java.lang.String tags;

    private int deleted;

    private java.lang.String publishStatus;

    public DocumentDTO() {
    }

    public DocumentDTO(
           int objectId,
           int reviewId,
           int workgroupId,
           int folderId,
           java.lang.String fileName,
           java.lang.String formatName,
           java.lang.String contentType,
           int tocLevel,
           int docSequence,
           java.lang.String title,
           java.util.Calendar createDate,
           java.lang.String convertStatus,
           java.lang.String extRef,
           java.lang.String extSource,
           java.lang.String serverVersion,
           int modificationCount,
           boolean referenceOnly,
           java.lang.String documentType,
           boolean alwaysCreateReview,
           java.lang.String tags,
           int deleted,
           java.lang.String publishStatus) {
           this.objectId = objectId;
           this.reviewId = reviewId;
           this.workgroupId = workgroupId;
           this.folderId = folderId;
           this.fileName = fileName;
           this.formatName = formatName;
           this.contentType = contentType;
           this.tocLevel = tocLevel;
           this.docSequence = docSequence;
           this.title = title;
           this.createDate = createDate;
           this.convertStatus = convertStatus;
           this.extRef = extRef;
           this.extSource = extSource;
           this.serverVersion = serverVersion;
           this.modificationCount = modificationCount;
           this.referenceOnly = referenceOnly;
           this.documentType = documentType;
           this.alwaysCreateReview = alwaysCreateReview;
           this.tags = tags;
           this.deleted = deleted;
           this.publishStatus = publishStatus;
    }


    /**
     * Gets the objectId value for this DocumentDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this DocumentDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the reviewId value for this DocumentDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this DocumentDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the workgroupId value for this DocumentDTO.
     * 
     * @return workgroupId
     */
    public int getWorkgroupId() {
        return workgroupId;
    }


    /**
     * Sets the workgroupId value for this DocumentDTO.
     * 
     * @param workgroupId
     */
    public void setWorkgroupId(int workgroupId) {
        this.workgroupId = workgroupId;
    }


    /**
     * Gets the folderId value for this DocumentDTO.
     * 
     * @return folderId
     */
    public int getFolderId() {
        return folderId;
    }


    /**
     * Sets the folderId value for this DocumentDTO.
     * 
     * @param folderId
     */
    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }


    /**
     * Gets the fileName value for this DocumentDTO.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this DocumentDTO.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the formatName value for this DocumentDTO.
     * 
     * @return formatName
     */
    public java.lang.String getFormatName() {
        return formatName;
    }


    /**
     * Sets the formatName value for this DocumentDTO.
     * 
     * @param formatName
     */
    public void setFormatName(java.lang.String formatName) {
        this.formatName = formatName;
    }


    /**
     * Gets the contentType value for this DocumentDTO.
     * 
     * @return contentType
     */
    public java.lang.String getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this DocumentDTO.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.String contentType) {
        this.contentType = contentType;
    }


    /**
     * Gets the tocLevel value for this DocumentDTO.
     * 
     * @return tocLevel
     */
    public int getTocLevel() {
        return tocLevel;
    }


    /**
     * Sets the tocLevel value for this DocumentDTO.
     * 
     * @param tocLevel
     */
    public void setTocLevel(int tocLevel) {
        this.tocLevel = tocLevel;
    }


    /**
     * Gets the docSequence value for this DocumentDTO.
     * 
     * @return docSequence
     */
    public int getDocSequence() {
        return docSequence;
    }


    /**
     * Sets the docSequence value for this DocumentDTO.
     * 
     * @param docSequence
     */
    public void setDocSequence(int docSequence) {
        this.docSequence = docSequence;
    }


    /**
     * Gets the title value for this DocumentDTO.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this DocumentDTO.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the createDate value for this DocumentDTO.
     * 
     * @return createDate
     */
    public java.util.Calendar getCreateDate() {
        return createDate;
    }


    /**
     * Sets the createDate value for this DocumentDTO.
     * 
     * @param createDate
     */
    public void setCreateDate(java.util.Calendar createDate) {
        this.createDate = createDate;
    }


    /**
     * Gets the convertStatus value for this DocumentDTO.
     * 
     * @return convertStatus
     */
    public java.lang.String getConvertStatus() {
        return convertStatus;
    }


    /**
     * Sets the convertStatus value for this DocumentDTO.
     * 
     * @param convertStatus
     */
    public void setConvertStatus(java.lang.String convertStatus) {
        this.convertStatus = convertStatus;
    }


    /**
     * Gets the extRef value for this DocumentDTO.
     * 
     * @return extRef
     */
    public java.lang.String getExtRef() {
        return extRef;
    }


    /**
     * Sets the extRef value for this DocumentDTO.
     * 
     * @param extRef
     */
    public void setExtRef(java.lang.String extRef) {
        this.extRef = extRef;
    }


    /**
     * Gets the extSource value for this DocumentDTO.
     * 
     * @return extSource
     */
    public java.lang.String getExtSource() {
        return extSource;
    }


    /**
     * Sets the extSource value for this DocumentDTO.
     * 
     * @param extSource
     */
    public void setExtSource(java.lang.String extSource) {
        this.extSource = extSource;
    }


    /**
     * Gets the serverVersion value for this DocumentDTO.
     * 
     * @return serverVersion
     */
    public java.lang.String getServerVersion() {
        return serverVersion;
    }


    /**
     * Sets the serverVersion value for this DocumentDTO.
     * 
     * @param serverVersion
     */
    public void setServerVersion(java.lang.String serverVersion) {
        this.serverVersion = serverVersion;
    }


    /**
     * Gets the modificationCount value for this DocumentDTO.
     * 
     * @return modificationCount
     */
    public int getModificationCount() {
        return modificationCount;
    }


    /**
     * Sets the modificationCount value for this DocumentDTO.
     * 
     * @param modificationCount
     */
    public void setModificationCount(int modificationCount) {
        this.modificationCount = modificationCount;
    }


    /**
     * Gets the referenceOnly value for this DocumentDTO.
     * 
     * @return referenceOnly
     */
    public boolean isReferenceOnly() {
        return referenceOnly;
    }


    /**
     * Sets the referenceOnly value for this DocumentDTO.
     * 
     * @param referenceOnly
     */
    public void setReferenceOnly(boolean referenceOnly) {
        this.referenceOnly = referenceOnly;
    }


    /**
     * Gets the documentType value for this DocumentDTO.
     * 
     * @return documentType
     */
    public java.lang.String getDocumentType() {
        return documentType;
    }


    /**
     * Sets the documentType value for this DocumentDTO.
     * 
     * @param documentType
     */
    public void setDocumentType(java.lang.String documentType) {
        this.documentType = documentType;
    }


    /**
     * Gets the alwaysCreateReview value for this DocumentDTO.
     * 
     * @return alwaysCreateReview
     */
    public boolean isAlwaysCreateReview() {
        return alwaysCreateReview;
    }


    /**
     * Sets the alwaysCreateReview value for this DocumentDTO.
     * 
     * @param alwaysCreateReview
     */
    public void setAlwaysCreateReview(boolean alwaysCreateReview) {
        this.alwaysCreateReview = alwaysCreateReview;
    }


    /**
     * Gets the tags value for this DocumentDTO.
     * 
     * @return tags
     */
    public java.lang.String getTags() {
        return tags;
    }


    /**
     * Sets the tags value for this DocumentDTO.
     * 
     * @param tags
     */
    public void setTags(java.lang.String tags) {
        this.tags = tags;
    }


    /**
     * Gets the deleted value for this DocumentDTO.
     * 
     * @return deleted
     */
    public int getDeleted() {
        return deleted;
    }


    /**
     * Sets the deleted value for this DocumentDTO.
     * 
     * @param deleted
     */
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }


    /**
     * Gets the publishStatus value for this DocumentDTO.
     * 
     * @return publishStatus
     */
    public java.lang.String getPublishStatus() {
        return publishStatus;
    }


    /**
     * Sets the publishStatus value for this DocumentDTO.
     * 
     * @param publishStatus
     */
    public void setPublishStatus(java.lang.String publishStatus) {
        this.publishStatus = publishStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentDTO)) return false;
        DocumentDTO other = (DocumentDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            this.reviewId == other.getReviewId() &&
            this.workgroupId == other.getWorkgroupId() &&
            this.folderId == other.getFolderId() &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            ((this.formatName==null && other.getFormatName()==null) || 
             (this.formatName!=null &&
              this.formatName.equals(other.getFormatName()))) &&
            ((this.contentType==null && other.getContentType()==null) || 
             (this.contentType!=null &&
              this.contentType.equals(other.getContentType()))) &&
            this.tocLevel == other.getTocLevel() &&
            this.docSequence == other.getDocSequence() &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.createDate==null && other.getCreateDate()==null) || 
             (this.createDate!=null &&
              this.createDate.equals(other.getCreateDate()))) &&
            ((this.convertStatus==null && other.getConvertStatus()==null) || 
             (this.convertStatus!=null &&
              this.convertStatus.equals(other.getConvertStatus()))) &&
            ((this.extRef==null && other.getExtRef()==null) || 
             (this.extRef!=null &&
              this.extRef.equals(other.getExtRef()))) &&
            ((this.extSource==null && other.getExtSource()==null) || 
             (this.extSource!=null &&
              this.extSource.equals(other.getExtSource()))) &&
            ((this.serverVersion==null && other.getServerVersion()==null) || 
             (this.serverVersion!=null &&
              this.serverVersion.equals(other.getServerVersion()))) &&
            this.modificationCount == other.getModificationCount() &&
            this.referenceOnly == other.isReferenceOnly() &&
            ((this.documentType==null && other.getDocumentType()==null) || 
             (this.documentType!=null &&
              this.documentType.equals(other.getDocumentType()))) &&
            this.alwaysCreateReview == other.isAlwaysCreateReview() &&
            ((this.tags==null && other.getTags()==null) || 
             (this.tags!=null &&
              this.tags.equals(other.getTags()))) &&
            this.deleted == other.getDeleted() &&
            ((this.publishStatus==null && other.getPublishStatus()==null) || 
             (this.publishStatus!=null &&
              this.publishStatus.equals(other.getPublishStatus())));
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
        _hashCode += getObjectId();
        _hashCode += getReviewId();
        _hashCode += getWorkgroupId();
        _hashCode += getFolderId();
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        if (getFormatName() != null) {
            _hashCode += getFormatName().hashCode();
        }
        if (getContentType() != null) {
            _hashCode += getContentType().hashCode();
        }
        _hashCode += getTocLevel();
        _hashCode += getDocSequence();
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getCreateDate() != null) {
            _hashCode += getCreateDate().hashCode();
        }
        if (getConvertStatus() != null) {
            _hashCode += getConvertStatus().hashCode();
        }
        if (getExtRef() != null) {
            _hashCode += getExtRef().hashCode();
        }
        if (getExtSource() != null) {
            _hashCode += getExtSource().hashCode();
        }
        if (getServerVersion() != null) {
            _hashCode += getServerVersion().hashCode();
        }
        _hashCode += getModificationCount();
        _hashCode += (isReferenceOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDocumentType() != null) {
            _hashCode += getDocumentType().hashCode();
        }
        _hashCode += (isAlwaysCreateReview() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getTags() != null) {
            _hashCode += getTags().hashCode();
        }
        _hashCode += getDeleted();
        if (getPublishStatus() != null) {
            _hashCode += getPublishStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
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
        elemField.setFieldName("workgroupId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folderId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FolderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formatName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FormatName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ContentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tocLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TocLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docSequence");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocSequence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CreateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("convertStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ConvertStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extRef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ExtRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ExtSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("modificationCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ModificationCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenceOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReferenceOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alwaysCreateReview");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "AlwaysCreateReview"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tags");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Tags"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleted");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Deleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "PublishStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
