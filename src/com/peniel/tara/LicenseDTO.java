/**
 * LicenseDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class LicenseDTO  implements java.io.Serializable {
    private int objectId;

    private java.lang.String customerName;

    private int ownerId;

    private java.util.Calendar endDate;

    private boolean evaluation;

    private java.lang.String evaluationMessage;

    private int maxUsers;

    private java.lang.String licenseXml;

    private com.peniel.tara.SubjectDTO ownerSubjectDTO;

    private java.util.Calendar gracePeriodStartDate;

    public LicenseDTO() {
    }

    public LicenseDTO(
           int objectId,
           java.lang.String customerName,
           int ownerId,
           java.util.Calendar endDate,
           boolean evaluation,
           java.lang.String evaluationMessage,
           int maxUsers,
           java.lang.String licenseXml,
           com.peniel.tara.SubjectDTO ownerSubjectDTO,
           java.util.Calendar gracePeriodStartDate) {
           this.objectId = objectId;
           this.customerName = customerName;
           this.ownerId = ownerId;
           this.endDate = endDate;
           this.evaluation = evaluation;
           this.evaluationMessage = evaluationMessage;
           this.maxUsers = maxUsers;
           this.licenseXml = licenseXml;
           this.ownerSubjectDTO = ownerSubjectDTO;
           this.gracePeriodStartDate = gracePeriodStartDate;
    }


    /**
     * Gets the objectId value for this LicenseDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this LicenseDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the customerName value for this LicenseDTO.
     * 
     * @return customerName
     */
    public java.lang.String getCustomerName() {
        return customerName;
    }


    /**
     * Sets the customerName value for this LicenseDTO.
     * 
     * @param customerName
     */
    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }


    /**
     * Gets the ownerId value for this LicenseDTO.
     * 
     * @return ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }


    /**
     * Sets the ownerId value for this LicenseDTO.
     * 
     * @param ownerId
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }


    /**
     * Gets the endDate value for this LicenseDTO.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this LicenseDTO.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the evaluation value for this LicenseDTO.
     * 
     * @return evaluation
     */
    public boolean isEvaluation() {
        return evaluation;
    }


    /**
     * Sets the evaluation value for this LicenseDTO.
     * 
     * @param evaluation
     */
    public void setEvaluation(boolean evaluation) {
        this.evaluation = evaluation;
    }


    /**
     * Gets the evaluationMessage value for this LicenseDTO.
     * 
     * @return evaluationMessage
     */
    public java.lang.String getEvaluationMessage() {
        return evaluationMessage;
    }


    /**
     * Sets the evaluationMessage value for this LicenseDTO.
     * 
     * @param evaluationMessage
     */
    public void setEvaluationMessage(java.lang.String evaluationMessage) {
        this.evaluationMessage = evaluationMessage;
    }


    /**
     * Gets the maxUsers value for this LicenseDTO.
     * 
     * @return maxUsers
     */
    public int getMaxUsers() {
        return maxUsers;
    }


    /**
     * Sets the maxUsers value for this LicenseDTO.
     * 
     * @param maxUsers
     */
    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }


    /**
     * Gets the licenseXml value for this LicenseDTO.
     * 
     * @return licenseXml
     */
    public java.lang.String getLicenseXml() {
        return licenseXml;
    }


    /**
     * Sets the licenseXml value for this LicenseDTO.
     * 
     * @param licenseXml
     */
    public void setLicenseXml(java.lang.String licenseXml) {
        this.licenseXml = licenseXml;
    }


    /**
     * Gets the ownerSubjectDTO value for this LicenseDTO.
     * 
     * @return ownerSubjectDTO
     */
    public com.peniel.tara.SubjectDTO getOwnerSubjectDTO() {
        return ownerSubjectDTO;
    }


    /**
     * Sets the ownerSubjectDTO value for this LicenseDTO.
     * 
     * @param ownerSubjectDTO
     */
    public void setOwnerSubjectDTO(com.peniel.tara.SubjectDTO ownerSubjectDTO) {
        this.ownerSubjectDTO = ownerSubjectDTO;
    }


    /**
     * Gets the gracePeriodStartDate value for this LicenseDTO.
     * 
     * @return gracePeriodStartDate
     */
    public java.util.Calendar getGracePeriodStartDate() {
        return gracePeriodStartDate;
    }


    /**
     * Sets the gracePeriodStartDate value for this LicenseDTO.
     * 
     * @param gracePeriodStartDate
     */
    public void setGracePeriodStartDate(java.util.Calendar gracePeriodStartDate) {
        this.gracePeriodStartDate = gracePeriodStartDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LicenseDTO)) return false;
        LicenseDTO other = (LicenseDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            ((this.customerName==null && other.getCustomerName()==null) || 
             (this.customerName!=null &&
              this.customerName.equals(other.getCustomerName()))) &&
            this.ownerId == other.getOwnerId() &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            this.evaluation == other.isEvaluation() &&
            ((this.evaluationMessage==null && other.getEvaluationMessage()==null) || 
             (this.evaluationMessage!=null &&
              this.evaluationMessage.equals(other.getEvaluationMessage()))) &&
            this.maxUsers == other.getMaxUsers() &&
            ((this.licenseXml==null && other.getLicenseXml()==null) || 
             (this.licenseXml!=null &&
              this.licenseXml.equals(other.getLicenseXml()))) &&
            ((this.ownerSubjectDTO==null && other.getOwnerSubjectDTO()==null) || 
             (this.ownerSubjectDTO!=null &&
              this.ownerSubjectDTO.equals(other.getOwnerSubjectDTO()))) &&
            ((this.gracePeriodStartDate==null && other.getGracePeriodStartDate()==null) || 
             (this.gracePeriodStartDate!=null &&
              this.gracePeriodStartDate.equals(other.getGracePeriodStartDate())));
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
        if (getCustomerName() != null) {
            _hashCode += getCustomerName().hashCode();
        }
        _hashCode += getOwnerId();
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        _hashCode += (isEvaluation() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getEvaluationMessage() != null) {
            _hashCode += getEvaluationMessage().hashCode();
        }
        _hashCode += getMaxUsers();
        if (getLicenseXml() != null) {
            _hashCode += getLicenseXml().hashCode();
        }
        if (getOwnerSubjectDTO() != null) {
            _hashCode += getOwnerSubjectDTO().hashCode();
        }
        if (getGracePeriodStartDate() != null) {
            _hashCode += getGracePeriodStartDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LicenseDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LicenseDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CustomerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OwnerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evaluation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Evaluation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evaluationMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EvaluationMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxUsers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "MaxUsers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseXml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LicenseXml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerSubjectDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OwnerSubjectDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gracePeriodStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GracePeriodStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
