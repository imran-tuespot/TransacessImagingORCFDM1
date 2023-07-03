/**
 * WorkgroupDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class WorkgroupDTO  implements java.io.Serializable {
    private java.lang.String workgroupName;

    private java.lang.String descriptionNote;

    private int objectId;

    private int licenseId;

    private java.lang.String extSource;

    private java.lang.String extRef;

    private boolean isTaskgroup;

    private boolean isPublic;

    private boolean isAllMonitor;

    public WorkgroupDTO() {
    }

    public WorkgroupDTO(
           java.lang.String workgroupName,
           java.lang.String descriptionNote,
           int objectId,
           int licenseId,
           java.lang.String extSource,
           java.lang.String extRef,
           boolean isTaskgroup,
           boolean isPublic,
           boolean isAllMonitor) {
           this.workgroupName = workgroupName;
           this.descriptionNote = descriptionNote;
           this.objectId = objectId;
           this.licenseId = licenseId;
           this.extSource = extSource;
           this.extRef = extRef;
           this.isTaskgroup = isTaskgroup;
           this.isPublic = isPublic;
           this.isAllMonitor = isAllMonitor;
    }


    /**
     * Gets the workgroupName value for this WorkgroupDTO.
     * 
     * @return workgroupName
     */
    public java.lang.String getWorkgroupName() {
        return workgroupName;
    }


    /**
     * Sets the workgroupName value for this WorkgroupDTO.
     * 
     * @param workgroupName
     */
    public void setWorkgroupName(java.lang.String workgroupName) {
        this.workgroupName = workgroupName;
    }


    /**
     * Gets the descriptionNote value for this WorkgroupDTO.
     * 
     * @return descriptionNote
     */
    public java.lang.String getDescriptionNote() {
        return descriptionNote;
    }


    /**
     * Sets the descriptionNote value for this WorkgroupDTO.
     * 
     * @param descriptionNote
     */
    public void setDescriptionNote(java.lang.String descriptionNote) {
        this.descriptionNote = descriptionNote;
    }


    /**
     * Gets the objectId value for this WorkgroupDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this WorkgroupDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the licenseId value for this WorkgroupDTO.
     * 
     * @return licenseId
     */
    public int getLicenseId() {
        return licenseId;
    }


    /**
     * Sets the licenseId value for this WorkgroupDTO.
     * 
     * @param licenseId
     */
    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }


    /**
     * Gets the extSource value for this WorkgroupDTO.
     * 
     * @return extSource
     */
    public java.lang.String getExtSource() {
        return extSource;
    }


    /**
     * Sets the extSource value for this WorkgroupDTO.
     * 
     * @param extSource
     */
    public void setExtSource(java.lang.String extSource) {
        this.extSource = extSource;
    }


    /**
     * Gets the extRef value for this WorkgroupDTO.
     * 
     * @return extRef
     */
    public java.lang.String getExtRef() {
        return extRef;
    }


    /**
     * Sets the extRef value for this WorkgroupDTO.
     * 
     * @param extRef
     */
    public void setExtRef(java.lang.String extRef) {
        this.extRef = extRef;
    }


    /**
     * Gets the isTaskgroup value for this WorkgroupDTO.
     * 
     * @return isTaskgroup
     */
    public boolean isIsTaskgroup() {
        return isTaskgroup;
    }


    /**
     * Sets the isTaskgroup value for this WorkgroupDTO.
     * 
     * @param isTaskgroup
     */
    public void setIsTaskgroup(boolean isTaskgroup) {
        this.isTaskgroup = isTaskgroup;
    }


    /**
     * Gets the isPublic value for this WorkgroupDTO.
     * 
     * @return isPublic
     */
    public boolean isIsPublic() {
        return isPublic;
    }


    /**
     * Sets the isPublic value for this WorkgroupDTO.
     * 
     * @param isPublic
     */
    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }


    /**
     * Gets the isAllMonitor value for this WorkgroupDTO.
     * 
     * @return isAllMonitor
     */
    public boolean isIsAllMonitor() {
        return isAllMonitor;
    }


    /**
     * Sets the isAllMonitor value for this WorkgroupDTO.
     * 
     * @param isAllMonitor
     */
    public void setIsAllMonitor(boolean isAllMonitor) {
        this.isAllMonitor = isAllMonitor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkgroupDTO)) return false;
        WorkgroupDTO other = (WorkgroupDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.workgroupName==null && other.getWorkgroupName()==null) || 
             (this.workgroupName!=null &&
              this.workgroupName.equals(other.getWorkgroupName()))) &&
            ((this.descriptionNote==null && other.getDescriptionNote()==null) || 
             (this.descriptionNote!=null &&
              this.descriptionNote.equals(other.getDescriptionNote()))) &&
            this.objectId == other.getObjectId() &&
            this.licenseId == other.getLicenseId() &&
            ((this.extSource==null && other.getExtSource()==null) || 
             (this.extSource!=null &&
              this.extSource.equals(other.getExtSource()))) &&
            ((this.extRef==null && other.getExtRef()==null) || 
             (this.extRef!=null &&
              this.extRef.equals(other.getExtRef()))) &&
            this.isTaskgroup == other.isIsTaskgroup() &&
            this.isPublic == other.isIsPublic() &&
            this.isAllMonitor == other.isIsAllMonitor();
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
        if (getWorkgroupName() != null) {
            _hashCode += getWorkgroupName().hashCode();
        }
        if (getDescriptionNote() != null) {
            _hashCode += getDescriptionNote().hashCode();
        }
        _hashCode += getObjectId();
        _hashCode += getLicenseId();
        if (getExtSource() != null) {
            _hashCode += getExtSource().hashCode();
        }
        if (getExtRef() != null) {
            _hashCode += getExtRef().hashCode();
        }
        _hashCode += (isIsTaskgroup() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsPublic() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllMonitor() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WorkgroupDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descriptionNote");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DescriptionNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LicenseId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ExtSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extRef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ExtRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTaskgroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsTaskgroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPublic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsPublic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllMonitor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsAllMonitor"));
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
