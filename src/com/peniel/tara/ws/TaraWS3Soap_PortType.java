/**
 * TaraWS3Soap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara.ws;

public interface TaraWS3Soap_PortType extends java.rmi.Remote {
    public java.lang.String impersonate(java.lang.String accessKey, java.lang.String extSource, java.lang.String userName) throws java.rmi.RemoteException;
    public java.lang.String impersonate1(java.lang.String accessKey, java.lang.String extSource, java.lang.String userName, java.lang.String externalSessionTicket) throws java.rmi.RemoteException;
    public void enableTrustedClient(java.lang.String accessKey, java.lang.String loginContextId) throws java.rmi.RemoteException;
}
