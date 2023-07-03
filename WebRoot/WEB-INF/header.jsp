<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
@import url( css/styleSheet.css );
</style>


<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<%@page import="java.util.*"%>

<%@page import="com.peniel.beans.SessionBean"%>
<%@page import="org.apache.commons.lang.*"%>


<%
  SessionBean s = new SessionBean();
  String sessionId = "";
  
  int id = -1;
  
  if(!StringUtils.isBlank((String)request.getAttribute("sessionid")))
  {
  	sessionId = (String)request.getAttribute("sessionid");
  	id = s.getUserSessionList(sessionId, request);
  }
  else if(!StringUtils.isBlank((String)request.getParameter("sessionid")))
  {
  	sessionId = (String)request.getParameter("sessionid");
  	id = s.getUserSessionList(sessionId, request);
  }

  //System.out.println("id -->"+id);

 // Later to be changed to make part of singleton / session	
  HashMap hashMap = userInformation.getUserInformation(request);
  String strRole = (String) hashMap.get("role");
  //System.out.println("role-->"+strRole);


  if ( id <= -1) 
  {
	RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	rd.forward(request, response); 
  }
%>







<script type="text/javascript">

function onClickLink(nType)
{
	var sessionid = '<%=request.getAttribute("sessionid") %>';
	var oDisplayID = document.getElementById("headertext");	
	if(nType == 0)
	{
		location.href = "myProfile.jsp?sessionid="+sessionid;
		//setHeader("myProfile.jsp");
	}
	if(nType == 1)
	{
		location.href = "search.jsp?sessionid="+sessionid;
		//setHeader("Page2.jsp");
	}
	if(nType == 2)
	{
		// location.href = "supervisorGrid.jsp?sessionid="+sessionid;
		location.href = "dashboard.jsp?sessionid="+sessionid;
		//setHeader("admin.jsp");
	}

}
//window.onload = init;
function init()
{
	/*
	var oDisplayID = document.getElementById("headertext");
	if(oDisplayID == null)
		return;	
	var text = getCookie("IMAGING_HEADER_TEXT");
	if(text== null)
		text = "";
	
    var backurl = "";
	if(text != "")
	{
		backurl = getBackImageURL(text); 
		text += backurl;
	}	
	oDisplayID.innerHTML = text;
	*/
		
}

function locationClick(url)
{


	if(url == "HISTORYBACK")
	{
		history.back(1);
	}
	else if(url == "STOREURL")
	{
		var prevURL = getCookie("IMAGING_HEADER_PREV_URL");
		location.href = prevURL;
	
	}
	else
	{
		var sessionid = '<%=request.getAttribute("sessionid") %>';
		location.href = url + "?sessionid="+sessionid;
	}
}

function locationClicks(url)
{
	location.href = url ;
}

var oMainPageArray = new Array();
oMainPageArray[0] = "search.jsp";
oMainPageArray[1] = "myProfile.jsp";
oMainPageArray[2] = "dashboard.jsp";
oMainPageArray[3] = "supervisorShowUserProfile.jsp";
oMainPageArray[4] = "docMgmtSearchGrid.jsp";
oMainPageArray[5] = "addDoc.jsp";
oMainPageArray[6] = "supervisorGrid.jsp";
oMainPageArray[7] = "supervisorEditUserProfile.jsp";
oMainPageArray[8] = "registration.jsp";
oMainPageArray[9] = "editDocument.jsp";
oMainPageArray[10] = "editDocProfile.jsp";
oMainPageArray[11] = "replaceDocument.jsp";
oMainPageArray[12] = "auditTrailList.jsp";


var oMainPageText = new Array();
oMainPageText[0] = "Search"; // back to Admin home page
oMainPageText[1] = "My Profile";  // 
oMainPageText[2] = "Admin Home";
oMainPageText[3] = "User Profile";
oMainPageText[4] = "Document Management"; // back to Admin home page
oMainPageText[5] = "Document Management"; // back to Admin home page
oMainPageText[6] = "User Management"; // back to Admin home page
oMainPageText[7] = "User Profile";
oMainPageText[8] = "New User Profile";
oMainPageText[9] = "Document Details";
oMainPageText[10] = "Document Management";
oMainPageText[11] = "Replace Document";
oMainPageText[12] = "Audit Trail";



var oBackPageText = new Array();
oBackPageText[0] = ""; // back to Admin home page
oBackPageText[1] = "Search";  // 
oBackPageText[2] = "";
oBackPageText[3] = "User Management Home";
oBackPageText[4] = "Admin Home";
oBackPageText[5] = "Admin Home";
oBackPageText[6] = "Admin Home";
oBackPageText[7] = "User Management Home";
oBackPageText[8] = "User Management Home";
oBackPageText[9] = "Document Management Home";
oBackPageText[10] = "Document Management Home";
oBackPageText[11] = "Document Details";
oBackPageText[12] = "Document Details";

var oBackPageURL = new Array();
oBackPageURL[0] = "dashboard.jsp"; // back to Admin home page
oBackPageURL[1] = "search.jsp";  // 
oBackPageURL[2] = "";
oBackPageURL[3] = "supervisorGrid.jsp";
oBackPageURL[4] = "dashboard.jsp";
oBackPageURL[5] = "dashboard.jsp";
oBackPageURL[6] = "dashboard.jsp";
oBackPageURL[7] = "supervisorGrid.jsp";
oBackPageURL[8] = "supervisorGrid.jsp";
oBackPageURL[9] = "docMgmtSearchGrid.jsp";
oBackPageURL[10] = "HISTORYBACK";
oBackPageURL[11] = "HISTORYBACK";
oBackPageURL[12] = "HISTORYBACK";

function setHeaderURL(text)
{
	if(text == "") return "";
	var oDisplayID = document.getElementById("headertext");
	if(oDisplayID == null)
		return;	
	
	
	var sURL = "";	
	for(var i=0; i < oMainPageArray.length ; i++)
	{
		//alert(oMainPageArray[i]);
	
		if(oMainPageArray[i] == text)
		{
			sURL = oMainPageText[i];
			if(oBackPageText[i] != "")
				sURL += " | Back to <a href='javascript:locationClick(\"" + oBackPageURL[i] + "\")'><font color='white'>" + oBackPageText[i] + "</font></a>";	
		}
	
	}
	 	
	oDisplayID.innerHTML = sURL;

}

function setHeaderText(text,backtext,backurl)
{
	//alert('text-->'+text+'<--backtext-->'+backtext+'<--backurl-->'+backurl);
	if(text == "") return "";
	var oDisplayID = document.getElementById("headertext");
	if(oDisplayID == null)
		return;	
	
	var sURL = text;	
	if(backtext != "")
		sURL += " | Back to <a href='javascript:locationClicks(\"" + backurl + "\")'><font color='white'>" + backtext + "</font></a>";	
		
	oDisplayID.innerHTML = sURL;

}




function setHeader(text)
{
	storeURLs();
	setHeaderURL(text);
	
}

function storeURLs()
{
	var expires = new Date();
	expires.setMonth(expires.getMonth() + 1);

	var prevURL = getCookie("IMAGING_HEADER_URL");
	setCookie("IMAGING_HEADER_PREV_URL", prevURL, new Date(expires), '/', '', '');
	setCookie("IMAGING_HEADER_URL", location.href, new Date(expires), '/', '', '');
	


}

function setCookie(name, value, expires, path, domain, secure) {
  var curCookie = name + "=" + escape(value) +
      ((expires) ? "; expires=" + expires.toGMTString() : "") +
      ((path) ? "; path=" + path : "") +
      ((domain) ? "; domain=" + domain : "") +
      ((secure) ? "; secure" : "");
  document.cookie = curCookie;
}

function getCookie(name) {
  var dc = document.cookie;
  var prefix = name + "=";
  var begin = dc.indexOf("; " + prefix);
  if (begin == -1) {
    begin = dc.indexOf(prefix);
    if (begin != 0) return null;
  } else
    begin += 2;
  var end = document.cookie.indexOf(";", begin);
  if (end == -1)
    end = dc.length;
  return unescape(dc.substring(begin + prefix.length, end));
}


function deleteCookie(name, path, domain) {
  if (getCookie(name)) {
    document.cookie = name + "=" +
    ((path) ? "; path=" + path : "") +
    ((domain) ? "; domain=" + domain : "") +
    "; expires=Thu, 01-Jan-70 00:00:01 GMT";
  }
}


</script>

</head>

<body>

<p>&nbsp; </p>


<!-- Header for this design will go here --> 
<div class="headPageContainer"><img src="images/transaccess.jpg" alt="Logo" width="200" height="60" /></div>

<div class="mainBlueHeading" align="right">

<table width="1000" height="19" border="0" cellpadding="0" cellspacing="0">
  <!--DWLayoutTable-->
  <tr>
    <td width="433" height="19" valign="top" align="left"> </td>
    <td width="567" valign="top" align="right">
	
		<div class="mainBlueHeadingText">
		
			<a href="javascript:onClickLink(0)" >My Profile</a>&nbsp; | &nbsp;
			<a href="javascript:onClickLink(1)" >Search</a> &nbsp; | &nbsp;
			  <% if(strRole != null && strRole.compareTo("ADMIN") == 0) { %>	
			  <a href="javascript:onClickLink(2)" >Admin</a>&nbsp; | &nbsp;
			  <% } %>
			  <a href="manual.pdf" target="_blank" >User Manual</a> &nbsp; | &nbsp;
			  <a href="logout.jsp?sessionid=<%=request.getAttribute("sessionid") %>" >Logout</a>&nbsp;&nbsp;
		</div>  
	    </td>
  </tr>
</table>

		

</div>

	<div class="userInformaiton"> <%=request.getAttribute("username") %> 
	
	
	</div>

 
		  

</body>
</html>
