/**
 * TransformMarkUpText2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class TransformMarkUpText2  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.TransformMarkUpText2XmlDiff xmlDiff;

    private boolean showMerged;

    public TransformMarkUpText2() {
    }

    public TransformMarkUpText2(
           java.lang.String loginContextId,
           com.peniel.tara.TransformMarkUpText2XmlDiff xmlDiff,
           boolean showMerged) {
           this.loginContextId = loginContextId;
           this.xmlDiff = xmlDiff;
           this.showMerged = showMerged;
    }


    /**
     * Gets the loginContextId value for this TransformMarkUpText2.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this TransformMarkUpText2.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the xmlDiff value for this TransformMarkUpText2.
     * 
     * @return xmlDiff
     */
    public com.peniel.tara.TransformMarkUpText2XmlDiff getXmlDiff() {
        return xmlDiff;
    }


    /**
     * Sets the xmlDiff value for this TransformMarkUpText2.
     * 
     * @param xmlDiff
     */
    public void setXmlDiff(com.peniel.tara.TransformMarkUpText2XmlDiff xmlDiff) {
        this.xmlDiff = xmlDiff;
    }


    /**
     * Gets the showMerged value for this TransformMarkUpText2.
     * 
     * @return showMerged
     */
    public boolean isShowMerged() {
        return showMerged;
    }


    /**
     * Sets the showMerged value for this TransformMarkUpText2.
     * 
     * @param showMerged
     */
    public void setShowMerged(boolean showMerged) {
        this.showMerged = showMerged;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransformMarkUpText2)) return false;
        TransformMarkUpText2 other = (TransformMarkUpText2) obj;
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
            ((this.xmlDiff==null && other.getXmlDiff()==null) || 
             (this.xmlDiff!=null &&
              this.xmlDiff.equals(other.getXmlDiff()))) &&
            this.showMerged == other.isShowMerged();
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
        if (getXmlDiff() != null) {
            _hashCode += getXmlDiff().hashCode();
        }
        _hashCode += (isShowMerged() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransformMarkUpText2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">TransformMarkUpText2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlDiff");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "xmlDiff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">>TransformMarkUpText2>xmlDiff"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showMerged");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "showMerged"));
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
