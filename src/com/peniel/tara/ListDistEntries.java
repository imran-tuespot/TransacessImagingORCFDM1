/**
 * ListDistEntries.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class ListDistEntries  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private int distListId;

    private int workgroupId;

    private boolean showInactiveUsers;

    public ListDistEntries() {
    }

    public ListDistEntries(
           java.lang.String loginContextId,
           int distListId,
           int workgroupId,
           boolean showInactiveUsers) {
           this.loginContextId = loginContextId;
           this.distListId = distListId;
           this.workgroupId = workgroupId;
           this.showInactiveUsers = showInactiveUsers;
    }


    /**
     * Gets the loginContextId value for this ListDistEntries.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this ListDistEntries.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the distListId value for this ListDistEntries.
     * 
     * @return distListId
     */
    public int getDistListId() {
        return distListId;
    }


    /**
     * Sets the distListId value for this ListDistEntries.
     * 
     * @param distListId
     */
    public void setDistListId(int distListId) {
        this.distListId = distListId;
    }


    /**
     * Gets the workgroupId value for this ListDistEntries.
     * 
     * @return workgroupId
     */
    public int getWorkgroupId() {
        return workgroupId;
    }


    /**
     * Sets the workgroupId value for this ListDistEntries.
     * 
     * @param workgroupId
     */
    public void setWorkgroupId(int workgroupId) {
        this.workgroupId = workgroupId;
    }


    /**
     * Gets the showInactiveUsers value for this ListDistEntries.
     * 
     * @return showInactiveUsers
     */
    public boolean isShowInactiveUsers() {
        return showInactiveUsers;
    }


    /**
     * Sets the showInactiveUsers value for this ListDistEntries.
     * 
     * @param showInactiveUsers
     */
    public void setShowInactiveUsers(boolean showInactiveUsers) {
        this.showInactiveUsers = showInactiveUsers;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListDistEntries)) return false;
        ListDistEntries other = (ListDistEntries) obj;
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
            this.distListId == other.getDistListId() &&
            this.workgroupId == other.getWorkgroupId() &&
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
        _hashCode += getDistListId();
        _hashCode += getWorkgroupId();
        _hashCode += (isShowInactiveUsers() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListDistEntries.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">ListDistEntries"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distListId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "distListId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "workgroupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
