/**
 * GetFeedbackResultListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetFeedbackResultListResponse  implements java.io.Serializable {
    private com.peniel.tara.CommentDTO[] getFeedbackResultListResult;

    public GetFeedbackResultListResponse() {
    }

    public GetFeedbackResultListResponse(
           com.peniel.tara.CommentDTO[] getFeedbackResultListResult) {
           this.getFeedbackResultListResult = getFeedbackResultListResult;
    }


    /**
     * Gets the getFeedbackResultListResult value for this GetFeedbackResultListResponse.
     * 
     * @return getFeedbackResultListResult
     */
    public com.peniel.tara.CommentDTO[] getGetFeedbackResultListResult() {
        return getFeedbackResultListResult;
    }


    /**
     * Sets the getFeedbackResultListResult value for this GetFeedbackResultListResponse.
     * 
     * @param getFeedbackResultListResult
     */
    public void setGetFeedbackResultListResult(com.peniel.tara.CommentDTO[] getFeedbackResultListResult) {
        this.getFeedbackResultListResult = getFeedbackResultListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetFeedbackResultListResponse)) return false;
        GetFeedbackResultListResponse other = (GetFeedbackResultListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getFeedbackResultListResult==null && other.getGetFeedbackResultListResult()==null) || 
             (this.getFeedbackResultListResult!=null &&
              java.util.Arrays.equals(this.getFeedbackResultListResult, other.getGetFeedbackResultListResult())));
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
        if (getGetFeedbackResultListResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetFeedbackResultListResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetFeedbackResultListResult(), i);
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
        new org.apache.axis.description.TypeDesc(GetFeedbackResultListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetFeedbackResultListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getFeedbackResultListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetFeedbackResultListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentDTO"));
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
