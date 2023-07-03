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

import com.peniel.bus.vo.DocumentType;
import com.peniel.bus.vo.Property;
import com.peniel.dao.DocumentTypeDAO;
import com.peniel.dao.PropertyDAO;


public class GetDocTypeDropdown extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetDocTypeDropdown() {
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
		//System.out.println("Inside document type servlet");
		int comid = Integer.parseInt(request.getParameter("comid"));
		String doctypeId =request.getParameter("doctypeId");
		//int comid = 1;
	    //TODO: Get values for the index and populate JSON array	
		DocumentTypeDAO documentTypeDao = new DocumentTypeDAO();
		Vector documentTypes=null;
		if(doctypeId !=null || !"".equals(doctypeId)) {
			documentTypes = documentTypeDao.getAllDocumentTypes(comid,doctypeId);
		}else {
		 documentTypes = documentTypeDao.getAllDocumentTypes(comid);
		}
		System.out.println("Document Type size "+documentTypes.size());
		DocumentType documentType = new DocumentType();
		JSONObject json_response=new JSONObject();
        
	    //Send the data back to client
		JSONArray  prop = new JSONArray();
		JSONObject p;
		try
		{
		   
			 if(documentTypes.size() > 0)
			{
					//System.out.println("Time: "+Calendar.getInstance().getTime()+"properties "+ properties.size());
					for(int i=0; i < documentTypes.size(); i++ )
					{
						p = new JSONObject();
						documentType = (DocumentType) documentTypes.get(i);
						p.put("value",documentType.getDocumentTypeId());
						p.put("text",documentType.getDocumentType());
						prop.put(p);

					}
					//System.out.println("prop "+prop);
			        json_response.put("docTypeData", prop);

			}
			 
			    response.setContentType("application/Json");

		        response.getWriter().write(json_response.toString());

		       // System.out.println(json_response);
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
