/**
 * GetLicenseForSubjectResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetLicenseForSubjectResponse  implements java.io.Serializable {
    private com.peniel.tara.LicenseDTO getLicenseForSubjectResult;

    public GetLicenseForSubjectResponse() {
    }

    public GetLicenseForSubjectResponse(
           com.peniel.tara.LicenseDTO getLicenseForSubjectResult) {
           this.getLicenseForSubjectResult = getLicenseForSubjectResult;
    }


    /**
     * Gets the getLicenseForSubjectResult value for this GetLicenseForSubjectResponse.
     * 
     * @return getLicenseForSubjectResult
     */
    public com.peniel.tara.LicenseDTO getGetLicenseForSubjectResult() {
        return getLicenseForSubjectResult;
    }


    /**
     * Sets the getLicenseForSubjectResult value for this GetLicenseForSubjectResponse.
     * 
     * @param getLicenseForSubjectResult
     */
    public void setGetLicenseForSubjectResult(com.peniel.tara.LicenseDTO getLicenseForSubjectResult) {
        this.getLicenseForSubjectResult = getLicenseForSubjectResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLicenseForSubjectResponse)) return false;
        GetLicenseForSubjectResponse other = (GetLicenseForSubjectResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getLicenseForSubjectResult==null && other.getGetLicenseForSubjectResult()==null) || 
             (this.getLicenseForSubjectResult!=null &&
              this.getLicenseForSubjectResult.equals(other.getGetLicenseForSubjectResult())));
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
        if (getGetLicenseForSubjectResult() != null) {
            _hashCode += getGetLicenseForSubjectResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLicenseForSubjectResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetLicenseForSubjectResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getLicenseForSubjectResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetLicenseForSubjectResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LicenseDTO"));
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
