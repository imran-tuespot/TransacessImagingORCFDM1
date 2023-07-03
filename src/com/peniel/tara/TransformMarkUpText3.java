/**
 * TransformMarkUpText3.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class TransformMarkUpText3  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.TransformMarkUpText3XmlDiff xmlDiff;

    private com.peniel.tara.TransformMarkUpText3ColorMap colorMap;

    private java.lang.String paragraphColor;

    private boolean isRecon;

    private boolean showMerged;

    public TransformMarkUpText3() {
    }

    public TransformMarkUpText3(
           java.lang.String loginContextId,
           com.peniel.tara.TransformMarkUpText3XmlDiff xmlDiff,
           com.peniel.tara.TransformMarkUpText3ColorMap colorMap,
           java.lang.String paragraphColor,
           boolean isRecon,
           boolean showMerged) {
           this.loginContextId = loginContextId;
           this.xmlDiff = xmlDiff;
           this.colorMap = colorMap;
           this.paragraphColor = paragraphColor;
           this.isRecon = isRecon;
           this.showMerged = showMerged;
    }


    /**
     * Gets the loginContextId value for this TransformMarkUpText3.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this TransformMarkUpText3.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the xmlDiff value for this TransformMarkUpText3.
     * 
     * @return xmlDiff
     */
    public com.peniel.tara.TransformMarkUpText3XmlDiff getXmlDiff() {
        return xmlDiff;
    }


    /**
     * Sets the xmlDiff value for this TransformMarkUpText3.
     * 
     * @param xmlDiff
     */
    public void setXmlDiff(com.peniel.tara.TransformMarkUpText3XmlDiff xmlDiff) {
        this.xmlDiff = xmlDiff;
    }


    /**
     * Gets the colorMap value for this TransformMarkUpText3.
     * 
     * @return colorMap
     */
    public com.peniel.tara.TransformMarkUpText3ColorMap getColorMap() {
        return colorMap;
    }


    /**
     * Sets the colorMap value for this TransformMarkUpText3.
     * 
     * @param colorMap
     */
    public void setColorMap(com.peniel.tara.TransformMarkUpText3ColorMap colorMap) {
        this.colorMap = colorMap;
    }


    /**
     * Gets the paragraphColor value for this TransformMarkUpText3.
     * 
     * @return paragraphColor
     */
    public java.lang.String getParagraphColor() {
        return paragraphColor;
    }


    /**
     * Sets the paragraphColor value for this TransformMarkUpText3.
     * 
     * @param paragraphColor
     */
    public void setParagraphColor(java.lang.String paragraphColor) {
        this.paragraphColor = paragraphColor;
    }


    /**
     * Gets the isRecon value for this TransformMarkUpText3.
     * 
     * @return isRecon
     */
    public boolean isIsRecon() {
        return isRecon;
    }


    /**
     * Sets the isRecon value for this TransformMarkUpText3.
     * 
     * @param isRecon
     */
    public void setIsRecon(boolean isRecon) {
        this.isRecon = isRecon;
    }


    /**
     * Gets the showMerged value for this TransformMarkUpText3.
     * 
     * @return showMerged
     */
    public boolean isShowMerged() {
        return showMerged;
    }


    /**
     * Sets the showMerged value for this TransformMarkUpText3.
     * 
     * @param showMerged
     */
    public void setShowMerged(boolean showMerged) {
        this.showMerged = showMerged;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransformMarkUpText3)) return false;
        TransformMarkUpText3 other = (TransformMarkUpText3) obj;
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
            ((this.colorMap==null && other.getColorMap()==null) || 
             (this.colorMap!=null &&
              this.colorMap.equals(other.getColorMap()))) &&
            ((this.paragraphColor==null && other.getParagraphColor()==null) || 
             (this.paragraphColor!=null &&
              this.paragraphColor.equals(other.getParagraphColor()))) &&
            this.isRecon == other.isIsRecon() &&
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
        if (getColorMap() != null) {
            _hashCode += getColorMap().hashCode();
        }
        if (getParagraphColor() != null) {
            _hashCode += getParagraphColor().hashCode();
        }
        _hashCode += (isIsRecon() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isShowMerged() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransformMarkUpText3.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">TransformMarkUpText3"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">>TransformMarkUpText3>xmlDiff"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("colorMap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "colorMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">>TransformMarkUpText3>colorMap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paragraphColor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "paragraphColor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRecon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "isRecon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
