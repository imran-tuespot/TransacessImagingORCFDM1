/**
 * ListWorkgroupsForSubject1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListWorkgroupsForSubject1Response  implements java.io.Serializable {
    private com.peniel.tara.WorkgroupDTO[] listWorkgroupsForSubject1Result;

    public ListWorkgroupsForSubject1Response() {
    }

    public ListWorkgroupsForSubject1Response(
           com.peniel.tara.WorkgroupDTO[] listWorkgroupsForSubject1Result) {
           this.listWorkgroupsForSubject1Result = listWorkgroupsForSubject1Result;
    }


    /**
     * Gets the listWorkgroupsForSubject1Result value for this ListWorkgroupsForSubject1Response.
     * 
     * @return listWorkgroupsForSubject1Result
     */
    public com.peniel.tara.WorkgroupDTO[] getListWorkgroupsForSubject1Result() {
        return listWorkgroupsForSubject1Result;
    }


    /**
     * Sets the listWorkgroupsForSubject1Result value for this ListWorkgroupsForSubject1Response.
     * 
     * @param listWorkgroupsForSubject1Result
     */
    public void setListWorkgroupsForSubject1Result(com.peniel.tara.WorkgroupDTO[] listWorkgroupsForSubject1Result) {
        this.listWorkgroupsForSubject1Result = listWorkgroupsForSubject1Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListWorkgroupsForSubject1Response)) return false;
        ListWorkgroupsForSubject1Response other = (ListWorkgroupsForSubject1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listWorkgroupsForSubject1Result==null && other.getListWorkgroupsForSubject1Result()==null) || 
             (this.listWorkgroupsForSubject1Result!=null &&
              java.util.Arrays.equals(this.listWorkgroupsForSubject1Result, other.getListWorkgroupsForSubject1Result())));
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
        if (getListWorkgroupsForSubject1Result() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListWorkgroupsForSubject1Result());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListWorkgroupsForSubject1Result(), i);
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
        new org.apache.axis.description.TypeDesc(ListWorkgroupsForSubject1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListWorkgroupsForSubject1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listWorkgroupsForSubject1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListWorkgroupsForSubject1Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupDTO"));
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
