/**
 * GetSystemPolicyItemResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetSystemPolicyItemResponse  implements java.io.Serializable {
    private com.peniel.tara.SystemPolicyDTO getSystemPolicyItemResult;

    public GetSystemPolicyItemResponse() {
    }

    public GetSystemPolicyItemResponse(
           com.peniel.tara.SystemPolicyDTO getSystemPolicyItemResult) {
           this.getSystemPolicyItemResult = getSystemPolicyItemResult;
    }


    /**
     * Gets the getSystemPolicyItemResult value for this GetSystemPolicyItemResponse.
     * 
     * @return getSystemPolicyItemResult
     */
    public com.peniel.tara.SystemPolicyDTO getGetSystemPolicyItemResult() {
        return getSystemPolicyItemResult;
    }


    /**
     * Sets the getSystemPolicyItemResult value for this GetSystemPolicyItemResponse.
     * 
     * @param getSystemPolicyItemResult
     */
    public void setGetSystemPolicyItemResult(com.peniel.tara.SystemPolicyDTO getSystemPolicyItemResult) {
        this.getSystemPolicyItemResult = getSystemPolicyItemResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSystemPolicyItemResponse)) return false;
        GetSystemPolicyItemResponse other = (GetSystemPolicyItemResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSystemPolicyItemResult==null && other.getGetSystemPolicyItemResult()==null) || 
             (this.getSystemPolicyItemResult!=null &&
              this.getSystemPolicyItemResult.equals(other.getGetSystemPolicyItemResult())));
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
        if (getGetSystemPolicyItemResult() != null) {
            _hashCode += getGetSystemPolicyItemResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSystemPolicyItemResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetSystemPolicyItemResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSystemPolicyItemResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetSystemPolicyItemResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SystemPolicyDTO"));
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
