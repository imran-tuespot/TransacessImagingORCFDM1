/**
 * CellDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class CellDTO  implements java.io.Serializable {
    private java.lang.String cellValue;

    private java.lang.Boolean isHidden;

    private java.lang.Boolean isFormula;

    private java.lang.String formulaValue;

    private com.peniel.tara.FormulaType formulaType;

    public CellDTO() {
    }

    public CellDTO(
           java.lang.String cellValue,
           java.lang.Boolean isHidden,
           java.lang.Boolean isFormula,
           java.lang.String formulaValue,
           com.peniel.tara.FormulaType formulaType) {
           this.cellValue = cellValue;
           this.isHidden = isHidden;
           this.isFormula = isFormula;
           this.formulaValue = formulaValue;
           this.formulaType = formulaType;
    }


    /**
     * Gets the cellValue value for this CellDTO.
     * 
     * @return cellValue
     */
    public java.lang.String getCellValue() {
        return cellValue;
    }


    /**
     * Sets the cellValue value for this CellDTO.
     * 
     * @param cellValue
     */
    public void setCellValue(java.lang.String cellValue) {
        this.cellValue = cellValue;
    }


    /**
     * Gets the isHidden value for this CellDTO.
     * 
     * @return isHidden
     */
    public java.lang.Boolean getIsHidden() {
        return isHidden;
    }


    /**
     * Sets the isHidden value for this CellDTO.
     * 
     * @param isHidden
     */
    public void setIsHidden(java.lang.Boolean isHidden) {
        this.isHidden = isHidden;
    }


    /**
     * Gets the isFormula value for this CellDTO.
     * 
     * @return isFormula
     */
    public java.lang.Boolean getIsFormula() {
        return isFormula;
    }


    /**
     * Sets the isFormula value for this CellDTO.
     * 
     * @param isFormula
     */
    public void setIsFormula(java.lang.Boolean isFormula) {
        this.isFormula = isFormula;
    }


    /**
     * Gets the formulaValue value for this CellDTO.
     * 
     * @return formulaValue
     */
    public java.lang.String getFormulaValue() {
        return formulaValue;
    }


    /**
     * Sets the formulaValue value for this CellDTO.
     * 
     * @param formulaValue
     */
    public void setFormulaValue(java.lang.String formulaValue) {
        this.formulaValue = formulaValue;
    }


    /**
     * Gets the formulaType value for this CellDTO.
     * 
     * @return formulaType
     */
    public com.peniel.tara.FormulaType getFormulaType() {
        return formulaType;
    }


    /**
     * Sets the formulaType value for this CellDTO.
     * 
     * @param formulaType
     */
    public void setFormulaType(com.peniel.tara.FormulaType formulaType) {
        this.formulaType = formulaType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CellDTO)) return false;
        CellDTO other = (CellDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cellValue==null && other.getCellValue()==null) || 
             (this.cellValue!=null &&
              this.cellValue.equals(other.getCellValue()))) &&
            ((this.isHidden==null && other.getIsHidden()==null) || 
             (this.isHidden!=null &&
              this.isHidden.equals(other.getIsHidden()))) &&
            ((this.isFormula==null && other.getIsFormula()==null) || 
             (this.isFormula!=null &&
              this.isFormula.equals(other.getIsFormula()))) &&
            ((this.formulaValue==null && other.getFormulaValue()==null) || 
             (this.formulaValue!=null &&
              this.formulaValue.equals(other.getFormulaValue()))) &&
            ((this.formulaType==null && other.getFormulaType()==null) || 
             (this.formulaType!=null &&
              this.formulaType.equals(other.getFormulaType())));
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
        if (getCellValue() != null) {
            _hashCode += getCellValue().hashCode();
        }
        if (getIsHidden() != null) {
            _hashCode += getIsHidden().hashCode();
        }
        if (getIsFormula() != null) {
            _hashCode += getIsFormula().hashCode();
        }
        if (getFormulaValue() != null) {
            _hashCode += getFormulaValue().hashCode();
        }
        if (getFormulaType() != null) {
            _hashCode += getFormulaType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CellDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CellDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cellValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CellValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isHidden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsHidden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFormula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsFormula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formulaValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FormulaValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formulaType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FormulaType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FormulaType"));
        elemField.setNillable(true);
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
