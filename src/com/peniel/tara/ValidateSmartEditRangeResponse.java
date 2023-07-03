/**
 * ValidateSmartEditRangeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ValidateSmartEditRangeResponse  implements java.io.Serializable {
    private boolean validateSmartEditRangeResult;

    public ValidateSmartEditRangeResponse() {
    }

    public ValidateSmartEditRangeResponse(
           boolean validateSmartEditRangeResult) {
           this.validateSmartEditRangeResult = validateSmartEditRangeResult;
    }


    /**
     * Gets the validateSmartEditRangeResult value for this ValidateSmartEditRangeResponse.
     * 
     * @return validateSmartEditRangeResult
     */
    public boolean isValidateSmartEditRangeResult() {
        return validateSmartEditRangeResult;
    }


    /**
     * Sets the validateSmartEditRangeResult value for this ValidateSmartEditRangeResponse.
     * 
     * @param validateSmartEditRangeResult
     */
    public void setValidateSmartEditRangeResult(boolean validateSmartEditRangeResult) {
        this.validateSmartEditRangeResult = validateSmartEditRangeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ValidateSmartEditRangeResponse)) return false;
        ValidateSmartEditRangeResponse other = (ValidateSmartEditRangeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.validateSmartEditRangeResult == other.isValidateSmartEditRangeResult();
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
        _hashCode += (isValidateSmartEditRangeResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ValidateSmartEditRangeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ValidateSmartEditRangeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validateSmartEditRangeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ValidateSmartEditRangeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
