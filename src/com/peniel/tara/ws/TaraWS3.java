/**
 * TaraWS3.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara.ws;

public interface TaraWS3 extends javax.xml.rpc.Service {
    public java.lang.String getTaraWS3Soap12Address();

    public com.peniel.tara.ws.TaraWS3Soap_PortType getTaraWS3Soap12() throws javax.xml.rpc.ServiceException;

    public com.peniel.tara.ws.TaraWS3Soap_PortType getTaraWS3Soap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getTaraWS3SoapAddress();

    public com.peniel.tara.ws.TaraWS3Soap_PortType getTaraWS3Soap() throws javax.xml.rpc.ServiceException;

    public com.peniel.tara.ws.TaraWS3Soap_PortType getTaraWS3Soap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
