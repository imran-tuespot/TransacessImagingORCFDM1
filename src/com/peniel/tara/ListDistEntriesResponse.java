/**
 * ListDistEntriesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListDistEntriesResponse  implements java.io.Serializable {
    private com.peniel.tara.DistEntryDTO[] listDistEntriesResult;

    public ListDistEntriesResponse() {
    }

    public ListDistEntriesResponse(
           com.peniel.tara.DistEntryDTO[] listDistEntriesResult) {
           this.listDistEntriesResult = listDistEntriesResult;
    }


    /**
     * Gets the listDistEntriesResult value for this ListDistEntriesResponse.
     * 
     * @return listDistEntriesResult
     */
    public com.peniel.tara.DistEntryDTO[] getListDistEntriesResult() {
        return listDistEntriesResult;
    }


    /**
     * Sets the listDistEntriesResult value for this ListDistEntriesResponse.
     * 
     * @param listDistEntriesResult
     */
    public void setListDistEntriesResult(com.peniel.tara.DistEntryDTO[] listDistEntriesResult) {
        this.listDistEntriesResult = listDistEntriesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListDistEntriesResponse)) return false;
        ListDistEntriesResponse other = (ListDistEntriesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listDistEntriesResult==null && other.getListDistEntriesResult()==null) || 
             (this.listDistEntriesResult!=null &&
              java.util.Arrays.equals(this.listDistEntriesResult, other.getListDistEntriesResult())));
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
        if (getListDistEntriesResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListDistEntriesResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListDistEntriesResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListDistEntriesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListDistEntriesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listDistEntriesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListDistEntriesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DistEntryDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DistEntryDTO"));
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
