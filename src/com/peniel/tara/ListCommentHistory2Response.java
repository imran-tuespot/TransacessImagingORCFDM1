/**
 * ListCommentHistory2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListCommentHistory2Response  implements java.io.Serializable {
    private com.peniel.tara.CommentHistoryDTO[] listCommentHistory2Result;

    public ListCommentHistory2Response() {
    }

    public ListCommentHistory2Response(
           com.peniel.tara.CommentHistoryDTO[] listCommentHistory2Result) {
           this.listCommentHistory2Result = listCommentHistory2Result;
    }


    /**
     * Gets the listCommentHistory2Result value for this ListCommentHistory2Response.
     * 
     * @return listCommentHistory2Result
     */
    public com.peniel.tara.CommentHistoryDTO[] getListCommentHistory2Result() {
        return listCommentHistory2Result;
    }


    /**
     * Sets the listCommentHistory2Result value for this ListCommentHistory2Response.
     * 
     * @param listCommentHistory2Result
     */
    public void setListCommentHistory2Result(com.peniel.tara.CommentHistoryDTO[] listCommentHistory2Result) {
        this.listCommentHistory2Result = listCommentHistory2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListCommentHistory2Response)) return false;
        ListCommentHistory2Response other = (ListCommentHistory2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listCommentHistory2Result==null && other.getListCommentHistory2Result()==null) || 
             (this.listCommentHistory2Result!=null &&
              java.util.Arrays.equals(this.listCommentHistory2Result, other.getListCommentHistory2Result())));
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
        if (getListCommentHistory2Result() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListCommentHistory2Result());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListCommentHistory2Result(), i);
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
        new org.apache.axis.description.TypeDesc(ListCommentHistory2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListCommentHistory2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listCommentHistory2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListCommentHistory2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentHistoryDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentHistoryDTO"));
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
