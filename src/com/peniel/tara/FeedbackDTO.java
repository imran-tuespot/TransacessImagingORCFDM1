/**
 * FeedbackDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class FeedbackDTO  implements java.io.Serializable {
    private com.peniel.tara.FeedbackTypeDTO[] listOfFeedbackTypeDTO;

    public FeedbackDTO() {
    }

    public FeedbackDTO(
           com.peniel.tara.FeedbackTypeDTO[] listOfFeedbackTypeDTO) {
           this.listOfFeedbackTypeDTO = listOfFeedbackTypeDTO;
    }


    /**
     * Gets the listOfFeedbackTypeDTO value for this FeedbackDTO.
     * 
     * @return listOfFeedbackTypeDTO
     */
    public com.peniel.tara.FeedbackTypeDTO[] getListOfFeedbackTypeDTO() {
        return listOfFeedbackTypeDTO;
    }


    /**
     * Sets the listOfFeedbackTypeDTO value for this FeedbackDTO.
     * 
     * @param listOfFeedbackTypeDTO
     */
    public void setListOfFeedbackTypeDTO(com.peniel.tara.FeedbackTypeDTO[] listOfFeedbackTypeDTO) {
        this.listOfFeedbackTypeDTO = listOfFeedbackTypeDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FeedbackDTO)) return false;
        FeedbackDTO other = (FeedbackDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listOfFeedbackTypeDTO==null && other.getListOfFeedbackTypeDTO()==null) || 
             (this.listOfFeedbackTypeDTO!=null &&
              java.util.Arrays.equals(this.listOfFeedbackTypeDTO, other.getListOfFeedbackTypeDTO())));
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
        if (getListOfFeedbackTypeDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListOfFeedbackTypeDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListOfFeedbackTypeDTO(), i);
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
        new org.apache.axis.description.TypeDesc(FeedbackDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOfFeedbackTypeDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListOfFeedbackTypeDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackTypeDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackTypeDTO"));
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
