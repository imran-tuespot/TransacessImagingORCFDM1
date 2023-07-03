/**
 * SubjectDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SubjectDTO  implements java.io.Serializable {
    private int objectId;

    private int workgroupId;

    private java.lang.String fullName;

    private java.lang.String mailAddress;

    private java.lang.String systemRole;

    private java.lang.String descriptionNote;

    private boolean licenseAgreed;

    private java.lang.String cultureName;

    private java.util.Calendar lastLoginDate;

    private java.lang.String userType;

    private com.peniel.tara.SubjectExtSourceDTO[] loginSources;

    private boolean active;

    public SubjectDTO() {
    }

    public SubjectDTO(
           int objectId,
           int workgroupId,
           java.lang.String fullName,
           java.lang.String mailAddress,
           java.lang.String systemRole,
           java.lang.String descriptionNote,
           boolean licenseAgreed,
           java.lang.String cultureName,
           java.util.Calendar lastLoginDate,
           java.lang.String userType,
           com.peniel.tara.SubjectExtSourceDTO[] loginSources,
           boolean active) {
           this.objectId = objectId;
           this.workgroupId = workgroupId;
           this.fullName = fullName;
           this.mailAddress = mailAddress;
           this.systemRole = systemRole;
           this.descriptionNote = descriptionNote;
           this.licenseAgreed = licenseAgreed;
           this.cultureName = cultureName;
           this.lastLoginDate = lastLoginDate;
           this.userType = userType;
           this.loginSources = loginSources;
           this.active = active;
    }


    /**
     * Gets the objectId value for this SubjectDTO.
     * 
     * @return objectId
     */
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this SubjectDTO.
     * 
     * @param objectId
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the workgroupId value for this SubjectDTO.
     * 
     * @return workgroupId
     */
    public int getWorkgroupId() {
        return workgroupId;
    }


    /**
     * Sets the workgroupId value for this SubjectDTO.
     * 
     * @param workgroupId
     */
    public void setWorkgroupId(int workgroupId) {
        this.workgroupId = workgroupId;
    }


    /**
     * Gets the fullName value for this SubjectDTO.
     * 
     * @return fullName
     */
    public java.lang.String getFullName() {
        return fullName;
    }


    /**
     * Sets the fullName value for this SubjectDTO.
     * 
     * @param fullName
     */
    public void setFullName(java.lang.String fullName) {
        this.fullName = fullName;
    }


    /**
     * Gets the mailAddress value for this SubjectDTO.
     * 
     * @return mailAddress
     */
    public java.lang.String getMailAddress() {
        return mailAddress;
    }


    /**
     * Sets the mailAddress value for this SubjectDTO.
     * 
     * @param mailAddress
     */
    public void setMailAddress(java.lang.String mailAddress) {
        this.mailAddress = mailAddress;
    }


    /**
     * Gets the systemRole value for this SubjectDTO.
     * 
     * @return systemRole
     */
    public java.lang.String getSystemRole() {
        return systemRole;
    }


    /**
     * Sets the systemRole value for this SubjectDTO.
     * 
     * @param systemRole
     */
    public void setSystemRole(java.lang.String systemRole) {
        this.systemRole = systemRole;
    }


    /**
     * Gets the descriptionNote value for this SubjectDTO.
     * 
     * @return descriptionNote
     */
    public java.lang.String getDescriptionNote() {
        return descriptionNote;
    }


    /**
     * Sets the descriptionNote value for this SubjectDTO.
     * 
     * @param descriptionNote
     */
    public void setDescriptionNote(java.lang.String descriptionNote) {
        this.descriptionNote = descriptionNote;
    }


    /**
     * Gets the licenseAgreed value for this SubjectDTO.
     * 
     * @return licenseAgreed
     */
    public boolean isLicenseAgreed() {
        return licenseAgreed;
    }


    /**
     * Sets the licenseAgreed value for this SubjectDTO.
     * 
     * @param licenseAgreed
     */
    public void setLicenseAgreed(boolean licenseAgreed) {
        this.licenseAgreed = licenseAgreed;
    }


    /**
     * Gets the cultureName value for this SubjectDTO.
     * 
     * @return cultureName
     */
    public java.lang.String getCultureName() {
        return cultureName;
    }


    /**
     * Sets the cultureName value for this SubjectDTO.
     * 
     * @param cultureName
     */
    public void setCultureName(java.lang.String cultureName) {
        this.cultureName = cultureName;
    }


    /**
     * Gets the lastLoginDate value for this SubjectDTO.
     * 
     * @return lastLoginDate
     */
    public java.util.Calendar getLastLoginDate() {
        return lastLoginDate;
    }


    /**
     * Sets the lastLoginDate value for this SubjectDTO.
     * 
     * @param lastLoginDate
     */
    public void setLastLoginDate(java.util.Calendar lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }


    /**
     * Gets the userType value for this SubjectDTO.
     * 
     * @return userType
     */
    public java.lang.String getUserType() {
        return userType;
    }


    /**
     * Sets the userType value for this SubjectDTO.
     * 
     * @param userType
     */
    public void setUserType(java.lang.String userType) {
        this.userType = userType;
    }


    /**
     * Gets the loginSources value for this SubjectDTO.
     * 
     * @return loginSources
     */
    public com.peniel.tara.SubjectExtSourceDTO[] getLoginSources() {
        return loginSources;
    }


    /**
     * Sets the loginSources value for this SubjectDTO.
     * 
     * @param loginSources
     */
    public void setLoginSources(com.peniel.tara.SubjectExtSourceDTO[] loginSources) {
        this.loginSources = loginSources;
    }


    /**
     * Gets the active value for this SubjectDTO.
     * 
     * @return active
     */
    public boolean isActive() {
        return active;
    }


    /**
     * Sets the active value for this SubjectDTO.
     * 
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubjectDTO)) return false;
        SubjectDTO other = (SubjectDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.objectId == other.getObjectId() &&
            this.workgroupId == other.getWorkgroupId() &&
            ((this.fullName==null && other.getFullName()==null) || 
             (this.fullName!=null &&
              this.fullName.equals(other.getFullName()))) &&
            ((this.mailAddress==null && other.getMailAddress()==null) || 
             (this.mailAddress!=null &&
              this.mailAddress.equals(other.getMailAddress()))) &&
            ((this.systemRole==null && other.getSystemRole()==null) || 
             (this.systemRole!=null &&
              this.systemRole.equals(other.getSystemRole()))) &&
            ((this.descriptionNote==null && other.getDescriptionNote()==null) || 
             (this.descriptionNote!=null &&
              this.descriptionNote.equals(other.getDescriptionNote()))) &&
            this.licenseAgreed == other.isLicenseAgreed() &&
            ((this.cultureName==null && other.getCultureName()==null) || 
             (this.cultureName!=null &&
              this.cultureName.equals(other.getCultureName()))) &&
            ((this.lastLoginDate==null && other.getLastLoginDate()==null) || 
             (this.lastLoginDate!=null &&
              this.lastLoginDate.equals(other.getLastLoginDate()))) &&
            ((this.userType==null && other.getUserType()==null) || 
             (this.userType!=null &&
              this.userType.equals(other.getUserType()))) &&
            ((this.loginSources==null && other.getLoginSources()==null) || 
             (this.loginSources!=null &&
              java.util.Arrays.equals(this.loginSources, other.getLoginSources()))) &&
            this.active == other.isActive();
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
        _hashCode += getWorkgroupId();
        if (getFullName() != null) {
            _hashCode += getFullName().hashCode();
        }
        if (getMailAddress() != null) {
            _hashCode += getMailAddress().hashCode();
        }
        if (getSystemRole() != null) {
            _hashCode += getSystemRole().hashCode();
        }
        if (getDescriptionNote() != null) {
            _hashCode += getDescriptionNote().hashCode();
        }
        _hashCode += (isLicenseAgreed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCultureName() != null) {
            _hashCode += getCultureName().hashCode();
        }
        if (getLastLoginDate() != null) {
            _hashCode += getLastLoginDate().hashCode();
        }
        if (getUserType() != null) {
            _hashCode += getUserType().hashCode();
        }
        if (getLoginSources() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLoginSources());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLoginSources(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubjectDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ObjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "FullName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "MailAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemRole");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SystemRole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descriptionNote");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "DescriptionNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseAgreed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LicenseAgreed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cultureName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CultureName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastLoginDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LastLoginDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UserType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginSources");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LoginSources"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectExtSourceDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectExtSourceDTO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("active");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "Active"));
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
