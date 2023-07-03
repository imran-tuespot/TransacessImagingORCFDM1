/**
 * GetTrustedClientResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetTrustedClientResponse  implements java.io.Serializable {
    private com.peniel.tara.TrustedClientDTO getTrustedClientResult;

    public GetTrustedClientResponse() {
    }

    public GetTrustedClientResponse(
           com.peniel.tara.TrustedClientDTO getTrustedClientResult) {
           this.getTrustedClientResult = getTrustedClientResult;
    }


    /**
     * Gets the getTrustedClientResult value for this GetTrustedClientResponse.
     * 
     * @return getTrustedClientResult
     */
    public com.peniel.tara.TrustedClientDTO getGetTrustedClientResult() {
        return getTrustedClientResult;
    }


    /**
     * Sets the getTrustedClientResult value for this GetTrustedClientResponse.
     * 
     * @param getTrustedClientResult
     */
    public void setGetTrustedClientResult(com.peniel.tara.TrustedClientDTO getTrustedClientResult) {
        this.getTrustedClientResult = getTrustedClientResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTrustedClientResponse)) return false;
        GetTrustedClientResponse other = (GetTrustedClientResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getTrustedClientResult==null && other.getGetTrustedClientResult()==null) || 
             (this.getTrustedClientResult!=null &&
              this.getTrustedClientResult.equals(other.getGetTrustedClientResult())));
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
        if (getGetTrustedClientResult() != null) {
            _hashCode += getGetTrustedClientResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTrustedClientResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetTrustedClientResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getTrustedClientResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetTrustedClientResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TrustedClientDTO"));
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
