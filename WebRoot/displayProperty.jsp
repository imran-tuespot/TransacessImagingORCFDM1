<%@page import="com.peniel.beans.getDropD"%>
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
<%@page import="com.peniel.bus.vo.SessionLog" %>
<jsp:useBean id="documentData" scope="request" class="com.peniel.beans.DocumentDataBean" />
		
		<script src="js/jQuery/jquery-1.8.2.min.js"></script>
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>
		<title>TransAccess Imaging</title>	
		
<script type="text/javascript" src="js/animatedcollapse.js"></script>

		
		<style type="text/css">
		#doctype option{
		width:320;
		}
		#headerDivImg, #contentDivImg {
		float: left;
		width: 100%;
		}
		#titleTextImg {
		float: left;
		font-size: 0.8em;
		margin: 5px;
		}
		#myHeader {
		font-size: 0.7em;
		margin: 5px;
		}
		#headerDivImg {
		background-color: #006;
		color: #FFFFFF;
		}
		#contentDivImg {
		background-color: #FFE694;
		}
		#myContent {
		margin: 5px 10px;
		}
		#headerDivImg a {
		float: right;
		margin: 5px 10px 5px 5px;
		}
		#headerDivImg a:hover {
		color: #FFFFFF;
		}
		div#expand{
		display:block;
		width:100%;
		}
		.example {
			float: left;
			
		}
		.folderStruct {
			width: 98%;
			height: 200px;
			border-top: solid 1px #BBB;
			border-left: solid 1px #BBB;
			border-bottom: solid 1px #FFF;
			border-right: solid 1px #FFF;
			background: #FFF;
			overflow: auto;
			padding: 5px;
			background-color: #EEEEEE;
			
		}
	/*	#flip-tabs{  
		    width:800px;  
		    position:relative;  
		}  
		#flip-navigation{  
		    list-style:none;  
		    margin: 0px 0px 8px;
		    padding: 6px 0px 8px;
		    text-align: left;
		    width: 800px;
		
		}  
		#flip-navigation li{   
		    display:inline;   
		}  
		#flip-navigation li a{  
		    text-decoration:none;    
		    margin-right:0px;  
		    background:#f9f9f9;  
		    color:#333; outline:none;  
		    font-family:Arial;font-weight:bold; font-size:9px; text-transform:uppercase;  
		}  
		#flip-navigation li a:hover{  
		    background:#999;   
		    color:#f0f0f0;  
		}  
		#flip-navigation li.selected a{  
		    background:#999;  
		    color:#f0f0f0;  
		}  
		#flip-container{    
		    width:800px;  
		    font-family:Geneva,Arial,Helvetica,sans-serif;
		    font-size:0.8em;  
		}  
		#flip-container div{   
		}  */
				
		</style>
</head>

<jsp:include page="includes/sessionHeader.jsp" />

<% 
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = "";

%>



<body onLoad="initial_load()">

<div id="flip-tabs" >  
        
        <form name="editForm" id ="editForm" method="POST" action="">
        
        
		<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
		<input type="hidden" id ="comid" name="comid" value="<%=cid%>"/>
		<input type="hidden" id ="username" name="username" value="<%//=userName%>"/>
		
		<table>
		<tr><td style='font-size:14px;font-family: Verdana;color: green'>
		<font color=red><b></b></font>
		</td></tr>
		</table>
        
        
        <div id="flip-container" >  
            <div id="summaryTab">  
            <div style="border: 1px solid #CCC;background: url('images/round_box_botMid3.png') repeat-x scroll center bottom transparent;
									border-bottom: 0px solid #CCC;padding: 10px; min-height: 250px;" align="center">
					<h3 class="tableHeader">Edit Document</h3>  
					<!-- <table align="center" width= "750" >
						<tr height= '20'  align="right">
								<td style='font-size:14px;font-family: Arial;'>&nbsp;
								
								<input type="button" name="cancel" value="Cancel" class="buttonMod" onClick="location.href='admin.jsp?sessionid=<%//=request.getAttribute("sessionid") %>';"></td>
						</tr>
					</table>-->
					<table align="center" width= "750" >
						<tr height= '20'  align="right">
							<td style='font-size:12px;font-family: Arial;'>&nbsp;
								<input type="button" class="buttonMod" name="btnEdit" value="Edit Document" onClick="javascript:editDocProfile();">
								
								<input type="button" class="buttonMod" name="btnReplace" value="Replace Document" onClick="javascript:replaceDoc();">
								<input type="button" name="cancel" value="Cancel" class="buttonMod" onClick="location.href='dashboard.jsp';">
								
							</td>
						</tr>
					</table>
					
					<table align="center" width= "100%" style="border-bottom: 1px solid rgb(204, 204, 204); padding-top: 10px; padding-bottom: 10px;" >
						<tr>
							<td style="padding-bottom: 10px;"><h4 class="tableHeader">Key Document Information</h4></td>
						</tr>
						<tr valign=top>
							
						  <td width=30% rowspan="5">
							<div id="divDocStatus">
								<h4 class="header">Property ID</h4>
							  	<a href="" onclick="javascript:getProperty('')"><label class="summaryLbl"></label></a>
								<p></p>	
																			
							  	<h4 class="header">Document Status</h4><label class="summaryLbl"></label>
								<p></p>	
								
								<h4 class="header" style="display: inline;padding-right: 10px;">View Version No.</h4><label class="summaryLbl"></label>
						    		<a href="javascript:getPdf('');" ><img src="./images/pdfViewer.gif" alt="View Document" border=0></a>
						    		<br><br>
								
							  </div>
								
							</td>
						
						<td>
							<div id="defaultProfile">
							  <table width="100%">
									<tr>
										<td>
											<h4 class="header">Document Type</h4>
										</td>
										<td>
											<h4 class="header">Index Type:</h4>
										</td>
																	
										<td>
											<h4 class="header">Value:</h4>
										</td>						
										
									</tr>
								
								
									
									<tr>
									<td>
										<label class="summaryLbl"></label>									
									</td>
									<td>
										<label class="summaryLbl"></label>
									</td>
									
									
									<td>
										<label class="summaryLbl">	</label>
									</td>
									</tr>
							  </table>
							</div>
						</td>
						</tr>
					</table>
					
					<table align="center" width= "100%" style="border-bottom: 1px solid rgb(204, 204, 204); padding-top: 10px; padding-bottom: 10px;">
						<tr>
							<td style="padding-bottom: 10px;"><h4 class="tableHeader">Document Detail Information</h4></td>
						</tr>
						<tr valign=top>
						
						<td width=30%>
							<div id="divDocDetail">
							<h4 class="header">Document Creation Date:</h4><label class="summaryLbl"> </label>
							<p></p>
							
							 </div>
						 </td>
						
						<td>
						<div id="defaultProfile">
							<table width="100%">
								<tr>
								<td>
								<h4 class="header">Document Last Updated:</h4><label class="summaryLbl"></label>
								</td>
									<td>
										<h4 class="header">Previous Versions?</h4>
										<label class="summaryLbl"></label>
									</td>					
															
									
									<td>
										<h4 class="header">Version Numbers:</h4>
										<label class="summaryLbl"></label>
										
									</td>
									
									
								</tr>
							</table>
						</div></td>
						</tr>
						</table>
						
            </div>
            </div>  
            
        </div>  
        
        </form>
        
        
    </div>


</body>

</html>
