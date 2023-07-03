/**
 * GetSystemConnectorDTOResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetSystemConnectorDTOResponse  implements java.io.Serializable {
    private com.peniel.tara.SystemConnectorDTO getSystemConnectorDTOResult;

    public GetSystemConnectorDTOResponse() {
    }

    public GetSystemConnectorDTOResponse(
           com.peniel.tara.SystemConnectorDTO getSystemConnectorDTOResult) {
           this.getSystemConnectorDTOResult = getSystemConnectorDTOResult;
    }


    /**
     * Gets the getSystemConnectorDTOResult value for this GetSystemConnectorDTOResponse.
     * 
     * @return getSystemConnectorDTOResult
     */
    public com.peniel.tara.SystemConnectorDTO getGetSystemConnectorDTOResult() {
        return getSystemConnectorDTOResult;
    }


    /**
     * Sets the getSystemConnectorDTOResult value for this GetSystemConnectorDTOResponse.
     * 
     * @param getSystemConnectorDTOResult
     */
    public void setGetSystemConnectorDTOResult(com.peniel.tara.SystemConnectorDTO getSystemConnectorDTOResult) {
        this.getSystemConnectorDTOResult = getSystemConnectorDTOResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSystemConnectorDTOResponse)) return false;
        GetSystemConnectorDTOResponse other = (GetSystemConnectorDTOResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSystemConnectorDTOResult==null && other.getGetSystemConnectorDTOResult()==null) || 
             (this.getSystemConnectorDTOResult!=null &&
              this.getSystemConnectorDTOResult.equals(other.getGetSystemConnectorDTOResult())));
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
        if (getGetSystemConnectorDTOResult() != null) {
            _hashCode += getGetSystemConnectorDTOResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSystemConnectorDTOResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetSystemConnectorDTOResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSystemConnectorDTOResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetSystemConnectorDTOResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SystemConnectorDTO"));
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
