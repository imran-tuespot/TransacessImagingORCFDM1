<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.commons.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<%
String timeout = "";
if (!StringUtils.isBlank((String) request.getParameter("timeout"))) {
	if ("yes".equals((String) request.getParameter("timeout"))) {
		timeout = "Session Timed Out, please log back in to continue";
	}
}
javax.naming.Context ctx = new javax.naming.InitialContext();
String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
%>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TransAccess Imaging</title>
<!-- <script src="js/jQuery/jquery-1.8.2.min.js"></script> -->


<script type="text/javascript" src="js/jQuery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<script type="text/javascript" src="js/FHA.js"></script>
<script type="text/javascript" src="js/jQuery/jquery.qtip.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.qtip.min.css" />


<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />



<link rel="stylesheet" type="text/css" href="css/styleSheet.css" />
<link rel="stylesheet" type="text/css" href="css/app.css" />
<link rel="stylesheet" href="css/material-design-iconic-font.css">

<!-- <script
	src="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"></script>
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/dataTables.buttons.min.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.flash.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.html5.min.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.print.min.js"></script> 
   -->
<script type="text/javascript">
       window.history.forward();
        function noBack() {
            window.history.forward();
        }
        history.pushState(null, null, location.href);
        window.onpopstate = function () {
            history.go(1);
        }; 
      
      /*  $(document).ready(function() {
           window.history.pushState(null, "", window.location.href);        
           window.onpopstate = function() {
               window.history.pushState(null, "", window.location.href);
           };
       }); */
    </script>


</head>

<body onLoad="initial()" onpageshow="if (event.persisted) noBack();"
	onunload="">



	<div class="headPageContainer">
		<div id="ghUtilBar" class="">
			<div id="ghMainUtil">
				<div id="ghClientSegment"></div>
			</div>
		</div>

		<table width="1170" height="44" border="0" cellpadding="0"
			cellspacing="0">
			<!--DWLayoutTable-->
			<tr>
				<td style="padding-left: 10px"><img
					src="css/images/fhalogo.png "
					alt='TransAccess Imaging - Document Viewer.' width="156"
					height="80" style="margin-left: -10px;" /></td>
				<td rowspan="3" style="width: 100%; color: #0A68B4">
					<div class=""
						style="font-size: 32px; margin-left: 35px; text-align: right;">
						RMS Help Desk
						<div style="font-size: 13px; margin-left: 2%; text-align: right;"
							class="text-center">Powered by TransAccess (PSL)</div>
					</div>
				</td>
				<td width="500" style="padding-right: 10px" valign="bottom"><div
						align="right">
						<!-- 			 <img src="images/imaging2.jpg" alt="Imaging" width="133" height="53">
 -->
					</div></td>
			</tr>
		</table>


		<img src="images/homePageImage.jpg" alt="Working" width="1170"
			height="150">
	</div>

	<div class="blueHeading">
		<!-- <div width="530" align="center">
<br>
Greetings Multifamily TransAccess Users, October 18th, HUD will send a short 13-Question survey to your email. Please take a moment to give us your thoughts &amp; feedback. From PSL, Your Feedback has been amazing, <br>thank you for your time and have a great rest of your day!

<br>
<br></div>  -->
		<div align="center">Existing User Login</div>
		<!-- <div align="center" style="color:red">Training Site </div>  -->
	</div>





	<div class="mainContentAreaContainer" style="padding-bottom: 0;">
		<div class="card"
			style="width: 50%; margin-left: 25%; margin-bottom: 8px;">
			<div class="card-body card-padding"
				style="padding-bottom: 0px; background-color: #FDFDFE; border-radius: 2px; box-shadow: 0px 1px 4px 0px #777;">
				<!-- action="./Getlogin" -->
				<form name="getfile" id="getfile"
					onKeyPress="return submitenter(this,event)">
					<div>
						<div class="rowSetting"
							style="padding-bottom: 1px; border-bottom: 2px solid #F90;">
							<div class="fg-line">
								<div style="float: left;">
									<i class="zmdi_large zmdi-lock-outline"
										style="color: green; padding-left: 0px;"></i>
									<h3 class="pageHeader" style="display: inline">Sign In</h3>

								</div>
								<div style="text-align: right;">
									<img onclick="myFunctionvideo()" src="images/VIDIMG1.jpg"
										title="Tutorial: Signing-In with Multifactor Authentication"
										style="margin-right: 25px; cursor: pointer;"> <br>
									<span style="color: #009cd1"><b>Login Instructions</b></span>
								</div>
							</div>
						</div>
						<div class="rowSetting" style="padding-top: 20px;">

							<div class="fg-line">
								<input id="username" name="username"
									class="form-control input-lg" style="background-color: #FDFDFE"
									placeholder="User Name *" type="text"
									onfocus="javascript:addClass();" onblur="">
							</div>

						</div>

						<div class="rowSetting">

							<div class="fg-line">
								<input id="password" name="password"
									class="form-control input-lg" style="background-color: #FDFDFE"
									placeholder="Password *" type="password">
							</div>
						</div>
						<div style="height: 19px;"></div>
						<div class="rowSetting">
							<div class="checkbox m-b-15">
								<label> <input id="remember" name="remember"
									type="checkbox" checked=""> <i class="input-helper"></i>
									Remember my login ID
								</label>
							</div>
						</div>

					</div>


					<div class="rowSetting">

						<br>
						<table class="table" width="400">
							<tbody>
								<tr>
									<td width="30%">
										<!-- 						<h4><a style="cursor: pointer;color: #2196f3; margin-left: 20px" onclick="myFunctionpdf()" ><u>HELP</u></a> -->
										<!-- 						</h4>-->
									</td>

									<td width="35%"><input type="button"
										value="Forgot Password" style="margin-right: 10px;"
										onClick="document.location.href='forgotPassword.jsp';"
										class="btn btn-primary" /> <input type="button"
										value="Submit" id="Submit" onClick="javascript:submitform()"
										class="btn btn-success waves-effect waves-button waves-float" />

									</td>
								</tr>
							</tbody>
						</table>




						<br>
						<br>
					</div>
				</form>
			</div>
		</div>
		<div style="text-align: center;">
			<a href="http://www.TransAccessGCR.com/"> <img
				src="images/LOGO_GC Combo4.png" alt="Peniel Solutions, LLC"
				width="330" height="">
			</a>
			<!--  <img src="images/LOGO_GC Combo3.png" alt="Peniel Solutions, LLC" width="267" height=""> -->
		</div>
	</div>




	<div class="footer" style="padding: 0;">

		<div class="footerPadding">
			<p style="font-size: 0.9em;">This computer system, including all
				related equipment, networks, and network devices (specifically
				including Internet access) contains data belonging to the U.S.
				Government, and is provided for authorized U.S. Government use only.
				Access requires the use of one or more Multi-factor Authentication
				methods, which ties the account to an authorized user, validated by
				either account number and password or PIV ID card and PIN that must
				never be shared with anyone at any time. Doing so increases the risk
				of access by an unauthorized person posing as you. Authorized
				personnel will treat information about HUD computing resources
				(i.e., system names, technologies employed, etc.) as sensitive and
				will not reveal it to unauthorized personnel. This computer may be
				monitored for all lawful purposes, including ensuring that its use
				is authorized, to facilitate protection against unauthorized access,
				and to verify operational security. During monitoring, information
				may be examined, recorded, copied and used for authorized purposes.
				All activities and information, including personal information,
				associated with the use of this system may be monitored. Use of this
				computer system, authorized or unauthorized, constitutes consent to
				monitoring. Misuse or unauthorized use may subject you to criminal
				prosecution. Evidence of unauthorized use collected during
				monitoring may be used for administrative, criminal, or other
				adverse action. Use of this system implies understanding of these
				terms and conditions. Authority: U.S. Federal Criminal Code (18 USC
				1030. Fraud and Related Activity with Computers) and HUD Information
				Technology Security Policy 2400.25.</p>

			<p>&nbsp;</p>

		</div>

	</div>





	<script type="text/javascript">
 function myFunctionvideo() {
  popupvideo("images/Using_Multifactor_Authentication_2021.mp4",'Test Frame',700, 500)
}
 function myFunctionpdf() {
	 var randomnumber = Math.floor((Math.random()*100)+1); 
	  window.open('assets/TransAccess_MFHDSignIn.pdf',"_blank",'PopUp'+randomnumber+'	 ,scrollbars=1,menubar=0,resizable=1,width=850,height=500') 
	}
 
function popupvideo(url, title, w, h) {
  var left = (screen.width/2)-(w/2);
  var top = (screen.height/2)-(h/2);
  return window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
} 
function initial() {
	
	document.getElementById('Submit').disabled = false;

	$('.fg-line input').focus(function () {
	    $(this).parent().addClass('fg-toggled');
	}).blur(function () {
	    $(this).parent().removeClass('fg-toggled');
	});
	
	<%String logged = (String) request.getAttribute("isLogged");
String cell_phone = null;
String show_email = null;
String otp = null;
int authIdstr = 0;%>
	<%-- <% request.getSession().setAttribute("check","null");%> --%>
	<%if (null != request.getAttribute("authId") || "0" == request.getAttribute("authId")) {
		authIdstr = Integer.parseInt(request.getAttribute("authId").toString());
		String email = (String) request.getAttribute("email");
		show_email = email.split("@")[1];
		otp = request.getAttribute("otp").toString();
		if (null != request.getAttribute("cell_phone") && ((String) request.getAttribute("cell_phone")).length() > 4) {
			cell_phone = (String) request.getAttribute("cell_phone");
			cell_phone = cell_phone.substring(cell_phone.length() - 4);
		}
		long userid = Long.parseLong(request.getAttribute("userid").toString());%>
	<%String exp = (String) request.getSession().getAttribute("expired");%>
	var a = "no";
	if ( a == "<%=logged%>") {
	 //alert("Log In Error: Unknown user log in ID or password. \n Make sure your CapsLock key is off, and try again.");
	 jAlert('Log In Error: Unknown user log in ID or password. \n Make sure your CapsLock key is off, and try again.', 'Login Error');
	 /*jConfirm('Can you confirm this?', 'Confirmation Dialog', function(r) {
	    jAlert('Confirmed: ' + r, 'Confirmation Results');
	});
	jPrompt('Type something:', 'Prefilled value', 'Prompt Dialog', function(r) {
	    if( r ) alert('You entered ' + r);
	});
	
	*/
	<%request.removeAttribute("isLogged");%>
	 }else{
		if(0=="<%=authIdstr%>"){
			
			newUserTwillio("<%=email%>","<%=userid%>");
			
		}else{
			var authId = "<%=authIdstr%>" ;
			
			if('E'=="<%=otp%>"){
				
				otpcallEmail("<%=authIdstr%>");
			}else{
				
				if(authId){
					otpcall("<%=authIdstr%>") ;
					
				}	
			}
			<%--  otpcall("<%= authId %>");  --%>
		}
		 
		
		
		<%--  jAlert("<%= authId %>" , 'r');   --%>
	 }
	
	<%} else {%>
	var a = "no";
	if ( a == "<%=logged%>") {
	 //alert("Log In Error: Unknown user log in ID or password. \n Make sure your CapsLock key is off, and try again.");
	 jAlert('Log In Error: Unknown user log in ID or password. \n Make sure your CapsLock key is off, and try again.', 'Login Error');
	 /*jConfirm('Can you confirm this?', 'Confirmation Dialog', function(r) {
	    jAlert('Confirmed: ' + r, 'Confirmation Results');
	});
	jPrompt('Type something:', 'Prefilled value', 'Prompt Dialog', function(r) {
	    if( r ) alert('You entered ' + r);
	});
	
	*/
	}
	<%}%>
	
	 setUserID();
	//setHeader("Search");
	//init(); 
	/*$('#username').qtip({    content: {
        text: 'Please enter username.'
    },
    style: {
        classes: 'qtip-jtools qtip-shadow'
    }
});*/
} 
function resendotp(){
	var obj=JSON.parse(sessionStorage.getItem("roles"));
	if('E'==sessionStorage.getItem("OTP")){
		//(data.roleres.authId,data.token,em);token
		//email.split("@")[1];authId email
		
		console.log(JSON.parse(sessionStorage.getItem("roles")).authId);
		otpcallEmail(obj.authId,sessionStorage.getItem("token"),obj.email.split("@")[1]);
		}else{
		otpcall(obj.authId,obj.mobile.substr(obj.mobile.length - 4));
		}

	
}
function validatePhone(phone)  
{  

	if( /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(phone))
	{
		return true;
	}
	return false;
 
}  



function login(){
	var username= document.getfile.username.value;
	var password =document.getfile.password.value
	console.log("===>> "+password);
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "<%=restURL%>role/authenticate",
		dataType : 'json',
		headers: {  'Access-Control-Allow-Origin': '*' },
		timeout : 100000,
		 crossDomain: true,
	  data:JSON.stringify({"username":username,"password":password}),
		success : function(data) {
		      console.log("line no 368 "+JSON.stringify(data));
			sessionStorage.setItem("token",data.token);
			sessionStorage.setItem("roles",JSON.stringify(data.roleres));
			sessionStorage.setItem("username",data.roleres.username);
			sessionStorage.setItem("OTP",data.roleres.otp);
			sessionStorage.setItem("userId",data.roleres.user_id)
		sessionStorage.setItem("sessionid",data.roleres.sessionid);
			sessionStorage.setItem("userControl" ,data.roleres.user_Control)
if(data.roleres.mfa_STATUS=="0"){
	<%session.setAttribute("user", "user");%>
	window.location.href = "dashboardRMS.jsp?sessionid="+data.roleres.sessionid;
	
}else{
	if('E'==data.roleres.otp){
		
		var em=data.roleres.email.split("@")[1];
		otpcallEmail(data.roleres.authId,data.token,em);
	}else{
		
		
			otpcall(data.roleres.authId, data.roleres.mobile.substr(data.roleres.mobile.length - 4)) ;
		
	}
	
}

	
		//window.location= "dashboardRMS.jsp";
			
								
		},
		error : function(e) {
			console.log("ERROR: ", e);
		 if(e.status=="400"){
			 jAlert(e.responseText, 'Error');
				//$("#popup_error").text(data.message);
			}else{
			jAlert('Log In Error: Unknown user log in ID or password. \n Make sure your CapsLock key is off, and try again.', 'Login Error');
			
				}
		 document.getElementById('Submit').disabled = false;
		},
		done : function(e) {
			console.log("DONE");
		}
		
});
	
}
function otpcallEmail(user,tocken,emailid){


 	userId=user;
 	if(user){
 	$("#popup_error").text("");
 	$.ajax({
 		type : "POST",
		url : "<%=restURL%>role/sendTwilioEmail?userId="+user,
		headers: {  'Access-Control-Allow-Origin': '*' },
		timeout : 100000,
		 crossDomain: true,
		data:{},
	  
		success : function(data) {
			
			if(data.key=="200"){
				 jPrompt('One Time Password(OTP) has been sent to your email ****@'+emailid, '', 'OTP Verification', function(r) { 
					 var regexp = /^[0-9]+$/;
					   if( r &&regexp.test(r)){
						   
						   $("#popup_error").text("");
						   
						  
						   	
						 //  promptclose();
						  // return false;
						   callafterverification(r);
						   //alert('You entered ' + r);
					   }else{
						   $("#popup_error").text("Enter valid OTP");  
					   }
					   });
				 $("#link_add").css("display", "block"); 
			}else if(data.key=="201"){
				  jAlert(data.message.message, 'Error');
				//alert(data.status.message)
				//$("#popup_error").text(data.status.message);
			}else if(data.key=="500"){
				 jAlert(data.message, 'Error');
				//$("#popup_error").text(data.message);
			}else if(data.key=="400"){
				 jAlert(data.message, 'Error');
					//$("#popup_error").text(data.message);
				}

			  
			//$('#myModal').modal('show');
		
		},
		error : function(e) {
			console.log("ERROR: ", e);
			 jAlert(e, 'Error');
		},
		done : function(e) {
			console.log("DONE");
		}
		
});
 	} else{
 		 jAlert('Something went wrong. Please contact administrator', 'Error');
 	 	}
}
function newUserTwillio(email,userId){
	 jPrompt('Enter Mobile Number', '', 'Mobile Number Verification', function(r) { 
		 var regexp = /^[0-9]+$/;
		   if( r &&validatePhone(r)){
			   
			   $("#popup_error").text("");
			   
			  registermobleNumber(r,email,userId);
			
		   }else{
			  
			   $("#popup_error").text("Please enter valid mobile number");  
		   }
		   });
}
function registermobleNumber(mnumber,email,userid){
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "<%=restURL%>role/saveTwillouser",
		dataType : 'json',
		timeout : 100000,
	  data:JSON.stringify({'email':email,'phone':mnumber,'ccode':'+91','userId':userid}),
		success : function(data) {
			
			if(data.key=="200"){
				userId=data.authId;
				 jPrompt('One Time Password(OTP) has been sent your mobile number***-***-'+mnumber.substr(mnumber.length -4), '', 'OTP Verification', function(r) {
					 var regexp = /^[0-9]+$/;
					   if( r &&regexp.test(r)){
						   
						   $("#popup_error").text("");
						   
						  
						   	
						 //  promptclose();
						  // return false;
						   callafterverification(r);
						   //alert('You entered ' + r);
					   }else{
						   $("#popup_error").text("Enter valid OTP");  
					   }
					   });
			}else if(data.key=="201"){
				 // jAlert(data.status.message, 'Error');
				//alert(data.status.message)
				$("#popup_error").text(data.status.message);
			}else if(data.key=="500"){
				 //jAlert(data.message, 'Error');
				$("#popup_error").text(data.message);
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
function setUserID()
{
	var strcookieValue = getCookie("REMEMBER_TRANSACCESS_USERID");
	if(strcookieValue == null) return;
	document.getfile.username.value = strcookieValue;
	if(strcookieValue != "")
		document.getfile.remember.checked = true;
	else
		document.getfile.remember.checked = false;
		
}
function callafterverification(inputotp){
	//document.getfile.submit();
	//var inputotp=$("#inputotp").val();
	$.ajax({
		type : "POST",
		 crossDomain: true,
		url : "<%=restURL%>role/verifyotp?otp="+inputotp+"&userId="+userId,
		headers: {  'Access-Control-Allow-Origin': '*' },
		timeout : 100000,
	  
		success : function(data) {
			//$('#myModal').modal('show');
			console.log(data)
			if(data.key=="200"){
				promptclose();
				<%session.setAttribute("user", "user");%>
				window.location.href = "dashboardRMS.jsp?sessionid="+sessionStorage.getItem("sessionid");
				
			}else if(data.key=="201"){
				 // jAlert(data.status.message, 'Error');
				  $("#popup_error").text(data.message.message);
				//alert(data.status.message)
			}else if(data.key=="500"){
				// jAlert(data.message, 'Error');
				 $("#popup_error").text(data.message);
			}
			//document.getfile.submit();
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		done : function(e) {
			console.log("DONE");
		}
		
});
}

$("#popup_cancel").click(function() { 
	 <%-- <%
	 if(request.getSession().getAttribute("authId")!=null){
	 request.getSession().invalidate(); }%> --%>
	   
}); 

function otpcall(user,cell_phone){
	userId=user;
	$("#popup_error").text("");
	
	
	
   
//alert();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "<%=restURL%>role/getauthotp?userId="+user,
		headers: {  'Access-Control-Allow-Origin': '*' },
		dataType : 'json',
		timeout : 100000,
	  
		success : function(data) {
			
			if(data.key=="200"){
				 jPrompt('One Time Password(OTP) has been sent to your mobile number***-***-'+cell_phone, '', 'OTP Verification', function(r) { 
					 var regexp = /^[0-9]+$/;
					   if( r &&regexp.test(r)){
						   
						   $("#popup_error").text("");
						   callafterverification(r);
						   //alert('You entered ' + r);
					   }else{
						   $("#popup_error").text("Enter valid OTP");  
					   }
					   });
				 $("#link_add").css("display", "block"); 
			}else if(data.key=="201"){
				  jAlert(data.message.message, 'Error');
				//alert(data.status.message)
				//$("#popup_error").text(data.status.message);
			}else if(data.key=="500"){
				 jAlert(data.message, 'Error');
				//$("#popup_error").text(data.message);
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

var userId;

function submitform() {

if(document.getfile.remember.checked == true)
{
		var expires = new Date();
		expires.setMonth(expires.getMonth() + 1);
		setCookie("REMEMBER_TRANSACCESS_USERID",  document.getfile.username.value, new Date(expires), '/', '', '');
		
}
else
{
		var expires = new Date();
		expires.setMonth(expires.getMonth() + 1);
		setCookie("REMEMBER_TRANSACCESS_USERID",  "", new Date(expires), '/', '', '');
}

// var usn = document.getfile.username.value;


login();
// if(usn.indexOf("\\")<0) {
//document.getfile.submit();
<%--  $.ajax({
	type : "POST",
	contentType : "application/json",
	url : "<%=restURL%>/oauth/token?grant_type=password&username="+document.getfile.username.value+"&password="+ document.getfile.password.value+"&accessUser="+document.getfile.username.value,
	dataType : 'json',
	timeout : 100000,
   headers: {
        "Authorization": make_base_auth("restapp", "restapp")
    },
	success : function(data) {
		window.location="./Getlogin?username=" + document.getfile.username.value + "&password=" + document.getfile.password.value;
	
	},
	error : function(e) {
		console.log("ERROR: ", e);
	},
	done : function(e) {
		console.log("DONE");
	}
}); --%>


// } else {
// alert("Error:Backslash is not allowed in the username");
// } 
}


function make_base_auth(user, password) {
    var tok = user + ':' + password;
    var hash = btoa(tok);
    return 'Basic ' + hash;
}

function submitenter(myfield,e)
{
	
var keycode;
if (window.event) keycode = window.event.keyCode;
else if (e) keycode = e.which;
else return true;

if (keycode == 13)
   {
   		//myfield.submit();
   		submitform();
   		document.getElementById('Submit').disabled = true;
   		return false;
   
   }
else
   return true;
}
//-->


</script>

</body>

</html>
