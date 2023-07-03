/**
 * TransformMarkUpTextResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class TransformMarkUpTextResponse  implements java.io.Serializable {
    private java.lang.String transformMarkUpTextResult;

    public TransformMarkUpTextResponse() {
    }

    public TransformMarkUpTextResponse(
           java.lang.String transformMarkUpTextResult) {
           this.transformMarkUpTextResult = transformMarkUpTextResult;
    }


    /**
     * Gets the transformMarkUpTextResult value for this TransformMarkUpTextResponse.
     * 
     * @return transformMarkUpTextResult
     */
    public java.lang.String getTransformMarkUpTextResult() {
        return transformMarkUpTextResult;
    }


    /**
     * Sets the transformMarkUpTextResult value for this TransformMarkUpTextResponse.
     * 
     * @param transformMarkUpTextResult
     */
    public void setTransformMarkUpTextResult(java.lang.String transformMarkUpTextResult) {
        this.transformMarkUpTextResult = transformMarkUpTextResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransformMarkUpTextResponse)) return false;
        TransformMarkUpTextResponse other = (TransformMarkUpTextResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.transformMarkUpTextResult==null && other.getTransformMarkUpTextResult()==null) || 
             (this.transformMarkUpTextResult!=null &&
              this.transformMarkUpTextResult.equals(other.getTransformMarkUpTextResult())));
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
        if (getTransformMarkUpTextResult() != null) {
            _hashCode += getTransformMarkUpTextResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransformMarkUpTextResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">TransformMarkUpTextResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transformMarkUpTextResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TransformMarkUpTextResult"));
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
