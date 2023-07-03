/**
 * ListReviewDocumentsForDocumentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListReviewDocumentsForDocumentResponse  implements java.io.Serializable {
    private com.peniel.tara.ReviewDocumentDTO[] listReviewDocumentsForDocumentResult;

    public ListReviewDocumentsForDocumentResponse() {
    }

    public ListReviewDocumentsForDocumentResponse(
           com.peniel.tara.ReviewDocumentDTO[] listReviewDocumentsForDocumentResult) {
           this.listReviewDocumentsForDocumentResult = listReviewDocumentsForDocumentResult;
    }


    /**
     * Gets the listReviewDocumentsForDocumentResult value for this ListReviewDocumentsForDocumentResponse.
     * 
     * @return listReviewDocumentsForDocumentResult
     */
    public com.peniel.tara.ReviewDocumentDTO[] getListReviewDocumentsForDocumentResult() {
        return listReviewDocumentsForDocumentResult;
    }


    /**
     * Sets the listReviewDocumentsForDocumentResult value for this ListReviewDocumentsForDocumentResponse.
     * 
     * @param listReviewDocumentsForDocumentResult
     */
    public void setListReviewDocumentsForDocumentResult(com.peniel.tara.ReviewDocumentDTO[] listReviewDocumentsForDocumentResult) {
        this.listReviewDocumentsForDocumentResult = listReviewDocumentsForDocumentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListReviewDocumentsForDocumentResponse)) return false;
        ListReviewDocumentsForDocumentResponse other = (ListReviewDocumentsForDocumentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listReviewDocumentsForDocumentResult==null && other.getListReviewDocumentsForDocumentResult()==null) || 
             (this.listReviewDocumentsForDocumentResult!=null &&
              java.util.Arrays.equals(this.listReviewDocumentsForDocumentResult, other.getListReviewDocumentsForDocumentResult())));
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
        if (getListReviewDocumentsForDocumentResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListReviewDocumentsForDocumentResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListReviewDocumentsForDocumentResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListReviewDocumentsForDocumentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListReviewDocumentsForDocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listReviewDocumentsForDocumentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListReviewDocumentsForDocumentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDocumentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewDocumentDTO"));
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
