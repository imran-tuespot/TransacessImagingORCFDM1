/**
 * GuessFileFormatResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GuessFileFormatResponse  implements java.io.Serializable {
    private com.peniel.tara.FileFormatDTO guessFileFormatResult;

    public GuessFileFormatResponse() {
    }

    public GuessFileFormatResponse(
           com.peniel.tara.FileFormatDTO guessFileFormatResult) {
           this.guessFileFormatResult = guessFileFormatResult;
    }


    /**
     * Gets the guessFileFormatResult value for this GuessFileFormatResponse.
     * 
     * @return guessFileFormatResult
     */
    public com.peniel.tara.FileFormatDTO getGuessFileFormatResult() {
        return guessFileFormatResult;
    }


    /**
     * Sets the guessFileFormatResult value for this GuessFileFormatResponse.
     * 
     * @param guessFileFormatResult
     */
    public void setGuessFileFormatResult(com.peniel.tara.FileFormatDTO guessFileFormatResult) {
        this.guessFileFormatResult = guessFileFormatResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GuessFileFormatResponse)) return false;
        GuessFileFormatResponse other = (GuessFileFormatResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.guessFileFormatResult==null && other.getGuessFileFormatResult()==null) || 
             (this.guessFileFormatResult!=null &&
              this.guessFileFormatResult.equals(other.getGuessFileFormatResult())));
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
        if (getGuessFileFormatResult() != null) {
            _hashCode += getGuessFileFormatResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GuessFileFormatResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GuessFileFormatResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guessFileFormatResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GuessFileFormatResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileFormatDTO"));
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
