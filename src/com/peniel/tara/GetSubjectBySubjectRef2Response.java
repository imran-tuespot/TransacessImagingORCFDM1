/**
 * GetSubjectBySubjectRef2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetSubjectBySubjectRef2Response  implements java.io.Serializable {
    private com.peniel.tara.SubjectDTO getSubjectBySubjectRef2Result;

    public GetSubjectBySubjectRef2Response() {
    }

    public GetSubjectBySubjectRef2Response(
           com.peniel.tara.SubjectDTO getSubjectBySubjectRef2Result) {
           this.getSubjectBySubjectRef2Result = getSubjectBySubjectRef2Result;
    }


    /**
     * Gets the getSubjectBySubjectRef2Result value for this GetSubjectBySubjectRef2Response.
     * 
     * @return getSubjectBySubjectRef2Result
     */
    public com.peniel.tara.SubjectDTO getGetSubjectBySubjectRef2Result() {
        return getSubjectBySubjectRef2Result;
    }


    /**
     * Sets the getSubjectBySubjectRef2Result value for this GetSubjectBySubjectRef2Response.
     * 
     * @param getSubjectBySubjectRef2Result
     */
    public void setGetSubjectBySubjectRef2Result(com.peniel.tara.SubjectDTO getSubjectBySubjectRef2Result) {
        this.getSubjectBySubjectRef2Result = getSubjectBySubjectRef2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSubjectBySubjectRef2Response)) return false;
        GetSubjectBySubjectRef2Response other = (GetSubjectBySubjectRef2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSubjectBySubjectRef2Result==null && other.getGetSubjectBySubjectRef2Result()==null) || 
             (this.getSubjectBySubjectRef2Result!=null &&
              this.getSubjectBySubjectRef2Result.equals(other.getGetSubjectBySubjectRef2Result())));
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
        if (getGetSubjectBySubjectRef2Result() != null) {
            _hashCode += getGetSubjectBySubjectRef2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSubjectBySubjectRef2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetSubjectBySubjectRef2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSubjectBySubjectRef2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetSubjectBySubjectRef2Result"));
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
