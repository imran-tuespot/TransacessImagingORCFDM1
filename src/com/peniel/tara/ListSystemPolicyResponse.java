/**
 * ListSystemPolicyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListSystemPolicyResponse  implements java.io.Serializable {
    private com.peniel.tara.SystemPolicyDTO[] listSystemPolicyResult;

    public ListSystemPolicyResponse() {
    }

    public ListSystemPolicyResponse(
           com.peniel.tara.SystemPolicyDTO[] listSystemPolicyResult) {
           this.listSystemPolicyResult = listSystemPolicyResult;
    }


    /**
     * Gets the listSystemPolicyResult value for this ListSystemPolicyResponse.
     * 
     * @return listSystemPolicyResult
     */
    public com.peniel.tara.SystemPolicyDTO[] getListSystemPolicyResult() {
        return listSystemPolicyResult;
    }


    /**
     * Sets the listSystemPolicyResult value for this ListSystemPolicyResponse.
     * 
     * @param listSystemPolicyResult
     */
    public void setListSystemPolicyResult(com.peniel.tara.SystemPolicyDTO[] listSystemPolicyResult) {
        this.listSystemPolicyResult = listSystemPolicyResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListSystemPolicyResponse)) return false;
        ListSystemPolicyResponse other = (ListSystemPolicyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listSystemPolicyResult==null && other.getListSystemPolicyResult()==null) || 
             (this.listSystemPolicyResult!=null &&
              java.util.Arrays.equals(this.listSystemPolicyResult, other.getListSystemPolicyResult())));
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
        if (getListSystemPolicyResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListSystemPolicyResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListSystemPolicyResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListSystemPolicyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListSystemPolicyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listSystemPolicyResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListSystemPolicyResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SystemPolicyDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SystemPolicyDTO"));
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
