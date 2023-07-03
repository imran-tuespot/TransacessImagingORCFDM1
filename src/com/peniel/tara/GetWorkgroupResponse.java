/**
 * GetWorkgroupResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetWorkgroupResponse  implements java.io.Serializable {
    private com.peniel.tara.WorkgroupDTO getWorkgroupResult;

    public GetWorkgroupResponse() {
    }

    public GetWorkgroupResponse(
           com.peniel.tara.WorkgroupDTO getWorkgroupResult) {
           this.getWorkgroupResult = getWorkgroupResult;
    }


    /**
     * Gets the getWorkgroupResult value for this GetWorkgroupResponse.
     * 
     * @return getWorkgroupResult
     */
    public com.peniel.tara.WorkgroupDTO getGetWorkgroupResult() {
        return getWorkgroupResult;
    }


    /**
     * Sets the getWorkgroupResult value for this GetWorkgroupResponse.
     * 
     * @param getWorkgroupResult
     */
    public void setGetWorkgroupResult(com.peniel.tara.WorkgroupDTO getWorkgroupResult) {
        this.getWorkgroupResult = getWorkgroupResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetWorkgroupResponse)) return false;
        GetWorkgroupResponse other = (GetWorkgroupResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getWorkgroupResult==null && other.getGetWorkgroupResult()==null) || 
             (this.getWorkgroupResult!=null &&
              this.getWorkgroupResult.equals(other.getGetWorkgroupResult())));
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
        if (getGetWorkgroupResult() != null) {
            _hashCode += getGetWorkgroupResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetWorkgroupResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetWorkgroupResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getWorkgroupResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetWorkgroupResult"));
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
