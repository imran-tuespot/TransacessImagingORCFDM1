/**
 * FeedbackTypeDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class FeedbackTypeDTO  implements java.io.Serializable {
    private java.lang.String name;

    private java.lang.String inherits;

    private java.lang.String bsAdapter;

    private java.lang.String webAdapter;

    private java.lang.String ajaxRefreshHandler;

    private java.lang.String wordRenderXSL;

    private java.lang.String reconReportRenderXSL;

    private java.lang.String triggerStyle;

    private java.lang.String style;

    private java.lang.String tableStyle;

    private java.lang.String paragraphStyle;

    private boolean allowReply;

    private int maxLength;

    private boolean enableLike;

    private com.peniel.tara.FeedbackTypeList groupType;

    private com.peniel.tara.FeedbackOptionDTO[] ratings;

    private java.lang.String wordMLOutputStyle;

    private java.lang.String wordMLNumberingOutputStyle;

    public FeedbackTypeDTO() {
    }

    public FeedbackTypeDTO(
           java.lang.String name,
           java.lang.String inherits,
           java.lang.String bsAdapter,
           java.lang.String webAdapter,
           java.lang.String ajaxRefreshHandler,
           java.lang.String wordRenderXSL,
           java.lang.String reconReportRenderXSL,
           java.lang.String triggerStyle,
           java.lang.String style,
           java.lang.String tableStyle,
           java.lang.String paragraphStyle,
           boolean allowReply,
           int maxLength,
           boolean enableLike,
           com.peniel.tara.FeedbackTypeList groupType,
           com.peniel.tara.FeedbackOptionDTO[] ratings,
           java.lang.String wordMLOutputStyle,
           java.lang.String wordMLNumberingOutputStyle) {
           this.name = name;
           this.inherits = inherits;
           this.bsAdapter = bsAdapter;
           this.webAdapter = webAdapter;
           this.ajaxRefreshHandler = ajaxRefreshHandler;
           this.wordRenderXSL = wordRenderXSL;
           this.reconReportRenderXSL = reconReportRenderXSL;
           this.triggerStyle = triggerStyle;
           this.style = style;
           this.tableStyle = tableStyle;
           this.paragraphStyle = paragraphStyle;
           this.allowReply = allowReply;
           this.maxLength = maxLength;
           this.enableLike = enableLike;
           this.groupType = groupType;
           this.ratings = ratings;
           this.wordMLOutputStyle = wordMLOutputStyle;
           this.wordMLNumberingOutputStyle = wordMLNumberingOutputStyle;
    }


    /**
     * Gets the name value for this FeedbackTypeDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this FeedbackTypeDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the inherits value for this FeedbackTypeDTO.
     * 
     * @return inherits
     */
    public java.lang.String getInherits() {
        return inherits;
    }


    /**
     * Sets the inherits value for this FeedbackTypeDTO.
     * 
     * @param inherits
     */
    public void setInherits(java.lang.String inherits) {
        this.inherits = inherits;
    }


    /**
     * Gets the bsAdapter value for this FeedbackTypeDTO.
     * 
     * @return bsAdapter
     */
    public java.lang.String getBsAdapter() {
        return bsAdapter;
    }


    /**
     * Sets the bsAdapter value for this FeedbackTypeDTO.
     * 
     * @param bsAdapter
     */
    public void setBsAdapter(java.lang.String bsAdapter) {
        this.bsAdapter = bsAdapter;
    }


    /**
     * Gets the webAdapter value for this FeedbackTypeDTO.
     * 
     * @return webAdapter
     */
    public java.lang.String getWebAdapter() {
        return webAdapter;
    }


    /**
     * Sets the webAdapter value for this FeedbackTypeDTO.
     * 
     * @param webAdapter
     */
    public void setWebAdapter(java.lang.String webAdapter) {
        this.webAdapter = webAdapter;
    }


    /**
     * Gets the ajaxRefreshHandler value for this FeedbackTypeDTO.
     * 
     * @return ajaxRefreshHandler
     */
    public java.lang.String getAjaxRefreshHandler() {
        return ajaxRefreshHandler;
    }


    /**
     * Sets the ajaxRefreshHandler value for this FeedbackTypeDTO.
     * 
     * @param ajaxRefreshHandler
     */
    public void setAjaxRefreshHandler(java.lang.String ajaxRefreshHandler) {
        this.ajaxRefreshHandler = ajaxRefreshHandler;
    }


    /**
     * Gets the wordRenderXSL value for this FeedbackTypeDTO.
     * 
     * @return wordRenderXSL
     */
    public java.lang.String getWordRenderXSL() {
        return wordRenderXSL;
    }


    /**
     * Sets the wordRenderXSL value for this FeedbackTypeDTO.
     * 
     * @param wordRenderXSL
     */
    public void setWordRenderXSL(java.lang.String wordRenderXSL) {
        this.wordRenderXSL = wordRenderXSL;
    }


    /**
     * Gets the reconReportRenderXSL value for this FeedbackTypeDTO.
     * 
     * @return reconReportRenderXSL
     */
    public java.lang.String getReconReportRenderXSL() {
        return reconReportRenderXSL;
    }


    /**
     * Sets the reconReportRenderXSL value for this FeedbackTypeDTO.
     * 
     * @param reconReportRenderXSL
     */
    public void setReconReportRenderXSL(java.lang.String reconReportRenderXSL) {
        this.reconReportRenderXSL = reconReportRenderXSL;
    }


    /**
     * Gets the triggerStyle value for this FeedbackTypeDTO.
     * 
     * @return triggerStyle
     */
    public java.lang.String getTriggerStyle() {
        return triggerStyle;
    }


    /**
     * Sets the triggerStyle value for this FeedbackTypeDTO.
     * 
     * @param triggerStyle
     */
    public void setTriggerStyle(java.lang.String triggerStyle) {
        this.triggerStyle = triggerStyle;
    }


    /**
     * Gets the style value for this FeedbackTypeDTO.
     * 
     * @return style
     */
    public java.lang.String getStyle() {
        return style;
    }


    /**
     * Sets the style value for this FeedbackTypeDTO.
     * 
     * @param style
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
    }


    /**
     * Gets the tableStyle value for this FeedbackTypeDTO.
     * 
     * @return tableStyle
     */
    public java.lang.String getTableStyle() {
        return tableStyle;
    }


    /**
     * Sets the tableStyle value for this FeedbackTypeDTO.
     * 
     * @param tableStyle
     */
    public void setTableStyle(java.lang.String tableStyle) {
        this.tableStyle = tableStyle;
    }


    /**
     * Gets the paragraphStyle value for this FeedbackTypeDTO.
     * 
     * @return paragraphStyle
     */
    public java.lang.String getParagraphStyle() {
        return paragraphStyle;
    }


    /**
     * Sets the paragraphStyle value for this FeedbackTypeDTO.
     * 
     * @param paragraphStyle
     */
    public void setParagraphStyle(java.lang.String paragraphStyle) {
        this.paragraphStyle = paragraphStyle;
    }


    /**
     * Gets the allowReply value for this FeedbackTypeDTO.
     * 
     * @return allowReply
     */
    public boolean isAllowReply() {
        return allowReply;
    }


    /**
     * Sets the allowReply value for this FeedbackTypeDTO.
     * 
     * @param allowReply
     */
    public void setAllowReply(boolean allowReply) {
        this.allowReply = allowReply;
    }


    /**
     * Gets the maxLength value for this FeedbackTypeDTO.
     * 
     * @return maxLength
     */
    public int getMaxLength() {
        return maxLength;
    }


    /**
     * Sets the maxLength value for this FeedbackTypeDTO.
     * 
     * @param maxLength
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }


    /**
     * Gets the enableLike value for this FeedbackTypeDTO.
     * 
     * @return enableLike
     */
    public boolean isEnableLike() {
        return enableLike;
    }


    /**
     * Sets the enableLike value for this FeedbackTypeDTO.
     * 
     * @param enableLike
     */
    public void setEnableLike(boolean enableLike) {
        this.enableLike = enableLike;
    }


    /**
     * Gets the groupType value for this FeedbackTypeDTO.
     * 
     * @return groupType
     */
    public com.peniel.tara.FeedbackTypeList getGroupType() {
        return groupType;
    }


    /**
     * Sets the groupType value for this FeedbackTypeDTO.
     * 
     * @param groupType
     */
    public void setGroupType(com.peniel.tara.FeedbackTypeList groupType) {
        this.groupType = groupType;
    }


    /**
     * Gets the ratings value for this FeedbackTypeDTO.
     * 
     * @return ratings
     */
    public com.peniel.tara.FeedbackOptionDTO[] getRatings() {
        return ratings;
    }


    /**
     * Sets the ratings value for this FeedbackTypeDTO.
     * 
     * @param ratings
     */
    public void setRatings(com.peniel.tara.FeedbackOptionDTO[] ratings) {
        this.ratings = ratings;
    }


    /**
     * Gets the wordMLOutputStyle value for this FeedbackTypeDTO.
     * 
     * @return wordMLOutputStyle
     */
    public java.lang.String getWordMLOutputStyle() {
        return wordMLOutputStyle;
    }


    /**
     * Sets the wordMLOutputStyle value for this FeedbackTypeDTO.
     * 
     * @param wordMLOutputStyle
     */
    public void setWordMLOutputStyle(java.lang.String wordMLOutputStyle) {
        this.wordMLOutputStyle = wordMLOutputStyle;
    }


    /**
     * Gets the wordMLNumberingOutputStyle value for this FeedbackTypeDTO.
     * 
     * @return wordMLNumberingOutputStyle
     */
    public java.lang.String getWordMLNumberingOutputStyle() {
        return wordMLNumberingOutputStyle;
    }


    /**
     * Sets the wordMLNumberingOutputStyle value for this FeedbackTypeDTO.
     * 
     * @param wordMLNumberingOutputStyle
     */
    public void setWordMLNumberingOutputStyle(java.lang.String wordMLNumberingOutputStyle) {
        this.wordMLNumberingOutputStyle = wordMLNumberingOutputStyle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FeedbackTypeDTO)) return false;
        FeedbackTypeDTO other = (FeedbackTypeDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.inherits==null && other.getInherits()==null) || 
             (this.inherits!=null &&
              this.inherits.equals(other.getInherits()))) &&
            ((this.bsAdapter==null && other.getBsAdapter()==null) || 
             (this.bsAdapter!=null &&
              this.bsAdapter.equals(other.getBsAdapter()))) &&
            ((this.webAdapter==null && other.getWebAdapter()==null) || 
             (this.webAdapter!=null &&
              this.webAdapter.equals(other.getWebAdapter()))) &&
            ((this.ajaxRefreshHandler==null && other.getAjaxRefreshHandler()==null) || 
             (this.ajaxRefreshHandler!=null &&
              this.ajaxRefreshHandler.equals(other.getAjaxRefreshHandler()))) &&
            ((this.wordRenderXSL==null && other.getWordRenderXSL()==null) || 
             (this.wordRenderXSL!=null &&
              this.wordRenderXSL.equals(other.getWordRenderXSL()))) &&
            ((this.reconReportRenderXSL==null && other.getReconReportRenderXSL()==null) || 
             (this.reconReportRenderXSL!=null &&
              this.reconReportRenderXSL.equals(other.getReconReportRenderXSL()))) &&
            ((this.triggerStyle==null && other.getTriggerStyle()==null) || 
             (this.triggerStyle!=null &&
              this.triggerStyle.equals(other.getTriggerStyle()))) &&
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              this.style.equals(other.getStyle()))) &&
            ((this.tableStyle==null && other.getTableStyle()==null) || 
             (this.tableStyle!=null &&
              this.tableStyle.equals(other.getTableStyle()))) &&
            ((this.paragraphStyle==null && other.getParagraphStyle()==null) || 
             (this.paragraphStyle!=null &&
              this.paragraphStyle.equals(other.getParagraphStyle()))) &&
            this.allowReply == other.isAllowReply() &&
            this.maxLength == other.getMaxLength() &&
            this.enableLike == other.isEnableLike() &&
            ((this.groupType==null && other.getGroupType()==null) || 
             (this.groupType!=null &&
              this.groupType.equals(other.getGroupType()))) &&
            ((this.ratings==null && other.getRatings()==null) || 
             (this.ratings!=null &&
              java.util.Arrays.equals(this.ratings, other.getRatings()))) &&
            ((this.wordMLOutputStyle==null && other.getWordMLOutputStyle()==null) || 
             (this.wordMLOutputStyle!=null &&
              this.wordMLOutputStyle.equals(other.getWordMLOutputStyle()))) &&
            ((this.wordMLNumberingOutputStyle==null && other.getWordMLNumberingOutputStyle()==null) || 
             (this.wordMLNumberingOutputStyle!=null &&
              this.wordMLNumberingOutputStyle.equals(other.getWordMLNumberingOutputStyle())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getInherits() != null) {
            _hashCode += getInherits().hashCode();
        }
        if (getBsAdapter() != null) {
            _hashCode += getBsAdapter().hashCode();
        }
        if (getWebAdapter() != null) {
            _hashCode += getWebAdapter().hashCode();
        }
        if (getAjaxRefreshHandler() != null) {
            _hashCode += getAjaxRefreshHandler().hashCode();
        }
        if (getWordRenderXSL() != null) {
            _hashCode += getWordRenderXSL().hashCode();
        }
        if (getReconReportRenderXSL() != null) {
            _hashCode += getReconReportRenderXSL().hashCode();
        }
        if (getTriggerStyle() != null) {
            _hashCode += getTriggerStyle().hashCode();
        }
        if (getStyle() != null) {
            _hashCode += getStyle().hashCode();
        }
        if (getTableStyle() != null) {
            _hashCode += getTableStyle().hashCode();
        }
        if (getParagraphStyle() != null) {
            _hashCode += getParagraphStyle().hashCode();
        }
        _hashCode += (isAllowReply() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getMaxLength();
        _hashCode += (isEnableLike() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getGroupType() != null) {
            _hashCode += getGroupType().hashCode();
        }
        if (getRatings() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRatings());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRatings(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWordMLOutputStyle() != null) {
            _hashCode += getWordMLOutputStyle().hashCode();
        }
        if (getWordMLNumberingOutputStyle() != null) {
            _hashCode += getWordMLNumberingOutputStyle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FeedbackTypeDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackTypeDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inherits");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Inherits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bsAdapter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "BsAdapter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("webAdapter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WebAdapter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ajaxRefreshHandler");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "AjaxRefreshHandler"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wordRenderXSL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WordRenderXSL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reconReportRenderXSL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReconReportRenderXSL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("triggerStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TriggerStyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("style");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Style"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tableStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TableStyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paragraphStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParagraphStyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allowReply");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "AllowReply"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxLength");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "MaxLength"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableLike");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EnableLike"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GroupType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackTypeList"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ratings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Ratings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackOptionDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FeedbackOptionDTO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wordMLOutputStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WordMLOutputStyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wordMLNumberingOutputStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WordMLNumberingOutputStyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
