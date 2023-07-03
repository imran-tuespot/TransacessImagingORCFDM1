/**
 * ListEditDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListEditDTO  implements java.io.Serializable {
    private int objectId;

    private int excludeObjectId;

    private int reviewId;

    private int documentId;

    private int subjectId;

    private boolean includeSubjectDto;

    private java.lang.String startParagraphId;

    private java.lang.String endParagraphId;

    private java.lang.String status;

    private boolean notIncludeCompletedEdit;

    private java.lang.String originalEndParagraphId;

    private java.lang.String zoneType;

    private java.util.Calendar updateDate;

    public ListEditDTO() {
    }

    public ListEditDTO(
           int objectId,
           int excludeObjectId,
           int reviewId,
           int documentId,
           int subjectId,
           boolean includeSubjectDto,
           java.lang.String startParagraphId,
           java.lang.String endParagraphId,
           java.lang.String status,
           boolean notIncludeCompletedEdit,
           java.lang.String originalEndParagraphId,
           java.lang.String zoneType,
           java.util.Calendar updateDate) {
           this.objectId = objectId;
           this.excludeObjectId = excludeObjectId;
           this.reviewId = reviewId;
           this.documentId = documentId;
           this.subjectId = subjectId;
           this.includeSubjectDto = includeSubjectDto;
           this.startParagraphId = startParagraphId;
           this.endParagraphId = endParagraphId;
           this.status = status;
           this.notIncludeCompletedEdit = notIncludeCompletedEdit;
           this.originalEndParagraphId = originalEndParagraphId;
           this.zoneType = zoneType;
           this.updateDate = updateDate;
    }


    /**
     * Gets the objectId value for this ListEditDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this ListEditDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the excludeObjectId value for this ListEditDTO.
     * 
     * @return excludeObjectId
     */
    public int getExcludeObjectId() {
        return excludeObjectId;
    }


    /**
     * Sets the excludeObjectId value for this ListEditDTO.
     * 
     * @param excludeObjectId
     */
    public void setExcludeObjectId(int excludeObjectId) {
        this.excludeObjectId = excludeObjectId;
    }


    /**
     * Gets the reviewId value for this ListEditDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this ListEditDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the documentId value for this ListEditDTO.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this ListEditDTO.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the subjectId value for this ListEditDTO.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this ListEditDTO.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the includeSubjectDto value for this ListEditDTO.
     * 
     * @return includeSubjectDto
     */
    public boolean isIncludeSubjectDto() {
        return includeSubjectDto;
    }


    /**
     * Sets the includeSubjectDto value for this ListEditDTO.
     * 
     * @param includeSubjectDto
     */
    public void setIncludeSubjectDto(boolean includeSubjectDto) {
        this.includeSubjectDto = includeSubjectDto;
    }


    /**
     * Gets the startParagraphId value for this ListEditDTO.
     * 
     * @return startParagraphId
     */
    public java.lang.String getStartParagraphId() {
        return startParagraphId;
    }


    /**
     * Sets the startParagraphId value for this ListEditDTO.
     * 
     * @param startParagraphId
     */
    public void setStartParagraphId(java.lang.String startParagraphId) {
        this.startParagraphId = startParagraphId;
    }


    /**
     * Gets the endParagraphId value for this ListEditDTO.
     * 
     * @return endParagraphId
     */
    public java.lang.String getEndParagraphId() {
        return endParagraphId;
    }


    /**
     * Sets the endParagraphId value for this ListEditDTO.
     * 
     * @param endParagraphId
     */
    public void setEndParagraphId(java.lang.String endParagraphId) {
        this.endParagraphId = endParagraphId;
    }


    /**
     * Gets the status value for this ListEditDTO.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ListEditDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the notIncludeCompletedEdit value for this ListEditDTO.
     * 
     * @return notIncludeCompletedEdit
     */
    public boolean isNotIncludeCompletedEdit() {
        return notIncludeCompletedEdit;
    }


    /**
     * Sets the notIncludeCompletedEdit value for this ListEditDTO.
     * 
     * @param notIncludeCompletedEdit
     */
    public void setNotIncludeCompletedEdit(boolean notIncludeCompletedEdit) {
        this.notIncludeCompletedEdit = notIncludeCompletedEdit;
    }


    /**
     * Gets the originalEndParagraphId value for this ListEditDTO.
     * 
     * @return originalEndParagraphId
     */
    public java.lang.String getOriginalEndParagraphId() {
        return originalEndParagraphId;
    }


    /**
     * Sets the originalEndParagraphId value for this ListEditDTO.
     * 
     * @param originalEndParagraphId
     */
    public void setOriginalEndParagraphId(java.lang.String originalEndParagraphId) {
        this.originalEndParagraphId = originalEndParagraphId;
    }


    /**
     * Gets the zoneType value for this ListEditDTO.
     * 
     * @return zoneType
     */
    public java.lang.String getZoneType() {
        return zoneType;
    }


    /**
     * Sets the zoneType value for this ListEditDTO.
     * 
     * @param zoneType
     */
    public void setZoneType(java.lang.String zoneType) {
        this.zoneType = zoneType;
    }


    /**
     * Gets the updateDate value for this ListEditDTO.
     * 
     * @return updateDate
     */
    public java.util.Calendar getUpdateDate() {
        return updateDate;
    }


    /**
     * Sets the updateDate value for this ListEditDTO.
     * 
     * @param updateDate
     */
    public void setUpdateDate(java.util.Calendar updateDate) {
        this.updateDate = updateDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListEditDTO)) return false;
        ListEditDTO other = (ListEditDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            this.excludeObjectId == other.getExcludeObjectId() &&
            this.reviewId == other.getReviewId() &&
            this.documentId == other.getDocumentId() &&
            this.subjectId == other.getSubjectId() &&
            this.includeSubjectDto == other.isIncludeSubjectDto() &&
            ((this.startParagraphId==null && other.getStartParagraphId()==null) || 
             (this.startParagraphId!=null &&
              this.startParagraphId.equals(other.getStartParagraphId()))) &&
            ((this.endParagraphId==null && other.getEndParagraphId()==null) || 
             (this.endParagraphId!=null &&
              this.endParagraphId.equals(other.getEndParagraphId()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            this.notIncludeCompletedEdit == other.isNotIncludeCompletedEdit() &&
            ((this.originalEndParagraphId==null && other.getOriginalEndParagraphId()==null) || 
             (this.originalEndParagraphId!=null &&
              this.originalEndParagraphId.equals(other.getOriginalEndParagraphId()))) &&
            ((this.zoneType==null && other.getZoneType()==null) || 
             (this.zoneType!=null &&
              this.zoneType.equals(other.getZoneType()))) &&
            ((this.updateDate==null && other.getUpdateDate()==null) || 
             (this.updateDate!=null &&
              this.updateDate.equals(other.getUpdateDate())));
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
        _hashCode += getExcludeObjectId();
        _hashCode += getReviewId();
        _hashCode += getDocumentId();
        _hashCode += getSubjectId();
        _hashCode += (isIncludeSubjectDto() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getStartParagraphId() != null) {
            _hashCode += getStartParagraphId().hashCode();
        }
        if (getEndParagraphId() != null) {
            _hashCode += getEndParagraphId().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        _hashCode += (isNotIncludeCompletedEdit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getOriginalEndParagraphId() != null) {
            _hashCode += getOriginalEndParagraphId().hashCode();
        }
        if (getZoneType() != null) {
            _hashCode += getZoneType().hashCode();
        }
        if (getUpdateDate() != null) {
            _hashCode += getUpdateDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListEditDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListEditDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excludeObjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ExcludeObjectId"));
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
        elemField.setFieldName("documentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentId"));
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
        elemField.setFieldName("includeSubjectDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IncludeSubjectDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startParagraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "StartParagraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endParagraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EndParagraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("notIncludeCompletedEdit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "NotIncludeCompletedEdit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalEndParagraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OriginalEndParagraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zoneType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ZoneType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UpdateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
