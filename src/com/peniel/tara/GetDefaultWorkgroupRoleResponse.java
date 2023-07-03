/**
 * GetDefaultWorkgroupRoleResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetDefaultWorkgroupRoleResponse  implements java.io.Serializable {
    private java.lang.String getDefaultWorkgroupRoleResult;

    public GetDefaultWorkgroupRoleResponse() {
    }

    public GetDefaultWorkgroupRoleResponse(
           java.lang.String getDefaultWorkgroupRoleResult) {
           this.getDefaultWorkgroupRoleResult = getDefaultWorkgroupRoleResult;
    }


    /**
     * Gets the getDefaultWorkgroupRoleResult value for this GetDefaultWorkgroupRoleResponse.
     * 
     * @return getDefaultWorkgroupRoleResult
     */
    public java.lang.String getGetDefaultWorkgroupRoleResult() {
        return getDefaultWorkgroupRoleResult;
    }


    /**
     * Sets the getDefaultWorkgroupRoleResult value for this GetDefaultWorkgroupRoleResponse.
     * 
     * @param getDefaultWorkgroupRoleResult
     */
    public void setGetDefaultWorkgroupRoleResult(java.lang.String getDefaultWorkgroupRoleResult) {
        this.getDefaultWorkgroupRoleResult = getDefaultWorkgroupRoleResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDefaultWorkgroupRoleResponse)) return false;
        GetDefaultWorkgroupRoleResponse other = (GetDefaultWorkgroupRoleResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDefaultWorkgroupRoleResult==null && other.getGetDefaultWorkgroupRoleResult()==null) || 
             (this.getDefaultWorkgroupRoleResult!=null &&
              this.getDefaultWorkgroupRoleResult.equals(other.getGetDefaultWorkgroupRoleResult())));
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
        if (getGetDefaultWorkgroupRoleResult() != null) {
            _hashCode += getGetDefaultWorkgroupRoleResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDefaultWorkgroupRoleResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetDefaultWorkgroupRoleResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDefaultWorkgroupRoleResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetDefaultWorkgroupRoleResult"));
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
