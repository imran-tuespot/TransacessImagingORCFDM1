<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="js/jQuery/1.11.3/jquery.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    					<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	
		<script type="text/javascript" src="js/jquery.jmesa.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		
		<script type="text/javascript" src="js/jquery.bgiframe.pack.js"></script>
		<script type='text/javascript' src='js/jquery.bgiframe.min.js'></script>
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script type="text/javascript" src="js/FHA.js"></script>

 <script src="js/bootstrap.min.js"></script>
		<title>TransAccess Imaging</title>

<style type="text/css">
.jmesa .highlight td {cursor: default}
</style>
		
</head>




<%-- <jsp:include page="includes/sessionHeader.jsp" /> --%>
<body onLoad="getUsers()">



<% 
   
 // int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
 // int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());

  String successMsg = "";
  successMsg = request.getParameter("successMsg");
  if("".equals(successMsg) || successMsg == null){
	successMsg = "";
  }

%> 


<script language="javascript">
var userinfo=JSON.parse(sessionStorage.getItem("roles"));
function onInvokeAction(id,action) {
	
	var compid = userinfo.company_ID;
	var fname = document.advancedSearch.fnameSearch.value;
	var lname = document.advancedSearch.lnameSearch.value;
    var parameterString = createParameterStringForLimit(id);
    console.log(parameterString)
  
    $.post("GetSupervisorGrid?companyId="+ compid + "&" +"firstName=" +fname+"&" +"lastName=" +lname+ "&" + parameterString, function(data) {
    	 	
        $("#results").html(data)
 
    },"html");
    
}
$(document).mousemove(function(event){
	  InitializeTimer();
});
function onInvokeExportAction(id,action) {
	
	var compid = userinfo.company_ID;
	var parameterString = createParameterStringForLimit(id);
    
    $.get("GetSupervisorGrid?companyId="+ compid + "&" + parameterString, 
    function(data) 
    {

        $("#results").html(data)
 
    });
    
}



</script>

<table>
<tr align="center">
			
	 <% if(successMsg.contains("Mobile Number is already")){ %>
	<td style='font-size:13px;padding: 10px;color: red' ><b><%=successMsg %></b></td>
	<% }else{ %>
	<td style='font-size:13px;padding: 10px;color: green' ><b><%=successMsg %></b></td>
	<%} %>
</tr>
</table>
<form name="advancedSearch">

<div class="card" style="width: 95%;margin-top: 23px; padding-left: 0px;">
			<div class="card-body card-padding" style="background-color: rgb(237, 236, 236);">
		<table align="center" style="width:100%;border-spacing: 10px;">
		
		<tr>
		  <td style="width: 15%">
		  
		    First Name:
		    </td>
		    <td>
		      <input type="text" size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" name="fnameSearch" />
		    </td>
	    </tr>
		 <tr>
		    <td>Last Name:</td>
		    <td>
		  <input type="text" size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" name="lnameSearch" />  
		  </td>
		</tr>
		  <tr>
		  <td></td>
		  	<td align="left">
		      <input type="button" id="searchByName" name="searchByName" style="margin-left: 160px;margin-right: 10px;margin-top: 10px;" value="Search" class="btn btn-success waves-effect waves-button waves-float" onClick="getAdvancedSearchUsers()" />
		 
		      <input type="button" name="registration" style="margin-top: 10px;" value="New Users" class="btn btn-warning waves-effect waves-button waves-float" onClick="location.href='registration.jsp'" >
		   	</td>
		  </tr> 
		  
		</table>
	</div>
		</div>	
</form>  
		
		
		
		<table align="center">
		<tr>
		  <td >
		  <div id="div_links"></div>
		  </td>
		</tr>
		</table>
		


<center>
	<form id="userGrid" name="userGrid" method="POST">
		<div id="results" style="padding: 0px 20px 20px;"></div>
	</form>	
</center>




<script type="text/javascript">

var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object
var xmlhttp1 = new getXMLObject();       //xmlhttp holds the ajax object
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

function getUsers() {
	getHeaderusername();
	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(i == 1)
		array_of_li[i].setAttribute("class", "active");	
		
	}

$.jmesa.addTableFacade('formId');
			$.jmesa.setMaxRowsToLimit('formId','12');
			$.jmesa.setPageToLimit('formId','1');
			$.jmesa.setOnInvokeAction('formId','onInvokeAction');
			$.jmesa.setOnInvokeExportAction('formId','onInvokeExportAction');
			
setHeader("supervisorGrid.jsp");
		//Initialize slider menu
      //	$('#simple-menu').sidr();
      
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
/* 	  $('#userManagementLi').collapse('toggle');
 */
getUserLinks();

var compid = userinfo.company_ID;

if(xmlhttp) { 

    xmlhttp.open("POST","GetSupervisorGrid",true); 
    xmlhttp.onreadystatechange  = handleResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("companyId=" + compid);
  } 
} 

function getUserLinks() {
if(xmlhttp1) { 

    xmlhttp1.open("POST","GetSupervisorGridLinks",true); 
    xmlhttp1.onreadystatechange  = handleLinkResponse;
    xmlhttp1.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp1.send(null);
  } 
} 

function handleLinkResponse() {

	//alert(xmlhttp1.status);
	
   if (xmlhttp1.readyState == 4 && xmlhttp1.status == 200) {
   		//alert(xmlhttp1.responseText);
		document.getElementById("div_links").innerHTML = xmlhttp1.responseText;
     }    
}


function getAdvancedSearchUsers() {

var compid = userinfo.company_ID;
var fname = document.advancedSearch.fnameSearch.value;
var lname = document.advancedSearch.lnameSearch.value;
document.getElementById("searchByName").disabled = true;

	if(fname == "" && lname == "")
	{
		alert("Please fill in either a FIRST NAME or a LAST NAME!");
		document.getElementById("searchByName").disabled = false;
	}
	else
	{
		if(xmlhttp) 
		{ 
		    xmlhttp.open("POST","GetSupervisorGrid",true); 
		    xmlhttp.onreadystatechange  = handleResponse;
		    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xmlhttp.send("companyId=" + compid + "&firstName=" + fname + "&lastName=" + lname);
	 	} 
	}
} 


function getAlphabetSearchUsers(lname) {

var compid = userinfo.company_ID;
var fname = '';
document.advancedSearch.fnameSearch.value= '';
document.advancedSearch.lnameSearch.value = lname;

	if(xmlhttp) 
	{ 
		xmlhttp.open("POST","GetSupervisorGrid",true); 
		xmlhttp.onreadystatechange  = handleResponse;
		xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xmlhttp.send("companyId=" + compid + "&firstName=" + fname + "&lastName=" + lname);
	} 
} 

function setSortValue(sortName,sortValue)
{
		var expires = new Date();
		expires.setMonth(expires.getMonth() + 4);
		setCookie(sortName,sortValue, new Date(expires), '/', '', '');
}

function getSoryValue(property)
{
	var sortValue = getCookie("SORT_"+property);
	if(sortValue == null || sortValue == "0")
	{
		setSortValue("SORT_"+property,1);
		return 0;
	}
	else
	{
		setSortValue("SORT_"+property,0);
		return 1;
	}
}

function sortby(property)
{
	property = " LOWER(" + property + ")";
	var compid = userinfo.company_ID;
	var fname = document.advancedSearch.fnameSearch.value;
	var lname = document.advancedSearch.lnameSearch.value;
	var sVal = getSoryValue(property);
	if(sVal == 0)
		property += " ASC";
	else
		property += " DESC";
		
	var order = property;
	var sFilter = "companyId=" + compid + "&firstName=" + fname + "&lastName=" + lname + "&orderby=" + order ;
	//alert(sFilter);
	
	if(xmlhttp) 
	{ 
		xmlhttp.open("POST","GetSupervisorGrid",true); 
		xmlhttp.onreadystatechange  = handleResponse;
		xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xmlhttp.send(sFilter);
	} 

  // alert(property);

}

function handleResponse() {
   if (xmlhttp.readyState == 4) {
   	 document.getElementById("searchByName").disabled = false;   
     if(xmlhttp.status == 200) {
     	DisplayData(xmlhttp.responseText);
     }    
     else {
        //alert(xmlhttp.status);
     }
   }
}



function editUserProfile(userId,userRoleValue)
{
	//alert("userRoleValue:"+userRoleValue);
	//console.log("userRoleValue"+userRoleValue);
	debugger;
	console.log("Check Url:;supervisorEditUserProfile.jsp?guestUserId=" + userId +"&userRoleValue="+userRoleValue);
	location.href="supervisorEditUserProfile.jsp?guestUserId=" + userId +"&userRoleValue="+userRoleValue;
}

function showUserProfile(userId)
{
	location.href="supervisorShowUserProfile.jsp?guestUserId=" + userId;
}

function DisplayData(data)
{
	var initTable = "";
	
		
	var obj =  document.getElementById("results");
	obj.innerHTML = data;
	

}

</script>

<%-- <%}else{
	response.sendRedirect("index.jsp");
}

}catch(Exception ie){
response.sendRedirect("index.jsp");
}
%> --%>

</body>

</html>