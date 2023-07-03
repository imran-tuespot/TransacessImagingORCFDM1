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
<script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js">
 
  <script src="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"></script>
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
    margin-right: 20px;
    background-color: #4caf50;
    float: left;
    border-radius: 7px;
    position: absolute;
    margin-top: -57px;
     left: 20%;
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
    left: 0%;
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
		
			 int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
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
	$.each(data.documenttype, function(i, obj) {
		var version=obj.version+1;
		var row='<tr><td width="25%">'+obj.actualFileName+'</td><td  width="15%">'+obj.propertyName+'</td><td>'+obj.documentType+'</td><td>'+version+'</td><td>'+obj.createDate+'</td>';
 		 if(obj.fileName!=null){
 			row=row+'<td  width="20%">'+obj.fileName +'</td>';
 		 }else{
 			row=row+'<td  width="20%">LF User</td>';
 		 }
 				 
	 $('#myTable tbody').append(row);   
 	});
	if(data.documenttype.length==5000){
		$("#result").text("Search results have reached max limit of 5k records. please refine your search to get the best results !!");
	}else{
			$("#result").text("");
	}
  	     	
  
  	
  	
	
  }




function getHtmlReport(type){
	
	  $("#result").text("");
		if ($.fn.DataTable.isDataTable("#myTable")) {
			  $('#myTable').DataTable().clear().destroy();
			}
		//$(".buttons-excel").css("position", "initial").css("background", "none");
		var fromDate = $('#datepicker').datepicker('getDate');
		var toDate = $('#datepicker2').datepicker('getDate');
		var datedisplay="";
		var datef="",dates="";
	/*  if(fromDate!='Invalid Date'||toDate!='Invalid Date'){
			if(fromDate!='Invalid Date'){
				if(toDate!='Invalid Date'){
					 datef=fromDate.getMonth()+1+"-"+fromDate.getDate()+"-"+fromDate.getFullYear();
			    	 dates=toDate.getMonth()+1+"-"+toDate.getDate()+"-"+toDate.getFullYear();
			    	datedisplay="From "+datef+" to "+dates
				}else{
		    		$("#result").text("Select To Date");	
		    		return false;
		    	}
			}else{
				
				$("#result").text("Select From Date");
				return false;
			}
		} */
	 
	 /* else{
			
			$("#result").text("Select  Date");
			return false;
		} */
		  

	
	
	   		$("#loadingImage").show();
	   	
	

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/role/getiremsList",
		dataType : 'json',
		timeout : 100000,
	  //data:JSON.stringify({'email':email,'phone':mnumber,'ccode':'+91','userId':userid,'not':'nosms'}),
		success : function(recordsdata) {
			$("#loadingImage").hide();
			$('#myTable').show();
			if(recordsdata.key=="200"){
				var totalrecords='';
				 totalrecords=recordsdata.propertyList.length;
				 /*  if(recordsdata.documenttype!=null){
					  totalrecords=data.documenttype[0].uploadSource;
					  recordsdata=displayData(recordsdata);
				   		  }else{
				   			 
				   			recordsdata=[];
				   		  } */
			/* 	var row='<tr><td width="25%">'+obj.actualFileName+'</td><td  width="15%">'+obj.propertyName+'</td><td>'+obj.documentType+'</td><td>'+version+'</td><td>'+obj.createDate+'</td>';
		 		 if(obj.fileName!=null){
		 			row=row+'<td  width="20%">'+obj.fileName +'</td>';
		 		 }else{
		 			row=row+'<td  width="20%">LF User</td>';
		 		 } */
		 		 
		 		
		 		
		   		     $('#myTable').DataTable( {
		   		        serverSide: false,
		   		        ordering: false,
		   		        searching: true,
		   		     dom: 'lBfrtip',
				        buttons: [
				        	{ extend : 'excelHtml5',
				        		title:"Current iREMS # Report",
				        		text:"EXCEL REPORT",
				        		filename:"Current iREMS # Report",
				        		messageTop:"Records Total:"+totalrecords
				        	},{ extend : 'pdfHtml5',
				        		title:"Current iREMS # Report",
				        		text:"PDF REPORT",
				        		filename:"Current iREMS # Report",
				        		messageTop:"Records Total:"+totalrecords ,
				        		orientation: 'landscape',
			        			  pageSize: 'LEGAL',
			        			customize : function(doc) {
			        			     doc.styles['td:nth-child(2)'] = { 
			        			       width: '100px',
			        			       'max-width': '100px'
			        			     }
				        	}}
					        ],
					       
					        "order": [[ 0, "desc" ]],
						  "aoColumns": [
				                 
				                null
				                
				             ],
		   		        ajax: function ( data, callback, settings ) {
		   		          
		   		         var out = [];
		 		 		$.each(recordsdata.propertyList, function(i, obj) {
		 		 	 			 
		 		 	 		out.push( [obj.propertyId]);
		 		 	 	});

		 		 		 if($('#totalrecords').length<=0){
			        		   $( "#myTable_length" ).append( "<lable id='totalrecords' style='margin-left: 30px;'>Records Total:"+totalrecords+"</lable>" );  
			        	   }
		   		 
		   		            setTimeout( function () {
		   		                callback( {
		   		                    draw: data.draw,
		   		                    data: out,
		   		                    recordsTotal: out.length,
		   		                    recordsFiltered: out.length,
		   		                } );
		   		            }, 50 );
		   		        },
		   		    //   scrollY:400,
 		   		        scroller: {
 		   		            loadingIndicator: true
 		   		        },
		   		    } ); 
		 		 
				/*   $("#myTable").dataTable({
				   			
				   		 dom: 'lBfrtip',
					        buttons: [
					        	{ extend : 'excelHtml5',
					        		title:"Document Type (Detailed) Report",
					        		text:"EXCEL REPORT",
					        		filename:"Document Type (Detailed) Report",
					        		messageTop:"Records Total:"+totalrecords
					        	},{ extend : 'pdfHtml5',
					        		title:"Document Type (Detailed) Report",
					        		text:"PDF REPORT",
					        		filename:"Document Type (Detailed) Report",
					        		messageTop:"Records Total:"+totalrecords ,
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
					        	   if($('#totalrecords').length<=0){
					        		   $( "#myTable_length" ).append( "<lable id='totalrecords' style='margin-left: 30px;'>Records Total:"+totalrecords+"</lable>" );  
					        	   }
					        	 
					        	  
					        	},
					        	"aoColumns": [
					                 null,
					                 null,
					                 null,
					                 null,
					                 { "sType": "date-uk" },
					                null
					                
					             ]
					    
					    }); */
				  
					

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
	setHeader('IremsReports.jsp');
	
	$("#loadingImage").hide();
	
	getHtmlReport('html');
    
	/*  $("#datepicker").datepicker({
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
	    	}); */
		
	$('#myTable').hide();
	initial_load();
});





function initial_load()
	{
	setHeaderText('Current iREMS # Report','Reporting & Analysis','dashboard.jsp?reports=true');
	 var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(i == 1)
		array_of_li[i].setAttribute("class", "active");	
		
	} 
	
	}
	
		
	


//-->
</script>
	

	<section class="upload-document">
        <div class="container-fluid">
            <div class="child-upload-docs" style="text-align: left;  margin-left: 10px;">
            <br>
                <h4 style="color: #0a68b4;">Current iREMS # Report</h4>
				<hr>
				<div>This Report will provide you with every available iREMS Number.<br>
 &nbsp  The Field include: ( iREMS# )</div><br>
							
				<div class="upload-dates col-sm-12">
				<div >
				<span id="result" style="color:red"></span></div>
				
				</div>
				 <br>
				 
                <div class="upload-dates col-sm-12">
                
                    <div class="form-group">
							<div class="row">
								
							
							<!-- 	 <div id="datepicker" class="input-group date" data-date-format="mm-dd-yyyy">
                        <input class="form-control" placeholder="From Date *" type="text" style="text-align: center;height: 28px;background: #edecec;" readonly />
                        <span class="input-group-addon calstyle"><i class="glyphicon glyphicon-calendar" style="font-size: 22px;color: #0d529f;"></i></span>
                    </div>

                    <div id="datepicker2" class="input-group date" data-date-format="mm-dd-yyyy">
                        <input class="form-control" placeholder="To Date *" type="text" style="text-align: center;height: 28px;background: #edecec;" readonly />
                        <span class="input-group-addon calstyle"><i class="glyphicon glyphicon-calendar" style="font-size: 22px;color: #0d529f;" ></i></span>
                    </div> -->
							</div>
						</div>
						
						
                   
                </div>
               
                
                <br>
               
                 <div class="upload-dates col-sm-12" style="margin-bottom: 22px;">
                <!-- 
                  <div class="export">
                  <button type="button" class="btn btncolour btnclass" onclick="getHtmlReport('html')">HTML REPORT</button></div>  -->
                    <div class="export">
                        <button  type="button" class="btn btncolour btnclass"  onclick="getHtmlReport('pdf')"><i class="fa fa-share-square-o" aria-hidden="true"></i>PDF REPORT</button>
                    </div>
                    <div class="export">
                        <button  type="button" class="btn btncolour btnclass"  onclick="getHtmlReport('excel')"><i class="fa fa-share-square-o" aria-hidden="true"></i>EXCEL REPORT</button>
                    </div>
                  <!--   <div class="export">
                        <button   type="button"  class="btn btncolour resettable btnclass"  ><i class="fa fa-share-square-o" aria-hidden="true"></i>CLEAR</button>
                    </div> -->
                 </div>
                 <br>
                  <br>
                <div class='row' style="width: 100%">
               
                <div class="col-sm-12 table-data">
                    <table id="myTable" class="table table-bordered">
                        <thead>
                            <tr>
                            <!--     <th> File Name </th> -->
                                <th>iREMS#</th>
                                <!-- <th>Document Type</th>
                                <th>Version Total</th>
                                <th>Date uploaded</th>
                                <th>Record Originator</th> -->
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
