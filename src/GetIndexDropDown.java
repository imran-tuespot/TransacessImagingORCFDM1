

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.dao.DropDownDAO;

/**
 * Servlet implementation class for Servlet: GetDropDown
 *
 */
 public class GetIndexDropDown extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   private static Logger logger = LogManager.getLogger(GetIndexDropDown.class);
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GetIndexDropDown() {
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
		
		String compid = (String)request.getParameter("compid");
		String docTypeId = (String)request.getParameter("docTypeId");
		
		
		String index = getIndexDropDown(compid,docTypeId);
		
		
		
		(response.getWriter()).write(index);
		
		
		
	} 
	
	
	
    public String getIndexDropDown(String compid, String docTypeId) {
		
    	String select = "";
    	
    	if(docTypeId.equalsIgnoreCase("All")){
    		select = "select distinct index_type,index_type_id from index_type where company_id = '"+compid+"' order by index_type";
    	}
    	else{
    		select = "select * from doc_index_view where company_id = '"+compid+"' and document_type_id = '"+docTypeId+"'  order by index_type";
    	}
    	
		
		
		
		String outputstr = "";
		String param = "index_type";
		try {
			
			DropDownDAO dropDownDAO = new DropDownDAO();
		
			outputstr = dropDownDAO.findByQuery(param,select);
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
        }
		
		return outputstr;
	}	
	
}