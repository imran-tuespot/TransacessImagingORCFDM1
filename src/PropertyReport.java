

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmesa.model.TableModel;
import org.jmesalive.table.BasicExportProperty;

import com.peniel.bus.vo.Property;
import com.peniel.dao.PropertyDAO;


public class PropertyReport extends HttpServlet {
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

	    RequestDispatcher dispatcher = request.getRequestDispatcher("basicExport.jsp?sessionid="+sessionId);
	    dispatcher.forward(request, response);
	   
	    
	}

	public String getTable(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("type");
	    int companyId = (Integer)request.getSession().getAttribute("comid");
		Collection<Property> properties = null;
		PropertyDAO propertyDao = new PropertyDAO();
		
		if (request.getSession().getAttribute("propertyCollection") != null) {
			properties = (List<Property>)request.getSession().getAttribute("propertyCollection");
    	}
    	
    	if (properties == null) {
    		properties = propertyDao.getProperties(companyId);
        }
		
    	request.getSession().setAttribute("propertyCollection", properties);
        request.getSession().setAttribute("lastId", properties.size());
        
        // respose is required for export
	    TableModel tableModel = new TableModel(id, request, response);
	    tableModel.setItems(properties);
	    
		BasicExportProperty.setTableProperties(tableModel);
		 
		String html = tableModel.render();
		
		return html;
	}
}