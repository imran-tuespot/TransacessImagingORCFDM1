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

import java.util.Date;

import org.jmesa.core.filter.DateFilterMatcher;
import org.jmesa.core.filter.MatcherKey;
import org.jmesa.model.TableModel;
import org.jmesa.view.component.Table;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;

import com.peniel.bus.vo.Property;


public class BasicProperty {
    public static void setTableProperties(TableModel tableModel) {
        
        tableModel.setStateAttr("restore");

        tableModel.setTable(getBasicHtmlTable());
    }
    
    public static Table getBasicHtmlTable() {
    	System.out.println("*** In getBasicHtmlTable ****");
                
        HtmlTable table = new HtmlTable().caption("All Properties").width("850px");

        HtmlRow row = new HtmlRow();
        table.setRow(row);
        
                
        HtmlColumn propertyId = new HtmlColumn("propertyId").title("Property Id");
        //HtmlColumn fhaNum = new HtmlColumn("fhaNum").title("FHA Number");
       /*
        HtmlColumn accExec = new HtmlColumn("accountExec").title("Borrower Name");
       // HtmlColumn workloadMgr = new HtmlColumn("workloadMgr");
        HtmlColumn lenderNum = new HtmlColumn("lenderNum");
        HtmlColumn lenderName = new HtmlColumn("lenderName");
        HtmlColumn servicerNum = new HtmlColumn("servicerNum").title("Form Num");
        HtmlColumn servicerName = new HtmlColumn("servicerName").title("Form Name");
        */
        HtmlColumn propertyName = new HtmlColumn("propertyName");
        HtmlColumn address = new HtmlColumn("city");
        address.width("250px");
        address.title("Address");
        address.setCellEditor(new CellEditor() {
            public Object getValue(Object item, String property, int rowcount) {
                Property propertyObj = (Property)item;
                HtmlBuilder html = new HtmlBuilder();
                String city = "";
                String state = "";
                String zip = "";
                
                if(propertyObj.getCity() != null){
                	//System.out.println("city-->"+propertyObj.getCity()+"<--");
                	city = propertyObj.getCity();
                }
                if(propertyObj.getState() != null){
                	//System.out.println("state-->"+propertyObj.getState()+"<--");
                	state = propertyObj.getState();
                }
                
                if(propertyObj.getZip() != null){
                	//System.out.println("zip-->"+propertyObj.getZip()+"<--");
                	zip = propertyObj.getZip();
                }
                
                
                html.append(city +" "+state + " "+zip);
                return html.toString();
            }
        });
        
        //HtmlColumn state = new HtmlColumn("state");
        //HtmlColumn zip = new HtmlColumn("zip");
        //HtmlColumn congressionalArea = new HtmlColumn("congressionalArea");
       // HtmlColumn troubleCode = new HtmlColumn("troubleCode");
       // HtmlColumn reacScore = new HtmlColumn("reacScore");
       // HtmlColumn activeDeacAssignment = new HtmlColumn("activeDeacAssignment");

        row.addColumn(propertyId);
        row.addColumn(propertyName);

        //row.addColumn(fhaNum);
        /*
        row.addColumn(accExec);
       // row.addColumn(workloadMgr);
        row.addColumn(lenderNum);
        
        row.addColumn(lenderName);
        row.addColumn(servicerNum);
        row.addColumn(servicerName);
        */
        row.addColumn(address);
        //row.addColumn(state);
        //row.addColumn(zip);
        //row.addColumn(congressionalArea);
       // row.addColumn(troubleCode);
       // row.addColumn(reacScore);
       // row.addColumn(activeDeacAssignment);
        
        return table;
        
    }
}
