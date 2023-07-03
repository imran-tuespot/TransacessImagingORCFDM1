<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.lang.*"%><%@page import="java.util.*"%><%@page
	import="org.apache.commons.lang.StringUtils"%>
	<%@page import="java.text.SimpleDateFormat"%>
	
<jsp:useBean id="folderBean" scope="request"
	class="com.peniel.beans.FolderBean" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Retension Search</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>
<link
	href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" />
<script src="jscript/jquery.easing.js" type="text/javascript"></script>
<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css"
	media="screen" />

<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>
<link
	href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/app.css"></link>
<script src="jscript/jquery.easing.js" type="text/javascript"></script>
<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css"
	media="screen" />

<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<style>
	#propertyDetails{padding:15px;}
	#propertyDetails td{padding:10px;}
	
	table td { 
	border-width: 0px 0px 0px 0px; 
	padding: 2px; 
	border-style: none none none none; 
	border-color: gray gray gray gray; 
	color: #0B3861;
	-moz-border-radius: 0px 0px 0px 0px;
	}
	</style>
<script>
  $( function() {
    $( "#startDate" ).datepicker();
  } );
  $( function() {
	    $( "#endDate" ).datepicker();
	  } );
  </script>
  
  
<%
	String appuserrole = (String) request.getSession().getAttribute(
			"appuserrole");
	System.out.println("appuserrole " + appuserrole);
	int uid = Integer.parseInt(request.getSession()
			.getAttribute("userid").toString());
	String sessionid = request.getSession().getAttribute("sessionid")
			.toString();
	int cid = Integer.parseInt(request.getSession()
			.getAttribute("comid").toString());
	String userName = request.getSession().getAttribute("username")
			.toString();
	

	String propertyId = "";
	String propertyName = "";
	String fhaNumber = "";
	String loanType = "";
	String loanAmt = "";
	String lenderName = "";
	String closingDate = "";
	String status = "";
	String result = "";
    String setDate="";
    String loanDataIdvalue="";
    String disposalDateShow=null;
    String terminationDate="";
    String msg="";
	propertyId = request.getParameter("propertyId");
	propertyName = request.getParameter("propertyName");
	fhaNumber = request.getParameter("fhaNumber");
	loanType = request.getParameter("loanType");
	loanAmt = request.getParameter("loanAmt");
	lenderName = request.getParameter("lenderName");
	closingDate = request.getParameter("closingDate");
	terminationDate=request.getParameter("termiationDate");
	setDate=request.getParameter("setDate");
	status = request.getParameter("status");
	result = request.getParameter("result");
	loanDataIdvalue=request.getParameter("loanDataId");
	disposalDateShow=request.getParameter("disposalDate");
	System.out.println("disposalDateShow123::::"+disposalDateShow);
	System.out.println((disposalDateShow.length())+"---------------"+(disposalDateShow.equals("null")));
	if(disposalDateShow.equals("null")){
		msg="Date Not Set";
	}else{
		msg=disposalDateShow;
	}
	
	/* if(disposalDateShow!=null){
		msg=disposalDateShow;
	}else{
		System.out.println("disposalDateShow::::"+disposalDateShow);
		msg="Date Not Set";
	} */
    String[] years=terminationDate.split("/");
    int mm=Integer.parseInt(years[0]);
    int dd=Integer.parseInt(years[1]);
    int year=Integer.parseInt(years[2]);
	if (!StringUtils.isEmpty(result)) {
		propertyId = result.replace("/", " > ");

	} else {
		result = propertyId;
	}
	String folderPatteren = request.getSession()
			.getAttribute("folderPatterens").toString();
	System.out.println("folderPatteren--->"
			+ folderPatteren.replaceAll("\\[|\\]", ""));

	javax.naming.Context ctx = new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
%>

<script type="text/javascript">
  $(document).ready(function(){
	  setHeader('retensionSearch.jsp');
	  $(".headPageContainer").hide();
	  $(".userInformaiton").hide();	
	  $(".mainBlueHeading").hide();
	  $('#show2').hide();
	  $("#showsuccessmsg").hide();
	  for(i=1;i<=30;i++){
	       $("#selectCount").append("<option value='"+i+"'><b>"+i+"</b></option>");
	   }
	 
  });
  </script>

<script type="text/javascript">
     function setDisposaldate(){
    	 var x=document.getElementById("selectCount");
 	     for (var i = 0; i < x.options.length; i++) {
          if(x.options[i].selected ==true){
             var yearCount=x.options[i].value;
           }
        }
 	    
 	     if(yearCount == "Select"){
 	    	 alert("Please Select Number of Years");
 	     }else{
    	// $('#show2').show();
    	// $('#show1').hide();
    	var year=<%=year%>;
    	var disposaldate=parseInt(year)+parseInt(yearCount);
    	var date=<%=dd%>;
    	var month=<%=mm%>;
    	var finalValue=month+"/"+date+"/"+disposaldate;
    	$( "#diaposaldate" ).empty();
    	$("#diaposaldate").append("<h4>"+finalValue+"</h4>");
    	popupWindow(finalValue);
 	     }
     }
  
     
     function cancelWindow(){
    	  window.close();
     }
     
    
  </script>
  <script type="text/javascript">
   function popupWindow(finalValues){
	    var r = confirm("Please Confirm that the  Disposal Date '"+finalValues+"' is correct or not?");
	    if (r == true) {
	    	confirmDate();
	    } else {
	       
	    }
	  
	   
   } 
</script>
  <script type="text/javascript">
  
  function cancelDate(){
	  $('#show2').hide();
 	 $('#show1').show();
 	 $('#showsuccessmsg').hide();
 	
  }
  
  
 function confirmDate(){
	 var userId='<%=uid%>';
	 var closingDate = document.getElementById('diaposaldate').innerText;
	 var loanDataId='<%=loanDataIdvalue%>';
	 var testData={
			 "userId":userId,
			 "closingDate":closingDate,
			 "loanDataId":loanDataId
		};
	// alert("139:::"+JSON.stringify(testData));
	  $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/updateLoanData",
			dataType : 'json',
			timeout : 100000,
			data : JSON.stringify(testData),
			success : function(data) {
				 $('#showsuccessmsg').show();
				 document.getElementById("buttonConf1").disabled = true;
			},
			error : function(e) {
				
				alert("151");
		     	
			},
			done : function(e) {
				console.log("DONE");
			}
		}); 
 }

</script>
</head>


<body>

<div id="showsuccessmsg" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center" >
				     <div style="text-align:center;" id="successmsg">
				     	<h4 style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;"><i class="zmdi_medium zmdi-check"></i>
				     		<span style="padding-left: 8px;">Disposal date updated successfully</span>
				     	</h4>
				     </div>
				</div>
		     <div id="show1">
		      <div class="container">
		      <div class="row">
		      <div class="cl-lg-12">
		        <%-- <h5 class="f-family text-left"><b>&nbspProperty Name: <%=propertyName%></b></h5> --%>
		        
		        <table id="propertyDetails" align="left">
		        	<tbody>
		        	   <tr>
		        			<td>Property ID</td>
		        			<td>:</td>
		        			<td><%=propertyId%></td>
		        		</tr>
		        	    <tr>
		        			<td>Property Name:</td>
		        			<td>:</td>
		        			<td><%=propertyName%></td>
		        		</tr>
		        		<tr>
		        			<td>FHA-Number</td>
		        			<td>:</td>
		        			<td><%=fhaNumber%></td>
		        		</tr>
		        		
		        		<tr>
		        			<td>Loan Type</td>
		        			<td>:</td>
		        			<td><%=loanType%></td>
		        		</tr>
		        		<tr>
		        			<td>Loan Amount</td>
		        			<td>:</td>
		        			<td><%=loanAmt%></td>
		        		</tr>
		        		<tr>
		        			<td>Closing Date</td>
		        			<td>:</td>
		        			<td><%=setDate%></td>
		        		</tr>
		        		<tr>
		        			<td>Termination Date</td>
		        			<td>:</td>
		        			<td><%=terminationDate%></td>
		        		</tr>
		        		<tr>
		        			<td>Disposal Date</td>
		        			<td>:</td>
		        			<td id="show1Date" style="color: red;font-size: 16px;"><%=msg%></td>
		        			<!-- <td id="show1Date" style="color: red;font-size: 16px;">Date Not Set</td> -->
		        		</tr>
		        		<tr>
		        			<td>Lender Name</td>
		        			<td>:</td>
		        			<td><%=lenderName%></td>
		        		</tr>
		        		<tr>
		        			<td>Property Status</td>
		        			<td>:</td>
		        			<td><%=status%></td>
		        		</tr>
		        		
		        		
		        	</tbody>
		        </table>
		        
		        <div class="clearfix"></div>
		       <!--  <div>
		        
		        		<h4 class=""><b><i>
		        	   How long would you like to retain the files <br />assosiated with this loan(years)?
		        		</i></b></h4>
		        	
		        		<input type="number" class="inputStyle" max="20" />
		        	
		      </div> -->
		      <div class="row">
		        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6" style="width:36%">
		        		<h5 class="text-left" style="margin-left:20px"><b>
		        	   How long would you like to retain the files <br />associated with this loan  (years) ?
		        		</b></h5>
		        		<br>
		        		 <div class="modal-footer" style="margin-top:20px;text-align:center">
		      	<button id="buttonConf1" class=" btn btn-success waves-effect waves-button waves-float f-family center-block" onclick="javascript:setDisposaldate();"><i class="fa fa-check"></i>  Submit</button>
				<button class=" btn btn-danger waves-effect waves-button waves-float f-family center-block" onclick="javascript:cancelWindow();"><i class="fa fa-times" aria-hidden="true"></i>Cancel</button>						
										
		      </div>
		        	</div>
		        	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
		        	<br />
		        		<!-- <input type="number" class="inputStyle pull-left" max="20" style="width:65px;border:1px solid #000 !important;"/> -->
		        		<select id="selectCount" class="inputStyle pull-left" style="width:80px;border:1px solid #000 !important;">
						  <option  selected>Select</option>
						</select>
		        	</div>
		        	<div class="col-lg-2 col-md-2 col-sm-2 "></div>
		        </div>
		     
		        </div>
		        </div>
		        </div>
		        </div>
		        
		     <!--  Part 2 -->
		     <div id="show2">
		      <div class="container">
		      <div class="row">
		      <div class="cl-lg-12">
<%-- 		        <h5  class="f-family text-left"><b>&nbspProperty Name: <%=propertyName%></b></h5>
 --%>		        
		        <table id="propertyDetails" align="left">
		        	<tbody>
		        	 <tr>
		        			<td>Property Name:</td>
		        			<td>:</td>
		        			<td><%=propertyName%></td>
		        		</tr>
		        		<tr>
		        			<td>FHA-Number</td>
		        			<td>:</td>
		        			<td><%=fhaNumber%></td>
		        		</tr>
		        		<tr>
		        			<td>Property ID</td>
		        			<td>:</td>
		        			<td><%=propertyId%></td>
		        		</tr>
		        		<tr>
		        			<td>Loan Type</td>
		        			<td>:</td>
		        			<td><%=loanType%></td>
		        		</tr>
		        		<tr>
		        			<td>Loan Amount</td>
		        			<td>:</td>
		        			<td><%=loanAmt%></td>
		        		</tr>
		        		<tr>
		        			<td>Closing Date</td>
		        			<td>:</td>
		        			<td><%=setDate%></td>
		        		</tr>
		        		<tr>
		        			<td>Disposal Date</td>
		        			<td>:</td>
		        			<td  id="diaposaldate" style="color: red;font-size: 18px;"></td>
		        		</tr>
		        		<tr>
		        			<td>Lender Name</td>
		        			<td>:</td>
		        			<td><%=lenderName%></td>
		        		</tr>
		        		<tr>
		        			<td>Property Status</td>
		        			<td>:</td>
		        			<td><%=status%></td>
		        		</tr>
		        		
		        		
		        	</tbody>
		        </table>
		        
		        <div class="clearfix"></div>
		       <!--  <div>
		        
		        		<h4 class=""><b><i>
		        	   How long would you like to retain the files <br />assosiated with this loan(years)?
		        		</i></b></h4>
		        	
		        		<input type="number" class="inputStyle" max="20" />
		        	
		      </div> -->
		      <div class="row">
		        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
		        		<h5 class="text-left" style="margin-left:20px"><b>
		        	   Please Confirm that the  Disposal Date is correct
		        		</b></h5>
		        		<br>
		        		 <div class="modal-footer" style="margin-top:20px;text-align:center">
		      	<button class=" btn btn-success waves-effect waves-button waves-float f-family center-block" id="buttonConf" onclick="javascript:confirmDate();"><i class="fa fa-check"></i>Confirm</button>
				<button class=" btn btn-danger waves-effect waves-button waves-float f-family center-block" onclick="javascript:cancelDate();"><i class="fa fa-times" aria-hidden="true"></i>Cancel</button>						
		      </div>
		        	</div>
		        	<!-- <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
		        	<br />
		        		<input type="number" class="inputStyle pull-left" max="20" style="width:65px;border:1px solid #000 !important;"/>
		        		<select id="selectCount" class="inputStyle pull-left" style="width:80px;border:1px solid #000 !important;">
						  <option  selected>Select</option>
						</select>
		        	</div> -->
		        	<div class="col-lg-2 col-md-2 col-sm-2 "></div>
		        </div>
		     
		        </div>
		        </div>
		        </div>
		        </div>
	</body>
</html>