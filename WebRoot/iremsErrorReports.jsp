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
     
  
  <script src="js/searchFilter.js"></script>
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
		
				
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
    margin-right: 8px;
    background-color: #4caf50;
    float: left;
    border-radius: 7px;
    position: absolute;
    margin-top: -54px;
     right: 41%;
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
    margin-top: -54px;
    left: 21%;
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
 
function displayData(data) {

	
	 
  	$.each(data.getIREMSErrorReport, function(i, obj) {
  		 $('#myTable tbody').append('<tr><td >'+obj.userName+'</td><td width="10%">'+obj.uploadDate+'</td><td  width="15%">'+obj.propertyId+'</td><td width="20%">'+obj.documentTypedesc+'</td><td>'+obj.actualFilename+'</td>');
           
  	});
	
  }



function getHtmlReport(){
	
	if ($.fn.DataTable.isDataTable("#myTable")) {
		  $('#myTable').DataTable().clear().destroy();
		}
	
	var param="uploadType=E";
	$("#loadingImage").show();

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/role/getIREMSErrorReport?"+param,
		dataType : 'json',
		timeout : 100000,
	  //data:JSON.stringify({'email':email,'phone':mnumber,'ccode':'+91','userId':userid,'not':'nosms'}),
		success : function(data) {
			$("#loadingImage").hide();
			$('#myTable').show();
			if(data.key=="200"){
				
				  if(data.getIREMSErrorReport!=null){
					  data=displayData(data);
				   		  }else{
				   			 
				   			data=[];
				   		  }
				  $('#clearnotdefault').show();
				  
				   		  
				   		$("#myTable").dataTable({
				   			
				   		 dom: 'lBfrtip',
					        buttons: [
					        	{ extend : 'excelHtml5',
					        		title:"IREMS Error Report",
					        		text:"EXCEL REPORT",
					        		filename:"IREMS Error Report"
					        		
					        	},{ extend : 'pdfHtml5',
					        		title:"IREMS Error Report",
					        		text:"PDF REPORT",
					        		filename:"IREMS Error Report"
					        	}
						        ],
						       
							  "order": [[ 1, "desc" ]],
					          "deferRender":    true,
					          "scroller":       true,
					        
					           "drawCallback": function(){
					        	   // Update state of "Select all" control
					        	  // updateDataTableSelectAllCtrl($("#myTable").DataTable());
					        	},
					        	"aoColumns": [
					                 null,
					                 { "sType": "date-uk" },
					                 null,
					                 null,
					                null
					                
					             ],
					             "columnDefs": [
					            	    { "width": "10%" },
					            	    { "width": "20%" },
					            	    { "width": "10%" },
					            	    { "width": "20%" },
					            	    { "width": "20%" }
					            	  ]
					             
					    
					    });
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





 



$(function() {
	$("#loadingImage").hide();
	
  
	$('#myTable').hide();
	initial_load();
});



$(document).mousemove(function(event){
	  InitializeTimer();
});

function initial_load()
	{
	
	setHeader('iremsErrorReports.jsp');
	setHeaderText('IREMS Error','Reporting & Analysis','dashboard.jsp?reports=true');
	 var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(i == 1)
		array_of_li[i].setAttribute("class", "active");	
		
	} 
	getHtmlReport();	
	}
	
		
	


//-->
</script>
	

	<section class="upload-document">
        <div class="container-fluid">
            <div class="child-upload-docs" style="text-align: left;  margin-left: 10px;">
            <br>
                <h4 style="color: #0a68b4;">iREMS Error Report</h4>
				<hr>
				<div>
This Report provides a list of current Records with invalid iREMS numbers or other errors that can be identified-Excluding those included<br>
  in the pending Uploads Rpt.<br>
 
 The Fields include: (User ID, Upload Date, iREMS#, Document Type, File Name )
 
</div><br>
							
				<div class="upload-dates col-sm-12">
				<div >
				<span id="result" style="color:red"></span></div>
				
				</div>
               
                <br>
                <br>
                 <div class="upload-dates col-sm-12">
                  <div>
                  <button type="button" class="btn btncolour btnclass" onclick="getHtmlReport()">HTML REPORT</button></div> 
                   
                  </div> 
                    
                   <br>
                 </div>
                 <br>
                  <br>
                <div class='row' style="width: 100%">
                <div class="table-data">
                
                    <table id="myTable" class="table table-bordered">
                        <thead>
                           <tr>
                                <th>User ID </th>
                                <th>Upload Date</th>
                                <th>iREMS #</th>
                                <th>Document Type</th>
                                <th>File Name</th>
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
