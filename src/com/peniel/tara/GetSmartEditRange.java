/**
 * GetSmartEditRange.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetSmartEditRange  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int documentId;

    private int modificationCount;

    private java.lang.String paragraphId;

    private boolean returnSection;

    public GetSmartEditRange() {
    }

    public GetSmartEditRange(
           java.lang.String loginContextId,
           int documentId,
           int modificationCount,
           java.lang.String paragraphId,
           boolean returnSection) {
           this.loginContextId = loginContextId;
           this.documentId = documentId;
           this.modificationCount = modificationCount;
           this.paragraphId = paragraphId;
           this.returnSection = returnSection;
    }


    /**
     * Gets the loginContextId value for this GetSmartEditRange.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetSmartEditRange.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the documentId value for this GetSmartEditRange.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this GetSmartEditRange.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the modificationCount value for this GetSmartEditRange.
     * 
     * @return modificationCount
     */
    public int getModificationCount() {
        return modificationCount;
    }


    /**
     * Sets the modificationCount value for this GetSmartEditRange.
     * 
     * @param modificationCount
     */
    public void setModificationCount(int modificationCount) {
        this.modificationCount = modificationCount;
    }


    /**
     * Gets the paragraphId value for this GetSmartEditRange.
     * 
     * @return paragraphId
     */
    public java.lang.String getParagraphId() {
        return paragraphId;
    }


    /**
     * Sets the paragraphId value for this GetSmartEditRange.
     * 
     * @param paragraphId
     */
    public void setParagraphId(java.lang.String paragraphId) {
        this.paragraphId = paragraphId;
    }


    /**
     * Gets the returnSection value for this GetSmartEditRange.
     * 
     * @return returnSection
     */
    public boolean isReturnSection() {
        return returnSection;
    }


    /**
     * Sets the returnSection value for this GetSmartEditRange.
     * 
     * @param returnSection
     */
    public void setReturnSection(boolean returnSection) {
        this.returnSection = returnSection;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSmartEditRange)) return false;
        GetSmartEditRange other = (GetSmartEditRange) obj;
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
            this.documentId == other.getDocumentId() &&
            this.modificationCount == other.getModificationCount() &&
            ((this.paragraphId==null && other.getParagraphId()==null) || 
             (this.paragraphId!=null &&
              this.paragraphId.equals(other.getParagraphId()))) &&
            this.returnSection == other.isReturnSection();
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
        _hashCode += getDocumentId();
        _hashCode += getModificationCount();
        if (getParagraphId() != null) {
            _hashCode += getParagraphId().hashCode();
        }
        _hashCode += (isReturnSection() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSmartEditRange.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetSmartEditRange"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "documentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modificationCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "modificationCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paragraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "paragraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnSection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "returnSection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
