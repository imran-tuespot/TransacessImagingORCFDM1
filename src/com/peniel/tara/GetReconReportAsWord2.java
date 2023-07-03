/**
 * GetReconReportAsWord2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetReconReportAsWord2  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private com.peniel.tara.GetReconReportAsWord2CommentSelection commentSelection;

    private int reviewId;

    private boolean supportRichText;

    private com.peniel.tara.DocMarkUpParamsDTO paramDto;

    private boolean hasPermissionToLinkedReview;

    public GetReconReportAsWord2() {
    }

    public GetReconReportAsWord2(
           java.lang.String loginContextId,
           com.peniel.tara.GetReconReportAsWord2CommentSelection commentSelection,
           int reviewId,
           boolean supportRichText,
           com.peniel.tara.DocMarkUpParamsDTO paramDto,
           boolean hasPermissionToLinkedReview) {
           this.loginContextId = loginContextId;
           this.commentSelection = commentSelection;
           this.reviewId = reviewId;
           this.supportRichText = supportRichText;
           this.paramDto = paramDto;
           this.hasPermissionToLinkedReview = hasPermissionToLinkedReview;
    }


    /**
     * Gets the loginContextId value for this GetReconReportAsWord2.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetReconReportAsWord2.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the commentSelection value for this GetReconReportAsWord2.
     * 
     * @return commentSelection
     */
    public com.peniel.tara.GetReconReportAsWord2CommentSelection getCommentSelection() {
        return commentSelection;
    }


    /**
     * Sets the commentSelection value for this GetReconReportAsWord2.
     * 
     * @param commentSelection
     */
    public void setCommentSelection(com.peniel.tara.GetReconReportAsWord2CommentSelection commentSelection) {
        this.commentSelection = commentSelection;
    }


    /**
     * Gets the reviewId value for this GetReconReportAsWord2.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this GetReconReportAsWord2.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the supportRichText value for this GetReconReportAsWord2.
     * 
     * @return supportRichText
     */
    public boolean isSupportRichText() {
        return supportRichText;
    }


    /**
     * Sets the supportRichText value for this GetReconReportAsWord2.
     * 
     * @param supportRichText
     */
    public void setSupportRichText(boolean supportRichText) {
        this.supportRichText = supportRichText;
    }


    /**
     * Gets the paramDto value for this GetReconReportAsWord2.
     * 
     * @return paramDto
     */
    public com.peniel.tara.DocMarkUpParamsDTO getParamDto() {
        return paramDto;
    }


    /**
     * Sets the paramDto value for this GetReconReportAsWord2.
     * 
     * @param paramDto
     */
    public void setParamDto(com.peniel.tara.DocMarkUpParamsDTO paramDto) {
        this.paramDto = paramDto;
    }


    /**
     * Gets the hasPermissionToLinkedReview value for this GetReconReportAsWord2.
     * 
     * @return hasPermissionToLinkedReview
     */
    public boolean isHasPermissionToLinkedReview() {
        return hasPermissionToLinkedReview;
    }


    /**
     * Sets the hasPermissionToLinkedReview value for this GetReconReportAsWord2.
     * 
     * @param hasPermissionToLinkedReview
     */
    public void setHasPermissionToLinkedReview(boolean hasPermissionToLinkedReview) {
        this.hasPermissionToLinkedReview = hasPermissionToLinkedReview;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetReconReportAsWord2)) return false;
        GetReconReportAsWord2 other = (GetReconReportAsWord2) obj;
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
            ((this.commentSelection==null && other.getCommentSelection()==null) || 
             (this.commentSelection!=null &&
              this.commentSelection.equals(other.getCommentSelection()))) &&
            this.reviewId == other.getReviewId() &&
            this.supportRichText == other.isSupportRichText() &&
            ((this.paramDto==null && other.getParamDto()==null) || 
             (this.paramDto!=null &&
              this.paramDto.equals(other.getParamDto()))) &&
            this.hasPermissionToLinkedReview == other.isHasPermissionToLinkedReview();
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
        if (getCommentSelection() != null) {
            _hashCode += getCommentSelection().hashCode();
        }
        _hashCode += getReviewId();
        _hashCode += (isSupportRichText() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getParamDto() != null) {
            _hashCode += getParamDto().hashCode();
        }
        _hashCode += (isHasPermissionToLinkedReview() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetReconReportAsWord2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetReconReportAsWord2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentSelection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "commentSelection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">>GetReconReportAsWord2>commentSelection"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "reviewId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportRichText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "supportRichText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paramDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "paramDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocMarkUpParamsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasPermissionToLinkedReview");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "hasPermissionToLinkedReview"));
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
