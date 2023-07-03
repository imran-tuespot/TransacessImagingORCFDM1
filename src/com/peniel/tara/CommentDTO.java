/**
 * CommentDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class CommentDTO  implements java.io.Serializable {
    private int objectId;

    private int documentId;

    private int reviewId;

    private java.lang.String paragraphId;

    private java.lang.String location;

    private int parentCommentId;

    private int commentNumber;

    private int threadCommentId;

    private int subjectId;

    private int reconcileSubjectId;

    private java.lang.String commentData;

    private java.lang.String status;

    private java.util.Calendar createDate;

    private java.util.Calendar updateDate;

    private java.lang.String commentType;

    private java.lang.String commentText;

    private java.lang.String paragraphText;

    private java.lang.String originalText;

    private java.lang.String reconcileText;

    private java.lang.String categoryText;

    private java.lang.String reviewerCategoryText;

    private int attachDocumentId;

    private java.lang.String attachFileName;

    private com.peniel.tara.SubjectDTO subjectDTO;

    private com.peniel.tara.SubjectDTO reconcileSubjectDTO;

    private int depth;

    private boolean hasChildren;

    private java.lang.String previousText;

    private com.peniel.tara.CommentDTOXmlDiff xmlDiff;

    private com.peniel.tara.CommentDTO[] otherAffectedComment;

    private int commentSequence;

    public CommentDTO() {
    }

    public CommentDTO(
           int objectId,
           int documentId,
           int reviewId,
           java.lang.String paragraphId,
           java.lang.String location,
           int parentCommentId,
           int commentNumber,
           int threadCommentId,
           int subjectId,
           int reconcileSubjectId,
           java.lang.String commentData,
           java.lang.String status,
           java.util.Calendar createDate,
           java.util.Calendar updateDate,
           java.lang.String commentType,
           java.lang.String commentText,
           java.lang.String paragraphText,
           java.lang.String originalText,
           java.lang.String reconcileText,
           java.lang.String categoryText,
           java.lang.String reviewerCategoryText,
           int attachDocumentId,
           java.lang.String attachFileName,
           com.peniel.tara.SubjectDTO subjectDTO,
           com.peniel.tara.SubjectDTO reconcileSubjectDTO,
           int depth,
           boolean hasChildren,
           java.lang.String previousText,
           com.peniel.tara.CommentDTOXmlDiff xmlDiff,
           com.peniel.tara.CommentDTO[] otherAffectedComment,
           int commentSequence) {
           this.objectId = objectId;
           this.documentId = documentId;
           this.reviewId = reviewId;
           this.paragraphId = paragraphId;
           this.location = location;
           this.parentCommentId = parentCommentId;
           this.commentNumber = commentNumber;
           this.threadCommentId = threadCommentId;
           this.subjectId = subjectId;
           this.reconcileSubjectId = reconcileSubjectId;
           this.commentData = commentData;
           this.status = status;
           this.createDate = createDate;
           this.updateDate = updateDate;
           this.commentType = commentType;
           this.commentText = commentText;
           this.paragraphText = paragraphText;
           this.originalText = originalText;
           this.reconcileText = reconcileText;
           this.categoryText = categoryText;
           this.reviewerCategoryText = reviewerCategoryText;
           this.attachDocumentId = attachDocumentId;
           this.attachFileName = attachFileName;
           this.subjectDTO = subjectDTO;
           this.reconcileSubjectDTO = reconcileSubjectDTO;
           this.depth = depth;
           this.hasChildren = hasChildren;
           this.previousText = previousText;
           this.xmlDiff = xmlDiff;
           this.otherAffectedComment = otherAffectedComment;
           this.commentSequence = commentSequence;
    }


    /**
     * Gets the objectId value for this CommentDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this CommentDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the documentId value for this CommentDTO.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this CommentDTO.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the reviewId value for this CommentDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this CommentDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the paragraphId value for this CommentDTO.
     * 
     * @return paragraphId
     */
    public java.lang.String getParagraphId() {
        return paragraphId;
    }


    /**
     * Sets the paragraphId value for this CommentDTO.
     * 
     * @param paragraphId
     */
    public void setParagraphId(java.lang.String paragraphId) {
        this.paragraphId = paragraphId;
    }


    /**
     * Gets the location value for this CommentDTO.
     * 
     * @return location
     */
    public java.lang.String getLocation() {
        return location;
    }


    /**
     * Sets the location value for this CommentDTO.
     * 
     * @param location
     */
    public void setLocation(java.lang.String location) {
        this.location = location;
    }


    /**
     * Gets the parentCommentId value for this CommentDTO.
     * 
     * @return parentCommentId
     */
    public int getParentCommentId() {
        return parentCommentId;
    }


    /**
     * Sets the parentCommentId value for this CommentDTO.
     * 
     * @param parentCommentId
     */
    public void setParentCommentId(int parentCommentId) {
        this.parentCommentId = parentCommentId;
    }


    /**
     * Gets the commentNumber value for this CommentDTO.
     * 
     * @return commentNumber
     */
    public int getCommentNumber() {
        return commentNumber;
    }


    /**
     * Sets the commentNumber value for this CommentDTO.
     * 
     * @param commentNumber
     */
    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }


    /**
     * Gets the threadCommentId value for this CommentDTO.
     * 
     * @return threadCommentId
     */
    public int getThreadCommentId() {
        return threadCommentId;
    }


    /**
     * Sets the threadCommentId value for this CommentDTO.
     * 
     * @param threadCommentId
     */
    public void setThreadCommentId(int threadCommentId) {
        this.threadCommentId = threadCommentId;
    }


    /**
     * Gets the subjectId value for this CommentDTO.
     * 
     * @return subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }


    /**
     * Sets the subjectId value for this CommentDTO.
     * 
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * Gets the reconcileSubjectId value for this CommentDTO.
     * 
     * @return reconcileSubjectId
     */
    public int getReconcileSubjectId() {
        return reconcileSubjectId;
    }


    /**
     * Sets the reconcileSubjectId value for this CommentDTO.
     * 
     * @param reconcileSubjectId
     */
    public void setReconcileSubjectId(int reconcileSubjectId) {
        this.reconcileSubjectId = reconcileSubjectId;
    }


    /**
     * Gets the commentData value for this CommentDTO.
     * 
     * @return commentData
     */
    public java.lang.String getCommentData() {
        return commentData;
    }


    /**
     * Sets the commentData value for this CommentDTO.
     * 
     * @param commentData
     */
    public void setCommentData(java.lang.String commentData) {
        this.commentData = commentData;
    }


    /**
     * Gets the status value for this CommentDTO.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CommentDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the createDate value for this CommentDTO.
     * 
     * @return createDate
     */
    public java.util.Calendar getCreateDate() {
        return createDate;
    }


    /**
     * Sets the createDate value for this CommentDTO.
     * 
     * @param createDate
     */
    public void setCreateDate(java.util.Calendar createDate) {
        this.createDate = createDate;
    }


    /**
     * Gets the updateDate value for this CommentDTO.
     * 
     * @return updateDate
     */
    public java.util.Calendar getUpdateDate() {
        return updateDate;
    }


    /**
     * Sets the updateDate value for this CommentDTO.
     * 
     * @param updateDate
     */
    public void setUpdateDate(java.util.Calendar updateDate) {
        this.updateDate = updateDate;
    }


    /**
     * Gets the commentType value for this CommentDTO.
     * 
     * @return commentType
     */
    public java.lang.String getCommentType() {
        return commentType;
    }


    /**
     * Sets the commentType value for this CommentDTO.
     * 
     * @param commentType
     */
    public void setCommentType(java.lang.String commentType) {
        this.commentType = commentType;
    }


    /**
     * Gets the commentText value for this CommentDTO.
     * 
     * @return commentText
     */
    public java.lang.String getCommentText() {
        return commentText;
    }


    /**
     * Sets the commentText value for this CommentDTO.
     * 
     * @param commentText
     */
    public void setCommentText(java.lang.String commentText) {
        this.commentText = commentText;
    }


    /**
     * Gets the paragraphText value for this CommentDTO.
     * 
     * @return paragraphText
     */
    public java.lang.String getParagraphText() {
        return paragraphText;
    }


    /**
     * Sets the paragraphText value for this CommentDTO.
     * 
     * @param paragraphText
     */
    public void setParagraphText(java.lang.String paragraphText) {
        this.paragraphText = paragraphText;
    }


    /**
     * Gets the originalText value for this CommentDTO.
     * 
     * @return originalText
     */
    public java.lang.String getOriginalText() {
        return originalText;
    }


    /**
     * Sets the originalText value for this CommentDTO.
     * 
     * @param originalText
     */
    public void setOriginalText(java.lang.String originalText) {
        this.originalText = originalText;
    }


    /**
     * Gets the reconcileText value for this CommentDTO.
     * 
     * @return reconcileText
     */
    public java.lang.String getReconcileText() {
        return reconcileText;
    }


    /**
     * Sets the reconcileText value for this CommentDTO.
     * 
     * @param reconcileText
     */
    public void setReconcileText(java.lang.String reconcileText) {
        this.reconcileText = reconcileText;
    }


    /**
     * Gets the categoryText value for this CommentDTO.
     * 
     * @return categoryText
     */
    public java.lang.String getCategoryText() {
        return categoryText;
    }


    /**
     * Sets the categoryText value for this CommentDTO.
     * 
     * @param categoryText
     */
    public void setCategoryText(java.lang.String categoryText) {
        this.categoryText = categoryText;
    }


    /**
     * Gets the reviewerCategoryText value for this CommentDTO.
     * 
     * @return reviewerCategoryText
     */
    public java.lang.String getReviewerCategoryText() {
        return reviewerCategoryText;
    }


    /**
     * Sets the reviewerCategoryText value for this CommentDTO.
     * 
     * @param reviewerCategoryText
     */
    public void setReviewerCategoryText(java.lang.String reviewerCategoryText) {
        this.reviewerCategoryText = reviewerCategoryText;
    }


    /**
     * Gets the attachDocumentId value for this CommentDTO.
     * 
     * @return attachDocumentId
     */
    public int getAttachDocumentId() {
        return attachDocumentId;
    }


    /**
     * Sets the attachDocumentId value for this CommentDTO.
     * 
     * @param attachDocumentId
     */
    public void setAttachDocumentId(int attachDocumentId) {
        this.attachDocumentId = attachDocumentId;
    }


    /**
     * Gets the attachFileName value for this CommentDTO.
     * 
     * @return attachFileName
     */
    public java.lang.String getAttachFileName() {
        return attachFileName;
    }


    /**
     * Sets the attachFileName value for this CommentDTO.
     * 
     * @param attachFileName
     */
    public void setAttachFileName(java.lang.String attachFileName) {
        this.attachFileName = attachFileName;
    }


    /**
     * Gets the subjectDTO value for this CommentDTO.
     * 
     * @return subjectDTO
     */
    public com.peniel.tara.SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }


    /**
     * Sets the subjectDTO value for this CommentDTO.
     * 
     * @param subjectDTO
     */
    public void setSubjectDTO(com.peniel.tara.SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }


    /**
     * Gets the reconcileSubjectDTO value for this CommentDTO.
     * 
     * @return reconcileSubjectDTO
     */
    public com.peniel.tara.SubjectDTO getReconcileSubjectDTO() {
        return reconcileSubjectDTO;
    }


    /**
     * Sets the reconcileSubjectDTO value for this CommentDTO.
     * 
     * @param reconcileSubjectDTO
     */
    public void setReconcileSubjectDTO(com.peniel.tara.SubjectDTO reconcileSubjectDTO) {
        this.reconcileSubjectDTO = reconcileSubjectDTO;
    }


    /**
     * Gets the depth value for this CommentDTO.
     * 
     * @return depth
     */
    public int getDepth() {
        return depth;
    }


    /**
     * Sets the depth value for this CommentDTO.
     * 
     * @param depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }


    /**
     * Gets the hasChildren value for this CommentDTO.
     * 
     * @return hasChildren
     */
    public boolean isHasChildren() {
        return hasChildren;
    }


    /**
     * Sets the hasChildren value for this CommentDTO.
     * 
     * @param hasChildren
     */
    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }


    /**
     * Gets the previousText value for this CommentDTO.
     * 
     * @return previousText
     */
    public java.lang.String getPreviousText() {
        return previousText;
    }


    /**
     * Sets the previousText value for this CommentDTO.
     * 
     * @param previousText
     */
    public void setPreviousText(java.lang.String previousText) {
        this.previousText = previousText;
    }


    /**
     * Gets the xmlDiff value for this CommentDTO.
     * 
     * @return xmlDiff
     */
    public com.peniel.tara.CommentDTOXmlDiff getXmlDiff() {
        return xmlDiff;
    }


    /**
     * Sets the xmlDiff value for this CommentDTO.
     * 
     * @param xmlDiff
     */
    public void setXmlDiff(com.peniel.tara.CommentDTOXmlDiff xmlDiff) {
        this.xmlDiff = xmlDiff;
    }


    /**
     * Gets the otherAffectedComment value for this CommentDTO.
     * 
     * @return otherAffectedComment
     */
    public com.peniel.tara.CommentDTO[] getOtherAffectedComment() {
        return otherAffectedComment;
    }


    /**
     * Sets the otherAffectedComment value for this CommentDTO.
     * 
     * @param otherAffectedComment
     */
    public void setOtherAffectedComment(com.peniel.tara.CommentDTO[] otherAffectedComment) {
        this.otherAffectedComment = otherAffectedComment;
    }


    /**
     * Gets the commentSequence value for this CommentDTO.
     * 
     * @return commentSequence
     */
    public int getCommentSequence() {
        return commentSequence;
    }


    /**
     * Sets the commentSequence value for this CommentDTO.
     * 
     * @param commentSequence
     */
    public void setCommentSequence(int commentSequence) {
        this.commentSequence = commentSequence;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommentDTO)) return false;
        CommentDTO other = (CommentDTO) obj;
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
            ((this.location==null && other.getLocation()==null) || 
             (this.location!=null &&
              this.location.equals(other.getLocation()))) &&
            this.parentCommentId == other.getParentCommentId() &&
            this.commentNumber == other.getCommentNumber() &&
            this.threadCommentId == other.getThreadCommentId() &&
            this.subjectId == other.getSubjectId() &&
            this.reconcileSubjectId == other.getReconcileSubjectId() &&
            ((this.commentData==null && other.getCommentData()==null) || 
             (this.commentData!=null &&
              this.commentData.equals(other.getCommentData()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.createDate==null && other.getCreateDate()==null) || 
             (this.createDate!=null &&
              this.createDate.equals(other.getCreateDate()))) &&
            ((this.updateDate==null && other.getUpdateDate()==null) || 
             (this.updateDate!=null &&
              this.updateDate.equals(other.getUpdateDate()))) &&
            ((this.commentType==null && other.getCommentType()==null) || 
             (this.commentType!=null &&
              this.commentType.equals(other.getCommentType()))) &&
            ((this.commentText==null && other.getCommentText()==null) || 
             (this.commentText!=null &&
              this.commentText.equals(other.getCommentText()))) &&
            ((this.paragraphText==null && other.getParagraphText()==null) || 
             (this.paragraphText!=null &&
              this.paragraphText.equals(other.getParagraphText()))) &&
            ((this.originalText==null && other.getOriginalText()==null) || 
             (this.originalText!=null &&
              this.originalText.equals(other.getOriginalText()))) &&
            ((this.reconcileText==null && other.getReconcileText()==null) || 
             (this.reconcileText!=null &&
              this.reconcileText.equals(other.getReconcileText()))) &&
            ((this.categoryText==null && other.getCategoryText()==null) || 
             (this.categoryText!=null &&
              this.categoryText.equals(other.getCategoryText()))) &&
            ((this.reviewerCategoryText==null && other.getReviewerCategoryText()==null) || 
             (this.reviewerCategoryText!=null &&
              this.reviewerCategoryText.equals(other.getReviewerCategoryText()))) &&
            this.attachDocumentId == other.getAttachDocumentId() &&
            ((this.attachFileName==null && other.getAttachFileName()==null) || 
             (this.attachFileName!=null &&
              this.attachFileName.equals(other.getAttachFileName()))) &&
            ((this.subjectDTO==null && other.getSubjectDTO()==null) || 
             (this.subjectDTO!=null &&
              this.subjectDTO.equals(other.getSubjectDTO()))) &&
            ((this.reconcileSubjectDTO==null && other.getReconcileSubjectDTO()==null) || 
             (this.reconcileSubjectDTO!=null &&
              this.reconcileSubjectDTO.equals(other.getReconcileSubjectDTO()))) &&
            this.depth == other.getDepth() &&
            this.hasChildren == other.isHasChildren() &&
            ((this.previousText==null && other.getPreviousText()==null) || 
             (this.previousText!=null &&
              this.previousText.equals(other.getPreviousText()))) &&
            ((this.xmlDiff==null && other.getXmlDiff()==null) || 
             (this.xmlDiff!=null &&
              this.xmlDiff.equals(other.getXmlDiff()))) &&
            ((this.otherAffectedComment==null && other.getOtherAffectedComment()==null) || 
             (this.otherAffectedComment!=null &&
              java.util.Arrays.equals(this.otherAffectedComment, other.getOtherAffectedComment()))) &&
            this.commentSequence == other.getCommentSequence();
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
        if (getLocation() != null) {
            _hashCode += getLocation().hashCode();
        }
        _hashCode += getParentCommentId();
        _hashCode += getCommentNumber();
        _hashCode += getThreadCommentId();
        _hashCode += getSubjectId();
        _hashCode += getReconcileSubjectId();
        if (getCommentData() != null) {
            _hashCode += getCommentData().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getCreateDate() != null) {
            _hashCode += getCreateDate().hashCode();
        }
        if (getUpdateDate() != null) {
            _hashCode += getUpdateDate().hashCode();
        }
        if (getCommentType() != null) {
            _hashCode += getCommentType().hashCode();
        }
        if (getCommentText() != null) {
            _hashCode += getCommentText().hashCode();
        }
        if (getParagraphText() != null) {
            _hashCode += getParagraphText().hashCode();
        }
        if (getOriginalText() != null) {
            _hashCode += getOriginalText().hashCode();
        }
        if (getReconcileText() != null) {
            _hashCode += getReconcileText().hashCode();
        }
        if (getCategoryText() != null) {
            _hashCode += getCategoryText().hashCode();
        }
        if (getReviewerCategoryText() != null) {
            _hashCode += getReviewerCategoryText().hashCode();
        }
        _hashCode += getAttachDocumentId();
        if (getAttachFileName() != null) {
            _hashCode += getAttachFileName().hashCode();
        }
        if (getSubjectDTO() != null) {
            _hashCode += getSubjectDTO().hashCode();
        }
        if (getReconcileSubjectDTO() != null) {
            _hashCode += getReconcileSubjectDTO().hashCode();
        }
        _hashCode += getDepth();
        _hashCode += (isHasChildren() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPreviousText() != null) {
            _hashCode += getPreviousText().hashCode();
        }
        if (getXmlDiff() != null) {
            _hashCode += getXmlDiff().hashCode();
        }
        if (getOtherAffectedComment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOtherAffectedComment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOtherAffectedComment(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getCommentSequence();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommentDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentDTO"));
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
        elemField.setFieldName("location");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Location"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentCommentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParentCommentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("threadCommentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ThreadCommentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reconcileSubjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReconcileSubjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CreateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UpdateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("originalText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OriginalText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reconcileText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReconcileText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoryText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CategoryText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewerCategoryText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReviewerCategoryText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachDocumentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "AttachDocumentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "AttachFileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("reconcileSubjectDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReconcileSubjectDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depth");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Depth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasChildren");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "HasChildren"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previousText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "PreviousText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlDiff");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "XmlDiff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">CommentDTO>XmlDiff"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherAffectedComment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OtherAffectedComment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentDTO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentSequence");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentSequence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
