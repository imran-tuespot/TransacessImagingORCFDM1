/**
 * SendParagraphEmail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SendParagraphEmail  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int reviewId;

    private int documentId;

    private java.lang.String paragraphId;

    private int[] subjectIds;

    private java.lang.String subjectLine;

    private java.lang.String textblock;

    public SendParagraphEmail() {
    }

    public SendParagraphEmail(
           java.lang.String loginContextId,
           int reviewId,
           int documentId,
           java.lang.String paragraphId,
           int[] subjectIds,
           java.lang.String subjectLine,
           java.lang.String textblock) {
           this.loginContextId = loginContextId;
           this.reviewId = reviewId;
           this.documentId = documentId;
           this.paragraphId = paragraphId;
           this.subjectIds = subjectIds;
           this.subjectLine = subjectLine;
           this.textblock = textblock;
    }


    /**
     * Gets the loginContextId value for this SendParagraphEmail.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this SendParagraphEmail.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the reviewId value for this SendParagraphEmail.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this SendParagraphEmail.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the documentId value for this SendParagraphEmail.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this SendParagraphEmail.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the paragraphId value for this SendParagraphEmail.
     * 
     * @return paragraphId
     */
    public java.lang.String getParagraphId() {
        return paragraphId;
    }


    /**
     * Sets the paragraphId value for this SendParagraphEmail.
     * 
     * @param paragraphId
     */
    public void setParagraphId(java.lang.String paragraphId) {
        this.paragraphId = paragraphId;
    }


    /**
     * Gets the subjectIds value for this SendParagraphEmail.
     * 
     * @return subjectIds
     */
    public int[] getSubjectIds() {
        return subjectIds;
    }


    /**
     * Sets the subjectIds value for this SendParagraphEmail.
     * 
     * @param subjectIds
     */
    public void setSubjectIds(int[] subjectIds) {
        this.subjectIds = subjectIds;
    }


    /**
     * Gets the subjectLine value for this SendParagraphEmail.
     * 
     * @return subjectLine
     */
    public java.lang.String getSubjectLine() {
        return subjectLine;
    }


    /**
     * Sets the subjectLine value for this SendParagraphEmail.
     * 
     * @param subjectLine
     */
    public void setSubjectLine(java.lang.String subjectLine) {
        this.subjectLine = subjectLine;
    }


    /**
     * Gets the textblock value for this SendParagraphEmail.
     * 
     * @return textblock
     */
    public java.lang.String getTextblock() {
        return textblock;
    }


    /**
     * Sets the textblock value for this SendParagraphEmail.
     * 
     * @param textblock
     */
    public void setTextblock(java.lang.String textblock) {
        this.textblock = textblock;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendParagraphEmail)) return false;
        SendParagraphEmail other = (SendParagraphEmail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.loginContextId==null && other.getLoginContextId()==null) || 
             (this.loginContextId!=null &&
              this.loginContextId.equals(other.getLoginContextId()))) &&
            this.reviewId == other.getReviewId() &&
            this.documentId == other.getDocumentId() &&
            ((this.paragraphId==null && other.getParagraphId()==null) || 
             (this.paragraphId!=null &&
              this.paragraphId.equals(other.getParagraphId()))) &&
            ((this.subjectIds==null && other.getSubjectIds()==null) || 
             (this.subjectIds!=null &&
              java.util.Arrays.equals(this.subjectIds, other.getSubjectIds()))) &&
            ((this.subjectLine==null && other.getSubjectLine()==null) || 
             (this.subjectLine!=null &&
              this.subjectLine.equals(other.getSubjectLine()))) &&
            ((this.textblock==null && other.getTextblock()==null) || 
             (this.textblock!=null &&
              this.textblock.equals(other.getTextblock())));
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
        if (getLoginContextId() != null) {
            _hashCode += getLoginContextId().hashCode();
        }
        _hashCode += getReviewId();
        _hashCode += getDocumentId();
        if (getParagraphId() != null) {
            _hashCode += getParagraphId().hashCode();
        }
        if (getSubjectIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubjectIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubjectIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSubjectLine() != null) {
            _hashCode += getSubjectLine().hashCode();
        }
        if (getTextblock() != null) {
            _hashCode += getTextblock().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendParagraphEmail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">SendParagraphEmail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "reviewId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "documentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paragraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "paragraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectLine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectLine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textblock");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "textblock"));
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
