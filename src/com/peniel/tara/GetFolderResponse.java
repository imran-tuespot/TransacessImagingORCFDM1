/**
 * GetFolderResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetFolderResponse  implements java.io.Serializable {
    private com.peniel.tara.FolderDTO getFolderResult;

    public GetFolderResponse() {
    }

    public GetFolderResponse(
           com.peniel.tara.FolderDTO getFolderResult) {
           this.getFolderResult = getFolderResult;
    }


    /**
     * Gets the getFolderResult value for this GetFolderResponse.
     * 
     * @return getFolderResult
     */
    public com.peniel.tara.FolderDTO getGetFolderResult() {
        return getFolderResult;
    }


    /**
     * Sets the getFolderResult value for this GetFolderResponse.
     * 
     * @param getFolderResult
     */
    public void setGetFolderResult(com.peniel.tara.FolderDTO getFolderResult) {
        this.getFolderResult = getFolderResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetFolderResponse)) return false;
        GetFolderResponse other = (GetFolderResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getFolderResult==null && other.getGetFolderResult()==null) || 
             (this.getFolderResult!=null &&
              this.getFolderResult.equals(other.getGetFolderResult())));
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
        if (getGetFolderResult() != null) {
            _hashCode += getGetFolderResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetFolderResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetFolderResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getFolderResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetFolderResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FolderDTO"));
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
