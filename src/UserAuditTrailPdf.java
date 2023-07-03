import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.SearchData;
import com.peniel.bus.vo.SessionLogExtended;
import com.peniel.bus.vo.UserSession;
import com.peniel.dao.SessionLogDAO;
import com.peniel.dao.UserSessionDAO;
import org.jmesa.facade.TableFacade;
import org.jmesa.facade.TableFacadeFactory;
import org.jmesa.limit.Limit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: tsieland
 * Date: 12/10/11
 * Time: 5:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserAuditTrailPdf extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
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

        String comid = request.getParameter("comid");
        String sessionid = request.getParameter("sessionid");
        String typeVal = request.getParameter("type");
        int type = SessionLogDAO.UPDATE_RECORDS;

        String status = request.getParameter("status");

        Vector<SessionLogExtended> sessionLogList;
        SessionLogDAO sessionLogDAO = new SessionLogDAO();

        String startDateVal = request.getParameter("startDate");
        String endDateVal = request.getParameter("endDate");
        Date startDate = convertDate(startDateVal);
        Date endDate = convertDate(endDateVal);

        try {
            type = Integer.parseInt(typeVal);
        } catch (NumberFormatException e) {
            type = SessionLogDAO.UPDATE_RECORDS;
        }

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

                response.setContentType( "application/pdf" );
                response.setHeader( "Content-Disposition", "attachment; filename=\"audit_list.pdf\"" );

                buildPdfFile(request,response, sessionLogList);
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

    public void buildPdfFile( HttpServletRequest request, HttpServletResponse response, Vector<SessionLogExtended> sessionLogList) {
        String typeVal = request.getParameter("type");
        int type = SessionLogDAO.UPDATE_RECORDS;

        try {
            Document document = new Document(PageSize.LETTER.rotate());
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            PdfPTable table = new PdfPTable(7);

            try {
                type = Integer.parseInt(typeVal);
            } catch (NumberFormatException e) {
                type = SessionLogDAO.UPDATE_RECORDS;
            }

            table.addCell("Date");
            table.addCell("Name");
            table.addCell("Doc Id");
            table.addCell("Doc Typ");
            table.addCell("Field Modified");
            if (type == SessionLogDAO.UPDATE_RECORDS) {
                table.addCell("Old Value");
                table.addCell("New Value");
            }

            for (SessionLogExtended au : sessionLogList) {
                table.addCell(au.getDtm());
                table.addCell(au.getLastName() + ", " + au.getFirstName());
                table.addCell("" + au.getDocumentNumber());
                table.addCell(au.getDocumentType());
                table.addCell(au.getFieldName());
                if (type == SessionLogDAO.UPDATE_RECORDS) {
                    table.addCell(au.getOldValue());
                    table.addCell(au.getNewValue());
                }
            }

            document.add(table);
            document.close();
        } catch (DocumentException de) {
            logger.error("Error during Conversion", de);
        } catch (Exception e) {

        }
    }
}
