/**
 * SubjectInWorkgroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SubjectInWorkgroup  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.SubjectDTO subjectDto;

    private int workgroupid;

    public SubjectInWorkgroup() {
    }

    public SubjectInWorkgroup(
           java.lang.String loginContextId,
           com.peniel.tara.SubjectDTO subjectDto,
           int workgroupid) {
           this.loginContextId = loginContextId;
           this.subjectDto = subjectDto;
           this.workgroupid = workgroupid;
    }


    /**
     * Gets the loginContextId value for this SubjectInWorkgroup.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this SubjectInWorkgroup.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the subjectDto value for this SubjectInWorkgroup.
     * 
     * @return subjectDto
     */
    public com.peniel.tara.SubjectDTO getSubjectDto() {
        return subjectDto;
    }


    /**
     * Sets the subjectDto value for this SubjectInWorkgroup.
     * 
     * @param subjectDto
     */
    public void setSubjectDto(com.peniel.tara.SubjectDTO subjectDto) {
        this.subjectDto = subjectDto;
    }


    /**
     * Gets the workgroupid value for this SubjectInWorkgroup.
     * 
     * @return workgroupid
     */
    public int getWorkgroupid() {
        return workgroupid;
    }


    /**
     * Sets the workgroupid value for this SubjectInWorkgroup.
     * 
     * @param workgroupid
     */
    public void setWorkgroupid(int workgroupid) {
        this.workgroupid = workgroupid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubjectInWorkgroup)) return false;
        SubjectInWorkgroup other = (SubjectInWorkgroup) obj;
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
            ((this.subjectDto==null && other.getSubjectDto()==null) || 
             (this.subjectDto!=null &&
              this.subjectDto.equals(other.getSubjectDto()))) &&
            this.workgroupid == other.getWorkgroupid();
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
        if (getSubjectDto() != null) {
            _hashCode += getSubjectDto().hashCode();
        }
        _hashCode += getWorkgroupid();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubjectInWorkgroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">SubjectInWorkgroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "workgroupid"));
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