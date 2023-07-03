/**
 * Converter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.penielsolutions.converter;

public interface Converter extends java.rmi.Remote {
    public java.lang.String convertFile(java.lang.String inputFileName, java.lang.String outputFileName, boolean forceOverwrite, int port) throws java.rmi.RemoteException;
}
