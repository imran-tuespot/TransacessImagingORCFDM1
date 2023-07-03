/**
 * ReviewDocumentDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ReviewDocumentDTO  implements java.io.Serializable {
    private int objectId;

    private int reviewId;

    private com.peniel.tara.ReviewDTO reviewDTO;

    private int documentId;

    private com.peniel.tara.DocumentDTO documentDTO;

    private boolean referenceOnly;

    public ReviewDocumentDTO() {
    }

    public ReviewDocumentDTO(
           int objectId,
           int reviewId,
           com.peniel.tara.ReviewDTO reviewDTO,
           int documentId,
           com.peniel.tara.DocumentDTO documentDTO,
           boolean referenceOnly) {
           this.objectId = objectId;
           this.reviewId = reviewId;
           this.reviewDTO = reviewDTO;
           this.documentId = documentId;
           this.documentDTO = documentDTO;
           this.referenceOnly = referenceOnly;
    }


    /**
     * Gets the objectId value for this ReviewDocumentDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this ReviewDocumentDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the reviewId value for this ReviewDocumentDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this ReviewDocumentDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the reviewDTO value for this ReviewDocumentDTO.
     * 
     * @return reviewDTO
     */
    public com.peniel.tara.ReviewDTO getReviewDTO() {
        return reviewDTO;
    }


    /**
     * Sets the reviewDTO value for this ReviewDocumentDTO.
     * 
     * @param reviewDTO
     */
    public void setReviewDTO(com.peniel.tara.ReviewDTO reviewDTO) {
        this.reviewDTO = reviewDTO;
    }


    /**
     * Gets the documentId value for this ReviewDocumentDTO.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this ReviewDocumentDTO.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the documentDTO value for this ReviewDocumentDTO.
     * 
     * @return documentDTO
     */
    public com.peniel.tara.DocumentDTO getDocumentDTO() {
        return documentDTO;
    }


    /**
     * Sets the documentDTO value for this ReviewDocumentDTO.
     * 
     * @param documentDTO
     */
    public void setDocumentDTO(com.peniel.tara.DocumentDTO documentDTO) {
        this.documentDTO = documentDTO;
    }


    /**
     * Gets the referenceOnly value for this ReviewDocumentDTO.
     * 
     * @return referenceOnly
     */
    public boolean isReferenceOnly() {
        return referenceOnly;
    }


    /**
     * Sets the referenceOnly value for this ReviewDocumentDTO.
     * 
     * @param referenceOnly
     */
    public void setReferenceOnly(boolean referenceOnly) {
        this.referenceOnly = referenceOnly;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReviewDocumentDTO)) return false;
        ReviewDocumentDTO other = (ReviewDocumentDTO) obj;
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
            ((this.reviewDTO==null && other.getReviewDTO()==null) || 
             (this.reviewDTO!=null &&
              this.reviewDTO.equals(other.getReviewDTO()))) &&
            this.documentId == other.getDocumentId() &&
            ((this.documentDTO==null && other.getDocumentDTO()==null) || 
             (this.documentDTO!=null &&
              this.documentDTO.equals(other.getDocumentDTO()))) &&
            this.referenceOnly == other.isReferenceOnly();
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
        if (getReviewDTO() != null) {
            _hashCode += getReviewDTO().hashCode();
        }
        _hashCode += getDocumentId();
        if (getDocumentDTO() != null) {
            _hashCode += getDocumentDTO().hashCode();
        }
        _hashCode += (isReferenceOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReviewDocumentDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDocumentDTO"));
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
        elemField.setFieldName("reviewDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenceOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReferenceOnly"));
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
