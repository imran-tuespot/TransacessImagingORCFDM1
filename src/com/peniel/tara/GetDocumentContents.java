/**
 * GetDocumentContents.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetDocumentContents  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.DocMarkUpParamsDTO docMarkUpParamsDTO;

    public GetDocumentContents() {
    }

    public GetDocumentContents(
           java.lang.String loginContextId,
           com.peniel.tara.DocMarkUpParamsDTO docMarkUpParamsDTO) {
           this.loginContextId = loginContextId;
           this.docMarkUpParamsDTO = docMarkUpParamsDTO;
    }


    /**
     * Gets the loginContextId value for this GetDocumentContents.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetDocumentContents.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the docMarkUpParamsDTO value for this GetDocumentContents.
     * 
     * @return docMarkUpParamsDTO
     */
    public com.peniel.tara.DocMarkUpParamsDTO getDocMarkUpParamsDTO() {
        return docMarkUpParamsDTO;
    }


    /**
     * Sets the docMarkUpParamsDTO value for this GetDocumentContents.
     * 
     * @param docMarkUpParamsDTO
     */
    public void setDocMarkUpParamsDTO(com.peniel.tara.DocMarkUpParamsDTO docMarkUpParamsDTO) {
        this.docMarkUpParamsDTO = docMarkUpParamsDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDocumentContents)) return false;
        GetDocumentContents other = (GetDocumentContents) obj;
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
            ((this.docMarkUpParamsDTO==null && other.getDocMarkUpParamsDTO()==null) || 
             (this.docMarkUpParamsDTO!=null &&
              this.docMarkUpParamsDTO.equals(other.getDocMarkUpParamsDTO())));
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
        if (getDocMarkUpParamsDTO() != null) {
            _hashCode += getDocMarkUpParamsDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDocumentContents.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetDocumentContents"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docMarkUpParamsDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "docMarkUpParamsDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocMarkUpParamsDTO"));
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
