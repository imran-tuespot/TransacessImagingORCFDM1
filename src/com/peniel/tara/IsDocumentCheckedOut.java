/**
 * IsDocumentCheckedOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class IsDocumentCheckedOut  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private java.lang.String extSource;

    private java.lang.String extRef;

    public IsDocumentCheckedOut() {
    }

    public IsDocumentCheckedOut(
           java.lang.String loginContextId,
           java.lang.String extSource,
           java.lang.String extRef) {
           this.loginContextId = loginContextId;
           this.extSource = extSource;
           this.extRef = extRef;
    }


    /**
     * Gets the loginContextId value for this IsDocumentCheckedOut.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this IsDocumentCheckedOut.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the extSource value for this IsDocumentCheckedOut.
     * 
     * @return extSource
     */
    public java.lang.String getExtSource() {
        return extSource;
    }


    /**
     * Sets the extSource value for this IsDocumentCheckedOut.
     * 
     * @param extSource
     */
    public void setExtSource(java.lang.String extSource) {
        this.extSource = extSource;
    }


    /**
     * Gets the extRef value for this IsDocumentCheckedOut.
     * 
     * @return extRef
     */
    public java.lang.String getExtRef() {
        return extRef;
    }


    /**
     * Sets the extRef value for this IsDocumentCheckedOut.
     * 
     * @param extRef
     */
    public void setExtRef(java.lang.String extRef) {
        this.extRef = extRef;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IsDocumentCheckedOut)) return false;
        IsDocumentCheckedOut other = (IsDocumentCheckedOut) obj;
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
            ((this.extSource==null && other.getExtSource()==null) || 
             (this.extSource!=null &&
              this.extSource.equals(other.getExtSource()))) &&
            ((this.extRef==null && other.getExtRef()==null) || 
             (this.extRef!=null &&
              this.extRef.equals(other.getExtRef())));
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
        if (getExtSource() != null) {
            _hashCode += getExtSource().hashCode();
        }
        if (getExtRef() != null) {
            _hashCode += getExtRef().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IsDocumentCheckedOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">IsDocumentCheckedOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "extSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extRef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "extRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
