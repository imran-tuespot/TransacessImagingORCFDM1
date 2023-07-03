import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.peniel.bus.vo.DocumentType;
import com.peniel.bus.vo.Folder;
import com.peniel.bus.vo.Property;
import com.peniel.dao.DocumentTypeDAO;
import com.peniel.dao.FolderDAO;
import com.peniel.dao.PropertyDAO;


public class GetFolderDropdown extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetFolderDropdown() {
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
		
		//  String folderPatteren=request.getSession().getAttribute("folderPatterens").toString();
		//  System.out.println("folderPatteren--->"+folderPatteren.replaceAll("\\[|\\]","").replaceAll(",\\s","|")); 
		
		 List<String> list=new ArrayList<String>();
		  
		  String folderPatteren=null;
		  
		  Map accessPatteren= (Map)request.getSession().getAttribute("accessPatteren");
		  System.out.println("accessPatteren--->"+accessPatteren);
		  
		  Iterator entries = accessPatteren.entrySet().iterator();
		  while (entries.hasNext()) {
		      Map.Entry entry = (Map.Entry) entries.next();
		     if(!entry.getValue().toString().equalsIgnoreCase("ReadOnly")){
		    	  list.add((String)entry.getKey());
		      
		  }
		  }
		  folderPatteren=list.toString();  
		  System.out.println("folderPatteren--->"+folderPatteren.replaceAll("\\[|\\]", "")); 

		int comid = Integer.parseInt(request.getParameter("comid"));
		FolderDAO folderDao = new FolderDAO();
	//	Vector folders = folderDao.findByProperty("COMPANY_ID", ""+comid);
		Vector folders = folderDao.findBy("COMPANY_ID", ""+comid,"Folder_Name",folderPatteren.replaceAll("\\[|\\]","").replaceAll(",\\s","|"));
		Folder folder = new Folder();
		JSONObject json_response=new JSONObject();
        
	    //Send the data back to client
		JSONArray  prop = new JSONArray();
		JSONObject p;
		try
		{
		   
			 if(folders.size() > 0)
			{
					for(int i=0; i < folders.size(); i++ )
					{
						p = new JSONObject();
						folder = (Folder) folders.get(i);
						p.put("value",folder.getFolderId());
						p.put("text",folder.getFolderName());
						prop.put(p);

					}
					//System.out.println("prop "+prop);
			        json_response.put("folderData", prop);

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
