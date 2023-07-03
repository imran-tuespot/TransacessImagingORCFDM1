/**
 * ListParticipantsParagraphWatchResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListParticipantsParagraphWatchResponse  implements java.io.Serializable {
    private com.peniel.tara.ParticipantDTO[] listParticipantsParagraphWatchResult;

    public ListParticipantsParagraphWatchResponse() {
    }

    public ListParticipantsParagraphWatchResponse(
           com.peniel.tara.ParticipantDTO[] listParticipantsParagraphWatchResult) {
           this.listParticipantsParagraphWatchResult = listParticipantsParagraphWatchResult;
    }


    /**
     * Gets the listParticipantsParagraphWatchResult value for this ListParticipantsParagraphWatchResponse.
     * 
     * @return listParticipantsParagraphWatchResult
     */
    public com.peniel.tara.ParticipantDTO[] getListParticipantsParagraphWatchResult() {
        return listParticipantsParagraphWatchResult;
    }


    /**
     * Sets the listParticipantsParagraphWatchResult value for this ListParticipantsParagraphWatchResponse.
     * 
     * @param listParticipantsParagraphWatchResult
     */
    public void setListParticipantsParagraphWatchResult(com.peniel.tara.ParticipantDTO[] listParticipantsParagraphWatchResult) {
        this.listParticipantsParagraphWatchResult = listParticipantsParagraphWatchResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListParticipantsParagraphWatchResponse)) return false;
        ListParticipantsParagraphWatchResponse other = (ListParticipantsParagraphWatchResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listParticipantsParagraphWatchResult==null && other.getListParticipantsParagraphWatchResult()==null) || 
             (this.listParticipantsParagraphWatchResult!=null &&
              java.util.Arrays.equals(this.listParticipantsParagraphWatchResult, other.getListParticipantsParagraphWatchResult())));
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
        if (getListParticipantsParagraphWatchResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListParticipantsParagraphWatchResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListParticipantsParagraphWatchResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListParticipantsParagraphWatchResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListParticipantsParagraphWatchResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listParticipantsParagraphWatchResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListParticipantsParagraphWatchResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParticipantDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParticipantDTO"));
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
