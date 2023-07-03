/**
 * TransformMarkUpText3Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class TransformMarkUpText3Response  implements java.io.Serializable {
    private java.lang.String transformMarkUpText3Result;

    public TransformMarkUpText3Response() {
    }

    public TransformMarkUpText3Response(
           java.lang.String transformMarkUpText3Result) {
           this.transformMarkUpText3Result = transformMarkUpText3Result;
    }


    /**
     * Gets the transformMarkUpText3Result value for this TransformMarkUpText3Response.
     * 
     * @return transformMarkUpText3Result
     */
    public java.lang.String getTransformMarkUpText3Result() {
        return transformMarkUpText3Result;
    }


    /**
     * Sets the transformMarkUpText3Result value for this TransformMarkUpText3Response.
     * 
     * @param transformMarkUpText3Result
     */
    public void setTransformMarkUpText3Result(java.lang.String transformMarkUpText3Result) {
        this.transformMarkUpText3Result = transformMarkUpText3Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransformMarkUpText3Response)) return false;
        TransformMarkUpText3Response other = (TransformMarkUpText3Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.transformMarkUpText3Result==null && other.getTransformMarkUpText3Result()==null) || 
             (this.transformMarkUpText3Result!=null &&
              this.transformMarkUpText3Result.equals(other.getTransformMarkUpText3Result())));
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
        if (getTransformMarkUpText3Result() != null) {
            _hashCode += getTransformMarkUpText3Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransformMarkUpText3Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">TransformMarkUpText3Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transformMarkUpText3Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TransformMarkUpText3Result"));
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
