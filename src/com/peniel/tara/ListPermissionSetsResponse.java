/**
 * ListPermissionSetsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListPermissionSetsResponse  implements java.io.Serializable {
    private com.peniel.tara.PermissionSetDTO[] listPermissionSetsResult;

    public ListPermissionSetsResponse() {
    }

    public ListPermissionSetsResponse(
           com.peniel.tara.PermissionSetDTO[] listPermissionSetsResult) {
           this.listPermissionSetsResult = listPermissionSetsResult;
    }


    /**
     * Gets the listPermissionSetsResult value for this ListPermissionSetsResponse.
     * 
     * @return listPermissionSetsResult
     */
    public com.peniel.tara.PermissionSetDTO[] getListPermissionSetsResult() {
        return listPermissionSetsResult;
    }


    /**
     * Sets the listPermissionSetsResult value for this ListPermissionSetsResponse.
     * 
     * @param listPermissionSetsResult
     */
    public void setListPermissionSetsResult(com.peniel.tara.PermissionSetDTO[] listPermissionSetsResult) {
        this.listPermissionSetsResult = listPermissionSetsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListPermissionSetsResponse)) return false;
        ListPermissionSetsResponse other = (ListPermissionSetsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listPermissionSetsResult==null && other.getListPermissionSetsResult()==null) || 
             (this.listPermissionSetsResult!=null &&
              java.util.Arrays.equals(this.listPermissionSetsResult, other.getListPermissionSetsResult())));
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
        if (getListPermissionSetsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListPermissionSetsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListPermissionSetsResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListPermissionSetsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListPermissionSetsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listPermissionSetsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListPermissionSetsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "PermissionSetDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "PermissionSetDTO"));
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
