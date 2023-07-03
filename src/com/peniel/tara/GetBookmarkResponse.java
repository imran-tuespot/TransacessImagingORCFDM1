/**
 * GetBookmarkResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetBookmarkResponse  implements java.io.Serializable {
    private com.peniel.tara.BookmarkDTO getBookmarkResult;

    public GetBookmarkResponse() {
    }

    public GetBookmarkResponse(
           com.peniel.tara.BookmarkDTO getBookmarkResult) {
           this.getBookmarkResult = getBookmarkResult;
    }


    /**
     * Gets the getBookmarkResult value for this GetBookmarkResponse.
     * 
     * @return getBookmarkResult
     */
    public com.peniel.tara.BookmarkDTO getGetBookmarkResult() {
        return getBookmarkResult;
    }


    /**
     * Sets the getBookmarkResult value for this GetBookmarkResponse.
     * 
     * @param getBookmarkResult
     */
    public void setGetBookmarkResult(com.peniel.tara.BookmarkDTO getBookmarkResult) {
        this.getBookmarkResult = getBookmarkResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetBookmarkResponse)) return false;
        GetBookmarkResponse other = (GetBookmarkResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getBookmarkResult==null && other.getGetBookmarkResult()==null) || 
             (this.getBookmarkResult!=null &&
              this.getBookmarkResult.equals(other.getGetBookmarkResult())));
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
        if (getGetBookmarkResult() != null) {
            _hashCode += getGetBookmarkResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetBookmarkResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetBookmarkResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getBookmarkResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetBookmarkResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "BookmarkDTO"));
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
