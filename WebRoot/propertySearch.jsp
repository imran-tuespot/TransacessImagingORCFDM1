<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.lang.*"%>
<html lang="en">
  <head>
  <!--   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> -->
    
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->
<script src="js/bootstrap/3.3.5/jquery.min.js"></script>
    
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Property Search</title>
    <link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<!-- <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" /> -->
		<link rel="stylesheet" href="css/jquery.dataTables.min.css" />  
			<!-- 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
			<link rel="stylesheet"
	href="css/font-awesome.min.css">
		<!-- <script src="js/jQuery/1.11.3/jquery.min.js"></script> -->
		<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
		<script
	src="js/bootstrap/3.3.5/jquery.min.js"></script>
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
		 <!-- <link href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" /> -->
        <link
	href="css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" />
        <script src="js/jquery.popupoverlay.js"></script>
        
        <!--  <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> -->
        <script
	src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
         
        <!--   <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
        <link rel="stylesheet"
	href="css/jquery-ui.css">

  <!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<!--   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 -->   
 
 
 <script
	src="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"></script>
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/dataTables.buttons.min.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.flash.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.html5.min.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.print.min.js"></script> 
	
  <script src="js/jQuery/jquery-ui.js"></script>
 
 
       <script>
  $( function() {
    $( "#startDate" ).datepicker({
    	
         onSelect: function (selected) {
             var dt = new Date(selected);
             dt.setDate(dt.getDate() + 1);
             $("#endDate").datepicker("option", "minDate", dt);
         }
  } );
  } );
  $( function() {
	    $( "#endDate" ).datepicker({
	    
	        onSelect: function (selected) {
	            var dt = new Date(selected);
	            dt.setDate(dt.getDate() - 1);
	            $("#startDate").datepicker("option", "maxDate", dt);
	        }
	    });
	  } );
  </script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
    <% String appuserrole = (String)request.getSession().getAttribute("appuserrole");
   System.out.println("appuserrole "+appuserrole);
   int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
   String sessionid = request.getSession().getAttribute("sessionid").toString();
   int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
   String userName = request.getSession().getAttribute("username").toString();
   javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	String companyFullName=request.getSession().getAttribute("companyFullname").toString();
   %>
   
 
		
   <script type="text/javascript">
   $(document).ready(function(){
		var array_of_li =  document.querySelectorAll("ul.tab-nav li");
		for (var i = 0; i < array_of_li.length; i++) {
		if(i == 0)
			array_of_li[i].setAttribute("class", "active");	
			
		}
	   setHeader('propertySearch.jsp');
   showListOFFiles();
   getLoanTypes();
   
 
   });

   function getLoanTypes(){
	   var companyId=<%= cid %>;
	   $.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getLoanTypes?companyId="+companyId,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {  
			       for(i=0;i<data.response.length;i++){
			    	   $("#loanType").append("<option value='"+data.response[i].loanType+"'><b>"+data.response[i].loanType+"</b></option>");
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
   
   
	function showListOFFiles(){
		debugger;
		 $('#my_popup').popup('hide');
	 	$.ajax({
	 		  type : "GET",
	 		  contentType : "application/json",
	 		  url : "<%=restURL%>/orcf/getDocCount?companyId=<%=cid%>",
	 		  dataType : 'json',
	 		  timeout : 100000,
	 		  success : function(data) {
	 		  console.log("SUCCESS: ", JSON.stringify(data));
	 		  console.log("data.FILESCOUNT:"+data.FILESCOUNT);
	 		  debugger;
	 		  console.log("countOfLoanType:"+JSON.stringify(data.LoanTypePropertiesList));
	 		  	$("#filesCount").append("<b>"+data.FILESCOUNT+"</b> Files");
	 		 	$("#propertiesCount").append("<b>"+data.PROPERTYCOUNT+"</b> Properties");
	 			$("#loanCount").append("<b>"+data.LOANTYPECOUNT+"</b> loans");
	 			for(var i=0;i<data.LoanTypePropertiesList.length;i++){
	 				//$("#loanTypePropertyList").append("<b>"+data.LoanTypePropertiesList[i].countOFProperties+"</b>&nbsp;&nbsp;"+data.LoanTypePropertiesList[i].loanType+" properties<br>");
	 				//$("#loanTypePropertyList").append("<tr><td class='text-left'><b> &nbsp;&nbsp;&nbsp;&nbsp;"+data.LoanTypePropertiesList[i].countOFProperties+"</b></td><td class='text-left padding15'><a id='datagg' href='#' onclick=javascript:getPropertyList('"+data.LoanTypePropertiesList[i].loanType+"')>"+data.LoanTypePropertiesList[i].loanType+" properties<br></a></td></tr>");
	 				$("#loanTypePropertyList").append("<div style='display:inline-block;'><button class='btnPropty' id='"+data.LoanTypePropertiesList[i].loanType+"' onclick=javascript:getPropertyList('"+data.LoanTypePropertiesList[i].loanType+"')>&nbsp;&nbsp;&nbsp;&nbsp;<b>"+data.LoanTypePropertiesList[i].countOFProperties+"</b>&nbsp;&nbsp;&nbsp;&nbsp;"+data.LoanTypePropertiesList[i].loanType+" Properties </button></div>");
	 			}
	 			//$("#loanTypePropertyList").empty();
	 		
	 		  },
	 		  error : function(e) {
	 		   console.log("ERROR: ", e);
	 		  // alert("12313122error");
	 		   displayRights(e);
	 		  },
	 		  done : function(e) {
	 		   console.log("DONE");
	 		  }
	 		 });
		}

function clearFields(type){
	$("#propertyId").val('');
	$("#propertyNm").val('');
	$("#city").val('');
	$("#state").val('');
	$("#zip").val('');
	$("#fhaNum").val('');
	$("#roleNameVal").val('');
	$("#loanAmt").val('');
	$("#lenderNm").val('');
	$("#startDate").val('');
	$("#endDate").val('');
	$("#propertyStatus").val('');
	$("#loanType").val('');
}

function clearResults(){
	$("#tableStyle1").hide();
}

function getPropertyList(type){
	$("#loanTypePropertyList .btnPropty").on("click", function() {
		 $("#loanTypePropertyList .btnPropty").removeClass("active");
		$(this).addClass("active");
		
   });
	$('#my_popup').popup('show');	
	$('#basic').css("display","block");
 var datatype="";
 

 if(type.length > 1){
	 
	 datatype=type;
 }
 else{
	 
	 datatype=$("#loanType").val();
 }
	 var companyId = '<%=cid%>';
	 var userIdvalue='<%=uid%>';
	 var tbl = '';
	  var testData={
			         "propertyId":$("#propertyId").val(),
			  	     "propertyName":$("#propertyNm").val(),
			  	     "city":$("#city").val(),
			  	     "state":$("#state").val(),
			  	     "zip":$("#zip").val(),
			  	     "fhaNumber":$("#fhaNum").val(),
			  	     "loanType":$("#roleNameVal").val(),
			  	     "loanAmount":$("#loanAmt").val(),
			  	     "lenderName":$("#lenderNm").val(),
			  	     "startDate":$("#startDate").val(),
			  	     "endDate":$("#endDate").val(),
			  	      "propertyStatus":$("#propertyStatus").val(),
			  	     "loanTypeData":datatype,			  	     
			  	     "companyId":companyId
	     
	   };

	 $.ajax({	 
	  type : "POST",
	  contentType : "application/json",
		url : "<%=restURL%>/orcf/getPropertyList",
      dataType : 'json',
	  timeout : 100000,
	  data : JSON.stringify(testData),
	  success : function(data) {
		  $('#my_popup').popup('hide');
		  console.log("SUCCESS    : ", data.getPropertyList.length);
			$("#propertyList").empty();
			$("#tableStyle1").show();
			if ($.fn.DataTable.isDataTable("#searchResTable")) {
				  $('#searchResTable').DataTable().clear().destroy();
				}
			display(data);
			$("#searchResTable").dataTable({
				 dom: 'lBfrtip',
			        buttons: [
			            'excelHtml5',
			            'pdfHtml5'
			        ],
				  "order": [[ 6, "asc" ]],
		          "deferRender": true,
		          
		    
		    }); 
			  
		var tbl = $("#searchResTable").dataTable();
		$("#searchResTable_length").css('margin-left','156px');
// 		$('.buttons-excel').css('margin-left', '136px');
		$("#searchResTable_wrapper").css('padding','10px 0px');

			/* var tbl = $("#searchResTable").dataTable(
					 {
				        dom: 'Bfrtip',
				      buttons: [ {
						    extend: 'pdfHtml5',
						    text:'Export To PDF'
						 
				             },
				            {
							    extend: 'excelHtml5',
							    text:'Export To Excel'
							   
				            }]
					 }); */
	  },
	  error : function(e) {
	   console.log("ERROR: ", e); 
	  },
	  done : function(e) {
		  tbl.fnClearTable(this);
	  }
	 
	 });
	/*  }else{
		 alert("Provide:"+message);
 } */
	 $('#propertyList').empty();
	 
	 
	}
	
	
	
function display(data) {
	
	    $.each(data.getPropertyList, function(i, item) {
		   item.city=='null'|| null ?item.city='':item.city == null ? item.city='':item.city;
		   item.state=='null' || null ?item.state='':item.state == null ? item.state='':item.state;
		   item.zip =='null' || null ?item.zip='':item.zip ==null? item.zip='':item.zip;
		   item.propertyStatus == null  ?item.propertyStatus='':item.propertyStatus;
		   item.fhaNumber =='null' || null ?item.fhaNumber='':item.fhaNumber ==null? item.fhaNumber='':item.fhaNumber;
		   item.loanType =='null' || null ?item.loanType='':item.loanType ==null? item.loanType='':item.loanType;
		   item.closingDate === null  ?item.closingDate='':item.closingDate;
		$('#propertyList').append('<tr><td><a id="editB" href="#/" onclick="hello(\''+item.id+'\',\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');" href="#myModal">'+item.propertyName+'</a></td><td><a id="editB" href="#/" onclick="hello(\''+item.id+'\',\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');">'+item.propertyId+'</a></td><td><a id="editB" href="#/" onclick="hello12(\''+item.id+'\',\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\',\''+item.loanAmount+'\',\''+item.lenderName+'\',\''+item.closingDate+'\',\''+item.propertyStatus+'\');">'+item.fhaNumber+'</a></td><td>'+item.city+'</td><td>'+item.state+'</td><td>'+item.zip+'</td><td>'+item.loanType+'</td><td>'+item.propertyStatus+'</td></tr>');
		  // $('#propertyList').append('<tr><td><a id="editB" href="#" onclick="hello(\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');" href="#myModal">'+item.propertyName+'</a></td><td><a id="editB" href="#" onclick="hello(\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');">'+item.propertyId+'</a></td><td><a id="editB" href="#" onclick="hello12(\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\',\''+item.loanAmount+'\',\''+item.lenderName+'\',\''+item.closingDate+'\',\''+item.propertyStatus+'\');">'+item.fhaNumber+'</a></td><td>'+item.city+'</td><td>'+item.state+'</td><td>'+item.zip+'</td><td>'+item.loanType+'</td><td>'+item.propertyStatus+'</td></tr>');

	
	});
}


function hello( id,propertyId,propertyName,fhaNumber,loanType){
	
	 $.ajax({	 
		  type : "GET",
		  contentType : "application/json",
			url : "<%=restURL%>/orcf/getFolderData?id="+id,
	      dataType : 'json',
		  timeout : 100000,
		   success : function(data) {
			  // alert(data.folderName)
			 	   if(data.folderName != '/Legacy Data/'){
				    var randomnumber = Math.floor((Math.random()*100)+1); 
				    window.open("propertyDataSearch.jsp?propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=1000,height=500');
				}
					else
						{
						//alert("this property having legacy folder");
						$("#myModal1").modal("show");	
										
						
						} 
		  },
		  error : function(e) {
		   console.log("ERROR: ", e); 
		  },
		  done : function(e) {
			  tbl.fnClearTable(this);
		  }
		 
		 });
	 
	 
}


function hello12(folderName,propertyId,propertyName,fhaNumber,loanType,loanAmt,lenderName,closingDate,status){
	

	 $.ajax({	 
		  type : "GET",
		  contentType : "application/json",
			url : "<%=restURL%>/orcf/getFolderData?id="+folderName,
	      dataType : 'json',
		  timeout : 100000,
		   success : function(data) {
			  // alert(data.folderName)
			   if(data.folderName != '/Legacy Data/'){
					var res = propertyId + "/" +fhaNumber;
					 var randomnumber = Math.floor((Math.random()*100)+1); 
					    window.open("propertyDataSearch.jsp?result="+res+"&propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType+"&loanAmt="+loanAmt+"&lenderName="+lenderName+"&closingDate="+closingDate+"&status="+status,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=1000,height=500');
					 }
					else
						{
						//alert("this property having legacy folder")
						$("#myModal1").modal("show");
						
						} 
		  },
		  error : function(e) {
		   console.log("ERROR: ", e); 
		  },
		  done : function(e) {
			  tbl.fnClearTable(this);
		  }
		 
		 });
	
	
}


function handleSelect(type)
{
	 if(type=="property"){
		   $( "#selectArea option:selected" ).text();
		   window.location.href = 'propertySearch.jsp';
	   }else if(type=="document"){
		   $( "#selectArea option:selected" ).text();
		   window.location.href = 'documentSearch.jsp';
	   }else if(type=="transaction"){
		   $( "#selectArea option:selected" ).text();
		   window.location.href = 'transactionSearch.jsp';
	   }
}
 


  </script>
    <!-- Bootstrap -->
<!--     <link href="css/bootstrap.min.css" rel="stylesheet">
 -->    <link href="css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
	.btnPropty:active,.btnPropty:focus,.btnPropty:hover{
        border: 2px solid #ff9800 !important;
       }
  
      .btnPropty.active{
       border: 2px solid #ff9800 !important;
       }
  
    
	.btnPropty{
    background: transparent;
    padding: 10px 0px;
    margin-right: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: -2px 3px 4px #ccc;
    margin-bottom: 20px;
    width: 200px;
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
	.workingArea {
    
    border: 0px solid #867171 !important;    
    box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.9) !important;
}


.dt-buttons {
    left: 0px !important;
    
    position: absolute !important;
}


a.dt-button.buttons-excel.buttons-html5 {
   
background: #4ba34b !important;
    border: 1px solid #ddd  !important;
    padding: 4px 20px  !important;
    vertical-align: -webkit-baseline-middle !important;
    color: #fff  !important;
    border-radius: 6px  !important;

}

a.dt-button.buttons-pdf.buttons-html5{

background: #4ba34b !important;
    border: 1px solid #ddd  !important;
    padding: 4px 20px  !important;
    vertical-align: -webkit-baseline-middle !important;
    color: #fff  !important;
    border-radius: 6px  !important;
    
}
	
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
  
  <body>
    
	<!--- Header ----->
	<!-- <header id="transMenu">
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		  <div class="row">
		  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>                        
			  </button>
			  <a class="navbar-brand" href="#">Office of Residential Care Facilities Document Management System<br> <sub class="pull-right mtop10">Powered by Transaccess(PSL)</sub></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
			  
			  <ul class="nav navbar-nav navbar-right">
				<li><a href="#"> My Profile</a></li>
				<li><a href="#"> Home</a></li>
				<li><a href="#"> Admin</a></li>
				<li><a href="#"> Logout</a></li>
			  </ul>
			</div>
			</div>
			</div>
		  </div>
		</nav>
	</header> -->
	<!--- Header ----->
	
	<!--- content Part --->
	<section>
	     <div class="container-fluid">
		<div class="row" style="border: 1px solid #a5a1a1;">
		<div class="col-lg-12" style="margin-top: 30px;margin-bottom: 20px;color: #ff9900;font-size: 22px;font-weight: bold;text-transform: capitalize;">
				<div class="text-center">Welcome To <%=companyFullName %> </div>
				<div class="text-center" >Document Management System </div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-6">
					<div class="text-left" id="propertiesCount" style="font-size: 14px;font-weight: bold;margin-top: 15px;margin-bottom: 30px; color: #0A68B4;">The System Currently Contains: </div>
				</div>
				<div class="col-lg-6">
				<div class="text-right" id="filesCount" style="font-size: 14px;font-weight: bold;margin-bottom:30px;margin-top: 15px;color: #0A68B4;">The System Currently Contains: </div>
				</div>
			</div>
			<div class="col-lg-12">
				<div style="text-align:left;margin-bottom: 15px;margin-left:15px;font-size: 14px;font-weight:bold;">Total Properties by Loan type</div>
					<div style="display:table;" id="loanTypePropertyList">
					</div>
			</div>
		</div>
	</div>
	 <!--   <div class="container-fluid">
		<div class="row" style="border: 1px solid #a5a1a1;padding: 30px 0px;">
			<div class="col-lg-12">
				<div class="col-lg-6">
					<div class="text-center" id="propertiesCount" style="font-size: 14px;font-weight: bold;">The System Currently Containes :</div>
				</div>
				<div class="col-lg-6">
				<div class="text-center" id="filesCount" style="font-size: 14px;font-weight: bold;">The System Currently Containes :</div>
				</div>
			</div>
			<div class="col-lg-12" style="margin-top: 30px;margin-bottom: 20px;color: #0A68B4;font-size: 25px;">
				<div class="text-center">Welcome to office of Residential Care Facilities </div>
				<div class="text-center" style="font-weight: bold;">Document Management System </div>
			</div>
			<div class="col-lg-12">
				<div style="text-align:left;margin-bottom: 15px;margin-left: 40px;font-size: 14px;font-weight:bold;">Total Properties by Loan type</div>
				
					<div style="display:table;" id="loanTypePropertyList">
						
					
					</div>
					
					
			</div>
			
		</div>
	</div> -->
		<!--- Part1 ---->
			<!-- <div id="welcomeArea" class="borderAll">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="text-center">
								<h5>Welcome to the Office of Residential Care Facilities Document Management System</h5>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
							<br />
							<ul class="list-none pleft0">
								<li class="text-capitalize"><p id ="filesCount">the system currently containes : </span></li>
								<li class="text-capitalize"><p id ="propertiesCount">the system currently containes : </p></li>
								<li class="text-capitalize"><p id ="loanCount">the system currently containes : </p></li>	
								<table class="pull-left">
								<tr>
							<td><p id ="propertiesCount" class="text-capitalize">the system currently containes : </p></td>
						
							</tr>
							<tr>
							<td><p id ="filesCount"  class="text-capitalize">the system currently containes : </p></td>
							
							</tr>
							
							<tr>
							<td><p id ="loanCount" class="text-capitalize">the system currently containes :  </p></td>
							
							</tr>
							
							</table>						</ul>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 pull-right">
							<div class="pull-right">
							<div class="f-family"><h5><b>Total properties by Loan type</b></h5></div>
							<div style="cursor: pointer;">
								 
								<table><h6 class="text-primary margin5" id="loanTypePropertyList"></h6></table>
							</div>
							</div>
						</div>
					</div>
				</div>
			</div> -->
		<!--- Part1 ---->
		   <div id="my_popup">
	<div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em;  display: none; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
    <h4><i class="zmdi_large zmdi-settings zmdi-hc-spin"></i> Loading Contents...Please Wait...</h4>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;It will take few seconds.</p>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;Please wait while the contents are loading.</p>
    
	</div>
	
  </div>
		<!--- Part2 - Search ---->
			<div id="searchArea" class="borderAll" style="margin-top: 25px;">
				<div class="container-fluid">
					<div class="row">
						<br />
						<div class="col-lg-offset-4 col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<div class="text-center">
								<h5><b class="f-family">Property Name Search</b></h4>
							</div>							
						</div>
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<div class="pull-right">
								<label><h5 class="f-family">Search Type</h4></label>
								<select id="selectArea" class="selectArea"  onchange="javascript:handleSelect(this.value)">
								<option value="document">FHA Number Search</option>									
								<option value="property" selected>Property Name Search</option>								
 								   <option value="transaction">Transaction Search</option>							
								</select>
							</div>
						</div>
						<div class="clearfix"></div>
						<hr class="hrStyle1"/>
										<br />
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 propertysearchForm">
							
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" style="padding-right:20px;">
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle" >Property ID</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="propertyId" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Property Name</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="propertyNm" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">City</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="city" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">State</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="state" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Zip</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="zip" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" style="padding-left:20px;">
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">FHA Number</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="fhaNum" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Lender Name</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="lenderNm" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>										
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Loan Type</label>
											<div class="col-sm-8 posiRelavtive">
											  <select id="loanType" class="selectArea width100per"> <!-- multiple -->
											  	<option value="" selected disabled>Select Type of Search</option>
												<!-- <option>241a</option>								
												<option>223a7</option>								
												<option>232i</option>
												<option>223f</option>	
												<option>232nc</option>
												<option>223d</option> -->									
											  </select>
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Loan Amount</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="loanAmt" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Closing Date Range</label>
											<div class="col-sm-8 posiRelavtive">
												<div class="row">
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
													<!-- 	<label class="control-label col-sm-12 lablestyle">Start</label> -->
                                                         
														 <input id="startDate"  type="text" class="form-control col-sm-12 inputStyle1" placeholder="Start" style=width: 100%" >
												
													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
<!-- 														<label class="control-label col-sm-12 lablestyle">End</label>
 -->											  			<input id="endDate" type="text" class="form-control col-sm-12 inputStyle1" placeholder="End" style=width: 100%">
											
													</div>
												</div>
												
												</div>
										</div>	
										
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Property Status</label>
											<div class="col-sm-8 posiRelavtive">
											  <select id="propertyStatus" class="selectArea width100per"> <!-- multiple -->
											  	<option value="" selected disabled>Select Status</option>
												<option>Active</option>								
												<option>Inactive</option>								
																				
											  </select>
											</div>
										</div>	
										
									</div>	
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">		
										<br />
										<button class="btn btn-success waves-effect waves-button waves-float f-family center-block" onclick="javascript:getPropertyList(this);"><i class="fa fa-check"></i>  Search</button>
										<button class="btn btn-warning waves-effect waves-button waves-float f-family center-block" onclick="javascript:clearFields(this);"><i class="fa fa-close"></i>  Reset</button>		
										<br />							
									</div>
								</div>
						</div>
					</div>
				</div>
			</div>	
		<!--- Part2 - Search ---->
		
		<!--- Part3 - Search Results---->
			<div id="searchResults" class="borderAll">
				<div class="container-fluid">
					<div class="">
						<div class="">
							<div class="row">
								<div class="col-lg-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<h5 class="text-left"><b>Search Results</b></h5>
								</div>
								<div class="col-lg-6 col-lg-6 col-md-6 col-sm-6 col-xs-12 pull-right">
									<button class="btn btn-warning waves-effect waves-button waves-float f-family pull-right" onclick="clearResults()"><i class="fa fa-close"></i> &nbsp; Clear Results</button>
								</div>
								<div class="clearfix"></div>
									<hr class="hrStyle1"/>
										<br />
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			                    <div id="tableStyle1" style="display: none;">
			
									<div class="table-responsive">
										
										<table id="searchResTable" class="table table-bordered">
											<thead>
												<tr>
													<th>Property Name</th>
													<th>Property ID</th>
													<th>Associated FHA Number</th>
													<th>City</th>
													<th>State</th>
													<th>Zip</th>
													<th>Type of Loan</th>
													<th>Property Status</th>
												</tr>
											</thead>
											<tbody id="propertyList">
											<!-- 	<tr>
													<td class="color-blue">1</td>
													<td class="color-blue">1</td>
													<td class="color-blue">1</td>
													<td>1</td>
													<td>1</td>
													<td>1</td>
													<td>1</td>
												</tr> -->
											</tbody>
										</table>
									</div>
								</div>
								</div>
								
							</div>
						</div>		
					</div>
				</div>
			</div>	
			
		<!--- Part3 - Search Results---->				
		
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog propertyPopup">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          
        </div>
        <div class="modal-body">
        <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        	<div id="treeview5" class="treeview">
        	<ul class="list-group">
        	<li class="list-group-item node-treeview5 node-selected" data-nodeid="0" style="color:#FFFFFF;background-color:#428bca;">
        	<span class="icon expand-icon glyphicon glyphicon-chevron-down">
        	</span><span class="icon node-icon glyphicon glyphicon-bookmark">
        	</span>Parent 1</li>
        	<li class="list-group-item node-treeview5" data-nodeid="1" style="color:undefined;background-color:undefined;">
        	<span class="indent">
        	</span><span class="icon expand-icon glyphicon glyphicon-chevron-right">
        	</span><span class="icon node-icon glyphicon glyphicon-bookmark">
        	</span>Child 1</li><li class="list-group-item node-treeview5" data-nodeid="4" style="color:undefined;background-color:undefined;">
        	<span class="indent">     	</span>
        	<span class="icon glyphicon"></span><span class="icon node-icon glyphicon glyphicon-bookmark"></span>Child 2</li><li class="list-group-item node-treeview5" data-nodeid="5" style="color:undefined;background-color:undefined;"><span class="icon glyphicon"></span><span class="icon node-icon glyphicon glyphicon-bookmark"></span>Parent 2</li><li class="list-group-item node-treeview5" data-nodeid="6" style="color:undefined;background-color:undefined;"><span class="icon glyphicon"></span><span class="icon node-icon glyphicon glyphicon-bookmark"></span>Parent 3</li><li class="list-group-item node-treeview5" data-nodeid="7" style="color:undefined;background-color:undefined;"><span class="icon glyphicon"></span><span class="icon node-icon glyphicon glyphicon-bookmark"></span>Parent 4</li><li class="list-group-item node-treeview5" data-nodeid="8" style="color:undefined;background-color:undefined;"><span class="icon glyphicon"></span><span class="icon node-icon glyphicon glyphicon-bookmark"></span>Parent 5</li></ul></div>
        	<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
        	<div class="folderBorder">
        	FHA Number
        	</div>
        	<div class="">
        		<div class="">
			                    <div id="tableStyle1" >
			
									<div class="table-responsive">
										<br />
										<table id="searchResTable" class="table table-bordered">
											<thead>
												<tr>
													<th> Name</th>
													<th>Type</th>
													<th>Dcument Type</th>
													<th>Version Number</th>
													<th>Document Details</th>
													<th>Closing Date</th>
													<th>Deposit Date</th>
												</tr>
											</thead>
											<tbody id="88">
									 	<tr>
													<td class="color-blue">1</td>
													<td class="color-blue">1</td>
													<td class="color-blue">1</td>
													<td>1</td>
													<td>1</td>
													<td>1</td>
													<td>1</td>
												</tr> 
											</tbody>
										</table>
									</div>
								</div>
								</div>
								
        	</div>
        	</div>
       
        
        </div>
          </div>
        </div>
        
      </div>
      
    </div>
  </div>
  
	</section>
	<!--- content Part --->
	  <div style='display:none'>
  <div id="dialog-modal" style="" title="Basic modal dialog">
    <p>Loading</p>
    </div>
<div>
  </div>
</div> 
	
	<!-- Model BOX -->
	
	<div id="myModal1" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content" style="width: 380px;margin: auto;">
      <!--  <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div> -->
        <div class="modal-header" style="background-color:#7098CC">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel" style="color:white;text-align: center;">Property Details</h4>
                </div>
      <div class="modal-body">
        <p>The file you have selected is a Legacy file and can only be viewed via the FHA Number Search leveraging the FHA Number or Property ID. All other search functionality has been disabled for this particular file.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
	<!-- <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div> -->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 -->    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- <script src="js/bootstrap.min.js"></script> -->
  </body>
</html>