

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.io.Files;
import com.peniel.beans.SessionBean;
import com.peniel.tara.DocumentDTO;
import com.peniel.tara.FileContentDTO;
import com.peniel.tara.ListReviewDTO;
import com.peniel.tara.ListReviews;
import com.peniel.tara.ReviewDTO;
import com.peniel.tara.ReviewDocumentDTO;
import com.peniel.tara.TaraWSLocator;
import com.peniel.tara.TaraWSSoap_BindingStub;

/**
 * Servlet implementation class for Servlet: DisplayPlsReview
 *
 */
 public class DisplayPlsReview extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(DisplayPlsReview.class);
  
   private String accessKey = "cccbcf7e-93d8-49f7-8bec-514568088591"; //TARAWS
   
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public DisplayPlsReview() {
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
		  String mode = request.getParameter("mode");
		 // String contextLoginId = request.getParameter("contextLoginId");
		  
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
			  
			 // System.out.println("********** contextLoginId --->"+contextLoginId+"<--");
			  //response.sendRedirect("http://www.taptrac.com/HUDPleaseReview/Main/Default.aspx?logincontextid="+loginContextId);
			  
			  if("new".equals(mode)){
				  
				  try{  
					  
				   TaraWSLocator loc = new TaraWSLocator();
					
					loc.setEndpointAddress("TaraWSSoap", "http://www.taptrac.com/HUDPleaseReview/services/taraws.asmx");
					
					java.net.URL url= new java.net.URL(loc.getTaraWSSoapAddress());
					
					TaraWSSoap_BindingStub bStub = new TaraWSSoap_BindingStub(url,loc);
					
					//bStub.enableTrustedClient(accessKey, contextLoginId);					
				  
				  // create a review
				    ReviewDTO review = new ReviewDTO();
				    
				    review.setTitle("");
				    
				    Calendar cal = Calendar.getInstance();
				    review.setStartDate(cal);
				    
				    cal.add(Calendar.DAY_OF_MONTH, +7);
				    
				   // Calendar.getInstance()..add(Calendar.DAY_OF_MONTH, +7);
				    
				    review.setEndDate(cal);
				    
				    cal.add(Calendar.DAY_OF_MONTH, +17);
				    
				    review.setCloseDate(cal);
				    
				    review.setCompleteDate(cal);
				    
				    review.setUpdateDate(cal);
				    
				   // ndDate = DateTime.Now.AddDays(7);
				    
				  //  int reviewId = bStub.saveReview(contextLoginId, review);
					  
				   // System.out.println("reviewid -->"+reviewId+"<--");		    
				    				    
				    String filepath = request.getParameter("id");
				    String docId = request.getParameter("docId");
					//logger.info("File path "+filepath);
					
				    if(filepath != null && docId != null){
							String logofull = this.getServletContext().getRealPath("scaimages");
							logofull=logofull+java.io.File.separator.toString()+filepath;
							
						   // String logofull = "C:\\Users\\hchitalwala\\Documents\\testWord.docx";
						    
							File file = null;
							byte[] buffer = null;
							try{
								file = new File(logofull);
								buffer = Files.toByteArray(file);
								System.out.println(buffer.length);
								
							}catch(Exception e){
								System.out.println("Exception in reading file -->"+e.getMessage());
							}
							
						    
						    
						 // add the document to the review
						      DocumentDTO document = new DocumentDTO();
						      document.setContentType("application/pdf");
						      document.setTitle("Review Document");
						      document.setFileName(docId+".pdf");
				      document.setCreateDate(cal);
						      
		
						      ReviewDocumentDTO reviewDocument = new ReviewDocumentDTO();
		
						      //reviewDocument.setReviewDTO(review);
						      
						      FileContentDTO fileContent = new FileContentDTO();
						      fileContent.setData(buffer);
		
						    /*  bStub.saveDocument(
						        document,
						        reviewDocument,
						        new FileContentDTO[] { fileContent });*/
				    }
				      
				  response.sendRedirect("http://www.taptrac.com/HUDPleaseReview/Main/NewReview.aspx?logincontextid="+"mode=wizard");
			
				  }catch(Exception e){
					  System.out.println("Exception in DisplayPlsReview create review -->"+e.getMessage());
				  }
			  } else {
				  
				  response.sendRedirect("http://www.taptrac.com/HUDPleaseReview/Main/Inbox.aspx");
				  
			  }	  
		  }
		
	} 
	
	
}