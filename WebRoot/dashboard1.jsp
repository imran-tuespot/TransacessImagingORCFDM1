<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.*" %>
<%
	 javax.naming.Context ctx = 	new javax.naming.InitialContext();
		String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
		System.out.println("restURL"+restURL);
	
	%>
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
<% 


 /* String sessionid =null;
try{
   // sessionid = request.getServletContext().getAttribute("sessionid").toString();
	sessionid = (String)request.getSession().getAttribute("username");
	  
}catch (NullPointerException npe) {
    	sessionid = "NULLPOINTEREXCEPTION";
 	}

if (sessionid == "NULLPOINTEREXCEPTION" || sessionid == null) {
	System.out.println("*******");
	 response.sendRedirect(request.getContextPath()+"/index.jsp");
 
}  */
String appuserrole = (String)request.getSession().getAttribute("appuserrole");
   System.out.println("appuserrole "+appuserrole);
   Properties prop = null; 
   InputStream is = null; 
   
   try
   {     
       try { 
           prop = new Properties(); 
           is = this.getClass().getResourceAsStream("/appProperties.properties"); prop.load(is); 
           } catch (FileNotFoundException e) { 
               e.printStackTrace(); 
               } catch (IOException e) {
                   e.printStackTrace(); 
                   }
       String LogFileName = prop.getProperty("userManagement");
       System.out.println(LogFileName);

   }
   catch (Exception e)
   {
       System.out.println(e.getMessage());
   }
   
   Set<String> rights = (Set<String>)request.getSession().getAttribute("rightNames");
  // System.out.println("rights "+rights.size()+rights);
   
   
   Map<String,String> moduleData=(Map<String,String>)request.getSession().getAttribute("modules");
   System.out.println("modules "+moduleData.size()+moduleData);
  // Set<String> modules =null;
   
   Set<String> modules = new HashSet<String>();
   
   System.out.println("modules "+modules.size()+modules);
   
   for (String setdata : moduleData.keySet()) {
	   modules.add(setdata);
	}
   
   
   for (String set : moduleData.values()) {
	   modules.add(set);
	}
   
   System.out.println("modules "+modules.size()+modules);
   
	request.getSession().setAttribute("modulesSet",modules);
	
	Set<String> accessType = (Set<String>)request.getSession().getAttribute("accessPatterenDetails");
	  System.out.println("accessType "+accessType.size()+accessType);

   
   
   
 //  Set<String> modules = (Set<String>)request.getSession().getAttribute("modules");
 //  System.out.println("modules "+modules.size()+modules);
 
 
   
  // String contextLoginId = (String)session.getAttribute("contextLoginId");
%>
<script language=javascript>
function quicksightopentab(id)
{
	
	 $.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/role/getQSDashboardurl?dashId="+id,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("data: ", data.getQSDashboardList);
				
				window.open(data.getQSDashboardList, "MsgWindow", "scrollbars=1,menubar=0,resizable=1,width=800,height=600");
			  // alert(data.getQSDashboardList)
			},
			error : function(e) {
				console.log("ERROR: ", e);
				
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	
	
}
/* function getDashboardList(){
	   $.ajax({
			type : "GET",
			contentType : "application/json",
			url : "http://localhost:8699/TransAccessImagingWS/role/getQSDashboardList",
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
			   alert("684:::"+JSON.stringify(data.getQSDashboardList[0]))	;
			  for(i=0;i<data.getQSDashboardList.length;i++){
			       $("#dashboardList").append(" <div >  <a onclick=quicksightopentab('"+data.getQSDashboardList[i].awsDashboardId+"')>"+data.getQSDashboardList[i].dashboardName+"</a><blockquote> - "+data.getQSDashboardList[i].dashboardDesc+"</blockquote><br>	</div>");
				   //dashboardList
			      } 
			},
			error : function(e) {
				console.log("ERROR: ", e);
				
			},
			done : function(e) {
				console.log("DONE");
			}
		});
}
getDashboardList(); */
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
	if(i == 1)
		array_of_li[i].setAttribute("class", "active");	
		
	}
		
$('.si-inner ul li').click(function() {
    var i = $(this).index();
    $('.si-inner ul li').css("background-color","FFF");
    
    $('.fullarticle').hide();
    $('#article' + (i+1)).show();
        $('.si-inner ul li:nth-child('+(i+1)+')').css("background-color","EBEBEB");
    
});

  //  $('#article1').show();
    
	var role = "POWERUSER";
	if ( role === "<%= appuserrole %>") 
	{
		hideLink('id_link');
	}
	
	
	//$('#profile-menu').hide();
	
	
	
	 <%
	 
		if(modules.contains(prop.getProperty("administrativeFunctions")) && appuserrole.compareTo("Production Manager") != 0 ){
		%>
		
	
	 <%
	if(modules.contains(prop.getProperty("userManagement"))){
	%>
	
	$('#UserManagement').show();
	$('#article2').show();
	
			
	<%}else{%>
	
	$('#UserManagement').hide();
	<%}%>
	
	<%
	if(modules.contains(prop.getProperty("documentManagement"))  || modules.contains(prop.getProperty("addDocument")) || modules.contains(prop.getProperty("addMultipleDocument")) || modules.contains(prop.getProperty("searchDocuments")) || modules.contains(prop.getProperty("downloadDocumentSelector"))){
	%>
	$('#DocumentManagement').show();
	$('#article4').show();
	
    <%if(modules.contains(prop.getProperty("addDocument")) && (accessType!=null && accessType.contains("ReadWrite"))){ %>
	$('#upload').show();
	
	<%}else{%>
	$('#upload').hide();
	<%}%>
	
	<%if(modules.contains(prop.getProperty("addMultipleDocument")) && (accessType!=null && accessType.contains("ReadWrite"))){ %>
	$('#multipleupload').show();
	
	<%}else{%>
	$('#multipleupload').hide();
	<%}%>
	

	<%if(modules.contains(prop.getProperty("searchDocuments"))){ %>
	$('#manageDocument').show();
	
	<%}else{%>
	$('#manageDocument').hide();
	<%}%>
	<%if(modules.contains(prop.getProperty("downloadDocumentSelector"))){ %>
	$('#download').show();
	
	<%}else{%>
	$('#download').hide();
	<%}%>
		
	<%}else{%>
	
	$('#DocumentManagement').hide();
	$('#article4').hide();
	
	<%}%>
	
	
	<%
	if(modules.contains(prop.getProperty("reports"))){
	%>
	
	$('#ReportsData').show();
	$('#article5').show();
	
	
	<%}else{%>
	
	$('#ReportsData').hide();
	<%}%>
	
	<%
	if(modules.contains(prop.getProperty("retentionschedule"))){
	%>

	$('#RetentionSchedule').show();
	$('#article6').show();
	
   <%}else{%>
	
	$('#RetentionSchedule').hide();
	$('#article6').hide();
	
	<%}%>
	
	<%
	if(modules.contains(prop.getProperty("companyProfile"))){
	%>
	
	$('#CompanyProfile').show();
	$('#article3').show();
	
	<%}else{%>
	
	$('#CompanyProfile').hide();
	<%}%>
	
	<%-- <%
	if(modules.contains(prop.getProperty("propertyManagement"))){
	%>
	
	$('#CompanyProfile').show();
	$('#article1').show();
	
	<%}else{%>
	
	$('#CompanyProfile').hide();
	<%}%>
	 --%>

	
		$('#AdministratorWizard').show();
		$('#profile-menu').show();
		$('#article1').show();
		$('#article2').hide();
		$('#article3').hide();
		$('#article4').hide();
		$('#article5').hide();
		$('#article6').hide();
		$('#article7').hide();
		$('#article8').hide();
		
			
		 <%}else{%>
			
		 <%
			if(modules.contains(prop.getProperty("userManagement"))){
			%>
			
			$('#UserManagement').show();
			$('#article2').show();
			
					
			<%}else{%>
			
			$('#UserManagement').hide();
			<%}%>
			
			<%
			if(modules.contains(prop.getProperty("documentManagement"))  || modules.contains(prop.getProperty("addDocument")) || modules.contains(prop.getProperty("addMultipleDocument")) || modules.contains(prop.getProperty("searchDocuments")) || modules.contains(prop.getProperty("downloadDocumentSelector"))){
			%>
			$('#DocumentManagement').show();
			$('#article4').show();
			
		    <%if(modules.contains(prop.getProperty("addDocument")) && (accessType!=null && accessType.contains("ReadWrite"))){ %>
			$('#upload').show();
			
			<%}else{%>
			$('#upload').hide();
			<%}%>
			
			<%if(modules.contains(prop.getProperty("addMultipleDocument")) && (accessType!=null && accessType.contains("ReadWrite"))){ %>
			$('#multipleupload').show();
			
			<%}else{%>
			$('#multipleupload').hide();
			<%}%>
			

			<%if(modules.contains(prop.getProperty("searchDocuments"))){ %>
			$('#manageDocument').show();
			
			<%}else{%>
			$('#manageDocument').hide();
			<%}%>
			<%if(modules.contains(prop.getProperty("downloadDocumentSelector"))){ %>
			$('#download').show();
			
			<%}else{%>
			$('#download').hide();
			<%}%>
				
			<%}else{%>
			
			$('#DocumentManagement').hide();
			$('#article4').hide();
			
			<%}%>
			
			<%
			if(modules.contains(prop.getProperty("retentionschedule"))){
			%>

			$('#RetentionSchedule').show();
			$('#article6').show();
			
		   <%}else{%>
			
			$('#RetentionSchedule').hide();
			$('#article6').hide();
			
			<%}%>
			<%
			if(modules.contains(prop.getProperty("reports"))){
			%>
			
			$('#ReportsData').show();
			$('#article5').show();
			
			
			<%}else{%>
			
			$('#ReportsData').hide();
		
			<%}%>
			
			
			
			<%
			if(modules.contains(prop.getProperty("companyProfile"))){
			%>
			
			$('#CompanyProfile').show();
			
			
			<%}else{%>
			
			$('#CompanyProfile').hide();
			
			<%}%>
			
			$('#AdministratorWizard').hide(); 
			$('#profile-menu').hide();
			$('#article1').hide();
			
		//	$('#article2').show();
			
			 <%
				if(modules.contains(prop.getProperty("documentManagement"))){
				%>
				$('#article2').hide();
				$('#article4').show();
				 <%}%>
				 
				 <%
					if(modules.contains(prop.getProperty("userManagement"))){
					%>
					$('#article2').show();
					$('#article4').hide();
					 <%}%>
		
			//$('#article4').hide();
		
			$('#article3').hide();
			$('#article5').hide();
			$('#article6').hide();
			$('#article7').hide();
			$('#article8').hide();
			
		 <%}%>
		
	
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
		  getDashboardList();
	  }
	  
	  function getDashboardList(){
		   $.ajax({
				type : "GET",
				contentType : "application/json",
				url : "<%=restURL%>/role/getQSDashboardList",
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
				  // alert("684:::"+JSON.stringify(data.getQSDashboardList[0]))	;
				  for(i=0;i<data.getQSDashboardList.length;i++){
				       $("#dashboardList").append(" <div > <a  onmouseover='' style='cursor:pointer;' onclick=quicksightopentab('"+data.getQSDashboardList[i].awsDashboardId+"')>"+data.getQSDashboardList[i].dashboardName+"</a><blockquote> - "+data.getQSDashboardList[i].dashboardDesc+"</blockquote><br>	</div>");
					   //dashboardList
				      } 
				},
				error : function(e) {
					console.log("ERROR: ", e);
					
				},
				done : function(e) {
					console.log("DONE");
				}
			});
	   }
	</script>
</head>

<jsp:include page="includes/sessionHeader.jsp" />

<body onLoad="loadFunction()">
<div id="main">
<aside id="sidebar" style="float:left">
                <div class="sidebar-inner">
                    <div class="si-inner">
                        <div class="profile-menu" id="profile-menu">
                          	<div class="userSection">
                                
								<div class="btn-group">					
										<div class="btn btn-primary waves-effect waves-button waves-float"  style="cursor:auto" title="Administrator Wizard">Administrator Wizard</div>										
								 </div>
                           </div>
                        </div>
                		
                        <ul class="main-menu">
                        <li id="AdministratorWizard"><a style="text-align: left;"><i class="zmdi zmdi-view-dashboard"></i>Administrator Wizard</a></li> 
                        <li id="UserManagement"><a style="text-align: left;"><i class="zmdi zmdi-accounts"></i> User Management</a></li>   
                        <li id="CompanyProfile"><a style="text-align: left;"><i class="zmdi zmdi-balance"></i>Company Profile</a></li>
                        <li id="DocumentManagement"><a style="text-align: left;"><i class="zmdi zmdi-collection-text"></i> Document Management</a></li>                      
                      <!--  old Reports -->
                       <!--  <li id="ReportsData"> <a style="text-align: left;"><i class="zmdi zmdi-chart"></i>Reports</a></li> -->
                       <!--  QuickSight Reports -->
                          <li id="ReportsData"> <a   style="text-align: left;"><i class="zmdi zmdi-chart"></i> Reports</a></li>
                        <li id="RetentionSchedule"> <a style="text-align: left;"><i class="zmdi zmdi-collection-text"></i>Archive</a></li>
                       <!--  <li id="RetentionSchedule"> <a style="text-align: left;"><i class="zmdi zmdi-collection-text"></i>Archive</a></li> -->
                        
                      <!--   <li><a style="text-align: left;" onclick="getRoles()"><i class="zmdi zmdi-accounts-outline"></i>Roles</a></li> -->
           <!--              <li><a style="text-align: left; onclick="getRoles()"><i  class="zmdi zmdi-accounts-outline"></i>Roles</a></li> -->
                      <!--   <li><a style="text-align: left;" onclick="getRights()"><i class="zmdi zmdi-accounts-add"></i>Rights</a></li>     -->
                     
                    </ul>
                    </div>
                </div>
            </aside>
<div id="content" style="overflow: auto;">
<div class="card" style="width: 588px;float:right; margin: 0px 20px 0px 0px; padding-left: 0px;">
	<div class="card-body card-padding" style="padding: 28px 0px 10px 0px;background-color:#EBEBEB"> 
	
	<div class="fullarticle" id="article1" >
		<div class="smallWhiteHeader"><i class="zmdi_large zmdi-view-dashboard" style="color:#F90;"></i> Administrator Wizard</div>
	
		<div class="smallSectionText" style="min-height:460px;">		
			<div class="smallSectionTextPadding" style="margin:20px;min-height: 420px; background-color: #FFF;padding: 20px;">
			
			<div class="panel-group" id="accordion6" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading-small" role="tab" id="headingAdminOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse"  href="#collapseAdminOne" aria-expanded="true" aria-controls="collapseAdminOne">
				         Property Management <i class="zmdi_large zmdi-chevron-down" style="float:right;"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseAdminOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingAdminOne">
				      <div class="panel-body">
				 		<!-- 	<a href="addProperty.jsp?sessionid=<%//=request.getAttribute("sessionid") %>">Manage Property</a><blockquote> - Add property</blockquote><blockquote> - Edit property</blockquote><blockquote> - Remove property</blockquote>-->
				 			

<!-- 							 <a href="PropertyList?type=worksheet">Manage Property and Loan ()</a><blockquote> Presents a wizard to manage list of required properties.</blockquote><blockquote> - Add property</blockquote><blockquote> - Edit property</blockquote><blockquote> - Remove property</blockquote>
 -->				 	 <a href="propertyRequest.jsp">Manage Property and Loan(s)</a><blockquote> Provides a place to manage Properties and Loans</blockquote><blockquote> - Add Property and Loan information</blockquote><blockquote> - Edit Property and Loan information</blockquote><blockquote> - Remove Property and Loan information</blockquote>
 						 			
				      </div>
				      
				    </div>
				  </div>
				  
				  <div class="panel panel-default">
				    <div class="panel-heading-small" role="tab" id="headingAdminSecond">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse"  href="#collapseAdminSecond" aria-expanded="true" aria-controls="collapseAdminSecond">
				         Metadata Management <i class="zmdi_large zmdi-chevron-down" style="float:right;"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseAdminSecond" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingAdminSecond">
				      <div class="panel-body">
<!-- 				            <a href="propertyRequest.jsp">Property</a><blockquote> - Presents a wizard to  add list of Property </blockquote>
 --> 						    <a href="moduleCreation.jsp">Modules</a><blockquote> - Provides a place to  add  Modules </blockquote>
 						    <a href="subModuleCreation.jsp">Sub Modules</a><blockquote> - Provides a place to  add  Sub Modules </blockquote>
 						    <a href="roleCreation.jsp">Roles</a><blockquote> - Provides a place to  add  Roles </blockquote>
                            <a href="rightsCreation.jsp">Rights</a><blockquote> - Provides a place to add  Rights </blockquote>
 							<a id="id_link" href="newIndexType.jsp">Index Type</a><blockquote>- Provides a place to add  Index Types </blockquote>
 							<a href="newDocType.jsp">Document Type</a> <blockquote>- Provides a place to add  Document Types</blockquote>
 							<a href="newFolder.jsp">Folders</a><blockquote> - Provides a place to add Folders	</blockquote>
 							<!-- <a href="retensionSchedule.jsp">Retention Schedule</a><blockquote> - Presents a wizard to about Retention schedule</blockquote> -->
 							<a href="inactiveFHANumbers.jsp">Inactive Loans</a><blockquote> - Provides a place to change Loan Status	</blockquote>
 							
				 	 </div>
				    </div>
				  </div>					  
			</div>
						 		
			</div>
		</div>
	</div>
	
    <div class="fullarticle" id="article2">
		<div class="smallWhiteHeader"><i class="zmdi_large zmdi-accounts" style="color:#F90;"></i> User Management</div>
	
		<div class="smallSectionText" style="min-height:460px;">		
			<div class="smallSectionTextPadding" style="margin:20px;min-height: 420px; background-color: #FFF;padding: 20px;">
			<div class="panel-group" id="accordion1" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading-small" role="tab" id="headingUserOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion1" href="#collapseUserOne" aria-expanded="true" aria-controls="collapseUserOne">
				         User Management <i class="zmdi_large zmdi-chevron-down" style="float:right;"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseUserOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingUserOne">
				      <div class="panel-body">
							<a href="supervisorGrid.jsp">User Management & Access Control</a><blockquote> - Manage users and their data visibility </blockquote><br>
							<a href="registration.jsp">User Creation </a><blockquote> - Allows creation of new users </blockquote><br>
							
				      </div>
				      
				      
				    </div>
				  </div>			  
				</div>
			</div>
		</div>
	</div>
	
	<div class="fullarticle" id="article3">
		<div class="smallWhiteHeader"><i class="zmdi_large zmdi-balance" style="color:#F90;"></i> Company Profile</div>
	
		<div class="smallSectionText" style="min-height:460px;">		
			<div class="smallSectionTextPadding" style="margin:20px;min-height: 420px; background-color: #FFF;padding: 20px;">
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading-small" role="tab" id="headingComOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseComOne" aria-expanded="true" aria-controls="collapseComOne">
				         Company Profile <i class="zmdi_large zmdi-chevron-down" style="float:right;"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseComOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingComOne">
				      <div class="panel-body">
						<a href="companyProfile.jsp">Company Profile</a><blockquote> - Manage configuration settings pertaining to the company's preferences and best-practices	<blockquote><br>			
				      </div>
				    </div>
				  </div>
			</div>
		</div>
		</div>
	</div>
	
	
	<div class="fullarticle" id="article4">
		<div class="smallWhiteHeader"><i class="zmdi_large zmdi-collection-text" style="color:#F90;"></i> Document Management</div>
	
		<div class="smallSectionText" style="min-height:460px;">
		
			<div class="smallSectionTextPadding" style="margin:20px;min-height: 420px; background-color: #FFF;padding: 20px;">
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading-small" role="tab" id="headingDocOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseDocOne" aria-expanded="true" aria-controls="collapseDocOne">
				         Manage Your Documents <i class="zmdi_large zmdi-chevron-down" style="float:right;"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseDocOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingDocOne">
				      <div class="panel-body">
				     
					<!-- 	<div id="upload">	<a href="addDoc.jsp">Add New Document</a><blockquote> - Allows the creation of a new documents</blockquote><br></div> -->
					 <div id="multipleupload">  <a href="addDocuments.jsp">Add New Production Document (s)</a><blockquote> - Allows bulk uploading</blockquote><br>	</div>				
						
					<div id="multipleupload">  <a href="addTransactionDocuments.jsp">Add New Asset Management Document (s)</a><blockquote> - Allows bulk uploading of Asset Management files</blockquote><br>	</div>			
						
						<div id="manageDocument"><a href="indexPage.jsp">Manage Document (s)</a><blockquote>- Search documents </blockquote>
																																		 <blockquote>- Manages information pertaining to existing documents</blockquote>																																		 
																																		 <blockquote>- Activate/Deactivate documents </blockquote>
																																		 <blockquote>- Replace existing documents</blockquote> <br></div>
						<div id="download">	<a href="docDownloadSearchGrid.jsp">Download Document Selector</a> <blockquote>- Allows the download of a selected set of documents</blockquote><br></div>
							
				      </div>
				    </div>
				  </div>  
			</div>
		
			</div>
		</div>
	</div>
	
	
	
	<div class="fullarticle" id="article7">
		<div class="smallWhiteHeader"><i class="zmdi_large zmdi-chart" style="color:#F90;"></i>Reports</div>
	
		<div class="smallSectionText" style="min-height:460px;">
		
			<div class="smallSectionTextPadding" style="margin:20px;min-height: 420px; background-color: #FFF;padding: 20px;">
				<div class="panel-group" id="accordion4" role="tablist" aria-multiselectable="true">
				  	<div class="panel panel-default">
				    <div class="panel-heading-small" role="tab" id="headingAuditTwo">
				      <h4 class="panel-title">
				        <a class="" role="button" data-toggle="collapse"  href="#collapseAuditTwo" aria-expanded="true" aria-controls="collapseAuditTwo">
				         	Property Reports <i class="zmdi_large zmdi-chevron-down" style="float:right;"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseAuditTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingAuditTwo">
				      <div class="panel-body">
				           <a href="./PropertyReport?type=basicExport&maxRows=15">Active Properties</a><blockquote> - List of all active properties for this company</blockquote><br>
				          <a href="propertyDocExport.jsp">Documents associated with property</a><blockquote> - List of all documents for a property.</blockquote><br>
				           
				      </div>
				    </div>
				  </div>
				 
				  
				  <div class="panel panel-default">
				    <div class="panel-heading-small" role="tab" id="headingAuditThree">
				      <h4 class="panel-title">
				        <a  role="button" data-toggle="collapse"  href="#collapseAuditThree" aria-expanded="true" aria-controls="collapseAuditThree">
				          Audit Reports <i class="zmdi_large zmdi-chevron-down" style="float:right;"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseAuditThree" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingAuditThree">
				      <div class="panel-body">
				            <a href="UserAudit">Active Users</a><blockquote> - List of all active users on the platform</blockquote><br>
				            <a href="userAuditTrail.jsp">Document Report</a><blockquote>Presents an audit report illustrating</blockquote><blockquote> - document modifications</blockquote><blockquote> - document creation activity</blockquote><br>				            
				      
				      </div>
				    </div>
				  </div>				  				  			 
				</div>
		
	       </div>
		</div>
	</div>
	
	<div class="fullarticle" id="article6">
			<div class="smallWhiteHeader"><i class="zmdi_large zmdi-collection-text" style="color:#F90;"></i> Archive </div>
	
		<div class="smallSectionText" style="min-height:460px;">
		
			<div class="smallSectionTextPadding" style="margin:20px;min-height: 420px; background-color: #FFF;padding: 20px;">
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				 <div class="panel-heading-small" role="tab" id="headingUserOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion1" href="#collapseArchiveOne" aria-expanded="true" aria-controls="collapseUserOne">
				         Archive <i class="zmdi_large zmdi-chevron-down" style="float:right;"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseArchiveOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingDocOne">
				      <div class="panel-body">
				     
				       <div id="retentionSchedule">  <a href="retensionSchedule.jsp">Edit Archive</a><blockquote> - Allows you to edit an existing retention period for a loan</blockquote><br>	</div>				
						 <div id="purgedRecordsReport">  <a href="purgeRecord.jsp">Purged Records</a><blockquote> - Allows you to create a report to identify the loans that have been purged or are scheduled to be purged due to their Disposal Dates
</blockquote><br>	</div>				
						
	</div></div></div>						
	</div>
</div>
</div>
</div>

<div class="fullarticle" id="article5">
			<div class="smallWhiteHeader"><i class="zmdi_large zmdi-collection-text" style="color:#F90;"></i> Report </div>
	
		<div class="smallSectionText" style="min-height:460px;">
		
			<div class="smallSectionTextPadding" style="margin:20px;min-height: 420px; background-color: #FFF;padding: 20px;">
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				 <div class="panel-heading-small" role="tab" id="headingUserOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion11" href="collapseQuickSight" aria-expanded="true" aria-controls="collapseUserOne">
				         QuickSight Report <i class="zmdi_large zmdi-chevron-down" style="float:right;"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseQuickSight" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingDocOne">
				      <div class="panel-body" >
				      <div  id="dashboardList">
				     			
						
	</div></div></div>						
	</div>
</div>
</div>
</div>
</div>


	<!-- <div class="fullarticle" id="article7">
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
		
		
		<div id="addRightForm" class="smallSectionTextPadding" style="margin:20px;min-height: 420px; display: none; background-color: #FFF;padding: 20px;">
				<div id="loadingImage12" style="position :absolute;top:30%;left:0px;right:0px;margin:auto;text-align:center"><img src="css/images/default.gif" /></div>
			<div class="row">
			
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center" >
				     <div style="text-align:center;" id="successmsg1">
				     	<h4 style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;"><i class="zmdi_medium zmdi-check"></i>
				     		<span style="padding-left: 8px;">Right added successfully</span>
				     	</h4>
				     </div>
				</div>
			
				<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12">
				<div>
				
				
				
					 <div class="rowSetting">			
								
							<div class="fg-line">
                                   <input id="rightNameVal" name="rightName"  class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Rights Name" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
							
						</div>

						<div class="rowSetting" style="padding-top: 20px;">						
								
								<div class="fg-line">
                                    <input id="" name="" class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Company ID" type="text" >
                                </div>							
						</div>
						 <div class="rowSetting" style="padding-top: 20px;">      
                                  <div class="fg-line">
                                    <input id="rightDescriptionVal" name="rightDesc" class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Right Description" type="text" >
                                </div>       
                       </div>
						<div class="rowSetting">						
								<div class="">
									 <lable class="text-left labelText">AccessType</lable>
                                     <select id="rightAccessType" class="selectStyle" placeholder="AccessType">
                                        <option value="">Select</option>
						                <option value="ReadOnly">ReadOnly</option>
						                <option value="Create">Create</option>
						                <option value="WriteOnly">WriteOnly</option>
						                <option value="ReadWrite">ReadWrite</option>
                                     </select>
                                </div>	
						</div>
						<div class="rowSetting">						
								<div class="">
									<lable class="text-left labelText">Folder Pattern</lable>
									 <input id="folderIdVal" name="folderName" class="form-control input-lg" style="background-color:#FDFDFE" placeholder="FolderPatterns with , separated values" type="text" >
                                </div>	
						</div>
						<div class="rowSetting text-left" style="padding-top: 40px;">	
							<button type="submit" id="submitbtndisa"   class="btn btn-success text-left btn-orange width120" onclick="saveRights()">Submit</button>
						</div>
						</div>
				</div>
				
			</div></div>
			
		
		
		
	</div>	
	
	
	
	</div> -->
</div>

</div>
</div>


</body>

</html>
