/**
 * IsLockedWorkgroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class IsLockedWorkgroup  implements java.io.Serializable {
    private java.lang.String accessKey;

    private java.lang.String sysconname;

    private java.lang.String extSource;

    private java.lang.String extRef;

    public IsLockedWorkgroup() {
    }

    public IsLockedWorkgroup(
           java.lang.String accessKey,
           java.lang.String sysconname,
           java.lang.String extSource,
           java.lang.String extRef) {
           this.accessKey = accessKey;
           this.sysconname = sysconname;
           this.extSource = extSource;
           this.extRef = extRef;
    }


    /**
     * Gets the accessKey value for this IsLockedWorkgroup.
     * 
     * @return accessKey
     */
    public java.lang.String getAccessKey() {
        return accessKey;
    }


    /**
     * Sets the accessKey value for this IsLockedWorkgroup.
     * 
     * @param accessKey
     */
    public void setAccessKey(java.lang.String accessKey) {
        this.accessKey = accessKey;
    }


    /**
     * Gets the sysconname value for this IsLockedWorkgroup.
     * 
     * @return sysconname
     */
    public java.lang.String getSysconname() {
        return sysconname;
    }


    /**
     * Sets the sysconname value for this IsLockedWorkgroup.
     * 
     * @param sysconname
     */
    public void setSysconname(java.lang.String sysconname) {
        this.sysconname = sysconname;
    }


    /**
     * Gets the extSource value for this IsLockedWorkgroup.
     * 
     * @return extSource
     */
    public java.lang.String getExtSource() {
        return extSource;
    }


    /**
     * Sets the extSource value for this IsLockedWorkgroup.
     * 
     * @param extSource
     */
    public void setExtSource(java.lang.String extSource) {
        this.extSource = extSource;
    }


    /**
     * Gets the extRef value for this IsLockedWorkgroup.
     * 
     * @return extRef
     */
    public java.lang.String getExtRef() {
        return extRef;
    }


    /**
     * Sets the extRef value for this IsLockedWorkgroup.
     * 
     * @param extRef
     */
    public void setExtRef(java.lang.String extRef) {
        this.extRef = extRef;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IsLockedWorkgroup)) return false;
        IsLockedWorkgroup other = (IsLockedWorkgroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accessKey==null && other.getAccessKey()==null) || 
             (this.accessKey!=null &&
              this.accessKey.equals(other.getAccessKey()))) &&
            ((this.sysconname==null && other.getSysconname()==null) || 
             (this.sysconname!=null &&
              this.sysconname.equals(other.getSysconname()))) &&
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
        if (getAccessKey() != null) {
            _hashCode += getAccessKey().hashCode();
        }
        if (getSysconname() != null) {
            _hashCode += getSysconname().hashCode();
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
        new org.apache.axis.description.TypeDesc(IsLockedWorkgroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">IsLockedWorkgroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accessKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "accessKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysconname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "sysconname"));
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
