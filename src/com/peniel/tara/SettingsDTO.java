/**
 * SettingsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SettingsDTO  implements java.io.Serializable {
    private int objectId;

    private java.lang.String refObjectType;

    private int refObjectId;

    private java.lang.String entryName;

    private java.lang.String stringParam1;

    private java.lang.String stringParam2;

    private int intParam1;

    private int intParam2;

    private java.util.Calendar dateParam1;

    private java.util.Calendar dateParam2;

    private java.lang.String textParam1;

    public SettingsDTO() {
    }

    public SettingsDTO(
           int objectId,
           java.lang.String refObjectType,
           int refObjectId,
           java.lang.String entryName,
           java.lang.String stringParam1,
           java.lang.String stringParam2,
           int intParam1,
           int intParam2,
           java.util.Calendar dateParam1,
           java.util.Calendar dateParam2,
           java.lang.String textParam1) {
           this.objectId = objectId;
           this.refObjectType = refObjectType;
           this.refObjectId = refObjectId;
           this.entryName = entryName;
           this.stringParam1 = stringParam1;
           this.stringParam2 = stringParam2;
           this.intParam1 = intParam1;
           this.intParam2 = intParam2;
           this.dateParam1 = dateParam1;
           this.dateParam2 = dateParam2;
           this.textParam1 = textParam1;
    }


    /**
     * Gets the objectId value for this SettingsDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this SettingsDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the refObjectType value for this SettingsDTO.
     * 
     * @return refObjectType
     */
    public java.lang.String getRefObjectType() {
        return refObjectType;
    }


    /**
     * Sets the refObjectType value for this SettingsDTO.
     * 
     * @param refObjectType
     */
    public void setRefObjectType(java.lang.String refObjectType) {
        this.refObjectType = refObjectType;
    }


    /**
     * Gets the refObjectId value for this SettingsDTO.
     * 
     * @return refObjectId
     */
    public int getRefObjectId() {
        return refObjectId;
    }


    /**
     * Sets the refObjectId value for this SettingsDTO.
     * 
     * @param refObjectId
     */
    public void setRefObjectId(int refObjectId) {
        this.refObjectId = refObjectId;
    }


    /**
     * Gets the entryName value for this SettingsDTO.
     * 
     * @return entryName
     */
    public java.lang.String getEntryName() {
        return entryName;
    }


    /**
     * Sets the entryName value for this SettingsDTO.
     * 
     * @param entryName
     */
    public void setEntryName(java.lang.String entryName) {
        this.entryName = entryName;
    }


    /**
     * Gets the stringParam1 value for this SettingsDTO.
     * 
     * @return stringParam1
     */
    public java.lang.String getStringParam1() {
        return stringParam1;
    }


    /**
     * Sets the stringParam1 value for this SettingsDTO.
     * 
     * @param stringParam1
     */
    public void setStringParam1(java.lang.String stringParam1) {
        this.stringParam1 = stringParam1;
    }


    /**
     * Gets the stringParam2 value for this SettingsDTO.
     * 
     * @return stringParam2
     */
    public java.lang.String getStringParam2() {
        return stringParam2;
    }


    /**
     * Sets the stringParam2 value for this SettingsDTO.
     * 
     * @param stringParam2
     */
    public void setStringParam2(java.lang.String stringParam2) {
        this.stringParam2 = stringParam2;
    }


    /**
     * Gets the intParam1 value for this SettingsDTO.
     * 
     * @return intParam1
     */
    public int getIntParam1() {
        return intParam1;
    }


    /**
     * Sets the intParam1 value for this SettingsDTO.
     * 
     * @param intParam1
     */
    public void setIntParam1(int intParam1) {
        this.intParam1 = intParam1;
    }


    /**
     * Gets the intParam2 value for this SettingsDTO.
     * 
     * @return intParam2
     */
    public int getIntParam2() {
        return intParam2;
    }


    /**
     * Sets the intParam2 value for this SettingsDTO.
     * 
     * @param intParam2
     */
    public void setIntParam2(int intParam2) {
        this.intParam2 = intParam2;
    }


    /**
     * Gets the dateParam1 value for this SettingsDTO.
     * 
     * @return dateParam1
     */
    public java.util.Calendar getDateParam1() {
        return dateParam1;
    }


    /**
     * Sets the dateParam1 value for this SettingsDTO.
     * 
     * @param dateParam1
     */
    public void setDateParam1(java.util.Calendar dateParam1) {
        this.dateParam1 = dateParam1;
    }


    /**
     * Gets the dateParam2 value for this SettingsDTO.
     * 
     * @return dateParam2
     */
    public java.util.Calendar getDateParam2() {
        return dateParam2;
    }


    /**
     * Sets the dateParam2 value for this SettingsDTO.
     * 
     * @param dateParam2
     */
    public void setDateParam2(java.util.Calendar dateParam2) {
        this.dateParam2 = dateParam2;
    }


    /**
     * Gets the textParam1 value for this SettingsDTO.
     * 
     * @return textParam1
     */
    public java.lang.String getTextParam1() {
        return textParam1;
    }


    /**
     * Sets the textParam1 value for this SettingsDTO.
     * 
     * @param textParam1
     */
    public void setTextParam1(java.lang.String textParam1) {
        this.textParam1 = textParam1;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SettingsDTO)) return false;
        SettingsDTO other = (SettingsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            ((this.refObjectType==null && other.getRefObjectType()==null) || 
             (this.refObjectType!=null &&
              this.refObjectType.equals(other.getRefObjectType()))) &&
            this.refObjectId == other.getRefObjectId() &&
            ((this.entryName==null && other.getEntryName()==null) || 
             (this.entryName!=null &&
              this.entryName.equals(other.getEntryName()))) &&
            ((this.stringParam1==null && other.getStringParam1()==null) || 
             (this.stringParam1!=null &&
              this.stringParam1.equals(other.getStringParam1()))) &&
            ((this.stringParam2==null && other.getStringParam2()==null) || 
             (this.stringParam2!=null &&
              this.stringParam2.equals(other.getStringParam2()))) &&
            this.intParam1 == other.getIntParam1() &&
            this.intParam2 == other.getIntParam2() &&
            ((this.dateParam1==null && other.getDateParam1()==null) || 
             (this.dateParam1!=null &&
              this.dateParam1.equals(other.getDateParam1()))) &&
            ((this.dateParam2==null && other.getDateParam2()==null) || 
             (this.dateParam2!=null &&
              this.dateParam2.equals(other.getDateParam2()))) &&
            ((this.textParam1==null && other.getTextParam1()==null) || 
             (this.textParam1!=null &&
              this.textParam1.equals(other.getTextParam1())));
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
        _hashCode += getObjectId();
        if (getRefObjectType() != null) {
            _hashCode += getRefObjectType().hashCode();
        }
        _hashCode += getRefObjectId();
        if (getEntryName() != null) {
            _hashCode += getEntryName().hashCode();
        }
        if (getStringParam1() != null) {
            _hashCode += getStringParam1().hashCode();
        }
        if (getStringParam2() != null) {
            _hashCode += getStringParam2().hashCode();
        }
        _hashCode += getIntParam1();
        _hashCode += getIntParam2();
        if (getDateParam1() != null) {
            _hashCode += getDateParam1().hashCode();
        }
        if (getDateParam2() != null) {
            _hashCode += getDateParam2().hashCode();
        }
        if (getTextParam1() != null) {
            _hashCode += getTextParam1().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SettingsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SettingsDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refObjectType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "RefObjectType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refObjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "RefObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entryName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EntryName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stringParam1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "StringParam1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stringParam2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "StringParam2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intParam1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IntParam1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intParam2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IntParam2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateParam1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DateParam1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateParam2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DateParam2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textParam1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TextParam1"));
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
