<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:useBean id="passwordReset" scope="request" class="com.peniel.beans.PasswordReset" />
<jsp:setProperty name="passwordReset" property="*" />
<%-- %

	String confirmationMessage = passwordReset.getPasswordReset(request.getParameter("username"), "");


 %> --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
 <script type="text/javascript" src="js/jQuery/1.11.3/jquery.min.js" ></script>

<title>RMS HelpDesk First Time Login</title>



<link rel="stylesheet" type="text/css" href="css/styleSheet.css" />
<script>
function setMessage(){
	console.log(sessionStorage.getItem("messageBody"));
	var mes =sessionStorage.getItem("messageBody");
	if(mes.includes('Your account has been disabled')){
		$('#message').css({"color":"red","font-weight":"bold","margin-bottom":"20px"});
		
	}else{
		$('#message').css({"color":"green","font-weight":"bold","margin-bottom":"20px"});
	}
$('#message').text(sessionStorage.getItem("messageBody"));
//sessionStorage.removeItem("messageBody");
}
</script>
</head>

	


<body onLoad="setMessage();">

<div class="headPageContainer">
<div id="ghUtilBar" class="">
<div id="ghMainUtil">
<div id="ghClientSegment"></div></div></div>
		<!-- <table  height="44" border="0" cellpadding="0" cellspacing="0">
		  DWLayoutTable
		  <tr>
			<td width="500"><img src="css/images/fhalogo.png" alt='TransAccess Imaging - Document Viewer.' width="156" height="53" /></td>
			<td width="500" valign="bottom"><div align="right">
			 <img src="images/imagingText.jpg" alt="Imaging" width="133" height="53" />
			</div></td>
		  </tr>
		</table> -->
			<table width="1150" height="44" border="0" cellpadding="0" cellspacing="0">
		  <!--DWLayoutTable-->
		  <tr>
			<td  style="padding-left: 10px"><img src="css/images/fhalogo.png " alt='TransAccess Imaging - Document Viewer.' width="156" height="80" style="margin-left:-10px;"/></td>
			<td  rowspan="3" style="width:100%;color:#0A68B4">
			<div class="" style="font-size:32px;margin-left:35px;text-align:right;">
			 Records Management Service
			<div style="font-size:13px;margin-left:2%;text-align:right;" class="text-center">Powered by TransAccess (PSL)</div>
			 </div>
			</td>
			<td width="500" style="padding-right: 10px" valign="bottom"><div align="right">
<!-- 			 <img src="images/imaging2.jpg" alt="Imaging" width="133" height="53">
 -->			</div></td>
		  </tr>
		</table>
<div style="background-color: #ccc;">
<div id="ghMainUtil">
<div id="ghClientSegment"></div></div></div>
  
</div>

<div class="mainBlueHeading">
	<div align="center" ><h2>Forgot Password  </h2></div>
</div>


<div class="mainContentAreaContainer">

		<table width="850" border="0" cellpadding="0" cellspacing="0" align="center">
			  <!--DWLayoutTable-->
			  <tr align="center">
			    <td width="500">
			<div id="message">    <b>
			   			    </b></div>
			    <input name="button" type="button" onclick="window.location.href='index.jsp'" value="Back to the Homepage" /></td>
			  </tr>
		</table>
  

</div>

<div class="footer"> 
	<div class="footerPadding">
	<p>All information on this computer system may be intercepted, recorded, read, copied, and disclosed by and to authorized personnel for official purposes, including criminal investigations. Such information includes sensitive data encrypted to comply with confidentiality and privacy requirements. Access or use of this computer system by any person, whether authorized or unauthorized, constitutes consent to these terms. There is no right of privacy in this system. </p>
	    
	<p>&nbsp;</p>
	<a href="http://www.TransAccessGCR.com">
<img src="images/Version 4.png" alt="Peniel Solutions, LLC" width="220" height="">
</a>
	<!-- <p><img src="images/penielLogo.jpg" alt="Peniel Solutions, LLC" width="120" height=""></p> -->
	</div>

</div>
</body>
</html>
