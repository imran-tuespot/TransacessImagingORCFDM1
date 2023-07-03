/**
 * GetDefaultExtSourceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetDefaultExtSourceResponse  implements java.io.Serializable {
    private java.lang.String getDefaultExtSourceResult;

    public GetDefaultExtSourceResponse() {
    }

    public GetDefaultExtSourceResponse(
           java.lang.String getDefaultExtSourceResult) {
           this.getDefaultExtSourceResult = getDefaultExtSourceResult;
    }


    /**
     * Gets the getDefaultExtSourceResult value for this GetDefaultExtSourceResponse.
     * 
     * @return getDefaultExtSourceResult
     */
    public java.lang.String getGetDefaultExtSourceResult() {
        return getDefaultExtSourceResult;
    }


    /**
     * Sets the getDefaultExtSourceResult value for this GetDefaultExtSourceResponse.
     * 
     * @param getDefaultExtSourceResult
     */
    public void setGetDefaultExtSourceResult(java.lang.String getDefaultExtSourceResult) {
        this.getDefaultExtSourceResult = getDefaultExtSourceResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDefaultExtSourceResponse)) return false;
        GetDefaultExtSourceResponse other = (GetDefaultExtSourceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDefaultExtSourceResult==null && other.getGetDefaultExtSourceResult()==null) || 
             (this.getDefaultExtSourceResult!=null &&
              this.getDefaultExtSourceResult.equals(other.getGetDefaultExtSourceResult())));
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
        if (getGetDefaultExtSourceResult() != null) {
            _hashCode += getGetDefaultExtSourceResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDefaultExtSourceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetDefaultExtSourceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDefaultExtSourceResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetDefaultExtSourceResult"));
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
