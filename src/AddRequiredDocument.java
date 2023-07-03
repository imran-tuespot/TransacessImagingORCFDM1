import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.peniel.dao.ProjectDocumentDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;


public class AddRequiredDocument extends HttpServlet {

	
	private static Logger logger = LogManager.getLogger(AddDocument.class);
	public AddRequiredDocument() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("In add required document file ");
			
		String success = "";
		
		String cId = (String)request.getParameter("cId");
		String projectID = (String)request.getParameter("projectId");
		String entryDate = (String)request.getParameter("entryDate");
		String dueDate = (String)request.getParameter("dueDate");
		String emails = (String)request.getParameter("emails");
		String mode = (String)request.getParameter("mode");
		
		
		// Add the record to the db		
		ProjectDocumentDAO projectDocumentDAO = new ProjectDocumentDAO();
		//ProjectDocumentBean projectDocumentBean = new ProjectDocumentBean();
		try{	
			if("save".compareToIgnoreCase(mode) == 0)
			{ 
				System.out.println("In save mode");									
				projectDocumentDAO.InsertProjectDocumentData(cId, projectID, entryDate, dueDate, emails);
				  
				success = "yes";
			}else if("delete".compareToIgnoreCase(mode) == 0)
			{
				System.out.println("In delete mode");
				int rowCount = projectDocumentDAO.DeleteProjectDocumentData(cId, projectID);
				if(rowCount > 0)
					success = "yes";
				else
					success = "no";
			}
			else if("edit".compareToIgnoreCase(mode) == 0)
			{
				System.out.println("In edit mode");
				projectDocumentDAO.EditProjectDocumentData(cId, projectID, entryDate ,dueDate, emails);
				success = "yes";
				
			}
			//String htmlGrid = projectDocumentBean.getProjectDocumentHTML(Integer.parseInt(cId),beginDate,endDate);
		}
		catch(Exception e){
			success = "no";
		}
		logger.info("success after insert in project required docs -->"+success);
		(response.getWriter()).write(success);
		
	}

	public static ArrayList stringToArrayList(String list) 
	{
		String[] temp;		 
		/* delimiter */
		String delimiter = "-";
		/* given string will be split by the argument delimiter provided. */
		temp = list.split(delimiter);
		return new ArrayList(Arrays.asList(temp));
	}
	public void init() throws ServletException {
		
	}

}
