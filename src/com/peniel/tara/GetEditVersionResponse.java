/**
 * GetEditVersionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetEditVersionResponse  implements java.io.Serializable {
    private com.peniel.tara.EditVersionDTO getEditVersionResult;

    public GetEditVersionResponse() {
    }

    public GetEditVersionResponse(
           com.peniel.tara.EditVersionDTO getEditVersionResult) {
           this.getEditVersionResult = getEditVersionResult;
    }


    /**
     * Gets the getEditVersionResult value for this GetEditVersionResponse.
     * 
     * @return getEditVersionResult
     */
    public com.peniel.tara.EditVersionDTO getGetEditVersionResult() {
        return getEditVersionResult;
    }


    /**
     * Sets the getEditVersionResult value for this GetEditVersionResponse.
     * 
     * @param getEditVersionResult
     */
    public void setGetEditVersionResult(com.peniel.tara.EditVersionDTO getEditVersionResult) {
        this.getEditVersionResult = getEditVersionResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEditVersionResponse)) return false;
        GetEditVersionResponse other = (GetEditVersionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEditVersionResult==null && other.getGetEditVersionResult()==null) || 
             (this.getEditVersionResult!=null &&
              this.getEditVersionResult.equals(other.getGetEditVersionResult())));
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
        if (getGetEditVersionResult() != null) {
            _hashCode += getGetEditVersionResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEditVersionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetEditVersionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEditVersionResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetEditVersionResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditVersionDTO"));
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
