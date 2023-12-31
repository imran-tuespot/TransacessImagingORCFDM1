/**
 * GetReconReportAsWordResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetReconReportAsWordResponse  implements java.io.Serializable {
    private byte[] getReconReportAsWordResult;

    public GetReconReportAsWordResponse() {
    }

    public GetReconReportAsWordResponse(
           byte[] getReconReportAsWordResult) {
           this.getReconReportAsWordResult = getReconReportAsWordResult;
    }


    /**
     * Gets the getReconReportAsWordResult value for this GetReconReportAsWordResponse.
     * 
     * @return getReconReportAsWordResult
     */
    public byte[] getGetReconReportAsWordResult() {
        return getReconReportAsWordResult;
    }


    /**
     * Sets the getReconReportAsWordResult value for this GetReconReportAsWordResponse.
     * 
     * @param getReconReportAsWordResult
     */
    public void setGetReconReportAsWordResult(byte[] getReconReportAsWordResult) {
        this.getReconReportAsWordResult = getReconReportAsWordResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetReconReportAsWordResponse)) return false;
        GetReconReportAsWordResponse other = (GetReconReportAsWordResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getReconReportAsWordResult==null && other.getGetReconReportAsWordResult()==null) || 
             (this.getReconReportAsWordResult!=null &&
              java.util.Arrays.equals(this.getReconReportAsWordResult, other.getGetReconReportAsWordResult())));
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
        if (getGetReconReportAsWordResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetReconReportAsWordResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetReconReportAsWordResult(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetReconReportAsWordResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetReconReportAsWordResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getReconReportAsWordResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetReconReportAsWordResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
