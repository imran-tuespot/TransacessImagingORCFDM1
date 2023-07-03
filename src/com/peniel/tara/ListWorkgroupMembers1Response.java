/**
 * ListWorkgroupMembers1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListWorkgroupMembers1Response  implements java.io.Serializable {
    private com.peniel.tara.WorkgroupMemberDTO[] listWorkgroupMembers1Result;

    public ListWorkgroupMembers1Response() {
    }

    public ListWorkgroupMembers1Response(
           com.peniel.tara.WorkgroupMemberDTO[] listWorkgroupMembers1Result) {
           this.listWorkgroupMembers1Result = listWorkgroupMembers1Result;
    }


    /**
     * Gets the listWorkgroupMembers1Result value for this ListWorkgroupMembers1Response.
     * 
     * @return listWorkgroupMembers1Result
     */
    public com.peniel.tara.WorkgroupMemberDTO[] getListWorkgroupMembers1Result() {
        return listWorkgroupMembers1Result;
    }


    /**
     * Sets the listWorkgroupMembers1Result value for this ListWorkgroupMembers1Response.
     * 
     * @param listWorkgroupMembers1Result
     */
    public void setListWorkgroupMembers1Result(com.peniel.tara.WorkgroupMemberDTO[] listWorkgroupMembers1Result) {
        this.listWorkgroupMembers1Result = listWorkgroupMembers1Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListWorkgroupMembers1Response)) return false;
        ListWorkgroupMembers1Response other = (ListWorkgroupMembers1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listWorkgroupMembers1Result==null && other.getListWorkgroupMembers1Result()==null) || 
             (this.listWorkgroupMembers1Result!=null &&
              java.util.Arrays.equals(this.listWorkgroupMembers1Result, other.getListWorkgroupMembers1Result())));
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
        if (getListWorkgroupMembers1Result() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListWorkgroupMembers1Result());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListWorkgroupMembers1Result(), i);
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
        new org.apache.axis.description.TypeDesc(ListWorkgroupMembers1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListWorkgroupMembers1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listWorkgroupMembers1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListWorkgroupMembers1Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupMemberDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupMemberDTO"));
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
