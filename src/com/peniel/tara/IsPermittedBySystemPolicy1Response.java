/**
 * IsPermittedBySystemPolicy1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class IsPermittedBySystemPolicy1Response  implements java.io.Serializable {
    private boolean isPermittedBySystemPolicy1Result;

    public IsPermittedBySystemPolicy1Response() {
    }

    public IsPermittedBySystemPolicy1Response(
           boolean isPermittedBySystemPolicy1Result) {
           this.isPermittedBySystemPolicy1Result = isPermittedBySystemPolicy1Result;
    }


    /**
     * Gets the isPermittedBySystemPolicy1Result value for this IsPermittedBySystemPolicy1Response.
     * 
     * @return isPermittedBySystemPolicy1Result
     */
    public boolean isIsPermittedBySystemPolicy1Result() {
        return isPermittedBySystemPolicy1Result;
    }


    /**
     * Sets the isPermittedBySystemPolicy1Result value for this IsPermittedBySystemPolicy1Response.
     * 
     * @param isPermittedBySystemPolicy1Result
     */
    public void setIsPermittedBySystemPolicy1Result(boolean isPermittedBySystemPolicy1Result) {
        this.isPermittedBySystemPolicy1Result = isPermittedBySystemPolicy1Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IsPermittedBySystemPolicy1Response)) return false;
        IsPermittedBySystemPolicy1Response other = (IsPermittedBySystemPolicy1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.isPermittedBySystemPolicy1Result == other.isIsPermittedBySystemPolicy1Result();
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
        _hashCode += (isIsPermittedBySystemPolicy1Result() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IsPermittedBySystemPolicy1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">IsPermittedBySystemPolicy1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPermittedBySystemPolicy1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsPermittedBySystemPolicy1Result"));
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
