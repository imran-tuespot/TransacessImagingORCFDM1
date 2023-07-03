/**
 * SaveDocument.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SaveDocument  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.DocumentDTO documentDto;

    private com.peniel.tara.ReviewDocumentDTO reviewDocumentDto;

    private com.peniel.tara.FileContentDTO[] fileContents;

    public SaveDocument() {
    }

    public SaveDocument(
           java.lang.String loginContextId,
           com.peniel.tara.DocumentDTO documentDto,
           com.peniel.tara.ReviewDocumentDTO reviewDocumentDto,
           com.peniel.tara.FileContentDTO[] fileContents) {
           this.loginContextId = loginContextId;
           this.documentDto = documentDto;
           this.reviewDocumentDto = reviewDocumentDto;
           this.fileContents = fileContents;
    }


    /**
     * Gets the loginContextId value for this SaveDocument.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this SaveDocument.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the documentDto value for this SaveDocument.
     * 
     * @return documentDto
     */
    public com.peniel.tara.DocumentDTO getDocumentDto() {
        return documentDto;
    }


    /**
     * Sets the documentDto value for this SaveDocument.
     * 
     * @param documentDto
     */
    public void setDocumentDto(com.peniel.tara.DocumentDTO documentDto) {
        this.documentDto = documentDto;
    }


    /**
     * Gets the reviewDocumentDto value for this SaveDocument.
     * 
     * @return reviewDocumentDto
     */
    public com.peniel.tara.ReviewDocumentDTO getReviewDocumentDto() {
        return reviewDocumentDto;
    }


    /**
     * Sets the reviewDocumentDto value for this SaveDocument.
     * 
     * @param reviewDocumentDto
     */
    public void setReviewDocumentDto(com.peniel.tara.ReviewDocumentDTO reviewDocumentDto) {
        this.reviewDocumentDto = reviewDocumentDto;
    }


    /**
     * Gets the fileContents value for this SaveDocument.
     * 
     * @return fileContents
     */
    public com.peniel.tara.FileContentDTO[] getFileContents() {
        return fileContents;
    }


    /**
     * Sets the fileContents value for this SaveDocument.
     * 
     * @param fileContents
     */
    public void setFileContents(com.peniel.tara.FileContentDTO[] fileContents) {
        this.fileContents = fileContents;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SaveDocument)) return false;
        SaveDocument other = (SaveDocument) obj;
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
            ((this.documentDto==null && other.getDocumentDto()==null) || 
             (this.documentDto!=null &&
              this.documentDto.equals(other.getDocumentDto()))) &&
            ((this.reviewDocumentDto==null && other.getReviewDocumentDto()==null) || 
             (this.reviewDocumentDto!=null &&
              this.reviewDocumentDto.equals(other.getReviewDocumentDto()))) &&
            ((this.fileContents==null && other.getFileContents()==null) || 
             (this.fileContents!=null &&
              java.util.Arrays.equals(this.fileContents, other.getFileContents())));
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
        if (getDocumentDto() != null) {
            _hashCode += getDocumentDto().hashCode();
        }
        if (getReviewDocumentDto() != null) {
            _hashCode += getReviewDocumentDto().hashCode();
        }
        if (getFileContents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFileContents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFileContents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SaveDocument.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">SaveDocument"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "documentDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewDocumentDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "reviewDocumentDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDocumentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileContents");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "fileContents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileContentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileContentDTO"));
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
