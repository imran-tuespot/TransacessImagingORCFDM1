/**
 * GetFeedbackOptionListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetFeedbackOptionListResponse  implements java.io.Serializable {
    private com.peniel.tara.FeedbackOptionDTO[] getFeedbackOptionListResult;

    public GetFeedbackOptionListResponse() {
    }

    public GetFeedbackOptionListResponse(
           com.peniel.tara.FeedbackOptionDTO[] getFeedbackOptionListResult) {
           this.getFeedbackOptionListResult = getFeedbackOptionListResult;
    }


    /**
     * Gets the getFeedbackOptionListResult value for this GetFeedbackOptionListResponse.
     * 
     * @return getFeedbackOptionListResult
     */
    public com.peniel.tara.FeedbackOptionDTO[] getGetFeedbackOptionListResult() {
        return getFeedbackOptionListResult;
    }


    /**
     * Sets the getFeedbackOptionListResult value for this GetFeedbackOptionListResponse.
     * 
     * @param getFeedbackOptionListResult
     */
    public void setGetFeedbackOptionListResult(com.peniel.tara.FeedbackOptionDTO[] getFeedbackOptionListResult) {
        this.getFeedbackOptionListResult = getFeedbackOptionListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetFeedbackOptionListResponse)) return false;
        GetFeedbackOptionListResponse other = (GetFeedbackOptionListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getFeedbackOptionListResult==null && other.getGetFeedbackOptionListResult()==null) || 
             (this.getFeedbackOptionListResult!=null &&
              java.util.Arrays.equals(this.getFeedbackOptionListResult, other.getGetFeedbackOptionListResult())));
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
        if (getGetFeedbackOptionListResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetFeedbackOptionListResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetFeedbackOptionListResult(), i);
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
        new org.apache.axis.description.TypeDesc(GetFeedbackOptionListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetFeedbackOptionListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getFeedbackOptionListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetFeedbackOptionListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackOptionDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackOptionDTO"));
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
