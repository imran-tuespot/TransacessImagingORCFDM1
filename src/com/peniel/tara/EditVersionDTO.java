/**
 * EditVersionDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class EditVersionDTO  implements java.io.Serializable {
    private int objectId;

    private int editId;

    private int version;

    private java.util.Calendar updateDate;

    private int modificationCount;

    private java.lang.String status;

    private int replaceDocumentId;

    private int uploadedBySubjectId;

    private int lastUpdatedBySubjectId;

    public EditVersionDTO() {
    }

    public EditVersionDTO(
           int objectId,
           int editId,
           int version,
           java.util.Calendar updateDate,
           int modificationCount,
           java.lang.String status,
           int replaceDocumentId,
           int uploadedBySubjectId,
           int lastUpdatedBySubjectId) {
           this.objectId = objectId;
           this.editId = editId;
           this.version = version;
           this.updateDate = updateDate;
           this.modificationCount = modificationCount;
           this.status = status;
           this.replaceDocumentId = replaceDocumentId;
           this.uploadedBySubjectId = uploadedBySubjectId;
           this.lastUpdatedBySubjectId = lastUpdatedBySubjectId;
    }


    /**
     * Gets the objectId value for this EditVersionDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this EditVersionDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the editId value for this EditVersionDTO.
     * 
     * @return editId
     */
    public int getEditId() {
        return editId;
    }


    /**
     * Sets the editId value for this EditVersionDTO.
     * 
     * @param editId
     */
    public void setEditId(int editId) {
        this.editId = editId;
    }


    /**
     * Gets the version value for this EditVersionDTO.
     * 
     * @return version
     */
    public int getVersion() {
        return version;
    }


    /**
     * Sets the version value for this EditVersionDTO.
     * 
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }


    /**
     * Gets the updateDate value for this EditVersionDTO.
     * 
     * @return updateDate
     */
    public java.util.Calendar getUpdateDate() {
        return updateDate;
    }


    /**
     * Sets the updateDate value for this EditVersionDTO.
     * 
     * @param updateDate
     */
    public void setUpdateDate(java.util.Calendar updateDate) {
        this.updateDate = updateDate;
    }


    /**
     * Gets the modificationCount value for this EditVersionDTO.
     * 
     * @return modificationCount
     */
    public int getModificationCount() {
        return modificationCount;
    }


    /**
     * Sets the modificationCount value for this EditVersionDTO.
     * 
     * @param modificationCount
     */
    public void setModificationCount(int modificationCount) {
        this.modificationCount = modificationCount;
    }


    /**
     * Gets the status value for this EditVersionDTO.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this EditVersionDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the replaceDocumentId value for this EditVersionDTO.
     * 
     * @return replaceDocumentId
     */
    public int getReplaceDocumentId() {
        return replaceDocumentId;
    }


    /**
     * Sets the replaceDocumentId value for this EditVersionDTO.
     * 
     * @param replaceDocumentId
     */
    public void setReplaceDocumentId(int replaceDocumentId) {
        this.replaceDocumentId = replaceDocumentId;
    }


    /**
     * Gets the uploadedBySubjectId value for this EditVersionDTO.
     * 
     * @return uploadedBySubjectId
     */
    public int getUploadedBySubjectId() {
        return uploadedBySubjectId;
    }


    /**
     * Sets the uploadedBySubjectId value for this EditVersionDTO.
     * 
     * @param uploadedBySubjectId
     */
    public void setUploadedBySubjectId(int uploadedBySubjectId) {
        this.uploadedBySubjectId = uploadedBySubjectId;
    }


    /**
     * Gets the lastUpdatedBySubjectId value for this EditVersionDTO.
     * 
     * @return lastUpdatedBySubjectId
     */
    public int getLastUpdatedBySubjectId() {
        return lastUpdatedBySubjectId;
    }


    /**
     * Sets the lastUpdatedBySubjectId value for this EditVersionDTO.
     * 
     * @param lastUpdatedBySubjectId
     */
    public void setLastUpdatedBySubjectId(int lastUpdatedBySubjectId) {
        this.lastUpdatedBySubjectId = lastUpdatedBySubjectId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EditVersionDTO)) return false;
        EditVersionDTO other = (EditVersionDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            this.editId == other.getEditId() &&
            this.version == other.getVersion() &&
            ((this.updateDate==null && other.getUpdateDate()==null) || 
             (this.updateDate!=null &&
              this.updateDate.equals(other.getUpdateDate()))) &&
            this.modificationCount == other.getModificationCount() &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            this.replaceDocumentId == other.getReplaceDocumentId() &&
            this.uploadedBySubjectId == other.getUploadedBySubjectId() &&
            this.lastUpdatedBySubjectId == other.getLastUpdatedBySubjectId();
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
        _hashCode += getEditId();
        _hashCode += getVersion();
        if (getUpdateDate() != null) {
            _hashCode += getUpdateDate().hashCode();
        }
        _hashCode += getModificationCount();
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        _hashCode += getReplaceDocumentId();
        _hashCode += getUploadedBySubjectId();
        _hashCode += getLastUpdatedBySubjectId();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EditVersionDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditVersionDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
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
        elemField.setFieldName("replaceDocumentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReplaceDocumentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uploadedBySubjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UploadedBySubjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastUpdatedBySubjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LastUpdatedBySubjectId"));
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
