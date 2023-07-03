/**
 * ListDistEntries1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListDistEntries1Response  implements java.io.Serializable {
    private com.peniel.tara.DistEntryDTO[] listDistEntries1Result;

    public ListDistEntries1Response() {
    }

    public ListDistEntries1Response(
           com.peniel.tara.DistEntryDTO[] listDistEntries1Result) {
           this.listDistEntries1Result = listDistEntries1Result;
    }


    /**
     * Gets the listDistEntries1Result value for this ListDistEntries1Response.
     * 
     * @return listDistEntries1Result
     */
    public com.peniel.tara.DistEntryDTO[] getListDistEntries1Result() {
        return listDistEntries1Result;
    }


    /**
     * Sets the listDistEntries1Result value for this ListDistEntries1Response.
     * 
     * @param listDistEntries1Result
     */
    public void setListDistEntries1Result(com.peniel.tara.DistEntryDTO[] listDistEntries1Result) {
        this.listDistEntries1Result = listDistEntries1Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListDistEntries1Response)) return false;
        ListDistEntries1Response other = (ListDistEntries1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listDistEntries1Result==null && other.getListDistEntries1Result()==null) || 
             (this.listDistEntries1Result!=null &&
              java.util.Arrays.equals(this.listDistEntries1Result, other.getListDistEntries1Result())));
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
        if (getListDistEntries1Result() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListDistEntries1Result());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListDistEntries1Result(), i);
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
        new org.apache.axis.description.TypeDesc(ListDistEntries1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListDistEntries1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listDistEntries1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListDistEntries1Result"));
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
