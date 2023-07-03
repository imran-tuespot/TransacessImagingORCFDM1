
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.common.PenielException;
import com.peniel.dao.FolderDAO;
import com.peniel.dao.PropertyDAO;


/**
 * Servlet implementation class for Servlet: GetFiles
 *
 */
 public class AddProperty extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(MyProfile.class);
   
   private String userName = "";

      
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AddProperty() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int seq = 0 ;
		boolean verification = false;
		long comid = Long.parseLong(request.getParameter("comid").toString());
		String proertyId = (String)request.getParameter("propertyId");
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
		
		PropertyDAO propertyDao = new PropertyDAO();
        try {
			seq = (int)propertyDao.getNextId();
		} catch (PenielException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        if( seq != 0)
        {
        	verification = propertyDao.insertIntoProperty(seq,comid,proertyId,fhaNum,accountExec,workloadMgr,lenderNum,
        			lenderName,servicerNum,servicerName,propertyName,city,state,zip,congressionalArea,troubleCode,reacScore,
        			activeDeacAssignment);
        }
		
        if(verification){
        	
        	String folderName = "/"+proertyId+"/";
        	String companyId = comid+"";
        	
        	//Add folder
        	FolderDAO folderDao = new FolderDAO();
        	try {
				folderDao.insertFolder(companyId, folderName);
 				/**commented on 22-2-2019 sribala dont want to add asset management subfolders**/
//				 String[] tokens =folderName .split("/");
//					if(tokens.length <= 2){
//						addFolderStructure(companyId, folderName);
//					}
 				/**commented on 22-2-2019 sribala dont want to add asset management subfolders**/
			} catch (PenielException e) {
				verification = false;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
        }
		
		try{
			
			request.setAttribute("sessionid", request.getParameter("sessionid"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("addProperty.jsp?sessionid="+(String)request.getParameter("sessionid")+"&successMsg="+verification);
			dispatcher.forward(request, response);
		} catch(Exception e){
			System.out.println("Exception -->"+e.getMessage());
		
		}
	}

		private void addFolderStructure(String companyId, String folderName) {
		 Properties prop = null; 
		   InputStream is = null; 
		   
		try {
			 
			   try
			   {     
			       try { 
			           prop = new Properties(); 
			           is = this.getClass().getResourceAsStream("/appProperties.properties"); prop.load(is); 
			           } catch (FileNotFoundException e) { 
			               e.printStackTrace(); 
			               } catch (IOException e) {
			                   e.printStackTrace(); 
			                   }
			      prop.getProperty("assetManagement");
			       System.out.println(prop.getProperty("assetManagement"));

			   }
			   catch (Exception e)
			   {
			       System.out.println(e.getMessage());
			   }
			   
			   
			   String[] folders= prop.getProperty("assetManagement").split(",");
			   
			  for(String folder:folders){
			if(!folder.isEmpty()){
			new FolderDAO().insertFolder(companyId, folderName+folder);
			}
			  }
		} catch (PenielException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}     	
	
}
