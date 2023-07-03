/**
 * SearchReviewsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SearchReviewsResponse  implements java.io.Serializable {
    private com.peniel.tara.ParticipantDTO[] searchReviewsResult;

    public SearchReviewsResponse() {
    }

    public SearchReviewsResponse(
           com.peniel.tara.ParticipantDTO[] searchReviewsResult) {
           this.searchReviewsResult = searchReviewsResult;
    }


    /**
     * Gets the searchReviewsResult value for this SearchReviewsResponse.
     * 
     * @return searchReviewsResult
     */
    public com.peniel.tara.ParticipantDTO[] getSearchReviewsResult() {
        return searchReviewsResult;
    }


    /**
     * Sets the searchReviewsResult value for this SearchReviewsResponse.
     * 
     * @param searchReviewsResult
     */
    public void setSearchReviewsResult(com.peniel.tara.ParticipantDTO[] searchReviewsResult) {
        this.searchReviewsResult = searchReviewsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchReviewsResponse)) return false;
        SearchReviewsResponse other = (SearchReviewsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchReviewsResult==null && other.getSearchReviewsResult()==null) || 
             (this.searchReviewsResult!=null &&
              java.util.Arrays.equals(this.searchReviewsResult, other.getSearchReviewsResult())));
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
        if (getSearchReviewsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSearchReviewsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSearchReviewsResult(), i);
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
        new org.apache.axis.description.TypeDesc(SearchReviewsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">SearchReviewsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchReviewsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SearchReviewsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParticipantDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParticipantDTO"));
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
