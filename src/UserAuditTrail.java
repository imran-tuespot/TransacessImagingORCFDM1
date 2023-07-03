import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmesa.facade.TableFacade;
import org.jmesa.facade.TableFacadeFactory;
import org.jmesa.limit.Limit;
import org.jmesa.model.TableModel;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;


import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.SearchData;
import com.peniel.bus.vo.SessionLog;
import com.peniel.bus.vo.SessionLogExtended;
import com.peniel.bus.vo.UserSession;
import com.peniel.dao.SessionLogDAO;
import com.peniel.dao.UserSessionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * User: todds
 * Date: 11/27/11
 * Time: 4:51 PM
 */
public class UserAuditTrail extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    private static final Logger LOGGER = LogManager.getLogger(UserAuditTrail.class);
    static final long serialVersionUID = 1L;

    private static Logger logger = LogManager.getLogger(DocMgmtSearchGrid.class);

    private String userName = "";

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

        String id = "formId";

        String userid = request.getParameter("userid");
        String comid = request.getParameter("comid");
        String sessionid = request.getParameter("sessionid");
        String docId = request.getParameter("docId");
        String typeVal = request.getParameter("type");
        int type = SessionLogDAO.UPDATE_RECORDS;

        String status = request.getParameter("status");

        Vector sessionLog;
        Vector<SessionLogExtended> sessionLogList;
        SearchData searchData = null;
        SessionLogDAO sessionLogDAO = new SessionLogDAO();

        try {
            type = Integer.parseInt(typeVal);
        } catch (NumberFormatException e) {
            type = SessionLogDAO.UPDATE_RECORDS;
        }

        String startDateVal = request.getParameter("startDate");
        String endDateVal = request.getParameter("endDate");
        Date startDate = convertDate(startDateVal);
        Date endDate = convertDate(endDateVal);

        SessionBean s = new SessionBean();
        int sid = s.checkSession(sessionid);
        logger.debug("In Get Files : Return value from checkSession " + sid);
        if (sid <= -1) {
            request.getSession().setAttribute("expired", "expired");
            (response.getWriter()).write("expired");
            logger.debug("In Get Files : Session Expired ");
        } else {
            UserSessionDAO userSessionDAO = new UserSessionDAO();
            Vector<UserSession> userSessionVector = userSessionDAO.findById(sessionid);
            if (userSessionVector.size() > 0) {
                UserSession us = userSessionVector.get(0);
                comid = "" + us.getCompanyId();
            }
            try {
                // Audit Trail
                sessionLogList = sessionLogDAO.getTimedSessionLog(type, startDate, endDate, comid);

                request.setAttribute("sessionLogList", sessionLogList);
                request.setAttribute("startDate", startDateVal);
                request.setAttribute("endDate", endDateVal);

               // TableFacade tableFacade = TableFacadeFactory.createTableFacade(id, request);
                
            	TableModel tableModel = new TableModel(id, request, response);

            /*    if (type == SessionLogDAO.NEW_RECORDS) {
                    tableFacade.setColumnProperties("Date", "Name", "Doc Id", "Doc Type", "Field Modified");
                } else {
                    tableFacade.setColumnProperties("Date", "Name", "Doc Id", "Doc Type", "Field Modified", "Old Value", "New Value");
                }*/
            	
                tableModel.setItems(sessionLogList);
            	tableModel.setTable(getRenderedHTML(tableModel, request, userid, comid, sessionid, userName));
    			

               // Limit limit = tableFacade.getLimit();
                tableModel.setView(new CustomView());
                String html =tableModel.render() ;
                (response.getWriter()).write(html);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date convertDate(String v) {
        Date date;
        try {
            DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            date = df.parse(v);
            return date;
        } catch (ParseException e) {

        }
        try {
            DateFormat df = new SimpleDateFormat("dd-MM-yy");
            date = df.parse(v);
            return date;
        } catch (ParseException e) {

        }
        return null;
    }

    public HtmlTable getRenderedHTML(TableModel tableModel, HttpServletRequest request, String userid, String compid, String sessionid, String username) {

        String typeVal = request.getParameter("type");
        Integer type = SessionLogDAO.UPDATE_RECORDS;
        try {
            type = Integer.parseInt(typeVal);
        } catch (NumberFormatException e) {
            type = SessionLogDAO.UPDATE_RECORDS;
        }

     //   HtmlTable table = (HtmlTable) tableModel.
     //   table.getTableRenderer().setWidth("100%");
     //   table.setCaption("Your Search Results");
        
        
        HtmlTable table = new HtmlTable();
       table.setCaption("Your Search Results");
       
       HtmlRow row = new HtmlRow().uniqueProperty("id");
   	    table.setRow(row);
		
      // HtmlRow row = table.getRow();
   	    
   		
		HtmlColumn indexDate = new HtmlColumn("indexDate");
		indexDate.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		  SessionLog searchDataObj1 = (SessionLog) arg0;
        	      return searchDataObj1.getDtm();
         }});
		 indexDate.setTitle("<font color=white>Date</font>");
	        indexDate.setEditable(false);
	        indexDate.setSortable(false);
	        indexDate.setFilterable(false);
		
		row.addColumn(indexDate);
		
		HtmlColumn indexName = new HtmlColumn("indexName");
		indexName.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {        		

                SessionLog searchDataObj1 = (SessionLog) arg0;
                return searchDataObj1.getLastName() + ", " + searchDataObj1.getFirstName();
         }});
		indexName.setTitle("<a href=javascript:sortby(\'document_type\')><font color=white>Type</font></a>");
        indexName.setTitle("<font color=white>Name</font>");
        indexName.setEditable(false);
		  indexName.setSortable(true);
		  indexName.setFilterable(false);
		
		row.addColumn(indexName);
		
		
		
		HtmlColumn indexDocId = new HtmlColumn("indexDocId");
		indexDocId.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {        		

        		SessionLogExtended searchDataObj1 = (SessionLogExtended) arg0;
                return searchDataObj1.getDocumentNumber();
         }});
        indexDocId.setTitle("<a href=javascript:sortby(\'index_type\')><font color=white>Index Type</font></a>");
        indexDocId.setTitle("<font color=white>Doc Id</font>");
		indexDocId.setEditable(false);
		indexDocId.setSortable(true);
		indexDocId.setFilterable(false);
		
		row.addColumn(indexDocId);
		
		
		HtmlColumn indexDocType = new HtmlColumn("indexDocType");
		indexDocType.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {        		

        		SessionLogExtended searchDataObj1 = (SessionLogExtended) arg0;
                return searchDataObj1.getDocumentType();
         }});
		indexDocType.setTitle("<a href=javascript:sortby(\'index_data\')><font color=white>Value</font></a>");
        indexDocType.setTitle("<font color=white>Doc Type</font>");
		indexDocType.setEditable(false);
		indexDocType.setSortable(true);
		indexDocType.setFilterable(false);
		
		row.addColumn(indexDocType);
		
		HtmlColumn indexFieldName = new HtmlColumn("indexFieldName");
		indexFieldName.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {        		

        		   SessionLog searchDataObj1 = (SessionLog) arg0;
                   return searchDataObj1.getFieldName();
         }});
		indexFieldName.setTitle("<a href=javascript:sortby(\'index_data\')><font color=white>Value</font></a>");
        indexFieldName.setTitle("<font color=white>Field Name</font>");
		indexFieldName.setEditable(false);
		indexFieldName.setSortable(true);
		indexFieldName.setFilterable(false);
		
		row.addColumn(indexFieldName);

		   if ( type == SessionLogDAO.UPDATE_RECORDS) {
	            HtmlColumn indexOldValue = new HtmlColumn("indexOldValue");
	            indexOldValue.setCellEditor(new  CellEditor(){

	                public Object getValue(Object arg0, String arg1, int arg2) {

	                    SessionLog searchDataObj1 = (SessionLog) arg0;
	                    return searchDataObj1.getOldValue();
	                }
	            });
	            //indexOldValue.setTitle("<a href=javascript:sortby(\'index_data\')><font color=white>Value</font></a>");
	            indexOldValue.setTitle("<font color=white>Old Value</font>");
	            indexOldValue.setEditable(false);
	            indexOldValue.setSortable(true);
	            indexOldValue.setFilterable(false);
	            
	            row.addColumn(indexOldValue);

	            HtmlColumn indexNewValue = new HtmlColumn("indexNewValue");
	            indexNewValue.setCellEditor(new  CellEditor(){

	                public Object getValue(Object arg0, String arg1, int arg2) {

	                    SessionLog searchDataObj1 = (SessionLog) arg0;
	                    return searchDataObj1.getNewValue();
	                }
	            });
	            //indexNewValue.setTitle("<a href=javascript:sortby(\'index_data\')><font color=white>Value</font></a>");
	            indexNewValue.setTitle("<font color=white>New Value</font>");
	            indexNewValue.setEditable(false);
	            indexNewValue.setSortable(true);
	            indexNewValue.setFilterable(false);
	            
	            row.addColumn(indexNewValue);
	        }


        return  table;
    }

}
