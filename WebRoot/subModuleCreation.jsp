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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
		 <link href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" />
        <title>Sub Modules</title>
       <!--  Kiran -->
       
     <!-- <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script> -->
       <!--  <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
    <script src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
        type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables.css">
   <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables_themeroller.css">
   <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
   <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/jquery.dataTables.min.js"></script> -->
        <!--  Kiran -->
         <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> 		
		<title>Dashboard</title>
<% String appuserrole = (String)request.getSession().getAttribute("appuserrole");
   System.out.println("appuserrole "+appuserrole);
  Integer companyId = (Integer)request.getSession().getAttribute("comid");
  int uid = Integer.parseInt(request.getSession().getAttribute("userid").toString());
  javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
   
  // String contextLoginId = (String)session.getAttribute("contextLoginId");
%>
		
	<script type="text/javascript">
function subModuleLoad(){
	 //alert("108");
  initial_load();
  getSubModules123();
}

<!-- </script>	
		
<!-- get roles and rights -->		
<script language=javascript>



function goBackRole() {	
	$("#addRoleForm").hide();
	$("#backBtn").hide();	
	$("#addRoleList").show();
	$("#addRoleBtn").show();
	getRoles();
}


function goBack() {
	
	location.reload();
	$("#addRightForm").hide();
	$("#backBtn1").hide();
	$("#addRightList").show();
	$("#addRightBtn").show();
	$("#moduleListsData").dataTable();
	
}


function addRightForm() {
	var arrayOfRights=[];
	$("#addRightList").hide();
	$("#addRightBtn").hide();
	$("#addRightForm").show();
	$("#loadingImage123").hide();
	$("#backBtn1").show();	
	$("#successmsg").hide();
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
		       $("#lstFruits345").append("<option value='"+data.moduleDetails[i].moduleId+"'><b>"+data.moduleDetails[i].moduleName+"</b></option>");
		       
		      } 
		    		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayModules(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	
}


   
function getSubModules123(){

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
		url : "<%=restURL%>/role/getSubModules?companyId="+companyIdValue,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#loadingImage").hide();
			$("#tableStyle1").show();
			displaySubModules(data);
			$("#moduleListsData").dataTable();
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayModules(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	
}

function displaySubModules(data) {
	$.each(data.subModuleDetails, function(i, item) {/* hello(\''+item+'\') */
	      $('#moduleList').append('<tr><td id="123">'+item.subModuleName+'</td><td>'+item.moduleName+'</td><td>'+item.createdBy+'</td><td>'+item.createdOn+'</td><td><a id="editB" onclick="hello(\''+item.subModuleId+'\',\''+item.subModuleName+'\',\''+item.moduleId+'\')"><i class="zmdi_medium zmdi zmdi-edit"></i></a></td></tr>');
	});
	 
}

function hello(i,n,j){
	 document.getElementById("editSubModuleId").value = i;
	 document.getElementById("editSubModuleName").value = n; 
	 document.getElementById("lstFruits34").value=j;
	 $("#loadingImage1234").hide();
	 $("#editSuccessMsg").hide();
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
				document.getElementById("lstFruits34").value=j;
			},
			error : function(e) {
				console.log("ERROR: ", e);
				displayModules(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	 $("#myModal").modal("show");	 
 } 
 
 function UpdateSubModule(){
	 $("#loadingImage1234").show();
	 $("#editSuccessMsg").hide();
	 var companyIdValue= '<%= companyId %>';
	 var userIdvalue='<%=uid%>';
	 document.getElementById("submitbtndisa1").disabled = true;
	 var editSUbModuleId= $("#editSubModuleId").val();
	 var editSubModuleName= $("#editSubModuleName").val();
	 var x=document.getElementById("lstFruits34");
	 for (var i = 0; i < x.options.length; i++) {
         if(x.options[i].selected ==true){
            var moduleId=x.options[i].value;
          }
     }
	
	 
	 if(editSubModuleName != ""){
	 var testData={
			 "subModuleName":editSubModuleName,
			 "subModuleId":editSUbModuleId,
			 "moduleId":moduleId,
			 "modifiedBy":userIdvalue
	 }
	 $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/role/updateSubModule",
			dataType : 'json',
			timeout : 100000,
			data : JSON.stringify(testData),
			success : function(data) {
				 $("#loadingImage1234").hide();
				 $("#editSuccessMsg").show();
				console.log("SUCCESS: ", data);
				document.getElementById("submitbtndisa1").disabled = false;
				location.reload();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				document.getElementById("submitbtndisa1").disabled = false;
		     	
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	 }else{
		 alert("Please Enter the Module Name");
		 $("#loadingImage1234").hide();
			document.getElementById("submitbtndisa1").disabled = false;
	 }
 }
function saveSubModules(){
	 var companyIdValue= '<%= companyId %>';
	 var userIdvalue='<%=uid%>';
     document.getElementById("submitbtndisa").disabled = true;
	 $("#loadingImage123").show();
	 $("#successmsg").hide(); 
	 var subModuleName = $("#subModuleName").val();
	 var x=document.getElementById("lstFruits345");
	 for (var i = 0; i < x.options.length; i++) {
         if(x.options[i].selected ==true){
            var moduleId=x.options[i].value;
          }
    }
	 var isAvailble=true;
	 var message="Please Enter the Values for  parameters::";
	 
	 if(subModuleName == ""){
		
		 isAvailble=false;
		 message += "Sub Module Name ,";
		 
	 }
	 if(moduleId=="Select Module Name"){
		 
		 isAvailble=false;
		 message += "Module Name "; 
	 }
	
	if(isAvailble == true){
	var testData={
			 "subModuleName":subModuleName,
			 "companyId":companyIdValue,
			 "createdBy":userIdvalue,
			 "moduleId":moduleId
		};
	
	  $.ajax({
		type : "POST",
		contentType : "application/json",
		url : "<%=restURL%>/role/saveSubModule",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(testData),
		success : function(data) {
			
			 $("#loadingImage123").hide();
			console.log("SUCCESS: ", data);
			document.getElementById("submitbtndisa").disabled = false;
			$("#successmsg").show(); 
			
		},
		error : function(e) {
			
			console.log("ERROR: ", e);
			document.getElementById("submitbtndisa").disabled = false;
	     	
		},
		done : function(e) {
			console.log("DONE");
		}
	}); 	
	}else{
		alert(message);
		 $("#loadingImage123").hide();
		 document.getElementById("submitbtndisa").disabled = false;
	}
}

</script>


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


<body onLoad="subModuleLoad()" >

<!-- <form name="upload" method="post" > -->

<div class="buttonAction">
			<button class="btn btn-success pull-right btn-orange" id="addRightBtn" onclick="addRightForm()">
			<div class="d-table">
				<div class="d-tbcell v-middle"><i class="zmdi_medium zmdi-plus-circle-o"></i></div>
				<div class="p-left10 d-tbcell v-middle">Add  Sub Module</div>
			</div>
			</button>
			<button id="backBtn1"  class="btn btn-success pull-right btn-orange width120" onclick="goBack()" style="display: none;">
				<div class="d-table">
				<div class="d-tbcell v-middle"><i class="zmdi_medium zmdi zmdi-caret-left-circle"></i></div>
				<div class="p-left10 d-tbcell v-middle">Back</div>
			</div>
			</button>
				        
		</div>

  <div align="center" style="margin:10px;">
  
 	<div>
		<div>
		
		<!-- Rights Area -->

	
		<div class="" style="min-height:460px;">		
			<div id="addRightList" class="smallSectionTextPadding" style="min-height: 420px; background-color: #FFF;padding: 20px;">
			
			<!-- <div id="loadingImage"><img src="css/images/default.gif" /></div>
			<div id="tableStyle1" style="display:none"> -->
			<div id="loadingImage" style="position :absolute;top:30%;left:0px;right:0px;margin:auto;text-align:center"><img src="css/images/default.gif" /></div>
			<div id="tableStyle1" style="display: none;">
			<div class="table-responsive">
			<table id="moduleListsData" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
					    <th>Sub Module Name</th>
						<th>Module Name</th>
						<th>Created By</th>
						<th>Created On</th>	
						<th>Action</th>							
					</tr>
				</thead>
				<tbody id="moduleList">
					
				</tbody>
        	</table>
			</div>
			
			</div>
		</div>
		
		
		<div id="addRightForm" class="smallSectionTextPadding" style="min-height: 420px; display: none; height: 420px;background-color: #FFF;padding: 20px;">
				<div id="loadingImage12" style="position :absolute;top:30%;left:0px;right:0px;margin:auto;text-align:center"><img src="css/images/default.gif" /></div>
			<div id="loadingImage123" style="position :absolute;top:30%;left:0px;right:0px;margin:auto;text-align:center"><img src="css/images/default.gif" /></div>
			<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center" >
				     <div style="text-align:center;" id="successmsg">
				     	<h4 style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;"><i class="zmdi_medium zmdi-check"></i>
				     		<span style="padding-left: 8px;">Sub Module added successfully</span>
				     	</h4>
				     </div>
				</div>
			
				<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12" style="margin-top:80px;">
				
					 
					 <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                   <label style="font-size:15px;margin-top:10px;">Sub Module Name</label>
                             </div>			
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                                   <input id="subModuleName" name="subModuleName"  class="form-control input-lg text-center" placeholder="Enter Sub Module Name" type="text" onfocus="javascript:addClass();" onblur="" required>
                             </div>
                             </div>
                             
						<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12" style="margin-top:10px;">
						
					          <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                   <label style="font-size:15px;margin-top:10px;">Module Name</label>
                             </div>	
                             <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
					         <select id="lstFruits345"  class="selectStyle lineheight37" placeholder="Module Name" style="margin-bottom: 15px;height: 50px;color: black;margin-top:0px !important;" >
					         	<option>Select Module Name</option> 
					         </select>
					         </div>
                        
						
						
				</div>
				<div class="col-lg-offset-2 col-lg-8 col-md-off-set-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12" style="margin-top:10px;">
				<div class="rowSetting text-center" style="padding-top: 40px;">	
							<button type="submit" id="submitbtndisa"   class="btn btn-success text-left btn-orange width120" onclick="saveSubModules()">Submit</button>
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
                <div class="modal-header" style="background-color:#7098CC">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel" style="color:white">Edit Module Details</h4>
                </div>
                <div class="modal-body">
                    	<div id="loadingImage1234" style="position :absolute;top:30%;left:0px;right:0px;margin:auto;text-align:center"><img src="css/images/default.gif" /></div>
                        <div style="text-align:center;" id="editSuccessMsg">
				     	<h4 style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;"><i class="zmdi_medium zmdi-check"></i>
				     		<span style="padding-left: 8px;">Sub Module Edited successfully</span>
				     	</h4>
				     </div>
                    <div>
					 <div class="rowSetting">			
							<div class="fg-line col-lg-12" style="padding:0px;">
								<div class="col-lg-4" style="margin-top:12px;">
                                <label>Sub Module Name</label>
                             </div>
                              <div class="col-lg-8">
                                   <input id="editSubModuleName" name="subModuleName"  class="form-control input-lg" style="background-color:#FDFDFE" placeholder="Module Name" type="text" onfocus="javascript:addClass();" onblur="">
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
                                   <input type="hidden" id="editSubModuleId" name="editModuleId"  class="form-control input-lg text-center" style="margin-top: 60px;" placeholder="Enter Module ID" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
						</div>
						<div class="rowSetting text-center" style="padding-top: 40px;">	
							<button type="submit" id="submitbtndisa1"   class="btn btn-success text-left btn-orange width120" onclick="UpdateSubModule()">Submit</button>
						</div>
						</div>
                </div>
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
	
	setHeader('subModuleCreation.jsp');
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

