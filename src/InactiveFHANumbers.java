
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jmesa.model.TableModel;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;

import com.peniel.bus.vo.SearchDataObj;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.dao.SearchDataDAO;
import com.peniel.utilities.ParseMultiForm;


public class InactiveFHANumbers extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   private static Logger logger = LogManager.getLogger(InactiveFHANumbers.class);
     /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public InactiveFHANumbers() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String sessionid = (String)request.getParameter("sessionid");
		String userid = (String)request.getParameter("userid");
		String cid = (String)request.getParameter("cid");
		String userName = (String)request.getParameter("userName");
		String confirmedFHANumbers = "";
		
				String sqlstr = "";
				
				String strResponse ="";
				
				try {
					String fhaNumbers = "";
					ParseMultiForm pMF = new ParseMultiForm( request );
			        String param;
			        StringBuffer g = new StringBuffer( strResponse );
			        SearchDataDAO searchDataDAO = new SearchDataDAO();
			        DocumentDataDAO docDataDAO = new DocumentDataDAO();
			        
			        while ( (param = pMF.getNextParameter(g)) != null ){
			        	  
			              if ("file".equals(param) ) {
			            	  	
				                String infile=pMF.getFilename();
				                
				                
				                if (infile!=null){
				                	
				                      try{
				                    	  
				                    	  	                    	  
				                    	  String outfilename=this.getServletContext().getRealPath("/csvdump/") + infile ; 
								           System.out.println("**** outfilename ---->"+outfilename+"<--")  ;
								           
					                      strResponse=strResponse+" +++Uploading "+infile;
							
							              strResponse=strResponse+" +++Uploaded to "+outfilename; 
														              	
						                  FileOutputStream OutFile = new FileOutputStream( outfilename  );
						
						                  pMF.getParameter( OutFile );
						
						                  OutFile.close();
						                  
				                    	  //create BufferedReader to read csv file			
				                    	  BufferedReader br = new BufferedReader( new FileReader(outfilename));			
				                    	  String strLine = "";			
				                    	  StringTokenizer st = null;			
				                    	  int lineNumber = 0, tokenNumber = 0; 			
				                    	  //read comma separated file line by line			
				                    	  while( (strLine = br.readLine()) != null)			{				
				                    		  lineNumber++; 				//break comma separated line using ","				
				                    		  st = new StringTokenizer(strLine, ","); 				
				                    		  while(st.hasMoreTokens())				{					
				                    			  //display csv values					
				                    			  tokenNumber++;					
				                    			  	
				                    			  fhaNumbers += ""+st.nextToken().trim()+",";
				                    		  } 				
				                    		  //reset token number				
				                    		  tokenNumber = 0; 
				                    		  
				                    		  System.out.println("fhaNumbers from file upload -->"+fhaNumbers);
				                    	  }
				                    } catch (Exception e) {
				      					// TODO Auto-generated catch block
				                    	  
				      					e.printStackTrace();
				      					System.out.println("error in reading csv -->"+e.getMessage());
				      				}   
				                }
	
				                
			              }
			              else{
			            	  String k=param;
			            		
				                String v="";
				
				                if (k.equalsIgnoreCase("message")){
				                      v=pMF.getMessage();
				                }
				                else{
				
					                 v=pMF.getParameter();
					                 
					                 if("sessionid".equals(k)) sessionid = v;
					                 
					                 if("cid".equals(k)) cid = v;
					                 
					                 if("fhaNumbers".equals(k)) confirmedFHANumbers = v;
					                 
					                 System.out.println("fhaNumbers from submit -->"+confirmedFHANumbers);
				                }     
			            	  
			              }
				              
				              
				    }
			        
			        
			        System.out.println("confirmedFHANumbers-->"+confirmedFHANumbers+"<---");
			        
			        if(confirmedFHANumbers != null && !"null".equals(confirmedFHANumbers) && !"".equals(confirmedFHANumbers)){
			        	System.out.println("*** 1 ****"+confirmedFHANumbers+"<---");
			        	
			        	fhaNumbers = confirmedFHANumbers;
			        } else {
			        	
			        	System.out.println("*** 2 ****"+fhaNumbers+"<---");
			        	
			        	fhaNumbers = fhaNumbers.substring(0, fhaNumbers.lastIndexOf(","));
			        }
			        			        
					
					String indexData = "";
					String successMsg = "";
					
					StringTokenizer st = new StringTokenizer(fhaNumbers, ",");
					while(st.hasMoreTokens()){
						indexData+= "'"+st.nextToken()+"',";
					}
					
					indexData = indexData.substring(0, indexData.lastIndexOf(","));
					
					
					if(confirmedFHANumbers != null && !"null".equals(confirmedFHANumbers) && !"".equals(confirmedFHANumbers)){
						System.out.println("*** 3 ****"+confirmedFHANumbers+"<---");	        	
				        // Document status is changed to "Inactive"
						// Multiply all versions by (-1) And add (-999) to version (0)
						int newVersion = 0;
						String indexValue =  "";
						StringTokenizer dc = new StringTokenizer(confirmedFHANumbers, ",");
						while(dc.hasMoreTokens()){ 
						
						    newVersion = -1;
						    indexValue = dc.nextToken();
						    
						    sqlstr = "select document_id, document_type_id, version from document_data WHERE DOCUMENT_ID in (select document_id from search_data where index_data = '"+indexValue+"') and version != '-999' ";
						    Vector vcDocId = searchDataDAO.findByQuery(sqlstr, "docMgmt");
						    
						    for(int k=0; k < vcDocId.size(); k++){
						    	SearchDataObj sd = (SearchDataObj) vcDocId.get(k);
						    	
						    	System.out.println("*** 4 ****"+sd.getDocId()+"<---");
						    	docDataDAO.inactivateDocVersion(sd.getDocId()+"", sessionid, newVersion);
						    	
						    }
						} 	
						
						successMsg = "Yes";
					
					}
					
					
	    			sqlstr = "";
					//////////////////////////
					
					
					sqlstr = "select ";
	                sqlstr += "a.filename fileName,e.folder_name, ";
	                sqlstr += "b.document_type document_type, ";
	                sqlstr += "c.index_type index_type, ";
	                sqlstr += "d.index_data value, ";
	                sqlstr += "a.version version, ";
	                sqlstr += "a.document_id document_id, ";
	                sqlstr += "c.index_type_id index_type_id, ";
	                sqlstr += "a.document_type_id document_type_id ";
	                sqlstr += "from ";
	                
	                sqlstr += "document_data a , ";
	                sqlstr += "document_type b, ";
	                sqlstr += "index_type c, ";
	                sqlstr += "search_data d, ";
	                sqlstr += "folders e ";
	                sqlstr += "where ";
	                
	                sqlstr += "a.document_type_id=b.document_type_id and ";
	                sqlstr += "d.index_type_id = c.index_type_id and ";
	                sqlstr += "a.document_id = d.document_id and ";
	                sqlstr += "a.folder_id = e.folder_id ";
	                sqlstr += " and d.index_data in ("+indexData+") ";
	                
	                sqlstr += " and a.company_id='" + cid + "' ";
	                sqlstr += " and a.version != '-999' ";
	                sqlstr += "  order by index_data ";
	                
	
	                logger.info(" : query : " + sqlstr);
					
					
	                TableModel tableModel = new TableModel("formId", request, response);
					
	               // final String sql = sqlstr;
	                
	                
        			 Vector vc = searchDataDAO.findByQuery(sqlstr, "docMgmt");
	                
	         		System.out.println("vc size -->"+vc.size());
        			 
        			 tableModel.setItems(vc);
	         		

	                tableModel.setTable(getRenderedHTML(request, userid, cid, sessionid, userName));
	                
	                String html = tableModel.render();
	                
	               // System.out.println("html-->"+html);
        
	                request.setAttribute("fhaNumbers", fhaNumbers);
	                
	                request.setAttribute("resultSize", vc.size());
	                
	                if(!"null".equals(successMsg) && !"".equals(successMsg)) request.setAttribute("successMsg", successMsg);
	                
	                request.setAttribute("htmlResult", html);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("inactiveFHANumbers.jsp");
					
					dispatcher.forward(request, response);
	                
				}  catch (Exception e) {
					e.printStackTrace();
					
				} 
				
		
	}   	
public HtmlTable getRenderedHTML(HttpServletRequest request,String userid, String compid, String sessionid, String username){
		
		HtmlTable worksheetTable = new HtmlTable().caption("Uploaded File Document List").width("700px");

		// unique property to identify the row
		HtmlRow row = new HtmlRow().uniqueProperty("documentId");
		worksheetTable.setRow(row);
		
		
		HtmlColumn docType = new HtmlColumn("documentType");
		docType.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		SearchDataObj searchDataObj1=(SearchDataObj)arg0;
        		return searchDataObj1.getDocumentType();
         }});
		//docType.setTitle("<a href=javascript:sortby(\'document_type\')><font color=white>Type</font></a>");
		docType.setTitle("<font color=white>Document Type</font>");
		docType.setEditable(false);
		docType.setSortable(true);
		docType.setFilterable(true);
		
		row.addColumn(docType);
		
		HtmlColumn indexType = new HtmlColumn("indexType");
		
		indexType.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		SearchDataObj searchDataObj1=(SearchDataObj)arg0;
        		return searchDataObj1.getIndexType();
         }});
		//indexType.setTitle("<a href=javascript:sortby(\'index_type\')><font color=white>Index Type</font></a>");
		indexType.setTitle("<font color=white>Index Type</font>");
		indexType.setEditable(false);
		indexType.setSortable(true);
		indexType.setFilterable(true);
		
		row.addColumn(indexType);
		
		HtmlColumn indexValue = new HtmlColumn("indexValue");
		indexValue.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		SearchDataObj searchDataObj1=(SearchDataObj)arg0;
        		return searchDataObj1.getIndexValue();
         }});
		//indexValue.setTitle("<a href=javascript:sortby(\'index_data\')><font color=white>Value</font></a>");
		indexValue.setTitle("<font color=white>Value</font>");
		indexValue.setEditable(false);
		indexValue.setSortable(true);
		indexValue.setFilterable(true);

		row.addColumn(indexValue);
			
		/*****************Add Version********************/
		HtmlColumn Version = new HtmlColumn("version");
		Version.setCellEditor(new  CellEditor(){

        	public Object getValue(Object arg0, String arg1, int arg2) {
        		
        		SearchDataObj searchDataObj1=(SearchDataObj)arg0;
        		        		        		
        		if(searchDataObj1.getVersion() >= 0){
        			return "Active";
        		} else {
        			return "Inactive";
        		}
        		
        		 
        		
         }});
		//Version.setTitle("<a href=javascript:sortby(\'version\')><font color=white>Version</font></a>");
		Version.setTitle("<font color=white>Status</font>");
		Version.setEditable(false);
		//Version.setSortable(true);
		Version.setFilterable(true);
		
		row.addColumn(Version);
		
		/****************************************************/
		

		final String CONTEXT_PATH = request.getContextPath();
		
		HtmlColumn fileName = new HtmlColumn("fileName");
		fileName.setTitle("PDF Viewer &nbsp;<img height=\"15\" src=\""+CONTEXT_PATH+"/images/pdfViewer.gif\">");
		
		fileName.setCellEditor(new  CellEditor(){
        	public Object getValue(Object item, String property, int rowcount) {
        		SearchDataObj searchDataObj1=(SearchDataObj)item;
        		HtmlBuilder htmlB = new HtmlBuilder();
                //String filePath = "javascript:getpdf("+"'/"+searchDataObj1.getFileName()+"/');";
        		String filePath = "javascript:getpdf1('" + searchDataObj1.getFileName() + "','"+searchDataObj1.getDocumentType()+
                		"','"+searchDataObj1.getIndexType()+"','"+searchDataObj1.getIndexValue()+"');";
        		htmlB.a().href().quote().append(filePath).quote().close();
                htmlB.append("View");
                htmlB.aEnd();
               // htmlB.nbsp();
               // htmlB.nbsp();
               // htmlB.append("<img height=\"11\" src=\""+CONTEXT_PATH+"/images/pdfViewer.gif\">");
                
                return htmlB.toString();
        }});
		fileName.setEditable(false);
		fileName.setSortable(false);
		fileName.setFilterable(true);
		
		row.addColumn(fileName);
		
		return worksheetTable;
	}	

		
	
	
}
