package com.peniel.utilities;

import java.io.File;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
/*import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.ExternalOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeConnectionProtocol;
import org.artofsolving.jodconverter.office.OfficeException;
import org.artofsolving.jodconverter.office.OfficeManager;*/


import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeConnectionProtocol;
//import org.artofsolving.jodconverter.office.OfficeException;
import org.artofsolving.jodconverter.office.OfficeManager;


public class Converter{
 OfficeManager officeManager;
 OfficeDocumentConverter converter = null;
	/*public Converter()
	{
		officeManager = new DefaultOfficeManagerConfiguration()
		.setOfficeHome("/usr/lib/libreOffice")
		.setConnectionProtocol(OfficeConnectionProtocol.SOCKET)
		.setPortNumber(8301)
		.setTaskExecutionTimeout(240000L) //4 mins
		.setTaskQueueTimeout(60000L)// 1 min
		.buildOfficeManager();
	}*/

 private static boolean isAlive( Process p ) { 
     try 
     { 
         p.exitValue(); 
         return false; 
     } catch (IllegalThreadStateException e) { 
         return true; 
     } 
 } 
	public  synchronized String convertFile(String inputFileName, String outputFileName, boolean forceOverwrite, Integer port,Integer timeoutInSeconds) throws SecurityException, NoSuchFieldException, Exception 
	{	   
		/*officeManager = new DefaultOfficeManagerConfiguration()
		.setOfficeHome("/usr/lib/libreoffice")
		.setConnectionProtocol(OfficeConnectionProtocol.SOCKET)
		.setPortNumber(8301)
		.setTaskExecutionTimeout(240000L) //4 mins
		.setTaskQueueTimeout(60000L)// 1 min
		.buildOfficeManager();*/
			System.out.println("Converting File " + inputFileName + " -> " + outputFileName);
			String envp[] = null;
			envp[0]="LIB=ABCD";		
			int rc = 0;
			Process p = Runtime.getRuntime().exec("/usr/lib/libreoffice/program/bin/soffice --headless --convert-to pdf "
			+inputFileName +" "+outputFileName, envp, new File("/backup"));
	        
	        
	        if ( timeoutInSeconds <= 0 ) 
	        { 
	            rc = p.waitFor(); 
	            if(rc == 0)
	            {
	            	
	            }
	        } 
	        else 
	        { 
	            long now = System.currentTimeMillis(); 
	            long timeoutInMillis = 1000L * timeoutInSeconds; 
	            long finish = now + timeoutInMillis; 
	            while ( isAlive( p ) && ( System.currentTimeMillis() < finish ) ) 
	            { 
	                Thread.sleep( 10 );
	                
	            } 
	            if ( isAlive( p ) ) 
	            { 
	                throw new InterruptedException( "Process timeout out after " + timeoutInSeconds + " seconds" ); 
	            } 
	            rc = p.exitValue(); 
	        } 
	         
	       

	        File inputFile = new File(inputFileName);
	        File outputFile = new File(outputFileName);
	        if (!inputFile.exists()) 
	        {
	            System.out.println("Source file "+ inputFile + " does not exist");
	            return "false";
	        }

	        if (outputFile.exists())
	        {
	            if (forceOverwrite) 
	            {
	                if (!outputFile.delete()) 
	                {
	                    System.out.println("Cannot delete destination file");
	                    return "false";
	                }
	            } else {
	                System.out.println("Destination file "+ inputFile + " does not exist");
	                return "false";
	            }
	        }                	
	       
	     	       	        	
	        	/*try 
	        	 * { 
	               	OfficeManager officeManager = null;	            
	              
	                ExternalOfficeManagerConfiguration externalProcessOfficeManager = new 
	                ExternalOfficeManagerConfiguration(); 
	                externalProcessOfficeManager.setConnectOnStart(true); 
	                externalProcessOfficeManager.setPortNumber(8301); 
	               
	                externalProcessOfficeManager.setConnectionProtocol(OfficeConnectionProtocol.SOCKET);
	                officeManager = externalProcessOfficeManager.buildOfficeManager(); 
	                
	                officeManager.start();
	        	
		            	            
		            long startTime = System.currentTimeMillis();  
		            
		            converter = new OfficeDocumentConverter(officeManager);           
		            long conversionTime = System.currentTimeMillis() - startTime;      
		            
		            converter.convert(inputFile, outputFile);
		           
		            officeManager.stop();        		


		    } catch (OfficeException oex) { 
		         System.out.println("error:" + oex); 
		         return "false";
		    } 

	        catch (Exception e) 
	        {
	            System.out.println("Error in trying to convert File Using Server " + port);
	            return "false";
	            
	        } 
			*/
	        try
	        {		        
	            officeManager.start();		            
	            long startTime = System.currentTimeMillis();  	
	            
	            converter = new OfficeDocumentConverter(officeManager);                
	            converter.convert(inputFile, outputFile);
	            
	            long conversionTime = System.currentTimeMillis() - startTime;    
	            System.out.println("Time required for conversion "+conversionTime);
	           
	            officeManager.stop(); 
	        } catch (Exception oex) 
	        { 
		         System.out.println("error:" + oex); 
		         return "false";
		    } 

	       
	        
	        return "true";                
	       
	    }       

}