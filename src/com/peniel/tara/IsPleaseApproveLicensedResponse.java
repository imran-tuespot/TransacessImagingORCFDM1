/**
 * IsPleaseApproveLicensedResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class IsPleaseApproveLicensedResponse  implements java.io.Serializable {
    private boolean isPleaseApproveLicensedResult;

    public IsPleaseApproveLicensedResponse() {
    }

    public IsPleaseApproveLicensedResponse(
           boolean isPleaseApproveLicensedResult) {
           this.isPleaseApproveLicensedResult = isPleaseApproveLicensedResult;
    }


    /**
     * Gets the isPleaseApproveLicensedResult value for this IsPleaseApproveLicensedResponse.
     * 
     * @return isPleaseApproveLicensedResult
     */
    public boolean isIsPleaseApproveLicensedResult() {
        return isPleaseApproveLicensedResult;
    }


    /**
     * Sets the isPleaseApproveLicensedResult value for this IsPleaseApproveLicensedResponse.
     * 
     * @param isPleaseApproveLicensedResult
     */
    public void setIsPleaseApproveLicensedResult(boolean isPleaseApproveLicensedResult) {
        this.isPleaseApproveLicensedResult = isPleaseApproveLicensedResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IsPleaseApproveLicensedResponse)) return false;
        IsPleaseApproveLicensedResponse other = (IsPleaseApproveLicensedResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.isPleaseApproveLicensedResult == other.isIsPleaseApproveLicensedResult();
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
        _hashCode += (isIsPleaseApproveLicensedResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IsPleaseApproveLicensedResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">IsPleaseApproveLicensedResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPleaseApproveLicensedResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsPleaseApproveLicensedResult"));
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
