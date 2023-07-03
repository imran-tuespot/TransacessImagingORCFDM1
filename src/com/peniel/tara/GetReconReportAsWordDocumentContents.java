/**
 * GetReconReportAsWordDocumentContents.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetReconReportAsWordDocumentContents  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.DocMarkUpParamsDTO docMarkUpParamsDTO;

    private boolean supportRichText;

    private com.peniel.tara.GetReconReportAsWordDocumentContentsSummaryEl summaryEl;

    private com.peniel.tara.GetReconReportAsWordDocumentContentsReportParamEL reportParamEL;

    public GetReconReportAsWordDocumentContents() {
    }

    public GetReconReportAsWordDocumentContents(
           java.lang.String loginContextId,
           com.peniel.tara.DocMarkUpParamsDTO docMarkUpParamsDTO,
           boolean supportRichText,
           com.peniel.tara.GetReconReportAsWordDocumentContentsSummaryEl summaryEl,
           com.peniel.tara.GetReconReportAsWordDocumentContentsReportParamEL reportParamEL) {
           this.loginContextId = loginContextId;
           this.docMarkUpParamsDTO = docMarkUpParamsDTO;
           this.supportRichText = supportRichText;
           this.summaryEl = summaryEl;
           this.reportParamEL = reportParamEL;
    }


    /**
     * Gets the loginContextId value for this GetReconReportAsWordDocumentContents.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetReconReportAsWordDocumentContents.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the docMarkUpParamsDTO value for this GetReconReportAsWordDocumentContents.
     * 
     * @return docMarkUpParamsDTO
     */
    public com.peniel.tara.DocMarkUpParamsDTO getDocMarkUpParamsDTO() {
        return docMarkUpParamsDTO;
    }


    /**
     * Sets the docMarkUpParamsDTO value for this GetReconReportAsWordDocumentContents.
     * 
     * @param docMarkUpParamsDTO
     */
    public void setDocMarkUpParamsDTO(com.peniel.tara.DocMarkUpParamsDTO docMarkUpParamsDTO) {
        this.docMarkUpParamsDTO = docMarkUpParamsDTO;
    }


    /**
     * Gets the supportRichText value for this GetReconReportAsWordDocumentContents.
     * 
     * @return supportRichText
     */
    public boolean isSupportRichText() {
        return supportRichText;
    }


    /**
     * Sets the supportRichText value for this GetReconReportAsWordDocumentContents.
     * 
     * @param supportRichText
     */
    public void setSupportRichText(boolean supportRichText) {
        this.supportRichText = supportRichText;
    }


    /**
     * Gets the summaryEl value for this GetReconReportAsWordDocumentContents.
     * 
     * @return summaryEl
     */
    public com.peniel.tara.GetReconReportAsWordDocumentContentsSummaryEl getSummaryEl() {
        return summaryEl;
    }


    /**
     * Sets the summaryEl value for this GetReconReportAsWordDocumentContents.
     * 
     * @param summaryEl
     */
    public void setSummaryEl(com.peniel.tara.GetReconReportAsWordDocumentContentsSummaryEl summaryEl) {
        this.summaryEl = summaryEl;
    }


    /**
     * Gets the reportParamEL value for this GetReconReportAsWordDocumentContents.
     * 
     * @return reportParamEL
     */
    public com.peniel.tara.GetReconReportAsWordDocumentContentsReportParamEL getReportParamEL() {
        return reportParamEL;
    }


    /**
     * Sets the reportParamEL value for this GetReconReportAsWordDocumentContents.
     * 
     * @param reportParamEL
     */
    public void setReportParamEL(com.peniel.tara.GetReconReportAsWordDocumentContentsReportParamEL reportParamEL) {
        this.reportParamEL = reportParamEL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetReconReportAsWordDocumentContents)) return false;
        GetReconReportAsWordDocumentContents other = (GetReconReportAsWordDocumentContents) obj;
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
            ((this.docMarkUpParamsDTO==null && other.getDocMarkUpParamsDTO()==null) || 
             (this.docMarkUpParamsDTO!=null &&
              this.docMarkUpParamsDTO.equals(other.getDocMarkUpParamsDTO()))) &&
            this.supportRichText == other.isSupportRichText() &&
            ((this.summaryEl==null && other.getSummaryEl()==null) || 
             (this.summaryEl!=null &&
              this.summaryEl.equals(other.getSummaryEl()))) &&
            ((this.reportParamEL==null && other.getReportParamEL()==null) || 
             (this.reportParamEL!=null &&
              this.reportParamEL.equals(other.getReportParamEL())));
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
        if (getDocMarkUpParamsDTO() != null) {
            _hashCode += getDocMarkUpParamsDTO().hashCode();
        }
        _hashCode += (isSupportRichText() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSummaryEl() != null) {
            _hashCode += getSummaryEl().hashCode();
        }
        if (getReportParamEL() != null) {
            _hashCode += getReportParamEL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetReconReportAsWordDocumentContents.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetReconReportAsWordDocumentContents"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docMarkUpParamsDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "docMarkUpParamsDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocMarkUpParamsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportRichText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "supportRichText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryEl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "summaryEl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">>GetReconReportAsWordDocumentContents>summaryEl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportParamEL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "reportParamEL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">>GetReconReportAsWordDocumentContents>reportParamEL"));
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
