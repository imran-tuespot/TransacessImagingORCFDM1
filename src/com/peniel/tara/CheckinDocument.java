/**
 * CheckinDocument.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class CheckinDocument  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private java.lang.String extSource;

    private java.lang.String extRef;

    private int checkinMode;

    private com.peniel.tara.FileContentDTO contents;

    private java.lang.String extraInfo;

    private int reviewid;

    private int documentid;

    public CheckinDocument() {
    }

    public CheckinDocument(
           java.lang.String loginContextId,
           java.lang.String extSource,
           java.lang.String extRef,
           int checkinMode,
           com.peniel.tara.FileContentDTO contents,
           java.lang.String extraInfo,
           int reviewid,
           int documentid) {
           this.loginContextId = loginContextId;
           this.extSource = extSource;
           this.extRef = extRef;
           this.checkinMode = checkinMode;
           this.contents = contents;
           this.extraInfo = extraInfo;
           this.reviewid = reviewid;
           this.documentid = documentid;
    }


    /**
     * Gets the loginContextId value for this CheckinDocument.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this CheckinDocument.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the extSource value for this CheckinDocument.
     * 
     * @return extSource
     */
    public java.lang.String getExtSource() {
        return extSource;
    }


    /**
     * Sets the extSource value for this CheckinDocument.
     * 
     * @param extSource
     */
    public void setExtSource(java.lang.String extSource) {
        this.extSource = extSource;
    }


    /**
     * Gets the extRef value for this CheckinDocument.
     * 
     * @return extRef
     */
    public java.lang.String getExtRef() {
        return extRef;
    }


    /**
     * Sets the extRef value for this CheckinDocument.
     * 
     * @param extRef
     */
    public void setExtRef(java.lang.String extRef) {
        this.extRef = extRef;
    }


    /**
     * Gets the checkinMode value for this CheckinDocument.
     * 
     * @return checkinMode
     */
    public int getCheckinMode() {
        return checkinMode;
    }


    /**
     * Sets the checkinMode value for this CheckinDocument.
     * 
     * @param checkinMode
     */
    public void setCheckinMode(int checkinMode) {
        this.checkinMode = checkinMode;
    }


    /**
     * Gets the contents value for this CheckinDocument.
     * 
     * @return contents
     */
    public com.peniel.tara.FileContentDTO getContents() {
        return contents;
    }


    /**
     * Sets the contents value for this CheckinDocument.
     * 
     * @param contents
     */
    public void setContents(com.peniel.tara.FileContentDTO contents) {
        this.contents = contents;
    }


    /**
     * Gets the extraInfo value for this CheckinDocument.
     * 
     * @return extraInfo
     */
    public java.lang.String getExtraInfo() {
        return extraInfo;
    }


    /**
     * Sets the extraInfo value for this CheckinDocument.
     * 
     * @param extraInfo
     */
    public void setExtraInfo(java.lang.String extraInfo) {
        this.extraInfo = extraInfo;
    }


    /**
     * Gets the reviewid value for this CheckinDocument.
     * 
     * @return reviewid
     */
    public int getReviewid() {
        return reviewid;
    }


    /**
     * Sets the reviewid value for this CheckinDocument.
     * 
     * @param reviewid
     */
    public void setReviewid(int reviewid) {
        this.reviewid = reviewid;
    }


    /**
     * Gets the documentid value for this CheckinDocument.
     * 
     * @return documentid
     */
    public int getDocumentid() {
        return documentid;
    }


    /**
     * Sets the documentid value for this CheckinDocument.
     * 
     * @param documentid
     */
    public void setDocumentid(int documentid) {
        this.documentid = documentid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckinDocument)) return false;
        CheckinDocument other = (CheckinDocument) obj;
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
            ((this.extSource==null && other.getExtSource()==null) || 
             (this.extSource!=null &&
              this.extSource.equals(other.getExtSource()))) &&
            ((this.extRef==null && other.getExtRef()==null) || 
             (this.extRef!=null &&
              this.extRef.equals(other.getExtRef()))) &&
            this.checkinMode == other.getCheckinMode() &&
            ((this.contents==null && other.getContents()==null) || 
             (this.contents!=null &&
              this.contents.equals(other.getContents()))) &&
            ((this.extraInfo==null && other.getExtraInfo()==null) || 
             (this.extraInfo!=null &&
              this.extraInfo.equals(other.getExtraInfo()))) &&
            this.reviewid == other.getReviewid() &&
            this.documentid == other.getDocumentid();
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
        if (getExtSource() != null) {
            _hashCode += getExtSource().hashCode();
        }
        if (getExtRef() != null) {
            _hashCode += getExtRef().hashCode();
        }
        _hashCode += getCheckinMode();
        if (getContents() != null) {
            _hashCode += getContents().hashCode();
        }
        if (getExtraInfo() != null) {
            _hashCode += getExtraInfo().hashCode();
        }
        _hashCode += getReviewid();
        _hashCode += getDocumentid();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CheckinDocument.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">CheckinDocument"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "extSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extRef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "extRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkinMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "checkinMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contents");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "contents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileContentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extraInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "extraInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "reviewid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "documentid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
