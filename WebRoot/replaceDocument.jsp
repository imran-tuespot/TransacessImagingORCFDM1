<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.commons.lang.*,java.io.*"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TransAccess Imaging</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
			<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
				<script type="text/javascript" src="js/bubble-tooltip.js"></script>
</head>

<jsp:include page="includes/sessionHeader.jsp" />

<% 
 String docTypeId ="";
  if(!StringUtils.isBlank((String)request.getParameter("docTypeId"))){
  docTypeId = request.getParameter("docTypeId").toString();
  }
int uid = Integer.parseInt(request.getSession()
		.getAttribute("userid").toString());
		
		
  String dcTyp ="";
 if(!StringUtils.isBlank((String)request.getParameter("dcTyp"))){

 dcTyp= request.getParameter("dcTyp").toString();
 }
  
  String status = ""; 
 if(!StringUtils.isBlank((String)request.getParameter("status"))){
  status=request.getParameter("status").toString();
 }
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  
  String docId = "";
  if(!StringUtils.isBlank((String)request.getParameter("docId"))){
  docId=request.getParameter("docId").toString();
  }
    
  String version = "";
   if(!StringUtils.isBlank((String)request.getParameter("version"))){
  version=request.getParameter("version").toString();
   }
  String fileName = "";
     if(!StringUtils.isBlank((String)request.getParameter("id"))){

  fileName=request.getParameter("id").toString();
	 }  
  String actualFileName = "";
   if(!StringUtils.isBlank((String)request.getParameter("actualFileName"))){
 actualFileName= request.getParameter("actualFileName");
   }
  String success = 	request.getParameter("success");
  System.out.println("success"+success);
  String comid = 	request.getParameter("comid");
  String userName = request.getSession().getAttribute("username")
			.toString();
  String oldFile = "";
 
  if(!StringUtils.isBlank((String)request.getParameter("oldFile"))){
  	oldFile = request.getParameter("oldFile").toString();
  }
  
  javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl"); 
	String repository = (String) ctx.lookup("java:comp/env/repository");
	String repositoryURL = (String) ctx.lookup("java:comp/env/URL");

	
	String fileNameExt = fileName.substring(fileName.lastIndexOf('.') + 1);


	 String fileSize=null;
	  
	 File file=new File(repository+"/"+fileName);
	  
	  if (file.length() >= 1000000000) {
		  fileSize=file.length() / (1024 * 1024 * 1024) + "GB";
	  }

	  else if (file.length() >= 1000000) {
		  fileSize= file.length() / (1024 * 1024) + "MB";
	  }
	  else{
		  fileSize =file.length() / 1024 + "  KB";
	  
	  }
  
%>


<body  onLoad="javascript:successMsg('<%=success%>');" >



<table align="center" width= "100%" >
	<tr valign=top>
		<td width="75%">
		
			<div id ="confirmReplace" style ="display:none;" align=center>
			<font color=red><b>Replace Confirmation</b></font>
			<br><br>
			Are you sure you want to <br>
			replace this file?
			<br><br>
			<input type="button" name="confirmAttach" value="Yes"  onClick="javascript:confirmAttach()"/>
			<input type="button" name="cancel" value="No" onClick="javascript:rejectAttach()"/>
			<br><br>
			<font color=red><b>Note: </b></font> Once you select yes all changes are final
			</div>
			
			<div id ="successMessage" style ='display:none;' align=center>
			<font color=green><b>File has been successfully replaced</b></font>
			</div>
			<div id ="failureMessage" style ='display:none;' align=center>
			<font color=red><b>Error while replacing file. Please contact system administrator.</b></font>
			</div>
			<br>
			
			
			<div id='initialImage'  style='display:block'>
			
			<iframe  id="iframe1"  frameborder="0"  marginwidth="0"  marginheight="0"  scrolling="auto"  width=100%  height=450   
			src="<%-- ./DisplayPdfs?id=<%=fileName%>&sessionid=<%=sessionid%> --%>" >
			</iframe>
			
			</div>
		
		</td>
	
		<td width="25%">
			<form name="upload" method="post" action="./FileUpload" enctype="multipart/form-data">
				<div id = "fileUpload">
				
					<input type="hidden" id ="docTypeId" name="docTypeId" value="<%=docTypeId%>"/>
					
					<input type="hidden" id ="dcTyp" name="dcTyp" value="<%=dcTyp%>"/>
					<input type="hidden" id ="fileName" name="fileName" value="<%=fileName%>"/>
					<input type="hidden" id ="actualFileName" name="actualFileName" value="<%=actualFileName%>"/>
					<input type="hidden" id ="status" name="status" value="<%=status%>"/>
					<input type="hidden" id ="comid" name="comid" value="<%=comid%>"/>
					<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
					<input type="hidden" id ="docId" name="docId" value="<%=docId%>"/>
					<input type="hidden" id ="version" name="version" value="<%=version%>"/>
					<input type="hidden" id ="success" name="success" value="<%=success%>"/>
					<input type="hidden" id ="confirmParam" name="confirmParam"/>
					
					<input type="hidden" id ="oldFile" name="oldFile" value="<%=oldFile%>"/>
					
					<b>File Search</b>
					<br />
					<br />
					Search for file by clicking Browse.
					<br />
					
					<br />
					<div id = "disabledBrowse" >
					<input type=file id ="browseFile" name = "browseFile" style='display:block' onChange="javascript:enableConfirm();">
					</div>
					
					<br />
					
					<div id = "disableAttach" style='display:none'>
					<input type=submit id ="attachFile" name = "attachFile"  value= "Attach">
					</div>
				
				</div>
			
			
			</form>
		</td>
	
	

</table>

<script language="javascript">

/*
function enableConfirm(){
	
	if (document.getElementById('browseFile').value != ''){
		document.getElementById('disableAttach').style.display = 'block';
	}

}
*/

function enableConfirm(){
	document.getElementById('failureMessage').style.display = 'none';
	var fileVal = document.getElementById('browseFile').value;
	
	if (fileVal != ''){
	
		if(fileVal.indexOf(".pdf") < 0){
			successMsg("errorFileType");
			document.getElementById('disableAttach').style.display = 'none';
		}
		else{
			document.getElementById('disableAttach').style.display = 'block';
		}	
	}

}

function confirmAttach(){
	document.getElementById('confirmParam').value = 'Yes';
	document.upload.submit();

}

function getPdf(filename) {
	
	var user = '<%= uid%>';
	var id = '<%= fileName%>';
	var com = '<%= comid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
var downloadOriginal=false;
var fileSize='<%= fileSize%>';

var fileSizedata=fileSize.substring(0,fileSize.length - 2); 
var bytedata=fileSize.substring(fileSize.length - 2,fileSize.length); 


if(bytedata.toLowerCase() == 'mb' && fileSizedata > 10)
	{
		downloadOriginal=true;
	}
	
//var id = filename;

//alert("id"+id)

var fileNameExt = id.substr(id.lastIndexOf('.') + 1);

	if (fileNameExt == "doc" || fileNameExt == "docx"
			|| fileNameExt == "xlsx" || fileNameExt == "xls"
			|| fileNameExt == "jpg" || fileNameExt == "jpeg") {
<%-- 		var Text = "<%=repositoryURL%>DisplayNonPdf?fileName=" + id ;
 --%>		var Text = "<%=repositoryURL%>DisplayFile?filePath=" 
		 				+id+'&output=embed';
		var repository="<%=repository.replaceAll("\\\\", "/")%>";
		$('#iframe1').attr("allowfullscreen");
		 
		$('#iframe1').attr('src',"https://docs.google.com/gview?url="+Text)
		
		
	
		//window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
		/* var popout = window
				.open(
						Text,
						'_blank',
						'toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=15000, top=15000, width=50, height=50, visible=none',
						''); */

		/* window.setTimeout(function() {
			popout.close();
		}, 8000);
 */
	}

	else {

	sessionStorage.setItem('downloadOriginal',downloadOriginal);
	
						var fPath = "<%=restURL%>/role/invokeFile?id="+id;
						console.log("365..."+fPath);
						$.ajax({					   		 
						   	type : "GET",
						    contentType : "application/json",
						   	url : "<%=restURL%>/role/invokeFile?id="+id,
						   	timeout : 100000,
						   	success : function(resp) {
						   		console.log("success getting file"+resp);
						   		//sessionStorage.setItem('filename',"../../../../TransAccessImagingWS/role/downloadOriginal?id=FHA232/webtest1/"+resp);
						   		 sessionStorage.setItem('filename',"../../../../TransAccessImagingWS/role/downloadDocument?docId="+resp.substring(0,resp.lastIndexOf("_")));
								//var pdfurl1='viewer.html?file='+resp;
								var pdfurl1='viewer.html?file='+resp+'&restURL=<%=restURL%>';
								console.log('pdf url...'+pdfurl1);
								$('#initialImage').css("display","block");
								$('#iframe1').attr('src', pdfurl1)
								//$('#iframe1').src=pdfurl1;
							 	var dataobj= window.frames
								dataobj.onbeforeunload = function(){
									$.ajax({
											type : "GET",
										    contentType : "application/json",
										   	url : "<%=restURL%>/role/deleteFile?id="+resp,
										   	timeout : 100000,
							                success: function(msg){
							                    //alert("delete file status:    "+msg)
							                },
							             });
									return null;
								}
						   		 sessionStorage.setItem('resp',resp);

								/* var pdfWindow = window
									.open(
											pdfurl1,
											'',
											'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes'); */
							
								
								
						   	  },
						   	  error : function(e) {
						   	   console.log("ERROR: ", e);						   	       
						   	  },
						   	  done : function(e) {
						   	  }
						   	});							
						
		  <%-- var pdfurl = '<%=restURL%>'+"/role/ResponseBodyStreamFixed?id="+ id; --%>
		  
			//var Text = "displayPdf.html";
			
			//sessionStorage.setItem('filename',id);
					
			/*  window
					.open(
							Text,
							'',
							'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');  */
		/* 					
			window
				.open(
						pdfurl1,
						'',
						'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes'); */
				
	}
}


function rejectAttach(){
	document.getElementById('confirmReplace').style.display = 'none';
	<%fileName = oldFile;%>
	var oldfile = '<%=fileName%>';
	
}

function successMsg(msg){
	 $(".headPageContainer").hide();
	  $(".userInformaiton").hide();	
	  $(".mainBlueHeading").hide();
	//setHeader('replaceDocument.jsp');
	var comid = '<%= comid%>';
	var sessionid = '<%= sessionid%>';
	var docId = '<%= docId%>';
	var status = '<%= status%>';
	
	var dcTyp = '<%= dcTyp%>';
	
	var id = document.getElementById('fileName').value;
	var version = '<%= version%>';
	var docTypeId = '<%= docTypeId%>';
	
	var qryString = 'docId='+docId+'&sessionid='+sessionid+'&status='+status+'&comid='+comid+'&dcTyp='+dcTyp+'&id='+id+'&version='+version+'&docTypeId='+docTypeId+"&formAction=";
	
	setHeaderText('Replace Document','Document Details','./EditDocument?'+qryString);
	
	if(msg == "yes"){
		document.getElementById('confirmReplace').style.display = 'block';
	}
	
	if(msg == "confirmed"){
		document.getElementById('successMessage').style.display = 'block';
		document.getElementById('confirmReplace').style.display = 'none';
	}
	
	if(msg == "error"){
		document.getElementById('failureMessage').style.display = 'block';
		document.getElementById('confirmReplace').style.display = 'none';
	}
	
	if(msg == "errorFileType"){
		document.getElementById('failureMessage').style.display = 'block';
		document.getElementById('failureMessage').innerHTML = "<font color=red><b>PDF files can only be replaced... Please browse and attach a PDF file.</b></font>"; 
		
		document.getElementById('confirmReplace').style.display = 'none';
	}
	    $("#iframe1").attr('onload', getPdf("ddd"));

	
}



</script>


</body>

</html>
