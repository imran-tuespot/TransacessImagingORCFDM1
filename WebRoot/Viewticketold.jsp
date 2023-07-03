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

.input-group {
	width: 20%;
	float: left;
	margin-bottom: 10px;
	border-radius: 4px;
}
.table-data tbody tr td img {
    float: none;
}
</style>
<%
    String ticketId = request.getParameter("ticketId");
%>
<%javax.naming.Context ctx = 	new javax.naming.InitialContext();
String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
String URL = (String) ctx.lookup("java:comp/env/URL"); %>



</head>
<body>
	<section>
	<div class="container-fluid">
		<a id="backBtn1" class="btn btn-success pull-right btn-orange width120" href="dashboardRMS.jsp" style="font-weight: bold;margin-top: 4px;">
			<div class="d-table">
				<div class="d-tbcell v-middle">
					<i class="zmdi_medium zmdi zmdi-caret-left-circle"></i>
				</div>
				<div class="p-left10 d-tbcell v-middle">Back</div>
			</div>
		</a>
            <div class="row" style="min-height: 630px; border: 1px solid #a5a1a1;">
            
			
			 <div class="search-form">
               
				<div class="col-sm-12 ">
					<form>
						<h2>View Ticket</h2>	
						<hr>
					<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-1"> </label>
								<div class="col-sm-8">

									<span id="result" style="color: red"></span>
								</div>
				
						<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Ticket ID </label>
								<div class="col-sm-5">
									<input readonly id= "TicketID" class="form-control" type="text" placeholder="Ticket Title"	style="height: 28px; width: 175px;"  /> 
								</div>
								</div>
								<div class="col-sm-5">
							       <label class="control-label col-sm-4">Ticket Title </label>
								<div class="col-sm-5">
								<input readonly id= "ticketTitle" class="form-control" type="text" placeholder="Ticket Title"	style="height: 28px; width: 175px;"  /> 
								</div>
								</div>
							</div> 
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Ticket Description </label>
								<div class="col-sm-5">
									<input readonly id= "TicketDescription" class="form-control" type="text" placeholder="Ticket Description"		style="height: 40px; width: 900px;"  /> 
								</div>
							   </div>
							   </div>
								</div>
                            </div><div class="col-sm-5">
								<label class="control-label col-sm-4">Attachments</label>
								<div class="col-sm-5">
									<div id="Attachments"> </div>
								
								</div>
								</div>
							</div>
								<div class="col-sm-5">
								<label class="control-label col-sm-4">Last Date</label>
								<div class="col-sm-5">
									<input id= "LastDate" class="form-control" type="text" placeholder="Creation Date"	readonly	style="height: 28px; width: 175px;"  /> 
								</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Assigned to</label>
								<div class="col-sm-5">
									<input readonly id= "Assignedto" class="form-control" type="text" placeholder="Assigned to"		style="height: 28px; width: 175px;"  /> 
								</div>
								</div>
								<div class="col-sm-5">
								<label class="control-label col-sm-4">Assigned Date</label>
								<div class="col-sm-5">
									<input readonly id= "AssignedDate" class="form-control" type="text" placeholder="Assigned Date"	readonly	style="height: 28px; width: 175px;"  /> 
								</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Category Type </label>
								<div class="col-sm-5">
								<select readonly id="categorytype" style="height: 25px; width: 175px;">
										<option value="" selected="" disabled="">Select Category type</option>
									</select>
									</div>
								</div>
								<div class="col-sm-5">
								<label class="control-label col-sm-4">Subcategory Type </label>
								<div class="col-sm-5">
									<input readonly id= "subcategoryId" class="form-control" type="text" placeholder="Subcategory Type"		style="height: 28px; width: 175px;"  /> 
							</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Priority </label>
								<div class="col-sm-5">
				
												<input readonly id= "priority" class="form-control" type="text" placeholder="priority"		style="height: 28px; width: 175px;"  /> 
						
								</div>
								</div>
								<div class="col-sm-5">
								<label class="control-label col-sm-4">Action Type </label>
								<div class="col-sm-5">
										<input readonly id= "ActionType" class="form-control" type="text" placeholder="Action Type"		style="height: 28px; width: 175px;"  /> 
						
								</div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Last Date modified </label>
								<div class="col-sm-5">
									<input id= "LastDatemodified" class="form-control" type="text" placeholder="Last Date modified"	readonly	style="height: 28px; width: 175px;"  /> 
								
								</div>
								</div>
								<div class="col-sm-5">
								<label class="control-label col-sm-4">Discussion </label>
								<div class="col-sm-5">
							<textarea readonly id= "Discussion" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Issue Description"  > 
							</textarea>
								</div>
								</div>
							</div>
						</div>
						
						
						<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">MFHD|POC</label>
								<div class="col-sm-5">
								<textarea readonly id= "MFHD|POC" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
							
								</div>
							
							
								</div>
								<div class="col-sm-5">
								<label class="control-label col-sm-4">MFHD|POC</label>
								<div class="col-sm-5">
									<textarea readonly id= "MFHD|POC" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								
								</div>
								</div>
							</div>
						</div>
							
						<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">HLPDSK|TESTUSER1</label>
								<div class="col-sm-5">
							<textarea readonly id= "HLPDSK|TESTUSER1" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								</div>
								<div class="col-sm-5">
								<label class="control-label col-sm-4">Application</label>
								<div class="col-sm-5">
									<div id="Application"> </div>
								
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Request By </label>
								<div class="col-sm-5">
							<textarea readonly id= "RequestBy" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Supervisor E-mail </label>
								<div class="col-sm-5">
							<textarea readonly id= "SupervisorE-mail" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Assigned To </label>
								<div class="col-sm-5">
							<textarea readonly id= "AssignedTo" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Priority </label>
								<div class="col-sm-5">
							<textarea readonly id= "Priority" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Creation Date </label>
								<div class="col-sm-5">
							<textarea readonly id= "CreationDate" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Assigned Date </label>
								<div class="col-sm-5">
							<textarea readonly id= "AssignedDate" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Created By </label>
								<div class="col-sm-5">
							<textarea readonly id= "CreatedBy" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Action Type </label>
								<div class="col-sm-5">
							<textarea readonly id= "ActionType" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Category Type </label>
								<div class="col-sm-5">
							<textarea readonly id= "CategoryType" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Subcategory Type </label>
								<div class="col-sm-5">
							<textarea readonly id= "SubcategoryType" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-5">
							<label class="control-label col-sm-4">Internal Notes </label>
								<div class="col-sm-5">
							<textarea readonly id= "Internal Notes" rows="2" style=" width: 176px; border: 1px solid #ccc;"  class="form-control"  placeholder="Recreation Steps"  > 
							</textarea>
								</div>
								</div>
							</div>
						</div>
					</form>
				</div>
				<br>
				<br>
				<br> <br>


			</div>
		</div>
		<form style="display:none" method="POST" enctype="multipart/form-data" id="fileUploadForm1">
    
   
   
    <input type="submit" value="Submit" id="btnSubmit1"/>
</form>
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
    	getTicket();
		
    });
    function getTicket(){
	   
	   var token=sessionStorage.getItem("token");
  	 $.ajax({
           type: "POST",
           url:"<%=restURL%>rmshd/viewTicketByTicketId?ticketId="+'<%= ticketId%>',
          // dataType: "json",
           headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
           success: function (res) {
               var data;
   if(res.ticketviewpart1.length>0){
	   data=res.ticketviewpart1[0];
	   }        	


$('#TicketID').val(data.ticket_id);
           		 $('#ticketTitle').val(data.ticket_title);
           		$('#creationDate').val(data.creation_date);
            	 $('#subcategoryId').val(data.sub_category_type);
            	$('#issueDescription').val(data.item_description);
            	$('#recreationSteps').val(data.recreate_steps);
            	 $('#CreatedBy').val(data.created_by);
            	 $('#application_id').val(data.application_name);
            	 $('#Assignedto').val(data.assigned_to);
            	 $('#AssignedDate').val(data.assigned_date);
            	 $('#ActionType').val(data.action_type);
            	 $('#CreatorContact').val(data.creators_contact);
            	 $('#priority').val(data.priority);
            	 $('#LastDatemodified').val(data.last_date_modified);
            	 $('#creationDate').val(data.creation_date);
            	 
            	 $('#categorytype option[value=' +data.category_type + ']').prop('selected', true);
            	 $("#categorytype").prop("disabled", true);
           		$('#helpdeskname option:contains(' +data.application_id + ')').attr('selected', 'selected'); 
           		
           		//$('#categorytype option:contains("' +data.category_type + '")').attr('selected', 'selected'); 
           		//$('#priority option:contains(' +data.priority + ')').attr('selected', 'selected'); 
//category_type
           	 $.each(res.comments,function(i,obj)
              		
                     {  
           		$('#logExternal').val(obj.comment_log_external);
           	 $('#logInternal').val(obj.comment_log_internal);              	
                     	
                     });
           	$.each(res.attachments,function(i,obj)
              		
                    {  
          	          console.log(obj)	
          		var	div_data="<a href=<%=restURL%>/rmshd/downloadDocument?name='"+obj.attachment_name+"'&path="+obj.attachment_path+">"+obj.attachment_name+"</a><br>";
             	$(div_data).appendTo('#Attachments'); 	
                    });
           		
              
               } 
         });
	   }
    function searchbyId(){
    	
    	var appname=$('#helpdeskname').find(":selected").val();
    	var ticketTitle= $('#ticketTitle').val();
    	var priority=$('#priority').find(":selected").val();
    	var categorytype=$('#categorytype').find(":selected").val();
    	var subcategoryId= $('#subcategoryId').val();
    	var issueDescription= $('#issueDescription').val();
    	var recreationSteps= $('#recreationSteps').val();
    	var logExternal= $('#logExternal').val();
    	var logInternal= $('#logInternal').val();
    	    	
    	
    	var inputdata=JSON.stringify({Ticket_title:ticketTitle,Action_type:'qww',Application_id:appname,Assigned_to:1,Category_type:categorytype,Comments_internal:logInternal,Comments_external:logExternal,Created_by:11,Item_desc:issueDescription,Priority:priority,Recreate_steps:recreationSteps,Sub_category_type:subcategoryId});
    	 var fileSelect = document.getElementById('files');
    	var formData = new FormData();
    	var form1 = $('#fileUploadForm1')[0];

	    var data = new FormData(form1);
	   
		    $.each($("input[type='file']")[0].files, function(i, file) {
		        data.append('documents', file);
		    });
	    data.append('ticketDetails',inputdata);
    	var token=sessionStorage.getItem("token");
    			$("#result").text("");
    			//$("#loadingImage").show();
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
    		 			$("#loadingImage").hide();
   		 				
   		 				
  				   		  if(response.status=="200"){
  				   		 $("#result").text("Ticket Successfully Created").css("color", "green");
  				   		  }else{
  				   			  
  				   			  }
  				   	
  				   		  
  				   		
  				   
    		 		 
    		 		  },
    		 		 error : function(xhr, status, textError) 
    		 		     {
    		 			$("#loadingImage").hide();
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
             url:"<%=restURL%>rmshd/getUsers",
             dataType: "json",
             headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
             success: function (data) {
             	//alert("619::"+data.docTypeData[0].value);
             		

                 $.each(data.users,function(i,obj)
                 		
                 {                	
                 	var	div_data="<option value="+obj.dropdown_id+">"+obj.dropdown_name+"</option>";
                 	$(div_data).appendTo('#username'); 
                 	
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
             		

                 $.each(data.statuslist,function(i,obj)
                 		
                 {                	
                 	var	div_data="<option value='"+obj.dropdown_name+"'>"+obj.dropdown_name+"</option>";
                 	$(div_data).appendTo('#statustype'); 
                 	
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
                 	var	div_data="<option value="+obj.dropdown_id+">"+obj.dropdown_name+"</option>";
                 	$(div_data).appendTo('#helpdeskname'); 
                 	
                 });
                
                 } 
           });
    }
    function getCategory(){
    	var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getCategory",
             dataType: "json",
             headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
             success: function (data) {
             	//alert("619::"+data.docTypeData[0].value);
             		

                 $.each(data.category,function(i,obj)
                 		
                 {                	
                 	var	div_data="<option value="+obj.dropdown_id+">"+obj.dropdown_name+"</option>";
                 	$(div_data).appendTo('#categorytype'); 
                 	
                 });
                
                 } 
           });
    }
    
    
   
   

    </script>
	
</body>
</html>