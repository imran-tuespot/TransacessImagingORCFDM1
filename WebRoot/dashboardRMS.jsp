<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/stylelager.css"></link>
<script src="js/jQuery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="css/jquery.dataTables.min.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
<!-- Include the Sidr JS -->
<script type="text/javascript" src="js/jquery.alerts.js" ></script>	
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
.form-group {
    margin-bottom: 20px;
}
.buttonexport:hover, .buttonexport:focus {color: #fff;}

.dataTables_length{margin-bottom: 20px;}
.buttonexport{
cursor: pointer;
    z-index: 99;
left: 142px;
  position: absolute;
    padding: 6px 12px;
    background-repeat: repeat-x;
    border-color: #3e8f3e;
    color: #fff;
    background-color: #5cb85c;
}
</style>


</head>
<%javax.naming.Context ctx = 	new javax.naming.InitialContext();
String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
String URL = (String) ctx.lookup("java:comp/env/URL");
String sessionId = (String)request.getParameter("sessionid");
if(sessionId!=null)
request.getSession().setAttribute("sessionid",sessionId);
%>
<body>
	<section>
	<div class="container-fluid">
	<div class="col-lg-12" style="margin-top: 3px;margin-bottom: 30px;">
			<div class="d-table pull-right" >
				<div >HelpDesk Name</div>
				<select id="helpdeskname" style="height: 25px; width: 175px;">
					<option value="" selected="" disabled="">Select HelpDesk Name</option>

				</select>
			</div>
		</div>
		
            <div class="row" style="	box-shadow: 1px 1px 5px rgb(0 0 0 / 90%); height: 360px;">
            
			
			 <div class="search-form">
	<form id="myform">
				<div class="col-sm-12">
					<div class="col-sm-2"></div>
					<div class="col-sm-10">



					
							<span id="result" style="color: red"></span>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-5">
										<label class="control-label col-sm-4">Status Type </label>
										<div class="col-sm-5">
											<select id="statustype" style="height: 25px; width: 175px;">
												<option value="" selected="" disabled="">Select Status Type</option>

											</select>
										</div>
									</div>
									<div class="col-sm-5">
									<label class="control-label col-sm-4">Ticket Id </label>
										<div class="col-sm-5">
											<input id="ticketId" class="form-control" type="text"
												placeholder="Ticket Id" style="height: 28px; width: 175px;" />
										</div>
										
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-5">
									<label class="control-label col-sm-4">From Date </label>
										<div class="col-sm-5">
											<div style="height: 28px; width: 188px;" id="datepicker1"
												class="input-group date" data-date-format="mm-dd-yyyy">
												<input class="form-control" type="text"
													style="height: 28px; background: #edecec;" readonly /> <span
													class="input-group-addon calstyle"><i
													class="glyphicon glyphicon-calendar"
													style="font-size: 22px; color: #0d529f;"></i></span>
											</div>
										</div>
										
										
									</div>
									<div class="col-sm-5">
										<label class="control-label col-sm-4">Priority </label>
										<div class="col-sm-5">
											<select id="priority" style="height: 25px; width: 175px;">
												<option value="" selected="" disabled="">Select Priority</option>

											</select>
										</div>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="row">
									<div class="col-sm-5">
									<label class="control-label col-sm-4">To Date</label>
										<div class="col-sm-5">
											<div style="height: 28px; width: 188px;" id="datepickerto"
												class="input-group date" data-date-format="mm-dd-yyyy">
												<input class="form-control" type="text"
													style="height: 28px; background: #edecec;" readonly /> <span
													class="input-group-addon calstyle"><i
													class="glyphicon glyphicon-calendar"
													style="font-size: 22px; color: #0d529f;"></i></span>
											</div>
										</div>
										
									</div>
									<div class="col-sm-5">
									<label class="control-label col-sm-4">Category Type </label>
										<div class="col-sm-5">
											<select id="categorytype" style="height: 25px; width: 175px;">
												<option value="" selected="" disabled="">Select Category type</option>

											</select>
										</div>
										
									</div>
								</div>
							</div>


							<div class="form-group">
								<div class="row">
								<div class="col-sm-5">
								</div>
									<div class="col-sm-5">
										<label class="control-label col-sm-4">Helpdesk Agent </label>
										<div class="col-sm-5">
											<select id="username" style="height: 25px; width: 175px;">
												<option value="" selected="" disabled="">Select User Name</option>

											</select>
										</div>
									</div>

								</div>
							</div>
							
						
						</div>
						<div class="form-group">
								<div class="row">
									<div class="col-sm-12 ">
										<div class="col-sm-2">
											<a id="backBtn1" class="btn btn-success pull-right "
												href="ticketCreation.jsp" style="font-weight: bold;">
												<div class="d-table">
													<div class="p-left10 d-tbcell v-middle">Create Ticket</div>
												</div>
											</a>
										</div>
										<div class="sub-btns">
											<button type="button" class="btn btn-success"
												onclick="searchbyId()">Submit</button>
											<input type="reset" class="btn resettable btn-danger"
												value="Reset" />
										</div>
									</div>
								</div>
							</div>
					
				</div>
</form>
				<br>
				<br>
				<br> <br>





				<div id="datagrid" class="col-sm-12" style='margin-top: 29px; box-shadow: 1px 1px 5px rgb(0 0 0 /90%);'>

					<form>

						
 				<div class="search-tables" style="text-align: center;margin-top: 10px; ">
						<span id="displaymsg" style="font-weight: bold; color: orange;"  ></span>
               

							<div class="table-data">
							<a class="buttonexport" onclick="exportExcel()" ><span>Excel Export</span></a> 
								<table id="myTable" class="table table-bordered">
									<thead>
										<tr>
  									       <th >Priority</th>
											<th >ID</th>
											<th >Creation date</th>
											<th >Assigned to</th>
											<th >Assigned date</th>
											<th >Title</th>
											<th>Department</th>
											<th >Status</th>
											<th >Application</th>
											<th >View</th>
										</tr>
									</thead>
									<tbody>



									</tbody>
								</table>
								<!-- <div id="loadingImage"
									style="position: absolute; top: 50%; left: 0px; right: 0px; margin: auto; text-align: center">
									<img src="css/images/default.gif" />
								</div> -->
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript">
	jQuery.extend( jQuery.fn.dataTableExt.oSort, {
		"date-uk-pre": function ( date ) {
		           var eu_date, year;
		           date = date.replace(" ", "");
		                     
		              eu_date = date.split('-');
		           /*year (optional)*/
		           if (eu_date[2]) {
		               year = eu_date[2];
		           } else {
		               year = 0;
		           }
		             
		           /*month*/
		           var month = eu_date[0];
		           if (month.length == 1) {
		               month = 0+month;
		           }
		             
		           /*day*/
		           var day = eu_date[1];
		           if (day.length == 1) {
		               day = 0+day;
		           }
		             
		           return (year + month + day) * 1;
		       },

		"date-uk-asc": function ( a, b ) {
		   return ((a < b) ? -1 : ((a > b) ? 1 : 0));
		},

		"date-uk-desc": function ( a, b ) {
		   return ((a < b) ? 1 : ((a > b) ? -1 : 0));
		}
		} );
	 $(document).keypress(function(event){
			event.stopPropagation();
			var keycode = (event.keyCode ? event.keyCode : event.which);
			if(keycode == '13'){
				//alert()
				
				var docTypeId=$('#doctype').find(":selected").val();
    	
    		var IREMS= $('#IREMS').val();
    		var Documenttext= $('#Documenttxt').val();
    		var fromDate = $('#datepicker1').datepicker('getDate');
    		
    		if(IREMS!=''||docTypeId !=''||Documenttext!=''||fromDate!='Invalid Date'){
				
				
					searchbyId();
					return false;
					//$('.btn-success').click()
					
				}
				
			}
			
		});
    $('.resettable').click(function() {
    	
    	$('#datepicker1').datepicker('setDate', null);
    	$('#datepickerto').datepicker('setDate', null);
    	
    	$('#myform')[0].reset();
    	//$('#statustype option[value="Open"]').attr("selected",true);
   	 searchbyId();
       
        
});
    $(document).mousemove(function(event){
		  InitializeTimer();
	  });
	
    $(function() {
    	getPriority();
    	getUserName();
    	getStatus();
    	 getCategory();
    	 getApplications();
    	
    	setHeader('IREMSDocumentSearch.jsp');
    	$("#loadingImage").hide();
    	 $(".workingAreaBlueHeading").html('<div style="margin-top: 5px;">'+
    			 '<div style="margin: 16px;color: #ff9900;font-size: 26px;font-weight: bold;text-transform: capitalize;" class="text-center">Welcome To HUD Office of RMS HelpDesk</div> </div> ');
    	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
    	for (var i = 0; i < array_of_li.length; i++) {
    		if(array_of_li[i].textContent.trim()=='Home'){
    		array_of_li[i].setAttribute("class", "active");	
    	}
    		
    	}
		
		 $("#datepicker1").datepicker({
	        	endDate:new Date(),
	            autoclose: true,
	            dateFormat: 'mm-dd-yy'
	        	
	        }).on("changeDate", function (e) {
	        	$('#datepickerto').datepicker('setDate', null);
	        	$("#result").text("");
	        	$('#datepickerto').datepicker({ autoclose: true}).datepicker('setStartDate', e.date).focus();
	        	//$("#datepickerto").datepicker( "option", "startDate", new Date() );
	        	});
			$("#datepickerto").datepicker({
	            autoclose: true,
	            dateFormat: 'dd-mm-yy',
	           
	            endDate:new Date()
	        }).on("changeDate", function (e) {
	        	
	        	$("#result").text("");
	        	});
    });
   
  function  checkVAlidation(){
    	 var regx="[<>%\$]";
		 var title=$('#ticketId').val().match(regx);
		 
		 if(title){  
			  jAlert("invalid cahracters")
		 		return false;
			}
    }
    
    function searchbyId(){
    	checkVAlidation();
    	
    	 if ($.fn.DataTable.isDataTable("#myTable")) {
			  $('#myTable').DataTable().clear().destroy();
			}
    	var statustype=$('#statustype').find(":selected").val();
    	var categorytype=$('#categorytype').find(":selected").val();
    	var priority=$('#priority').find(":selected").val();
    	var username=$('#username').find(":selected").val();
    	var helpdeskname=$('#helpdeskname').find(":selected").val();
    	var fromDate = $('#datepicker1').datepicker('getDate');
    	var toDate = $('#datepickerto').datepicker('getDate');
    	var ticketId= $('#ticketId').val();
    	var formatfromDate='';
    	var formattoDate='';
    	
    	if(statustype!=''||categorytype !=''||priority!=''||username !=''||helpdeskname !=''||ticketId !=''||fromDate!='Invalid Date'){
			if(!statustype){
				statustype='';
			}
			if(!categorytype){
				categorytype='';
			}
			if(!priority){
				priority='';
			}
			if(!username){
				username='';
			}
			if(!helpdeskname){
				helpdeskname='';
			}
			if(!ticketId){
				ticketId='';
			}
    		
    	if(fromDate!='Invalid Date'){
    		formatfromDate=fromDate.getMonth()+1+"-"+fromDate.getDate()+"-"+fromDate.getFullYear();
		}else{
			formatfromDate='';
		}
    	if(toDate!='Invalid Date'){
    		formattoDate=toDate.getMonth()+1+"-"+toDate.getDate()+"-"+toDate.getFullYear();
		}else{
			formattoDate='';
		}
    		
    	}else{
			$("#result").text("Please provide at least one field");	
		}
    	var token=sessionStorage.getItem("token");
    	var userinfo=JSON.parse(sessionStorage.getItem("roles"));		  
    	var userIdforNotification =sessionStorage.getItem("userId");     				
    			var str="categoryType="+categorytype+"&ticketId="+ticketId+"&role="+userinfo.role_NAME+"&priority="+priority+"&status="+statustype+"&userId="+username+"&fromDate="+formatfromDate+"&toDate="+formattoDate+"&userIdforNotification="+userIdforNotification; 
    			$("#result").text("");
    			//$("#loadingImage").show();
    			$.ajax({
    		 		type : "POST",
    		 		url : "<%=restURL%>rmshd/getalltickets?"+str,
    		 		datType : "json",
    		 		 headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
    		 		ContentType : "application/json; charset=utf-8",
    		 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
    		 		success : function(response) 
    		 		{
    		 			$("#loadingImage").hide();
   		 				
   		 				
  				   		  if(response.length>0){
  				   		response=displayData(response);
  				   		  }else{
  				   			  if(response.commonword!=null){
  				   				$("#result").text(response.commonword); 
  				   			  }
  				   		response=[];
  				   		  }
  				   	
  				   		  
  				   		$("#myTable").dataTable({
  				   			
  				   		// dom: 'lBfrtip',
	  				       
  							  "order": [[ 1, "desc" ]],
  					          "deferRender":    true,
  					          "scroller":       true,
  					        
  					           "drawCallback": function(){
  					        	   // Update state of "Select all" control
  					        	  // updateDataTableSelectAllCtrl($("#myTable").DataTable());
  					        	},
  					        	"aoColumns": [
					                 null,
					                 null,
					                 { "sType": "date-uk" },
					                 null,
					                 null,
					                 null,
					                 null,
					                 null,
					                 null
					                 
					                 
					             ],
					           
  					    
  					    });
  			
    		 		
    		 		  },
    		 		 error : function(xhr, status, textError) 
    		 		     {
    		 			$("#loadingImage").hide();
    				     }
    		 		    }); 
    			
    			
    		
    		
    			    	/* 	}else{
    			    			$("#result").text("Select Create Date ");	
    			    		}
    			    		}else{
    			    			$("#result").text("Enter Document text ");
    			    			
    			    		}
    				}else{
    					$("#result").text("Select Document Type");	
    		}
    			 }else{
    		        	$("#result").text("Enter Valid IREMS Number");
    		} */
    		
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
    	getHeaderusername();
    	var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getUsers?type=A&cid="+ JSON.parse(sessionStorage.getItem('roles')).company_ID,
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
                 {  var	div_data="";
                     if(JSON.parse(sessionStorage.getItem("roles")).company_ID==obj.dropdown_id) {
                    			div_data+="<option value="+obj.dropdown_id+" selected>"+obj.dropdown_name+"</option>";
                    			$("#helpdeskname").prop("disabled", true);
                         } else{
                        			div_data+="<option value="+obj.dropdown_id+">"+obj.dropdown_name+"</option>";
                             }            	
                 	$(div_data).appendTo('#helpdeskname'); 
                 	
                 });
                // $('#statustype option[value="Open"]').attr("selected",true);
            	 searchbyId();
                
                 } 
           });
    }
    
    function getDepartments(){
    	 var token=sessionStorage.getItem("token");
    	 $.ajax({
             type: "POST",
             url:"<%=restURL%>rmshd/getDepartments",
             dataType: "json",
             headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
             success: function (data) {
             	//alert("619::"+data.docTypeData[0].value);
                 $.each(data.departments,function(i,obj)
                 		
                 {                	
                 	var	div_data="<option value="+obj.dropdown_id+">"+obj.dropdown_name+"</option>";
                 	$(div_data).appendTo('#departments'); 
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
    
    
    function exportExcel(){
    	var statustype=$('#statustype').find(":selected").val();
    	var categorytype=$('#categorytype').find(":selected").val();
    	var priority=$('#priority').find(":selected").val();
    	var username=$('#username').find(":selected").val();
    	var helpdeskname=$('#helpdeskname').find(":selected").val();
    	var fromDate = $('#datepicker1').datepicker('getDate');
    	var toDate = $('#datepickerto').datepicker('getDate');
    	var ticketId= $('#ticketId').val();
    	var formatfromDate='';
    	var formattoDate='';
    	
    	if(statustype!=''||categorytype !=''||priority!=''||username !=''||helpdeskname !=''||ticketId !=''||fromDate!='Invalid Date'){
			if(!statustype){
				statustype='';
			}
			if(!categorytype){
				categorytype='';
			}
			if(!priority){
				priority='';
			}
			if(!username){
				username='';
			}
			if(!helpdeskname){
				helpdeskname='';
			}
			if(!ticketId){
				ticketId='';
			}
    		
    	if(fromDate!='Invalid Date'){
    		formatfromDate=fromDate.getMonth()+1+"-"+fromDate.getDate()+"-"+fromDate.getFullYear();
		}else{
			formatfromDate='';
		}
    	if(toDate!='Invalid Date'){
    		formattoDate=toDate.getMonth()+1+"-"+toDate.getDate()+"-"+toDate.getFullYear();
		}else{
			formattoDate='';
		}
    		
    	}else{
			$("#result").text("Please provide at least one field");	
		}
    	var token=sessionStorage.getItem("token");
    	var userinfo=JSON.parse(sessionStorage.getItem("roles"));		  
    	var userIdforNotification =sessionStorage.getItem("userId");     				
    	var str="categoryType="+categorytype+"&ticketId="+ticketId+"&role="+userinfo.role_NAME+"&appId="+helpdeskname+"&priority="+priority+"&status="+statustype+"&userId="+username+"&fromDate="+formatfromDate+"&toDate="+formattoDate+"&userIdforNotification="+userIdforNotification; 
    			$("#result").text("");
    	$.ajax({
            type: "POST",
            url:"<%=restURL%>excel/export-to-excel?"+str,
            xhrFields: { responseType: 'arraybuffer'},
            headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
            success: function (data) {
            	console.log(data);
            	var arr = data;
            	//var byteArray = new Uint8Array(arr);
            	var a = window.document.createElement('a');

            	a.href = window.URL.createObjectURL(new Blob([arr], { type: 'application/octet-stream' }));
            	a.download = "HelpDeskTicketQueue.xlsx";

            	// Append anchor to body.
            	document.body.appendChild(a)
            	a.click();
                } 
          });
    }
    
    function fnExcelReport()
    {
    	var rowCount = $('#myTable tr').length;
   	  if(rowCount>1){
        var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
        var textRange; var j=0;
        tab = document.getElementById('myTable'); // id of table
        $('td').css('width','200px');
        for(j = 0 ; j < tab.rows.length ; j++) 
        { 
        	if(j!=0){
        		tab.rows[j].cells[6].innerHTML=tab.rows[j].cells[6].firstChild.value;
        	}
        	tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
            //tab_text=tab_text+"</tr>";
        }

        tab_text=tab_text+"</table>";
        tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
        tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
        tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

        var ua = window.navigator.userAgent;
        var msie = ua.indexOf("MSIE "); 

        if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
        {
            txtArea1.document.open("txt/html","replace");
            txtArea1.document.write(tab_text);
            txtArea1.document.close();
            txtArea1.focus(); 
            sa=txtArea1.document.execCommand("SaveAs",true,"Reports.xlsx");
        }  
        else                 //other browser not tested on IE 11
            sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

        return (sa);
    	  }else{
      		$("#result").text("No Rows in Table");	
      	}
    }
    function displayData(data) {
        var count =0;
    	if(data.length==5000){
    		$("#displaymsg").text("Search results have reached max limit of 5k records. please refine your search to get the best results !!");
    	}else{
    		$("#displaymsg").text("");
    	}
    	
      	     	
      	$.each(data, function(i, obj) {
      		/*  $('#myTable tbody').append('<tr><td ><a  href="Viewticket.jsp?ticketId='+obj.ticket_id+'"  >'+obj.ticket_id+'</a></td><td>'+obj.application_name+'</td><td>'+obj.status+'</td><td>'+obj.ticket_title+'</td><td>'+obj.priority+'</td><td>'+obj.creation_date+'</td><td>'+obj.assigned_to+'</td><td>'+obj.assigned_date+'</td> </tr> '); */
      		if(!obj.assigned_to){
                obj.assigned_to="Unassigned";
            }
      		if(!obj.priority){
                obj.priority="Not selected";
            }
      		if(!obj.assigned_date){
                obj.assigned_date="Unassigned";
            }
      		if(obj.notificationFlag == 1 ){ 

      			count = count+1 
      			$('#myTable tbody').append('<tr><td>'+obj.priority+'</td><td>'+obj.ticket_id+'</td><td>'+obj.creation_date+'</td><td>'+obj.assigned_to+'</td><td>'+obj.assigned_date+'</td><td>'+obj.ticket_title+'</td><td>'+obj.department+'</td><td><select id=status'+obj.ticket_id+' name=status'+obj.ticket_id+' onchange=statusChange("'+obj.ticket_id+'") > </select></td><td>'+obj.application_name+'</td><td><a  href="Viewticket.jsp?ticketId='+obj.ticket_id+'&userId=1"  >'+ 
      		      		'<i class="fa fa-2x fa-eye" >'+ 
      		      		'<span style=" position: relative; top: -13px; right:2px ; padding:0px 5px; border-radius:50% ; font-size:17px; background:red;color:white"  >1</span>'+ 
      		      		'</i>'+ 
      		      		'</a></td> </tr> '); 
      		}else{ 
      			$('#myTable tbody').append('<tr><td>'+obj.priority+'</td><td>'+obj.ticket_id+'</td><td>'+obj.creation_date+'</td><td>'+obj.assigned_to+'</td><td>'+obj.assigned_date+'</td><td>'+obj.ticket_title+'</td><td>'+obj.department+'</td><td><select id=status'+obj.ticket_id+' name=status'+obj.ticket_id+' onchange=statusChange("'+obj.ticket_id+'") > </select></td><td>'+obj.application_name+'</td><td><a  href="Viewticket.jsp?ticketId='+obj.ticket_id+'"  >'+ 
      		      		'<i class="fa fa-2x fa-eye">'+ 
      		      		'</i>'+ 
      		      		'</a></td> </tr> '); 
      		} 
      		sessionStorage.setItem("notificationCount", count); 
      		statustypeoptions('status'+obj.ticket_id,obj.status);  

      		
     	   
     
      		
      	});
      	
      }

   function statustypeoptions(id,status){
	   jQuery('#statustype option').clone().appendTo('#'+id);
	   $('#'+id).val(status);
   }
   function statusChange(id){
	   var statustype=$('#status'+id).find(":selected").val();
	   var str="ticketId="+id+"&status="+statustype;
	   var token=sessionStorage.getItem("token");
  	 $.ajax({
           type: "POST",
           url:"<%=restURL%>rmshd/editTicketStatus?"+str,
           dataType: "json",
           headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
           success: function (data) {
           	jAlert('Updated successfully', 'Success');
           		  setTimeout(function(){
           			 searchbyId();
				        	}, 4000);

             //  alert(data)
              
               } 
         });
   }

    </script>
	
</body>
</html>