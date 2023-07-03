<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />
 --%>
<%@page  import="org.apache.pdfbox.pdmodel.PDDocument"%>
<%@page import ="org.apache.pdfbox.pdmodel.PDDocumentNameDictionary"%>
<%@page import ="org.apache.pdfbox.pdmodel.PDEmbeddedFilesNameTreeNode"%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
		<script src="js/jQuery/1.11.3/jquery.min.js"></script>
	    <script src="js/jquery.tooltipster.min.js" type="text/javascript"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>   
    	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
		<!-- <script src="https://unpkg.com/weakmap-polyfill/weakmap-polyfill.min.js"></script> -->
		<script src="js/weakmap-polyfill.min.js"></script>
<script src="https://unpkg.com/formdata-polyfill"></script>
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
			
		<script src="scripts/FormData.js"></script> 
		
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" /> 
		
		
	     <!-- Our main JS file -->
		<script src="assets/js/script.js"></script>
		<link href="assets/css/style.css" rel="stylesheet" />
		
		<link rel="stylesheet" href="css/bootstrap.css"></link>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<link rel="stylesheet" type="text/css" href="css/tooltipster.css" />
		<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>	 -->
		
		<script src="js/bootstrap.min.js"></script>
		
		
	<!-- 	<link rel="stylesheet" href="css/bp/custom_screen.css" type="text/css" media="screen, projection">
      <link rel="stylesheet" href="css/bp/print.css" type="text/css" media="print">
      <link rel="stylesheet" href="css/bp/fancy-type/screen.css" type="text/css" media="screen, projection">-->
		

		<title>TransAccess Imaging</title>
		<style type="text/css">
		::-webkit-scrollbar {
    width: 12px;
}
 
::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
    border-radius: 10px;
}
 
::-webkit-scrollbar-thumb {
    border-radius: 10px;
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.5); 
}
		
	.deletedoc {
	    color: #fff; 
    background-color: #ff9900;
	}	
		
		
	.deletedoc:focus, .deletedoc:hover {
    background-color: #ef9309;
    background-position: 0 -15px;
}	
		


@keyframes auto-progress {
  0% {
    width: 0%;
  }

  100% {
    width: 100%;
  }
}

.progress-bar {
/* margin-top: 3px;
    margin-left: 12px; */
    background-color: #ccc;
    height: 15px;
   width: 50px;
   
    border-radius: 5px;
   
}

.stripes {
    background-size: 30px 30px;
    background-image: linear-gradient(
        135deg,
        rgba(255, 255, 255, .15) 25%,
        transparent 25%,
        transparent 50%,
        rgba(255, 255, 255, .15) 50%,
        rgba(255, 255, 255, .15) 75%,
        transparent 75%,
        transparent
    );
}

.stripes.animated {
  animation: animate-stripes 0.6s linear infinite;
}

.stripes.animated.slower {
  animation-duration: 1.75s;
}

.stripes.reverse {
  animation-direction: reverse;
}

.progress-bar-inner {
  display: block;
  height: 15px;
  width: 0%;
  background-color: #54ae54;
  border-radius: 3px;
  box-shadow: 0 1px 0 rgba(255, 255, 255, .5) inset;
  position: relative;
  animation: auto-progress 10s infinite linear;
}
		
		
		
		
		
		.profress-bar {
border: 1px solid #ccc;
padding: 6px;
border-radius: 4px;
background-color: #f1f1f1;
}
		.widthActions i{
		    width: 20px;
    float: left;
    padding-right: 6px;
    padding-top: 2px;
		
		}
		.btn-upload{
		border: none;
    border-radius: 4px;
    margin-right: 2px;
    font-size: 11px;
    padding: 5px 5px;
		}
		.table-data thead tr,.table > thead > tr > th{
    background-color: #7098CC;
    color: #fff !important;
}
		#upload ul#uploadedFiles li {
    background: none !important;
        height: 56px;;
    }
		
								
									
										  
										
		
		
		.btn-danger {
		background-color: #ff9900 !important;
		background-image: none;
    
		color:#fff;
		}
		#upload{
		box-shadow:none
		}
		#drop {
      text-align: left;
    padding-left: 8px;
   background:none; 
    
     border: none;}
		.instractions{
		  
    text-align: left;
    }
    .instractions ul {
    border: 1px solid #ccc;
    padding-bottom: 20px;
    padding-top: 20px;
    border-bottom-left-radius: 4px;
    border-bottom-right-radius: 4px;
}
		.instractions p {
    border: 1px solid #ccc;
    padding: 10px 20px;
    margin: 0px;
    background-color: #f1f1f1;
    font-weight: 600;
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
}
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
		    font-family:roboto;font-size:13px;;  
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
		#browse_btn{
		color: #b1b3b7;
    background: #ffff;
    border: #ccc;
    padding: 10px 18px;}	
    
    
    
  .widthName  {
width: 200px;

 word-break: break-all;
 
}
 .width126{width: 126px;} 
 .width130{width: 130px;}  	
    	.table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td {
    padding: 6px;
    vertical-align: middle;
    }	
		</style>
</head>




<% 
try{
	
	 String appuserrole = (String)request.getSession().getAttribute("appuserrole");
if(request.getSession().getAttribute("userid")!=null&&(appuserrole.equals("ADMIN")||appuserrole.equals("COORDINATOR"))){
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  
 
  System.out.println("appuserrole "+appuserrole);
  javax.naming.Context ctx1 = 	new javax.naming.InitialContext();
		String restURL = (String) ctx1.lookup("java:comp/env/restCommonUrl");
  
   //String folderPatteren=request.getSession().getAttribute("folderPatterens").toString();
   // System.out.println("folderPatteren--->"+folderPatteren.replaceAll("\\[|\\]", ""));
   
  /*  List<String> list=new ArrayList<String>();
  
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
  System.out.println("folderPatteren--->"+folderPatteren.replaceAll("\\[|\\]", "")); */

  
  java.util.Date today = new java.util.Date();
  java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
  //String html = folderBean.getFolderNameGridHTML(""+cid); 
  //request.getSession().setAttribute("folderData", html);	
  
 /*   List<String> html = folderBean.getPropertyNameGridHTML(""+cid,folderPatteren.replaceAll("\\[|\\]","").replaceAll(",\\s","|")); 
  request.getSession().setAttribute("folderData", html);*/
%>

<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>


<jsp:include page="includes/sessionHeader.jsp" />

<body onLoad="initial_load()" >
<span id="countId" style="display:none" ></span>
<span id="autopop" style="display:none" ></span>
<input id="fileuploadId" style="display:none" ></input>
<button id="dataremove" style="display:none"></button>
<!-- <form method="POST" enctype="multipart/form-data" id="fileUploadForm">
    
    <input type="file" name="documents" multiple/><br/><br/>
   
    <input type="submit" value="Submit" id="btnSubmit"/>
</form> -->
<form style="display:none" method="POST" enctype="multipart/form-data" id="fileUploadForm1">
    
   
   
    <input type="submit" value="Submit" id="btnSubmit1"/>
</form>

  <!--  <input type="file" id="files123" name="files" multiple /> -->
								
								
								<select  name="doctype" id="doctype" class="selectText" style="display:none">
								    				<option value="" selected>Select Document Type</option>
								  				</select>	
								  				<select style="display:none" name="iremsnumber" id="iremsnumber" class="selectText" onchange="getFhaNumbersbyProperty(this.value);">
									    			<option value="" selected>Select IREMS </option>
									  			</select>	
								
												
											
<section class="Dropbox section-width" id="dropbox">
        <div class="">
            <div class="child-dropbox">
                
                <div class="instractions">
                    <p>Dropbox Information</p>
                    <ul>
                     <li>Only Portable Document Format files (<b>PDF</b>) are allowed</li>
                     <li><b> No</b> Encrypted/Password-Protected PDFs allowed</li>
                        <li><b>Max</b> (16) files per upload</li>
						<li>Max file size <b>(500MB)</b></li>
                        <li>Filename format is as follows '<b>iREMS#_DocumentType</b>'</li>
                         <li>You can <b>drag &amp; drop</b> records from your desktop</li>
  
                        <li>Any records uploaded <b>without </b> Document Type will be found in <b>Pending Uploads</b></li>
                        <li>A session <b>will</b> timeout during extended idle periods (~40Min)</li>
                        <li>To confirm all records were uploaded successfully, please review <b>Pending Uploads</b>  </li>
                       
                    </ul>
                </div>
                
                
                
                 
        <form name="upload" id="upload" method="post"  enctype="multipart/form-data"  onsubmit="return false;">
        
        <div id="flip-container" >  
            
	 
            
               
		
		        <div>        
	           
		<div>
	           
			<div style="padding: 10px; min-height: 390px;" align="center" width= "100%">
			 	
					<!-- <h4 class="tableHeader"><i class="zmdi_large zmdi-cloud-upload"></i>Upload Documents</h4>-->			
						<table align="center" width= "100%" >
																
							<tr valign=top>
							   
								<td>
								 	 <h4 style="    padding-left: 15px;">Select files</h4>
								<div id="drop" class="col-sm-12">
								<div style="     background: #E4EAF4 none repeat scroll 0% 0%;  border: 3px dashed #C1C3C5;">
								
												<div class="uploadimage-text" style="    padding-left: 10px;    margin-top: 1em;">
								    				Drag files here
												</div>
								</div>
												
												<div style="color:black;font-size: 12px;    padding-left: 10px;">				
												    Or, if you prefer...				
												</div>
												<a id="browse_btn" style="    color: #000;" class="btn btn-s">Choose file(s)</a>
												
												<!-- <a id="reset_btn" class="btn btn-warning btn-s"  >Reset</a> -->
																
												
											    <input type="file" id="files" name="files" multiple accept="application/pdf,.pdf" />		
											   													
										</div>
										<div class="upload-queue">
                    <div id="uploadandremove" class="upload-remove-buttons">
                        <button type="button" id="allSubmit" class="btn btn-success"><i class="fa fa-upload" aria-hidden="true"></i> Upload all</button>
                        <button id="reset_btn" type="button" class="btn" style="color:#fff !important;border color:#ff9900 !important;background-color:#ff9900 !important;" ><i class="fa fa-trash" aria-hidden="true"></i> Remove all</button>
                    </div>
                </div> 
              	
                <input type="hidden" id ="userName" name="userName" value="<%=appuserrole%>"/>
									  	<input type="hidden" id ="filecount" name="filecount">
                
                
          
											<ul id="uploadedFiles" class="col-sm-12">																						
														                
											</ul>			
								</td>
								
							
						</tr>
								
                   
								</table>
								 	<div id="result" style="color:red;letter-spacing: 1px;font-size: 12px;"></div>
								<div  class="table-data table-list">
							
                    <table id="myTable" class="table">
                        <thead>
                            <tr>
                                <th>File Name</th>
                                <th>Size</th>
                                <th>IREMS #</th>
                                <th>Document Type</th>
                                <th>Progress</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody id="myTablebody">
                           

                           
                           
                           
                        </tbody>
                    </table>
                </div>
								
								</div>
								</div></div>
					
       
        </div>  
      
        
        <input type="hidden" id ="cid" name="cid" value="<%=cid%>"/>
		<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
		
		<%javax.naming.Context ctx = new javax.naming.InitialContext();
								String uploadFileSize = (String) ctx
										.lookup("java:comp/env/uploadFileSize");%>
		 
		<input type="hidden" id ="uploadFileSize" name="uploadFileSize" value="<%=uploadFileSize%>"/>
        </form>
     
          
                
                
             
             <!--   <div class="upload-queue">
                    <h4>Upload queue</h4>
                    <p>Queue length : 0</p>
                    <p>Queue progress</p>
                    <div class="profress-bar"></div>
                    <div class="upload-remove-buttons">
                        <button type="button" class="btn btn-success"><i class="fa fa-upload" aria-hidden="true"></i> Upload all</button>
                        <button type="button" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Remove all</button>
                    </div>
                </div>-->
			 </div>
        </div>
    </section>


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

	<!-- Modal -->
<div class="modal fade" id="myAutoModal" tabindex="-1" role="dialog" aria-labelledby="myAutoModal" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="border-radius: 30px;">
      <div class="modal-header" style="border-bottom:0 !important;    padding:0!important">
        <h1 class="modal-title" style="    text-align: center;"><b>ATTENTION</b></h1>
       
      </div>
      <div class="modal-body">
         <div>
<div align="left" style="float: left; margin-top: -6px; margin-right: 20px;">
<img alt="" src="images/Alert1.png" style="height: 70px;">
</div>
<div align="right">

<div  style="    font-size: 13px;font-family:Geneva, Arial, Helvetica, sans-serif; text-align: left;" >
You are about to autofill this iREMS# to every document below this one.</div> 
</div>
</div>
      </div>
      <div class="modal-footer" style="border-top:0 !important">
      <div id="btntype1">
         <input type="image" style="width:100px;height: 37px;" src="images/AttButtNo.png" value="CANCEL" alt="Cancel" onClick="javascript:cancelWindow();"/>
  
  <input type="image" style="width:150px;height: 37px;" src="images/AttButtYes.png" value="OK" alt="Continue" onClick="javascript:continueWindow();"/>
     
      </div>
    <div id="btntype2">
    
     <button class="button button1" onClick="javascript:cancelWindow();">Cancel</button>
<button class="button button2" onClick="javascript:continueWindow();">Continue</button>
      </div>
    </div>
    </div>
  </div>
</div>
<style>

.button1 {
 /*  background: url("images/AttButtNo1.png") no-repeat; */
  background-size: contain;
    width: 145px;
    height: 45px;
    border: none;
    color: green;
    border-radius: 14px;
    background: #ccc;
 
}
.button2 {
 /*  background: url("images/AttButtYes1.png") no-repeat; */
  background-size: contain;
    width: 145px;
    height: 45px;
    border: none;
    color: green;
    border-radius: 14px;
    background-color: #7098CC;
 
}
</style>

<script language="javascript">
 var fView = "fView";
 function filedetection(index,formData){
	 
console.log("sd")
	  var formDataEntries = formData.entries(), formDataEntry = formDataEntries.next(), pair;
	  var newfile='';	    
	  	  
	  	  // or, if you are really into compact code
	  	 var countfile=1;
	  	    var es, e, pair;
	  	    for (es = formData.entries(); !(e = es.next()).done && (pair = e.value);) {
	  	       if(countfile==index){
	  	    	   newfile=pair[1];   break;
	  	       }
	  	       countfile++;
	  	    }
	  	  
	 <%
	 String name=request.getParameter("formData");
	 String str = "<script>document.writeln(newfile)</script>";
	 System.out.println(name);
	 /*  final PDDocument document = PDDocument.load(new File(newfile));
     PDDocumentNameDictionary namesDictionary = new PDDocumentNameDictionary( document.getDocumentCatalog());
     PDEmbeddedFilesNameTreeNode efTree = namesDictionary.getEmbeddedFiles();
     System.out.println(efTree.getNames().size()); */
			 
			 %>
	 
	 
	 
	 
	 
 }
 function autopopulate(i){
	 console.log(i);
	 var rowcount=$('#myTablebody').children('tr').length;
	 if(rowcount==1){
		 $('#btntype1').css("display", "none");
		 $('#btntype2').css("display", "initial");
	 }else{
		 $('#btntype2').css("display", "none");
		 $('#btntype1').css("display", "initial");
	 }
	 $('#autopop').val(i);
	 $('#myAutoModal').modal('show');
 }
 function cancelWindow(){
	 $('#myAutoModal').modal('hide'); 
 }
 function continueWindow(){
	 var autopop=$('#autopop').val();
	 var rowcount=$('#myTablebody').children('tr').length;
	 console.log(rowcount)
	 var iremsval= $('#iremsnumber'+autopop).val();
	 for (i=autopop;i<=rowcount;i++){
		 $('#iremsnumber'+i).val(iremsval);
		 $('#img'+i).css("display", "initial");
	 }
	 $('#myAutoModal').modal('hide'); 
 }
 function iremschange(obj){
	// var regexp = /^(800)(\s*[\_]\s*)?\d{6}$/;
	 var provalue=$('#iremsnumber'+obj).val();
	
	 //regexp.test(provalue)
		if(provalue){
			 $('#img'+obj).css("display", "initial");
		}else{
			 $('#img'+obj).css("display", "none");
		}
 }
 
 $(document).ready(function () {
	console.log('naveen')
	/*  $('input').keyup(function() {
		 
		 console.log(e)
			 if (this.value.length === 4) alert('test');
		 });  */ 
	 
	    $("#btnSubmit").click(function (event) {

	        //stop submit the form, we will post it manually.
	        event.preventDefault();

	        fire_ajax_submit();

	    });

	});

	function fire_ajax_submit(index,files) {
		var count=$('#countId').val();
		$('#countId').val("1")
		
	
		var sessionid= '<%=sessionid%>';
		var cid='<%= cid %>';
		var uid='<%= uid %>';
		var propertyID=[];
		var documentType=[];
		var filesdata=[];
		
		var statusloop=false;
		 var form1 = $('#fileUploadForm1')[0];

		    var data = new FormData(form1);
		
		//   var regexp = /^[a-zA-Z0-9-_]+$/;
		var regexp = /^(800)(\s*[\_]\s*)?\d{6}$/;
		
		function test(ini){
			 
			if(ini<=index){
				 $('#iremsnumber'+ini).css("border", "1px solid rgb(169,169,169)");
				 $('#doctype'+ini).css("border", "1px solid rgb(169,169,169)");
				var docIdgetting= $('#doctype'+ini).find(":selected").val();
				var propertyselectiongetting=$('#iremsnumber'+ini).val();
				if(regexp.test(propertyselectiongetting)){
					
					if($('#doctype'+ini+' option[value="'+docIdgetting+'"]').attr("disabled") ||  $('#doctype'+ini+' option[value="'+docIdgetting+'"]').prop("disabled"))
					 {
						 $("#result").text("Selected document type is deprecated").css("color", "red");
						 $('#doctype'+ini).css("border", "1px solid red");
						 $('#countId').val("");
					  }else{
				documentType.push(docIdgetting)
				propertyID.push(propertyselectiongetting);
				test(ini+1);
					  }
				}else{
					 $('#iremsnumber'+ini).css("border", "1px solid red");
					$('#countId').val("");
					if(propertyselectiongetting){
						
					 $("#result").text("'"+propertyselectiongetting+"' is not a valid IREMS #").css("color", "red");
					}else{
						 $("#result").text("'File "+ini+"' is not a valid IREMS #").css("color", "red");
					}
				}
			//	var dataform = new FormData(form1);
	 //var newfile = file.get('file'+index);
	 //data.append('documents', files.get('file'+ini));
				//filesdata.push(files.get('file'+ini))
				
			}else{
				statusloop=true;	
			}
		}
		
		  var formDataEntries = files.entries(), formDataEntry = formDataEntries.next(), pair;
		    
		  
		  // or, if you are really into compact code
		    var es, e, pair;
		    for (es = files.entries(); !(e = es.next()).done && (pair = e.value);) {
		       
		       data.append('documents',pair[1]);
		    }
		test(1);
		console.log(index)
		 $("#btnSubmit").prop("disabled", true);
	if(statusloop&&count==''){
		 $(".widthStatus").text("Uploading").css("color", "green");  
			$(".widthProgress").css("display", "none"); 
			$(".widthbarprogress").css("display", "block"); 
		// data.append('documents',filesdata); 
		    console.log(filesdata)
		  // var index = $('[id^="'+checkboxid+'"]');
		    
		    var str="userId="+uid+"&propertyID="+propertyID+"&documentType="+documentType+"&sessionId="+sessionid+"&companyId="+cid;
		    $("#result").text("");
		    $.ajax({
		        type: "POST",
		        enctype: 'multipart/form-data',
		      url : "<%=restURL%>/orcf/addDocumentsMFHD?"+str,
		        data: data,
		        //http://api.jquery.com/jQuery.ajax/
		        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
		        processData: false, //prevent jQuery from automatically transforming the data into a query string
		        contentType: false,
		        cache: false,
		        timeout: 0,
		        success: function (data) {
		        	$(".widthbarprogress").css("display", "none");
			        if(data.status=='success'){
			        	 $("#result").text("To confirm successful uploads, visit Pending Uploads").css("color", "green");
			        	 $(".widthProgress").css("display", "block").css("background", "green");
			        	 $(".widthStatus").text("Uploaded").css("color", "green"); 
				        setTimeout(function(){ $('#uploadedFiles').remove();
				        	
				         		 $("#uploadandremove").hide();
				         		window.location.reload();
				         	
				        	}, 4000); 
			        	
			        }else{
			        	$("#result").text("File(s) not uploaded");
			        	$(".widthProgress").css("display", "block").css("background", "red");
			        	 $(".widthStatus").text("Failed").css("color", "red");
			        }	
		        	

		        },
		        error: function (e) {

		            $("#result").text(e.responseText);
		            console.log("ERROR : ", e);
		            $("#btnSubmit").prop("disabled", false);

		        }
		    });
		
	}else{
		$("#btnSubmit").prop("disabled", false);
	}
		

	}
	
function singlefileupload12(index,formData){ 
	 $("#"+index).attr("disabled", "disabled");
	

	  var formDataEntries = formData.entries(), formDataEntry = formDataEntries.next(), pair;
var newfile='';	    
	  
	  // or, if you are really into compact code
	 var countfile=1;
	    var es, e, pair;
	    for (es = formData.entries(); !(e = es.next()).done && (pair = e.value);) {
	       if(countfile==index){
	    	   newfile=pair[1];   break;
	       }
	       countfile++;
	    }
	  
	  
	   var  propertyval=$('#iremsnumber'+index).val();
	   var regexp = /^(800)(\s*[\_]\s*)?\d{6}$/;
if(regexp.test(propertyval)){
	var doctyped=$('#doctype'+index).find(":selected").val();
	if($('#doctype'+index+' option[value="'+doctyped+'"]').attr("disabled") ||  $('#doctype'+index+' option[value="'+doctyped+'"]').prop("disabled"))
	 {
		 $("#result").text("Selected document type is deprecated").css("color", "red");
		 $('#doctype'+index).css("border", "1px solid red");
		 $("#"+index).removeAttr("disabled");
	  }else{
	
	 $('#iremsnumber'+index).css("border", "1px solid rgb(169,169,169)");
	 $('#doctype'+index).css("border", "1px solid rgb(169,169,169)");
	  
	$("#status"+index).text("Uploading").css("color", "green");  
	$("#progress"+index).css("display", "none"); 
	$("#barprogress"+index).css("display", "block"); 
	
	
	
	//var newfile = file.get('file'+index);
	
   var sessionid= '<%=sessionid%>';
	var cid='<%= cid %>';
	var uid='<%= uid %>';
	var documentType=[];
	
	documentType.push(doctyped);
	
	
	//var documentType = $('#doctype'+index).find(":selected").text();
	var propertyID=[];
	propertyID.push(propertyval)
	 var form1 = $('#fileUploadForm1')[0];
	 var dataform = new FormData(form1);
	 
	 dataform.append('documents', newfile); 
	 var str="userId="+uid+"&propertyID="+propertyID+"&documentType="+documentType+"&sessionId="+sessionid+"&companyId="+cid;
	 $("#result").text("");
	    $.ajax({
	        type: "POST",
	        enctype: 'multipart/form-data',
	        url : "<%=restURL%>/orcf/addDocumentsMFHD?"+str,
	        data: dataform,
	        //http://api.jquery.com/jQuery.ajax/
	        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
	        processData: false, //prevent jQuery from automatically transforming the data into a query string
	        contentType: false,
	        cache: false,
	        timeout: 0,
	        success: function (data) {
	        	$("#barprogress"+index).css("display", "none");
	        if(data.status=='success'){
	        	 $("#result").text("To confirm successful uploads, visit Pending Uploads").css("color", "green");
	        	
		        $("#progress"+index).css("display", "block").css("background", "green");
		        	$("#status"+index).text("Uploaded").css("color", "green"); 
		        //	removefileformdata('file'+index);
		        	  setTimeout(function(){ $('#li_'+index).remove();
		        	  $("#result").text("");
		        	  
		        	 if ($('#myTablebody').children('tr').length>1)
		         	{
		             	 $("#uploadandremove").show();
		         	
		         	}else{
		         		 $("#uploadandremove").hide();
		         	}
		        	}, 5000);  
		        	
		            
	        	
	        }else{
	        	
	        	$("#"+index).removeAttr("disabled");
	        	$("#result").text("File not uploaded").css("color", "red");
	        	$("#progress"+index).css("display", "block").css("background", "red");
	        	$("#status"+index).text("Failed").css("color", "red");
	        }
	        	
	        
	        	 
	            
	        },
	        error: function (e) {
	        	$("#"+index).removeAttr("disabled")

	            $("#result").text(e.responseText).css("color", "red");
	            console.log("ERROR : ", e);
	            $("#btnSubmit").prop("disabled", false);

	        }
	    });
}	
}else{
	$("#"+index).removeAttr("disabled")
 $('#iremsnumber'+index).css("border", "1px solid red");
    $("#result").text("Enter valid IREMS #").css("color", "red");
}
	   
	
	
}
function removefileformdata(param){
	$("#fileuploadId").val(param);	
	console.log("fileuploadId:"+$("#fileuploadId").val()	)
	 setTimeout(function(){ 
		 $('#dataremove').trigger("click");
	        	}, 1000);  
	
	
}
$('document').ready(function(){
	
/* $('#card').tooltip('show') */;
displayFolderStructure();

<%-- alert('<%= appuserrole %>'); --%>

<%--  if ( "PRODUCTION" === '<%= appuserrole %>')  --%>
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
				//$('#flip-container').quickFlipper({ }, flipid, 1);
				
				return false;
			});
		});
	});
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
$(document).mousemove(function(event){
	  InitializeTimer();
});
function initial_load() {
	setHeader('dropbox.jsp');
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
		 if(array_of_li[i].textContent.trim()=='Dropbox'){
	     		array_of_li[i].setAttribute("class", "active");	
	     	}
	}
	
	
	
//     //alert(data);
//     var dataArray = data.split(',');
   
//     for(var i=0; i< dataArray.length;i++)
//     {
//         if((dataArray[i].split("/").length-1) === 2)
//         {
// 	       	var str =  dataArray[i];
//         	//alert("Pushing "+ str);
//         	s.push(str);
//         }
       
//     } 
    
  
	 // $('#adminWizardLi').click();
	

 	getdropdowns();
 
	// session();
	 //   $('#folderNameFViewDataone').hide();
	
	
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
 

	
	   $('#my_popup').popup('show');
	   $('#basic').css("display","block");
	   $('#myDiv').hide();  
	   $('#searchResults').hide();
	   var companyIdValue= '<%= cid %>';
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getFHANumbersByProperty?propertyId="+id+"&companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				 $('#my_popup').popup('hide');
				 $("#indexvalues").html("");
					 $("#textError").empty();
					  $("#indexvalues").append("<option>Select FHA Number</option>");
				for(i=0;i<data.response.length;i++){
				       $("#indexvalues").append("<option value='"+data.response[i].fhaNumber+"'><b>"+data.response[i].fhaNumber+"</b></option>");
				       
				      } 
				if(input.length != 0){
					document.getElementById("indexvalues").value = input;
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
            //url:"GetDocTypeDropdown?comid=1&doctypeId=1",
            url:"<%=restURL%>/orcf/getDocType?companyId="+comid,
            dataType: "json",
            success: function (data) {
            	//alert("619::"+data.docTypeData[0].value);
            		

                $.each(data.response,function(i,obj)
                		
                {                	
                	var	div_data="<option value="+obj.docTypeMasterId+">"+obj.docTypeMasterDesc+"</option>";
                	$(div_data).appendTo('#doctype'); 
                	
                });
                //console.log("div_data:"+div_data)
               		/* if(data.docTypeData.length > 1)
                		document.getElementById("doctype").selectedIndex =1;*/
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
	window.location="addDocuments.jsp";
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
    	 message += " Property Type ,";
	 }
	 
	 if($("#doctype").val()=="" || $("#doctype").val() == null ){
		 isAvailble= false;
    	 message += " Doc Type ,";
	 }
	 
	 if($("#indexvalues").val()=="" || $("#indexvalues").val() == null  || $("#indexvalues").val()=="Select FHA Number" ){
		 isAvailble= false;
    	 message += " FHA Number ,"; 
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
	

	if( '<%= appuserrole %>'.toUpperCase().indexOf("PRODUCTION") != -1)
		{
		 tabContent2();
		} 
	
	 }else{
			//	 alert("Please "+message);
		// if(message.endsWith(",")){
		  if(message.substring(message.length-1)==','){
				message = message.substring(0, message.length - 1);
			}
	    document.getElementById("textError").innerHTML = message ;
	 }
		
	 }

function tabContent2()
{
		 //checkIfDone();
		 
$("#propertyIdData").html($('#propertytype option:selected').html());
	 
	$("#fhaNumberData").html($('#indexvalues option:selected').html());
			 
		 var noOfFiles = document.getElementById('uploadedFiles').getElementsByTagName('li').length;
		 if(noOfFiles >= 1) //If there are files in the upload list; make upload button visible
		 {
		 		 document.getElementById('upload_btn').style.display = 'block'; 
		 		 document.getElementById('upload_btn').style.position= 'absolute';
		 		 document.getElementById('upload_btn').style.top = '0px';
		 		 document.getElementById('upload_btn').style.left = '50%';
		 		
		 		 
		 }
		 
		/*  var folderNameFView =document.getElementById('folderNameFView').value;
         
         alert("folderNameFView"+folderNameFView);
         */ 
		 		 $('#flip-container').quickFlipper({ }, 2, 1);
		 		 setActive(2);		
	
		
		  /* $('#flip-container').quickFlipper({ }, 1, 1);
		  setActive(1);	   */
		 		
}
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
			
		document.getElementById('doctype').selectedIndex = 0;	
		document.getElementById('indextype').selectedIndex = 0;	
		document.getElementById('indexvalues').selectedIndex = 0;	
		document.getElementById('realtxt').value =""; 
		document.getElementById('fhanumber').value =""; 
		
		
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
<%}else{
	response.sendRedirect("index.jsp");
} 
	}catch(Exception ie){
		response.sendRedirect("index.jsp");
	}
%>
</body>

</html>
