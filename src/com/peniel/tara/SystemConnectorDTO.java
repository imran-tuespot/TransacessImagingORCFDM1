/**
 * SystemConnectorDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SystemConnectorDTO  implements java.io.Serializable {
    private java.lang.String connectorName;

    private java.lang.String connectorDisplayName;

    private com.peniel.tara.NameValueDTO[] loginSources;

    private boolean supportsRememberMe;

    private boolean supportsTrustedLogin;

    private boolean supportsImpersonation;

    private boolean supportsImpersonation2;

    private boolean isNativeConnector;

    private boolean canChangeUserPassword;

    private boolean canUpdateUserDetails;

    private boolean hasExternalContent;

    private boolean usesExternalGroups;

    private boolean usesExternalSessions;

    private boolean hasExitPoints;

    private com.peniel.tara.LoginArgumentDTO userArg1;

    private com.peniel.tara.LoginArgumentDTO userArg2;

    private boolean requiresUserArg1;

    private boolean requiresUserArg2;

    private boolean requiresNTImpersonation;

    private java.lang.String iconPath;

    public SystemConnectorDTO() {
    }

    public SystemConnectorDTO(
           java.lang.String connectorName,
           java.lang.String connectorDisplayName,
           com.peniel.tara.NameValueDTO[] loginSources,
           boolean supportsRememberMe,
           boolean supportsTrustedLogin,
           boolean supportsImpersonation,
           boolean supportsImpersonation2,
           boolean isNativeConnector,
           boolean canChangeUserPassword,
           boolean canUpdateUserDetails,
           boolean hasExternalContent,
           boolean usesExternalGroups,
           boolean usesExternalSessions,
           boolean hasExitPoints,
           com.peniel.tara.LoginArgumentDTO userArg1,
           com.peniel.tara.LoginArgumentDTO userArg2,
           boolean requiresUserArg1,
           boolean requiresUserArg2,
           boolean requiresNTImpersonation,
           java.lang.String iconPath) {
           this.connectorName = connectorName;
           this.connectorDisplayName = connectorDisplayName;
           this.loginSources = loginSources;
           this.supportsRememberMe = supportsRememberMe;
           this.supportsTrustedLogin = supportsTrustedLogin;
           this.supportsImpersonation = supportsImpersonation;
           this.supportsImpersonation2 = supportsImpersonation2;
           this.isNativeConnector = isNativeConnector;
           this.canChangeUserPassword = canChangeUserPassword;
           this.canUpdateUserDetails = canUpdateUserDetails;
           this.hasExternalContent = hasExternalContent;
           this.usesExternalGroups = usesExternalGroups;
           this.usesExternalSessions = usesExternalSessions;
           this.hasExitPoints = hasExitPoints;
           this.userArg1 = userArg1;
           this.userArg2 = userArg2;
           this.requiresUserArg1 = requiresUserArg1;
           this.requiresUserArg2 = requiresUserArg2;
           this.requiresNTImpersonation = requiresNTImpersonation;
           this.iconPath = iconPath;
    }


    /**
     * Gets the connectorName value for this SystemConnectorDTO.
     * 
     * @return connectorName
     */
    public java.lang.String getConnectorName() {
        return connectorName;
    }


    /**
     * Sets the connectorName value for this SystemConnectorDTO.
     * 
     * @param connectorName
     */
    public void setConnectorName(java.lang.String connectorName) {
        this.connectorName = connectorName;
    }


    /**
     * Gets the connectorDisplayName value for this SystemConnectorDTO.
     * 
     * @return connectorDisplayName
     */
    public java.lang.String getConnectorDisplayName() {
        return connectorDisplayName;
    }


    /**
     * Sets the connectorDisplayName value for this SystemConnectorDTO.
     * 
     * @param connectorDisplayName
     */
    public void setConnectorDisplayName(java.lang.String connectorDisplayName) {
        this.connectorDisplayName = connectorDisplayName;
    }


    /**
     * Gets the loginSources value for this SystemConnectorDTO.
     * 
     * @return loginSources
     */
    public com.peniel.tara.NameValueDTO[] getLoginSources() {
        return loginSources;
    }


    /**
     * Sets the loginSources value for this SystemConnectorDTO.
     * 
     * @param loginSources
     */
    public void setLoginSources(com.peniel.tara.NameValueDTO[] loginSources) {
        this.loginSources = loginSources;
    }


    /**
     * Gets the supportsRememberMe value for this SystemConnectorDTO.
     * 
     * @return supportsRememberMe
     */
    public boolean isSupportsRememberMe() {
        return supportsRememberMe;
    }


    /**
     * Sets the supportsRememberMe value for this SystemConnectorDTO.
     * 
     * @param supportsRememberMe
     */
    public void setSupportsRememberMe(boolean supportsRememberMe) {
        this.supportsRememberMe = supportsRememberMe;
    }


    /**
     * Gets the supportsTrustedLogin value for this SystemConnectorDTO.
     * 
     * @return supportsTrustedLogin
     */
    public boolean isSupportsTrustedLogin() {
        return supportsTrustedLogin;
    }


    /**
     * Sets the supportsTrustedLogin value for this SystemConnectorDTO.
     * 
     * @param supportsTrustedLogin
     */
    public void setSupportsTrustedLogin(boolean supportsTrustedLogin) {
        this.supportsTrustedLogin = supportsTrustedLogin;
    }


    /**
     * Gets the supportsImpersonation value for this SystemConnectorDTO.
     * 
     * @return supportsImpersonation
     */
    public boolean isSupportsImpersonation() {
        return supportsImpersonation;
    }


    /**
     * Sets the supportsImpersonation value for this SystemConnectorDTO.
     * 
     * @param supportsImpersonation
     */
    public void setSupportsImpersonation(boolean supportsImpersonation) {
        this.supportsImpersonation = supportsImpersonation;
    }


    /**
     * Gets the supportsImpersonation2 value for this SystemConnectorDTO.
     * 
     * @return supportsImpersonation2
     */
    public boolean isSupportsImpersonation2() {
        return supportsImpersonation2;
    }


    /**
     * Sets the supportsImpersonation2 value for this SystemConnectorDTO.
     * 
     * @param supportsImpersonation2
     */
    public void setSupportsImpersonation2(boolean supportsImpersonation2) {
        this.supportsImpersonation2 = supportsImpersonation2;
    }


    /**
     * Gets the isNativeConnector value for this SystemConnectorDTO.
     * 
     * @return isNativeConnector
     */
    public boolean isIsNativeConnector() {
        return isNativeConnector;
    }


    /**
     * Sets the isNativeConnector value for this SystemConnectorDTO.
     * 
     * @param isNativeConnector
     */
    public void setIsNativeConnector(boolean isNativeConnector) {
        this.isNativeConnector = isNativeConnector;
    }


    /**
     * Gets the canChangeUserPassword value for this SystemConnectorDTO.
     * 
     * @return canChangeUserPassword
     */
    public boolean isCanChangeUserPassword() {
        return canChangeUserPassword;
    }


    /**
     * Sets the canChangeUserPassword value for this SystemConnectorDTO.
     * 
     * @param canChangeUserPassword
     */
    public void setCanChangeUserPassword(boolean canChangeUserPassword) {
        this.canChangeUserPassword = canChangeUserPassword;
    }


    /**
     * Gets the canUpdateUserDetails value for this SystemConnectorDTO.
     * 
     * @return canUpdateUserDetails
     */
    public boolean isCanUpdateUserDetails() {
        return canUpdateUserDetails;
    }


    /**
     * Sets the canUpdateUserDetails value for this SystemConnectorDTO.
     * 
     * @param canUpdateUserDetails
     */
    public void setCanUpdateUserDetails(boolean canUpdateUserDetails) {
        this.canUpdateUserDetails = canUpdateUserDetails;
    }


    /**
     * Gets the hasExternalContent value for this SystemConnectorDTO.
     * 
     * @return hasExternalContent
     */
    public boolean isHasExternalContent() {
        return hasExternalContent;
    }


    /**
     * Sets the hasExternalContent value for this SystemConnectorDTO.
     * 
     * @param hasExternalContent
     */
    public void setHasExternalContent(boolean hasExternalContent) {
        this.hasExternalContent = hasExternalContent;
    }


    /**
     * Gets the usesExternalGroups value for this SystemConnectorDTO.
     * 
     * @return usesExternalGroups
     */
    public boolean isUsesExternalGroups() {
        return usesExternalGroups;
    }


    /**
     * Sets the usesExternalGroups value for this SystemConnectorDTO.
     * 
     * @param usesExternalGroups
     */
    public void setUsesExternalGroups(boolean usesExternalGroups) {
        this.usesExternalGroups = usesExternalGroups;
    }


    /**
     * Gets the usesExternalSessions value for this SystemConnectorDTO.
     * 
     * @return usesExternalSessions
     */
    public boolean isUsesExternalSessions() {
        return usesExternalSessions;
    }


    /**
     * Sets the usesExternalSessions value for this SystemConnectorDTO.
     * 
     * @param usesExternalSessions
     */
    public void setUsesExternalSessions(boolean usesExternalSessions) {
        this.usesExternalSessions = usesExternalSessions;
    }


    /**
     * Gets the hasExitPoints value for this SystemConnectorDTO.
     * 
     * @return hasExitPoints
     */
    public boolean isHasExitPoints() {
        return hasExitPoints;
    }


    /**
     * Sets the hasExitPoints value for this SystemConnectorDTO.
     * 
     * @param hasExitPoints
     */
    public void setHasExitPoints(boolean hasExitPoints) {
        this.hasExitPoints = hasExitPoints;
    }


    /**
     * Gets the userArg1 value for this SystemConnectorDTO.
     * 
     * @return userArg1
     */
    public com.peniel.tara.LoginArgumentDTO getUserArg1() {
        return userArg1;
    }


    /**
     * Sets the userArg1 value for this SystemConnectorDTO.
     * 
     * @param userArg1
     */
    public void setUserArg1(com.peniel.tara.LoginArgumentDTO userArg1) {
        this.userArg1 = userArg1;
    }


    /**
     * Gets the userArg2 value for this SystemConnectorDTO.
     * 
     * @return userArg2
     */
    public com.peniel.tara.LoginArgumentDTO getUserArg2() {
        return userArg2;
    }


    /**
     * Sets the userArg2 value for this SystemConnectorDTO.
     * 
     * @param userArg2
     */
    public void setUserArg2(com.peniel.tara.LoginArgumentDTO userArg2) {
        this.userArg2 = userArg2;
    }


    /**
     * Gets the requiresUserArg1 value for this SystemConnectorDTO.
     * 
     * @return requiresUserArg1
     */
    public boolean isRequiresUserArg1() {
        return requiresUserArg1;
    }


    /**
     * Sets the requiresUserArg1 value for this SystemConnectorDTO.
     * 
     * @param requiresUserArg1
     */
    public void setRequiresUserArg1(boolean requiresUserArg1) {
        this.requiresUserArg1 = requiresUserArg1;
    }


    /**
     * Gets the requiresUserArg2 value for this SystemConnectorDTO.
     * 
     * @return requiresUserArg2
     */
    public boolean isRequiresUserArg2() {
        return requiresUserArg2;
    }


    /**
     * Sets the requiresUserArg2 value for this SystemConnectorDTO.
     * 
     * @param requiresUserArg2
     */
    public void setRequiresUserArg2(boolean requiresUserArg2) {
        this.requiresUserArg2 = requiresUserArg2;
    }


    /**
     * Gets the requiresNTImpersonation value for this SystemConnectorDTO.
     * 
     * @return requiresNTImpersonation
     */
    public boolean isRequiresNTImpersonation() {
        return requiresNTImpersonation;
    }


    /**
     * Sets the requiresNTImpersonation value for this SystemConnectorDTO.
     * 
     * @param requiresNTImpersonation
     */
    public void setRequiresNTImpersonation(boolean requiresNTImpersonation) {
        this.requiresNTImpersonation = requiresNTImpersonation;
    }


    /**
     * Gets the iconPath value for this SystemConnectorDTO.
     * 
     * @return iconPath
     */
    public java.lang.String getIconPath() {
        return iconPath;
    }


    /**
     * Sets the iconPath value for this SystemConnectorDTO.
     * 
     * @param iconPath
     */
    public void setIconPath(java.lang.String iconPath) {
        this.iconPath = iconPath;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SystemConnectorDTO)) return false;
        SystemConnectorDTO other = (SystemConnectorDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.connectorName==null && other.getConnectorName()==null) || 
             (this.connectorName!=null &&
              this.connectorName.equals(other.getConnectorName()))) &&
            ((this.connectorDisplayName==null && other.getConnectorDisplayName()==null) || 
             (this.connectorDisplayName!=null &&
              this.connectorDisplayName.equals(other.getConnectorDisplayName()))) &&
            ((this.loginSources==null && other.getLoginSources()==null) || 
             (this.loginSources!=null &&
              java.util.Arrays.equals(this.loginSources, other.getLoginSources()))) &&
            this.supportsRememberMe == other.isSupportsRememberMe() &&
            this.supportsTrustedLogin == other.isSupportsTrustedLogin() &&
            this.supportsImpersonation == other.isSupportsImpersonation() &&
            this.supportsImpersonation2 == other.isSupportsImpersonation2() &&
            this.isNativeConnector == other.isIsNativeConnector() &&
            this.canChangeUserPassword == other.isCanChangeUserPassword() &&
            this.canUpdateUserDetails == other.isCanUpdateUserDetails() &&
            this.hasExternalContent == other.isHasExternalContent() &&
            this.usesExternalGroups == other.isUsesExternalGroups() &&
            this.usesExternalSessions == other.isUsesExternalSessions() &&
            this.hasExitPoints == other.isHasExitPoints() &&
            ((this.userArg1==null && other.getUserArg1()==null) || 
             (this.userArg1!=null &&
              this.userArg1.equals(other.getUserArg1()))) &&
            ((this.userArg2==null && other.getUserArg2()==null) || 
             (this.userArg2!=null &&
              this.userArg2.equals(other.getUserArg2()))) &&
            this.requiresUserArg1 == other.isRequiresUserArg1() &&
            this.requiresUserArg2 == other.isRequiresUserArg2() &&
            this.requiresNTImpersonation == other.isRequiresNTImpersonation() &&
            ((this.iconPath==null && other.getIconPath()==null) || 
             (this.iconPath!=null &&
              this.iconPath.equals(other.getIconPath())));
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
        if (getConnectorName() != null) {
            _hashCode += getConnectorName().hashCode();
        }
        if (getConnectorDisplayName() != null) {
            _hashCode += getConnectorDisplayName().hashCode();
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
        _hashCode += (isSupportsRememberMe() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSupportsTrustedLogin() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSupportsImpersonation() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSupportsImpersonation2() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsNativeConnector() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCanChangeUserPassword() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCanUpdateUserDetails() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHasExternalContent() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isUsesExternalGroups() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isUsesExternalSessions() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHasExitPoints() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getUserArg1() != null) {
            _hashCode += getUserArg1().hashCode();
        }
        if (getUserArg2() != null) {
            _hashCode += getUserArg2().hashCode();
        }
        _hashCode += (isRequiresUserArg1() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRequiresUserArg2() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRequiresNTImpersonation() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIconPath() != null) {
            _hashCode += getIconPath().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SystemConnectorDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SystemConnectorDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("connectorName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ConnectorName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("connectorDisplayName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ConnectorDisplayName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginSources");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LoginSources"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "NameValueDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "NameValueDTO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportsRememberMe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SupportsRememberMe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportsTrustedLogin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SupportsTrustedLogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportsImpersonation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SupportsImpersonation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportsImpersonation2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "SupportsImpersonation2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isNativeConnector");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IsNativeConnector"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canChangeUserPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CanChangeUserPassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canUpdateUserDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "CanUpdateUserDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasExternalContent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "HasExternalContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usesExternalGroups");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UsesExternalGroups"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usesExternalSessions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UsesExternalSessions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasExitPoints");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "HasExitPoints"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userArg1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UserArg1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LoginArgumentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userArg2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "UserArg2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "LoginArgumentDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requiresUserArg1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "RequiresUserArg1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requiresUserArg2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "RequiresUserArg2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requiresNTImpersonation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "RequiresNTImpersonation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iconPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "IconPath"));
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
