<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script type="text/javascript" src="js/jquery-1.3.2.js" ></script>
 <script src="js/jQuery/1.11.3/jquery.min.js"></script>  -->
<title>Edit Archive</title>

    <link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/app.css"></link>
<!-- Include the Sidr JS -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" />
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="js/jQuery/1.11.3/jquery.min.js"></script> 
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 
		
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> 
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
	     getFhaNumbers();
	     getLoanTypes();
	     initial_load();
	 	//$("#searchResults").hide();
	   });
	 </script>
	 <script type="text/javascript">
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
	 
	 
	 
	 </script>
	  <script>
	  function initial_load() {
		  setHeader('retensionSchedule.jsp');
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
			//alert("hiii");
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
			// $('#adminWizardLi').click();
			
			  $("#adminWizardLi").collapse('toggle'); 
			  /* setHeader('retensionSchedule.jsp');
		      $('#simple-menu').sidr();
			  $('.child').hide();
			  $('.parent').click(function() {
				 $('.child').slideUp();
				 $(this).find('ul').slideToggle();
			  });
			  $("#adminWizardLi").collapse('toggle');  */
			
			
		}
	    
          $( function() {
                $( "#startDate" ).datepicker();
            } );
		  $( function() {
			    $( "#endDate" ).datepicker();
			  } );
      </script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
	 
	 <script type="text/javascript">
	 
	          function showForm(){
	        	  $('#myDiv').show(); 
	        	  $('#searchResults').hide();
	          }
	          
	          
	           function getFhaNumbers(){
	        	   $('#my_popup').popup('show');
	        	   $('#basic').css("display","block");
	        	   $('#myDiv').hide();  
	        	   $('#searchResults').hide();
	        	   var companyIdValue= '<%= cid %>';
	        		$.ajax({
	        			type : "GET",
	        			contentType : "application/json",
	        			url : "<%=restURL%>/orcf/getFHANumbers?companyId="+companyIdValue,
	        			dataType : 'json',
	        			timeout : 100000,
	        			success : function(data) {
	        				 $('#my_popup').popup('hide');
	        				console.log("SUCCESS: ", data);
	        				for(i=0;i<data.response.length;i++){
	        				       $("#selectFHA").append("<option value='"+data.response[i].fhaNumber+"'><b>"+data.response[i].fhaNumber+"</b></option>");
	        				       
	        				      } 
	        			},
	        			error : function(e) {
	        				console.log("ERROR: ", e);
	        				//displayModules(e);
	        			},
	        			done : function(e) {
	        				console.log("DONE");
	        			}
	        		});
	           }
	 
	 
	 </script>
	 
	 <script type="text/javascript">
	 function clearFields(){
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
	 
	 </script>
	 
	 <script type="text/javascript">
	    function getSeearchResultsList(){
	    	 $('#my_popup').popup('show');
	    	 $("#searchResults").show();
	    	  $('#basic').css("display","block");
	    	var companyId = '<%=cid%>';
	   	    var userIdvalue='<%=uid%>';
	   	    var testData={
	   			         "propertyId":$("#propertyId").val(),
	   			  	     "propertyName":$("#propertyNm").val(),
	   			  	     "city":$("#city").val(),
	   			  	     "state":$("#state").val(),
	   			  	     "zip":$("#zip").val(),
	   			  	     "fhaNumber":$("#fhaNumber").val(),
	   			  	     "loanType":$("#roleNameVal").val(),
	   			  	     "loanAmount":$("#loanAmt").val(),
	   			  	     "lenderName":$("#lenderNm").val(),
	   			  	     "startDate":$("#startDate").val(),
	   			  	     "endDate":$("#endDate").val(),
	   			  	      "propertyStatus":$("#propertyStatus").val(),
	   			  	     "loanTypeData":$("#loanType").val(),			  	     
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
	   		   
	   		    if ($.fn.DataTable.isDataTable("#searchResTable")) {
	   		      $('#searchResTable').DataTable().clear().destroy();
	   		    } 
	   		    
	   			display(data);
	   			
	   			$("#searchResTable").dataTable();
	   	  },
	   	  error : function(e) {
	   	   console.log("ERROR: ", e);
	   	       
	   	  },
	   	  done : function(e) {
	   		 
	   		 
	   	  }
	   	 
	   	 }); 
	   	 $("#propertyList").empty(); 
	   	    
	   	    
	    }
	 
	 </script>
   
     <script type="text/javascript">
        function clearResults(){
    		
    		$("#propertyList").empty();
    		 if ($.fn.DataTable.isDataTable("#searchResTable")) {
			      $('#searchResTable').DataTable().clear().destroy();
			    } 
    	}
     
     
        function getFhaNumberResult(){
        	 
        	 $('#my_popup').popup('show');
	    	  $('#basic').css("display","block");
	    	  $('#searchResults').show();
        	var x=document.getElementById("selectFHA");
       	    for (var i = 0; i < x.options.length; i++) {
                if(x.options[i].selected ==true){
                   var fhaNumber=x.options[i].value;
                 }
           }
       	 var isAvailble=true;
       	 var message=" Select the ";
       	 if(fhaNumber=="Search"){
    		 
    		 isAvailble=false;
    		 message += "Fha  Number "; 
    	 }
    	
       	  var companyId = '<%=cid%>';
    	  var userIdvalue='<%=uid%>';
    	  if(isAvailble == true){
    	  var testData={
			  	     "fhaNumber":fhaNumber,
			  	     "companyId":companyId
	      };
    		 $.ajax({
    		  type : "POST",
    		  contentType : "application/json",
    		  url : "<%=restURL%>/orcf/getFHANumbersResults",
    	      dataType : 'json',
    		  timeout : 100000,
    		  data : JSON.stringify(testData),
    		  success : function(data) {
    			  $("#propertyList").empty();
    			  $('#my_popup').popup('hide');
    	    	  console.log("300:::"+JSON.stringify(data));
    			   if ($.fn.DataTable.isDataTable("#searchResTable")) {
    			      $('#searchResTable').DataTable().clear().destroy();
    			    } 
    			  display(data);
    			  $("#searchResTable").dataTable();
    		  },
    		  error : function(e) {
    		   console.log("ERROR: ", e);
    		       
    		  },
    		  done : function(e) {
    			 
    			  
    		  }
    		 
    		 });
    	  }else{
    			alert("Please:"+message);
    	  }
     }
     
     </script>
     
     <script type="text/javascript">
     function display(data) {
    	 $("#propertyList").empty();	
 	    $.each(data.getPropertyList, function(i, item) {
 	    	 item.city=='null'|| null ?item.city='':item.city == null ? item.city='':item.city;
 			   item.state=='null' || null ?item.state='':item.state;
 			   item.terminationDate =='null' || null ?item.terminationDate='':item.terminationDate ==null? item.terminationDate='':item.terminationDate;
 			   item.disposalDate =='null' || null ?item.disposalDate='':item.disposalDate ==null? item.disposalDate='':item.disposalDate;
 			   item.propertyStatus == null  ?item.propertyStatus='':item.propertyStatus;
 		   // alert("284::"+item.disposalDate);
 		$('#propertyList').append('<tr><td>'+item.propertyId+'</td><td>'+item.propertyName+'</td><td><a id="editB" href="#" onclick="hello12(\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\',\''+item.loanAmount+'\',\''+item.lenderName+'\',\''+item.closingDate+'\',\''+item.propertyStatus+'\',\''+item.setDate+'\',\''+item.loanDataId+'\',\''+item.disposalDate+'\',\''+item.terminationDate+'\');">'+item.fhaNumber+'</a></td><td>'+item.city+'</td><td>'+item.state+'</td><td>'+item.disposalDate+'</td><td>'+item.terminationDate+'</td><td>'+item.loanType+'</td><td>'+item.propertyStatus+'</td></tr>');
 		
 	
 	});
 }
     </script>
     <script type="text/javascript">
     function hello12(propertyId,propertyName,fhaNumber,loanType,loanAmt,lenderName,closingDate,status,setDate,loanDataId,disposalDate,terminationDate){
    		    var res = propertyId;
    		    var terminationDate1="";
    		    var disposalDate1="";
    		    var randomnumber = Math.floor((Math.random()*100)+1); 
    			var companyId = '<%=cid%>';
    	   	    var userIdvalue='<%=uid%>';
    	   	    var testData={
    				 "fhaNumber":fhaNumber,
    				 "companyId":companyId,
    				 "propertyId":propertyId
    				
    		    }
    	   	 $.ajax({
    				type : "POST",
    				contentType : "application/json",
    				url : "<%=restURL%>/orcf/getFHAPROPResults",
    				dataType : 'json',
    				timeout : 100000,
    				data : JSON.stringify(testData),
    				success : function(data) {
    					$.each(data.getPropertyList, function(i, item) {
    						if(item.terminationDate=="null"){
    							alert("Please Update Your Termination Date");
    						}else{
    						 terminationDate1=item.terminationDate;
    						 disposalDate1=item.disposalDate;
    						 window.open("retensionSearch.jsp?result="+res+"&propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType+"&loanAmt="+loanAmt+"&lenderName="+lenderName+"&closingDate="+closingDate+"&status="+status+"&setDate="+setDate+"&loanDataId="+loanDataId+"&termiationDate="+terminationDate1+"&disposalDate="+disposalDate1,"_blank",'PopUp'+randomnumber+',scrollbars=1,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=0,resizable=1,width=850,height=650');
    						}
    					});
    				},
    				error : function(e) {
    					console.log("ERROR: ", e);
    					
    			     	
    				},
    				done : function(e) {
    					console.log("DONE");
    				}
    			});
    	   	   
    		 //   window.open("retensionSearch.jsp?result="+res+"&propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType+"&loanAmt="+loanAmt+"&lenderName="+lenderName+"&closingDate="+closingDate+"&status="+status+"&setDate="+setDate,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=850,height=500'); 
    		// window.open("retensionSearch.jsp?result="+res+"&propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType+"&loanAmt="+loanAmt+"&lenderName="+lenderName+"&closingDate="+closingDate+"&status="+status+"&setDate="+setDate+"&loanDataId="+loanDataId+"&termiationDate="+terminationDate1+"&disposalDate="+disposalDate1,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=850,height=800');
    	}
     
     </script>
</head>
<body>


<section>
		<!--- Part1 ---->
			<!-- <div class="borderRect">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="text-center">
								<br /><h3 class="f-family nopadding"><b>Retension Schedule</b></h3><br />
							</div>
						</div>
					</div>
				</div>
			</div>
			<br /><br /> -->
			<div class="borderRect p-all20">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="text-center">
								<label><h5 ><b>Select FHA Number From the List</b></h5></label>&nbsp&nbsp
								<select id="selectFHA" class="selectArea" onchange="getFhaNumberResult();">
									<option  selected>Search</option>								
									<!-- <option value="document">Document Search</option> -->							
								</select>
								<div><h5 class="text-center f-family">OR</h5></div>
								<br>
								<div class="text-center f-family"><b>Search for FHA Number</b>&emsp;&emsp;
									<button class="btn btn-success waves-effect waves-button waves-float f-family center-block" style="" onclick="showForm()"><i class="fa fa-check"></i>  Search</button>
							</div><br>
							
							</div>
						</div>
					</div>
				</div>
			</div>
			<br />
			
			<div id="my_popup">
				<div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em;  display: none; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
			    <h4><i class="zmdi_large zmdi-settings zmdi-hc-spin"></i> Loading Contents...Please Wait...</h4>
			    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;It will take few seconds.</p>
			    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;Please wait while the contents are loading.</p>
			    
				</div>
	
             </div>
			
			<div id="myDiv"  class="borderRect p-all20">
				<div class="container-fluid">
					<div class="row">
						
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
			</div>
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
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			                    <div id="tableStyle1" >
			
									<div class="table-responsive">
										
										<table id="searchResTable" class="table table-bordered">
											<thead>
												<tr>
												    <th>Property ID</th>
													<th>Property Name</th>
													<th>Associated FHA Numberr</th>
													<th>City</th>
													<th>State</th>
													<th>Disposal Date</th>
													<th>Termination Date</th>
													<th>Type of Loan</th>
													<th>Property Status</th>
												</tr>
											</thead>
											<tbody id="propertyList">
												<!-- <tr>
													<td class="color-blue"><a data-toggle="modal" data-target="#myModal"> 1</a></td>
													<td class="color-blue"><a data-toggle="modal" data-target="#myModal1">2</a></td>
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
			<!--  Search Results -->
		</section>
		
		<!-- <a type="button" class="btn btn-info btn-lg"  data-toggle="modal" data-target="#myModal"> show1</a>
													<a data-toggle="modal" data-target="#myModal1">show 2</a> -->
		
		<div id="myModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-body">
		        <h3 class="f-family text-left">&nbspProperty Name: Test Property 3</h3>
		        
		        <table id="propertyDetails" align="left">
		        	<tbody>
		        		<tr>
		        			<td>FHA-Number</td>
		        			<td>:</td>
		        			<td>039-98989</td>
		        		</tr>
		        		<tr>
		        			<td>Property ID</td>
		        			<td>:</td>
		        			<td></td>
		        		</tr>
		        		<tr>
		        			<td>Loan Type</td>
		        			<td>:</td>
		        			<td></td>
		        		</tr>
		        		<tr>
		        			<td>Loan Amount</td>
		        			<td>:</td>
		        			<td></td>
		        		</tr>
		        		<tr>
		        			<td>Closing Date</td>
		        			<td>:</td>
		        			<td></td>
		        		</tr>
		        		<tr>
		        			<td>Disposal Date</td>
		        			<td>:</td>
		        			<td></td>
		        		</tr>
		        		<tr>
		        			<td>Lender Name</td>
		        			<td>:</td>
		        			<td></td>
		        		</tr>
		        		<tr>
		        			<td>Property Status</td>
		        			<td>:</td>
		        			<td></td>
		        		</tr>
		        		
		        	</tbody>
		        </table>
		        <div class="clearfix"></div>
		        <div class="row">
		        	<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
		        		<h4 class=""><b><i>
		        	   How long would you like to retain the files <br />assosiated with this loan(years)?
		        		</i></b></h4>
		        	</div>
		        	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
		        	<br />
		        		<input type="number" class="inputStyle" max="20" />
		        	</div>
		        </div>
		      </div>
		      <div class="modal-footer">
		      	<button class="btn btn-success waves-effect waves-button waves-float f-family center-block" onclick="javascript:getPropertyList(this);"><i class="fa fa-check"></i>  Submit</button>
										
		      </div>
		    </div>
		
		  </div>
		</div>				
   
</body>
</html>