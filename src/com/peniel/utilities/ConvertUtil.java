package com.peniel.utilities;
 
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
//import com.sun.star.resource.OfficeResourceLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.ConnectException;


/**
 * User: todds
 * Date: 11/7/11
 * Time: 3:13 PM
 */
public class ConvertUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConvertUtil.class);

    /**
     * converts the input file to the output file via the converter url specified.
     * @param inputFileName complete path
     * @param outputFileName complete path
     * @param forceOverwrite if the output file exists do an overwrite. if exists and false then error out.
     * @param host what host is the converter on
     * @param port and the port number
     * @return null on failure. output file name is echoed on success.
     * @throws Exception 
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     *
     */
    public static String convertFile(String inputFileName, String outputFileName, boolean forceOverwrite, String host, Integer port) throws SecurityException, NoSuchFieldException, Exception {
    	
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
    
    static void setFinalStatic(Field field, Object newValue) throws Exception { 
        field.setAccessible(true); 
     
        // remove final modifier from field 
        Field modifiersField = Field.class.getDeclaredField("modifiers"); 
        modifiersField.setAccessible(true); 
        modifiersField.setInt(field, field.getModifiers()+ ~Modifier.FINAL); 
     
        field.set(null, newValue); 
    } 

    public static synchronized String convertFile(File inputFile, File outputFile, String host, Integer port) {
        
    	OpenOfficeConnection connection = null;
    	 
        DocumentConverter converter = null;
       
        try
        {
            // connect to an OpenOffice.org instance running on port 8300
        	System.out.println("Connecting to host "+host);
            if (host == null) {
                connection = new SocketOpenOfficeConnection(port);
            } else {
                connection = new SocketOpenOfficeConnection(host,port);
            }
            connection.connect();
            
        } catch (ConnectException officeNotRunning) {
        	 LOGGER.error("ERROR: connection failed. Please make sure OpenOffice is running and listening on port "
                            + port + ".");
          
        }
        	
        try{
        	
        	// convert
            converter = new OpenOfficeDocumentConverter(connection);
          
            System.out.println("This is the input path:  " + inputFile.getPath());
            System.out.println("This is the output path" + outputFile.getPath());
            
            long startTime = System.currentTimeMillis();  
            
            converter.convert(inputFile, outputFile);            
            long conversionTime = System.currentTimeMillis() - startTime;      
            
           
            LOGGER.info("Done With conversion for "+inputFile.getPath()+" in "+ conversionTime);

        } catch (Exception e) 
        {
            LOGGER.error("Error in trying to convert File Using Server " + host + ":"  + port, e);
            return null;
            
        } finally
        {
            if (connection != null) {
                // close the connection
                connection.disconnect();
            }
        }

        return outputFile.getPath();
    }
    public static String convertFile(String inputFileName, String outputFileName, String host, Integer port) {
        LOGGER.debug("Converting File " + inputFileName + " -> " + outputFileName);
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);

        return convertFile(inputFile, outputFile, host, port);
    }


}
