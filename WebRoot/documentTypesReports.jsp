<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<%@page import="java.util.*"%>


<html>
	<head>
		<title>Transaccess Imaging Administrator Edit User Profile</title>
		<meta name="pageHeading" content='Imaging Registration' />
			
		
		
		
		<script src="js/jQuery/1.11.3/jquery.min.js"></script>
		

<!-- <script type="text/javascript" src="js/jQuery/1.11.3/jquery.min.js" ></script>-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css" rel="stylesheet" type="text/css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>	
<script type="text/javascript" src="js/jQuery/jquery.qtip.min.js" ></script>		

<link rel="stylesheet" href="css/jquery.dataTables.min.css" />  
	

<link rel="stylesheet" type="text/css" href="css/styleSheet.css" />
 <script src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
  <script
	src="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"></script>
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/dataTables.buttons.min.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.flash.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.html5.min.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.print.min.js"></script> 
     <script src="js/dataTables.checkboxes.min.js"></script>
        <script src="js/jQuery/jquery.tablecheckbox.js"></script>
     
  <script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
  <script src="js/searchFilter.js"></script>
		
				
	<style type="text/css">
	.monthselect{
	    height: 28px;
    width: 14%;}
	.btncolour{
	    background-image: linear-gradient( #b9d0e8, #8fbae6,#bbe9fe) !important;
    color: black !important;
    font-weight: bold;
	}
	.btnclass{
	    padding: 7px 25px;
    margin-right: 20px;
    background-color: #4caf50;
    color: #fff;
    float: left;
    border-radius: 7px;}
a:hover, a:focus {
    color: #0A68B4;
    text-decoration: none;
}
#myTable_info, #myTable_length{
float: left !important;}
#myTable_paginate, #myTable_filter{
float: right !important;}
.table > thead > tr > th, table-data thead tr {
    background-color: #7098CC;
    color: #fff !important;
}
.buttons-excel{

    
     background-image: linear-gradient( #b9d0e8, #8fbae6,#bbe9fe) !important;
    color: black !important;
    font-weight: bold;
    padding: 9px 30px;
    margin-right: 20px;
    background-color: #4caf50;
    float: left;
    border-radius: 7px;
    position: absolute;
    margin-top: -57px;
     right: 38%;
    background: #4caf50;
}
.buttons-pdf {
    background-image: linear-gradient( #b9d0e8, #8fbae6,#bbe9fe) !important;
    color: black !important;
    font-weight: bold;
    padding: 9px 30px;
    margin-right: 20px;
    background-color: #4caf50;
    float: left;
    border-radius: 7px;
    position: absolute;
    margin-top: -57px;
    left: 22%;
    background: #4caf50;}
.input-group {
    width: 28%;
    float: left;
    margin-bottom: 20px;
    border-radius: 4px;
}
</style>
	</head>	
	
	
	<% try{
		 String appuserrole = (String)request.getSession().getAttribute("appuserrole");
		
		if(request.getSession().getAttribute("sessionid")!=null&&appuserrole.equals("ADMIN")){	
		

		  javax.naming.Context ctx = 	new javax.naming.InitialContext();
			String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
			
		
	%>
	
		
	<jsp:include page="includes/sessionHeader.jsp" />
	
<body >
<script type="text/javascript">

 


function displayData(data) {

  	     	
  	$.each(data.documentTypeInfoList, function(i, obj) {
  		 $('#myTable tbody').append('<tr><td width="25%">'+obj.documentType+'</td><td  width="15%">'+obj.documentTypeId+'</td><td>'+obj.docCountByDateRange+'</td><td>'+obj.totalDocCount+'</td><td  width="20%">'+obj.actualFileName+'</td>');
           
  	});
	
  }

function getHtmlReport(type){
	var month=$('#month').val();
	var year=$('#year').val();
	  $("#result").text("");
	if ($.fn.DataTable.isDataTable("#myTable")) {
		  $('#myTable').DataTable().clear().destroy();
		}
	//$(".buttons-excel").css("position", "initial").css("background", "none");
	var fromDate = $('#datepicker').datepicker('getDate');
	var toDate = $('#datepicker2').datepicker('getDate');
	var datedisplay="";
if(month||year){
	if(year){
		if(month){
		}else{
			$("#result").text("Select Month");
			return false;
		}
	}else{
		$("#result").text("Select Year");
		return false;
	}
	
	}else if(fromDate!='Invalid Date'||toDate!='Invalid Date'){
		if(fromDate!='Invalid Date'){
			if(toDate!='Invalid Date'){
				var datef=fromDate.getMonth()+1+"-"+fromDate.getDate()+"-"+fromDate.getFullYear();
		    	var dates=toDate.getMonth()+1+"-"+toDate.getDate()+"-"+toDate.getFullYear();
		    	datedisplay="From "+datef+" to "+dates
			}else{
	    		$("#result").text("Select To Date");	
	    		return false;
	    	}
		}else{
			
			$("#result").text("Select From Date");
			return false;
		}
	}else{
		
		$("#result").text("Select  Date");
		return false;
	}
	   	var param="startDate="+datef+"&endDate="+dates+"&year="+year+"&month="+month;
	$("#loadingImage").show();

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/role/getDocumentTypeReport?"+param,
		dataType : 'json',
		timeout : 100000,
	  //data:JSON.stringify({'email':email,'phone':mnumber,'ccode':'+91','userId':userid,'not':'nosms'}),
		success : function(data) {
			$("#loadingImage").hide();
			$('#myTable').show();
			if(data.key=="200"){
				
				  if(data.documentTypeInfoList!=null){
					  data=displayData(data);
				   		  }else{
				   			 
				   			data=[];
				   		  }
				  
				  if(!datef&&!dates){
					  datef=$('#month option:selected').html();
					  dates=year;
					 datedisplay=  datef+","+dates;
				  }
				   		  
				  $("#myTable").dataTable({
				   			
				   		 dom: 'lBfrtip',
					        buttons: [
					        	{ extend : 'excelHtml5',
					        		title:"Document Type Report",
					        		text:"EXCEL REPORT",
					        		filename:"Document Type Report",
					        		messageTop:datedisplay
					        	},{ extend : 'pdfHtml5',
					        		title:"Document Type Report",
					        		text:"PDF REPORT",
					        		filename:"Document Type Report",
					        		messageTop:datedisplay,
					        		orientation: 'landscape',
				        			  pageSize: 'LEGAL',
				        			customize : function(doc) {
				        			     doc.styles['td:nth-child(2)'] = { 
				        			       width: '100px',
				        			       'max-width': '100px'
				        			     }
					        	}}
						        ],
						       
							  "order": [[ 4, "desc" ]],
					          "deferRender":    true,
					          "scroller":       true,
					        
					           "drawCallback": function(){
					        	   exportdata();
					        	   
					        	  
					        	},
					        	"aoColumns": [
					                 null,
					                 null,
					                 null,
					                 null,
					                null
					                
					             ]
					    
					    });
				   	function exportdata(){
				   		if(type=='pdf'){
				   			$(".buttons-pdf").click();
				   			$("#myTable_wrapper").hide();
				   		}else if(type=='excel'){
				   			$(".buttons-excel").click();
				   			$("#myTable_wrapper").hide();
				   		}
				   	 
				   	}
			}else if(data.key=="500"){
				 //jAlert(data.message, 'Error');
				//$("#popup_error").text(data.message);
				alert(data.message)
			}

			  
			//$('#myModal').modal('show');
		
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		done : function(e) {
			console.log("DONE");
		}
		
});
		
}





 
$(document).mousemove(function(event){
	  InitializeTimer();
});


$(function() {
	setHeader('documentTypesReports.jsp');
	$("#loadingImage").hide();
	
   
    $("#datepicker").datepicker({
    	endDate:new Date(),
        autoclose: true,
        dateFormat: 'mm-dd-yy'
    	
    }).on("changeDate", function (e) {
    	var selectedto=$('#datepicker2').datepicker('getDate');
    	if(selectedto!='Invalid Date'){
    		if(e.date>selectedto){
    			$('#datepicker2').datepicker('setDate', null);
    			$('#datepicker2').datepicker({ autoclose: true}).datepicker('setStartDate', e.date).focus();
    		}
    	}else{
    		$('#datepicker2').datepicker({ autoclose: true}).datepicker('setStartDate', e.date).focus();
    	}
    	$("#result").text("");
    	//$("#datepicker2").datepicker( "option", "startDate", new Date() );
    	});
	$("#datepicker2").datepicker({
        autoclose: true,
        dateFormat: 'dd-mm-yy',
        endDate:new Date()
    }).on("changeDate", function (e) {
    	
    	$("#result").text("");
    	});
	$('.resettable').click(function() {
		window.location.reload();
		
		 $('#month').val('');
			$('#year').val('');
		$('#datepicker').datepicker('setDate', null);
		$('#datepicker2').datepicker('setDate', null);
		if ($.fn.DataTable.isDataTable("#myTable")) {
			  $('#myTable').DataTable().clear().destroy();
			}
	});
	$('#myTable').hide();
	initial_load();
});





function initial_load()
	{
	setHeaderText('Document Types','Reporting & Analysis','dashboard.jsp?reports=true');
	 var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(i == 1)
		array_of_li[i].setAttribute("class", "active");	
		
	} 
		
	var d = new Date();
	var monthArray = new Array();
	monthArray[0] = "January";
	monthArray[1] = "February";
	monthArray[2] = "March";
	monthArray[3] = "April";
	monthArray[4] = "May";
	monthArray[5] = "June";
	monthArray[6] = "July";
	monthArray[7] = "August";
	monthArray[8] = "September";
	monthArray[9] = "October";
	monthArray[10] = "November";
	monthArray[11] = "December";
	for(m = 0; m <= 11; m++) {
	    var optn = document.createElement("OPTION");
	    optn.text = monthArray[m];
	    // server side month start from one
	    optn.value = (m+1);
	    // if june selected
	    /* if ( m == 1) {
	        optn.selected = true;
	    } */
	    document.getElementById('month').options.add(optn);
	}
	
	for(y = 2000; y <= d.getFullYear(); y++) {
        var optn = document.createElement("OPTION");
        optn.text = y;
        optn.value = y;
        
        // if year is 2015 selected
        /* if (y == 2015) {
            optn.selected = true;
        } */
        
        document.getElementById('year').options.add(optn);
}
	
	
	
	
	}
	
		
	


//-->
</script>
	

	<section class="upload-document">
        <div class="container-fluid">
            <div class="child-upload-docs" style="text-align: left;  margin-left: 10px;">
            <br>
                <h4 style="color: #0a68b4;">Document Types Report</h4>
				<hr>
				<div>This Report will provide Statistics on all Document Type, within the date range provided.<br>
  The Fields include: (Document Type, Document Type ID, No of Records Uploaded,  Total Number of Records, Last Upload Date)</div><br>
							
				<div class="upload-dates col-sm-12">
				<div >
				<span id="result" style="color:red"></span></div>
				
				</div>
                <div class="upload-dates col-sm-12">
                
                    <div id="datepicker" class="input-group date" data-date-format="mm-dd-yyyy">
                        <input class="form-control" placeholder="From Date *" type="text" style="text-align: center;height: 28px;background: #edecec;" readonly />
                        <span class="input-group-addon calstyle"><i class="glyphicon glyphicon-calendar" style="font-size: 22px;color: #0d529f;"></i></span>
                    </div>

                    <div id="datepicker2" class="input-group date" data-date-format="mm-dd-yyyy">
                        <input class="form-control" placeholder="To Date *" type="text" style="text-align: center;height: 28px;background: #edecec;" readonly />
                        <span class="input-group-addon calstyle"><i class="glyphicon glyphicon-calendar" style="font-size: 22px;color: #0d529f;" ></i></span>
                    </div>
                   
                </div>
                <div style="margin-left: 17px;">OR</div>
                <br>
                 <div class="upload-dates col-sm-12" style="margin-bottom: 22px;">
                 <select class="monthselect" name="month" id="month">
    <option value="" selected disabled>Select Month</option>
</select>
                 <select class="monthselect" name="year" id="year">
    <option value="" selected disabled>Select Year</option>
</select>
 <br>
                <br>
                 </div>
                 <div class="upload-dates col-sm-12" style="margin-bottom: 22px;">
                
                  <div class="export">
                  <button type="button" class="btn btncolour btnclass" onclick="getHtmlReport('html')">HTML REPORT</button></div> 
                    <div class="export">
                        <button  type="button" class="btn btncolour btnclass"  onclick="getHtmlReport('pdf')"><i class="fa fa-share-square-o" aria-hidden="true"></i>PDF REPORT</button>
                    </div>
                    <div class="export">
                        <button  type="button" class="btn btncolour btnclass"  onclick="getHtmlReport('excel')"><i class="fa fa-share-square-o" aria-hidden="true"></i>EXCEL REPORT</button>
                    </div>
                    <div class="export">
                        <button   type="button"  class="btn btncolour resettable btnclass"  ><i class="fa fa-share-square-o" aria-hidden="true"></i>CLEAR</button>
                    </div>
                 </div>
                 <br>
                  <br>
                <div class='row' style="width: 100%">
                <div class="col-sm-12 table-data">
                
                    <table id="myTable" class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Document Type </th>
                                <th>Document Type ID</th>
                                <th>No of Records Uploaded</th>
                                <th>Total Number of Records</th>
                                <th>Last Upload Date</th>
                            </tr>
                        </thead>
                        <tbody id="getDocumentList">
                            
                        </tbody>
                    </table>
                     <div id="loadingImage"
							style="position: absolute; top: 50%; left: 0px; right: 0px; margin: auto; text-align: center">
							<img src="css/images/default.gif" />
						</div>
                    </div>
                </div>
            </div>
        </div>
    </section>	
			<%}else{
	response.sendRedirect("index.jsp");
} 
				}catch(IllegalStateException ie){
		response.sendRedirect("index.jsp");
	}%>
	</body>
</html>
