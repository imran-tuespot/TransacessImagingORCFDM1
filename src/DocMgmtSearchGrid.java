import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jmesa.facade.TableFacade;
import org.jmesa.facade.TableFacadeFactory;
import org.jmesa.limit.Limit;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;

import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.SearchDataObj;
import com.peniel.dao.SearchDataDAO;

/**
 * Servlet implementation class for Servlet: DocDownloadSearchGrid.
 *
 * user will be able to accept
 */
public class DocMgmtSearchGrid extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    private static Logger logger = LogManager.getLogger(DocMgmtSearchGrid.class);

    private String userName = "";


    /* (non-Java-doc)
      * @see javax.servlet.http.HttpServlet#HttpServlet()
      */
    public DocMgmtSearchGrid() {
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
        logger.info("orderby -->" + orderby);
        SessionBean s = new SessionBean();
        int sid = s.checkSession(sessionid);
        logger.debug("In Get Files : Return value from checkSession " + sid);
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


            String indexid2 = "";
            String docid2 = "";
            String indexval2 = "";
            String docStatus2 = "";

            String indexid3 = "";
            String docid3 = "";
            String indexval3 = "";
            String docStatus3 = "";

            String indexid4 = "";
            String docid4 = "";
            String indexval4 = "";
            String docStatus4 = "";

            String indexid5 = "";
            String docid5 = "";
            String indexval5 = "";
            String docStatus5 = "";

            String keyword = "";
            
            if ((String) request.getParameter("docvar") != null) {
                indexid = (String) request.getParameter("indexvar");
                docid = (String) request.getParameter("docvar");
                indexval = (String) request.getParameter("indexval");
                docStatus = (String) request.getParameter("docStatus");
            }

            if ((String) request.getParameter("docvar2") != null) {
                indexid2 = (String) request.getParameter("indexvar2");
                docid2 = (String) request.getParameter("docvar2");
                indexval2 = (String) request.getParameter("indexval2");
                docStatus2 = (String) request.getParameter("docStatus2");
            }

            if ((String) request.getParameter("docvar3") != null) {
                indexid3 = (String) request.getParameter("indexvar3");
                docid3 = (String) request.getParameter("docvar3");
                indexval3 = (String) request.getParameter("indexval3");
                docStatus3 = (String) request.getParameter("docStatus3");
            }

            if ((String) request.getParameter("docvar4") != null) {
                indexid4 = (String) request.getParameter("indexvar4");
                docid4 = (String) request.getParameter("docvar4");
                indexval4 = (String) request.getParameter("indexval4");
                docStatus4 = (String) request.getParameter("docStatus4");
            }

            if ((String) request.getParameter("docvar5") != null) {
                indexid5 = (String) request.getParameter("indexvar5");
                docid5 = (String) request.getParameter("docvar5");
                indexval5 = (String) request.getParameter("indexval5");
                docStatus5 = (String) request.getParameter("docStatus5");
            }
            //String secondRow = (String)request.getParameter("checkRow");

            if ((String) request.getParameter("keywordSearch") != null) {
                keyword = (String) request.getParameter("keywordSearch");
            }
            
            String fuzzySearch = (String) request.getParameter("fuzzySearch");

            String id = "formId";

            try {

                String sqlstr = "";

                if(!"".equals(keyword) && keyword != null){ 
                	
                	// only when search is for Keyword
                	
                	sqlstr = "select ";
	                sqlstr += "a.filename fileName, ";
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
	                sqlstr += " hud_pdf e ";
	                sqlstr += "where ";
	                sqlstr += "a.document_type_id=b.document_type_id and ";
	                sqlstr += "d.index_type_id = c.index_type_id and ";
	                sqlstr += "a.document_id = d.document_id ";
	                sqlstr += "and a.document_id = e.document_id ";
	                sqlstr += "and contains(pdf_str,'" + keyword + "',1)>0 ";
	                sqlstr += " and a.company_id='" + compid + "' ";

                } else if (!"".equals(docid) && docid != null) {

                	sqlstr = "select ";
	                sqlstr += "a.filename fileName, ";
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
	                sqlstr += "search_data d ";
	                if(!"".equals(keyword) && keyword != null){
	                	sqlstr += ", hud_pdf e ";
	                }
	                sqlstr += "where ";
	                sqlstr += "a.document_type_id=b.document_type_id and ";
	                sqlstr += "d.index_type_id = c.index_type_id and ";
	                sqlstr += "a.document_id = d.document_id ";
	                if(!"".equals(keyword) && keyword != null){
	                	sqlstr += "and a.document_id = e.document_id ";
	                }
	                
	                String indexsql1 = " Upper(t1.index_data) like '%" + indexval.toUpperCase() + "%' ";
	                String indexsql2 = " Upper(t2.index_data) like '%" + indexval2.toUpperCase() + "%' ";
	                String indexsql3 = " Upper(t3.index_data) like '%" + indexval3.toUpperCase() + "%' ";
	                String indexsql4 = " Upper(t4.index_data) like '%" + indexval4.toUpperCase() + "%' ";
	                String indexsql5 = " Upper(t5.index_data) like '%" + indexval5.toUpperCase() + "%' ";
	
	                if ("true".equals(fuzzySearch)) {
	                    indexsql1 = " contains(index_data,'" + indexval + "',1)>0 ";
	                    indexsql2 = " contains(index_data,'" + indexval2 + "',1)>0 ";
	                    indexsql3 = " contains(index_data,'" + indexval3 + "',1)>0 ";
	                    indexsql4 = " contains(index_data,'" + indexval4 + "',1)>0 ";
	                    indexsql5 = " contains(index_data,'" + indexval5 + "',1)>0 ";
	                }
	
	                sqlstr += " and d.document_id in (select t1.document_id from search_data t1 where ";

                    sqlstr += " ( index_type_id='" + indexid + "'";

                    if (!"".equals(indexval) && indexval != null) {
                        sqlstr += " and " + indexsql1;
                    }
                    sqlstr += " ) ";
                    if (!"All".equals(docid.trim())) {
                        sqlstr += " and a.document_type_id='" + docid.trim() + "'";
                    }

                    if ("Active".equals(docStatus)) {
                        //sqlstr += " and a.version >= 0  ";
                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id and g.version >= 0) ";
                    } else if ("Inactive".equals(docStatus)) {
                        //sqlstr += " and a.version < 0 ";
                        sqlstr += " and a.version = (select min(version) from document_data g where g.document_id= a.document_id and g.version < 0) ";
                    } else {
                        //sqlstr += " and a.version < 0 ";
                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id ) ";
                    }
                

	                if (!"".equals(docid2) && docid2 != null) {
	
	                    sqlstr += " or ( index_type_id='" + indexid2 + "'";
	
	                    if (!"".equals(indexval2) && indexval2 != null) {
	                        sqlstr += " and " + indexsql2;
	                    }
	                    sqlstr += " ) ";
	
	                    if (!"All".equals(docid2.trim())) {
	                        sqlstr += " and a.document_type_id='" + docid2.trim() + "'";
	                    }
	
	                    if ("Active".equals(docStatus2)) {
	                        //sqlstr += " and a.version >= 0  ";
	                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id and g.version >= 0) ";
	                    } else if ("Inactive".equals(docStatus2)) {
	                        //sqlstr += " and a.version < 0 ";
	                        sqlstr += " and a.version = (select min(version) from document_data g where g.document_id= a.document_id and g.version < 0) ";
	                    } else {
	                        //sqlstr += " and a.version < 0 ";
	                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id ) ";
	                    }
	                }
	
	                if (!"".equals(docid3) && docid3 != null) {
	
	                    sqlstr += " or ( index_type_id='" + indexid3 + "'";
	
	                    if (!"".equals(indexval3) && indexval3 != null) {
	                        sqlstr += " and " + indexsql3;
	                    }
	                    sqlstr += " ) ";
	
	                    if (!"All".equals(docid3.trim())) {
	                        sqlstr += " and a.document_type_id='" + docid3.trim() + "'";
	                    }
	
	                    if ("Active".equals(docStatus3)) {
	                        //sqlstr += " and a.version >= 0  ";
	                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id and g.version >= 0) ";
	                    } else if ("Inactive".equals(docStatus3)) {
	                        //sqlstr += " and a.version < 0 ";
	                        sqlstr += " and a.version = (select min(version) from document_data g where g.document_id= a.document_id and g.version < 0) ";
	                    } else {
	                        //sqlstr += " and a.version < 0 ";
	                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id ) ";
	                    }
	                }
	
	                if (!"".equals(docid4) && docid4 != null) {
	
	                    sqlstr += " or ( index_type_id='" + indexid4 + "'";
	
	                    if (!"".equals(indexval4) && indexval4 != null) {
	                        sqlstr += " and " + indexsql4;
	                    }
	                    sqlstr += " ) ";
	
	                    if (!"All".equals(docid4.trim())) {
	                        sqlstr += " and a.document_type_id='" + docid4.trim() + "'";
	                    }
	                    if ("Active".equals(docStatus4)) {
	                        //sqlstr += " and a.version >= 0  ";
	                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id and g.version >= 0) ";
	                    } else if ("Inactive".equals(docStatus4)) {
	                        //sqlstr += " and a.version < 0 ";
	                        sqlstr += " and a.version = (select min(version) from document_data g where g.document_id= a.document_id and g.version < 0) ";
	                    } else {
	                        //sqlstr += " and a.version < 0 ";
	                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id ) ";
	                    }
	                }
	
	                if (!"".equals(docid5) && docid5 != null) {
	
	                    sqlstr += " or ( index_type_id='" + indexid5 + "'";
	
	                    if (!"".equals(indexval5) && indexval5 != null) {
	                        sqlstr += " and " + indexsql5;
	                    }
	
	                    sqlstr += " ) ";
	
	                    if (!"All".equals(docid5.trim())) {
	                        sqlstr += " and a.document_type_id='" + docid5.trim() + "'";
	                    }
	
	                    if ("Active".equals(docStatus5)) {
	                        //sqlstr += " and a.version >= 0  ";
	                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id and g.version >= 0) ";
	                    } else if ("Inactive".equals(docStatus5)) {
	                        //sqlstr += " and a.version < 0 ";
	                        sqlstr += " and a.version = (select min(version) from document_data g where g.document_id= a.document_id and g.version < 0) ";
	                    } else {
	                        //sqlstr += " and a.version < 0 ";
	                        sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id ) ";
	                    }
	                    
	                    if(!"".equals(keyword) && keyword != null){
		                	sqlstr += "and contains(pdf_str,'" + keyword + "',1)>0 ";
		                }
	                    
	                    
	                }  
	                    
	                sqlstr += " and a.company_id='" + compid + "') ";
	                    
	                  
	                } 
	                
	                if (!"".equals(orderby) && orderby != null) {
	                    sqlstr += " order by " + orderby;
	                } else {
	                    sqlstr += " order by index_type, index_data, b.document_type_id  ";
	                }
	
	                logger.info(userName + " : query : " + sqlstr);
	
	                Vector fileList = new Vector();
	                SearchDataDAO searchDataDAO = new SearchDataDAO();
	
	                fileList = searchDataDAO.findByQuery(sqlstr, "docMgmt");
	
	                TableFacade tableFacade = TableFacadeFactory.createTableFacade(id, request);
	                //tableFacade.setColumnProperties("Nbr.","indexType","indexValue","documentType","version","PDF Viewer", "Document");
	                tableFacade.setColumnProperties("documentType", "indexType", "indexValue", "version", "version", "PDF Viewer", "Document");
	                tableFacade.setItems(fileList);
	
	                Limit limit = tableFacade.getLimit();
	
	                tableFacade.setView(new CustomView());
	
	                String html = getRenderedHTML(tableFacade, request, userid, compid, sessionid, userName);
	                (response.getWriter()).write(html);

            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }

        }
    }

    public String getRenderedHTML(TableFacade tableFacade, HttpServletRequest request, String userid, String compid, String sessionid, String username) {

        HtmlTable table = (HtmlTable) tableFacade.getTable();
        table.getTableRenderer().setWidth("100%");
        table.setCaption("Your Search Results");


        HtmlRow row = table.getRow();
        /*
          HtmlColumn nbr = row.getColumn(0);

          nbr.getCellRenderer().setCellEditor(new  CellEditor(){

              public Object getValue(Object arg0, String arg1, int arg2) {

                  SearchDataObj searchDataObj1=(SearchDataObj)arg0;
                  return searchDataObj1.getSrNo();
           }});
          nbr.setTitle("Nbr.");
          nbr.setEditable(false);
          nbr.setSortable(false);
          nbr.setFilterable(false);
          */

        HtmlColumn docType = row.getColumn(0);
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

        HtmlColumn indexType = row.getColumn(1);

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


        HtmlColumn indexValue = row.getColumn(2);
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


        HtmlColumn version = row.getColumn(3);
        version.setCellEditor(new CellEditor() {

            public Object getValue(Object arg0, String arg1, int arg2) {

                SearchDataObj searchDataObj1 = (SearchDataObj) arg0;
                String status = "Active";
                int version = 0;
                version = searchDataObj1.getVersion();
                if (version < 0) {
                    status = "Inactive";
                }
                return status;
            }
        });
        //version.setTitle("<a href=javascript:sortby(\'version\')><font color=white>Status</font></a>");
        version.setTitle("<font color=white>Status</font>");
        version.setEditable(false);
        version.setSortable(true);
        version.setFilterable(true);

        /*****************Add Version********************/
        HtmlColumn Version = row.getColumn(4);
        Version.setCellEditor(new CellEditor() {

            public Object getValue(Object arg0, String arg1, int arg2) {

                SearchDataObj searchDataObj1 = (SearchDataObj) arg0;
                return searchDataObj1.getVersion();

            }
        });
        //Version.setTitle("<a href=javascript:sortby(\'version\')><font color=white>Version</font></a>");
        Version.setTitle("<font color=white>Version</font>");
        Version.setEditable(false);
        //Version.setSortable(true);
        Version.setFilterable(true);
        /****************************************************/

        final String CONTEXT_PATH = request.getContextPath();

        HtmlColumn fileName = row.getColumn(5);
        fileName.setTitle("PDF Viewer &nbsp;<img height=\"15\" src=\"" + CONTEXT_PATH + "/images/pdfViewer.gif\">");

        fileName.setCellEditor(new CellEditor() {
            public Object getValue(Object item, String property, int rowcount) {
                SearchDataObj searchDataObj1 = (SearchDataObj) item;
                HtmlBuilder htmlB = new HtmlBuilder();
                //String filePath = "javascript:getpdf("+"'/"+searchDataObj1.getFileName()+"/');";
                String filePath = "javascript:getpdf('" + searchDataObj1.getFileName() + "');";
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
        fileName.setFilterable(true);

        HtmlColumn editFile = row.getColumn(6);
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

                String filePath = "javascript:editDoc('" + searchDataObj1.getFileName() + "','" + searchDataObj1.getIndexType() + "','" + searchDataObj1.getIndexValue() + "','" + searchDataObj1.getDocumentType() + "','" + status + "','" + searchDataObj1.getDocId() + "','" + version + "','" + searchDataObj1.getIndexTypeId() + "','" + searchDataObj1.getDocTypeId() + "','')";
                //String filePath = "./EditDocument?userid="+userid+"&"+"comid="+compid+"&"+"sessionid="+sessionid+"&"+"username="+username;

                htmlB.a().href().quote().append(filePath).quote().close();
                htmlB.append("Details");
                htmlB.aEnd();
                return htmlB.toString();
            }
        });
        editFile.setEditable(false);
        editFile.setSortable(false);
        editFile.setFilterable(true);


        return tableFacade.render();
    }


}
