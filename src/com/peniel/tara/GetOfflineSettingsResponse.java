/**
 * GetOfflineSettingsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetOfflineSettingsResponse  implements java.io.Serializable {
    private com.peniel.tara.SettingsDTO getOfflineSettingsResult;

    public GetOfflineSettingsResponse() {
    }

    public GetOfflineSettingsResponse(
           com.peniel.tara.SettingsDTO getOfflineSettingsResult) {
           this.getOfflineSettingsResult = getOfflineSettingsResult;
    }


    /**
     * Gets the getOfflineSettingsResult value for this GetOfflineSettingsResponse.
     * 
     * @return getOfflineSettingsResult
     */
    public com.peniel.tara.SettingsDTO getGetOfflineSettingsResult() {
        return getOfflineSettingsResult;
    }


    /**
     * Sets the getOfflineSettingsResult value for this GetOfflineSettingsResponse.
     * 
     * @param getOfflineSettingsResult
     */
    public void setGetOfflineSettingsResult(com.peniel.tara.SettingsDTO getOfflineSettingsResult) {
        this.getOfflineSettingsResult = getOfflineSettingsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOfflineSettingsResponse)) return false;
        GetOfflineSettingsResponse other = (GetOfflineSettingsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getOfflineSettingsResult==null && other.getGetOfflineSettingsResult()==null) || 
             (this.getOfflineSettingsResult!=null &&
              this.getOfflineSettingsResult.equals(other.getGetOfflineSettingsResult())));
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
        if (getGetOfflineSettingsResult() != null) {
            _hashCode += getGetOfflineSettingsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetOfflineSettingsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetOfflineSettingsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getOfflineSettingsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetOfflineSettingsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SettingsDTO"));
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
