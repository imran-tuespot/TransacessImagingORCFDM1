/**
 * ReviewDefaultReasonResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ReviewDefaultReasonResponse  implements java.io.Serializable {
    private java.lang.String reviewDefaultReasonResult;

    public ReviewDefaultReasonResponse() {
    }

    public ReviewDefaultReasonResponse(
           java.lang.String reviewDefaultReasonResult) {
           this.reviewDefaultReasonResult = reviewDefaultReasonResult;
    }


    /**
     * Gets the reviewDefaultReasonResult value for this ReviewDefaultReasonResponse.
     * 
     * @return reviewDefaultReasonResult
     */
    public java.lang.String getReviewDefaultReasonResult() {
        return reviewDefaultReasonResult;
    }


    /**
     * Sets the reviewDefaultReasonResult value for this ReviewDefaultReasonResponse.
     * 
     * @param reviewDefaultReasonResult
     */
    public void setReviewDefaultReasonResult(java.lang.String reviewDefaultReasonResult) {
        this.reviewDefaultReasonResult = reviewDefaultReasonResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReviewDefaultReasonResponse)) return false;
        ReviewDefaultReasonResponse other = (ReviewDefaultReasonResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.reviewDefaultReasonResult==null && other.getReviewDefaultReasonResult()==null) || 
             (this.reviewDefaultReasonResult!=null &&
              this.reviewDefaultReasonResult.equals(other.getReviewDefaultReasonResult())));
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
        if (getReviewDefaultReasonResult() != null) {
            _hashCode += getReviewDefaultReasonResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReviewDefaultReasonResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ReviewDefaultReasonResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewDefaultReasonResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDefaultReasonResult"));
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
