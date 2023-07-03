/**
 * FeedbackConfigDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class FeedbackConfigDTO  implements java.io.Serializable {
    private boolean isFeebackEnabled;

    private com.peniel.tara.FeedbackDTO feedback;

    public FeedbackConfigDTO() {
    }

    public FeedbackConfigDTO(
           boolean isFeebackEnabled,
           com.peniel.tara.FeedbackDTO feedback) {
           this.isFeebackEnabled = isFeebackEnabled;
           this.feedback = feedback;
    }


    /**
     * Gets the isFeebackEnabled value for this FeedbackConfigDTO.
     * 
     * @return isFeebackEnabled
     */
    public boolean isIsFeebackEnabled() {
        return isFeebackEnabled;
    }


    /**
     * Sets the isFeebackEnabled value for this FeedbackConfigDTO.
     * 
     * @param isFeebackEnabled
     */
    public void setIsFeebackEnabled(boolean isFeebackEnabled) {
        this.isFeebackEnabled = isFeebackEnabled;
    }


    /**
     * Gets the feedback value for this FeedbackConfigDTO.
     * 
     * @return feedback
     */
    public com.peniel.tara.FeedbackDTO getFeedback() {
        return feedback;
    }


    /**
     * Sets the feedback value for this FeedbackConfigDTO.
     * 
     * @param feedback
     */
    public void setFeedback(com.peniel.tara.FeedbackDTO feedback) {
        this.feedback = feedback;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FeedbackConfigDTO)) return false;
        FeedbackConfigDTO other = (FeedbackConfigDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.isFeebackEnabled == other.isIsFeebackEnabled() &&
            ((this.feedback==null && other.getFeedback()==null) || 
             (this.feedback!=null &&
              this.feedback.equals(other.getFeedback())));
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
        _hashCode += (isIsFeebackEnabled() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFeedback() != null) {
            _hashCode += getFeedback().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FeedbackConfigDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackConfigDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFeebackEnabled");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsFeebackEnabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feedback");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Feedback"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackDTO"));
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
