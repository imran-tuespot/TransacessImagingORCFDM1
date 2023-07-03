
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


import com.peniel.beans.UsersGrid;
import com.peniel.bus.vo.AppUser;

import com.peniel.dao.AppUserDAO;


/**
 * Servlet implementation class for Servlet: GetFiles
 *
 */
 public class GetAdvancedSupervisorGrid extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   
	public GetAdvancedSupervisorGrid() {
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
		// TODO Auto-generated method stub

		try 
		{
    		Vector appUserList = new Vector();
			AppUserDAO appUserDao = new AppUserDAO();
    		
    		
    		
	        appUserList = appUserDao.findByCompanyId(request.getParameter("companyId"));
	        UsersGrid usersGrid = new UsersGrid();
	        
			String html = usersGrid.getUserGrid(appUserList, request, response);
			
			
			(response.getWriter()).write(html);
			
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		
	}  
	

	

}