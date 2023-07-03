/**
 * ListWorkgroupsForSubject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListWorkgroupsForSubject  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int subjectId;

    private java.lang.String workgroupPermission;

    private boolean includeMember;

    private boolean includeLicenseAdmin;

    public ListWorkgroupsForSubject() {
    }

    public ListWorkgroupsForSubject(
           java.lang.String loginContextId,
           int subjectId,
           java.lang.String workgroupPermission,
           boolean includeMember,
           boolean includeLicenseAdmin) {
           this.loginContextId = loginContextId;
           this.subjectId = subjectId;
           this.workgroupPermission = workgroupPermission;
           this.includeMember = includeMember;
           this.includeLicenseAdmin = includeLicenseAdmin;
    }


    /**
     * Gets the loginContextId value for this ListWorkgroupsForSubject.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this ListWorkgroupsForSubject.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the subjectId value for this ListWorkgroupsForSubject.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this ListWorkgroupsForSubject.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the workgroupPermission value for this ListWorkgroupsForSubject.
     * 
     * @return workgroupPermission
     */
    public java.lang.String getWorkgroupPermission() {
        return workgroupPermission;
    }


    /**
     * Sets the workgroupPermission value for this ListWorkgroupsForSubject.
     * 
     * @param workgroupPermission
     */
    public void setWorkgroupPermission(java.lang.String workgroupPermission) {
        this.workgroupPermission = workgroupPermission;
    }


    /**
     * Gets the includeMember value for this ListWorkgroupsForSubject.
     * 
     * @return includeMember
     */
    public boolean isIncludeMember() {
        return includeMember;
    }


    /**
     * Sets the includeMember value for this ListWorkgroupsForSubject.
     * 
     * @param includeMember
     */
    public void setIncludeMember(boolean includeMember) {
        this.includeMember = includeMember;
    }


    /**
     * Gets the includeLicenseAdmin value for this ListWorkgroupsForSubject.
     * 
     * @return includeLicenseAdmin
     */
    public boolean isIncludeLicenseAdmin() {
        return includeLicenseAdmin;
    }


    /**
     * Sets the includeLicenseAdmin value for this ListWorkgroupsForSubject.
     * 
     * @param includeLicenseAdmin
     */
    public void setIncludeLicenseAdmin(boolean includeLicenseAdmin) {
        this.includeLicenseAdmin = includeLicenseAdmin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListWorkgroupsForSubject)) return false;
        ListWorkgroupsForSubject other = (ListWorkgroupsForSubject) obj;
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
            ((this.workgroupPermission==null && other.getWorkgroupPermission()==null) || 
             (this.workgroupPermission!=null &&
              this.workgroupPermission.equals(other.getWorkgroupPermission()))) &&
            this.includeMember == other.isIncludeMember() &&
            this.includeLicenseAdmin == other.isIncludeLicenseAdmin();
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
        if (getWorkgroupPermission() != null) {
            _hashCode += getWorkgroupPermission().hashCode();
        }
        _hashCode += (isIncludeMember() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeLicenseAdmin() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListWorkgroupsForSubject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListWorkgroupsForSubject"));
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
        elemField.setFieldName("workgroupPermission");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "workgroupPermission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeMember");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "includeMember"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeLicenseAdmin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "includeLicenseAdmin"));
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
