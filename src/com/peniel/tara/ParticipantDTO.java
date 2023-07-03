/**
 * ParticipantDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ParticipantDTO  implements java.io.Serializable {
    private int objectId;

    private int reviewId;

    private int subjectId;

    private java.lang.String role;

    private java.lang.String status;

    private java.lang.String description;

    private java.lang.String summary;

    private java.util.Calendar updateDate;

    private com.peniel.tara.ReviewDTO reviewDTO;

    private com.peniel.tara.SubjectDTO subjectDTO;

    private int reviewTime;

    private boolean watch;

    private int statusSequence;

    private java.lang.String reviewZoneRole;

    private int delegatedBy;

    private boolean managerDelegator;

    public ParticipantDTO() {
    }

    public ParticipantDTO(
           int objectId,
           int reviewId,
           int subjectId,
           java.lang.String role,
           java.lang.String status,
           java.lang.String description,
           java.lang.String summary,
           java.util.Calendar updateDate,
           com.peniel.tara.ReviewDTO reviewDTO,
           com.peniel.tara.SubjectDTO subjectDTO,
           int reviewTime,
           boolean watch,
           int statusSequence,
           java.lang.String reviewZoneRole,
           int delegatedBy,
           boolean managerDelegator) {
           this.objectId = objectId;
           this.reviewId = reviewId;
           this.subjectId = subjectId;
           this.role = role;
           this.status = status;
           this.description = description;
           this.summary = summary;
           this.updateDate = updateDate;
           this.reviewDTO = reviewDTO;
           this.subjectDTO = subjectDTO;
           this.reviewTime = reviewTime;
           this.watch = watch;
           this.statusSequence = statusSequence;
           this.reviewZoneRole = reviewZoneRole;
           this.delegatedBy = delegatedBy;
           this.managerDelegator = managerDelegator;
    }


    /**
     * Gets the objectId value for this ParticipantDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this ParticipantDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the reviewId value for this ParticipantDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this ParticipantDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the subjectId value for this ParticipantDTO.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this ParticipantDTO.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the role value for this ParticipantDTO.
     * 
     * @return role
     */
    public java.lang.String getRole() {
        return role;
    }


    /**
     * Sets the role value for this ParticipantDTO.
     * 
     * @param role
     */
    public void setRole(java.lang.String role) {
        this.role = role;
    }


    /**
     * Gets the status value for this ParticipantDTO.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ParticipantDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the description value for this ParticipantDTO.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ParticipantDTO.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the summary value for this ParticipantDTO.
     * 
     * @return summary
     */
    public java.lang.String getSummary() {
        return summary;
    }


    /**
     * Sets the summary value for this ParticipantDTO.
     * 
     * @param summary
     */
    public void setSummary(java.lang.String summary) {
        this.summary = summary;
    }


    /**
     * Gets the updateDate value for this ParticipantDTO.
     * 
     * @return updateDate
     */
    public java.util.Calendar getUpdateDate() {
        return updateDate;
    }


    /**
     * Sets the updateDate value for this ParticipantDTO.
     * 
     * @param updateDate
     */
    public void setUpdateDate(java.util.Calendar updateDate) {
        this.updateDate = updateDate;
    }


    /**
     * Gets the reviewDTO value for this ParticipantDTO.
     * 
     * @return reviewDTO
     */
    public com.peniel.tara.ReviewDTO getReviewDTO() {
        return reviewDTO;
    }


    /**
     * Sets the reviewDTO value for this ParticipantDTO.
     * 
     * @param reviewDTO
     */
    public void setReviewDTO(com.peniel.tara.ReviewDTO reviewDTO) {
        this.reviewDTO = reviewDTO;
    }


    /**
     * Gets the subjectDTO value for this ParticipantDTO.
     * 
     * @return subjectDTO
     */
    public com.peniel.tara.SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }


    /**
     * Sets the subjectDTO value for this ParticipantDTO.
     * 
     * @param subjectDTO
     */
    public void setSubjectDTO(com.peniel.tara.SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }


    /**
     * Gets the reviewTime value for this ParticipantDTO.
     * 
     * @return reviewTime
     */
    public int getReviewTime() {
        return reviewTime;
    }


    /**
     * Sets the reviewTime value for this ParticipantDTO.
     * 
     * @param reviewTime
     */
    public void setReviewTime(int reviewTime) {
        this.reviewTime = reviewTime;
    }


    /**
     * Gets the watch value for this ParticipantDTO.
     * 
     * @return watch
     */
    public boolean isWatch() {
        return watch;
    }


    /**
     * Sets the watch value for this ParticipantDTO.
     * 
     * @param watch
     */
    public void setWatch(boolean watch) {
        this.watch = watch;
    }


    /**
     * Gets the statusSequence value for this ParticipantDTO.
     * 
     * @return statusSequence
     */
    public int getStatusSequence() {
        return statusSequence;
    }


    /**
     * Sets the statusSequence value for this ParticipantDTO.
     * 
     * @param statusSequence
     */
    public void setStatusSequence(int statusSequence) {
        this.statusSequence = statusSequence;
    }


    /**
     * Gets the reviewZoneRole value for this ParticipantDTO.
     * 
     * @return reviewZoneRole
     */
    public java.lang.String getReviewZoneRole() {
        return reviewZoneRole;
    }


    /**
     * Sets the reviewZoneRole value for this ParticipantDTO.
     * 
     * @param reviewZoneRole
     */
    public void setReviewZoneRole(java.lang.String reviewZoneRole) {
        this.reviewZoneRole = reviewZoneRole;
    }


    /**
     * Gets the delegatedBy value for this ParticipantDTO.
     * 
     * @return delegatedBy
     */
    public int getDelegatedBy() {
        return delegatedBy;
    }


    /**
     * Sets the delegatedBy value for this ParticipantDTO.
     * 
     * @param delegatedBy
     */
    public void setDelegatedBy(int delegatedBy) {
        this.delegatedBy = delegatedBy;
    }


    /**
     * Gets the managerDelegator value for this ParticipantDTO.
     * 
     * @return managerDelegator
     */
    public boolean isManagerDelegator() {
        return managerDelegator;
    }


    /**
     * Sets the managerDelegator value for this ParticipantDTO.
     * 
     * @param managerDelegator
     */
    public void setManagerDelegator(boolean managerDelegator) {
        this.managerDelegator = managerDelegator;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParticipantDTO)) return false;
        ParticipantDTO other = (ParticipantDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            this.reviewId == other.getReviewId() &&
            this.subjectId == other.getSubjectId() &&
            ((this.role==null && other.getRole()==null) || 
             (this.role!=null &&
              this.role.equals(other.getRole()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.summary==null && other.getSummary()==null) || 
             (this.summary!=null &&
              this.summary.equals(other.getSummary()))) &&
            ((this.updateDate==null && other.getUpdateDate()==null) || 
             (this.updateDate!=null &&
              this.updateDate.equals(other.getUpdateDate()))) &&
            ((this.reviewDTO==null && other.getReviewDTO()==null) || 
             (this.reviewDTO!=null &&
              this.reviewDTO.equals(other.getReviewDTO()))) &&
            ((this.subjectDTO==null && other.getSubjectDTO()==null) || 
             (this.subjectDTO!=null &&
              this.subjectDTO.equals(other.getSubjectDTO()))) &&
            this.reviewTime == other.getReviewTime() &&
            this.watch == other.isWatch() &&
            this.statusSequence == other.getStatusSequence() &&
            ((this.reviewZoneRole==null && other.getReviewZoneRole()==null) || 
             (this.reviewZoneRole!=null &&
              this.reviewZoneRole.equals(other.getReviewZoneRole()))) &&
            this.delegatedBy == other.getDelegatedBy() &&
            this.managerDelegator == other.isManagerDelegator();
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
        _hashCode += getReviewId();
        _hashCode += getSubjectId();
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getSummary() != null) {
            _hashCode += getSummary().hashCode();
        }
        if (getUpdateDate() != null) {
            _hashCode += getUpdateDate().hashCode();
        }
        if (getReviewDTO() != null) {
            _hashCode += getReviewDTO().hashCode();
        }
        if (getSubjectDTO() != null) {
            _hashCode += getSubjectDTO().hashCode();
        }
        _hashCode += getReviewTime();
        _hashCode += (isWatch() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getStatusSequence();
        if (getReviewZoneRole() != null) {
            _hashCode += getReviewZoneRole().hashCode();
        }
        _hashCode += getDelegatedBy();
        _hashCode += (isManagerDelegator() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParticipantDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParticipantDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Role"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summary");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Summary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UpdateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("watch");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Watch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusSequence");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "StatusSequence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewZoneRole");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewZoneRole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delegatedBy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DelegatedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("managerDelegator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ManagerDelegator"));
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
