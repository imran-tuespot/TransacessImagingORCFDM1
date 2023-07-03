/**
 * ListEditVersionsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListEditVersionsResponse  implements java.io.Serializable {
    private com.peniel.tara.EditVersionDTO[] listEditVersionsResult;

    public ListEditVersionsResponse() {
    }

    public ListEditVersionsResponse(
           com.peniel.tara.EditVersionDTO[] listEditVersionsResult) {
           this.listEditVersionsResult = listEditVersionsResult;
    }


    /**
     * Gets the listEditVersionsResult value for this ListEditVersionsResponse.
     * 
     * @return listEditVersionsResult
     */
    public com.peniel.tara.EditVersionDTO[] getListEditVersionsResult() {
        return listEditVersionsResult;
    }


    /**
     * Sets the listEditVersionsResult value for this ListEditVersionsResponse.
     * 
     * @param listEditVersionsResult
     */
    public void setListEditVersionsResult(com.peniel.tara.EditVersionDTO[] listEditVersionsResult) {
        this.listEditVersionsResult = listEditVersionsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListEditVersionsResponse)) return false;
        ListEditVersionsResponse other = (ListEditVersionsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listEditVersionsResult==null && other.getListEditVersionsResult()==null) || 
             (this.listEditVersionsResult!=null &&
              java.util.Arrays.equals(this.listEditVersionsResult, other.getListEditVersionsResult())));
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
        if (getListEditVersionsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListEditVersionsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListEditVersionsResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListEditVersionsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListEditVersionsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listEditVersionsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListEditVersionsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditVersionDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditVersionDTO"));
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
