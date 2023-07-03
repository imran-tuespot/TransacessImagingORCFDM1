/**
 * ListWorkgroupMembersResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListWorkgroupMembersResponse  implements java.io.Serializable {
    private com.peniel.tara.WorkgroupMemberDTO[] listWorkgroupMembersResult;

    public ListWorkgroupMembersResponse() {
    }

    public ListWorkgroupMembersResponse(
           com.peniel.tara.WorkgroupMemberDTO[] listWorkgroupMembersResult) {
           this.listWorkgroupMembersResult = listWorkgroupMembersResult;
    }


    /**
     * Gets the listWorkgroupMembersResult value for this ListWorkgroupMembersResponse.
     * 
     * @return listWorkgroupMembersResult
     */
    public com.peniel.tara.WorkgroupMemberDTO[] getListWorkgroupMembersResult() {
        return listWorkgroupMembersResult;
    }


    /**
     * Sets the listWorkgroupMembersResult value for this ListWorkgroupMembersResponse.
     * 
     * @param listWorkgroupMembersResult
     */
    public void setListWorkgroupMembersResult(com.peniel.tara.WorkgroupMemberDTO[] listWorkgroupMembersResult) {
        this.listWorkgroupMembersResult = listWorkgroupMembersResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListWorkgroupMembersResponse)) return false;
        ListWorkgroupMembersResponse other = (ListWorkgroupMembersResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listWorkgroupMembersResult==null && other.getListWorkgroupMembersResult()==null) || 
             (this.listWorkgroupMembersResult!=null &&
              java.util.Arrays.equals(this.listWorkgroupMembersResult, other.getListWorkgroupMembersResult())));
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
        if (getListWorkgroupMembersResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListWorkgroupMembersResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListWorkgroupMembersResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListWorkgroupMembersResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListWorkgroupMembersResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listWorkgroupMembersResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListWorkgroupMembersResult"));
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
