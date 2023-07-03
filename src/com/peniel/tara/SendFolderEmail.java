/**
 * SendFolderEmail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SendFolderEmail  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int folderId;

    private int[] subjectIds;

    private java.lang.String subjectLine;

    private java.lang.String textblock;

    public SendFolderEmail() {
    }

    public SendFolderEmail(
           java.lang.String loginContextId,
           int folderId,
           int[] subjectIds,
           java.lang.String subjectLine,
           java.lang.String textblock) {
           this.loginContextId = loginContextId;
           this.folderId = folderId;
           this.subjectIds = subjectIds;
           this.subjectLine = subjectLine;
           this.textblock = textblock;
    }


    /**
     * Gets the loginContextId value for this SendFolderEmail.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this SendFolderEmail.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the folderId value for this SendFolderEmail.
     * 
     * @return folderId
     */
    public int getFolderId() {
        return folderId;
    }


    /**
     * Sets the folderId value for this SendFolderEmail.
     * 
     * @param folderId
     */
    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }


    /**
     * Gets the subjectIds value for this SendFolderEmail.
     * 
     * @return subjectIds
     */
    public int[] getSubjectIds() {
        return subjectIds;
    }


    /**
     * Sets the subjectIds value for this SendFolderEmail.
     * 
     * @param subjectIds
     */
    public void setSubjectIds(int[] subjectIds) {
        this.subjectIds = subjectIds;
    }


    /**
     * Gets the subjectLine value for this SendFolderEmail.
     * 
     * @return subjectLine
     */
    public java.lang.String getSubjectLine() {
        return subjectLine;
    }


    /**
     * Sets the subjectLine value for this SendFolderEmail.
     * 
     * @param subjectLine
     */
    public void setSubjectLine(java.lang.String subjectLine) {
        this.subjectLine = subjectLine;
    }


    /**
     * Gets the textblock value for this SendFolderEmail.
     * 
     * @return textblock
     */
    public java.lang.String getTextblock() {
        return textblock;
    }


    /**
     * Sets the textblock value for this SendFolderEmail.
     * 
     * @param textblock
     */
    public void setTextblock(java.lang.String textblock) {
        this.textblock = textblock;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendFolderEmail)) return false;
        SendFolderEmail other = (SendFolderEmail) obj;
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
            this.folderId == other.getFolderId() &&
            ((this.subjectIds==null && other.getSubjectIds()==null) || 
             (this.subjectIds!=null &&
              java.util.Arrays.equals(this.subjectIds, other.getSubjectIds()))) &&
            ((this.subjectLine==null && other.getSubjectLine()==null) || 
             (this.subjectLine!=null &&
              this.subjectLine.equals(other.getSubjectLine()))) &&
            ((this.textblock==null && other.getTextblock()==null) || 
             (this.textblock!=null &&
              this.textblock.equals(other.getTextblock())));
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
        _hashCode += getFolderId();
        if (getSubjectIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubjectIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubjectIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSubjectLine() != null) {
            _hashCode += getSubjectLine().hashCode();
        }
        if (getTextblock() != null) {
            _hashCode += getTextblock().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendFolderEmail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">SendFolderEmail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folderId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "folderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectLine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectLine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textblock");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "textblock"));
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
