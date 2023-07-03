import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peniel.beans.Mail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class SendmailWithCC_BCC extends HttpServlet {
	 private static Logger logger = LogManager.getLogger(GetFiles.class);
	
	public SendmailWithCC_BCC() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sessId = request.getParameter("sessionid").toString();
		String subject = request.getParameter("mailsubject").toString();
		String message = request.getParameter("mailbody").toString();
		
		String strRecipientsTo = request.getParameter("mailto").toString();
		strRecipientsTo = strRecipientsTo.replaceAll("\n", "");
		strRecipientsTo = strRecipientsTo.trim();
		String strRecipientsCc = request.getParameter("mailcc").toString();
		strRecipientsCc = strRecipientsCc.replaceAll("\n", "");
		strRecipientsCc = strRecipientsCc.trim();
		
		String strRecipientsBcc = request.getParameter("mailbcc").toString();
		strRecipientsBcc = strRecipientsBcc.replaceAll("\n", "");
		strRecipientsBcc = strRecipientsBcc.trim();
		
		String[] recipientsTo = new String[0];
		String[] recipientsCc = new String[0];
		String[] recipientsBcc = new String[0];
		
		if(strRecipientsTo != null && strRecipientsTo.length() > 1)
			recipientsTo = strRecipientsTo.split(";");
		if(strRecipientsCc != null && strRecipientsCc.length() > 1)
			recipientsCc = strRecipientsCc.split(";");
		if(strRecipientsBcc != null && strRecipientsBcc.length() > 1)
			recipientsBcc = strRecipientsBcc.split(";");
		String success ="";
		try
		{
			if(recipientsTo.length > 0)
			{				
				success = Mail.postMailWithCC_BCC(recipientsTo, recipientsCc, recipientsBcc, subject, message);				
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("sendMails.jsp?sessionid="+sessId+"&success=" + success);
             dispatcher.forward(request, response);			
			
		}  catch (Exception e) 
		{
			e.printStackTrace();
		} 	
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
