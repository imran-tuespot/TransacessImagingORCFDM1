/**
 * SyncWorkgroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class SyncWorkgroup  implements java.io.Serializable {
    private java.lang.String loginContextId;

    private java.lang.String extSource;

    private java.lang.String extRef;

    private int workgroupid;

    private com.peniel.tara.WorkgroupMemberDTO[] members;

    private boolean neverSendInviteForSyscon;

    public SyncWorkgroup() {
    }

    public SyncWorkgroup(
           java.lang.String loginContextId,
           java.lang.String extSource,
           java.lang.String extRef,
           int workgroupid,
           com.peniel.tara.WorkgroupMemberDTO[] members,
           boolean neverSendInviteForSyscon) {
           this.loginContextId = loginContextId;
           this.extSource = extSource;
           this.extRef = extRef;
           this.workgroupid = workgroupid;
           this.members = members;
           this.neverSendInviteForSyscon = neverSendInviteForSyscon;
    }


    /**
     * Gets the loginContextId value for this SyncWorkgroup.
     * 
     * @return loginContextId
     */
    public java.lang.String getLoginContextId() {
        return loginContextId;
    }


    /**
     * Sets the loginContextId value for this SyncWorkgroup.
     * 
     * @param loginContextId
     */
    public void setLoginContextId(java.lang.String loginContextId) {
        this.loginContextId = loginContextId;
    }


    /**
     * Gets the extSource value for this SyncWorkgroup.
     * 
     * @return extSource
     */
    public java.lang.String getExtSource() {
        return extSource;
    }


    /**
     * Sets the extSource value for this SyncWorkgroup.
     * 
     * @param extSource
     */
    public void setExtSource(java.lang.String extSource) {
        this.extSource = extSource;
    }


    /**
     * Gets the extRef value for this SyncWorkgroup.
     * 
     * @return extRef
     */
    public java.lang.String getExtRef() {
        return extRef;
    }


    /**
     * Sets the extRef value for this SyncWorkgroup.
     * 
     * @param extRef
     */
    public void setExtRef(java.lang.String extRef) {
        this.extRef = extRef;
    }


    /**
     * Gets the workgroupid value for this SyncWorkgroup.
     * 
     * @return workgroupid
     */
    public int getWorkgroupid() {
        return workgroupid;
    }


    /**
     * Sets the workgroupid value for this SyncWorkgroup.
     * 
     * @param workgroupid
     */
    public void setWorkgroupid(int workgroupid) {
        this.workgroupid = workgroupid;
    }


    /**
     * Gets the members value for this SyncWorkgroup.
     * 
     * @return members
     */
    public com.peniel.tara.WorkgroupMemberDTO[] getMembers() {
        return members;
    }


    /**
     * Sets the members value for this SyncWorkgroup.
     * 
     * @param members
     */
    public void setMembers(com.peniel.tara.WorkgroupMemberDTO[] members) {
        this.members = members;
    }


    /**
     * Gets the neverSendInviteForSyscon value for this SyncWorkgroup.
     * 
     * @return neverSendInviteForSyscon
     */
    public boolean isNeverSendInviteForSyscon() {
        return neverSendInviteForSyscon;
    }


    /**
     * Sets the neverSendInviteForSyscon value for this SyncWorkgroup.
     * 
     * @param neverSendInviteForSyscon
     */
    public void setNeverSendInviteForSyscon(boolean neverSendInviteForSyscon) {
        this.neverSendInviteForSyscon = neverSendInviteForSyscon;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SyncWorkgroup)) return false;
        SyncWorkgroup other = (SyncWorkgroup) obj;
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
            ((this.extSource==null && other.getExtSource()==null) || 
             (this.extSource!=null &&
              this.extSource.equals(other.getExtSource()))) &&
            ((this.extRef==null && other.getExtRef()==null) || 
             (this.extRef!=null &&
              this.extRef.equals(other.getExtRef()))) &&
            this.workgroupid == other.getWorkgroupid() &&
            ((this.members==null && other.getMembers()==null) || 
             (this.members!=null &&
              java.util.Arrays.equals(this.members, other.getMembers()))) &&
            this.neverSendInviteForSyscon == other.isNeverSendInviteForSyscon();
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
        if (getExtSource() != null) {
            _hashCode += getExtSource().hashCode();
        }
        if (getExtRef() != null) {
            _hashCode += getExtRef().hashCode();
        }
        _hashCode += getWorkgroupid();
        if (getMembers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMembers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMembers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isNeverSendInviteForSyscon() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SyncWorkgroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", ">SyncWorkgroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginContextId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "loginContextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "extSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extRef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "extRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "workgroupid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("members");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "members"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupMemberDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "WorkgroupMemberDTO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("neverSendInviteForSyscon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "neverSendInviteForSyscon"));
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
