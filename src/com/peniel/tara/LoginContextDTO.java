/**
 * LoginContextDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class LoginContextDTO  implements java.io.Serializable {
    private com.peniel.tara.WorkgroupDTO workgroupDTO;

    private java.lang.String workgroupRole;

    private java.lang.String composeRole;

    private com.peniel.tara.SubjectDTO subjectDTO;

    private com.peniel.tara.SubjectExtSourceDTO subjectExtSource;

    private com.peniel.tara.LicenseDTO licenseDTO;

    private java.lang.String authenticatingSystemConnector;

    private java.lang.String contextId;

    private java.lang.String authenticationType;

    private java.lang.String cultureName;

    private com.peniel.tara.UserTypeRuntimePermissionDTO userTypePermission;

    private java.lang.Object offlineWebReviewDTOs;

    private java.lang.Object offlineWebReviewIds;

    private java.lang.Object offlineWebCacheTime;

    public LoginContextDTO() {
    }

    public LoginContextDTO(
           com.peniel.tara.WorkgroupDTO workgroupDTO,
           java.lang.String workgroupRole,
           java.lang.String composeRole,
           com.peniel.tara.SubjectDTO subjectDTO,
           com.peniel.tara.SubjectExtSourceDTO subjectExtSource,
           com.peniel.tara.LicenseDTO licenseDTO,
           java.lang.String authenticatingSystemConnector,
           java.lang.String contextId,
           java.lang.String authenticationType,
           java.lang.String cultureName,
           com.peniel.tara.UserTypeRuntimePermissionDTO userTypePermission,
           java.lang.Object offlineWebReviewDTOs,
           java.lang.Object offlineWebReviewIds,
           java.lang.Object offlineWebCacheTime) {
           this.workgroupDTO = workgroupDTO;
           this.workgroupRole = workgroupRole;
           this.composeRole = composeRole;
           this.subjectDTO = subjectDTO;
           this.subjectExtSource = subjectExtSource;
           this.licenseDTO = licenseDTO;
           this.authenticatingSystemConnector = authenticatingSystemConnector;
           this.contextId = contextId;
           this.authenticationType = authenticationType;
           this.cultureName = cultureName;
           this.userTypePermission = userTypePermission;
           this.offlineWebReviewDTOs = offlineWebReviewDTOs;
           this.offlineWebReviewIds = offlineWebReviewIds;
           this.offlineWebCacheTime = offlineWebCacheTime;
    }


    /**
     * Gets the workgroupDTO value for this LoginContextDTO.
     * 
     * @return workgroupDTO
     */
    public com.peniel.tara.WorkgroupDTO getWorkgroupDTO() {
        return workgroupDTO;
    }


    /**
     * Sets the workgroupDTO value for this LoginContextDTO.
     * 
     * @param workgroupDTO
     */
    public void setWorkgroupDTO(com.peniel.tara.WorkgroupDTO workgroupDTO) {
        this.workgroupDTO = workgroupDTO;
    }


    /**
     * Gets the workgroupRole value for this LoginContextDTO.
     * 
     * @return workgroupRole
     */
    public java.lang.String getWorkgroupRole() {
        return workgroupRole;
    }


    /**
     * Sets the workgroupRole value for this LoginContextDTO.
     * 
     * @param workgroupRole
     */
    public void setWorkgroupRole(java.lang.String workgroupRole) {
        this.workgroupRole = workgroupRole;
    }


    /**
     * Gets the composeRole value for this LoginContextDTO.
     * 
     * @return composeRole
     */
    public java.lang.String getComposeRole() {
        return composeRole;
    }


    /**
     * Sets the composeRole value for this LoginContextDTO.
     * 
     * @param composeRole
     */
    public void setComposeRole(java.lang.String composeRole) {
        this.composeRole = composeRole;
    }


    /**
     * Gets the subjectDTO value for this LoginContextDTO.
     * 
     * @return subjectDTO
     */
    public com.peniel.tara.SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }


    /**
     * Sets the subjectDTO value for this LoginContextDTO.
     * 
     * @param subjectDTO
     */
    public void setSubjectDTO(com.peniel.tara.SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }


    /**
     * Gets the subjectExtSource value for this LoginContextDTO.
     * 
     * @return subjectExtSource
     */
    public com.peniel.tara.SubjectExtSourceDTO getSubjectExtSource() {
        return subjectExtSource;
    }


    /**
     * Sets the subjectExtSource value for this LoginContextDTO.
     * 
     * @param subjectExtSource
     */
    public void setSubjectExtSource(com.peniel.tara.SubjectExtSourceDTO subjectExtSource) {
        this.subjectExtSource = subjectExtSource;
    }


    /**
     * Gets the licenseDTO value for this LoginContextDTO.
     * 
     * @return licenseDTO
     */
    public com.peniel.tara.LicenseDTO getLicenseDTO() {
        return licenseDTO;
    }


    /**
     * Sets the licenseDTO value for this LoginContextDTO.
     * 
     * @param licenseDTO
     */
    public void setLicenseDTO(com.peniel.tara.LicenseDTO licenseDTO) {
        this.licenseDTO = licenseDTO;
    }


    /**
     * Gets the authenticatingSystemConnector value for this LoginContextDTO.
     * 
     * @return authenticatingSystemConnector
     */
    public java.lang.String getAuthenticatingSystemConnector() {
        return authenticatingSystemConnector;
    }


    /**
     * Sets the authenticatingSystemConnector value for this LoginContextDTO.
     * 
     * @param authenticatingSystemConnector
     */
    public void setAuthenticatingSystemConnector(java.lang.String authenticatingSystemConnector) {
        this.authenticatingSystemConnector = authenticatingSystemConnector;
    }


    /**
     * Gets the contextId value for this LoginContextDTO.
     * 
     * @return contextId
     */
    public java.lang.String getContextId() {
        return contextId;
    }


    /**
     * Sets the contextId value for this LoginContextDTO.
     * 
     * @param contextId
     */
    public void setContextId(java.lang.String contextId) {
        this.contextId = contextId;
    }


    /**
     * Gets the authenticationType value for this LoginContextDTO.
     * 
     * @return authenticationType
     */
    public java.lang.String getAuthenticationType() {
        return authenticationType;
    }


    /**
     * Sets the authenticationType value for this LoginContextDTO.
     * 
     * @param authenticationType
     */
    public void setAuthenticationType(java.lang.String authenticationType) {
        this.authenticationType = authenticationType;
    }


    /**
     * Gets the cultureName value for this LoginContextDTO.
     * 
     * @return cultureName
     */
    public java.lang.String getCultureName() {
        return cultureName;
    }


    /**
     * Sets the cultureName value for this LoginContextDTO.
     * 
     * @param cultureName
     */
    public void setCultureName(java.lang.String cultureName) {
        this.cultureName = cultureName;
    }


    /**
     * Gets the userTypePermission value for this LoginContextDTO.
     * 
     * @return userTypePermission
     */
    public com.peniel.tara.UserTypeRuntimePermissionDTO getUserTypePermission() {
        return userTypePermission;
    }


    /**
     * Sets the userTypePermission value for this LoginContextDTO.
     * 
     * @param userTypePermission
     */
    public void setUserTypePermission(com.peniel.tara.UserTypeRuntimePermissionDTO userTypePermission) {
        this.userTypePermission = userTypePermission;
    }


    /**
     * Gets the offlineWebReviewDTOs value for this LoginContextDTO.
     * 
     * @return offlineWebReviewDTOs
     */
    public java.lang.Object getOfflineWebReviewDTOs() {
        return offlineWebReviewDTOs;
    }


    /**
     * Sets the offlineWebReviewDTOs value for this LoginContextDTO.
     * 
     * @param offlineWebReviewDTOs
     */
    public void setOfflineWebReviewDTOs(java.lang.Object offlineWebReviewDTOs) {
        this.offlineWebReviewDTOs = offlineWebReviewDTOs;
    }


    /**
     * Gets the offlineWebReviewIds value for this LoginContextDTO.
     * 
     * @return offlineWebReviewIds
     */
    public java.lang.Object getOfflineWebReviewIds() {
        return offlineWebReviewIds;
    }


    /**
     * Sets the offlineWebReviewIds value for this LoginContextDTO.
     * 
     * @param offlineWebReviewIds
     */
    public void setOfflineWebReviewIds(java.lang.Object offlineWebReviewIds) {
        this.offlineWebReviewIds = offlineWebReviewIds;
    }


    /**
     * Gets the offlineWebCacheTime value for this LoginContextDTO.
     * 
     * @return offlineWebCacheTime
     */
    public java.lang.Object getOfflineWebCacheTime() {
        return offlineWebCacheTime;
    }


    /**
     * Sets the offlineWebCacheTime value for this LoginContextDTO.
     * 
     * @param offlineWebCacheTime
     */
    public void setOfflineWebCacheTime(java.lang.Object offlineWebCacheTime) {
        this.offlineWebCacheTime = offlineWebCacheTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoginContextDTO)) return false;
        LoginContextDTO other = (LoginContextDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.workgroupDTO==null && other.getWorkgroupDTO()==null) || 
             (this.workgroupDTO!=null &&
              this.workgroupDTO.equals(other.getWorkgroupDTO()))) &&
            ((this.workgroupRole==null && other.getWorkgroupRole()==null) || 
             (this.workgroupRole!=null &&
              this.workgroupRole.equals(other.getWorkgroupRole()))) &&
            ((this.composeRole==null && other.getComposeRole()==null) || 
             (this.composeRole!=null &&
              this.composeRole.equals(other.getComposeRole()))) &&
            ((this.subjectDTO==null && other.getSubjectDTO()==null) || 
             (this.subjectDTO!=null &&
              this.subjectDTO.equals(other.getSubjectDTO()))) &&
            ((this.subjectExtSource==null && other.getSubjectExtSource()==null) || 
             (this.subjectExtSource!=null &&
              this.subjectExtSource.equals(other.getSubjectExtSource()))) &&
            ((this.licenseDTO==null && other.getLicenseDTO()==null) || 
             (this.licenseDTO!=null &&
              this.licenseDTO.equals(other.getLicenseDTO()))) &&
            ((this.authenticatingSystemConnector==null && other.getAuthenticatingSystemConnector()==null) || 
             (this.authenticatingSystemConnector!=null &&
              this.authenticatingSystemConnector.equals(other.getAuthenticatingSystemConnector()))) &&
            ((this.contextId==null && other.getContextId()==null) || 
             (this.contextId!=null &&
              this.contextId.equals(other.getContextId()))) &&
            ((this.authenticationType==null && other.getAuthenticationType()==null) || 
             (this.authenticationType!=null &&
              this.authenticationType.equals(other.getAuthenticationType()))) &&
            ((this.cultureName==null && other.getCultureName()==null) || 
             (this.cultureName!=null &&
              this.cultureName.equals(other.getCultureName()))) &&
            ((this.userTypePermission==null && other.getUserTypePermission()==null) || 
             (this.userTypePermission!=null &&
              this.userTypePermission.equals(other.getUserTypePermission()))) &&
            ((this.offlineWebReviewDTOs==null && other.getOfflineWebReviewDTOs()==null) || 
             (this.offlineWebReviewDTOs!=null &&
              this.offlineWebReviewDTOs.equals(other.getOfflineWebReviewDTOs()))) &&
            ((this.offlineWebReviewIds==null && other.getOfflineWebReviewIds()==null) || 
             (this.offlineWebReviewIds!=null &&
              this.offlineWebReviewIds.equals(other.getOfflineWebReviewIds()))) &&
            ((this.offlineWebCacheTime==null && other.getOfflineWebCacheTime()==null) || 
             (this.offlineWebCacheTime!=null &&
              this.offlineWebCacheTime.equals(other.getOfflineWebCacheTime())));
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
        if (getWorkgroupDTO() != null) {
            _hashCode += getWorkgroupDTO().hashCode();
        }
        if (getWorkgroupRole() != null) {
            _hashCode += getWorkgroupRole().hashCode();
        }
        if (getComposeRole() != null) {
            _hashCode += getComposeRole().hashCode();
        }
        if (getSubjectDTO() != null) {
            _hashCode += getSubjectDTO().hashCode();
        }
        if (getSubjectExtSource() != null) {
            _hashCode += getSubjectExtSource().hashCode();
        }
        if (getLicenseDTO() != null) {
            _hashCode += getLicenseDTO().hashCode();
        }
        if (getAuthenticatingSystemConnector() != null) {
            _hashCode += getAuthenticatingSystemConnector().hashCode();
        }
        if (getContextId() != null) {
            _hashCode += getContextId().hashCode();
        }
        if (getAuthenticationType() != null) {
            _hashCode += getAuthenticationType().hashCode();
        }
        if (getCultureName() != null) {
            _hashCode += getCultureName().hashCode();
        }
        if (getUserTypePermission() != null) {
            _hashCode += getUserTypePermission().hashCode();
        }
        if (getOfflineWebReviewDTOs() != null) {
            _hashCode += getOfflineWebReviewDTOs().hashCode();
        }
        if (getOfflineWebReviewIds() != null) {
            _hashCode += getOfflineWebReviewIds().hashCode();
        }
        if (getOfflineWebCacheTime() != null) {
            _hashCode += getOfflineWebCacheTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoginContextDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LoginContextDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupRole");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupRole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("composeRole");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ComposeRole"));
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
        elemField.setFieldName("subjectExtSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectExtSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SubjectExtSourceDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LicenseDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LicenseDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authenticatingSystemConnector");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "AuthenticatingSystemConnector"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authenticationType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "AuthenticationType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("userTypePermission");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UserTypePermission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UserTypeRuntimePermissionDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offlineWebReviewDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OfflineWebReviewDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offlineWebReviewIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OfflineWebReviewIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offlineWebCacheTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "OfflineWebCacheTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
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
