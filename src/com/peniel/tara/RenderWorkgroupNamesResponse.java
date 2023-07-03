/**
 * RenderWorkgroupNamesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class RenderWorkgroupNamesResponse  implements java.io.Serializable {
    private com.peniel.tara.WorkgroupDTO[] renderWorkgroupNamesResult;

    public RenderWorkgroupNamesResponse() {
    }

    public RenderWorkgroupNamesResponse(
           com.peniel.tara.WorkgroupDTO[] renderWorkgroupNamesResult) {
           this.renderWorkgroupNamesResult = renderWorkgroupNamesResult;
    }


    /**
     * Gets the renderWorkgroupNamesResult value for this RenderWorkgroupNamesResponse.
     * 
     * @return renderWorkgroupNamesResult
     */
    public com.peniel.tara.WorkgroupDTO[] getRenderWorkgroupNamesResult() {
        return renderWorkgroupNamesResult;
    }


    /**
     * Sets the renderWorkgroupNamesResult value for this RenderWorkgroupNamesResponse.
     * 
     * @param renderWorkgroupNamesResult
     */
    public void setRenderWorkgroupNamesResult(com.peniel.tara.WorkgroupDTO[] renderWorkgroupNamesResult) {
        this.renderWorkgroupNamesResult = renderWorkgroupNamesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RenderWorkgroupNamesResponse)) return false;
        RenderWorkgroupNamesResponse other = (RenderWorkgroupNamesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.renderWorkgroupNamesResult==null && other.getRenderWorkgroupNamesResult()==null) || 
             (this.renderWorkgroupNamesResult!=null &&
              java.util.Arrays.equals(this.renderWorkgroupNamesResult, other.getRenderWorkgroupNamesResult())));
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
        if (getRenderWorkgroupNamesResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRenderWorkgroupNamesResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRenderWorkgroupNamesResult(), i);
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
        new org.apache.axis.description.TypeDesc(RenderWorkgroupNamesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">RenderWorkgroupNamesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renderWorkgroupNamesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "RenderWorkgroupNamesResult"));
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
