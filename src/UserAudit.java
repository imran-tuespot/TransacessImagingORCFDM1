import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Document;
import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.UserSession;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.SessionLogDAO;
import com.peniel.dao.UserSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: tsieland
 * Date: 12/8/11
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserAudit extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet  {
    private static final Logger logger = LoggerFactory.getLogger(UserAuditTrail.class);
    static final long serialVersionUID = 1L;

    private static final int BUFSIZE = 10240;

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

        String userid = "";
        String comid = "";
        String sessionid = (String) request.getSession().getAttribute("sessionid");

        SessionLogDAO sessionLogDAO = new SessionLogDAO();
        AppUserDAO appUserDAO = new AppUserDAO();

        SessionBean s = new SessionBean();
        int sid = s.checkSession(sessionid);
        logger.debug("In Get Files : Return value from checkSession " + sid);
        if (sid <= -1) {
            request.getSession().setAttribute("expired", "expired");
            (response.getWriter()).write("expired");
            logger.debug("In Get Files : Session Expired ");
            return;
        }

        UserSessionDAO userSessionDAO = new UserSessionDAO();
        Vector<UserSession> userSessionVector = userSessionDAO.findById(sessionid);
        if (userSessionVector.size() > 0) {
            UserSession us = userSessionVector.get(0);
            comid = "" + us.getCompanyId();
        }

        Vector<AppUser> appUserVector = appUserDAO.findByCompanyId(comid);

        request.setAttribute("userid", userid);
        request.setAttribute("comid", comid);
        request.setAttribute("sessionid", sessionid);
        request.setAttribute("appUserVector", appUserVector);

        response.setContentType( "application/pdf" );
        response.setHeader( "Content-Disposition", "attachment; filename=\"user_list.pdf\"" );

        buildPdfFile(request,response, appUserVector);
    }

    public void buildPdfFile( HttpServletRequest req, HttpServletResponse response, Vector<AppUser> appUserVector) {
        try {
            Document document = new Document(PageSize.LETTER.rotate());
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            PdfPTable table = new PdfPTable(7);

            table.addCell("Last Name");
            table.addCell("First Name");
            table.addCell("EMail Address");
            table.addCell("Phone");
            table.addCell("User Id");
            table.addCell("Role");
            table.addCell("Status");

            for (AppUser au : appUserVector) {
                table.addCell(au.getLastName());
                table.addCell(au.getFirstName());
                table.addCell(au.getEmail());
                table.addCell(au.getPhoneNo());
                table.addCell(au.getUsername());
                table.addCell(au.getRole());
                table.addCell(au.getStatus());
            }

            document.add(table);
            document.close();
        } catch (DocumentException de) {
            logger.error("Error during Conversion", de);
        } catch (Exception e) {

        }
    }
}
