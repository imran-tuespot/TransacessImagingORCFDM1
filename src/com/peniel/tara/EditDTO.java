/**
 * EditDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class EditDTO  implements java.io.Serializable {
    private int objectId;

    private int reviewId;

    private int documentId;

    private int subjectId;

    private com.peniel.tara.SubjectDTO subjectDTO;

    private java.lang.String startParagraphId;

    private java.lang.String endParagraphId;

    private java.lang.String title;

    private java.lang.String description;

    private java.lang.String status;

    private java.lang.String subSectionStartParagraphId;

    private java.lang.String subSectionEndParagraphId;

    private java.lang.String permissionFlags;

    private java.lang.String zoneType;

    private java.util.Calendar updateDate;

    private boolean readOnly;

    public EditDTO() {
    }

    public EditDTO(
           int objectId,
           int reviewId,
           int documentId,
           int subjectId,
           com.peniel.tara.SubjectDTO subjectDTO,
           java.lang.String startParagraphId,
           java.lang.String endParagraphId,
           java.lang.String title,
           java.lang.String description,
           java.lang.String status,
           java.lang.String subSectionStartParagraphId,
           java.lang.String subSectionEndParagraphId,
           java.lang.String permissionFlags,
           java.lang.String zoneType,
           java.util.Calendar updateDate,
           boolean readOnly) {
           this.objectId = objectId;
           this.reviewId = reviewId;
           this.documentId = documentId;
           this.subjectId = subjectId;
           this.subjectDTO = subjectDTO;
           this.startParagraphId = startParagraphId;
           this.endParagraphId = endParagraphId;
           this.title = title;
           this.description = description;
           this.status = status;
           this.subSectionStartParagraphId = subSectionStartParagraphId;
           this.subSectionEndParagraphId = subSectionEndParagraphId;
           this.permissionFlags = permissionFlags;
           this.zoneType = zoneType;
           this.updateDate = updateDate;
           this.readOnly = readOnly;
    }


    /**
     * Gets the objectId value for this EditDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this EditDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the reviewId value for this EditDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this EditDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the documentId value for this EditDTO.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this EditDTO.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the subjectId value for this EditDTO.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this EditDTO.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the subjectDTO value for this EditDTO.
     * 
     * @return subjectDTO
     */
    public com.peniel.tara.SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }


    /**
     * Sets the subjectDTO value for this EditDTO.
     * 
     * @param subjectDTO
     */
    public void setSubjectDTO(com.peniel.tara.SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }


    /**
     * Gets the startParagraphId value for this EditDTO.
     * 
     * @return startParagraphId
     */
    public java.lang.String getStartParagraphId() {
        return startParagraphId;
    }


    /**
     * Sets the startParagraphId value for this EditDTO.
     * 
     * @param startParagraphId
     */
    public void setStartParagraphId(java.lang.String startParagraphId) {
        this.startParagraphId = startParagraphId;
    }


    /**
     * Gets the endParagraphId value for this EditDTO.
     * 
     * @return endParagraphId
     */
    public java.lang.String getEndParagraphId() {
        return endParagraphId;
    }


    /**
     * Sets the endParagraphId value for this EditDTO.
     * 
     * @param endParagraphId
     */
    public void setEndParagraphId(java.lang.String endParagraphId) {
        this.endParagraphId = endParagraphId;
    }


    /**
     * Gets the title value for this EditDTO.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this EditDTO.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the description value for this EditDTO.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this EditDTO.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the status value for this EditDTO.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this EditDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the subSectionStartParagraphId value for this EditDTO.
     * 
     * @return subSectionStartParagraphId
     */
    public java.lang.String getSubSectionStartParagraphId() {
        return subSectionStartParagraphId;
    }


    /**
     * Sets the subSectionStartParagraphId value for this EditDTO.
     * 
     * @param subSectionStartParagraphId
     */
    public void setSubSectionStartParagraphId(java.lang.String subSectionStartParagraphId) {
        this.subSectionStartParagraphId = subSectionStartParagraphId;
    }


    /**
     * Gets the subSectionEndParagraphId value for this EditDTO.
     * 
     * @return subSectionEndParagraphId
     */
    public java.lang.String getSubSectionEndParagraphId() {
        return subSectionEndParagraphId;
    }


    /**
     * Sets the subSectionEndParagraphId value for this EditDTO.
     * 
     * @param subSectionEndParagraphId
     */
    public void setSubSectionEndParagraphId(java.lang.String subSectionEndParagraphId) {
        this.subSectionEndParagraphId = subSectionEndParagraphId;
    }


    /**
     * Gets the permissionFlags value for this EditDTO.
     * 
     * @return permissionFlags
     */
    public java.lang.String getPermissionFlags() {
        return permissionFlags;
    }


    /**
     * Sets the permissionFlags value for this EditDTO.
     * 
     * @param permissionFlags
     */
    public void setPermissionFlags(java.lang.String permissionFlags) {
        this.permissionFlags = permissionFlags;
    }


    /**
     * Gets the zoneType value for this EditDTO.
     * 
     * @return zoneType
     */
    public java.lang.String getZoneType() {
        return zoneType;
    }


    /**
     * Sets the zoneType value for this EditDTO.
     * 
     * @param zoneType
     */
    public void setZoneType(java.lang.String zoneType) {
        this.zoneType = zoneType;
    }


    /**
     * Gets the updateDate value for this EditDTO.
     * 
     * @return updateDate
     */
    public java.util.Calendar getUpdateDate() {
        return updateDate;
    }


    /**
     * Sets the updateDate value for this EditDTO.
     * 
     * @param updateDate
     */
    public void setUpdateDate(java.util.Calendar updateDate) {
        this.updateDate = updateDate;
    }


    /**
     * Gets the readOnly value for this EditDTO.
     * 
     * @return readOnly
     */
    public boolean isReadOnly() {
        return readOnly;
    }


    /**
     * Sets the readOnly value for this EditDTO.
     * 
     * @param readOnly
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EditDTO)) return false;
        EditDTO other = (EditDTO) obj;
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
            this.documentId == other.getDocumentId() &&
            this.subjectId == other.getSubjectId() &&
            ((this.subjectDTO==null && other.getSubjectDTO()==null) || 
             (this.subjectDTO!=null &&
              this.subjectDTO.equals(other.getSubjectDTO()))) &&
            ((this.startParagraphId==null && other.getStartParagraphId()==null) || 
             (this.startParagraphId!=null &&
              this.startParagraphId.equals(other.getStartParagraphId()))) &&
            ((this.endParagraphId==null && other.getEndParagraphId()==null) || 
             (this.endParagraphId!=null &&
              this.endParagraphId.equals(other.getEndParagraphId()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.subSectionStartParagraphId==null && other.getSubSectionStartParagraphId()==null) || 
             (this.subSectionStartParagraphId!=null &&
              this.subSectionStartParagraphId.equals(other.getSubSectionStartParagraphId()))) &&
            ((this.subSectionEndParagraphId==null && other.getSubSectionEndParagraphId()==null) || 
             (this.subSectionEndParagraphId!=null &&
              this.subSectionEndParagraphId.equals(other.getSubSectionEndParagraphId()))) &&
            ((this.permissionFlags==null && other.getPermissionFlags()==null) || 
             (this.permissionFlags!=null &&
              this.permissionFlags.equals(other.getPermissionFlags()))) &&
            ((this.zoneType==null && other.getZoneType()==null) || 
             (this.zoneType!=null &&
              this.zoneType.equals(other.getZoneType()))) &&
            ((this.updateDate==null && other.getUpdateDate()==null) || 
             (this.updateDate!=null &&
              this.updateDate.equals(other.getUpdateDate()))) &&
            this.readOnly == other.isReadOnly();
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
        _hashCode += getDocumentId();
        _hashCode += getSubjectId();
        if (getSubjectDTO() != null) {
            _hashCode += getSubjectDTO().hashCode();
        }
        if (getStartParagraphId() != null) {
            _hashCode += getStartParagraphId().hashCode();
        }
        if (getEndParagraphId() != null) {
            _hashCode += getEndParagraphId().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getSubSectionStartParagraphId() != null) {
            _hashCode += getSubSectionStartParagraphId().hashCode();
        }
        if (getSubSectionEndParagraphId() != null) {
            _hashCode += getSubSectionEndParagraphId().hashCode();
        }
        if (getPermissionFlags() != null) {
            _hashCode += getPermissionFlags().hashCode();
        }
        if (getZoneType() != null) {
            _hashCode += getZoneType().hashCode();
        }
        if (getUpdateDate() != null) {
            _hashCode += getUpdateDate().hashCode();
        }
        _hashCode += (isReadOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EditDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditDTO"));
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
        elemField.setFieldName("documentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentId"));
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
        elemField.setFieldName("subjectDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startParagraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "StartParagraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endParagraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EndParagraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Title"));
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
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subSectionStartParagraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subSectionStartParagraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subSectionEndParagraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subSectionEndParagraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permissionFlags");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "PermissionFlags"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zoneType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ZoneType"));
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
        elemField.setFieldName("readOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReadOnly"));
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
