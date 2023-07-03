/**
 * GetDocumentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetDocumentResponse  implements java.io.Serializable {
    private com.peniel.tara.DocumentDTO getDocumentResult;

    public GetDocumentResponse() {
    }

    public GetDocumentResponse(
           com.peniel.tara.DocumentDTO getDocumentResult) {
           this.getDocumentResult = getDocumentResult;
    }


    /**
     * Gets the getDocumentResult value for this GetDocumentResponse.
     * 
     * @return getDocumentResult
     */
    public com.peniel.tara.DocumentDTO getGetDocumentResult() {
        return getDocumentResult;
    }


    /**
     * Sets the getDocumentResult value for this GetDocumentResponse.
     * 
     * @param getDocumentResult
     */
    public void setGetDocumentResult(com.peniel.tara.DocumentDTO getDocumentResult) {
        this.getDocumentResult = getDocumentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDocumentResponse)) return false;
        GetDocumentResponse other = (GetDocumentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDocumentResult==null && other.getGetDocumentResult()==null) || 
             (this.getDocumentResult!=null &&
              this.getDocumentResult.equals(other.getGetDocumentResult())));
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
        if (getGetDocumentResult() != null) {
            _hashCode += getGetDocumentResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDocumentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetDocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDocumentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetDocumentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentDTO"));
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
