/**
 * CheckAdminEmailStatusResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class CheckAdminEmailStatusResponse  implements java.io.Serializable {
    private java.lang.String checkAdminEmailStatusResult;

    public CheckAdminEmailStatusResponse() {
    }

    public CheckAdminEmailStatusResponse(
           java.lang.String checkAdminEmailStatusResult) {
           this.checkAdminEmailStatusResult = checkAdminEmailStatusResult;
    }


    /**
     * Gets the checkAdminEmailStatusResult value for this CheckAdminEmailStatusResponse.
     * 
     * @return checkAdminEmailStatusResult
     */
    public java.lang.String getCheckAdminEmailStatusResult() {
        return checkAdminEmailStatusResult;
    }


    /**
     * Sets the checkAdminEmailStatusResult value for this CheckAdminEmailStatusResponse.
     * 
     * @param checkAdminEmailStatusResult
     */
    public void setCheckAdminEmailStatusResult(java.lang.String checkAdminEmailStatusResult) {
        this.checkAdminEmailStatusResult = checkAdminEmailStatusResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckAdminEmailStatusResponse)) return false;
        CheckAdminEmailStatusResponse other = (CheckAdminEmailStatusResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.checkAdminEmailStatusResult==null && other.getCheckAdminEmailStatusResult()==null) || 
             (this.checkAdminEmailStatusResult!=null &&
              this.checkAdminEmailStatusResult.equals(other.getCheckAdminEmailStatusResult())));
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
        if (getCheckAdminEmailStatusResult() != null) {
            _hashCode += getCheckAdminEmailStatusResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CheckAdminEmailStatusResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">CheckAdminEmailStatusResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkAdminEmailStatusResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CheckAdminEmailStatusResult"));
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
