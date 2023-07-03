import java.io.IOException;
import java.util.Calendar;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.peniel.bus.vo.Property;
import com.peniel.dao.PropertyDAO;


public class GetPropertyNameValues extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetPropertyNameValues() {
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

	//	int comid = (Integer)request.getSession().getAttribute("comid");
		
		int comid = Integer.parseInt(request.getParameter("comid"));

	    //TODO: Get values for the index and populate JSON array	
		PropertyDAO propertyDao = new PropertyDAO();
		Vector properties = propertyDao.findPropertiesNames(""+comid);
		Property property = new Property();
		JSONObject json_response=new JSONObject();
		
	    //Send the data back to client
		JSONArray  prop = new JSONArray();
		JSONObject p;
		try
		{
		 /*  
			 if(properties.size() > 0)
			{
					p = new JSONObject();
					//System.out.println("Time: "+Calendar.getInstance().getTime()+"properties "+ properties.size());
					for(int i=0; i < properties.size(); i++ )
					{
						property = (Property) properties.get(i);
						p.put(""+property.getId(),property.getPropertyName());
						
					}
					prop.put(p);

			}
			 */
			
			 if(properties.size() > 0)
				{
						for(int i=0; i < properties.size(); i++ )
						{
							p = new JSONObject();
							property = (Property) properties.get(i);
							p.put("value",property.getId());
							p.put("text",property.getPropertyName());
							prop.put(p);

						}
						//System.out.println("prop "+prop);
				        json_response.put("propertyData", prop);

				}
			
		  response.setContentType("application/json");
		  response.getWriter().write(json_response.toString());
		}
		catch (JSONException e)
		{ 

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
