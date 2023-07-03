/**
 * ListWorkgroupMembers1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListWorkgroupMembers1  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int workgroupId;

    private int ownerId;

    private java.lang.String permissionType;

    private java.lang.String requiredRight;

    private boolean showInactiveUsers;

    public ListWorkgroupMembers1() {
    }

    public ListWorkgroupMembers1(
           java.lang.String loginContextId,
           int workgroupId,
           int ownerId,
           java.lang.String permissionType,
           java.lang.String requiredRight,
           boolean showInactiveUsers) {
           this.loginContextId = loginContextId;
           this.workgroupId = workgroupId;
           this.ownerId = ownerId;
           this.permissionType = permissionType;
           this.requiredRight = requiredRight;
           this.showInactiveUsers = showInactiveUsers;
    }


    /**
     * Gets the loginContextId value for this ListWorkgroupMembers1.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this ListWorkgroupMembers1.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the workgroupId value for this ListWorkgroupMembers1.
     * 
     * @return workgroupId
     */
    public int getWorkgroupId() {
        return workgroupId;
    }


    /**
     * Sets the workgroupId value for this ListWorkgroupMembers1.
     * 
     * @param workgroupId
     */
    public void setWorkgroupId(int workgroupId) {
        this.workgroupId = workgroupId;
    }


    /**
     * Gets the ownerId value for this ListWorkgroupMembers1.
     * 
     * @return ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }


    /**
     * Sets the ownerId value for this ListWorkgroupMembers1.
     * 
     * @param ownerId
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }


    /**
     * Gets the permissionType value for this ListWorkgroupMembers1.
     * 
     * @return permissionType
     */
    public java.lang.String getPermissionType() {
        return permissionType;
    }


    /**
     * Sets the permissionType value for this ListWorkgroupMembers1.
     * 
     * @param permissionType
     */
    public void setPermissionType(java.lang.String permissionType) {
        this.permissionType = permissionType;
    }


    /**
     * Gets the requiredRight value for this ListWorkgroupMembers1.
     * 
     * @return requiredRight
     */
    public java.lang.String getRequiredRight() {
        return requiredRight;
    }


    /**
     * Sets the requiredRight value for this ListWorkgroupMembers1.
     * 
     * @param requiredRight
     */
    public void setRequiredRight(java.lang.String requiredRight) {
        this.requiredRight = requiredRight;
    }


    /**
     * Gets the showInactiveUsers value for this ListWorkgroupMembers1.
     * 
     * @return showInactiveUsers
     */
    public boolean isShowInactiveUsers() {
        return showInactiveUsers;
    }


    /**
     * Sets the showInactiveUsers value for this ListWorkgroupMembers1.
     * 
     * @param showInactiveUsers
     */
    public void setShowInactiveUsers(boolean showInactiveUsers) {
        this.showInactiveUsers = showInactiveUsers;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListWorkgroupMembers1)) return false;
        ListWorkgroupMembers1 other = (ListWorkgroupMembers1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.loginContextId==null && other.getLoginContextId()==null) || 
             (this.loginContextId!=null &&
              this.loginContextId.equals(other.getLoginContextId()))) &&
            this.workgroupId == other.getWorkgroupId() &&
            this.ownerId == other.getOwnerId() &&
            ((this.permissionType==null && other.getPermissionType()==null) || 
             (this.permissionType!=null &&
              this.permissionType.equals(other.getPermissionType()))) &&
            ((this.requiredRight==null && other.getRequiredRight()==null) || 
             (this.requiredRight!=null &&
              this.requiredRight.equals(other.getRequiredRight()))) &&
            this.showInactiveUsers == other.isShowInactiveUsers();
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
        if (getLoginContextId() != null) {
            _hashCode += getLoginContextId().hashCode();
        }
        _hashCode += getWorkgroupId();
        _hashCode += getOwnerId();
        if (getPermissionType() != null) {
            _hashCode += getPermissionType().hashCode();
        }
        if (getRequiredRight() != null) {
            _hashCode += getRequiredRight().hashCode();
        }
        _hashCode += (isShowInactiveUsers() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListWorkgroupMembers1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListWorkgroupMembers1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "workgroupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "ownerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permissionType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "permissionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requiredRight");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "requiredRight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showInactiveUsers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "showInactiveUsers"));
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
