/**
 * SaveSubjectExtSource.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SaveSubjectExtSource  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int subjectid;

    private com.peniel.tara.SubjectExtSourceDTO subjectExtSourceDTO;

    private java.lang.String password;

    private boolean neverSendEmail;

    public SaveSubjectExtSource() {
    }

    public SaveSubjectExtSource(
           java.lang.String loginContextId,
           int subjectid,
           com.peniel.tara.SubjectExtSourceDTO subjectExtSourceDTO,
           java.lang.String password,
           boolean neverSendEmail) {
           this.loginContextId = loginContextId;
           this.subjectid = subjectid;
           this.subjectExtSourceDTO = subjectExtSourceDTO;
           this.password = password;
           this.neverSendEmail = neverSendEmail;
    }


    /**
     * Gets the loginContextId value for this SaveSubjectExtSource.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this SaveSubjectExtSource.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the subjectid value for this SaveSubjectExtSource.
     * 
     * @return subjectid
     */
    public int getSubjectid() {
        return subjectid;
    }


    /**
     * Sets the subjectid value for this SaveSubjectExtSource.
     * 
     * @param subjectid
     */
    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }


    /**
     * Gets the subjectExtSourceDTO value for this SaveSubjectExtSource.
     * 
     * @return subjectExtSourceDTO
     */
    public com.peniel.tara.SubjectExtSourceDTO getSubjectExtSourceDTO() {
        return subjectExtSourceDTO;
    }


    /**
     * Sets the subjectExtSourceDTO value for this SaveSubjectExtSource.
     * 
     * @param subjectExtSourceDTO
     */
    public void setSubjectExtSourceDTO(com.peniel.tara.SubjectExtSourceDTO subjectExtSourceDTO) {
        this.subjectExtSourceDTO = subjectExtSourceDTO;
    }


    /**
     * Gets the password value for this SaveSubjectExtSource.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this SaveSubjectExtSource.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the neverSendEmail value for this SaveSubjectExtSource.
     * 
     * @return neverSendEmail
     */
    public boolean isNeverSendEmail() {
        return neverSendEmail;
    }


    /**
     * Sets the neverSendEmail value for this SaveSubjectExtSource.
     * 
     * @param neverSendEmail
     */
    public void setNeverSendEmail(boolean neverSendEmail) {
        this.neverSendEmail = neverSendEmail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SaveSubjectExtSource)) return false;
        SaveSubjectExtSource other = (SaveSubjectExtSource) obj;
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
            this.subjectid == other.getSubjectid() &&
            ((this.subjectExtSourceDTO==null && other.getSubjectExtSourceDTO()==null) || 
             (this.subjectExtSourceDTO!=null &&
              this.subjectExtSourceDTO.equals(other.getSubjectExtSourceDTO()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            this.neverSendEmail == other.isNeverSendEmail();
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
        _hashCode += getSubjectid();
        if (getSubjectExtSourceDTO() != null) {
            _hashCode += getSubjectExtSourceDTO().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        _hashCode += (isNeverSendEmail() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SaveSubjectExtSource.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">SaveSubjectExtSource"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectExtSourceDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "subjectExtSourceDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectExtSourceDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("neverSendEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "neverSendEmail"));
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
