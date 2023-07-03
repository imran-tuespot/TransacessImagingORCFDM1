<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery-1.2.2.pack.js"></script>
		<script type="text/javascript" src="js/jquery.bgiframe.pack.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type='text/javascript' src='js/jquery.bgiframe.min.js'></script>
		<title>TransAccess Imaging</title>
		
		<style type="text/css">

		p {
		margin:10px 10px 10px 10px;
		font-family:Arial, Helvetica, sans-serif;
		color:#fff;
		font-size:12px;

		}
		
		.totalCount{
		
		margin:10px 10px 10px 10px;
		font-family:Arial, Helvetica, sans-serif;
		color:#000000;
		font-size:12px;
		
		}


</style>

		
</head>






<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>


<jsp:include page="includes/sessionHeader.jsp" />


<% 
   
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = (String)request.getSession().getAttribute("sessionid");
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  
  String docid = request.getParameter("docid");
  
  System.out.println("docid -->"+docid);

%>


<body onLoad="initial_load()">


<fieldset class="gfieldset">
<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>

<table align="center">

<tr>
<td>
<div id ="totalCount" class="totalCount">
</div>
</td>
</tr>

<tr >
<td>


<fieldset class="fieldset1">

<table width= "843" height="700" align="center" border=0>


<tr valign="top" align="center">
<td valign="top" align="left">

<div class=messagewindow id=messagewindow
	style="DISPLAY: none; MARGIN: 0px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 60%; z-index: 4; text-align: center;">
	<!-- Start - put your content here --->
	<h4>
		Retrieving data.. Please wait.
	</h4>
	<IMG src="images/progress.gif" width="32" height="32" alt="" />
	<!-- End   - put your content here --->
</div>

<div id = "results">
</div>

</td>
</tr>

</table>

</fieldset>

</td>
</tr>

<tr>
<td >
</td>
</tr>

</table>

<script type="text/javascript">

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

var xmlhttp1 = new getXMLObject1();       //xmlhttp holds the ajax object
function getXMLObject1()  //XML OBJECT
{
   var xmlHttp1 = false;
   try {
     xmlHttp1 = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp1 = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp1 = false   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp1 && typeof XMLHttpRequest != 'undefined') {
     xmlHttp1 = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp1;  // Mandatory Statement returning the ajax object created
}

function initial_load() {
	getfiles();
}


function getfiles() {
	// msgbox_visible(true);
	var compid = '<%= cid %>';
	var sessionid = '<%= sessionid %>';
	var userName = '<%= userName %>';
	var docid = '<%= docid %>';	
	var queryString = "docid="+docid+"&sessionid="+sessionid; 	
	if(xmlhttp) {
	    xmlhttp.open("POST","GetVersions",true); 
	    xmlhttp.onreadystatechange  = handleResponse;
	    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlhttp.send(queryString);
	} 
 
} 

function handleResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
        if (xmlhttp.responseText == "expired") { 
        msgbox_visible(false);	
        window.location = "index.jsp";
        } else {
     	DisplayData(xmlhttp.responseText);
     	}
     }    
     else {
        alert(xmlhttp.status);
     }
   }
}

var opArray = new Array();
function DisplayData(data)
{
	var x = 0;
	var initTable = "";
	initTable +="<table align='left'><tr>";
	initTable +="<tr height='40'></tr>"; 
	opArray = data.split('^');
	for (var i=0; i<opArray.length-1; i++) {
	 // alert(opArray[i]);
	 // var ss = "'"+opArray[i]+"'";
	 // alert(ss);
	 var n = i+1;
	 if (x==4) {
	 initTable +="<tr height='40'></tr>"; 
	 initTable +="<tr>"; 
	 }
	 initTable +="<td width='40'></td>"; 
	 initTable +="<td width='160'><a href='javascript:getpdf(\""+opArray[i]+"\")'><img src='./images/logo_pdf.jpg' width='110' height='135'><br>Version "+n+"</a></td>"; 
	 initTable +="<td width='40'></td>"; 
	 x++;
	 if (x==4) {
	 initTable +="</tr><tr height='30'></tr>"; 
	 x = 0;
	 }
    }
	initTable +="</tr></table>";	
	// msgbox_visible(false);	
	var obj =  document.getElementById("results");
	obj.innerHTML = initTable;
	
}



function getpdf(id) {
	alert("in get pdf");
	// var interval = setInterval('msgbox_visible(true)',0000);
	
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
		
	var Text = "./DisplayPdf?id="+id+"&userid="+user+"&comid="+com+"&sessionid="+session+"&userName="+userName;
	window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
	
	var interval = setInterval('msgbox_visible(false)',2000);
}


</script>


</fieldset>

</body>

</html>
