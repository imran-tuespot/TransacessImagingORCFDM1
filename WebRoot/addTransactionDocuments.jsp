<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />

<%@page import="java.util.*"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <script src="js/jquery.tooltipster.min.js" type="text/javascript"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>
		<script src="assets/js/jquery.ui.widget.js"></script>
		<script src="assets/js/jquery.iframe-transport.js"></script>
		<script src="assets/js/jquery.fileupload.js"></script>
		<script src="assets/js/jquery.popupoverlay.js"></script>
		  <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
		<script type="text/javascript" src="https://cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
      <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
       <script type='text/javascript' src='js/CalendarPopup.js'> </script>
     
		    	
		
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" /> 
		
		
	     <!-- Our main JS file -->
		<script src="assets/js/transactionscript.js"></script>
		<link href="assets/css/style.css" rel="stylesheet" />
		
		<link rel="stylesheet" href="css/bootstrap.css"></link>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<link rel="stylesheet" type="text/css" href="css/tooltipster.css" />
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>	
		
		
		
		
	<!-- 	<link rel="stylesheet" href="css/bp/custom_screen.css" type="text/css" media="screen, projection">
      <link rel="stylesheet" href="css/bp/print.css" type="text/css" media="print">
      <link rel="stylesheet" href="css/bp/fancy-type/screen.css" type="text/css" media="screen, projection">-->
		

		<title>TransAccess Imaging</title>
		<style type="text/css">
		
		div#expand{
		display:block;
		width:100%;
		}
		.example {
			float: left;
			
		}
		/* .folderStruct {
			margin-top:20px;
			width: 98%;
			height: 100%;
			border: solid 1px #BBB;
			background: #FFF;
			overflow: auto;
			padding: 5px;
		} */
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
		
		  #flip-tabs{  
		    width:850px;  
		      
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
		
	    #flip-navigation li.selected{
			border-width: 1px;
			border-style: solid;
			border-color: #999 #999 #FFF;			
			border-image: none;
			padding-top:9px;
			background-color: #FF9800;
			border-color: transparent;
			padding-bottom: 11px;
		}
		#flip-navigation li a{  
		    text-decoration:none; padding:10px;
		    margin-right:0px;  
		    color:#333; outline:none;  
		    font-family:roboto;font-size:13px; 
		  /*  pointer-events: none !important;*/
		}  
		#flip-navigation li a:hover{  
		    color:#2196F3;  
		}  
		#flip-navigation li.selected a{  
			height: 25px;
			padding: 4px 11px 15px 9px;
			font-size: 14px;
			letter-spacing: normal;
			text-decoration: none;
			color: #333;
			border-bottom: medium none; 
			background-color: #FFF;
			/*pointer-events: pointer !important;*/
		}  
		.disable{
			pointer-events: none !important;
					}
		.clear{
		pointer-events: none !important;
		}
		#flip-container{    
		    width:850px;  
		    font-family: roboto;
		    font-size:0.8em;  
		    overflow: visible;
			height: auto;
		}  
		.tabBox{
		background-color: #FFF;
		padding: 0px 6px;
		position: relative;
		border-bottom: 1px solid #999;
		height: 27px;
		margin-bottom: 20px;
		margin-top: 20px;
		height: 37px;

		}
	  .isSelected{
	  		height: 25px;
			padding: 4px 11px 15px 9px;
			font-size: 14px;
			letter-spacing: normal;
			text-decoration: none;
			color: #333;
			border-bottom: medium none; 
			background-color: #FFF;
	  }				
		</style>
</head>

<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>


<jsp:include page="includes/sessionHeader.jsp" />


<% 
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  
  String appuserrole = (String)request.getSession().getAttribute("appuserrole");
  System.out.println("appuserrole "+appuserrole);
  javax.naming.Context ctx1 = 	new javax.naming.InitialContext();
		String restURL = (String) ctx1.lookup("java:comp/env/restCommonUrl");
  
   //String folderPatteren=request.getSession().getAttribute("folderPatterens").toString();
   // System.out.println("folderPatteren--->"+folderPatteren.replaceAll("\\[|\\]", ""));
   
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

  
  java.util.Date today = new java.util.Date();
  java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
  //String html = folderBean.getFolderNameGridHTML(""+cid); 
  //request.getSession().setAttribute("folderData", html);	
  
    List<String> html = folderBean.getPropertyNameGridHTML(""+cid,folderPatteren.replaceAll("\\[|\\]","").replaceAll(",\\s","|")); 
  request.getSession().setAttribute("folderData", html);
%>



<body onLoad="initial_load()" >

<div id="slide" style="width:500px">
    <button  style="align:right" class="slide_close btn btn-default">Close</button>
    
<br>
		<img id="imageDisplayArea"  width="100%" height="500px" style="display:none" />
		 <object data="" id="fileDisplayArea" type="application/pdf" align="left" width="100%" height="500px" >
		 
		  <p>It appears you don't have a PDF plugin for this browser.
		  you can <a href="">click here to
		  download the PDF file.</a></p>
		  
		</object> 
		<iframe id="pptdisplayArea" src="" frameborder="0" style="display:none"></iframe>
		<a href="" id="docDisplayArea" src="" >Read the full file</a>

</div> 

<!--- Part1 ---->
		<!-- 	<div id="loadingImage123"
									style="position: absolute; top: 30%; left: 0px; right: 0px; margin: auto; text-align: center">
									<img src="css/images/default.gif" />
								</div> -->
	<div id="flip-tabs" >  
	
		<div class="tabbox" id="tabbox">		
	        <ul id="flip-navigation" >  
	            <li class="selected"><a  href="#content3" onclick="javascript:tabContent3()" id="tab-0"  >Property Information</a></li> 
	            <li class="documentInfo disable" id="documentInfo"><a href="#content" onclick="javascript:tabContentData();javascript:tabContent0();" id="tab-1"  >Document Information</a></li>  
<!-- 	           <li><a href="#folderTab" id="tab-1" onclick="javascript:tabContent1()">Folder Information</a></li>
 -->	            <li class="uploadTab disable" id="uploadTab"><a href="#uploadDocTab" id="tab-2"  onclick="javascript:tabContent2()">Upload Document</a></li>  
	        </ul>  
	     </div>
	     
	    <form name="upload" id="upload" method="post" action="UploadTransactionFiles" enctype="multipart/form-data"  onsubmit="return false;">
        
        <div id="flip-container" >  
        
        <div  id="content3"> <!--  Content for First tab -->		
			<div align="center" style="height: auto; overflow: auto;">
				<div style = "float:left;width:98%;padding-left:20px;padding-top: 15px;">
						<div style="color:black;font-size: 13px;top:50%;">
							<div  class="card-body card-padding" style="padding: 16px 36px 0px;background-color:#EBEBEB;margin-bottom: 20px;">					
							<div style="text-align:center;">
                          <span id="textError" style="color: red;"></span>
                     </div>
								<table class="table" cellspacing="0" >
									<tbody>
										<tr >
											<td style="border-bottom: 0px;border-top:0px !important">Search Property ID </td>
											<td style="border-bottom: 0px;border-top:0px !important;">Property ID <span class="requiredStar">*</span></td>	
										</tr>
										
										<tr style="border-bottom:1px solid #ddd;">	
	          								<td style="border-bottom: 0px;border-top:0px !important">							
								   				 <input type="text" id="realtxt" style="width: 250px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);margin-top:-10px;    margin-bottom: 10px;" onkeyup="javascript:searchSel();"/>
											</td>
											<td style="border-bottom: 0px;border-top:0px !important;">
												<select style="width:250px;margin-top:-10px;    margin-bottom: 10px;" name="propertytype" id="propertytype" class="selectText" onchange="getFhaNumbersbyProperty(this.value);">
										    		<option value="" selected>Select Property</option>
										  		</select>
										  	</td>
								
										</tr>
										
										<tr>
											<td style="border-bottom: 0px;border-top:0px !important;">
											 	<div >Search Property Name</div>
											</td>
											 <td nowrap="" style="border-bottom: 0px;border-top:0px !important">
											 	<div style="text-align: left;">Property Name <span class="requiredStar">*</span></div>
											 </td>
										</tr>
										
										<tr>
											<td style="border-bottom: 0px;border-top:0px !important;">							
								    			<input type="text" id="propertyName" style="width: 250px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);margin-top:-10px" onkeyup="javascript:searchPropertyName();"/>
											</td>
											<td style="border-bottom: 0px;border-top:0px !important;">
												<select style="width:250px;margin-top:-10px;   margin-bottom: 10px;" name="propertyname" id="propertyname" class="selectText" onchange="getFhaNumbersbyProperty(this.value);">
									    			<option value="" selected>Select PropertyName</option>
									  			</select>
										   </td>
										</tr>   
										
										<tr>
											<td style="border-bottom: 0px;border-top:0px !important;">
											 	<div >Search FHA Number</div>
											</td>
											<td nowrap="" style="border-bottom: 0px;border-top:0px !important">
											 	<div style="text-align: left;">FHA Number</div>
											</td>
										</tr>
										
										<tr style="border-bottom:1px solid #ddd;">
											<td style="border-bottom: 0px;border-top:0px !important;">							
							    				<input type="text" id="fhanumber" style="width: 250px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);margin-top:-10px" onkeyup="javascript:searchFhaNumber();"/>
											</td>
											 <td style="border-bottom: 0px;border-top:0px !important;">							
<!-- 							    				<input type="text" id="fhanumber" style="width: 250px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);margin-top:-10px" onkeyup="javascript:searchFhaNumber();"/>
 -->											
 										<select  id="indexvalues"  style="width: 250px;margin-top:-10px" class="selectText">
													<option value="" selected>Select FHA Number</option>
												</select>	
 
 											</td>
											
											
										</tr>
										
										 
										
										
										
										
										     
											<tr>
											<td hidden style="border-bottom: 0px;border-top:0px !important">Default Index Type</td>
											
											</tr>
											                     		
                                       						
									
											<td style="text-align: right;border-bottom: 0px;border-top:0px !important" colspan="3" >
											 	<input id="btnContFirst" class="btn btn-success waves-effect waves-button waves-float btnContFirst" style="margin-right: 15px;"  type="button" onclick="javascript:tabContentData()" value="Continue">

            									 <input id="clear" name="clear" class="btn btn-warning waves-effect waves-button waves-float" style="margin-right: 25px;" type="button" onClick="javascript:clearFields()" value="Clear">										
							
											</td>
											
											<td>
											</td>
											
										</tr>
										
									</tbody>
								</table>
								</div>	
							</div>						
					</div>
            </div> 
            </div>
            
		<div  id="content"> <!--  Content for First tab -->		
			<div align="center" style="height: auto; overflow: auto;">
			 	<!-- div style="float: left;width:25%">
					<div class="example" id="expand" style="display: block;">
									<div id="fileTreeDemo_1" class="folderStruct"></div>
					</div>	
				</div--> 
				<div style = "float:left;width:98%;padding-left:20px;padding-top: 15px;">
						<div style="color:black;font-size: 13px;top:50%;">
							<div  class="card-body card-padding" style="padding: 16px 36px 0px;background-color:#EBEBEB;margin-bottom: 20px;">			
							<div style="text-align:center;">
                          <span id="textError" style="color: red;"></span>
                     </div>
                    <div style="text-align:left;border-bottom: 2px solid #ccc;">
					<!-- 	<p style="color: #0b3861;padding: 5px 0px;">Property Name</p><p style="color: #0b3861;padding: 0px 0px;" id="propName"/>
						<p style="color: #0b3861;padding: 5px 0px;">Property Id</p><p style="color: #0b3861;padding: 0px 0px;" id="propId"/>
						
						<p style="color: #0b3861;padding: 5px 0px;">FHA Number</p><p style="color: #0b3861;padding: 0px 0px;" id="fhaNum"/> -->
						<div class="f-family" ><b>Property Id  : </b> <label id="propName"></label></div>
					<div class="f-family" ><b>Property Name    : </b> <label id="propId"></label></div>
					<div class="f-family" ><b>FHA Number       : </b> <label id="fhaNum"></label></div>
					</div>
								<table class="table" cellspacing="0" >
									<tbody>
																			
										
										<tr id="folderNameFViewDataone">
											<td style="border-bottom: 0px;border-top:0px !important">Folder Name</td>
											
											<td style="border-bottom: 0px;border-top:0px !important"> 
											<!-- 	<input id="folderNameFView" name="folderNameFView"  type="text"  size=41 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" >
											 -->	
											 	<select style="width:250px;margin-top:-10px" name="folderNameFViewData" id="folderNameFViewData" class="selectText">
									    			<option value=""></option>
									  			</select>
									  			<input type="hidden" id ="userName" name="userName" value="<%=appuserrole%>"/>
									  			<input type="hidden" id ="filecount" name="filecount">
											</td>
											<!-- <td>
												<input type="checkbox" id="chkResetFolder" name = "chkResetFolder" onclick="resetFolder(this)"/>&nbsp;&nbsp;Reset Folder
											</td> -->
										</tr>
										
									
											<tr>
												<div style="text-align:center;">
                                              <span id="textError1" style="color: red;"></span>
                                           </div>
											<td hidden style="border-bottom: 0px;border-top:0px !important">Default Index Type</td>
											</tr>
											<tr>
											<td hidden style="border-bottom: 0px;border-top:0px !important">
											<select  id="indextype"  style="width: 250px" class="selectText">
													<option value=""></option>
												</select>	
											</td>
											
											
											
                                       		</tr>
                                       		
                                       						
										<tr>
											<td nowrap="" style="border-bottom: 0px;border-top:0px !important">Transaction Type <span class="requiredStar">*</span></td>
											<td nowrap="" style="border-bottom: 0px;border-top:0px !important">
											 <div style="text-align: left;margin-left: 95px;">Default Document Type</div>
											</td>
											</tr>
											<tr>
											<td style="border-bottom: 0px;border-top:0px !important"><select  name="transactiontype" id="transactiontype" class="selectText" style="width:250px;margin-top:-10px">
								    				<option value="" selected>Select Transaction Type</option>
								  				</select>	
								  					
											</td>
										
												<td style="border-bottom: 0px;border-top:0px !important;text-align:right;"><select  id="doctype"  style="width: 250px;margin-top:-10px" class="selectText setwidth">
													<option value="" selected> Select Document Type </option>
												</select>	
										  
										</td>	
										   
									     
										
										</tr>
										<tr >
											<td style="border-bottom: 0px;border-top:0px !important"></td>
											<td nowrap="" style="border-bottom: 0px;border-top:0px !important">
											 <div style="text-align: left;margin-left: 95px;">Transaction Status </div>
											</td>
																				
										</tr>
										<tr>	
<!--           								<td style="border-bottom: 0px;border-top:0px !important"></td>
 -->								
 								<td style="border-bottom: 0px;border-top:0px !important;text-align:right;" ></td>
 
								<td style="border-bottom: 0px;border-top:0px !important;text-align:right;"><select  id="transactionStatus"  style="width: 250px;margin-top:-10px" class="selectText">
<!-- 												<option >Approved</option>								 -->
<!-- 												<option >Denied</option>	 -->
<!-- 												<option >Approved with Changes</option> -->
												</select>
										  
										</td>
																  					
								
								</tr>
								<tr>
								<td style="border-bottom: 0px;border-top:0px !important"></td>
									<td nowrap="" style="border-bottom: 0px;border-top:0px !important">
									 <div style="text-align: left;margin-left: 95px;">Transaction Date</div>
									</td>
								</tr>
									
								<tr>	
								
								<td style="border-bottom: 0px;border-top:0px !important;text-align:right;"></td>
								<td style="border-bottom: 0px;border-top:0px !important;text-align:right;">							
							    	<input type="text" name="transactionDate" id="transactionDate" style="width: 250px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);margin-top:-10px;    margin-bottom: 10px;"/>
								</td>
								</tr>
								
								<tr>
								<td style="border-bottom: 0px;border-top:0px !important"></td>
									<td nowrap="" style="border-bottom: 0px;border-top:0px !important">
									 <div style="text-align: left;margin-left: 95px;"></div>
									</td>
								</tr>
								
								<tr>	
								
								<td style="border-bottom: 0px;border-top:0px !important;text-align:right;"> </td>
								<td style="border-bottom: 0px;border-top:0px !important;text-align:right;"></td>
								</tr>
								
											<td style="text-align: right;border-bottom: 0px;border-top:0px !important" colspan="3" >
											 	<input id="btnContFirst" class="btn btn-success waves-effect waves-button waves-float btnContFirst" style="margin-right: 15px;"  type="button" onclick="javascript:tabContent2()" value="Continue">

            									 <input id="clearDocInfo" name="clear" class="btn btn-warning waves-effect waves-button waves-float" style="margin-right: 25px;" type="button" onClick="javascript:clearDocInfoFields()" value="Clear">										
							
											</td>
											
											<td>
											</td>
											
										</tr>
										
									</tbody>
								</table>
											 
								
								
							
								</div>
								</div>	
							</div>						
					</div>
            </div> 
            
             
		
		        <div>        
	           
		<div>
	           
			<div style="padding: 10px; min-height: 390px;" align="center" width= "100%">
			 	 <div style=" position: absolute;top: 28px;z-index: 99;font-size: 12px;text-align: left;margin-left: 18px;">
					<div class="f-family" ><b>Property Id : </b> <label id="propertyIdData"></label></div>
					<div class="f-family" ><b>Property Name : </b> <label id="propertyNameData"></label></div>
					<div class="f-family" ><b>FHA Number  : </b> <label id="fhaNumberData"></label></div>
				</div> 
					<!-- <h4 class="tableHeader"><i class="zmdi_large zmdi-cloud-upload"></i>Upload Documents</h4>-->			
						<table align="center" width= "100%" >
																
							<tr valign=top>
							   
								<td>
								 	
								<div id="drop" class="col-sm-12">
												<img alt="" src="" class="uploadimage-dragndrop"/>
												<div class="uploadimage-text">
								    				Drag files here
												</div>
												<div style="color:black;font-size: 12px;">				
												    Or, if you prefer...				
												</div>
												<a id="browse_btn" class="btn btn-success btn-s">Browse</a>
												
												<a id="reset_btn" class="btn btn-warning btn-s"  >Reset</a>
																
												
											    <input type="file" id="files" name="files" multiple />		
											   													
										</div>
										
											<ul id="uploadedFiles" class="col-sm-12">																						
														                
											</ul>			
								</td>
								</tr><tr>
							<td>
								<div class="col-sm-12 pull-right"
									style="overflow: auto; padding-top: 10px; padding-left: 8px;height:60px;right:8%;display:inline-block;">
<!-- 									onclick="waitingDialog.show();"
 -->									<button id="upload_btn" class="btn btn-success " 
										style="display:none;position: absolute;top: 25px;">
										<i class="fa fa-cloud-upload fa"></i> &nbsp;Upload
									</button>
									<button id="cancel_btn" class="btn btn-warning"
										onClick="javascript:onCancelled()"
										style="display:none;position: absolute;top: 25px;margin-left:58%;background-color:#FF8C00;">Go To Property Information</button>
								</div>
							</td>
						</tr>
								
                   
								</table>
								 
								
								
								</div>
								</div></div>
					
       
        </div>  
      <div id="folderTab">   
            	<div class="card" style="width: 95%; padding-left: 0px;">
					<div class="card-body card-padding" style="background-color:#EBEBEB;">    
						<div style="min-height: 360px;" align="center" width= "100%">
							<div style="float: left;width:100%"><h4 class="tableHeader" style="padding-top: 10px;padding-bottom: 10px;"><i class="zmdi_large zmdi-folder-outline"></i>Select Folder</h4></div>
								<div style="float: right;margin-bottom:5px;margin-right:10px">
								
								<input type="text" id="foltxt" placeholder="Search" style="width: 330px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onkeyup="javascript:searchFolSel();"/>
								
							<input id="folderNameFView" name="folderNameFView" readonly="readonly" type="text"  size=40 onkeypress="setFolderPatteren(this)"></div> 
						
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
        
        <input type="hidden" id ="cid" name="cid" value="<%=cid%>"/>
		<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
		
		<%javax.naming.Context ctx = new javax.naming.InitialContext();
								String uploadFileSize = (String) ctx
										.lookup("java:comp/env/uploadFileSize");%>
		 
		<input type="hidden" id ="uploadFileSize" name="uploadFileSize" value="<%=uploadFileSize%>"/>
        </form>
     
          	 
        
    </div>


<script language="javascript">
 var fView = "fView";
var curtab=1;
$('document').ready(function(){
	
/* $('#card').tooltip('show') */;

displayFolderStructure();
getTransactionType()

<%-- alert('<%= appuserrole %>'); --%>

<%--  if ( "PRODUCTION" === '<%= appuserrole %>')  --%>
if( '<%= appuserrole %>'.toUpperCase().indexOf("PRODUCTION") != -1)
	{
		//$('#tab-1').hide();
	}  
	
$('#folderTab').hide();
		$('#flip-container').quickFlip();
		$('#documentInfo').removeClass('selected');
		$('#uploadTab').removeClass('selected');
		
		$('#flip-navigation').removeAttr('style');
		$('#flip-navigation li a').each(function(){
			$(this).click(function(){
				$('#flip-navigation li').each(function(){
					$(this).removeClass('selected');
				});
				$(this).parent().addClass('selected');
				var flipid=$(this).attr('id').substr(4);
				//$('#flip-container').quickFlipper({ }, flipid, 1);
				
				return false;
			});
		});
	});
	
	
$(function() {
	
    $('input[name="transactionDate"]').daterangepicker({
        singleDatePicker: true,
     
        showDropdowns: true,
        yearRange: '-100y:c+nn',
        locale: {
            format: 'MM-DD-YYYY'
          },
        
    }, 
    function(start, end, label) {
        var years = moment().diff(start, 'years');
        //alert("You are " + years + " years old.");
    });
    $('#transactionDate').val(""); 
});

/**************sribala folder structure**************/
function setfilecount(){
	 var noOfFiles = document.getElementById('uploadedFiles').getElementsByTagName('li').length;
	 if(noOfFiles >= 1) //If there are files in the upload list; make upload button visible
	 {
	 $('#filecount').val(noOfFiles);
		// alert(noOfFiles);
	 }
}
/**************sribala folder structure**************/

function getTransactionType(){
	   
	   var companyIdValue= '<%= cid %>';
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getTransactionTypes?companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
			       for(i=0;i<data.response.length;i++){
			         $("#transactiontype").append("<option value='"+data.response[i].transactionTypeId+"'><b>"+data.response[i].transactionType+"</b></option>");
			      }  
			   },
			error : function(e) {
				
			},
			done : function(e) {
				console.log("DONE");
			}
		}); 
}

//Global variable to store array elements for expanded folder
 var s = [];   

function displayFolderStructure()
{
   //Displays only the folder structure required for folder selection
  $('#fileTreeDemo_1').fileTree({ root: '/',
	 script: 'connectors/jqueryFolderSelection.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'One moment...' }, function(file) { 
		alert(file);	
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
	setHeader('addTransactionDocuments.jsp');
	
	 $('#simple-menu').sidr();
     
	  $('.child').hide();
	  $('.parent').click(function() {
// 		 $('.child').slideUp();
// 		 $(this).find('ul').slideToggle();
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
	  //$('#adminWizardLi').click();
	  
	  $("#docManagementLi").collapse('toggle'); 
	
	// $("#loadingImage123").show();
	
	   //getFhaNumbers();
$('#slide').popup({
        focusdelay: 400,
        outline: true,
        vertical: 'top'
    });
$('.tooltip').tooltipster();

	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(i == 1)
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
    
  
	 // $('#adminWizardLi').click();
	
	//$('#content').hide(); 
 	//$('#uploadDocTab').hide();
 //	document.getElementById('content').disabled=true;
 	//document.getElementById('uploadDocTab').disabled=true;
 	getdropdowns();
 	//$("#tabbox").tabs('select',2);
 	//$("#tabbox").tabs({disabled: [0,1]});
 	//jQuery("#tab-0").tabs( "disable" , 0 )

  // $('#tab-0').diabled();
  
 	// $("#content").removeAttr("href");
	// session();
	    $('#folderNameFViewDataone').hide();
	
	
}



var index = new Array();
var documentdata = new Array();
var propertydata = new Array();

/*function getdropdowns() {
var queryString = "compid="+compid;

if(xmlhttp) {
    xmlhttp.open("POST","GetDropdownOptions",true); 
    xmlhttp.onreadystatechange  = handleServerResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send(queryString);
  } 
}*/



function getFhaNumbersbyProperty(id){

	 var input = document.getElementById('indexvalues').value.toLowerCase();
	 var input1;
	 var input2;
	 
	   $('#my_popup').popup('show');
	   $('#basic').css("display","block");
	   $('#myDiv').hide();  
	   $('#searchResults').hide();
	   var companyIdValue= '<%= cid %>';
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getFHANumbersByPropertyAssetManagement?propertyId="+id+"&companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				 $('#my_popup').popup('hide');
				 $("#indexvalues").html("");
					 $("#textError").empty();
					 $("#indexvalues").append("<option>Select FHA Number</option>");
// 					 alert(id+"-------------id");
				for(i=0;i<data.response.length;i++){
					if(data.response[i].fhaNumber !=null){
				       $("#indexvalues").append("<option value='"+data.response[i].fhaNumber+"'><b>"+data.response[i].fhaNumber+"</b></option>");
					}else{
						input='Select FHA Number';
						$('#indexvalues option:contains("' + input+ '")').attr('selected', 'selected disabled');
					}
					
					// alert("khj"+data.response[i].propertyName)
				       input1=data.response[i].propertyName;
				       input2=data.response[i].propertyId;
				       $('#propertyname option:contains("' +input1+ '")').attr('selected', 'selected');
				       $('#propertytype option:contains("' + input2+ '")').attr('selected', 'selected');
// 				       alert(data.response[i].fhaNumber+"-------input------id");
				}
			
			},
			error : function(e) {
				console.log("ERROR: ", e);
				//displayModules(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	
}

function getPropertybyFHANumber(id){
	//alert("id"+id);
	   $('#my_popup').popup('show');
	   $('#basic').css("display","block");
	   $('#myDiv').hide();  
	   $('#searchResults').hide();
	   var companyIdValue= '<%= cid %>';
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getPropertybyFHANumber?fhaNumber="+id+"&companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				 $('#my_popup').popup('hide');
				 $("#propertytype").html("");
					 $("#textError").empty();
					  $("#propertytype").append("<option>Select Property </option>");
				for(i=0;i<data.response.length;i++){
				       $("#propertytype").append("<option value='"+data.response[i].id+"'><b>"+data.response[i].propertyId+"</b></option>");
				       
				      } 
			},
			error : function(e) {
				console.log("ERROR: ", e);
				//displayModules(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
}




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
	               /*  if(data.propertyData.length > 1)
	                {
                		document.getElementById("propertytype").selectedIndex =1;
                		var selText = document.getElementById("propertytype").options[1].text;		
    					//document.getElementById("folderNameFView").value = "/"+selText;
                	} */
                	//openFolders();
                	
	               }
	          });
           
           $.ajax({
	            type: "GET",
	            url:"GetPropertyNameValues?comid="+comid,
	            dataType: "json",
	            success: function (data) {
	            
	                $.each(data.propertyData,function(i,obj)
	                {
	                 	var div_data="<option value="+obj.value+">"+obj.text+"</option>";
	                	$(div_data).appendTo('#propertyname'); 
	                });
	               /*  if(data.propertyData.length > 1)
	                {
               		document.getElementById("propertytype").selectedIndex =1;
               		var selText = document.getElementById("propertytype").options[1].text;		
   					//document.getElementById("folderNameFView").value = "/"+selText;
               	} */
               	//openFolders();
               	
	               }
	          });
        
         var doctypeId='2';
           $.ajax({
            type: "GET",
            url:"GetDocTypeDropdown?comid="+comid+"&doctypeId="+doctypeId,
            dataType: "json",
            success: function (data) {
            	//alert("619::"+data.docTypeData[0].value);
            		

                $.each(data.docTypeData,function(i,obj)
                		
                {                	
                	var	div_data="<option value="+obj.value+">"+obj.text+"</option>";
                	$(div_data).appendTo('#doctype'); 
                	
                });
               		/* if(data.docTypeData.length > 1)
                		document.getElementById("doctype").selectedIndex =1;*/
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
           
           // Commented becoz of the long running script
          /*  $.ajax({
	            type: "GET",
	            url:"GetFolderDropdown?comid="+comid,
	            dataType: "json",
	            success: function (data) {
	                $.each(data.folderData,function(i,obj)
	                {
	                 	var div_data="<option value="+obj.value+">"+obj.text+"</option>";
	                	$(div_data).appendTo('#folderNameFViewData'); 
	                });
	                if(data.folderData.length > 1)
	                {
               		document.getElementById("folderNameFViewData").selectedIndex =1;
               		var selText = document.getElementById("folderNameFViewData").options[1].text;		
   					//document.getElementById("folderNameFView").value = "/"+selText;
               	}
               	//openFolders();
               	
	               }
	          }); */
          	//Rearrange the dropdown to display default index at the top
			//update_select('indextype');
       //	$("#loadingImage123").hide();     
           var companyIdValue=comid;
   		$.ajax({
   			type : "GET",
   			contentType : "application/json",
   			url : "<%=restURL%>/orcf/getTransactionStatus?companyId="+companyIdValue,
   			dataType : 'json',
   			timeout : 100000,
   			success : function(data) {
   			 $("#transactionStatus").append("<option  value='' selected disabled>Select Transaction Status</option>");
   			       for(i=0;i<data.response.length;i++){
   			         $("#transactionStatus").append("<option value='"+data.response[i].transactionStatusDesc+"'><b>"+data.response[i].transactionStatusDesc+"</b></option>");
   			      }  
   			   },
   			error : function(e) {
   				console.log("error");	
   			},
   			done : function(e) {
   				console.log("DONE");
   			}
   		}); 
}

function handleServerResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	//parseData(xmlhttp.responseText);
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
	
	//parseindexstr(indexstr);
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
		
	/*for (var i=0; i < index.length;++i){
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

function openFolders(){
	  var closedFolders = $(".directory:not(.expanded) a");
	  if(closedFolders.length > 0) {
	    window.setTimeout(openFolders, 10);
	    closedFolders.click();
	    }
		//setFolderAsProperty();     	

	}
	

function setFolderAsProperty()
{
	var propertySelect = document.getElementById("propertytype");
    var property = propertySelect.options[propertySelect.selectedIndex].text;
   	document.getElementById("folderNameFView").value = "/"+property;
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
    	//document.getElementById("folderNameFView").value = "/"+selText;
    	
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
}

function check1() {


 			      	/*    var check1 = $('[id^="checkbox1"]');
                  	for(var i=0; i< check1.length; i++){
                  	 var check = document.getElementById("checkbox1").checked;
                  	   alert("checked"+check);
                  		if(check == true){
                  	    document.getElementById("hiddencheckbox").value=true;
                  	 
                  	   }else
                  	   {
                  	  document.getElementById("hiddencheckbox").value=false;
                  	
                  	   }
                  	} */
        	   
	var x = $('[id^="lnk"]');
	var err = false;
	
	for(var i=0; i< x.length; i++)
	{
		var ext = $(x[i]).attr("title");
		if (ext.lastIndexOf(".pdf") != -1 || ext.lastIndexOf(".PDF") != -1
		        || ext.lastIndexOf(".xls") != -1  || ext.lastIndexOf(".xlsx") != -1
		        || ext.lastIndexOf(".doc") != -1  || ext.lastIndexOf(".docx") != -1
		        || ext.lastIndexOf(".tiff") != -1  || ext.lastIndexOf(".tif") != -1
		        || ext.lastIndexOf(".jpg") != -1 || ext.lastIndexOf(".jpeg") != -1) 
		{
						
		} else {
		    //alert("Please upload PDF, Excel, Word, TIFF, JPG files only");
		  //alert(" x[i] "+$(x[i]));
		  err = true;
		  $(x[i]).css("color", "red");	  
		}	
	}
	if(err)
		return false;
	else
		return true;	
} 

function verifyIndex(){
	var index = $('[id^="indexval"]');
	//var err = false;
	for(var i=0; i< index.length; i++)
	{
		var indexVal =  $(index[i]).val();
		
		if(indexVal == "")
		{
			//alert("Please enter index value");
			 //$(index[i]).css("borderColor", "red");	
			 //err = true;
			 $(index[i]).val("");		
			 
		}
		/*else
		{	
			$(index[i]).css("borderColor", "rgba(0, 0, 0, 0.3)");	
		}*/
	}
	/*if(err)
		return false;
	else*/
		return true;	
}

function onCancel(){
	window.location="dashboard.jsp";
}

function onCancelled(){
	window.location="addTransactionDocuments.jsp";
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

function checkContent(){
	if($("#propertytype option:selected" ).text()== 'Select Property' && 
			$("#propertyname option:selected" ).text()== 'Select PropertyName' ){
			$('#documentInfo').removeClass('selected');
			$('#documentInfo').addClass('disable');
			curtab=1;
			}else{
				$("#propId").html($('#propertyname option:selected').html());
				$("#fhaNum").html($('#indexvalues option:selected').html());
				$("#propName").html($('#propertytype option:selected').html());
			}
}


function tabContent0()
{
	// checkIfDone();
	if(curtab!=1 && curtab==2){
	  document.getElementById('upload_btn').style.display = 'none'; 
	  $('#flip-container').quickFlipper({ }, 1, 1);
	 // document.getElementById('uploadDocTab').style.display = 'none';
	}else if(curtab=1){
		
		 if((($("#propertytype").val()!="" || $("#propertytype").val() != null)) && ($("#propertyname").val()!="" || $("#propertyname").val() != null )){
				
				$('#flip-navigation li a').each(function(){
					$(this).click(function(){
						$('#flip-navigation li').each(function(){
							$(this).removeClass('selected');
						});
						$(this).parent().addClass('selected');
						var flipid=$(this).attr('id').substr(4);
						//$('#flip-container').quickFlipper({ }, flipid, 1);
						
						return false;
					});
				});
				 }
	}
		
		
}

function tabContent3(){
	if(curtab!=1 && curtab==2){
	document.getElementById('upload_btn').style.display = 'none'; 
	  $('#flip-container').quickFlipper({ }, 0, 1);

	 // document.getElementById('uploadDocTab').style.display = 'none';
	}
}

/* $(function () {

    $("#btnContFirst").click(function () {
         	
        if( $("#propertytype").val() == "" || $("#propertytype").val() == null){
        	$("#message2").html("Please select valid Property");
        	alert("Please select valid Property")
          return false;
        } 
        if($("#doctype").val() == "" || $("#doctype").val() == null )
        	{
        	$("#message1").html("Please select valid Document Type");
            return false;	
        	} 
        if($("#indexvalues").val() == "" || $("#indexvalues").val() == null){
        	
        	$("#message").html("Please select valid FHAnumber");
            return false;
        }
        
        return true;
    });
}); */

 function tabContentData()
{ 
	//$('#tabContentData').live('click', function(e){
	//	$(document).on('click','#tabContentData',function(e){
//  $( '#tabContentData' ).click( function( e ) {
	
	 $("#textError").empty();
	 var isAvailble = true;
	 var message="Please select valid ";
	 
	 if($("#propertytype").val()=="" || $("#propertytype").val() == null){
		 isAvailble= false;
    	 message += " Property Type, ";
    	 curtab=1;
//     	 $('#documentInfo').addClass('disable');
// 		 $('#uploadTab').addClass('disable');
	 }
	  if($("#propertyname").val()=="" || $("#propertyname").val() == null ){
		 isAvailble= false;
    	 message += " Property Name ,";
    	 curtab=1;
//     	 $('#documentInfo').addClass('disable');
// 		 $('#uploadTab').addClass('disable');
	 } 
	 

	 /* if( $("#propertytype").val() == "" || $("#propertytype").val() == null){
     	$("#message2").html("Please select valid Property");
     	//alert("Please select valid Property")
       return false;
     } 
	 if($("#doctype").val() == "" || $("#doctype").val() == null )
     	{
     	$("#message1").html("Please select valid Document Type");
     //	alert("Please select valid Document Type")
         return false;	
     	} 
	 if($("#indexvalues").val() == "" || $("#indexvalues").val() == null){
     	
     	$("#message").html("Please select valid FHAnumber");
     //	alert("Please select valid valid FHAnumber")
         return false;
     }  */
	 
	 
	     
	 if(isAvailble == true){
	<%--  if ( "PRODUCTION" === '<%= appuserrole %>')  --%>
	

	<%-- if( '<%= appuserrole %>'.toUpperCase().indexOf("PRODUCTION") != -1)
		{
		 tabContent2();
		} 
	 else
		 {
		 tabContent2();
		 
		 } --%>
		curtab=2;	
		 $('#documentInfo').removeClass('disable');
		 $('#uploadTab').addClass('disable');
		 $('#uploadTab').removeClass('selected');
		 //$('#clear').addClass('disable');
		 tabContent1();
		// $('#content').show();
		
		
	 }else{
			//	 alert("Please "+message);
		 //if(message.endsWith(",")){
		//	if(message.substring(message.length - 1, message.length) == ","){
			  if(message.substring(message.length-1)==',') { 
				message = message.substring(0, message.length - 1);
			}
	    document.getElementById("textError").innerHTML = message ;
	 }
		
	 }

function tabContent1()
{
	/* $("#propId").html($('#propertytype option:selected').html()); */
	
	$("#propId").html($('#propertyname option:selected').html());
	 
	$("#fhaNum").html($('#indexvalues option:selected').html());
	$("#propName").html($('#propertytype option:selected').html());
	
	
	
	
	<%-- 	
	 if ( "PRODUCTION" === '<%= appuserrole %>') 
		{
		 alert("1234"+'<%= appuserrole %>');
			$('#folderTab').hide();
		}  --%>
	 //checkIfDone();
	 
	 document.getElementById('upload_btn').style.display = 'none'; 
	 document.getElementById('content3').disabled=false;
	 
	 $('#flip-container').quickFlipper({ }, 1, 1);
	 setActive(1);
	  
		 
		  
	 //document.getElementById('uploadDocTab').style.display = 'none';		 	
		
}
function tabContent2()
{
if($('#propertytype').val()=="" || $('#propertyname').val()=="" || $('#indexvalues').val()==""){
	 $('#documentInfo').addClass('disable');
	 $('#documentInfo').addClass('selected');
	 $('#uploadTab').addClass('disable');
	 $('#uploadTab').removeClass('selected');
	//$('#propertyInfo').addClass('isSelected');
//	 $('#flip-container').quickFlipper({ }, 0, 1);
	setActive(0);
	 document.getElementById("textError").innerHTML = 'Please select valid Property Type, Property Name' ;
	}
else{
//checkIfDone();
		 if(curtab!=1 && curtab==2){
		//  $('#content').show();
$("#propertyIdData").html($('#propertytype option:selected').html());
$("#propertyNameData").html($('#propertyname option:selected').html());	 
$("#fhaNumberData").html($('#indexvalues option:selected').html());
	
	 $("#textError1").empty();
	 var isAvailble = true;
	  var message="Please select valid ";
	 if($("#transactiontype").val()=="" || $("#transactiontype").val() == null ){
		 isAvailble= false;
    	 message += " Transaction Type,";
    	 $('#uploadTab').addClass('disable');
		 $('#uploadTab').removeClass('selected');
	 } 
	 
	 if(isAvailble == true){
		 $('#uploadTab').removeClass('disable');
		 //$('#clearDocInfo').addClass('disable');
		 $('#flip-container').quickFlipper({ }, 2, 1);
 		 setActive(2);	
	 }

else
	  {
	  // if(message.endsWith(",")){
		// if(message.substring(message.length - 1, message.length) == ","){
			  if(message.substring(message.length-1)==',') { 
			message = message.substring(0, message.length - 1);
		}
 document.getElementById("textError1").innerHTML = message ;

	  } 
	  }
	  }
	  }
	 
		/*  var noOfFiles = document.getElementById('uploadedFiles').getElementsByTagName('li').length;
		 if(noOfFiles >= 1) //If there are files in the upload list; make upload button visible
		 {
		 		 document.getElementById('upload_btn').style.display = 'block'; 
		 		 document.getElementById('upload_btn').style.position= 'absolute';
		 		 document.getElementById('upload_btn').style.top = '0px';
		 		 document.getElementById('upload_btn').style.left = '50%';
		 		 
		 } */
		 
		/*  var folderNameFView =document.getElementById('folderNameFView').value;
         
         alert("folderNameFView"+folderNameFView);
         */ 
         
		 			
	
		
		  /* $('#flip-container').quickFlipper({ }, 1, 1);
		  setActive(1);	   */
		 		
/*
function tabContent3()
{
		 //checkIfDone();
		 document.getElementById('folderLbl').innerHTML  = document.getElementById('folderNameFView').value;
		 document.getElementById('doctypeLbl').innerHTML  = document.getElementById('doctype').options[document.getElementById('doctype').selectedIndex].text;
		 document.getElementById('propertytypeLbl').innerHTML  = document.getElementById('propertytype').options[document.getElementById('propertytype').selectedIndex].text;
		 document.getElementById('indexTypeLbl').innerHTML  = document.getElementById('indextype').options[document.getElementById('indextype').selectedIndex].text;
		 document.getElementById('indexValueLbl').innerHTML  = document.getElementById('value').value;
		 
		 
		 $('#flip-container').quickFlipper({ }, 3, 1);
		 setActive(3);
		 
		
}*/

function msgbox_visible(val){
	   
   var e = document.getElementById('messagewindow');
   if(val==true){
   		e.style.display = 'block';
   } else {
   		e.style.display = 'none';
   }
		   
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

function setPropertyFolder(property) {
   // document.getElementById("folderNameFView").value = "/"+property;
}
function setFolderPatteren(property) {
	alert("erter");
    document.getElementById("folderNameFView").value = "/"+property;
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

function clearFields()
{
		document.getElementById('propertytype').selectedIndex = 0; 

		var selText = document.getElementById("propertytype").options[1].text;		
    	//document.getElementById("folderNameFView").value = "/"+selText;
		//document.getElementById('indexvalues').value =""; 
			
		document.getElementById('propertyname').selectedIndex = 0;	
		document.getElementById('indextype').selectedIndex = 0;	
		document.getElementById('indexvalues').selectedIndex = 0;
		document.getElementById('realtxt').value =""; 
		document.getElementById('propertyName').value =""; 		
		document.getElementById('fhanumber').value =""; 
		$("#propId").text("");
		$("#fhaNum").text("");
		$("#propName").text("");

}

function clearDocInfoFields(){
	document.getElementById('transactionDate').value =""; 
	document.getElementById('transactionStatus').value ="";
	document.getElementById('transactiontype').selectedIndex = 0;
	document.getElementById('doctype').selectedIndex = 0;	
}


function searchPropertyName()
{
  var input = document.getElementById('propertyName').value.toLowerCase();
  var outputdata =null;
      len = input.length;
      output = document.getElementById('propertyname').options;
      
  for(var i=0; i<output.length; i++)
      if (output[i].text.toLowerCase().indexOf(input) != -1 ){
    	  outputdata=output[i].value;
      output[i].selected = true;
/*       document.getElementById("folderNameFView").value = "/"+output[i].text;
 */      break;
      }
  if (input == '')
    output[1].selected = true;
 
  
  if(outputdata != null){	
  getFhaNumbersbyProperty(outputdata);
  }
}
function searchSel() 
{
  var input = document.getElementById('realtxt').value.toLowerCase();
  var outputdata =null;
      len = input.length;
      output = document.getElementById('propertytype').options;
      
  for(var i=0; i<output.length; i++)
      if (output[i].text.toLowerCase().indexOf(input) != -1 ){
    	  outputdata=output[i].value;
      output[i].selected = true;
/*       document.getElementById("folderNameFView").value = "/"+output[i].text;
 */      break;
      }
  if (input == '')
    output[1].selected = true;
 
  
  if(outputdata != null){	
  getFhaNumbersbyProperty(outputdata);
  }
}

function searchFhaNumber() 
{
	

  var input = document.getElementById('fhanumber').value.toLowerCase();
  
  var comid = '<%= cid %>';
  
    
  $.ajax({
       type: "GET",
       url:"<%=restURL%>/orcf/getFHANumbersList?fhaNumber="+input+"&companyId="+comid,
       dataType: "json",
       success: function (data) {
    	   $('#my_popup').popup('hide');
			 $("#indexvalues").html("");
				 $("#textError").empty();
				//  $("#indexvalues").append("<option>Select FHA Number</option>");
			for(i=0;i<data.response.length;i++){
			       $("#indexvalues").append("<option value='"+data.response[i].fhaNumber+"'><b>"+data.response[i].fhaNumber+"</b></option>");
			       
			      }
                       	
          }
     });
  
  
  var outputdata =null;
      len = input.length;
      output = document.getElementById('indexvalues').options;
      
  for(var i=0; i<output.length; i++)
      if (output[i].text.toLowerCase().indexOf(input) != -1 ){
    	  outputdata=output[i].value;
      output[i].selected = true;
/*       document.getElementById("folderNameFView").value = "/"+output[i].text;
 */      break;
      }
  if (input == '')
    output[1].selected = true;
 
  
  if(outputdata != null){	
  getPropertybyFHANumber(outputdata);
  }
}



/**
 * Module for displaying "Waiting for..." dialog using Bootstrap
 *
 * @author Eugene Maslovich <ehpc@em42.ru>
 */

var waitingDialog = waitingDialog || (function ($) {
    'use strict';

	// Creating modal dialog's DOM
	var $dialog = $(
		'<div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-hidden="true" style="padding-top:15%; overflow-y:visible;">' +
		'<div class="modal-dialog modal-m">' +
		'<div class="modal-content">' +
			'<div class="modal-header"><h3 style="margin:0;"></h3></div>' +
			'<div class="modal-body">' +
				'<div class="progress progress-striped active" style="margin-bottom:0;"><div class="progress-bar" style="width: 100%"></div></div>' +
			'</div>' +
		'</div></div></div>');

	return {
		/**
		 * Opens our dialog
		 * @param message Custom message
		 * @param options Custom options:
		 * 				  options.dialogSize - bootstrap postfix for dialog size, e.g. "sm", "m";
		 * 				  options.progressType - bootstrap postfix for progress bar type, e.g. "success", "warning".
		 */
		show: function (message, options) {
			// Assigning defaults
			if (typeof options === 'undefined') {
				options = {};
			}
			if (typeof message === 'undefined') {
				message = 'Uploading Files!  Please Wait...';
			}
			var settings = $.extend({
				dialogSize: 'm',
				progressType: '',
				onHide: null // This callback runs after the dialog was hidden
			}, options);

			// Configuring dialog
			$dialog.find('.modal-dialog').attr('class', 'modal-dialog').addClass('modal-' + settings.dialogSize);
			$dialog.find('.progress-bar').attr('class', 'progress-bar');
			if (settings.progressType) {
				$dialog.find('.progress-bar').addClass('progress-bar-' + settings.progressType);
			}
			$dialog.find('h3').text(message);
			// Adding callbacks
			if (typeof settings.onHide === 'function') {
				$dialog.off('hidden.bs.modal').on('hidden.bs.modal', function (e) {
					settings.onHide.call($dialog);
				});
			}
			// Opening dialog
			$dialog.modal();
		},
		/**
		 * Closes dialog
		 */
		hide: function () {
			$dialog.modal('hide');
		}
	};

})(jQuery);

</script>

</body>

</html>
