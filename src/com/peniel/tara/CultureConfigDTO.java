/**
 * CultureConfigDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class CultureConfigDTO  implements java.io.Serializable {
    private java.lang.String defaultCultureName;

    private boolean useDefaultForNewUsers;

    private boolean enforceDefaultCulture;

    private com.peniel.tara.CultureDTO[] cultures;

    public CultureConfigDTO() {
    }

    public CultureConfigDTO(
           java.lang.String defaultCultureName,
           boolean useDefaultForNewUsers,
           boolean enforceDefaultCulture,
           com.peniel.tara.CultureDTO[] cultures) {
           this.defaultCultureName = defaultCultureName;
           this.useDefaultForNewUsers = useDefaultForNewUsers;
           this.enforceDefaultCulture = enforceDefaultCulture;
           this.cultures = cultures;
    }


    /**
     * Gets the defaultCultureName value for this CultureConfigDTO.
     * 
     * @return defaultCultureName
     */
    public java.lang.String getDefaultCultureName() {
        return defaultCultureName;
    }


    /**
     * Sets the defaultCultureName value for this CultureConfigDTO.
     * 
     * @param defaultCultureName
     */
    public void setDefaultCultureName(java.lang.String defaultCultureName) {
        this.defaultCultureName = defaultCultureName;
    }


    /**
     * Gets the useDefaultForNewUsers value for this CultureConfigDTO.
     * 
     * @return useDefaultForNewUsers
     */
    public boolean isUseDefaultForNewUsers() {
        return useDefaultForNewUsers;
    }


    /**
     * Sets the useDefaultForNewUsers value for this CultureConfigDTO.
     * 
     * @param useDefaultForNewUsers
     */
    public void setUseDefaultForNewUsers(boolean useDefaultForNewUsers) {
        this.useDefaultForNewUsers = useDefaultForNewUsers;
    }


    /**
     * Gets the enforceDefaultCulture value for this CultureConfigDTO.
     * 
     * @return enforceDefaultCulture
     */
    public boolean isEnforceDefaultCulture() {
        return enforceDefaultCulture;
    }


    /**
     * Sets the enforceDefaultCulture value for this CultureConfigDTO.
     * 
     * @param enforceDefaultCulture
     */
    public void setEnforceDefaultCulture(boolean enforceDefaultCulture) {
        this.enforceDefaultCulture = enforceDefaultCulture;
    }


    /**
     * Gets the cultures value for this CultureConfigDTO.
     * 
     * @return cultures
     */
    public com.peniel.tara.CultureDTO[] getCultures() {
        return cultures;
    }


    /**
     * Sets the cultures value for this CultureConfigDTO.
     * 
     * @param cultures
     */
    public void setCultures(com.peniel.tara.CultureDTO[] cultures) {
        this.cultures = cultures;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CultureConfigDTO)) return false;
        CultureConfigDTO other = (CultureConfigDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.defaultCultureName==null && other.getDefaultCultureName()==null) || 
             (this.defaultCultureName!=null &&
              this.defaultCultureName.equals(other.getDefaultCultureName()))) &&
            this.useDefaultForNewUsers == other.isUseDefaultForNewUsers() &&
            this.enforceDefaultCulture == other.isEnforceDefaultCulture() &&
            ((this.cultures==null && other.getCultures()==null) || 
             (this.cultures!=null &&
              java.util.Arrays.equals(this.cultures, other.getCultures())));
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
        if (getDefaultCultureName() != null) {
            _hashCode += getDefaultCultureName().hashCode();
        }
        _hashCode += (isUseDefaultForNewUsers() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isEnforceDefaultCulture() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCultures() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCultures());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCultures(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CultureConfigDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CultureConfigDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultCultureName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DefaultCultureName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useDefaultForNewUsers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UseDefaultForNewUsers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enforceDefaultCulture");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EnforceDefaultCulture"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cultures");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Cultures"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CultureDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CultureDTO"));
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
