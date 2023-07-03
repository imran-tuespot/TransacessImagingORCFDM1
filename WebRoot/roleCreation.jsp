
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
		<!-- <script src="js/jQuery/jquery-1.8.2.min.js"></script> -->
		
		
		
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- <script src="js/jQuery/1.11.3/jquery.min.js"></script> -->
	<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
	<script
	src="js/bootstrap/3.3.5/jquery.min.js"></script>
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
		 <link href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" />
        
         <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> 		
		<title>Dashboard</title>
<% String appuserrole = (String)request.getSession().getAttribute("appuserrole");
   Integer companyId = (Integer)request.getSession().getAttribute("comid");
  System.out.println("cmp"+companyId);
   int uid = Integer.parseInt(request.getSession().getAttribute("userid").toString());
   javax.naming.Context ctx = 	new javax.naming.InitialContext();
 	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
  // String contextLoginId = (String)session.getAttribute("contextLoginId");
%>
		
		
		
<!-- get roles and rights -->		
<script language=javascript>
var roleFlag=false;
var editRoleFlag=false;
function hideLink(id)
{
	var link_ref = document.getElementById(id);
	link_ref.style.display = 'none';
}

function initial() 
{
setHeader('dashboard.jsp');
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
	 var companyId = '<%=companyId%>';
	 var userIdvalue='<%=uid%>';
	 rightNames = [];
	 var x=document.getElementById("lstFruits3");
	 for (var i = 0; i < x.options.length; i++) {
	         if(x.options[i].selected ==true){
	               rightNames.push(x.options[i].value);
	          }
	  }
	 var isAvailble = true;
     var message="Please Enter the Values for  parameters::";
     if(roleName == ""){
    	 isAvailble= false;
    	 message += "Role Name,";
     }
     if(rightIdOfCheckBox == ""){
    	 isAvailble= false;
    	 message += "Rights,";
     }
     if(rightNames == ""){
    	 isAvailble= false;
    	 message += "Module Name,";
     }
    
	 
	  var testData={
	     "roleName":roleName,
	     "rightId":rightIdOfCheckBox,
	     "moduleId":rightNames,
	     "userId":userIdvalue,
	     "companyId":companyId
	   };
	 if(isAvailble == true){
	 $.ajax({
	  type : "POST",
	  contentType : "application/json",
	  url : "<%=restURL%>/role/saveRole",
	  dataType : 'json',
	  timeout : 100000,
	  data : JSON.stringify(testData),
	  success : function(data) {
	   $("#loadingImage123").hide();
	   console.log("SUCCESS: ", JSON.stringify(data));
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
	 }else{
		 if(message.substring(message.length-1)==',') {  
				  message = message.substring(0, message.length - 1);
			  
			 } 
		 alert(message);
		 $("#loadingImage123").hide();
		   document.getElementById("submitbtndis").disabled = false;
	 }
	}

<%-- function saveRole(){
	document.getElementById("submitbtndis").disabled = true;
	$("#loadingImage123").show();
	$("#successmsg").hide();
	var companyIdValue= '<%= companyId %>';
	var userIdvalue='<%=uid%>';
	var roleName = $("#roleNameVal").val();
	
	
    var rightNames = [];
    var x=document.getElementById("lstFruits3");
	for (var i = 0; i < x.options.length; i++) {
	        if(x.options[i].selected ==true){
	              rightNames.push(x.options[i].value);
	         }
	 }
	var testData={
			 "roleName":roleName,
			 "companyId":companyIdValue,
			 "rightId":rightNames,
			 "userId":userIdvalue
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
} --%>

function addRole() { 
	var arrayOfRights=[];
	$("#addRoleList").hide();
	$("#showRights").hide();
	$("#addRoleBtn").hide();
	$("#backBtnForm").hide();
	/* $("#getDone").hide(); */
	$("#successmsg").hide();
	$("#loadingImage123").hide();
	var companyIdValue= '<%= companyId %>';
	$.ajax({
	     type : "GET",
	     contentType : "application/json",
	     url : "<%=restURL%>/role/getModules?companyId="+companyIdValue,
	     dataType : 'json',
	     timeout : 100000,
	     success : function(data) {
	     
	       arrayOfRights.push(data);
	       for(i=0;i<data.moduleDetails.length;i++){
	       $("#lstFruits3").append("<option value='"+data.moduleDetails[i].moduleId+"'><b>"+data.moduleDetails[i].moduleName+"</b></option>");
	       
	      } 
	      console.log("Data:"+JSON.stringify(data));
	      },
	     error : function(e) {
	      console.log("ERROR: ", e);
	      
	     }
	});
	$("#addRoleForm").show();
	$("#backBtn").show();	
}

/* 
$(function () {
	$("#moduleLists").dataTable();
}); */

function goBackRole() {	
	location.reload();
	$("#addRoleForm").hide();
	$("#backBtn").hide();
	$("#backBtnForm").hide();
	$("#showRights").hide();
	$("#addRoleList").show();
	$("#addRoleBtn").show();
	getRoles();
	$("#rolesDataDetails").dataTable();
}
var  rightnameCheckboxEdit=[];
var rightIdOfCheckBoxEdit=[];
function getDone(){
	$("#myModal123").modal("show");
	$("#addRoleForm").hide();
	$("#backBtn").hide();
	$("#addRoleList").hide();
	$("#addRoleBtn").hide();
	$("#showRights").hide();
	$("#backBtnForm").hide();
	$("#getDone").hide();
	$("#editRightsForm").hide();
	$("#addRoleList").show();
	 rightnameCheckboxEdit=[];
	 rightIdOfCheckBoxEdit=[];
	 $('#moduleLists123 tr input[type=checkbox]').each(function () {
	       
         console.log(this.checked);
         if(this.checked==true){
        
          rightIdOfCheckBoxEdit.push(parseInt(this.value));
          rightnameCheckboxEdit.push(this.name);
        
         }
        // alert("rightIdOfCheckBoxEditrightIdOfCheckBoxEdit::::::"+rightIdOfCheckBoxEdit);
         $("#editRightId").val(rightIdOfCheckBoxEdit);
         $("#editRightName").val(rightnameCheckboxEdit);
         
     });
}
function editRights(){
	$("#myModal123").modal("hide");
	$("#addRoleForm").hide();
	$("#backBtn").hide();
	$("#addRoleList").hide();
	$("#addRoleBtn").hide();
	$("#showRights").hide();
	$("#backBtnForm").hide();
	$("#getDone").show();
	$("#editRightsForm").show();
	var rightId123 = $("#editRightId").val();
	//alert("abc:::::::"+rightId123);
	$("#rightId").prop( "checked", true );
	var companyIdValue= '<%= companyId %>';
	if(editRoleFlag==false){
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/role/getRights?companyId="+companyIdValue,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			editRoleFlag=true;
			console.log("SUCCESS: ", data);
			$("#loadingImage").hide();
			$("#tableStyle1").show();
			editRightsDetails(data,rightId123);
			$("#moduleLists123").dataTable();
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
}
function showRights() {
	$("#addRoleForm").hide();
	$("#backBtn").hide();
	$("#addRoleList").hide();
	$("#addRoleBtn").hide();
	$("#backBtnForm").show();
	$("#showRights").show();
	var companyIdValue= '<%= companyId %>';
	if(roleFlag == false){
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/role/getRights?companyId="+companyIdValue,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			 /* if ($.fn.DataTable.isDataTable("#moduleLists1234")) {
				  $('#moduleLists1234').DataTable().clear().destroy();
				}  */
				roleFlag=true;
			$("#loadingImage12345").hide();
			$("#tableStyle123").show();
			displayRights(data);
			$("#moduleLists1234").dataTable();
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
}

var  rightnameCheckbox=[];
var rightIdOfCheckBox=[];
function goBackForm() {
	 $("#addRoleList").hide();
	 $("#backBtnForm").hide();
	 $("#showRights").hide();
	 $("#addRoleBtn").hide();
	 $("#backBtn").show();
	 $("#addRoleForm").show(); 

	 rightnameCheckbox=[];
	 rightIdOfCheckBox=[];
	      $('#moduleLists1234 tr input[type=checkbox]').each(function () {
	       
	          console.log(this.checked);
	          if(this.checked==true){
	          
	           rightIdOfCheckBox.push(this.value);
	           rightnameCheckbox.push(this.name);
	         
	          }
	          $("#rightNameVal").val(rightnameCheckbox);
	          
	      }); 
	      
	    
	      
	    
	}

function getRoles(){
	
	$("#addRoleForm").hide();
	$("#backBtn").hide();
	$("#getDone").hide();
	$("#addRoleList").show();
	var companyIdValue= '<%= companyId %>';
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/role/getRolesList?companyId="+companyIdValue,
		dataType : 'json',
		timeout : 100000000000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#loadingImage1").hide();
			$("#tableStyle").show(); 
			display(data);
				$("#rolesDataDetails").dataTable();
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
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
	$("#addRightList").show();
	$("#addRightBtn").show();	
	getRights();
}

function getRights(){
	$("#addRightList").show();
	$("#addRightBtn").show();
	$("#addRightForm").hide();
	$("#loadingImage12").hide();
	$("#backBtn1").hide();	
	$("#successmsg1").hide();
	var companyIdValue= '<%= companyId %>';
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
	 $("#loadingImage12").show();
	 $("#successmsg1").hide();
	 document.getElementById("submitbtndisa").disabled = true;
	 var rightName = $("#rightNameVal").val();
	 var accesstype = $("#rightAccessType option:selected").text();
	 var folderPattern= $("#folderIdVal").val().split(",");
     var rightDescription =  $("#rightDescriptionVal").val();
	 var rightSaveData = {"rightName":rightName,"rightDescription":rightDescription,"folderPattern":folderPattern,"accessType":accesstype}; 
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
function display(data) {
	$.each(data.roleDetails, function(i, item) {
		 $.each(item.roleDetailsList, function(i, item1) {
			 $.each(item.moduleDetailsList, function(i, item2) { 
		     $('#rolesList').append('<tr><td>'+item1.roleName+'</td><td>'+item1.rightName+'</td><td>'+item2.moduleName+'</td><td><a id="editB" onclick="hello(\''+item1.roleName+'\',\''+item1.rightName+'\',\''+item2.moduleName+'\',\''+item1.roleId+'\',\''+item1.roleRightId+'\',\''+item1.rightId+'\',\''+item2.moduleId+'\',\''+item2.roleModuleId+'\')"><i class="zmdi_medium zmdi zmdi-edit"></i></a></td></tr>');
			 });
		});
	});
}


function hello(roleName,rightName,moduleName,roleId,roleRightId,rightId,moduleId,roleModuleId){
	$("#loadingImage456").hide();
	 $("#editSuccessMsg").hide();
	document.getElementById("editRoleName").value=roleName;
	document.getElementById("editRightName").value=rightName;
	document.getElementById("lstFruits34").value=moduleId;
	document.getElementById("editRoleId").value=roleId;
	document.getElementById("editRightId").value=rightId;
	document.getElementById("editRoleRightId").value=roleRightId;
	document.getElementById("editModuleId").value=moduleId;
	document.getElementById("editRoleModuleId").value=roleModuleId;
	var companyIdValue= '<%= companyId %>';
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/role/getModules?companyId="+companyIdValue,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			var select="selected";
			for(i=0;i<data.moduleDetails.length;i++){
			     $("#lstFruits34").append("<option   value='"+data.moduleDetails[i].moduleId+"' selected='"+select+"'>"+data.moduleDetails[i].moduleName+"</option>");
			    } 
			document.getElementById("lstFruits34").value=moduleId;
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayModules(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	$("#myModal123").modal("show");
}

function updateRoles(){
	$("#loadingImage456").show();
	 $("#editSuccessMsg").hide();
	 document.getElementById("submitbtndis123").disabled = true;
	var roleName = $("#editRoleName").val();
	var roleId = $("#editRoleId").val();
	var roleModuleId= $("#editRoleModuleId").val();
	var roleRightId= $("#editRoleRightId").val();
    var rightId=rightIdOfCheckBoxEdit;   
	var x=document.getElementById("lstFruits34");
	var moduleId = [];
	for (var i = 0; i < x.options.length; i++) {
	        if(x.options[i].selected ==true){
	        	moduleId.push(parseInt(x.options[i].value));
	         }
	 }
	var isAvailble = true;
    var message="Please Enter the Values for  parameters::";
    if(roleName == ""){
   	 isAvailble= false;
   	 message += "Role Name,";
    }
    if(rightId == ""  ){
    	if($("#editRightName").val().trim()==""){
   	 isAvailble= false;
   	 message += "Rights,";
    	}
    }
    if(moduleId == ""){
   	 isAvailble= false;
   	 message += "Module Name,";
    }
    
	
	var testData={
			 "roleName":roleName,
			 "roleId":roleId,
			 "roleRightId":roleRightId,
			 "roleModuleId":roleModuleId,
			 "moduleId":moduleId,
			 "rightId":rightId
		};
   if(isAvailble == true){   
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "<%=restURL%>/role/updateRoleDetails",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(testData),
		success : function(data) {
			$("#loadingImage456").hide();
			console.log("SUCCESS: ", data);
			document.getElementById("submitbtndis123").disabled = false;
			$("#editSuccessMsg").show();
			location.reload();
		},
		error : function(e) {
			console.log("ERROR: ", e);
			document.getElementById("submitbtndis123").disabled = false;
	     	
		},
		done : function(e) {
			console.log("DONE");
		}
	})
   }else{
	   if(message.substring(message.length-1)==',') {  
			  message = message.substring(0, message.length - 1);
		 } 
	   alert(message);
	   $("#loadingImage456").hide();
		document.getElementById("submitbtndis123").disabled = false;
   }
	
}

function displayRights(data) {

	$.each(data.totalRightDetails, function(i, item) {
		/* $.each(item.rightDetails, function(i, item1) { */
	     // $('#displayRights').append('<tr><td>'+item.rightName+'</td><td>'+item.rightDescription+'</td><td>'+item.acessType+'</td><td><input id="checkValue" type="checkbox"  onclick="rightIds(\''+item.rightId+'\',\''+item.rightName+'\')"/></td></tr>');
			$('#displayRights').append('<tr><td><input  type="checkbox" id="checkValue"  value="'+item.rightId+'" class="checkValues"  name="'+item.rightName+'" />&emsp;<label>'+item.rightName+'</label></td><td>'+item.rightDescription+'</td><td>'+item.acessType+'</td></tr>');
		/* }); */
	});
}

function editRightsDetails(data, checkedId) {
	$.each(data.totalRightDetails, function(i, item) {
		var rightId=item.rightId;
		if(item.rightId==checkedId){
			$('#editRights').append('<tr><td><input  type="checkbox"  checked="true" id="checkValue"  value="'+item.rightId+'" class="checkValues"  name="'+item.rightName+'" />&emsp;<label>'+item.rightName+'</label></td><td>'+item.rightDescription+'</td><td>'+item.acessType+'</td></tr>');
		}else{
			$('#editRights').append('<tr><td><input  type="checkbox" id="checkValue"  value="'+item.rightId+'" class="checkValues"  name="'+item.rightName+'" />&emsp;<label>'+item.rightName+'</label></td><td>'+item.rightDescription+'</td><td>'+item.acessType+'</td></tr>');
		}
		
	});
}

var rightIdsChecked=[];
var rightIdsName=[];
 function rightIds(id,name){
	 $('#checkValue').change(function(){

		    if($(this).attr('checked')){
		          $(this).val('TRUE');
		     }else{
		          $(this).val('FALSE');
		     }
		    
		    alert($(this).val());
		    
		});
	
 }

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
    getRoles();
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
    
    
   <!-- <!--  <script>
    $(document).ready(function() {
        $('#example').DataTable();
        $('#example1').DataTable();
    } );
    </script> -->
    
    
	<style type="text/css">
	
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

 	<div>
		<div>
		
		<!-- Roles Area -->
		<div class="buttonAction">
			<button class="btn btn-success pull-right btn-orange" onclick="addRole()" id="addRoleBtn">
			<div class="d-table">
				<div class="d-tbcell v-middle"><i class="zmdi_medium zmdi-plus-circle-o"></i></div>
				<div class="p-left10 d-tbcell v-middle">Add Roles</div>
			</div>
			</button>
			<button id="backBtn"  class="btn btn-success pull-right btn-orange" onclick="goBackRole()" style="display: none;">
				<div class="d-table">
					<div class="d-tbcell v-middle"><i class="zmdi_medium zmdi zmdi-caret-left-circle"></i></div>
					<div class="p-left10 d-tbcell v-middle">Back</div>
				</div>
			</button>
			 <button id="getDone"  class="btn btn-success pull-right btn-orange" onclick="getDone()" style="display: none;">
				<div class="d-table">
					<div class="d-tbcell v-middle"><i class="zmdi_medium zmdi zmdi-caret-left-circle"></i></div>
					<div class="p-left10 d-tbcell v-middle">Done</div>
				</div>
			</button> 
			<button id="backBtnForm"  class="btn btn-success pull-right btn-orange" onclick="goBackForm()" style="display: none;">
				<div class="d-table">
					<div class="d-tbcell v-middle"><i class="zmdi_medium zmdi zmdi-caret-left-circle"></i></div>
					<div class="p-left10 d-tbcell v-middle">Back</div>
				</div>
			</button>
		</div>
		
	<!-- <button class="btn btn-success pull-right btn-orange" onclick="GetRoles()" id="addRoleBtn">GetRoles</button> -->
		<div class="smallSectionText" style="min-height:460px;" >
		
		
			<div id="addRoleList" class="smallSectionTextPadding" style="margin:20px;min-height: 420px; background-color: #FFF;padding: 20px;">
			
			<div id="loadingImage1"><img src="css/images/default.gif" /></div>
			
			<div id="tableStyle" style="display:none">
			<table id="rolesDataDetails" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Role Name</th>
						<th>RightName</th>
						<th>Module Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody id="rolesList">
				</tbody>
			</table>
			<!-- <table id="rolesDataDetails" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Role Name</th>
						<th>RightName</th>
					</tr>
				</thead>
				<tbody >
					<tr>
						<td>1</td>
						<td>1</td>
					</tr>
					<tr>
						<td>1</td>
						<td>1</td>
					</tr>
					<tr>
						<td>1</td>
						<td>1</td>
					</tr>
				</tbody>
			</table> -->
			</div>	
		
	       </div>
		
			<div id="addRoleForm" class="smallSectionTextPadding" style="margin:20px;min-height: 420px; display: none; background-color: #FFF;padding: 20px;">
			<div id="loadingImage123" style="position :absolute;top:30%;left:0px;right:0px;margin:auto;text-align:center"><img src="css/images/default.gif" /></div>
			<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center" >
				     
				     <div style="text-align:center; color: green" id="successmsg">
				     	<h4 style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;"><i class="zmdi_medium zmdi-check"></i>
				     		<span style="padding-left: 8px;">Roles added successfully</span>
				     	</h4>
				     </div>
				     
				</div>
			
				<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12" style="margin-top:15px">
			<!-- <form name="roleForm" method="post" > -->
				
					 <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-left">
					 <label style="font-size:15px;margin-top:10px;">Role Name</label>
					 </div>			
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                         <input id="roleNameVal" name=""  class="form-control input-lg text-center"  placeholder="Enter Role Name" type="text" onfocus="javascript:addClass();" onblur="">
                    </div>
				</div>

						<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12" style="margin-top:15px">
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-left">
					 <label style="font-size:15px;margin-top:10px;">Right Name</label>
					 </div>	
					   <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
					         <input id="rightNameVal" name="" onclick="showRights()" class="form-control input-lg text-center"  placeholder="Right Name" type="text" onfocus="javascript:addClass();" onblur="">
                        </div>
                        </div>
                        
                        
                        
						<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12" style="margin-top:15px">
					         <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-left">
					           <label style="font-size:15px;margin-top:40px;">Module Name</label>
					           </div>	
					        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
					         <select id="lstFruits3"  class="selectStyle" placeholder="Module Name" multiple ="multiple" style="margin-bottom: 15px;height: 120px;color: black;" >
					         <!-- 	<option>Module Name</option> -->
					         </select>
					         </div>
                        </div>
                        
                        
                        
						<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12 " style="padding-top: 40px;">	
							<button type="submit" onclick="saveRole()" id="submitbtndis" class="btn btn-success text-left btn-orange">Submit</button>
						</div>
							
						
		<!-- 	</form> -->
				<!-- </div> -->
				<!-- <div class="col-lg-7 col-md-4 col-sm-4 col-xs-12 text-center" >
				<div style="text-align:center" id="successmsg" >Role added successfully</div>
				</div> -->
			</div>
				
			</div>
			
		<!-- 	Kiran -->
		 <div class="modal " id="myModal123" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" style="background-color:#7098CC">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel" style="color:white">Edit Role Details</h4>
                </div>
                <div class="modal-body">
                    	 <div id="loadingImage456" style="position :absolute;top:30%;left:0px;right:0px;margin:auto;text-align:center"><img src="css/images/default.gif" /></div>
                        <div style="text-align:center;" id="editSuccessMsg">
				     	<h4 style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;"><i class="zmdi_medium zmdi-check"></i>
				     		<span style="padding-left: 8px;">Role Edited successfully</span>
				     	</h4>
				     </div>
                    <div>
					 <div class="rowSetting">			
							<div class="fg-line" style="padding:0px;">
                                 <div class="col-lg-4" style="margin-top:12px;">
                                <label>Role Name</label>
                                </div>  
                                <div class="col-lg-8">
                                   <input id="editRoleName" name="roleName"  class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Role Name" type="text" onfocus="javascript:addClass();" onblur="">
                             	</div>
                             </div>
						</div>
						 <div class="rowSetting">			
							<div class="fg-line col-lg-12" style="padding:0px;">
								<div class="col-lg-4" style="margin-top:12px;">
                                <label>Right Name</label>
                                </div>  
                                <div class="col-lg-8">
                                   <input id="editRightName" name="rightName"  onclick="editRights()" class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Right Name" type="text" onfocus="javascript:addClass();" onblur="" readonly>
                             	</div>
                             </div>
						</div>
						 <div class="rowSetting">			
							<div class="fg-line" style="padding:0px;">
                                 <div class="col-lg-4" style="margin-top:12px;">
                                <label>Module Name</label>
                                </div>  
                                <div class="col-lg-8">
                                    <select id="lstFruits34" style="color:black !important" class="selectStyle" multiple="multiple"  placeholder="AccessType"  >
					               </select>
                             	</div>
                             </div>
						</div>
						 
						<div class="rowSetting">			
							<div class="fg-line">
                                   <input type="hidden" id="editRoleId" name="editRoleId"  class="form-control input-lg text-center" style="margin-top: 60px;" placeholder="Enter Module ID" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
						</div>
						<div class="rowSetting">			
							<div class="fg-line">
                                   <input type="hidden" id="editRoleRightId" name="editroleRightId"  class="form-control input-lg text-center" style="margin-top: 60px;" placeholder="Enter Module ID" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
						</div>
						<div class="rowSetting">			
							<div class="fg-line">
                                   <input type="hidden" id="editRightId" name="editrightId"  class="form-control input-lg text-center" style="margin-top: 60px;" placeholder="Enter Module ID" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
						</div>
						<div class="rowSetting">			
							<div class="fg-line">
                                   <input type="hidden" id="editModuleId" name="editModuleId"  class="form-control input-lg text-center" style="margin-top: 60px;" placeholder="Enter Module ID" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
						</div>
						<div class="rowSetting">			
							<div class="fg-line">
                                   <input type="hidden" id="editRoleModuleId" name="editroleModuleId"  class="form-control input-lg text-center" style="margin-top: 60px;" placeholder="Enter Module ID" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
						</div>
						<div class="rowSetting text-center" style="padding-top: 40px;">	
							<button type="submit" onclick="updateRoles()" id="submitbtndis123" class="btn btn-success text-left btn-orange">Submit</button>
							<!-- <button type="submit" id="submitbtndisa1"   class="btn btn-success text-left btn-orange width120" onclick="UpdateRoles()">Submit</button> -->
						</div>
						</div>
                </div>
            </div>
        </div>
    </div>
		<!-- Kiran Ends -->
           <div id="editRightsForm" class="smallSectionTextPadding" style="min-height: 420px; display: none; background-color: #FFF;padding: 20px;">
				
				<div id="loadingImage"><img src="css/images/default.gif" /></div>
				<div id="tableStyle1" style="display:none">
					<div class="table-responsive">
					
					<table id="moduleLists123" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<!-- <th>Check</th>	 -->
								<th>Right Name</th>
								<th>Right Description</th>
								<th>Access Type</th>		
													
							</tr>
						</thead>
						<tbody id="editRights">
							<!-- <tr>
								<td>Date</td>
								<td>Date</td>
								<td>Date</td>
								<td><input type="checkbox" /></td>
							</tr> -->
						</tbody>
		        	</table>
					</div>
					
				</div>			
			</div>

			<div id="showRights" class="smallSectionTextPadding" style="min-height: 420px; display: none; background-color: #FFF;padding: 20px;">
				
				<div id="loadingImage12345"><img src="css/images/default.gif" /></div>
				<div id="tableStyle123" style="display:none">
					<div class="table-responsive">
					
					<table id="moduleLists1234" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								
								<th>Right Name</th>
								<th>Right Description</th>
								<th>Access Type</th>		
								<!-- <th>Check</th>	 -->					
							</tr>
						</thead>
						<tbody id="displayRights">
							<!-- <tr>
								<td>Date</td>
								<td>Date</td>
								<td>Date</td>
								<td><input type="checkbox" /></td>
							</tr> -->
						</tbody>
		        	</table>
					</div>
					
				</div>			
			</div>


		
		</div>
		<!-- Roles Area -->
		
		</div>
		</div>
	</div>		
<!-- </form> -->



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
	
	setHeader('roleCreation.jsp');
	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(i == 1)
		array_of_li[i].setAttribute("class", "active");	
		
	}
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
	//  $('#adminWizardLi').click();
	  $("#adminWizardLi").collapse('toggle'); 
	
	
}







String.prototype.trim = function () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}
</script>

</body>
</html>

