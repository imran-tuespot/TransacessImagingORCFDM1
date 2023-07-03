/**
 * GetGroupMembersResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetGroupMembersResponse  implements java.io.Serializable {
    private com.peniel.tara.WorkgroupMemberDTO[] getGroupMembersResult;

    public GetGroupMembersResponse() {
    }

    public GetGroupMembersResponse(
           com.peniel.tara.WorkgroupMemberDTO[] getGroupMembersResult) {
           this.getGroupMembersResult = getGroupMembersResult;
    }


    /**
     * Gets the getGroupMembersResult value for this GetGroupMembersResponse.
     * 
     * @return getGroupMembersResult
     */
    public com.peniel.tara.WorkgroupMemberDTO[] getGetGroupMembersResult() {
        return getGroupMembersResult;
    }


    /**
     * Sets the getGroupMembersResult value for this GetGroupMembersResponse.
     * 
     * @param getGroupMembersResult
     */
    public void setGetGroupMembersResult(com.peniel.tara.WorkgroupMemberDTO[] getGroupMembersResult) {
        this.getGroupMembersResult = getGroupMembersResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetGroupMembersResponse)) return false;
        GetGroupMembersResponse other = (GetGroupMembersResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getGroupMembersResult==null && other.getGetGroupMembersResult()==null) || 
             (this.getGroupMembersResult!=null &&
              java.util.Arrays.equals(this.getGroupMembersResult, other.getGetGroupMembersResult())));
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
        if (getGetGroupMembersResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetGroupMembersResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetGroupMembersResult(), i);
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
        new org.apache.axis.description.TypeDesc(GetGroupMembersResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetGroupMembersResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getGroupMembersResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetGroupMembersResult"));
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
