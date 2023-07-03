/**
 * GetParticipantResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetParticipantResponse  implements java.io.Serializable {
    private com.peniel.tara.ParticipantDTO getParticipantResult;

    public GetParticipantResponse() {
    }

    public GetParticipantResponse(
           com.peniel.tara.ParticipantDTO getParticipantResult) {
           this.getParticipantResult = getParticipantResult;
    }


    /**
     * Gets the getParticipantResult value for this GetParticipantResponse.
     * 
     * @return getParticipantResult
     */
    public com.peniel.tara.ParticipantDTO getGetParticipantResult() {
        return getParticipantResult;
    }


    /**
     * Sets the getParticipantResult value for this GetParticipantResponse.
     * 
     * @param getParticipantResult
     */
    public void setGetParticipantResult(com.peniel.tara.ParticipantDTO getParticipantResult) {
        this.getParticipantResult = getParticipantResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetParticipantResponse)) return false;
        GetParticipantResponse other = (GetParticipantResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getParticipantResult==null && other.getGetParticipantResult()==null) || 
             (this.getParticipantResult!=null &&
              this.getParticipantResult.equals(other.getGetParticipantResult())));
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
        if (getGetParticipantResult() != null) {
            _hashCode += getGetParticipantResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetParticipantResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetParticipantResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getParticipantResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetParticipantResult"));
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
