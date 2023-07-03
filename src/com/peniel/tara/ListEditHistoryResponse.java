/**
 * ListEditHistoryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListEditHistoryResponse  implements java.io.Serializable {
    private com.peniel.tara.EditHistoryDTO[] listEditHistoryResult;

    public ListEditHistoryResponse() {
    }

    public ListEditHistoryResponse(
           com.peniel.tara.EditHistoryDTO[] listEditHistoryResult) {
           this.listEditHistoryResult = listEditHistoryResult;
    }


    /**
     * Gets the listEditHistoryResult value for this ListEditHistoryResponse.
     * 
     * @return listEditHistoryResult
     */
    public com.peniel.tara.EditHistoryDTO[] getListEditHistoryResult() {
        return listEditHistoryResult;
    }


    /**
     * Sets the listEditHistoryResult value for this ListEditHistoryResponse.
     * 
     * @param listEditHistoryResult
     */
    public void setListEditHistoryResult(com.peniel.tara.EditHistoryDTO[] listEditHistoryResult) {
        this.listEditHistoryResult = listEditHistoryResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListEditHistoryResponse)) return false;
        ListEditHistoryResponse other = (ListEditHistoryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listEditHistoryResult==null && other.getListEditHistoryResult()==null) || 
             (this.listEditHistoryResult!=null &&
              java.util.Arrays.equals(this.listEditHistoryResult, other.getListEditHistoryResult())));
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
        if (getListEditHistoryResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListEditHistoryResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListEditHistoryResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListEditHistoryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListEditHistoryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listEditHistoryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListEditHistoryResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditHistoryDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EditHistoryDTO"));
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
