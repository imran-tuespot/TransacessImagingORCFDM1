/**
 * IsPermittedBySystemPolicy1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class IsPermittedBySystemPolicy1  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private java.lang.String object;

    private java.lang.String principal;

    private java.lang.String permission;

    private boolean defaultAction;

    public IsPermittedBySystemPolicy1() {
    }

    public IsPermittedBySystemPolicy1(
           java.lang.String loginContextId,
           java.lang.String object,
           java.lang.String principal,
           java.lang.String permission,
           boolean defaultAction) {
           this.loginContextId = loginContextId;
           this.object = object;
           this.principal = principal;
           this.permission = permission;
           this.defaultAction = defaultAction;
    }


    /**
     * Gets the loginContextId value for this IsPermittedBySystemPolicy1.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this IsPermittedBySystemPolicy1.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the object value for this IsPermittedBySystemPolicy1.
     * 
     * @return object
     */
    public java.lang.String getObject() {
        return object;
    }


    /**
     * Sets the object value for this IsPermittedBySystemPolicy1.
     * 
     * @param object
     */
    public void setObject(java.lang.String object) {
        this.object = object;
    }


    /**
     * Gets the principal value for this IsPermittedBySystemPolicy1.
     * 
     * @return principal
     */
    public java.lang.String getPrincipal() {
        return principal;
    }


    /**
     * Sets the principal value for this IsPermittedBySystemPolicy1.
     * 
     * @param principal
     */
    public void setPrincipal(java.lang.String principal) {
        this.principal = principal;
    }


    /**
     * Gets the permission value for this IsPermittedBySystemPolicy1.
     * 
     * @return permission
     */
    public java.lang.String getPermission() {
        return permission;
    }


    /**
     * Sets the permission value for this IsPermittedBySystemPolicy1.
     * 
     * @param permission
     */
    public void setPermission(java.lang.String permission) {
        this.permission = permission;
    }


    /**
     * Gets the defaultAction value for this IsPermittedBySystemPolicy1.
     * 
     * @return defaultAction
     */
    public boolean isDefaultAction() {
        return defaultAction;
    }


    /**
     * Sets the defaultAction value for this IsPermittedBySystemPolicy1.
     * 
     * @param defaultAction
     */
    public void setDefaultAction(boolean defaultAction) {
        this.defaultAction = defaultAction;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IsPermittedBySystemPolicy1)) return false;
        IsPermittedBySystemPolicy1 other = (IsPermittedBySystemPolicy1) obj;
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
            ((this.object==null && other.getObject()==null) || 
             (this.object!=null &&
              this.object.equals(other.getObject()))) &&
            ((this.principal==null && other.getPrincipal()==null) || 
             (this.principal!=null &&
              this.principal.equals(other.getPrincipal()))) &&
            ((this.permission==null && other.getPermission()==null) || 
             (this.permission!=null &&
              this.permission.equals(other.getPermission()))) &&
            this.defaultAction == other.isDefaultAction();
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
        if (getObject() != null) {
            _hashCode += getObject().hashCode();
        }
        if (getPrincipal() != null) {
            _hashCode += getPrincipal().hashCode();
        }
        if (getPermission() != null) {
            _hashCode += getPermission().hashCode();
        }
        _hashCode += (isDefaultAction() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IsPermittedBySystemPolicy1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">IsPermittedBySystemPolicy1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("object");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Object"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("principal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Principal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permission");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Permission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultAction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "defaultAction"));
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
