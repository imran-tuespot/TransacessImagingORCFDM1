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

import static org.jmesa.limit.ExportType.CSV;
import static org.jmesa.limit.ExportType.JEXCEL;
import static org.jmesa.limit.ExportType.PDFP;

import org.jmesa.limit.ExportType;
import org.jmesa.model.TableModel;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Row;
import org.jmesa.view.component.Table;
import org.jmesa.view.pdf.PdfView;



public class BasicExportProperty {
    
    public static void setTableProperties(TableModel tableModel) {
        
        // Google App Engine (http://jmesa-live.appspot.com) does not support iText.jar, which is used for pdf export
         tableModel.setExportTypes(new ExportType[]{CSV, JEXCEL, PDFP});
        //tableModel.setExportTypes(new ExportType[]{CSV, JEXCEL});
        
        tableModel.setStateAttr("restore");

        if (tableModel.isExporting()) {
        	
        	tableModel.setTable(getBasicExportTable());
        } else {
            // reuse the table of BasicPresident
            tableModel.setTable(BasicProperty.getBasicHtmlTable());
        }
    }
    
    private static Table getBasicExportTable() {
    	Table table = new Table().caption("All Properties");

        Row row = new Row();
        table.setRow(row);
                
        Column propertyId = new Column("propertyId").title("Property Id");
        //Column fhaNum = new Column("fhaNum").title("FHA Number");
       // Column accExec = new Column("accountExec").title("Borrower Name");
        //Column workloadMgr = new Column("workloadMgr");
        //Column lenderNum = new Column("lenderNum");
        //Column lenderName = new Column("lenderName");
        //Column servicerNum = new Column("servicerNum");
        //Column servicerName = new Column("servicerName");
        Column propertyName = new Column("propertyName");
        Column city = new Column("city");
        Column state = new Column("state");
        Column zip = new Column("zip");
        //Column congressionalArea = new Column("congressionalArea");
      //  Column troubleCode = new Column("troubleCode");
       // Column reacScore = new Column("reacScore");
       // Column activeDeacAssignment = new Column("activeDeacAssignment");

        row.addColumn(propertyId);
        //row.addColumn(fhaNum);
        //row.addColumn(accExec);
       // row.addColumn(workloadMgr);
        //row.addColumn(lenderNum);
        row.addColumn(propertyName);
        
        //row.addColumn(lenderName);
        //row.addColumn(servicerNum);
        //row.addColumn(servicerName);
        row.addColumn(city);
        row.addColumn(state);
        row.addColumn(zip);
        //row.addColumn(congressionalArea);
        //row.addColumn(troubleCode);
        //row.addColumn(reacScore);
        //row.addColumn(activeDeacAssignment);

        
        return table;    
    }
}
