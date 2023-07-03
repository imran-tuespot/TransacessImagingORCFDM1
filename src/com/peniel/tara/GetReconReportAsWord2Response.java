/**
 * GetReconReportAsWord2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetReconReportAsWord2Response  implements java.io.Serializable {
    private byte[] getReconReportAsWord2Result;

    public GetReconReportAsWord2Response() {
    }

    public GetReconReportAsWord2Response(
           byte[] getReconReportAsWord2Result) {
           this.getReconReportAsWord2Result = getReconReportAsWord2Result;
    }


    /**
     * Gets the getReconReportAsWord2Result value for this GetReconReportAsWord2Response.
     * 
     * @return getReconReportAsWord2Result
     */
    public byte[] getGetReconReportAsWord2Result() {
        return getReconReportAsWord2Result;
    }


    /**
     * Sets the getReconReportAsWord2Result value for this GetReconReportAsWord2Response.
     * 
     * @param getReconReportAsWord2Result
     */
    public void setGetReconReportAsWord2Result(byte[] getReconReportAsWord2Result) {
        this.getReconReportAsWord2Result = getReconReportAsWord2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetReconReportAsWord2Response)) return false;
        GetReconReportAsWord2Response other = (GetReconReportAsWord2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getReconReportAsWord2Result==null && other.getGetReconReportAsWord2Result()==null) || 
             (this.getReconReportAsWord2Result!=null &&
              java.util.Arrays.equals(this.getReconReportAsWord2Result, other.getGetReconReportAsWord2Result())));
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
        if (getGetReconReportAsWord2Result() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetReconReportAsWord2Result());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetReconReportAsWord2Result(), i);
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
        new org.apache.axis.description.TypeDesc(GetReconReportAsWord2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetReconReportAsWord2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getReconReportAsWord2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetReconReportAsWord2Result"));
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
