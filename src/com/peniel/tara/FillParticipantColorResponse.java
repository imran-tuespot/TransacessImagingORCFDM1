/**
 * FillParticipantColorResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class FillParticipantColorResponse  implements java.io.Serializable {
    private com.peniel.tara.FillParticipantColorResponseFillParticipantColorResult fillParticipantColorResult;

    public FillParticipantColorResponse() {
    }

    public FillParticipantColorResponse(
           com.peniel.tara.FillParticipantColorResponseFillParticipantColorResult fillParticipantColorResult) {
           this.fillParticipantColorResult = fillParticipantColorResult;
    }


    /**
     * Gets the fillParticipantColorResult value for this FillParticipantColorResponse.
     * 
     * @return fillParticipantColorResult
     */
    public com.peniel.tara.FillParticipantColorResponseFillParticipantColorResult getFillParticipantColorResult() {
        return fillParticipantColorResult;
    }


    /**
     * Sets the fillParticipantColorResult value for this FillParticipantColorResponse.
     * 
     * @param fillParticipantColorResult
     */
    public void setFillParticipantColorResult(com.peniel.tara.FillParticipantColorResponseFillParticipantColorResult fillParticipantColorResult) {
        this.fillParticipantColorResult = fillParticipantColorResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FillParticipantColorResponse)) return false;
        FillParticipantColorResponse other = (FillParticipantColorResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fillParticipantColorResult==null && other.getFillParticipantColorResult()==null) || 
             (this.fillParticipantColorResult!=null &&
              this.fillParticipantColorResult.equals(other.getFillParticipantColorResult())));
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
        if (getFillParticipantColorResult() != null) {
            _hashCode += getFillParticipantColorResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FillParticipantColorResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">FillParticipantColorResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fillParticipantColorResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FillParticipantColorResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">>FillParticipantColorResponse>FillParticipantColorResult"));
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
