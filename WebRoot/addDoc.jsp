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
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>
		
		<script type="text/javascript" src="js/jquery.popupoverlay.js" ></script>	
		
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
  System.out.println("***addDoc.jsp***"); 
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
 // String folderPatteren=request.getSession().getAttribute("folderPatterens").toString();
  //System.out.println("folderPatteren--->"+folderPatteren.replaceAll("\\[|\\]", ""));  
  
   List<String> list=new ArrayList<String>();
  
  String folderPatteren=null;
  
  Map accessPatteren= (Map)request.getSession().getAttribute("accessPatteren");
  System.out.println("accessPatteren--->"+accessPatteren);
  
  Iterator entries = accessPatteren.entrySet().iterator();
  while (entries.hasNext()) {
      Map.Entry entry = (Map.Entry) entries.next();
     if(!entry.getValue().toString().equalsIgnoreCase("ReadOnly")){
    	  list.add((String)entry.getKey());
      
  }
  }
  folderPatteren=list.toString();  
  System.out.println("folderPatteren--->"+folderPatteren.replaceAll("\\[|\\]", "")); 

  
  String appuserrole = (String)request.getSession().getAttribute("appuserrole");
  System.out.println("appuserrole "+appuserrole);
  
  String lastName = "";
  String firstName = "";
  
  HashMap hashMap = userInformation.getUserInformation(request);
 
  lastName = (String) hashMap.get("lastName");
  if(lastName== null) lastName="";
  firstName = (String) hashMap.get("firstName"); 
  if(firstName== null) firstName="";  
  
  java.util.Date today = new java.util.Date();
  java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
  List<String> html = folderBean.getPropertyNameGridHTML(""+cid,folderPatteren.replaceAll("\\[|\\]","").replaceAll(",\\s","|")); 
  request.getSession().setAttribute("folderData", html);		
  String indexType = request.getSession().getAttribute("defaultIndex").toString();
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
  
	<div id="flip-tabs" >  
		<div class="tabbox">		
	        <ul id="flip-navigation" >  
	              <li class="selected"><a href="#content" onclick="javascript:tabContent0()" id="tab-0"  >Document Information<!-- <img id="docInfoImg" src="images/docInfoActive.png" width="195px;" height="60px;"/>--></a></li>  
	            <li><a href="#folderTab" id="tab-1" onclick="javascript:tabContent1()">Folder Information</a></li>  
                <li><a href="#uploadDocTab" id="tab-2"  onclick="javascript:tabContent2()">Upload Document<!-- <img id="uploadDocImg" src="images/uploadDoc1.png" width="195px;" height="60px;"/>--></a></li>  
	            <li><a href="#summaryTab" id="tab-3" onclick="javascript:tabContent3()">Review <!-- <img id="reviewImg" src="images/Review1.png" width="195px;" height="60px;"/>--></a></li>                       
	        </ul>  
	     </div>
        
        <form name="upload" method="post" action="AddDocument" enctype="multipart/form-data">
        
        <div id="flip-container" >  
            
					<div  id="content"> <!--  Content for First tab -->	
					<!-- <div class="ui-box ui-box-has-header box-primary" id="transaction-log">
						<div class="ui-box-heading">
							<h2 class="ui-box-heading-title">Select the type of document and index type</h2> 
								
							</div>
							<div class="ui-box-content">
								<table id="transactiontimeline"> 
									<thead> <tr> <th>Type</th> <th>Index</th> <th>Index Value</th></tr></thead> 
									<tbody> 
									<tr class="odd"> 
										<td width="54%"><label for="">&nbsp;&nbsp;Search Property:&nbsp;&nbsp;</label><input type="text" id="realtxt" style="width: 330px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onkeyup="javascript:searchSel();"/></td> 
										<td width="23%"> <select  id="indextype" name="indextype" style="width: 150px" class="selectText">
											<option value=""></option>
											</select>
										</td> 
										<td width="23%"><input id="value" name="value" type="text" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
									</tr>
									<tr class="odd"> 
										<td> <label for="">&nbsp;&nbsp;Property Type:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <select style="width:330px;" name="propertytype" id="propertytype" class="selectText" onchange="setPropertyFolder(this.options[this.selectedIndex].innerHTML)">
								    		<option value=""></option>
								  			</select>
								  		</td> 
										<td><select  id="indextype1" name="indextype1" class="selectText" style="width: 150px">
											<option value=""></option>
										</select>
									</td> 
									<td>									
										<input id="value1" name="value1" type="text" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);">
									</td>
									</tr>
									<tr class="odd"> 
										<td> <label for="">&nbsp;&nbsp;Document Type:&nbsp;&nbsp;</label> <select  name="doctype" id="doctype" class="selectText" style="width:330px;">
								    <option value=""></option>
								  </select>	</td> 
										<td><select  id="indextype2" name="indextype2" class="selectText" style="width: 150px">
											<option value=""></option>
											</select>
										</td> 
										<td><input id="value2" name="value2" type="text" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
									</tr>
									<tr class="odd"> 
										<td></td> 
										<td>
										<select  id="indextype3" name="indextype3" class="selectText" style="width: 150px">
											<option value=""></option>
										</select>
										</td> 
										<td><input id="value3" name="value3" type="text" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
									</tr>
									<tr class="odd"> 
										<td></td> 
										<td>
											<select  id="indextype4" name="indextype4" class="selectText" style="width: 150px">
												<option value=""></option>
											</select>
										</td> 
										<td><input id="value4" name="value4" type="text" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
									</tr>
											
									</tbody></table></div></div>
									<div id="trackTransactionHeader" class="page-navigation clearfix">
										 <div class="ui-box-heading-sub-header"> 
										 <span class="authorized-on"></span> 
										 <span class="sms-block">
										 <input id="btnContFirst" class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 15px;"  type="button" onclick="javascript:tabContent1()" value="Continue">
										<input id="clear" name="clear" class="btn btn-warning waves-effect waves-button waves-float" style="margin-right: 25px;" type="button" onClick="clearFields()" value="Clear">											
										 </span> 
										 </div>
								    </div>	-->
						
						
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
								  <select style="width:330px;" name="propertytype" id="propertytype" class="selectText" onchange="setPropertyFolder(this.options[this.selectedIndex].innerHTML)">
								    <option value=""></option>
								  </select>
								  <p></p>
								  <h4 class="header">Document Type</h4>
								  <select  name="doctype" id="doctype" class="selectText" style="width:330px;">
								    <option value=""></option>
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
									<option value=""></option>
								</select></td>
								<td >
									<input id="value" name="value" type="text" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
								</tr>
								
								<!-- tr>
								<td style="padding-top: 20px;">
								<select  id="indextype1" name="indextype1" class="selectText" style="width: 150px">
								<option value=""></option>
								</select></td>
								<td style="padding-top: 20px;">
									<input id="value1" name="value1" type="text" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
								</tr>
								
								<tr>
								<td style="padding-top: 20px;">
								<select  id="indextype2" name="indextype2" class="selectText" style="width: 150px">
								<option value=""></option>
								</select></td>
								<td style="padding-top: 20px;">
									<input id="value2" name="value2" type="text" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
								</tr>
								
								<tr>
								<td style="padding-top: 20px;">
								<select  id="indextype3" name="indextype3" class="selectText" style="width: 150px">
								<option value=""></option>
								</select></td>
								<td style="padding-top: 20px;" >
									<input id="value3" name="value3" type="text" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
								</tr>
								
								<tr>
								<td style="padding-top: 20px;">
								<select  id="indextype4" name="indextype4" class="selectText" style="width: 150px">
								<option value=""></option>
								</select></td>
								<td style="padding-top: 20px;">
									<input id="value4" name="value4" type="text" style="width: 150px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"></td>
								</tr-->
								</table>
								</div>							  
								  </td>
								</tr>
								<tr>
									<td  colspan="2" style="padding-bottom: 20px; padding-top: 20px; text-align: right;">
										<input id="btnContFirst" class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 15px;"  type="button" onclick="javascript:tabContent1()" value="Continue">
										<input id="clear" name="clear" class="btn btn-warning waves-effect waves-button waves-float" style="margin-right: 25px;" type="button" onClick="clearFields()" value="Clear">											
																				
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
					<div class="card-body card-padding" style="background-color:#EBEBEB;">    
						<div style="min-height: 360px;" align="center" width= "100%">
							<div style="float: left;width:100%"><h4 class="tableHeader" style="padding-top: 10px;padding-bottom: 10px;"><i class="zmdi_large zmdi-folder-outline"></i>Select Folder</h4></div>
								<div style="float: right;margin-bottom:5px;margin-right:10px">
								
								<input type="text" id="foltxt" placeholder="Search" style="width: 330px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onkeyup="javascript:searchFolSel();"/>
								
							<input id="folderNameFView" name="folderNameFView" readonly="readonly" type="text"  size=40 onkeypress="setFolderPatteren(this.options[this.selectedIndex].innerHTML)"></div> 
						
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
		<div>        
	           
		<div>
			<div class="card" style="width: 95%;padding-left: 0px;">
					<div class="card-body card-padding" style="background-color:#EBEBEB;margin-bottom: 20px;">    
						<div style="padding: 10px; min-height: 360px;" align="center" width= "100%">
						
					
						<h4 class="tableHeader" style="padding-bottom: 10px;padding-top: 10px;"><i class="zmdi_large zmdi-cloud-upload"></i>Upload Document</h4>			
						<table align="center" width= "100%" >
							
							<tr valign="top">
								<td><p>To add a document, select a file by clicking the Browse button.
								</p></td>
							</tr>
							<tr height="5">
								<td></td>
							</tr>
							<tr valign=top>
								<td>
										<input type="hidden" id ="cid" name="cid" value="<%=cid%>"/>
										<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
										<input type="hidden" id ="confirmParam" name="confirmParam"/>
										<input type="hidden" id ="actualFileName" name="actualFileName"/>
										<input type="hidden" id="checkbox2" name="checkbox2" value="" />
																	
										<input id="file" class="btn btn-success waves-effect waves-button waves-float" name="file" type="file" size="40" onchange="javascript:getFilePath();" onClick="javascript:enable();" style="display:inline">&nbsp;&nbsp;										
										<input type="checkbox" id="checkbox1" name="checkbox1" value="apple" />&nbsp;Do you want to convert this document to PDF?
										
								
								</td>
							</tr>
							<tr height="5">
								<td></td>
							</tr>
							<tr>	
								<td>
								 	<input id="attach" class="btn btn-primary waves-effect waves-button waves-float" name="attach" type="submit" onClick="return check1();" value="Add New File" disabled="disabled">
								</td>
							</tr>
							<tr align="right">
								<td>
									<input id="btnContThird" class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 15px;margin-top:150px;margin-bottom: 20px;"  type="button" onclick="javascript:tabContent3();" value="Continue">				
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
						<div style="padding-left: 10px; padding-right: 10px; min-height: 360px;" align="center" width= "100%">

				<!-- 	<h4 class="tableHeader"><i class="zmdi_large zmdi-flip-to-back"></i>Review</h4>-->  
					<div>  
		            	<table align="center" width= "710" >
							<tr height= '55'  align="right">
							<td style='font-size:14px;font-family: Arial;'>&nbsp;
																
								<input type="button" name="save" value="Save" disabled="disabled" class="btn btn-success waves-effect waves-button waves-float"> 
								<input type="button" name="saveandnew" value="Save & Add New"  disabled="disabled" class="btn btn-success waves-effect waves-button waves-float"> 					
								<input type="button" name="cancel" value="Cancel"  onClick="javascript:onCancel();" class="btn btn-warning waves-effect waves-button waves-float"></td>
					        </tr>
				       </table>
					</div>
          				
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
									<td><label class="summaryLbl" id="indexValueLbl"></label></td>
								</tr>
								<!-- tr>
									<td><label class="summaryLbl" id="indexType1Lbl"></label></td>
									<td><label class="summaryLbl" id="indexValue1Lbl"></label></td>
								</tr>
								<tr>
									<td><label class="summaryLbl" id="indexType2Lbl"></label></td>
									<td><label class="summaryLbl" id="indexValue2Lbl"></label></td>
								</tr>
								<tr>
									<td><label class="summaryLbl" id="indexType3Lbl"></label></td>
									<td><label class="summaryLbl" id="indexValue3Lbl"></label></td>
								</tr>
								<tr>
									<td><label class="summaryLbl" id="indexType4Lbl"></label></td>
									<td><label class="summaryLbl" id="indexValue4Lbl"></label></td>
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
								</div></div>
            	</div>
            </div> 
            
            
        </div>  
        <input type="hidden" id="defaultIndexType" value="<%=indexType%>" />
        
        </form>
        
        
    </div>



<script language="javascript">
 var fView = "fView";

$('document').ready(function(){
	  	
		displayFolderStructure();
		
	<%-- alert('<%= appuserrole %>'); --%>
		
		<%-- if ( "PRODUCTION" === '<%= appuserrole %>')  --%>
		if( '<%= appuserrole %>'.toUpperCase().indexOf("PRODUCTION") != -1)
		{
			$('#tab-1').hide();
		} 
		
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
		        displayFolderStructure();                
		        
        }
        else {
                ele.style.display = "block";
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
	setFolderAsProperty();     	

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

function initial_load()
	{
		// Initialize the plugin
        $('#my_popup').popup({color:'#000'});
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
		
	 var data = '<%=html%>';
	    //alert(data);
	    var dataArray = data.split(',');
	   
	    for(var i=0; i< dataArray.length;i++)
	    {
	        if((dataArray[i].split("/").length-1) === 2)
	        {
		       	var str =  dataArray[i];
	        	//alert("Pushing "+ str);
	        	s.push(str);
	        }
	       
	    }  
		getdropdowns();
		
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
	                if(data.propertyData.length > 1)
	                {
                		document.getElementById("propertytype").selectedIndex =1;
                		var selText = document.getElementById("propertytype").options[1].text;		
    					//document.getElementById("folderNameFView").value = "/"+selText;
                	}
                	//openFolders();
                	
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
               		if(data.docTypeData.length > 1)
                		document.getElementById("doctype").selectedIndex =1;
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
                if(data.indexTypeData.length > 1)
                {
                	document.getElementById("indextype").selectedIndex = 1;
                }                
                }
          });
          	//Rearrange the dropdown to display default index at the top
			update_select('indextype');
          
}
/*function getdropdowns() {
var queryString = "compid="+compid;

if(xmlhttp) {
    xmlhttp.open("POST","GetDropdownOptions",true); 
    xmlhttp.onreadystatechange  = handleServerResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send(queryString);
  } 
}*/

function handleServerResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	parseData(xmlhttp.responseText);
     	openFolders();
     	//alert(xmlhttp.responseText);
     }    
     else {
        //alert(xmlhttp.status);
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
	if(document.getElementById("indextype").options.length > 1)
		document.getElementById("indextype").selectedIndex =1;
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
    if(document.getElementById("doctype").options.length > 1)
    	document.getElementById("doctype").selectedIndex =1;
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
    if(document.getElementById("propertytype").options.length > 1)
    {
    	document.getElementById("propertytype").selectedIndex =1;
    	var selText = document.getElementById("propertytype").options[1].text;		
    	document.getElementById("folderNameFView").value = "/"+selText;
    }
}



function addOption(selectbox,text,value )
{
var optn = document.createElement("OPTION");
optn.text = text;
optn.title = text;
optn.value = value;
selectbox.options.add(optn);
}

function setFolderAsProperty()
{
	var propertySelect = document.getElementById("propertytype");
    var property = propertySelect.options[propertySelect.selectedIndex].text;
  	document.getElementById("folderNameFView").value = "/"+property;
}
function enable() {
document.getElementById("attach").disabled=false;
}
function getFilePath()
{
 //alert("This file path"+ document.getElementById("file").value);
 var filePath = document.getElementById("file").value;
 if(filePath.lastIndexOf("\\") > -1)
 {
     filePath = filePath.substr(filePath.lastIndexOf("\\")+1,filePath.length-filePath.lastIndexOf("\\"));
     //alert(filePath);
 }
 document.getElementById("actualFileName").value = filePath;
 var fileNameExt = filePath.substr(filePath.lastIndexOf('.') + 1).toLowerCase();          
            
            if(fileNameExt == "pdf"){
            document.getElementById("checkbox1").disabled=true;
            }
            else{
            document.getElementById("checkbox1").disabled=false;
            }
}

function check1() {
var x = document.getElementById("file").value.toLocaleLowerCase();

var check = document.getElementById("checkbox1").checked;
	if(check == true){
 document.getElementById("checkbox2").value=true;
 }else
 {
  document.getElementById("checkbox2").value=false;
 }
 
 //alert(document.getElementById("checkbox2").value);
// alert(x.lastIndexOf(".pdf")); 
if (x.lastIndexOf(".pdf") != -1
        || x.lastIndexOf(".xls") != -1  || x.lastIndexOf(".xlsx") != -1
        || x.lastIndexOf(".doc") != -1  || x.lastIndexOf(".docx") != -1
        || x.lastIndexOf(".tiff") != -1  || x.lastIndexOf(".tif") != -1
        || x.lastIndexOf(".jpg") != -1 || x.lastIndexOf(".jpeg") != -1) 
{
	var folder = document.getElementById("folderNameFView").value;
	
	//check.setAttribute("checkbox123", check);
	
	//alert(folder);
	//msgbox_visible(true);
	$('#my_popup').popup('show');
    return true;
} else {
    alert("Please upload PDF, Excel, Word, TIFF, JPG files only");
    return false;
}

} 

function onCancel(){
	var sessionid='<%=sessionid%>';
	window.location="dashboard.jsp?sessionid="+sessionid;
}

function tabContent0()
{	
     $('#flip-container').quickFlipper({ }, 0, 1);
  	 //document.getElementById('uploadDocTab').style.display = 'none';	
}
function tabContent1()
{
	<%--  if ( "PRODUCTION" === '<%= appuserrole %>') --%>
	if( '<%= appuserrole %>'.toUpperCase().indexOf("PRODUCTION") != -1)
		{
		 tabContent2();
		}  
	 else{
	 $('#flip-container').quickFlipper({ }, 1, 1);
	 setActive(1);
	 }
	 //document.getElementById('uploadDocTab').style.display = 'none';		 	
		
}
function tabContent2()
{
		 $('#flip-container').quickFlipper({ }, 2, 1);
		 setActive(2);		
}
function tabContent3()
{
		 document.getElementById('folderLbl').innerHTML  = document.getElementById('folderNameFView').value;
		 document.getElementById('doctypeLbl').innerHTML  = document.getElementById('doctype').options[document.getElementById('doctype').selectedIndex].text;
		 document.getElementById('propertytypeLbl').innerHTML  = document.getElementById('propertytype').options[document.getElementById('propertytype').selectedIndex].text;
		 document.getElementById('indexTypeLbl').innerHTML  = document.getElementById('indextype').options[document.getElementById('indextype').selectedIndex].text;
		 document.getElementById('indexValueLbl').innerHTML  = document.getElementById('value').value;
		 /*
		 document.getElementById('indexType1Lbl').innerHTML  = document.getElementById('indextype1').options[document.getElementById('indextype1').selectedIndex].text;
		 document.getElementById('indexValue1Lbl').innerHTML  = document.getElementById('value1').value;
		 
		 document.getElementById('indexType2Lbl').innerHTML  = document.getElementById('indextype2').options[document.getElementById('indextype2').selectedIndex].text;
		 document.getElementById('indexValue2Lbl').innerHTML  = document.getElementById('value2').value;
		 
		 document.getElementById('indexType3Lbl').innerHTML  = document.getElementById('indextype3').options[document.getElementById('indextype3').selectedIndex].text;
		 document.getElementById('indexValue3Lbl').innerHTML  = document.getElementById('value3').value;
		 
		 document.getElementById('indexType4Lbl').innerHTML  = document.getElementById('indextype4').options[document.getElementById('indextype4').selectedIndex].text;
		 document.getElementById('indexValue4Lbl').innerHTML  = document.getElementById('value4').value;
		 */
		 
		 
		 
		 $('#flip-container').quickFlipper({ }, 3, 1);
		 setActive(3);
		 document.getElementById('uploadDocTab').style.display = 'none';

}

function msgbox_visible(val){
	   
 /*  var e = document.getElementById('messagewindow');
   if(val==true){
   		e.style.display = 'block';
   } else {
   		e.style.display = 'none';
   }*/
		   
}

function setPropertyFolder(property) {
  //  document.getElementById("folderNameFView").value = "/"+property;
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
	/*
	document.getElementById('value1').value ="";
	document.getElementById('value2').value ="";
	document.getElementById('value3').value ="";
	document.getElementById('value4').value ="";
	*/
	document.getElementById("indextype").selectedIndex = "0";
	
	/*document.getElementById("indextype1").selectedIndex = "0";
	document.getElementById("indextype2").selectedIndex = "0";
	document.getElementById("indextype3").selectedIndex = "0";
	document.getElementById("indextype4").selectedIndex = "0";
	*/
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
          document.getElementById("folderNameFView").value = "/"+output[i].text;
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
          	document.getElementById("folderNameFView").value = ""+$(output[i]).attr('rel');
          	$(output[i]).css("background-color", "#03A9F4");
            $(output[i]).css("color", "#FFFFFF");
        	$(output[i]).focus();
          
         // $(output[i]).show();
          break;
          }
          else{
          		$(output[i]).css("background-color", "#FFFFFF");
          		$(output[i]).css("color", "#0B3861");
          		document.getElementById("folderNameFView").value = "";         
          		//$(output[i]).hide();
          }
          }
          if (input == '')
            for(var i=0; i<output.length; i++){
        		 $(output[i]).css("background-color", "#FFFFFF");
          		$(output[i]).css("color", "#0B3861");
 			}
 
 }
 function update_select(selectId) 
{
    var selectList = document.getElementById(selectId);
    var selectOptions = selectList.getElementsByTagName('option');    
	var defaultIndex = document.getElementById("defaultIndexType").value;
	
	for (var i = 0; i < selectOptions.length; i++) 
	{		
		var opt = selectOptions[i];
		
		if (selectList.options[i].text === defaultIndex) 
		{
			selectList.removeChild(opt);
			selectList.insertBefore(opt, selectList[0]);
			selectList.selectedIndex = 0;
		}
		
    }	
}
 
</script>


</body>

</html>

