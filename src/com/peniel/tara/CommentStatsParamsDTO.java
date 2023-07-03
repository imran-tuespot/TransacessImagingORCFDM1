/**
 * CommentStatsParamsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class CommentStatsParamsDTO  implements java.io.Serializable {
    private com.peniel.tara.ListCommentParamsDTO listCommentParamsDTO;

    private boolean groupByReviewId;

    private boolean groupByDocumentId;

    private boolean groupByParagraphId;

    private boolean groupByStatus;

    private boolean groupBySubjectId;

    private boolean groupByCommentType;

    public CommentStatsParamsDTO() {
    }

    public CommentStatsParamsDTO(
           com.peniel.tara.ListCommentParamsDTO listCommentParamsDTO,
           boolean groupByReviewId,
           boolean groupByDocumentId,
           boolean groupByParagraphId,
           boolean groupByStatus,
           boolean groupBySubjectId,
           boolean groupByCommentType) {
           this.listCommentParamsDTO = listCommentParamsDTO;
           this.groupByReviewId = groupByReviewId;
           this.groupByDocumentId = groupByDocumentId;
           this.groupByParagraphId = groupByParagraphId;
           this.groupByStatus = groupByStatus;
           this.groupBySubjectId = groupBySubjectId;
           this.groupByCommentType = groupByCommentType;
    }


    /**
     * Gets the listCommentParamsDTO value for this CommentStatsParamsDTO.
     * 
     * @return listCommentParamsDTO
     */
    public com.peniel.tara.ListCommentParamsDTO getListCommentParamsDTO() {
        return listCommentParamsDTO;
    }


    /**
     * Sets the listCommentParamsDTO value for this CommentStatsParamsDTO.
     * 
     * @param listCommentParamsDTO
     */
    public void setListCommentParamsDTO(com.peniel.tara.ListCommentParamsDTO listCommentParamsDTO) {
        this.listCommentParamsDTO = listCommentParamsDTO;
    }


    /**
     * Gets the groupByReviewId value for this CommentStatsParamsDTO.
     * 
     * @return groupByReviewId
     */
    public boolean isGroupByReviewId() {
        return groupByReviewId;
    }


    /**
     * Sets the groupByReviewId value for this CommentStatsParamsDTO.
     * 
     * @param groupByReviewId
     */
    public void setGroupByReviewId(boolean groupByReviewId) {
        this.groupByReviewId = groupByReviewId;
    }


    /**
     * Gets the groupByDocumentId value for this CommentStatsParamsDTO.
     * 
     * @return groupByDocumentId
     */
    public boolean isGroupByDocumentId() {
        return groupByDocumentId;
    }


    /**
     * Sets the groupByDocumentId value for this CommentStatsParamsDTO.
     * 
     * @param groupByDocumentId
     */
    public void setGroupByDocumentId(boolean groupByDocumentId) {
        this.groupByDocumentId = groupByDocumentId;
    }


    /**
     * Gets the groupByParagraphId value for this CommentStatsParamsDTO.
     * 
     * @return groupByParagraphId
     */
    public boolean isGroupByParagraphId() {
        return groupByParagraphId;
    }


    /**
     * Sets the groupByParagraphId value for this CommentStatsParamsDTO.
     * 
     * @param groupByParagraphId
     */
    public void setGroupByParagraphId(boolean groupByParagraphId) {
        this.groupByParagraphId = groupByParagraphId;
    }


    /**
     * Gets the groupByStatus value for this CommentStatsParamsDTO.
     * 
     * @return groupByStatus
     */
    public boolean isGroupByStatus() {
        return groupByStatus;
    }


    /**
     * Sets the groupByStatus value for this CommentStatsParamsDTO.
     * 
     * @param groupByStatus
     */
    public void setGroupByStatus(boolean groupByStatus) {
        this.groupByStatus = groupByStatus;
    }


    /**
     * Gets the groupBySubjectId value for this CommentStatsParamsDTO.
     * 
     * @return groupBySubjectId
     */
    public boolean isGroupBySubjectId() {
        return groupBySubjectId;
    }


    /**
     * Sets the groupBySubjectId value for this CommentStatsParamsDTO.
     * 
     * @param groupBySubjectId
     */
    public void setGroupBySubjectId(boolean groupBySubjectId) {
        this.groupBySubjectId = groupBySubjectId;
    }


    /**
     * Gets the groupByCommentType value for this CommentStatsParamsDTO.
     * 
     * @return groupByCommentType
     */
    public boolean isGroupByCommentType() {
        return groupByCommentType;
    }


    /**
     * Sets the groupByCommentType value for this CommentStatsParamsDTO.
     * 
     * @param groupByCommentType
     */
    public void setGroupByCommentType(boolean groupByCommentType) {
        this.groupByCommentType = groupByCommentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommentStatsParamsDTO)) return false;
        CommentStatsParamsDTO other = (CommentStatsParamsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listCommentParamsDTO==null && other.getListCommentParamsDTO()==null) || 
             (this.listCommentParamsDTO!=null &&
              this.listCommentParamsDTO.equals(other.getListCommentParamsDTO()))) &&
            this.groupByReviewId == other.isGroupByReviewId() &&
            this.groupByDocumentId == other.isGroupByDocumentId() &&
            this.groupByParagraphId == other.isGroupByParagraphId() &&
            this.groupByStatus == other.isGroupByStatus() &&
            this.groupBySubjectId == other.isGroupBySubjectId() &&
            this.groupByCommentType == other.isGroupByCommentType();
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
        if (getListCommentParamsDTO() != null) {
            _hashCode += getListCommentParamsDTO().hashCode();
        }
        _hashCode += (isGroupByReviewId() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isGroupByDocumentId() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isGroupByParagraphId() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isGroupByStatus() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isGroupBySubjectId() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isGroupByCommentType() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommentStatsParamsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentStatsParamsDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listCommentParamsDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListCommentParamsDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListCommentParamsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupByReviewId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GroupByReviewId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupByDocumentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GroupByDocumentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupByParagraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GroupByParagraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupByStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GroupByStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupBySubjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GroupBySubjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupByCommentType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GroupByCommentType"));
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
