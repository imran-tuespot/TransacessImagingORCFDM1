/**
 * CultureDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class CultureDTO  implements java.io.Serializable {
    private java.lang.String cultureName;

    private java.lang.String loginPageTitle;

    private java.lang.String displayDateFormat;

    private java.lang.String displayTimeFormat;

    private java.lang.String displayCultureName;

    private java.lang.String defaultLogInTo;

    public CultureDTO() {
    }

    public CultureDTO(
           java.lang.String cultureName,
           java.lang.String loginPageTitle,
           java.lang.String displayDateFormat,
           java.lang.String displayTimeFormat,
           java.lang.String displayCultureName,
           java.lang.String defaultLogInTo) {
           this.cultureName = cultureName;
           this.loginPageTitle = loginPageTitle;
           this.displayDateFormat = displayDateFormat;
           this.displayTimeFormat = displayTimeFormat;
           this.displayCultureName = displayCultureName;
           this.defaultLogInTo = defaultLogInTo;
    }


    /**
     * Gets the cultureName value for this CultureDTO.
     * 
     * @return cultureName
     */
    public java.lang.String getCultureName() {
        return cultureName;
    }


    /**
     * Sets the cultureName value for this CultureDTO.
     * 
     * @param cultureName
     */
    public void setCultureName(java.lang.String cultureName) {
        this.cultureName = cultureName;
    }


    /**
     * Gets the loginPageTitle value for this CultureDTO.
     * 
     * @return loginPageTitle
     */
    public java.lang.String getLoginPageTitle() {
        return loginPageTitle;
    }


    /**
     * Sets the loginPageTitle value for this CultureDTO.
     * 
     * @param loginPageTitle
     */
    public void setLoginPageTitle(java.lang.String loginPageTitle) {
        this.loginPageTitle = loginPageTitle;
    }


    /**
     * Gets the displayDateFormat value for this CultureDTO.
     * 
     * @return displayDateFormat
     */
    public java.lang.String getDisplayDateFormat() {
        return displayDateFormat;
    }


    /**
     * Sets the displayDateFormat value for this CultureDTO.
     * 
     * @param displayDateFormat
     */
    public void setDisplayDateFormat(java.lang.String displayDateFormat) {
        this.displayDateFormat = displayDateFormat;
    }


    /**
     * Gets the displayTimeFormat value for this CultureDTO.
     * 
     * @return displayTimeFormat
     */
    public java.lang.String getDisplayTimeFormat() {
        return displayTimeFormat;
    }


    /**
     * Sets the displayTimeFormat value for this CultureDTO.
     * 
     * @param displayTimeFormat
     */
    public void setDisplayTimeFormat(java.lang.String displayTimeFormat) {
        this.displayTimeFormat = displayTimeFormat;
    }


    /**
     * Gets the displayCultureName value for this CultureDTO.
     * 
     * @return displayCultureName
     */
    public java.lang.String getDisplayCultureName() {
        return displayCultureName;
    }


    /**
     * Sets the displayCultureName value for this CultureDTO.
     * 
     * @param displayCultureName
     */
    public void setDisplayCultureName(java.lang.String displayCultureName) {
        this.displayCultureName = displayCultureName;
    }


    /**
     * Gets the defaultLogInTo value for this CultureDTO.
     * 
     * @return defaultLogInTo
     */
    public java.lang.String getDefaultLogInTo() {
        return defaultLogInTo;
    }


    /**
     * Sets the defaultLogInTo value for this CultureDTO.
     * 
     * @param defaultLogInTo
     */
    public void setDefaultLogInTo(java.lang.String defaultLogInTo) {
        this.defaultLogInTo = defaultLogInTo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CultureDTO)) return false;
        CultureDTO other = (CultureDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cultureName==null && other.getCultureName()==null) || 
             (this.cultureName!=null &&
              this.cultureName.equals(other.getCultureName()))) &&
            ((this.loginPageTitle==null && other.getLoginPageTitle()==null) || 
             (this.loginPageTitle!=null &&
              this.loginPageTitle.equals(other.getLoginPageTitle()))) &&
            ((this.displayDateFormat==null && other.getDisplayDateFormat()==null) || 
             (this.displayDateFormat!=null &&
              this.displayDateFormat.equals(other.getDisplayDateFormat()))) &&
            ((this.displayTimeFormat==null && other.getDisplayTimeFormat()==null) || 
             (this.displayTimeFormat!=null &&
              this.displayTimeFormat.equals(other.getDisplayTimeFormat()))) &&
            ((this.displayCultureName==null && other.getDisplayCultureName()==null) || 
             (this.displayCultureName!=null &&
              this.displayCultureName.equals(other.getDisplayCultureName()))) &&
            ((this.defaultLogInTo==null && other.getDefaultLogInTo()==null) || 
             (this.defaultLogInTo!=null &&
              this.defaultLogInTo.equals(other.getDefaultLogInTo())));
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
        if (getCultureName() != null) {
            _hashCode += getCultureName().hashCode();
        }
        if (getLoginPageTitle() != null) {
            _hashCode += getLoginPageTitle().hashCode();
        }
        if (getDisplayDateFormat() != null) {
            _hashCode += getDisplayDateFormat().hashCode();
        }
        if (getDisplayTimeFormat() != null) {
            _hashCode += getDisplayTimeFormat().hashCode();
        }
        if (getDisplayCultureName() != null) {
            _hashCode += getDisplayCultureName().hashCode();
        }
        if (getDefaultLogInTo() != null) {
            _hashCode += getDefaultLogInTo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CultureDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CultureDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cultureName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CultureName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginPageTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LoginPageTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayDateFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DisplayDateFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayTimeFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DisplayTimeFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayCultureName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DisplayCultureName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultLogInTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DefaultLogInTo"));
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
