/**
 * HandleEditZoneStatusChange.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class HandleEditZoneStatusChange  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int reviewId;

    private java.lang.String zoneType;

    private java.lang.String zoneStatus;

    public HandleEditZoneStatusChange() {
    }

    public HandleEditZoneStatusChange(
           java.lang.String loginContextId,
           int reviewId,
           java.lang.String zoneType,
           java.lang.String zoneStatus) {
           this.loginContextId = loginContextId;
           this.reviewId = reviewId;
           this.zoneType = zoneType;
           this.zoneStatus = zoneStatus;
    }


    /**
     * Gets the loginContextId value for this HandleEditZoneStatusChange.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this HandleEditZoneStatusChange.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the reviewId value for this HandleEditZoneStatusChange.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this HandleEditZoneStatusChange.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the zoneType value for this HandleEditZoneStatusChange.
     * 
     * @return zoneType
     */
    public java.lang.String getZoneType() {
        return zoneType;
    }


    /**
     * Sets the zoneType value for this HandleEditZoneStatusChange.
     * 
     * @param zoneType
     */
    public void setZoneType(java.lang.String zoneType) {
        this.zoneType = zoneType;
    }


    /**
     * Gets the zoneStatus value for this HandleEditZoneStatusChange.
     * 
     * @return zoneStatus
     */
    public java.lang.String getZoneStatus() {
        return zoneStatus;
    }


    /**
     * Sets the zoneStatus value for this HandleEditZoneStatusChange.
     * 
     * @param zoneStatus
     */
    public void setZoneStatus(java.lang.String zoneStatus) {
        this.zoneStatus = zoneStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HandleEditZoneStatusChange)) return false;
        HandleEditZoneStatusChange other = (HandleEditZoneStatusChange) obj;
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
            this.reviewId == other.getReviewId() &&
            ((this.zoneType==null && other.getZoneType()==null) || 
             (this.zoneType!=null &&
              this.zoneType.equals(other.getZoneType()))) &&
            ((this.zoneStatus==null && other.getZoneStatus()==null) || 
             (this.zoneStatus!=null &&
              this.zoneStatus.equals(other.getZoneStatus())));
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
        _hashCode += getReviewId();
        if (getZoneType() != null) {
            _hashCode += getZoneType().hashCode();
        }
        if (getZoneStatus() != null) {
            _hashCode += getZoneStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HandleEditZoneStatusChange.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">HandleEditZoneStatusChange"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "reviewId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zoneType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "zoneType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zoneStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "zoneStatus"));
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
