/**
 * GetCommentStatsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetCommentStatsResponse  implements java.io.Serializable {
    private com.peniel.tara.CommentStatsDTO[] getCommentStatsResult;

    public GetCommentStatsResponse() {
    }

    public GetCommentStatsResponse(
           com.peniel.tara.CommentStatsDTO[] getCommentStatsResult) {
           this.getCommentStatsResult = getCommentStatsResult;
    }


    /**
     * Gets the getCommentStatsResult value for this GetCommentStatsResponse.
     * 
     * @return getCommentStatsResult
     */
    public com.peniel.tara.CommentStatsDTO[] getGetCommentStatsResult() {
        return getCommentStatsResult;
    }


    /**
     * Sets the getCommentStatsResult value for this GetCommentStatsResponse.
     * 
     * @param getCommentStatsResult
     */
    public void setGetCommentStatsResult(com.peniel.tara.CommentStatsDTO[] getCommentStatsResult) {
        this.getCommentStatsResult = getCommentStatsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCommentStatsResponse)) return false;
        GetCommentStatsResponse other = (GetCommentStatsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCommentStatsResult==null && other.getGetCommentStatsResult()==null) || 
             (this.getCommentStatsResult!=null &&
              java.util.Arrays.equals(this.getCommentStatsResult, other.getGetCommentStatsResult())));
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
        if (getGetCommentStatsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetCommentStatsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetCommentStatsResult(), i);
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
        new org.apache.axis.description.TypeDesc(GetCommentStatsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetCommentStatsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCommentStatsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetCommentStatsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentStatsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentStatsDTO"));
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
