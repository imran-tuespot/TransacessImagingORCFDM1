/**
 * EditHistoryDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class EditHistoryDTO  implements java.io.Serializable {
    private int reviewID;

    private int documentID;

    private int editId;

    private int editVersionId;

    private java.lang.String title;

    private int version;

    private java.util.Calendar updateDate;

    private int modificationCount;

    private java.lang.String status;

    private com.peniel.tara.SubjectDTO subjectDTO;

    private com.peniel.tara.SubjectDTO lastUpdatedBySubjectDTO;

    public EditHistoryDTO() {
    }

    public EditHistoryDTO(
           int reviewID,
           int documentID,
           int editId,
           int editVersionId,
           java.lang.String title,
           int version,
           java.util.Calendar updateDate,
           int modificationCount,
           java.lang.String status,
           com.peniel.tara.SubjectDTO subjectDTO,
           com.peniel.tara.SubjectDTO lastUpdatedBySubjectDTO) {
           this.reviewID = reviewID;
           this.documentID = documentID;
           this.editId = editId;
           this.editVersionId = editVersionId;
           this.title = title;
           this.version = version;
           this.updateDate = updateDate;
           this.modificationCount = modificationCount;
           this.status = status;
           this.subjectDTO = subjectDTO;
           this.lastUpdatedBySubjectDTO = lastUpdatedBySubjectDTO;
    }


    /**
     * Gets the reviewID value for this EditHistoryDTO.
     * 
     * @return reviewID
     */
    public int getReviewID() {
        return reviewID;
    }


    /**
     * Sets the reviewID value for this EditHistoryDTO.
     * 
     * @param reviewID
     */
    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }


    /**
     * Gets the documentID value for this EditHistoryDTO.
     * 
     * @return documentID
     */
    public int getDocumentID() {
        return documentID;
    }


    /**
     * Sets the documentID value for this EditHistoryDTO.
     * 
     * @param documentID
     */
    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }


    /**
     * Gets the editId value for this EditHistoryDTO.
     * 
     * @return editId
     */
    public int getEditId() {
        return editId;
    }


    /**
     * Sets the editId value for this EditHistoryDTO.
     * 
     * @param editId
     */
    public void setEditId(int editId) {
        this.editId = editId;
    }


    /**
     * Gets the editVersionId value for this EditHistoryDTO.
     * 
     * @return editVersionId
     */
    public int getEditVersionId() {
        return editVersionId;
    }


    /**
     * Sets the editVersionId value for this EditHistoryDTO.
     * 
     * @param editVersionId
     */
    public void setEditVersionId(int editVersionId) {
        this.editVersionId = editVersionId;
    }


    /**
     * Gets the title value for this EditHistoryDTO.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this EditHistoryDTO.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the version value for this EditHistoryDTO.
     * 
     * @return version
     */
    public int getVersion() {
        return version;
    }


    /**
     * Sets the version value for this EditHistoryDTO.
     * 
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }


    /**
     * Gets the updateDate value for this EditHistoryDTO.
     * 
     * @return updateDate
     */
    public java.util.Calendar getUpdateDate() {
        return updateDate;
    }


    /**
     * Sets the updateDate value for this EditHistoryDTO.
     * 
     * @param updateDate
     */
    public void setUpdateDate(java.util.Calendar updateDate) {
        this.updateDate = updateDate;
    }


    /**
     * Gets the modificationCount value for this EditHistoryDTO.
     * 
     * @return modificationCount
     */
    public int getModificationCount() {
        return modificationCount;
    }


    /**
     * Sets the modificationCount value for this EditHistoryDTO.
     * 
     * @param modificationCount
     */
    public void setModificationCount(int modificationCount) {
        this.modificationCount = modificationCount;
    }


    /**
     * Gets the status value for this EditHistoryDTO.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this EditHistoryDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the subjectDTO value for this EditHistoryDTO.
     * 
     * @return subjectDTO
     */
    public com.peniel.tara.SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }


    /**
     * Sets the subjectDTO value for this EditHistoryDTO.
     * 
     * @param subjectDTO
     */
    public void setSubjectDTO(com.peniel.tara.SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }


    /**
     * Gets the lastUpdatedBySubjectDTO value for this EditHistoryDTO.
     * 
     * @return lastUpdatedBySubjectDTO
     */
    public com.peniel.tara.SubjectDTO getLastUpdatedBySubjectDTO() {
        return lastUpdatedBySubjectDTO;
    }


    /**
     * Sets the lastUpdatedBySubjectDTO value for this EditHistoryDTO.
     * 
     * @param lastUpdatedBySubjectDTO
     */
    public void setLastUpdatedBySubjectDTO(com.peniel.tara.SubjectDTO lastUpdatedBySubjectDTO) {
        this.lastUpdatedBySubjectDTO = lastUpdatedBySubjectDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EditHistoryDTO)) return false;
        EditHistoryDTO other = (EditHistoryDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.reviewID == other.getReviewID() &&
            this.documentID == other.getDocumentID() &&
            this.editId == other.getEditId() &&
            this.editVersionId == other.getEditVersionId() &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            this.version == other.getVersion() &&
            ((this.updateDate==null && other.getUpdateDate()==null) || 
             (this.updateDate!=null &&
              this.updateDate.equals(other.getUpdateDate()))) &&
            this.modificationCount == other.getModificationCount() &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.subjectDTO==null && other.getSubjectDTO()==null) || 
             (this.subjectDTO!=null &&
              this.subjectDTO.equals(other.getSubjectDTO()))) &&
            ((this.lastUpdatedBySubjectDTO==null && other.getLastUpdatedBySubjectDTO()==null) || 
             (this.lastUpdatedBySubjectDTO!=null &&
              this.lastUpdatedBySubjectDTO.equals(other.getLastUpdatedBySubjectDTO())));
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
        _hashCode += getReviewID();
        _hashCode += getDocumentID();
        _hashCode += getEditId();
        _hashCode += getEditVersionId();
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        _hashCode += getVersion();
        if (getUpdateDate() != null) {
            _hashCode += getUpdateDate().hashCode();
        }
        _hashCode += getModificationCount();
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getSubjectDTO() != null) {
            _hashCode += getSubjectDTO().hashCode();
        }
        if (getLastUpdatedBySubjectDTO() != null) {
            _hashCode += getLastUpdatedBySubjectDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EditHistoryDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditHistoryDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editVersionId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditVersionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UpdateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modificationCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ModificationCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("subjectDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastUpdatedBySubjectDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LastUpdatedBySubjectDTO"));
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
