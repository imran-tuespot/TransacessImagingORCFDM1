/**
 * ListReviewDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListReviewDTO  implements java.io.Serializable {
    private int workgroupId;

    private int folderId;

    private java.lang.String[] status;

    private java.lang.String title;

    private int ownerId;

    private boolean includeOwnerDto;

    private boolean includeDocumentFormatName;

    private int sortBy;

    private boolean sortDescending;

    private java.lang.String reviewType;

    private int parentReviewId;

    private boolean includeDeletedReviews;

    private boolean deletedReviewsOnly;

    private boolean isTaskgroup;

    public ListReviewDTO() {
    }

    public ListReviewDTO(
           int workgroupId,
           int folderId,
           java.lang.String[] status,
           java.lang.String title,
           int ownerId,
           boolean includeOwnerDto,
           boolean includeDocumentFormatName,
           int sortBy,
           boolean sortDescending,
           java.lang.String reviewType,
           int parentReviewId,
           boolean includeDeletedReviews,
           boolean deletedReviewsOnly,
           boolean isTaskgroup) {
           this.workgroupId = workgroupId;
           this.folderId = folderId;
           this.status = status;
           this.title = title;
           this.ownerId = ownerId;
           this.includeOwnerDto = includeOwnerDto;
           this.includeDocumentFormatName = includeDocumentFormatName;
           this.sortBy = sortBy;
           this.sortDescending = sortDescending;
           this.reviewType = reviewType;
           this.parentReviewId = parentReviewId;
           this.includeDeletedReviews = includeDeletedReviews;
           this.deletedReviewsOnly = deletedReviewsOnly;
           this.isTaskgroup = isTaskgroup;
    }


    /**
     * Gets the workgroupId value for this ListReviewDTO.
     * 
     * @return workgroupId
     */
    public int getWorkgroupId() {
        return workgroupId;
    }


    /**
     * Sets the workgroupId value for this ListReviewDTO.
     * 
     * @param workgroupId
     */
    public void setWorkgroupId(int workgroupId) {
        this.workgroupId = workgroupId;
    }


    /**
     * Gets the folderId value for this ListReviewDTO.
     * 
     * @return folderId
     */
    public int getFolderId() {
        return folderId;
    }


    /**
     * Sets the folderId value for this ListReviewDTO.
     * 
     * @param folderId
     */
    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }


    /**
     * Gets the status value for this ListReviewDTO.
     * 
     * @return status
     */
    public java.lang.String[] getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ListReviewDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String[] status) {
        this.status = status;
    }


    /**
     * Gets the title value for this ListReviewDTO.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this ListReviewDTO.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the ownerId value for this ListReviewDTO.
     * 
     * @return ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }


    /**
     * Sets the ownerId value for this ListReviewDTO.
     * 
     * @param ownerId
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }


    /**
     * Gets the includeOwnerDto value for this ListReviewDTO.
     * 
     * @return includeOwnerDto
     */
    public boolean isIncludeOwnerDto() {
        return includeOwnerDto;
    }


    /**
     * Sets the includeOwnerDto value for this ListReviewDTO.
     * 
     * @param includeOwnerDto
     */
    public void setIncludeOwnerDto(boolean includeOwnerDto) {
        this.includeOwnerDto = includeOwnerDto;
    }


    /**
     * Gets the includeDocumentFormatName value for this ListReviewDTO.
     * 
     * @return includeDocumentFormatName
     */
    public boolean isIncludeDocumentFormatName() {
        return includeDocumentFormatName;
    }


    /**
     * Sets the includeDocumentFormatName value for this ListReviewDTO.
     * 
     * @param includeDocumentFormatName
     */
    public void setIncludeDocumentFormatName(boolean includeDocumentFormatName) {
        this.includeDocumentFormatName = includeDocumentFormatName;
    }


    /**
     * Gets the sortBy value for this ListReviewDTO.
     * 
     * @return sortBy
     */
    public int getSortBy() {
        return sortBy;
    }


    /**
     * Sets the sortBy value for this ListReviewDTO.
     * 
     * @param sortBy
     */
    public void setSortBy(int sortBy) {
        this.sortBy = sortBy;
    }


    /**
     * Gets the sortDescending value for this ListReviewDTO.
     * 
     * @return sortDescending
     */
    public boolean isSortDescending() {
        return sortDescending;
    }


    /**
     * Sets the sortDescending value for this ListReviewDTO.
     * 
     * @param sortDescending
     */
    public void setSortDescending(boolean sortDescending) {
        this.sortDescending = sortDescending;
    }


    /**
     * Gets the reviewType value for this ListReviewDTO.
     * 
     * @return reviewType
     */
    public java.lang.String getReviewType() {
        return reviewType;
    }


    /**
     * Sets the reviewType value for this ListReviewDTO.
     * 
     * @param reviewType
     */
    public void setReviewType(java.lang.String reviewType) {
        this.reviewType = reviewType;
    }


    /**
     * Gets the parentReviewId value for this ListReviewDTO.
     * 
     * @return parentReviewId
     */
    public int getParentReviewId() {
        return parentReviewId;
    }


    /**
     * Sets the parentReviewId value for this ListReviewDTO.
     * 
     * @param parentReviewId
     */
    public void setParentReviewId(int parentReviewId) {
        this.parentReviewId = parentReviewId;
    }


    /**
     * Gets the includeDeletedReviews value for this ListReviewDTO.
     * 
     * @return includeDeletedReviews
     */
    public boolean isIncludeDeletedReviews() {
        return includeDeletedReviews;
    }


    /**
     * Sets the includeDeletedReviews value for this ListReviewDTO.
     * 
     * @param includeDeletedReviews
     */
    public void setIncludeDeletedReviews(boolean includeDeletedReviews) {
        this.includeDeletedReviews = includeDeletedReviews;
    }


    /**
     * Gets the deletedReviewsOnly value for this ListReviewDTO.
     * 
     * @return deletedReviewsOnly
     */
    public boolean isDeletedReviewsOnly() {
        return deletedReviewsOnly;
    }


    /**
     * Sets the deletedReviewsOnly value for this ListReviewDTO.
     * 
     * @param deletedReviewsOnly
     */
    public void setDeletedReviewsOnly(boolean deletedReviewsOnly) {
        this.deletedReviewsOnly = deletedReviewsOnly;
    }


    /**
     * Gets the isTaskgroup value for this ListReviewDTO.
     * 
     * @return isTaskgroup
     */
    public boolean isIsTaskgroup() {
        return isTaskgroup;
    }


    /**
     * Sets the isTaskgroup value for this ListReviewDTO.
     * 
     * @param isTaskgroup
     */
    public void setIsTaskgroup(boolean isTaskgroup) {
        this.isTaskgroup = isTaskgroup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListReviewDTO)) return false;
        ListReviewDTO other = (ListReviewDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.workgroupId == other.getWorkgroupId() &&
            this.folderId == other.getFolderId() &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              java.util.Arrays.equals(this.status, other.getStatus()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            this.ownerId == other.getOwnerId() &&
            this.includeOwnerDto == other.isIncludeOwnerDto() &&
            this.includeDocumentFormatName == other.isIncludeDocumentFormatName() &&
            this.sortBy == other.getSortBy() &&
            this.sortDescending == other.isSortDescending() &&
            ((this.reviewType==null && other.getReviewType()==null) || 
             (this.reviewType!=null &&
              this.reviewType.equals(other.getReviewType()))) &&
            this.parentReviewId == other.getParentReviewId() &&
            this.includeDeletedReviews == other.isIncludeDeletedReviews() &&
            this.deletedReviewsOnly == other.isDeletedReviewsOnly() &&
            this.isTaskgroup == other.isIsTaskgroup();
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
        _hashCode += getWorkgroupId();
        _hashCode += getFolderId();
        if (getStatus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStatus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStatus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        _hashCode += getOwnerId();
        _hashCode += (isIncludeOwnerDto() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeDocumentFormatName() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getSortBy();
        _hashCode += (isSortDescending() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getReviewType() != null) {
            _hashCode += getReviewType().hashCode();
        }
        _hashCode += getParentReviewId();
        _hashCode += (isIncludeDeletedReviews() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDeletedReviewsOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsTaskgroup() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListReviewDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListReviewDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OwnerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeOwnerDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IncludeOwnerDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeDocumentFormatName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IncludeDocumentFormatName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortBy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SortBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortDescending");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SortDescending"));
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
        elemField.setFieldName("parentReviewId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParentReviewId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeDeletedReviews");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IncludeDeletedReviews"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deletedReviewsOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DeletedReviewsOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTaskgroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsTaskgroup"));
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
