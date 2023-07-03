/**
 * GetImageFromDocumentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetImageFromDocumentResponse  implements java.io.Serializable {
    private com.peniel.tara.FileContentDTO getImageFromDocumentResult;

    public GetImageFromDocumentResponse() {
    }

    public GetImageFromDocumentResponse(
           com.peniel.tara.FileContentDTO getImageFromDocumentResult) {
           this.getImageFromDocumentResult = getImageFromDocumentResult;
    }


    /**
     * Gets the getImageFromDocumentResult value for this GetImageFromDocumentResponse.
     * 
     * @return getImageFromDocumentResult
     */
    public com.peniel.tara.FileContentDTO getGetImageFromDocumentResult() {
        return getImageFromDocumentResult;
    }


    /**
     * Sets the getImageFromDocumentResult value for this GetImageFromDocumentResponse.
     * 
     * @param getImageFromDocumentResult
     */
    public void setGetImageFromDocumentResult(com.peniel.tara.FileContentDTO getImageFromDocumentResult) {
        this.getImageFromDocumentResult = getImageFromDocumentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetImageFromDocumentResponse)) return false;
        GetImageFromDocumentResponse other = (GetImageFromDocumentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getImageFromDocumentResult==null && other.getGetImageFromDocumentResult()==null) || 
             (this.getImageFromDocumentResult!=null &&
              this.getImageFromDocumentResult.equals(other.getGetImageFromDocumentResult())));
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
        if (getGetImageFromDocumentResult() != null) {
            _hashCode += getGetImageFromDocumentResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetImageFromDocumentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetImageFromDocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getImageFromDocumentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetImageFromDocumentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileContentDTO"));
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
