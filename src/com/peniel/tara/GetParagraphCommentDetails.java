/**
 * GetParagraphCommentDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetParagraphCommentDetails  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.ListCommentParamsDTO listCommentParamsDto;

    private java.lang.String originalText;

    public GetParagraphCommentDetails() {
    }

    public GetParagraphCommentDetails(
           java.lang.String loginContextId,
           com.peniel.tara.ListCommentParamsDTO listCommentParamsDto,
           java.lang.String originalText) {
           this.loginContextId = loginContextId;
           this.listCommentParamsDto = listCommentParamsDto;
           this.originalText = originalText;
    }


    /**
     * Gets the loginContextId value for this GetParagraphCommentDetails.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetParagraphCommentDetails.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the listCommentParamsDto value for this GetParagraphCommentDetails.
     * 
     * @return listCommentParamsDto
     */
    public com.peniel.tara.ListCommentParamsDTO getListCommentParamsDto() {
        return listCommentParamsDto;
    }


    /**
     * Sets the listCommentParamsDto value for this GetParagraphCommentDetails.
     * 
     * @param listCommentParamsDto
     */
    public void setListCommentParamsDto(com.peniel.tara.ListCommentParamsDTO listCommentParamsDto) {
        this.listCommentParamsDto = listCommentParamsDto;
    }


    /**
     * Gets the originalText value for this GetParagraphCommentDetails.
     * 
     * @return originalText
     */
    public java.lang.String getOriginalText() {
        return originalText;
    }


    /**
     * Sets the originalText value for this GetParagraphCommentDetails.
     * 
     * @param originalText
     */
    public void setOriginalText(java.lang.String originalText) {
        this.originalText = originalText;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetParagraphCommentDetails)) return false;
        GetParagraphCommentDetails other = (GetParagraphCommentDetails) obj;
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
            ((this.listCommentParamsDto==null && other.getListCommentParamsDto()==null) || 
             (this.listCommentParamsDto!=null &&
              this.listCommentParamsDto.equals(other.getListCommentParamsDto()))) &&
            ((this.originalText==null && other.getOriginalText()==null) || 
             (this.originalText!=null &&
              this.originalText.equals(other.getOriginalText())));
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
        if (getListCommentParamsDto() != null) {
            _hashCode += getListCommentParamsDto().hashCode();
        }
        if (getOriginalText() != null) {
            _hashCode += getOriginalText().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetParagraphCommentDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetParagraphCommentDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listCommentParamsDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "listCommentParamsDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListCommentParamsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "originalText"));
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
