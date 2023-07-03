

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmesa.model.TableModel;
import org.jmesalive.table.BasicExportPropertyDocs;

import com.peniel.bus.vo.Property;
import com.peniel.dao.PropertyDAO;


public class PropertyDocumentReport extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String html = getTable(request, response); // set the Html in the request for the JSP
	    //System.out.println("html-->"+html);
	    
	    // export will return null
	    if (html == null) {
	        return;
	    } 
	    	
    	request.setAttribute("properties", html);
    	
    	String sessionId= (String)request.getSession().getAttribute("sessionid");

	    RequestDispatcher dispatcher = request.getRequestDispatcher("propertyDocExport.jsp?sessionid="+sessionId);
	    dispatcher.forward(request, response);
	   
	    
	}

	public String getTable(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("type");
		String propertyId = request.getParameter("propertyId");
		
		System.out.println("<-- propertyId-->"+propertyId+"<-- from request -->"+(String)request.getAttribute("propertyId"));
		
		if(propertyId != "null"){
			request.setAttribute("propertyId", propertyId);
		} else {
			propertyId = (String)request.getAttribute("propertyId");
		}
		
		
		System.out.println("id-->"+id+"<-- propertyId-->"+propertyId+"<--from request -->"+(String)request.getAttribute("propertyId"));
		
	    int companyId = (Integer)request.getSession().getAttribute("comid");
	    
		Collection<Property> properties = null;
		PropertyDAO propertyDao = new PropertyDAO();
		/*
		if (request.getSession().getAttribute("propertyDocCollection") != null) {
			properties = (List<Property>)request.getSession().getAttribute("propertyDocCollection");
    	}
    	*/
    	if (properties == null) {
    		properties = propertyDao.getPropertyDocuments(companyId, propertyId);
        }
    	
    	
		
    	request.getSession().setAttribute("propertyDocCollection", properties);
        request.getSession().setAttribute("lastId", properties.size());
        
        // respose is required for export
	    TableModel tableModel = new TableModel(id, request, response);
	    tableModel.setItems(properties);
	    
		BasicExportPropertyDocs.setTableProperties(tableModel, propertyId);
		 
		String html = tableModel.render();
		
		return html;
	}
}