/**
 * TaraWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class TaraWSLocator extends org.apache.axis.client.Service implements com.peniel.tara.TaraWS {

    public TaraWSLocator() {
    }


    public TaraWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TaraWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TaraWSSoap12
    private java.lang.String TaraWSSoap12_address = "http://www.taptrac.com/HUDPleaseReview/services/taraws.asmx";

    public java.lang.String getTaraWSSoap12Address() {
        return TaraWSSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TaraWSSoap12WSDDServiceName = "TaraWSSoap12";

    public java.lang.String getTaraWSSoap12WSDDServiceName() {
        return TaraWSSoap12WSDDServiceName;
    }

    public void setTaraWSSoap12WSDDServiceName(java.lang.String name) {
        TaraWSSoap12WSDDServiceName = name;
    }

    public com.peniel.tara.TaraWSSoap_PortType getTaraWSSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TaraWSSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTaraWSSoap12(endpoint);
    }

    public com.peniel.tara.TaraWSSoap_PortType getTaraWSSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.peniel.tara.TaraWSSoap12Stub _stub = new com.peniel.tara.TaraWSSoap12Stub(portAddress, this);
            _stub.setPortName(getTaraWSSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTaraWSSoap12EndpointAddress(java.lang.String address) {
        TaraWSSoap12_address = address;
    }


    // Use to get a proxy class for TaraWSSoap
    private java.lang.String TaraWSSoap_address = "http://www.taptrac.com/HUDPleaseReview/services/taraws.asmx";

    public java.lang.String getTaraWSSoapAddress() {
        return TaraWSSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TaraWSSoapWSDDServiceName = "TaraWSSoap";

    public java.lang.String getTaraWSSoapWSDDServiceName() {
        return TaraWSSoapWSDDServiceName;
    }

    public void setTaraWSSoapWSDDServiceName(java.lang.String name) {
        TaraWSSoapWSDDServiceName = name;
    }

    public com.peniel.tara.TaraWSSoap_PortType getTaraWSSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TaraWSSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTaraWSSoap(endpoint);
    }

    public com.peniel.tara.TaraWSSoap_PortType getTaraWSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.peniel.tara.TaraWSSoap_BindingStub _stub = new com.peniel.tara.TaraWSSoap_BindingStub(portAddress, this);
            _stub.setPortName(getTaraWSSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTaraWSSoapEndpointAddress(java.lang.String address) {
        TaraWSSoap_address = address;
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
            if (com.peniel.tara.TaraWSSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.peniel.tara.TaraWSSoap12Stub _stub = new com.peniel.tara.TaraWSSoap12Stub(new java.net.URL(TaraWSSoap12_address), this);
                _stub.setPortName(getTaraWSSoap12WSDDServiceName());
                return _stub;
            }
            if (com.peniel.tara.TaraWSSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.peniel.tara.TaraWSSoap_BindingStub _stub = new com.peniel.tara.TaraWSSoap_BindingStub(new java.net.URL(TaraWSSoap_address), this);
                _stub.setPortName(getTaraWSSoapWSDDServiceName());
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
        if ("TaraWSSoap12".equals(inputPortName)) {
            return getTaraWSSoap12();
        }
        else if ("TaraWSSoap".equals(inputPortName)) {
            return getTaraWSSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TaraWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TaraWSSoap12"));
            ports.add(new javax.xml.namespace.QName("http://pleasetech.com/tara/taraws", "TaraWSSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TaraWSSoap12".equals(portName)) {
            setTaraWSSoap12EndpointAddress(address);
        }
        else 
if ("TaraWSSoap".equals(portName)) {
            setTaraWSSoapEndpointAddress(address);
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
