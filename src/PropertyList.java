import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.jmesa.model.TableModel;
import org.jmesa.worksheet.Worksheet;
import org.jmesa.worksheet.WorksheetCallbackHandler;
import org.jmesa.worksheet.WorksheetColumn;
import org.jmesa.worksheet.WorksheetRow;
import org.jmesa.worksheet.WorksheetRowStatus;
import org.jmesa.worksheet.WorksheetUtils;
import org.jmesa.worksheet.editor.CheckboxWorksheetEditor;
import org.jmesalive.table.WorksheetProperty;

import com.peniel.bus.vo.Property;
import com.peniel.dao.PropertyDAO;


public class PropertyList extends HttpServlet {
	
	private int companyId = 0;
	private String sessionId = "";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String type = request.getParameter("type");
	    String removeOption = request.getParameter("remove");
	    String id = request.getParameter("id");
	    sessionId= (String)request.getSession().getAttribute("sessionid");
	    
	    System.out.println("Inside PropertyList type = "+type);
	    if(removeOption != null){
		    if(removeOption.equals("yes")){
		    	PropertyDAO propDao = new PropertyDAO();
	        	propDao.deleteProperty(id);
		    }
	    }
	    String html = getTable(type, request, response); // set the Html in the request for the JSP
	    //System.out.println("html-----> "+html);
	    if (html == null) {
	        return;
	    }
	    request.setAttribute("propertyList", html);
	    	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("propertyList.jsp?sessionid="+sessionId);
	    dispatcher.forward(request, response);
	}

	public String getTable(String id, HttpServletRequest request, HttpServletResponse response) {
	  PropertyDAO propertyDao = new PropertyDAO();
	   companyId = (Integer)request.getSession().getAttribute("comid");
		
	   TableModel tableModel = new TableModel(id, request, response);
	   //tableModel.setEditable(true);
	    /*
		tableModel.saveWorksheet(new WorksheetSaver() {
            public void saveWorksheet(Worksheet worksheet) {
            	saveWorksheetChanges(worksheet);
            }
        });
		*/
	   /*
		tableModel.setItems(new AllItems() {
            public Collection<?> getItems() {
            	PropertyDAO propDAO = new PropertyDAO();
                return propDAO.getProperties(companyId);
            }
        });
		*/
	   
	   PropertyDAO propDAO = new PropertyDAO();
       Collection<Property> vc =  propDAO.getProperties(companyId);
       
        tableModel.setItems(vc);
		WorksheetProperty.setTableProperties(tableModel,sessionId, request.getContextPath());
		
		String html = tableModel.render();
		//System.out.println("html-->"+html+"<--");
		return html;
	}
	
	
	protected void saveWorksheetChanges(Worksheet worksheet) {
		System.out.println("******** in save ********");
		PropertyDAO propDao = new PropertyDAO();
		
		List<String> uniquePropertyValues = WorksheetUtils.getUniquePropertyValues(worksheet);
		
		final Map<String, Property> properties =
        		propDao.getPropertiesAsMap(uniquePropertyValues);

        worksheet.processRows(new WorksheetCallbackHandler() {
            public void process(WorksheetRow worksheetRow) {
            	
            	System.out.println("worksheetRow.getRowStatus()-->"+worksheetRow.getRowStatus());
            	
                if (worksheetRow.getRowStatus().equals(WorksheetRowStatus.ADD)) {
                    // would save the new Property here
                	
                	PropertyDAO propDao = new PropertyDAO();
                	propDao.insertNewProperty(companyId,worksheetRow);
                	
                } else if (worksheetRow.getRowStatus().equals(WorksheetRowStatus.REMOVE)) {
                    // would delete the Property here
                } else if (worksheetRow.getRowStatus().equals(WorksheetRowStatus.MODIFY)) {
                    Collection<WorksheetColumn> columns = worksheetRow.getColumns();
                    for (WorksheetColumn worksheetColumn : columns) {
                        String changedValue = worksheetColumn.getChangedValue();

                        validateColumn(worksheetColumn, changedValue);
                        if (worksheetColumn.hasError()) {
                            continue;
                        }

                        String uniqueValue = worksheetRow.getUniqueProperty().getValue();
                        //System.out.println("uniqueValue-->"+uniqueValue+"<--");
                        Property props = null;
                        props = properties.get(uniqueValue);
                        String property = worksheetColumn.getProperty();

                        try {
                            if (worksheetColumn.getProperty().equals("selected")) {
                            	
                            	if (changedValue.equals(CheckboxWorksheetEditor.CHECKED)) {
                            		PropertyUtils.setProperty(props, property, "y");
                                } else {
                                	PropertyUtils.setProperty(props, property, "n");
                                }

                            } else {
                            	PropertyUtils.setProperty(props, property, changedValue);
                            }
                        } catch (Exception ex) {
                            String msg = "Not able to set the property [" + property + "] when saving worksheet.";
                            throw new RuntimeException(msg);
                        }
                        
                        PropertyDAO propsDao = new PropertyDAO();	
                        propsDao.updateProperty(props);
                    }
                }
            }
        });
	
   }
	
	
	private void validateColumn(WorksheetColumn worksheetColumn, String changedValue) {
		if (changedValue.equals("foo")) {
        	worksheetColumn.setErrorKey("foo.error");
        } else {
        	worksheetColumn.removeError();
        }
    }
    
   
    
    
}