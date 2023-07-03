import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peniel.bus.vo.Property;
import com.peniel.common.PenielException;
import com.peniel.dao.PropertyDAO;


public class EditProperty extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EditProperty() {
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
		long id = Long.parseLong((String)request.getParameter("id"));
		String propertyId = (String)request.getParameter("propertyId");
		String fhaNum = (String)request.getParameter("fhaNum");
		String accountExec = (String)request.getParameter("accountExec");
		String workloadMgr = (String)request.getParameter("workloadMgr");
		String lenderNum = (String)request.getParameter("lenderNum");
		String lenderName = (String)request.getParameter("lenderName");
		String servicerNum = (String)request.getParameter("servicerNum");
		String servicerName = (String)request.getParameter("servicerName");
		String propertyName = (String)request.getParameter("propertyName");
		String city = (String)request.getParameter("city");
		String state = (String)request.getParameter("state");
		String zip = (String)request.getParameter("zip");
		String congressionalArea = (String)request.getParameter("congressionalArea");
		String troubleCode = (String)request.getParameter("troubleCode");
		String reacScore = (String)request.getParameter("reacScore");
		String activeDeacAssignment = (String)request.getParameter("activeDeacAssignment");
		String sessionid = request.getParameter("sessionid");
		String userid = request.getParameter("userid");
		String comId = request.getParameter("comId");
		
		Property property = new Property();
		property.setId(id);
		property.setPropertyId(propertyId);
		property.setPropertyName(propertyName);
		property.setAccountExec(accountExec);
		property.setWorkloadMgr(workloadMgr);
		property.setLenderNum(lenderNum);
		property.setLenderName(lenderName);
		property.setServicerNum(servicerNum);
		property.setServicerName(servicerName);
		property.setCity(city);
		property.setState(state);
		property.setZip(zip);
		property.setCongressionalArea(congressionalArea);
		property.setTroubleCode(troubleCode);
		property.setReacScore(reacScore);
		property.setActiveDeacAssignment(activeDeacAssignment);
		
		PropertyDAO propertyDao = new PropertyDAO();
		String sqlStatement = "";
		boolean verification = false;
		try {
			verification = propertyDao.updateProperty(property);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{			
			request.setAttribute("sessionid", request.getParameter("sessionid"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("PropertyList?sessionid="+(String)request.getParameter("sessionid")+"&successMsg="+verification+"&type=worksheet");
			dispatcher.forward(request, response);
		} catch(Exception e){
			System.out.println("Exception -->"+e.getMessage());
		
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
