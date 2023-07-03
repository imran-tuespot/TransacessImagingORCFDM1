/**
 * GetEmailQueueEntryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetEmailQueueEntryResponse  implements java.io.Serializable {
    private com.peniel.tara.EmailQueueEntryDTO getEmailQueueEntryResult;

    public GetEmailQueueEntryResponse() {
    }

    public GetEmailQueueEntryResponse(
           com.peniel.tara.EmailQueueEntryDTO getEmailQueueEntryResult) {
           this.getEmailQueueEntryResult = getEmailQueueEntryResult;
    }


    /**
     * Gets the getEmailQueueEntryResult value for this GetEmailQueueEntryResponse.
     * 
     * @return getEmailQueueEntryResult
     */
    public com.peniel.tara.EmailQueueEntryDTO getGetEmailQueueEntryResult() {
        return getEmailQueueEntryResult;
    }


    /**
     * Sets the getEmailQueueEntryResult value for this GetEmailQueueEntryResponse.
     * 
     * @param getEmailQueueEntryResult
     */
    public void setGetEmailQueueEntryResult(com.peniel.tara.EmailQueueEntryDTO getEmailQueueEntryResult) {
        this.getEmailQueueEntryResult = getEmailQueueEntryResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmailQueueEntryResponse)) return false;
        GetEmailQueueEntryResponse other = (GetEmailQueueEntryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEmailQueueEntryResult==null && other.getGetEmailQueueEntryResult()==null) || 
             (this.getEmailQueueEntryResult!=null &&
              this.getEmailQueueEntryResult.equals(other.getGetEmailQueueEntryResult())));
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
        if (getGetEmailQueueEntryResult() != null) {
            _hashCode += getGetEmailQueueEntryResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmailQueueEntryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetEmailQueueEntryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEmailQueueEntryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetEmailQueueEntryResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EmailQueueEntryDTO"));
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
