
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">



<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Transaccess Imaging Forgot Password</title>
 <script type="text/javascript" src="js/jQuery/1.11.3/jquery.min.js" ></script>

<link rel="stylesheet" type="text/css" href="css/app.css" />
<link rel="stylesheet" type="text/css" href="css/styleSheet.css" />

<%javax.naming.Context ctx = 	new javax.naming.InitialContext();
String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
String URL = (String) ctx.lookup("java:comp/env/URL"); %>




</head>

	<script type="text/javascript">
<!--
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

function validate()
{

    if ( document.formId.username.value == "" )
    {
        alert ( "Please fill in the User Login ID field." );
        return false;
    }
    
    validateUserStatus();
    
    return false;
}

function validateUserStatus()
{
if(xmlhttp) { 

	//alert("In validateuserstatus");
	var username = document.formId.username.value;
    xmlhttp.open("POST","GetUsernameValidation",true); 
    xmlhttp.onreadystatechange  = handleResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("username=" + username + "&userstatuscheck=1");
  } 
	
}

function handleResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	// alert(xmlhttp.responseText);
		if(xmlhttp.responseText == "Disabled")
		{
			alert("Your account is no longer active.  Please contact your system administrator for further instructions."); 
		}
		else if(xmlhttp.responseText == "none")
		{
			alert("There is not a record that is associated with that username.  Please make sure that the username is entered correctly."); 
		}
		else
		{
			document.formId.submit();
		}
		
		document.formId.username.value = "";
		
     	//if(xmlhttp.responseText != "Disabled")
     		//document.formId.submit();
     	//else
     		//alert("Your account is no longer active.  Please contact your system administrator for further instructions."); 	
     }    
     else {
        //alert(xmlhttp.status);
     }
   }
}

//-->

function validate()
{

    if ( document.formId.username.value == "" )
    {
        alert ( "Please fill in the User Login ID field." );
        return false;
    }
    
    validateUserStatus();
    
    return false;
}

function validateUserStatus(){
	var usernameData = $('#usernameData').val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
 		url : "<%=restURL%>role/forgotPassword?username="+usernameData,
// 		url : "http://localhost:2221/role/forgotPassword?username="+usernameData,
		dataType : 'json',
		headers: {  'Access-Control-Allow-Origin': '*' },
		timeout : 100000,
		 crossDomain: true,
		success : function(data) {
		console.log(data.messageBody);
		sessionStorage.setItem("messageBody",data.messageBody);
		window.location= "forgotPasswordComplete.jsp";
			
								
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		done : function(e) {
			console.log("DONE");
		}
		
});
}
/* 
$(document).ready(function(){
  $("#usernameData").on("keyup", function() {
    document.getElementById("usernameData").innerHTML =  $(this).val().toLowerCase()ntById("usernameData").value.ignoreCase;

  });
}); */

</script>

<body>


<div class="headPageContainer">
<div id="ghUtilBar" class="">
<div id="ghMainUtil">
<div id="ghClientSegment"></div></div></div>
		<table width="1150" height="44" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="400"><img src="css/images/fhalogo.png" alt='TransAccess Imaging - Document Viewer.' width="156" height="85" /></td>
			<td colspan="3" rowspan="3" style="width:100%;color:#0A68B4">
			<div class="" style="font-size:32px;margin-left:35px;text-align:right;">
			 RMS Help Desk
			<div style="font-size:13px;margin-left: 40%;text-align:right;" class="text-center">Powered by TransAccess (PSL)</div>
			 </div>
			</td>
			<!-- <td width="500" valign="bottom"><div align="right">
			 <img src="images/imagingText.jpg" alt="Imaging" width="133" height="53" />
			</div></td> -->
		  </tr>
		</table>
<img src="images/homePageImage.jpg" alt="Working" height="150" width="1170">
  
	</div>

<div class="blueHeading">
	<div align="center">Forgot Password  </div>
</div>

<div class="mainContentAreaContainer">
  
  <form name="formId" action="forgotPasswordComplete.jsp" method="post" >
<table width="850" border="0" cellspacing="5" align="center">
		  <tr align="left">
		    <td  colspan="2" valign="top"><p>Enter your User Log In ID.  Once your user log in information has been validated, an email will be sent to the address on file with further instructions on how to reset your password.  If you need further assistance, please contact your system administrator.</p></td>
    </tr>
    </table>
    <table align="center" style="margin-top: 20px;">
		  <tr>
			<td width="90" valign="middle">
			  <p style="margin: 0px;">User Log In ID:			</p></td>
		    <td width="204" valign="middle" >
			<input type="text" id="usernameData" name="username" size="25" />			</td>
		  <td width="39" valign="middle"><input type="button" class="btn btn-primary" value="Go" onclick="validate()"/></td>
		  <td width="97" valign="middle"><input type="button"  class="btn btn-success" value="Cancel" onclick="window.location.href='index.jsp'" /></td>
		  </tr>
		  <tr>
		    <td valign="top"> </td>
		    <td></td>
    </tr>
    <tr>
		    
		    <td></td>
    </tr>
	</table>

	
</form>
  
  

</div>


<div class="footer"> 
	<div class="footerPadding">
	<p>All information on this computer system may be intercepted, recorded, read, copied, and disclosed by and to authorized personnel for official purposes, including criminal investigations. Such information includes sensitive data encrypted to comply with confidentiality and privacy requirements. Access or use of this computer system by any person, whether authorized or unauthorized, constitutes consent to these terms. There is no right of privacy in this system. </p>
	    
	<p>&nbsp;</p>
	 <a href="http://www.TransAccessGCR.com">
<img src="images/Version 4.png" alt="Peniel Solutions, LLC" width="220" height="">
</a>
	<!--  <p><img src="images/penielLogo.jpg" alt="Peniel Solutions, LLC" width="120" height=""></p> -->
	</div>

</div>









</body>
</html>
