/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmesalive.table;


import java.util.HashMap;
import java.util.Vector;

import org.jmesa.model.TableModel;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.worksheet.editor.CheckboxWorksheetEditor;
import org.jmesa.worksheet.editor.RemoveRowWorksheetEditor;

import com.peniel.bus.vo.DocumentData;
import com.peniel.bus.vo.Property;
import com.peniel.dao.DocumentDataDAO;


public class WorksheetProperty {

    public static void setTableProperties(TableModel tableModel, String sessionId,String contextPath) {
        tableModel.setTable(getWorksheetTable(sessionId,contextPath));
    }
    
	private static HtmlTable getWorksheetTable(String sessionId,String contextPath) {
		
		HtmlTable worksheetTable = new HtmlTable().caption("<p style='color:green;font-size:16px;padding-left: 0px; padding-top: 0px;'><i class='zmdi_large zmdi-file-text' style='color: green;'></i>Properties</p>" +
				"<input name='button2' id='button2' class='btn btn-success waves-effect waves-button waves-float' style='margin-left: 740px;margin-top:-20px;margin-bottom:5px;'  type='button' onclick=\"location.href='addProperty.jsp?sessionid=" +sessionId +"'\" value='Add Property'>").width("700px");

		// unique property to identify the row
		HtmlRow htmlRow = new HtmlRow().uniqueProperty("id");
		worksheetTable.setRow(htmlRow);

		final String sessionid = sessionId;
		final String CONTEXT_PATH = contextPath;
        // fluent columns
		HtmlColumn chkbox = new HtmlColumn("selected").title("Remove");
		chkbox.setWidth("30px");
		chkbox.setStyle("text-align:center");

		chkbox.filterable(false).sortable(false).editable(false);
		//chkbox.setWorksheetEditor(new CheckboxWorksheetEditor());
		
		chkbox.setCellEditor(new  CellEditor(){
			public Object getValue(Object arg0, String arg1, int arg2) {
				Property property = (Property)arg0;
				HtmlBuilder htmls = new HtmlBuilder();
				try{
					String sql = "SELECT PROPERTY_ID FROM DOCUMENT_DATA WHERE ";
	    			sql += " PROPERTY_ID = (SELECT ID FROM PROPERTY WHERE PROPERTY_ID = '"+property.getPropertyId()+"')  ";
	    			
	    			
	    			//System.out.println("sql -->"+sql);
	    			
	    			Vector<DocumentData> vDocData = new Vector<DocumentData>();
	    			
	    			DocumentDataDAO docDao = new DocumentDataDAO();
	    			vDocData = docDao.processSelectMulti(sql);
	    			String imgName = "removeImg"+property.getId();
	    			if(vDocData.size()>0){
	    				htmls.append("<img height=\"15\" src=\"" + CONTEXT_PATH + "/images/remove.png\" alt=\"Remove is disabled, as documents associated with property.\" disabled>");
	    				//htmls.append("<i style=\"color:#008000\" class=\"zmdi zmdi-delete\"></i>");		        		
					} else {
						String jsFunction = "javascript:removeProperty('"+property.getId()+"','"+sessionid+"');";
		        		htmls.a().href().quote().append(jsFunction).quote().close();
		        		htmls.append("<img height=\"15\" src=\"" + CONTEXT_PATH + "/images/remove.png\" alt=\"Remove property\" >");
	    				//htmls.append("<i style=\"color:#008000\" class=\"zmdi zmdi-delete\"></i>");
		        		htmls.aEnd();
					}
	    			
	    			
	                
					
				
				}catch(Exception e){
					
				}
				
		        return htmls.toString();
         }});	
		
		

		
		

		
		HtmlColumn edit = new HtmlColumn("edit").title("Edit");
		edit.setWidth("30px");
		edit.setStyle("text-align:center");
		edit.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		Property property =(Property)arg0;
        		       		
        		HtmlBuilder htmlB = new HtmlBuilder();
                
        		//String filePath = "abc.jsp?id="+property.getId()+"&sessionid="+sessionid;
        		
        		String filePath = property.getId()+","+sessionid;
        		String jsFunction = "javascript:getDetails('"+property.getId()+"','"+sessionid+"');";
        		
        		htmlB.a().href().quote().append(jsFunction).quote().close();
                //htmlB.append("<img height=\"15\" src=\"" + CONTEXT_PATH + "/images/edit.gif\" alt=\"Edit property\" >");
        		htmlB.append("<i class=\"zmdi zmdi-edit\"></i>");
                htmlB.aEnd();
                return htmlB.toString();
         }});
		
		edit.setTitle("<font color=white>Edit</font>");
		edit.setEditable(false);
		edit.setSortable(true);
		edit.setFilterable(false);
		
		//HtmlColumn id = new HtmlColumn("id").title("Id");
		//id.setEditable(false);
		
		HtmlColumn propertyId = new HtmlColumn("propertyId").title("Property Id");
		propertyId.setEditable(false);
		//propertyId.addWorksheetValidation(new WorksheetValidation(REQUIRED, TRUE).errorMessage("Property name is required."));
		
		HtmlColumn propertyName = new HtmlColumn("propertyName").title("Property Name");
		propertyName.setEditable(false);
		
		HtmlColumn city = new HtmlColumn("city").title("City");
		city.setEditable(false);
		
        HtmlColumn state = new HtmlColumn("state").title("State");
        state.setEditable(false);
        
        HtmlColumn zip = new HtmlColumn("zip").title("Zip");
        zip.setEditable(false);
        
        /*	
		HtmlColumn lenderNum = new HtmlColumn("lenderNum").title("Lender Number");
		HtmlColumn lenderName = new HtmlColumn("lenderName").title("Lender Name");
		HtmlColumn accExec = new HtmlColumn("accountExec").title("Account Exec");
        HtmlColumn workloadMgr = new HtmlColumn("workloadMgr").title("Workload Mgr");
        HtmlColumn servicerNum = new HtmlColumn("servicerNum").title("Servicer Num");
        HtmlColumn servicerName = new HtmlColumn("servicerName").title("Servicer Name");
        HtmlColumn congressionalArea = new HtmlColumn("congressionalArea").title("Congressional Area");
        HtmlColumn troubleCode = new HtmlColumn("troubleCode").title("Trouble Code");
        HtmlColumn reacScore = new HtmlColumn("reacScore").title("Reac Score");
        HtmlColumn activeDeacAssignment = new HtmlColumn("activeDeacAssignment").title("Active DeacAssignment");
		*/
		///
		
		
		htmlRow.addColumn(chkbox);
		htmlRow.addColumn(edit);
		htmlRow.addColumn(propertyId);
		htmlRow.addColumn(propertyName);
		htmlRow.addColumn(city);
		htmlRow.addColumn(state);
		htmlRow.addColumn(zip);
		/*
		htmlRow.addColumn(lenderNum);
		htmlRow.addColumn(lenderName);
		htmlRow.addColumn(accExec);
		htmlRow.addColumn(workloadMgr);
		htmlRow.addColumn(servicerNum);
		htmlRow.addColumn(servicerName);
		htmlRow.addColumn(congressionalArea);
		htmlRow.addColumn(troubleCode);
		htmlRow.addColumn(reacScore);
		htmlRow.addColumn(activeDeacAssignment);
		*/
		return worksheetTable;
	}
}