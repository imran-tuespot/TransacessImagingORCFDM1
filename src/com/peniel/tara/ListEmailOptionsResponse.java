/**
 * ListEmailOptionsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListEmailOptionsResponse  implements java.io.Serializable {
    private com.peniel.tara.SettingsDTO[] listEmailOptionsResult;

    public ListEmailOptionsResponse() {
    }

    public ListEmailOptionsResponse(
           com.peniel.tara.SettingsDTO[] listEmailOptionsResult) {
           this.listEmailOptionsResult = listEmailOptionsResult;
    }


    /**
     * Gets the listEmailOptionsResult value for this ListEmailOptionsResponse.
     * 
     * @return listEmailOptionsResult
     */
    public com.peniel.tara.SettingsDTO[] getListEmailOptionsResult() {
        return listEmailOptionsResult;
    }


    /**
     * Sets the listEmailOptionsResult value for this ListEmailOptionsResponse.
     * 
     * @param listEmailOptionsResult
     */
    public void setListEmailOptionsResult(com.peniel.tara.SettingsDTO[] listEmailOptionsResult) {
        this.listEmailOptionsResult = listEmailOptionsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListEmailOptionsResponse)) return false;
        ListEmailOptionsResponse other = (ListEmailOptionsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listEmailOptionsResult==null && other.getListEmailOptionsResult()==null) || 
             (this.listEmailOptionsResult!=null &&
              java.util.Arrays.equals(this.listEmailOptionsResult, other.getListEmailOptionsResult())));
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
        if (getListEmailOptionsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListEmailOptionsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListEmailOptionsResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListEmailOptionsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListEmailOptionsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listEmailOptionsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListEmailOptionsResult"));
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
