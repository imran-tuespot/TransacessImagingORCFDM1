/**
 * ListSettingsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListSettingsResponse  implements java.io.Serializable {
    private com.peniel.tara.SettingsDTO[] listSettingsResult;

    public ListSettingsResponse() {
    }

    public ListSettingsResponse(
           com.peniel.tara.SettingsDTO[] listSettingsResult) {
           this.listSettingsResult = listSettingsResult;
    }


    /**
     * Gets the listSettingsResult value for this ListSettingsResponse.
     * 
     * @return listSettingsResult
     */
    public com.peniel.tara.SettingsDTO[] getListSettingsResult() {
        return listSettingsResult;
    }


    /**
     * Sets the listSettingsResult value for this ListSettingsResponse.
     * 
     * @param listSettingsResult
     */
    public void setListSettingsResult(com.peniel.tara.SettingsDTO[] listSettingsResult) {
        this.listSettingsResult = listSettingsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListSettingsResponse)) return false;
        ListSettingsResponse other = (ListSettingsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listSettingsResult==null && other.getListSettingsResult()==null) || 
             (this.listSettingsResult!=null &&
              java.util.Arrays.equals(this.listSettingsResult, other.getListSettingsResult())));
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
        if (getListSettingsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListSettingsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListSettingsResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListSettingsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListSettingsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listSettingsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListSettingsResult"));
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
