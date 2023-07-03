/**
 * ListAllDistListsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListAllDistListsResponse  implements java.io.Serializable {
    private com.peniel.tara.DistListDTO[] listAllDistListsResult;

    public ListAllDistListsResponse() {
    }

    public ListAllDistListsResponse(
           com.peniel.tara.DistListDTO[] listAllDistListsResult) {
           this.listAllDistListsResult = listAllDistListsResult;
    }


    /**
     * Gets the listAllDistListsResult value for this ListAllDistListsResponse.
     * 
     * @return listAllDistListsResult
     */
    public com.peniel.tara.DistListDTO[] getListAllDistListsResult() {
        return listAllDistListsResult;
    }


    /**
     * Sets the listAllDistListsResult value for this ListAllDistListsResponse.
     * 
     * @param listAllDistListsResult
     */
    public void setListAllDistListsResult(com.peniel.tara.DistListDTO[] listAllDistListsResult) {
        this.listAllDistListsResult = listAllDistListsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllDistListsResponse)) return false;
        ListAllDistListsResponse other = (ListAllDistListsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listAllDistListsResult==null && other.getListAllDistListsResult()==null) || 
             (this.listAllDistListsResult!=null &&
              java.util.Arrays.equals(this.listAllDistListsResult, other.getListAllDistListsResult())));
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
        if (getListAllDistListsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListAllDistListsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListAllDistListsResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListAllDistListsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListAllDistListsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listAllDistListsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListAllDistListsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DistListDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DistListDTO"));
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
