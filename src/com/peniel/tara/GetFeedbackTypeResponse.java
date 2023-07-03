/**
 * GetFeedbackTypeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetFeedbackTypeResponse  implements java.io.Serializable {
    private com.peniel.tara.FeedbackTypeDTO getFeedbackTypeResult;

    public GetFeedbackTypeResponse() {
    }

    public GetFeedbackTypeResponse(
           com.peniel.tara.FeedbackTypeDTO getFeedbackTypeResult) {
           this.getFeedbackTypeResult = getFeedbackTypeResult;
    }


    /**
     * Gets the getFeedbackTypeResult value for this GetFeedbackTypeResponse.
     * 
     * @return getFeedbackTypeResult
     */
    public com.peniel.tara.FeedbackTypeDTO getGetFeedbackTypeResult() {
        return getFeedbackTypeResult;
    }


    /**
     * Sets the getFeedbackTypeResult value for this GetFeedbackTypeResponse.
     * 
     * @param getFeedbackTypeResult
     */
    public void setGetFeedbackTypeResult(com.peniel.tara.FeedbackTypeDTO getFeedbackTypeResult) {
        this.getFeedbackTypeResult = getFeedbackTypeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetFeedbackTypeResponse)) return false;
        GetFeedbackTypeResponse other = (GetFeedbackTypeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getFeedbackTypeResult==null && other.getGetFeedbackTypeResult()==null) || 
             (this.getFeedbackTypeResult!=null &&
              this.getFeedbackTypeResult.equals(other.getGetFeedbackTypeResult())));
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
        if (getGetFeedbackTypeResult() != null) {
            _hashCode += getGetFeedbackTypeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetFeedbackTypeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetFeedbackTypeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getFeedbackTypeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetFeedbackTypeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackTypeDTO"));
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
