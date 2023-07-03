/**
 * GetOfflineClientWebResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetOfflineClientWebResponse  implements java.io.Serializable {
    private byte[] getOfflineClientWebResult;

    public GetOfflineClientWebResponse() {
    }

    public GetOfflineClientWebResponse(
           byte[] getOfflineClientWebResult) {
           this.getOfflineClientWebResult = getOfflineClientWebResult;
    }


    /**
     * Gets the getOfflineClientWebResult value for this GetOfflineClientWebResponse.
     * 
     * @return getOfflineClientWebResult
     */
    public byte[] getGetOfflineClientWebResult() {
        return getOfflineClientWebResult;
    }


    /**
     * Sets the getOfflineClientWebResult value for this GetOfflineClientWebResponse.
     * 
     * @param getOfflineClientWebResult
     */
    public void setGetOfflineClientWebResult(byte[] getOfflineClientWebResult) {
        this.getOfflineClientWebResult = getOfflineClientWebResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOfflineClientWebResponse)) return false;
        GetOfflineClientWebResponse other = (GetOfflineClientWebResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getOfflineClientWebResult==null && other.getGetOfflineClientWebResult()==null) || 
             (this.getOfflineClientWebResult!=null &&
              java.util.Arrays.equals(this.getOfflineClientWebResult, other.getGetOfflineClientWebResult())));
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
        if (getGetOfflineClientWebResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetOfflineClientWebResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetOfflineClientWebResult(), i);
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
        new org.apache.axis.description.TypeDesc(GetOfflineClientWebResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetOfflineClientWebResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getOfflineClientWebResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetOfflineClientWebResult"));
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
