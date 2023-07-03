package com.peniel.utilities;


import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.File;
import java.net.ConnectException;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.ExternalOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeConnectionProtocol;
import org.artofsolving.jodconverter.office.OfficeException;
import org.artofsolving.jodconverter.office.OfficeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;


public class JODConverterService{
 private static final Logger LOGGER = LoggerFactory.getLogger(ConvertUtil.class);
 OfficeManager officeManager;

		 
	 public  String convertFile(String inputFileName, String outputFileName, boolean forceOverwrite, String host, Integer port) throws SecurityException, NoSuchFieldException, Exception {
	    
	        LOGGER.info("Converting File " + inputFileName + " -> " + outputFileName);
	        File inputFile = new File(inputFileName);
	        File outputFile = new File(outputFileName);
	       
	        if (!inputFile.exists()) {
	            LOGGER.error("Source file "+ inputFile + " does not exist");
	            return null;
	        }

	        if (outputFile.exists()) {
	            if (forceOverwrite) {
	                if (!outputFile.delete()) {
	                    LOGGER.error("Cannot delete destination file");
	                    return null;
	                }
	            } else {
	                LOGGER.error("Destination file "+ inputFile + " does not exist");
	                return null;
	            }
	        }
	                      
	        LOGGER.info("Converting Input file -----> "+inputFile.getPath());      
	       
	        return convertFile(inputFile, outputFile, host, port);
	    }
	    
	   

	    public  synchronized String convertFile(File inputFile, File outputFile, String host, Integer port) {
	    	
	    	System.out.println("Inside convertFile.........");
	        
	    	OpenOfficeConnection connection = null;	    	 
	    	OfficeDocumentConverter converter = null;
	       
	      /* try
	        {
	            // connect to an OpenOffice.org instance running on port 8300
	        	System.out.println("Connecting to host "+host + "port "+port);
	        
	            if (host == null) {
	                connection = new SocketOpenOfficeConnection(port);
	            } else {
	                connection = new SocketOpenOfficeConnection(host,port);
	            }
	            connection.connect();
	            
	        } catch (ConnectException officeNotRunning) {
	        	 LOGGER.error("ERROR: connection failed. Please make sure OpenOffice is running and listening on port "
	                            + port + ".");
	          
	        }*/
	        	
	       	        	
	        	try { 
	               OfficeManager officeManager = null;	             
	              
	                ExternalOfficeManagerConfiguration externalProcessOfficeManager = new 
	                ExternalOfficeManagerConfiguration(); 
	                externalProcessOfficeManager.setConnectOnStart(true); 
	                externalProcessOfficeManager.setPortNumber(8301); 
	                
	               
	                externalProcessOfficeManager.setConnectionProtocol(OfficeConnectionProtocol.SOCKET);
	                officeManager = externalProcessOfficeManager.buildOfficeManager(); 
	                
	                officeManager.start();
	        	
		            System.out.println("This is the input path:  " + inputFile.getPath());
		            System.out.println("This is the output path" + outputFile.getPath());
		            
		            long startTime = System.currentTimeMillis();  
		            
		            converter = new OfficeDocumentConverter(officeManager);           
		            long conversionTime = System.currentTimeMillis() - startTime;      
		            
		            converter.convert(inputFile, outputFile);
		            LOGGER.info("Done With conversion for "+inputFile.getPath()+" in "+ conversionTime);
		            officeManager.stop(); 


		    } catch (OfficeException oex) { 
		         System.out.println("error:" + oex); 
		         return null;
		    } 

	        catch (Exception e) 
	        {
	            LOGGER.error("Error in trying to convert File Using Server " + host + ":"  + port, e);
	            return null;
	            
	        } finally
	        {
	            if (connection != null) {
	                connection.disconnect();
	            }
	        }

	        return outputFile.getPath();
	    }
	    
	    public  String convertFile(String inputFileName, String outputFileName, String host, Integer port) {
	    	
	        LOGGER.debug("Converting File " + inputFileName + " -> " + outputFileName);
	        File inputFile = new File(inputFileName);
	        File outputFile = new File(outputFileName);

	        return convertFile(inputFile, outputFile, host, port);
	    }


   

}