/**
 * ListCommentParamsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListCommentParamsDTO  implements java.io.Serializable {
    private int reviewId;

    private int documentId;

    private java.lang.String paragraphId;

    private boolean includeSubjectDto;

    private boolean headCommentsOnly;

    private java.lang.String[] status;

    private int[] subjectIds;

    private java.lang.String[] commentCategories;

    private boolean includeSubjectReplies;

    private java.util.Calendar updateDate;

    private boolean showTrackChange;

    private java.lang.String[] commentTypes;

    private boolean excludeGeneralComments;

    private boolean generalCommentsOnly;

    private boolean offlineCommentsOnly;

    private int offlineStartCommentId;

    private com.peniel.tara.ListEditDTO listEditDTO;

    private int modificationCount;

    private boolean includeOriginalTextForComments;

    private boolean showOpenTrackChanges;

    public ListCommentParamsDTO() {
    }

    public ListCommentParamsDTO(
           int reviewId,
           int documentId,
           java.lang.String paragraphId,
           boolean includeSubjectDto,
           boolean headCommentsOnly,
           java.lang.String[] status,
           int[] subjectIds,
           java.lang.String[] commentCategories,
           boolean includeSubjectReplies,
           java.util.Calendar updateDate,
           boolean showTrackChange,
           java.lang.String[] commentTypes,
           boolean excludeGeneralComments,
           boolean generalCommentsOnly,
           boolean offlineCommentsOnly,
           int offlineStartCommentId,
           com.peniel.tara.ListEditDTO listEditDTO,
           int modificationCount,
           boolean includeOriginalTextForComments,
           boolean showOpenTrackChanges) {
           this.reviewId = reviewId;
           this.documentId = documentId;
           this.paragraphId = paragraphId;
           this.includeSubjectDto = includeSubjectDto;
           this.headCommentsOnly = headCommentsOnly;
           this.status = status;
           this.subjectIds = subjectIds;
           this.commentCategories = commentCategories;
           this.includeSubjectReplies = includeSubjectReplies;
           this.updateDate = updateDate;
           this.showTrackChange = showTrackChange;
           this.commentTypes = commentTypes;
           this.excludeGeneralComments = excludeGeneralComments;
           this.generalCommentsOnly = generalCommentsOnly;
           this.offlineCommentsOnly = offlineCommentsOnly;
           this.offlineStartCommentId = offlineStartCommentId;
           this.listEditDTO = listEditDTO;
           this.modificationCount = modificationCount;
           this.includeOriginalTextForComments = includeOriginalTextForComments;
           this.showOpenTrackChanges = showOpenTrackChanges;
    }


    /**
     * Gets the reviewId value for this ListCommentParamsDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this ListCommentParamsDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the documentId value for this ListCommentParamsDTO.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this ListCommentParamsDTO.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the paragraphId value for this ListCommentParamsDTO.
     * 
     * @return paragraphId
     */
    public java.lang.String getParagraphId() {
        return paragraphId;
    }


    /**
     * Sets the paragraphId value for this ListCommentParamsDTO.
     * 
     * @param paragraphId
     */
    public void setParagraphId(java.lang.String paragraphId) {
        this.paragraphId = paragraphId;
    }


    /**
     * Gets the includeSubjectDto value for this ListCommentParamsDTO.
     * 
     * @return includeSubjectDto
     */
    public boolean isIncludeSubjectDto() {
        return includeSubjectDto;
    }


    /**
     * Sets the includeSubjectDto value for this ListCommentParamsDTO.
     * 
     * @param includeSubjectDto
     */
    public void setIncludeSubjectDto(boolean includeSubjectDto) {
        this.includeSubjectDto = includeSubjectDto;
    }


    /**
     * Gets the headCommentsOnly value for this ListCommentParamsDTO.
     * 
     * @return headCommentsOnly
     */
    public boolean isHeadCommentsOnly() {
        return headCommentsOnly;
    }


    /**
     * Sets the headCommentsOnly value for this ListCommentParamsDTO.
     * 
     * @param headCommentsOnly
     */
    public void setHeadCommentsOnly(boolean headCommentsOnly) {
        this.headCommentsOnly = headCommentsOnly;
    }


    /**
     * Gets the status value for this ListCommentParamsDTO.
     * 
     * @return status
     */
    public java.lang.String[] getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ListCommentParamsDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String[] status) {
        this.status = status;
    }


    /**
     * Gets the subjectIds value for this ListCommentParamsDTO.
     * 
     * @return subjectIds
     */
    public int[] getSubjectIds() {
        return subjectIds;
    }


    /**
     * Sets the subjectIds value for this ListCommentParamsDTO.
     * 
     * @param subjectIds
     */
    public void setSubjectIds(int[] subjectIds) {
        this.subjectIds = subjectIds;
    }


    /**
     * Gets the commentCategories value for this ListCommentParamsDTO.
     * 
     * @return commentCategories
     */
    public java.lang.String[] getCommentCategories() {
        return commentCategories;
    }


    /**
     * Sets the commentCategories value for this ListCommentParamsDTO.
     * 
     * @param commentCategories
     */
    public void setCommentCategories(java.lang.String[] commentCategories) {
        this.commentCategories = commentCategories;
    }


    /**
     * Gets the includeSubjectReplies value for this ListCommentParamsDTO.
     * 
     * @return includeSubjectReplies
     */
    public boolean isIncludeSubjectReplies() {
        return includeSubjectReplies;
    }


    /**
     * Sets the includeSubjectReplies value for this ListCommentParamsDTO.
     * 
     * @param includeSubjectReplies
     */
    public void setIncludeSubjectReplies(boolean includeSubjectReplies) {
        this.includeSubjectReplies = includeSubjectReplies;
    }


    /**
     * Gets the updateDate value for this ListCommentParamsDTO.
     * 
     * @return updateDate
     */
    public java.util.Calendar getUpdateDate() {
        return updateDate;
    }


    /**
     * Sets the updateDate value for this ListCommentParamsDTO.
     * 
     * @param updateDate
     */
    public void setUpdateDate(java.util.Calendar updateDate) {
        this.updateDate = updateDate;
    }


    /**
     * Gets the showTrackChange value for this ListCommentParamsDTO.
     * 
     * @return showTrackChange
     */
    public boolean isShowTrackChange() {
        return showTrackChange;
    }


    /**
     * Sets the showTrackChange value for this ListCommentParamsDTO.
     * 
     * @param showTrackChange
     */
    public void setShowTrackChange(boolean showTrackChange) {
        this.showTrackChange = showTrackChange;
    }


    /**
     * Gets the commentTypes value for this ListCommentParamsDTO.
     * 
     * @return commentTypes
     */
    public java.lang.String[] getCommentTypes() {
        return commentTypes;
    }


    /**
     * Sets the commentTypes value for this ListCommentParamsDTO.
     * 
     * @param commentTypes
     */
    public void setCommentTypes(java.lang.String[] commentTypes) {
        this.commentTypes = commentTypes;
    }


    /**
     * Gets the excludeGeneralComments value for this ListCommentParamsDTO.
     * 
     * @return excludeGeneralComments
     */
    public boolean isExcludeGeneralComments() {
        return excludeGeneralComments;
    }


    /**
     * Sets the excludeGeneralComments value for this ListCommentParamsDTO.
     * 
     * @param excludeGeneralComments
     */
    public void setExcludeGeneralComments(boolean excludeGeneralComments) {
        this.excludeGeneralComments = excludeGeneralComments;
    }


    /**
     * Gets the generalCommentsOnly value for this ListCommentParamsDTO.
     * 
     * @return generalCommentsOnly
     */
    public boolean isGeneralCommentsOnly() {
        return generalCommentsOnly;
    }


    /**
     * Sets the generalCommentsOnly value for this ListCommentParamsDTO.
     * 
     * @param generalCommentsOnly
     */
    public void setGeneralCommentsOnly(boolean generalCommentsOnly) {
        this.generalCommentsOnly = generalCommentsOnly;
    }


    /**
     * Gets the offlineCommentsOnly value for this ListCommentParamsDTO.
     * 
     * @return offlineCommentsOnly
     */
    public boolean isOfflineCommentsOnly() {
        return offlineCommentsOnly;
    }


    /**
     * Sets the offlineCommentsOnly value for this ListCommentParamsDTO.
     * 
     * @param offlineCommentsOnly
     */
    public void setOfflineCommentsOnly(boolean offlineCommentsOnly) {
        this.offlineCommentsOnly = offlineCommentsOnly;
    }


    /**
     * Gets the offlineStartCommentId value for this ListCommentParamsDTO.
     * 
     * @return offlineStartCommentId
     */
    public int getOfflineStartCommentId() {
        return offlineStartCommentId;
    }


    /**
     * Sets the offlineStartCommentId value for this ListCommentParamsDTO.
     * 
     * @param offlineStartCommentId
     */
    public void setOfflineStartCommentId(int offlineStartCommentId) {
        this.offlineStartCommentId = offlineStartCommentId;
    }


    /**
     * Gets the listEditDTO value for this ListCommentParamsDTO.
     * 
     * @return listEditDTO
     */
    public com.peniel.tara.ListEditDTO getListEditDTO() {
        return listEditDTO;
    }


    /**
     * Sets the listEditDTO value for this ListCommentParamsDTO.
     * 
     * @param listEditDTO
     */
    public void setListEditDTO(com.peniel.tara.ListEditDTO listEditDTO) {
        this.listEditDTO = listEditDTO;
    }


    /**
     * Gets the modificationCount value for this ListCommentParamsDTO.
     * 
     * @return modificationCount
     */
    public int getModificationCount() {
        return modificationCount;
    }


    /**
     * Sets the modificationCount value for this ListCommentParamsDTO.
     * 
     * @param modificationCount
     */
    public void setModificationCount(int modificationCount) {
        this.modificationCount = modificationCount;
    }


    /**
     * Gets the includeOriginalTextForComments value for this ListCommentParamsDTO.
     * 
     * @return includeOriginalTextForComments
     */
    public boolean isIncludeOriginalTextForComments() {
        return includeOriginalTextForComments;
    }


    /**
     * Sets the includeOriginalTextForComments value for this ListCommentParamsDTO.
     * 
     * @param includeOriginalTextForComments
     */
    public void setIncludeOriginalTextForComments(boolean includeOriginalTextForComments) {
        this.includeOriginalTextForComments = includeOriginalTextForComments;
    }


    /**
     * Gets the showOpenTrackChanges value for this ListCommentParamsDTO.
     * 
     * @return showOpenTrackChanges
     */
    public boolean isShowOpenTrackChanges() {
        return showOpenTrackChanges;
    }


    /**
     * Sets the showOpenTrackChanges value for this ListCommentParamsDTO.
     * 
     * @param showOpenTrackChanges
     */
    public void setShowOpenTrackChanges(boolean showOpenTrackChanges) {
        this.showOpenTrackChanges = showOpenTrackChanges;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListCommentParamsDTO)) return false;
        ListCommentParamsDTO other = (ListCommentParamsDTO) obj;
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
            this.headCommentsOnly == other.isHeadCommentsOnly() &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              java.util.Arrays.equals(this.status, other.getStatus()))) &&
            ((this.subjectIds==null && other.getSubjectIds()==null) || 
             (this.subjectIds!=null &&
              java.util.Arrays.equals(this.subjectIds, other.getSubjectIds()))) &&
            ((this.commentCategories==null && other.getCommentCategories()==null) || 
             (this.commentCategories!=null &&
              java.util.Arrays.equals(this.commentCategories, other.getCommentCategories()))) &&
            this.includeSubjectReplies == other.isIncludeSubjectReplies() &&
            ((this.updateDate==null && other.getUpdateDate()==null) || 
             (this.updateDate!=null &&
              this.updateDate.equals(other.getUpdateDate()))) &&
            this.showTrackChange == other.isShowTrackChange() &&
            ((this.commentTypes==null && other.getCommentTypes()==null) || 
             (this.commentTypes!=null &&
              java.util.Arrays.equals(this.commentTypes, other.getCommentTypes()))) &&
            this.excludeGeneralComments == other.isExcludeGeneralComments() &&
            this.generalCommentsOnly == other.isGeneralCommentsOnly() &&
            this.offlineCommentsOnly == other.isOfflineCommentsOnly() &&
            this.offlineStartCommentId == other.getOfflineStartCommentId() &&
            ((this.listEditDTO==null && other.getListEditDTO()==null) || 
             (this.listEditDTO!=null &&
              this.listEditDTO.equals(other.getListEditDTO()))) &&
            this.modificationCount == other.getModificationCount() &&
            this.includeOriginalTextForComments == other.isIncludeOriginalTextForComments() &&
            this.showOpenTrackChanges == other.isShowOpenTrackChanges();
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
        _hashCode += (isHeadCommentsOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getStatus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStatus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStatus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        if (getCommentCategories() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCommentCategories());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCommentCategories(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isIncludeSubjectReplies() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getUpdateDate() != null) {
            _hashCode += getUpdateDate().hashCode();
        }
        _hashCode += (isShowTrackChange() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCommentTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCommentTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCommentTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isExcludeGeneralComments() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isGeneralCommentsOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOfflineCommentsOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getOfflineStartCommentId();
        if (getListEditDTO() != null) {
            _hashCode += getListEditDTO().hashCode();
        }
        _hashCode += getModificationCount();
        _hashCode += (isIncludeOriginalTextForComments() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isShowOpenTrackChanges() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListCommentParamsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListCommentParamsDTO"));
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
        elemField.setFieldName("headCommentsOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "HeadCommentsOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
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
        elemField.setFieldName("commentCategories");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentCategories"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeSubjectReplies");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IncludeSubjectReplies"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UpdateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showTrackChange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ShowTrackChange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CommentTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excludeGeneralComments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ExcludeGeneralComments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("generalCommentsOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "GeneralCommentsOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offlineCommentsOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OfflineCommentsOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offlineStartCommentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OfflineStartCommentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listEditDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListEditDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ListEditDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modificationCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ModificationCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeOriginalTextForComments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IncludeOriginalTextForComments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showOpenTrackChanges");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ShowOpenTrackChanges"));
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
