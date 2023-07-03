/**
 * ValidateSmartEditRange.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ValidateSmartEditRange  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int documentId;

    private com.peniel.tara.EditDTO edit;

    private com.peniel.tara.EditDTO[] editsDto;

    public ValidateSmartEditRange() {
    }

    public ValidateSmartEditRange(
           java.lang.String loginContextId,
           int documentId,
           com.peniel.tara.EditDTO edit,
           com.peniel.tara.EditDTO[] editsDto) {
           this.loginContextId = loginContextId;
           this.documentId = documentId;
           this.edit = edit;
           this.editsDto = editsDto;
    }


    /**
     * Gets the loginContextId value for this ValidateSmartEditRange.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this ValidateSmartEditRange.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the documentId value for this ValidateSmartEditRange.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this ValidateSmartEditRange.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the edit value for this ValidateSmartEditRange.
     * 
     * @return edit
     */
    public com.peniel.tara.EditDTO getEdit() {
        return edit;
    }


    /**
     * Sets the edit value for this ValidateSmartEditRange.
     * 
     * @param edit
     */
    public void setEdit(com.peniel.tara.EditDTO edit) {
        this.edit = edit;
    }


    /**
     * Gets the editsDto value for this ValidateSmartEditRange.
     * 
     * @return editsDto
     */
    public com.peniel.tara.EditDTO[] getEditsDto() {
        return editsDto;
    }


    /**
     * Sets the editsDto value for this ValidateSmartEditRange.
     * 
     * @param editsDto
     */
    public void setEditsDto(com.peniel.tara.EditDTO[] editsDto) {
        this.editsDto = editsDto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ValidateSmartEditRange)) return false;
        ValidateSmartEditRange other = (ValidateSmartEditRange) obj;
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
            ((this.edit==null && other.getEdit()==null) || 
             (this.edit!=null &&
              this.edit.equals(other.getEdit()))) &&
            ((this.editsDto==null && other.getEditsDto()==null) || 
             (this.editsDto!=null &&
              java.util.Arrays.equals(this.editsDto, other.getEditsDto())));
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
        if (getEdit() != null) {
            _hashCode += getEdit().hashCode();
        }
        if (getEditsDto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEditsDto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEditsDto(), i);
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
        new org.apache.axis.description.TypeDesc(ValidateSmartEditRange.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ValidateSmartEditRange"));
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
        elemField.setFieldName("edit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "edit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editsDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "editsDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditDTO"));
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
