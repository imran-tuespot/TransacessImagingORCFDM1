import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.dao.DropDownDAO;



public class PendingUploads extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	   static final long serialVersionUID = 1L;
	   private static Logger logger = LogManager.getLogger(GetDropDown.class);
	   
	    /* (non-Java-doc)
		 * @see javax.servlet.http.HttpServlet#HttpServlet()
		 */
		public PendingUploads() {
			super();
		}   	
		
		/* (non-Java-doc)
		 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		}  	
		
		/* (non-Java-doc)
		 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			System.out.println("Inside GetDropdownOptions");
			String compid = (String)request.getParameter("compid");
			
			
			
			String folders = getFolderDropDown(compid);
			
			
			
			//(response.getWriter()).write(index+"$"+doc+"$"+properties+"$"+folders);
			
			
			
		} 
		
			public String getFolderDropDown(String compid) {
			
			String select = "select folder_id, folder_name from folders where company_id = '"+compid+"' order by folder_name";
			String outputstr = "";
			String param = "folder_id";
			try {
				DropDownDAO dropDownDAO = new DropDownDAO();
				
				outputstr = dropDownDAO.findByQuery(param,select);
				//System.out.println("outputstr "+outputstr);
		        outputstr = StringUtils.replace(outputstr, "\\\\", "'");
				//System.out.println("outputstr "+outputstr);

			}
			catch (Exception e) 
			{
				e.printStackTrace();
				logger.info("Error :"+e.getMessage());
		    }
			return outputstr;
		}
		
		
	}