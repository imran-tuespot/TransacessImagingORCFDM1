import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.peniel.beans.FolderBean;
import com.peniel.bus.vo.DocumentData;
import com.peniel.bus.vo.SearchData;
import com.peniel.common.PenielException;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.dao.FolderDAO;
import com.peniel.dao.IndexTypeDAO;
import com.peniel.dao.SearchDataDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddFolder extends HttpServlet {

	
	private static Logger logger = LogManager.getLogger(AddFolder.class);
	public AddFolder() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("In add folder file ");
			
		String success = "";
		
		String cId = (String)request.getParameter("cId");
		String folderName = (String)request.getParameter("folderName");
		String mode = (String)request.getParameter("mode");
		FolderDAO folderDAO = new FolderDAO();
		com.peniel.beans.FolderBean folderBean = new FolderBean();
		System.out.println(" mode "+mode);
		if(mode.equalsIgnoreCase("add"))
		{	
			if(!folderName.startsWith("/"))
			{
				folderName = "/"+folderName;		
			}
			if(!folderName.endsWith("/"))
			{
				folderName = folderName + "/";		
			}
			try
			{		
				System.out.println("Adding folder "+folderName);
				folderDAO.insertFolder(cId, folderName);
 				/**commented on 22-2-2019 sribala dont want to add asset management subfolders**/
//				 String[] tokens =folderName .split("/");
//					if(tokens.length <= 2){
//						addFolderStructure(cId, folderName);
//					}
 				/**commented on 22-2-2019 sribala dont want to add asset management subfolders**/
					List<String> html = folderBean.getFolderNameGridHTML(cId,"");
				request.getSession().setAttribute("folderData", html);
				success = "yes^add";				
			}
			catch(PenielException e){				
				System.out.println("Error message "+e.getExceptionMessage());
				success = "no^add";
			}
			
		}
		else if(mode.equalsIgnoreCase("edit"))
		{
			String oldFolderName = request.getParameter("path");
			try
			{										
				
				folderDAO.editFolder(cId,oldFolderName,folderName);	
				List<String> html = folderBean.getFolderNameGridHTML(cId,"");
				request.getSession().setAttribute("folderData", html);
				success = "yes^edit";
				
			}
			catch(PenielException e){
				
				System.out.println("Error message "+e.getExceptionMessage());
				success = "no^edit";
			}
			
		}
		else if(mode.equalsIgnoreCase("delete"))
		{
			/* Check if folder has associated documents */
		
			DocumentDataDAO documentDataDAO = new DocumentDataDAO();
			Vector<DocumentData> documentDataVector = documentDataDAO.findByFolderName(folderName, cId);
			System.out.println("documentDataVector "+documentDataVector.size());
			if(documentDataVector.size() > 0) //Folder has documents associated with it; can not be deleted
			{
				System.out.println("Folder has "+documentDataVector.size()+ " docs ");
				success = "no^delete";
			}
			else
			{
				try
				{										
					if(folderDAO.deleteFolder(cId,folderName))
					{
						List<String> html = folderBean.getFolderNameGridHTML(cId,"");
						request.getSession().setAttribute("folderData", html);
						success = "yes^delete";
					}
					else
						success = "no^delete";				
				}
				catch(PenielException e){
					
					System.out.println("Error message "+e.getExceptionMessage());
					success = "no^delete";
				}
			}	
			
		}
		logger.info("success after insert in folders table -->"+success);
		(response.getWriter()).write(success);
			
		}

	
	
	private void addFolderStructure(String cId, String folderName) {
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
			new FolderDAO().insertFolder(cId, folderName+folder);
			}
			  }
//		  System.out.println("befor proc call 184 ]]]]]]]>>>>"+folderName);
//		  if(folderName != null && !"".equals(folderName)) {
//			 new FolderDAO().callProcFolderStructure(folderName,cId);
//		  }  
		} catch (PenielException e) {
			e.printStackTrace();
		}
		
	}

	public void init() throws ServletException {
		
	}

}
