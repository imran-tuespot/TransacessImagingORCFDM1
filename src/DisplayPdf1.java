import java.awt.FlowLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrServer;
import org.pdfclown.documents.Page;
import org.pdfclown.documents.contents.ITextString;
import org.pdfclown.documents.contents.TextChar;
import org.pdfclown.documents.interaction.annotations.TextMarkup;
import org.pdfclown.documents.interaction.annotations.TextMarkup.MarkupTypeEnum;
import org.pdfclown.files.File;
import org.pdfclown.files.SerializationModeEnum;
import org.pdfclown.tools.TextExtractor;
import org.pdfclown.util.math.Interval;
import org.pdfclown.util.math.geom.Quad;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.peniel.beans.SessionBean;

/**
 * Servlet implementation class for Servlet: DisplayPdf
 *
 */
public class DisplayPdf1 extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	private static Logger logger = LogManager.getLogger(DisplayPdf1.class);
	private ConcurrentUpdateSolrServer _server;
	private long _start = System.currentTimeMillis();
	// private PDFParser pdfparser ;

	private Collection _docs = new ArrayList();

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public DisplayPdf1() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userid = request.getParameter("userid");
		String filepath = request.getParameter("id");
		// int uid = Integer.parseInt(userid);
		String sessionid = request.getParameter("sessionid");
		String userName = request.getParameter("userName");
		String actualfilename=request.getParameter("actualfilename");
		String irems = request.getParameter("irems");
		boolean fileExists = false;
		File file = null;
		String keywordSearch = null;

		// String comid = request.getParameter("comid");
		// int cid = Integer.parseInt(comid);

		SessionBean s = new SessionBean();

		int id = s.checkSession(sessionid);
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
				System.out.println("File path in DisplayPDF--> " + filepath);

				// String logofull = this.getServletContext().getRealPath("scaimages");

				String logofull = getFromEnv("repositoryOCR1");
				logofull = logofull+"/"+userid+irems +"/"+ filepath;

				String extension = logofull.substring(logofull.lastIndexOf(".") + 1);
				logger.info("file full path " + logofull);
				logger.info("file full path " + extension);
				if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpge")) {

					// read image
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
				} else {
					keywordSearch = request.getParameter("keywordSearch");

					try {
						file = new File(logofull);
						fileExists = true;

					} catch (Exception e) {
						e.printStackTrace();
//						fileExists = false;
//						response.setHeader("Expires", "0");
//						response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
//						response.setHeader("Pragma", "public");
//						response.setContentType("text/html");
//						(response.getWriter()).write(
//								"<table align='center'><tr><td><font size=8 color=red>System error.</font></td></tr></table>");
//
//						logger.info("File does not exists");
						
						ByteArrayOutputStream baos = null;
						ServletOutputStream out = null;
						try {
							 logofull = getFromEnv("repositoryOCR1");
							logofull = logofull+"/"+userid+irems + filepath;
							baos = new ByteArrayOutputStream();
							// logger.info("Byte Array created");
							PdfReader reader = new PdfReader(logofull);
							System.out.println("reader.isEncrypted():::"+reader.isEncrypted());

							if (reader == null)
								logger.info("NO READER FOUND!!!");
							// filling in the form
							PdfStamper stamp1 = new PdfStamper(reader, baos);
							stamp1.close();
							response.setHeader("Expires", "0");
							response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
							response.setHeader("Pragma", "public");
							response.setContentType("application/pdf");
							response.setHeader("Content-Disposition",
									"inline; filename=".concat(String.valueOf(actualfilename)));
							response.setContentLength(baos.size());
							out = response.getOutputStream();
							baos.writeTo(out);
							out.flush();
						}catch (Exception eee) {
							e.printStackTrace();
						}finally {
							if(null!=baos) {
								baos.close();
								}
							if(null!=out) {
							out.close();
							}
						}

					}
				}

				if (fileExists) {
					logger.info("keywordSearch-->" + keywordSearch + "<--");

					if (keywordSearch != null && !"".equals(keywordSearch)) {
						final String keySearch = keywordSearch;
						Pattern pattern = Pattern.compile(keywordSearch, Pattern.CASE_INSENSITIVE);

						TextExtractor textExtractor = new TextExtractor(true, true);
						for (final Page page : file.getDocument().getPages()) {

							Map<Rectangle2D, List<ITextString>> textStrings = textExtractor.extract(page);

							final Matcher matcher = pattern.matcher(TextExtractor.toString(textStrings));

							textExtractor.filter(textStrings, new TextExtractor.IIntervalFilter() {
								public boolean hasNext() {
									if (matcher.find()) {
										return true;
									}

									return false;
								}
								public Interval<Integer> next() {
									return new Interval<Integer>(matcher.start(), matcher.end());
								}
								public void process(Interval<Integer> interval, ITextString match) {
									// Defining the highlight box of the text pattern match...
									List<Quad> highlightQuads = new ArrayList<Quad>();
									{
										Rectangle2D textBox = null;
										for (TextChar textChar : match.getTextChars()) {
											Rectangle2D textCharBox = textChar.getBox();
											if (textBox == null) {
												textBox = (Rectangle2D) textCharBox.clone();
											} else {
												if (textCharBox.getY() > textBox.getMaxY()) {
													highlightQuads.add(Quad.get(textBox));
													textBox = (Rectangle2D) textCharBox.clone();
												} else {
													textBox.add(textCharBox);
												}
											}
										}
										textBox.setRect(textBox.getX(), textBox.getY(), textBox.getWidth(),
												textBox.getHeight() + 5);
										highlightQuads.add(Quad.get(textBox));
									}
									// Highlight the text pattern match!
									TextMarkup temp = new TextMarkup(page, keySearch, MarkupTypeEnum.Highlight,
											highlightQuads);
									temp.setVisible(true);

								}
								public void remove() {
									throw new UnsupportedOperationException();
								}
							});
						}

						Random rNo = new Random();
						int iNo = rNo.nextInt(1000);

						String outputPath = this.getServletContext().getRealPath("scaimages")
								+ java.io.File.separator.toString() + "newFile" + iNo + ".pdf";
						System.out.println("outputPath-->" + outputPath);
						SerializationModeEnum serializationMode = SerializationModeEnum.Incremental;
						java.io.File newFile = new java.io.File(outputPath);
						FileInputStream fileInputStream = null;
						OutputStream responseOutputStream = null;
						try {
							file.save(newFile, serializationMode);
							file.close();

							response.setHeader("Expires", "0");
							response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
							response.setHeader("Pragma", "public");
							response.setContentType("application/pdf");
							response.setHeader("Content-Disposition",
									"inline; filename=".concat(String.valueOf(actualfilename)));
							fileInputStream = new FileInputStream(newFile);
							responseOutputStream = response.getOutputStream();
							int bytes;
							while ((bytes = fileInputStream.read()) != -1) {
								responseOutputStream.write(bytes);
							}
							responseOutputStream.flush();
						} catch (Exception e) {
							System.out.println("File writing failed: " + e.getMessage());
							e.printStackTrace();
						} finally {
							responseOutputStream.close();
							fileInputStream.close();
							newFile.delete();
						}
					}
					// else {
					ByteArrayOutputStream baos = null;
					ServletOutputStream out = null;
					try {
						baos = new ByteArrayOutputStream();
						// logger.info("Byte Array created");

						PdfReader reader = new PdfReader(logofull);

						if (reader == null)
							logger.info("NO READER FOUND!!!");
						// filling in the form
						PdfStamper stamp1 = new PdfStamper(reader, baos);
						stamp1.close();
						response.setHeader("Expires", "0");
						response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
						response.setHeader("Pragma", "public");
						response.setContentType("application/pdf");
						response.setHeader("Content-Disposition",
								"inline; filename=".concat(String.valueOf(actualfilename)));
						response.setContentLength(baos.size());
						out = response.getOutputStream();
						baos.writeTo(out);
						out.flush();
						
						/*
						 * System.out.println("logofull"+logofull);
						 * 
						 * FileInputStream fileInputStream = new FileInputStream(logofull);
						 * response.setHeader("Expires", "0"); response.setHeader("Cache-Control",
						 * "must-revalidate, post-check=0, pre-check=0"); response.setHeader("Pragma",
						 * "public"); response.setContentType("application/pdf");
						 * 
						 * 
						 * OutputStream ops = response.getOutputStream(); int bytes; while ((bytes =
						 * fileInputStream.read()) != -1) { ops.write(bytes); }
						 * 
						 * response.getOutputStream().flush();
						 */
					} catch (Exception exc) {
						exc.printStackTrace();
						System.out.println("Exception e -->" + exc.getMessage());
					} finally {
						if(null!=baos) {
							baos.close();
							}
						if(null!=out) {
						out.close();
						}
					}
					// }

				}

				// DocumentDataDAO docDataDAO = new DocumentDataDAO();

				// DocumentData docData = docDataDAO.findByCompIdFileName(Long.parseLong(comid),
				// filepath);

			} /*catch (IOException io) {
				

				ByteArrayOutputStream baos = null;
				ServletOutputStream out = null;
				try {
					String logofull = getFromEnv("repositoryOCR");
					logofull = logofull + filepath;
					baos = new ByteArrayOutputStream();
					// logger.info("Byte Array created");

					PdfReader reader = new PdfReader(logofull);

					if (reader == null)
						logger.info("NO READER FOUND!!!");
					// filling in the form
					PdfStamper stamp1 = new PdfStamper(reader, baos);
					stamp1.close();
					response.setHeader("Expires", "0");
					response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
					response.setHeader("Pragma", "public");
					response.setContentType("application/pdf");
					response.setContentLength(baos.size());
					out = response.getOutputStream();
					baos.writeTo(out);
					out.flush();
				}catch (Exception e) {
					// TODO: handle exception
				}
			
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Pragma", "public");
				response.setContentType("text/html");
				(response.getWriter()).write(
						"<table align='center'><tr><td><font size=8 color=red>The file is .</font></td></tr></table>");

				logger.info(userName + " : Error : " + io.getMessage());
			} catch (IllegalArgumentException ie) {
				
			
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Pragma", "public");
				response.setContentType("text/html");
				(response.getWriter()).write(
						"<table align='center'><tr><td><font size=8 color=red>The file is .</font></td></tr></table>");

				logger.info(userName + " : Error : " + ie.getMessage());
			}*/ catch (Exception e) {
				e.printStackTrace();
				ByteArrayOutputStream baos = null;
				ServletOutputStream out = null;
				PdfReader reader=null;
				try {
					String logofull = getFromEnv("repositoryOCR1");
					logofull = logofull + filepath;
					baos = new ByteArrayOutputStream();
					// logger.info("Byte Array created");

					 reader = new PdfReader(logofull);
					 
					if (reader == null)
						logger.info("NO READER FOUND!!!");
					// filling in the form
					PdfStamper stamp1 = new PdfStamper(reader, baos);
					stamp1.close();
					response.setHeader("Expires", "0");
					response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
					response.setHeader("Pragma", "public");
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							"inline; filename=".concat(String.valueOf(actualfilename)));
					response.setContentLength(baos.size());
					out = response.getOutputStream();
					baos.writeTo(out);
					out.flush();
				}catch (Exception eee) {
					eee.printStackTrace();
					logger.info(eee.getMessage());
				}finally {
					if(null!=baos) {
						baos.close();
						}
					if(null!=out) {
					out.close();
					}
					if(null!=reader) {
						reader.close();
					}
									}
				/*e.printStackTrace();*/
				logger.error(userName + " : Error : " + e.getMessage());
			}

		}
	}

	public String getFromEnv(String val) throws NamingException {
		javax.naming.Context ctx = new javax.naming.InitialContext();
		return (String) ctx.lookup("java:comp/env/" + val);
	}

}