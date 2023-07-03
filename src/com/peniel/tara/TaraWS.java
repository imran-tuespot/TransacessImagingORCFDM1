/**
 * TaraWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public interface TaraWS extends javax.xml.rpc.Service {
    public java.lang.String getTaraWSSoap12Address();

    public com.peniel.tara.TaraWSSoap_PortType getTaraWSSoap12() throws javax.xml.rpc.ServiceException;

    public com.peniel.tara.TaraWSSoap_PortType getTaraWSSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getTaraWSSoapAddress();

    public com.peniel.tara.TaraWSSoap_PortType getTaraWSSoap() throws javax.xml.rpc.ServiceException;

    public com.peniel.tara.TaraWSSoap_PortType getTaraWSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
