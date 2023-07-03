/**
 * GetSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetSettings  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private java.lang.String refObjectType;

    private int refObjectId;

    private java.lang.String entryName;

    private boolean returnNewIfNone;

    public GetSettings() {
    }

    public GetSettings(
           java.lang.String loginContextId,
           java.lang.String refObjectType,
           int refObjectId,
           java.lang.String entryName,
           boolean returnNewIfNone) {
           this.loginContextId = loginContextId;
           this.refObjectType = refObjectType;
           this.refObjectId = refObjectId;
           this.entryName = entryName;
           this.returnNewIfNone = returnNewIfNone;
    }


    /**
     * Gets the loginContextId value for this GetSettings.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetSettings.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the refObjectType value for this GetSettings.
     * 
     * @return refObjectType
     */
    public java.lang.String getRefObjectType() {
        return refObjectType;
    }


    /**
     * Sets the refObjectType value for this GetSettings.
     * 
     * @param refObjectType
     */
    public void setRefObjectType(java.lang.String refObjectType) {
        this.refObjectType = refObjectType;
    }


    /**
     * Gets the refObjectId value for this GetSettings.
     * 
     * @return refObjectId
     */
    public int getRefObjectId() {
        return refObjectId;
    }


    /**
     * Sets the refObjectId value for this GetSettings.
     * 
     * @param refObjectId
     */
    public void setRefObjectId(int refObjectId) {
        this.refObjectId = refObjectId;
    }


    /**
     * Gets the entryName value for this GetSettings.
     * 
     * @return entryName
     */
    public java.lang.String getEntryName() {
        return entryName;
    }


    /**
     * Sets the entryName value for this GetSettings.
     * 
     * @param entryName
     */
    public void setEntryName(java.lang.String entryName) {
        this.entryName = entryName;
    }


    /**
     * Gets the returnNewIfNone value for this GetSettings.
     * 
     * @return returnNewIfNone
     */
    public boolean isReturnNewIfNone() {
        return returnNewIfNone;
    }


    /**
     * Sets the returnNewIfNone value for this GetSettings.
     * 
     * @param returnNewIfNone
     */
    public void setReturnNewIfNone(boolean returnNewIfNone) {
        this.returnNewIfNone = returnNewIfNone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSettings)) return false;
        GetSettings other = (GetSettings) obj;
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
            ((this.refObjectType==null && other.getRefObjectType()==null) || 
             (this.refObjectType!=null &&
              this.refObjectType.equals(other.getRefObjectType()))) &&
            this.refObjectId == other.getRefObjectId() &&
            ((this.entryName==null && other.getEntryName()==null) || 
             (this.entryName!=null &&
              this.entryName.equals(other.getEntryName()))) &&
            this.returnNewIfNone == other.isReturnNewIfNone();
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
        if (getRefObjectType() != null) {
            _hashCode += getRefObjectType().hashCode();
        }
        _hashCode += getRefObjectId();
        if (getEntryName() != null) {
            _hashCode += getEntryName().hashCode();
        }
        _hashCode += (isReturnNewIfNone() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refObjectType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "refObjectType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refObjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "refObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entryName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "entryName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnNewIfNone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "returnNewIfNone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
