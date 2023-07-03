
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.jmesa.facade.TableFacade;
import org.jmesa.facade.TableFacadeFactory;
import org.jmesa.limit.Limit;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.worksheet.Worksheet;
import org.jmesa.worksheet.WorksheetCallbackHandler;
import org.jmesa.worksheet.WorksheetColumn;
import org.jmesa.worksheet.WorksheetRow;
import org.jmesa.worksheet.WorksheetUtils;
import org.jmesa.worksheet.editor.CheckboxWorksheetEditor;

import com.peniel.beans.UsersGrid;
import com.peniel.bus.vo.AppUser;

import com.peniel.dao.AppUserDAO;


/**
 * Servlet implementation class for Servlet: GetFiles
 *
 */
 public class GetSupervisorGrid extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   private Connection con;
   public String str,usn,pwd;
  // private String id ;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GetSupervisorGrid() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String html = "";
		
		try 
		{
    		Vector appUserList = new Vector();
			AppUserDAO appUserDao = new AppUserDAO();
    		
    		System.out.println("lastname"+request.getParameter("lastName"));
    		
    		//see which list of users to get back.  See if the advanced functions have been used
			if(!StringUtils.isBlank(request.getParameter("firstName")) || !StringUtils.isBlank(request.getParameter("lastName")) || !StringUtils.isBlank(request.getParameter("orderby")) )
			{
				String sOrder = request.getParameter("orderby");
				if(sOrder == null )sOrder = "";
				appUserList = appUserDao.findByAdvancedSearch(request.getParameter("companyId"), request.getParameter("firstName"), request.getParameter("lastName"), sOrder);
			}
			else
			{
				 appUserList = appUserDao.findByCompanyId(request.getParameter("companyId"));
			}

	        UsersGrid usersGrid = new UsersGrid();
	        
	        html = usersGrid.getUserGrid(appUserList, request, response);

			(response.getWriter()).write(html);
			
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		
	}  


}