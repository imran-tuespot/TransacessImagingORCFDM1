/**
 * GetReviewForToolTipResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetReviewForToolTipResponse  implements java.io.Serializable {
    private com.peniel.tara.ReviewDTO getReviewForToolTipResult;

    public GetReviewForToolTipResponse() {
    }

    public GetReviewForToolTipResponse(
           com.peniel.tara.ReviewDTO getReviewForToolTipResult) {
           this.getReviewForToolTipResult = getReviewForToolTipResult;
    }


    /**
     * Gets the getReviewForToolTipResult value for this GetReviewForToolTipResponse.
     * 
     * @return getReviewForToolTipResult
     */
    public com.peniel.tara.ReviewDTO getGetReviewForToolTipResult() {
        return getReviewForToolTipResult;
    }


    /**
     * Sets the getReviewForToolTipResult value for this GetReviewForToolTipResponse.
     * 
     * @param getReviewForToolTipResult
     */
    public void setGetReviewForToolTipResult(com.peniel.tara.ReviewDTO getReviewForToolTipResult) {
        this.getReviewForToolTipResult = getReviewForToolTipResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetReviewForToolTipResponse)) return false;
        GetReviewForToolTipResponse other = (GetReviewForToolTipResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getReviewForToolTipResult==null && other.getGetReviewForToolTipResult()==null) || 
             (this.getReviewForToolTipResult!=null &&
              this.getReviewForToolTipResult.equals(other.getGetReviewForToolTipResult())));
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
        if (getGetReviewForToolTipResult() != null) {
            _hashCode += getGetReviewForToolTipResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetReviewForToolTipResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetReviewForToolTipResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getReviewForToolTipResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetReviewForToolTipResult"));
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
