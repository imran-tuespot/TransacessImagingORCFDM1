/**
 * ListSettings2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListSettings2Response  implements java.io.Serializable {
    private com.peniel.tara.SettingsDTO[] listSettings2Result;

    public ListSettings2Response() {
    }

    public ListSettings2Response(
           com.peniel.tara.SettingsDTO[] listSettings2Result) {
           this.listSettings2Result = listSettings2Result;
    }


    /**
     * Gets the listSettings2Result value for this ListSettings2Response.
     * 
     * @return listSettings2Result
     */
    public com.peniel.tara.SettingsDTO[] getListSettings2Result() {
        return listSettings2Result;
    }


    /**
     * Sets the listSettings2Result value for this ListSettings2Response.
     * 
     * @param listSettings2Result
     */
    public void setListSettings2Result(com.peniel.tara.SettingsDTO[] listSettings2Result) {
        this.listSettings2Result = listSettings2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListSettings2Response)) return false;
        ListSettings2Response other = (ListSettings2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listSettings2Result==null && other.getListSettings2Result()==null) || 
             (this.listSettings2Result!=null &&
              java.util.Arrays.equals(this.listSettings2Result, other.getListSettings2Result())));
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
        if (getListSettings2Result() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListSettings2Result());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListSettings2Result(), i);
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
        new org.apache.axis.description.TypeDesc(ListSettings2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListSettings2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listSettings2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListSettings2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SettingsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SettingsDTO"));
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
