<%@page import="com.peniel.beans.getDropD"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />

<jsp:setProperty name="userInformation" property="*" />
<%@page import="java.util.*,java.io.*,org.apache.commons.lang.StringUtils"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@page import="com.peniel.bus.vo.SessionLog" %>
<jsp:useBean id="documentData" scope="request" class="com.peniel.beans.DocumentDataBean" />
<jsp:useBean id="propertyBean" scope="request" class="com.peniel.beans.PropertyInformation" />

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.debug.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/2.3.5/jspdf.plugin.autotable.js"></script>
  <script src="js/jQuery/1.11.3/jquery.min.js"></script>
  <!-- Include the Sidr JS -->
  <script src="js/jquery.sidr.min.js"></script>
  <script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>			

		
   <title>TransAccess Imaging</title>
   
     
   <style type="text/css">
   
    input[disabled] {
    color: #DCDAD1;
    padding: 2px;
    margin: 0 0 0 0;
    background-image: none;
}

	</style>

</head>

<jsp:include page="includes/sessionHeader.jsp" />

<% if(request.getSession().getAttribute("sessionid")!=null){
	 String keyword = request.getParameter("keyword").toString();
	  
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = "";
  String propertyId = request.getAttribute("propertyId").toString();
  String propertyIdHtml =request.getAttribute("propertyIdHtml").toString();
  int uid = Integer.parseInt(request.getSession()
			.getAttribute("userid").toString());
  String docId = request.getAttribute("docId").toString();
  
  String dcTyp = request.getAttribute("docType").toString();
  String docTypeId = request.getAttribute("docTypeId").toString();
  String status = request.getAttribute("status").toString();
  String fileName = request.getParameter("id").toString();
  String transactionType="";
  String transactionDate="";
  String transactionStatus="";
  System.out.println(request.getSession().getAttribute("transactionType")+"request.getAttribute");
 if(request.getSession().getAttribute("transactionType")!=null){
	 transactionType = request.getSession().getAttribute("transactionType").toString();
  }
  if(request.getSession().getAttribute("transactionDate")!=null){
	 transactionDate = request.getSession().getAttribute("transactionDate").toString();
  }
  if(request.getSession().getAttribute("transactionStatus")!=null)
  {
	 transactionStatus = request.getSession().getAttribute("transactionStatus").toString();
  } 
  
 // Set<String> accessType = (Set<String>)request.getSession().getAttribute("accessPatterenDetails");
 // System.out.println("accessType "+accessType.size()+accessType);
 
 /* String accessType =null;
   String folderName = request.getAttribute("folderName").toString();
  
  Map accessPatteren= (Map)request.getSession().getAttribute("accessPatteren");
  System.out.println("accessPatteren--->"+accessPatteren);
  
  Iterator entries = accessPatteren.entrySet().iterator();
  while (entries.hasNext()) {
      Map.Entry entry = (Map.Entry) entries.next();
     if(folderName.matches(entry.getKey().toString().replace(".", "\\.").replace("?", ".?").replace("*", ".*"))){
    	 accessType = (String)entry.getValue();
      
  }
  }
  
  System.out.println("accessType "+accessType); */

 // String folderName = request.getAttribute("folderName").toString();
  Long versionNum = Long.parseLong(request.getAttribute("versionNum").toString());
  String createDate = request.getAttribute("createDate").toString();
   String auditTrailDate ="";
 Vector sessionLogList = new Vector();
 sessionLogList = (Vector)request.getAttribute("sessionLogList");
 if( sessionLogList != null)
 {
 //System.out.println("sessionLogList.size  "+sessionLogList.size());
	if(sessionLogList.size()  > 0)
	{
			
			SessionLog sessionLog = (SessionLog)sessionLogList.get(0);
			
		    auditTrailDate = (String)sessionLog.getDtm();				
		    System.out.println("audit date  = "+ auditTrailDate);		
			String lastName = (String) sessionLog.getLastName();
			String firstName = (String) sessionLog.getFirstName();
			String fieldModified = (String)sessionLog.getFieldName();
			String oldValue = (String)sessionLog.getOldValue();
			String newValue = (String) sessionLog.getNewValue();
		
	}
}
 
  
 
  Vector indexTypeIdVal = new Vector();
  indexTypeIdVal = (Vector)request.getAttribute("indexTypeIdVal");
  
  String formAction = request.getParameter("formAction").toString();
 
  
  if(versionNum < 0) {
	if(versionNum == -999){
		versionNum = 0L;
	}
	else{
		versionNum = -versionNum;
	}
  } 
	
  String prevVersion = "N";
  if(versionNum > 1){
	prevVersion = "Y";
  }
        HashMap hashMap = propertyBean.getPropertyInformation(request);
		/*Set set = hashMap.entrySet();
		
		// Get an iterator
		Iterator it = set.iterator();
		
		while(it.hasNext()) 
		{
			Map.Entry me = (Map.Entry)it.next();			
			System.out.println(""+me.getKey() +" "+ me.getValue());
		}*/ 
		   javax.naming.Context ctx = 	new javax.naming.InitialContext();
		String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
		String URL = (String) ctx.lookup("java:comp/env/URL");
		
		String repository = (String) ctx.lookup("java:comp/env/repository");
		
		
		 String fileSize=null;
		  
		 File file=new File(repository+"/"+fileName);
		  
		  if (file.length() >= 1000000000) {
			  fileSize=file.length() / (1024 * 1024 * 1024) + "GB";
		  }

		  else if (file.length() >= 1000000) {
			  fileSize= file.length() / (1024 * 1024) + "MB";
		  }
		  else{
			  fileSize =file.length() / 1024 + "  KB";
		  
		  }

%>



<body onLoad="initial_load()">

<div id="flip-tabs" >  
        
        <form name="editForm" id ="editForm" method="POST" action="">
        
        
		<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
		<input type="hidden" id ="comid" name="comid" value="<%=cid%>"/>
		<input type="hidden" id ="username" name="username" value="<%//=userName%>"/>
		<input type="hidden" id ="docId" name="docId" value="<%=docId%>"/>
		<input type="hidden" id ="docTypeId" name="docTypeId" value="<%=docTypeId%>"/>		
		<input type="hidden" id ="dcTyp" name="dcTyp" value="<%=dcTyp%>"/>
<%if(!StringUtils.isEmpty(transactionType) && !StringUtils.isEmpty(transactionDate) && !StringUtils.isEmpty(transactionStatus)) { %>
		
		<input type="hidden" id ="transactionType" name="transactionType" value="<%=transactionType%>"/>
		<input type="hidden" id ="transactionDate" name="transactionDate" value="<%=transactionDate%>"/>
		<%if(transactionStatus.equals("null")){ transactionStatus="";}%>
		<input type="hidden" id ="transactionStatus" name="transactionStatus" value="<%=transactionStatus%>"/>		
		<%} %>
		<input type="hidden" id ="status" name="status" value="<%=status%>"/>
		<input type="hidden" id ="id" name="id" value="<%=fileName%>"/>
		<input type="hidden" id ="version" name="version" value="<%=versionNum%>"/>
		<input type="hidden" id ="propertyId" name="propertyId" value="<%=propertyId%>"/>
	<%-- 	<input type="hidden" id ="folderName" name="folderName" value="<%=folderName%>"/> --%>
		<input type="hidden" id ="formAction" name="formAction" value="<%=formAction%>"/>
		<table>
		<tr><td style='font-size:14px;font-family: Verdana;color: green'>
		<font color=red><b></b></font>
		</td></tr>
		</table>
        <div align="center" style="margin:20px;">
	
											
		<p style="color:green;font-size:16px;text-align: left;margin-bottom:10px;margin-left: 10px;"><i class="zmdi_large zmdi-file"></i></i>Document Details</p>
		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
         Key Document Information
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body" style="padding-left: 5px; padding-top: 20px; padding-bottom: 20px;">
          

  <!-- Modal -->
  <div class="modal fade" id="myEx" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Property <%=hashMap.get("propertyId")%>  Details</h4>
        </div>
        <div class="modal-body">
        	<table  align="center" width= "100%" style="margin-top: 20px; margin-bottom: 20px;">
				          
				            <tr>								
								<td    ><p>Property Name</p></td>				
								<td   align="left">	
								<label class="infoLbl"><%=hashMap.get("propertyName")%></label>
								</td>								
								<td>
								<p>Property City</p></td>				
						 		<td   align="left">	
								<label class="infoLbl"><%=hashMap.get("city")%></label>
								</td>				                  
				          </tr>
				          <tr>						
								<td><p>Property State </p></td>				
								<td   align="left">
									<label class="infoLbl"><%=hashMap.get("state")%></label>
								</td>									
								
								<td>
								<p>Property Zip</p></td>				
						 		<td   align="left">	
								<label class="infoLbl"><%=hashMap.get("zip")%></label>
								</td>				                  
				          </tr>
				                   				         
					</table>		          
				          
	       </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
      
  					
 <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
	<div class="card-body card-padding" style="background-color:#FFFFFF;overflow: auto"> 
      	<table align="center" width= "720" style="margin-bottom: 20px;">
			<tr height= '20'  align="right">
				<%-- <td style='font-size:12px;font-family: Arial;'>&nbsp;
				
					<%
					String disabled="";
					if(accessType!=null && !accessType.contains("ReadWrite") && accessType.contains("ReadOnly")){
						disabled = "disabled";
						%> 
					<input type="button" class="btn btn-success" name="btnEdit" value="Edit Document" onClick="javascript:editDocProfile();" disabled="<%=disabled%>">
					<%	
						}else{
					%> 
					<input type="button" class="btn btn-success" name="btnEdit" value="Edit Document" onClick="javascript:editDocProfile();">
					
					<%
					}
					%> 
					<%
					if("Inactive".equals(status) || (accessType!=null && !accessType.contains("ReadWrite") && accessType.contains("ReadOnly"))){
						disabled = "disabled";
					
					%> 
					<input type="button" class="btn btn-primary" name="btnReplace" value="Replace Document" onClick="javascript:replaceDoc();" disabled="<%=disabled%>">
					
					<%	
						}else{
					%> 
					<input type="button" class="btn btn-primary" name="btnReplace" value="Replace Document" onClick="javascript:replaceDoc();" >
					
					<%
					}
					%> 
					
					<input type="button" name="cancel" value="Cancel" class="btn btn-warning" onClick="onCancel()">
					
				</td> --%>
			</tr>
		</table>
		<div style="width:50%;float:left;border-right: 2px dotted #8C8888;">			
		<table align="center" width= "100%" class="summaryTable" >
			<tr>
				<td style="padding-bottom: 10px;" colspan="2"><h4 class="tableHeader">Key Document Information</h4></td>
			</tr>
			<tr>
				<td style="width:35%"><h4 class="header">Property</h4></td>
				<td><%=propertyIdHtml%></td>
			</tr>
			<%-- <tr>
				<td>Folder Name</td>
				<td><label class="infoLbl"><%=folderName %></label></td>
			</tr> --%>
			
			<tr>
				<td><h4 class="header">Document Type</h4></td>
				<td><label class="infoLbl"><%=dcTyp%></label></td>
			</tr>
			
			<tr>
				<td>Document Status</td>
				<td><label class="infoLbl"><%=status%></label></td>				
			</tr>
			
			
		
			<%if(!StringUtils.isEmpty(transactionType) && !StringUtils.isEmpty(transactionDate) && !StringUtils.isEmpty(transactionStatus)) { %>
			<tr>
				<td>Transaction Type</td>
				<td><label class="infoLbl"><%=transactionType%></label></td>				
			</tr>
			
			<tr>
				<td>Transaction Date</td>
				<td><label class="infoLbl"><%=transactionDate%></label></td>				
			</tr>
			
			<tr>
				<td>Transaction Status</td>
				<td><label class="infoLbl"><%=transactionStatus%></label></td>				
			</tr>
			<%} %>
		</table>
		</div>
		<div style="background-color: rgb(255, 255, 255); width: 50%; float: right; height: auto;    overflow-y: scroll; max-height: 220px;text-align: left;">
			<table class="summaryTable" style="min-width:320px">
			<tr>
				<td style="padding-bottom: 10px;" colspan="3"><h4 class="tableHeader">Version History</h4></td>
			</tr>
				<tr>
					<td><h4 class="header" style="display: inline;padding-right: 10px;">View Version No.</h4></td>
					<td><label style="display: inline;padding-right: 10px;" class="infoLbl"><%= versionNum%></label>
<%-- 						<a href="javascript:getPdf('<%= fileName%>');" ><img src="./images/pdfViewer.gif" alt="View Document" border=0></a>
 --%>					
  <%  
  String createdate=null;
  String fnamecomplete = documentData.getFilenameByVersion(docId,versionNum);	
  if(null!=fnamecomplete){
	 
	  String extension=fileName.substring(fileName.lastIndexOf(".") + 1);
  String actmainname=fnamecomplete.split(":::")[1];
   createdate=fnamecomplete.split(":::")[2];
									System.out.println("extension"+extension);
									if(extension.toLowerCase().equalsIgnoreCase("doc") || extension.toLowerCase().equalsIgnoreCase("docx")){
									 %>
		                              <a href="javascript:getPdf('<%=fileName %>');"><img src="./images/docLatest.png" border="0" height="25px" width="25px"></a>
									 <%}else if(extension.toLowerCase().equalsIgnoreCase("jpg") || extension.toLowerCase().equalsIgnoreCase("jpeg")){ %>
		      						 <a href="javascript:getPdf('<%=fileName %>');"><img src="./images/jpegsma.jpg"border="0" height="25px" width="25px"></a>
									<%}else if(extension.toLowerCase().equalsIgnoreCase("xls") || extension.toLowerCase().equalsIgnoreCase("xlsx")){ %>
								  <a href="javascript:getPdf('<%=fileName %>');"><img src="./images/excel_file.png" border="0" height="25px" width="25px"></a>
								
									<%}else{ %>
								  <a href="javascript:getPdf('<%=fileName %>','<%=actmainname%>');"><img src="./images/pdfViewer.gif" border="0" height="25px" width="25px"></a>
																	
									<%} 
									}%> 
 
 </td>
 <td><%= createdate%></td>
				</tr>
				<%   
					for(long j = versionNum-1; j >= 0 ; j--){%>
					
						<% String filename_complete = documentData.getFilenameByVersion(docId,j);
						System.out.println("filename_complete ="+filename_complete);
						if(null!=filename_complete &&filename_complete!=""){%>
							
							
							<tr><td><h4 class="header" style="display: inline;padding-right: 10px;">View Version No.</h4></td><td><label style="display: inline;padding-right: 10px;" class="infoLbl"><%= j%></label>
						<% 	String[] filename_broken = filename_complete.split(":::");
							String fname=filename_broken[0];
							String actualfilename=filename_broken[1];
							 createdate=filename_broken[2];
							System.out.println("fname ="+fname);
						
						
						   if(!fname.equalsIgnoreCase("")){
						%>
<%-- 			    		<a href="javascript:getPdf('<%=fname%>');" ><img src="./images/pdfViewer.gif" alt="View Document" border=0></a>
 --%>			    		
			    		
			    		 <%   String ext=fname.substring(fname.lastIndexOf(".") + 1);
									
								//	System.out.println("extension"+extension);
									if(ext.toLowerCase().equalsIgnoreCase("doc") || ext.toLowerCase().equalsIgnoreCase("docx")){
									 %>
		                              <a href="javascript:getPdf('<%=fname %>','<%=actualfilename %>');"><img src="./images/docLatest.png" border="0" height="25px" width="25px"></a>
									 <%}else if(ext.toLowerCase().equalsIgnoreCase("jpg") || ext.toLowerCase().equalsIgnoreCase("jpeg")){ %>
		      						 <a href="javascript:getPdf('<%=fname %>','<%=actualfilename %>');"><img src="./images/jpegsma.jpg"border="0" height="25px" width="25px"></a>
									<%}else if(ext.toLowerCase().equalsIgnoreCase("xls") || ext.toLowerCase().equalsIgnoreCase("xlsx")){ %>
								  <a href="javascript:getPdf('<%=fname %>','<%=actualfilename %>');"><img src="./images/excel_file.png" border="0" height="25px" width="25px"></a>
								
									<%}else{ %>
								  <a href="javascript:getPdf('<%=fname %>','<%=actualfilename %>');"><img src="./images/pdfViewer.gif" border="0" height="25px" width="25px"></a>
																	
									<%} %> 
			    		</td>
			    		<td><%= createdate%></td>
			    		</tr>
			    	<%    }
					}
		    	    } %>
			</table>
		</div>
			</div></div>
      </div>
    </div>
  </div>
  
  <%-- <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Document Detail Information
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body" style="padding-left: 5px; padding-top: 20px; padding-bottom: 20px;">
		 <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
			<div class="card-body card-padding" style="background-color:#EDECEC">
					<table align="center" width= "100%" style="background-color:#FFF; padding:10px;border-collapse: unset;">
						<tr>
							<td style="padding-bottom: 10px;" colspan="4"><h4 class="tableHeader">Document Detail Information</h4></td>
						</tr>
						<tr valign=top>
						
						<td width=30%>
							<div id="divDocDetail">
							<h4 class="header">Document Creation Date:</h4><label class="infoLbl"> <%=createDate %></label>
							<p></p>
							
							 </div>
						 </td>
						
						<td>
						<div id="defaultProfile">
							<table width="100%">
								<tr>
								<td>
								<h4 class="header">Document Last Updated:</h4><label class="infoLbl"><%=auditTrailDate %></label>
								</td>
									<td>
										<h4 class="header">Previous Versions?</h4>
										<label class="infoLbl"><%=prevVersion %></label>
									</td>					
															
									
									<td>
										<h4 class="header">Version Numbers:</h4>
										<label class="infoLbl"><%=versionNum %></label>
										
									</td>
									
									
								</tr>
							</table>
						</div></td>
						</tr>
						</table>
						</div>
						</div>
      </div>
    </div>
  </div>
   --%>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          Audit Trail
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body" style="padding-left: 5px; padding-top: 20px; padding-bottom: 20px;">					
				  		<!--Auditrail report changes-->
<span style="align:left" ><button style="background-color:#4ba34b !important;color: white;border-left-width: 0px;text-align: left;float: left;margin-left: 8px;" id="genpdf">Export to PDF</button></span>
<div id="PDFcontent" >
<table id="table1" border="0" style="border-bottom:1px solid #F90" align="center" width= "800" > 
			 <tr> 
			<td width="190" valign="top"><h5 class="header">Date</h5></td> 
			<td width="110" valign="top"><h5 class="header">Last Name</h5></td> 
			<td width="109" valign="top"><h5 class="header">First Name</h5></td> 
			<td width="142" valign="top"><h5 class="header">Field Modified</h5></td> 
			<td width="133" valign="top"><h5 class="header">Old Value</h5></td> 
			<td width="196" valign="top"><h5 class="header">New Value</h5></td>
			<td width="196" valign="top"><h5 class="header">Action</h5></td> 
			</tr> 
		<% 
		
		 Vector<SessionLog> auditList = new Vector<SessionLog>();  
		auditList=(Vector)request.getAttribute("sessionLogList");	
			for (int i = 0; i < auditList.size(); i++) {
				
				SessionLog sesslog = (SessionLog)auditList.get(i);  %>
			<tr>
			<td width="190" valign="top"><% out.print(sesslog.getDtm()); %></td>
			<td width="110" valign="top"><% out.print(sesslog.getLastName()); %></td>
			<td width="109" valign="top"><% out.print(sesslog.getFirstName()); %></td>
			<%if(sesslog.getAction().startsWith("DELETE")){ %>
			<td width="142" valign="top"><% out.print("Deleted Ver-"+sesslog.getVersion()); %></td>
			<%}else{ %>
			<td width="142" valign="top"><% out.print(sesslog.getFieldName()); %></td>
			<%} %>
			<td width="133" valign="top"><% out.print(sesslog.getOldValue()); %></td>
			<td width="196" valign="top"><% out.print(sesslog.getNewValue()); %></td>
			<td width="196" valign="top"><% out.print(sesslog.getAction()); %></td>
			</tr>
<% } %>
</table>
</div>
<span>&nbsp;&nbsp;</span>
<br>
<div id="ignoreContent">
</div>	
<!--Auditrail report changes-->
      </div>
    </div>
  </div>
</div>
		
		
		</div>
	
              
        </form>
        
        
    </div>
<script language="javascript">
//<!--Auditrail report changes-->

$(document).on("click", "#genpdf", function () { 
	var doc = new jsPDF('l', 'pt', 'a4');
	var docId = '<%=docId%>';   
	// doc.text("From HTML", 40, 50);
	    //doc.text( 40, 50);
	     doc.text('\t\t Document Audit Trail Report', 220, 50);
	     doc.text("\n Document Id : "+docId, 40, 50);
	    var res = doc.autoTableHtmlToJson(document.getElementById("table1"));
	    doc.autoTable(res.columns, res.data, {
	      startY: 80
	    });
	    doc.save("DocAuditTrailReport");
});

// <!--Auditrail report changes-->
$(function(){

$('#trigger').click(function(){
 // $('#myEx').modal('show');
  return false;
})

});
function replaceDoc(){
	
	document.editForm.action = "./replaceDocument.jsp";
    document.editForm.submit();

	
	
}

function editDocProfile(){
	document.editForm.action = "./EditDocProfile";
	document.editForm.submit();
}
<%-- function getPdf(filename) {
	var keyword = '<%= keyword%>';
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var version = '<%= versionNum%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var urlui= '<%=URL%>'
	window.open(urlui+'DisplayPdf?&sessionid='+session+'&id='+filename+'&keywordSearch='+keyword+'&userid='+user+'&userName='+userName,'popup','width=1000,height=600');
} --%>


function getPdf(filename, actualfilename) {
	var keyword = '';
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var version = '<%= versionNum%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var urlui= '<%=URL%>'
	
	var fileNameExtension = filename.substr(filename.lastIndexOf('.') + 1);   
	var action="";
	
	if(fileNameExtension=="pdf"){
		action="View Document";
	}else{
		action="Download Document";
	}
	var documentData={
			 "sessionId":session,
			 "userId":user,
			 "companyId":com,
			 "documentId":filename,
			 "version":version,
			 "action":action,
			 "description":action
	}
	
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "<%=restURL%>/audit/saveAuditReport",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(documentData),
		success : function(data) {
			console.log("SUCCESS: ", data);
	    			
		},
		error : function(e) {
			console.log("ERROR: ", e);
			
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	var theChild=window.open(urlui+'DisplayPdf?&sessionid='+session+'&id='+filename+'&keywordSearch='+keyword+'&userid='+user+'&userName='+userName+'&actualfilename='+actualfilename+'&irems=<%= propertyId %>','popup','width=1000,height=800');
			theChild.onload = function(){ 
	    /* my code */ 
	    this.onbeforeunload = function(e){
	    	console.log("onbeforeunload");
	    	console.log(e); 
	    	saveFormData();
	    	}
	}
}
function saveFormData() {
	$.ajax({
		type : "GET",
		   contentType : "application/json",
		  url :  "<%=restURL%>/role/deleteportfolio?id=<%= uid%><%= propertyId %>",
		   async:true,
		  timeout : 100000,
		               success: function(msg){
		                //   alert("delete file status:  viewer2  "+msg)
		               },
					    error:function(e){
						   console.log("error in line 72--"+e);
					   },
		            });
}

function getPdf12(filename) {
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var version = '<%= versionNum%>';
	var id = filename;
	
	//Kiran Changes Starts
	var fileNameExtension = filename.substr(filename.lastIndexOf('.') + 1);
	var action="";


	
	if(fileNameExtension=="pdf"){
		action="View Document";
	}else{
		action="Download Document";
	}
	//var docId=filename.substr(filename.lastIndexOf('/')+1);
	//var documentData=[];
	//documentData=docId.split('.');
	var documentData={
			 "sessionId":session,
			 "userId":user,
			 "companyId":com,
			 "documentId":filename,
			 "version":version,
			 "action":action,
			 "description":action
	}
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "<%=restURL%>/audit/saveAuditReport",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(documentData),
		success : function(data) {
			console.log("SUCCESS: ", data);
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
			
		},
		done : function(e) {
			console.log("DONE");
		}
	});

	//Kiran Changes Ends
	
/* 	var Text = "./DisplayPdf?id="+id+"&comid="+com+"&sessionid="+session+"&userName="+userName;
 */	//window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
	 
	 //alert("pdfurl"+pdfurl)
<%--   var pdfurl = '<%=restURL%>'+"/role/ResponseBodyStreamFixed?id="+ id;

	var Text = "displayPdf.html";
	
	 sessionStorage.setItem('pdfurl',pdfurl);
			
	 window
			.open(
					pdfurl,
					'',
					'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');  
					 --%>

					 var downloadOriginal=false;

					var fileSize='<%= fileSize%>';
					 var fileSizedata=fileSize.substring(0,fileSize.length - 2); 
					 var bytedata=fileSize.substring(fileSize.length - 2,fileSize.length); 


					 if(bytedata.toLowerCase() == 'mb' && fileSizedata > 10)
					 	{
					 		downloadOriginal=true;
					 	}
					 	
					// var id = filename;

					 var fileNameExt = id.substr(id.lastIndexOf('.') + 1);

					 	if (fileNameExt == "doc" || fileNameExt == "docx"
					 			|| fileNameExt == "xlsx" || fileNameExt == "xls"
					 			|| fileNameExt == "jpg" || fileNameExt == "jpeg") {

					 		var Text = "./DisplayText?id=" + id + "&userid=" + user + "&comid="
					 				+ com + "&sessionid=" + session + "&userName=" + userName;
					 		//window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
					 		var popout = window
					 				.open(
					 						Text,
					 						'_blank',
					 						'toolbar=no,status=1,menubar=no,scrollbars=no,resizable=no,left=15000, top=15000, width=50, height=50, visible=none',
					 						'');

					 		window.setTimeout(function() {
					 			popout.close();
					 		}, 8000);

					 	}

						else {

					 	sessionStorage.setItem('downloadOriginal',downloadOriginal);
					 	
					 						var fPath = "<%=restURL%>/role/invokeFile?id="+id;
					 						console.log("365..."+fPath);
					 						$.ajax({					   		 
					 						   	type : "GET",
					 						    contentType : "application/json",
					 						   	url : "<%=restURL%>/role/invokeFile?id="+id,
					 						   	timeout : 100000,
					 						   	success : function(resp) {
					 						   		console.log("success getting file"+resp);
					 						   		//sessionStorage.setItem('filename',"../../../../TransAccessImagingWS/role/downloadOriginal?id=FHA232/webtest1/"+resp);
					 						   		 sessionStorage.setItem('filename',"../../../../TransAccessImagingWS/role/downloadDocument?docId="+resp.substring(0,resp.lastIndexOf("_")));
					 								//var pdfurl1='viewer.html?file='+resp;
					 								var pdfurl1='viewer.html?file='+resp+'&restURL=<%=restURL%>';
					 								console.log('pdf url...'+pdfurl1);
					 								var pdfWindow = window
					 									.open(
					 											pdfurl1,
					 											'',
					 											'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
					 								pdfWindow.onbeforeunload = function(){
					 									$.ajax({
					 											type : "GET",
					 										    contentType : "application/json",
					 										   	url : "<%=restURL%>/role/deleteFile?id="+resp,
					 										   	timeout : 100000,
					 							                success: function(msg){
					 							                    //alert("delete file status:    "+msg)
					 							                },
					 							             });
					 									return null;
					 								}
					 								
					 								
					 						   	  },
					 						   	  error : function(e) {
					 						   	   console.log("ERROR: ", e);						   	       
					 						   	  },
					 						   	  done : function(e) {
					 						   	  }
					 						   	});							
					 						
					 		  <%-- var pdfurl = '<%=restURL%>'+"/role/ResponseBodyStreamFixed?id="+ id; --%>
					 		  
					 			//var Text = "displayPdf.html";
					 			
					 			//sessionStorage.setItem('filename',id);
					 					
					 			/*  window
					 					.open(
					 							Text,
					 							'',
					 							'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');  */
					 		/* 					
					 			window
					 				.open(
					 						pdfurl1,
					 						'',
					 						'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes'); */
					 				
					 	}									
										
}

function moreAuditTrail() {
	
	document.editForm.action = "./AuditTrail";
	document.editForm.submit();
	
	
}

function initial_load()
{
	  $(".headPageContainer").hide();
	  $(".userInformaiton").hide();	
	  $(".mainBlueHeading").hide();
	  $("#headertext").hide();
	  
	   
	setHeader('editDocument.jsp');
	//Initialize slider menu
    $('#simple-menu').sidr();
     
  	$('.child').hide();
  	$('.parent').click(function() {
	 	$('.child').slideUp();
	 	$(this).find('ul').slideToggle();
  	});
  	$('#docManagementLi').click();	 	
	  	
	<%if("save".equals(formAction)){%>
		document.getElementById('successMessage').style.display = 'block';
		document.getElementById('formAction').value = '';
	<%}%>	
	

	
	
	var id='<%=fileName %>';
	// var   documentData=[];
	 //   var docId=id.substr(id.lastIndexOf('/')+1);
	    
	 //   documentData=docId.split('.');
	    sessionStorage.setItem('sessLogCompId','<%= cid%>');
	 
	   sessionStorage.setItem('sessLogSessid','<%=sessionid%>' );
	   
	   
	var rest='<%=restURL%>';
	
	 sessionStorage.setItem('sessLogRestUrl',rest);
	
	    
	    sessionStorage.setItem('sessLogUserid','<%=uid%>' );
	    sessionStorage.setItem('sessLogver','<%= versionNum%>');
	    sessionStorage.setItem('sessLogdocid',id ); 

}
function onCancel()
{
	//history.back(1);
	 window.close();
}
	    <%}else{%>
	    onCancel();
	    	 <%} %>
</script>

</body>

</html>
