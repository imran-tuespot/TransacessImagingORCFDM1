<%@page import="com.peniel.beans.getDropD"%>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<title>TransAccess Imaging</title>	
		
</head>

<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>

<jsp:include page="includes/sessionHeader.jsp" />

<% 
  System.out.println("*** addDocResult.jsp ***");
  String success = 	request.getParameter("success");
  String successAfterInsert = 	request.getParameter("successAfterInsert");
  System.out.println("success after uploading file ---> "+success);
  System.out.println("success after inserting record in DB ---> "+successAfterInsert);
  
  if (success.equalsIgnoreCase("yes") || successAfterInsert.equalsIgnoreCase("yes")) 
  {
  	success = "<font color=green><b>Document has been saved successfully.</b></font>";
  } 
  else if (success.equalsIgnoreCase("error")|| successAfterInsert.equalsIgnoreCase("no")) 
  {
  	success = "<font color=red><b>Error while adding document. Please contact system administrator.</b></font>";
  } else 
  {
  	success = "";
  }
  System.out.println("success after adding document --->"+success); 
 
  getDropD getDD = new getDropD();
  
  String doctype = request.getAttribute("doctype").toString();
  //System.out.println("doctype -->"+doctype);
  
  String indextype = request.getAttribute("indextype").toString();
  //System.out.println("indextype -->"+indextype);
  
  String folderName = request.getAttribute("folderName").toString();
  System.out.println("folderName -->"+folderName);
  
  String propertytype = request.getAttribute("propertytype").toString();
  System.out.println("propertytype --->"+propertytype);
  
  String docval = getDD.getDoctype(doctype);
  String indextypeval = getDD.getIndex(indextype); 
  String propertyTypeVal = getDD.getProperty(propertytype);
  System.out.println("property val "+propertyTypeVal);
  String folderval = folderName;
  
  
  
  
  String[] docvalarr = docval.split("|");
  String[] indextypevalarr = indextypeval.split("|");
  
  String indextype1 = request.getAttribute("indextype1").toString();
  //System.out.println("indextype1 -->"+indextype1);
  
  String indextype2 = request.getAttribute("indextype2").toString();
  //System.out.println("indextype2 -->"+indextype2);
  
  String indextype3 = request.getAttribute("indextype3").toString();
  //System.out.println("indextype3 -->"+indextype3);
  
  String indextype4 = request.getAttribute("indextype4").toString();
  //System.out.println("indextype4 -->"+indextype4);
  
  String indexval = request.getAttribute("indexval").toString();
  //System.out.println("indexval -->"+indexval);
 
  String indexval1 = request.getAttribute("indexval1").toString();
  //System.out.println("indexval1 -->"+indexval1);
  
  String indexval2 = request.getAttribute("indexval2").toString();
  //System.out.println("indexval2 -->"+indexval2);
  
  String indexval3 = request.getAttribute("indexval3").toString();
  //System.out.println("indexval3 -->"+indexval3);
  
  String indexval4 = request.getAttribute("indexval4").toString();
  //System.out.println("indexval4 -->"+indexval4);

  String fileName = request.getParameter("id").toString();	
  //System.out.println("fileName -->"+fileName);
  
  String indextypeval1 = getDD.getIndex(indextype1); 
  String indextypeval2 = getDD.getIndex(indextype2); 
  String indextypeval3 = getDD.getIndex(indextype3); 
  String indextypeval4 = getDD.getIndex(indextype4); 
   
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
  String webFolder = (String) ctx.lookup("java:comp/env/webfolder");
  
  String strContextPath = request.getContextPath();
  // String filePath = strContextPath + "/scaimages/"+companyName+"/web/" + fileName;
  String filePath = companyName+"/"+webFolder+"/"+ fileName;
  
  HashMap hashMap = userInformation.getUserInformation(request);
  //System.out.println( "hashMap = " + hashMap );
  
  lastName = (String) hashMap.get("lastName");
  if(lastName== null) lastName="";
  firstName = (String) hashMap.get("firstName"); 
  if(firstName== null) firstName="";  
  
%>

<body onLoad="initial_load()" >

<table>
<tr><td >
<%=success%>
</td></tr>
</table>

<form name="upload" method="post" action="AddDocument" enctype="multipart/form-data">

<div class="blueHeaderNoRound">
	<div class="blueHeaderNoRoundText">Key Document Information:</div>
</div>


<br>
<table align="center" width= "843" >
<tr valign=top align="left">

<td width=55% >
<div id="divDocStatus">
<h4>Document Type</h4> 
<div style="font-size:0.8em;"><%=docval%></div> 
<p></p>
<h4>Folder Name</h4> 
<div style="font-size:0.8em;"><%=folderval%></div>

<p><b>Property ID &nbsp;&nbsp;&nbsp;&nbsp; </b>
<div style="font-size:0.8em;"><%=propertyTypeVal%></div>
</p>

<h4>View Document</h4> <a href="javascript:getpdf('<%=filePath %>');" ><img src="./images/pdfViewer.gif" border="0"></a></div>	
</td>

<td  valign="top">
<div id="defaultProfile">
<table width="100%">
<tr valign="top">
<td width="214" >
	<h4>Index Type</h4></td>
<td width="148" >
	<h4><b>Value</b></h4></td>
</tr>
	
<tr>
<td >
  <p><%=indextypeval%></p></td>
<td >
  <p><%=indexval%></p></td>
</tr>

<tr>
<td >
  <p><%=indextypeval1%></p></td>
<td ><p><%=indexval1%></p></td>
</tr>

<tr>
<td >
  <p><%=indextypeval2%></p></td>
<td >
  <p><%=indexval2%></p></td>
</tr>

<tr>
<td >
  <p><%=indextypeval3%></p></td>
<td >
  <p><%=indexval3%></p></td>
</tr>

<tr>
<td >
  <p><%=indextypeval4%></p></td>
<td >
  <p><%=indexval4%></p></td>
</tr>
</table>
</div>
</td>
</tr>
</table>
<div class="blueHeaderNoRound">
	<div class="blueHeaderNoRoundText">Property Information:</div>
</div>



<table align="center" width= "843" >
<tr height="5"><td></td></tr>
<tr valign=top align="left">
<td><table width="98%">
  <tr>
<td width="50%" valign="top" ><h4>Property ID:</h4>
  
  <p><%=propertyTypeVal %>
    </p></td>

<td valign="top" >
	<h4>Property Name</h4> 
	<p></p>
</td>

<td valign="top" ><h4>Location</h4>
  <p>0</p></td>
</tr></table></td>
</tr>

</table>

<div class="blueHeaderNoRound">
	<div class="blueHeaderNoRoundText">Document Detail Information:</div>
</div>



<table align="center" width= "843" >
<tr height="5"><td></td></tr>
<tr valign=top align="left">
<td><table width="98%">
  <tr>
<td width="50%" valign="top" ><h4>System Creation Date:</h4>
  
  <p><%=timestamp %>
    </p></td>

<td valign="top" >
<h4>Previous Versions?</h4> 
<p>N  
</p></td>

<td valign="top" ><h4>Version Numbers:</h4>
  <p>0</p></td>
</tr></table></td>
</tr>

</table>
</form>


<div class="blueHeaderNoRound">
	<div class="blueHeaderNoRoundText">Audit Trail:</div>
</div>


<table align="center" width= "843" >


<tr align="left">
<td></td>
<td ><h4>Date</h4></td>
<td ><h4>UserId</h4></td>
<td ><h4>Last Name</h4></td>
<td ><h4>First Name</h4></td>

<td></td>
</tr>

<tr align="left">
<td></td>
<td ><p><%= timestamp%></p></td>
<td ><p><%= userName %></p></td>
<td ><p><%= lastName %></p></td>
<td ><p><%= firstName %></p></td>

<td></td>
</tr>

</table>


<script language="javascript">

function initial_load() {
	setHeader('addDoc.jsp');
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

