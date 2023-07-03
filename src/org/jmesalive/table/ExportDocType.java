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



public class ExportDocType {
    
    public static void setTableProperties(TableModel tableModel) {
        
        // Google App Engine (http://jmesa-live.appspot.com) does not support iText.jar, which is used for pdf export
         tableModel.setExportTypes(new ExportType[]{CSV, JEXCEL, PDFP});
        //tableModel.setExportTypes(new ExportType[]{CSV, JEXCEL});
        
        tableModel.setStateAttr("restore");

        if (tableModel.isExporting()) {
        	
        	tableModel.setTable(getBasicExportTable());
        } else {
            tableModel.setTable(DocType.getBasicHtmlTable());
        }
    }
    
    private static Table getBasicExportTable() {
    	Table table = new Table().caption("All Document Types");

        Row row = new Row();
        table.setRow(row);
                
        Column documentType = new Column("documentType").title("Document Type");
     

        row.addColumn(documentType);
                
        return table;    
    }
}
