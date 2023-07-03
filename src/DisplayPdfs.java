

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.peniel.beans.SessionBean;
import com.peniel.beans.SessionLog;
import com.peniel.bus.vo.DocumentData;
import com.peniel.dao.DocumentDataDAO;

/**
 * Servlet implementation class for Servlet: DisplayPdf
 *
 */
 public class DisplayPdfs extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(DisplayPdfs.class);
   
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public DisplayPdfs() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  String sessionid = request.getParameter("sessionid");
		  logger.info("** in  display pdf ***");
		  SessionBean s = new SessionBean();
		 
		  int id = s.checkSession(sessionid);
		  if ( id <= -1) {
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setContentType("text/html");
			(response.getWriter()).write("<table align='center'><tr><td><font size=8 color=red>Session Expired. Please Login again.</font></td></tr></table>");
			logger.info("Session expired");
		  }  else {
		
		try {
		String filepath = request.getParameter("id");
		//logger.info("File path "+filepath);
		//String logofull = this.getServletContext().getRealPath("scaimages");
		//logofull=logofull+File.separator.toString()+filepath;
		
		
		String logofull = getFromEnv("repositoryOCR");
		 logofull=logofull+java.io.File.separator.toString()+filepath;
		
		logger.info("file full path "+logofull);
		
		//logger.info("file full path "+logofull);
		Document document =   new Document();
		//logger.info("Document created");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//logger.info("Byte Array created");
		
		
		PdfReader reader = new PdfReader(logofull);

			if (reader==null) logger.info("NO READER FOUND!!!");
			
	      // filling in the form
	        PdfStamper stamp1 = new PdfStamper(reader, baos);
	  
	        stamp1.close();
	      
	        response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			ServletOutputStream out = response.getOutputStream();
			baos.writeTo(out);
			out.flush();

			        
			} catch ( Exception e) {
				e.printStackTrace();
				logger.error(" : Error : "+e.getMessage());
			}
			/*************For Local Testing Only; Comment this part while checking to CVS*********
			try {
			
			String filepath = request.getParameter("id");	
			filepath = filepath.replace("/","\\");
				
			logger.info("File path "+filepath);
			String logofull = "C:\\Users\\vrane\\Workspaces\\Transaccess\\.metadata\\.me_tcat\\webapps\\transaccessImaging\\scaimages\\"+filepath;
			
			logger.info("file full path "+logofull);
			
			Document document =   new Document();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			PdfReader reader = new PdfReader(logofull);
			
			if (reader==null) logger.info("NO READER FOUND!!!");
			
	      // filling in the form
	        PdfStamper stamp1 = new PdfStamper(reader, baos);
	  
	        stamp1.close();
	      
	        response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			ServletOutputStream out = response.getOutputStream();
			baos.writeTo(out);
			out.flush();
			
			       
			} catch ( Exception e) {
				e.printStackTrace();
				logger.error(" : Error : "+e.getMessage());
			}*/
		
	  }
	} 
	
	public String getFromEnv(String val) throws NamingException {
        javax.naming.Context ctx = new javax.naming.InitialContext();
        return (String) ctx.lookup("java:comp/env/" + val);
    }
}