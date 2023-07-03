/**
 * GetParticipantColor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetParticipantColor  implements java.io.Serializable {
    private java.lang.String accessKey;

    private int subjectId;

    private com.peniel.tara.GetParticipantColorColorMap colorMap;

    public GetParticipantColor() {
    }

    public GetParticipantColor(
           java.lang.String accessKey,
           int subjectId,
           com.peniel.tara.GetParticipantColorColorMap colorMap) {
           this.accessKey = accessKey;
           this.subjectId = subjectId;
           this.colorMap = colorMap;
    }


    /**
     * Gets the accessKey value for this GetParticipantColor.
     * 
     * @return accessKey
     */
    public java.lang.String getAccessKey() {
        return accessKey;
    }


    /**
     * Sets the accessKey value for this GetParticipantColor.
     * 
     * @param accessKey
     */
    public void setAccessKey(java.lang.String accessKey) {
        this.accessKey = accessKey;
    }


    /**
     * Gets the subjectId value for this GetParticipantColor.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this GetParticipantColor.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the colorMap value for this GetParticipantColor.
     * 
     * @return colorMap
     */
    public com.peniel.tara.GetParticipantColorColorMap getColorMap() {
        return colorMap;
    }


    /**
     * Sets the colorMap value for this GetParticipantColor.
     * 
     * @param colorMap
     */
    public void setColorMap(com.peniel.tara.GetParticipantColorColorMap colorMap) {
        this.colorMap = colorMap;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetParticipantColor)) return false;
        GetParticipantColor other = (GetParticipantColor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accessKey==null && other.getAccessKey()==null) || 
             (this.accessKey!=null &&
              this.accessKey.equals(other.getAccessKey()))) &&
            this.subjectId == other.getSubjectId() &&
            ((this.colorMap==null && other.getColorMap()==null) || 
             (this.colorMap!=null &&
              this.colorMap.equals(other.getColorMap())));
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
        if (getAccessKey() != null) {
            _hashCode += getAccessKey().hashCode();
        }
        _hashCode += getSubjectId();
        if (getColorMap() != null) {
            _hashCode += getColorMap().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetParticipantColor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetParticipantColor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accessKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "accessKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("colorMap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "colorMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">>GetParticipantColor>colorMap"));
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