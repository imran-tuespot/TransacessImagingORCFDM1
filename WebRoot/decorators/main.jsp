<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.*"%>
<html>
<head>
<%
	javax.naming.Context ctx = new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	String URL = (String) ctx.lookup("java:comp/env/URL");
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Cache-Control" content="private" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<title>TransAccess Imaging- <decorator:title default="Welcome!" /></title>
<!--  <script type="text/javascript" src="js/jquery-1.3.2.js" ></script>
         <script src="js/jQuery/1.11.3/jquery.min.js"></script>-->

<!-- <script src="js/bootstrap/3.3.5/jquery.min.js"></script>  -->
<link rel="stylesheet" type="text/css" href="css/app.css"></link>
<link rel="stylesheet" href="css/material-design-iconic-font.css">
<link rel="stylesheet" type="text/css" href="css/fancyTable.css"></link>
<!-- Include Sidr bundled CSS theme -->
<link rel="stylesheet" href="css/jquery.sidr.dark.css">


<style type="text/css">
@import url( css/styleSheet.css );
</style>
<style>

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

.badge {
	position: absolute;
	padding: 4px 4px;
	border-radius: 50%;
	background: red;
	color: white;
	opacity: 2;
	margin-left: -35px !important;
}
</style>

<jsp:useBean id="userInformation" scope="request"
	class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<%@page import="java.util.*"%>

<%@page import="com.peniel.beans.SessionBean"%>
<%@page import="org.apache.commons.lang.*"%>



<style>
/* .tab-nav:not([data-tab-color]) > li > a:after {
    background: none;
}
 */
</style>
<script type="text/javascript" src="js/jQuery/1.11.3/jquery.min.js">
</script>
<script type="text/javascript">
 $(document).ready(function (){
	
	 loadFunction();
	 
     $(".main li a").on("click", function (){
        $(this).addClass("active").siblings(".active").removeClass("active");
    	
    }); 
   
   
});
 
 

 
 </script>

<script type="text/javascript">
function loadFunction(){

<%-- 	  var companyFullName='<%=companyFullName%>'; --%>
	  $("#emptyCompanyName").hide();
	 /*  if(companyFullName!=""){
		  $("#emptyCompanyName").hide();
		  $("#companyName").show();
		  
	  }else{
		  $("#emptyCompanyName").show();
		  $("#companyName").hide();
	  } */
	  getCount();
}
 
function getHeaderusername(){
	
	var userId=sessionStorage.getItem("userId");
	 var token=sessionStorage.getItem("token");
	var username=sessionStorage.getItem("username");
	var appname="HLPDSK";
	var appidrole=JSON.parse(sessionStorage.getItem("roles"));
	var role=appidrole.role_NAME;
	role= role.replace(" ADMIN","");
	console.log(username)
	//$("#usernameId").val("'"+username+"'");
	var div = document.getElementById('usernameId');
	var div1= document.getElementById('applicationid');

	div.innerHTML = username;
	div1.innerHTML = role;
	
	
}
function getCount(){
	var token=sessionStorage.getItem("token");
	var userinfo=JSON.parse(sessionStorage.getItem("roles"));		  
	var userIdforNotification =sessionStorage.getItem("userId");     				
			var str="&role="+userinfo.role_NAME+"&appId="+2+"&userIdforNotification="+userIdforNotification; 
			$("#result").text("");
			//$("#loadingImage").show();
			$.ajax({
		 		type : "POST",
		 		url : "<%=restURL%>rmshd/viewAllTicketsByAppId?"+str,
		 		datType : "json",
		 		 headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
		 		ContentType : "application/json; charset=utf-8",
		 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
		 		success : function(response) 
		 		{ 
				   		
		 			$.ajax({
				 		type : "GET",
				 		url : "<%=restURL%>rmshd/getTicketCount",
				 		datType : "json",
				 		 headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
				 		ContentType : "application/json; charset=utf-8",
				 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
				 		success : function(response) 
				 		{
				 	
						   		if(response.count!=0){
						   		$("#count").append(
						   		response.count
						   		)
				 		}
				 			
				 			
					
			  }
      
			});
	 
}
			});
}
</script>



<script type="text/javascript">

function onClickLink(nType)
{
	var oDisplayID = document.getElementById("headertext");	
	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
		array_of_li[i].removeAttribute("class", "active");	
		
	}
	
      // $(this).addClass('active');
	
	if(nType == 0)
	{
		location.href = "profile.jsp";
		
	}
	if(nType == 1)
	{
		location.href = "search.jsp";
		
	}
	if(nType == 2)
	{
		// location.href = "supervisorGrid.jsp?sessionid="+sessionid;
		location.href = "dashboard.jsp";
		
	}
	if(nType == 3)
	{
		
		location.href = "dashboardRMS.jsp";
		
	}
	if(nType == 4)
	{
		
		location.href = "addDoc.jsp";
		
	}
	if(nType == 5)
	{
		
		location.href = "myFiles.jsp";
		
	}
	
	
	
	if(nType == 6)
	{
		
		location.href = "addDocuments.jsp";
		
	}
	
	if(nType == 7)
	{
		
		location.href = "purgeRecord.jsp";
		
	}
	if(nType == 8)
	{
		
		location.href = "dropbox.jsp";
		
	}
	if(nType == 9)
	{
		
		location.href = "pendinguploads.jsp";
		
	}
	if(nType == 10)
	{
		
		location.href = "ticketCreation.jsp";
		
	}
	if(nType == 11)
	{
		
		location.href = "Training.jsp";
		
	}
	if(nType == 12)
	{
		
		location.href = "faq.jsp";
		
	}
	if(nType == 13)
	{
		
		location.href = "help.jsp";
		
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
		var sessionid = '<%=request.getSession().getAttribute("sessionid")%>';
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
//oMainPageArray[7] = "supervisorEditUserProfile.jsp";
oMainPageArray[7] = "registration.jsp";
oMainPageArray[8] = "editDocument.jsp";
oMainPageArray[9] = "editDocProfile.jsp";
oMainPageArray[10] = "replaceDocument.jsp";
oMainPageArray[11] = "auditTrailList.jsp";
oMainPageArray[12] = "addRequiredDocs.jsp";
oMainPageArray[13] = "userAuditTrail.jsp";
oMainPageArray[14] = "docDownloadSearchGrid.jsp";
oMainPageArray[15] = "newDocType.jsp";
oMainPageArray[16] = "sendMails.jsp";
oMainPageArray[17] = "AddRequiredDocumentView.jsp";
oMainPageArray[18] = "newIndexType.jsp";
oMainPageArray[19] = "companyProfile.jsp";
oMainPageArray[20] = "addBatch.jsp";
oMainPageArray[21] = "newFolder.jsp";
oMainPageArray[22] = "myFiles.jsp";
oMainPageArray[23] = "addProperty.jsp";
oMainPageArray[24] = "editProperty.jsp";
oMainPageArray[25] = "propertyList.jsp";
oMainPageArray[26] = "basicExport.jsp";
oMainPageArray[27] = "rightsCreation.jsp";
oMainPageArray[28] = "roleCreation.jsp";
oMainPageArray[29] = "inactiveFHANumbers.jsp";
oMainPageArray[30] = "moduleCreation.jsp";
oMainPageArray[31] = "subModuleCreation.jsp";
oMainPageArray[32] = "retensionSchedule.jsp";
oMainPageArray[33] = "propertyRequest.jsp";
oMainPageArray[34] = "purgeRecord.jsp";
oMainPageArray[35] = "addDocuments.jsp";
oMainPageArray[36] = "addTransactionDocuments.jsp";

var oMainPageText = new Array();
oMainPageText[0] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Search Documents"; // back to Admin home page
oMainPageText[1] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> My Profile";  // 
oMainPageText[2] = "<i class='zmdi_large zmdi-settings-square my_popup_open'></i> Admin Home";
oMainPageText[3] = "User Profile";
oMainPageText[4] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Document Management Search"; // back to Admin home page
oMainPageText[5] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Add New Document"; // back to Admin home page
oMainPageText[6] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> User List"; // back to Admin home page
//oMainPageText[7] = "Edit User Profile";
oMainPageText[7] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a>New User Profile";
oMainPageText[8] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Document Details";
oMainPageText[9] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Edit Document Details";
oMainPageText[10] = "Replace Document";
oMainPageText[11] = "Audit Trail";
oMainPageText[12] = "Add Required Documents";
oMainPageText[13] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a>Document Report";
oMainPageText[14] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a>Select Documents for Download";
oMainPageText[15] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a>Add Document Type";
oMainPageText[16] = "Send Mail";
oMainPageText[17] = "View Required Documents";
oMainPageText[18] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Add Index Type";
oMainPageText[19] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Company Profile";
oMainPageText[20] = "Batch Upload";
oMainPageText[21] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Folders";
oMainPageText[22] = "Files Accessed";
oMainPageText[23] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Add New Property";
oMainPageText[24] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Manage Property";
oMainPageText[25] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Property List";
oMainPageText[26] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Property List";
oMainPageText[27] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Rights List";
oMainPageText[28] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Roles List";
oMainPageText[29] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Inactive Loans";
oMainPageText[30] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Module List";
oMainPageText[31] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Sub Module List";
oMainPageText[32] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Edit Archive";
oMainPageText[33] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Property Management";
oMainPageText[34] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Purge Records";
oMainPageText[35] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Add New Document";
oMainPageText[36] = "<a id='simple-menu' href='#sidr'><i class='zmdi zmdi-menu'></i></a> Add New Asset Management Document"; // back to Admin home page



var oBackPageText = new Array();
oBackPageText[0] = ""; // back to Admin home page
oBackPageText[1] = "";  // 
oBackPageText[2] = "";
oBackPageText[3] = "User List";
oBackPageText[4] = "";
oBackPageText[5] = "";
oBackPageText[6] = "";
//oBackPageText[7] = "User Profile";
oBackPageText[7] = "User List";
oBackPageText[8] = "Document Management Search Results";
oBackPageText[9] = "Document Management Search Results";
oBackPageText[10] = "Edit Document Details";
oBackPageText[11] = "Document Details";
oBackPageText[12] = "";
oBackPageText[13] = "";
oBackPageText[14] = "";
oBackPageText[15] = "";
oBackPageText[16] = "";
oBackPageText[17] = "Add Required Documents";
oBackPageText[18] = "";
oBackPageText[19] = "";
oBackPageText[20] = "";
oBackPageText[21] = "";
oBackPageText[22] = "";
oBackPageText[23] = "";
oBackPageText[24] = "";
oBackPageText[25] = "";
oBackPageText[26] = "";
oBackPageText[27] = "";
oBackPageText[28] = "";
oBackPageText[29] = "";
oBackPageText[30] = "";
oBackPageText[31] = "";
oBackPageText[32] = "";
oBackPageText[33] = "";
oBackPageText[34] = "";
oBackPageText[35] = "";
oBackPageText[36] = "";

var oBackPageURL = new Array();
oBackPageURL[0] = "dashboard.jsp"; // back to Admin home page
oBackPageURL[1] = "";  // 
oBackPageURL[2] = "";
oBackPageURL[3] = "supervisorGrid.jsp";
oBackPageURL[4] = "";
oBackPageURL[5] = "";
oBackPageURL[6] = "";
//oBackPageURL[7] = "supervisorShowUserProfile.jsp";
oBackPageURL[7] = "supervisorGrid.jsp";
oBackPageURL[8] = "docMgmtSearchGrid.jsp";
oBackPageURL[9] = "docMgmtSearchGrid.jsp";
oBackPageURL[10] = "HISTORYBACK";
oBackPageURL[11] = "HISTORYBACK";
oBackPageURL[12] = "";
oBackPageURL[13] = "";
oBackPageURL[14] = "";
oBackPageURL[15] = "";
oBackPageURL[16] = "";
oBackPageURL[17] = "addRequiredDocs.jsp";
oBackPageURL[18] = "";
oBackPageURL[19] = "";
oBackPageURL[20] = "";
oBackPageURL[21] = "";
oBackPageURL[22] = "";
oBackPageURL[23] = "";
oBackPageURL[24] = "";
oBackPageURL[25] = "";
oBackPageURL[26] = "";
oBackPageURL[27] = "";
oBackPageURL[28] = "";
oBackPageURL[29] = "";
oBackPageURL[30] = "";
oBackPageURL[31] = "";
oBackPageURL[32] = "";
oBackPageURL[33] = "";
oBackPageURL[34] = "";
oBackPageURL[35] = "";
oBackPageURL[36] = "";

<%-- var userRole = "<%=strRole%>"; --%>
// if(userRole == "ADMIN" || userRole == "POWERUSER")
// {
// 	oBackPageURL[1] = "docMgmtSearchGrid.jsp";
// }

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
				sURL += " |  <span  style='font-size:0.7em;'>Back to</span> <a href='javascript:locationClick(\"" + oBackPageURL[i] + "\")'>" + oBackPageText[i] + "</a>";	
		}
	
	}
	//alert("sURL "+sURL);
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
		sURL += " | <span  style='font-size:0.7em;'>Back to</span> <a href='javascript:locationClicks(\"" + backurl + "\")'>" + backtext + "</a>";	
		
	oDisplayID.innerHTML = sURL;

}


function setHeader(text)
{
	InitializeTimer();

	storeURLs();
	setHeaderURL(text);
	
}

var secs
var timerID = null
var timerRunning = false
var delay = 1000;
var sessionsec;

function InitializeTimer()
{
    // Set the length of the timer, in seconds
    if(!sessionsec|| sessionsec==0){
    secs = 10*60;
    StopTheClock()
    StartTimer()
}
}

function StartTimer()
{
	//console.log( secs)
    if (secs==0)
    {
    	sessionsec = 5*60;
        StopTheClock();
        StartTheTimer();
    }
    else
    {
        //self.status = secs;
        secs = secs - 1;
        timerRunning = true;
        
        timerID = self.setTimeout("StartTimer()", delay)
    }
}

function cancelCloseWindow()
{
	$('#myModal').modal('hide');
	//window.close();
	window.location = "logout.jsp?timeout=yes";

}
function closeWindow(){
	StopTheClock();
	$('#myModal').modal('hide');
	//window.close();
	
	if(sessionsec == 0)
	{
		window.location = "logout.jsp?timeout=yes";
	}
	else
	{
		
		sessionsec=0;
		InitializeTimer();
		
	}

}

function StopTheClock()
{
    if(timerRunning)
        clearTimeout(timerID);
    timerRunning = false;
}



function StartTheTimer()
{
    
if (sessionsec==0)
{
   closeWindow(); 
    
}
else
{
    //self.status = secs;
    
    sessionsec = sessionsec - 1;
    $('#myModal').modal('show');
    timerRunning = true;
    var timer = sessionsec, minutes, seconds;
    minutes = parseInt(timer / 60, 10);
    seconds = parseInt(timer % 60, 10);

    minutes = minutes < 10 ? "0" + minutes : minutes;
    seconds = seconds < 10 ? "0" + seconds : seconds;

    var disecs = minutes + ":" + seconds;

    if (--timer < 0) {
        timer = sessionsec;
    }
    
    var divObj = document.getElementById("timeoutMsg");
    divObj.innerHTML = "If you would like to remain in your Session, Please, choose 'Continue Session'. Otherwise, you will be logged off due to inactivity in <b>"+disecs+"</b>.";
    
    
    timerID = self.setTimeout("StartTheTimer()", delay)
}
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


function myProfileCancel(){
<%-- 	<% if(strRole != null && (strRole.compareTo("ADMIN") == 0 || strRole.compareTo("POWERUSER")==0)) { %>	 --%>
// 	   location.href = "dashboard.jsp";
<%-- 	<% }  --%>
// 	  else
// 	  {
<%-- 	 %> --%>
// 		location.href = "search.jsp";
<%-- 	<% } %>	 --%>

}
var number =  sessionStorage.getItem("notificationCount"); 
</script>


<decorator:head />
<jsp:include page="../connectors/sideMenu.jsp" />

</head>

<body onLoad="<decorator:getProperty property="body.onLoad"/> ">



	<center>

		<!-- Header for this design will go here -->
		<div class="headPageContainer">
			<div id="ghUtilBar" class="">
				<div id="ghMainUtil">
					<div id="ghClientSegment"></div>
				</div>
			</div>

			<table width="1100" height="44" border="0" cellpadding="0"
				cellspacing="0">
				<!--DWLayoutTable-->
				<tr>
					<td style="padding-left: 10px;"><img
						src="css/images/fhalogo.png "
						alt='TransAccess Imaging - Document Viewer.' width="156"
						height="80" style="margin-left: -25px" /></td>
					<td rowspan="3" style="width: 100%; color: #0A68B4">
						<div id="companyName"
							style="font-size: 18px; font-family: roboto; text-transform: capitalize; text-align: right;">
							<%-- <%=companyFullName %>  Records Management System --%>
							<span Style="margin-right: 20px;">RMS HelpDesk</span>
							<div style="font-size: 13px; margin-left: 47%;"
								class="text-center;text-align:right;">Powered by
								TransAccess (PSL)</div>
						</div> <%--  <div id="emptyCompanyName" style="font-size:35px;font-family: roboto;text-transform: capitalize;"> 
			<%=companyFullName %>  Document Management System
			<div style="font-size:13px;margin-left: 47%;" class="text-center">Powered by TransAccess (PSL)</div>
			 </div>  --%> <!--  <h4  style="color:red ;margin-left: 34%;">Training Site </h4>  -->
					</td>
					<td width="500" style="padding-right: 10px" valign="bottom"><div
							align="right">
							<!-- 			 <img src="images/imaging2.jpg" alt="Imaging" width="133" height="53">
 -->
						</div></td>
				</tr>
				<!-- <tr>
			<td width="500" style="padding-left: 10px"><img src="css/images/home.PNG" 
			style="" alt='TransAccess Imaging - Document Viewer.'  /></td>
			<td width="500" style="padding-right: 10px" valign="bottom"><div align="right">
			<div align="right">
			 <img src="images/imaging2.jpg" width="133" height="53">
			</div>
			</div></td>
		  </tr> -->
			</table>



		</div>

		<div class="mainBlueHeading">


			<ul tabindex="1" style="overflow: hidden;"
				class="tab-nav tab-nav-right main">

				<!-- <li class="waves-effect homeactive">			  	
			  	<a href="javascript:onClickLink(3)" >Home</a></li> -->

				<li class="waves-effect homeactive"><a
					href="javascript:onClickLink(3)"
					style="padding: 14px 40px 10px 10px;"> <span>Home</span></a><span
					class="badge" id="count"
					style="background: red; position: absolute; padding: 4px 4px; border-radius: 50%; background: red; color: white; opacity: 2; margin-left: -25px;"></span>
				</li>


				<li id="adminactive" class="waves-effect"><a
					href="javascript:onClickLink(2)"
					style="padding: 14px 20px 10px 10px;">ADMIN</a></li>




				<li class="waves-effect profileactive"><a
					href="javascript:onClickLink(0)"
					style="padding: 14px 20px 10px 10px;">My Profile</a></li>


				<li class="waves-effect"><a href="logout.jsp"
					style="padding: 14px 20px 10px 10px;">Logout</a></li>

				<li disabled="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			</ul>



		</div>



		<div class="userInformaiton">

			<table width="1100px" border="0" cellpadding="0" cellspacing="0">
				<!--DWLayoutTable-->
				<tr>
					<td width="80%">
						<div id="usernameId" class="userInformationText"></div>
					</td>
					<td width="10%" align="right">

						<div ID="applicationid" class="userInformationText"></div>

					</td>
				</tr>
			</table>




		</div>


		<!-- Main Content for this design will go here -->
		<div class="applicationMainContentAreaContainer">


			<div class="workingAreaBlueHeading">
				<div align="center">
					<div id="headertext"></div>
				</div>
			</div>


			<div class="workingArea">



				<decorator:body />

			</div>
		</div>


		<!-- Footer for this design will go here 
	<div class="applicationFooterContainer"> 
		<div class="applicationFooterContainerPadding">
  			
		</div>
	</div>-->


	</center>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="border-radius: 30px;">
				<div class="modal-header"
					style="border-bottom: 0 !important; padding: 0 !important">
					<h1 class="modal-title"
						style="font-size: 26px; text-align: center;" id="myModal">
						<b>Session Timeout</b>
					</h1>

				</div>
				<div class="modal-body">
					<div>
						<div align="left"
							style="float: left; margin-top: -6px; margin-right: 20px;">
							<img alt="" src="images/Alert1.png" style="height: 70px;">
						</div>
						<div align="right">

							<div id="timeoutMsg"
								style="font-size: 13px; font-family: Geneva, Arial, Helvetica, sans-serif; text-align: left;"></div>
						</div>
					</div>
				</div>
				<div class="modal-footer" style="border-top: 0 !important">
					<input type="image" style="width: 100px; height: 37px;"
						src="images/AttButtNo2.png" value="CANCEL"
						onClick="javascript:cancelCloseWindow();" /> <input type="image"
						style="width: 150px; height: 37px;" src="images/AttButtYes2.png"
						value="OK" onClick="javascript:closeWindow();" />
				</div>
			</div>
		</div>
	</div>

</body>
</html>