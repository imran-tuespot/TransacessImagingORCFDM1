/**
 * GetServerConfigResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetServerConfigResponse  implements java.io.Serializable {
    private com.peniel.tara.ConfigEntryDTO[] getServerConfigResult;

    public GetServerConfigResponse() {
    }

    public GetServerConfigResponse(
           com.peniel.tara.ConfigEntryDTO[] getServerConfigResult) {
           this.getServerConfigResult = getServerConfigResult;
    }


    /**
     * Gets the getServerConfigResult value for this GetServerConfigResponse.
     * 
     * @return getServerConfigResult
     */
    public com.peniel.tara.ConfigEntryDTO[] getGetServerConfigResult() {
        return getServerConfigResult;
    }


    /**
     * Sets the getServerConfigResult value for this GetServerConfigResponse.
     * 
     * @param getServerConfigResult
     */
    public void setGetServerConfigResult(com.peniel.tara.ConfigEntryDTO[] getServerConfigResult) {
        this.getServerConfigResult = getServerConfigResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetServerConfigResponse)) return false;
        GetServerConfigResponse other = (GetServerConfigResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getServerConfigResult==null && other.getGetServerConfigResult()==null) || 
             (this.getServerConfigResult!=null &&
              java.util.Arrays.equals(this.getServerConfigResult, other.getGetServerConfigResult())));
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
        if (getGetServerConfigResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetServerConfigResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetServerConfigResult(), i);
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
        new org.apache.axis.description.TypeDesc(GetServerConfigResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetServerConfigResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getServerConfigResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetServerConfigResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ConfigEntryDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ConfigEntryDTO"));
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
