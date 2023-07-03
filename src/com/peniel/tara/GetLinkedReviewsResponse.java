/**
 * GetLinkedReviewsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetLinkedReviewsResponse  implements java.io.Serializable {
    private com.peniel.tara.ReviewDTO[] getLinkedReviewsResult;

    public GetLinkedReviewsResponse() {
    }

    public GetLinkedReviewsResponse(
           com.peniel.tara.ReviewDTO[] getLinkedReviewsResult) {
           this.getLinkedReviewsResult = getLinkedReviewsResult;
    }


    /**
     * Gets the getLinkedReviewsResult value for this GetLinkedReviewsResponse.
     * 
     * @return getLinkedReviewsResult
     */
    public com.peniel.tara.ReviewDTO[] getGetLinkedReviewsResult() {
        return getLinkedReviewsResult;
    }


    /**
     * Sets the getLinkedReviewsResult value for this GetLinkedReviewsResponse.
     * 
     * @param getLinkedReviewsResult
     */
    public void setGetLinkedReviewsResult(com.peniel.tara.ReviewDTO[] getLinkedReviewsResult) {
        this.getLinkedReviewsResult = getLinkedReviewsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLinkedReviewsResponse)) return false;
        GetLinkedReviewsResponse other = (GetLinkedReviewsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getLinkedReviewsResult==null && other.getGetLinkedReviewsResult()==null) || 
             (this.getLinkedReviewsResult!=null &&
              java.util.Arrays.equals(this.getLinkedReviewsResult, other.getGetLinkedReviewsResult())));
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
        if (getGetLinkedReviewsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetLinkedReviewsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetLinkedReviewsResult(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLinkedReviewsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetLinkedReviewsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getLinkedReviewsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetLinkedReviewsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDTO"));
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
