import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.*;
import com.peniel.dao.*;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

/**
 * User: todds
 * Date: 11/17/11
 * Time: 1:15 AM
 */
public class DocDownloadFile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    private static Logger logger = LogManager.getLogger(DocDownloadSearchGrid.class);

    private String userName = "";
    private static int count = 0; // increments the sh filename so we can handle mulitple requests from the same person


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
        String userId = request.getParameter("userid");
        String compId = request.getParameter("compid");
        String sessionId = request.getParameter("sessionid");
        String orderBy = request.getParameter("orderby");
        String ipaddress;

        //Timestamp
        AppUser user = null;

        SessionBean s = new SessionBean();

        int id = s.checkSession(sessionId);
        if ( id <= -1) {

            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setContentType("text/html");
            (response.getWriter()).write("<table align='center'><tr><td><font size=8 color=red>Session Expired. Please Login again.</font></td></tr></table>");
            logger.info("Session expired");

        }  else {
            Timestamp ts = new Timestamp((new Date()).getTime());

            String newSessionId = s.getNewSessionId(userId);
            //s.insertSessionString(newSessionId, ts, userId, int flag, String userName, long companyId, String ipAddress)
            UserSessionDAO userSessionDAO = new UserSessionDAO();

            ipaddress = request.getRemoteAddr();

            UserSession userSession = userSessionDAO.insertIntoUserSession(userId, null, "name", compId, ipaddress);

            AppUserDAO appUserDAO = new AppUserDAO();
            Vector<AppUser> users = appUserDAO.findByUserId(userId);
            if (users.size() > 0) {
                user = users.get(0);
            }

            Cookie[] cookies = request.getCookies();
            Cookie cookie = null;
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("SELECTED_DOCUMENTS")) {
                    cookie = cookies[i];
                }
            }
            // at this point the values selected should be in an array
            if (cookie != null) {
            	buildOutputFile(compId, user, cookie.getValue(), sessionId);
            }
        }
    }

    public void buildOutputFile(String compId, AppUser userId, String cookieValue, String sessionId) {
        String tempDir = getTempDirectory();
        String url = getUrl();
        int localCount = ++count; // does not have to be too accurate because this only is for 1 user requesting 2 downloads
        
        String[] values = null;
        if (cookieValue != null) {
            values = StringUtils.split(cookieValue, '-');
        }
        if (values != null) {
            String shellFileName = userId.getUserId() + "-" + localCount + "-Downloads.sh";
            String mailFileName = userId.getUserId() + "-" + localCount + "-Downloads.email.txt";
            String indexFileName = userId.getUserId() + "-" + localCount + "-Downloads.index.dat";
            String zipFileName = sessionId + ".zip";

            File outFile = new File(tempDir + File.separator + shellFileName);
            BufferedWriter bw = null;
            File indexFile = new File(tempDir + File.separator + userId.getUserId() + "-" + localCount + "-Downloads.index.dat");
            BufferedWriter indexFileBw = null;

            
            try {
                bw = new BufferedWriter(new FileWriter(outFile));
                indexFileBw = new BufferedWriter(new FileWriter(indexFile));

                // header line for the index file
                indexFileBw.write("Document Name,Document Type,Project Number");
                indexFileBw.newLine();

                // bash script file
                bw.write("#!/bin/bash \n");
                bw.write("# Email This person \n");
                bw.write("EMAIL_ADDRESS=\"" + userId.getEmail() + "\"\n");
                bw.write("USER_ID=\"" + userId.getUserId() + "\"\n");
                bw.write("\n");
                bw.write("# src and destination dir\n");
                bw.write("DISK_DIR=\"" + this.getServletContext().getRealPath("WEB-INF/diskimage") + "\"\n");
                bw.write("SRC_DIR=\"" + getDestinationBaseDirectory() + "\"\n");
                bw.write("DEST_DIR=\"" + getTempDirectory() + File.separator + userId.getUserId() + "\"\n");
                bw.write("FINAL_DEST_DIR=\"" + getDestinationBaseDirectory() + getFinalDownloadDir() + "\"\n");
                bw.write("FINAL_FILENAME=\"" + zipFileName + "\"\n");
                bw.write("\n");
                bw.write("# Files to copy\n");
                //bw.write("FILES_TO_COPY=\"" + buildFileList(compId, values) + "\" \n");
                //bw.write("\n");
                bw.write("SESSION_ID=\"" + sessionId + "\" \n");
                bw.write("mkdir $DEST_DIR\n");
                bw.write("mkdir $DEST_DIR/files\n");
                bw.write("rm -f $DEST_DIR/files/*.pdf\n");
                bw.write("cp $DISK_DIR/* $DEST_DIR/\n");
                bw.write("mv " + tempDir + File.separator + indexFileName + " $DEST_DIR/index.dat\n");
                bw.write("\n# main logic to copy the files to the dir\n");

                writeFileValue(bw, indexFileBw, values, compId,
                        tempDir + File.separator + userId.getUserId() + File.separator);
                //return bw.toString();

                bw.write("\n# add in the basic files\n");
                bw.write("# cleanup logic\n");
                bw.write("cd $DEST_DIR\n");
                bw.write("rm $FINAL_DEST_DIR/" + zipFileName + " \n");
                bw.write("zip -r $FINAL_DEST_DIR/" + zipFileName  + " . \n");

                bw.write("#rm ./files/* \n");
                bw.write("cd -\n");
                bw.write("# rm " + shellFileName + "\n\n");
                bw.write("#email the person \n");
                bw.write("mail -s \"Download is ready\" $EMAIL_ADDRESS <" + tempDir + File.separator + mailFileName + "\n");
                bw.write("mkdir "   + tempDir + File.separator + "downloadsprocessed\n");
                bw.write("mv "  + tempDir + File.separator + mailFileName + " " +
                        tempDir + File.separator + "downloadsprocessed" + File.separator + "\n");
                bw.write("mv "  + tempDir + File.separator + shellFileName + " " +
                        tempDir + File.separator + "downloadsprocessed" + File.separator + "\n");
                bw.write("mv "  + tempDir + File.separator + indexFileName + " " +
                        tempDir + File.separator + "downloadsprocessed" + File.separator + "\n");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("should not end up here. Doc download file");
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                        outFile.setExecutable(true);
                    }
                } catch (IOException ee) {

                }
                try {
                    if (indexFileBw != null)
                        indexFileBw.close();
                } catch (IOException ee) {

                }
            }
            buildEmail(url, getTempDirectory(), userId, sessionId, localCount);
        }
        //return "";
    }

    public void buildEmail(String url, String tempDir, AppUser user, String session, int localCount) {
        File emailInFile = new File(this.getServletContext().getRealPath("WEB-INF") + "/DownloadEmail.txt");
        BufferedReader bwIn = null;
        String mailFileName = user.getUserId() + "-" + localCount + "-Downloads.email.txt";
        File outFile = new File(tempDir + File.separator + mailFileName);
        BufferedWriter bwOut = null;

        try {
            bwIn = new BufferedReader(new FileReader(emailInFile));
            bwOut = new BufferedWriter(new FileWriter(outFile));

            String buffer;
            while (bwIn.ready()) {
                buffer = bwIn.readLine();
                if (buffer.startsWith("#"))
                    continue;
                if (buffer.contains("${session}")) {
                    buffer = StringUtils.replace(buffer, "${session}", session);
                }
                if (buffer.contains("${firstName}")) {
                    buffer = StringUtils.replace(buffer, "${firstName}", user.getFirstName());
                }
                if (buffer.contains("${lastName}")) {
                    buffer = StringUtils.replace(buffer, "${lastName}", user.getLastName());
                }
                if (buffer.contains("${dir}")) {
                    buffer = StringUtils.replace(buffer, "${dir}", tempDir);
                }
                if (buffer.contains("${URL}")) {
                    buffer = StringUtils.replace(buffer, "${URL}", url);
                }
                if (buffer.contains("${userid}")) {
                    buffer = StringUtils.replace(buffer, "${userid}", "" + user.getUserId());
                }
                bwOut.write(buffer);
                bwOut.newLine();
            }
            bwOut.write("Your download is ready to pick up. ");
        } catch (IOException e) {
            System.out.println("should not end up here. Doc download file");
        } finally {
            try {
                if (bwIn != null)
                    bwIn.close();
            } catch (IOException ee) {

            }
            try {
                if (bwOut != null)
                    bwOut.close();
            } catch (IOException ee) {

            }
        }
    }

    public void writeFileValue(BufferedWriter shell, BufferedWriter dat, String[] values, String compId, String baseTemp)
            throws IOException {
        String tempDir = getTempDirectory();
        Long companyId = new Long(compId);
        Long indexType = 1L;

        SearchDataDAO searchDataDAO = new SearchDataDAO();
        DocumentDataDAO documentDataDAO = new DocumentDataDAO();
        DocumentTypeDAO documentTypeDAO = new DocumentTypeDAO();

        for (String value : values) {
            Vector<DocumentData> data = documentDataDAO.findByDocumentId(value);
            if (data != null && data.size() > 0) {
                DocumentData dd = data.get(0);
                Vector<SearchData> searchDataVector = searchDataDAO.findByDocId(dd.getDocumentId());
                String fileId = "";
                String documentType = "";

                for (SearchData sd : searchDataVector) {
                    if (sd.getCompanyId() == companyId) {
                        if (sd.getIndexTypeId() == indexType) {
                            fileId = sd.getIndexData();
                        }
                    }
                }

                Vector<DocumentType> documentTypeVector = documentTypeDAO.findByDocumentTypeId("" + dd.getDocumentTypeId());
                for (DocumentType documentTypeVal : documentTypeVector) {
                    documentType = documentTypeVal.getDocumentType();
                }

                String[] file = dd.getFilename().split("/");
                String baseFileName = file[file.length - 1];
                dat.write("./files/" + baseFileName + "," + documentType + "," + fileId + "\n");

                shell.write("cp $SRC_DIR/" + dd.getFilename() + " $DEST_DIR/files/" + baseFileName + "\n");
            }
        }
    }

    public String getDestinationBaseDirectory() {
        return  this.getServletContext().getRealPath("scaimages");
    }

    public String getFinalDownloadDir() {
        try {
            return getFromEnv("finalDownloadDir");
        } catch (NamingException e) {
            return null;
        }
    }

    public String getTempDirectory() {
        try {
            return getFromEnv("converterTempDirectory");
        } catch (NamingException e) {
            return null;
        }
    }

    public String getUrl() {
        try {
            return getFromEnv("URL");
        } catch (NamingException e) {
            return null;
        }
    }

    public String getFromEnv(String val) throws NamingException {
        javax.naming.Context ctx = new javax.naming.InitialContext();
        return (String) ctx.lookup("java:comp/env/" + val);
    }

}
