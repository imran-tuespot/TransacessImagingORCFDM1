/**
 * TaraWS3Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara.ws;

public class TaraWS3Locator extends org.apache.axis.client.Service implements com.peniel.tara.ws.TaraWS3 {

    public TaraWS3Locator() {
    }


    public TaraWS3Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TaraWS3Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TaraWS3Soap12
    private java.lang.String TaraWS3Soap12_address = "http://www.taptrac.com/HUDPleaseReview/services/taraws3.asmx";

    public java.lang.String getTaraWS3Soap12Address() {
        return TaraWS3Soap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TaraWS3Soap12WSDDServiceName = "TaraWS3Soap12";

    public java.lang.String getTaraWS3Soap12WSDDServiceName() {
        return TaraWS3Soap12WSDDServiceName;
    }

    public void setTaraWS3Soap12WSDDServiceName(java.lang.String name) {
        TaraWS3Soap12WSDDServiceName = name;
    }

    public com.peniel.tara.ws.TaraWS3Soap_PortType getTaraWS3Soap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TaraWS3Soap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTaraWS3Soap12(endpoint);
    }

    public com.peniel.tara.ws.TaraWS3Soap_PortType getTaraWS3Soap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	com.peniel.tara.ws.TaraWS3Soap12Stub _stub = new com.peniel.tara.ws.TaraWS3Soap12Stub(portAddress, this);
            _stub.setPortName(getTaraWS3Soap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTaraWS3Soap12EndpointAddress(java.lang.String address) {
        TaraWS3Soap12_address = address;
    }


    // Use to get a proxy class for TaraWS3Soap
    private java.lang.String TaraWS3Soap_address = "http://www.taptrac.com/HUDPleaseReview/services/taraws3.asmx";

    public java.lang.String getTaraWS3SoapAddress() {
        return TaraWS3Soap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TaraWS3SoapWSDDServiceName = "TaraWS3Soap";

    public java.lang.String getTaraWS3SoapWSDDServiceName() {
        return TaraWS3SoapWSDDServiceName;
    }

    public void setTaraWS3SoapWSDDServiceName(java.lang.String name) {
        TaraWS3SoapWSDDServiceName = name;
    }

    public com.peniel.tara.ws.TaraWS3Soap_PortType getTaraWS3Soap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TaraWS3Soap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTaraWS3Soap(endpoint);
    }

    public com.peniel.tara.ws.TaraWS3Soap_PortType getTaraWS3Soap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	com.peniel.tara.ws.TaraWS3Soap_BindingStub _stub = new com.peniel.tara.ws.TaraWS3Soap_BindingStub(portAddress, this);
            _stub.setPortName(getTaraWS3SoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTaraWS3SoapEndpointAddress(java.lang.String address) {
        TaraWS3Soap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.peniel.tara.ws.TaraWS3Soap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
            	com.peniel.tara.ws.TaraWS3Soap12Stub _stub = new com.peniel.tara.ws.TaraWS3Soap12Stub(new java.net.URL(TaraWS3Soap12_address), this);
                _stub.setPortName(getTaraWS3Soap12WSDDServiceName());
                return _stub;
            }
            if (com.peniel.tara.ws.TaraWS3Soap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
            	com.peniel.tara.ws.TaraWS3Soap_BindingStub _stub = new com.peniel.tara.ws.TaraWS3Soap_BindingStub(new java.net.URL(TaraWS3Soap_address), this);
                _stub.setPortName(getTaraWS3SoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TaraWS3Soap12".equals(inputPortName)) {
            return getTaraWS3Soap12();
        }
        else if ("TaraWS3Soap".equals(inputPortName)) {
            return getTaraWS3Soap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws3", "TaraWS3");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws3", "TaraWS3Soap12"));
            ports.add(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws3", "TaraWS3Soap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TaraWS3Soap12".equals(portName)) {
            setTaraWS3Soap12EndpointAddress(address);
        }
        else 
if ("TaraWS3Soap".equals(portName)) {
            setTaraWS3SoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
