/**
 * GetAutoRefreshSettingsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetAutoRefreshSettingsResponse  implements java.io.Serializable {
    private com.peniel.tara.SettingsDTO getAutoRefreshSettingsResult;

    public GetAutoRefreshSettingsResponse() {
    }

    public GetAutoRefreshSettingsResponse(
           com.peniel.tara.SettingsDTO getAutoRefreshSettingsResult) {
           this.getAutoRefreshSettingsResult = getAutoRefreshSettingsResult;
    }


    /**
     * Gets the getAutoRefreshSettingsResult value for this GetAutoRefreshSettingsResponse.
     * 
     * @return getAutoRefreshSettingsResult
     */
    public com.peniel.tara.SettingsDTO getGetAutoRefreshSettingsResult() {
        return getAutoRefreshSettingsResult;
    }


    /**
     * Sets the getAutoRefreshSettingsResult value for this GetAutoRefreshSettingsResponse.
     * 
     * @param getAutoRefreshSettingsResult
     */
    public void setGetAutoRefreshSettingsResult(com.peniel.tara.SettingsDTO getAutoRefreshSettingsResult) {
        this.getAutoRefreshSettingsResult = getAutoRefreshSettingsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAutoRefreshSettingsResponse)) return false;
        GetAutoRefreshSettingsResponse other = (GetAutoRefreshSettingsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getAutoRefreshSettingsResult==null && other.getGetAutoRefreshSettingsResult()==null) || 
             (this.getAutoRefreshSettingsResult!=null &&
              this.getAutoRefreshSettingsResult.equals(other.getGetAutoRefreshSettingsResult())));
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
        if (getGetAutoRefreshSettingsResult() != null) {
            _hashCode += getGetAutoRefreshSettingsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAutoRefreshSettingsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetAutoRefreshSettingsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAutoRefreshSettingsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetAutoRefreshSettingsResult"));
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
