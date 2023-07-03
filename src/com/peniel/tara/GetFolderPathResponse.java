/**
 * GetFolderPathResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetFolderPathResponse  implements java.io.Serializable {
    private com.peniel.tara.FolderDTO[] getFolderPathResult;

    public GetFolderPathResponse() {
    }

    public GetFolderPathResponse(
           com.peniel.tara.FolderDTO[] getFolderPathResult) {
           this.getFolderPathResult = getFolderPathResult;
    }


    /**
     * Gets the getFolderPathResult value for this GetFolderPathResponse.
     * 
     * @return getFolderPathResult
     */
    public com.peniel.tara.FolderDTO[] getGetFolderPathResult() {
        return getFolderPathResult;
    }


    /**
     * Sets the getFolderPathResult value for this GetFolderPathResponse.
     * 
     * @param getFolderPathResult
     */
    public void setGetFolderPathResult(com.peniel.tara.FolderDTO[] getFolderPathResult) {
        this.getFolderPathResult = getFolderPathResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetFolderPathResponse)) return false;
        GetFolderPathResponse other = (GetFolderPathResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getFolderPathResult==null && other.getGetFolderPathResult()==null) || 
             (this.getFolderPathResult!=null &&
              java.util.Arrays.equals(this.getFolderPathResult, other.getGetFolderPathResult())));
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
        if (getGetFolderPathResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetFolderPathResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetFolderPathResult(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetFolderPathResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetFolderPathResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getFolderPathResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetFolderPathResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FolderDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FolderDTO"));
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
