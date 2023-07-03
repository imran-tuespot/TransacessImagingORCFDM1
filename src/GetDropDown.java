import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.dao.DropDownDAO;

/**
 * Servlet implementation class for Servlet: GetDropDown
 *
 */
 public class GetDropDown extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   private static Logger logger = LogManager.getLogger(GetDropDown.class);
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GetDropDown() {
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
		System.out.println("Inside GetDropDowns");
		String compid = (String)request.getParameter("compid");
		String countProjects = (String)request.getParameter("countProjects");
		
		System.out.println(countProjects);
		
		String totalCounts = "";
		if(!"false".equals(countProjects)){
			 totalCounts = getTotalProjectCounts(compid);
		}
		String index = getIndexDropDown(compid);
		
		String doc = getDocDropDown(compid);
		
		//String folders = getFolderDropDown(compid);
		
		(response.getWriter()).write(index+"$"+doc+"$"+totalCounts);
		
		
		
	} 
	
	public String getTotalProjectCounts(String compid) {
		
		String select = "select NO_OF_PROJECTS, NO_OF_DOCUMENTS, NO_OF_PAGES from DOCUMENT_COUNT where company_id = '"+compid+"'";
		String outputstr = "";
		String param = "document_count";
		try {
			
			DropDownDAO dropDownDAO = new DropDownDAO();
		
			outputstr = dropDownDAO.findByQuery(param,select);
            outputstr = StringUtils.replace(outputstr, "\\\\", "'");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
        }
		
		return outputstr;
	}	
	
public String getIndexDropDown(String compid) {
		
		String select = "select distinct index_type,index_type_id from index_type where company_id = '"+compid+"' order by index_type";
		String outputstr = "";
		String param = "index_type";
		try {
			
			DropDownDAO dropDownDAO = new DropDownDAO();
		
			outputstr = dropDownDAO.findByQuery(param,select);
            outputstr = StringUtils.replace(outputstr, "\\\\", "'");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
        }
		
		return outputstr;
	}	
	

	/*public String getFolderDropDown(String compid) {
		
		String select = "select distinct folder_name,folder_id from folders where company_id = '"+compid+"' order by folder_name";
		String outputstr = "";
		String param = "folder_name";
		try {
			DropDownDAO dropDownDAO = new DropDownDAO();
			
			outputstr = dropDownDAO.findByQuery(param,select);
			System.out.println("outputstr "+outputstr);
	        outputstr = StringUtils.replace(outputstr, "\\\\", "'");
			System.out.println("outputstr "+outputstr);

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
	    }
		return outputstr;
	}*/

	public String getDocDropDown(String compid) {
		
		String select = "select distinct document_type,document_type_id from document_type where company_id = '"+compid+"' order by document_type";
		String outputstr = "";
		String param = "document_type";
		try {
			DropDownDAO dropDownDAO = new DropDownDAO();
			
			outputstr = dropDownDAO.findByQuery(param,select);
            outputstr = StringUtils.replace(outputstr, "\\\\", "'");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
        }
		return outputstr;
	}	
	
	
	public String getDocType(String docTypeId, String compid) {
		
		String select = "select document_type from document_type where company_id = '"+compid+"' and document_type_id = '"+docTypeId+"' ";
		String outputstr = "";
		
		try {
			DropDownDAO dropDownDAO = new DropDownDAO();
			
			outputstr = dropDownDAO.findByQuery("document_type1",select);
            outputstr = StringUtils.replace(outputstr, "\\\\", "'");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
        }
		return outputstr;
	}

	
	
}