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
	color: #FFF;
    background-color: #4CAF50;
    border-color: #449D48;
	display: inline-block;
    margin-bottom: 0px;
    font-weight: 400;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    background-image: none;
    border: 1px solid transparent;
    white-space: nowrap;
    padding: 3px 6px;
    font-size: 13px;
    line-height: 1.42857;
    border-radius: 2px;
    font-family: Open Sans,sans-serif,Arial,Helvetica,Verdana;
    margin-bottom: 20px;
    margin-right: 652px;
    margin-top: -46px;
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
		
			int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
		  javax.naming.Context ctx = 	new javax.naming.InitialContext();
			String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
			
		
	%>
	
		
	<jsp:include page="includes/sessionHeader.jsp" />
	
<body >
<script type="text/javascript">
   
	   
var globalData;

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
 var dispalytabledata='';
function displayData(data) {
console.log(data.response)
	 dispalytabledata=data.response;
  	$.each(data.response, function(i, obj) {
  		 $('#myTable tbody').append('<tr><td></td><td style="text-align:center;" width="15%"><input type=hidden value='+obj.request_id+'>'+obj.requestDate+'</td><td style="text-align:center;" width="10%">'+obj.requestedBy+'</td><td style="text-align:center;" width="15%">'+obj.irems+'</td><td width="20%" style="text-align:center;">'+obj.doctype_desc+'</td><td style="text-align:center;">'+obj.version+'</td><td style="text-align:center;">'+obj.uploadDate+'</td><td style="text-align:center;">'+obj.uploadedBy+'</td><td style="text-align:left;" width="30%"><div  style="overflow-y:auto;overflow-x:hidden;height:100;">'+obj.problemDesc+'</div></td>');
           
  	});
	
  }



function getHtmlReport(){
	
	if ($.fn.DataTable.isDataTable("#myTable")) {
		  $('#myTable').DataTable().clear().destroy();
		}
	
	

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/orcf/getRecordRemovalReq",
		dataType : 'json',
		timeout : 100000,
	  //data:JSON.stringify({'email':email,'phone':mnumber,'ccode':'+91','userId':userid,'not':'nosms'}),
		success : function(data) {
			globalData=data;
			$("#loadingImage").hide();
			$('#myTable').show();
			if(data.key=="200"){
				
				  if(data.response!=null){
					  data=displayData(data);
				   		  }else{
				   			 
				   			data=[];
				   		  }
				  $('#clearnotdefault').show();
				  
				   		  
				   $("#myTable").dataTable({
					   dom: 'lBfrtip',
				        buttons: [
				        	{ extend : 'excelHtml5',
				        		title:"Record Removal Requests Report",
				        		text:"Export Excel",
				        		filename:"Record Removal Requests Report",
				        			customize: function( xlsx ) {
				        	              var source = xlsx.xl['workbook.xml'].getElementsByTagName('sheet')[0];
				        	              source.setAttribute('name','Removal Requests');
				        	                        }
				        		
				        	}],
							  "order": [[ 1, "desc" ]],
					          "deferRender":    true,
					          "scroller":       true,
					        
					           "drawCallback": function(){
					        	   // Update state of "Select all" control
					        	  // updateDataTableSelectAllCtrl($("#myTable").DataTable());
					        	},
					        	"aoColumns": [
					                 null,
					                 null,
					                 { "sType": "date-uk" },
					                 null,
					                 null,
					                 null,
					                 null,
					                null,
					                null
					                
					             ],
					             /* "columnDefs": [
					            	    { "width": "10%" },
					            	    { "width": "20%" },
					            	    { "width": "10%" },
					            	    { "width": "20%" },
					            	    { "width": "20%" }
					            	  ], */

					            	  "columnDefs": [ {
					            		  'targets': 0,
					            	         'searchable':false,
					            	         'orderable':false,
					            	         'className': 'dt-body-center',
					            	         'render': function (data, type, full, meta){
					            	      var obj= full[1].split('>')[0].replace('<input type="hidden" value=','').replace('\"',"").replace('\"',"");

					            	        	 console.log(obj);
					            	        	/*  console.log(full[4]);
					            	        	 console.log(full[5]);
					            	        	 console.log(full[1].split('>')[0].replace('<input type="hidden" value=','')); */
					            	        	
					            	        	// console.log(data)
					            	             return '<input type="checkbox" name="requestcls" value='+obj+ 
					            	                '>';
					            	         }
				                        },
				                        { "width": "10%" },
					            	    { "width": "10%" },
					            	    { "width": "10%" },
					            	    { "width": "20%" },
					            	  
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

/* {
    "list":[{
    "removeReqId":"1",     "status":"A","irems":"076496201","doctype":"2131","version":"0"},
    {"removeReqId":"2",    "status":"R","irems":"076496201","doctype":"2131","version":"0"}
],
"modifiedBy":"915"} */
function checkIfHigherVersionExists(list,dispdata){
	for(var i=0;i<list.length;i++){
		for(var j=0;j<dispdata.length;j++){
			if(list[i].irems == dispdata[j].irems && list[i].doctype==dispdata[j].doc_type
				&& list[i].version<dispdata[j].version){
				return false;
			}
		}
	}
	return true;
}

function acceptRequet(){
	var list=[];
	$('input[name="requestcls"]:checked').each(function() {
		for(var i=0;i<dispalytabledata.length;i++){
		
			if(dispalytabledata[i].request_id==this.value){
				console.log(dispalytabledata[i]);
				list.push({"removeReqId":this.value,     "status":"Accepted","irems":dispalytabledata[i].irems,"doctype":dispalytabledata[i].doc_type,
						"version":dispalytabledata[i].version})
			}
		}  
		});
//if(checkIfHigherVersionExists(list,dispalytabledata)){
	if(list.length>0){
		var user_id= '<%=uid%>';
		$("#loadingImage").show();
	    $.ajax({
	    	
	        type: "POST",
	        
	         url : "<%=restURL%>/orcf/recordRemovalApproval", 
	      
	        contentType: "application/json",
	        
	 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
	        data: JSON.stringify({list:list,
	        	modifiedBy:user_id
	        	
	        	}),
	        	datType : "json",
	       
	 		success : function(data) 
	 		{$("#loadingImage").hide();
	 			if(data.key==200){
	 				 $("#result").text("Document Deleted successfully").css("color", "green");
	 				setTimeout(function(){ 
	 	        		window.location.reload();
	 	        	
	 	       	}, 2000); 
	 			}else if(data.key==201){
	 				 $("#result").text("This version can't be approved for deletion as a higher/latest version of this document exists. \n Please select/request for the latest version to be deleted first for "+
	data.IREMS+".\n").css("color", "red").css("white-space","pre-line");
	 			}
	 			
	 		}
		});
		
		
	}else{
		alert("Select Record")
	}
/* } else{
	 $("#result").text("Has Higher version").css("color", "red");
}*/ 
}

function rejectRequet(){
	var list=[];
	$('input[name="requestcls"]:checked').each(function() {
		for(var i=0;i<dispalytabledata.length;i++){
		
			if(dispalytabledata[i].request_id==this.value){
				console.log(dispalytabledata[i]);
				list.push({"removeReqId":this.value,     "status":"R","irems":dispalytabledata[i].irems,"doctype":dispalytabledata[i].doc_type,
						"version":dispalytabledata[i].version})
			}
		}
		
		  
		});
	if(list.length>0){
		var user_id= '<%=uid%>';
	    $.ajax({
	    	
	        type: "POST",
	        
	         url : "<%=restURL%>/orcf/recordRemovalApproval", 
	      
	        contentType: "application/json",
	        
	 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
	        data: JSON.stringify({list:list,
	        	modifiedBy:user_id
	        	
	        	}),
	        	datType : "json",
	       
	 		success : function(data) 
	 		{
	 			if(data.key==200){
	 				 $("#result").text("Request reject successfully").css("color", "green");
	 				setTimeout(function(){ 
	 	        		window.location.reload();
	 	        	
	 	       	}, 2000); 
	 			}
	 			
	 		}
		});
		
		
	}else{
		alert("Select Record")
	}
	 
}


$(function() {
	$("#loadingImage").hide();
	$('#myTable').hide();
	initial_load();

	$('#example-select-all').on('click', function(){
	 
	    if($('#example-select-all').prop('checked')==true){
	    	$('input[type="checkbox"]').prop('checked', true);
	    }else{
	    	$('input[type="checkbox"]').prop('checked', false);
	    }
	    
	 });
	$('#requestcls').on('click', function(){
		 
	    if($('#example-select-all').prop('checked')==true){
	    	$('input[type="checkbox"]').prop('checked', true);
	    }else{
	    	$('input[type="checkbox"]').prop('checked', false);
	    }
	    
	 });
	 
	

	 
});



$(document).mousemove(function(event){
	  InitializeTimer();
});

function initial_load()
	{
	
	setHeader('recordremovalrequests.jsp');
	setHeaderText('Record Removal Requests','Record Management','dashboard.jsp?removalRequest=true');
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
                <h4 style="color: #0a68b4;">Record Removal Requests</h4>
				<hr>
				<div>
-This tool will provide Admins with the current User Record Removal Requests.<br>
&nbsp Admins will need to select & Approve or Reject in order to remove the requests.<br>
&nbsp&nbsp  Information Provided:(Request Date,&nbsp Request By,&nbsp iREMS#,&nbsp Document Type,&nbsp Version,&nbsp Date Uploaded,&nbsp Record Originator,&nbsp Description of Problem)
							
</div><br>
							
				<div class="upload-dates col-sm-12">
				<div >
				<span id="result" style="color:red"></span></div>
				<br>
				</div>
               
                
                 </div>
                 <br>
                  <br>
                <div class='row' style="width: 100%">
                <div class="table-data">
                <div id="uploadandremove" style="text-align: left;   margin-bottom: 20px;"class="upload-remove-buttons">
                        <button type="button" onclick="acceptRequet()" class="btn btn-success"><i class="fa fa-upload" aria-hidden="true"></i> Approve </button>
                        <button id="reset_btn" onclick="rejectRequet()" type="button" class="btn" style="color:#fff !important;border color:#ff9900 !important;background-color:#ff9900 !important;" ><i class="fa fa-trash" aria-hidden="true"></i> Reject</button>
                    </div>
                    <table id="myTable" class="table table-bordered">
                        <thead>
                           <tr>
                          <th><input type="checkbox" class="select_all" value="1" id="example-select-all"></th>
                                <th>Request Date </th>
                                <th>Request By</th>
                                <th>iREMS #</th>
                                <th>Document Type</th>
                                <th>Version</th>
                                <th>Date Uploaded</th>
                                <th>Record Originator</th>
                                <th>Description</th>
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
