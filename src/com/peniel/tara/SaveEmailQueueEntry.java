/**
 * SaveEmailQueueEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SaveEmailQueueEntry  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.EmailQueueEntryDTO emailQueueEntryDto;

    public SaveEmailQueueEntry() {
    }

    public SaveEmailQueueEntry(
           java.lang.String loginContextId,
           com.peniel.tara.EmailQueueEntryDTO emailQueueEntryDto) {
           this.loginContextId = loginContextId;
           this.emailQueueEntryDto = emailQueueEntryDto;
    }


    /**
     * Gets the loginContextId value for this SaveEmailQueueEntry.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this SaveEmailQueueEntry.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the emailQueueEntryDto value for this SaveEmailQueueEntry.
     * 
     * @return emailQueueEntryDto
     */
    public com.peniel.tara.EmailQueueEntryDTO getEmailQueueEntryDto() {
        return emailQueueEntryDto;
    }


    /**
     * Sets the emailQueueEntryDto value for this SaveEmailQueueEntry.
     * 
     * @param emailQueueEntryDto
     */
    public void setEmailQueueEntryDto(com.peniel.tara.EmailQueueEntryDTO emailQueueEntryDto) {
        this.emailQueueEntryDto = emailQueueEntryDto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SaveEmailQueueEntry)) return false;
        SaveEmailQueueEntry other = (SaveEmailQueueEntry) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.loginContextId==null && other.getLoginContextId()==null) || 
             (this.loginContextId!=null &&
              this.loginContextId.equals(other.getLoginContextId()))) &&
            ((this.emailQueueEntryDto==null && other.getEmailQueueEntryDto()==null) || 
             (this.emailQueueEntryDto!=null &&
              this.emailQueueEntryDto.equals(other.getEmailQueueEntryDto())));
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
        if (getLoginContextId() != null) {
            _hashCode += getLoginContextId().hashCode();
        }
        if (getEmailQueueEntryDto() != null) {
            _hashCode += getEmailQueueEntryDto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SaveEmailQueueEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">SaveEmailQueueEntry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailQueueEntryDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "emailQueueEntryDto"));
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
