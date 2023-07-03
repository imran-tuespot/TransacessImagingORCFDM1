/**
 * ListSystemConnectorsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListSystemConnectorsResponse  implements java.io.Serializable {
    private com.peniel.tara.SystemConnectorDTO[] listSystemConnectorsResult;

    public ListSystemConnectorsResponse() {
    }

    public ListSystemConnectorsResponse(
           com.peniel.tara.SystemConnectorDTO[] listSystemConnectorsResult) {
           this.listSystemConnectorsResult = listSystemConnectorsResult;
    }


    /**
     * Gets the listSystemConnectorsResult value for this ListSystemConnectorsResponse.
     * 
     * @return listSystemConnectorsResult
     */
    public com.peniel.tara.SystemConnectorDTO[] getListSystemConnectorsResult() {
        return listSystemConnectorsResult;
    }


    /**
     * Sets the listSystemConnectorsResult value for this ListSystemConnectorsResponse.
     * 
     * @param listSystemConnectorsResult
     */
    public void setListSystemConnectorsResult(com.peniel.tara.SystemConnectorDTO[] listSystemConnectorsResult) {
        this.listSystemConnectorsResult = listSystemConnectorsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListSystemConnectorsResponse)) return false;
        ListSystemConnectorsResponse other = (ListSystemConnectorsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listSystemConnectorsResult==null && other.getListSystemConnectorsResult()==null) || 
             (this.listSystemConnectorsResult!=null &&
              java.util.Arrays.equals(this.listSystemConnectorsResult, other.getListSystemConnectorsResult())));
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
        if (getListSystemConnectorsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListSystemConnectorsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListSystemConnectorsResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListSystemConnectorsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListSystemConnectorsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listSystemConnectorsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListSystemConnectorsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SystemConnectorDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SystemConnectorDTO"));
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
