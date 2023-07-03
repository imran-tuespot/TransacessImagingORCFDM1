<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TransAccess Imaging</title>
<%@page import="com.peniel.bus.vo.SessionLog" %>
<%@page import="java.util.*,java.io.*"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
  
  <script src="js/jQuery/1.11.3/jquery.min.js"></script>
  <!-- Include the Sidr JS -->
  <script src="js/jquery.sidr.min.js"></script>
  <script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>		
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.debug.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/2.3.5/jspdf.plugin.autotable.js"></script> 
	 	
<%@page import="java.util.*,java.io.*,org.apache.commons.lang.StringUtils"%>

</head>

<jsp:include page="includes/sessionHeader.jsp" />


<% 
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  int uid = Integer.parseInt(request.getSession()
			.getAttribute("userid").toString());
  String userName = "";
  //String userName = request.getAttribute("username").toString();
    
  String docId = request.getParameter("docId").toString();  
  
  String dcTyp = request.getParameter("dcTyp").toString();
   
  String status = request.getParameter("status").toString();
  String fileName = request.getParameter("id").toString();
  String version = request.getParameter("version").toString();

  String docTypeId = request.getParameter("docTypeId").toString();
  String propertyId = request.getParameter("propertyId").toString();
  
  String[] folderName = request.getParameter("folderName").split("</br>");
  String transactionType="";
  String transactionDate="";
  String transactionStatus=" ";
	/*   transactionType = request.getSession().getAttribute("transactionType").toString();
	 transactionDate = request.getSession().getAttribute("transactionDate").toString();
	 transactionStatus = request.getSession().getAttribute("transactionStatus").toString();
	 */
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
  
   //System.out.println("Property in editDocProfile" +propertyId);
  Long versionNum = Long.parseLong(request.getAttribute("versionNum").toString());
  String createDate = request.getAttribute("createDate").toString();
  String updateDate = request.getAttribute("updateDate").toString();
 String auditTrailDate ="";
 Vector sessionLogList = new Vector();
 sessionLogList = (Vector)request.getAttribute("sessionLogList");
		
		if(sessionLogList.size()  > 0)
		{
				
				SessionLog sessionLog = (SessionLog)sessionLogList.get(0);
				
			    auditTrailDate = (String)sessionLog.getDtm();				
			    //System.out.println("audit date  = "+ auditTrailDate);		
				String lastName = (String) sessionLog.getLastName();
				String firstName = (String) sessionLog.getFirstName();
				String fieldModified = (String)sessionLog.getFieldName();
				String oldValue = (String)sessionLog.getOldValue();
				String newValue = (String) sessionLog.getNewValue();
			
		}
 
  Vector indexTypeIdVal = new Vector();
  indexTypeIdVal = (Vector)request.getAttribute("indexTypeIdVal");
  javax.naming.Context ctx = new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
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




<body onLoad="initialLoad()">

<form name="editForm" id ="editForm" method="POST" action="">

<input type="hidden" id ="userid" name="userid" value="<%//=uid%>"/>
<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
<input type="hidden" id ="comid" name="comid" value="<%=cid%>"/>
<input type="hidden" id ="username" name="" value="<%//=userName%>"/>

<input type="hidden" id ="docId" name="docId" value="<%=docId%>"/>

<input type="hidden" id ="dcTyp" name="dcTyp" value="<%=dcTyp%>"/>
<input type="hidden" id ="transactionDate" name="transactionDate" value="<%=transactionDate%>"/>
<input type="hidden" id ="transactionStatus1" name="transactionStatus" />


<input type="hidden" id ="status" name="status" value="<%=status%>"/>
<input type="hidden" id ="id" name="id" value="<%=fileName%>"/>
<input type="hidden" id ="version" name="version" value="<%=version%>"/>
<input type="hidden" id ="docTypeId" name="docTypeId" value="<%=docTypeId%>"/>
<input type="hidden" id ="propertyId" name="propertyId" value="<%=propertyId%>"/>
<%for(String folderNames:folderName){
%>
<input type="hidden" id ="folderName" name="folderName" value="<%=folderNames%>"/> 

<%} %>
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
      <div class="card" style="width: 98%;">
	  		<div class="card-body card-padding" style="background-color:#EBEBEB;margin-bottom: 20px;">
	  		<table align="center" width= "100%"  >
					<tr height= '45' >
						<td width="415" style="padding-top: 10px;">&nbsp;
							<input type="button" name="btnEdit" value="Edit Document" class="btn btn-success waves-effect waves-button waves-float" onClick="javascript:editDocProfile();" disabled="disabled"> 
							<%
							String disabled="";
							if("Inactive".equals(status)){
								disabled = "disabled";
							}
							%> 
							<input type="button" name="btnReplace" value="Replace Document" class="btn btn-primary waves-effect waves-button waves-float" onClick="javascript:replaceDoc();" <%=disabled %>>		</td>
					    <td width="416" align="right" style="padding-top: 10px; padding-right: 10px;"><input name="button" type ="button" class="btn btn-success waves-effect waves-button waves-float" onClick="javascript:onSave();" value="Save"/>
					   
				          <input name="button" type ="button" onClick="javascript:onCancel();" class="btn btn-warning waves-effect waves-button waves-float" value="Cancel"/></td>
					</tr>
					<%
					String exceptions = (String)request.getAttribute("exceptions");
					if(exceptions == null || "noError".equals(exceptions))
						exceptions = "";
					 %>
					<tr>
						<td colspan="2">
							<font color=red><b><%=exceptions%></b></font>		</td>
					</tr>
				</table>
					  		
											  
			  	<table >
				<tr>
					<td colspan="3"><h4 style="padding:10px" class="tableHeader">Select the type of document and index</h4></td>
				</tr>	
				<tr valign=top>
					
					<td width=50% rowspan="5" style="vertical-align: top;">
					<div id="divDocStatus" style="padding-left:10px">
					  <h4 class="header" style="margin-top: 5px;">Property <input type="text" id="realtxt" class="searchText" placeholder="Enter Search Text" style="width: 280px;border:none;background-color: transparent;"  onkeyup="javascript:searchSel(document.getElementById('propertytype').selectedIndex);"/>
					  </h4>
					  <select style="width:330px;" name="propertytype" id="propertytype" class="selectText">
					  	<option value=""></option>
					  </select>
					  <p></p>
					  
					  <h4 class="header" style="margin-top: 5px;">Folder <input type="text" id="foltxt" class="searchText" placeholder="Enter Search Text" style="width: 280px;border:none;background-color: transparent;" onkeyup="javascript:searchFolSel();"/></h4> 
					  <select style="width:330px;" name="folderId" id="folderId" class="selectText" multiple="multiple">
					  	<option value=""></option>
					  </select>
					  <p></p>
					  								
					  <h4 class="header" style="margin-top: 10px;">Document Type</h4>
					  <select  id="doctype" name="doctype" style="width:330px;" class="selectText">  
					  	<option value=""></option>
					  </select>
					  <p></p>								
					  <h4 class="header" style="margin-top: 15px;">Document Status</h4> 
					  <select  id="docStatus" name="docStatus" style="width:330px;" class="selectText">  </select>
					  <p></p>								
					
<!-- 					  <a href="javascript:getPdf();" ><img src="./images/pdfViewer.gif" alt="View Document" border=0></a>
 -->
					
					
					    <%   String extension=fileName.substring(fileName.lastIndexOf(".") + 1);
									
									System.out.println("extension"+extension);
									if(extension.toLowerCase().equalsIgnoreCase("doc") || extension.toLowerCase().equalsIgnoreCase("docx")){
									 %>
									   <h4 class="header" style="margin-top: 15px;">View</h4> 
		                              <a href="javascript:getPdf();"><img src="./images/docLatest.png" border="0" height="25px" width="25px"></a>
									 <%}else if(extension.toLowerCase().equalsIgnoreCase("jpg") || extension.toLowerCase().equalsIgnoreCase("jpeg")){ %>
 									 <h4 class="header" style="margin-top: 15px;">View</h4> 
 									 <a href="javascript:getPdf();"><img src="./images/jpegsma.jpg"border="0" height="25px" width="25px"></a>
									<%}else if(extension.toLowerCase().equalsIgnoreCase("xls") || extension.toLowerCase().equalsIgnoreCase("xlsx")){ %>
                                 <h4 class="header" style="margin-top: 15px;">View</h4> 
  								  <a href="javascript:getPdf();"><img src="./images/excel_file.png" border="0" height="25px" width="25px"></a>
								
									<%}else{ %>
                             <h4 class="header" style="margin-top: 15px;">View</h4> 				
  				               <a href="javascript:getPdf();"><img src="./images/pdfViewer.gif" border="0" ></a>
																	
									<%} %>
					
					</div>
					
					</td>
					
					</tr>
					<tr valign=top>
					<td>
					  
					<div id="defaultProfile" style="padding-bottom: 10px;">
					<table width="100%" cellpadding="0" cellspacing="0">
					<tr valign="top">
						<td width="200" >
							<h4 class="header">Index Type</h4>
						</td>
						<td width="200" >
							<h4 class="header">Value   </h4>
						</td>
					</tr>
						
					<tr>
					<td >
					<select  id="indextype1" name="indextype1" class="selectText">	</select></td>
					<td >
					<input  id="indexval1" name="indexval1" type="text" size="12" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" />
					<input  id="rowid1" name="rowid1" type="hidden" />
					<input  id="indextype1Dis" name="indextype1Dis" type="hidden" />
					<input  id="indexval1Dis" name="indexval1Dis" type="hidden" /></td>
					</tr>
					
					</table>
					</div>							  
					  </td>
					
					</tr>
					<%if(!StringUtils.isEmpty(transactionType) && !StringUtils.isEmpty(transactionDate) && !StringUtils.isEmpty(transactionStatus)) { %>
					<tr valign="top">				
					  
					  <td>
					   <h4 class="header" style="margin-top: 10px;">Transaction Type</h4>
					  <select  id="transactionType" name="transactionType" style="width:330px;" class="selectText">  
					  	<option value="" selected></option>
					  </select>
				  
					  <p></p>	
					    <h4 class="header" style="margin-top: 10px;">Transaction Date</h4>
					 	<input  id="transactionDate" name="transactionDate" type="text" size="12" style="width: 330px;" value=<%=transactionDate %> />

					  <p></p>								
					  <h4 class="header" style="margin-top: 15px;">Transaction Status</h4> 
					  <select id="transactionStatus" onChange="setTransactionStatusValue();" class="selectText width100per"> 
											  	
<!-- 												<option selected>Approved</option>								 -->
<!-- 												<option>Denied</option>		 -->
<!-- 												<option>Approved with Changes</option>								 -->
																				
					 </select>
					  <p></p>	
					  </td>
					</tr>
					
					<%} %>
					
					</table>
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
      <div class="panel-body" style="padding-right: 0px;">
       <div class="card" style="width: 95%; padding-left: 0px;">
	  		<div class="card-body card-padding" style="background-color:#EBEBEB;margin-bottom: 20px;">
	  		
	  		<table align="center" width= "100%" style="border-bottom: 1px solid rgb(204, 204, 204); padding-top: 10px; padding-bottom: 10px;border-collapse: unset;">
						<tr>
							<td colspan="4" style="padding-bottom: 10px;"><h4 class="tableHeader">Document Detail Information</h4></td>
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
										<%
									if(versionNum < 0) {
										if(versionNum == -999){
											versionNum = 0L;
										}
										else{
											versionNum = -versionNum;
										}
									} 
									%>
									<%
									String prevVersion = "N";
									if(versionNum > 1){
										prevVersion = "Y";
									}
									%>
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
       <div class="card" style="width: 95%;padding-left: 0px;">
	  		<div  class="card-body card-padding" style="background-color:#EBEBEB;margin-bottom: 20px;">
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
<td width="142" valign="top"><% out.print(sesslog.getFieldName()); %></td>
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
		</div></div>
      </div>
    </div>
  </div>
</div>
		


<script language="javascript">

var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object
function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}


function initialLoad() {
	  $(".headPageContainer").hide();
	  $(".userInformaiton").hide();	
	  $(".mainBlueHeading").hide();
	  $("#headertext").hide();
	getdropdowns();
	setHeader('editDocProfile.jsp');
	//Initialize slider menu
     $('#simple-menu').sidr();
     
  	$('.child').hide();
  	$('.parent').click(function() {
	 	$('.child').slideUp();
	 	$(this).find('ul').slideToggle();
  	});
  	$('#docManagementLi').click();	 
}

function getdropdowns()
{	  
    var comid = '<%= cid %>';
    var id = '<%=fileName%>';
   
  //  var   documentData=[];
  //  var docId=id.substr(id.lastIndexOf('/')+1);
  //  documentData=docId.split('.');
    sessionStorage.setItem('sessLogCompId',comid);
 
   sessionStorage.setItem('sessLogSessid','<%=sessionid%>' );
   
   sessionStorage.setItem('sessLogRestUrl','<%=restURL%>' );
    
    sessionStorage.setItem('sessLogUserid','<%=uid%>' );
    sessionStorage.setItem('sessLogver','<%=version%>');
    sessionStorage.setItem('sessLogdocid',id ); 
     
      	    $.ajax({
	            type: "GET",
	            url:"GetPropertyDropdown?comid="+comid,
	            dataType: "json",
	            success: function (data) {
	                $.each(data.propertyData,function(i,obj)
	                {
	                 	var div_data="<option value="+obj.value+">"+obj.text+"</option>";
	                 	var propertyTypeIds = '<%=request.getParameter("propertyId").toString()%>';
	                 	if(obj.text == propertyTypeIds){
							div_data="<option value="+obj.value+" selected>"+obj.text+"</option>";
						}
						
	                	$(div_data).appendTo('#propertytype'); 
	                });   
                	
	               }
	          });
	           $.ajax({
	            type: "GET",
	            url:"GetFolderDropdown?comid="+comid,
	            dataType: "json",
	            success: function (data) {
	                $.each(data.folderData,function(i,obj)
	                {
	                 	var div_data="<option value="+obj.value+">"+obj.text+"</option>";
	                 	var folderNm = '<%=request.getParameter("folderName")%>';
	                 	//var str = '/Test001/567/Production/Accounts Receivable Financing/</br>/Test001/567/Production/Closing/';
						var myarray = folderNm.split('</br>');
						for(i = 0; i < myarray.length; i++){
						if(obj.text == myarray[i]){
							div_data="<option value="+obj.value+" selected>"+obj.text+"</option>";
							//alert(div_data);
						}
						}
	                	$(div_data).appendTo('#folderId'); 
	                });   
                	
	               }
	          });
	          
           $.ajax({
            type: "GET",
            url:"GetDocTypeDropdown?comid="+comid,
            dataType: "json",
            success: function (data) {
                $.each(data.docTypeData,function(i,obj)
                {
                 	var div_data="<option value="+obj.value+">"+obj.text+"</option>";
                 	var docTypeIds = '<%=request.getParameter("docTypeId").toString()%>';
                 	if(obj.value == docTypeIds){
						div_data="<option value="+obj.value+" selected>"+obj.text+"</option>";
					}
					
                	$(div_data).appendTo('#doctype'); 
                });
               
                }
          });
           
         
        	   
        	   var companyIdValue= '<%= cid %>';
        		$.ajax({
        			type : "GET",
        			contentType : "application/json",
        			url : "<%=restURL%>/orcf/getTransactionTypes?companyId="+companyIdValue,
        			dataType : 'json',
        			timeout : 100000,
        			success : function(data) {
        			     for(i=0;i<data.response.length;i++){
        			         $("#transactionType").append("<option value='"+data.response[i].transactionType+"'><b>"+data.response[i].transactionType+"</b></option>");
        			      	if(data.response[i].transactionType === '<%=transactionType%>'){
        			      		$("#transactionTypeId").append(data.response[i].transactionTypeId);        			      		
        			     		div_data="<option value="+data.response[i].transactionType+" selected>"+data.response[i].transactionType+"</option>";
        			     		 $(div_data).appendTo('#transactionType'); 
        			     	}
        			       }   
        		
        		                }
        			   
        		}); 
          
           
          
           $.ajax({
            type: "GET",
            url:"GetIndexTypeDropdown?comid="+comid,
            dataType: "json",
            success: function (data) {
                $.each(data.indexTypeData,function(i,obj)
                {
                 	/*var div_data="<option value="+obj.value+">"+obj.text+"</option>";
                	$(div_data).appendTo('#indextype1'); 
                	$(div_data).appendTo('#indextype2');
                	$(div_data).appendTo('#indextype3');
                	$(div_data).appendTo('#indextype4');
                	$(div_data).appendTo('#indextype5');*/
           			addIndexOption(document.getElementById("indextype1"), obj.text, obj.value, '0');
           			                 	
                	
                });
                
                if('<%=status%>' == 'Inactive'){
		document.getElementById("propertytype").disabled=true;
	
		document.getElementById("folderId").disabled=true;
	
		document.getElementById("doctype").disabled=true;
		
		document.getElementById("indextype1Dis").value = document.getElementById("indextype1").value;
		document.getElementById("indextype1").disabled=true;
		
		
		document.getElementById("indexval1Dis").value = document.getElementById("indexval1").value;
		document.getElementById("indexval1").disabled=true;
		
		
	}	
	parseStatus();
                 
                }
                
          });
           getTransactionStatus();        
}
function getTransactionStatus(){
	   
	   var companyIdValue= '<%= cid %>';
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getTransactionStatus?companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
		    	 $("#transactionStatus").append("<option value='' selected><b>Select Transaction Status</b></option>");
			     for(i=0;i<data.response.length;i++){
			    	 	if(data.response[i].transactionStatusDesc === '<%=transactionStatus%>'){
					         $("#transactionStatus").append("<option value='"+data.response[i].transactionStatusDesc+"' selected><b>"+data.response[i].transactionStatusDesc+"</b></option>");
	}else{
			         $("#transactionStatus").append("<option value='"+data.response[i].transactionStatusDesc+"'><b>"+data.response[i].transactionStatusDesc+"</b></option>");
			     
// 			     		div_data="<option value="+data.response[i].transactionStatusDesc+" selected>"+data.response[i].transactionStatusDesc+"</option>";
// 			     		 $(div_data).appendTo('#transactionStatus'); 
			     	}
			       }   
		
		                }
// 			success : function(data) {
// 			       for(i=0;i<data.response.length;i++){
// 			         $("#transactionStatus").append("<option value='"+data.response[i].transactionStatusDesc+"'><b>"+data.response[i].transactionStatusDesc+"</b></option>");
// 			      }  
// 			   }
		                ,
			error : function(e) {
				console.log("error");	
			},
			done : function(e) {
				console.log("DONE");
			}
		}); 
}
function setTransactionStatusValue(){
	var changedVal=$("#transactionStatus").val();
	$("#transactionStatus1").val(changedVal);
}
/*function getdropdowns() {
	
	var queryString = "compid="+compid+"&countProjects=false";

	if(xmlhttp) { 
	    // xmlhttp.open("GET",URL,true); 
	    xmlhttp.open("POST","GetDropdownOptions",true); 
	    xmlhttp.onreadystatechange  = handleServerResponse;
	    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlhttp.send(queryString);
   } 
}*/


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
function handleServerResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	parseData(xmlhttp.responseText);
     }    
     else {
        alert(xmlhttp.status);
     }
   }
}

var index = new Array();
var documentdata = new Array();
var propertydata = new Array();
var folderData = new Array();


function parseData(data) {
	var row = data.split('$');
	var indexstr = row[0];
	var docstr = row[1];
	var propertystr = row[2];
	var folderStr = row[3];
	
	parseindexstr(indexstr);
	parsedocstr(docstr);
	
	
	if('<%=status%>' == 'Inactive'){
		document.getElementById("propertytype").disabled=true;
	
		document.getElementById("folderId").disabled=true;
	
		document.getElementById("doctype").disabled=true;
		
		document.getElementById("indextype1Dis").value = document.getElementById("indextype1").value;
		document.getElementById("indextype1").disabled=true;
		
		document.getElementById("indexval1Dis").value = document.getElementById("indexval1").value;
		document.getElementById("indexval1").disabled=true;
		
		
	}	
	parseStatus();
	
	parsepropertystr(propertystr);
	 
	parseFolderStr(folderStr); 
	
}

function parseindexstr(indexstr) {
	var row = indexstr.split('|');
	index.length = 0;
	for (var i=0; i<row.length-1; i++) {
	  var col = row[i].split('^');
	  index[i]= new Array(col[0],col[1]);
	  // alert(index[i][0]+"="+index[i][1]);
    }
    
    for (var i=0; i < index.length;++i){
    	
		addIndexOption(document.getElementById("indextype1"), index[i][0], index[i][1], '0');
		
	}
}

function parsedocstr(docstr) {
	var row = docstr.split('|');
	documentdata.length = 0;
	for (var i=0; i<row.length-1; i++) {
	  var col = row[i].split('^');
	  documentdata[i]= new Array(col[0],col[1]);
	  //alert(documentdata[i][0]+"="+documentdata[i][1]+"<-- doctypeid -->"+<%//=request.getParameter("docTypeId").toString()%>);
    }
    
    for (var i=0; i < documentdata.length;i++){
    	addOption(document.getElementById("doctype"), documentdata[i][0], documentdata[i][1]);
    }
    
}

function parsepropertystr(propertystr) {
//alert("Inside propertystr "+propertystr)
	var row = propertystr.split('|');
	propertydata.length = 0;
	for (var i=0; i<row.length-1; i++) {
	  var col = row[i].split('^');
	  propertydata[i]= new Array(col[0],col[1]);
	   //alert(documentdata[i][0]+"="+documentdata[i][1]);
    }
    
    for (var i=0; i < propertydata.length;++i){
    	addPropertyOption(document.getElementById("propertytype"), propertydata[i][0], propertydata[i][1]);
    }
    
}

function parseFolderStr(folderStr) {
	var row = folderStr.split('|');
	folderData.length = 0;
	for (var i=0; i<row.length-1; i++) {
	  var col = row[i].split('^');
	  folderData[i]= new Array(col[0],col[1]);
	   //alert(folderData[i][0]+"="+folderData[i][1]);
    }
    
    for (var i=0; i < folderData.length;++i){
    	addFolderOption(document.getElementById("folderId"), folderData[i][0], folderData[i][1]);
    }
    
}

function parseStatus(){
	var selectbox = document.getElementById("docStatus");
	
	var optn = document.createElement("OPTION");
	optn.text = 'Active';
	optn.value = 'Active';
	
	var docStatus = '<%=status%>';
	if('Active' == docStatus){
		optn.selected = true;
	}
	selectbox.options.add(optn); 
	
	var optn = document.createElement("OPTION");
	optn.text = 'Inactive';
	optn.value = 'Inactive';
	var docStatus = '<%=status%>';
	if('Inactive' == docStatus){
		optn.selected = true;
	}
	selectbox.options.add(optn); 

}

function addOption(selectbox,text,value )
{
	var optn = document.createElement("OPTION");
	optn.text = text;
	optn.value = value;
	var docTypeIds = '<%=request.getParameter("docTypeId").toString()%>';
	
	if(value == docTypeIds){
		optn.selected = true;
	}
	
	selectbox.options.add(optn);
}
function addPropertyOption(selectbox,text,value )
{
	var optn = document.createElement("OPTION");
	optn.text = text;
	optn.value = value;
	var propertyTypeIds = '<%=request.getParameter("propertyId").toString()%>';
	if(text == propertyTypeIds){
		optn.selected = true;
	}
	
	selectbox.options.add(optn);
}

function addFolderOption(selectbox,text,value )
{
	var optn = document.createElement("OPTION");
	optn.text = text;
	optn.value = value;
	var folderNm = '<%=request.getParameter("folderName").toString()%>';
	if(text == folderNm){
		optn.selected = true;
	}
	
	selectbox.options.add(optn);
}


function addIndexOption(selectbox,text,value,fieldNumber )
{
	var optn = document.createElement("OPTION");
	optn.text = text;
	optn.value = value;
		
	var vectorSize = <%=indexTypeIdVal.size()%>;
	
	if(fieldNumber == '0'){
		<%if(indexTypeIdVal.size() >= 1){%>
			var idVal = '<%=indexTypeIdVal.get(0)%>';
			
			var id = idVal.substring(0,idVal.indexOf("^"));
			
			if(value == id){
				optn.selected = true;
			}
			
			document.getElementById("indexval1").value = idVal.substring(idVal.indexOf("^")+1, idVal.lastIndexOf("^"));
			document.getElementById("rowid1").value  = idVal.substring(idVal.lastIndexOf("^")+1, idVal.length);
			
			var indexval1 = document.getElementById("indexval1").value;
			if(indexval1 == ''){
				var optn1 = document.createElement("OPTION");
				optn1.text = '';
				optn1.value = '';
				optn1.selected = true;
				document.getElementById("indextype1").options.add(optn);
			}
		<%}%>
	}
	
	selectbox.options.add(optn);
}




function replaceDoc(){
	document.editForm.action = "./replaceDocument.jsp";
	document.editForm.submit();
	
}

function editDocProfile(){
	document.editForm.action = "./editDocProfile.jsp";
	document.editForm.submit();
}

function validateForm()
{	
	//Check if doctype field contains value
	if(document.getElementById('doctype').value == "" ) 
	{
		alert("Please Select Document Type Field.");
		return false;		
	}//Check if index type field contains value
	else if(document.getElementById('indextype1').value  == "") 
	{
		alert("Please Select Index Type.");
		return false;		
	}//Check if value field contains value
	else if(document.getElementById('indexval1').value == ""  ) 
	{
		alert("Please Enter Index Value.");
		return false;		
	}
	else if(document.getElementById('folderId').value == ""  ) 
	{
		alert("Please Select Folder.");
		return false;		
	}	
	return true;	
}

function onSave()
{
	if(validateForm())
	{
		document.editForm.action = "./EditDocProfile?formAction=save";
		document.editForm.submit();
	}
}

function onCancel()
{
	history.back(1);
}

function getPdf() {
	var user = '<%= uid%>';
	
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var version = '<%= version%>';
	var id = '<%=fileName%>';
	
	var fileNameExtension = id.substr(id.lastIndexOf('.') + 1);
	var action="";
	
	if(fileNameExtension=="pdf"){
		action="View Document";
	}else{
		action="Download Document";
	}
	
	//var docId=id.substr(id.lastIndexOf('/')+1);
	//var documentData=[];
	//documentData=docId.split('.');
	var documentData={
			 "sessionId":session,
			 "userId":user,
			 "companyId":com,
			 "documentId":id,
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
	
/* 	var Text = "./DisplayPdf?id="+id+"&comid="+com+"&sessionid="+session+"&userName="+userName;
 */	
<%-- 	var pdfurl = '<%=restURL%>'+"/role/ResponseBodyStreamFixed?id="+ id;

	window.open(pdfurl,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
	 
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
	  						'toolbar=no,status=no,menubar=1,scrollbars=no,resizable=1,left=15000, top=15000, width=50, height=50, visible=none',
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
function searchSel() 
    {
      var input = document.getElementById('realtxt').value.toLowerCase();
       
          len = input.length;
          output = document.getElementById('propertytype').options;
      for(var i=0; i<output.length; i++)
          if (output[i].text.toLowerCase().indexOf(input) != -1 ){
          output[i].selected = true;
          break;
          }
      if (input == '')
      {
        var propertyTypeIds = '<%=request.getParameter("propertyId").toLowerCase()%>';
        for(var i=0; i<output.length; i++)
          if (output[i].text.toLowerCase().indexOf(propertyTypeIds) != -1 ){
          output[i].selected = true;
          }
      }
    }
    
 function searchFolSel()
 {
 	      var input = document.getElementById('foltxt').value.toLowerCase();
       
          len = input.length;
          output = document.getElementById('folderId').options;
      for(var i=0; i<output.length; i++)
          if (output[i].text.toLowerCase().indexOf(input) != -1 ){
          output[i].selected = true;
          break;
          }
      if (input == '')
      {
        var folderNm = '<%=request.getParameter("folderName").toLowerCase()%>';
        for(var i=0; i<output.length; i++)
          if (output[i].text.toLowerCase().indexOf(folderNm) != -1 ){
          output[i].selected = true;
          }
      }
 
 }
</script>

</form>
</body>

</html>
