/**
 * PrettyPrintExtSourceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class PrettyPrintExtSourceResponse  implements java.io.Serializable {
    private java.lang.String prettyPrintExtSourceResult;

    public PrettyPrintExtSourceResponse() {
    }

    public PrettyPrintExtSourceResponse(
           java.lang.String prettyPrintExtSourceResult) {
           this.prettyPrintExtSourceResult = prettyPrintExtSourceResult;
    }


    /**
     * Gets the prettyPrintExtSourceResult value for this PrettyPrintExtSourceResponse.
     * 
     * @return prettyPrintExtSourceResult
     */
    public java.lang.String getPrettyPrintExtSourceResult() {
        return prettyPrintExtSourceResult;
    }


    /**
     * Sets the prettyPrintExtSourceResult value for this PrettyPrintExtSourceResponse.
     * 
     * @param prettyPrintExtSourceResult
     */
    public void setPrettyPrintExtSourceResult(java.lang.String prettyPrintExtSourceResult) {
        this.prettyPrintExtSourceResult = prettyPrintExtSourceResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrettyPrintExtSourceResponse)) return false;
        PrettyPrintExtSourceResponse other = (PrettyPrintExtSourceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.prettyPrintExtSourceResult==null && other.getPrettyPrintExtSourceResult()==null) || 
             (this.prettyPrintExtSourceResult!=null &&
              this.prettyPrintExtSourceResult.equals(other.getPrettyPrintExtSourceResult())));
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
        if (getPrettyPrintExtSourceResult() != null) {
            _hashCode += getPrettyPrintExtSourceResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrettyPrintExtSourceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">PrettyPrintExtSourceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prettyPrintExtSourceResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "PrettyPrintExtSourceResult"));
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
