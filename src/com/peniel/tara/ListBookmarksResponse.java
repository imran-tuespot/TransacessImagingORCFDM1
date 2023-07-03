/**
 * ListBookmarksResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListBookmarksResponse  implements java.io.Serializable {
    private com.peniel.tara.BookmarkDTO[] listBookmarksResult;

    public ListBookmarksResponse() {
    }

    public ListBookmarksResponse(
           com.peniel.tara.BookmarkDTO[] listBookmarksResult) {
           this.listBookmarksResult = listBookmarksResult;
    }


    /**
     * Gets the listBookmarksResult value for this ListBookmarksResponse.
     * 
     * @return listBookmarksResult
     */
    public com.peniel.tara.BookmarkDTO[] getListBookmarksResult() {
        return listBookmarksResult;
    }


    /**
     * Sets the listBookmarksResult value for this ListBookmarksResponse.
     * 
     * @param listBookmarksResult
     */
    public void setListBookmarksResult(com.peniel.tara.BookmarkDTO[] listBookmarksResult) {
        this.listBookmarksResult = listBookmarksResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListBookmarksResponse)) return false;
        ListBookmarksResponse other = (ListBookmarksResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listBookmarksResult==null && other.getListBookmarksResult()==null) || 
             (this.listBookmarksResult!=null &&
              java.util.Arrays.equals(this.listBookmarksResult, other.getListBookmarksResult())));
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
        if (getListBookmarksResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListBookmarksResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListBookmarksResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListBookmarksResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListBookmarksResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listBookmarksResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListBookmarksResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "BookmarkDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "BookmarkDTO"));
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
