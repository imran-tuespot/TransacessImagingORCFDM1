import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pdfclown.files.File;

import com.peniel.beans.SessionBean;

public class DisplayNonPdf extends HttpServlet {

	private static Logger logger = LogManager.getLogger(DisplayNonPdf.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-------------");
		System.out.println("-------------doPost in DisplayPdf");

		String fileName = request.getParameter("fileName");
		//String userid = request.getParameter("userid");
		String sessionid = request.getParameter("sessionid");
		String userName = request.getParameter("userName");
		//String userSession = request.getParameter("sessionid");
		//String folderName = (String) userSession.subSequence(0, userSession.indexOf("/"));
		//String docId = request.getParameter("docId");
		boolean fileExists = false;
		File file = null;
		String keywordSearch = null;

		//System.out.println(
			//	fileName + "------userId...." + userid + "sessionid...." + sessionid + "--userName---" + userName);

		//System.out.println("------------" + userSession);

		SessionBean s = new SessionBean();

		int id = s.checkSession(sessionid);
		System.out.println(id + "---checkSessionId");
		if (id <= -1) {
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setContentType("text/html");
			(response.getWriter()).write(
					"<table align='center'><tr><td><font size=8 color=red>Session Expired. Please Login again.</font></td></tr></table>");
			logger.info("Session expired");
		} else {
			try {
				System.out.println("File path in DisplayPDF---------> " + fileName);
				String filepath = fileName;

				String logofull = getFromEnv("repositoryOCR");
				logofull = logofull + java.io.File.separator.toString() + filepath.toLowerCase();

				String extension = logofull.substring(logofull.lastIndexOf(".") + 1);
				logger.info("file full path " + logofull);
				logger.info("file Extension " + extension);
				if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg")) {
					try {
						BufferedImage img = ImageIO.read(new java.io.File(logofull));
						ImageIcon icon = new ImageIcon(img);
						JFrame frame = new JFrame();
						frame.setLayout(new FlowLayout());
						frame.setSize(963, 640);
						JLabel lbl = new JLabel();
						lbl.setIcon(icon);
						frame.add(lbl);
						frame.setVisible(true);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						fileExists = false;
						System.out.println("Reading complete.");
					} catch (IOException e) {
						System.out.println("Error: " + e);
					}
				} else if (extension == "doc" || extension == "docx") {
					try {
						file = new File(logofull);
						fileExists = true;
						logger.info("fileExists..." + fileExists);
					} catch (Exception e) {
						e.printStackTrace();
						fileExists = false;
						response.setHeader("Expires", "0");
						response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
						response.setHeader("Pragma", "public");
						response.setContentType("text/html");
						(response.getWriter()).write(
								"<table align='center'><tr><td><font size=8 color=red>System error.</font></td></tr></table>");

						logger.info("File does not exists");
					}
				}
			} catch (IOException io) {
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Pragma", "public");
				response.setContentType("text/html");
				(response.getWriter()).write(
						"<table align='center'><tr><td><font size=8 color=red>The file is corrupted.</font></td></tr></table>");

				logger.info(userName + " : Error : " + io.getMessage());
			} catch (IllegalArgumentException ie) {
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Pragma", "public");
				response.setContentType("text/html");
				(response.getWriter()).write(
						"<table align='center'><tr><td><font size=8 color=red>The file is corrupted.</font></td></tr></table>");

				logger.info(userName + " : Error : " + ie.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(userName + " : Error : " + e.getMessage());
			}

		}
	}

	public String getFromEnv(String val) throws NamingException {
		javax.naming.Context ctx = new javax.naming.InitialContext();
		return (String) ctx.lookup("java:comp/env/" + val);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
