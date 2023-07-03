<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purge Records</title>
<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/app.css"></link>
<!-- Include the Sidr JS -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" />
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.4.2/css/buttons.dataTables.min.css">

<script src="js/jQuery/1.11.3/jquery.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 
<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>

				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js">
	</script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.flash.min.js">
	</script>
	<script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js">
	</script>
	<script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js">
	</script>
	<script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js">
	</script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.html5.min.js">
	</script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.print.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" />
<script src="js/jquery.popupoverlay.js"></script>
<script src="js/jquery.sidr.min.js"></script>
<style>
.borderRect {
	border: 1px solid #444;
}
.p-all20 { padding: 20px; }
#propertyDetails td {
	font-size: 16px;
	    padding: 10px;
}
.workingArea {
    border: 0px solid #867171 !important;    
    box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.9) !important;
}
 .btnPropty.active,.btnPropty:focus,.btnPropty:hover{
       border: 2px solid #ff9800 !important;
       } 
       .current {
    color:#900;
   background:#bbb; 
     
}
.lablestyle {
   
    float: left !important;
    margin-top: 12px !important;
}
      .btnPropty.active{
       border: 2px solid #ff9800 !important;
       }
	.btnPropty{
     background: transparent; 
    cursor:default !important;
    padding: 10px 0px;
    margin-right: 60px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: -2px 3px 4px #ccc;
    margin-bottom: 20px;
    width: 280px;
	}
	#fg .form-group {
    margin-bottom: 15px !important;
}
#fb .form-control{
padding:5px !important;
}
input[type="search"] {
    -webkit-appearance: none;
    padding: 5px !important;
}

body #sidr{

 width:21% !important;
 position: absolute !important;
  left: -90px !important;
}

.applicationMainContentAreaContainer { position: relative; }
	table.dataTable thead th {
	    background-color: #7098CC;
	    color: #fff;
	}
</style>
     </script>
    <% String appuserrole = (String)request.getSession().getAttribute("appuserrole");
       System.out.println("appuserrole "+appuserrole);
	   int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
	   String sessionid = request.getSession().getAttribute("sessionid").toString();
	   int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
	   String userName = request.getSession().getAttribute("username").toString();
	   javax.naming.Context ctx = 	new javax.naming.InitialContext();
		String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");

   %>
	<script type="text/javascript">
	 $(document).ready(function(){
		 var array_of_li =  document.querySelectorAll("ul.tab-nav li");
		
			for (var i = 0; i < array_of_li.length; i++) {
			if(i == 2){
				array_of_li[i].setAttribute("class", "active");	
			}			
			}
	     initial_load();
	     showListOFFiles();
	 	$("#tableStyle1").hide();
	 	$("#searchResults").hide();
	 	
	     
	   });
	 </script>
	  <script>
	 
	  function initial_load() {
		  
		  setHeader('purgeRecord.jsp');
		    $('#simple-menu').sidr();
			  $('.child').hide();
			  $('.parent').click(function() {
// 				 $('.child').slideUp();
// 				 $(this).find('ul').slideToggle();
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
			  $("#adminWizardLi").collapse('toggle'); 
		}

  	function showListOFFiles(){
  		var companyId = '<%=cid%>';
  	 	$.ajax({
  	 		  type : "GET",
  	 		  contentType : "application/json",
  	 		  url : "<%=restURL%>/orcf/getFHANumberStatusCount?companyId="+companyId,
  	 		  dataType : 'json',
  	 		  timeout : 100000,
  	 		  success : function(data) {
  	 		 	$("#activePropertyCount").append("<b>"+data.ACTIVEPROPERTYCOUNT+"</b> Properties");
  	 		 	$("#inactivePropertyCount").append("<b>"+data.INACTIVEPROPERTYCOUNT+"</b> Properties");
  	 		 		
  	 		
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
  		$("#fhaNumber").val('');
  		$("#roleNameVal").val('');
  		$("#startDate").val('');
  		$("#endDate").val('');
  		$("#propertyStatus").val('');
  	
  	}
  function getStatusResults(status){
	 
	  var companyId = '<%=cid%>';
	  var testData={
			  //"propertyStatus":status,
		  	   
	  }
	  $('#my_popup').popup('show');
	  $('#basic').css("display","block");
	  $.ajax({	 
		  type : "GET",
		  contentType : "application/json",
			url : "<%=restURL%>/orcf/getFHANumberStatusList?status="+status+"&companyId="+companyId,
	      dataType : 'json',
		  timeout : 100000,
		 // data : JSON.stringify(testData),
		  success : function(data) {
			    $('#my_popup').popup('hide');
				$("#searchResults").show();
				$("#welcomeArea").hide();
				 $("#propertyList").empty(); 
				$("#tableStyle1").show();
				//$("#statusTag").empty().append("Active Properties");
				if(status === 'Active')
					{
					$("#statusTag").empty().append("<b> Terminated Loans to be Disposed </b> ");
				}
				else
					{
					$("#statusTag").empty().append("<b> Terminated Loans Disposed </b> ");

					}
						
				if ($.fn.DataTable.isDataTable("#searchResTable")) {
					  $('#searchResTable').DataTable().clear().destroy();
					}
				display(data);
				//var tbl = $("#searchResTable").dataTable();
				
					var msg =null;
					if(status === 'Active')
						{
				 msg=" Terminated Loans to be Disposed ";
						}
					else
						{
				msg=" Terminated Loans Disposed ";
						}
				var tbl = $("#searchResTable").dataTable(
 						 {
 					        dom: 'Bfrtip',
 					      buttons: [ {
							    extend: 'pdfHtml5',
							    text:'Export To PDF',
							    messageTop:msg,
 					             },
 					            {
 								    extend: 'excelHtml5',
 								    text:'Export To Excel',
 								   messageTop:msg,
 					            }]
 						 });
		            
		  },
		  error : function(e) {
		   console.log("ERROR: ", e); 
		  },
		  done : function(e) {
			  tbl.fnClearTable(this);
		  }
		 
		 });
  }
  	function clearResults(){
  		$("#tableStyle1").hide();
  	}

  	function getPropertyList(){
  		var isAvailble = true;
	    var message="Enter the values for  parameters::";
	    if($("#startDate").val().trim() == ""){
	     	  isAvailble= false;
	     	  message += "Start Date,";
	      }
	    if($("#endDate").val().trim() == ""){
	     	  isAvailble= false;
	     	  message += "End Date,";
	      }
	    if(isAvailble == true){
	    	$("#searchResults").show();
	    	$('#my_popup').popup('show');
	    	$('#basic').css("display","block");
	    	document.getElementById("texterr").innerHTML = "" ;
  		showListOFPropertiesInfo1($("#startDate").val(),$("#endDate").val());
  		
  		
  		
  		
  		
  		
  		function showListOFPropertiesInfo1(startdate,enddate){
  			
  			var companyId = '<%=cid%>';
  			$.ajax({
  		 		  type : "GET",
  		 		  contentType : "application/json",
  		 		  url : "<%=restURL%>/orcf/getFHANumberPurgedCount?startDate="+startdate+"&endDate="+enddate+"&companyId="+companyId,
  		 		  dataType : 'json',
  		 		  timeout : 100000,
  		 		   
  		 		  success : function(data) {
  		 			$("#propertiesCount").empty().append("Date Range of Report : <b>"+startdate+"-"+enddate+"</b>");
  		 		 	$("#purgedPropertiesCount").empty().append("Number of loans purged : <b>"+data.PURGEDPROPERTIES+"</b> Properties");
  		 		 	$("#purgedPropertiesDocCount").empty().append("Number of records purged  : <b>"+ data.PURGEDDOCPROPERTIES+"</b> Properties");
  		 		 	$("#SchpurgedPropertiesCount").empty().append("Number of loans scheduled to be purged : <b>"+data.SCHPURGEDPROPERTIES+"</b> Properties");
  		 		 	$("#SchpurgedPropertiesDocCount").empty().append("Number of records scheduled to be purged : <b>"+ data.SCHPURGEDDOCPROPERTIES+"</b> Properties");
  		 		 	purgeProp = data.PURGEDPROPERTIES;
  		 		 	purgeDoc = data.PURGEDDOCPROPERTIES;
  		 		 	schpurg = data.SCHPURGEDPROPERTIES;
  		 		 	schpurgDoc = data.SCHPURGEDDOCPROPERTIES;
  		 		 	console.log("data.PURGEDDOCPROPERTIES:"+data.PURGEDDOCPROPERTIES+"data.SCHPURGEDPROPERTIES:"+data.SCHPURGEDPROPERTIES+"data.SCHPURGEDDOCPROPERTIES:"+data.SCHPURGEDDOCPROPERTIES);
  		 		 	console.log("purgeDoc:"+purgeDoc+"schpurg:"+schpurg+"schpurgDoc:"+schpurgDoc);
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
  		
  		 var companyId = '<%=cid%>';
  		 var userIdvalue='<%=uid%>';
  		 var tbl = '';
  		  var testData={
  				         "propertyId":$("#propertyId").val(),
  				  	     "propertyName":$("#propertyNm").val(),
  				  	     "fhaNumber":$("#fhaNumber").val(),
  				  	      "startDisposDate":$("#startDate").val(),
  				  	     "endDisposDate":$("#endDate").val(),
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
  			  $("#statusTag").empty();
  			  console.log("SUCCESS    : ", data.getPropertyList.length);
  				$("#propertyList").empty();
  				$("#tableStyle1").show();
  				$("#welcomeArea").show();
  				if ($.fn.DataTable.isDataTable("#searchResTable")) {
  					  $('#searchResTable').DataTable().clear().destroy();
  					}
  				display(data);
  				 var htmlDataAppeend = "";
  				 var htmlDataAppeend1 = "";
  				 
  				/*  htmlDataAppeend = htmlDataAppeend+'Date Range Of Report :'+$("#startDate").val()+' To '+$("#endDate").val()+'\n'
			    +'Number of loans purged : '+purgeProp+' Properties '+'\n'
			    +'Number of records purged  : '+ purgeDoc+' Properties '+'\n'
			    +'Number of loans scheduled to be purged : '+schpurg+' Properties '+'\n'
			    +'Number of records scheduled to be purged : '+ schpurgDoc+' Properties'+'\n';  
			    
			 htmlDataAppeend1 = htmlDataAppeend1+'Date Range:'+$("#startDate").val()+' To '+$("#endDate").val()+'<br>'
			    +'Number of loans purged : <b>'+purgeProp+'</b> Properties<br>'
			    +'Number of records purged  : <b>'+ purgeDoc+'</b> Properties<br>'
			    +'Number of loans scheduled to be purged : <b>'+schpurg+'</b> Properties<br>'
			    +'Number of records scheduled to be purged : <b>'+ schpurgDoc+'</b> Properties';
			    console.log("purgeDoc:"+purgeDoc+"schpurg:"+schpurg+"schpurgDoc:"+schpurgDoc); */
  				 
  				var tbl = $("#searchResTable").dataTable(
  						 {
  					        dom: 'Bfrtip',
  					      buttons: [ {
							    extend: 'pdfHtml5',
							    text:'Export To PDF',
							    messageTop: 'Date Range Of Report :'+$("#startDate").val()+' To '+$("#endDate").val()+'\n'
							    +'Number of loans purged : '+purgeProp+' Properties '+'\n'
							    +'Number of records purged  : '+ purgeDoc+' Properties '+'\n'
							    +'Number of loans scheduled to be purged : '+schpurg+' Properties '+'\n'
							    +'Number of records scheduled to be purged : '+ schpurgDoc+' Properties'+'\n'
							   },
							   {
								    extend: 'excelHtml5',
								    text:'Export To Excel',
								    messageTop: 'Date Range Of Report :'+$("#startDate").val()+' To '+$("#endDate").val()+'\n'
								    +'Number of loans purged : '+purgeProp+' Properties '+'\n'
								    +'Number of records purged  : '+ purgeDoc+' Properties '+'\n'
								    +'Number of loans scheduled to be purged : '+schpurg+' Properties '+'\n'
								    +'Number of records scheduled to be purged : '+ schpurgDoc+' Properties'+'\n'
								 },
							   /* {
								   extend: 'csvHtml5',
								    messageTop: 'Date Range Of Report :'+$("#startDate").val()+' To '+$("#endDate").val()
								},  */
								
								  {
				                       extend: 'print',
				                       /* text:  '<h1 style="color:red;"> Print</h1>', */
				                       customize: function ( win ) {
				                           $(win.document.body)
				                               .css( 'font-size', '10pt' )
				                               .prepend(
				                            		   'Date Range:'+$("#startDate").val()+' To '+$("#endDate").val()+'<br>'
				                       			    +'Number of loans purged : <b>'+purgeProp+'</b> Properties<br>'
				                       			    +'Number of records purged  : <b>'+ purgeDoc+'</b> Properties<br>'
				                       			    +'Number of loans scheduled to be purged : <b>'+schpurg+'</b> Properties<br>'
				                       			    +'Number of records scheduled to be purged : <b>'+ schpurgDoc+'</b> Properties'
				                               );
				        
				                           $(win.document.body).find( 'table' )
				                               .addClass( 'compact' )
				                               .css( 'font-size', 'inherit' );
				                       }
				                   } 
			         
  					        ]
  					    } );
  		  },
  		  error : function(e) {
  		   console.log("ERROR: ", e); 
  		  },
  		  done : function(e) {
  			  tbl.fnClearTable(this);
  		  }
  		 
  		 });
  		  }else{
  			/*  alert("280:::::"+!(message.substring(message.length-1)==','));	 */
  			   if(message.substring(message.length-1)==',') {   /* // if(message.endsWith(",")){ */
  				  message = message.substring(0, message.length - 1);
  			  
  			 } 
  			 document.getElementById("texterr").innerHTML = message ;
  	 } 
  		 $('#propertyList').empty();
  		 
  	}
  		
  		
  	function display(data) {
  		
  		    $.each(data.getPropertyList, function(i, item) {
  			  item.propertyStatus == null  ?item.propertyStatus='':item.propertyStatus;
  			   item.fhaNumber =='null' || null ?item.fhaNumber='':item.fhaNumber ==null? item.fhaNumber='':item.fhaNumber;
  			   item.disposalDate =='null' || null ?item.disposalDate='':item.disposalDate ==null? item.disposalDate='':item.disposalDate;
  			$('#propertyList').append('<tr><td>'+item.propertyId+'</td><td>'+item.propertyName+'</td><td><a id="editB" href="#/" onclick="hello12(\''+item.id+'\',\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\',\''+item.loanAmount+'\',\''+item.lenderName+'\',\''+item.closingDate+'\',\''+item.loanStatus+'\');">'+item.fhaNumber+'</a></td><td>'+item.disposalDate+'</td><td id="loanstatus">'+item.loanStatus+'</td></tr>');
  			  // $('#propertyList').append('<tr><td><a id="editB" href="#" onclick="hello(\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');" href="#myModal">'+item.propertyName+'</a></td><td><a id="editB" href="#" onclick="hello(\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');">'+item.propertyId+'</a></td><td><a id="editB" href="#" onclick="hello12(\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\',\''+item.loanAmount+'\',\''+item.lenderName+'\',\''+item.closingDate+'\',\''+item.propertyStatus+'\');">'+item.fhaNumber+'</a></td><td>'+item.city+'</td><td>'+item.state+'</td><td>'+item.zip+'</td><td>'+item.loanType+'</td><td>'+item.propertyStatus+'</td></tr>');

  		
  		});
  	}
  	
  	 var purgeProp =0;
	  var purgeDoc = 0;
	  var schpurg = 0;
	  var schpurgDoc = 0;
	function showListOFPropertiesInfo(startdate,enddate){
		
		var companyId = '<%=cid%>';
		$.ajax({
	 		  type : "GET",
	 		  contentType : "application/json",
	 		  url : "<%=restURL%>/orcf/getFHANumberPurgedCount?startDate="+startdate+"&endDate="+enddate+"&companyId="+companyId,
	 		  dataType : 'json',
	 		  timeout : 100000,
	 		   
	 		  success : function(data) {
	 			$("#propertiesCount").empty().append("Date Range of Report : <b>"+startdate+"-"+enddate+"</b>");
	 		 	$("#purgedPropertiesCount").empty().append("Number of loans purged : <b>"+data.PURGEDPROPERTIES+"</b> Properties");
	 		 	$("#purgedPropertiesDocCount").empty().append("Number of records purged  : <b>"+ data.PURGEDDOCPROPERTIES+"</b> Properties");
	 		 	$("#SchpurgedPropertiesCount").empty().append("Number of loans scheduled to be purged : <b>"+data.SCHPURGEDPROPERTIES+"</b> Properties");
	 		 	$("#SchpurgedPropertiesDocCount").empty().append("Number of records scheduled to be purged : <b>"+ data.SCHPURGEDDOCPROPERTIES+"</b> Properties");
	 		 	purgeProp = data.PURGEDPROPERTIES;
	 		 	purgeDoc = data.PURGEDDOCPROPERTIES;
	 		 	schpurg = data.SCHPURGEDPROPERTIES;
	 		 	schpurgDoc = data.SCHPURGEDDOCPROPERTIES;
	 		 	console.log("data.PURGEDDOCPROPERTIES:"+data.PURGEDDOCPROPERTIES+"data.SCHPURGEDPROPERTIES:"+data.SCHPURGEDPROPERTIES+"data.SCHPURGEDDOCPROPERTIES:"+data.SCHPURGEDDOCPROPERTIES);
	 		 	console.log("purgeDoc:"+purgeDoc+"schpurg:"+schpurg+"schpurgDoc:"+schpurgDoc);
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

  	function hello( folderName,propertyId,propertyName,fhaNumber,loanType){
  		//alert("folderName"+folderName);
  		if(folderName != '/Legacy Data/'){
  	    var randomnumber = Math.floor((Math.random()*100)+1); 
  	    window.open("propertyDataSearch.jsp?propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=1000,height=500');
  	    
  		}
  		else
  			{
  			//alert("this property having legacy folder");
  			$("#myModal1").modal("show");	
  		
  			} 
  	}

  	function hello12(folderName,propertyId,propertyName,fhaNumber,loanType,loanAmt,lenderName,closingDate,status){
 		

  		 $.ajax({	 
  			  type : "GET",
  			  contentType : "application/json",
  				url : "<%=restURL%>/orcf/getFolderData?id="+folderName,
  		      dataType : 'json',
  			  timeout : 100000,
  			   success : function(data) {
  				 //  alert(data.folderName)
//  		  		alert("folderName12"+folderName);
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
/* 
          $( function() {
                $( "#startDate" ).datepicker();
            } );
		  $( function() {
			    $( "#endDate" ).datepicker();
			  } ); */
			  
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
</head>
<body>
<section>
			<div  class="borderRect p-all20" >
				<div class="container-fluid" id="fg">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						 <div class="row">
							<div style="text-align: left;">
								<label><h5 ><b style="color: #0a68b4;margin-right:535px">Records Retention Purge Forecast</b></h5></label>&nbsp&nbsp
								<label style="padding:0px 0px;background:none;border:none;text-decoration:underline"><h5 ><b ><a href="retensionSchedule.jsp">Edit Archive</a></b></h5></label>&nbsp&nbsp
								
							</div>
							</div>
							
				   	     <div>
						  <button class="btnPropty" onclick="getStatusResults('Active')">&nbsp;&nbsp;&nbsp;&nbsp;<b>Terminated Loans to be Disposed - </b>&nbsp;&nbsp;&nbsp;&nbsp;<div id="activePropertyCount"></div>  </button>
							  <button class="btnPropty"  onclick="getStatusResults('InActive')" style="float:right;">&nbsp;&nbsp;&nbsp;&nbsp;<b>Terminated Loans Disposed -</b>&nbsp;&nbsp;&nbsp;&nbsp;<div id="inactivePropertyCount"></div>  </button>
							</div>
							<br>
							<br>
							              <div class="form-group">
							              <div style="text-align: center;" id="tagscloud">
										<span id="texterr" style="color: red;"></span>
									     </div>
							              <div class="row">
							             	<div class="col-lg-offset-1 col-lg-2 col-md-3 col-sm-3 col-xs-3">
											<label class="control-label lablestyle">Date Range <span class="requiredStar">*</span></label>
											</div>
											<div class="col-sm-8 posiRelavtive" style="padding:0px">
												<div class="">
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
													<!-- 	<label class="control-label col-sm-12 lablestyle">Start</label> -->
                                                         
														 <input id="startDate"  type="text" class="form-control col-sm-12 inputStyle1" placeholder="StartDate" style=width: 100%" >
												
													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
<!-- 														<label class="control-label col-sm-12 lablestyle">End</label>
 -->											  			<input id="endDate" type="text" class="form-control col-sm-12 inputStyle1" placeholder="EndDate" style=width: 100%">
											
													</div>
													
													
													
												</div>
												</div>
<!-- 												<span id="textErr" style='color: red;'></span>
 -->												</div>
										</div>
										<div class="" >
										<div class="form-group">
										<div class="row">
										<div class="col-lg-offset-1 col-lg-2 col-md-3 col-sm-3 col-xs-3">
											<label class="control-label  lablestyle" >Property ID</label>
											</div>
											<div class="col-sm-8 posiRelavtive">
											<!--   <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="propertyId" type="search" class="form-control inputStyle" placeholder="Search">-->
											    <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="propertyId" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										</div>
						</div>
						<div class="form-group">
						<div class="row">
							<div class="col-lg-offset-1 col-lg-2 col-md-3 col-sm-3 col-xs-3">
											<label class="control-label  lablestyle">Property Name</label>
											</div>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="propertyNm" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
											</div>
										</div>
										<div class="form-group">
										<div class="row">
										<div class="col-lg-offset-1 col-lg-2 col-md-3 col-sm-3 col-xs-3">
											<label class="control-label  lablestyle">FHA Number</label>
											</div>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="fhaNumber" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">		
										<br />
										<button class="btn btn-success waves-effect waves-button waves-float f-family center-block" onclick="javascript:getPropertyList();"><i class="fa fa-check"></i>Search</button>
										<button class="btn btn-warning waves-effect waves-button waves-float f-family center-block" onclick="javascript:clearFields();"><i class="fa fa-close"></i>  Reset</button>		
										<br />
										
										
																
									</div>
					</div>
				</div>
			</div>
			</div>
			<br />
			
			<!-- <div id="my_popup">
				<div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em;  display: none; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
			    <h4><i class="zmdi_large zmdi-settings zmdi-hc-spin"></i> Loading Contents...Please Wait...</h4>
			    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;It will take few seconds.</p>
			    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;Please wait while the contents are loading.</p>
			    
				</div>
	
             </div> -->
			
			<div id="my_popup">
				<div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em;  display: none; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
			    <h4><i class="zmdi_large zmdi-settings zmdi-hc-spin"></i> Loading Contents...Please Wait...</h4>
			    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;It will take few seconds.</p>
			    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;Please wait while the contents are loading.</p>
			    
				</div>
	
             </div>
			<!-- <div id="myDiv"  class="borderRect p-all20">
				<div class="container-fluid">
					<div class="row">
						
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 propertysearchForm">
							
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding-right:20px;">
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
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding-left:20px;">
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">FHA Number</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="fhaNumber" type="search" class="form-control inputStyle" placeholder="Search">
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
											  <select id="loanType" class="selectArea width100per"> multiple
											  	<option value="" selected disabled>Select Type of Search</option>
												<option>241a</option>								
												<option>223a7</option>								
												<option>232i</option>
												<option>223f</option>	
												<option>232nc</option>
												<option>223d</option>									
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
														<label class="control-label col-sm-12 lablestyle">Start</label>
                                                         
														 <input id="startDate"  type="text" class="form-control col-sm-12 inputStyle1" placeholder="Start" style=width: 100%" >
												
													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<label class="control-label col-sm-12 lablestyle">End</label>
											  			<input id="endDate" type="text" class="form-control col-sm-12 inputStyle1" placeholder="End" style=width: 100%">
											
													</div>
												</div>
												
												</div>
										</div>	
										
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Property Status</label>
											<div class="col-sm-8 posiRelavtive">
											  <select id="propertyStatus" class="selectArea width100per"> multiple
											  	<option value="" selected disabled>All</option>
												<option>Ative</option>								
												<option>Inactive</option>								
																				
											  </select>
											</div>
										</div>	
										
									</div>	
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">		
										<br />
										<button class="btn btn-success waves-effect waves-button waves-float f-family center-block" onclick="javascript:getSeearchResultsList();"><i class="fa fa-check"></i>Search</button>
										<button class="btn btn-warning waves-effect waves-button waves-float f-family center-block" onclick="javascript:clearFields();"><i class="fa fa-close"></i>  Reset</button>		
										<br />							
									</div>
								</div>
						</div>
						
					</div>
				</div>
			</div> -->
			<br />
			<!-- Search Resulis  -->
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
										<div style="text-align: center;">
								<label><h5><Span id="statusTag" style="color: #0a68b4;"><b style="color: #0a68b4;"></b></Span></h5></label>&nbsp&nbsp
							</div>
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			                    <div id="tableStyle1" >
			                    
			                    <div id="welcomeArea" class="borderAll">
				<div  class="container-fluid">
					<div class="row">
						
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
							<br />
							
							<table class="pull-left">
							<tr>
							<td><p id ="propertiesCount" class="text-capitalize"></p></td>
						
							</tr>
							<tr>
							<td><p id ="purgedPropertiesCount"  class="text-capitalize">	Number of loans purged : </p></td>
							
							</tr>
							
							<tr>
							<td><p id ="purgedPropertiesDocCount" class="text-capitalize">	Number of records purged  :  </p></td>
							
							</tr>
							
							</table>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 pull-right">
						<br/>
						<br/>
							<div class="pull-right">
					
							<div>
								<table class="pull-left">
							<tr>
							<td><p id ="SchpurgedPropertiesCount" class="text-capitalize">	Number of loans scheduled to be purged :  </p></td>
						
							</tr>
							<tr>
							<td><p id ="SchpurgedPropertiesDocCount"  class="text-capitalize"> Number of records scheduled to be purged :</p></td>
							
							</tr>
							
							
							
							</table>
							</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
									<div class="table-responsive">
										
										<table id="searchResTable" class="table table-bordered">
										   
											<thead>
											<tr>
												<tr>
													<th>Property ID</th>
													<th>Property Name</th>
													<th>Associated FHA Numberr</th>
													<th>Disposal Date</th>
													<th>Property Status</th>
												</tr>
											</thead>
											<tbody id="propertyList">
											    
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
			
			<div id ="checkTableHeader"></div>
		</section>
</body>
</html>