<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request"
	class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<jsp:useBean id="folderBean" scope="request"
	class="com.peniel.beans.FolderBean" />
<%@page import="java.util.*"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-control" content="no-cache">
<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
	<link rel="stylesheet"
	href="css/jquery.dataTables.min.css" />  

	<link rel="stylesheet"
	href="css/font-awesome.min.css">
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
	<script
	src="js/bootstrap/3.3.5/jquery.min.js"></script>
<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>
<!-- <link
	href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
	
<link
	href="css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="css/jquery-ui.css">
<title>Property</title>
<!-- <script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
<script
	src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
<script src="js/bootstrap/3.3.5/jquery-ui.js"></script>
<script type="text/javascript"
	src="js/jquery.formatCurrency-1.4.0.min.js"></script>
<script type="text/javascript" src="scripts/propertyRequest.js"></script>


<script>
   /*  var date = new Date();
    var date1 = new Date();
    date.setDate(date.getDate());
    date1.setDate( date1.getDate()-1 );
    date1.setFullYear( date1.getFullYear()+ 50 );
    console.log('date1'+date1);  */
	$(document).on('focus', ".endDate", function() {
		$(this).datepicker({
	           maxPicks: 1,
	           changeMonth : true,
	              changeYear : true, 
 	              yearRange: '-20:+50',
 	              showDropdowns:true,
	           /*   minDate:date,
	               maxDate:date1, */
	              dateFormat: "mm/dd/yy"
	                   });
	});

	$(document).on('blur', '.currency', function() {
		
		
		 var notNumber=new RegExp("[^0-9]","g");
		 if($.trim($(this).val()).match(notNumber)){
	        //display error message
	           this.value = this.value.replace(/[^1-9\.]/g,'');
	          // $("#errmsg").html("Digits Only").show().fadeOut(10000);
	           var message="Please Enter Loan Amount as Digits Only";
	           document.getElementById("loanError"+count).innerHTML = message ;
		 
	     }
		$('.currency').formatCurrency();
	});
	
	
	$(document).on('onkeyup', '.currency1', function() {
		debugger;
		var notNumber=new RegExp("[^0-9]","g");
		 if($.trim($(this).val()).match(notNumber)){
	        //display error message
	           this.value = this.value.replace(/[^1-9\.]/g,'');
	          // $("#errmsg").html("Digits Only").show().fadeOut(10000);
	           var message="Please Enter Loan Amount as Digits Only";
	           document.getElementById("loanError"+count).innerHTML = message ;
	     }
		$('.currency1').formatCurrency();
	});
	

	
	$(document).on('blur', '.currency2', function() {

		$('.currency2').formatCurrency();
	});
	
	
</script>



<title>Property</title>
<% String appuserrole = (String)request.getSession().getAttribute("appuserrole");
   System.out.println("appuserrole "+appuserrole);
  Integer companyId = (Integer)request.getSession().getAttribute("comid");
  int uid = Integer.parseInt(request.getSession().getAttribute("userid").toString());
  javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	System.out.println("restURL"+restURL);
  
  
%>



<!-- get roles and rights -->
<script type="text/javascript">
 


</script>
<script type="text/javascript">
  function validate_money(id) {
	
	  var i=$("#loanAmount"+count).val().trim();
	//  alert("100 i:::"+i);
	//  var valid_dollar_amt_regex = (/^\$?[0-9][0-9,]*[0-9]\.?[0-9]{0,2}$/i).test(i);
	//var valid_dollar_amt_regex = (/(^\d{5}$)|(^\d{5}-\d{4}$)/).test(i);
	//  alert("100:::"+valid_dollar_amt_regex);
	  return id.replace(/[^0-9]/g, '');
   /*  var valid_dollar_amt_regex = (/^\$?[0-9][0-9,]*[0-9]\.?[0-9]{0,2}$/i).test(i);
    alert("1038::::"+ valid_dollar_amt_regex.test(i));
    return valid_dollar_amt_regex.test(i); */
 }


</script> 
<script language=javascript>

function checkZip(value) {
    return (/(^\d{5}$)|(^\d{5}-\d{4}$)/).test(value);
}
var count=0,propertyId=0;
var propertyFlag=false;
/* var loanflag="loanflag";
var checkLoan =loanflag+count;
loanflag=checkLoan; */
var loanFlag=0;
var globalCompanyId,globalRestUrl;

globalCompanyId = <%= companyId %>;
//alert(globalCompanyId);

globalRestUrl = '<%=restURL%>';
//alert(globalRestUrl);

var globalUserId = '<%=uid%>';
//alert(globalUserId);
function addLoanInformation(){
	$("#successmsg").hide();
	$("#editmsg").hide();
	var companyId=<%= companyId %>;
	var state=$('#listStates :selected').val();
	var propertyTypeId=$('#lstFruits345 :selected').val();  
	var propertyStatus=$('#propertyStatus :selected').val();
	var isAvailble = true;
    var message="Enter the values for  parameters::";
    if($("#propertyId").val().trim() == ""){
   	  isAvailble= false;
   	  message += "Property Id,";
    }
    if($("#propertyName").val().trim() == ""){
   	  isAvailble= false;
   	  message += "Property Name,";
    }
    if($("#city").val().trim() == ""){
   	  isAvailble= false;
   	  message += "City,";
    }
    if($("#zip").val().trim() == ""){
   	   isAvailble= false;
       message += "Zip,";
    }else{
    	 var value = $('#zip').val().trim();
 	    if (checkZip(value)) {
 	      
 	    } else {
 	    	isAvailble= false;
 	        message += "Please Enter valid ZIP With 5 digits,";
 	    }
    }
   if(state=="Select State"){
		 isAvailble=false;
		 message += "State,"; 
	 }
   if(propertyTypeId=="Select Property Type"){
	    isAvailble=false;
		 message += "Property Type,"; 
	 }
   if(isAvailble == true){
	   $("#loadingImage123").show();
	   var testData={
				 "companyId":companyId,
				 "propertyId":$("#propertyId").val(),
				 "propertyName":$("#propertyName").val(),
				 "city":$("#city").val(),
				 "state":state,
				 "zip":$("#zip").val(),
				 "propertyTypeId":propertyTypeId,
				 "propertyStatus":propertyStatus
		};
	   $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/savePropertyInfo",
			dataType : 'json',
			timeout : 100000,
			data : JSON.stringify(testData),
			success : function(data) {
				 $("#loadingImage123").hide();
				 $("#tagscloud").hide();
				 if(data.key==201){
					 if(propertyFlag == true){
						 $("#buttonsDiv").show();
						    $("#buttonsTr").hide();
						    $.ajax({
								type : "GET",
								contentType : "application/json",
								url : "<%=restURL%>/orcf/getLoanTypes?companyId="+companyId,
								dataType : 'json',
								timeout : 100000,
								success : function(data) {  
								       for(i=0;i<data.response.length;i++){
								    	   $("#listOfLoanTypes"+count).append("<option value='"+data.response[i].loanTypeId+"'><b>"+data.response[i].loanType+"</b></option>");
								      } 
								    		},
								error : function(e) {
									console.log("ERROR: ", e);
								},
								done : function(e) {
									console.log("DONE");
								}
							     });
						    
						    var div = $("<div />");
				 	        div.html(GetDynamicTextBox(""));
				 	        $("#TextBoxContainer").append(div);
					 }else{
						 $("#editmsg").show(); 
					 }
				 }else{ 
						$("#successmsg").show();  
						propertyId=data.response.id;
					    $("#buttonsDiv").show();
					    $("#buttonsTr").hide();
					    $.ajax({
							type : "GET",
							contentType : "application/json",
							url : "<%=restURL%>/orcf/getLoanTypes?companyId="+companyId,
							dataType : 'json',
							timeout : 100000,
							success : function(data) {  
							       for(i=0;i<data.response.length;i++){
							    	   $("#listOfLoanTypes"+count).append("<option value='"+data.response[i].loanTypeId+"'><b>"+data.response[i].loanType+"</b></option>");
							      } 
							    		},
							error : function(e) {
								console.log("ERROR: ", e);
							},
							done : function(e) {
								console.log("DONE");
							}
						     });
					    
					    var div = $("<div />");
			 	        div.html(GetDynamicTextBox(""));
			 	        $("#TextBoxContainer").append(div);
			 	        
	      		        console.log("SUCCESS: ", data);
				 }
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
	  
	   if(message.substring(message.length-1)==',') {   //if(message.endsWith(",")){
			message = message.substring(0, message.length - 1);
		}
		 document.getElementById("texterr").innerHTML = message ;
		 $("#loadingImage12").hide();
   }
}

function checkZIPValid(){
	var isAvailble = true;
	 var message="";
	 if($("#zip").val().trim() == ""){
	   	   isAvailble= false;
	       message += "Zip";
	    }else{
	    	 var value = $('#zip').val().trim();
	    	    if (checkZip(value)) {
	    	    	document.getElementById("texterr").innerHTML = "" ;
	    	    } else {
	    	    	isAvailble= false;
	    	        message += "Please Enter valid ZIP with 5 digits";
	    	        document.getElementById("texterr").innerHTML = message ;
	    	    }
	     } 
}

function savePropertyRequest(){
	$("#successmsg").hide();
	$("#editmsg").hide();
	var companyId=<%= companyId %>;
	var state=$('#listStates :selected').val();
	var propertyTypeId=$('#lstFruits345 :selected').val();  
	var propertyStatus=$('#propertyStatus :selected').val();
	var isAvailble = true;
    var message="Enter the values for  parameters::";
    if($("#propertyId").val().trim() == ""){
   	  isAvailble= false;
   	  message += "Property Id,";
    }
    if($("#propertyName").val().trim() == ""){
   	  isAvailble= false;
   	  message += "Property Name,";
    }
    if($("#city").val().trim() == ""){
   	  isAvailble= false;
   	  message += "City,";
    }
    if($("#zip").val().trim() == ""){
   	   isAvailble= false;
       message += "Zip,";
    }else{
    	 var value = $('#zip').val().trim();
    	    if (checkZip(value)) {
    	      
    	    } else {
    	    	isAvailble= false;
    	        message += "Please Enter valid ZIP With 5 digits,";
    	    }
    }
   if(state=="Select State"){
		 isAvailble=false;
		 message += "State,"; 
	 }
   if(propertyTypeId=="Select Property Type"){
	     isAvailble=false;
		 message += "Property Type,";
	 }
   if(isAvailble == true){
	   $("#loadingImage123").show();
	   var testData={
				 "companyId":companyId,
				 "propertyId":$("#propertyId").val(),
				 "propertyName":$("#propertyName").val(),
				 "city":$("#city").val(),
				 "state":state,
				 "zip":$("#zip").val(),
				 "propertyTypeId":propertyTypeId,
				 "propertyStatus":propertyStatus
		};
	   $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/savePropertyInfo",
			dataType : 'json',
			timeout : 100000,
			data : JSON.stringify(testData),
			success : function(data) {
				 $("#loadingImage123").hide();
				 $("#tagscloud").hide();
				 if(data.key==201){
					 $("#editmsg").show(); 
				 }else{
					 propertyId=data.response.id;
					 $("#successmsg").show(); 
					 propertyFlag=true;
				 }
	      		console.log("SUCCESS: ", data);
				
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		}); 
   }else{
		/* if(message.endsWith(",")){ */
			 if(message.substring(message.length-1)==',') {
					message = message.substring(0, message.length - 1);
		}
		 document.getElementById("texterr").innerHTML = message ;
		 $("#loadingImage123").hide();
   }
}


function goBack() {
	location.reload();
	$("#addPropertyForm").hide();
	$("#backBtn1").hide();
	$("#addRightList").show();
	$("#addRightBtn").show();
	$("#propertyListsData").dataTable();
	
}


function updateLoanDataIdInfo(loanDataId,index){
	 $('#editLoanSuccessMessage'+index).empty();
	var isAvailble = true;
	var message="Please enter the parameters::";
	   var x=document.getElementById("elistOfLoanTypes"+count);
				 for (var i = 0; i < x.options.length; i++) {
			         if(x.options[i].selected ==true){
			            var loanTypesId=x.options[i].value;
			          }
			    } 
	 	 if($("#efhaNumber"+count).val().trim()==""){
			 isAvailble= false;
	    	 message += "FHA Number, ";
		 }
		 if($("#eloanAmount"+count).val().trim()==""){
			 isAvailble= false;
	    	 message += "Loan Amount, ";
		 }
		 if($("#elenderName"+count).val().trim()==""){
			 isAvailble= false;
	    	 message += "Lender Name, ";
		 }
		 if($("#eendDate"+count).val().trim()==""){
			 isAvailble= false;
	    	 message += "Closing Date,";
		 }
		
		 if(loanTypesId=="Select Loan Type" || loanTypesId==""){
			 isAvailble= false;
	    	 message += "Loan Type ,";
		 }
		 if($("#eloanAmount"+count).val() == "$0" || $("#eloanAmount"+count).val() == "$0.00"){
			 isAvailble= false;
	    	 message += "Loan amount should be greater than $0 ,";
		 }
		 
		 if( new Date($("#eendDate"+count).val()).getTime() > new Date($("#eterminationDate"+count).val()).getTime() )
		 {
			 isAvailble= false;
		     message += "Termination date should be greater than Closing Date";
		 }
		 else if( new Date($("#eendDate"+count).val()).getTime() < new Date($("#eterminationDate"+count).val()).getTime())
		 {
			 
		 }
		 else 
		 {
		 }
		 
    if(isAvailble){ 
	var updateLoanDataObject = {
	"companyId":parseInt(globalCompanyId),
	"propertyId":parseInt(globalPId),
	"loanTypeId":parseInt($('#elistOfLoanTypes'+index+' :selected').val()),
	"fhaNumber":$("#efhaNumber"+index).val(),
	"loanAmount":$("#eloanAmount"+index).val(),
	"lenderName":$("#elenderName"+index).val(),
	"closingDate":$("#eendDate"+index).val(),
	"userId":<%=uid%>,
	"loanDataId":loanDataId,
	"terminationDate":$("#eterminationDate"+index).val()
	}
	document.getElementById("textErrEditLoan"+index).innerHTML ="";
		
	//alert(JSON.stringify(updateLoanDataObject));
	$.ajax({
	type : "PUT",
	contentType : "application/json",
	url : "<%=restURL%>/orcf/updateLoanDataInfo",
	dataType : 'json',
	timeout : 100000,
	data : JSON.stringify(updateLoanDataObject),
	success : function(data) {
	console.log("updateLoanSuccess Success:"+JSON.stringify(data));	

	/* $('#updateLoanSuccess'+index).append(
			+"<h4	style='color: green; border-bottom: 1px dotted rgb(0, 128, 0); padding: 5px; margin-bottom: 12px;'>"
			+"<i class='zmdi_medium zmdi-check'></i>"
			+"<span style='padding-left: 8px;'>Loan Details Updated Successfully!</span>"
			+"</h4>"); */
			$("#editLoanSuccessMessage"+index).append("<i class='zmdi_medium zmdi-check'></i> <span style='padding-left: 8px;'> Loan Details Updated Successfully </span></h4>");

	  setTimeout(function(){
		  $('#editLoanSuccessMessage'+index).fadeIn(5000);
		  $('#editLoanSuccessMessage'+index).fadeOut(3000);
		 // $("#editLoanSuccessMessage"+index).append("<i class='zmdi_medium zmdi-check'></i> <span style='padding-left: 8px;'></span></h4>");
	});  
	
	},
	error : function(e) {
	console.log("ERROR: ", e);
	},
	done : function(e) {
	console.log("DONE");
	}
	});  
    }
    else{
    	/* if(message.endsWith(",")){ */
    		 if(message.substring(message.length-1)==',') {
			message = message.substring(0, message.length - 1);
			}
	      document.getElementById("textErrEditLoan"+index).innerHTML = message ;	
    }
	}
	
	
	
function checkZipValidation(){
	debugger;
	var isAvailble = true;
		 var message="";
		 if($("#ezip").val().trim() == ""){
		   	   isAvailble= false;
		       message += "Zip";
		    }else{
		    	 var value = $('#ezip').val().trim();
		    	    if (checkZip(value)) {
		    	    	document.getElementById("texterrEdit").innerHTML = "" ;
		    	    } else {
		    	    	isAvailble= false;
		    	        message += "Please Enter valid ZIP with 5 digits";
		    	        document.getElementById("texterrEdit").innerHTML = message ;
		    	    }
		     } 
	}
	
	
	function updatePropertyInfo(newLoan){
		//alert('updatepropertyInfo...'+newLoan);
		var companyId=<%= companyId %>;
		var state=$('#elistStates :selected').val();
		var propertyTypeId=$('#elstFruits345 :selected').val();  
		var propertyStatus = $('#ePropertyStatus :selected').val();
		var isAvailble = true;
	    var message="Enter the values for  parameters::";
	  //  alert(state+'updatePropertyInfo()'+propertyTypeId+'===='+propertyStatus+'----');
	   document.getElementById("texterrEdit").innerHTML ="";
	    debugger;
	    if($("#epropertyId").val().trim() == ""){
	   	  isAvailble= false;
	   	  message += "Property Id, ";
	    }
	    if($("#epropertyName").val().trim() == ""){
	   	  isAvailble= false;
	   	  message += "Property Name, ";
	    }
	    if($("#ecity").val().trim() == ""){
	   	  isAvailble= false;
	   	  message += "City, ";
	    }
	    if($("#ezip").val().trim() == ""){
	   	   isAvailble= false;
	       message += "Zip, ";
	    }else{
	    	var value = $('#ezip').val().trim();
    	    if (checkZip(value)) {
    	      
    	    } else {
    	    	isAvailble= false;
    	        message += "Please Enter valid ZIP With 5 digits, ";
    	    }
	    }
	   if(state=="Select State"){
			 isAvailble=false;
			 message += "State, "; 
		 }
	   if(propertyTypeId=="Select Property Type"){
		     isAvailble=false;
			 message += "Property Type,";
		 }
	   if(isAvailble == true){
		   $("#loadingImage123").show();
		var updatePropertyObject ={
			"id":parseInt(globalPId),
			"companyId":parseInt(globalCompanyId),
			"propertyId":$("#epropertyId").val(),
			"propertyName":$("#epropertyName").val(),
			"city":$("#ecity").val(),
			"state":$('#elistStates :selected').val() ,
			"zip":$("#ezip").val(),
			"propertyTypeId": parseInt($('#elstFruits345 :selected').val()),
			"propertyStatus":$('#ePropertyStatus :selected').val()
		};
		console.log("updatePropertyInfo:"+JSON.stringify(updatePropertyObject));
		$.ajax({
		type : "PUT",
		contentType : "application/json",
		url : "<%=restURL%>/orcf/updatePropertyInfo",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(updatePropertyObject),
		success : function(data) {
		console.log("data:"+JSON.stringify(data));
		//$(".card").load(location.href + ".card");
		$('#textError').hide();
		//$("#updatePropertySuccess").append("<span>"+data.propertyInfo+"</span>");
		$("#updatePropertySuccess").show();
		
		$("#updatePropertySuccess").delay(2000).fadeOut();
		
  		if(newLoan){
  		var appendData = 
	    	 "<div class='card' style='width: 95%; padding-left: 0px; position: relative; background: #fff; box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15); border-top: 1px solid rgba(0, 0, 0, 0.15); margin-bottom: 30px;'>"
			+"<div	style='background-color: #EDECEC; padding: 23px 26px; box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);'>"
			+"<div style='text-align: center; font-size: 16px;'>Loan Information</div>"
			+ '<div style="text-align:center;" id="tagscloud">'
			+ ' <span id="loanErrorForNew" style="color: red;"></span>'
			+ ' </div>'
			+"<table class='table loanTable' cellspacing='0'>"
			+"<tbody>"
			+"<tr>"
			+"<td class='wisth200'> FHA Number <span class='requiredStar'>*</span></td>"
			+"<td colspan='3'><div></div>"
			+"<input class='tableInputselectStyle1234567' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='efhaNumber' name='efhaNumberEdit'  maxlength='150'  value=''  onfocus='duplicateFhanumberCheck(\""+$("#epropertyId").val()+"\",\""+this.value+"\",\""+00+"\")'>"
			+"<span id='textMsg' style='color: red;'></span></td>"
			+"</tr>"
			+"<tr>"
			+"<td class='wisth200'>Loan Type<span class='requiredStar'>*</span></td>"
			+"<td>"
			+"<select id='elistOfLoanTypes' class='tableInputselectStyle1234567 selectLoanTypeclass'><option>Select Loan Type</option></select></td>"
			+"</tr>"
			+"<tr>"
			+"<td class='wisth200'>Loan Amount <span class='requiredStar'>*</span></td>"
			+"<td colspan='3'>"
			+"<div></div>"
			+"<input class='tableInputselectStyle1234567  currency' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='eloanAmount' name='eloanAmount' value='' />&nbsp;<span id='loanError'></span>"
			+"</td>"
			+"</tr>"
			+"<tr>"
			+"<td class='wisth200'>Lender Name <span class='requiredStar'>*</span></td>"
			+"<td colspan='3'><div></div>"
			+"<input class='tableInputselectStyle1234567' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='elenderName' name='elenderName' value=''>"
			+"</td>"
			+"</tr>"
			+"<tr>"
			+"<td class='wisth200'>Closing Date<span class='requiredStar'>*</span></td>"
			+"<td>"
			+"<input id='eendDate' type='text'  value='' class='form-control tableInputselectStyle1234567 endDate col-sm-12 inputStyle1' placeholder='Closing Date' style='width: 100%'>"
			+"</td>"
			+"</tr>"
			+"<tr>"
			+"<td class='wisth200'>Termination Date</td>"
			+"<td>"
			appendData = appendData +"<input id='eterminationDate' type='text'  value='' class='form-control tableInputselectStyle1234567 endDate col-sm-12 inputStyle1' placeholder='Termination Date' style='width: 100%'>"
			+"</td>"
			+"<div class='form-group row'>"
			+"<div class='col-sm-8 posiRelavtive'>"
			+"</div>"
			+"</div>"
			+"</tr>"
			+"<td></td>"
			+"<td style='text-align: left;padding-left:98px;'><input name='button2' id='button2' class='btn btn-success waves-effect waves-button waves-float' style='margin-left: 20px;' type='button' value='Save' onclick='saveLoanInformationForEdit(false)'>";
			appendData = appendData + "<input name='button2' id='btnEdit' class='btn btn-success waves-effect waves-button waves-float' style='margin-left: 15px;' type='button' value='Save & Add  New Loan'  onClick ='saveLoanInformationForEdit(true)'>"
			+ "<input name='button' id='resetButton' class='btn btn-warning waves-effect waves-button waves-float' style='margin-left: 15px;' type='button' value='Reset' onclick='resetLoanInformationForADD()'>"
			+"</td>"
			+"</tr>"
			+"</tbody>"
			+"</table>"
			+"</div>"
			+"</div>"
			+"</div>";
			
	     $('#editLoanInfo').append(appendData);
		$('#loanButton').hide();
		
	     
	     var companyIdValue= '<%= companyId %>';
			// alert(companyIdValue);
	    	 $.ajax({
					type : "GET",
					contentType : "application/json",
					url : "<%=restURL%>/orcf/getLoanTypes?companyId="+companyIdValue,
					dataType : 'json',
					timeout : 100000,
					success : function(lt) {  
						for(i=0;i<lt.response.length;i++){
									$("#elistOfLoanTypes").append("<option value='"+lt.response[i].loanTypeId+"'><b>"+lt.response[i].loanType+"</b></option>");	
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
		
  		}else{
  			
  		}
	},
	error : function(e) {
	console.log("ERROR: ", e);
	},
	done : function(e) {
	console.log("DONE");
	}
	});
	 }else{
			/*  if(message.endsWith(",")){ */
				 if(message.substring(message.length-1)==',') {
				message = message.substring(0, message.length - 1);
			}
	        document.getElementById("texterrEdit").innerHTML = message ;
	 
	} 

	}



function addRightForm() {
	$("#addRightList").hide();
	$("#addRightBtn").hide();
	$("#addPropertyForm").show();
	$("#loadingImage123").hide();
	$("#editLoanInfo").hide();
	$("#editPropertyForm").hide();
	$("#backBtn1").show();	
	$("#successmsg").hide();
	$("#editmsg").hide();
	 $("#propertyId").val(""),
	 $("#propertyName").val(""),
	 $("#city").val(""),
	 $("#zip").val(""),
	getPropertyTypes();
}

function loadFunction() {
    initial_load();
    getModules();
  }
   
   function getPropertyTypes(){
	   var companyIdValue= '<%= companyId %>';
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getPropertyTypes?companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
			       for(i=0;i<data.response.length;i++){
			       $("#lstFruits345").append("<option value='"+data.response[i].propertyTypeId+"'><b>"+data.response[i].propertyType+"</b></option>");
			       
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
		
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getStates",
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
			       for(i=0;i<data.response.length;i++){
			       $("#listStates").append("<option value='"+data.response[i].stateCode+"'><b>"+data.response[i].stateName+"</b></option>");
			       
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
   
function getModules(){
	$("#addRightList").show();
	$("#addRightBtn").show();
	$("#addPropertyForm").hide();
	$("#editLoanInfo").hide();
	$("#editPropertyForm").hide();
	$("#loadingImage12").hide();
	$("#backBtn1").hide();	
	$("#successmsg1").hide();
	var companyIdValue= '<%= companyId %>';
	globalCompanyId = '<%= companyId %>';
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/orcf/getPropertiesListPST?companyId="+companyIdValue,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#loadingImage").hide();
			$("#tableStyle1").show();
			if ($.fn.DataTable.isDataTable("#propertyListsData")) {
				  $('#propertyListsData').DataTable().clear().destroy();
				}
			displayModules(data);
			 $("#propertyListsData").dataTable({
					  "order": [[ 6, "asc" ]],
			          "deferRender": true
			    
			}); 
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

function displayModules(data) {
	 $.each(data.response, function(i, item) {
		   item.propertyId=='null'|| null ?item.propertyId='':item.propertyId == null ? item.propertyId='':item.propertyId;
		   item.propertyName=='null' || null ?item.propertyName='':item.propertyName;
		   item.city =='null' || null ?item.city='':item.city ==null? item.city='':item.city;
		   item.zip =='null' || null ?item.zip='':item.zip ==null? item.zip='':item.zip;
		   item.state =='null' || null ?item.state='':item.state ==null? item.state='':item.state;
	    //  $('#propertyList').append('<tr><td id="123">'+item.propertyId+'</td><td>'+item.propertyName+'</td><td>'+item.city+'</td><td>'+item.stateName+'</td><td>'+item.zip+'</td><td style="display:none">'+item.id+'</td><td><a id="editB" onclick="editPropertyInfo(\''+item.propertyId+'\',\''+item.propertyName+'\')"><i class="zmdi_medium zmdi zmdi-edit"></i></a></td><td><a id="deleteB" onclick="deleteProperty(\''+item.id+'\')"><i class="zmdi_medium zmdi zmdi-delete"></i></a></td></tr>');
		   $('#propertyList').append('<tr><td hidden>'+item.fhaNumber+'</td><td id="123">'+item.propertyId+'</td><td>'+item.propertyName+'</td><td>'+item.city+'</td><td>'+item.state+'</td><td>'+item.zip+'</td><td style="display:none">'+item.id+'</td><td><a id="editB" onclick="editPropertyInfo(\''+item.id+'\')"><i class="zmdi_medium zmdi zmdi-edit"></i></a></td><td><a id="deleteB" onclick="popupWindow(\''+item.id+'\')"><i class="zmdi_medium zmdi zmdi-delete"></i></a></td></tr>');
	 });
	 
}

 </script>
<script>
 var globalPId;
 function editPropertyInfo(propertyID){
	 //alert('property id..'+propertyID);
	globalPId = propertyID;
	$('#loanButton').hide();
	$("#addRightList").hide();
	$("#addRightBtn").hide();
	$("#editPropertyForm").show();
	$("#editLoanInfo").show();
	$("#loadingImage123").hide();
	$("#backBtn1").show();	
	$("#editsuccessmsg").hide();
	$("#editerrormsg").hide();
	$('#textError').hide();
	$('#updatePropertySuccess').hide();
	//$("#epropertyId").val('dfkdlfnds');
	
	console.log(propertyID);
	var companyIdValue= '<%= companyId %>';
	  $.ajax({
		type : "GET",
		contentType : "application/json",
		url : "<%=restURL%>/orcf/getEditPropertyInfo?propertyId="+propertyID,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {  
		console.log("getEditProppertyInfo success : 718 "+JSON.stringify(data));
		$("#successmsg").hide();
		$("#editmsg").hide();
		getData(data.PropertyDataInfo.state,data.PropertyDataInfo.propertyTypeId); 
		
		     $('#epropertyId').val(data.PropertyDataInfo.propertyId);
		     $('#epropertyName').val(data.PropertyDataInfo.propertyName);
		     $('#ecity').val(data.PropertyDataInfo.city);
		     $('#estate').val(data.PropertyDataInfo.state);
		     //$('#elistStates').val(data.PropertyDataInfo.state);
		     //zip
		     $('#ezip').val(data.PropertyDataInfo.zip);
		  
		     /* To Display associated loan information */		     
		     //$('#efhaNumber').val(data.PropertyDataInfo.zip);
		     
		     
		     var companyIdValue= '<%= companyId %>';
				// alert(companyIdValue);
		    	 $.ajax({
						type : "GET",
						contentType : "application/json",
						url : "<%=restURL%>/orcf/getLoanTypes?companyId="+companyIdValue,
						dataType : 'json',
						timeout : 100000,
						success : function(lt) {  
						//alert('getLoanTypes success..');
							if(data.LoandataInfo){

						    	   datalenth=data.LoandataInfo.length - 1;
						    	   
								for(var z = 0;z<data.LoandataInfo.length; z++){
									for(i=0;i<lt.response.length;i++){
									       if(data.LoandataInfo[z].loanTypeId == lt.response[i].loanTypeId)
											{
									    		$("#elistOfLoanTypes"+z).append("<option selected value='"+lt.response[i].loanTypeId+"'><b>"+lt.response[i].loanType+"</b></option>");				       
											}else{
												$("#elistOfLoanTypes"+z).append("<option value='"+lt.response[i].loanTypeId+"'><b>"+lt.response[i].loanType+"</b></option>");	
											}
									       //$(".selectLoanTypeclass").append("<option value='"+data.response[i].loanTypeId+"'><b>"+data.response[i].loanType+"</b></option>");
								      } 
								}  
							}else{
								for(i=0;i<lt.response.length;i++){
								       if(loanTypeId == lt.response[i].loanTypeId)
										{
								    		$("#elistOfLoanTypes"+z).append("<option selected value='"+lt.response[i].loanTypeId+"'><b>"+lt.response[i].loanType+"</b></option>");				       
										}else{
											$("#elistOfLoanTypes"+z).append("<option value='"+lt.response[i].loanTypeId+"'><b>"+lt.response[i].loanType+"</b></option>");	
										}
								       //$(".selectLoanTypeclass").append("<option value='"+data.response[i].loanTypeId+"'><b>"+data.response[i].loanType+"</b></option>");
							      } 
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
		   	var datalenth=0;
		    if(data.LoandataInfo){
		    //$('#editLoanInfo').append("");
		     for(var x = 0; x < data.LoandataInfo.length;x++){
		    
		    	 var appendData = 
			    	 "<div class='card' style='width: 95%; padding-left: 0px; position: relative; background: #fff; box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15); border-top: 1px solid rgba(0, 0, 0, 0.15); margin-bottom: 30px;'>"
					+"<div	style='background-color: #EDECEC; padding: 23px 26px; box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);'>"
					+"<div style='text-align: center; font-size: 16px;'>Loan Information</div>"
					/* +"<div style='text-align: center;' id='updateLoanSuccess"+x+"'>"
					+"</div>" */
					+"<div style='text-align: center;' id='tagscloud'><span id='textErrEditLoan"+x+"' style='color: red;'></span></div>"
					+"<div style='text-align: center;' id='editloanUpdateSuccess"+x+"'>"
					+"<h4 style='color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;' id='editLoanSuccessMessage"+x+"'></h4>"
					+"</div>"
					+"<table class='table loanTable' cellspacing='0'>"
					+"<tbody>"
					+"<tr>"
					+"<td class='wisth200'>Associated FHA Number <span class='requiredStar'>*</span></td>"
					+"<td colspan='3'><div> <span id='textMsg"+x+"' style='color: red;'></span></div>"
					+"<input class='tableInputselectStyle123' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='efhaNumber"+x+"' name='propertyId' maxlength='150'  value="+data.LoandataInfo[x].fhaNumber+" onfocus='getFilesist(\""+data.PropertyDataInfo.propertyId+"\",\""+data.LoandataInfo[x].fhaNumber+"\",\""+x+"\")'>"
					+"<span id='textMsg"+x+"' style='color: red;'></span></td>"
					+"</tr>"
					+"<tr>"
					+"<td class='wisth200'>Loan Type<span class='requiredStar'>*</span></td>"
					+"<td>"
					+"<select id='elistOfLoanTypes"+x+"' class='tableInputselectStyle123 selectLoanTypeclass'><option>Select Loan Type</option></select></td>"
					+"</tr>"
					+"<tr>"
					+"<td class='wisth200'>Loan Amount <span class='requiredStar'>*</span></td>"
					+"<td colspan='3'>"
					+"<div></div>"
					+"<input class='tableInputselectStyle123 currency  no-spin' size='50'  style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='eloanAmount"+x+"' name='eloanAmount' value="+data.LoandataInfo[x].loanAmount+" />&nbsp;<span id='loanError'></span>"
					+"</td>"
					+"</tr>"
					+"<tr>"
					+"<td class='wisth200'>Lender Name<span class='requiredStar'>*</span></td>"
					+"<td colspan='3'><div></div>";
					if(data.LoandataInfo[x].lenderName == '' || data.LoandataInfo[x].lenderName==null || data.LoandataInfo[x].lenderName=='null'){
						appendData = appendData + "<input class='tableInputselectStyle123' placeholder='enter lender name' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='elenderName"+x+"' name='city' value='' >";
					}else{
						appendData = appendData + "<input class='tableInputselectStyle123' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='elenderName"+x+"' name='city' value="+data.LoandataInfo[x].lenderName+">";
					}
					appendData = appendData + "</td>"
					+"</tr>"
					+"<tr>"
					+"<td class='wisth200'>Closing Date <span class='requiredStar'>*</span></td>"
					+"<td>";
					if(data.LoandataInfo[x].closingDate == '' || data.LoandataInfo[x].closingDate == null || data.LoandataInfo[x].closingDate == 'null'){
						appendData = appendData + "<input id='eendDate"+x+"' type='text' placeholder='Closing Date' value='' class='form-control tableInputselectStyle12345 endDate col-sm-12 inputStyle1' placeholder='Closing Date' style='width: 100%'>";
					}else{
						appendData = appendData + "<input id='eendDate"+x+"' type='text' value="+data.LoandataInfo[x].closingDate+" class='form-control tableInputselectStyle12345 endDate col-sm-12 inputStyle1' placeholder='End' style='width: 100%'>";
					}
					appendData = appendData + "</td>"
					+"</tr>"				 
					+"<div class='form-group row'>"
					+"<div class='col-sm-8 posiRelavtive'>"
					+"</div>"
					+"</div>"
					+"</td>"
					+"</tr>"
					
					
					+"<tr><td class='wisth200'> Termination Date <span class='requiredStar'></span></td>"
					+"<td>";
					if(data.LoandataInfo[x].terminationDate == '' || data.LoandataInfo[x].terminationDate==null || data.LoandataInfo[x].terminationDate=='null'){
						appendData = appendData + "<input id='eterminationDate"+x+"' type='text' placeholder='Termination Date' value='' class='form-control tableInputselectStyle12345 endDate col-sm-12 inputStyle1' style='width: 100%'>";
					}else{
						appendData = appendData + "<input id='eterminationDate"+x+"' type='text' placeholder='Termination Date' value="+data.LoandataInfo[x].terminationDate+" class='form-control tableInputselectStyle12345 endDate col-sm-12 inputStyle1' style='width: 100%'>";
					}
					appendData = appendData 
					+ "</td>"
					+"</tr>"
					+"<tr>"
					+"<td></td>"
					+"<td style='text-align: left;'>"
					+"<input name='button2' id='button2' class='btn btn-success waves-effect waves-button waves-float' style='margin-left: 20px;' type='button' value='Update' onclick='updateLoanDataIdInfo(\""+data.LoandataInfo[x].loanDataId+"\",\""+x+"\")'>";
					if(x == data.LoandataInfo.length-1){
						/* save and add new loan in edit */
						appendData = appendData + "<input name='button2' id='btnEdit' class='btn btn-success waves-effect waves-button waves-float' style='margin-left: 15px;' type='button' value='Update & Add  New Loan'  onClick ='saveLoanInformationAndAddNewLoanInEdit(\""+data.LoandataInfo[x].loanDataId+"\",\""+x+"\")'>";
					}
					 appendData = appendData /* + "<input  name='button' id='button' class='btn btn-warning waves-effect waves-button waves-float' style='margin-left: 15px;' type='button' value='Cancel'>" */ 
					+"</td>"
					+"</tr>"
					+"</tbody>"
					+"</table>"
					+"</div>"
					if(x == data.LoandataInfo.length-1){
						appendData = appendData + "<div id='LoanEditTextBoxContainer' style='background-color: #EDECEC; padding: 23px 26px; box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);'></div>";
					}
					+"</div>"
					+"</div>";
					
		       $('#editLoanInfo').append(appendData);
		       
				//data.LoandataInfo			     
				//$('#editLoanInfo').append("<h4>fafsafsafas</h4>");
		    
				var datahtml= $('#editLoanInfo').html() ;
		        	 	 
				if(datalenth != x){
					$('#editLoanInfo')
	                .clone(true)       /* get a clone of the element and from it */
	                .find('#btnEdit') /* retrieve the button, then */
	                .remove()          /* remove it, */
	                .end()             /* return to the previous selection and */
	                .html() ;
				} 
		    	 var loanTypeId = data.LoandataInfo[x].loanTypeId;
		    	 	
			}				
		}else{
			$('#loanButton').show();
			    // $('#editLoanInfo').append("dsfdsafdsafdsafa");
		    }
		    
		    //if(data.LoandataInfo.length>0){
				//getData(data.PropertyDataInfo.state,data.PropertyDataInfo.propertyTypeId); 
			//}
		},
		error : function(e) {
			console.log("ERROR: ", e);
			//displayModules(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	     });	
	 return true;
 } 

 
 
 
 
 
 </script>

<script type="text/javascript">
   function popupWindow(id){
	    var r = confirm("Are you sure you want to remove this property?");
	    if (r == true) {
	    	deleteProperty(id);
	    } else {
	       
	    }
	  
	   
   } 
</script>
<script type="text/javascript">
  function deleteProperty(id){
	    $.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/deleteProperty?propertyId="+id,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				$("#successDeleteMessage").empty();
				 if(data.key==200){
					 $("#successDeleteMessage").append("<span style ='color:red;'><b>"+data.status+"</b></span>");
					 getModules();
				 }else{
					 $("#successDeleteMessage").append("<span style ='color:red;'><b>"+data.status+"</b></span>");
				 }
				 $("#successDeleteMessage").show().delay(2000).fadeOut();
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
 
<!-- <script type="text/javascript">
function validate_money() {
	var i=$("#loanAmount"+count).val().trim();
    var valid_dollar_amt_regex = /^\$?[0-9][0-9,]*[0-9]\.?[0-9]{0,2}$/i;
    alert("1049:::"+valid_dollar_amt_regex.test(i));
    return valid_dollar_amt_regex.test(i);
}
</script> -->


<script type="text/javascript">
function dateCheck(){
	var isAvailble = true;
	 var message="";
	 var closingDate=$("#endDate"+count).val().trim();
	 var terminationDate=$("#terminationDate"+count).val().trim();
	
	 if($("#zip").val().trim() == ""){
	   	   isAvailble= false;
	       message += "Zip";
	    }else{
	    	 var value = $('#zip').val().trim();
	    	    if (checkZip(value)) {
	    	    	document.getElementById("texterr").innerHTML = "" ;
	    	    } else {
	    	    	isAvailble= false;
	    	        message += "Please Enter valid ZIP with 5 digits";
	    	        document.getElementById("texterr").innerHTML = message ;
	    	    }
	     } 
}
</script>
<script type="text/javascript">
  function saveLoanInformation(){
	  	   var companyIdValue= '<%=companyId%>';
	       var userIdvalue='<%=uid%>';
		   var isAvailble = true;
		 
	       var message="Please enter the parameters::";
		   var x=document.getElementById("listOfLoanTypes"+count);
					 for (var i = 0; i < x.options.length; i++) {
				         if(x.options[i].selected ==true){
				            var loanTypesId=x.options[i].value;
				          }
				    }
			 if($("#fhaNumber"+count).val().trim()==""){
				 isAvailble= false;
		    	 message += "FHA Number,";
			 }
			 if($("#loanAmount"+count).val().trim()==""){
				 isAvailble= false;
		    	 message += "Loan Amount,";
			 }
			 if($("#lenderName"+count).val().trim()==""){
				 isAvailble= false;
		    	 message += "Lender Name,";
			 }
			 if($("#endDate"+count).val().trim()==""){
				 isAvailble= false;
		    	 message += "Closing Date,";
			 }
			 if($("#loanAmount"+count).val() == "$0" || $("#loanAmount"+count).val() == "$0.00" || $("#loanAmount"+count).val() <= "$0.00" ){
				 isAvailble= false;
		    	 message += "Loan amount should be greater than $0 ,";
			 }
			/*  if($("#terminationDate"+count).val().trim()==""){
				 isAvailble= false;
		    	 message += "Termination Date,";
			 } */
			 if(loanTypesId=="Select Loan Type" || loanTypesId==""){
				 isAvailble= false;
		    	 message += "Loan Type ,";
			 }
			 if( new Date($("#endDate"+count).val()).getTime() > new Date($("#terminationDate"+count).val()).getTime() )
			 {
				 isAvailble= false;
			     message += "Termination date should be greater than Closing Date";
			 }
			 else if( new Date($("#endDate"+count).val()).getTime() < new Date($("#terminationDate"+count).val()).getTime())
			 {
				
			 }
			 else 
			 {
			 }
			 if(isAvailble == true){
				 var testData={
						 "companyId":companyIdValue,
						 "propertyId":parseInt(propertyId),
						 "loanTypeId":parseInt(loanTypesId),
						 "fhaNumber":$("#fhaNumber"+count).val(),
						 "loanAmount":$("#loanAmount"+count).val(),
						 "lenderName":$("#lenderName"+count).val(),
						 "closingDate":$("#endDate"+count).val(),
						 "terminationDate":$("#terminationDate"+count).val(),
						 "userId":userIdvalue
					};
				 console.log("810:::"+JSON.stringify(testData));
				 $.ajax({
						type : "POST",
						contentType : "application/json",
						url : "<%=restURL%>/orcf/addLoanInfo",
						dataType : 'json',
						timeout : 100000,
						data : JSON.stringify(testData),
						success : function(data) {
							 $("#tagscloud"+count).hide();
							if(data.key==200){
								 loanFlag=100;
								 $("#loanError"+count).hide();
								 $("#changeLoanMessage"+count).hide();
								  var loanSuccessMsg="Loan Information Added Successfully";
								  document.getElementById("successLoanMessage"+count).innerHTML = loanSuccessMsg ;
								  $("#successLoanMessage"+count).show();
							}else{
								$("#successLoanMessage"+count).hide();
								var loanChangeMsg="Please Change the FHA Number";
								document.getElementById("changeLoanMessage"+count).innerHTML = loanChangeMsg ;
							}
						},
						error : function(e) {
							console.log("ERROR: ", e);
						},
						done : function(e) {
							console.log("DONE");
						}
					}); 
			 }else{
				 /* if(message.endsWith(",")){ */
					   $("#loanError"+count).show();
					  if(message.substring(message.length-1)==',') {
						message = message.substring(0, message.length - 1);
					}
			    document.getElementById("loanError"+count).innerHTML = message ;
			 }
		}
/*function saveLoanInformationForEdit(addNewForm){*/  
</script>

<script type="text/javascript">
function saveLoanInformationAndadd(){
       var companyIdValue= '<%=companyId%>';
       var userIdvalue='<%=uid%>';
	   var isAvailble = true;
       var message="Please enter the parameters::";
	 	  var x=document.getElementById("listOfLoanTypes"+count);
				 for (var i = 0; i < x.options.length; i++) {
			         if(x.options[i].selected ==true){
			            var loanTypesId=x.options[i].value;
			          }
			    }
		 if($("#fhaNumber"+count).val().trim()==""){
			 isAvailble= false;
	    	 message += "FHA Number,";
		 }
		 if($("#loanAmount"+count).val().trim()==""){
			 isAvailble= false;
	    	 message += "Loan Amount,";
		 }
		 if($("#lenderName"+count).val().trim()==""){
			 isAvailble= false;
	    	 message += "Lender Name,";
		 }
		 if($("#endDate"+count).val().trim()==""){
			 isAvailble= false;
	    	 message += "Closing Date,";
		 }
		 if($("#loanAmount"+count).val() == "$0" || $("#loanAmount"+count).val() == "$0.00" || $("#loanAmount"+count).val() <= "$0.00"){
			 isAvailble= false;
	    	 message += "Loan amount should be greater than $ 0";
		 }
		
		 if(loanTypesId=="Select Loan Type" || loanTypesId==""){
			 isAvailble= false;
	    	 message += "Loan Type ,";
		 }
		 if( new Date($("#endDate"+count).val()).getTime() > new Date($("#terminationDate"+count).val()).getTime() )
		 {
			 isAvailble= false;
		     message += "Termination date should be  greater than Closing Date";
		 }
		 else if( new Date($("#endDate"+count).val()).getTime() < new Date($("#terminationDate"+count).val()).getTime())
		 {
			
		 }
		 else 
		 {
		 }

		 if(isAvailble == true){
			 var testData={
					 "companyId":companyIdValue,
					 "propertyId":parseInt(propertyId),
					 "loanTypeId":parseInt(loanTypesId),
					 "fhaNumber":$("#fhaNumber"+count).val(),
					 "loanAmount":$("#loanAmount"+count).val(),
					 "lenderName":$("#lenderName"+count).val(),
					 "closingDate":$("#endDate"+count).val(),
					 "terminationDate":$("#terminationDate"+count).val(),
					 "userId":userIdvalue
				};
			 $.ajax({
					type : "POST",
					contentType : "application/json",
					url : "<%=restURL%>/orcf/addLoanInfo",
					dataType : 'json',
					timeout : 100000,
					data : JSON.stringify(testData),
					success : function(data) {
						$("#loanError"+count).hide();
						if(data.key==200){
						$("#disabletrdynamic"+count).hide();
						$("#loanError"+count).hide();
						$("#changeLoanMessage"+count).hide();
						  var loanSuccessMsg="Loan Information Added Successfully";
						  document.getElementById("successLoanMessage"+count).innerHTML = loanSuccessMsg ;
						  $("#successLoanMessage"+count).show()
						  loanFlag=0;
						  count++;
							 $.ajax({
									type : "GET",
									contentType : "application/json",
									url : "<%=restURL%>/orcf/getLoanTypes?companyId="+companyIdValue,
									dataType : 'json',
									timeout : 100000,
									success : function(data) {  
									       for(i=0;i<data.response.length;i++){
									    	   $("#listOfLoanTypes"+count).append("<option value='"+data.response[i].loanTypeId+"'><b>"+data.response[i].loanType+"</b></option>");
									      } 
									    		},
									error : function(e) {
										console.log("ERROR: ", e);
									},
									done : function(e) {
										console.log("DONE");
									}
								     });
							    var div = $("<div />");
					 	        div.html(GetDynamicTextBox(""));
					 	        $("#TextBoxContainer").append(div);
						}else{
						  	if(loanFlag != 100){
							var loanChangeMsg="Please Change the FHA Number";
							document.getElementById("changeLoanMessage"+count).innerHTML = loanChangeMsg ;
						  	}else{
						  	//	$("#successLoanMessage"+count).hide();
							  	$("#changeLoanMessage"+count).hide();
							  	$("#disabletrdynamic"+count).hide();
							  	loanFlag=0;
							  	 count++;
								 $.ajax({
										type : "GET",
										contentType : "application/json",
										url : "<%=restURL%>/orcf/getLoanTypes?companyId="+companyIdValue,
										dataType : 'json',
										timeout : 100000,
										success : function(data) {  
										       for(i=0;i<data.response.length;i++){
										    	   $("#listOfLoanTypes"+count).append("<option value='"+data.response[i].loanTypeId+"'><b>"+data.response[i].loanType+"</b></option>");
										      } 
										    		},
										error : function(e) {
											console.log("ERROR: ", e);
										},
										done : function(e) {
											console.log("DONE");
										}
									     });
								    var div = $("<div />");
						 	        div.html(GetDynamicTextBox(""));
						 	        $("#TextBoxContainer").append(div);
						  	}
						}
						
					},
					error : function(e) {
						console.log("ERROR: ", e);
					},
					done : function(e) {
						console.log("DONE");
					}
				}); 
		 }else{
			 /* if(message.endsWith(",")){ */
				   $("#loanError"+count).show();
				  if(message.substring(message.length-1)==',') {
					message = message.substring(0, message.length - 1);
				}
		    document.getElementById("loanError"+count).innerHTML = message ;
		 }
		 
	}

</script>


<!-- Save and Add New Loan Details Form In Edit -->
<script type="text/javascript">
var loanInformationArray = [];
function addLoanData() {
	var loanInfoObject = {};
	loanInfoObject.loanTypeId=2;
	var isAvailble = true;
    var message="Please Enter the parameters::";
	if(count === 0)
	{
	 	 var loanType=$('#listOfLoanTypes :selected').val();
		 if($("#efhaNumber").val()==""){
			 isAvailble= false;
	    	 message += "Fha Number ,";
		 }
		 if($("#eloanAmount").val()==""){
			 isAvailble= false;
	    	 message += "Loan  Amount ,";
		 }
		 if($("#elenderName").val()==""){
			 isAvailble= false;
	    	 message += "Lender Name ,";
		 }
		 if($("#eendDate").val()==""){
			 isAvailble= false;
	    	 message += "End Date ,";
		 }
		 if(loanType=="Select Loan Type"){
			 isAvailble= false;
	    	 message += "Loan Type ,";
		 }
		 if(isAvailble == true){
		loanInfoObject.fhaNumber = $("#efhaNumber").val();
		loanInfoObject.loanAmount = $("#eloanAmount").val();
		loanInfoObject.lenderName = $("#elenderName").val();
		loanInfoObject.closingDate = $("#eendDate").val();
		loanInfoObject.loanTypeId=loanType;
		//alert("loanInfoObject:"+JSON.stringify(loanInfoObject));
		loanInformationArray.push(loanInfoObject);
		loanInfoObject=null;	
		propertyObject.loanInformationRequest =  loanInformationArray;
		count++;
		//alert("122");
		return true;
		 }else{
			 alert("Message:::::::"+message);
			 return false;
		 }
		 
	}else
	{
		 if($("#efhaNumber"+count).val()==""){
			 isAvailble= false;
	    	 message += "Fha Number ,";
		 }
		 if($("#eloanAmount"+count).val()==""){
			 isAvailble= false;
	    	 message += "Loan  Amount ,";
		 }
		 if($("#elenderName"+count).val()==""){
			 isAvailble= false;
	    	 message += "Lender Name ,";
		 }
		 if($("#eendDate"+count ).val()==""){
			 isAvailble= false;
	    	 message += "End Date ,";
		 }
		 if(isAvailble == true){
			    loanInfoObject.fhaNumber = $("#efhaNumber"+count).val();
				loanInfoObject.loanAmount = $("#eloanAmount"+count).val();
				loanInfoObject.lenderName = $("#elenderName"+count).val();
				loanInfoObject.closingDate = $("#eendDate"+count ).val();
				 var x=document.getElementById("listOfLoanTypes"+count);
				 for (var i = 0; i < x.options.length; i++) {
			         if(x.options[i].selected ==true){
			            var loanTypesId=x.options[i].value;
			          }
			    }
				loanInfoObject.loanTypeId=loanTypesId;
				//alert("152:"+JSON.stringify(loanInfoObject));
				loanInformationArray.push(loanInfoObject);
				loanInfoObject=null;	
				propertyObject.loanInformationRequest =  loanInformationArray;
				count++;
				return true;
		 }else{
			 alert("Message:::::::"+message);
			 return false;
		 }
	}
}

/*SaveLoanInformationAndAddNewLoanInEdit*/
</script>


<script type="text/javascript">
	function closeLoanInformation() {
		$("#fhaNumber" + count).val("");
		$("#loanAmount" + count).val("");
		$("#listOfLoanTypes" + count).val("");
		$("#lenderName" + count).val("");
		$("#endDate" + count).val("");
		$("#terminationDate" + count).val("");
		$("#loanError"+count).hide();
		//$("#tagscloud"+count).hide();
		//$("#changeLoanMessage"+count).hide();
	}
	function resetLoanInformation(checkresetValue){
		document.getElementById("loanError" + checkresetValue).innerHTML  = "";
		$("#efhaNumber" + checkresetValue).val("");
		$("#eloanAmount" + checkresetValue).val("");
		$("#elistOfLoanTypes" + checkresetValue).val("");
		$("#elenderName" + checkresetValue).val("");
		$("#eendDate" + checkresetValue).val("");
		$("#eterminationDate" + count).val("");
	}
</script>
<script type="text/javascript">
	function GetDynamicTextBox(value) {
		return '<div  id="dynamicDiv'+count+'" style="border-top:1px solid #000;margin-bottom:15px;margin-top:15px;"></div>'
				+ '<div  id="dynamicDiv1'
				+ count
				+ '" style="text-align:center;font-family: Geneva,Arial,Helvetica,roboto !important;color: green;font-size: 16px;">Loan Information</div>'
				+ '<input name = "DynamicTextBox" type="hidden" value = "' + value + '" />&nbsp;'
				+ '<input type="hidden" value="Remove" class="remove" />'
				+ '<div style="text-align:center;" id="successMessage'+count+'">'
				+ ' <span id="successLoanMessage'+count+'" style="color: green;"></span>'
				+ ' </div>'
				+ '<div style="text-align:center;" id="changeMessage'+count+'">'
				+ ' <span id="changeLoanMessage'+count+'" style="color: red;"></span>'
				+ ' </div>'
				+ '<div style="text-align:center;" id="tagscloud'+count+'">'
				+ ' <span id="loanError'+count+'" style="color: red;"></span>'
				+ ' </div>'
				+ '<table id="dynamicTable'+count+'"   class="table loanTable" cellspacing="0">'
				+ ' <tbody>'
				+ ' <tr>'
				+ ' <td class="wisth200">Associated FHA Number <span class="requiredStar">*</span></td>'
				+ '<td colspan="3">'
				+ '  <input size="50" class="tableInputselectStyle123 loanStyle" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="fhaNumber'
				+ count
				+ '" name="propertyId"  value="" maxlength="150"  onfocus="duplicateFhanumberCheck('+this.value+','+count+')">'
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td class="wisth200">Loan Type<span class="requiredStar">*</span></td>'
				+ ' <td>'
				+ '<select id="listOfLoanTypes'+count+'" class="tableInputselectStyle123  selectLoanTypeclass loanStyle">'
				+ ' <option value="">Select Loan Type</option>'
				+ ' </select>'
				+ '</td> '
				+ '</tr>'
				+ '<tr>'
				+ ' <td class="wisth200">Loan Amount<span class="requiredStar">*</span></td>'
				+ '<td colspan="3">'
				+ '   <input size="50" maxlength="15"  class="tableInputselectStyle123  currency loanStyle no-spin" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="loanAmount'
				+ count
				+ '" name="city" value="" >'
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ ' <td class="wisth200">Lender Name<span class="requiredStar">*</span></td>'
				+ ' <td colspan="3">'
				+ '  <input size="50"  class="tableInputselectStyle123 loanStyle" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="lenderName'
				+ count
				+ '" name="city" value="" >'
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ ' <td class="wisth200">Closing Date <span class="requiredStar">*</span></td>'
				+ ' <td>'
				+ ' <input id="endDate'
				+ count
				+ '"  type="text" class="tableInputselectStyle123 loanStyle endDate col-sm-12 inputStyle1" placeholder="Closing Date" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3) !important;background:#fff;"  readonly>'
				+ '</td>'
				+ '  </tr>'
				+ '<tr>'
				+ ' <td class="wisth200">Termination Date <span class="requiredStar"></span></td>'
				+ ' <td>'
				+ ' <input id="terminationDate'
				+ count
				+ '"  type="text" class="tableInputselectStyle123 loanStyle endDate col-sm-12 inputStyle1" placeholder="Termination Date" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3) !important;background:#fff;"  readonly>'
				+ '</td>'
				+ '  </tr>'
				+ '<tr id="disabletrdynamic'+count+'">'
				+ ' <td></td>'
				+ '<td>'
				+ '<input name="button2" id="button2" class="btn btn-success waves-effect waves-button waves-float" style="margin-left: 20px;" type="button" value="Save" onClick ="saveLoanInformation()">'
				+ '<input name="button2" id="btnAdd" class="btn btn-success waves-effect waves-button waves-float" style="margin-left: 15px;" type="button" value="Save & Add  New Loan"  onClick ="saveLoanInformationAndadd()">'
				+ '<input name="button" id="button" class="btn btn-warning waves-effect waves-button waves-float" style="margin-left: 15px;" type="button" value="Reset" onclick="closeLoanInformation()" > '
				+ '</td>' +

				'</tr>' + '</tbody>' + '</table>'

	}
</script>


<script type="text/javascript">

</script>



<style type="text/css">
.no-spin::-webkit-inner-spin-button, .no-spin::-webkit-outer-spin-button
	{
	-webkit-appearance: none !important;
	margin: 0 !important;
	-moz-appearance: textfield !important;
}

.fullarticle {
	display: none;
}

.panel-body {
	text-align: left;
	padding-left: 15px;
}

.modal {
	text-align: center;
	padding: 0 !important;
}
table.dataTable thead .sorting_asc {
    background-image: url(up.png) !important;
    color: #fff !important;
    background-size: 20px 11px;
}

table.dataTable thead .sorting_desc {
     background-image: url(down.png) !important;
    color: #fff !important;
    background-size: 20px 11px;
}
.wisdth200 {
	width: 200px !important;
}

.modal:before {
	content: '';
	display: inline-block;
	height: 100%;
	vertical-align: middle;
	margin-right: -4px;
}

.addPropertyLoan {
	width: 68%;
}

.loanStyle {
	width: 63% !important;
	margin-left: 10px;
}

.tableInputselectStyle123 {
	box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3) !important;
	width: 63%;
	padding: 2px;
}

.tableInputselectStyle12345 {
	margin-left: 5px;
	width: 62% !important;
	padding: 2px;
}

.tableInputselectStyle1234567 {
	margin-left: 112px;
	width: 51% !important;
	padding: 2px;
}

/* .tableInputselectStyle12345{
margin-left: 5px;
    width: 62% !important;
        padding: 2px;
} */
.selectStyle123 {
	box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3) !important;
	width: 56%;
	padding: 2px;
}

.tableInputselectStyle123:focus {
	border: 1px solid #00bcd4 !important;
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

.applicationMainContentAreaContainer {
	position: relative;
}

table.dataTable thead th {
	background-color: #7098CC;
	color: #fff;
}

#moduleLists_filter input {
	height: 35px;
	border: 1px solid #ccc;
	box-shadow: inset 0 0 3px #ccc;
}

.loanTable>tbody>tr>td {
	border-bottom: 0px !important;
}

#moduleLists_length select {
	padding: 10px;
	border: 1px solid #ccc;
	box-shadow: inset 0 0 3px #ccc;
}

.dataTables_filter {
	margin-bottom: 10px;
}
</style>
<script src="js/jquery.sidr.min.js"></script>
<script src="jscript/jquery.easing.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />

</head>


<DIV id=preview_div
	style="DISPLAY: none; POSITION: absolute; BORDER-LEFT-COLOR: #777777"></DIV>

<jsp:include page="includes/sessionHeader.jsp" />


<body onLoad="loadFunction()">
	<div class="buttonAction">
		<button class="btn btn-success pull-right btn-orange" id="addRightBtn"
			onclick="addRightForm()">
			<div class="d-table">
				<div class="d-tbcell v-middle">
					<i class="zmdi_medium zmdi-plus-circle-o"></i>
				</div>
				<div class="p-left10 d-tbcell v-middle">Add Property</div>
			</div>
		</button>
		<button id="backBtn1"
			class="btn btn-success pull-right btn-orange width120"
			onclick="goBack()" style="display: none;">
			<div class="d-table">
				<div class="d-tbcell v-middle">
					<i class="zmdi_medium zmdi zmdi-caret-left-circle"></i>
				</div>
				<div class="p-left10 d-tbcell v-middle">Back</div>
			</div>
		</button>

	</div>

	<div align="center" style="margin: 10px;">
		<div>
			<div>
				<div class="" style="min-height: 460px;">

					<div id="addRightList" class="smallSectionTextPadding"
						style="min-height: 420px; background-color: #FFF; padding: 20px;">

						<!-- <div id="loadingImage"><img src="css/images/default.gif" /></div>
			<div id="tableStyle1" style="display:none"> -->
						<div id="loadingImage"
							style="position: absolute; top: 30%; left: 0px; right: 0px; margin: auto; text-align: center">
							<img src="css/images/default.gif" />
						</div>
						<div id="tableStyle1" style="display: none;">
							<div id="successDeleteMessage"></div>
							<div class="table-responsive">
								<table id="propertyListsData"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">

									<thead>
										<tr>
											<th hidden>FHA Number</th>
											<th>Property Id</th>
											<th>Property Name</th>
											<th>City</th>
											<th>State</th>
											<th>Zip</th>
											<th style="display: none">Id</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody id="propertyList">

									</tbody>
								</table>
							</div>

						</div>
					</div>

					<!-- for adding new property and loan -->

					<div id="addPropertyForm" align="center" style="margin: 20px;">
						<p
							style="color: green; font-size: 16px; text-align: left; margin-bottom: 10px; padding-left: 10px;">
							Add Property & Loan Information</p>
						<div class="card"
							style="width: 95%; padding-left: 0px; position: relative; background: #fff; box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15); border-top: 1px solid rgba(0, 0, 0, 0.15); margin-bottom: 30px;">
							<div
								style="background-color: #EDECEC; padding: 23px 26px; box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
									<div style="text-align: center;" id="tagscloud">
										<span id="texterr" style="color: red;"></span>
									</div>
									<div style="text-align: center;" id="successmsg">
										<h4
											style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;">
											<i class="zmdi_medium zmdi-check"></i> <span
												style="padding-left: 8px;">Property added
												successfully</span>
										</h4>
									</div>
									<div style="text-align: center;" id="editmsg">
										<h4
											style="color: red; border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;">
											<i class="zmdi_medium zmdi-close-circle"></i> <span
												style="padding-left: 8px;">Please Change the Property
												Id</span>
										</h4>
									</div>
								</div>
								<div id="loadingImage123"
									style="position: absolute; top: 30%; left: 0px; right: 0px; margin: auto; text-align: center">
									<img src="css/images/default.gif" />
								</div>
								<table class="table loanTable" cellspacing="0">
									<tbody>
										<tr>
											<td class="wisth200">Property ID <span
												class="requiredStar">*</span></td>
											<td colspan="3"><input class="tableInputselectStyle123"
												size="50"
												style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
												type="text" id="propertyId" name="propertyId" value=""
												maxlength="150"></td>
											</td>
										</tr>
										<tr>
											<td class="wisth200">Property Name <span
												class="requiredStar">*</span></td>
											<td colspan="3" class="addPropertyLoan"><input
												class="tableInputselectStyle123" size="50"
												style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
												type="text" id="propertyName" name="propertyName" value=""
												maxlength="150"></td>
										</tr>
										<tr>
											<td class="wisth200">Property City <span
												class="requiredStar">*</span></td>
											<td colspan="3"><input class="tableInputselectStyle123"
												size="50"
												style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
												type="text" id="city" name="city" value=""></td>
										</tr>
										<tr>
											<td class="wisth200">Property State <span
												class="requiredStar">*</span></td>
											<td><select id="listStates"
												class="tableInputselectStyle123">
													<option value="Select State">Select State</option>
											</select></td>
										</tr>
										<tr>
											<td class="wisth200">Property Zip <span
												class="requiredStar">*</span></td>
											<td colspan="3"><input
												class="tableInputselectStyle123  no-spin" size="50"
												style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
												type="number" onblur="checkZIPValid()" id="zip" name="zip" value=""></td>
										</tr>
										<tr>
											<td class="wisth200">Property Type <span
												class="requiredStar">*</span>
											</td>
											<td><select id="lstFruits345"
												class="tableInputselectStyle123">
													<option>Select Property Type</option>
											</select></td>
										</tr>
										<tr>
											<td class="wisth200">Property Status <span
												class="requiredStar">*</span></td>
											<td><select id="propertyStatus"
												class="tableInputselectStyle123 ">
													<option value="Active">Active</option>
													<option value="Inactive">Inactive</option>
											</select></td>
										</tr>
										<div id="buttonsDiv">
											<tr id="buttonsTr">
												<td></td>
												<!-- For adding property and loan -->
												<td style="text-align: left; padding-top: 20px;"><input
													name="button2" id="button2" 
													class="btn btn-success waves-effect waves-button waves-float"
													onclick="savePropertyRequest()" style="" type="button"
													value="Save"> <input name="button2" id="btnAdd"
													class="btn btn-success waves-effect waves-button waves-float"
													style="margin-left: 15px;" type="button"
													value="Save & Add  New Loan"
													onClick="addLoanInformation()"> <input
													name="button" id="button"
													class="btn btn-warning waves-effect waves-button waves-float"
													style="margin-left: 15px;" type="button" value="Cancel"
													onclick="goBack()"></td>
											</tr>
										</div>
									</tbody>
								</table>



								<div id="TextBoxContainer">
									<!--Textboxes will be added here -->


								</div>
							</div>
						</div>
					</div>

					<!-- for edit -->
					<div id="editPropertyForm" align="center" style="margin: 20px;">
						<p
							style="color: green; font-size: 16px; text-align: left; margin-bottom: 10px; padding-left: 10px;">
							Edit Property & Loan Information</p>
						<div class="card"
							style="width: 95%; padding-left: 0px; position: relative; background: #fff; box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15); border-top: 1px solid rgba(0, 0, 0, 0.15); margin-bottom: 30px;">
							<div
								style="background-color: #EDECEC; padding: 23px 26px; box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
									<div style="text-align: center;" id="editsuccessmsg">
										<h4
											style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;">
											<i class="zmdi_medium zmdi-check"></i> <span
												style="padding-left: 8px;">Property added
												successfully</span>
										</h4>
									</div>
									<div style="text-align: center;" id="editerrormsg">
										<h4
											style="color: red; border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;">
											<i class="zmdi_medium zmdi-close-circle"></i> <span
												style="padding-left: 8px;">Please Change the Property
												Id</span>
										</h4>
									</div>

									<div style="text-align: center;" id="textError">
										<h4
											style="color: red; border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;">
											<i class="zmdi_medium zmdi-close-circle"></i> <span
												style="padding-left: 8px;">This Property Id Has
												Associated Documents</span>
										</h4>
									</div>

									<!-- updatePropertySuccess -->
									<div style="text-align: center;" id="updatePropertySuccess">
										<h4
											style="color: green; border-bottom: 1px dotted rgb(0, 128, 0); padding: 5px; margin-bottom: 12px;">
											<i class="zmdi_medium zmdi-check"></i> <span
												style="padding-left: 8px;">Property Details Updated
												Successfully!</span>
										</h4>
									</div>
                                    <div style="text-align: center;" id="tagscloud">
										<span id="texterrEdit" style="color: red;"></span>
									</div>


								</div>
								<table class="table loanTable" cellspacing="0">
									<tbody>
										<tr>
											<td class="wisth200">Property ID <span
												class="requiredStar">*</span></td>
											<td colspan="3" class="addPropertyLoan">
												<!-- <div>Input Field</div> --> <input
												class="tableInputselectStyle123" size="50"
												style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
												type="text" id="epropertyId" name="epropertyId" value=""
												onfocus="javascript:duplicateCheck(this.value);"
												maxlength="150">
											</td>
										</tr>
										<tr>
											<td class="wisth200">Property Name <span
												class="requiredStar">*</span></td>
											<td colspan="3" class="addPropertyLoan">
												<!-- <div>Input Field</div> --> <input
												class="tableInputselectStyle123" size="50"
												style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
												type="text" id="epropertyName" name="epropertyName" value=""
												maxlength="150">
											</td>
										</tr>
										<tr>
											<td class="wisth200">Property City<span
												class="requiredStar">*</span></td>
											<td colspan="3">
												<!-- <div>Input Field</div>  --> <input
												class="tableInputselectStyle123" size="50"
												style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
												type="text" id="ecity" name="ecity" value="">
											</td>
										</tr>
										<tr>
											<td class="wisth200">Property State<span
												class="requiredStar">*</span></td>
											<td><select id="elistStates"
												class="tableInputselectStyle123">
													<option>Select State</option>
											</select></td>
										</tr>
										<tr>
											<td class="wisth200">Property Zip<span
												class="requiredStar">*</span></td>
											<td colspan="3">
												<!-- <div>Input Field</div> --> <input
												class="tableInputselectStyle123" size="50"
												style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
												type="text" id="ezip" name="ezip" value="" onblur="checkZipValidation();">
											</td>
										</tr>
										<tr>
											<td class="wisth200">Property Type<span
												class="requiredStar">*</span></td>
											<td><select id="elstFruits345"
												class="tableInputselectStyle123">
													<option>Select Property Type</option>
											</select></td>
										</tr>
										<tr>
											<td class="wisth200">Property Status<span
												class="requiredStar">*</span></td>
											<td><select class="tableInputselectStyle123 "
												id="ePropertyStatus">
													<option>Active</option>
													<option>Inactive</option>
											</select></td>
										</tr>
										<tr>
											<td></td>
											<td style="text-align: left; padding-top: 30px">
											
											<input
												name="button2" id="button2"
												class="btn btn-success waves-effect waves-button waves-float"
												onclick="updatePropertyInfo(false)" style="" type="button"
												value="Update"> <!-- save and add new loan for property property -->
												
											<input name="button2" id="loanButton"
												class="btn btn-success waves-effect waves-button waves-float"
												onclick="updatePropertyInfo(true)"
												style="margin-left: 19px;" type="button"
												value="Update & Add New Loan"> 
											<!-- <input name="button"
												id="button"
												class="btn btn-warning waves-effect waves-button waves-float"
												style="margin-left: 15px;" type="button" value="Cancel"> -->
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div align="center" style="margin-top: -28px;" id="editLoanInfo">
						</div>

						<div id="addRightForm" class="smallSectionTextPadding"
							style="min-height: 420px; display: none; height: 420px; background-color: #FFF; padding: 20px;">
							<div id="loadingImage12"
								style="position: absolute; top: 30%; left: 0px; right: 0px; margin: auto; text-align: center">
								<img src="css/images/default.gif" />
							</div>
							<div id="loadingImage123"
								style="position: absolute; top: 30%; left: 0px; right: 0px; margin: auto; text-align: center">
								<img src="css/images/default.gif" />
							</div>
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
									<div style="text-align: center;" id="successmsg">
										<h4
											style="color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;">
											<i class="zmdi_medium zmdi-check"></i> <span
												style="padding-left: 8px;">Property added
												successfully</span>
										</h4>
									</div>
								</div>
								<div
									class="col-lg-offset-2 col-lg-8 col-lg-offset-2  col-md-offset-2 col-md-8 col-md-offset-2 col-sm-offset-2 col-sm-8 col-sm-offset-2 col-xs-12"
									style="margin-top: 80px;">

									<div class="col-lg-4 col-md-4 col-sm-4">
										<label style="margin-top: 10px; font-size: 15px;">Module
											Name</label>
									</div>
									<div class="col-lg-8 col-md-8 col-sm-8 ">
										<input id="moduleName" name="moduleName"
											class="form-control input-lg text-center"
											placeholder="Enter Module Name" type="text"
											onfocus="javascript:addClass();" onblur="" required>
									</div>



								</div>
								<div
									class="col-lg-offset-2 col-lg-8 col-lg-offset-2  col-md-offset-2 col-md-8 col-md-offset-2 col-sm-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 text-center"
									style="margin-top: 30px;">
									<button type="submit" id="submitbtndisa"
										class="btn btn-success text-left btn-orange width120"
										onclick="saveModules()">Submit</button>
								</div>
							</div>
						</div>
						<!-- Rights Area -->

					</div>
				</div>
			</div>
		</div>
	</div>



	<script language="javascript">
		function getXMLObject() //XML OBJECT
		{
			var xmlHttp = false;
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); // For Old Microsoft Browsers
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); // For Microsoft IE 6.0+
				} catch (e2) {
					xmlHttp = false; // No Browser accepts the XMLHTTP Object then false
				}
			}
			if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
				xmlHttp = new XMLHttpRequest(); //For Mozilla, Opera Browsers
			}
			return xmlHttp; // Mandatory Statement returning the ajax object created
		}

		function initial_load() {
			setHeader('propertyRequest.jsp');
			var array_of_li =  document.querySelectorAll("ul.tab-nav li");
			for (var i = 0; i < array_of_li.length; i++) {
			if(i == 1)
				array_of_li[i].setAttribute("class", "active");	
				
			}
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
			$("#adminWizardLi").collapse('toggle');

		}

		String.prototype.trim = function() {
			return this.replace(/^\s*/, "").replace(/\s*$/, "");
		}
		
		function duplicateCheck(id) 
		{ 
			
			 	$('#textMsg').empty();
			 	var path = "/"+id+"/";
			   	var companyId = '<%=companyId%>';
			   	var userIdvalue='<%=uid%>';
			   	var tbl = '';
			    var testData={
			       "propertyId":path,	 	    
			    	"companyId":companyId  
			     };
			   $.ajax({
			    type : "POST",
			    contentType : "application/json",
			    url : "<%=restURL%>/orcf/getPropertyDocList",
			 dataType : 'json',
			 timeout : 100000,
			 data : JSON.stringify(testData),
			 success : function(data) {
				
				 if(data.key == "200"){ $('#textError').show();
				 //$('#textError').html(data.response);
				 $("#epropertyId").prop('disabled', true);}
			 },
			 error : function(e) {
			 console.log("ERROR: ", e);

			 },
			 done : function(e) {
			 }
			 });
	 }
		function duplicateFhanumberCheck(index,newLoan) 
		{ 
			
			 	$('#textMsg' + index).empty();
			 	
			   	var companyId = '<%=companyId%>';
			   	var userIdvalue='<%=uid%>';
			   	var tbl = '';
			    var testData={
			       "propertyId":$("#epropertyId").val(),	 	    
			    	 "fhaNumber":$("#efhaNumber"+index).val()
			       
			     };
			   $.ajax({
			    type : "POST",
			    contentType : "application/json",
			    url : "<%=restURL%>/orcf/getFHANumberEixst",
			 dataType : 'json',
			 timeout : 100000,
			 data : JSON.stringify(testData),
			 success : function(data) {
				 if(data.key == "200"){ 
					$('#textMsg'+ index).html(data.response);
						
					//alert('new loan..'+newLoan);
						if(newLoan){
							$("#efhaNumber"+ index).prop('disabled', true); 
						}				
				 }
			 },
			 error : function(e) {
			 console.log("ERROR: ", e);

			 },
			 done : function(e) {
			 }
			 });
	 }
		   function getFilesist(propertyid,fhaNumber,index){
			   
				$('#textMsg'+index).empty();
								   
                     var path = "/"+propertyid+"/"+fhaNumber+"/";
                   //  alert("path"+path)
				   	 var companyId = '<%=companyId%>';
				   	 var userIdvalue='<%=uid%>';
				   	 var tbl = '';
				   	  var testData={
				   			 // "propertyId":$("#propertyId").val(),
				   			     "propertyId":path,	  	     
				   			  	  "companyId":companyId
				   	     
				   	   };
				   	  			   	
				    
				   	 $.ajax({
				   	  type : "POST",
				   	  contentType : "application/json",
				   	  url : globalRestUrl+"/orcf/getPropertyDocList",
						dataType : 'json',
						timeout : 100000,
						data : JSON.stringify(testData),
						success : function(data) {

							if (data.key == 200) {
								// alert(data.getDocumentList.length)
								$('#textMsg' + index)
										.html(
												"Documents are associated and Can`t Change the FHA number.");
							}

						},
						error : function(e) {
							console.log("ERROR: ", e);

						},
						done : function(e) {

						}

					});
			duplicateFhanumberCheck(index,false);
		}
	</script>

</body>
</html>

