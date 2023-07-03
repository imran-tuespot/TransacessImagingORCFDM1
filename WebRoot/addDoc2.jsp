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
		<script src="js/jQuery/jquery-1.8.2.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	
		<!-- <script type="text/javascript" src="js/jquery-1.3.2.js" ></script>-->
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>
		<script type="text/javascript" src="js/jquery.popupoverlay.js" ></script>	
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" /> 
		
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

<jsp:include page="includes/sessionHeader.jsp" />


<% 
  String errorMsg = "";
  String success = 	request.getParameter("success");
  String FileSize = request.getParameter("FileSize");
  System.out.println("***FileSize*** " +FileSize);
  System.out.println("In addDoc2.jsp Success after uploading file ---> "+success);
  
  String appuserrole = (String)request.getSession().getAttribute("appuserrole");
  System.out.println("appuserrole "+appuserrole);
  
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
  System.out.println("doctype -->"+doctype+"<---");
  String indextype = request.getAttribute("indextype").toString();
  System.out.println("indextype -->"+indextype+"<---");
  String folderName = request.getAttribute("folderName").toString();
  
  System.out.println("folderName in addDoc2 -->"+folderName+"<---");
  
  String propertytype = request.getAttribute("propertytype").toString();
  System.out.println("propertytype -->"+propertytype+"<---");
  
  String actualFileName = request.getAttribute("actualFileName").toString();
  System.out.println("actualFileName -->"+actualFileName+"<---");
  
  
  String docval = getDD.getDoctype(doctype);
  System.out.println("actualFileName -->"+actualFileName+"<---");
  String indextypeval = getDD.getIndex(indextype);
  System.out.println("actualFileName -->"+actualFileName+"<---");
  String propertyTypeVal = getDD.getProperty(propertytype);
  System.out.println("property val "+propertyTypeVal);
  String folderval = folderName;   
  System.out.println("actualFileName -->"+actualFileName+"<---");
  
  
  //String[] docvalarr = docval.split("|");
  //String[] indextypevalarr = indextypeval.split("|");
  
  /*  
  String indextype1 = request.getAttribute("indextype1").toString();
  
  String indextype2 = request.getAttribute("indextype2").toString();
  
  String indextype3 = request.getAttribute("indextype3").toString();
  
  String indextype4 = request.getAttribute("indextype4").toString();
 */
  String indexval = request.getAttribute("indexval").toString();
/*
  String indexval1 = request.getAttribute("indexval1").toString();
 
  String indexval2 = request.getAttribute("indexval2").toString();
  
  String indexval3 = request.getAttribute("indexval3").toString();
  
  String indexval4 = request.getAttribute("indexval4").toString();
*/
  String fileName = request.getParameter("id").toString();	
 /* 
  String indextypeval1 = getDD.getIndex(indextype1); 
  String indextypeval2 = getDD.getIndex(indextype2); 
  String indextypeval3 = getDD.getIndex(indextype3); 
  String indextypeval4 = getDD.getIndex(indextype4); 
  */
   
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  String cId = request.getSession().getAttribute("comid").toString();
  
  String docId = request.getAttribute("docId").toString();
  
  /*com.peniel.dao.CompanyDAO companyDao = new com.peniel.dao.CompanyDAO();
  Vector companyList = new Vector();
  com.peniel.bus.vo.Company company = new com.peniel.bus.vo.Company();
			
  companyList = companyDao.findById(cId);
  company = (com.peniel.bus.vo.Company) companyList.get(0);
  String companyName = company.getCompanyName();
  
   
  javax.naming.Context ctx = new javax.naming.InitialContext();
  String webFolder = (String) ctx.lookup("java:comp/env/webfolder");
  
  String strContextPath = request.getContextPath();*/
  
  String filePath = request.getAttribute("filePath").toString();
  
 // HashMap hashMap = userInformation.getUserInformation(request);
 
  List<String> html = folderBean.getPropertyNameGridHTML(""+cid,""); 
 
%>

<body onLoad="initial_load()" >

<div id="flip-tabs" >  
        <div class="tabbox">		
	        <ul id="flip-navigation" >  
	              <li ><a href="#content" onclick="javascript:tabContent0()" id="tab-0"  >Document Information<!-- <img id="docInfoImg" src="images/docInfoActive.png" width="195px;" height="60px;"/>--></a></li>  
 	            <li><a href="#folderTab" id="tab-1" onclick="javascript:tabContent1()">Folder Information</a></li>  
	            <li class="selected"><a href="#uploadDocTab" id="tab-2"  onclick="javascript:tabContent2()">Upload Document<!-- <img id="uploadDocImg" src="images/uploadDoc1.png" width="195px;" height="60px;"/>--></a></li>  
	            <li><a href="#summaryTab" id="tab-3" onclick="javascript:tabContent3()">Review <!-- <img id="reviewImg" src="images/Review1.png" width="195px;" height="60px;"/>--></a></li>                       
	        </ul>  
	     </div>
        
        <form name="upload" method="post" action="AddDocument" enctype="multipart/form-data">
        

		<table>
		<tr><td style='font-size:14px;font-family: Verdana;color: green'>
		<font color=red><b><%=errorMsg%></b></font>
		</td></tr>
		</table>
        
        
        <div id="flip-container" >  
            
					<div  id="content"> <!--  Content for First tab -->		
						<div class="card" style="width: 95%; padding-left: 0px;">
							<div class="card-body card-padding" style="background-color:#EBEBEB;margin-bottom: 20px;">				  
						  	<table>
							<tr>
								<td colspan="3"><h4 style="padding-top: 10px;padding-bottom: 10px;" class="tableHeader">Select the type of document and index</h4></td>
							</tr>	
							<tr valign=top>
								
								<td width=50% rowspan="5" style="vertical-align: top;">
								<div id="divDocStatus" style="margin-top: 10px;">
								<h4 class="header">Search Property ID</h4>								
							    <input type="text" id="realtxt" style="width: 330px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onkeyup="javascript:searchSel();"/>
								
								<h4 class="header">Property ID</h4> 
									  <select  name="propertytype" id="propertytype" class="selectText" style="width:330px;" onchange="setPropertyFolder(this.options[this.selectedIndex].innerHTML)">
									    		<option value="<%=propertytype%>"><%=propertyTypeVal %></option>
									  </select>
								
								  <p></p>								
									<h4 class="header">Document Type</h4>
								   <select  name="doctype" id="doctype" class="selectText" style="width:330px;">
									    <option value="<%=doctype%>"><%=docval%></option>
									</select>  
								</div>
								
								</td>
								
								</tr>
								<tr valign=top>
								<td>
								  
								<div id="defaultProfile">
								<table width="100%" cellpadding="0" cellspacing="0">
								<tr valign="top">
									<td width="200" >
										<h4 class="header">Index Type</h4>
									</td>
									<td width="200" >
										<h4 class="header">Value   </h4>
									</td>
								</tr>
									
								<tr>
								<td >
									<select  id="indextype" name="indextype" style="width: 150px" class="selectText">
										<option value="<%=indextype%>"><%=indextypeval%></option>
									</select>
								</td>
								<td >
										<input id="value" name="value" type="text" value="<%=indexval%>" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
								</tr>
								
								<!-- tr>
								<td style="padding-top: 20px;">
								<select  id="indextype1" name="indextype1" style="width: 150px" class="selectText">
											<option value="<%//=indextype1%>"><%//=indextypeval1%></option>
								</select>
								</td>
								<td style="padding-top: 20px;">
											<input id="value1" name="value1" type="text" value="<%//=indexval1%>" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
								</tr>
								
								<tr>
								<td style="padding-top: 20px;">
								<select  id="indextype2" name="indextype2" style="width: 150px" class="selectText">
										<option value="<%//=indextype2%>"><%//=indextypeval2%></option>
									</select>
								</td>
								<td style="padding-top: 20px;">
									<input id="value2" name="value2" type="text" value="<%//=indexval2%>" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
								</tr>
								
								<tr>
								<td style="padding-top: 20px;">
								<select  id="indextype3" name="indextype3" style="width: 150px" class="selectText">
										<option value="<%//=indextype3%>"><%//=indextypeval3%></option>
									</select>
								</td>
								<td style="padding-top: 20px;" >
									<input id="value3" name="value3" type="text" value="<%//=indexval3%>" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
								</tr>
								
								<tr>
								<td style="padding-top: 20px;">
								<select  id="indextype4" name="indextype4" style="width: 150px" class="selectText">
										<option value="<%//=indextype4%>"><%//=indextypeval4%></option>
									</select>
								</td>
								<td style="padding-top: 20px;">
									<input id="value4" name="value4" type="text" value="<%//=indexval4%>" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
								</tr-->
								</table>
								</div>							  
								  </td>
								</tr>
								<tr>
									<td  colspan="2" style="padding-bottom: 20px; padding-top: 20px; text-align: right;">
										<input id="btnContFirst" class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 15px;"  type="button" onclick="javascript:tabContent1()" value="Continue">
										<input id="clear" name="clear" class="btn btn-warning waves-effect waves-button waves-float" style="margin-right: 25px;" type="button" onClick="" value="Clear">											
																				
									</td>
									
									<td>
									</td>
									
								</tr>
								
								</table>
								</div>
								</div>							
					
            </div>  
          <div id="folderTab">   
            	<div class="card" style="width: 95%; padding-left: 0px;">
					<div class="card-body card-padding" style="background-color:#EBEBEB;margin-bottom: 20px;">    
						<div style="padding: 10px; min-height: 360px;" align="center" width= "100%">
							<div style="float: left;width:100%"><h4 class="tableHeader" style="padding-top: 10px;padding-bottom: 10px;"><i class="zmdi_large zmdi-folder-outline"></i>Select Folder</h4></div>
								<div style="float: right;margin-top: 15px;margin-right: 10px;">
									<input type="text" id="foltxt" placeholder="Search" style="width: 330px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onkeyup="javascript:searchFolSel();"/>
								
									<input id="folderNameFViewValue" name="folderNameFViewValue" value="<%=folderName%>" readonly="readonly" type="text"  size=40>
								</div>
						
								<div class="example" id="expand" style="display: block;">
											<div id="fileTreeDemo_1" class="folderStruct"></div>
								</div>	
								<br><br>
								<div style="float:left;">
									
								</div>
								<div style="float:right;margin-top:10px;">
										<input id="btnContSecond" class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 15px;"  type="button" onclick="javascript:tabContent2()" value="Continue">				
								</div>
						</div>
			 	
				</div> 
			</div></div>    
		<div>        
	           
		<div id="uploadDocTab">
			<div class="card" style="width: 95%;padding-left: 0px;">
					<div class="card-body card-padding" style="background-color:#EBEBEB;margin-bottom: 20px;">    
						<div style="padding: 10px; min-height: 360px;" align="center" width= "100%">
						
					
						<h4 class="tableHeader" style="padding-bottom: 10px;padding-top: 10px;"><i class="zmdi_large zmdi-cloud-upload"></i>Upload Document</h4>			
						<table align="center" width= "100%" >
								
							<tr valign="top">
								<td><p>To add a document, click the Add File button after downloading the document.
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
										<input type="hidden" id ="actualFileName" name="actualFileName" value="<%=actualFileName %>"/>
										<input type="hidden" id ="folderval" name="folderval" value="<%=folderval %>"/>
										
										<input type="hidden" id ="fileName" name="fileName" value="<%=fileName%>"/>
										<input type="hidden" id ="docId" name="docId" value="<%=docId%>"/>
									
									
									</td>
									<td>
										<input id="file" class="btn btn-success waves-effect waves-button waves-float" name="file" type="file" size="40" onchange="javascript:getFilePath();" onClick="javascript:enable();" style="display:inline">										
									</td>
								<td>
								
								 	<input id="attach" class="btn btn-primary waves-effect waves-button waves-float" name="attach" type="submit" onClick="return check1();" value="Add New File" disabled="disabled">
								</td>
								<td colspan="3">
									<div class="messagewindow" id="messagewindow"
										style="DISPLAY: none; MARGIN: 20px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 60%; z-index: 4; text-align: center;">
										<h4>
											<i class="zmdi_large zmdi-rotate-right zmdi-hc-spin"></i> Uploading file.. Please wait.
										</h4>
										<!-- <IMG src="images/progress.gif" width="32" height="32" alt="" />-->
									</div>
								</td>
								</tr>
								<tr>
									<td colspan="3">
									<%String extension=filePath.substring(filePath.lastIndexOf(".") + 1);
									
									System.out.println("extension"+extension);
									if(extension.toLowerCase().equalsIgnoreCase("doc") || extension.toLowerCase().equalsIgnoreCase("docx")){
									 %>
									<label class="summaryLbl" style="margin-top: 20px;"> View Document <a href="javascript:getpdf('<%=filePath %>');"><img src="./images/doc.png" border="0" height="25px" width="25px"></a></label>
									<%}else if(extension.toLowerCase().equalsIgnoreCase("jpg") || extension.toLowerCase().equalsIgnoreCase("jpeg")){ %>
									<label class="summaryLbl" style="margin-top: 20px;"> View Document <a href="javascript:getpdf('<%=filePath %>');"><img src="./images/jpeg.png" border="0" height="25px" width="25px"></a></label>
									<%}else if(extension.toLowerCase().equalsIgnoreCase("xls") || extension.toLowerCase().equalsIgnoreCase("xlsx")){ %>
									<label class="summaryLbl" style="margin-top: 5px;"> View Document <a href="javascript:getpdf('<%=filePath %>');"><img src="./images/excel_file.png" border="0" height="25px" width="25px"></a></label>
									<%}else{ %>
									<label class="summaryLbl" style="margin-top: 20px;"> View Document <a href="javascript:getpdf('<%=filePath %>');"><img src="./images/pdfViewer.gif" border="0" height="25px" width="25px"></a></label>
									
									<%} %>
									
									</td>
								
								</tr>
								</table>
								</td>
								</tr>
								<tr align="right">
								<td>
								<input id="btnContThird" class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 15px;margin-top:150px;margin-bottom: 20px;"  type="button" onclick="javascript:tabContent3();" value="Continue">				
								
								<!-- <input id="btnContThird" class="buttonContMod" style="margin-top: 170px;" onclick="javascript:tabContent3();" value="Continue" type="button"/>-->
								</td>
								</tr>
								</table>
								</div>
							</div></div>
					</div>
            </div> 
            
            
            
             <div id="summaryTab">
             <div class="card" style="width: 95%;padding-left: 0px;">
					<div class="card-body card-padding" style="background-color:#EBEBEB;margin-bottom: 20px;">    
						<div style="padding-left: 10px; padding-right: 10px; min-height: 360px;" align="center">

					<!-- <h4 class="tableHeader"><i class="zmdi_large zmdi-flip-to-back"></i>Review</h4>-->  
					
		            	<table align="center" width= "710" >
							<tr height= '55'  align="right">
							<td style='font-size:14px;font-family: Arial;'>&nbsp;
							
							<%if(success.equalsIgnoreCase("error") || FileSize.equalsIgnoreCase("error_lagre_file_size")){ %>
									<input type="button" name="save" value="Save" disabled="disabled" class="btn btn-success waves-effect waves-button waves-float"> 
								    <input type="button" name="saveandnew" value="Save & Add New"  disabled="disabled" class="btn btn-success waves-effect waves-button waves-float"> 			
								<%} else { %>
									<input type="button" name="save" value="Save" onClick="javascript:confirmAttach()" class="btn btn-success waves-effect waves-button waves-float"> 
									<input type="button" name="saveandnew" value="Save & Add New"  onClick="javascript:confirmAttach1();" class="btn btn-success waves-effect waves-button waves-float"> 			
									
								<%} %>
								
								<input type="button" name="cancel" value="Cancel"  onClick="javascript:onCancel();" class="btn btn-warning waves-effect waves-button waves-float"></td>
					        </tr>
				       </table>
					
          					
								<table align="center" width= "100%" style="padding-left: 20px;padding-right:20px;background-color: #FFF">
							<tr>
								<td colspan="2"><h4 class="tableHeader" style="padding-top: 10px;padding-bottom: 10px;">Please review entered values and save the document.</h4></td>
							</tr>	
							<tr valign=top>
							<td style="width: 40%">
								<div style="float: left;width: 100%">
								<table style="width: 100%;">
									<tr>
										<td style="border-bottom:1px solid #CCC">
										<h3 class="header" style="display: inline-block;">Property ID : </h3> 
								  		<label class="summaryLbl" id="propertytypeLbl"></label>
									  	</td>
								  	<tr>
									  	<td style="border-bottom:1px solid #CCC">								
									  	<h3 class="header" style="display: inline-block;">Document Type : </h3>
								  	<label class="summaryLbl" id="doctypeLbl"></label>
									  	</td>
								  	</tr>
								  	<tr>
									  	<td style="border-bottom:1px solid #CCC">
									  	<h3 class="header" style="display: inline-block;">Folder : </h3> 
									  	<label class="summaryLbl" id="folderLbl"></label>
									  	</td>
									</tr>
								</table>
								</div>
								</td>
								<td style="width: 40%">
								<div class="or-spacer-vertical right">  
									<div class="mask">
									</div>
								</div>
								<div id="defaultProfile" style="float: right;width: 90%">
									<table width="350" cellpadding="0" cellspacing="0">
								<tr valign="top">
									<td width="200" style="border-bottom:1px solid #CCC">
										<h3 class="header">Index Type</h3>
									</td>
									<td width="200" style="border-bottom:1px solid #CCC" >
										<h3 class="header">Value   </h3>
									</td>
								</tr>
									
								<tr>
									<td><label class="summaryLbl" id="indexTypeLbl"></label></td>
									<td><label class="summaryLbl" id="indexValueLbl"><%=indexval %></label></td>
								</tr>
								<!-- tr>
									<td><label class="summaryLbl" id="indexType1Lbl"></label></td>
									<td><label class="summaryLbl" id="indexValue1Lbl"><%//=indexval1 %></label></td>
								</tr>
								<tr>
									<td><label class="summaryLbl" id="indexType2Lbl"></label></td>
									<td><label class="summaryLbl" id="indexValue2Lbl"><%//=indexval2 %></label></td>
								</tr>
								<tr>
									<td><label class="summaryLbl" id="indexType3Lbl"></label></td>
									<td><label class="summaryLbl" id="indexValue3Lbl"><%//=indexval3 %></label></td>
								</tr>
								<tr>
									<td><label class="summaryLbl" id="indexType4Lbl"></label></td>
									<td><label class="summaryLbl" id="indexValue4Lbl"><%//=indexval4 %></label></td>
								</tr-->
								
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
								</div></div>
            	</div>
            </div> 
        </form>
        
        
    </div>
    



<script language="javascript">
 var fView = "fView";

$('document').ready(function(){

	<%-- if ( "PRODUCTION" === '<%= appuserrole %>') --%>
	if( '<%= appuserrole %>'.toUpperCase().indexOf("PRODUCTION") != -1)
	{
		$('#tab-1').hide();
	} 
	
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
function openFolders(){
  var closedFolders = $(".directory:not(.expanded) a");
  if(closedFolders.length > 0) {
    window.setTimeout(openFolders, 10);
    closedFolders.click();
    }
		setFolder();     	

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
	
	 setHeader('addDoc.jsp');
	 //Initialize slider menu
     $('#simple-menu').sidr();
     
  	$('.child').hide();
  	$('.parent').click(function() {
	 	$('.child').slideUp();
	 	$(this).find('ul').slideToggle();
  	});
  	$('#docManagementLi').click();	
	  	
	  	
	 var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	 for (var i = 0; i < array_of_li.length; i++) {
	 if(i == 2)
		array_of_li[i].setAttribute("class", "active");	
		
	}
		getdropdowns();
		
	//checkIfDone();
}

var index = new Array();
var documentdata = new Array();
var propertydata = new Array();

function getdropdowns()
{	  
    var comid = '<%= cid %>';
      
           $.ajax({
	            type: "GET",
	            url:"GetPropertyDropdown?comid="+comid,
	            dataType: "json",
	            success: function (data) {
	                $.each(data.propertyData,function(i,obj)
	                {
	                 	var div_data="<option value="+obj.value+">"+obj.text+"</option>";
	                	$(div_data).appendTo('#propertytype'); 
	                });
	                
                	openFolders();
                	
	               }
	          });
           $.ajax({
            type: "GET",
            url:"GetDocTypeDropdown?comid="+comid,
            dataType: "json",
            success: function (data) {
                $.each(data.docTypeData,function(i,obj)
                {
                 	var div_data="<option value="+obj.value+">"+obj.text+"</option>";
                	$(div_data).appendTo('#doctype'); 
                });
               		
                }
          });
           $.ajax({
            type: "GET",
            url:"GetIndexTypeDropdown?comid="+comid,
            dataType: "json",
            success: function (data) {
                $.each(data.indexTypeData,function(i,obj)
                {
                 	var div_data="<option value="+obj.value+">"+obj.text+"</option>";
                	$(div_data).appendTo('#indextype');
                	             	 
                	
                });              	
                 
                }
          });
          
          
}
/*function getdropdowns() {
var queryString = "compid="+compid;

if(xmlhttp) { 
    // xmlhttp.open("GET",URL,true); 
    xmlhttp.open("POST","GetDropdownOptions",true); 
    xmlhttp.onreadystatechange  = handleServerResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send(queryString);
  } 
}
*/

function handleServerResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	parseData(xmlhttp.responseText);
     	openFolders();
     	
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
function setFolder(){
   	//document.getElementById("folderNameFView").value = '<%//=folderName%>';

}

function validateForm()
{	
	
	//Check if doctype field contains value
	if(document.getElementById('doctype').value == "" ) 
	{
		tabContent0();		
		jAlert("Please Select Document Type Field.","Document Type Selection");
		return false;		
	}//Check if index type field contains value
	else if(document.getElementById('indextype').value == "" && document.getElementById('indextype1').value == ""
	   && document.getElementById('indextype2').value == "" && document.getElementById('indextype3').value == "" ) 
	{
		tabContent0();		
		jAlert("Please Select Index Type.","Index Type Selection");
		return false;		
	}//Check if value field contains value
	else if(document.getElementById('value').value == "" && document.getElementById('value1').value == ""
	        && document.getElementById('value2').value == "" && document.getElementById('value3').value == "" ) 
	{
		tabContent0();
		$('#flip-container').quickFlipper({ }, 0, 1);
		setActive(0);
		jAlert("Please Enter Index Value.","Index Value");
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
	
	
	var fileNameExt = id.substr(id.lastIndexOf('.') + 1);
		if (fileNameExt == "doc" || fileNameExt == "docx"
				|| fileNameExt == "xlsx" || fileNameExt == "xls"
				|| fileNameExt == "jpg" || fileNameExt == "jpeg") {

			var Text = "./DisplayText?id=" + id + "&userid=" + user + "&comid="
					+ com + "&sessionid=" + session + "&userName=" + userName;
			//window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
			var popout = window
					.open(
							Text,
							'_blank',
							'toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=15000, top=15000, width=50, height=50, visible=none',
							'');

			window.setTimeout(function() {
				popout.close();
			}, 8000);

		}

		else {

			var Text = "./DisplayPdf?id=" + id + "&userid=" + user + "&comid="
					+ com + "&sessionid=" + session + "&userName=" + userName;
			window
					.open(
							Text,
							'',
							'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');

		}
	}
	function onCancel() {
		var sessionid = '<%=sessionid%>';
	window.location="dashboard.jsp?sessionid="+sessionid;
}

function tabContent0()
{
		
		 $('#flip-container').quickFlipper({ }, 0, 1);
		 document.getElementById('uploadDocTab').style.display = 'none';
		
		
}
function tabContent1()
{		
		 $('#flip-container').quickFlipper({ }, 1, 1);
		 setActive(1);		 
		 document.getElementById('uploadDocTab').style.display = 'none';		 	
		
}
function tabContent2()
{
		  $('#flip-container').quickFlipper({ }, 2, 1);
		  setActive(2);	  
		  document.getElementById('uploadDocTab').style.display = 'block';	
}
function tabContent3()
{
		 		 
		 /*document.getElementById('folderLbl').innerHTML  = document.getElementById('folderNameFView').value;
		 document.getElementById('doctypeLbl').innerHTML  = document.getElementById('doctype').options[document.getElementById('doctype').selectedIndex].text;
		 document.getElementById('propertytypeLbl').innerHTML  = document.getElementById('propertytype').options[document.getElementById('propertytype').selectedIndex].text;
		 
		 var indextype = document.getElementById('indextype');
		 var indextype1 = document.getElementById('indextype1');
		 var indextype2 = document.getElementById('indextype2');
		 var indextype3 = document.getElementById('indextype3');
		 var indextype4 = document.getElementById('indextype4');
		 if(indextype != null)
		 {
		 		 document.getElementById('indexTypeLbl').innerHTML  = document.getElementById('indextype').options[document.getElementById('indextype').selectedIndex].text;
		 }
		  if(indextype1 != null)
		 {
		 	document.getElementById('indexType1Lbl').innerHTML  = document.getElementById('indextype1').options[document.getElementById('indextype1').selectedIndex].text;
		 	
		 }
		  if(indextype2 != null)
		 {
		 	document.getElementById('indexType2Lbl').innerHTML  = document.getElementById('indextype2').options[document.getElementById('indextype2').selectedIndex].text;
		 }
		  if(indextype3 != null)
		 {
		 	document.getElementById('indexType3Lbl').innerHTML  = document.getElementById('indextype3').options[document.getElementById('indextype3').selectedIndex].text;
		 }
		  if(indextype4 != null)
		 {	 
		 	document.getElementById('indexType4Lbl').innerHTML  = document.getElementById('indextype4').options[document.getElementById('indextype4').selectedIndex].text;
		 }	 
		 
		// document.getElementById('indexValueLbl').innerHTML  = document.getElementById('value').value;*/
		document.getElementById('folderLbl').innerHTML  = document.getElementById('folderval').value;
		 document.getElementById('doctypeLbl').innerHTML  = document.getElementById('doctype').options[document.getElementById('doctype').selectedIndex].text;
		 document.getElementById('propertytypeLbl').innerHTML  = document.getElementById('propertytype').options[document.getElementById('propertytype').selectedIndex].text;
		 document.getElementById('indexTypeLbl').innerHTML  = document.getElementById('indextype').options[document.getElementById('indextype').selectedIndex].text;
		 document.getElementById('indexValueLbl').innerHTML  = document.getElementById('value').value;
		 
		
		 
		 $('#flip-container').quickFlipper({ }, 3, 1);
		 setActive(3);		 
		 document.getElementById('uploadDocTab').style.display = 'none';
}
function setPropertyFolder(property) {
   // document.getElementById("folderNameFView").value = "/"+property;
}
function setActive(tab)
{
	var array_of_li =  document.querySelectorAll("ul#flip-navigation li");
	for (var i = 0; i < array_of_li.length; i++) {		
		array_of_li[i].setAttribute("class", "");	
		if(i == tab){
			array_of_li[i].setAttribute("class", "selected");	
			
		}
	}
}
function clearFields()
{

	document.getElementById('value').value = "";
	
	document.getElementById("indextype").selectedIndex = "0";
	
	document.getElementById("doctype").selectedIndex = "1";
	document.getElementById("propertytype").selectedIndex = "1";	
}
function searchSel() 
    {
      var input = document.getElementById('realtxt').value.toLowerCase();
       
          len = input.length;
          output = document.getElementById('propertytype').options;
      for(var i=0; i<output.length; i++)
          if (output[i].text.toLowerCase().indexOf(input) != -1 ){
          output[i].selected = true;
          //document.getElementById("folderNameFView").value = "/"+output[i].text;
          break;
          }
      if (input == '')
        output[1].selected = true;
    }
    
 function searchFolSel()
 {
 	      var input = document.getElementById('foltxt').value.toLowerCase();
 	      len = input.length;
 	      output = $("div.folderStruct a");
 	      for(var i=0; i<output.length; i++){
 	      //alert("output "+$(output[i]).attr('rel').toLowerCase()+" input "+input);
          if ($(output[i]).attr('rel').toLowerCase().indexOf(input) != -1 ){
          	//document.getElementById("folderNameFView").value = ""+$(output[i]).attr('rel');
          	$(output[i]).css("background-color", "#03A9F4");
            $(output[i]).css("color", "#FFFFFF");
        	$(output[i]).focus();
            break;
          }
          else{
          		$(output[i]).css("background-color", "#FFFFFF");
          		$(output[i]).css("color", "#0B3861");
          		//document.getElementById("folderNameFView").value = "";         
          		//$(output[i]).hide();
          }
          }
          if (input == '')
            for(var i=0; i<output.length; i++){
        		 $(output[i]).css("background-color", "#FFFFFF");
          		$(output[i]).css("color", "#0B3861");
 			}
 
 }

</script>

</body>

</html>
