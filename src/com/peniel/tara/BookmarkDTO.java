/**
 * BookmarkDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class BookmarkDTO  implements java.io.Serializable {
    private int objectId;

    private int documentId;

    private int reviewId;

    private java.lang.String paragraphId;

    private int subjectId;

    private com.peniel.tara.SubjectDTO subjectDTO;

    private java.lang.String title;

    private java.lang.String bookmarkText;

    private int publicView;

    private java.util.Calendar updateDate;

    private java.lang.String bookmarkIcon;

    public BookmarkDTO() {
    }

    public BookmarkDTO(
           int objectId,
           int documentId,
           int reviewId,
           java.lang.String paragraphId,
           int subjectId,
           com.peniel.tara.SubjectDTO subjectDTO,
           java.lang.String title,
           java.lang.String bookmarkText,
           int publicView,
           java.util.Calendar updateDate,
           java.lang.String bookmarkIcon) {
           this.objectId = objectId;
           this.documentId = documentId;
           this.reviewId = reviewId;
           this.paragraphId = paragraphId;
           this.subjectId = subjectId;
           this.subjectDTO = subjectDTO;
           this.title = title;
           this.bookmarkText = bookmarkText;
           this.publicView = publicView;
           this.updateDate = updateDate;
           this.bookmarkIcon = bookmarkIcon;
    }


    /**
     * Gets the objectId value for this BookmarkDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this BookmarkDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the documentId value for this BookmarkDTO.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this BookmarkDTO.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the reviewId value for this BookmarkDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this BookmarkDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the paragraphId value for this BookmarkDTO.
     * 
     * @return paragraphId
     */
    public java.lang.String getParagraphId() {
        return paragraphId;
    }


    /**
     * Sets the paragraphId value for this BookmarkDTO.
     * 
     * @param paragraphId
     */
    public void setParagraphId(java.lang.String paragraphId) {
        this.paragraphId = paragraphId;
    }


    /**
     * Gets the subjectId value for this BookmarkDTO.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this BookmarkDTO.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the subjectDTO value for this BookmarkDTO.
     * 
     * @return subjectDTO
     */
    public com.peniel.tara.SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }


    /**
     * Sets the subjectDTO value for this BookmarkDTO.
     * 
     * @param subjectDTO
     */
    public void setSubjectDTO(com.peniel.tara.SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }


    /**
     * Gets the title value for this BookmarkDTO.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this BookmarkDTO.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the bookmarkText value for this BookmarkDTO.
     * 
     * @return bookmarkText
     */
    public java.lang.String getBookmarkText() {
        return bookmarkText;
    }


    /**
     * Sets the bookmarkText value for this BookmarkDTO.
     * 
     * @param bookmarkText
     */
    public void setBookmarkText(java.lang.String bookmarkText) {
        this.bookmarkText = bookmarkText;
    }


    /**
     * Gets the publicView value for this BookmarkDTO.
     * 
     * @return publicView
     */
    public int getPublicView() {
        return publicView;
    }


    /**
     * Sets the publicView value for this BookmarkDTO.
     * 
     * @param publicView
     */
    public void setPublicView(int publicView) {
        this.publicView = publicView;
    }


    /**
     * Gets the updateDate value for this BookmarkDTO.
     * 
     * @return updateDate
     */
    public java.util.Calendar getUpdateDate() {
        return updateDate;
    }


    /**
     * Sets the updateDate value for this BookmarkDTO.
     * 
     * @param updateDate
     */
    public void setUpdateDate(java.util.Calendar updateDate) {
        this.updateDate = updateDate;
    }


    /**
     * Gets the bookmarkIcon value for this BookmarkDTO.
     * 
     * @return bookmarkIcon
     */
    public java.lang.String getBookmarkIcon() {
        return bookmarkIcon;
    }


    /**
     * Sets the bookmarkIcon value for this BookmarkDTO.
     * 
     * @param bookmarkIcon
     */
    public void setBookmarkIcon(java.lang.String bookmarkIcon) {
        this.bookmarkIcon = bookmarkIcon;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BookmarkDTO)) return false;
        BookmarkDTO other = (BookmarkDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            this.documentId == other.getDocumentId() &&
            this.reviewId == other.getReviewId() &&
            ((this.paragraphId==null && other.getParagraphId()==null) || 
             (this.paragraphId!=null &&
              this.paragraphId.equals(other.getParagraphId()))) &&
            this.subjectId == other.getSubjectId() &&
            ((this.subjectDTO==null && other.getSubjectDTO()==null) || 
             (this.subjectDTO!=null &&
              this.subjectDTO.equals(other.getSubjectDTO()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.bookmarkText==null && other.getBookmarkText()==null) || 
             (this.bookmarkText!=null &&
              this.bookmarkText.equals(other.getBookmarkText()))) &&
            this.publicView == other.getPublicView() &&
            ((this.updateDate==null && other.getUpdateDate()==null) || 
             (this.updateDate!=null &&
              this.updateDate.equals(other.getUpdateDate()))) &&
            ((this.bookmarkIcon==null && other.getBookmarkIcon()==null) || 
             (this.bookmarkIcon!=null &&
              this.bookmarkIcon.equals(other.getBookmarkIcon())));
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
        _hashCode += getObjectId();
        _hashCode += getDocumentId();
        _hashCode += getReviewId();
        if (getParagraphId() != null) {
            _hashCode += getParagraphId().hashCode();
        }
        _hashCode += getSubjectId();
        if (getSubjectDTO() != null) {
            _hashCode += getSubjectDTO().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getBookmarkText() != null) {
            _hashCode += getBookmarkText().hashCode();
        }
        _hashCode += getPublicView();
        if (getUpdateDate() != null) {
            _hashCode += getUpdateDate().hashCode();
        }
        if (getBookmarkIcon() != null) {
            _hashCode += getBookmarkIcon().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BookmarkDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "BookmarkDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
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
        elemField.setFieldName("reviewId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewId"));
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
        elemField.setFieldName("subjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookmarkText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "BookmarkText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicView");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "PublicView"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UpdateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookmarkIcon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "BookmarkIcon"));
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
