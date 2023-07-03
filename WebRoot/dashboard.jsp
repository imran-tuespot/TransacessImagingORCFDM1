<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.*" %>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Javascript Libraries -->

		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" />
		
		<!-- <script src="js/jQuery/1.11.3/jquery.min.js"></script> -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
		 <link href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" />
         <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> 		
		<title>Dashboard</title>

   
   
   
 
<script language=javascript>


function hideLink(id)
{
	var link_ref = document.getElementById(id);
	link_ref.style.display = 'none';
}
$(document).mousemove(function(event){
	  InitializeTimer();
});
function initial() 
{
	 /* getHeaderusername(); */

setHeader('dashboard.jsp');

var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(i == 1){
		array_of_li[i].setAttribute("class", "active");
	}
			
		
	} 
		
$('.si-inner ul li').click(function() {
    var i = $(this).index();
    $('.si-inner ul li').css("background-color","FFF");
    
    $('.fullarticle').hide();
    $('#article' + (i+1)).show();
        $('.si-inner ul li:nth-child('+(i+1)+')').css("background-color","EBEBEB");
    
});

  //  $('#article1').show();
    
	
	
	
				
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
		url : "http://localhost:8699/TransAccessImagingWS/role/saveRole",
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
	$.ajax({
		   type : "GET",
		   contentType : "application/json",
		   url : "http://localhost:8699/TransAccessImagingWS/role/getRights",
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
		url : "http://localhost:8699/TransAccessImagingWS/role/getRoles",
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
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "http://localhost:8699/TransAccessImagingWS/role/getRights",
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
			url : "http://localhost:8699/TransAccessImagingWS/role/saveRights",
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
	      $('#rightsList').append('<tr><td>'+item.rightName+'</td><td>'+item.rightDescription+'</td><td>'+item.createdName+'</td><td>'+item.createdOn+'</td><td>'+item1.folderPattern+'</td><td><input onclick="something(1)" type="button" value="submit"></td></tr>');
		});
	});
}
function something(id){
	alert("hi:"+id);
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
	
	</style>	
	<script type="text/javascript">
	  function loadFunction(){
		  initial();
		   getCount();
		  getHeaderusername();
		 // getDashboardList();
		
	  }
	  
	
	</script>
</head>

<%-- <jsp:include page="includes/sessionHeader.jsp" /> --%>

<body onLoad="	">
<div id="main">

<div class="panel-group" id="accordion1" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading-small" role="tab" id="headingUserOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion1" href="#collapseUserOne" aria-expanded="true" aria-controls="collapseUserOne" class="">
				         User Management <i class="zmdi_large zmdi-chevron-down" style="float:right;"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseUserOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingUserOne" aria-expanded="true" style="">
				      <div class="panel-body">
				     <!--  href="supervisorGrid.html" -->
				    <!--  newusercreation.html -->
				    
							<a  href="supervisorGrid.jsp">User Management &amp; Access Control</a><blockquote style="border-left: 0;font-size: 13px;"> - Manage users and their data visibility </blockquote><br>
							<a href="registration.jsp">User Creation </a><blockquote style="border-left: 0;font-size: 13px;"> - Allows creation of new users </blockquote><br>
							
				      </div>
				      
				      
				    </div>
				  </div>
				

</body>


</html>
