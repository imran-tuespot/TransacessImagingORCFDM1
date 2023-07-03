/**
 * GetSubjectBySubjectRef2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetSubjectBySubjectRef2  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private java.lang.String subjectRef;

    private java.lang.String extSource;

    private boolean populateSubjectExtSources;

    public GetSubjectBySubjectRef2() {
    }

    public GetSubjectBySubjectRef2(
           java.lang.String loginContextId,
           java.lang.String subjectRef,
           java.lang.String extSource,
           boolean populateSubjectExtSources) {
           this.loginContextId = loginContextId;
           this.subjectRef = subjectRef;
           this.extSource = extSource;
           this.populateSubjectExtSources = populateSubjectExtSources;
    }


    /**
     * Gets the loginContextId value for this GetSubjectBySubjectRef2.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this GetSubjectBySubjectRef2.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the subjectRef value for this GetSubjectBySubjectRef2.
     * 
     * @return subjectRef
     */
    public java.lang.String getSubjectRef() {
        return subjectRef;
    }


    /**
     * Sets the subjectRef value for this GetSubjectBySubjectRef2.
     * 
     * @param subjectRef
     */
    public void setSubjectRef(java.lang.String subjectRef) {
        this.subjectRef = subjectRef;
    }


    /**
     * Gets the extSource value for this GetSubjectBySubjectRef2.
     * 
     * @return extSource
     */
    public java.lang.String getExtSource() {
        return extSource;
    }


    /**
     * Sets the extSource value for this GetSubjectBySubjectRef2.
     * 
     * @param extSource
     */
    public void setExtSource(java.lang.String extSource) {
        this.extSource = extSource;
    }


    /**
     * Gets the populateSubjectExtSources value for this GetSubjectBySubjectRef2.
     * 
     * @return populateSubjectExtSources
     */
    public boolean isPopulateSubjectExtSources() {
        return populateSubjectExtSources;
    }


    /**
     * Sets the populateSubjectExtSources value for this GetSubjectBySubjectRef2.
     * 
     * @param populateSubjectExtSources
     */
    public void setPopulateSubjectExtSources(boolean populateSubjectExtSources) {
        this.populateSubjectExtSources = populateSubjectExtSources;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSubjectBySubjectRef2)) return false;
        GetSubjectBySubjectRef2 other = (GetSubjectBySubjectRef2) obj;
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
            ((this.subjectRef==null && other.getSubjectRef()==null) || 
             (this.subjectRef!=null &&
              this.subjectRef.equals(other.getSubjectRef()))) &&
            ((this.extSource==null && other.getExtSource()==null) || 
             (this.extSource!=null &&
              this.extSource.equals(other.getExtSource()))) &&
            this.populateSubjectExtSources == other.isPopulateSubjectExtSources();
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
        if (getSubjectRef() != null) {
            _hashCode += getSubjectRef().hashCode();
        }
        if (getExtSource() != null) {
            _hashCode += getExtSource().hashCode();
        }
        _hashCode += (isPopulateSubjectExtSources() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSubjectBySubjectRef2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetSubjectBySubjectRef2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectRef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectRef"));
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
        elemField.setFieldName("populateSubjectExtSources");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "populateSubjectExtSources"));
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
