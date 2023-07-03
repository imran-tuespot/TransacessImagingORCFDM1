/**
 * GetSubjectByEmailResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetSubjectByEmailResponse  implements java.io.Serializable {
    private com.peniel.tara.SubjectDTO getSubjectByEmailResult;

    public GetSubjectByEmailResponse() {
    }

    public GetSubjectByEmailResponse(
           com.peniel.tara.SubjectDTO getSubjectByEmailResult) {
           this.getSubjectByEmailResult = getSubjectByEmailResult;
    }


    /**
     * Gets the getSubjectByEmailResult value for this GetSubjectByEmailResponse.
     * 
     * @return getSubjectByEmailResult
     */
    public com.peniel.tara.SubjectDTO getGetSubjectByEmailResult() {
        return getSubjectByEmailResult;
    }


    /**
     * Sets the getSubjectByEmailResult value for this GetSubjectByEmailResponse.
     * 
     * @param getSubjectByEmailResult
     */
    public void setGetSubjectByEmailResult(com.peniel.tara.SubjectDTO getSubjectByEmailResult) {
        this.getSubjectByEmailResult = getSubjectByEmailResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSubjectByEmailResponse)) return false;
        GetSubjectByEmailResponse other = (GetSubjectByEmailResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSubjectByEmailResult==null && other.getGetSubjectByEmailResult()==null) || 
             (this.getSubjectByEmailResult!=null &&
              this.getSubjectByEmailResult.equals(other.getGetSubjectByEmailResult())));
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
        if (getGetSubjectByEmailResult() != null) {
            _hashCode += getGetSubjectByEmailResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSubjectByEmailResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetSubjectByEmailResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSubjectByEmailResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetSubjectByEmailResult"));
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
