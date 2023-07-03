/**
 * ListTrustedClientsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListTrustedClientsResponse  implements java.io.Serializable {
    private com.peniel.tara.TrustedClientDTO[] listTrustedClientsResult;

    public ListTrustedClientsResponse() {
    }

    public ListTrustedClientsResponse(
           com.peniel.tara.TrustedClientDTO[] listTrustedClientsResult) {
           this.listTrustedClientsResult = listTrustedClientsResult;
    }


    /**
     * Gets the listTrustedClientsResult value for this ListTrustedClientsResponse.
     * 
     * @return listTrustedClientsResult
     */
    public com.peniel.tara.TrustedClientDTO[] getListTrustedClientsResult() {
        return listTrustedClientsResult;
    }


    /**
     * Sets the listTrustedClientsResult value for this ListTrustedClientsResponse.
     * 
     * @param listTrustedClientsResult
     */
    public void setListTrustedClientsResult(com.peniel.tara.TrustedClientDTO[] listTrustedClientsResult) {
        this.listTrustedClientsResult = listTrustedClientsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListTrustedClientsResponse)) return false;
        ListTrustedClientsResponse other = (ListTrustedClientsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listTrustedClientsResult==null && other.getListTrustedClientsResult()==null) || 
             (this.listTrustedClientsResult!=null &&
              java.util.Arrays.equals(this.listTrustedClientsResult, other.getListTrustedClientsResult())));
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
        if (getListTrustedClientsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListTrustedClientsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListTrustedClientsResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListTrustedClientsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListTrustedClientsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listTrustedClientsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListTrustedClientsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TrustedClientDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TrustedClientDTO"));
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
