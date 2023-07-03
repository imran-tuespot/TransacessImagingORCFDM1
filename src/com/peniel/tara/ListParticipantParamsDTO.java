/**
 * ListParticipantParamsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListParticipantParamsDTO  implements java.io.Serializable {
    private int subjectId;

    private int workgroupId;

    private java.lang.String[] status;

    private java.lang.String[] reviewStatus;

    private boolean includeReviewDto;

    private boolean includeOwnerDto;

    private boolean includeDocumentFormatName;

    private int sortBy;

    private boolean sortDescending;

    private java.lang.String reviewType;

    private boolean excludeReviewsWhereOwner;

    private boolean includeDeletedReviews;

    private boolean deletedReviewsOnly;

    private java.lang.String reviewTitle;

    public ListParticipantParamsDTO() {
    }

    public ListParticipantParamsDTO(
           int subjectId,
           int workgroupId,
           java.lang.String[] status,
           java.lang.String[] reviewStatus,
           boolean includeReviewDto,
           boolean includeOwnerDto,
           boolean includeDocumentFormatName,
           int sortBy,
           boolean sortDescending,
           java.lang.String reviewType,
           boolean excludeReviewsWhereOwner,
           boolean includeDeletedReviews,
           boolean deletedReviewsOnly,
           java.lang.String reviewTitle) {
           this.subjectId = subjectId;
           this.workgroupId = workgroupId;
           this.status = status;
           this.reviewStatus = reviewStatus;
           this.includeReviewDto = includeReviewDto;
           this.includeOwnerDto = includeOwnerDto;
           this.includeDocumentFormatName = includeDocumentFormatName;
           this.sortBy = sortBy;
           this.sortDescending = sortDescending;
           this.reviewType = reviewType;
           this.excludeReviewsWhereOwner = excludeReviewsWhereOwner;
           this.includeDeletedReviews = includeDeletedReviews;
           this.deletedReviewsOnly = deletedReviewsOnly;
           this.reviewTitle = reviewTitle;
    }


    /**
     * Gets the subjectId value for this ListParticipantParamsDTO.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this ListParticipantParamsDTO.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the workgroupId value for this ListParticipantParamsDTO.
     * 
     * @return workgroupId
     */
    public int getWorkgroupId() {
        return workgroupId;
    }


    /**
     * Sets the workgroupId value for this ListParticipantParamsDTO.
     * 
     * @param workgroupId
     */
    public void setWorkgroupId(int workgroupId) {
        this.workgroupId = workgroupId;
    }


    /**
     * Gets the status value for this ListParticipantParamsDTO.
     * 
     * @return status
     */
    public java.lang.String[] getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ListParticipantParamsDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String[] status) {
        this.status = status;
    }


    /**
     * Gets the reviewStatus value for this ListParticipantParamsDTO.
     * 
     * @return reviewStatus
     */
    public java.lang.String[] getReviewStatus() {
        return reviewStatus;
    }


    /**
     * Sets the reviewStatus value for this ListParticipantParamsDTO.
     * 
     * @param reviewStatus
     */
    public void setReviewStatus(java.lang.String[] reviewStatus) {
        this.reviewStatus = reviewStatus;
    }


    /**
     * Gets the includeReviewDto value for this ListParticipantParamsDTO.
     * 
     * @return includeReviewDto
     */
    public boolean isIncludeReviewDto() {
        return includeReviewDto;
    }


    /**
     * Sets the includeReviewDto value for this ListParticipantParamsDTO.
     * 
     * @param includeReviewDto
     */
    public void setIncludeReviewDto(boolean includeReviewDto) {
        this.includeReviewDto = includeReviewDto;
    }


    /**
     * Gets the includeOwnerDto value for this ListParticipantParamsDTO.
     * 
     * @return includeOwnerDto
     */
    public boolean isIncludeOwnerDto() {
        return includeOwnerDto;
    }


    /**
     * Sets the includeOwnerDto value for this ListParticipantParamsDTO.
     * 
     * @param includeOwnerDto
     */
    public void setIncludeOwnerDto(boolean includeOwnerDto) {
        this.includeOwnerDto = includeOwnerDto;
    }


    /**
     * Gets the includeDocumentFormatName value for this ListParticipantParamsDTO.
     * 
     * @return includeDocumentFormatName
     */
    public boolean isIncludeDocumentFormatName() {
        return includeDocumentFormatName;
    }


    /**
     * Sets the includeDocumentFormatName value for this ListParticipantParamsDTO.
     * 
     * @param includeDocumentFormatName
     */
    public void setIncludeDocumentFormatName(boolean includeDocumentFormatName) {
        this.includeDocumentFormatName = includeDocumentFormatName;
    }


    /**
     * Gets the sortBy value for this ListParticipantParamsDTO.
     * 
     * @return sortBy
     */
    public int getSortBy() {
        return sortBy;
    }


    /**
     * Sets the sortBy value for this ListParticipantParamsDTO.
     * 
     * @param sortBy
     */
    public void setSortBy(int sortBy) {
        this.sortBy = sortBy;
    }


    /**
     * Gets the sortDescending value for this ListParticipantParamsDTO.
     * 
     * @return sortDescending
     */
    public boolean isSortDescending() {
        return sortDescending;
    }


    /**
     * Sets the sortDescending value for this ListParticipantParamsDTO.
     * 
     * @param sortDescending
     */
    public void setSortDescending(boolean sortDescending) {
        this.sortDescending = sortDescending;
    }


    /**
     * Gets the reviewType value for this ListParticipantParamsDTO.
     * 
     * @return reviewType
     */
    public java.lang.String getReviewType() {
        return reviewType;
    }


    /**
     * Sets the reviewType value for this ListParticipantParamsDTO.
     * 
     * @param reviewType
     */
    public void setReviewType(java.lang.String reviewType) {
        this.reviewType = reviewType;
    }


    /**
     * Gets the excludeReviewsWhereOwner value for this ListParticipantParamsDTO.
     * 
     * @return excludeReviewsWhereOwner
     */
    public boolean isExcludeReviewsWhereOwner() {
        return excludeReviewsWhereOwner;
    }


    /**
     * Sets the excludeReviewsWhereOwner value for this ListParticipantParamsDTO.
     * 
     * @param excludeReviewsWhereOwner
     */
    public void setExcludeReviewsWhereOwner(boolean excludeReviewsWhereOwner) {
        this.excludeReviewsWhereOwner = excludeReviewsWhereOwner;
    }


    /**
     * Gets the includeDeletedReviews value for this ListParticipantParamsDTO.
     * 
     * @return includeDeletedReviews
     */
    public boolean isIncludeDeletedReviews() {
        return includeDeletedReviews;
    }


    /**
     * Sets the includeDeletedReviews value for this ListParticipantParamsDTO.
     * 
     * @param includeDeletedReviews
     */
    public void setIncludeDeletedReviews(boolean includeDeletedReviews) {
        this.includeDeletedReviews = includeDeletedReviews;
    }


    /**
     * Gets the deletedReviewsOnly value for this ListParticipantParamsDTO.
     * 
     * @return deletedReviewsOnly
     */
    public boolean isDeletedReviewsOnly() {
        return deletedReviewsOnly;
    }


    /**
     * Sets the deletedReviewsOnly value for this ListParticipantParamsDTO.
     * 
     * @param deletedReviewsOnly
     */
    public void setDeletedReviewsOnly(boolean deletedReviewsOnly) {
        this.deletedReviewsOnly = deletedReviewsOnly;
    }


    /**
     * Gets the reviewTitle value for this ListParticipantParamsDTO.
     * 
     * @return reviewTitle
     */
    public java.lang.String getReviewTitle() {
        return reviewTitle;
    }


    /**
     * Sets the reviewTitle value for this ListParticipantParamsDTO.
     * 
     * @param reviewTitle
     */
    public void setReviewTitle(java.lang.String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListParticipantParamsDTO)) return false;
        ListParticipantParamsDTO other = (ListParticipantParamsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.subjectId == other.getSubjectId() &&
            this.workgroupId == other.getWorkgroupId() &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              java.util.Arrays.equals(this.status, other.getStatus()))) &&
            ((this.reviewStatus==null && other.getReviewStatus()==null) || 
             (this.reviewStatus!=null &&
              java.util.Arrays.equals(this.reviewStatus, other.getReviewStatus()))) &&
            this.includeReviewDto == other.isIncludeReviewDto() &&
            this.includeOwnerDto == other.isIncludeOwnerDto() &&
            this.includeDocumentFormatName == other.isIncludeDocumentFormatName() &&
            this.sortBy == other.getSortBy() &&
            this.sortDescending == other.isSortDescending() &&
            ((this.reviewType==null && other.getReviewType()==null) || 
             (this.reviewType!=null &&
              this.reviewType.equals(other.getReviewType()))) &&
            this.excludeReviewsWhereOwner == other.isExcludeReviewsWhereOwner() &&
            this.includeDeletedReviews == other.isIncludeDeletedReviews() &&
            this.deletedReviewsOnly == other.isDeletedReviewsOnly() &&
            ((this.reviewTitle==null && other.getReviewTitle()==null) || 
             (this.reviewTitle!=null &&
              this.reviewTitle.equals(other.getReviewTitle())));
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
        _hashCode += getSubjectId();
        _hashCode += getWorkgroupId();
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
        if (getReviewStatus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReviewStatus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReviewStatus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isIncludeReviewDto() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeOwnerDto() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeDocumentFormatName() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getSortBy();
        _hashCode += (isSortDescending() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getReviewType() != null) {
            _hashCode += getReviewType().hashCode();
        }
        _hashCode += (isExcludeReviewsWhereOwner() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeDeletedReviews() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDeletedReviewsOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getReviewTitle() != null) {
            _hashCode += getReviewTitle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListParticipantParamsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListParticipantParamsDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectId"));
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
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeReviewDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IncludeReviewDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("excludeReviewsWhereOwner");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ExcludeReviewsWhereOwner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("reviewTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewTitle"));
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
