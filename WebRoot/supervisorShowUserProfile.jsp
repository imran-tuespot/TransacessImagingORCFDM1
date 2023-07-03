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
		<title>Transaccess Imaging Administrator Show User Profile</title>
		<meta name="pageHeading" content='Imaging Registration' />
		<link rel="stylesheet" href="css/bootstrap.css"></link>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<script src="js/jQuery/1.11.3/jquery.min.js"></script>
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
		
	</head>
<% try{
	
	if(request.getSession().getAttribute("sessionid")!=null){	
		HashMap hashMap = userInformation.supervisorGetUserProfile(request);
	
	%>
	<body onLoad="initial_load()">
	
	
	<%-- <jsp:include page="includes/sessionHeader.jsp" /> --%>
	
	
	

	<script type="text/javascript">

	function initial_load()
	{
		setHeader('supervisorShowUserProfile.jsp');
		var array_of_li =  document.querySelectorAll("ul.tab-nav li");
    	for (var i = 0; i < array_of_li.length; i++) {
    	if(i == 1)
    		array_of_li[i].setAttribute("class", "active");	
    		
    	}
		//init();
	}
	
		
	



function validate_form()
{
    

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

	//statusChange();
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


function onEdit() {

	location.href='supervisorEditUserProfile.jsp?sessionid=<%=request.getSession().getAttribute("sessionid")%>&guestUserId=<%=hashMap.get("userId") %>&userRoleValue=<%=request.getParameter("userRoleValue")%>';

}

function resetPassword() {

	var sts = 	"<%= (String) hashMap.get("status") %>"; 
	if(sts != null && sts != "Active")
	{
		alert("This account has been disabled.  You can not generate a  password for an inactive user.");
		return;
	}
	
	var username = '<%=hashMap.get("username") %>';
	
	var answer = confirm("Click OK to confirm you want to reset the password for "+ username + "?")
	if (!answer)return;
	
	var username = '<%=hashMap.get("username") %>';
	var sessionid = '<%=request.getSession().getAttribute("sessionid") %>';
	msgbox_visible(true);
	//var interval = setInterval('msgbox_visible(true)',0000);
	
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
     	var username = '<%=hashMap.get("username") %>';
     	alert("The password has been reset for "+ username +".  \n An email with further instructions  will be sent to the user shortly.  \n The user should use the link provided in the email for reentering their password and  the application.");
     	//alert("Your password is reset. An email will be sent to you shortly. Please use the link provided in the email for reentering to the application.");
     msgbox_visible(false);
     	//var interval = setInterval('msgbox_visible(false)',0000);
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
	location.href='supervisorGrid.jsp?sessionid=<%=request.getSession().getAttribute("sessionid")%>';
}

function msgbox_visible(val){
	console.log("naven reset")
	  var e = document.getElementById('messagewindow');
	   if(val==true){
	   		e.style.display = 'block';
	   } else {
	   		e.style.display = 'none';
	   }
}	

//-->
</script>

	
	
<form name="registrationForm" method="post" action="supervisorEditUserProfileUpdate.jsp"  onSubmit="return validate_form()">

<table width= "100%">
<tr align="right">
<div class=messagewindow id=messagewindow
	style="DISPLAY: none; MARGIN: 0px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 50%; z-index: 4; text-align: center;">
	<h4>
		Resetting Password.. Please wait.
	</h4>
	<IMG src="images/progress.gif" width="32" height="32" alt="" />
</div>

<td >
	<input type="button" name="button" id="button"
							value='Cancel'
							class="btn btn-warning waves-effect waves-button waves-float"
							onclick="javascript:onCancel()" />	
							
	<input type="button" class="btn btn-success waves-effect waves-button waves-float" name="Edit" id="edit" value="Edit" onClick="onEdit()"/>
									
<input type="button" class="btn btn-primary waves-effect waves-button waves-float" name="changePassword" id="changePassword" value="Reset Password" onClick="resetPassword()"/>
</td>
</tr>
</table>
<div align="center" style="margin:20px;">
									
<p style="color:green;font-size:16px;text-align: left;margin-bottom:10px;margin-left: 10px;"><i class="zmdi_large zmdi-file"></i></i>User Information</p>
		
		
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Account information:
         </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
      <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
			<div class="card-body card-padding" style="background-color:#EDECEC">
      			<table width= "100%" border="0" cellspacing="1" cellpadding="1" align="center">
				<tr>
				<td width="225"  ><p><strong>User Name</strong></p></td>
				<td width="225" align="left">
					<p>
					  <%
						String strUserName = (String) hashMap.get("username");
					 	if(strUserName != null && strUserName.indexOf('/') > 0)
					 		strUserName = strUserName.substring(strUserName.indexOf('/') +1);
					 %>
  &nbsp;&nbsp;
  <label> <%=strUserName %> </label>
				  </p></td>
                  <td width="225"  ><p><strong>User Login ID</strong></p></td><td width="225" align="left">
				  <p>&nbsp;&nbsp;
				      <label> <%=(String) hashMap.get("username") %> </label>
			        </p></td>
          </tr>
                  <tr>  
                    
                      
					<td ><p><strong>Email</strong></p></td>
					<td align="left">
					  <p>&nbsp;&nbsp;
					      <label> <%=(String) hashMap.get("email") %> </label>
			          </p></td>
                    <td ><p><strong>Role</strong></p></td>				
				<td align="left">
				  <p>&nbsp;&nbsp;
				      <label> <%=(String) hashMap.get("role") %> </label>
                  </p></td>
                  </tr>
                  
                  
                  
				
				<tr>
					<td >
				  <p><strong>First Name</strong></p></td>
						<td align="left">
						  <p>
						    <%String fstname = (String) hashMap.get("firstName");
						 if(fstname==null) fstname =" - ";
						 %>
  &nbsp;&nbsp;
  <label> <%=fstname %> </label>
                          </p></td>
					<td >							
						<p><strong>Last Name</strong></p></td>
						<td align="left">
						  <p>
						    <% String lastname = (String) hashMap.get("lastName"); 
						if(lastname == null)lastname = " - "; 
						%>
  &nbsp;&nbsp;
  <label> <%=lastname %> </label>
                          </p></td>
				</tr>				
				
				<tr>
				
				  <td  ><p><strong>Status</strong></p></td>
				  <td align="left"> 
				    <p>&nbsp;&nbsp;
				        <label> <%=(String) hashMap.get("status") %> </label>
                    </p></td>
				
					<td >							
						<p><strong>Password Status</strong></p></td>
						<td align="left">
						  <p>
						    <% String pwdsts = (String) hashMap.get("password_status");
						if(pwdsts != null && pwdsts.compareTo("A")==0)
							pwdsts = "Active";
						else
							pwdsts = "Disabled";
						 %>
  &nbsp;&nbsp;
  <label> <%=pwdsts %> </label>
                          </p></td>
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
          Geographic Information:
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
      <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
			<div class="card-body card-padding" style="background-color:#EDECEC">
      			<table align="center" width="100%" >
				
				<tr>
					<td width="225" >
				  <p><strong>Street Address</strong></p></td>
						 
					<td width ="225"  align="left">
					  <p>
					    <%String add1 = (String) hashMap.get("address1");
					 if(add1 == null) add1 = " - ";
					 %>
  &nbsp;&nbsp;
  <label> <%=add1 %> </label>
                      </p></td>
				  
				  <td width="225" >
						<p><strong>State</strong></p></td>
					<td width="225" align="left">
					  <p>
					    <% String strState = (String) hashMap.get("state");
					if(strState == null)strState=" - ";
					 %>
  &nbsp;&nbsp;
  <label> <%=strState %> </label>
                      </p></td>
				</tr>
				<tr>
				<td><p><strong>Street Address 2 </strong></p></td>
				 
					<td align="left">
					  <p>
					    <% String add2 = (String) hashMap.get("address2"); 
					if(add2 == null) add2 = "  ";
					%>
  &nbsp;&nbsp;
  <label><%=add2 %>  </label>
                      </p></td>
					
					<td ><p><strong>Zip </strong></p></td>
					 
					<td size="25" align="left">
					  <p>
					    <% String zip = (String) hashMap.get("zip"); 
					if(zip == null)zip = " - "; 
					%>
  &nbsp;&nbsp;
  <label> <%=zip %> </label>
                      </p></td>
				</tr>
				
				<tr>
					<td >
				  <p><strong>City					</strong></p></td>
						
				  <td align="left">
				    <p>
				      <% String strcity = (String) hashMap.get("city");
				  if(strcity == null) strcity = " - ";
				   %>
  &nbsp;&nbsp;
  <label> <%=strcity %> </label>
                    </p></td>
					<td width="215" ><p><strong>Mobile Number</strong></p></td>
					<td width="215" align="left"><p>
					  <%String cell = (String) hashMap.get("cellPhone");
						if(cell == null) cell = " - ";
						 %>
  &nbsp;&nbsp;
  <label> <%=cell %> </label>
				  </p></td>
				</tr>
				<tr>
					
					<td ><p>&nbsp;</p></td>
						 
				  <td align="left"><p>&nbsp;</p></td>
				</tr>
				</table>
				<table align="center">
				<tr>
				 <td colspan="2">
				 
				 <input type="hidden" name="sessionid" value="<%=(String)request.getSession().getAttribute("sessionid") %>" />
				 <input type="hidden" name="userid" value="<%=hashMap.get("userId") %>" />

				  </td>

					<td width="0%">&nbsp;					</td>
				</tr>
				<tr>
					<td>&nbsp;					</td>
				</tr>
			</table>
			
			</div></div>
      </div>
    </div>
  </div> 
  
</div>
			
</div>
		
	
				
</form>

		<% }else{
	response.sendRedirect("index.jsp");
}  
				}catch(IllegalStateException ie){
		response.sendRedirect("index.jsp");
	}%>
		
	</body>
</html>
