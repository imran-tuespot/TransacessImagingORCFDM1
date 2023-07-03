/**
 * GetUserTypeRuntimePermissionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetUserTypeRuntimePermissionResponse  implements java.io.Serializable {
    private com.peniel.tara.UserTypeRuntimePermissionDTO getUserTypeRuntimePermissionResult;

    public GetUserTypeRuntimePermissionResponse() {
    }

    public GetUserTypeRuntimePermissionResponse(
           com.peniel.tara.UserTypeRuntimePermissionDTO getUserTypeRuntimePermissionResult) {
           this.getUserTypeRuntimePermissionResult = getUserTypeRuntimePermissionResult;
    }


    /**
     * Gets the getUserTypeRuntimePermissionResult value for this GetUserTypeRuntimePermissionResponse.
     * 
     * @return getUserTypeRuntimePermissionResult
     */
    public com.peniel.tara.UserTypeRuntimePermissionDTO getGetUserTypeRuntimePermissionResult() {
        return getUserTypeRuntimePermissionResult;
    }


    /**
     * Sets the getUserTypeRuntimePermissionResult value for this GetUserTypeRuntimePermissionResponse.
     * 
     * @param getUserTypeRuntimePermissionResult
     */
    public void setGetUserTypeRuntimePermissionResult(com.peniel.tara.UserTypeRuntimePermissionDTO getUserTypeRuntimePermissionResult) {
        this.getUserTypeRuntimePermissionResult = getUserTypeRuntimePermissionResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUserTypeRuntimePermissionResponse)) return false;
        GetUserTypeRuntimePermissionResponse other = (GetUserTypeRuntimePermissionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getUserTypeRuntimePermissionResult==null && other.getGetUserTypeRuntimePermissionResult()==null) || 
             (this.getUserTypeRuntimePermissionResult!=null &&
              this.getUserTypeRuntimePermissionResult.equals(other.getGetUserTypeRuntimePermissionResult())));
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
        if (getGetUserTypeRuntimePermissionResult() != null) {
            _hashCode += getGetUserTypeRuntimePermissionResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetUserTypeRuntimePermissionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetUserTypeRuntimePermissionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getUserTypeRuntimePermissionResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetUserTypeRuntimePermissionResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UserTypeRuntimePermissionDTO"));
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
