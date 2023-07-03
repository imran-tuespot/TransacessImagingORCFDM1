import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jmesa.model.AllItems;
import org.jmesa.model.TableModel;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;

import com.peniel.beans.CompanyInformation;
import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.SearchDataObj;
import com.peniel.dao.SearchDataDAO;

/**
 * Servlet implementation class for Servlet: DocDownloadSearchGrid.
 *
 * user will be able to accept
 */
public class DocMgmtSearchGrid1 extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    private static Logger logger = LogManager.getLogger(DocMgmtSearchGrid.class);

    private String userName = "";


    /* (non-Java-doc)
      * @see javax.servlet.http.HttpServlet#HttpServlet()
      */
    public DocMgmtSearchGrid1() {
        super();
    }

    /* (non-Java-doc)
      * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
      */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /* (non-Java-doc)
      * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
      */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	
        String userid = (String) request.getParameter("userid");
        String compid = (String) request.getParameter("compid");
        String sessionid = (String) request.getParameter("sessionid");
        String orderby = (String) request.getParameter("orderby");
        String id = (String) request.getParameter("formId");
        //String andOR = (String) request.getParameter("andOR");
        //String andOr = "and";
        
     //   Set<String> accessType = (Set<String>)request.getSession().getAttribute("accessPatterenDetails");
       // System.out.println("accessType "+accessType.size()+accessType);
        String propertytypeClassic = "";
        if ((String) request.getParameter("propertytype") != null) {
        	propertytypeClassic = (String) request.getParameter("propertytype");
        	
        }
        System.out.println("propertytypeClassic -->" + propertytypeClassic +"<--");
        String propertynameClassic = "";
        if ((String) request.getParameter("propertyname") != null) {
        	propertynameClassic = (String) request.getParameter("propertyname");
        	
        }
        System.out.println("propertynameClassic -->" + propertynameClassic +"<--");
        SessionBean s = new SessionBean();
        int sid = s.checkSession(sessionid);
        System.out.println("In Get Files : Return value from checkSession " + sid);
        if (sid <= -1) {
            request.getSession().setAttribute("expired", "expired");
            (response.getWriter()).write("expired");
            logger.debug("In Get Files : Session Expired ");
        } else {
            logger.debug("In Get Files : Getting List of Files ");
            userName = (String) request.getParameter("userName");

            	
            String indexid = "";
            String docid = "";
            String indexval = "";
            String docStatus = "";


            if ((String) request.getParameter("docvar") != null) {
                indexid = (String) request.getParameter("indexvar");
                docid = (String) request.getParameter("docvar");
                indexval = (String) request.getParameter("indexval");
                docStatus = (String) request.getParameter("docStatus");
            }

            
	            try {
	
	                String sqlstr = "";
	
	                sqlstr = "select ";
	                //sqlstr += "a.filename fileName,e.folder_name, ";
	                sqlstr += "a.filename fileName, ";
	                sqlstr += "b.document_type document_type, ";
	                sqlstr += "c.index_type index_type, ";
	                sqlstr += "d.index_data value, ";
	                sqlstr += "a.version version, ";
	                sqlstr += "a.document_id document_id, ";
	                sqlstr += "c.index_type_id index_type_id, ";
	                sqlstr += "a.document_type_id document_type_id ";
	                sqlstr += "from ";
	                if(!propertytypeClassic.equalsIgnoreCase("Any") && !propertytypeClassic.equalsIgnoreCase(""))
	                {
	                	sqlstr += "property p,";
	                }
	                if(!propertynameClassic.equalsIgnoreCase("Any") && !propertynameClassic.equalsIgnoreCase(""))
	                {
	                	sqlstr += "property p,";
	                }
	                sqlstr += "document_data a , ";
	                sqlstr += "document_type b, ";
	                sqlstr += "index_type c, ";
	                sqlstr += "search_data d ";
	                //sqlstr += "folders e ";
	                sqlstr += "where ";
	                if(!propertytypeClassic.equalsIgnoreCase("Any") && !propertytypeClassic.equalsIgnoreCase(""))
	                {
		                sqlstr += "a.property_id = p.id and p.property_id = '"+propertytypeClassic+"' and ";

	                }
	                if(!propertynameClassic.equalsIgnoreCase("Any") && !propertynameClassic.equalsIgnoreCase(""))
	                {
		                sqlstr += "a.property_id = p.id and p.property_name = '"+propertynameClassic+"' and ";

	                }
	                sqlstr += "a.document_type_id=b.document_type_id and ";
	                sqlstr += "d.index_type_id = c.index_type_id and ";
	                sqlstr += "a.document_id = d.document_id  ";
	               // sqlstr += " and a.folder_id = e.folder_id ";
	
	                String indexsql1 = " Upper(t1.index_data) like '%" + indexval.toUpperCase() + "%' ";
	                
	
	                
	
	                boolean keywordExists = true;
	                
	                String html = "";
	                //if(keywordExists)  {               
			        
			                if (!"".equals(docid) && docid != null) {
			                	sqlstr += " and (d.document_id in (select t1.document_id from search_data t1 where ";
			                	
			                    sqlstr += "  t1.index_type_id='" + indexid + "'";
			
			                    if (!"".equals(indexval) && indexval != null) {
			                        sqlstr += " and " + indexsql1;
			                    }
			                    
			                    sqlstr += " ) ";
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
			                }
			
			                
			                sqlstr += " and a.company_id='" + compid + "') ";
			
			                if (!"".equals(orderby) && orderby != null) {
			                    sqlstr += " order by " + orderby;
			                    
			                } else {
			                    sqlstr += "  order by a.filename,index_type, index_data, b.document_type_id ";
			                }
			
			                logger.info(userName + " : query : " + sqlstr);
			
			                                
			                TableModel tableModel = new TableModel(id, request, response);
			         	   //tableModel.setEditable(true);
			         	    
			                //final String sql = sqlstr;
			         		/*tableModel.setItems(new AllItems() {
			                     public Collection<?> getItems() {
			                    	 
			                    	 SearchDataDAO searchDataDAO = new SearchDataDAO();
			             			 return searchDataDAO.findByQuery(sql, "docMgmt");
			                     }
			                 });
			         		*/
			                
			                SearchDataDAO searchDataDAO = new SearchDataDAO();
		        			 Vector vc = searchDataDAO.findByQuery(sqlstr, "docMgmt");
			                
			         		tableModel.setItems(vc);

			                tableModel.setTable(getRenderedHTML(request, userid, compid, sessionid, userName));
			                
			                html = tableModel.render();
			                
			               // System.out.println("html-->"+html);
	               
			               // byte[] contents = html.getBytes();
			                response.getWriter().write(html);

	
	            } catch (Exception e) {
	                e.printStackTrace();
	                logger.error(e.getMessage());
	            }
            

        }
    }
    


    public HtmlTable getRenderedHTML(HttpServletRequest request, String userid, String compid, String sessionid, String username) {

       
    	HtmlTable worksheetTable = new HtmlTable().caption("Your Search Results").width("700px");

		// unique property to identify the row
		HtmlRow row = new HtmlRow().uniqueProperty("documentId");
		worksheetTable.setRow(row);
        
		//HtmlRow row = table.getRow();
        

        HtmlColumn docType = new HtmlColumn("documentType");
        docType.setCellEditor(new CellEditor() {
            public Object getValue(Object arg0, String arg1, int arg2) {

                SearchDataObj searchDataObj1 = (SearchDataObj) arg0;
                return searchDataObj1.getDocumentType();
            }
        });
        //docType.setTitle("<a href=javascript:sortby(\'document_type\')><font color=white>Type</font></a>");
        docType.setTitle("<font color=white>Document Type</font>");
        docType.setEditable(false);
        docType.setSortable(true);
        docType.setFilterable(true);
        
        row.addColumn(docType);

        HtmlColumn indexType = new HtmlColumn("indexType");

        indexType.setCellEditor(new CellEditor() {

            public Object getValue(Object arg0, String arg1, int arg2) {

                SearchDataObj searchDataObj1 = (SearchDataObj) arg0;
                return searchDataObj1.getIndexType();
            }
        });
        //indexType.setTitle("<a href=javascript:sortby(\'index_type\')><font color=white>Index Type</font></a>");
        indexType.setTitle("<font color=white>Index Type</font>");
        indexType.setEditable(false);
        indexType.setSortable(true);
        indexType.setFilterable(true);

        row.addColumn(indexType);
        
        HtmlColumn indexValue = new HtmlColumn("indexValue");
        indexValue.setCellEditor(new CellEditor() {

            public Object getValue(Object arg0, String arg1, int arg2) {

                SearchDataObj searchDataObj1 = (SearchDataObj) arg0;
                return searchDataObj1.getIndexValue();
            }
        });
        //indexValue.setTitle("<a href=javascript:sortby(\'index_data\')><font color=white>Value</font></a>");
        indexValue.setTitle("<font color=white>Value</font>");
        indexValue.setEditable(false);
        indexValue.setSortable(true);
        indexValue.setFilterable(true);

        row.addColumn(indexValue);
        
        /*****************Add Version********************/
        HtmlColumn Version = new HtmlColumn("version");
        Version.setCellEditor(new CellEditor() {

            public Object getValue(Object arg0, String arg1, int arg2) {

                SearchDataObj searchDataObj1 = (SearchDataObj) arg0;
                return searchDataObj1.getVersion();

            }
        });
        Version.setTitle("<font color=white>Version</font>");
        Version.setEditable(false);
        Version.setFilterable(true);
        /****************************************************/
        
        row.addColumn(Version);
        
        final String CONTEXT_PATH = request.getContextPath();

        HtmlColumn fileName = new HtmlColumn("fileName");
        fileName.setTitle("Viewer");

        fileName.setCellEditor(new CellEditor() {
            public Object getValue(Object item, String property, int rowcount) {
                SearchDataObj searchDataObj1 = (SearchDataObj) item;
                HtmlBuilder htmlB = new HtmlBuilder();
                //String filePath = "javascript:getpdf("+"'/"+searchDataObj1.getFileName()+"/');";
                String filePath = "javascript:getpdf1('" + searchDataObj1.getFileName() + "','"+searchDataObj1.getDocumentType()+
                		"','"+searchDataObj1.getIndexType()+"','"+searchDataObj1.getIndexValue()+"','"+searchDataObj1.getFolderName()+"');";
                htmlB.a().href().quote().append(filePath).quote().close();
                htmlB.append("View");
                htmlB.aEnd();
                //htmlB.nbsp();
                //htmlB.nbsp();
                //htmlB.append("<img height=\"11\" src=\""+CONTEXT_PATH+"/images/pdfViewer.gif\">");

                return htmlB.toString();
            }
        });
        fileName.setEditable(false);
        fileName.setSortable(false);
        fileName.setFilterable(false);
        
        row.addColumn(fileName);

        HtmlColumn editFile = new HtmlColumn("editFile");
        editFile.setTitle("Document");

        Vector vc = new Vector();
        vc.add(userid);

        editFile.setCellEditor(new CellEditor() {
            public Object getValue(Object item, String property, int rowcount) {

                SearchDataObj searchDataObj1 = (SearchDataObj) item;
                HtmlBuilder htmlB = new HtmlBuilder();
                String status = "Active";
                int version = 0;
                version = searchDataObj1.getVersion();
                if (version < 0) {
                    status = "Inactive";
                }
               
               // if(accessType.contains("ReadWrite")){
                    // String filePath = "javascript:editDoc('" + searchDataObj1.getFileName() + "','" + searchDataObj1.getIndexType() + "','" + searchDataObj1.getIndexValue() + "','" + searchDataObj1.getDocumentType() + "','" + status + "','" + searchDataObj1.getDocId() + "','" + version + "','" + searchDataObj1.getIndexTypeId() + "','" + searchDataObj1.getDocTypeId() + "','')";
                     String filePath = "javascript:editDoc('" + searchDataObj1.getFileName() + "','" + status + "','')";
                     //String filePath = "./EditDocument?userid="+userid+"&"+"comid="+compid+"&"+"sessionid="+sessionid+"&"+"username="+username;

                     htmlB.a().href().quote().append(filePath).quote().close();
             //       }
                    
                   
                htmlB.append("Details");
                htmlB.aEnd();
                return htmlB.toString();
            }
        });
        editFile.setEditable(false);
        editFile.setSortable(false);
        editFile.setFilterable(false);

        row.addColumn(editFile);
        
        
        return worksheetTable;
    }


}
