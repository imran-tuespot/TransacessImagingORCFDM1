/**
 * GetCommentLikeBySubject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetCommentLikeBySubject  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int commentId;

    private int subjectId;

    public GetCommentLikeBySubject() {
    }

    public GetCommentLikeBySubject(
           java.lang.String loginContextId,
           int commentId,
           int subjectId) {
           this.loginContextId = loginContextId;
           this.commentId = commentId;
           this.subjectId = subjectId;
    }


    /**
     * Gets the loginContextId value for this GetCommentLikeBySubject.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetCommentLikeBySubject.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the commentId value for this GetCommentLikeBySubject.
     * 
     * @return commentId
     */
    public int getCommentId() {
        return commentId;
    }


    /**
     * Sets the commentId value for this GetCommentLikeBySubject.
     * 
     * @param commentId
     */
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }


    /**
     * Gets the subjectId value for this GetCommentLikeBySubject.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this GetCommentLikeBySubject.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCommentLikeBySubject)) return false;
        GetCommentLikeBySubject other = (GetCommentLikeBySubject) obj;
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
            this.commentId == other.getCommentId() &&
            this.subjectId == other.getSubjectId();
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
        _hashCode += getCommentId();
        _hashCode += getSubjectId();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCommentLikeBySubject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetCommentLikeBySubject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "commentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectId"));
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