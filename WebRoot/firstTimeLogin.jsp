<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Transaccess Imaging First Time Login</title>
<style type="text/css">
@import url( css/transaccessstylesheet.css );
.mainData {
	width: 850px;
	margin: auto;
}
.f-rightAlign {	float: right; }
.f-leftAlign { float: left; }
.passwordForm {
	background: #081F6B;
	padding: 15px;
	margin-bottom: 5px;
}
.labelColor { 
	color: #fff;
	margin-bottom: 10px; 
}
.inputForm {
	border: 1px solid #ccc;
    background: #fff;
    height: 30px;
    margin-bottom: 15px;
    PADDING-LEFT: 10px;
}
.goBtn {
cursor: pointer;
	    width: 75px;
    height: 32px;
    font-size: 18px;
}
.disableBg { background: rgba(216, 209, 209, 0.99); }
:focus { outline: none !important; }
.requiredField { 
	font-size: 14px;
}
</style>

<% 
   
  javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	System.out.println("restURL"+restURL);
  
  
%>
<script src="js/jQuery/jquery-1.8.2.min.js"></script>	
<!-- Include the Sidr JS -->
 <script src="js/jquery.sidr.min.js"></script>
    		
 <script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
 <script type="text/javascript" src="js/jquery.alerts.js" ></script>	
 
</head>

<script type="text/javascript">

var hasItBeen48hrs = true;
var userJSName;
var template ;
var WSURL;
var splits;
var sessionOfUser;
var verifyMessage;
$(document).ready(function(){
 	$("#showSetPassword").hide();
 	$("#sessionExperiedDiv").hide();
	
	var url = window.location.href; // or window.location.toString()
	splits=url.split("=")[1];
	var usernamesplit =splits.split("2023")[0];
	console.log("splits"+usernamesplit);
	$("#idOfUserName").val(usernamesplit.toUpperCase());
	//WSURL = "http://localhost:2221/role/sessionVerify?userSession="+"";
	//debugger;
	//sendUserSession();
	
});

function resetPassword(){
	var username1= $("#idOfUserName").val();
	var code= $("#password").val();
	sessionStorage.setItem("idOfUserName",username1);
	sessionStorage.setItem("code",code);
	
	console.log(JSON.stringify({username:username1 , code: code}));
	 $.ajax({
         type: "POST",
         url:"<%=restURL%>role/resetPassword?username="+username1+"&code="+code,
         dataType: "json",
         headers: {  'Access-Control-Allow-Origin': '*' },
         data: JSON.stringify({username:username1 , code: code}),
         success: function (data) {
         		
        	 $("#showSetPassword").hide();
        	 	$("#sessionExperiedDiv").show();
            
             } 
       });
}

 function sendUserSession(){
		//alert("sendUserSession");
		var token=sessionStorage.getItem("token");
		debugger;
	 	$.ajax({
	 		  type : "POST",
	 		  contentType : "application/json",
	 		  url : WSURL,
	 		  dataType : 'json',
	 		  timeout : 100000,
	 		 headers: {  'Access-Control-Allow-Origin': '*'  },
	 		  success : function(data) {
	 		  console.log("SUCCESS: ", data);
	 		  debugger;
	 		  //alert("SSSS:"+JSON.stringify(data));
	 		  userJSName = data.username;
	 		 console.log("userJSName: ", data.username);
	 			if( data.booleanValue == false){
	 				hasItBeen48hrs = data.booleanValue;
	 				
	 				$("#idOfUserName").val(data.username);
	 				$("#sessionIDOfUser").val(splits);	
	 				$("#showSetPassword").show();
	 				$("#intialUserName").append(data.username);
	 				localStorage.setItem("userSession",data.sessionId);
	 				
	 				
	 				 				
	 			}
	 			else{
	 				
	 				console.log('coming');
	 				
	 				//$("#sessionExperiedDiv").removeAttr('style');
	 				$("#sessionExperiedDiv").show();
	 				console.log($("#sessionExperiedDiv"));
	 				$("#intialUserName").append(userJSName);
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



function validate_form()
{
    

    if ( document.formId.password.value == "" )
    {
        alert ( "Please fill in the PASSWORD field." );
        return false;
    }
    else if ( document.formId.verifyPassword.value != document.formId.password.value )
    {
        alert ( "VERIFY PASSWORD field does not match PASSWORD field" );
        return false;
    }
    
    var username1= $("#idOfUserName").val();
	var code= $("#password").val();
	sessionStorage.setItem("idOfUserName",username1);
	sessionStorage.setItem("code",code);
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

function initial()
{

		$("#showSetPassword").show();


}


function handleResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	//alert(xmlhttp.responseText);
     	if(xmlhttp.responseText == "Disabled")
     	{
     		alert("Your account is no longer active.  Please contact your system administrator for further instructions."); 	
     		self.close();
     	}
     }    
     else {
        //alert(xmlhttp.status);
     }
   }
}





</script>

<style type="text/css">

p {
		margin:10px 10px 10px 10px;
		font-family:Arial, Helvetica, sans-serif;
		color:#fff;
		font-size:12px;

		}
		
		.username{
		
		margin:10px 10px 10px 10px;
		font-family:Arial, Helvetica, sans-serif;
		color:#ccc;
		font-size:12px;
		
		}


</style>


<body onload="initial()">

<table width="850" align="center" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="190" valign="middle" style='font-size:10px;font-family: Verdana;color:#706F6F'>
				<img src="css/images/fhalogo.png" alt='TransAccess Imaging - Document Viewer.'/>		</td>
		<td width="660" valign="bottom" >	 
		</td>
	</tr>
	<tr>
		<td colspan=2 >
			<hr />
			
		</td>
	</tr>
	<tr>
		<td height="40" colspan=2 valign="top" >	

		<table width="850" border="0" cellpadding="0" cellspacing="0">
		  <!--DWLayoutTable-->
		  <tr>
			<td width="215" height="22" valign="top" value="" id="intialUserName"> </td>
		    <td width="215">
			
			
			
			</td>
		  </tr>
		</table>
		
		
		
		</td>
	</tr>
</table>

<div id="showSetPassword" style="display:none">
		  <!--DWLayoutTable-->
	 <div class="mainData">	 
	<div height="22" colspan="2" valign="top" align="left">Either this is your first time signing in, or your password has been reset by the Administrator. You must set a new password. Please remember your user sign in ID and new password as you will need both to access the system in the future. </div>
    <div class="f-leftAlign">
    <br />
    <table border="0" cellspacing="5">
    <tr><td height="22" colspan="2" valign="top" align="left"><b>Your new password must conform to the following password policy:</b></td></tr>
	<tr><td height="22" colspan="2" valign="top" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-Be different from your user sign in ID and email address.</td></tr>
	<tr><td height="22" colspan="2" valign="top" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-Have minimum length of 8 characters and maximum of 32 characters.</td></tr>
	<tr><td height="22" colspan="2" valign="top" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-Contain characters from all of the following three categories:</td></tr>
	<tr><td height="22" colspan="2" valign="top" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-English uppercase characters(A....Z)</td></tr>
	<tr><td height="22" colspan="2" valign="top" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-English lowercase characters(a....z)</td></tr>
	<tr><td height="22" colspan="2" valign="top" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-Numeric characters(0,1,2...9) or Non-alphanumeric(For Example,!,$,#,%)</td></tr>
	<tr><td height="22" colspan="2" valign="top" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-Non-alphanumeric(For Example,!,$,#,%)</td></tr>
	</table>
	</div>
	<div class="f-rightAlign">
	<form name="formId" action="firstTimeLoginComplete.jsp" method="post" onSubmit="return validate_form()">
		 <div class="passwordForm"> 
		    <div class="labelColor">User Sign In ID </div>			
			<input type="text" size="30" class="inputForm disableBg" disabled="disabled" value="" id = "idOfUserName" />
			
			<div class="labelColor">New Password *</div>			
			<input type="password" size="30" class="inputForm" name="password" id="password" size="25" />
				
			<div class="labelColor">Verify New Password *</div>
			<input type="password" size="30" class="inputForm" name="verifyPassword" id="verifyPassword" size="25" />
			
			
			<div align="right"><input type="submit" class="goBtn" onclick=" return validate()" value="Go" /></div>
	<input type="hidden" name="sessionId" value="" id ="sessionIDOfUser"/>
	<input type="hidden" name="username" value=""  />
	
	</div>
	<font color="red" class="requiredField" >*=Required Field</font>
</form>
</div>
</div> 


</div>

<div id="sessionExperiedDiv" style="display:none">
 <table width="850" border="0" cellpadding="0" cellspacing="0" align="center">
		  <tr>
			<td width="215" height="22" valign="top">
			Your time to login has EXPIRED!!
			</td>
		    <td width="215">
		    <b>
		    The session to login for this user has expired.  Please take the time to contact the administrator to reset your login information and try again.
		    </b>
		    </td>
		  </tr>
</table>
 
 </div>

<div id ="showSuccess"></div>

<jsp:include page="footer.jsp" />

<script type="text/javascript">

function validate(){
debugger;
var Char;
var IsNumber=true; 
var v1 = "!@#$%^&*";
var v2 = "0123456789";
var v3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
var v4 = "abcdefghijklmnopqrstuvwxyz";
var password = document.getElementById("password").value;
var verpassword = document.getElementById("verifyPassword").value;
var username = userJSName;

	if(password == username)
	{
		alert("Invalid Password.Password should be different from sign in ID.");
		return false;
	}

	if(password == "" )
	{
		alert("Password cannot be blank");
		return false;
	}

	if(password != verpassword)
	{
		alert("Password and Verify Password should match.");
		return false;
	}

	if(password.length < 8 || password.length > 32 )
	{
		alert("Invalid Password Length.");
		return false;

	}
	
	var passed = validatePassword(password, {
	length:   [8, 32],
	lower:    1,
	upper:    1,
	numeric:  1,
	special:  0,
	badWords: [username],
	badSequenceLength: 8
	});
	
	if ( passed == false ) {
		alert("Invalid Password.");
		return false;
	}
    
	
    localStorage.setItem("userName",username);
    localStorage.setItem("password",password);
	
	console.log("ssssession"+window.localStorage.getItem("userName"));
	
	
	/* debugger;
	
		//alert("newUserCreation");
	 	$.ajax({
	 		  type : "POST",
	 		  contentType : "application/json",
	 		  url : "http://localhost:8688/TransAccessImagingWS/role/setPassword",
	 		  dataType : 'json',
	 		  timeout : 100000,
	 		  data : JSON.stringify(setPasswordData),
	 		  success : function(data) {
	 		  console.log("SUCCESS: ", data);
	 		 $("showSuccess").append("<h3>PasswordUpdatedSuccessFully</h3>");
	 		   
	 		   
	 		  },
	 		  error : function(e) {
	 		   console.log("ERROR: ", e);
	 		   alert("12313122error");
	 		   displayRights(e);
	 		  },
	 		  done : function(e) {
	 		   console.log("DONE");
	 		  }
	 		 }); */
		return true;
}

function validatePassword (pw, options) {
	// default options (allows any password)
	var o = {
		lower:    0,
		upper:    0,
		alpha:    0, /* lower + upper */
		numeric:  0,
		special:  0,
		length:   [0, Infinity],
		custom:   [ /* regexes and/or functions */ ],
		badWords: [],
		badSequenceLength: 0,
		noQwertySequences: false,
		noSequential:      false
	};

	for (var property in options)
		o[property] = options[property];

	var	re = {
			lower:   /[a-z]/g,
			upper:   /[A-Z]/g,
			alpha:   /[A-Z]/gi,
			numeric: /[0-9,\W_]/g,
			special: /[\W_]/g
		},
		rule, i;

	// enforce min/max length
	if (pw.length < o.length[0] || pw.length > o.length[1])
		return false;

	// enforce lower/upper/alpha/numeric/special rules
	for (rule in re) {
		if ((pw.match(re[rule]) || []).length < o[rule])
			return false;
	}

	// enforce word ban (case insensitive)
	for (i = 0; i < o.badWords.length; i++) {
		if (pw.toLowerCase().indexOf(o.badWords[i].toLowerCase()) > -1)
			return false;
	}

	// enforce the no sequential, identical characters rule
	if (o.noSequential && /([\S\s])\1/.test(pw))
		return false;

	// enforce alphanumeric/qwerty sequence ban rules
	if (o.badSequenceLength) {
		var	lower   = "abcdefghijklmnopqrstuvwxyz",
			upper   = lower.toUpperCase(),
			numbers = "0123456789",
			qwerty  = "qwertyuiopasdfghjklzxcvbnm",
			start   = o.badSequenceLength - 1,
			seq     = "_" + pw.slice(0, start);
		for (i = start; i < pw.length; i++) {
			seq = seq.slice(1) + pw.charAt(i);
			if (
				lower.indexOf(seq)   > -1 ||
				upper.indexOf(seq)   > -1 ||
				numbers.indexOf(seq) > -1 ||
				(o.noQwertySequences && qwerty.indexOf(seq) > -1)
			) {
				return false;
			}
		}
	}

	// enforce custom regex/function rules
	for (i = 0; i < o.custom.length; i++) {
		rule = o.custom[i];
		if (rule instanceof RegExp) {
			if (!rule.test(pw))
				return false;
		} else if (rule instanceof Function) {
			if (!rule(pw))
				return false;
		}
	}

	// great success!
	return true;
}


</script>

</body>
</html>
