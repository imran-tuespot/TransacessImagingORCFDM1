<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
.scroll{
overflow-y: scroll;
    overflow-x: hidden;
    height: 300px;
}
.f-14{font-size: 13px;}
.f-12{font-size: 11px;}
.f-13{font-size: 13px;}
.scrollComments1{
    overflow-y: scroll;
    overflow-x: hidden;
    height: 300px;
    }
.scrollR{
overflow-y:scroll;
height:40%;
margin-bottom: 15px;
}

.table>thead>tr>th, table-data thead tr {
	background-color: #7098CC;
	color: #fff !important;
}
.input{
    width: 10%;
    padding: 5px 20px;
    border: 2px solid #e2e2e2;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
    border-radius: 5px;
}
.text_area{
   width: 100%;
    padding: 5px ;
     border: 2px solid #e2e2e2;
   /* border-top-right-radius: 82px 20px;
    border-top-left-radius: 82px 20px;
    border-bottom-right-radius: 82px 20px;
   border-bottom-left-radius: 82px 20px;*/
    transition: 0.5s;
    outline: none;
   
}
.small_text_area{    /* width: 100%; */
 
    border: 2px solid #e2e2e2;
    border-top-right-radius: 60px 12px;
    border-top-left-radius: 60px 12px;
    border-bottom-right-radius: 60px 12px;
    border-bottom-left-radius: 60px 12px;
    transition: 0.5s;
    outline: none;
}

.text-center h3{
    padding-right: 30px;
    color: rgb(59, 174, 192);
    margin: 0px;
}
.btn-secondary{
    margin-bottom: 9px;
    margin-right: 9px;
    }
.text-center p{
    padding-right: 30px;
    color:  rgb(59, 174, 192);
    font-size: 20px;
    margin: 0px;}
.inputt{
    width: 83%;
    padding: 5px 20px;
    border: 2px solid #e2e2e2;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
    border-radius: 5px;
}
.m-tp2{margin-top: 2px;}
.m-tp12{margin-top: 12px;}
.input-group {
	width: 20%;
	float: left;
	margin-bottom: 10px;
	border-radius: 4px;
}
.textarea-container { 
    position:relative;
    width: 300px;
    height: 100px;
    border: 1px solid #ddd;
} 
.textarea-container textarea {
    position:relative;
    border:none;
    width:232px;
    height: 95px;
    resize: none;
    outline: none; /* add this to stop highlight on focus */
}
.textarea-container button { 
   position:absolute;
    top: 3px;
    right:3px;
    width: 60px;
}
.table-data tbody tr td img {
    float: none;
}
  .newScrollBar {
            scrollbar-3dlight-color: #4FBDDD;
            scrollbar-arrow-color: #EEE1AE;
            scrollbar-darkshadow-color: #000000;
            scrollbar-face-color: #A0CCE0;
            scrollbar-highlight-color: #F8F2DC;
            scrollbar-shadow-color: #176F99;
            scrollbar-track-color: #E7F2FA;

            overflow: scroll;
            width: 200px;
            height: 167px;
            border: 1px solid #cccccc;
        }
        .row {
    margin-left: -12px;
    
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
		
            <div class="row" style="min-height: 630px; border: 1px solid #a5a1a1;">
            
			
			 <div class="search-form">
               
				<div class="col-sm-12 ">
				<a id="backBtn1" class="btn btn-success pull-left btn-orange width120" href="dashboardRMS.jsp" style="font-weight: bold;margin-top: 25px;">
			<div class="d-table">
				<div class="d-tbcell v-middle">
					<i class="zmdi_medium zmdi zmdi-caret-left-circle"></i>
				</div>
				<div class="p-left10 d-tbcell v-middle">Back</div>
			</div>
		</a>
					<form>
						<h2 style="    margin-top: 32px;">View Ticket</h2>	
						<hr>
						<div class="row" >
						<div class="col-sm-6" style=" margin-top: 45px">
						
						<div class="form-group">
							<div class="row">
							<div class="col-sm-12">
							<label class="control-label m-tp2 col-sm-4"><b>Ticket ID</b> </label>
								<div class="col-sm-6">
									<input readonly id= "TicketID" class="form-control" type="text" placeholder="Ticket Title"		style="height: 28px;     width: 45px;
                                     margin-right: 183px;;"  /> 
								</div>
								</div>
								</div>
						</div>
						<div class="form-group">
							<div class="row">
							<div class="col-sm-12">
								<label class="control-label m-tp2 col-sm-4"><b>Ticket Title</b> </label>
								<div class="col-sm-6" style="    padding-right: 70px;">
								<input id= "ticketTitle" class="form-control readonly" type="text" placeholder="Ticket Title"		style="height: 28px ;width: 175px;"  /> 
								</div>
								</div>
								</div>
								</div>
								<div class="form-group">
							<div class="row">
							<div class="col-sm-12">
								<label class="control-label m-tp2 col-sm-4"><b>Ticket Description</b></label>
								<div class="col-sm-6">
							<textarea id= "issueDescription" rows="2" style=" width: 417px;
                                    height: 144px; border: 1px solid #ccc;"  class="readonly form-control"  placeholder="Issue Description"  > 
							</textarea>
							<div class="col-sm-12" style="width: 389px;
							    margin-top: 31px;    padding-left: 0;
							    padding-right: 0;">
								<label class="control-label col-sm-3"><b>Attachments</b></label>
								
								<div class="col-sm-4" style="    padding-left: 0;
  														  padding-right: 0">
									<div id="Attachments"> 
								
								</div>
								<br>
								</div>
								
								<div class="col-sm-5">
								<lable style="text-align: center ;"><b>Last Date modified</b> </lable>
									<input id= "LastDatemodified" class="form-control" type="text" placeholder="Last Date modified"	readonly	style="height: 28px;text-align: center ; width: 165px;"  /> 
								
								
								</div>
								</div>
								<div class="col-sm-12" style="width: 389px;
							    margin-top: -17px;    padding-left: 0;
							    padding-right: 0;margin-left:-140px">
							
								<a    id="addnewAttachemnts" style="cursor:pointer">add</a>
								<span>/</span>
								<a  class="removeAttachments" style="cursor:pointer">remove</a>
								</div>
								</form>
								<form name="fileupload" id="fileupload" method="post" enctype="multipart/form-data">								
									<div class="col-sm-12 addattachments" style="width: 389px;
							        padding-left: 0;
							    padding-right: 0;margin-top:5px">
								</div>
								<input type="submit" class="btn btn-primary upload" style="  margin-left: 88px;
    					margin-top: 8px;display:none"/ name="submit">
							</form>
							
								</div>
						</div>
						</div>
					</div>
						<div class="form-group" style="    margin-top: 65px;
    								   margin-left: 40px;
									    width: 558px;">
							<div class="row" >
                            <div class="col-sm-12">
                            <span id="result1" style="color: red"></span>
                             <hr style="width: 153px;margin-bottom: 8px;">
                                     <label class="text-center"><b>Discussion </b></label>
							 <div class="row pt-4" style="margin-bottom: 21px;">
                            <div class="col-md-3">
                               
                            </div>
                            
                            <div class="col-md-8"> 

                                <div >
                                    <input  class="inputt" id="commentInput" style=" border:  1px solid #000 !important;" class="p-2" type="text" placeholder=" Add a comments" >
                                   <button onclick="addcomment()" id="addnew" type="button" class="btn btn-primary" style="margin-left:17px">Add</button>
                                </div> 
                            
                            </div>
                          
                        </div>
                       
             <div class="scroll">
                        <div class="row pt-4 ">
                            <div id="chat">
                            </div>
                        </div>
                         <div class="scrollComments"></div>      
                    </div>
                    </div>
                    </div>
                    </div>
                    </div>
                  
                   
						<div class="col-sm-6" style="margin-top:5px ;    
                                             ">
						<div class="row" style="margin-bottom: 50px;" >
						<div class="col-sm-12" style="margin-bottom: 12px;     padding-right: 0px !important">
								<div class="col-sm-2"></div>
								<label class="control-label col-sm-4"></label>
								<div class="col-sm-6" >
								<label class="control-label "><b>Application</b> </label>
								<input readonly id= "application_id" class="form-control" type="text" placeholder="Ticket Title"		style="height: 28px; width: 175px;"  /> 
								</div>
								</div>
						</div>
						<span id="result" style="color: red"></span>
						      <hr style="width: 153px;
                                     margin-right: 136px;">      
             <div class="scrollR">
            <div class="col-sm-12"style=" margin-bottom: 5px;">
								<div class="col-sm-3"></div>
							<label class="control-label m-tp2 col-sm-3" style="    padding-left: 0px;
                                       padding-right: 0px;"><b>Created By</b></label>
								<div class="col-sm-6">
									<input readonly id= "CreatedBy" class="form-control" type="text" placeholder="Created By"		style="height: 28px; width: 175px;"  /> 
								</div>
								</div>
						
							
							<div class="col-sm-12" style=" margin-bottom: 25px;   ">
								<div class="col-sm-3"></div>
							<label class="control-label m-tp2 col-sm-3" style="    padding-left: 0px;
                                       padding-right: 0px;" ><b>Supervisor E-mail</b></label>
								<div class="col-sm-6">
									<input  id="supervisoremail" onchange="supervisoremailChange()" class="form-control" type="text"		style="height: 28px; width: 175px;"  /> 
								</div>
								</div>
								<div class="col-sm-12" style="    margin-bottom: 5px;     ">
								<div class="col-sm-3"></div>
							<label class="control-label m-tp2 col-sm-3"><b>Requested By</b> </label>
								<div class="col-sm-6">
								<select   onchange="reqbyChange()" id="requestedby"  style="height: 25px; width: 175px;">
										<option value="" selected="" disabled="">Select </option>
									</select>
									</div>
						</div>
								<div class="col-sm-12" style="    margin-bottom: 5px;">
								<div class="col-sm-3"></div>
							<label class="control-label m-tp2 col-sm-3" style="    padding-left: 0px;
                                       padding-right: 0px;"><b>Assigned to</b></label>
								<div class="col-sm-6">
								<select  id="Assignedto"   style="height: 25px; width: 175px;">
										<option value="" selected="" disabled="">Select </option>
									</select>
									</div>
								</div>
								
								<div class="col-sm-12" style="    margin-bottom: 5px;">
								<div class="col-sm-3"></div>
							<label class="control-label m-tp2 col-sm-3"><b>Priority </b></label>
								<div class="col-sm-6">
				
						<select  id="priority"  onchange="priorityChange()"  style="height: 25px; width: 175px;">
										<option value="" selected="" disabled="">Select </option>
									</select>
							
								</div>
								</div>
								<div class="col-sm-12" style="    margin-bottom: 5px;">
								<div class="col-sm-3"></div>
								<label class="control-label m-tp2 col-sm-3" style="    padding-left: 0px;
                                       padding-right: 0px;"><b>Creation Date</b></label>
								<div class="col-sm-6">
									<input id= "creationDate" class="form-control" type="text" placeholder="Creation Date"	readonly	style="height: 28px; width: 175px;"  /> 
								</div>
								</div>
								<div class="col-sm-12" style="    margin-bottom: 25px;">
								<div class="col-sm-3"></div>
								<label class="control-label m-tp2 col-sm-3" style="    padding-left: 0px;
                                       padding-right: 0px;"><b>Assigned Date</b></label>
								<div class="col-sm-6">
									<input readonly id= "AssignedDate" class="form-control" type="text" placeholder="Assigned Date"	readonly	style="height: 28px; width: 175px;"  /> 
								</div>
								</div>
								
								
								<div class="col-sm-12" style="margin-bottom: 5px;">
								<div class="col-sm-3"></div>
								<label class="control-label m-tp2 col-sm-3" style="    padding-left: 0px;
                                       padding-right: 0px;"><b>Action Type </b></label>
								<div class="col-sm-6">
						<select  id="ActionType"  onchange="actiontypeChange()" style="height: 25px; width: 175px;">
										<option value="" selected="" disabled=""><b>Select Action Type</b></option>
									</select>
								</div>
								</div>
								<div class="col-sm-12" style="margin-bottom: 5px;">
								<div class="col-sm-3"></div>
							<label class="control-label m-tp2 col-sm-3" style="    padding-left: 0px;
                                       padding-right: 0px;"><b>Category Type</b> </label>
								<div class="col-sm-6">
								<select id="categorytype" onchange="getSubCategory();catChange()"
													style="height: 25px; width: 175px;">
													<option value="" selected="" disabled="">Select Category type</option>

												</select>
									</div>
								</div>
								<div class="col-sm-12" style="margin-bottom: 5px;">
								<div class="col-sm-3"></div>
								<label class="control-label m-tp2 col-sm-3" style="    padding-left: 0px;
                                       padding-right: 0px;"><b>Subcategory Type </b></label>
								<div class="col-sm-6">
							
							<select  onchange="subCatChange()" id="subcategoryId" style="height: 25px; width: 175px;">
										<option value="" selected disabled><b>Select Subcategory</b></option>
									</select>
										
							</div>
								</div>
								<div class="col-sm-12" style="margin-bottom: 5px;">
								<div class="col-sm-3"></div>
								<label class="control-label m-tp2 col-sm-3" style="    padding-left: 0px;
                                       padding-right: 0px;"><b>Contact Type </b></label>
								<div class="col-sm-6">
								<select  onchange="contacttypeChange()" id="contactType" style="height: 25px; width: 175px;">
										<option value="" selected="" disabled=""><b>Select Contact type</b></option>
									</select>
									</div>
								</div>
								
								<div class="col-sm-12" style="margin-bottom: 5px;">
								<div class="col-sm-3"></div>
								<label class="control-label m-tp2 col-sm-3" style="    padding-left: 0px;
                                       padding-right: 0px;"><b>Department </b></label>
								<div class="col-sm-6">
								<select  onchange="departmentsChange()" id="departments" style="height: 25px; width: 175px;">
										<option value="" selected="" disabled=""><b>Select Department</b></option>
																		
									</select>
									</div>
								</div>
								
								</div>
							
							<div class="form-group" style="   
    								   margin-left: 85px;
									   ">
							<div class="row" >
							<div class="col-sm-12" style=" ">
							<span id="result2" style="color: red"></span>
							<hr style="width: 133px;margin-bottom: 8px">
							<div>
							
                                <label class="text-center"><b>INTERNAL NOTES</b></label>
                            </div>
                            </div>
                             
                            <div class="col-sm-12">
							 <div class="row pt-4" style="margin-bottom: 21px;">
                            <div class="col-md-3">
                               
                            </div>
                            <div class="col-md-8"> 

                                <div style=" margin-top: 8px;">
                                    <input  class="inputt" id="commentInput1" style=" width: 71% !important; border:  1px solid #000 !important;" class="p-2" type="text" placeholder=" Add a comments" >
                                    <button type="button" onclick="addcomment2()" id="addnew1" class="btn btn-primary" style="margin-left: 17px;">Add</button>
                                </div> 
                            
                            </div>
                          </div>
                        </div>
                         
                         
                           <div class="scroll1">
                        <div class="row pt-4 ">
                            <div id="chat">
                            </div>
                        </div>
                         <div class="scrollComments1"></div>      
                    </div>
                         
                           
                        	
								</div>	
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
		<form style="display:none" method="POST" >
    
   
   
    <input type="submit" value="Submit" id="btnSubmit1"/>
   
</form>
  
	</section>

	<script type="text/javascript">
	
	var subCategoryId;
	
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
    	getRequestedBy();
    	 getCategory();
    	 getAsignedTo();
    	 getApplications();
    	 getContactType();
    	 getDepartments();
    	 
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
    var timertitle = null;
    $('#ticketTitle').keyup(function(){
           clearTimeout(timertitle);
           timertitle = setTimeout(titleChange, 1000)
    });
    var desctitle = null;
    $('#issueDescription').keyup(function(){
           clearTimeout(desctitle);
           desctitle = setTimeout(descChange, 1000)
    });
    function catChange(){
    	updatevalues("category_type", $('#categorytype').val());
    }
     function subCatChange(){
    	updatevalues("sub_category_type", $('#subcategoryId').val());
    }
    function contacttypeChange(){
    	updatevalues("contact_Type", $('#contactType').val());
    }
    function departmentsChange(){
    	updatevalues("department", $('#departments').val());
    }
    function actiontypeChange(){
    	updatevalues("action_type", $('#ActionType').val());
    }
     function priorityChange(){
    	updatevalues("priority", $('#priority').val());
    }
    function supervisoremailChange(){
    	  if(!validateEmail($('#supervisoremail').val())) 
    		{  
    		  $("#result").text("Not a valid e-mail address").css("color", "red");
    		}else{
    			$("#result").text("");
    			updatevalues("supervisor_email", $('#supervisoremail').val());	
    		}
    }
    function reqbyChange(){
    	updatevalues("requested_by", $('#requestedby').val());
    }
    function descChange(){
    	updatevalues("item_desc", $('#issueDescription').val());
    }
   
    function titleChange(){
    	updatevalues("ticket_title", $('#ticketTitle').val());
    }
  
    
    function validateEmail(email) 
    {  
    	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))  
    	  {  
    	    return true; 
    	  } 
       
        return false;

    }
    function getAsignedTo(){
    
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
                 	$(div_data).appendTo('#Assignedto'); 
                 	
                 });
                
                 } 
           });
    }
    function getTicket(){
    	var uid = sessionStorage.getItem("userId"); 	   
	   var token=sessionStorage.getItem("token");
  	 $.ajax({
           type: "POST",
           url:"<%=restURL%>rmshd/viewTicketByTicketId?ticketId="+'<%= ticketId%>'+"&userId="+uid, 
          // dataType: "json",
           headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
           success: function (res) {
               var data;
   if(res.ticketviewpart1.length>0){
	   data=res.ticketviewpart1[0];
	   }        	

	console.log("line no 545 "+JSON.stringify(data))
   
$('#TicketID').val(data.ticket_id);
	 $('#supervisoremail').val(data.supervisor_email);
           		 $('#ticketTitle').val(data.ticket_title);
           		$('#creationDate').val(data.creation_date);
            //	 $('#subcategoryId').val(data.sub_category_type);
            	$('#issueDescription').val(data.item_description);
            	//$('#recreationSteps').val(data.recreate_steps);
            	 $('#CreatedBy').val(data.created_by_name);
            	 $('#application_id').val(data.application_name);
            	 //	$('#Assignedto option[value='+data.assigned_to + ']').prop('selected',true);
            	 $('#Assignedto option[value='+data.assigned_to  + ']').prop('selected',true);
            	 if(data.assigned_to == 1){
                     //obj.assigned_to="Unassigned";
                     $('#AssignedDate').val("");
                 }else{
                	 $('#AssignedDate').val(data.assigned_date);
                 }
            	 
            	 $('#ActionType').val(data.action_type);
            	 $('#CreatorContact').val(data.creators_contact);
            	 $('#priority').val(data.priority);
            	 $('#LastDatemodified').val(data.last_date_modified);
            	 $('#creationDate').val(data.creation_date);
            	 if(data.contact_Type){
            		 $('#contactType option[value='+data.contact_Type + ']').prop('selected',true);
            	 }
         
            	 $('#departments option[value=' +data.department + ']').prop('selected', true);
            
             		
            	 if(data.requested_by!=""){
             		
                 	
                	 if(!isNaN(Number(data.requested_by))){
                		 $('#requestedby option[value='+data.requested_by + ']').prop('selected',true);
                     		 
                	 }
                	}
            	
            	 $('#categorytype option[value=' +data.category_type + ']').prop('selected', true);
            	// $("#categorytype").prop("disabled", true);
            		getSubCategory(data.category_type); 
           		
            	$('#helpdeskname option:contains(' +data.application_id + ')').attr('selected', 'selected'); 
            	 $('#subcategoryId option[value=' +data.sub_category_type + ']').prop('selected', true);
            	 subCategoryId=data.sub_category_type;
            	//$('#subcategoryId option[value=' +data.sub_category_type + ']').prop('selected', true);
            	
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
          		var	div_data="<a download href=<%=restURL%>rmshd/downloadDocument?name="+obj.attachment_name+"&path="+obj.attachment_path+">"+obj.attachment_name.substr(0,10)+"...</a><br>";
             	$(div_data).appendTo('#Attachments'); 	
                    });

           
           		
           		
                	
           
           	  
               } 
         });
	   }
    function searchbyId(){
    	
    	var appname=$('#helpdeskname').find(":selected").val();
    	var ticketTitle= $('#ticketTitle').val();
    	var priority=$('#priority').find(":selected").val();
    	var departments=$('#departments').find(":selected").val();
    	var categorytype=$('#categorytype').find(":selected").val();
    	var subcategoryId= $('#subcategoryId').val();
    	var issueDescription= $('#issueDescription').val();
    	var recreationSteps= $('#recreationSteps').val();
    	var logExternal= $('#logExternal').val();
    	var logInternal= $('#logInternal').val();
    	    	
    	
    	var inputdata=JSON.stringify({Ticket_title:ticketTitle,Action_type:'qww',Application_id:appname,Assigned_to:1,Category_type:categorytype,Comments_internal:logInternal,Comments_external:logExternal,Created_by:11,Item_desc:issueDescription,Priority:priority,department:departments,Recreate_steps:recreationSteps,Sub_category_type:subcategoryId});
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
   
    	var count =0;
    		$('#addnewAttachemnts').click(function(){
    			
    			  $(".addattachments").append('<div class="row" id="atch'+count+'" style=" margin-top:10px">'+
                          '<input type="file" name="file"  class="col-sm-6" >'+
                          '<button type="button" class="btn btn-primary" style="margin-left:-100px" onclick="rmAttchments('+count+')">Remove</button>'+
             '</div>'
             );
    			  $('.removeAttachments').show();  
    			  $('.upload').show();
    			  count = count+1
    		});
    		$('.removeAttachments').click(function(){
    			$(".addattachments").empty();
    			var uid = sessionStorage.getItem("userId");
   	         var token=sessionStorage.getItem("token");
   	         var discussionID=sessionStorage.getItem("discussionId");
      		$.ajax({
              type: "DELETE",
              url:"<%=restURL%>rmshd/delete/attachmentid?ticketId="+'<%= ticketId%>',
              dataType: "json",
              headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
              success: function (data) {
              	window.location.reload()
              	console.log("deleted ! 915");
              }
      	});
    	$("#Attachments").empty();
    	$('.upload').hide();
    			 
    		});
    	
    
  	function rmAttchments(id){
  		count=count-1;
  		console.log("line no "+count);
  		$("#atch"+id).remove();
  		
  		if(count==0){
  			$('.upload').hide();
  		}
  		
  	}
  	
  	$("form#fileupload").submit(function(e) {
  	    e.preventDefault();    
  	    var formData = new FormData(this);
  	    $.ajax({
  	    	url:"<%=restURL%>rmshd/uploadFileattachment?tid="+'<%= ticketId%>',
  	        type: 'POST',
  	        data: formData,
  	        success: function (data) {
  	           // alert(data)
  	        	window.location.reload()
  	        },
  	        cache: false,
  	        contentType: false,
  	        processData: false
  	    });
  	});
 
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
             url:"<%=restURL%>rmshd/getUsers?cid="+ JSON.parse(sessionStorage.getItem('roles')).company_ID,
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
                 	$(div_data).appendTo('#ActionType'); 
                 	
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
    function getRequestedBy(){
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
    
    function getDiscussionData() {
    	
    	var token=sessionStorage.getItem("token");
    	var tid = $('#TicketID').val();
    	$(".scrollComments").empty();
		 $("#commentInput").val("");
	
   	 $.ajax({
            type: "GET",
            url:"<%=restURL%>rmshd/get/discussionbytid?tid="+'<%= ticketId%>',
            dataType: "json",
            headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
            success: function (data) {
            	//alert("619::"+data.docTypeData[0].value);
					
            	
					 
						var jsonObject = $.parseJSON(JSON.stringify(data)); //Only if not already an object
						$.each(jsonObject, function (i, obj) {
						   // alert(obj.id);
						  /*  
						    var	div_data="<div>hello</div>";
		                 	//$(div_data).appendTo('.scroll'); 
			                $(".scrollComments").append('<div class="row pt-4">'+
                                     '<div class="col-md-3">'+
                             '<label class="m-tp12">'+obj.user.short_username+' :</label>'+
                        ' </div>'+
                         '<div class="col-md-8 col-sm-12  text-left"> '+
                            ' <textarea disabled  class="para_border p-2  text_area" name="" id=commentInput1'+obj.id+' cols="50" rows="2">'+obj.message+' </textarea>'+
                            ' <label style="  color: e2e2e2;  color: hsl(0deg 6% 72%);">'+obj.createdAt+'</label>    '+  
                            '<div  class="pull-right"> <button type="button" id=discusedit'+obj.id+' onClick="saveenable2('+obj.id+')" class="btn btn-secondary">Edit</button>'+
                            '<button type="button"  onClick="editid('+obj.id+')" id=discussave'+obj.id+' style="    display: none;" class="btn d-none btn-secondary">Save</button>'+
                            '<button type="button" onClick="deletebyid('+obj.id+')" id="deletemessage'+obj.id+'" class="btn btn-secondary">Delete</button>'+
                        ' </div> </div>'+
                     '</div>');  */ 
                    
                     var flname=obj.created_name.split(" ");
			                var row= '<div class="row pt-4">'+
                            '<div class="col-md-3">';
			                if(obj.created_name!="HLPDSK | PSL TEAM"){
			                	row=row+ '<label class="m-tp12 f-14">'+obj.app_name+' | '+flname[0]+' '+flname[1].charAt(0)+'.</label>';
		                     }else{
		                    	 row=row+ '<label class="m-tp12 f-12">'+obj.created_name+'.</label>';
		                     }
                            
                           
			                row=row+ ' </div>'+
                        '<div class="col-md-8 col-sm-12  text-left"> '+
                           ' <textarea disabled  class="para_border p-2  text_area" name="" id=commentInput1'+obj.id+' cols="50" rows="2">'+obj.message+' </textarea>'+
                           ' <label style="  color: e2e2e2;  color: hsl(0deg 6% 72%);">'+obj.createdAt+'</label>    '; 
                  
                           if(JSON.parse(sessionStorage.getItem("roles")).user_id==obj.user.user_id){
                	  row=row+ '<div  class="pull-right"> <button type="button" id=discusedit'+obj.id+' onClick="saveenable2('+obj.id+')" class="btn btn-secondary">Edit</button>'+
                      '<button type="button"  onClick="editid('+obj.id+')" id=discussave'+obj.id+' style="    display: none;" class="btn d-none btn-secondary">Save</button>'+
                      '<button type="button" onClick="deletebyid('+obj.id+')" id="deletemessage'+obj.id+'" class="btn btn-secondary">Delete</button>';
                  }   
                   row+= ' </div></div>';
			 $(".scrollComments").append(row); 
			                
			                
			                
			                
						});
                } 
          });
    }
    
    $(document).ready(function(){
    	var token=sessionStorage.getItem("token");
    	var tid = $('#TicketID').val()
    	var username=sessionStorage.getItem('username');
    	 var userControl=sessionStorage.getItem("userControl");
    	 var uid = sessionStorage.getItem("userId");
  			/* if(userControl=='Y'){
  				$("#commentInput1").prop('disabled',true);
  				
  			}
  			else{
  				$("#commentInput").prop('disabled',true);
  				
  			} */
   	 $.ajax({
            type: "GET",
            url:"<%=restURL%>rmshd/get/discussionbytid?tid="+'<%= ticketId%>'+"&userId="+uid,
            dataType: "json",
            headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
            success: function (data) {
            	//alert("619::"+data.docTypeData[0].value);
					 
					 if(data.length>0){
						 
					
						sessionStorage.setItem('discussionId' ,data[0].id);
						
						 var discussionID=sessionStorage.getItem("discussionId");
							var jsonObject = $.parseJSON(JSON.stringify(data)); //Only if not already an object
							$(".scrollComments").empty();
							 $("#commentInput").val("");
							$.each(jsonObject, function (i, obj) {
							  
                       var flname=obj.created_name.split(" ");
   
                       
				               var row=   '<div class="row pt-4">'+
                                            '<div class="col-md-3 text-right">';
                                            
                                            if(obj.created_name!="HLPDSK | PSL TEAM"){
                                            	row+='<label class="m-tp12 f-14">'+obj.app_name+' | '+flname[0]+' '+flname[1].charAt(0)+'.</label>';
                    	                     }else{
                    	                    	 row+= '<label class="m-tp12 f-12">'+obj.created_name+'.</label>';
                    	                     }
                                                  
                                            
                                            row+= ' </div>'+
	                            '<div class="col-md-8 col-sm-12  text-left"> '+
	                               '<textarea  disabled  class="para_border p-2 f-14 text_area" name="" id=commentInput2'+obj.id+' cols="60" rows="3" >'+obj.message+'</textarea>'+ 
	                               ' <label style="  color: e2e2e2;  color: hsl(0deg 6% 72%);">'+obj.createdAt+'</label>    ';
	                               if(JSON.parse(sessionStorage.getItem("roles")).user_id==obj.user.user_id){
	                            	   row+=  '<div  class="pull-right"><button type="button"  id=discusedit'+obj.id+' onClick="saveenable2('+obj.id+')" class="btn btn-secondary">Edit</button>'+
	                               '<button type="button"  onClick="editid('+obj.id+')" id=discussave'+obj.id+' style="    display: none;" class="btn d-none btn-secondary">Save</button>'+
	                               '<button type="button" onClick="deletebyid('+obj.id+')" id="deletemessage'+obj.id+'" class="btn btn-secondary">Delete</button></div>'
	                               }
	                               row+= '</div></div>';
	                               $(".scrollComments").append(row); 
							
				               
			                 	
						});
					 }
                } 
          });
   
	});
   
    function editid(editid)
    {
    	 var uid = sessionStorage.getItem("userId");
    	 
    	 var token=sessionStorage.getItem("token");
      	var discussionId=sessionStorage.getItem('discussionId')
     	console.log("working edit "+editid)
    	
            	 
            	   var descussionObj = {
            				id:editid,
               		 message: $("#commentInput2"+editid).val(),
               		createdBy_Id :uid,
               		 createdAt:"",
               		modifiedBy_Id:"",
               		modifiedAt:"",
               		ticket_id : $("#TicketID").val(),
               		created_name : JSON.parse(sessionStorage.getItem('roles')).fname+' '+JSON.parse(sessionStorage.getItem('roles')).lname,
               		app_name :   'HLPDSK'
                }
            	   
            	 $.ajax({
            		 type:"PUT",
            		 contentType : "application/json",
     	     		url : "<%=restURL%>rmshd/update/discussion",
     	     		dataType : 'json',
     	     		headers: {'Access-Control-Allow-Origin': '*','Authorization':'Bearer '+token},
     	     		timeout : 100000,
     	     		crossDomain: true,
     	     		data:JSON.stringify(descussionObj),
    	     		success : function(data) {
    	     	
    	     		window.location.reload()
    	     		}
            	 });
               
 
    	 
    }
        function  deletebyid(deleteID)
         {
        	   var uid = sessionStorage.getItem("userId");
  	  
  	         
  	         //console.log("line no 818 "+JSON.stringify(descussionObj))
  	         var token=sessionStorage.getItem("token");
  	         var discussionID=sessionStorage.getItem("discussionId");
  	         
        	console.log("working"+discussionID)
        	disabled=true;
        	$.ajax({
                type: "DELETE",
                url:"<%=restURL%>rmshd/delete/discussionbyid?tid="+deleteID,
                dataType: "json",
                headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
                success: function (data) {
                	
                	window.location.reload()
                	
                  },
                error: function (xhr, status, errorThrown) {
                    //Here the status code can be retrieved like;
                   console.log(xhr.status);

                    //The message added to Response object in Controller can be retrieved as following.
                   console.log(xhr.responseText);
                }
    });
    }
  	
    	$("#addnew").click(function(ent){
    		
    	         if($("#commentInput").val()){
    	         var uid = sessionStorage.getItem("userId");
    	        var username=sessionStorage.getItem('username');
    	         var descussionObj = {
    	        			
    	        		 "message": $("#commentInput").val(),
    	        		createdBy_Id :uid,
    	        		 createdAt:"",
    	        		modifiedBy_Id:"",
    	        		modifiedAt:"",
    	        		ticket_id : $("#TicketID").val(),
    	        		created_name : JSON.parse(sessionStorage.getItem('roles')).fname+' '+JSON.parse(sessionStorage.getItem('roles')).lname,
                   		app_name :  'HLPDSK',
                   		appid: 6 
    	         }
    	         
    	         console.log("line no 818 "+JSON.stringify(descussionObj))
    	         var token=sessionStorage.getItem("token");
    	        
    	         $("#result1").text("");
    	         $.ajax({
    	        	type : "POST",
    	     		contentType : "application/json",
    	     		url : "<%=restURL%>rmshd/discussion",
    	     		dataType : 'json',
    	     		headers: {'Access-Control-Allow-Origin': '*','Authorization':'Bearer '+token},
    	     		timeout : 100000,
    	     		crossDomain: true,
    	     	    data:JSON.stringify(descussionObj),
    	     		success : function(data) {
    	     			//window.location.reload()
    	             	//alert("619::"+data.docTypeData[0].value);
							
							//JSON.stringify(data);
							window.location.reload();
						
						
						
    	                 } 
    	           });
    	         
    	}else{
    		 $("#result1").text("Enter comments").css("color", "red");
    	}
    	})

    	
    	$(document).ready(function(){
    	var token=sessionStorage.getItem("token");
    	var tid = $('#TicketID').val()
   	 $.ajax({
            type: "GET",
            url:"<%=restURL%>rmshd/get/internalnotesbytid?tid="+'<%= ticketId%>',
            dataType: "json",
            headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
            success: function (data) {
            	//alert("619::"+data.docTypeData[0].value);
					 console.log("line no 798 "+JSON.stringify(data))
					 
						
						var internalNotesId=sessionStorage.getItem('notesId');
								var jsonObject = $.parseJSON(JSON.stringify(data)); //Only if not already an object
								$(".scrollComments1").empty();
								 $("#commentInput1").val("");
								$.each(jsonObject, function (i, obj) {
								   // alert(obj.id);
								   
								    var	div_data="<div>hello</div>";
				                 	//$(div_data).appendTo('.scroll');
				                 
					              var row= '<div class="row pt-4">'+
	                                            '<div class="col-md-3 text-right">'+
	                                            '<label class="m-tp12 f-14">'+obj.user.first_NAME+' '+ obj.user.last_NAME[0]+'.</label>'+
		                           ' </div>'+
		                            '<div class="col-md-8 col-sm-12 text-left "> '+
		                               '<textarea disabled  class="para_border1 p-2 f-14 text_area" name="" id=commentInput1'+obj.id+' cols="50" rows="2" >'+obj.message+'</textarea>'+ 
		                               ' <label style=" color: e2e2e2;  color: hsl(0deg 6% 72%);">'+obj.createdAt+'</label>    ' 
		                              if(JSON.parse(sessionStorage.getItem("roles")).user_id==obj.user.user_id){
		                            	  row=row+ ' <div class="pull-right"><button type="button" id=nodesedit'+obj.id+' onClick="saveenable1('+obj.id+')" class="btn btn-secondary">Edit</button>'+
		                              '<button type="button"  onClick="editid1('+obj.id+')" id=nodesave'+obj.id+' style="    display: none;" class="btn d-none btn-secondary">Save</button>'+
		                               '<button type="button" onClick="deletebyid1('+obj.id+')" id="deletemessage'+obj.id+'" class="btn btn-secondary">Delete</button></div>';
								}                                
		                               row+= ' </div></div>';
								 $(".scrollComments1").append(row); 
								});
                } 
          });
   
	});
    	
    	function saveenable1(id){
    		$("#commentInput1"+id).removeAttr('disabled');
    		$("#nodesedit"+id).css("display", "none");
    		$("#nodesave"+id).css("display", "inline");
    		
    	}
    	function saveenable2(id){
    		$("#commentInput2"+id).removeAttr('disabled');
    		$("#discusedit"+id).css("display", "none");
    		$("#discussave"+id).css("display", "inline");
    		
    	}
    	 function getSubCategory(obj){
    		 
    			 var id= $("#categorytype").val();
    			 if(!id){
    				 id=obj;
    			 }
     	    	var token=sessionStorage.getItem("token");
     	    	 $.ajax({
     	             type: "POST",
     	             url:"<%=restURL%>rmshd/getSubCategory?categoryId="+id,
     					dataType : "json",
     					headers : {
     						'Access-Control-Allow-Origin' : '*',
     						'Authorization' : 'Bearer ' + token
     					},
     					success : function(data) {
     						//alert("619::"+data.docTypeData[0].value);
					     	$('#subcategoryId').find('option').remove();
					     	$('#subcategoryId').append("<option value=''>Select Subcategory Type</option>");
     						$.each(data.category, function(i, obj)

     						{
     							var div_data;
     							if(obj.dropdown_id==subCategoryId){
     								 div_data = "<option value="+obj.dropdown_id+" selected>"	+ obj.dropdown_name + "</option>";
     							}
     							else{
     								 div_data = "<option value="+obj.dropdown_id+">"	+ obj.dropdown_name + "</option>";
     							}
     							
     							
     							$(div_data).appendTo('#subcategoryId');

     						});

     					}
     				});
	        	
    	    	
    			}
    function editid1(editid)
    {
    	 var uid = sessionStorage.getItem("userId");
    	 
    	 var token=sessionStorage.getItem("token");
      	var notesId=sessionStorage.getItem("notesId");
     	console.log("working"+editid);
 
            	   var descussionObj = {
            				id:editid,
               		 message: $("#commentInput1"+editid).val(),
               		createdBy_Id :uid,
               		 createdAt:"",
               		modifiedBy_Id:uid,
               		modifiedAt:"",
               		ticket_id : $("#TicketID").val()
                }
            	 $.ajax({
            		 type:"PUT",
            		 contentType : "application/json",
     	     		url : "<%=restURL%>rmshd/update/internalnotes",
     	     		dataType : 'json',
     	     		headers: {'Access-Control-Allow-Origin': '*','Authorization':'Bearer '+token},
     	     		timeout : 100000,
     	     		crossDomain: true,
     	     		data:JSON.stringify(descussionObj),
    	     		success : function(data) {
    	     		
    	     		window.location.reload()
    	     		}
            	 });   

    	 
    }
        function  deletebyid1(deleteID)
         {
        	   var uid = sessionStorage.getItem("userId");
  	         
  	         //console.log("line no 818 "+JSON.stringify(descussionObj))
  	         var token=sessionStorage.getItem("token");
  	         
        	console.log("working"+deleteID)
        	$.ajax({
                type: "DELETE",
                url:"<%=restURL%>rmshd/delete/internalnotesById?tid="+deleteID,
                dataType: "json",
                headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
                success: function (data) {
                	
                	window.location.reload()
                
                  },
                error: function (xhr, status, errorThrown) {
                    //Here the status code can be retrieved like;
                   console.log(xhr.status);

                    //The message added to Response object in Controller can be retrieved as following.
                   console.log(xhr.responseText);
                }
    });
        	
         }
    	$("#addnew1").click(function(ent){
    		
    	         //alert($("#commentInput").val()+" TicketID : "+$("#TicketID").val());
    	         var uid = sessionStorage.getItem("userId");
    	         if($("#commentInput1").val()){
    	         var descussionObj = {
    	        			
    	        		 "message": $("#commentInput1").val(),
    	        		createdBy_Id :uid,
    	        		 createdAt:"",
    	        		modifiedBy_Id:"",
    	        		modifiedAt:"",
    	        		ticket_id : $("#TicketID").val()
    	         }
    	         
    	         console.log("line no 818 "+JSON.stringify(descussionObj))
    	         var token=sessionStorage.getItem("token");
    	         $("#result2").text("");
    	         $.ajax({
    	        	type : "POST",
    	     		contentType : "application/json",
    	     		url : "<%=restURL%>rmshd/internalnotes",
    	     		dataType : 'json',
    	     		headers: {'Access-Control-Allow-Origin': '*','Authorization':'Bearer '+token},
    	     		timeout : 100000,
    	     		crossDomain: true,
    	     	    data:JSON.stringify(descussionObj),
    	     		success : function(data) {
    	             	//alert("619::"+data.docTypeData[0].value);
							//alert(data.id)
							//JSON.stringify(data);
							window.location.reload()
										
						
    	                 } 
    	           });
    	}else{
   		 $("#result2").text("Enter comments").css("color", "red");
   	} 
    	
    	})
    	
    	function updatevalues(fieldName,fieldValue){
    		
    		 var regx="[<>%\$]";
    		 var title=fieldValue.match(regx);
    		// var description=issueDescription.match(regx);
    		 
    		 if(title){  
    			 alert("Invalid chracters");
    		 		return false;
    			}
    		
    		var token=sessionStorage.getItem("token");
    		 $.ajax({
        		 type:"PUT",
        		 contentType : "application/json",
 	     		url : "<%=restURL%>rmshd/ticket",
 	     		dataType : 'json',
 	     		headers: {'Access-Control-Allow-Origin': '*','Authorization':'Bearer '+token},
 	     		timeout : 100000,
 	     		crossDomain: true,
 	     		data:JSON.stringify({ticketId:'<%= ticketId%>',fieldName:fieldName,fieldValue:fieldValue}),
	     		success : function(data) {
	     		
	     		window.location.reload()
	     		}
        	 });   

    	}

    	
    	$("#Assignedto").on('change', function(){
    		
    		   var assignedValue = this.value;
  	         
    		var token=sessionStorage.getItem("token");
    		$.ajax({
	        	type : "POST",
	     		contentType : "application/json",
	     		url : "<%=restURL%>rmshd/update/assignto?ticketId="+'<%= ticketId%>'+"&assigned="+assignedValue,
	     		dataType : 'json',
	     		headers: {'Access-Control-Allow-Origin': '*','Authorization':'Bearer '+token},
	     		timeout : 100000,
	     		crossDomain: true,
	     		success : function(data) {
	     			
	     		},
    		});
    		window.location.reload()
    	})


    </script>
	
</body>
</html>