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
	<style>
	table.audittab tr:nth-child(even) {background-color: #f2f2f2;}
	table.audittab tbody,tr,td {font-size:12px;font-family:roboto;}
	p.auditclass  {font-size:12px !important;font-family:roboto !important;word-break: break-word;}
	</style>
		<title>Transaccess Imaging Administrator Edit User Profile</title>
		<meta name="pageHeading" content='Imaging Registration' />
		<link rel="stylesheet" href="css/bootstrap.css"></link>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<script src="js/jQuery/1.11.3/jquery.min.js"></script>
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>			
	
	</head>	
	
	
	 <% 	
		HashMap hashMap = userInformation.supervisorGetUserProfile(request);
		String htmlAuditTrail = userInformation.getUserAuditTrail(request);
		String otp=hashMap.get("OTP").toString();

		  javax.naming.Context ctx = 	new javax.naming.InitialContext();
			String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
		
	%>
	
	<%--<jsp:include page="includes/sessionHeader.jsp" /> --%>
	
<body onLoad="initial_load()">	
	
<script type="text/javascript">
var userID;
var userRoleID;
	var url = window.location.href; // or window.location.toString()
	if(url.split("=").length==3){
		userID=url.split("=")[1];
		userRoleID=url.split("=")[2];
		}else{
			userID=url.split("=")[2];
			userRoleID=url.split("=")[3];
			}
	
	//alert("userID"+userID+" userRoleID "+userRoleID);
	//alert(url.split("=").length)
	
	$(window).bind("load", function() {
		document.getElementById("userRoleID").setAttribute('value',userRoleID);
	});
	$(document).mousemove(function(event){
		  InitializeTimer();
	});
function validateEmail(email) 
{  
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))  
	  {  
	    return (true); 
	  } 
   
    return (false);

}
function validateZip(zip)
{
	if( /(^\d{5}$)|(^\d{5}-\d{4}$)/.test(zip))
	{
		return true;
	}
	return false;
}
function validatePhone(phone)  
{  

	if( /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(phone))
	{
		return true;
	}
	return false;
 
}  
function fnGetLandNo(){
	var num= Math.floor(1000000 + Math.random() * 9000000);
	
	return '720'+num;
 }

function fnOTP(otpchanged){
	$("#otpVal").val(otpchanged);
	if(otpchanged=='M' && $("#cellPhone").val()== ""){
		alert("Mobile Number is required");
		
	}
}



function validate_form()
{
	var otpval=$("#otpVal").val();
	if(otpval=='M' && $("#cellPhone").val()== ""){
		alert("Mobile Number is required");
		return false;
	}

   if ( document.registrationForm.first_name.value == "" )
    {
        alert ( "Please fill in the FIRST NAME field." );
        return false;
    }
    else if ( document.registrationForm.last_name.value == "" )
    {
        alert ( "Please fill in the LAST NAME field." );
        return false;
    }
    else if ( document.registrationForm.email.value == "" )
    {
        alert ( "Please fill in the EMAIL field." );
        return false;
    }
    if(!validateEmail(document.getElementById('email').value)) 
	{  
  		alert("Not a valid e-mail address");
 		return false;
	}
   
   

	 if(document.getElementById('cellPhone').value !="" &&!validatePhone(document.getElementById('cellPhone').value)) 
	{  
  		alert("Not a valid mobile number. Please enter mobile number in XXX-XXX-XXXX format");
 		return false;
	}
		
	 if(document.getElementById('zip').value != "" &&!validateZip(document.getElementById('zip').value)) 
		{  
			
	  		alert("Not a valid zip code");
	 		return false;
		}
   
		var mobileChange='no';
		 <%String cellPhone = (String)hashMap.get("cellPhone");
	     if(cellPhone == null) cellPhone="";	
	   %>
	   if(document.getElementById('cellPhone').value != '<%=cellPhone%>'){
	   	mobileChange='yes';
	   	
	   	
	   }
	   <%String email = (String)hashMap.get("email");
	    if(email == null) email="";	
	  %>
	  if(document.getElementById('email').value != '<%=email%>'){
	  	mobileChange='yes';
	  	
	  	
	  }
	    
	 

	if(otpval != '<%=otp%>'){
		mobileChange='yes';
		
		
	}
   	document.registrationForm.last_name.value = document.registrationForm.last_name.value.replace(/'/g, "''");
	document.registrationForm.first_name.value = document.registrationForm.first_name.value.replace(/'/g, "''");
	document.registrationForm.city.value = document.registrationForm.city.value.replace(/'/g, "''");
	document.registrationForm.address1.value = document.registrationForm.address1.value.replace(/'/g, "''");
	document.registrationForm.address2.value = document.registrationForm.address2.value.replace(/'/g, "''");
	
    document.getElementById('button2').disabled = true;
    if(otpval=='E' && $("#cellPhone").val()== "" && $("#phone_no").val()==""){
    	//	 alert(otpval+"---hii--"+$("#cellPhone").val());
    		
    		 mobileChange=='yes';
    		} 
    if(mobileChange=='yes'){
		mobleChange();
	}else{
    document.registrationForm.submit();
	}
}
function mobleChange(){
	

	var mnumber=document.getElementById('cellPhone').value;
 	if($("#otpVal").val()=='E'){
 		mnumber=fnGetLandNo();
 	}	


	var email=document.getElementById('email').value;
	var userid='<%=hashMap.get("userId") %>' ;
	var token=sessionStorage.getItem("token");
	$.ajax({
		type : "POST",
		headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
		contentType : "application/json",
		url : "<%=restURL%>role/saveTwillouser",
		dataType : 'json',
		timeout : 100000,
	  data:JSON.stringify({'email':email,'phone':mnumber,'ccode':'+91','userId':userid,'not':'nosms'}),
		success : function(data) {
			
			if(data.key=="200"){
				document.getElementById('AUTH_ID').value=data.authId;
				document.registrationForm.submit();
				 
			}else if(data.key=="201"){
				 // jAlert(data.status.message, 'Error');
				alert(data.message.message)
				//$("#popup_error").text(data.status.message);
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
function LettersOnly(evt) 
{
       var textBoxObj = document.getElementById('first_name');
       evt = (evt) ? evt : event;
       var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
          ((evt.which) ? evt.which : 0));
       if (charCode != 39 &&(charCode > 32 && (charCode < 65 || charCode > 90) &&
          (charCode < 97 || charCode > 122)))                 // Letters Only
                
       {       	 
         	alert("Please enter letters only.");
         	return false;         
          
       }
       
       if (textBoxObj.value.length > 39) 
       {          
        	var val = textBoxObj.value.substring(0,40);  
       		textBoxObj.value = "";
       		textBoxObj.value = val;
       		alert("First Name can not exceed 40 characters"); 
       		
       } 
       
       return true;
     }


var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object
function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}

function resetPassword() {

var sts = 	"<%= (String) hashMap.get("status") %>"; 
if(sts != null && sts != "Active")
{
	alert("Your Account  has been disabled, please contact your company administrator.");
	return;
}

var username = '<%=hashMap.get("username") %>';

var answer = confirm("Click OK to confirm you want to reset the password for "+ username + "?")
if (!answer)return;

var username = '<%=hashMap.get("username") %>';
var sessionid = '<%=request.getSession().getAttribute("sessionid") %>';



if(xmlhttp) { 
	
    xmlhttp.open("POST","GetAdminPasswordReset",true); 
    xmlhttp.onreadystatechange  = handleResetPwdResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("username=" + username + "&sessionId=" + sessionid);
  } 
} 

function statusChange() {

var username = '<%=hashMap.get("username") %>';
var sessionid = '<%=request.getSession().getAttribute("sessionid") %>';

if(xmlhttp) { 
	
    xmlhttp.open("POST","GetUserStatusChange",true); 
    xmlhttp.onreadystatechange  = handleResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("username=" + username + "&sessionId=" + sessionid);
  } 
} 


function handleResetPwdResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	//DisplayData(xmlhttp.responseText);
     	//var obj =  document.getElementById("status");
     	//obj.selectedIndex = 1;
     	alert("Your password is reset. An email will be sent to you shortly. Please use the link provided in the email for reentering to the application.");
     }    
     else {
        //alert(xmlhttp.status);
     }
   }
}


function handleResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	DisplayData(xmlhttp.responseText);
     }    
     else {
        //alert(xmlhttp.status);
     }
   }
}


function DisplayData(data)
{
	//alert(data);
	
	//var obj =  document.getElementById("status");
	//obj.innerHTML = data;

}


function onCancel()
{
	location.href='supervisorGrid.jsp';

	//history.go(-1);
}

function initial_load()
	{
	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(i == 1)
		array_of_li[i].setAttribute("class", "active");	
		
	}
		 var btn =  document.getElementById("changePassword");
		 var sts = 	"<%= (String) hashMap.get("status") %>"; 
		 var obj =  document.getElementById("status");
		 //alert(btn);
		 
		 if(sts != null && sts == "Active" )
		 {
		 		if(obj != null)
		 			obj.selectedIndex = 0;
		 }
		 else
		 {
		 		if(obj != null){

		 			obj.selectedIndex = 1;
		 			if(btn != null)
		 		 btn.disabled=true;
			 		}
		 }
		 var otp = '<%=otp%>';
		
	        if(otp=='E'){
	      
	        	$("#emailotp").prop("checked", true);
	        	$('#otpVal').val('E');
	        }else {
	        	
	        	$("#mobileotp").prop("checked", true);
	        	$('#otpVal').val('M');
	        }

		checkForNull();
		setHeader('supervisorEditUserProfile.jsp');
		var sessId = '<%=request.getSession().getAttribute("sessionid")%>';
		var userId = '<%=hashMap.get("userId") %>';
		
		var valueOfUserRole =  '<%=request.getParameter("userRoleValue")%>';
		console.log("valueOfUserRole::::"+valueOfUserRole);
		var queryStr = '?sessionid='+sessId+'&guestUserId='+userId+'&userRoleValue='+valueOfUserRole;
		var state='<%=hashMap.get("state") %>';
		
		$("option[value="+state+"]").attr('selected','selected');
		setHeaderText('Edit User Profile','User Profile','supervisorShowUserProfile.jsp'+queryStr);
	}
	
		
	function checkForNull()
	{
		var counter = document.registrationForm.elements.length;
		
		for(var i = 0;i < counter;i++)
		{
			if(document.registrationForm.elements[i].value == "null")
			{
				document.registrationForm.elements[i].value = "";
			
			}
		}
	}


//-->
</script>
	

		
		<div id ="noChangeMsg" style ='display:none;' >
			No Changes Occurred.
		</div>


<form name="registrationForm" method="post" action="./SupervisorEditUserProfile"  >
<div align="center" style="margin:20px;">
									
<p style="color:green;font-size:16px;text-align: left;margin-bottom:10px;margin-left: 10px;"><i class="zmdi_large zmdi-file"></i></i>User Information</p>
		
		
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          	Account Information  &nbsp&nbsp<span style = "font-size: 11px;    font-weight: normal;    border-left: 3px #fff solid;">&nbsp&nbsp General details about your account</span>
         </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
      <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
			<div class="card-body card-padding" style="background-color:#EDECEC">
      
      		<div style="float:left;" class="requiredStar">* Required</div>
		
		<table width="100%" border="0" cellspacing="1" cellpadding="1" align="center" style="border-collapse: separate; border-spacing: 10px;">
				
				<tr>
				<td  width="15%" ><p>User Name <span class="requiredStar">*</span></p></td><td align="left">
					<%
						String strUserName = (String) hashMap.get("username");
					 	if(strUserName != null && strUserName.indexOf('/') > 0)
					 		strUserName = strUserName.substring(strUserName.indexOf('/') +1);
					 %>
					<input size="40" style="color:gray;box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" name="username" maxlength="25" value="<%=strUserName %>" readonly="readonly"/></td>
                  <td width="15%"  ><p>User Login ID <span class="requiredStar">*</span></p></td><td width="310" align="left">
					<input size="40" type="text" style="color:gray;box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" name="username" maxlength="25" value="<%=(String) hashMap.get("username") %>" readonly="readonly"/></td>
          </tr>
                  <tr>  
                    
                      
					<td ><p>Email <span class="requiredStar">*</span></p></td><td align="left">
					<input type="text" name="email" id="email" size="40" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" maxlength="100" value="<%=hashMap.get("email") %>" tabindex="1"/></td>
                    <td ><p>Role</p></td>				
					<td align="left">
					<select name="userRoleValue" id="userRole"   multiple="multiple" tabindex="5" style="width:245px">
                      <%=hashMap.get("userRole") %>
                    </select><br>
                    <p><b>Existing Roles:</b></p><h4 style="color: red;"><%=hashMap.get("selectedRolesNames")%></h4>
                    </td>
                  </tr>
                  
                  
                  <tr>  
				  
				
				<tr>
					<td>
						<p>First Name <span class="requiredStar">*</span></p>
					</td>
						<td align="left">
						<%String strValue = (String) hashMap.get("firstName"); if(strValue== null) strValue="";  %>
						<input type="text" size="40" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" name="first_name" id="first_name" maxlength="25" value="<%=strValue %>" tabindex="3" onkeypress="return LettersOnly(event)"/></td>
					<td>							
						<p>Last Name <span class="requiredStar">*</span></p></td>
						<td align="left">
						<% strValue = (String) hashMap.get("lastName"); if(strValue== null) strValue="";  %>
						<input type="text" size="40" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" name="last_name" maxlength="25" value="<%=strValue %>" tabindex="7" onkeypress="return LettersOnly(event)"/></td>
				</tr>				
				
				<tr>				
				  <td><p>Status</p></td>
				  <td align="left"> 
				  	<select name="status" id="status" tabindex="4" style="width:245px">
				  	<option value="A">Active</option>
				  	<option value="D">Disabled</option>
				  	</select>				
				  </td>
				
					<td >							
						<p>Password Status</p></td>
						<td align="left">
												<% String pwdsts = (String) hashMap.get("password_status");
						if(pwdsts != null && pwdsts.compareTo("A")==0)
							pwdsts = "Active";
						else
							pwdsts = "Disabled";
						 %>

						<input type="text" style="color:graystyle;box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" size="40" readonly="readonly" disabled name="password_status" maxlength="25" value="<%=pwdsts %>"/>					</td>
				</tr>
				<tr><td></td><td></td></tr>
		  </table>
		  </div></div>
      </div>
    </div>
  </div>
  
  
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse"  href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Geographic Information &nbsp&nbsp<span style = "font-size: 11px;    font-weight: normal;    border-left: 3px #fff solid;">&nbsp&nbsp Address & Phone details</span>
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
      <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
			<div class="card-body card-padding" style="background-color:#EDECEC">
      
      <table align="center" width="100%" style="border-collapse: separate; border-spacing: 10px;">
				
				<tr>
					<td width="15%" >
				  <p>Street Address</p></td>
						 
					<td align="left">
						<% strValue = (String) hashMap.get("address1"); if(strValue== null) strValue="";  %>
						<input type="text" name="address1" size="40" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" maxlength="150" value="<%=strValue %>" tabindex="8" />
				  <span class="requiredStar">&nbsp;</span></td>
						<td ><p>Mobile Number</p></td>
						 
					<td align="left"><% strValue = (String) hashMap.get("cellPhone"); if(strValue== null) strValue="";  %>
                      <input size="40"  style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="cellPhone" name="cellPhone" maxlength="25" value="<%=strValue %>" tabindex="14"/></td>
				
				 
				</tr>
				<tr>
				<td><p>&nbsp;</p></td>
				 
					<td align="left">
						<% strValue = (String) hashMap.get("address2"); if(strValue== null) strValue="";  %>
						<input type="text" name="address2" size="40" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" value="<%=strValue %>" tabindex="9" />					</td>
						
				<td width="15%" ><p>Zip </p></td>
					<% strValue = (String) hashMap.get("zip"); if(strValue== null) strValue="";  %>
					<td ><input size="40" type="text" name="zip" id="zip" maxlength="5" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" value="<%=strValue %>" tabindex="11"/></td>
					</tr>
				
				<tr>
					<td >
						<p>City					</p></td>
						
				  <td align="left">
						<% strValue = (String) hashMap.get("city"); if(strValue== null) strValue="";  %>
						<input size="40" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="city" name="city" maxlength="10" value="<%=strValue %>" tabindex="10" onkeypress="return LettersOnly(event)"/></td>
						
					
				</tr>
				<tr>
				<td >
				 	<p>State</p></td>
						 
					<td  align="left">
						<select id="state" name="state" tabindex="12" style="width:245px">
							<%=hashMap.get("stateList") %>
				  		</select>
				  	</td>
					
					<td><input type="hidden" name="userRoleID" id="userRoleID" value="" /></td>
						 
				  <td align="left">&nbsp;</td>
				</tr>
				</table>
			
			</div></div>
      </div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingFour">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse"  href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
         Multifactor Authentication &nbsp&nbsp<span style = "font-size: 11px;    font-weight: normal;    border-left: 3px #fff solid;">&nbsp&nbsp A unique One-Time-Password will be delivered to the mode you choose (Email / Mobile)</span>
        </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingFour">
      <div class="panel-body">
      <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
			<div class="card-body card-padding" style="background-color:#EDECEC">
      
      <table align="center" width="100%" style="border-collapse: separate; border-spacing: 10px;">
				<tr>
							<td>	<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="radio" id="emailotp" name="otp" onClick="fnOTP('E')" size="38" value="E" />
								&nbsp;&nbsp;&nbsp;Enable Email OTP 
								</td>
								
							</tr>
							<tr>
							<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onClick="fnOTP('M')"  type="radio" id="mobileotp" name="otp"  value="M"  />
							&nbsp;&nbsp;&nbsp;Enable Mobile OTP</td>
								
								
							</tr>	
				
				</table>
			
			</div></div>
      </div>
    </div>
  </div>

  
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
         Audit Trail &nbsp&nbsp<span style = "font-size: 11px;    font-weight: normal;    border-left: 3px #fff solid;">&nbsp&nbsp Provides a collection of past events taken by the user</span>
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div style="overflow-x:scroll;overflow-y:scroll;height:300;" class="panel-body">
			<%= htmlAuditTrail%>
      </div>
    </div>
  </div>
  
</div>
			<table>
				<tr>
				 	<td>
				 
					  
					    <input type="hidden" name="sessionid" value="<%=(String)request.getSession().getAttribute("sessionid") %>" />
					    <input type="hidden" name="userid" value="<%=hashMap.get("userId") %>" />
					    <input type="hidden" name="oldRole" id="oldRole" value="" />
					    <input type="hidden" name="newRole" id="newRole" value="" /> 
					     <input type="hidden" name="AUTH_ID" id="AUTH_ID" value="<%=hashMap.get("AUTH_ID") %>" />
					    <input type="hidden" name="oldEmail" id="oldEmail" value="" /> 
					    <input type="hidden" name="oldSecondEmail" id="oldSecondEmail" value="" /> 
					    <input type="hidden" name="comId" id="comId" value="<%=hashMap.get("comId") %>" /> 
					    <input type="hidden" name="userSelectRole" id="userSelectRole" value="<%=hashMap.get("userSelectedRole") %>" />
					       <input type="hidden" name="OTP" id="otpVal" />
					    
					    </td>
					    <td>
					    <input type="button" name="button2" id="button2" onClick="javascript:validate_form();"
							value='Save'
							class="btn btn-success waves-effect waves-button waves-float" style="margin-left: 665px;" />
					    
					    
					    <input type="button" name="button" id="button"
							value='Cancel'
							class="btn btn-warning waves-effect waves-button waves-float" style="margin-left: 15px;margin-right: 20px;"
							onclick="javascript:onCancel()" />				 
			          </td>

				</tr>
			</table>
			</div>
		</form>		
			<%-- <%}else{
	response.sendRedirect("index.jsp");
} 
				}catch(IllegalStateException ie){
		response.sendRedirect("index.jsp");
	}%> --%>
	</body>
</html>
