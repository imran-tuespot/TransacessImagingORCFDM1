/**
 * CheckinOptionDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class CheckinOptionDTO  implements java.io.Serializable {
    private int checkinMode;

    private java.lang.String description;

    private java.lang.String extraInfoPopup;

    private java.lang.String versionLabel;

    public CheckinOptionDTO() {
    }

    public CheckinOptionDTO(
           int checkinMode,
           java.lang.String description,
           java.lang.String extraInfoPopup,
           java.lang.String versionLabel) {
           this.checkinMode = checkinMode;
           this.description = description;
           this.extraInfoPopup = extraInfoPopup;
           this.versionLabel = versionLabel;
    }


    /**
     * Gets the checkinMode value for this CheckinOptionDTO.
     * 
     * @return checkinMode
     */
    public int getCheckinMode() {
        return checkinMode;
    }


    /**
     * Sets the checkinMode value for this CheckinOptionDTO.
     * 
     * @param checkinMode
     */
    public void setCheckinMode(int checkinMode) {
        this.checkinMode = checkinMode;
    }


    /**
     * Gets the description value for this CheckinOptionDTO.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this CheckinOptionDTO.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the extraInfoPopup value for this CheckinOptionDTO.
     * 
     * @return extraInfoPopup
     */
    public java.lang.String getExtraInfoPopup() {
        return extraInfoPopup;
    }


    /**
     * Sets the extraInfoPopup value for this CheckinOptionDTO.
     * 
     * @param extraInfoPopup
     */
    public void setExtraInfoPopup(java.lang.String extraInfoPopup) {
        this.extraInfoPopup = extraInfoPopup;
    }


    /**
     * Gets the versionLabel value for this CheckinOptionDTO.
     * 
     * @return versionLabel
     */
    public java.lang.String getVersionLabel() {
        return versionLabel;
    }


    /**
     * Sets the versionLabel value for this CheckinOptionDTO.
     * 
     * @param versionLabel
     */
    public void setVersionLabel(java.lang.String versionLabel) {
        this.versionLabel = versionLabel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckinOptionDTO)) return false;
        CheckinOptionDTO other = (CheckinOptionDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.checkinMode == other.getCheckinMode() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.extraInfoPopup==null && other.getExtraInfoPopup()==null) || 
             (this.extraInfoPopup!=null &&
              this.extraInfoPopup.equals(other.getExtraInfoPopup()))) &&
            ((this.versionLabel==null && other.getVersionLabel()==null) || 
             (this.versionLabel!=null &&
              this.versionLabel.equals(other.getVersionLabel())));
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
        _hashCode += getCheckinMode();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getExtraInfoPopup() != null) {
            _hashCode += getExtraInfoPopup().hashCode();
        }
        if (getVersionLabel() != null) {
            _hashCode += getVersionLabel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CheckinOptionDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CheckinOptionDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkinMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CheckinMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("extraInfoPopup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ExtraInfoPopup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versionLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "VersionLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
