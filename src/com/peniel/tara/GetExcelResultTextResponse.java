/**
 * GetExcelResultTextResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetExcelResultTextResponse  implements java.io.Serializable {
    private com.peniel.tara.CellDTO getExcelResultTextResult;

    public GetExcelResultTextResponse() {
    }

    public GetExcelResultTextResponse(
           com.peniel.tara.CellDTO getExcelResultTextResult) {
           this.getExcelResultTextResult = getExcelResultTextResult;
    }


    /**
     * Gets the getExcelResultTextResult value for this GetExcelResultTextResponse.
     * 
     * @return getExcelResultTextResult
     */
    public com.peniel.tara.CellDTO getGetExcelResultTextResult() {
        return getExcelResultTextResult;
    }


    /**
     * Sets the getExcelResultTextResult value for this GetExcelResultTextResponse.
     * 
     * @param getExcelResultTextResult
     */
    public void setGetExcelResultTextResult(com.peniel.tara.CellDTO getExcelResultTextResult) {
        this.getExcelResultTextResult = getExcelResultTextResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetExcelResultTextResponse)) return false;
        GetExcelResultTextResponse other = (GetExcelResultTextResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getExcelResultTextResult==null && other.getGetExcelResultTextResult()==null) || 
             (this.getExcelResultTextResult!=null &&
              this.getExcelResultTextResult.equals(other.getGetExcelResultTextResult())));
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
        if (getGetExcelResultTextResult() != null) {
            _hashCode += getGetExcelResultTextResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetExcelResultTextResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetExcelResultTextResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getExcelResultTextResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetExcelResultTextResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CellDTO"));
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
