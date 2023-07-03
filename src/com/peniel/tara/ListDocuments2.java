/**
 * ListDocuments2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListDocuments2  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int reviewId;

    private boolean includeReferenceOnly;

    private boolean includeNonPrepared;

    private boolean hasPermissionToLinkedReview;

    public ListDocuments2() {
    }

    public ListDocuments2(
           java.lang.String loginContextId,
           int reviewId,
           boolean includeReferenceOnly,
           boolean includeNonPrepared,
           boolean hasPermissionToLinkedReview) {
           this.loginContextId = loginContextId;
           this.reviewId = reviewId;
           this.includeReferenceOnly = includeReferenceOnly;
           this.includeNonPrepared = includeNonPrepared;
           this.hasPermissionToLinkedReview = hasPermissionToLinkedReview;
    }


    /**
     * Gets the loginContextId value for this ListDocuments2.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this ListDocuments2.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the reviewId value for this ListDocuments2.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this ListDocuments2.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the includeReferenceOnly value for this ListDocuments2.
     * 
     * @return includeReferenceOnly
     */
    public boolean isIncludeReferenceOnly() {
        return includeReferenceOnly;
    }


    /**
     * Sets the includeReferenceOnly value for this ListDocuments2.
     * 
     * @param includeReferenceOnly
     */
    public void setIncludeReferenceOnly(boolean includeReferenceOnly) {
        this.includeReferenceOnly = includeReferenceOnly;
    }


    /**
     * Gets the includeNonPrepared value for this ListDocuments2.
     * 
     * @return includeNonPrepared
     */
    public boolean isIncludeNonPrepared() {
        return includeNonPrepared;
    }


    /**
     * Sets the includeNonPrepared value for this ListDocuments2.
     * 
     * @param includeNonPrepared
     */
    public void setIncludeNonPrepared(boolean includeNonPrepared) {
        this.includeNonPrepared = includeNonPrepared;
    }


    /**
     * Gets the hasPermissionToLinkedReview value for this ListDocuments2.
     * 
     * @return hasPermissionToLinkedReview
     */
    public boolean isHasPermissionToLinkedReview() {
        return hasPermissionToLinkedReview;
    }


    /**
     * Sets the hasPermissionToLinkedReview value for this ListDocuments2.
     * 
     * @param hasPermissionToLinkedReview
     */
    public void setHasPermissionToLinkedReview(boolean hasPermissionToLinkedReview) {
        this.hasPermissionToLinkedReview = hasPermissionToLinkedReview;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListDocuments2)) return false;
        ListDocuments2 other = (ListDocuments2) obj;
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
            this.includeReferenceOnly == other.isIncludeReferenceOnly() &&
            this.includeNonPrepared == other.isIncludeNonPrepared() &&
            this.hasPermissionToLinkedReview == other.isHasPermissionToLinkedReview();
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
        _hashCode += (isIncludeReferenceOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeNonPrepared() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHasPermissionToLinkedReview() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListDocuments2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListDocuments2"));
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
        elemField.setFieldName("includeReferenceOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "includeReferenceOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeNonPrepared");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "includeNonPrepared"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasPermissionToLinkedReview");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "hasPermissionToLinkedReview"));
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
