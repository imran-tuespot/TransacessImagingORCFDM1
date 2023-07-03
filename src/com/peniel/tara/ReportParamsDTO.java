/**
 * ReportParamsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ReportParamsDTO  implements java.io.Serializable {
    private com.peniel.tara.NameValueDTO param1;

    private com.peniel.tara.NameValueDTO param2;

    private com.peniel.tara.NameValueDTO param3;

    private com.peniel.tara.NameValueDTO param4;

    private java.lang.Object[] param5;

    private boolean isTaskgroup;

    public ReportParamsDTO() {
    }

    public ReportParamsDTO(
           com.peniel.tara.NameValueDTO param1,
           com.peniel.tara.NameValueDTO param2,
           com.peniel.tara.NameValueDTO param3,
           com.peniel.tara.NameValueDTO param4,
           java.lang.Object[] param5,
           boolean isTaskgroup) {
           this.param1 = param1;
           this.param2 = param2;
           this.param3 = param3;
           this.param4 = param4;
           this.param5 = param5;
           this.isTaskgroup = isTaskgroup;
    }


    /**
     * Gets the param1 value for this ReportParamsDTO.
     * 
     * @return param1
     */
    public com.peniel.tara.NameValueDTO getParam1() {
        return param1;
    }


    /**
     * Sets the param1 value for this ReportParamsDTO.
     * 
     * @param param1
     */
    public void setParam1(com.peniel.tara.NameValueDTO param1) {
        this.param1 = param1;
    }


    /**
     * Gets the param2 value for this ReportParamsDTO.
     * 
     * @return param2
     */
    public com.peniel.tara.NameValueDTO getParam2() {
        return param2;
    }


    /**
     * Sets the param2 value for this ReportParamsDTO.
     * 
     * @param param2
     */
    public void setParam2(com.peniel.tara.NameValueDTO param2) {
        this.param2 = param2;
    }


    /**
     * Gets the param3 value for this ReportParamsDTO.
     * 
     * @return param3
     */
    public com.peniel.tara.NameValueDTO getParam3() {
        return param3;
    }


    /**
     * Sets the param3 value for this ReportParamsDTO.
     * 
     * @param param3
     */
    public void setParam3(com.peniel.tara.NameValueDTO param3) {
        this.param3 = param3;
    }


    /**
     * Gets the param4 value for this ReportParamsDTO.
     * 
     * @return param4
     */
    public com.peniel.tara.NameValueDTO getParam4() {
        return param4;
    }


    /**
     * Sets the param4 value for this ReportParamsDTO.
     * 
     * @param param4
     */
    public void setParam4(com.peniel.tara.NameValueDTO param4) {
        this.param4 = param4;
    }


    /**
     * Gets the param5 value for this ReportParamsDTO.
     * 
     * @return param5
     */
    public java.lang.Object[] getParam5() {
        return param5;
    }


    /**
     * Sets the param5 value for this ReportParamsDTO.
     * 
     * @param param5
     */
    public void setParam5(java.lang.Object[] param5) {
        this.param5 = param5;
    }


    /**
     * Gets the isTaskgroup value for this ReportParamsDTO.
     * 
     * @return isTaskgroup
     */
    public boolean isIsTaskgroup() {
        return isTaskgroup;
    }


    /**
     * Sets the isTaskgroup value for this ReportParamsDTO.
     * 
     * @param isTaskgroup
     */
    public void setIsTaskgroup(boolean isTaskgroup) {
        this.isTaskgroup = isTaskgroup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReportParamsDTO)) return false;
        ReportParamsDTO other = (ReportParamsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.param1==null && other.getParam1()==null) || 
             (this.param1!=null &&
              this.param1.equals(other.getParam1()))) &&
            ((this.param2==null && other.getParam2()==null) || 
             (this.param2!=null &&
              this.param2.equals(other.getParam2()))) &&
            ((this.param3==null && other.getParam3()==null) || 
             (this.param3!=null &&
              this.param3.equals(other.getParam3()))) &&
            ((this.param4==null && other.getParam4()==null) || 
             (this.param4!=null &&
              this.param4.equals(other.getParam4()))) &&
            ((this.param5==null && other.getParam5()==null) || 
             (this.param5!=null &&
              java.util.Arrays.equals(this.param5, other.getParam5()))) &&
            this.isTaskgroup == other.isIsTaskgroup();
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
        if (getParam1() != null) {
            _hashCode += getParam1().hashCode();
        }
        if (getParam2() != null) {
            _hashCode += getParam2().hashCode();
        }
        if (getParam3() != null) {
            _hashCode += getParam3().hashCode();
        }
        if (getParam4() != null) {
            _hashCode += getParam4().hashCode();
        }
        if (getParam5() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParam5());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParam5(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isIsTaskgroup() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReportParamsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReportParamsDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Param1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "NameValueDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Param2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "NameValueDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Param3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "NameValueDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param4");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Param4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "NameValueDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param5");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Param5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "anyType"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTaskgroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "isTaskgroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
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
