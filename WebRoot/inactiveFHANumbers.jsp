<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />

<jsp:setProperty name="userInformation" property="*" />
<%@page import="java.util.*"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="js/jQuery/jquery-1.8.2.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	
         <link rel="stylesheet" href="css/jquery-ui.css">
		<!-- <script type="text/javascript" src="js/jquery-1.3.2.js" ></script>-->
		<!--  <script type="text/javascript" src="js/jQuery/jquery-1.7.1.js" ></script>-->		
		
		<script type="text/javascript" src="js/jquery.jmesa.js"></script>
		<script src="jscript/jquery-ui.js"></script>
		
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />			
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>
		
				
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script src="js/jquery.popupoverlay.js"></script>
		
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" /> 
		<link rel="stylesheet" type="text/css" href="css/search.css" /> 	
		
		
		<jsp:include page="includes/sessionHeader.jsp" />

		<title>TransAccess Imaging</title>
		<style type="text/css">
		
		div#expand{
		display:block;
		width:100%;
		}
		.example {
			float: left;
			
		}
		.folderStruct {
			width: 98%;
			height: 230px;
			border: solid 1px #BBB;
			background: #FFF;
			overflow: auto;
			padding: 5px;
		}
		#content{
		position:relative;
		}
				
		</style>
		
</head>

<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>




<% 
  
  Integer uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  Integer cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  
  String fhaNumbers = (String) request.getAttribute("fhaNumbers");
 
%>

<body onLoad="initial_load()" >
	<!-- Add content to the popup -->
  <div id="my_popup">

    <div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em; opacity: 1; visibility: visible; display: inline-block; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
    <h4><i class="zmdi_large zmdi-rotate-right zmdi-hc-spin"></i> Uploading File...Please Wait...</h4>
    <p style="margin-left:40px;margin-bottom: 0px">It will take few seconds.</p>
    <p style="margin-left:40px;margin-bottom: 0px">Please wait while the file is uploading.</p>
    
	</div>
	
  </div>
  
  <div id="my_popup1">
	<div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em; opacity: 1; visibility: visible; display: inline-block; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
    <h4><i class="zmdi_large zmdi-settings zmdi-hc-spin"></i> Loading Contents...Please Wait...</h4>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;It will take few seconds.</p>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;Please wait while the contents are loading.</p>
    
	</div>
	
  </div>
	
        
        <form id="upload" name="upload" method="post" action="InactiveFHANumbers" enctype="multipart/form-data">
        
               
	           
		<div>
			
					<div class="card-body card-padding" >    
						<div style="padding: 10px; height: auto;" align="center" width= "100%">
						
					
						<h4 class="tableHeader" style="padding-bottom: 10px;padding-top: 10px;"><i class="zmdi_large zmdi-cloud-upload"></i>Upload Document</h4>			
						<table align="center" width= "100%" >
								
							<tr valign="top">
								<td><p>Click the Browse button to select the .xls/.csv file from your local drive and then click Upload File button.
								</p></td>
							</tr>
							<tr height="5">
								<td></td>
							</tr>
							<tr valign=top>
								<td>
									<table style="width: 50%;"><tr>
										<td>
										<input type="hidden" id ="cid" name="cid" value="<%=cid%>"/>
										<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
										<input type="hidden" id ="confirmParam" name="confirmParam"/>
										<input type="hidden" id ="actualFileName" name="actualFileName"/>
									    <input type="hidden" id ="userName" name="<%=userName%>"/>
									    <input type="hidden" id ="fhaNumbers" name="fhaNumbers" value="<%=fhaNumbers%>"/>
									
									</td>
									<td>
										<input id="file" class="btn btn-success waves-effect waves-button waves-float" name="file" type="file" size="40" onchange="javascript:getFilePath();" onClick="javascript:enable();" style="display:inline">										
									&nbsp;&nbsp;
								
								 	<input id="attach" class="btn btn-primary waves-effect waves-button waves-float" name="attach" type="submit" onClick="return check1();" value="Upload New File" disabled="disabled">
								</td>
								</tr>
							
								</table>
								</td>
								</tr>
								
								<tr>
								<td>&nbsp;
								</td>
								</tr>
								
								<tr>
								<td align="center">
								<div id = "confirmMsg">
								<%
								 if(request.getAttribute("resultSize") != null){
								 	
								 	if((Integer)request.getAttribute("resultSize") > 0){
								   
										 if(request.getAttribute("htmlResult") != null){%>
										    <%if("Yes".equals((String)request.getAttribute("successMsg"))){%>
										    	<b>The loans were successfully set to Inactive</b>
										    <%} else { %>	
										    	<b>Are you sure you want to set the following loans to Inactive status?</b> &nbsp;<input id="confirmInactive" class="btn btn-success waves-effect waves-button waves-float" name="confirmInactive" type="button" onClick="inactiveAction();" value="Yes" >
								         		&nbsp;<input id="cancelInactive" class="btn btn-primary waves-effect waves-button waves-float" name="cancelInactive" type="button" onClick="enable();" value="No" >	
								         	 <%} %>
							         <%   }
							         } else {
							             if("Yes".equals((String)request.getAttribute("successMsg"))){ %>
							        	 	<b>The loans were successfully set to Inactive</b>
										 <%} else { %>
							         		<b>No Active Loans found for the uploaded file.</b>
						         <%		 }
						         	 }
						         } 
						          %>	
						         </div>
								</td>
								</tr>
								
								<tr>
								<td>
								<div id="results">
									<%if(request.getAttribute("htmlResult") != null){%>
						         		<%=request.getAttribute("htmlResult") %>
						         	<%} %>	
						
								</div>
								</td>
								</tr>
								
								</table>
								
								</div>
								
								
							</div>
					</div>
         
         </form>
        
        




<script language="javascript">
 var fView = "fView";





function initial_load()
	{
		// Initialize the plugin
        $('#my_popup').popup({color:'#000'});
        $('#my_popup1').popup({color:'#000'});
      	setHeader('inactiveFHANumbers.jsp');
      
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
      //	$('#docManagementLi').click();	 
      $('#docManagementLi').collapse('toggle');
      
		 var array_of_li =  document.querySelectorAll("ul.tab-nav li");
		for (var i = 0; i < array_of_li.length; i++) {
		if(i == 1)
			array_of_li[i].setAttribute("class", "active");	
			
		} 
		
		
	}

function enable() {
	document.getElementById("attach").disabled=false;
	document.getElementById("fhaNumbers").value = '';
	var objResults =  document.getElementById("results");
	objResults.innerHTML = '';
	
	var objMsg =  document.getElementById("confirmMsg");
	objMsg.innerHTML = '';

}


function inactiveAction(){

	$('#my_popup1').popup('show');
	document.getElementById("confirmInactive").disabled=true;
	document.getElementById("cancelInactive").disabled=true;
    document.getElementById("upload").submit();


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


function getfiles() {
	
	
	$('#my_popup').popup('show');
	//Make Submit button disabled
	document.getElementById('attach').disabled = true;
	
	
	var user = '<%= uid%>';
	var compid = '<%= cid %>';
	var sessionid = '<%= sessionid %>';
	var userName = '<%= userName %>';
	
	
	var queryString = "userid="+user+"&"+"compid="+compid+"&"+"sessionid="+sessionid+"&"+"userName="+userName+"&formId=formId";

	if(xmlhttp) { 
	    xmlhttp.open("POST","InactiveFHANumbers",true); 
	    xmlhttp.onreadystatechange  = handleResponse;
	    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlhttp.send(queryString);
	}
 
} 

function handleResponse() {
	
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     // alert(xmlhttp.responseText);
        if (xmlhttp.responseText == "expired") { 
        //msgbox_visible(false);	
        $('#my_popup').popup('show');
        
        //Make submit button enabled
        //document.getElementById('submit').disabled = false;
        
        // alert("Session Expired...Please Login Again.");
        window.location = "index.jsp";
        } else {
     		DisplayData(xmlhttp.responseText);
     	}
     }    
     else {
        //alert(xmlhttp.status);
     }
   }
}

function DisplayData(data)
{
	
	$('#my_popup').popup('hide');	
	document.getElementById('attach').disabled = false;
	
		
	var obj =  document.getElementById("results");
	obj.innerHTML = data;
}


function getFilePath()
{
 //alert("This file path"+ document.getElementById("file").value);
 var filePath = document.getElementById("file").value;
 if(filePath.lastIndexOf("\\") > -1)
 {
     filePath = filePath.substr(filePath.lastIndexOf("\\")+1,filePath.length-filePath.lastIndexOf("\\"));
     alert(filePath);
 }
 document.getElementById("actualFileName").value = filePath;
}

function check1() {
var x = document.getElementById("file").value.toLocaleLowerCase();

// alert(x);
// alert(x.lastIndexOf(".pdf")); 
if (x.lastIndexOf(".xls") != -1 || x.lastIndexOf(".csv") != -1   ) 
{
	$('#my_popup').popup('show');
    //getfiles();
    return true;
} else {
    alert("Please upload Excel file only");
   return false;
}

} 

function onCancel(){
	var sessionid='<%=sessionid%>';
	window.location="dashboard.jsp?sessionid="+sessionid;
}

function getpdf1(id) {

    var interval = setInterval('msgbox_visible(true)', 0000);

    var user = '<%= uid%>';
    var com = '<%= cid%>';
    var session = '<%= sessionid%>';
    var userName = '<%= userName%>';

    var Text = "./DisplayPdf?id=" + id + "&userid=" + user + "&comid=" + com + "&sessionid=" + session + "&userName=" + userName;
    window.open(Text, '', 'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');

    var interval = setInterval('msgbox_visible(false)', 2000);
}
 
</script>


</body>

</html>

