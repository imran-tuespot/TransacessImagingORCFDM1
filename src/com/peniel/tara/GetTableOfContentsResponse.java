/**
 * GetTableOfContentsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetTableOfContentsResponse  implements java.io.Serializable {
    private com.peniel.tara.GetTableOfContentsResponseGetTableOfContentsResult getTableOfContentsResult;

    public GetTableOfContentsResponse() {
    }

    public GetTableOfContentsResponse(
           com.peniel.tara.GetTableOfContentsResponseGetTableOfContentsResult getTableOfContentsResult) {
           this.getTableOfContentsResult = getTableOfContentsResult;
    }


    /**
     * Gets the getTableOfContentsResult value for this GetTableOfContentsResponse.
     * 
     * @return getTableOfContentsResult
     */
    public com.peniel.tara.GetTableOfContentsResponseGetTableOfContentsResult getGetTableOfContentsResult() {
        return getTableOfContentsResult;
    }


    /**
     * Sets the getTableOfContentsResult value for this GetTableOfContentsResponse.
     * 
     * @param getTableOfContentsResult
     */
    public void setGetTableOfContentsResult(com.peniel.tara.GetTableOfContentsResponseGetTableOfContentsResult getTableOfContentsResult) {
        this.getTableOfContentsResult = getTableOfContentsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTableOfContentsResponse)) return false;
        GetTableOfContentsResponse other = (GetTableOfContentsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getTableOfContentsResult==null && other.getGetTableOfContentsResult()==null) || 
             (this.getTableOfContentsResult!=null &&
              this.getTableOfContentsResult.equals(other.getGetTableOfContentsResult())));
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
        if (getGetTableOfContentsResult() != null) {
            _hashCode += getGetTableOfContentsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTableOfContentsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetTableOfContentsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getTableOfContentsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetTableOfContentsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">>GetTableOfContentsResponse>GetTableOfContentsResult"));
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
