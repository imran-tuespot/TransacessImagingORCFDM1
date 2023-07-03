/**
 * WorkgroupMemberDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class WorkgroupMemberDTO  implements java.io.Serializable {
    private int objectId;

    private int workgroupId;

    private java.lang.String workgroupRole;

    private java.lang.String composeRole;

    private int subjectId;

    private com.peniel.tara.SubjectDTO subjectDTO;

    public WorkgroupMemberDTO() {
    }

    public WorkgroupMemberDTO(
           int objectId,
           int workgroupId,
           java.lang.String workgroupRole,
           java.lang.String composeRole,
           int subjectId,
           com.peniel.tara.SubjectDTO subjectDTO) {
           this.objectId = objectId;
           this.workgroupId = workgroupId;
           this.workgroupRole = workgroupRole;
           this.composeRole = composeRole;
           this.subjectId = subjectId;
           this.subjectDTO = subjectDTO;
    }


    /**
     * Gets the objectId value for this WorkgroupMemberDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this WorkgroupMemberDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the workgroupId value for this WorkgroupMemberDTO.
     * 
     * @return workgroupId
     */
    public int getWorkgroupId() {
        return workgroupId;
    }


    /**
     * Sets the workgroupId value for this WorkgroupMemberDTO.
     * 
     * @param workgroupId
     */
    public void setWorkgroupId(int workgroupId) {
        this.workgroupId = workgroupId;
    }


    /**
     * Gets the workgroupRole value for this WorkgroupMemberDTO.
     * 
     * @return workgroupRole
     */
    public java.lang.String getWorkgroupRole() {
        return workgroupRole;
    }


    /**
     * Sets the workgroupRole value for this WorkgroupMemberDTO.
     * 
     * @param workgroupRole
     */
    public void setWorkgroupRole(java.lang.String workgroupRole) {
        this.workgroupRole = workgroupRole;
    }


    /**
     * Gets the composeRole value for this WorkgroupMemberDTO.
     * 
     * @return composeRole
     */
    public java.lang.String getComposeRole() {
        return composeRole;
    }


    /**
     * Sets the composeRole value for this WorkgroupMemberDTO.
     * 
     * @param composeRole
     */
    public void setComposeRole(java.lang.String composeRole) {
        this.composeRole = composeRole;
    }


    /**
     * Gets the subjectId value for this WorkgroupMemberDTO.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this WorkgroupMemberDTO.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the subjectDTO value for this WorkgroupMemberDTO.
     * 
     * @return subjectDTO
     */
    public com.peniel.tara.SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }


    /**
     * Sets the subjectDTO value for this WorkgroupMemberDTO.
     * 
     * @param subjectDTO
     */
    public void setSubjectDTO(com.peniel.tara.SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkgroupMemberDTO)) return false;
        WorkgroupMemberDTO other = (WorkgroupMemberDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            this.workgroupId == other.getWorkgroupId() &&
            ((this.workgroupRole==null && other.getWorkgroupRole()==null) || 
             (this.workgroupRole!=null &&
              this.workgroupRole.equals(other.getWorkgroupRole()))) &&
            ((this.composeRole==null && other.getComposeRole()==null) || 
             (this.composeRole!=null &&
              this.composeRole.equals(other.getComposeRole()))) &&
            this.subjectId == other.getSubjectId() &&
            ((this.subjectDTO==null && other.getSubjectDTO()==null) || 
             (this.subjectDTO!=null &&
              this.subjectDTO.equals(other.getSubjectDTO())));
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
        _hashCode += getObjectId();
        _hashCode += getWorkgroupId();
        if (getWorkgroupRole() != null) {
            _hashCode += getWorkgroupRole().hashCode();
        }
        if (getComposeRole() != null) {
            _hashCode += getComposeRole().hashCode();
        }
        _hashCode += getSubjectId();
        if (getSubjectDTO() != null) {
            _hashCode += getSubjectDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WorkgroupMemberDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupMemberDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupRole");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupRole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("composeRole");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ComposeRole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
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
