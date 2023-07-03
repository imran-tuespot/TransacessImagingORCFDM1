/**
 * GetParticipant1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetParticipant1Response  implements java.io.Serializable {
    private com.peniel.tara.ParticipantDTO getParticipant1Result;

    public GetParticipant1Response() {
    }

    public GetParticipant1Response(
           com.peniel.tara.ParticipantDTO getParticipant1Result) {
           this.getParticipant1Result = getParticipant1Result;
    }


    /**
     * Gets the getParticipant1Result value for this GetParticipant1Response.
     * 
     * @return getParticipant1Result
     */
    public com.peniel.tara.ParticipantDTO getGetParticipant1Result() {
        return getParticipant1Result;
    }


    /**
     * Sets the getParticipant1Result value for this GetParticipant1Response.
     * 
     * @param getParticipant1Result
     */
    public void setGetParticipant1Result(com.peniel.tara.ParticipantDTO getParticipant1Result) {
        this.getParticipant1Result = getParticipant1Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetParticipant1Response)) return false;
        GetParticipant1Response other = (GetParticipant1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getParticipant1Result==null && other.getGetParticipant1Result()==null) || 
             (this.getParticipant1Result!=null &&
              this.getParticipant1Result.equals(other.getGetParticipant1Result())));
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
        if (getGetParticipant1Result() != null) {
            _hashCode += getGetParticipant1Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetParticipant1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetParticipant1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getParticipant1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetParticipant1Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParticipantDTO"));
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
