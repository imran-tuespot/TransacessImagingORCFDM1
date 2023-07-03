/**
 * ListFileFormatsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListFileFormatsResponse  implements java.io.Serializable {
    private com.peniel.tara.FileFormatDTO[] listFileFormatsResult;

    public ListFileFormatsResponse() {
    }

    public ListFileFormatsResponse(
           com.peniel.tara.FileFormatDTO[] listFileFormatsResult) {
           this.listFileFormatsResult = listFileFormatsResult;
    }


    /**
     * Gets the listFileFormatsResult value for this ListFileFormatsResponse.
     * 
     * @return listFileFormatsResult
     */
    public com.peniel.tara.FileFormatDTO[] getListFileFormatsResult() {
        return listFileFormatsResult;
    }


    /**
     * Sets the listFileFormatsResult value for this ListFileFormatsResponse.
     * 
     * @param listFileFormatsResult
     */
    public void setListFileFormatsResult(com.peniel.tara.FileFormatDTO[] listFileFormatsResult) {
        this.listFileFormatsResult = listFileFormatsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListFileFormatsResponse)) return false;
        ListFileFormatsResponse other = (ListFileFormatsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listFileFormatsResult==null && other.getListFileFormatsResult()==null) || 
             (this.listFileFormatsResult!=null &&
              java.util.Arrays.equals(this.listFileFormatsResult, other.getListFileFormatsResult())));
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
        if (getListFileFormatsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListFileFormatsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListFileFormatsResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListFileFormatsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListFileFormatsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listFileFormatsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListFileFormatsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileFormatDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FileFormatDTO"));
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
