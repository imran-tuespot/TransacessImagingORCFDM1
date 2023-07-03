/**
 * ListReviewDocuments2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListReviewDocuments2Response  implements java.io.Serializable {
    private com.peniel.tara.ReviewDocumentDTO[] listReviewDocuments2Result;

    public ListReviewDocuments2Response() {
    }

    public ListReviewDocuments2Response(
           com.peniel.tara.ReviewDocumentDTO[] listReviewDocuments2Result) {
           this.listReviewDocuments2Result = listReviewDocuments2Result;
    }


    /**
     * Gets the listReviewDocuments2Result value for this ListReviewDocuments2Response.
     * 
     * @return listReviewDocuments2Result
     */
    public com.peniel.tara.ReviewDocumentDTO[] getListReviewDocuments2Result() {
        return listReviewDocuments2Result;
    }


    /**
     * Sets the listReviewDocuments2Result value for this ListReviewDocuments2Response.
     * 
     * @param listReviewDocuments2Result
     */
    public void setListReviewDocuments2Result(com.peniel.tara.ReviewDocumentDTO[] listReviewDocuments2Result) {
        this.listReviewDocuments2Result = listReviewDocuments2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListReviewDocuments2Response)) return false;
        ListReviewDocuments2Response other = (ListReviewDocuments2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listReviewDocuments2Result==null && other.getListReviewDocuments2Result()==null) || 
             (this.listReviewDocuments2Result!=null &&
              java.util.Arrays.equals(this.listReviewDocuments2Result, other.getListReviewDocuments2Result())));
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
        if (getListReviewDocuments2Result() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListReviewDocuments2Result());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListReviewDocuments2Result(), i);
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
        new org.apache.axis.description.TypeDesc(ListReviewDocuments2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListReviewDocuments2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listReviewDocuments2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListReviewDocuments2Result"));
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
