/**
 * GetReconcileReport.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetReconcileReport  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.ListCommentParamsDTO param;

    private boolean showLinks;

    private boolean unformatted;

    public GetReconcileReport() {
    }

    public GetReconcileReport(
           java.lang.String loginContextId,
           com.peniel.tara.ListCommentParamsDTO param,
           boolean showLinks,
           boolean unformatted) {
           this.loginContextId = loginContextId;
           this.param = param;
           this.showLinks = showLinks;
           this.unformatted = unformatted;
    }


    /**
     * Gets the loginContextId value for this GetReconcileReport.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetReconcileReport.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the param value for this GetReconcileReport.
     * 
     * @return param
     */
    public com.peniel.tara.ListCommentParamsDTO getParam() {
        return param;
    }


    /**
     * Sets the param value for this GetReconcileReport.
     * 
     * @param param
     */
    public void setParam(com.peniel.tara.ListCommentParamsDTO param) {
        this.param = param;
    }


    /**
     * Gets the showLinks value for this GetReconcileReport.
     * 
     * @return showLinks
     */
    public boolean isShowLinks() {
        return showLinks;
    }


    /**
     * Sets the showLinks value for this GetReconcileReport.
     * 
     * @param showLinks
     */
    public void setShowLinks(boolean showLinks) {
        this.showLinks = showLinks;
    }


    /**
     * Gets the unformatted value for this GetReconcileReport.
     * 
     * @return unformatted
     */
    public boolean isUnformatted() {
        return unformatted;
    }


    /**
     * Sets the unformatted value for this GetReconcileReport.
     * 
     * @param unformatted
     */
    public void setUnformatted(boolean unformatted) {
        this.unformatted = unformatted;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetReconcileReport)) return false;
        GetReconcileReport other = (GetReconcileReport) obj;
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
            ((this.param==null && other.getParam()==null) || 
             (this.param!=null &&
              this.param.equals(other.getParam()))) &&
            this.showLinks == other.isShowLinks() &&
            this.unformatted == other.isUnformatted();
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
        if (getParam() != null) {
            _hashCode += getParam().hashCode();
        }
        _hashCode += (isShowLinks() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isUnformatted() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetReconcileReport.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetReconcileReport"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "param"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListCommentParamsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showLinks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "showLinks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unformatted");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "unformatted"));
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
