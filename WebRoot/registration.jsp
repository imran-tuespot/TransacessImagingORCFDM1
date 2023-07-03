<%@ page contentType="text/html; charset=ISO-8859-1" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<jsp:useBean id="formInformation" scope="request"
	class="com.peniel.beans.FormInformation" />
<jsp:setProperty name="formInformation" property="*" />
<%@page import="java.util.*"%>

<html>
<head>
<title>Registration</title>
<meta name="pageHeading" content='Imaging Registration' />
<link rel="stylesheet" href="css/bootstrap.css"></link>
<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
<script src="js/jQuery/1.11.3/jquery.min.js"></script>

<!-- <script src="js/jQuery/jquery-1.8.2.min.js"></script> -->
<!-- Include the Sidr JS -->
<script src="js/jquery.sidr.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


	<script type="text/javascript" src="js/jquery.alerts.js"></script>
	<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
	<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>


	<style>
.multiselect {
	width: 200px;
}

.selectBox {
	position: relative;
}

.selectBox select {
	width: 100%;
	font-weight: bold;
}

.overSelect {
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
}

#checkboxes {
	display: none;
	border: 1px #dadada solid;
	position: absolute;
    background: #ffffff;
    padding: 5px 5px 5px 5px; 
    width: 20rem;'
 }
 #check-select:hover{ background: #417aff;
 color: #ffffff;
 }
#checkbox-input {
    position: absolute;
    right: 17px;
    margin: 1px 0px 1px 0px;
}
#checkboxes label {
	display: block;
}

#checkboxes label:hover {
	background-color: #1e90ff;
}
</style>
</head>

<body onload="initial()">

	<%-- <jsp:include page="includes/sessionHeader.jsp" /> --%>


	<%-- <% 
		//-1 means this is not a user type and the state code is empty
		//HashMap hashMap = formInformation.getFormInformation(-1L, "");
		
		Integer companyId = (Integer)request.getSession().getAttribute("comid");
		String appuserrole = (String)request.getSession().getAttribute("appuserrole");
		HashMap hashMap = formInformation.getFormInformation(appuserrole, "",companyId+"" );--%>
	<%
	javax.naming.Context ctx = new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	%>



	<script type="text/javascript">
$(function(){
	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(i == 1)
		array_of_li[i].setAttribute("class", "active");	
		
	}
	$('#userRoles').val('');
	InitializeTimer();
});
$(document).mousemove(function(event){
	  InitializeTimer();
});
function initial()
{
	getroles();
	getStates();
	setHeader('registration.jsp');
	//Initialize slider menu
      	$('#simple-menu').sidr();
        
	  	$('.child').hide();
	  	$('.parent').click(function() {
// 		 	$('.child').slideUp();
// 		 	$(this).find('ul').slideToggle();
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
	  //	$('#userManagementLi').click();
	  $('#userManagementLi').collapse('toggle'); 
	  	
	//init();
	var obj =  document.getElementById("usernameConfirmation");
	obj.innerHTML = "<font color='red' size='0.5'><i>Enter User Name</i></font>";

	$("#emailotp").prop("checked", true);	

	//var obj1 =  document.getElementById("userRoles");
	//if(obj1 != null)
	//	obj1.selectedIndex = 2;
		
		//jAlert(obj1);
		
}

function getStates(){
	var token=sessionStorage.getItem("token");
	 $.ajax({
         type: "POST",
         url:"<%=restURL%>rmshd/getStates",
         dataType: "json",
         headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
         success: function (data) {
         	//alert("619::"+data.docTypeData[0].value);
         		

             $.each(data.states,function(i,obj)
             		
             {                	
             	var	div_data="<option value="+obj.dropdown_id+">"+obj.dropdown_name+"</option>";
             	$(div_data).appendTo('#state'); 
             	
             });
            
             } 
       });
}

function fnGetLandNo(){
	var num= Math.floor(1000000 + Math.random() * 9000000);
	
	return '770'+num;
 }
function fnOTP(otpchanged){
	$("#otpVal").val(otpchanged);
	if(otpchanged=='M' && $("#cellPhone").val()== ""){
		alert("Mobile Number is required");

		
	}
}


function validateEmail(email) 
{  
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))  
	  {  
	    return true; 
	  } 
   
    return false;

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


function validate_form()
{


    if ( document.registrationForm.username.value == "" )
    {
        jAlert ( "Please fill in the USERNAME field." );
        return false;
    }
    else if ( document.registrationForm.validUsername.value == "false" )
    {
        jAlert ( "This USERNAME name already exists." );
        return false;
    }
    if ( document.registrationForm.email.value == "" )
    {
        jAlert ( "Please fill in the EMAIL field." );
        return false;
    }
     if(!validateEmail(document.registrationForm.email.value)) 
	{  
  		jAlert("Not a valid e-mail address");
 		return false;
	}
     if($('#userRoles').val() == null  || $('#userRoles').val()=="") 
		{  
	  		jAlert("Please select atleast one user role");
	 		return false;
		}
   
     if ( document.registrationForm.first_name.value == "" )
    {
    
        jAlert ( "Please fill in the FIRST NAME field." );
        return false;
    }
   
     if ( document.registrationForm.last_name.value == "" )
    {
        jAlert ( "Please fill in the LAST NAME field." );
        return false;
    }
   
   
	if(document.registrationForm.zip.value != "" &&!validateZip(document.registrationForm.zip.value)) 
	{  
  		jAlert("Not a valid zip code");
 		return false;
	}
	
	 if( document.registrationForm.cellPhone.value !="" &&!validatePhone(document.registrationForm.cellPhone.value)) 
	{  
  		jAlert("Not a valid mobile number. Please enter mobile number in XXX-XXX-XXXX format");
 		return false;
	}
	
	 var otpval=$("input[name='otp']:checked").val();
		if(otpval=='M' && $("#cellPhone").val()== ""){
			jAlert("Mobile Number is required");
			return false;
		}else if(otpval=='E'){
			if(document.registrationForm.cellPhone.value!=""){
				$("#generatedPhnNo").val(document.registrationForm.cellPhone.value);
				}else{
					$("#generatedPhnNo").val(fnGetLandNo());
					}
			 
		}
	
   
	document.registrationForm.last_name.value = document.registrationForm.last_name.value.replace(/'/g, "''");
	document.registrationForm.first_name.value = document.registrationForm.first_name.value.replace(/'/g, "''");
	document.registrationForm.city.value = document.registrationForm.city.value.replace(/'/g, "''");
	document.registrationForm.address1.value = document.registrationForm.address1.value.replace(/'/g, "''");
	document.registrationForm.address2.value = document.registrationForm.address2.value.replace(/'/g, "''");
	
	document.getElementById('button2').disabled = true;
	//document.registrationForm.submit();
	
	var roleNames = [];
	//alert("UsersNew:");
	var listOfRoles =document.getElementById("userRoles");
     for (var i = 0; i < listOfRoles.options.length; i++) {
        if(listOfRoles.options[i].selected ==true){
              //alert("saveRoles drop downs:"+listOfRoles.options[i].value);
              roleNames.push(listOfRoles.options[i].value);
         }
     }
     var cid=JSON.parse(sessionStorage.getItem("roles")).company_ID;
	
	var newUserPosetData = {"userName":document.registrationForm.username.value,
							"firstName":document.registrationForm.first_name.value,
							"lastName":document.registrationForm.last_name.value,
							"email":document.registrationForm.email.value,
							"role":roleNames,
							"address1":document.registrationForm.address1.value,
							"address2":document.registrationForm.address2.value,
							"city":document.registrationForm.city.value,
							"state":document.registrationForm.state.value,
							"zip":document.registrationForm.zip.value,
							"cellPhone":document.registrationForm.cellPhone.value,
							"AcceptMails":document.registrationForm.acceptMails.value,
							"companyId":cid,
							"otp":$("input[name='otp']:checked").val(),
							"generatedPhnNo":$("#generatedPhnNo").val()

	                      }
	//alert("newUserPosetData:"+JSON.stringify(newUserPosetData));
	
	 newUserCreation();
	
	function newUserCreation(){
	//alert("newUserCreation");
	var token=sessionStorage.getItem("token");
 	$.ajax({
 		  type : "POST",
 		 url : "<%=restURL%>role/saveUser", 
 		  dataType : 'json',
 		 headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token , 'Content-Type':'application/json' },
 		  timeout : 100000,
 		 ContentType : "application/json",
 		  data : JSON.stringify(newUserPosetData),
 		  success : function(data) {
 		   console.log("SUCCESS: ", data);
 		   if(data.key!="201"&&data.key=="200"){
 			  //alert("SSSS:"+ JSON.stringify(data));
 	 		  //alert("data MailMessage:"+data.MailMessage);
 	 		   localStorage.setItem("sessionid",document.registrationForm.sessionid.value );
 	 		   //alert("supervisorGrid.jsp?sessionid="+document.registrationForm.sessionid.value+"&successMsg=New user successfully registered.  An email is sent with login credentials");
 	 		   window.location = "supervisorGrid.jsp?sessionid="+document.registrationForm.sessionid.value+"&successMsg=New user successfully registered.  An email is sent with login credentials"; 
 	 		  
 			   
 		   }else{
 			  jAlert( data.message+"");
 			  document.getElementById('button2').disabled = false;
 			 
 		   }
 		  
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
	
}
$(function() {
	getHeaderusername();
	getroles();
	getStates();
});
function getroles(){
	var token=sessionStorage.getItem("token");
	var userinfo=JSON.parse(sessionStorage.getItem("roles")).company_ID;	
	 $.ajax({
         type: "GET",
         url:"<%=restURL%>role/roles?company="+userinfo,
         dataType: "json",
         headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
         success: function (data) {
         	//alert("619::"+data.docTypeData[0].value);
         		

             $.each(data.data,function(i,obj)
             		
             {                    	
                 	var	div_data="<option value='"+obj.role_ID+"'>"+obj.role_NAME+"</option>";
                 	var label_input_data="<div id='check-select'>"+
                 	"<input type='checkbox' id='checkbox-input' value='"+obj.role_ID+"'> &nbsp; "+obj.role_NAME+"</input>"
                 	"</div>";
                 	$(div_data).appendTo('#userRoles'); 
                 	$(label_input_data).appendTo('#checkboxes');
                 	
                 	 var	div_data="";
                 	 var	label_input_data="";
                 	 
                     if(JSON.parse(sessionStorage.getItem("roles")).role_ID!="6") {
                    			if(JSON.parse(sessionStorage.getItem("roles")).role_ID==obj.role_ID)
                    			div_data+="<option value='"+obj.role_ID+"'selected>"+obj.role_NAME+"</option>";
                    			
                         } else{
                        		div_data+="<option value='"+obj.role_ID+"'>"+obj.role_NAME+"</option>";
                        			
                             }            	
                 	$(div_data).appendTo('#userRoles')
                 	$(label_input_data).appendTo('#checkboxes');
                 });
         }
       });
}

var expanded = false;

function showCheckboxes() {
  var checkboxes = document.getElementById("checkboxes");
  if (!expanded) {
    checkboxes.style.display = "block";
    expanded = true;
  } else {
    checkboxes.style.display = "none";
    expanded = false;
  }
}



function LettersOnly(evt) 
{
       var textBoxObj = document.getElementById('first_name');
       evt = (evt) ? evt : event;
       var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
          ((evt.which) ? evt.which : 0));
       if (charCode != 39 &&(charCode > 32 && (charCode < 65 || charCode > 90) &&(charCode < 97 || charCode > 122))) 
    	   // Letters Only          
       {       	 
         	jAlert("Please enter letters only.");
         	return false;         
          
       }
       
       if (textBoxObj.value.length > 39) 
       {          
        	var val = textBoxObj.value.substring(0,40);  
       		textBoxObj.value = "";
       		textBoxObj.value = val;
       		jAlert("First Name can not exceed 40 characters"); 
       		
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

function validateUsername() 
{
if(xmlhttp) { 
	var username = document.registrationForm.username.value;
	var comid = JSON.parse(sessionStorage.getItem("roles")).company_ID;
    xmlhttp.open("POST","GetUsernameValidation",true); 
    xmlhttp.onreadystatechange  = handleResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("username=" + username + "&companyId=" + comid);
  } 
} 



function handleResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	DisplayData(xmlhttp.responseText);
     }    
     else {
        //jAlert(xmlhttp.status);
     }
   }
}

function DisplayData(data)
{
	
	var obj =  document.getElementById("usernameConfirmation");
	obj.innerHTML = data;
	
	if(data == '<span style=\"font:Verdana, Arial, Helvetica, sans-serif; color:#FF3300\" >Fill Username!</span>' || data == '<span style=\"font:Verdana, Arial, Helvetica, sans-serif; color:#FF3300\" >Username Taken!</span>')
	{
		document.registrationForm.validUsername.value = "false";	
	
	}
	else
	{
		document.registrationForm.validUsername.value = "true";	
	}

}


function oncancel()
{
	location.href = "dashboard.jsp";
	/* location.href('dashboard.jsp')
;	history.back(-1); */

}

function enableAcceptMails(id)
{
     var roleList = document.getElementById(id);
	for(i=0; i< roleList.options.length; i++)
	{
		if(roleList.options[i].selected == true && (roleList.options[i].text === "ADMIN" || roleList.options[i].text === "POWERUSER"))
		{
			document.getElementById("acceptMails").disabled = false;
		}
	}
		
	
}




//-->
</script>

	<form name="registrationForm" method="post">
		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" aria-expanded="true"
							aria-controls="collapseOne"> Account Information &nbsp&nbsp<span
							style="font-size: 11px; font-weight: normal; border-left: 3px #fff solid;">&nbsp&nbsp
								General details about your account</span>
						</a>
					</h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body">
						<div class="card"
							style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
							<div class="card-body card-padding"
								style="background-color: #EDECEC; min-height: 200px;">
								<label id="SuccessId"></label> <input type="hidden"
									name="companyId"
									value="<%=request.getSession().getAttribute("comid")%>" /> <input
									type="hidden" name="validUsername" value="false" />

								<table width="100%" border="0" cellspacing="1" cellpadding="1"
									align="center"
									style="border-collapse: separate; border-spacing: 10px;">

									<tr>
										<td><div class="requiredStar">* Required</div></td>
										<td align="left">&nbsp;</td>
										<td>&nbsp;</td>
										<td align="left">&nbsp;</td>
									</tr>
									<tr>
										<td width="15%">
											<p>
												User Name <span class="requiredStar">*</span>
											</p>
										</td>
										<td align="left"><input size=40
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											type="text" id="username" name="username" maxlength="25"
											onblur="validateUsername() " tabindex="1" /></td>

										<td width="15%"><p>User Login ID</p></td>
										<td align="left">
											<div id="usernameConfirmation"></div>
										</td>
									</tr>
									<tr>
										<td><p>
												Email <span class="requiredStar">*</span>
											</p></td>
										<td align="left"><input size=40
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											type="text" name="email" maxlength="50" tabindex="2" /></td>

										<td><p>
												Role <span class="requiredStar">*</span>
											</p></td>
										<td align="left">
										<select style="width: 243px; display:none;"
											id="userRoles" name="userRoles" tabindex="5"
											multiple="multiple"
											onchange="javascript:enableAcceptMails(this.id)">
												<%--  <%=hashMap.get("userRoles") %>  --%>

										</select>
											<div class="multiselect">
												<div class="selectBox" onclick="showCheckboxes()">
													<select>
														<option>Select an option</option>
													</select>
													<div class="overSelect"></div>
												</div>
												<div id="checkboxes">
									
												</div>
												
											</div></td>
									</tr>




									<tr>
										<td><p>
												First Name <span class="requiredStar">*</span>
											</p></td>
										<td align="left"><input type="text" size=40
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											id="first_name" name="first_name" maxlength="25" tabindex="4"
											onkeypress="return LettersOnly(event)" /></td>
										<td><p>
												Last Name <span class="requiredStar">*</span>
											</p></td>
										<td align="left"><input type="text" size=40
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											id="last_name" name="last_name" maxlength="25" tabindex="7"
											onkeypress="return LettersOnly(event)" /></td>
									</tr>

									<tr>
										<td>
											<p>Accept Emails</p>
										</td>
										<td align="left"><input type="checkbox" id="acceptMails"
											name="acceptMails" value="acceptEmails" /></td>
									</tr>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingTwo">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo"> Geographic
							Information &nbsp&nbsp<span
							style="font-size: 11px; font-weight: normal; border-left: 3px #fff solid;">&nbsp&nbsp
								Address & Phone details</span>
						</a>
					</h4>
				</div>
				<div id="collapseTwo" class="panel-collapse" role="tabpanel"
					aria-labelledby="headingTwo">
					<div class="panel-body">
						<div class="card"
							style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
							<div class="card-body card-padding"
								style="background-color: #EDECEC; min-height: 200px;">
								<table width="100%" border="0" cellspacing="1" cellpadding="1"
									align="center"
									style="border-collapse: separate; border-spacing: 10px;">
									<tr>
										<td width="15%">
											<p>Street Address</p>
										</td>
										<td align="left"><input size=40
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											type="text" id="address1" name="address1" maxlength="150"
											tabindex="8" /> <span class="Star">&nbsp;</span></td>

										<td width="15%"><p>Mobile Number</p></td>
										<td align="left"><input size=40
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											type="text" id="cellPhone" name="cellPhone" maxlength="25"
											tabindex="14" /></td>

									</tr>
									<tr>
										<td></td>
										<td align="left"><input size=40
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											type="text" id="address2" name="address2" tabindex="9" /></td>

									</tr>

									<tr>
										<td><p>City</p></td>

										<td align="left"><input size=40
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											type="text" id="city" name="city" maxlength="10"
											tabindex="10" onkeypress="return LettersOnly(event)" /></td>
										<td>
											<p>ZIP</p>
										</td>
										<td align="left"><input size=40
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											type="text" id="zip" name="zip" maxlength="5" tabindex="12" /></td>

									</tr>
									<tr>
										<td><p>State</p></td>
										<td size="10" align="left"><select id="state"
											name="state" tabindex="11" style="width: 243px;">
												<option value="" selected="" disabled="">Select
													State</option>
										</select></td>
										<td>&nbsp;</td>

										<td align="left">&nbsp;</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingFour">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseFour"
							aria-expanded="false" aria-controls="#collapseFour">
							Multifactor Authentication &nbsp&nbsp<span
							style="font-size: 11px; font-weight: normal; border-left: 3px #fff solid;">&nbsp&nbsp
								A unique One-Time-Password will be delivered to the mode you
								choose (Email / Mobile)</span>
						</a>
					</h4>
				</div>
				<div id="#collapseFour" class="panel-collapse" role="tabpanel"
					aria-labelledby="headingFour">
					<div class="panel-body">
						<div class="card"
							style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
							<div class="card-body card-padding"
								style="background-color: #EDECEC; min-height: 100px;">
								<table width="100%" border="0" cellspacing="1" cellpadding="1"
									align="center"
									style="border-collapse: separate; border-spacing: 10px;">
									<tr>
										<td align="right"><input
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											type="radio" id="emailotp" value='E' name="otp"
											onChange="fnOTP('E')" checked /></td>
										<td align="left"><p>Enable Email OTP</p></td>
									</tr>
									<tr>
										<td align="right"><input onChange="fnOTP('M')"
											style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
											type="radio" value='M' id="mobileotp" name="otp" /></td>
										<td align="left"><p>Enable Mobile OTP</p></td>
									</tr>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div align="right" style="padding: 20px">
				<input type="hidden" name="sessionid" id="sessionid"
					value="<%=(String) request.getSession().getAttribute("sessionid")%>" />
				<input type="hidden" name="generatedPhnNo" id="generatedPhnNo" /> <input
					type="button" name="button2" id="button2"
					onclick="javascript:validate_form();" value='Save'
					class="btn btn-success" style="margin-right: 10px" /> <a
					href="dashboard.jsp" name="button" id="button"
					class="btn btn-warning"> Cancel</a>
			</div>


		</div>


	</form>


</body>
</html>
