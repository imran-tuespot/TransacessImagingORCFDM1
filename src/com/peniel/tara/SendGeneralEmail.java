/**
 * SendGeneralEmail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SendGeneralEmail  implements java.io.Serializable {
    private java.lang.String accessKey;

    private java.lang.String emailType;

    private java.lang.String senderEmail;

    private java.lang.String senderName;

    private java.lang.String textblock1;

    private java.lang.String textblock2;

    private java.lang.String textblock3;

    public SendGeneralEmail() {
    }

    public SendGeneralEmail(
           java.lang.String accessKey,
           java.lang.String emailType,
           java.lang.String senderEmail,
           java.lang.String senderName,
           java.lang.String textblock1,
           java.lang.String textblock2,
           java.lang.String textblock3) {
           this.accessKey = accessKey;
           this.emailType = emailType;
           this.senderEmail = senderEmail;
           this.senderName = senderName;
           this.textblock1 = textblock1;
           this.textblock2 = textblock2;
           this.textblock3 = textblock3;
    }


    /**
     * Gets the accessKey value for this SendGeneralEmail.
     * 
     * @return accessKey
     */
    public java.lang.String getAccessKey() {
        return accessKey;
    }


    /**
     * Sets the accessKey value for this SendGeneralEmail.
     * 
     * @param accessKey
     */
    public void setAccessKey(java.lang.String accessKey) {
        this.accessKey = accessKey;
    }


    /**
     * Gets the emailType value for this SendGeneralEmail.
     * 
     * @return emailType
     */
    public java.lang.String getEmailType() {
        return emailType;
    }


    /**
     * Sets the emailType value for this SendGeneralEmail.
     * 
     * @param emailType
     */
    public void setEmailType(java.lang.String emailType) {
        this.emailType = emailType;
    }


    /**
     * Gets the senderEmail value for this SendGeneralEmail.
     * 
     * @return senderEmail
     */
    public java.lang.String getSenderEmail() {
        return senderEmail;
    }


    /**
     * Sets the senderEmail value for this SendGeneralEmail.
     * 
     * @param senderEmail
     */
    public void setSenderEmail(java.lang.String senderEmail) {
        this.senderEmail = senderEmail;
    }


    /**
     * Gets the senderName value for this SendGeneralEmail.
     * 
     * @return senderName
     */
    public java.lang.String getSenderName() {
        return senderName;
    }


    /**
     * Sets the senderName value for this SendGeneralEmail.
     * 
     * @param senderName
     */
    public void setSenderName(java.lang.String senderName) {
        this.senderName = senderName;
    }


    /**
     * Gets the textblock1 value for this SendGeneralEmail.
     * 
     * @return textblock1
     */
    public java.lang.String getTextblock1() {
        return textblock1;
    }


    /**
     * Sets the textblock1 value for this SendGeneralEmail.
     * 
     * @param textblock1
     */
    public void setTextblock1(java.lang.String textblock1) {
        this.textblock1 = textblock1;
    }


    /**
     * Gets the textblock2 value for this SendGeneralEmail.
     * 
     * @return textblock2
     */
    public java.lang.String getTextblock2() {
        return textblock2;
    }


    /**
     * Sets the textblock2 value for this SendGeneralEmail.
     * 
     * @param textblock2
     */
    public void setTextblock2(java.lang.String textblock2) {
        this.textblock2 = textblock2;
    }


    /**
     * Gets the textblock3 value for this SendGeneralEmail.
     * 
     * @return textblock3
     */
    public java.lang.String getTextblock3() {
        return textblock3;
    }


    /**
     * Sets the textblock3 value for this SendGeneralEmail.
     * 
     * @param textblock3
     */
    public void setTextblock3(java.lang.String textblock3) {
        this.textblock3 = textblock3;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendGeneralEmail)) return false;
        SendGeneralEmail other = (SendGeneralEmail) obj;
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
            ((this.emailType==null && other.getEmailType()==null) || 
             (this.emailType!=null &&
              this.emailType.equals(other.getEmailType()))) &&
            ((this.senderEmail==null && other.getSenderEmail()==null) || 
             (this.senderEmail!=null &&
              this.senderEmail.equals(other.getSenderEmail()))) &&
            ((this.senderName==null && other.getSenderName()==null) || 
             (this.senderName!=null &&
              this.senderName.equals(other.getSenderName()))) &&
            ((this.textblock1==null && other.getTextblock1()==null) || 
             (this.textblock1!=null &&
              this.textblock1.equals(other.getTextblock1()))) &&
            ((this.textblock2==null && other.getTextblock2()==null) || 
             (this.textblock2!=null &&
              this.textblock2.equals(other.getTextblock2()))) &&
            ((this.textblock3==null && other.getTextblock3()==null) || 
             (this.textblock3!=null &&
              this.textblock3.equals(other.getTextblock3())));
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
        if (getEmailType() != null) {
            _hashCode += getEmailType().hashCode();
        }
        if (getSenderEmail() != null) {
            _hashCode += getSenderEmail().hashCode();
        }
        if (getSenderName() != null) {
            _hashCode += getSenderName().hashCode();
        }
        if (getTextblock1() != null) {
            _hashCode += getTextblock1().hashCode();
        }
        if (getTextblock2() != null) {
            _hashCode += getTextblock2().hashCode();
        }
        if (getTextblock3() != null) {
            _hashCode += getTextblock3().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendGeneralEmail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">SendGeneralEmail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accessKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "accessKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "emailType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "senderEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "senderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textblock1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "textblock1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textblock2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "textblock2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textblock3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "textblock3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
