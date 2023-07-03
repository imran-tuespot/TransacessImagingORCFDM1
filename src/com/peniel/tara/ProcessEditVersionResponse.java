/**
 * ProcessEditVersionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ProcessEditVersionResponse  implements java.io.Serializable {
    private com.peniel.tara.EditVersionDTO processEditVersionResult;

    public ProcessEditVersionResponse() {
    }

    public ProcessEditVersionResponse(
           com.peniel.tara.EditVersionDTO processEditVersionResult) {
           this.processEditVersionResult = processEditVersionResult;
    }


    /**
     * Gets the processEditVersionResult value for this ProcessEditVersionResponse.
     * 
     * @return processEditVersionResult
     */
    public com.peniel.tara.EditVersionDTO getProcessEditVersionResult() {
        return processEditVersionResult;
    }


    /**
     * Sets the processEditVersionResult value for this ProcessEditVersionResponse.
     * 
     * @param processEditVersionResult
     */
    public void setProcessEditVersionResult(com.peniel.tara.EditVersionDTO processEditVersionResult) {
        this.processEditVersionResult = processEditVersionResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProcessEditVersionResponse)) return false;
        ProcessEditVersionResponse other = (ProcessEditVersionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.processEditVersionResult==null && other.getProcessEditVersionResult()==null) || 
             (this.processEditVersionResult!=null &&
              this.processEditVersionResult.equals(other.getProcessEditVersionResult())));
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
        if (getProcessEditVersionResult() != null) {
            _hashCode += getProcessEditVersionResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProcessEditVersionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ProcessEditVersionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processEditVersionResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ProcessEditVersionResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditVersionDTO"));
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
