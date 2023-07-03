/**
 * 
 */
package com.peniel.batch;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.peniel.bus.vo.DocumentData;
import com.peniel.utilities.PDFToText;

/**
 * 
 */
public class BatchProcessingJob {

    // private static Logger logger = Logger.getLogger(DocumentData.class);

    private static MyPropWithinClasspath mpc = new MyPropWithinClasspath();

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String fileName = null;
        String newOutfilename = null;
        String outfilename = null;
        String mode = "add";
        String strResponse = "";
    	String success = "";
        String outTextFileName = buildDestinationFileName(mpc.getPropertyValue("companyName"), mpc.getPropertyValue("webFolder"), "temptext.txt");
        final PDFToText pdfToText = new PDFToText();
        List<DocumentData> documentDataList = findByOCRFlag(mpc.getPropertyValue("ocrFlag"));
        for (DocumentData data : documentDataList) {
            fileName = data.getDocumentId() + ".pdf";
            outfilename = buildDestinationFileName(mpc.getPropertyValue("companyName"), mpc.getPropertyValue("webFolder"), fileName);
            newOutfilename = buildDestinationFileNameOCR(mpc.getPropertyValue("companyName"), mpc.getPropertyValue("webFolder"), fileName);

            if (!pdfToText.isPDFSearchable(outfilename)) {
                // PDF is not Searchable
                pdfToText.pdfToSearchablePdf(outfilename, newOutfilename,String.valueOf(data.getDocumentId()),outTextFileName,mode);
            }
            else
            {
            	  pdfToText.parsePdf(String.valueOf(data.getDocumentId()), newOutfilename, outTextFileName, mode);
                  success = "yes";
                  
            }
          
            if (!success.equalsIgnoreCase("error")) {
				strResponse = strResponse + " +++Uploading "
						+ fileName;
				strResponse = strResponse + " +++Uploaded to "
						+ outfilename;
				  updateOCRFlag(mpc.getPropertyValue("ocrFlagUpdate"), data.getDocumentId());

				success = "yes";
			}

          
        }

    }

    public static List<DocumentData> findByOCRFlag(String ocrFlag) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        List<DocumentData> result = new ArrayList<DocumentData>();
        try {
            String sqlStatement = "select * from document_data where ocr_flag = '" + ocrFlag.toUpperCase() + "'";
            System.out.println("query : " + sqlStatement);
            conn = getDatabaseConnection();
            pstmt = conn.prepareStatement(sqlStatement);
            res = pstmt.executeQuery();

            while (res.next()) {
                DocumentData documentData = new DocumentData();
                documentData.setDocumentId(res.getLong("document_id"));
                documentData.setFilename(res.getString("filename"));
                documentData.setOcrFlag(res.getString("ocr_flag"));

                result.add(documentData);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
            throw sqle;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            res.close();
            pstmt.close();
            conn.close();
        }
        return result;
    }

    public static void updateOCRFlag(String ocrFlag, long docId) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            String sqlStatement = "UPDATE document_data SET ocr_flag = ? WHERE document_id = ?";
            System.out.println("query : " + sqlStatement);
            conn = getDatabaseConnection();
            pstmt = conn.prepareStatement(sqlStatement);
            pstmt.setString(1, ocrFlag.toUpperCase());
            pstmt.setLong(2, docId);
            pstmt.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println(sqle);
            throw sqle;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            pstmt.close();
            conn.close();
        }

    }

    public static Connection getDatabaseConnection() {
        Connection conn = null;

        if (conn == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(mpc.getPropertyValue("connection"), mpc.getPropertyValue("dbusername"), mpc.getPropertyValue("dbpassword"));

                // logger.info("New Database Connection Successful");
            } catch (Exception e) {
                System.out.println("Error in getting context : " + e.getMessage());

            }
        }
        return conn;
    }

    public static String buildDestinationFileName(String companyName, String webFolder, String infile) {
        String retval = mpc.getPropertyValue("repository") + File.separator + companyName + File.separator + webFolder + File.separator + infile;
        System.out.println("Destination with company name Directory " + retval);
        return retval;
    }

    public static String buildDestinationFileNameOCR(String companyName, String webFolder, String infile) {
        String retval = mpc.getPropertyValue("repositoryOCR") + File.separator + companyName + File.separator + webFolder + File.separator + infile;
        System.out.println("Destination with company name Directory " + retval);
        return retval;
    }

}
