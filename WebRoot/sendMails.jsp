<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<%@page import ="com.peniel.beans.CheckUsername"%>
<%@page import="java.util.*"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<link rel="stylesheet" href="css/ui.all.css" type="text/css" media="screen" /> 
		<link rel="stylesheet" href="css/jquery.wysiwyg.css" type="text/css" media="screen" /> 
		<link rel="stylesheet" type="text/css" href="css/jquery.cleditor.css" />
		
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script> 
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="js/jquery-1.5.js"></script>
		<script type="text/javascript" src="js/jquery.wysiwyg.js"></script>
		<script type="text/javascript" src="js/jquery.cleditor.min.js"></script>
		<script type="text/javascript" src="js/jquery.elastic.source.js"></script>
		<script type="text/javascript" src="js/elastic-textarea.js"></script>
		
		<title>Send E-mails</title>
	<style type="text/css">
	html, body 
	{ 
	    height:100% 
	} 
 		
	#maskdiv {  
	    position:absolute; 
	    z-index:10; 
	    width:100%; 
	    height:100%; 
	    top:0; 
	    left:0; 
	    background-color:#9999FF; 
	    filter:alpha(opacity=10); 
	    -moz-opacity:0.1; 
	    opacity:0.1; 
	    cursor:pointer; 
	 
	}  
	 
	.dialog { 
	    position:absolute; 
	    border:2px solid #3366CC; 
	    width:600px; 
	    height:600px; 
	    background-color:#ffffff; 
	    z-index:12; 
	} 
 
</style>
	
		
<script language="javascript">
$(document).ready(function() { init(); }); 
var multipleRecipents; 
function init() { 
     $('#maskdiv').click(function() { closeDialog(); }); 
     $('#mailto').elastic();
     $('#mailcc').elastic();
     $('#mailbcc').elastic();
     $('#input').wysiwyg();
     $('#mailbody').cleditor();  
} 

function openDialog(element,recipentType) { 
  
    $('#maskdiv').css('height', $(document.body).height() + 'px'); 
    $('#maskdiv').show(); 
    $('#dialog').html($(element).html()); 
    centerMe('#dialog'); 
    $('#dialog').show(); 
    multipleRecipents = recipentType;
} 
 
function closeDialog() { 
    $('#maskdiv').hide(); 
    $('#dialog').hide(); 
    $('#dialog').html('');
} 
 
function centerMe(element) { 
    var pWidth = $(window).width(); 
    var pTop = $(window).scrollTop(); 
    var eWidth = $(element).width(); 
    var height = $(element).height(); 
    $(element).css('top', '130px');
    $(element).css('left', parseInt((pWidth / 2) - (eWidth / 2)) + 'px');
} 
	
function initial_load() 
{		
	setHeader('sendMails.jsp');
}	

function toggleBCC()
{
	if(document.getElementById("mailbcc").style.display == "none")
	{
		document.getElementById("mailbcc").style.display="block";
		document.getElementById("btnBccPlus").style.display="block";
		document.getElementById("divBcc").style.display="block";
		document.getElementById("btnHideBcc").style.display="block";
		document.getElementById("btnAddBcc").style.display="none";
		
	}else
	{
		document.getElementById("mailbcc").style.display="none";
		document.getElementById("btnBccPlus").style.display="none";
		document.getElementById("divBcc").style.display="none";
		document.getElementById("btnHideBcc").style.display="none";
		document.getElementById("btnAddBcc").style.display="block";
	}
}

function getSelectedContacts(tableID) 
{
      try 
      {           
       var table = document.getElementById(tableID);
       var mytablebody = table.getElementsByTagName("tbody")[0];
       var rowCount = mytablebody.rows.length;
       var emails="";
		
       for(var i=0; i<rowCount; i++) 
       {
         	var myrow = mytablebody.getElementsByTagName("tr")[i];
			var mycel = myrow.getElementsByTagName("td")[0];
            var chkbox = mycel.getElementsByTagName("input")[0];
            
            if(null != chkbox && true == chkbox.checked) 
            {           	   
               emails += document.getElementById('email'+(i+1)).innerHTML+";";
        	}        	
      }
     
      if(multipleRecipents === 'TO' && emails != "" )
       	document.getElementById('mailto').value = alltrim(emails);
      else if(multipleRecipents === 'CC' && emails != "")
       	document.getElementById('mailcc').value = alltrim(emails);
      else if(multipleRecipents === 'BCC' && emails != "")
       	document.getElementById('mailbcc').value = alltrim(emails);
      	
      closeDialog();
      }catch(e) 
      {
          alert("exception in get selected emails"+e);
      }
 }
	
function selectAllContacts(tableID)
{
	try 
      {           
       var table = document.getElementById(tableID);
       var mytablebody = table.getElementsByTagName("tbody")[0];
       var rowCount = mytablebody.rows.length;
       if(document.getElementById('chkSelectAll').checked == true)
       {
	       for(var i=0; i<rowCount; i++) 
	       {
	         	var myrow = mytablebody.getElementsByTagName("tr")[i];
				var mycel = myrow.getElementsByTagName("td")[0];
	            var chkbox = mycel.getElementsByTagName("input")[0];
	            chkbox.checked = true;	                  	
	       }
      }
      else
      {
	      	for(var i=0; i<rowCount; i++) 
		    {
	         	var myrow = mytablebody.getElementsByTagName("tr")[i];
				var mycel = myrow.getElementsByTagName("td")[0];
	            var chkbox = mycel.getElementsByTagName("input")[0];
	            chkbox.checked = false;	                  	
		    }
      }
      }catch(e) 
      {
          alert("exception in select all emails"+e);
      }
}	
function sz(t) 
{
	a = t.value.split('\n');
	b=1;
	for (x=0;x < a.length; x++) { if (a[x].length >= t.cols) b+= Math.floor(a[x].length/t.cols);
	}
	b+= a.length;
	if (b > t.rows) t.rows = b;
}

function alltrim(str) 
{
    return str.replace(/^\s+|\s+$/g, '');
}

function validate()
{
    
	var mailto = document.getElementById('mailto').value;
	var subject = document.getElementById('mailsubject').value;
	var message = document.getElementById('mailbody').value;
	
	if(mailto == "")
	{
		alert("Please specify at least one recipent in the :To field");
		return false;
	}
	if(subject == "")
	{
		alert("The email doesn't have subject");
		return false;
	}
	
	if(message == "")
	{
		alert("The email doesn't have message");
		return false;
	}
	
	return true;
	
}
	
</script>
		
</head>


<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>

<jsp:include page="includes/sessionHeader.jsp" />

<% 
  
  String success = request.getParameter("success");
  if (success != null && success.equalsIgnoreCase("yes")) {
  	success = "<font color=green><b>Message sent successfully.</b></font>";
  } else if (success != null && success.equalsIgnoreCase("no")) {
  	success = "<font color=red><b>Error while sending message.</b></font>";
  } else {
  success = "";
  }
    
 String sessId = request.getParameter("sessionid");
 String cid = request.getSession().getAttribute("comid").toString();
 String htmlGrid = CheckUsername.getEmails(cid);
 
%>
<body onLoad="initial_load()">

<FORM action="SendmailWithCC_BCC" method=post name="frmSendMails">
	<table>
	<tr><td >
	<%=success%>
	</td></tr>
	</table>
   <table align="center" style="font-family: sans-serif;font-size: 11" width= "100%" >
    <TBODY>
    <tr>
    <th></th>
    <th></th>
    <th></th>
    <th></th>    
    </tr>
    
    <TR>
      <TD align="right"  width="14%">TO:</td>
      <td width="20%"><textarea id="mailto" name="mailto" style="width:505px;height:22px; resize: none;" ></textarea></TD>
      <TD width="4%"><INPUT type= "button" id="btnToPlus" value="+" onClick="openDialog($('#contentB'),'TO')"></TD></TR>
    <TR>
      <TD align="right">CC:</td>
      <td><textarea id="mailcc" name="mailcc" style="width:505px;height:22px;resize: none;"></textarea></td>
      <TD><INPUT type= "button" id="btnCcPlus" value="+" onClick="openDialog($('#contentB'),'CC')" ></td>
      <td> <INPUT type= "button" id="btnAddBcc"  value="Add BCC" onClick="javascript:toggleBCC()"></TD></TR>
      
    <TR>
      <TD align="right"><div id ="divBcc" style = "display:none">BCC:</DIV></td>
      <td><textarea id="mailbcc" name="mailbcc"  style="width:505px;height:22px;Display:none;resize: none" > </textarea></TD>
      <td> <INPUT type= "button" id="btnBccPlus" value="+" style="Display:none" onClick="openDialog($('#contentB'),'BCC')"></td>
      <td><INPUT type= "button" id="btnHideBcc" value="Hide BCC" onClick="javascript:toggleBCC()" style="Display:none"></TD>
     </TR>
    
    <TR>
      <TD align="right">SUBJECT:</TD>
      <td colspan="3"><input id="mailsubject" name="mailsubject" size="82"></td>
    </TR>
    <TR>
    <tr></tr>
    <TR>
      <TD align="right">PRIORITY:</TD>
      <TD colspan="3"><SELECT name=mailpriority> 
            <OPTION value=1>Highest</OPTION>
            <OPTION value=2>High</OPTION> 
            <OPTION selected value=3>Normal</OPTION>
            <OPTION value=4>Low</OPTION> 
            <OPTION value=5>Lowest</OPTION>
          </SELECT>
      </TD>
      </TR>
      <tr></tr>
      <tr>
      <TD align="right"></TD>
      <TD colspan="3"><TEXTAREA id="mailbody" name="mailbody" style="width:650px;height:200px;resize: none" ></TEXTAREA>
       <!--  <textarea id="input" name="input"></textarea> -->
      </TR>
    <TR>
    <td></td>
      <TD colspan="2">
        <input type="hidden" name="sessionid" value="<%=(String)request.getSession().getAttribute("sessionid") %>" />
        <div class="blueHeaderNoRoundText" align="center"><INPUT name="Submit" type="submit" value="Send" onclick="return validate()"></DIV>
    </TD>
    </TR>
   </TBODY>
   </TABLE>
  </FORM>
 
<DIV id="dialog" class="dialog" STYLE="overflow-y: scroll; width:450; height:400; 
border:1 #000000 solid; text-align: center;  padding: 2px; display:none">
</div>


<div id="maskdiv" style="display:none"></div> 

<div id="contentB" style="display:none; border:5px solid gray; padding: 2px"> 
	
	<table width= "100%">
	<thead><tr height="25px" class="blueHeaderNoRound">
    <th>Choose Contacts</th>
 	</tr></thead> 
 	<tr><td>
 	<div>
	<input type="checkbox"  name="Select All" value="Select All" id="chkSelectAll"  onClick="javascript:selectAllContacts('dataTable');"/><h4>Select All</h4>
    </div>
  	</td>
 	</table>
 		
    <TABLE align="center" width= "100%" border="1" id="dataTable">
    <tbody>
    	<%= htmlGrid %> 
    </tbody> 	
	</TABLE>
	
	<table width= "100%">
	 <tr> 	
	 	<td width="100%" align="right">
	  		<input type="button" value="OK" align="right" onClick="javascript:getSelectedContacts('dataTable');"/>
	    </td>
	 </tr>
	</table>

</div> 

</body>
</html>
