/**
 * ListLicensesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListLicensesResponse  implements java.io.Serializable {
    private com.peniel.tara.LicenseDTO[] listLicensesResult;

    public ListLicensesResponse() {
    }

    public ListLicensesResponse(
           com.peniel.tara.LicenseDTO[] listLicensesResult) {
           this.listLicensesResult = listLicensesResult;
    }


    /**
     * Gets the listLicensesResult value for this ListLicensesResponse.
     * 
     * @return listLicensesResult
     */
    public com.peniel.tara.LicenseDTO[] getListLicensesResult() {
        return listLicensesResult;
    }


    /**
     * Sets the listLicensesResult value for this ListLicensesResponse.
     * 
     * @param listLicensesResult
     */
    public void setListLicensesResult(com.peniel.tara.LicenseDTO[] listLicensesResult) {
        this.listLicensesResult = listLicensesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListLicensesResponse)) return false;
        ListLicensesResponse other = (ListLicensesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listLicensesResult==null && other.getListLicensesResult()==null) || 
             (this.listLicensesResult!=null &&
              java.util.Arrays.equals(this.listLicensesResult, other.getListLicensesResult())));
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
        if (getListLicensesResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListLicensesResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListLicensesResult(), i);
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
        new org.apache.axis.description.TypeDesc(ListLicensesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListLicensesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listLicensesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListLicensesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LicenseDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LicenseDTO"));
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
