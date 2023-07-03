<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/stylelager.css"></link>
<script src="js/jQuery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="css/jquery.dataTables.min.css" />
<!-- Include the Sidr JS -->
<script src="js/jquery.sidr.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="js/jQuery/jquery-ui.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
<script src="js/bootstrap.min.js"></script>




<title>Insert title here</title>
<style type="text/css">
#datepicker {
	margin: 0;
}

.table>thead>tr>th, table-data thead tr {
	background-color: #7098CC;
	color: #fff !important;
}

@media ( max-width : 1920px) {
	#issueDescription {
		width: 100%
	}
}

.input-group {
	width: 20%;
	float: left;
	margin-bottom: 10px;
	border-radius: 4px;
}

.table-data tbody tr td img {
	float: none;
}
/* Absolute Center Spinner */
.loading {
	position: fixed;
	z-index: 999;
	overflow: show;
	margin: auto;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	width: 50px;
	height: 50px;
	display: none;
}

/* Transparent Overlay */
.loading:before {
	display: block;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(255, 255, 255, 0.5);
}

/* :not(:required) hides these rules from IE9 and below */
.loading:not (:required ) {
	/* hide "loading..." text */
	font: 0/0 a;
	color: transparent;
	text-shadow: none;
	background-color: transparent;
	border: 0;
}

.loading:not (:required ):after {
	content: '';
	display: block;
	font-size: 10px;
	width: 50px;
	height: 50px;
	margin-top: -0.5em;
	border: 5px solid rgba(33, 150, 243, 1.0);
	border-radius: 100%;
	border-bottom-color: transparent;
	-webkit-animation: spinner 1s linear 0s infinite;
	animation: spinner 1s linear 0s infinite;
}

/* Animation */
@
-webkit-keyframes spinner { 0% {
	-webkit-transform: rotate(0deg);
	-moz-transform: rotate(0deg);
	-ms-transform: rotate(0deg);
	-o-transform: rotate(0deg);
	transform: rotate(0deg);
}

100%
{
-webkit-transform
:
 
rotate
(360deg);

    
-moz-transform
:
 
rotate
(360deg);

    
-ms-transform
:
 
rotate
(360deg);

    
-o-transform
:
 
rotate
(360deg);

    
transform
:
 
rotate
(360deg);

  
}
}
@
-moz-keyframes spinner { 0% {
	-webkit-transform: rotate(0deg);
	-moz-transform: rotate(0deg);
	-ms-transform: rotate(0deg);
	-o-transform: rotate(0deg);
	transform: rotate(0deg);
}

100%
{
-webkit-transform
:
 
rotate
(360deg);

    
-moz-transform
:
 
rotate
(360deg);

    
-ms-transform
:
 
rotate
(360deg);

    
-o-transform
:
 
rotate
(360deg);

    
transform
:
 
rotate
(360deg);

  
}
}
@
-o-keyframes spinner { 0% {
	-webkit-transform: rotate(0deg);
	-moz-transform: rotate(0deg);
	-ms-transform: rotate(0deg);
	-o-transform: rotate(0deg);
	transform: rotate(0deg);
}

100%
{
-webkit-transform
:
 
rotate
(360deg);

    
-moz-transform
:
 
rotate
(360deg);

    
-ms-transform
:
 
rotate
(360deg);

    
-o-transform
:
 
rotate
(360deg);

    
transform
:
 
rotate
(360deg);

  
}
}
@
keyframes spinner { 0% {
	-webkit-transform: rotate(0deg);
	-moz-transform: rotate(0deg);
	-ms-transform: rotate(0deg);
	-o-transform: rotate(0deg);
	transform: rotate(0deg);
}
100%
{
-webkit-transform
:
 
rotate
(360deg);

    
-moz-transform
:
 
rotate
(360deg);

    
-ms-transform
:
 
rotate
(360deg);

    
-o-transform
:
 
rotate
(360deg);

    
transform
:
 
rotate
(360deg);

  
}
}
</style>
<%
	javax.naming.Context ctx = new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	String URL = (String) ctx.lookup("java:comp/env/URL");
	java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");
	String date = simpleDateFormat.format(new java.util.Date());
%>




</head>
<body>
	<section>
	<div class="container-fluid">

		<div class="row" style="min-height: 600px; border: 1px solid #a5a1a1;">

			<div class="loading">Loading&#8230;</div>

			<div class="search-form">

				<div class="col-sm-12 ">
					<form>


						<div class="row">
							<div class="col-sm-3">
								<a id="backBtn1"
									class="btn btn-success pull-left btn-orange width120"
									href="dashboardRMS.jsp"
									style="font-weight: bold; margin-top: 18px;">
									<div class="d-table">
										<div class="d-tbcell v-middle">
											<i class="zmdi_medium zmdi zmdi-caret-left-circle"></i>
										</div>
										<div class="p-left10 d-tbcell v-middle">Back</div>
									</div>
								</a>

							</div>
							<div class="col-sm-5">
								<h2>Create Ticket</h2>

							</div>
						</div>



						<hr>


						<div class="form-group">
							<div class="row">
								<div class="col-lg-12" style="margin-top: 3px;">
									<div class="d-table pull-left">
										<span id="result" style="color: red"></span>
									</div>
									<div class="d-table pull-right">
										<div>Application Name</div>
										<select id="helpdeskname" style="height: 25px; width: 175px;">
											<option value="" selected="" disabled="">Select
												Application Name</option>

										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-1"></div>
							<div class="col-lg-10">


								<div class="form-group">
									<div class="row">
										<div class="col-lg-12">
											<div class="row">
												<div class="col-sm-3 text-left">

													<label style="margin-right: 120px;">Ticket ID</label>
													<div>
														<input id="ticketId" class="form-control" type="text"
															placeholder="Ticket ID" readonly
															style="height: 28px; width: 175px;" />

													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-3 text-left">
											<label style="margin-right: 100px;">Creation Date</label>
											<div>
												<input id="creationDate" class="form-control" type="text"
													placeholder="Creation Date" readonly value="<%=date%>"
													style="height: 28px; width: 175px;" />
											</div>
										</div>
										<div class="col-sm-3 text-left">
											<label style="margin-right: 100px;">Priority <span
												class="requiredStar">*</span>
											</label>
											<div>
												<select id="priority" style="height: 25px; width: 175px;">
													<option value="" selected="" disabled="">Select
														Priority</option>
												</select>
											</div>
										</div>
										<div class="col-sm-4 text-left">
											<label style="margin-right: 120px;">Category Type <span
												class="requiredStar">*</span>
											</label>
											<div>
												<select id="categorytype" onchange="getSubCategory()"
													style="height: 25px; width: 175px;">
													<option value="" selected="" disabled="">Select
														Category type</option>

												</select>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
										<div class="col-sm-3 text-left">
											<label style="margin-right: 100px;">Request By <span
												class="requiredStar">*</span>
											</label>
											<div>
												<select id="requestedby" style="height: 25px; width: 175px;">
													<option value="" selected="" disabled="">Select
														Request By</option>

												</select>
											</div>
										</div>
										<div class="col-sm-3 text-left">
											<label style="margin-right: 100px;">Action Type </label>
											<div>
												<select id="actionType" style="height: 25px; width: 175px;">
													<option value="" selected="" disabled="">Select
														Action Type</option>
												</select>
											</div>
										</div>
										<div class="col-sm-4 text-left">
											<label style="margin-right: 120px;">Subcategory Type
											</label>
											<div>
												<select id="subcategoryId"
													style="height: 25px; width: 175px;">
													<option value="" selected="" disabled="">Select
														Subcategory type</option>

												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-4 text-left">
											<label style="margin-right: 100px;">Ticket Title <span
												class="requiredStar">*</span><sub> (Short Description)</sub>
											</label>
											<div>
												<input id="ticketTitle" class="form-control" type="text"
													placeholder="Ticket Title" style="height: 28px;" />
											</div>
										</div>




										<div class="col-sm-5 text-left">
											<label style="margin-right: 100px;">Contact Type <span
												class="requiredStar">*</span></label>
											<div>
												<select id="contactType" style="height: 25px; width: 175px;">
													<option value="" selected="" disabled="">Select
														Contact Type</option>
												</select>
											</div>
										</div>
										
										<div class="col-sm-5 text-left">
											<label style="margin-right: 100px;">Department <span
												class="requiredStar">*</span></label>
											<div>
												<select id="departments" style="height: 25px; width: 175px;">
													<option value="" selected="" disabled="">Select Department Type</option>
													<option value="HR Department" >HR Department</option>
													<option value="Admin Department" >Admin Department</option>
													<option value="IT Department" >IT Department</option>
												</select>
											</div>
										</div>


									</div>
								</div>

								<div class="form-group">
									<div class="row ">
										<div class="col-sm-9 text-left">
											<label style="margin-right: 100px;">Ticket
												Description <span class="requiredStar">*</span> <sub>
													(Detailed Description)</sub>
											</label>

											<textarea id="issueDescription" rows="4"
												style="border: 1px solid #ccc;" class="form-control"
												placeholder="Ticket Description"></textarea>
										</div>

									</div>
								</div>

								<!-- 								<div class="form-group">
									<div class="row">
										<div class="col-sm-5">
											<label class="control-label col-sm-4">Recreation
												Steps</label>
											<div class="col-sm-5">
												<textarea id="recreationSteps" rows="2"
													style="width: 176px; border: 1px solid #ccc;"
													class="form-control" placeholder="Recreation Steps"> 
							</textarea>
											</div>
										</div>
										<div class="col-sm-5">
											<label class="control-label col-sm-4">Creation Date</label>
											<div class="col-sm-5">
												<input id="creationDate" class="form-control" type="text"
													placeholder="Creation Date" readonly
													style="height: 28px; width: 175px;" />


											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
										<div class="col-sm-5">
											<label class="control-label col-sm-4">Comment log
												External</label>
											<div class="col-sm-5">
												<textarea id="logExternal" rows="2"
													style="width: 176px; border: 1px solid #ccc;"
													class="form-control" placeholder="Comment log External"> 
							</textarea>
											</div>
										</div>
										<div class="col-sm-5">
											<label class="control-label col-sm-4">Comment log
												Internal</label>
											<div class="col-sm-5">
												<textarea id="logInternal" rows="2"
													style="width: 176px; border: 1px solid #ccc;"
													class="form-control" placeholder="Comment log Internal"> 
							</textarea>

											</div>
										</div>
									</div>
								</div> -->
								<div class="form-group">
									<div class="row">
										<div style="text-align: left; margin-left: 11px">Attachments</div>
										<div class="col-sm-5 text-left">



											<input type="file" id="file0" onchange="filechange()"
												style="width: 187px; float: left;" name="files" multiple />

											<input id="Button1" type="button" value="add"
												onclick="AddFileUpload()" /> <input id="Buttonr1"
												type="button" value="Remove" onclick="RemoveFile()">
											<br /> <br />

											<div id="FileUploadContainer">

												<!--FileUpload Controls will be added here -->

											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
						<div class="sub-btns">
							<button type="button" class="btn btn-success"
								onclick="searchbyId()">Submit</button>
							<input type="reset" class="btn resettable btn-danger"
								value="Reset" />
						</div>
					</form>
				</div>


				<br> <br> <br> <br>


			</div>
		</div>
		<form style="display: none" method="POST"
			enctype="multipart/form-data" id="fileUploadForm1">



			<input type="submit" value="Submit" id="btnSubmit1" />
		</form>
	</div>
	</section>

	<script type="text/javascript">
	
    $('.resettable').click(function() {
    	$('#datepicker1').datepicker('setDate', null);
    	
});
    $(document).mousemove(function(event){
		  InitializeTimer();
	  });
	
    $(function() {
    	getHeaderusername();
    	getPriority();
    	getUserName();
    	getStatus();
    	 getCategory();
    	 getApplications();
    	 getContactType();
    	 getTicketId();
    	setHeader('IREMSDocumentSearch.jsp');
    	$("#loadingImage").hide();
    	/* $(".workingAreaBlueHeading").html('<div style="margin-top: 5px;">'+
    			'<img src="images/PPT.png " alt="PPT" style=" width: 62px;     margin-left: -13%;position: absolute;  transform: skewY(350deg);"/>'+
    			'<div> <p style="font-size: 14px;margin-top: 1px;color: black;text-transform: none;    font-weight: 400;"> &nbsp  Typing in the Document Type of your choice<br> will show Enhanced Searching Capabilities.</p>'+
    				 ' </div> </div> '); */
    	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
    	for (var i = 0; i < array_of_li.length; i++) {
    		if(array_of_li[i].textContent.trim()=='Home'){
    		array_of_li[i].setAttribute("class", "active");	
    	}
    		
    	}
		
		
    });
   function checkvalid(priority,categorytype,requestedby,ticketTitle,contactType,issueDescription){
	   var value=true;
	   
	   var regx="[<>%\$]";
		 var title=ticketTitle.match(regx);
		 var description=issueDescription.match(regx);
		 
		 if(title || description){  
			 alert("Invalid chracters");
		 		return false;
			}
	   
	   if(!priority){
		   $("#result").text(" Select Priority").css("color", "red");
		   return false;  
	   }
	   if(!categorytype){
		   $("#result").text(" Select Category Type").css("color", "red");
		   return false;  
	   }
	   if(!requestedby){
		   $("#result").text(" Select Requested By").css("color", "red");
		   return false;  
	   }
	   if(!ticketTitle){
		   $("#result").text(" Enter Ticket Title").css("color", "red");
		   return false;  
	   }
	   if(!contactType){
		   $("#result").text(" Select Contact Type").css("color", "red");
		   return false;  
	   }
	   if(!issueDescription){
		   $("#result").text(" Enter issue Description").css("color", "red");
		   return false;  
	   }
	   return value;
   }
    function searchbyId(){
    	
    	
    	 var uid = sessionStorage.getItem("userId");
    	var appname=$('#helpdeskname').find(":selected").val();
    	var ticketTitle= $('#ticketTitle').val();
    	var priority=$('#priority').find(":selected").val();
    	var categorytype=$('#categorytype').find(":selected").val();
    	var subcategoryId= $('#subcategoryId').val();
    	var requestedby= $('#requestedby').val();
    	var actionType= $('#actionType').val();
    	var contactType= $('#contactType').val();
    	var departments=$('#departments').val();
    	var issueDescription= $('#issueDescription').val();
    	var recreationSteps= $('#recreationSteps').val();
    	var logExternal= $('#logExternal').val();
    	var logInternal= $('#logInternal').val();
    	var check=checkvalid(priority,categorytype,requestedby,ticketTitle,contactType,issueDescription.trim());
    	var inputdata=JSON.stringify({reqfrom:'RMS',to_email:JSON.parse(sessionStorage.getItem("roles")).email,contact_Type:contactType,department:departments,requested_by:requestedby,supervisorEmail:'',Ticket_title:ticketTitle,Action_type:actionType,Application_id:appname,Category_type:categorytype,Comments_internal:logInternal,Comments_external:logExternal,Created_by:JSON.parse(sessionStorage.getItem("roles")).user_id,Item_desc:issueDescription,Priority:priority,Recreate_steps:recreationSteps,
    		Sub_category_type:subcategoryId,
    		created_username:sessionStorage.getItem("username"),
    		created_by_name	 : JSON.parse(sessionStorage.getItem('roles')).fname+' '+JSON.parse(sessionStorage.getItem('roles')).lname,
    		userId : uid
    		});
		var fileSelect = document.getElementById('files');
    	var formData = new FormData();
    	var form1 = $('#fileUploadForm1')[0];

	    var data = new FormData(form1);
	   
		    $.each($("input[type='file']")[0].files, function(i, file) {
			    console.log(i)
		        data.append('documents', file);
		    });
	    data.append('ticketDetails',inputdata);
    	var token=sessionStorage.getItem("token");
    	if(check){
    			$("#result").text("");
    			$(".loading").show();
    			
    			$.ajax({
    				 type: "POST",
    			    enctype: 'multipart/form-data',
    		 		url : "<%=restURL%>rmshd/addTicket",
    		 		 headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
    		 		data: data,
    		 		 processData: false, //prevent jQuery from automatically transforming the data into a query string
    			        contentType: false,
    			        cache: false,
    			        timeout: 0,
    		 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
    		 		success : function(response) 
    		 		{
    		 			$(".loadingImage").hide();
   		 				
   		 				
  				   		  if(response.status=="200"){
  				   		 $("#result").text("Ticket Successfully Created").css("color", "green");
  				   	setTimeout(function() {
  				  	location.reload();
  					}, 1000);
  				   
  				   		  }else{
  				   			$("#result").text(response).css("color", "red");
  				   			  }
  				   	
  				   		  
  				   		
  				   
    		 		 
    		 		  },
    		 		 error : function(xhr, status, textError) 
    		 		     {
    		 			$("#result").text(xhr.responseText).css("color", "red");
    		 			$(".loadingImage").hide();
    				     }
    		 		    }); 
    	}
    			
    }
    var counter = 1;
    function filechange(){
    	if( document.getElementById("file0").files.length==1){
    		$("#Buttonr1").css("visibility", "visible");
    	}
    }
    function AddFileUpload() {
    	var id=counter-1 ;
    	if( document.getElementById("file" + id ).files.length==1){
    		 $("#result").text("");
    		 var div = document.createElement('DIV');
             div.style='margin-bottom: 10px';

             div.innerHTML = '<input id="file' + counter + '" style=" width: 187px; float: left;" name = "file' + counter +

                             '" type="file" />' +

                             '<input id="Button' + counter + '" type="button" ' +

                             'value="Remove" onclick = "RemoveFileUpload(this)" />';

             document.getElementById("FileUploadContainer").appendChild(div);

             counter++;
    	}else{
      		 $("#result").text("Please select file").css("color", "red");
       	}
        

    }
    function RemoveFile()
    {
             document.getElementById("file0").value="";
             $("#Buttonr1").css("visibility", "hidden");

    }

    function RemoveFileUpload(div)

    {
             document.getElementById("FileUploadContainer").removeChild(div.parentNode);

    }
    function getTicketId(){
    	$("#Buttonr1").css("visibility", "hidden");
    	var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getTicketId",
             dataType: "json",
             headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
             success: function (data) {
             	//alert("619::"+data.docTypeData[0].value);
             		
$('#ticketId').val(data.ticketId);
                
                
                 } 
           });
    }
    function getPriority(){
    	var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getPriority",
             dataType: "json",
             headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
             success: function (data) {
             	//alert("619::"+data.docTypeData[0].value);
             		

                 $.each(data.priority,function(i,obj)
                 		
                 {                	
                 	var	div_data="<option value='"+obj.dropdown_name+"'>"+obj.dropdown_name+"</option>";
                 	$(div_data).appendTo('#priority'); 
                 	
                 });
                
                 } 
           });
    }
    function getUserName(){
    	var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getUsers?type=Y&cid="+ JSON.parse(sessionStorage.getItem('roles')).company_ID,
             dataType: "json",
             headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
             success: function (data) {
             	//alert("619::"+data.docTypeData[0].value);
             		

                 $.each(data.users,function(i,obj)
                 		
                 {                	
                 	var	div_data="<option value="+obj.dropdown_id+">"+obj.dropdown_name+"</option>";
                 	$(div_data).appendTo('#requestedby'); 
                 	
                 });
                
                 } 
           });
    }
    
    function getStatus(){
    	var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getStatus",
             dataType: "json",
             headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
             success: function (data) {
             	//alert("619::"+data.docTypeData[0].value);
             		$('#actionType').find('option').remove();
$('#actionType').append("<option value=''>Select Action type</option>");

                 $.each(data.statuslist,function(i,obj)
                 		
                 {                	
                 	var	div_data="<option value='"+obj.dropdown_name+"'>"+obj.dropdown_name+"</option>";
                 	$(div_data).appendTo('#actionType'); 
                 	
                 });
                
                 } 
           });
    }
   
    function getApplications(){
    	var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getApplications",
             dataType: "json",
             headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
             success: function (data) {
             	//alert("619::"+data.docTypeData[0].value);
             		

                 $.each(data.apps,function(i,obj)
                 		
                 {                	
                	 var	div_data="";
                     if(JSON.parse(sessionStorage.getItem("roles")).company_ID==obj.dropdown_id) {
                    			div_data+="<option value="+obj.dropdown_id+" selected>"+obj.dropdown_name+"</option>";
                    			$("#helpdeskname").prop("disabled", true);
                         } else{
                        			div_data+="<option value="+obj.dropdown_id+">"+obj.dropdown_name+"</option>";
                             }            	
                 	$(div_data).appendTo('#helpdeskname');  
                 	
                 });
                
                 } 
           });
    }
    function getContactType(){
    	var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getContactType",
				dataType : "json",
				headers : {
					'Access-Control-Allow-Origin' : '*',
					'Authorization' : 'Bearer ' + token
				},
				success : function(data) {
					//alert("619::"+data.docTypeData[0].value);

					$.each(data.contactType, function(i, obj)

					{
						var div_data = "<option value="+obj.dropdown_id+">"
								+ obj.dropdown_name + "</option>";
						$(div_data).appendTo('#contactType');

					});

				}
			});
		}
    function getCategory(){
    	var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getCategory",
				dataType : "json",
				headers : {
					'Access-Control-Allow-Origin' : '*',
					'Authorization' : 'Bearer ' + token
				},
				success : function(data) {
					//alert("619::"+data.docTypeData[0].value);

					$.each(data.category, function(i, obj)

					{
						var div_data = "<option value="+obj.dropdown_id+">"
								+ obj.dropdown_name + "</option>";
						$(div_data).appendTo('#categorytype');

					});

				}
			});
		}
    function getSubCategory(){
    	var id= $("#categorytype").val();
    	var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getSubCategory?categoryId="
								+ id,
						dataType : "json",
						headers : {
							'Access-Control-Allow-Origin' : '*',
							'Authorization' : 'Bearer ' + token
						},
						success : function(data) {
							//alert("619::"+data.docTypeData[0].value);
							$('#subcategoryId').find('option').remove();
							$('#subcategoryId')
									.append(
											"<option value=''>Select Subcategory type</option>");
							$
									.each(
											data.category,
											function(i, obj)

											{
												var div_data = "<option value="+obj.dropdown_id+">"
														+ obj.dropdown_name
														+ "</option>";
												$(div_data).appendTo(
														'#subcategoryId');

											});

						}
					});
		}
	</script>

</body>
</html>