/**
 * GetWorkgroupRoleForSubject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetWorkgroupRoleForSubject  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int subjectId;

    private int workgroupId;

    public GetWorkgroupRoleForSubject() {
    }

    public GetWorkgroupRoleForSubject(
           java.lang.String loginContextId,
           int subjectId,
           int workgroupId) {
           this.loginContextId = loginContextId;
           this.subjectId = subjectId;
           this.workgroupId = workgroupId;
    }


    /**
     * Gets the loginContextId value for this GetWorkgroupRoleForSubject.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetWorkgroupRoleForSubject.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the subjectId value for this GetWorkgroupRoleForSubject.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this GetWorkgroupRoleForSubject.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the workgroupId value for this GetWorkgroupRoleForSubject.
     * 
     * @return workgroupId
     */
    public int getWorkgroupId() {
        return workgroupId;
    }


    /**
     * Sets the workgroupId value for this GetWorkgroupRoleForSubject.
     * 
     * @param workgroupId
     */
    public void setWorkgroupId(int workgroupId) {
        this.workgroupId = workgroupId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetWorkgroupRoleForSubject)) return false;
        GetWorkgroupRoleForSubject other = (GetWorkgroupRoleForSubject) obj;
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
            this.subjectId == other.getSubjectId() &&
            this.workgroupId == other.getWorkgroupId();
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
        _hashCode += getSubjectId();
        _hashCode += getWorkgroupId();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetWorkgroupRoleForSubject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetWorkgroupRoleForSubject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "workgroupId"));
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
