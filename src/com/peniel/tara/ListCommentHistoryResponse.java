/**
 * ListCommentHistoryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListCommentHistoryResponse  implements java.io.Serializable {
    private com.peniel.tara.CommentHistoryDTO[] listCommentHistoryResult;

    public ListCommentHistoryResponse() {
    }

    public ListCommentHistoryResponse(
           com.peniel.tara.CommentHistoryDTO[] listCommentHistoryResult) {
           this.listCommentHistoryResult = listCommentHistoryResult;
    }


    /**
     * Gets the listCommentHistoryResult value for this ListCommentHistoryResponse.
     * 
     * @return listCommentHistoryResult
     */
    public com.peniel.tara.CommentHistoryDTO[] getListCommentHistoryResult() {
        return listCommentHistoryResult;
    }


    /**
     * Sets the listCommentHistoryResult value for this ListCommentHistoryResponse.
     * 
     * @param listCommentHistoryResult
     */
    public void setListCommentHistoryResult(com.peniel.tara.CommentHistoryDTO[] listCommentHistoryResult) {
        this.listCommentHistoryResult = listCommentHistoryResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListCommentHistoryResponse)) return false;
        ListCommentHistoryResponse other = (ListCommentHistoryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listCommentHistoryResult==null && other.getListCommentHistoryResult()==null) || 
             (this.listCommentHistoryResult!=null &&
              java.util.Arrays.equals(this.listCommentHistoryResult, other.getListCommentHistoryResult())));
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
        if (getListCommentHistoryResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListCommentHistoryResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListCommentHistoryResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListCommentHistoryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListCommentHistoryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listCommentHistoryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListCommentHistoryResult"));
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
