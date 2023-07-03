/**
 * MyMathServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.penielsolutions.converter;

public class MyMathServiceLocator extends org.apache.axis.client.Service implements MyMathService {

    public MyMathServiceLocator() {
    }


    public MyMathServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MyMathServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MyMath
    private java.lang.String MyMath_address = "http://localhost:8080/axis/vidya/MyMath.jws";

    public java.lang.String getMyMathAddress() {
        return MyMath_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MyMathWSDDServiceName = "MyMath";

    public java.lang.String getMyMathWSDDServiceName() {
        return MyMathWSDDServiceName;
    }

    public void setMyMathWSDDServiceName(java.lang.String name) {
        MyMathWSDDServiceName = name;
    }

    public MyMath getMyMath() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MyMath_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMyMath(endpoint);
    }

    public MyMath getMyMath(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            MyMathSoapBindingStub _stub = new MyMathSoapBindingStub(portAddress, this);
            _stub.setPortName(getMyMathWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMyMathEndpointAddress(java.lang.String address) {
        MyMath_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (MyMath.class.isAssignableFrom(serviceEndpointInterface)) {
                MyMathSoapBindingStub _stub = new MyMathSoapBindingStub(new java.net.URL(MyMath_address), this);
                _stub.setPortName(getMyMathWSDDServiceName());
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
        if ("MyMath".equals(inputPortName)) {
            return getMyMath();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/axis/vidya/MyMath.jws", "MyMathService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/axis/vidya/MyMath.jws", "MyMath"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MyMath".equals(portName)) {
            setMyMathEndpointAddress(address);
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
