import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peniel.beans.CheckUsername;
import com.peniel.bus.vo.Property;
import com.peniel.dao.PropertyDAO;


public class CheckDuplicateProperty extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckDuplicateProperty() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//check to see if the property Id is in the database already
		System.out.println("Checking if duplicate property ID ");
				if(request.getParameter("compid") != null)
				{
					String strStatus = "";
					String cId = request.getParameter("compid").toString();
					
					try
					{
						String propertyId = "";
						if(request.getParameter("propertyId") != null)
							propertyId = (String)request.getParameter("propertyId").toUpperCase();

						
						
						Vector propertyList = new Vector();
						PropertyDAO propertyDao = new PropertyDAO();
						Property property =  new Property();
						propertyList = propertyDao.findByPropertyId(cId,propertyId);
						System.out.println("Properties "+propertyList.size());
						property = (Property) propertyList.get(0);
						
						
						if(property != null)	
							strStatus = "exist";
						
						System.out.println(strStatus);
						
						
					}
					catch(Exception e)
					{
						//there is no such property like the one typed in by the user
						strStatus = "none";
						
					}
					finally
					{
						(response.getWriter()).write(strStatus);
					}
					
					
				}
				
				
			 

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
