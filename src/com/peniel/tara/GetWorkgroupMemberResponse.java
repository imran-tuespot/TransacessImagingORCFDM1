/**
 * GetWorkgroupMemberResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetWorkgroupMemberResponse  implements java.io.Serializable {
    private com.peniel.tara.WorkgroupMemberDTO getWorkgroupMemberResult;

    public GetWorkgroupMemberResponse() {
    }

    public GetWorkgroupMemberResponse(
           com.peniel.tara.WorkgroupMemberDTO getWorkgroupMemberResult) {
           this.getWorkgroupMemberResult = getWorkgroupMemberResult;
    }


    /**
     * Gets the getWorkgroupMemberResult value for this GetWorkgroupMemberResponse.
     * 
     * @return getWorkgroupMemberResult
     */
    public com.peniel.tara.WorkgroupMemberDTO getGetWorkgroupMemberResult() {
        return getWorkgroupMemberResult;
    }


    /**
     * Sets the getWorkgroupMemberResult value for this GetWorkgroupMemberResponse.
     * 
     * @param getWorkgroupMemberResult
     */
    public void setGetWorkgroupMemberResult(com.peniel.tara.WorkgroupMemberDTO getWorkgroupMemberResult) {
        this.getWorkgroupMemberResult = getWorkgroupMemberResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetWorkgroupMemberResponse)) return false;
        GetWorkgroupMemberResponse other = (GetWorkgroupMemberResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getWorkgroupMemberResult==null && other.getGetWorkgroupMemberResult()==null) || 
             (this.getWorkgroupMemberResult!=null &&
              this.getWorkgroupMemberResult.equals(other.getGetWorkgroupMemberResult())));
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
        if (getGetWorkgroupMemberResult() != null) {
            _hashCode += getGetWorkgroupMemberResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetWorkgroupMemberResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetWorkgroupMemberResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getWorkgroupMemberResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetWorkgroupMemberResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupMemberDTO"));
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
