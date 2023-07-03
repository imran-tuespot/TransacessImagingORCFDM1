import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jmesa.facade.TableFacade;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;

import com.peniel.beans.CompanyInformation;
import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.SearchDataObj;
import com.peniel.dao.SearchDataDAO;


public class DocMgmtAdvSearch extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    private static Logger logger = LogManager.getLogger(DocMgmtAdvSearch.class);

    private String userName = "";
	
	public DocMgmtAdvSearch() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = (String) request.getParameter("userid");
        String compid = (String) request.getParameter("compid");
        String sessionid = (String) request.getParameter("sessionid");
        String orderby = (String) request.getParameter("orderby");
        //String andOR = (String) request.getParameter("andOR");
        //String andOr = "and";
        System.out.println("Inside servlet DocMgmtAdvSearch");
       
        SessionBean s = new SessionBean();
        int sid = s.checkSession(sessionid);
        logger.debug("In DocMgmtAdvSearch : Return value from checkSession " + sid);
        if (sid <= -1) {
            request.getSession().setAttribute("expired", "expired");
            (response.getWriter()).write("expired");
            System.out.println("In DocMgmtAdvSearch : Session Expired ");
        } else {
            System.out.println("In DocMgmtAdvSearch : Getting List of Files ");
            userName = (String) request.getParameter("userName");

            String keywordSearch = "";
            String propertytype = "";
            String propertyname = "";
            
            String indexid = "";
            String docid = "";
            String foldername="";
            String indexval = "";
            String docStatus = "";

            String keyword = "";
            
            if ((String) request.getParameter("propertytype") != null) {
            	propertytype = (String) request.getParameter("propertytype");
            	
            }
            
            
            if ((String) request.getParameter("propertyname") != null) {
            	propertyname = (String) request.getParameter("propertyname");
            	
            }

            if ((String) request.getParameter("docvar") != null) {
                indexid = (String) request.getParameter("indexvar");
                docid = (String) request.getParameter("docvar");
                foldername = (String) request.getParameter("foldervar");
                indexval = (String) request.getParameter("indexval");
                docStatus = (String) request.getParameter("docStatus");
            }


            if ((String) request.getParameter("keywordSearch") != null) {
                keyword = (String) request.getParameter("keywordSearch");
            }


            String fuzzySearch = (String) request.getParameter("fuzzySearch");

            String id = "formId";
           
            System.out.println("**** docid *********"+docid+"<------");
            System.out.println("**** foldername ---->"+foldername+"<------");
	            try {
	
	                String sqlstr = "";
	                if(!"".equals(keyword) && keyword != null){ 
	                	System.out.println("**** keyword *********");
	                	// only when search is for Keyword  
			                sqlstr = "select ";
			                sqlstr += "a.filename fileName,a.actualfilename,x.foldername as folder_name, ";
			                
			                /*sqlstr += "(SELECT LISTAGG(folder_name,'</br>') WITHIN GROUP (ORDER BY folder_id) as folder_name ";
			                sqlstr += "FROM folders where folder_id in ";
			                sqlstr += "(SELECT folder_id ";
			                sqlstr += "FROM document_folders where document_id = a.document_id)) folder_name, ";*/

			                sqlstr += "b.document_type document_type, ";
			                sqlstr += "c.index_type index_type, ";
			                sqlstr += "d.index_data value, ";
			                sqlstr += "a.version version, ";
			                sqlstr += "a.document_id document_id, ";
			                sqlstr += "c.index_type_id index_type_id, ";
			                sqlstr += "a.document_type_id document_type_id ";
			                sqlstr += "from ";
			                if(!propertytype.equalsIgnoreCase("Any") && !propertytype.equalsIgnoreCase(""))
			                {
			                	sqlstr += "property p,";
			                }
			                if(!propertyname.equalsIgnoreCase("Any") && !propertyname.equalsIgnoreCase(""))
			                {
			                	sqlstr += "property p,";
			                }
			                sqlstr += "document_data a , ";
			                sqlstr += "document_type b, ";
			                sqlstr += "index_type c, ";
			                sqlstr += "search_data d, ";
			               // sqlstr += "folders e, ";
			                sqlstr += "hud_pdf f, ";
			                sqlstr +="table(getfolder(a.document_id)) x ";
			                sqlstr += "where ";
			                if(!propertytype.equalsIgnoreCase("Any")&& !propertytype.equalsIgnoreCase(""))
			                {
				                sqlstr += "a.property_id = p.id and p.property_id = '"+propertytype+"' and ";
		
			                }
			                if(!propertyname.equalsIgnoreCase("Any")&& !propertyname.equalsIgnoreCase(""))
			                {
				                sqlstr += "a.property_id = p.id and p.property_name = '"+propertyname+"' and ";
		
			                }
			                sqlstr += "a.document_type_id=b.document_type_id and ";
			                sqlstr += "d.index_type_id = c.index_type_id and ";
			                sqlstr += "a.document_id = d.document_id and ";
			                sqlstr += "a.document_id = f.document_id  ";
			                //sqlstr += "a.folder_id = e.folder_id ";
			                sqlstr += "and contains(pdf_str,'" + keyword + "',1)>0 ";
			                sqlstr += " and a.company_id='" + compid + "' ";
	                
	                } else if (!"".equals(docid) && docid != null && ("".equals(foldername) || foldername == null)) {
	                	System.out.println("**** docid *********");
	                	sqlstr = "select ";
		                sqlstr += "a.filename fileName,a.actualfilename,x.foldername as folder_name, ";
		                
		                /*sqlstr += "(SELECT LISTAGG(folder_name,'</br>') WITHIN GROUP (ORDER BY folder_id) as folder_name ";
		                sqlstr += "FROM folders where folder_id in ";
		                sqlstr += "(SELECT folder_id ";
		                sqlstr += "FROM document_folders where document_id = a.document_id)) folder_name, ";
*/
		                
		                sqlstr += "b.document_type document_type, ";
		                sqlstr += "c.index_type index_type, ";
		                sqlstr += "d.index_data value, ";
		                sqlstr += "a.version version, ";
		                sqlstr += "a.document_id document_id, ";
		                sqlstr += "c.index_type_id index_type_id, ";
		                sqlstr += "a.document_type_id document_type_id ";
		                sqlstr += "from ";
		                if(!propertytype.equalsIgnoreCase("Any") && !propertytype.equalsIgnoreCase(""))
		                {
		                	sqlstr += "property p,";
		                }
		                if(!propertyname.equalsIgnoreCase("Any") && !propertyname.equalsIgnoreCase(""))
		                {
		                	sqlstr += "property p,";
		                }
		                sqlstr += "document_data a , ";
		                sqlstr += "document_type b, ";
		                sqlstr += "index_type c, ";
		                sqlstr += "search_data d, ";
		                sqlstr +="table(getfolder(a.document_id)) x ";
		               // sqlstr += ",folders e ";
		                if(!"".equals(keyword) && keyword != null){
		                	sqlstr += ", hud_pdf f ";
		                }
		                sqlstr += "where ";
		                if(!propertytype.equalsIgnoreCase("Any")&& !propertytype.equalsIgnoreCase(""))
		                {
			                sqlstr += "a.property_id = p.id and p.property_id = '"+propertytype+"' and ";
	
		                }
		                if(!propertyname.equalsIgnoreCase("Any")&& !propertyname.equalsIgnoreCase(""))
		                {
			                sqlstr += "a.property_id = p.id and p.property_name = '"+propertyname+"' and ";
	
		                }
		                sqlstr += "a.document_type_id=b.document_type_id and ";
		                sqlstr += "d.index_type_id = c.index_type_id and ";
		                sqlstr += "a.document_id = d.document_id  ";
		               // sqlstr += "a.folder_id = e.folder_id ";
		                if(!"".equals(keyword) && keyword != null){
		                	sqlstr += "and a.document_id = f.document_id ";
		                }
		                
		                String indexsql1 = " Upper(t1.index_data) like '%" + indexval.toUpperCase() + "%' ";
		               
		                if ("true".equals(fuzzySearch)) {
		                    indexsql1 = " contains(index_data,'" + indexval + "',1)>0 ";
		                    
		                }
		                
	                
		                if (!"".equals(indexval) && indexval != null) {   	
		                	sqlstr += " and (d.document_id in (select t1.document_id from search_data t1 where ";

		                	sqlstr += "  t1.index_type_id='" + indexid + "'";
	
	                    
	                        sqlstr += " and " + indexsql1;
	                        
	                        sqlstr += " ) )";
	                    }
	                    
	                    if (!"All".equals(docid.trim())) {
	                        sqlstr += " and a.document_type_id='" + docid.trim() + "'";
	                    }
	
	                    if ("Active".equals(docStatus)) {
	                        
	                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id and g.version >= 0) ";
	                    } else if ("Inactive".equals(docStatus)) {
	                        
	                        sqlstr += " and a.version = (select min(version) from document_data g where g.document_id= a.document_id and g.version < 0) ";
	                    } else {
	                        
	                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id ) ";
	                    }
		                
		                if (!"".equals(foldername) && foldername != null ) {
		                	
		                	if(!foldername.startsWith("/"))
		        			{
		                		foldername = "/"+foldername;		
		        			}
		        			if(!foldername.endsWith("/"))
		        			{
		        				foldername = foldername + "/";		
		        			}
		                    //sqlstr += " and  e.folder_name like '" + foldername + "%' ";
		                //	sqlstr += " and  upper(e.folder_name) = upper('" + foldername + "') ";
		                	 sqlstr += " and  upper(e.folder_name) like upper('%" + foldername + "%') ";
		                }
		                
		
		                sqlstr += " and a.company_id='" + compid + "' ";
	                }    
	                else if (!"".equals(foldername) && foldername != null ){
	                	System.out.println("**** foldername *********");
	                	sqlstr = "select ";
		                sqlstr += "a.filename fileName,a.actualfilename,e.folder_name, ";
		                sqlstr += "b.document_type document_type, ";
		                sqlstr += "c.index_type index_type, ";
		                sqlstr += "d.index_data value, ";
		                sqlstr += "a.version version, ";
		                sqlstr += "a.document_id document_id, ";
		                sqlstr += "c.index_type_id index_type_id, ";
		                sqlstr += "a.document_type_id document_type_id ";
		                sqlstr += "from ";
		                
		                sqlstr += "document_data a , ";
		                sqlstr += "document_type b, ";
		                sqlstr += "index_type c, ";
		                sqlstr += "search_data d, ";
		                sqlstr += "folders e, ";
		                sqlstr += "document_folders f ";
		                
		                sqlstr += "where ";
		                
		                sqlstr += "a.document_type_id=b.document_type_id and ";
		                sqlstr += "d.index_type_id = c.index_type_id and ";
		                sqlstr += "a.document_id = d.document_id and ";
		                sqlstr += "a.document_id = f.document_id and ";
		                sqlstr += "e.folder_id = f.folder_id ";
		                		                
		                if (!"".equals(foldername) && foldername != null ) {
		                	
		                	if(!foldername.startsWith("/"))
		        			{
		                		foldername = "/"+foldername;		
		        			}
		        			/*if(!foldername.endsWith("/"))
		        			{
		        				foldername = foldername + "/";		
		        			}*/
		        			 //	sqlstr += " and  upper(e.folder_name) = upper('" + foldername + "') ";
		                    sqlstr += " and  upper(e.folder_name) like upper('%" + foldername + "%') ";
		        			
		        	
		        		
		                }
		                sqlstr += " and a.company_id='" + compid + "' ";

	                }
	                /*
	                System.out.println("docid "+ docid + " indexval "+indexval);
	                if(docid.equalsIgnoreCase("All") && indexval == "")
	                {
	                	sqlstr += "and rownum < = 1000 ";
	                }
					*/
	                if (!"".equals(orderby) && orderby != null) {
	                    sqlstr += " order by " + orderby;
	                    
	                } else {
	                    sqlstr += "  order by a.filename,index_type, index_data, b.document_type_id ";
	                }
	                
	                Vector fileList = new Vector();
	                SearchDataDAO searchDataDAO = new SearchDataDAO();
	                
	                String startSet = "0";
	                
	                if (!"".equals(docid) && docid != null) {
	                	
		                int totalSet = 0;
		                
		                if((String)request.getParameter("startSet") == null ){
		                	
		                	fileList = searchDataDAO.findByQuery(sqlstr, "docMgmtFolderView");
		                	totalSet = fileList.size();
		                	
		                }
		                
		                String startWith = "0";
		                
		                if((String)request.getParameter("startSet") != null ){
		                	startSet = request.getParameter("startSet");
		                	
		                	totalSet = Integer.parseInt(startSet.substring(0, startSet.indexOf("$", 0)));
		                	
		                	startWith = startSet.substring(startSet.indexOf("$", 0) + 1, startSet.length());
		                } else {
		                	startSet = totalSet + "$" + startSet;
		                }
		                	
		                sqlstr += " OFFSET "+startWith+" ROWS FETCH NEXT 10 ROWS ONLY ";
		                
		                logger.info(userName + " :DocMgmtSearchFolder query : " + sqlstr);
		               
	                	
	                }
	                 
	                fileList = searchDataDAO.findByQuery(sqlstr, "docMgmtFolderView");
	                String html = "";
	                for(int i=0; i< fileList.size(); i++)
	                {
	                	
	                	if(((SearchDataObj)fileList.get(i)).getFolderName() != null)
	                	{
	                		String actualFileName = "";
	                		if(((SearchDataObj)fileList.get(i)).getActualFileName() == null ||
	                			((SearchDataObj)fileList.get(i)).getActualFileName() == "")
	                		{
	                			String fullPath = ((SearchDataObj)fileList.get(i)).getFileName();
	                			int index = fullPath.lastIndexOf("/");
	                			actualFileName = fullPath.substring(index + 1);
	                		}
	                		else
	                		{
	                			actualFileName = ((SearchDataObj)fileList.get(i)).getActualFileName();
	                		}
	                		
		                 html += "/"+actualFileName.replaceAll(",", "").replaceAll("#", "")+
		                 "#"+((SearchDataObj)fileList.get(i)).getFileName()+
		                 "#"+((SearchDataObj)fileList.get(i)).getDocumentType()+
		                 "#"+((SearchDataObj)fileList.get(i)).getFolderName()+
		                 "#"+((SearchDataObj)fileList.get(i)).getVersion()+
		                 ",";
		                 
		                 
	                		/* html += ((SearchDataObj)fileList.get(i)).getFolderIds()+actualFileName+
	        		                 "#"+((SearchDataObj)fileList.get(i)).getFileName()+
	        		                 "#"+((SearchDataObj)fileList.get(i)).getDocumentType()+
	        		                 "#"+((SearchDataObj)fileList.get(i)).getFolderIds()+
	        		                 "#"+((SearchDataObj)fileList.get(i)).getVersion()+
	        		                 ",";
	                		*/
		                 System.out.println("html -->"+html);
	                	}

	                }
	                
	                //System.out.println("html New ---> "+html);
             
	                //Store the data in seesion variable 
	                //Which will be accessed by connector jqueryFileTree.jsp to render folders
	                request.getSession().setAttribute("data", html);                
	              
	                (response.getWriter()).write(startSet);
	
	            } catch (Exception e) {
	                e.printStackTrace();
	                logger.error(e.getMessage());
	            }
            

        }

	}

    



	public void init() throws ServletException {
		// Put your code here
	}

	}
