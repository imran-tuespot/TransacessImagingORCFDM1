/**
 * ParagraphCommentDetailsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ParagraphCommentDetailsDTO  implements java.io.Serializable {
    private int openChanges;

    private java.lang.String paragraphText;

    private java.lang.String paragraphHTMLText;

    private com.peniel.tara.CommentDTO[][] comments;

    public ParagraphCommentDetailsDTO() {
    }

    public ParagraphCommentDetailsDTO(
           int openChanges,
           java.lang.String paragraphText,
           java.lang.String paragraphHTMLText,
           com.peniel.tara.CommentDTO[][] comments) {
           this.openChanges = openChanges;
           this.paragraphText = paragraphText;
           this.paragraphHTMLText = paragraphHTMLText;
           this.comments = comments;
    }


    /**
     * Gets the openChanges value for this ParagraphCommentDetailsDTO.
     * 
     * @return openChanges
     */
    public int getOpenChanges() {
        return openChanges;
    }


    /**
     * Sets the openChanges value for this ParagraphCommentDetailsDTO.
     * 
     * @param openChanges
     */
    public void setOpenChanges(int openChanges) {
        this.openChanges = openChanges;
    }


    /**
     * Gets the paragraphText value for this ParagraphCommentDetailsDTO.
     * 
     * @return paragraphText
     */
    public java.lang.String getParagraphText() {
        return paragraphText;
    }


    /**
     * Sets the paragraphText value for this ParagraphCommentDetailsDTO.
     * 
     * @param paragraphText
     */
    public void setParagraphText(java.lang.String paragraphText) {
        this.paragraphText = paragraphText;
    }


    /**
     * Gets the paragraphHTMLText value for this ParagraphCommentDetailsDTO.
     * 
     * @return paragraphHTMLText
     */
    public java.lang.String getParagraphHTMLText() {
        return paragraphHTMLText;
    }


    /**
     * Sets the paragraphHTMLText value for this ParagraphCommentDetailsDTO.
     * 
     * @param paragraphHTMLText
     */
    public void setParagraphHTMLText(java.lang.String paragraphHTMLText) {
        this.paragraphHTMLText = paragraphHTMLText;
    }


    /**
     * Gets the comments value for this ParagraphCommentDetailsDTO.
     * 
     * @return comments
     */
    public com.peniel.tara.CommentDTO[][] getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this ParagraphCommentDetailsDTO.
     * 
     * @param comments
     */
    public void setComments(com.peniel.tara.CommentDTO[][] comments) {
        this.comments = comments;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParagraphCommentDetailsDTO)) return false;
        ParagraphCommentDetailsDTO other = (ParagraphCommentDetailsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.openChanges == other.getOpenChanges() &&
            ((this.paragraphText==null && other.getParagraphText()==null) || 
             (this.paragraphText!=null &&
              this.paragraphText.equals(other.getParagraphText()))) &&
            ((this.paragraphHTMLText==null && other.getParagraphHTMLText()==null) || 
             (this.paragraphHTMLText!=null &&
              this.paragraphHTMLText.equals(other.getParagraphHTMLText()))) &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              java.util.Arrays.equals(this.comments, other.getComments())));
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
        _hashCode += getOpenChanges();
        if (getParagraphText() != null) {
            _hashCode += getParagraphText().hashCode();
        }
        if (getParagraphHTMLText() != null) {
            _hashCode += getParagraphHTMLText().hashCode();
        }
        if (getComments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getComments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getComments(), i);
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
        new org.apache.axis.description.TypeDesc(ParagraphCommentDetailsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParagraphCommentDetailsDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openChanges");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OpenChanges"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paragraphText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParagraphText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paragraphHTMLText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParagraphHTMLText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ArrayOfCommentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ArrayOfCommentDTO"));
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
