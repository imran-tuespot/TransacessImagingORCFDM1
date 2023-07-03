<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-control" content="no-cache">
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script	src="js/bootstrap/3.3.5/jquery.min.js"></script>
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
		 <link href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" />
        <title>Add Rights</title>
         <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> 		
		<title>Dashboard</title>
<% String appuserrole = (String)request.getSession().getAttribute("appuserrole");
   System.out.println("appuserrole "+appuserrole);
  Integer companyId = (Integer)request.getSession().getAttribute("comid");
   int uid = Integer.parseInt(request.getSession().getAttribute("userid").toString());
   javax.naming.Context ctx = 	new javax.naming.InitialContext();
 	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
%>
		
		
		
<!-- get roles and rights -->		
<script language=javascript>
function hideLink(id)
{
	var link_ref = document.getElementById(id);
	link_ref.style.display = 'none';
}

function initial() 
{
setHeader('rightsCreation.jsp');
var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(i == 2)
		array_of_li[i].setAttribute("class", "active");	
		
	}
		
$('.si-inner ul li').click(function() {
    var i = $(this).index();
    $('.si-inner ul li').css("background-color","FFF");
    
    $('.fullarticle').hide();
    $('#article' + (i+1)).show();
        $('.si-inner ul li:nth-child('+(i+1)+')').css("background-color","EBEBEB");
    
});

    $('#article1').show();
    
	var role = "POWERUSER";
	if ( role === "<%= appuserrole %>") 
	{
		hideLink('id_link');
	}
}

function saveRole(){
	document.getElementById("submitbtndis").disabled = true;
	$("#loadingImage123").show();
	$("#successmsg").hide();
	var roleName = $("#roleNameVal").val();
	//var companyId = $("#companyIdVal").val();
	var companyId = 1;
    var rightNames = [];
    var x=document.getElementById("lstFruits3");
	for (var i = 0; i < x.options.length; i++) {
	        if(x.options[i].selected ==true){
	              rightNames.push(x.options[i].value);
	         }
	 }
	var testData={
			 "roleName":roleName,
			 "companyId":companyId,
			 "rightId":rightNames
		};
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "<%=restURL%>/role/saveRole",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(testData),
		success : function(data) {
			$("#loadingImage123").hide();
			console.log("SUCCESS: ", data);
			document.getElementById("submitbtndis").disabled = false;
			$("#successmsg").show();
		},
		error : function(e) {
			console.log("ERROR: ", e);
			document.getElementById("submitbtndis").disabled = false;
	     	
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function addRole() { 
	var arrayOfRights=[];
	$("#addRoleList").hide();
	$("#addRoleBtn").hide();
	$("#successmsg").hide();
	$("#loadingImage123").hide();
	var companyIdValue= '<%= companyId %>';
	$.ajax({
		   type : "GET",
		   contentType : "application/json",
		   url : "<%=restURL%>/role/getRights?companyId="+companyIdValue,
		   dataType : 'json',
		   timeout : 100000,
		   success : function(data) {
		    arrayOfRights.push(data);
		    
		    for(i=0;i<data.totalRightDetails.length;i++){
		     $("#lstFruits3").append("<option value='"+data.totalRightDetails[i].rightId+"'>"+data.totalRightDetails[i].rightName+"</option>");
		     
		    } 
		   },
		   error : function(e) {
		    console.log("ERROR: ", e);
		    
		   },
		   done : function(e) {
		    console.log("DONE");
		   }
		  });
	$("#addRoleForm").show();
	$("#backBtn").show();	
}


$('input[type=text][name=folderName]').tooltip({
    placement: "bottom",
    trigger: "hover"
});

function goBackRole() {	
	$("#addRoleForm").hide();
	$("#backBtn").hide();	
	$("#addRoleList").show();
	$("#addRoleBtn").show();
	getRoles();
}

function getRoles(){
	$("#addRoleForm").hide();
	$("#backBtn").hide();
	$("#addRoleList").show();
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/role/getRoles",
		dataType : 'json',
		timeout : 1000000000000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#loadingImage1").hide();
			$("#tableStyle").show(); 
			display(data);
			$("#rolesData").dataTable();
		},
		error : function(e) {
			console.log("ERROR: ", e);
			//alert("165:"+e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	
}

function goBack() {
	$("#addRightForm").hide();
	$("#backBtn1").hide();
	location.reload();
	$("#addRightList").show();
	$("#addRightBtn").show();
	
	//getRights();
}

function getRights(){
	var companyIdValue= '<%= companyId %>';
	$("#addRightList").show();
	$("#addRightBtn").show();
	$("#addRightForm").hide();
	$("#loadingImage12").hide();
	$("#backBtn1").hide();	
	$("#successmsg1").hide();
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/role/getRights?companyId="+companyIdValue,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#loadingImage").hide();
			$("#tableStyle1").show();
			displayRights(data);
			$("#example1").dataTable();
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayRights(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	
}
function saveRights(){
	var folderPattern =[];
	 var companyIdValue= '<%= companyId %>';
	 var userIdvalue='<%=uid%>';
	 
	 $("#loadingImage12").show();
	 $("#successmsg1").hide();
	 document.getElementById("submitbtndisa").disabled = true;
	 var rightName = $("#rightNameVal").val();
	 var accesstype = $("#rightAccessType option:selected").text();
	 folderPattern= $("#folderIdVal").val().split(",");
	
	 rightDescription =  $("#rightDescriptionVal").val();
     var isAvailble = true;
     var message="Please Enter the parameters::";
     if(rightName == ""){
    	
    	 isAvailble= false;
    	 message += "Right Name ,";
     }
     if(accesstype == "Select"){
    
    	 isAvailble= false;
    	 message += "Access Type ,";
     }
     if(folderPattern.length == 1){
    	if(folderPattern[0]==""){
    	 isAvailble= false;
    	 message += "Folder Patterns ";
    	 }
     }
     if(rightDescription == ""){
    	 
    	 isAvailble= false;
    	 message += "Right Description " 
     }
     var companyIdValue= '<%= companyId %>';
	 var rightSaveData = {"rightName":rightName,"rightDescription":rightDescription,"folderPattern":folderPattern,"accessType":accesstype,"createdBy":userIdvalue,"companyId":companyIdValue}; 
	 console.log("rightSaveData::::"+JSON.stringify(rightSaveData));
	 if(isAvailble == true){
	 $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/role/saveRights",
			dataType : 'json',
			timeout : 100000000000000,
			data : JSON.stringify(rightSaveData),
			success : function(data) {
				console.log("SUCCESS: ", data);
				document.getElementById("submitbtndisa").disabled = false;
				 $("#successmsg1").show();
				$("#loadingImage12").hide();
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
				
				displayRights(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	  }else{
			 if(message.substring(message.length-1)==',') {  
				  message = message.substring(0, message.length - 1);
			  
			 } 
		  alert(message);
		  document.getElementById("submitbtndisa").disabled = false;
		  $("#loadingImage12").hide();
	  }
	 }
function display(data) {
	$.each(data.roleDetails, function(i, item) {
		//console.log("itemitemitemitemitem:::::"+JSON.stringify(item));
		 $('#rolesList').append('<tr><td>'+item.roleName+'</td></tr>');
		 
		 $.each(item.rights, function(i, item1) {
			 console.log("item1item1item1item1item1:::::"+JSON.stringify(item1));
	     $('#rolesList').append('<tr><td>'+item.roleName+'</td><td>'+item1.rightName+'</td></tr>');
		});
	});
}

function displayRights(data) {
	
	$.each(data.totalRightDetails, function(i, item) {
		var name=item.rightName;
		
		$.each(item.rightDetails, function(i, item1) {
	      $('#rightsList').append('<tr><td>'+item.rightName+'</td><td>'+item.rightDescription+'</td><td>'+item.createdName+'</td><td>'+item.createdOn+'</td><td>'+item.acessType+'</td><td>'+item1.folderPattern+'</td><td><a onclick="myWindowOpen(\''+item.rightId+'\',\''+item.rightName+'\',\''+item.rightDescription+'\',\''+item.acessType+'\',\''+item1.rightDetailId+'\',\''+item1.folderPattern+'\')"><i class="zmdi_medium zmdi zmdi-edit"></i></a></td></tr>');
		});
	});
}

function myWindowOpen(rightId,rightName,rightDescription,accessType,rightDetailId,folderPattern){ 
	 document.getElementById("rightDetailsId").value=rightDetailId;
	 document.getElementById("rightId").value = rightId;
	 document.getElementById("rightName").value = rightName;
	 document.getElementById("rightDesc").value = rightDescription;
	 document.getElementById("rightAccessType1").value = accessType;
	 document.getElementById("folderPatterns").value = folderPattern;
	 $("#loadingImageMo").hide();
	 $("#editSuccessMsg").hide();
     $("#myModal").modal('show');
 }
function UpdateRights(){
	var folderPatterns=[];
	 $("#loadingImageMo").show();
	 $("#editSuccessMsg").hide();
	 var companyIdValue= '<%= companyId %>';
	var userIdvalue='<%=uid%>';
	document.getElementById("submitbtnd").disabled = true;
	var rightId= $("#rightId").val();
	var rightDetailsId= $("#rightDetailsId").val();
	var rightName= $("#rightName").val();
	var rightDesc= $("#rightDesc").val();
	var accesstype = $("#rightAccessType1 option:selected").text();
     folderPatterns= $("#folderPatterns").val().split(",");
     var isAvailble = true;
    var message="Please Enter the parameters::";
    if(rightName == ""){
   	 isAvailble= false;
   	 message += "Right Name ,";
    }
    if(rightDesc == ""){
      	 isAvailble= false;
      	 message += "Right Description ,";
       }
    if(accesstype == "Select"){
   	 isAvailble= false;
   	 message += "Access Type ,";
    }
    if(folderPatterns.length == 1){
    	if(folderPatterns[0]==""){
    	 isAvailble= false;
    	 message += "Folder Patterns ";
    	 }
     }
    var rightSaveData = {"rightId":rightId,"rightDetailsId":rightDetailsId,"rightName":rightName,"rightDesc":rightDesc,"accessType":accesstype,"folderPatterns":folderPatterns,"userId":userIdvalue}; 
   if(isAvailble == true){
    $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/role/updateRightDetails",
			dataType : 'json',
			timeout : 10000000,
			data : JSON.stringify(rightSaveData),
			success : function(data) {
				 console.log("SUCCESS: ", data);
				 $("#loadingImageMo").hide();
				 $("#editSuccessMsg").show();
				document.getElementById("submitbtnd").disabled = false;
				location.reload();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				document.getElementById("submitbtnd").disabled = false;
			},
			done : function(e) {
				console.log("DONE");
			}
		});
   }else{
	   alert(message);
	   $("#loadingImageMo").hide();
	   document.getElementById("submitbtnd").disabled = false;
   }
    
}
$(function() {
});

function addRightForm() {
	$("#addRightList").hide();
	$("#addRightBtn").hide();
	$("#addRightForm").show();
	$("#loadingImage12").hide();
	$("#backBtn1").show();	
	$("#successmsg1").hide();
}

function loadFunction() {
    initial_load();
    getRights();
   }

</script>

<script type="text/javascript">
        $(function () {
            $('#lstFruits').multiselect({
                includeSelectAllOption: true
            });
            $('#lstFruits1').multiselect({
                includeSelectAllOption: true
            });
            $('#btnSelected').click(function () {
                var selected = $("#lstFruits option:selected");
                var message = "";
                selected.each(function () {
                    message += $(this).text() + " " + $(this).val() + "\n";
                });
                alert(message);
            });	
            $('#btnSelected').click(function () {
                var selected = $("#lstFruits1 option:selected");
                var message = "";
                selected.each(function () {
                    message += $(this).text() + " " + $(this).val() + "\n";
                });
                alert(message);
            });		
            /* $('#btnSelected').click(function () {
                var selected = $("#lstFruits3 option:selected");
                var message = "";
                selected.each(function () {
                    message += $(this).text() + " " + $(this).val() + "\n";
                });
                alert(message);
            });		 */
        });        
    </script>
    <script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();   
    });
    </script>
    
   <!-- <!--  <script>
    $(document).ready(function() {
        $('#example').DataTable();
        $('#example1').DataTable();
    } );
    </script> -->
    
    
		<style type="text/css">
		
		
		
 .tooltip-inner {
            max-width: none;
            word-break: break-all;
        }
	
	.fullarticle { 
  		display: none;
	}
	.panel-body{
		text-align: left;
		padding-left: 15px;
	}
	.modal {
	  text-align: center;
	  padding: 0!important;
	}
	
	.modal:before {
	  content: '';
	  display: inline-block;
	  height: 100%;
	  vertical-align: middle;
	  margin-right: -4px;
	}
	.modal-dialog {
	  display: inline-block;
	  text-align: left;
	  vertical-align: middle;
	}
	.buttonAction {
		position: absolute;
	    top: 14px;
	    right: 20px;

	}
	.applicationMainContentAreaContainer { position: relative; }
	table.dataTable thead th {
	    background-color: #7098CC;
	    color: #fff;
	}
	#moduleLists_filter input {
		height: 35px;
	    border: 1px solid #ccc;
	    box-shadow: inset 0 0 3px #ccc;
	}
	#moduleLists_length select {
		padding: 10px;
	    border: 1px solid #ccc;
	    box-shadow: inset 0 0 3px #ccc;
	}
	.dataTables_filter { margin-bottom: 10px; }
	
	</style>		
<!-- Get roles and rights -->			
		
		
		
		
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<!-- <script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" /> -->
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" /> 
		
		

</head>


<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>

<jsp:include page="includes/sessionHeader.jsp" />


<body onLoad="loadFunction()" >

<!-- <form name="upload" method="post" > -->

  <div align="center" style="margin:10px;">
					<p style="color:green;font-size:16px;text-align: left;margin-bottom:10px;margin-left:10px;"><i class="zmdi_large zmdi-present-to-all"></i>Rights</p>
  
 	<div class="card" style="width: 95%;  padding-left: 0px;">
		<div class="card-body card-padding" style="padding: 16px 6px 0px;background-color:#EDECEC;margin-bottom: 20px;">
		
		<!-- Rights Area -->
<div class="smallWhiteHeader"><i class="zmdi_large zmdi-accounts-add" style="color:#F90;"></i> Rights
			<button class="btn btn-success pull-right btn-orange" id="addRightBtn" onclick="addRightForm()">
			<div class="d-table">
				<div class="d-tbcell v-middle"><i class="zmdi_medium zmdi-plus-circle-o"></i></div>
				<div class="p-left10 d-tbcell v-middle">Add Rights</div>
			</div>
			</button>
			<button id="backBtn1"  class="btn btn-success pull-right btn-orange" onclick="goBack()" style="display: none;">Back</button>
	        
		</div>
	
		<div class="smallSectionText" style="min-height:460px;">		
			<div id="addRightList" class="smallSectionTextPadding" style="margin:20px;min-height: 420px; background-color: #FFF;padding: 20px;">
			
			<div id="loadingImage"><img src="css/images/default.gif" /></div>
			<div id="tableStyle1" style="display:none">
			
			
			<div class="table-responsive">
			<table id="example1" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						
						<th>Right Name</th>
						<th>Right Description</th>
						<th>Created By</th>
						<th>Created On</th>
						<th>Access Type</th>
						<th>Folder Pattern</th>
						<th>Action</th>
						
					</tr>
				</thead>
				<tbody id="rightsList">
				
				</tbody>
        	</table>
			</div>
			
			</div>
		</div>
		
		
		<div id="addRightForm" class="smallSectionTextPadding" style="margin:20px;min-height: 420px; display: none; height: 420px;background-color: #FFF;padding: 20px;">
				<div id="loadingImage12" style="position :absolute;top:30%;left:0px;right:0px;margin:auto;text-align:center"><img src="css/images/default.gif" /></div>
			<div class="row">
			
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center" >
				     <div style="text-align:center;" id="successmsg1">
				     	<h4 style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;"><i class="zmdi_medium zmdi-check"></i>
				     		<span style="padding-left: 8px;">Right added successfully</span>
				     	</h4>
				     </div>
				</div>
			
				<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12" style="margin-top:40px;">
				
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-left">
                                   <label style="font-size:15px;margin-top:10px;">Right Name</label>
                             </div>	
                             <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">			
                                   <input id="rightNameVal" name="rightName"  class="form-control input-lg " style="background-color:#FDFDFE" placeholder="Rights Name" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
                  </div>
						<!-- <div class="rowSetting" style="padding-top: 20px;">						
								
								<div class="fg-line">
                                    <input id="" name="" class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Company ID" type="text" >
                                </div>							
						</div> -->
						<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12">
						 <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-left">
                                   <label style="font-size:15px;margin-top:10px;">Right Description</label>
                             </div>	   
                                  <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                                    <input id="rightDescriptionVal" name="rightDesc" class="form-control input-lg " style="background-color:#FDFDFE" placeholder="Right Description" type="text" >
                                </div>       
                      </div>
                      
                      
						<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12" >						
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-left">
									 <label style="font-size:15px;margin-top:10px;">Access Type</label>
									 </div>
									 <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                                     <select style="color:black !important" id="rightAccessType" class="selectStyle lineheight30" placeholder="Access Type">
                                        <option value="">Select</option>
						                <option value="ReadOnly">ReadOnly</option>
						                <option value="Create">Create</option>
						                <option value="WriteOnly">WriteOnly</option>
						                <option value="ReadWrite">ReadWrite</option>
                                     </select>
                                </div>	
						</div>
						
						
						<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12">						
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-left">
									<label style="font-size:15px;margin-top:10px;">Folder Pattern</label>
									</div>
									<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
									 <input data-placement="bottom" data-toggle="tooltip" title="Examples::/80001358424/000-22211/Production/* , /*/*/123456/* , /80001358424/000-22211/Production/00_HUD_UW" id="folderIdVal" name="folderName" class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Folder Patterns with Comma ( , ) separated values" type="text" >
                                </div>	
						</div>
						<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12 p-top40">	
							<button type="submit" id="submitbtndisa"   class="btn btn-success text-left btn-orange width120" onclick="saveRights()">Submit</button>
						</div>
						
				</div>
				
			</div></div>
		<!-- Rights Area -->
		
		</div>
		</div>
	</div>		
<!-- </form> -->

<div class="modal " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" style="background-color:#7098CC" >
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel" style="color:white">Edit Folder Permissions</h4>
                </div>
                <div class="modal-body">
                <div id="loadingImageMo" style="position :absolute;top:30%;left:0px;right:0px;margin:auto;text-align:center"><img src="css/images/default.gif" /></div>
                        <div style="text-align:center;" id="editSuccessMsg">
				     	<h4 style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;"><i class="zmdi_medium zmdi-check"></i>
				     		<span style="padding-left: 8px;">Rights Edited successfully</span>
				     	</h4>
				     </div>
                  <div>
					   <div class="rowSetting">			
							<div class="fg-line">
                                   <input type="hidden" id="rightDetailsId" name="rightDetailsId"  class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Right Detail Id" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
						</div>
						<div class="rowSetting">			
							<div class="fg-line">
                                   <input type="hidden" id="rightId" name="rightId"  class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Right  Id" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
						</div>
						<div class="rowSetting">			
							<div class="fg-line col-lg-12" style="padding:0px;">
								<div class="col-lg-4" style="margin-top:12px;">
                                <label>Right Name</label>
                                </div>  
                                <div class="col-lg-8">
                                   <input id="rightName" name="rightName"  class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Right Name" type="text" onfocus="javascript:addClass();" onblur="">
                                </div>
                             </div>
						</div>
						<div class="rowSetting">			
							<div class="fg-line col-lg-12" style="padding:0px;">
								<div class="col-lg-4" style="margin-top:12px;">
                                <label>Right Description</label>
                                </div>  
                                <div class="col-lg-8">
                                   <input id="rightDesc" name="rightDesc"  class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Right Description" type="text" onfocus="javascript:addClass();" onblur="">
                                  </div>
                             </div>
						</div>
						<div class="rowSetting">						
								<div class="">
									<div class="col-lg-4" style="margin-top:12px;">
	                                <label>Access Type</label>
	                                </div> 
									 <!-- <lable class="text-left labelText">AccessType</lable> -->
									 <div class="col-lg-8">
                                     <select style="color: black !important" id="rightAccessType1" class="selectStyle lineheight27" placeholder="AccessType">
                                        <option value="">Select</option>
						                <option value="ReadOnly" selected="selected">ReadOnly</option>
						                <option value="Create" selected="selected">Create</option>
						                <option value="WriteOnly" selected="selected">WriteOnly</option>
						                <option value="ReadWrite" selected="selected">ReadWrite</option>
                                     </select>
                                     </div>
                                </div>	
						</div>
						<div class="rowSetting">			
							<div class="fg-line col-lg-12" style="padding:0px;">
								<div class="col-lg-4" style="margin-top:12px;">
                                <label>Folder Pattern</label>
                                </div>  
                             <div class="col-lg-8">
                                   <input id="folderPatterns" name="folderPatterns"  class="form-control input-lg" style="background-color:#FDFDFE" placeholder="FolderPatterns" type="text" onfocus="javascript:addClass();" onblur="">
                              </div>
                             </div>
                             <div class="clearfix"></div>
                             <div class="rowSetting text-center">	
							<button  style="margin-top: 10px;" type="submit" id="submitbtnd"   class="btn btn-success text-left btn-orange width120" onclick="UpdateRights()">Submit</button>
						</div>
						</div>
						
						
						</div>
                </div>
               <!--  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div> -->
            </div>
        </div>
    </div>

<script language="javascript">


function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try 
   {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); // For Old Microsoft Browsers
   }
   catch (e) 
   {
     try 
     {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp = false;   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}


function initial_load() {
	
	setHeader('rightsCreation.jsp');
	<%-- var data = '<%=html%>';
    var s = [];   
    var dataArray = data.split(',');
   
    for(var i=0; i< dataArray.length;i++)
    {
        if((dataArray[i].split("/").length-1) === 2)
        {
            //alert(dataArray[i] +"  "+(dataArray[i].split("/").length-1));
        
        	var str =  dataArray[i];
        	//alert("Pushing "+ str);
        	s.push(str);
        }
       
    }  --%> 
	/* $('#fileTreeDemo_3').fileTree({ root: '/',expandedFolders: s , script: 'connectors/jqueryFolderTree.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'Un momento...' }, function(file) { 
					//alert(file);
	}); */
	
	
	 //Initialize slider menu
      $('#simple-menu').sidr();
      
	  $('.child').hide();
	  $('.parent').click(function() {
// 		 $('.child').slideUp();
// 		 $(this).find('ul').slideToggle();
		  var status=$(this).find('ul').is(":hidden");
			var child1 =$('.child1').find('li').is(":hidden");
			var child2 =$('.child2').find('li').is(":hidden");
			var child3 =$('.child3').find('li').is(":hidden");
			var child4 =$('.child4').find('li').is(":hidden");
		
			if(status){
				if(!child1){ $('.child1').parent().find('ul').slideUp();}
				if(!child2){ $('.child2').parent().find('ul').slideUp();}
				if(!child3){ $('.child3').parent().find('ul').slideUp();}
				if(!child4){ $('.child4').parent().find('ul').slideUp();}
				$(this).find('ul').slideDown();	
			}else{
				$(this).find('ul').slideUp();
			}
	  });
	 // $('#adminWizardLi').click();
	  $("#adminWizardLi").collapse('toggle'); 
	
	
}







String.prototype.trim = function () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}
</script>

</body>
</html>

