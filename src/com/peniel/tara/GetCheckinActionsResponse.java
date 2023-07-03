/**
 * GetCheckinActionsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class GetCheckinActionsResponse  implements java.io.Serializable {
    private com.peniel.tara.CheckinOptionDTO[] getCheckinActionsResult;

    public GetCheckinActionsResponse() {
    }

    public GetCheckinActionsResponse(
           com.peniel.tara.CheckinOptionDTO[] getCheckinActionsResult) {
           this.getCheckinActionsResult = getCheckinActionsResult;
    }


    /**
     * Gets the getCheckinActionsResult value for this GetCheckinActionsResponse.
     * 
     * @return getCheckinActionsResult
     */
    public com.peniel.tara.CheckinOptionDTO[] getGetCheckinActionsResult() {
        return getCheckinActionsResult;
    }


    /**
     * Sets the getCheckinActionsResult value for this GetCheckinActionsResponse.
     * 
     * @param getCheckinActionsResult
     */
    public void setGetCheckinActionsResult(com.peniel.tara.CheckinOptionDTO[] getCheckinActionsResult) {
        this.getCheckinActionsResult = getCheckinActionsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCheckinActionsResponse)) return false;
        GetCheckinActionsResponse other = (GetCheckinActionsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCheckinActionsResult==null && other.getGetCheckinActionsResult()==null) || 
             (this.getCheckinActionsResult!=null &&
              java.util.Arrays.equals(this.getCheckinActionsResult, other.getGetCheckinActionsResult())));
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
        if (getGetCheckinActionsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetCheckinActionsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetCheckinActionsResult(), i);
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
        new org.apache.axis.description.TypeDesc(GetCheckinActionsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">GetCheckinActionsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCheckinActionsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GetCheckinActionsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CheckinOptionDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CheckinOptionDTO"));
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
