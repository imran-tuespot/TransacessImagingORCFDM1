/**
 * ListBookmarkParamsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListBookmarkParamsDTO  implements java.io.Serializable {
    private int reviewId;

    private int documentId;

    private java.lang.String paragraphId;

    private boolean includeSubjectDto;

    private int[] subjectIds;

    private int publicView;

    private boolean generalBookmarksOnly;

    private boolean allBookmark;

    private boolean independentReview;

    private boolean independentReviewOwner;

    public ListBookmarkParamsDTO() {
    }

    public ListBookmarkParamsDTO(
           int reviewId,
           int documentId,
           java.lang.String paragraphId,
           boolean includeSubjectDto,
           int[] subjectIds,
           int publicView,
           boolean generalBookmarksOnly,
           boolean allBookmark,
           boolean independentReview,
           boolean independentReviewOwner) {
           this.reviewId = reviewId;
           this.documentId = documentId;
           this.paragraphId = paragraphId;
           this.includeSubjectDto = includeSubjectDto;
           this.subjectIds = subjectIds;
           this.publicView = publicView;
           this.generalBookmarksOnly = generalBookmarksOnly;
           this.allBookmark = allBookmark;
           this.independentReview = independentReview;
           this.independentReviewOwner = independentReviewOwner;
    }


    /**
     * Gets the reviewId value for this ListBookmarkParamsDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this ListBookmarkParamsDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the documentId value for this ListBookmarkParamsDTO.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this ListBookmarkParamsDTO.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the paragraphId value for this ListBookmarkParamsDTO.
     * 
     * @return paragraphId
     */
    public java.lang.String getParagraphId() {
        return paragraphId;
    }


    /**
     * Sets the paragraphId value for this ListBookmarkParamsDTO.
     * 
     * @param paragraphId
     */
    public void setParagraphId(java.lang.String paragraphId) {
        this.paragraphId = paragraphId;
    }


    /**
     * Gets the includeSubjectDto value for this ListBookmarkParamsDTO.
     * 
     * @return includeSubjectDto
     */
    public boolean isIncludeSubjectDto() {
        return includeSubjectDto;
    }


    /**
     * Sets the includeSubjectDto value for this ListBookmarkParamsDTO.
     * 
     * @param includeSubjectDto
     */
    public void setIncludeSubjectDto(boolean includeSubjectDto) {
        this.includeSubjectDto = includeSubjectDto;
    }


    /**
     * Gets the subjectIds value for this ListBookmarkParamsDTO.
     * 
     * @return subjectIds
     */
    public int[] getSubjectIds() {
        return subjectIds;
    }


    /**
     * Sets the subjectIds value for this ListBookmarkParamsDTO.
     * 
     * @param subjectIds
     */
    public void setSubjectIds(int[] subjectIds) {
        this.subjectIds = subjectIds;
    }


    /**
     * Gets the publicView value for this ListBookmarkParamsDTO.
     * 
     * @return publicView
     */
    public int getPublicView() {
        return publicView;
    }


    /**
     * Sets the publicView value for this ListBookmarkParamsDTO.
     * 
     * @param publicView
     */
    public void setPublicView(int publicView) {
        this.publicView = publicView;
    }


    /**
     * Gets the generalBookmarksOnly value for this ListBookmarkParamsDTO.
     * 
     * @return generalBookmarksOnly
     */
    public boolean isGeneralBookmarksOnly() {
        return generalBookmarksOnly;
    }


    /**
     * Sets the generalBookmarksOnly value for this ListBookmarkParamsDTO.
     * 
     * @param generalBookmarksOnly
     */
    public void setGeneralBookmarksOnly(boolean generalBookmarksOnly) {
        this.generalBookmarksOnly = generalBookmarksOnly;
    }


    /**
     * Gets the allBookmark value for this ListBookmarkParamsDTO.
     * 
     * @return allBookmark
     */
    public boolean isAllBookmark() {
        return allBookmark;
    }


    /**
     * Sets the allBookmark value for this ListBookmarkParamsDTO.
     * 
     * @param allBookmark
     */
    public void setAllBookmark(boolean allBookmark) {
        this.allBookmark = allBookmark;
    }


    /**
     * Gets the independentReview value for this ListBookmarkParamsDTO.
     * 
     * @return independentReview
     */
    public boolean isIndependentReview() {
        return independentReview;
    }


    /**
     * Sets the independentReview value for this ListBookmarkParamsDTO.
     * 
     * @param independentReview
     */
    public void setIndependentReview(boolean independentReview) {
        this.independentReview = independentReview;
    }


    /**
     * Gets the independentReviewOwner value for this ListBookmarkParamsDTO.
     * 
     * @return independentReviewOwner
     */
    public boolean isIndependentReviewOwner() {
        return independentReviewOwner;
    }


    /**
     * Sets the independentReviewOwner value for this ListBookmarkParamsDTO.
     * 
     * @param independentReviewOwner
     */
    public void setIndependentReviewOwner(boolean independentReviewOwner) {
        this.independentReviewOwner = independentReviewOwner;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListBookmarkParamsDTO)) return false;
        ListBookmarkParamsDTO other = (ListBookmarkParamsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.reviewId == other.getReviewId() &&
            this.documentId == other.getDocumentId() &&
            ((this.paragraphId==null && other.getParagraphId()==null) || 
             (this.paragraphId!=null &&
              this.paragraphId.equals(other.getParagraphId()))) &&
            this.includeSubjectDto == other.isIncludeSubjectDto() &&
            ((this.subjectIds==null && other.getSubjectIds()==null) || 
             (this.subjectIds!=null &&
              java.util.Arrays.equals(this.subjectIds, other.getSubjectIds()))) &&
            this.publicView == other.getPublicView() &&
            this.generalBookmarksOnly == other.isGeneralBookmarksOnly() &&
            this.allBookmark == other.isAllBookmark() &&
            this.independentReview == other.isIndependentReview() &&
            this.independentReviewOwner == other.isIndependentReviewOwner();
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
        _hashCode += getReviewId();
        _hashCode += getDocumentId();
        if (getParagraphId() != null) {
            _hashCode += getParagraphId().hashCode();
        }
        _hashCode += (isIncludeSubjectDto() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSubjectIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubjectIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubjectIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getPublicView();
        _hashCode += (isGeneralBookmarksOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAllBookmark() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIndependentReview() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIndependentReviewOwner() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListBookmarkParamsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListBookmarkParamsDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DocumentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paragraphId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParagraphId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeSubjectDto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IncludeSubjectDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicView");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "PublicView"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("generalBookmarksOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GeneralBookmarksOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allBookmark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "AllBookmark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("independentReview");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IndependentReview"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("independentReviewOwner");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IndependentReviewOwner"));
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
