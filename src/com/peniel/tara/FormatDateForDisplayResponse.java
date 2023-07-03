/**
 * FormatDateForDisplayResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class FormatDateForDisplayResponse  implements java.io.Serializable {
    private java.lang.String formatDateForDisplayResult;

    public FormatDateForDisplayResponse() {
    }

    public FormatDateForDisplayResponse(
           java.lang.String formatDateForDisplayResult) {
           this.formatDateForDisplayResult = formatDateForDisplayResult;
    }


    /**
     * Gets the formatDateForDisplayResult value for this FormatDateForDisplayResponse.
     * 
     * @return formatDateForDisplayResult
     */
    public java.lang.String getFormatDateForDisplayResult() {
        return formatDateForDisplayResult;
    }


    /**
     * Sets the formatDateForDisplayResult value for this FormatDateForDisplayResponse.
     * 
     * @param formatDateForDisplayResult
     */
    public void setFormatDateForDisplayResult(java.lang.String formatDateForDisplayResult) {
        this.formatDateForDisplayResult = formatDateForDisplayResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FormatDateForDisplayResponse)) return false;
        FormatDateForDisplayResponse other = (FormatDateForDisplayResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.formatDateForDisplayResult==null && other.getFormatDateForDisplayResult()==null) || 
             (this.formatDateForDisplayResult!=null &&
              this.formatDateForDisplayResult.equals(other.getFormatDateForDisplayResult())));
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
        if (getFormatDateForDisplayResult() != null) {
            _hashCode += getFormatDateForDisplayResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FormatDateForDisplayResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">FormatDateForDisplayResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formatDateForDisplayResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FormatDateForDisplayResult"));
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
