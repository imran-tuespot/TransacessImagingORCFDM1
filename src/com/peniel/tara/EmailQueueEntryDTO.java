/**
 * EmailQueueEntryDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class EmailQueueEntryDTO  implements java.io.Serializable {
    private int objectId;

    private java.util.Calendar dueDate;

    private java.util.Calendar startDate;

    private java.util.Calendar endDate;

    private java.lang.String status;

    private java.lang.String serviceId;

    private int reviewId;

    private int documentId;

    private int senderId;

    private int participantId;

    private int recipientId;

    private int reminderDays;

    private java.lang.String emailType;

    private java.lang.String emailCategory;

    private java.lang.String outputText;

    private com.peniel.tara.SubjectDTO sender;

    private com.peniel.tara.SubjectDTO recipient;

    public EmailQueueEntryDTO() {
    }

    public EmailQueueEntryDTO(
           int objectId,
           java.util.Calendar dueDate,
           java.util.Calendar startDate,
           java.util.Calendar endDate,
           java.lang.String status,
           java.lang.String serviceId,
           int reviewId,
           int documentId,
           int senderId,
           int participantId,
           int recipientId,
           int reminderDays,
           java.lang.String emailType,
           java.lang.String emailCategory,
           java.lang.String outputText,
           com.peniel.tara.SubjectDTO sender,
           com.peniel.tara.SubjectDTO recipient) {
           this.objectId = objectId;
           this.dueDate = dueDate;
           this.startDate = startDate;
           this.endDate = endDate;
           this.status = status;
           this.serviceId = serviceId;
           this.reviewId = reviewId;
           this.documentId = documentId;
           this.senderId = senderId;
           this.participantId = participantId;
           this.recipientId = recipientId;
           this.reminderDays = reminderDays;
           this.emailType = emailType;
           this.emailCategory = emailCategory;
           this.outputText = outputText;
           this.sender = sender;
           this.recipient = recipient;
    }


    /**
     * Gets the objectId value for this EmailQueueEntryDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this EmailQueueEntryDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the dueDate value for this EmailQueueEntryDTO.
     * 
     * @return dueDate
     */
    public java.util.Calendar getDueDate() {
        return dueDate;
    }


    /**
     * Sets the dueDate value for this EmailQueueEntryDTO.
     * 
     * @param dueDate
     */
    public void setDueDate(java.util.Calendar dueDate) {
        this.dueDate = dueDate;
    }


    /**
     * Gets the startDate value for this EmailQueueEntryDTO.
     * 
     * @return startDate
     */
    public java.util.Calendar getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this EmailQueueEntryDTO.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Calendar startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the endDate value for this EmailQueueEntryDTO.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this EmailQueueEntryDTO.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the status value for this EmailQueueEntryDTO.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this EmailQueueEntryDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the serviceId value for this EmailQueueEntryDTO.
     * 
     * @return serviceId
     */
    public java.lang.String getServiceId() {
        return serviceId;
    }


    /**
     * Sets the serviceId value for this EmailQueueEntryDTO.
     * 
     * @param serviceId
     */
    public void setServiceId(java.lang.String serviceId) {
        this.serviceId = serviceId;
    }


    /**
     * Gets the reviewId value for this EmailQueueEntryDTO.
     * 
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }


    /**
     * Sets the reviewId value for this EmailQueueEntryDTO.
     * 
     * @param reviewId
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    /**
     * Gets the documentId value for this EmailQueueEntryDTO.
     * 
     * @return documentId
     */
    public int getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this EmailQueueEntryDTO.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the senderId value for this EmailQueueEntryDTO.
     * 
     * @return senderId
     */
    public int getSenderId() {
        return senderId;
    }


    /**
     * Sets the senderId value for this EmailQueueEntryDTO.
     * 
     * @param senderId
     */
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }


    /**
     * Gets the participantId value for this EmailQueueEntryDTO.
     * 
     * @return participantId
     */
    public int getParticipantId() {
        return participantId;
    }


    /**
     * Sets the participantId value for this EmailQueueEntryDTO.
     * 
     * @param participantId
     */
    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }


    /**
     * Gets the recipientId value for this EmailQueueEntryDTO.
     * 
     * @return recipientId
     */
    public int getRecipientId() {
        return recipientId;
    }


    /**
     * Sets the recipientId value for this EmailQueueEntryDTO.
     * 
     * @param recipientId
     */
    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }


    /**
     * Gets the reminderDays value for this EmailQueueEntryDTO.
     * 
     * @return reminderDays
     */
    public int getReminderDays() {
        return reminderDays;
    }


    /**
     * Sets the reminderDays value for this EmailQueueEntryDTO.
     * 
     * @param reminderDays
     */
    public void setReminderDays(int reminderDays) {
        this.reminderDays = reminderDays;
    }


    /**
     * Gets the emailType value for this EmailQueueEntryDTO.
     * 
     * @return emailType
     */
    public java.lang.String getEmailType() {
        return emailType;
    }


    /**
     * Sets the emailType value for this EmailQueueEntryDTO.
     * 
     * @param emailType
     */
    public void setEmailType(java.lang.String emailType) {
        this.emailType = emailType;
    }


    /**
     * Gets the emailCategory value for this EmailQueueEntryDTO.
     * 
     * @return emailCategory
     */
    public java.lang.String getEmailCategory() {
        return emailCategory;
    }


    /**
     * Sets the emailCategory value for this EmailQueueEntryDTO.
     * 
     * @param emailCategory
     */
    public void setEmailCategory(java.lang.String emailCategory) {
        this.emailCategory = emailCategory;
    }


    /**
     * Gets the outputText value for this EmailQueueEntryDTO.
     * 
     * @return outputText
     */
    public java.lang.String getOutputText() {
        return outputText;
    }


    /**
     * Sets the outputText value for this EmailQueueEntryDTO.
     * 
     * @param outputText
     */
    public void setOutputText(java.lang.String outputText) {
        this.outputText = outputText;
    }


    /**
     * Gets the sender value for this EmailQueueEntryDTO.
     * 
     * @return sender
     */
    public com.peniel.tara.SubjectDTO getSender() {
        return sender;
    }


    /**
     * Sets the sender value for this EmailQueueEntryDTO.
     * 
     * @param sender
     */
    public void setSender(com.peniel.tara.SubjectDTO sender) {
        this.sender = sender;
    }


    /**
     * Gets the recipient value for this EmailQueueEntryDTO.
     * 
     * @return recipient
     */
    public com.peniel.tara.SubjectDTO getRecipient() {
        return recipient;
    }


    /**
     * Sets the recipient value for this EmailQueueEntryDTO.
     * 
     * @param recipient
     */
    public void setRecipient(com.peniel.tara.SubjectDTO recipient) {
        this.recipient = recipient;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EmailQueueEntryDTO)) return false;
        EmailQueueEntryDTO other = (EmailQueueEntryDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            ((this.dueDate==null && other.getDueDate()==null) || 
             (this.dueDate!=null &&
              this.dueDate.equals(other.getDueDate()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.serviceId==null && other.getServiceId()==null) || 
             (this.serviceId!=null &&
              this.serviceId.equals(other.getServiceId()))) &&
            this.reviewId == other.getReviewId() &&
            this.documentId == other.getDocumentId() &&
            this.senderId == other.getSenderId() &&
            this.participantId == other.getParticipantId() &&
            this.recipientId == other.getRecipientId() &&
            this.reminderDays == other.getReminderDays() &&
            ((this.emailType==null && other.getEmailType()==null) || 
             (this.emailType!=null &&
              this.emailType.equals(other.getEmailType()))) &&
            ((this.emailCategory==null && other.getEmailCategory()==null) || 
             (this.emailCategory!=null &&
              this.emailCategory.equals(other.getEmailCategory()))) &&
            ((this.outputText==null && other.getOutputText()==null) || 
             (this.outputText!=null &&
              this.outputText.equals(other.getOutputText()))) &&
            ((this.sender==null && other.getSender()==null) || 
             (this.sender!=null &&
              this.sender.equals(other.getSender()))) &&
            ((this.recipient==null && other.getRecipient()==null) || 
             (this.recipient!=null &&
              this.recipient.equals(other.getRecipient())));
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
        if (getDueDate() != null) {
            _hashCode += getDueDate().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getServiceId() != null) {
            _hashCode += getServiceId().hashCode();
        }
        _hashCode += getReviewId();
        _hashCode += getDocumentId();
        _hashCode += getSenderId();
        _hashCode += getParticipantId();
        _hashCode += getRecipientId();
        _hashCode += getReminderDays();
        if (getEmailType() != null) {
            _hashCode += getEmailType().hashCode();
        }
        if (getEmailCategory() != null) {
            _hashCode += getEmailCategory().hashCode();
        }
        if (getOutputText() != null) {
            _hashCode += getOutputText().hashCode();
        }
        if (getSender() != null) {
            _hashCode += getSender().hashCode();
        }
        if (getRecipient() != null) {
            _hashCode += getRecipient().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EmailQueueEntryDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EmailQueueEntryDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DueDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "StartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("serviceId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ServiceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("senderId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SenderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("participantId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ParticipantId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipientId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "RecipientId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reminderDays");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ReminderDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EmailType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailCategory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "EmailCategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OutputText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Sender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipient");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Recipient"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
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
