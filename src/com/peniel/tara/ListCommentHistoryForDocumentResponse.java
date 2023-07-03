/**
 * ListCommentHistoryForDocumentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListCommentHistoryForDocumentResponse  implements java.io.Serializable {
    private com.peniel.tara.CommentHistoryDTO[] listCommentHistoryForDocumentResult;

    public ListCommentHistoryForDocumentResponse() {
    }

    public ListCommentHistoryForDocumentResponse(
           com.peniel.tara.CommentHistoryDTO[] listCommentHistoryForDocumentResult) {
           this.listCommentHistoryForDocumentResult = listCommentHistoryForDocumentResult;
    }


    /**
     * Gets the listCommentHistoryForDocumentResult value for this ListCommentHistoryForDocumentResponse.
     * 
     * @return listCommentHistoryForDocumentResult
     */
    public com.peniel.tara.CommentHistoryDTO[] getListCommentHistoryForDocumentResult() {
        return listCommentHistoryForDocumentResult;
    }


    /**
     * Sets the listCommentHistoryForDocumentResult value for this ListCommentHistoryForDocumentResponse.
     * 
     * @param listCommentHistoryForDocumentResult
     */
    public void setListCommentHistoryForDocumentResult(com.peniel.tara.CommentHistoryDTO[] listCommentHistoryForDocumentResult) {
        this.listCommentHistoryForDocumentResult = listCommentHistoryForDocumentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListCommentHistoryForDocumentResponse)) return false;
        ListCommentHistoryForDocumentResponse other = (ListCommentHistoryForDocumentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listCommentHistoryForDocumentResult==null && other.getListCommentHistoryForDocumentResult()==null) || 
             (this.listCommentHistoryForDocumentResult!=null &&
              java.util.Arrays.equals(this.listCommentHistoryForDocumentResult, other.getListCommentHistoryForDocumentResult())));
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
        if (getListCommentHistoryForDocumentResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListCommentHistoryForDocumentResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListCommentHistoryForDocumentResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListCommentHistoryForDocumentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListCommentHistoryForDocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listCommentHistoryForDocumentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListCommentHistoryForDocumentResult"));
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
