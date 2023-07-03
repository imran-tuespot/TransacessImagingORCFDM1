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


public class DocType {
    public static void setTableProperties(TableModel tableModel) {
        
        tableModel.setStateAttr("restore");

        tableModel.setTable(getBasicHtmlTable());
    }
    
    public static Table getBasicHtmlTable() {
    	System.out.println("*** In get Document Type ****");
                
        HtmlTable table = new HtmlTable().caption("All Document Types").width("750px");

        HtmlRow row = new HtmlRow();
        table.setRow(row);        
                
        HtmlColumn documentType = new HtmlColumn("documentType").title("Document Type");      
      
       
        row.addColumn(documentType);               
        return table;
        
    }
}
