<%@page import="com.peniel.beans.getDropD"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<jsp:useBean id="batchInformation" scope="request" class="com.peniel.beans.BatchInformation" />
<jsp:setProperty name="batchInformation" property="*" />
<%@page import="java.util.*"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<title>TransAccess Imaging</title>	
		
</head>

<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>

<jsp:include page="includes/sessionHeader.jsp" />

<% 
  System.out.println("*** addBatchResult.jsp ***");
  String success = 	request.getParameter("success");
  String successAfterInsert = 	request.getParameter("successAfterInsert");
  System.out.println("success after uploading file ---> "+success);
  System.out.println("success after inserting record in DB ---> "+successAfterInsert);
  
  if (success.equalsIgnoreCase("yes") || successAfterInsert.equalsIgnoreCase("yes")) 
  {
  	success = "<font color=green>Batch has been saved successfully.<br>Please allow one hour time for the process to finish.</font>";
  } 
  else if (success.equalsIgnoreCase("error")|| successAfterInsert.equalsIgnoreCase("no")) 
  {
  	success = "<font color=red><b>Error while adding batch. Please contact system administrator.</b></font>";
  } else 
  {
  	success = "";
  }
  System.out.println("success after adding document --->"+success); 
 
 

  String fileName = request.getParameter("id").toString();	
  //System.out.println("fileName -->"+fileName);
  
  
   
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  String cId = request.getSession().getAttribute("comid").toString();
  
  String lastName = "";
  String firstName = "";
  
  com.peniel.dao.CompanyDAO companyDao = new com.peniel.dao.CompanyDAO();
  Vector companyList = new Vector();
  com.peniel.bus.vo.Company company = new com.peniel.bus.vo.Company();
			
  companyList = companyDao.findById(cId);
  company = (com.peniel.bus.vo.Company) companyList.get(0);
  String companyName = company.getCompanyName();
  //System.out.println ("******Company Name**** "+companyName);
  
  java.util.Date today = new java.util.Date();
  java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
  //System.out.println ("In do post "+timestamp);
  
  javax.naming.Context ctx = new javax.naming.InitialContext();
  String webFolder = (String) ctx.lookup("java:comp/env/batchfolder");
  
  String strContextPath = request.getContextPath();
  // String filePath = strContextPath + "/scaimages/"+companyName+"/web/" + fileName;
  String filePath = companyName+"/"+webFolder+"/"+ fileName;
  
  HashMap hashMap = userInformation.getUserInformation(request);
  //System.out.println( "hashMap = " + hashMap );
  
  lastName = (String) hashMap.get("lastName");
  if(lastName== null) lastName="";
  firstName = (String) hashMap.get("firstName"); 
  if(firstName== null) firstName="";  
  
  HashMap batchHashMap1 = new HashMap();
   batchHashMap1.clear();
   System.out.println("batchHashMap size in jsp"+batchHashMap1.size());
   batchHashMap1 = batchInformation.getUserBatchInformation(request.getAttribute("userid").toString(),
   														   request.getAttribute("comid").toString());
   System.out.println("batchHashMap size in jsp"+batchHashMap1.size());
  
   String description =  "";
  
%>

<body onLoad="initial_load()" >

<table>
<tr>
<td style='padding: 10px;'>
<%=success%>
</td>
</tr>
</table>

<form name="upload" method="post" action="AddBatch" enctype="multipart/form-data">
  
  <div class="blueHeaderNoRound">
  	<div class="blueHeaderNoRoundText">Key Document Information:</div>
	
</div>
  
  
  <table align="center" width= "100%" border="0">
<tr valign=top>

<td width=43% rowspan="2" >
<div id="divDocStatus"  style="padding:10px 10px 10px 10px">
<h4 style='padding:0px 0px 8px 0px'>Upload Type</h4>

  
  <select style='font-size:11px;font-family: Verdana;' name="uploadtype" id="uploadtype" >
    <option value="">Batch Scan</option>
  </select>
    
  <p><strong>Upload Status &nbsp;&nbsp;&nbsp;&nbsp;</strong> Pending </p>
</div></td>


</tr>
<tr valign=top>
  <td  valign="top">
  
  <div id="defaultProfile">
<table width="476" cellpadding="5px" cellspacing="0">
<tr valign="top">
<td width="225" >
	<h4>Upload Date</h4></td>
<td width="239" >
	<h4>Description</h4></td>
</tr>
	
<tr>
<td ><input id="uploadDate" name="uploadDate" type="text" value=<%= timestamp%> readonly/></td>
<td >
	<input id="value" name="value" type="text"></td>
</tr>
<tr>
<td width="239"><h4>Batch File Name</h4></td>
<td ><label for="Batch File Name" style='font-size:12px;font-family: Verdana;color:green;'><%= fileName%></label></td>
</tr>


</table>
</div>
  
  
  
  </td>
</tr>
</table>

<div class="blueHeaderNoRound">
	<div class="blueHeaderNoRoundText">Upload Batch:</div>
</div>

<table align="center" width= "100%" >
<tr valign="top"><td><p>To add a batch file, click the Add Batch button after selecting the zip file.
</p><p style="color:red">Note: The zip file should not contain subfolders. It should contain scanned files and index file only.
</p>
</td></tr>
<tr height="5"></tr>
<tr valign=top>
<td><table><tr>
<td>&nbsp;&nbsp;<input type="hidden" id ="cid" name="cid" value="<%=cid%>"/>
<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
<input type="hidden" id ="confirmParam" name="confirmParam"/>
</td>
<td>
&nbsp;&nbsp;<input id="file" name="file" type="file" size="40" onClick="javascript:enable();">&nbsp;&nbsp;&nbsp;&nbsp;
 <input id="attach" name="attach" type="submit" onClick="return check1();" value="Add New Batch" disabled="disabled">
</td>
</tr></table></td>
</tr>

</table>
</form>
<br>

<div class="blueHeaderNoRound">
	<div class="blueHeaderNoRoundText">Audit Trail:</div>
</div>

<table align="center" width= "100%" >

<tr>
<td></td>
<td ><h4>Last Name</h4></td>
<td ><h4>First Name</h4></td>
<td ><h4>Upload Date</h4></td>
<td ><h4>Process Date</h4></td>
<td ><h4>Status</h4></td>
<td ><h4>File</h4></td>
</tr>
<% 
if(batchHashMap1.size()>0)	
 {	
   	System.out.println("batchHashMap.size()----> "+batchHashMap1.size());
   	int mapSize = batchHashMap1.size()/4;
for(int i=0; i < mapSize; i++ )
{

   
%>
<tr>
<td></td>
<td ><p><%= lastName %></p></td>
<td ><p><%= firstName %></p></td>
<td ><p><%= batchHashMap1.get("processDate"+i).toString() %></p></td>
<td ><p><%= batchHashMap1.get("uploadDate"+i).toString() %></p></td>
<td ><p><%= batchHashMap1.get("status"+i).toString() %></p></td>
<td ><p><%= batchHashMap1.get("batchFilename"+i).toString() %></p></td>


</tr>
<%}} %>


</table>


<script language="javascript">

function initial_load() {
	setHeader('addBatch.jsp');
}




function getpdf(id) {
	
	
		
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
		
	var Text = "./DisplayPdf?id="+id+"&userid="+user+"&comid="+com+"&sessionid="+session+"&userName="+userName;
	
	window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
	
}


</script>


</body>

</html>

