<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

 <link rel="stylesheet" href="css/bootstrap.css">
 <link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
  
  <script src="js/jQuery/1.11.3/jquery.min.js"></script>
  <!-- Include the Sidr JS -->
  <script src="js/jquery.sidr.min.js"></script>
  
  <script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>		
 <script src="js/jQuery/jquery-ui.js"></script>
         <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TransAccess Imaging</title>
<%@page import="java.util.*,java.io.*,org.apache.commons.lang.StringUtils" %>	
<%@page import="com.peniel.bus.vo.SessionLog" %>
<jsp:useBean id="documentData" scope="request" class="com.peniel.beans.DocumentDataBean" />



				
</head>

<jsp:include page="includes/sessionHeader.jsp" />


<% 
if(request.getSession().getAttribute("sessionid")!=null){
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  int uid = Integer.parseInt(request.getSession()
			.getAttribute("userid").toString());
  String userName = "";
    
  String docId = request.getParameter("docId").toString();  
  String dcTyp = request.getParameter("dcTyp").toString();
   
  String status = request.getParameter("status").toString();
  String fileName = request.getParameter("id").toString();

  String version = request.getParameter("version").toString();

  String docTypeId = request.getParameter("docTypeId").toString();
  String propertyId = request.getAttribute("propertyId").toString();
  
  String transactionType = request.getParameter("transactionType").toString();
	String transactionDate = request.getParameter("transactionDate");
	String transactionStatus = request.getParameter("transactionStatus").toString();
	
	System.out.println("43534534"+transactionType +" "+transactionStatus);
  
  String[] folderName = request.getParameter("folderName").split("</br>");
  
  Long versionNum = Long.parseLong(request.getAttribute("versionNum").toString());
  String createDate = request.getAttribute("createDate").toString();
  //String updateDate = request.getAttribute("updateDate").toString();
   String auditTrailDate ="";
 Vector sessionLogList = new Vector();
 sessionLogList = (Vector)request.getAttribute("sessionLogList");
 if( sessionLogList != null)
 {
 System.out.println("sessionLogList.size  "+sessionLogList.size());
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
 javax.naming.Context ctx = 	new javax.naming.InitialContext();
String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
String repository = (String) ctx.lookup("java:comp/env/repository");
String URL = (String) ctx.lookup("java:comp/env/URL");


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
%>



<body onLoad="initial_load()">

<form name="editForm" id ="editForm" method="POST" action="">&nbsp; 
 
<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
<input type="hidden" id ="comid" name="comid" value="<%=cid%>"/>
<input type="hidden" id ="username" name="username" value="<%//=userName%>"/>
<input type="hidden" id ="docId" name="docId" value="<%=docId%>"/>

<input type="hidden" id ="dcTyp" name="dcTyp" value="<%=dcTyp%>"/>
<input type="hidden" id ="status" name="status" value="<%=status%>"/>
<input type="hidden" id ="id" name="id" value="<%=fileName%>"/>
<input type="hidden" id ="version" name="version" value="<%=versionNum%>"/>
<input type="hidden" id ="docTypeId" name="docTypeId" value="<%=docTypeId%>"/>
<input type="hidden" id ="formAction" name="formAction" value="<%=formAction%>"/>


<div id ="successMessage" style ='display:none;' align=center>
			<font color=green><b>Edit Document Profile successful</b></font>
</div>



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
      <div class="panel-body">
      <div class="card" style="width: 98%; margin: 10px 0px 0px 0px; padding-left: 0px;">
	  	<div class="card-body card-padding" style="background-color:#FFFFFF;overflow: auto">
	  		<div style="width:50%;float:left;border-right: 2px dotted #8C8888;">			
		<table align="center" width= "100%" class="summaryTable" >
			<tr>
				<td style="padding-bottom: 10px;" colspan="2"><h4 class="tableHeader">Key Document Information</h4></td>
			</tr>
			<tr>
				<td style="width:35%"><h4 class="header">Property</h4></td>
				<td><%= propertyId %></td>
			</tr>
			<tr>
				<td>Folder Name</td>
				<%for(String folderNames:folderName){
				
				%>
				<td><label class="infoLbl"><%=folderNames %></label></td>
				<%} %>
			</tr>
			
			<tr>
				<td><h4 class="header">Document Type</h4></td>
				<td><label class="infoLbl"><%=dcTyp%></label></td>
			</tr>
			
			<tr>
				<td>Document Status</td>
				<td><label class="infoLbl"><%=status%></label></td>				
			</tr>
			
			
			
			<%for(int i=0; i<indexTypeIdVal.size(); i++){
			
						String indexIdVal = (String)indexTypeIdVal.get(i);
						
						String indexId = indexIdVal.substring(0, indexIdVal.indexOf("^"));
									
						String val = indexIdVal.substring(indexIdVal.indexOf("^")+1, indexIdVal.length());
			%>
			<%if(!StringUtils.isEmpty(transactionType) && !StringUtils.isEmpty(transactionDate) && !StringUtils.isEmpty(transactionStatus)) { %>
					
			<tr>
				<td><h4 class="header">Index Type:</h4></td>
				<td><label class="infoLbl"><%=indexId%> : </label> <label class="infoLbl"><%=val%>	</label></td>
			</tr>
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
			<input  id="rowid1" name="rowid1" type="hidden" />
					<input  id="indextype1Dis" name="indextype1Dis" type="hidden" />
					<input  id="indexval1Dis" name="indexval1Dis" type="hidden" /></td>
			<%}} %>	
			
			
		</table>
		</div>
		<div style="background-color: rgb(255, 255, 255); width: 50%; float: right; height: auto; min-height: 220px; text-align: left;">
			<table class="summaryTable" style="min-width:320px">
			<tr>
				<td style="padding-bottom: 10px;" colspan="2"><h4 class="tableHeader">Version History</h4></td>
			</tr>
				<tr>
					<td><h4 class="header" style="display: inline;padding-right: 10px;">View Version No.</h4></td>
					<td><label style="display: inline;padding-right: 10px;" class="infoLbl"><%= versionNum%></label>
<%-- 						<a href="javascript:getPdf('<%= fileName%>');" ><img src="./images/pdfViewer.gif" alt="View Document" border=0></a>
 --%>					
                            <%   String extension=fileName.substring(fileName.lastIndexOf(".") + 1);
									
									System.out.println("extension"+extension);
									if(extension.toLowerCase().equalsIgnoreCase("doc") || extension.toLowerCase().equalsIgnoreCase("docx")){
									 %>
		                              <a href="javascript:getPdf('<%=fileName %>');"><img src="./images/docLatest.png" border="0" height="25px" width="25px"></a>
									 <%}else if(extension.toLowerCase().equalsIgnoreCase("jpg") || extension.toLowerCase().equalsIgnoreCase("jpeg")){ %>
		      						 <a href="javascript:getPdf('<%=fileName %>');"><img src="./images/jpegsma.jpg"border="0" height="25px" width="25px"></a>
									<%}else if(extension.toLowerCase().equalsIgnoreCase("xls") || extension.toLowerCase().equalsIgnoreCase("xlsx")){ %>
								  <a href="javascript:getPdf('<%=fileName %>');"><img src="./images/excel_file.png" border="0" height="25px" width="25px"></a>
								
									<%}else{ %>
								  <a href="javascript:getPdf('<%=fileName %>');"><img src="./images/pdfViewer.gif" border="0" height="25px" width="25px"></a>
																	
									<%} %> 
 
 </td>
				</tr>
				<%   
					for(long j = versionNum-1; j >= 0 ; j--){%>
									
						<tr><td><h4 class="header" style="display: inline;padding-right: 10px;">View Version No.</h4></td><td><label style="display: inline;padding-right: 10px;" class="infoLbl"><%= j%></label>
						<% String fname = documentData.getFilenameByVersion(docId,j);
						System.out.println("fname ="+fname);
						   if(!fname.equalsIgnoreCase("")){
						%>
<%-- 			    		<a href="javascript:getPdf('<%=fname%>');" ><img src="./images/pdfViewer.gif" alt="View Document" border=0></a>
 --%>			    		
			    		  <%   String ext=fname.substring(fname.lastIndexOf(".") + 1);
									
									System.out.println("extension"+extension);
									if(ext.toLowerCase().equalsIgnoreCase("doc") || ext.toLowerCase().equalsIgnoreCase("docx")){
									 %>
		                              <a href="javascript:getPdf('<%=fname %>');"><img src="./images/docLatest.png" border="0" height="25px" width="25px"></a>
									 <%}else if(ext.toLowerCase().equalsIgnoreCase("jpg") || ext.toLowerCase().equalsIgnoreCase("jpeg")){ %>
		      						 <a href="javascript:getPdf('<%=fname %>');"><img src="./images/jpegsma.jpg"border="0" height="25px" width="25px"></a>
									<%}else if(ext.toLowerCase().equalsIgnoreCase("xls") || ext.toLowerCase().equalsIgnoreCase("xlsx")){ %>
								  <a href="javascript:getPdf('<%=fname %>');"><img src="./images/excel_file.png" border="0" height="25px" width="25px"></a>
								
									<%}else{ %>
								  <a href="javascript:getPdf('<%=fname %>');"><img src="./images/pdfViewer.gif" border="0" height="25px" width="25px"></a>
																	
									<%} %> 
 
			    		
			    		
			    		</td></tr>
			    	<%    }
		    	    } %>
			</table>
		</div>

					
					
				</div>
				</div>	      
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Document Detail Information
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
       <div class="card" style="width: 95%; margin: 0px 30px 0px 0px; padding-left: 0px;">
	  		<div class="card-body card-padding" style="padding: 16px 36px 0px;background-color:#EBEBEB;margin-bottom: 20px;">
	  		
	  		<table align="center" width= "100%" style="border-bottom: 1px solid rgb(204, 204, 204); padding-top: 10px; padding-bottom: 10px;border-collapse: unset;">
						<tr>
							<td style="padding-bottom: 10px;"><h4 class="tableHeader">Document Detail Information</h4></td>
						</tr>
						<tr valign=top>
						
						<td width=30%>
							<div id="divDocDetail">
							<h4 class="header">Document Creation Date:</h4><label class="summaryLbl"> <%=createDate %></label>
							<p></p>
							
							 </div>
						 </td>
						
						<td>
						<div id="defaultProfile">
							<table width="100%">
								<tr>
								<td>
								<h4 class="header">Document Last Updated:</h4><label class="summaryLbl"><%=auditTrailDate %></label>
								</td>
									<td>
										<h4 class="header">Previous Versions?</h4>
										<label class="summaryLbl"><%=prevVersion %></label>
									</td>					
															
									
									<td>
										<h4 class="header">Version Numbers:</h4>
										<label class="summaryLbl"><%=versionNum %></label>
										
									</td>
									
									
								</tr>
							</table>
						</div></td>
						</tr>
						</table>
						
			
			</div></div>
      
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          Audit Trail
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">
       <div class="card" style="width: 95%; margin: 0px 30px 0px 0px; padding-left: 0px;">
	  		<div class="card-body card-padding" style="padding: 16px 36px 0px;background-color:#EBEBEB;margin-bottom: 20px;">
		<center>
			<%= (String) request.getAttribute("htmlTableAuditTrail")%>
		</center>
		</div></div>
      </div>
    </div>
  </div>
</div>






<script language="javascript">
$( function() {
    $( "#transactionDate" ).datepicker({
    	
        onSelect: function (selected) {
            var dt = new Date(selected);
            dt.setDate(dt.getDate() + 1);
            $("#transactionDate").datepicker("option", "minDate", dt);
        }
 } );
  } );
function replaceDoc(){
	document.editForm.action = "./replaceDocument.jsp";
	document.editForm.submit();
	
}

function editDocProfile(){
	document.editForm.action = "./EditDocProfile";
	document.editForm.submit();
}
function getPdf(filename) {
	var keyword='';
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var version = '<%= version%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var urlui= '<%=URL%>';

	
	
var documentData={
		 "sessionId":session,
		 "userId":user,
		 "companyId":com,
		 "documentId":filename,
		 "version":version,
		 "action":"View Document",
		 "description":"View Document"
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
	

	window.open(urlui+'DisplayPdf?&sessionid='+session+'&id='+filename+'&keywordSearch='+keyword+'&userid='+user+'&userName='+userName+'&irems='<%= propertyId %>,'popup','width=1000,height=600');
}

function getPdf11(filename) {
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var version = '<%= version%>';
	var id = filename;
	var fileSize='<%= fileSize%>';
	//var Text = //"./DisplayPdfs?id="+id+"&comid="+com+"&sessionid="+session+"&userName="+userName;
//	window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
	//Kiran Changes Starts
//var docId=filename.substr(filename.lastIndexOf('/')+1);
//var documentData=[];
//documentData=docId.split('.');
var documentData={
		 "sessionId":session,
		 "userId":user,
		 "companyId":com,
		 "documentId":filename,
		 "version":version,
		 "action":"View Document",
		 "description":"View Document"
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
	 
<%--     var pdfurl = '<%=uiURL%>'+"/DisplayPdf?id="+ id;
 --%>	 
	 //alert("pdfurl"+pdfurl)
<%-- 	 var pdfurl = '<%=restURL%>'+"/role/ResponseBodyStreamFixed?id="+ id;

	var Text = "displayPdf.html";
	
	 sessionStorage.setItem('pdfurl',pdfurl);
			
	 window
			.open(
					pdfurl,
					'',
					'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes'); 
				 --%>
	
	 
				 var downloadOriginal=false;


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
				 						'toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=15000, top=15000, width=50, height=50, visible=none',
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
	setHeader('editDocument.jsp');
	$(".headPageContainer").hide();
	  $(".userInformaiton").hide();	
	  $(".mainBlueHeading").hide();
	  $("#headertext").hide();
	  
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

}

<%}else{
	response.sendRedirect("index.jsp");
} %>

</script>

</form>
</body>

</html>
