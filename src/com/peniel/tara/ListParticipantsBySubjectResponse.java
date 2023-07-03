/**
 * ListParticipantsBySubjectResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListParticipantsBySubjectResponse  implements java.io.Serializable {
    private com.peniel.tara.ParticipantDTO[] listParticipantsBySubjectResult;

    public ListParticipantsBySubjectResponse() {
    }

    public ListParticipantsBySubjectResponse(
           com.peniel.tara.ParticipantDTO[] listParticipantsBySubjectResult) {
           this.listParticipantsBySubjectResult = listParticipantsBySubjectResult;
    }


    /**
     * Gets the listParticipantsBySubjectResult value for this ListParticipantsBySubjectResponse.
     * 
     * @return listParticipantsBySubjectResult
     */
    public com.peniel.tara.ParticipantDTO[] getListParticipantsBySubjectResult() {
        return listParticipantsBySubjectResult;
    }


    /**
     * Sets the listParticipantsBySubjectResult value for this ListParticipantsBySubjectResponse.
     * 
     * @param listParticipantsBySubjectResult
     */
    public void setListParticipantsBySubjectResult(com.peniel.tara.ParticipantDTO[] listParticipantsBySubjectResult) {
        this.listParticipantsBySubjectResult = listParticipantsBySubjectResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListParticipantsBySubjectResponse)) return false;
        ListParticipantsBySubjectResponse other = (ListParticipantsBySubjectResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listParticipantsBySubjectResult==null && other.getListParticipantsBySubjectResult()==null) || 
             (this.listParticipantsBySubjectResult!=null &&
              java.util.Arrays.equals(this.listParticipantsBySubjectResult, other.getListParticipantsBySubjectResult())));
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
        if (getListParticipantsBySubjectResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListParticipantsBySubjectResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListParticipantsBySubjectResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListParticipantsBySubjectResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListParticipantsBySubjectResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listParticipantsBySubjectResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListParticipantsBySubjectResult"));
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
