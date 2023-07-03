import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmesa.model.TableModel;
import org.jmesalive.table.ExportDocType;

import com.peniel.bus.vo.DocumentType;
import com.peniel.dao.DocumentTypeDAO;


public class NewDocTypeController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String type = request.getParameter("type");
		//String type = "worksheet";
	    String html = getTable(type, request, response); // set the Html in the request for the JSP
	    if (html == null) {
	        return;
	    }
	    request.setAttribute("presidents", html);
	    
    	String sessionId= (String)request.getSession().getAttribute("sessionid");

	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("worksheet.jsp?sessionid="+sessionId);
	    dispatcher.forward(request, response);
	}

	public String getTable(String id, HttpServletRequest request, HttpServletResponse response) {
	  /* PresidentDao presidentDao = new PresidentDao(new HttpServletRequestWebContext(request));
		
		// respose is required for export
	    TableModel tableModel = new TableModel(id, request, response);
	    tableModel.setItems(presidentDao.getPresidents());
	    
		WorksheetSaverImpl worksheetSaver = null;
	    
		if (id.equals("simplest")) {
			SimplestPresident.setTableProperties(tableModel);
		} else if (id.equals("basic")) {
			BasicPresident.setTableProperties(tableModel);
		} else if (id.equals("basicExport")) {
			BasicExportPresident.setTableProperties(tableModel);
		} else if (id.equals("worksheet")) {
			worksheetSaver = new WorksheetSaverImpl(presidentDao);
			
            tableModel.saveWorksheet(worksheetSaver);
            tableModel.addRowObject(PresidentDao.getNewPresident());
            
			WorksheetPresident.setTableProperties(tableModel);
		}
		
		// this will do all the work behind the scenes (e.g., save worksheet, add row object, render etc)
		String html = tableModel.render();
		
		if (id.equals("worksheet")) {
    		// it has be called after render
    		request.setAttribute("saveResults", worksheetSaver.getSaveResults());
		}
		
		return html;
		*/
		
		
		
		int companyId = (Integer)request.getSession().getAttribute("comid");
		Collection<DocumentType> documentTypes = null;
		DocumentTypeDAO documentTypeDao = new DocumentTypeDAO();
		
		if (request.getSession().getAttribute("documentTypesCollection") != null) {
			documentTypes = (List<DocumentType>)request.getSession().getAttribute("documentTypesCollection");
    	}
    	
    	if (documentTypes == null) {
    		documentTypes = documentTypeDao.getDocumentTypes(companyId);
        }
		
    	request.getSession().setAttribute("documentTypesCollection", documentTypes);
        request.getSession().setAttribute("lastId", documentTypes.size());
        
        // respose is required for export
	    TableModel tableModel = new TableModel(id, request, response);
	    tableModel.setItems(documentTypes);
	    
		ExportDocType.setTableProperties(tableModel);
		 
		String html = tableModel.render();
		
		return html;

	}
}