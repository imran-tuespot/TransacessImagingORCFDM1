
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.peniel.beans.SessionBean;
import com.peniel.beans.SessionLog;
import com.peniel.bus.vo.DocumentData;
import com.peniel.dao.DocumentDataDAO;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Servlet implementation class for Servlet: DisplayPdf
 *
 */
public class DisplayFile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	private static Logger logger = LogManager.getLogger(DisplayFile.class);

	public DisplayFile() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// filePath = fha232/webtest1/6544.pdf
		String filepath = request.getParameter("filePath");

		HttpHeaders headers = new HttpHeaders();
		
		String logofull = "";
		try {
			logofull = getFromEnv("repositoryOCR");// till c:\\em
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		logofull = logofull + java.io.File.separator.toString() + filepath.toLowerCase();

		String extension = logofull.substring(logofull.lastIndexOf(".") + 1);
		logger.info("file full path " + logofull);
		logger.info("file Extension " + extension);

		ServletOutputStream out = response.getOutputStream();
		if (extension.equalsIgnoreCase("pdf")) {
			try {
				Document document = new Document();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PdfReader reader = new PdfReader(logofull);
				if (reader == null)
					logger.info("NO READER FOUND!!!");
				PdfStamper stamp1 = new PdfStamper(reader, baos);
				stamp1.close();
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Pragma", "public");
				response.setContentType("application/pdf");
				response.setContentLength(baos.size());
				baos.writeTo(out);
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(" : Error : " + e.getMessage());
			}
		} else {
			if (extension.equalsIgnoreCase("doc") || extension.equalsIgnoreCase("docx")) {
				System.out.println("92---" + extension);
				FileInputStream fileIn = new FileInputStream(logofull);
				byte[] outputByte = new byte[4096];
				// copy binary contect to output stream
				while (fileIn.read(outputByte, 0, 4096) != -1) {
					out.write(outputByte, 0, 4096);
				}
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Pragma", "public");
				response.setContentType("application/msword");
				fileIn.close();
				out.flush();
				out.close();
			} else if (extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx")) {
				System.out.println("108---" + extension);
				FileInputStream fileIn = new FileInputStream(logofull);
				byte[] outputByte = new byte[4096];
				// copy binary contect to output stream
				while (fileIn.read(outputByte, 0, 4096) != -1) {
					out.write(outputByte, 0, 4096);
				}
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Pragma", "public");
				response.setContentType("application/vnd.ms-excel");
				fileIn.close();
				out.flush();
				out.close();
			} else if (extension.equalsIgnoreCase("txt")) {
				System.out.println("103---" + extension);
				FileInputStream fileIn = new FileInputStream(logofull);
				byte[] outputByte = new byte[4096];
				// copy binary contect to output stream
				while (fileIn.read(outputByte, 0, 4096) != -1) {
					out.write(outputByte, 0, 4096);
				}
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Pragma", "public");
				headers.setContentType(MediaType.parseMediaType("text/html"));
				fileIn.close();
				out.flush();
				out.close();
			} else if (extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("jpg")) {
				System.out.println("120---" + extension);
				FileInputStream fileIn = new FileInputStream(logofull);
				byte[] outputByte = new byte[4096];
				// copy binary contect to output stream
				while (fileIn.read(outputByte, 0, 4096) != -1) {
					out.write(outputByte, 0, 4096);
				}
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Pragma", "public");
				headers.setContentType(MediaType.parseMediaType("image/jpeg"));
				fileIn.close();
				out.flush();
				out.close();
			}
		}
	}

	public String getFromEnv(String val) throws NamingException {
		javax.naming.Context ctx = new javax.naming.InitialContext();
		return (String) ctx.lookup("java:comp/env/" + val);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}