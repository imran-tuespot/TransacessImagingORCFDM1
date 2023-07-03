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
		
		<script type="text/javascript" src="js/jquery-1.3.2.js" ></script>
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>
		<title>TransAccess Imaging</title>	
		
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
  String errorMsg = "";
  String success = 	request.getParameter("success");
  String FileSize = request.getParameter("FileSize");
  System.out.println("***FileSize*** " +FileSize);
  System.out.println("In addDoc1.jsp Success after uploading file ---> "+success);
  
  if (success.equalsIgnoreCase("error")) 
  {
   errorMsg = "Error while adding document. Please contact system administrator.";
  }
  
  if (FileSize.equalsIgnoreCase("error_lagre_file_size")) 
  {
   errorMsg = "Too large file. Please contact system administrator.";
  }
    
  getDropD getDD = new getDropD();
  
  String doctype = request.getAttribute("doctype").toString();
  System.out.println("doctype -->"+doctype);
  
  String indextype = request.getAttribute("indextype").toString();
  System.out.println("indextype -->"+indextype);
  
  String folderName = request.getAttribute("folderName").toString();
  System.out.println("folderName -->"+folderName);
  
  String propertytype = request.getAttribute("propertytype").toString();
  System.out.println("propertytype --->"+propertytype);
  
  String actualFileName = request.getAttribute("actualFileName").toString();
  System.out.println("actualFileName --->"+actualFileName);
  
  
  String docval = getDD.getDoctype(doctype);
  String indextypeval = getDD.getIndex(indextype);
  String propertyTypeVal = getDD.getProperty(propertytype);
  System.out.println("property val "+propertyTypeVal);
  String folderval = folderName; 
  
  
   
  
  String[] docvalarr = docval.split("|");
  String[] indextypevalarr = indextypeval.split("|");
  //String[] foldervalarr = folderval.split("|");
  
  
    
  String indextype1 = request.getAttribute("indextype1").toString();
  //System.out.println("indextype1 -->"+indextype1);
  /*
  String indextype2 = request.getAttribute("indextype2").toString();
  //System.out.println("indextype2 -->"+indextype2);
  
  String indextype3 = request.getAttribute("indextype3").toString();
  //System.out.println("indextype3 -->"+indextype3);
  
  String indextype4 = request.getAttribute("indextype4").toString();
  //System.out.println("indextype4 -->"+indextype4);
  */
  String indexval = request.getAttribute("indexval").toString();
  //System.out.println("indexval -->"+indexval);
 /*
  String indexval1 = request.getAttribute("indexval1").toString();
  //System.out.println("indexval1 -->"+indexval1);
  
  String indexval2 = request.getAttribute("indexval2").toString();
  //System.out.println("indexval2 -->"+indexval2);
  
  String indexval3 = request.getAttribute("indexval3").toString();
  //System.out.println("indexval3 -->"+indexval3);
  
  String indexval4 = request.getAttribute("indexval4").toString();
  //System.out.println("indexval4 -->"+indexval4);
*/
  String fileName = request.getParameter("id").toString();	
  //System.out.println("fileName -->"+fileName);
  
  //String indextypeval1 = getDD.getIndex(indextype1); 
 // String indextypeval2 = getDD.getIndex(indextype2); 
  //String indextypeval3 = getDD.getIndex(indextype3); 
  //String indextypeval4 = getDD.getIndex(indextype4); 
  
   
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  String cId = request.getSession().getAttribute("comid").toString();
  
  String docId = request.getAttribute("docId").toString();
  System.out.println("docId --->"+docId);
  
 
  String lastName = "";
  String firstName = "";
  
  com.peniel.dao.CompanyDAO companyDao = new com.peniel.dao.CompanyDAO();
  Vector companyList = new Vector();
  com.peniel.bus.vo.Company company = new com.peniel.bus.vo.Company();
			
  companyList = companyDao.findById(cId);
  company = (com.peniel.bus.vo.Company) companyList.get(0);
  String companyName = company.getCompanyName();
  System.out.println ("Company Name ---> "+companyName);
  
  java.util.Date today = new java.util.Date();
  java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
  //System.out.println ("In do post "+timestamp);
  
  javax.naming.Context ctx = new javax.naming.InitialContext();
  String webFolder = (String) ctx.lookup("java:comp/env/webfolder");
  
  String strContextPath = request.getContextPath();
  // String filePath = strContextPath + "/scaimages/"+companyName+"/web/" + fileName;
  String filePath = companyName+"/"+webFolder+"/"+ fileName;
  
  HashMap hashMap = userInformation.getUserInformation(request);
 
  
  lastName = (String) hashMap.get("lastName");
  if(lastName== null) lastName="";
  firstName = (String) hashMap.get("firstName"); 
  if(firstName== null) firstName="";
  List<String> html = folderBean.getPropertyNameGridHTML(""+cid,""); 
 
%>

<body onLoad="initial_load()" >

<div id="flip-tabs" >  
        <ul id="flip-navigation" >  
              <li class="selected"><a href="#content" onclick="javascript:tabContent0()" id="tab-0"  ><img id="docInfoImg" src="images/docInfo1.png" width="195px;" height="60px;"/></a></li>  
            <li><a href="#folderTab" id="tab-1" onclick="javascript:tabContent1()"><img id="folderInfoImg" src="images/folderInfo1.png" width="195px;" height="60px;"/></a></li>  
            <li><a href="#uploadDocTab" id="tab-2"  onclick="javascript:tabContent2()"><img id="uploadDocImg" src="images/uploadDocActive.png" width="195px;" height="60px;"/></a></li>  
            <li><a href="#summaryTab" id="tab-3" onclick="javascript:tabContent3()"><img id="reviewImg" src="images/Review1.png" width="195px;" height="60px;"/></a></li>                       
        </ul>   
        
        <form name="upload" method="post" action="AddDocument" enctype="multipart/form-data">
        

		<table>
		<tr><td style='font-size:14px;font-family: Verdana;color: green'>
		<font color=red><b><%=errorMsg%></b></font>
		</td></tr>
		</table>
        
        
        <div id="flip-container" >  
					<div  id="content"> <!--  Content for First tab -->		
						<table style="border: 1px solid #CCC;background: url('images/round_box_botMid3.png') repeat-x scroll center bottom transparent;
									border-bottom: 0px solid #CCC;padding: 10px;" align="center" width= "100%">
								<tr>
									<td><h4 class="tableHeader">Select the type of document and index</h4></td>
								</tr>	
								<tr valign=top>
								
								<td width=60% rowspan="5" >
									<div id="divDocStatus">
									<h4 class="header">Document Type</h4>
									  <select  name="doctype" id="doctype" class="selectText">
									    <option value="<%=doctype%>"><%=docval%></option>
									  </select>
									  <p></p>	
									  <h4 class="header">Property ID</h4> 
								  		<select  name="propertytype" id="propertytype" class="selectText">
								    		<option value="<%=propertytype%>"><%=propertyTypeVal %></option>
								  		</select>							
									  <p><h4 class="header">Document Status: Active </h4>  </p>
									  
									</div>								
								</td>
								
								</tr>
								<tr valign=top>
								  <td  valign="top">
								  
								  <div id="defaultProfile">
								<table width="400" cellpadding="0" cellspacing="0">
									<tr valign="top">
										<td width="200" >
											<h4 class="header">Index Type</h4>
										</td>
										<td width="200" >
											<h4 class="header">Value</h4>
										</td>
									</tr>
									
									<tr>
										<td >
										<select  id="indextype" name="indextype" style="width: 150px" class="selectText">
											<option value="<%=indextype%>"><%=indextypeval%></option>
										</select>
										</td>
									<td >
										<input id="value" name="value" type="text" value="<%=indexval%>"></td>
									</tr>
								
									<!-- tr>
										<td >
											<select  id="indextype1" name="indextype1" style="width: 150px" class="selectText">
											<option value="<%=indextype1%>"><%//=indextypeval1%></option>
											</select>
										</td>
										<td >
											<input id="value1" name="value1" type="text" value="<%//=indexval1%>">
										</td>
									</tr>
								
								<tr>
								<td >
									<select  id="indextype2" name="indextype2" style="width: 150px" class="selectText">
										<option value="<%//=indextype2%>"><%//=indextypeval2%></option>/
									</select>
								</td>
								<td >
									<input id="value2" name="value2" type="text" value="<%//=indexval2%>"></td>
								</tr>
								
								<tr>
								<td >
									<select  id="indextype3" name="indextype3" style="width: 150px" class="selectText">
										<option value="<%//=indextype3%>"><%//=indextypeval3%></option>
									</select>
								</td>
								<td >
									<input id="value3" name="value3" type="text" value="<%//=indexval3%>"></td>
								</tr>
								
								<tr>
								<td >
									<select  id="indextype4" name="indextype4" style="width: 150px" class="selectText">
										<option value="<%//=indextype4%>"><%//=indextypeval4%></option>
									</select>
								 </td>
								<td >
									<input id="value4" name="value4" type="text" value="<%//=indexval4%>"></td>
								</tr-->
								
								</table>
								</div>							  
								  </td>
								</tr>
								<tr align="right">
								<td>
								<input id="btnContFirst" class="buttonContMod" onkeypress="" value="Continue" type="button"/>
								</td>
								</tr>
								</table>
								
								
								
								<br>
								
								
            </div>  
             <div id="folderTab">   
            	<div class="card" style="width: 95%; padding-left: 0px;">
					<div class="card-body card-padding" style="background-color:#EBEBEB;">    
						<div style="min-height: 360px;" align="center" width= "100%">
							<div style="float: left;width:100%"><h4 class="tableHeader" style="padding-top: 10px;padding-bottom: 10px;"><i class="zmdi_large zmdi-folder-outline"></i>Select Folder</h4></div>
								<div style="float: right;margin-bottom:5px;margin-right:10px">
								
								<input type="text" id="foltxt" placeholder="Search" style="width: 330px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onkeyup="javascript:searchFolSel();"/>
								
							<input id="folderNameFView" name="folderNameFView" readonly="readonly" type="text"  size=40 onchange="setFolderPatteren(this.options[this.selectedIndex].innerHTML)"></div> 
						
								<div class="example" id="expand" style="display: block;">
											<div id="fileTreeDemo_1" class="folderStruct" ></div>
								</div>	
								<br><br>
								<div style="float:left;">
									
								</div>
								<div style="float:right;margin-top:15px;">
										<input id="btnContSecond" class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 15px;"  type="button" onclick="javascript:tabContent2()" value="Continue">				
								</div>
						</div>
			 	
				</div> 
			</div></div>    
			<div id="uploadDocTab">        
	            <div style="border: 1px solid #CCC;background: url('images/round_box_botMid3.png') repeat-x scroll center bottom transparent;
									border-bottom: 0px solid #CCC;padding: 10px; min-height: 300px;" align="center">
					<h3 class="tableHeader">Upload Document</h3>			
								<table align="center" width= "100%" >
								<tr valign="top"><td><p>To add a document, click the Add File button after downloading the document.
								</p></td></tr>
								<tr height="5"><td></td></tr>
								<tr valign=top>
								<td><table><tr>
								<td>&nbsp;&nbsp;<input type="hidden" id ="cid" name="cid" value="<%=cid%>"/>
								<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
								<input type="hidden" id ="confirmParam" name="confirmParam"/>
								<input type="hidden" id ="actualFileName" name="actualFileName" value="<%=actualFileName %>"/>
								<input type="hidden" id ="folderval" name="folderval" value="<%=folderval %>"/>
								
								<input type="hidden" id ="fileName" name="fileName" value="<%=fileName%>"/>
								<input type="hidden" id ="docId" name="docId" value="<%=docId%>"/>
								
								
								</td>
								<td>
								&nbsp;&nbsp;<input id="file" name="file" type="file" size="40" onchange="javascript:getFilePath();" onClick="javascript:enable();">&nbsp;&nbsp;&nbsp;&nbsp;
								 <input id="attach" name="attach" type="submit" onClick="return check1();" value="Add New File" disabled="disabled">
								</td>
								</tr>
								<tr>
									<label class="summaryLbl"> View Document <a href="javascript:getpdf('<%=filePath %>');"><img src="./images/pdfViewer.gif" border="0"></a></label>
								
								</tr>
								
								</table>
								</td>
								</tr>
								<tr align="right">
								<td>
								<input id="btnContThird" class="buttonContMod" onkeypress="" value="Continue" type="button"/>
								</td>
								</tr>
								</table>
            	</div> 
            </div>
            <div id="summaryTab">  
            <div style="border: 1px solid #CCC;background: url('images/round_box_botMid3.png') repeat-x scroll center bottom transparent;
									border-bottom: 0px solid #CCC;padding: 10px; min-height: 250px;" align="center">
					<h3 class="tableHeader">Review</h3>  
					<table align="center" width= "750" >
						<tr height= '20'  align="right">
								<td style='font-size:14px;font-family: Arial;'>&nbsp;
								<%if(success.equalsIgnoreCase("error") || FileSize.equalsIgnoreCase("error_lagre_file_size")){ %>
									<input type="button"  id="save" name="save" value="Save"  disabled="disabled"> 
									<input type="button" id= "saveandnew" name="saveandnew" value="Save & Add New" disabled="disabled">
								<%} else { %>
									<input type="button" name="save" value="Save" class="buttonMod"  onClick="javascript:confirmAttach()"> 
									<input type="button" name="saveandnew" value="Save & Add New" class="buttonMod" onClick="javascript:confirmAttach1();"> 
								<%} %>
								<input type="button" name="cancel" value="Cancel" class="buttonMod" onClick="javascript:onCancel();"></td>
						</tr>
					</table>
		            	<table align="center" width= "100%">
							<tr>
								<td><h4 class="tableHeader">Please review entered values and save the document.</h4></td>
							</tr>	
							<tr valign=top>
								
								<td width=60% rowspan="5" >
								<div>
									<h4 class="header">Document ID</h4>
								  	<label class="summaryLbl" id="doctypeLbl"></label>
								  	<p></p>								
								  	<h4 class="header">Property ID</h4> 
								  	<label class="summaryLbl" id="propertytypeLbl"></label>
								  	<p></p>	
								  	<h4 class="header">Folder</h4> 
								  	<label class="summaryLbl" id="folderLbl"></label>
								  	<p></p>							  
								 </div>
								
								</td>
								
								</tr>
								<tr valign=top>
								<td>
								  
								<div id="defaultProfile">
								<table width="400" cellpadding="0" cellspacing="0">
								<tr valign="top">
									<td width="200" >
										<h4 class="header">Index Type</h4>
									</td>
									<td width="200" >
										<h4 class="header">Value   </h4>
									</td>
								</tr>
									
								<tr>
								<td><label class="summaryLbl" id="indexTypeLbl"></label></td>
								<td><label class="summaryLbl" id="indexValueLbl"></label></td>
								</tr>
								
								<tr>
								<td >
								</td>
								<td ></td>
								</tr>
								
							
								</table>
								</div>							  
								  </td>
								</tr>
								
								</table>
            </div>
            </div>  
            
        </div>  
        
        </form>
        
        
    </div>
    



<script language="javascript">
 var fView = "fView";

$('document').ready(function(){
var pageTab = '<%= request.getAttribute("flipTab").toString()%>';
if(pageTab)
{
	$('#flip-container').quickFlipper({ }, pageTab, 1);
}
<% request.removeAttribute("flipTab");%>;
displayFolderStructure();

		$('#flip-container').quickFlip();
		
		$('#flip-navigation li a').each(function(){
			$(this).click(function(){
				$('#flip-navigation li').each(function(){
					$(this).removeClass('selected');
				});
				$(this).parent().addClass('selected');
				var flipid=$(this).attr('id').substr(4);
				
				$('#flip-container').quickFlipper({ }, flipid, 1);
				
				return false;
			});
		});
	});
//Global variable to store array elements for expanded folder
 var s = [];   
/*function showFolderStructure()
{
	
		var ele = document.getElementById('expand');
        var imageEle = document.getElementById('imageDivLink');
        if(ele.style.display == "block") {
                ele.style.display = "none";
		imageEle.innerHTML = '<img src="images/plus.png">';
        }
        else {
                ele.style.display = "block";
                displayFolderStructure();                
                imageEle.innerHTML = '<img src="images/minus.png">';
        }
}*/
function displayFolderStructure()
{
   //Displays only the folder structure required for folder selection
  $('#fileTreeDemo_1').fileTree({ root: '/',
	 script: 'connectors/jqueryFolderSelection.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'One moment...' }, function(file) { 
					//alert(file);
				});
	
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
	
	getdropdowns();
	// session();
	setHeader('addDoc.jsp');
	checkIfDone();
}

var index = new Array();
var documentdata = new Array();
var propertydata = new Array();


function getdropdowns() {
var compid = '<%= cid %>';
var queryString = "compid="+compid;

if(xmlhttp) { 
    // xmlhttp.open("GET",URL,true); 
    xmlhttp.open("POST","GetDropdownOptions",true); 
    xmlhttp.onreadystatechange  = handleServerResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send(queryString);
  } 
}

function handleServerResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	parseData(xmlhttp.responseText);
     	// alert(xmlhttp.responseText);
     }    
     else {
        alert(xmlhttp.status);
     }
   }
}

function parseData(data) {
	var row = data.split('$');
	var indexstr = row[0];
	var docstr = row[1];
	var propertystr = row[2];
	
	parseindexstr(indexstr);
	parsedocstr(docstr);
	parsepropertystr(propertystr);	
}



function parseindexstr(indexstr) {
	var row = indexstr.split('|');
	index.length = 0;
	for (var i=0; i<row.length-1; i++) {
	  var col = row[i].split('^');
	  index[i]= new Array(col[0],col[1]);
	  // alert(index[i][0]+"="+index[i][1]);
    }
    
    for (var i=0; i < index.length;++i){
	addOption(document.getElementById("indextype"), index[i][0], index[i][1]);
	}
	/*
	for (var i=0; i < index.length;++i){
	addOption(document.getElementById("indextype1"), index[i][0], index[i][1]);
	}
	for (var i=0; i < index.length;++i){
	addOption(document.getElementById("indextype2"), index[i][0], index[i][1]);
	}
	for (var i=0; i < index.length;++i){
	addOption(document.getElementById("indextype3"), index[i][0], index[i][1]);
	}
	for (var i=0; i < index.length;++i){
	addOption(document.getElementById("indextype4"), index[i][0], index[i][1]);
	}*/
}

function parsedocstr(docstr) {
	var row = docstr.split('|');
	documentdata.length = 0;
	for (var i=0; i<row.length-1; i++) {
	  var col = row[i].split('^');
	  documentdata[i]= new Array(col[0],col[1]);
	  // alert(documentdata[i][0]+"="+documentdata[i][1]);
    }
    
    for (var i=0; i < documentdata.length;++i){
    addOption(document.getElementById("doctype"), documentdata[i][0], documentdata[i][1]);
    }
    
}

function parsepropertystr(propertystr) {
	var row = propertystr.split('|');
	propertydata.length = 0;
	for (var i=0; i<row.length-1; i++) {
	  var col = row[i].split('^');
	  propertydata[i]= new Array(col[0],col[1]);
	   //alert(documentdata[i][0]+"="+documentdata[i][1]);
    }
    
    for (var i=0; i < propertydata.length;++i){
    	addOption(document.getElementById("propertytype"), propertydata[i][0], propertydata[i][1]);
    }
    /*if(document.getElementById("propertytype").options.length > 1)
    	document.getElementById("propertytype").selectedIndex =1;*/
}



function addOption(selectbox,text,value )
{
	var optn = document.createElement("OPTION");
	optn.text = text;
	optn.title = text;
	optn.value = value;
	selectbox.options.add(optn);
}

function validateForm()
{	
	//Check if folder field contains value
	if(document.getElementById('folderNameFView').value == "" ) 
	{
		//tabContent1();
		document.getElementById('tab-1').click();
		alert("Please Select Folder.");
		return false;		
	}
	
	//Check if doctype field contains value
	if(document.getElementById('doctype').value == "" ) 
	{
		tabContent0();		
		alert("Please Select Document Type Field.");
		return false;		
	}//Check if index type field contains value
	else if(document.getElementById('indextype').value == "" && document.getElementById('indextype1').value == ""
	   && document.getElementById('indextype2').value == "" && document.getElementById('indextype3').value == "" ) 
	{
		tabContent0();		
		alert("Please Select Index Type.");
		return false;		
	}//Check if value field contains value
	else if(document.getElementById('value').value == "" && document.getElementById('value1').value == ""
	        && document.getElementById('value2').value == "" && document.getElementById('value3').value == "" ) 
	{
		tabContent0();
		
		alert("Please Enter Index Value.");
		return false;		
	}	
	return true;	
}

function confirmAttach()
{
	document.getElementById('confirmParam').value = 'Yes';
	if(validateForm())
		document.upload.submit();
}

function confirmAttach1(){
	document.getElementById('confirmParam').value = 'Yes1';
	if(validateForm())
		document.upload.submit();
}

function enable() {
document.getElementById("attach").disabled=false;
}

function getpdf(id) {
	
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
		
	var Text = "./DisplayPdf?id="+id+"&userid="+user+"&comid="+com+"&sessionid="+session+"&userName="+userName;
	window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
	
}
function onCancel(){
	window.location="admin.jsp";
}
function checkIfDone()
{
	
	var value = document.getElementById('value').value;
	
	var folderName = document.getElementById('folderNameFView').value;
	
	var file = document.getElementById('file').value;
	var uploadedFile = '<%=filePath %>';
	//alert("upload "+uploadedFile);
	if (value != "")
	{
		document.getElementById('docInfoImg').src = "images/docInfoDone.png";		
	}
	if(folderName != "")
	{
		document.getElementById('folderInfoImg').src = "images/folderInfoDone.png";	 		
	}
	if(file != "" || uploadedFile != "")
	{
		document.getElementById('folderInfoImg').src = "images/uploadDocDone.png";	 		
	}
	if(value != "" && folderName != "" && file != "")
	{
			 document.getElementById('reviewImg').src = "images/Review1.png";
	
	}
}
function tabContent0()
{
		 document.getElementById('docInfoImg').src = "images/docInfoActive.png";
		 document.getElementById('folderInfoImg').src = "images/folderInfo1.png";		 
		 document.getElementById('uploadDocImg').src = "images/uploadDoc1.png";		 
		 document.getElementById('reviewImg').src = "images/Review1.png";
		 checkIfDone();
		 $('#flip-container').quickFlipper({ }, 0, 1);
		 document.getElementById('uploadDocTab').style.display = 'none';
		
		
}
function tabContent1()
{
		 document.getElementById('docInfoImg').src = "images/docInfo1.png";
		 document.getElementById('folderInfoImg').src = "images/folderInfoActive.png";		 
		 document.getElementById('uploadDocImg').src = "images/uploadDoc1.png";		 
		 document.getElementById('reviewImg').src = "images/Review1.png";
		 checkIfDone();
		 $('#flip-container').quickFlipper({ }, 1, 1);
		 document.getElementById('uploadDocTab').style.display = 'none';		 	
		
}
function tabContent2()
{
		 document.getElementById('docInfoImg').src = "images/docInfo1.png";
		 document.getElementById('folderInfoImg').src = "images/folderInfo1.png";		 
		 document.getElementById('uploadDocImg').src = "images/uploadDocActive.png";		 
		 document.getElementById('reviewImg').src = "images/Review1.png";
		 checkIfDone();

		 $('#flip-container').quickFlipper({ }, 2, 1);
		 document.getElementById('uploadDocTab').style.display = 'none';		
		
}
function tabContent3()
{
		 document.getElementById('docInfoImg').src = "images/docInfo1.png";
		 document.getElementById('folderInfoImg').src = "images/folderInfo1.png";		 
		 document.getElementById('uploadDocImg').src = "images/uploadDoc1.png";		 
		 document.getElementById('reviewImg').src = "images/reviewActive.png";
		 checkIfDone();
		 
		 document.getElementById('folderLbl').innerHTML  = document.getElementById('folderNameFView').value;
		 document.getElementById('doctypeLbl').innerHTML  = document.getElementById('doctype').options[document.getElementById('doctype').selectedIndex].text;
		 document.getElementById('propertytypeLbl').innerHTML  = document.getElementById('propertytype').options[document.getElementById('propertytype').selectedIndex].text;
		 document.getElementById('indexTypeLbl').innerHTML  = document.getElementById('indextype').options[document.getElementById('indextype').selectedIndex].text;
		 document.getElementById('indexValueLbl').innerHTML  = document.getElementById('value').value;
		 
		 $('#flip-container').quickFlipper({ }, 3, 1);
		 document.getElementById('uploadDocTab').style.display = 'none';
		
		
}
</script>


</body>

</html>
