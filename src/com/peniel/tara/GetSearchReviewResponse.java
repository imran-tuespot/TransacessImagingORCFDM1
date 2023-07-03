/**
 * GetSearchReviewResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetSearchReviewResponse  implements java.io.Serializable {
    private com.peniel.tara.ReviewDTO getSearchReviewResult;

    public GetSearchReviewResponse() {
    }

    public GetSearchReviewResponse(
           com.peniel.tara.ReviewDTO getSearchReviewResult) {
           this.getSearchReviewResult = getSearchReviewResult;
    }


    /**
     * Gets the getSearchReviewResult value for this GetSearchReviewResponse.
     * 
     * @return getSearchReviewResult
     */
    public com.peniel.tara.ReviewDTO getGetSearchReviewResult() {
        return getSearchReviewResult;
    }


    /**
     * Sets the getSearchReviewResult value for this GetSearchReviewResponse.
     * 
     * @param getSearchReviewResult
     */
    public void setGetSearchReviewResult(com.peniel.tara.ReviewDTO getSearchReviewResult) {
        this.getSearchReviewResult = getSearchReviewResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSearchReviewResponse)) return false;
        GetSearchReviewResponse other = (GetSearchReviewResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSearchReviewResult==null && other.getGetSearchReviewResult()==null) || 
             (this.getSearchReviewResult!=null &&
              this.getSearchReviewResult.equals(other.getGetSearchReviewResult())));
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
        if (getGetSearchReviewResult() != null) {
            _hashCode += getGetSearchReviewResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSearchReviewResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetSearchReviewResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSearchReviewResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetSearchReviewResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDTO"));
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
