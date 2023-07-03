/**
 * GetWorkgroupByNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetWorkgroupByNameResponse  implements java.io.Serializable {
    private com.peniel.tara.WorkgroupDTO getWorkgroupByNameResult;

    public GetWorkgroupByNameResponse() {
    }

    public GetWorkgroupByNameResponse(
           com.peniel.tara.WorkgroupDTO getWorkgroupByNameResult) {
           this.getWorkgroupByNameResult = getWorkgroupByNameResult;
    }


    /**
     * Gets the getWorkgroupByNameResult value for this GetWorkgroupByNameResponse.
     * 
     * @return getWorkgroupByNameResult
     */
    public com.peniel.tara.WorkgroupDTO getGetWorkgroupByNameResult() {
        return getWorkgroupByNameResult;
    }


    /**
     * Sets the getWorkgroupByNameResult value for this GetWorkgroupByNameResponse.
     * 
     * @param getWorkgroupByNameResult
     */
    public void setGetWorkgroupByNameResult(com.peniel.tara.WorkgroupDTO getWorkgroupByNameResult) {
        this.getWorkgroupByNameResult = getWorkgroupByNameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetWorkgroupByNameResponse)) return false;
        GetWorkgroupByNameResponse other = (GetWorkgroupByNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getWorkgroupByNameResult==null && other.getGetWorkgroupByNameResult()==null) || 
             (this.getWorkgroupByNameResult!=null &&
              this.getWorkgroupByNameResult.equals(other.getGetWorkgroupByNameResult())));
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
        if (getGetWorkgroupByNameResult() != null) {
            _hashCode += getGetWorkgroupByNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetWorkgroupByNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetWorkgroupByNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getWorkgroupByNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetWorkgroupByNameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupDTO"));
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
