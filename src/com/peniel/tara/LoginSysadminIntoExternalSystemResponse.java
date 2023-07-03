/**
 * LoginSysadminIntoExternalSystemResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class LoginSysadminIntoExternalSystemResponse  implements java.io.Serializable {
    private java.lang.Object loginSysadminIntoExternalSystemResult;

    public LoginSysadminIntoExternalSystemResponse() {
    }

    public LoginSysadminIntoExternalSystemResponse(
           java.lang.Object loginSysadminIntoExternalSystemResult) {
           this.loginSysadminIntoExternalSystemResult = loginSysadminIntoExternalSystemResult;
    }


    /**
     * Gets the loginSysadminIntoExternalSystemResult value for this LoginSysadminIntoExternalSystemResponse.
     * 
     * @return loginSysadminIntoExternalSystemResult
     */
    public java.lang.Object getLoginSysadminIntoExternalSystemResult() {
        return loginSysadminIntoExternalSystemResult;
    }


    /**
     * Sets the loginSysadminIntoExternalSystemResult value for this LoginSysadminIntoExternalSystemResponse.
     * 
     * @param loginSysadminIntoExternalSystemResult
     */
    public void setLoginSysadminIntoExternalSystemResult(java.lang.Object loginSysadminIntoExternalSystemResult) {
        this.loginSysadminIntoExternalSystemResult = loginSysadminIntoExternalSystemResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoginSysadminIntoExternalSystemResponse)) return false;
        LoginSysadminIntoExternalSystemResponse other = (LoginSysadminIntoExternalSystemResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.loginSysadminIntoExternalSystemResult==null && other.getLoginSysadminIntoExternalSystemResult()==null) || 
             (this.loginSysadminIntoExternalSystemResult!=null &&
              this.loginSysadminIntoExternalSystemResult.equals(other.getLoginSysadminIntoExternalSystemResult())));
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
        if (getLoginSysadminIntoExternalSystemResult() != null) {
            _hashCode += getLoginSysadminIntoExternalSystemResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoginSysadminIntoExternalSystemResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">LoginSysadminIntoExternalSystemResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginSysadminIntoExternalSystemResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LoginSysadminIntoExternalSystemResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
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
