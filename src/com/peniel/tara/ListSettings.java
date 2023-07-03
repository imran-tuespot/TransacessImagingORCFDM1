/**
 * ListSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListSettings  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.SettingsDTO param;

    private int minExpected;

    private int maxExpected;

    public ListSettings() {
    }

    public ListSettings(
           java.lang.String loginContextId,
           com.peniel.tara.SettingsDTO param,
           int minExpected,
           int maxExpected) {
           this.loginContextId = loginContextId;
           this.param = param;
           this.minExpected = minExpected;
           this.maxExpected = maxExpected;
    }


    /**
     * Gets the loginContextId value for this ListSettings.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this ListSettings.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the param value for this ListSettings.
     * 
     * @return param
     */
    public com.peniel.tara.SettingsDTO getParam() {
        return param;
    }


    /**
     * Sets the param value for this ListSettings.
     * 
     * @param param
     */
    public void setParam(com.peniel.tara.SettingsDTO param) {
        this.param = param;
    }


    /**
     * Gets the minExpected value for this ListSettings.
     * 
     * @return minExpected
     */
    public int getMinExpected() {
        return minExpected;
    }


    /**
     * Sets the minExpected value for this ListSettings.
     * 
     * @param minExpected
     */
    public void setMinExpected(int minExpected) {
        this.minExpected = minExpected;
    }


    /**
     * Gets the maxExpected value for this ListSettings.
     * 
     * @return maxExpected
     */
    public int getMaxExpected() {
        return maxExpected;
    }


    /**
     * Sets the maxExpected value for this ListSettings.
     * 
     * @param maxExpected
     */
    public void setMaxExpected(int maxExpected) {
        this.maxExpected = maxExpected;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListSettings)) return false;
        ListSettings other = (ListSettings) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.loginContextId==null && other.getLoginContextId()==null) || 
             (this.loginContextId!=null &&
              this.loginContextId.equals(other.getLoginContextId()))) &&
            ((this.param==null && other.getParam()==null) || 
             (this.param!=null &&
              this.param.equals(other.getParam()))) &&
            this.minExpected == other.getMinExpected() &&
            this.maxExpected == other.getMaxExpected();
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
        if (getLoginContextId() != null) {
            _hashCode += getLoginContextId().hashCode();
        }
        if (getParam() != null) {
            _hashCode += getParam().hashCode();
        }
        _hashCode += getMinExpected();
        _hashCode += getMaxExpected();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "param"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SettingsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minExpected");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "minExpected"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxExpected");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "maxExpected"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
