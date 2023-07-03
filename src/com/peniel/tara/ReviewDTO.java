/**
 * ReviewDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ReviewDTO  implements java.io.Serializable {
    private int objectId;

    private int ownerId;

    private com.peniel.tara.SubjectDTO ownerSubjectDTO;

    private int workgroupId;

    private int folderId;

    private int parentReviewId;

    private int lastCommentNumber;

    private boolean isCompound;

    private int duration;

    private java.lang.String title;

    private java.lang.String description;

    private java.util.Calendar startDate;

    private java.util.Calendar endDate;

    private java.util.Calendar closeDate;

    private java.util.Calendar completeDate;

    private java.util.Calendar updateDate;

    private java.lang.String status;

    private boolean independent;

    private java.lang.String reviewType;

    private java.lang.String documentFormatName;

    private int statusSequence;

    private int deleted;

    public ReviewDTO() {
    }

    public ReviewDTO(
           int objectId,
           int ownerId,
           com.peniel.tara.SubjectDTO ownerSubjectDTO,
           int workgroupId,
           int folderId,
           int parentReviewId,
           int lastCommentNumber,
           boolean isCompound,
           int duration,
           java.lang.String title,
           java.lang.String description,
           java.util.Calendar startDate,
           java.util.Calendar endDate,
           java.util.Calendar closeDate,
           java.util.Calendar completeDate,
           java.util.Calendar updateDate,
           java.lang.String status,
           boolean independent,
           java.lang.String reviewType,
           java.lang.String documentFormatName,
           int statusSequence,
           int deleted) {
           this.objectId = objectId;
           this.ownerId = ownerId;
           this.ownerSubjectDTO = ownerSubjectDTO;
           this.workgroupId = workgroupId;
           this.folderId = folderId;
           this.parentReviewId = parentReviewId;
           this.lastCommentNumber = lastCommentNumber;
           this.isCompound = isCompound;
           this.duration = duration;
           this.title = title;
           this.description = description;
           this.startDate = startDate;
           this.endDate = endDate;
           this.closeDate = closeDate;
           this.completeDate = completeDate;
           this.updateDate = updateDate;
           this.status = status;
           this.independent = independent;
           this.reviewType = reviewType;
           this.documentFormatName = documentFormatName;
           this.statusSequence = statusSequence;
           this.deleted = deleted;
    }


    /**
     * Gets the objectId value for this ReviewDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this ReviewDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the ownerId value for this ReviewDTO.
     * 
     * @return ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }


    /**
     * Sets the ownerId value for this ReviewDTO.
     * 
     * @param ownerId
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }


    /**
     * Gets the ownerSubjectDTO value for this ReviewDTO.
     * 
     * @return ownerSubjectDTO
     */
    public com.peniel.tara.SubjectDTO getOwnerSubjectDTO() {
        return ownerSubjectDTO;
    }


    /**
     * Sets the ownerSubjectDTO value for this ReviewDTO.
     * 
     * @param ownerSubjectDTO
     */
    public void setOwnerSubjectDTO(com.peniel.tara.SubjectDTO ownerSubjectDTO) {
        this.ownerSubjectDTO = ownerSubjectDTO;
    }


    /**
     * Gets the workgroupId value for this ReviewDTO.
     * 
     * @return workgroupId
     */
    public int getWorkgroupId() {
        return workgroupId;
    }


    /**
     * Sets the workgroupId value for this ReviewDTO.
     * 
     * @param workgroupId
     */
    public void setWorkgroupId(int workgroupId) {
        this.workgroupId = workgroupId;
    }


    /**
     * Gets the folderId value for this ReviewDTO.
     * 
     * @return folderId
     */
    public int getFolderId() {
        return folderId;
    }


    /**
     * Sets the folderId value for this ReviewDTO.
     * 
     * @param folderId
     */
    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }


    /**
     * Gets the parentReviewId value for this ReviewDTO.
     * 
     * @return parentReviewId
     */
    public int getParentReviewId() {
        return parentReviewId;
    }


    /**
     * Sets the parentReviewId value for this ReviewDTO.
     * 
     * @param parentReviewId
     */
    public void setParentReviewId(int parentReviewId) {
        this.parentReviewId = parentReviewId;
    }


    /**
     * Gets the lastCommentNumber value for this ReviewDTO.
     * 
     * @return lastCommentNumber
     */
    public int getLastCommentNumber() {
        return lastCommentNumber;
    }


    /**
     * Sets the lastCommentNumber value for this ReviewDTO.
     * 
     * @param lastCommentNumber
     */
    public void setLastCommentNumber(int lastCommentNumber) {
        this.lastCommentNumber = lastCommentNumber;
    }


    /**
     * Gets the isCompound value for this ReviewDTO.
     * 
     * @return isCompound
     */
    public boolean isIsCompound() {
        return isCompound;
    }


    /**
     * Sets the isCompound value for this ReviewDTO.
     * 
     * @param isCompound
     */
    public void setIsCompound(boolean isCompound) {
        this.isCompound = isCompound;
    }


    /**
     * Gets the duration value for this ReviewDTO.
     * 
     * @return duration
     */
    public int getDuration() {
        return duration;
    }


    /**
     * Sets the duration value for this ReviewDTO.
     * 
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }


    /**
     * Gets the title value for this ReviewDTO.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this ReviewDTO.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the description value for this ReviewDTO.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ReviewDTO.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the startDate value for this ReviewDTO.
     * 
     * @return startDate
     */
    public java.util.Calendar getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this ReviewDTO.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Calendar startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the endDate value for this ReviewDTO.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this ReviewDTO.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the closeDate value for this ReviewDTO.
     * 
     * @return closeDate
     */
    public java.util.Calendar getCloseDate() {
        return closeDate;
    }


    /**
     * Sets the closeDate value for this ReviewDTO.
     * 
     * @param closeDate
     */
    public void setCloseDate(java.util.Calendar closeDate) {
        this.closeDate = closeDate;
    }


    /**
     * Gets the completeDate value for this ReviewDTO.
     * 
     * @return completeDate
     */
    public java.util.Calendar getCompleteDate() {
        return completeDate;
    }


    /**
     * Sets the completeDate value for this ReviewDTO.
     * 
     * @param completeDate
     */
    public void setCompleteDate(java.util.Calendar completeDate) {
        this.completeDate = completeDate;
    }


    /**
     * Gets the updateDate value for this ReviewDTO.
     * 
     * @return updateDate
     */
    public java.util.Calendar getUpdateDate() {
        return updateDate;
    }


    /**
     * Sets the updateDate value for this ReviewDTO.
     * 
     * @param updateDate
     */
    public void setUpdateDate(java.util.Calendar updateDate) {
        this.updateDate = updateDate;
    }


    /**
     * Gets the status value for this ReviewDTO.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ReviewDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the independent value for this ReviewDTO.
     * 
     * @return independent
     */
    public boolean isIndependent() {
        return independent;
    }


    /**
     * Sets the independent value for this ReviewDTO.
     * 
     * @param independent
     */
    public void setIndependent(boolean independent) {
        this.independent = independent;
    }


    /**
     * Gets the reviewType value for this ReviewDTO.
     * 
     * @return reviewType
     */
    public java.lang.String getReviewType() {
        return reviewType;
    }


    /**
     * Sets the reviewType value for this ReviewDTO.
     * 
     * @param reviewType
     */
    public void setReviewType(java.lang.String reviewType) {
        this.reviewType = reviewType;
    }


    /**
     * Gets the documentFormatName value for this ReviewDTO.
     * 
     * @return documentFormatName
     */
    public java.lang.String getDocumentFormatName() {
        return documentFormatName;
    }


    /**
     * Sets the documentFormatName value for this ReviewDTO.
     * 
     * @param documentFormatName
     */
    public void setDocumentFormatName(java.lang.String documentFormatName) {
        this.documentFormatName = documentFormatName;
    }


    /**
     * Gets the statusSequence value for this ReviewDTO.
     * 
     * @return statusSequence
     */
    public int getStatusSequence() {
        return statusSequence;
    }


    /**
     * Sets the statusSequence value for this ReviewDTO.
     * 
     * @param statusSequence
     */
    public void setStatusSequence(int statusSequence) {
        this.statusSequence = statusSequence;
    }


    /**
     * Gets the deleted value for this ReviewDTO.
     * 
     * @return deleted
     */
    public int getDeleted() {
        return deleted;
    }


    /**
     * Sets the deleted value for this ReviewDTO.
     * 
     * @param deleted
     */
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReviewDTO)) return false;
        ReviewDTO other = (ReviewDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            this.ownerId == other.getOwnerId() &&
            ((this.ownerSubjectDTO==null && other.getOwnerSubjectDTO()==null) || 
             (this.ownerSubjectDTO!=null &&
              this.ownerSubjectDTO.equals(other.getOwnerSubjectDTO()))) &&
            this.workgroupId == other.getWorkgroupId() &&
            this.folderId == other.getFolderId() &&
            this.parentReviewId == other.getParentReviewId() &&
            this.lastCommentNumber == other.getLastCommentNumber() &&
            this.isCompound == other.isIsCompound() &&
            this.duration == other.getDuration() &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.closeDate==null && other.getCloseDate()==null) || 
             (this.closeDate!=null &&
              this.closeDate.equals(other.getCloseDate()))) &&
            ((this.completeDate==null && other.getCompleteDate()==null) || 
             (this.completeDate!=null &&
              this.completeDate.equals(other.getCompleteDate()))) &&
            ((this.updateDate==null && other.getUpdateDate()==null) || 
             (this.updateDate!=null &&
              this.updateDate.equals(other.getUpdateDate()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            this.independent == other.isIndependent() &&
            ((this.reviewType==null && other.getReviewType()==null) || 
             (this.reviewType!=null &&
              this.reviewType.equals(other.getReviewType()))) &&
            ((this.documentFormatName==null && other.getDocumentFormatName()==null) || 
             (this.documentFormatName!=null &&
              this.documentFormatName.equals(other.getDocumentFormatName()))) &&
            this.statusSequence == other.getStatusSequence() &&
            this.deleted == other.getDeleted();
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
        _hashCode += getOwnerId();
        if (getOwnerSubjectDTO() != null) {
            _hashCode += getOwnerSubjectDTO().hashCode();
        }
        _hashCode += getWorkgroupId();
        _hashCode += getFolderId();
        _hashCode += getParentReviewId();
        _hashCode += getLastCommentNumber();
        _hashCode += (isIsCompound() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getDuration();
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getCloseDate() != null) {
            _hashCode += getCloseDate().hashCode();
        }
        if (getCompleteDate() != null) {
            _hashCode += getCompleteDate().hashCode();
        }
        if (getUpdateDate() != null) {
            _hashCode += getUpdateDate().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        _hashCode += (isIndependent() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getReviewType() != null) {
            _hashCode += getReviewType().hashCode();
        }
        if (getDocumentFormatName() != null) {
            _hashCode += getDocumentFormatName().hashCode();
        }
        _hashCode += getStatusSequence();
        _hashCode += getDeleted();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReviewDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OwnerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerSubjectDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OwnerSubjectDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("parentReviewId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParentReviewId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastCommentNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LastCommentNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCompound");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsCompound"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Duration"));
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
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "StartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closeDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CloseDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("completeDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CompleteDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UpdateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("independent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Independent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentFormatName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentFormatName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusSequence");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "StatusSequence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleted");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Deleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
