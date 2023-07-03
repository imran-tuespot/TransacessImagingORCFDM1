/**
 * GetLinkedReviews.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetLinkedReviews  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int reviewId;

    private java.lang.String compareLink;

    private boolean hasLinkedReviewPermission;

    public GetLinkedReviews() {
    }

    public GetLinkedReviews(
           java.lang.String loginContextId,
           int reviewId,
           java.lang.String compareLink,
           boolean hasLinkedReviewPermission) {
           this.loginContextId = loginContextId;
           this.reviewId = reviewId;
           this.compareLink = compareLink;
           this.hasLinkedReviewPermission = hasLinkedReviewPermission;
    }


    /**
     * Gets the loginContextId value for this GetLinkedReviews.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetLinkedReviews.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the reviewId value for this GetLinkedReviews.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this GetLinkedReviews.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the compareLink value for this GetLinkedReviews.
     * 
     * @return compareLink
     */
    public java.lang.String getCompareLink() {
        return compareLink;
    }


    /**
     * Sets the compareLink value for this GetLinkedReviews.
     * 
     * @param compareLink
     */
    public void setCompareLink(java.lang.String compareLink) {
        this.compareLink = compareLink;
    }


    /**
     * Gets the hasLinkedReviewPermission value for this GetLinkedReviews.
     * 
     * @return hasLinkedReviewPermission
     */
    public boolean isHasLinkedReviewPermission() {
        return hasLinkedReviewPermission;
    }


    /**
     * Sets the hasLinkedReviewPermission value for this GetLinkedReviews.
     * 
     * @param hasLinkedReviewPermission
     */
    public void setHasLinkedReviewPermission(boolean hasLinkedReviewPermission) {
        this.hasLinkedReviewPermission = hasLinkedReviewPermission;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLinkedReviews)) return false;
        GetLinkedReviews other = (GetLinkedReviews) obj;
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
            ((this.compareLink==null && other.getCompareLink()==null) || 
             (this.compareLink!=null &&
              this.compareLink.equals(other.getCompareLink()))) &&
            this.hasLinkedReviewPermission == other.isHasLinkedReviewPermission();
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
        if (getCompareLink() != null) {
            _hashCode += getCompareLink().hashCode();
        }
        _hashCode += (isHasLinkedReviewPermission() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLinkedReviews.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetLinkedReviews"));
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
        elemField.setFieldName("compareLink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "compareLink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasLinkedReviewPermission");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "hasLinkedReviewPermission"));
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
