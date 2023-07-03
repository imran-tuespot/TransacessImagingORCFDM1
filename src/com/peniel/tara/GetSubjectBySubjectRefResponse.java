/**
 * GetSubjectBySubjectRefResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetSubjectBySubjectRefResponse  implements java.io.Serializable {
    private com.peniel.tara.SubjectDTO getSubjectBySubjectRefResult;

    public GetSubjectBySubjectRefResponse() {
    }

    public GetSubjectBySubjectRefResponse(
           com.peniel.tara.SubjectDTO getSubjectBySubjectRefResult) {
           this.getSubjectBySubjectRefResult = getSubjectBySubjectRefResult;
    }


    /**
     * Gets the getSubjectBySubjectRefResult value for this GetSubjectBySubjectRefResponse.
     * 
     * @return getSubjectBySubjectRefResult
     */
    public com.peniel.tara.SubjectDTO getGetSubjectBySubjectRefResult() {
        return getSubjectBySubjectRefResult;
    }


    /**
     * Sets the getSubjectBySubjectRefResult value for this GetSubjectBySubjectRefResponse.
     * 
     * @param getSubjectBySubjectRefResult
     */
    public void setGetSubjectBySubjectRefResult(com.peniel.tara.SubjectDTO getSubjectBySubjectRefResult) {
        this.getSubjectBySubjectRefResult = getSubjectBySubjectRefResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSubjectBySubjectRefResponse)) return false;
        GetSubjectBySubjectRefResponse other = (GetSubjectBySubjectRefResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSubjectBySubjectRefResult==null && other.getGetSubjectBySubjectRefResult()==null) || 
             (this.getSubjectBySubjectRefResult!=null &&
              this.getSubjectBySubjectRefResult.equals(other.getGetSubjectBySubjectRefResult())));
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
        if (getGetSubjectBySubjectRefResult() != null) {
            _hashCode += getGetSubjectBySubjectRefResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSubjectBySubjectRefResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetSubjectBySubjectRefResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSubjectBySubjectRefResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetSubjectBySubjectRefResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
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
