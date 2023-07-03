import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.SearchDataObj;
import com.peniel.dao.SearchDataDAO;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jmesa.facade.TableFacade;
import org.jmesa.facade.TableFacadeFactory;
import org.jmesa.limit.Limit;
import org.jmesa.model.TableModel;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Vector;

/**
 * Servlet implementation class for Servlet: GetFiles
 */
public class DocDownloadSearchGrid extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    private static Logger logger = LogManager.getLogger(DocDownloadSearchGrid.class);

    private String userName = "";


    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
    public DocDownloadSearchGrid() {
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

            String[] indexid = new String[5];
            String[] docid = new String[5];
            String[] indexval = new String[5];
            String[] docStatus = new String[5];

            indexid[0] = request.getParameter("indexvar");
            docid[0] = request.getParameter("docvar");
            indexval[0] = request.getParameter("indexval");
            docStatus[0] = request.getParameter("docStatus");

            for (int i = 1; i < 5; i++) {
                indexid[i] = "";
                if (request.getParameter("docvar" + (i + 1)) != null) {
                    indexid[i] = request.getParameter("indexvar" + (i + 1));
                    docid[i] = request.getParameter("docvar" + (i + 1));
                    indexval[i] = request.getParameter("indexval" + (i + 1));
                    docStatus[i] = request.getParameter("docStatus" + (i + 1));
                } else {
                    indexid[i] = "";
                    docid[i] = "";
                    indexval[i] = "";
                    docStatus[i] = "";
                }
            }

            //String secondRow = (String)request.getParameter("checkRow");

            String fuzzySearch = (String) request.getParameter("fuzzySearch");

            String id = "formId";

            try {

                String sqlstr = "";

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
                sqlstr += "where ";
                sqlstr += "a.document_type_id=b.document_type_id and ";
                sqlstr += "d.index_type_id = c.index_type_id and ";
                sqlstr += "a.document_id = d.document_id ";

                String[] indexsql = new String[5];

                for (int i = 0; i < 5; i++) {
                    if (!StringUtils.isEmpty(indexval[i])) {
                        if ("true".equals(fuzzySearch)) {
                            indexsql[i] = " contains(index_data,'" + indexval[i] + "',1)>0 ";
                        } else {
                            indexsql[i] = " Upper(index_data) like '%" + indexval[i].toUpperCase() + "%' ";
                        }
                    }
                }

                sqlstr += " and (a.document_id, d.index_data) in (select document_id, index_data from search_data where ";

                for (int i = 0; i < 5; i++) {
                    if (!StringUtils.isEmpty(indexval[i])) {
                        if (i != 0) { sqlstr += " or "; }
                        sqlstr += " ( index_type_id='" + indexid[i] + "'";

                        if (!StringUtils.isEmpty(indexval[i])) {
                            sqlstr += " and " + indexsql[i];
                        }
                        sqlstr += " ) ";
                        if (!"All".equals(docid[i].trim())) {
                            sqlstr += " and a.document_type_id='" + docid[i].trim() + "'";
                        }

                        if ("Active".equals(docStatus[i])) {
                            sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id and g.version >= 0) ";
                        } else if ("Inactive".equals(docStatus[i])) {
                            sqlstr += " and a.version = (select min(version) from document_data g where g.document_id= a.document_id and g.version < 0) ";
                        } else {
                            sqlstr += " and a.version = (select max(version) from document_data g where g.document_id= a.document_id ) ";
                        }
                    }
                }

                sqlstr += " and company_id='" + compid + "') ";

                if (!"".equals(orderby) && orderby != null) {
                    sqlstr += " order by a.filename," + orderby;
                    System.out.println("Order by "+orderby);
                } else {
                    sqlstr += " order by  a.filename,index_type, index_data, b.document_type_id  ";
                }

                logger.info(userName + " : query : " + sqlstr);
                SearchDataDAO searchDataDAO = new SearchDataDAO();

                Vector fileList = searchDataDAO.findByQuery(sqlstr, "docMgmt");
/*
                TableFacade tableFacade = TableFacadeFactory.createTableFacade(id, request);
                //tableFacade.setColumnProperties("Nbr.","indexType","indexValue","documentType","version","PDF Viewer", "Document");
                tableFacade.setColumnProperties("Download","documentType", "indexType", "indexValue", "version", "version", "PDF Viewer", "Document");
                tableFacade.setItems(fileList);

                Limit limit = tableFacade.getLimit();
*/
                
                TableModel tableModel = new TableModel("formId", request, response);
			    tableModel.setItems(fileList);
			    
			    tableModel.setView(new CustomView());

                String html = getRenderedHTML(tableModel, request, userid, compid, sessionid, userName);
                (response.getWriter()).write(html);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }

        }
    }

    public String getRenderedHTML(TableModel tableModel, HttpServletRequest request, String userid, String compid, String sessionid, String username) {

        //HtmlTable table = (HtmlTable) tableFacade.getTable();
    	
    	HtmlTable table = new HtmlTable().caption("Your Search Results").width("100%");
        //table.getTableRenderer().setWidth("100%");
        //table.setCaption("Your Search Results");


        HtmlRow row = table.getRow();

        HtmlColumn download = row.getColumn(0);
        download.setCellEditor(new CellEditor() {
            public Object getValue(Object item, String property, int rowcount) {
                SearchDataObj searchDataObj1 = (SearchDataObj) item;
                HtmlBuilder htmlB = new HtmlBuilder();
                htmlB.append("<input id=\"row-" + rowcount + "\" type=\"checkbox\" name=\"docIdSelected\" value=\"" + searchDataObj1.getDocId() +"\" checked />");
                //String filePath = "javascript:getpdf("+"'/"+searchDataObj1.getFileName()+"/');";
//                String filePath = "javascript:downloadDoc('" + searchDataObj1.getDocId() + "');";
//                htmlB.a().href().quote().append(filePath).quote().close();
//                htmlB.append("add");
//                htmlB.aEnd();

                return htmlB.toString();
//
//        		SearchDataObj searchDataObj1=(SearchDataObj)arg0;
//        		return searchDataObj1.getDocumentType();
            }
        });
        download.setTitle("<font color=white>Download</font>");
        download.setEditable(false);
        download.setSortable(false);
        download.setFilterable(false);

        HtmlColumn docType = row.getColumn(1);
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
        docType.setFilterable(false);

        HtmlColumn indexType = row.getColumn(2);

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
        indexType.setFilterable(false);


        HtmlColumn indexValue = row.getColumn(3);
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
        indexValue.setFilterable(false);


        HtmlColumn version = row.getColumn(4);
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
        version.setFilterable(false);

        /*****************Add Version********************/
        HtmlColumn Version = row.getColumn(5);
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
        Version.setFilterable(false);
        /****************************************************/

        final String CONTEXT_PATH = request.getContextPath();

        HtmlColumn fileName = row.getColumn(6);
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
        fileName.setFilterable(false);

        HtmlColumn editFile = row.getColumn(7);
        editFile.setTitle("<font color=white>Document</font>");

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
        editFile.setFilterable(false);


        return tableModel.render();
    }


}
