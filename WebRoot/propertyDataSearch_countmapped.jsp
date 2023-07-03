<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.lang.*"%><%@page import="java.util.*"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<jsp:useBean id="folderBean" scope="request"
	class="com.peniel.beans.FolderBean" />

<html lang="en">
<head>
<!--   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
 -->
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bootstrap 101 Template</title>
<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
<!-- <link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" /> -->
	<link rel="stylesheet" href="css/jquery.dataTables.min.css" />  <!-- 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- <script src="js/jQuery/1.11.3/jquery.min.js"></script> -->
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
	<script
	src="js/bootstrap/3.3.5/jquery.min.js"></script>
<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>
<!-- <link href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" /> -->
	<link
	href="css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" />
<script src="jscript/jquery.easing.js" type="text/javascript"></script>
<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css"
	media="screen" />

<!-- <script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> -->
	<script src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script type="text/javascript"
	src="js/jquery.formatCurrency-1.4.0.min.js"></script>

<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<!-- <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
 <script src="js/jQuery/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#startDate" ).datepicker();
  } );
  $( function() {
	    $( "#endDate" ).datepicker();
	  } );
  
 
  </script>
<%
	String appuserrole = (String) request.getSession().getAttribute(
			"appuserrole");
	System.out.println("appuserrole " + appuserrole);
	int uid = Integer.parseInt(request.getSession()
			.getAttribute("userid").toString());
	String sessionid = request.getSession().getAttribute("sessionid")
			.toString();
	int cid = Integer.parseInt(request.getSession()
			.getAttribute("comid").toString());
	String userName = request.getSession().getAttribute("username")
			.toString();
	  
	String propertyId = "";
	String propertyName = "";
	String fhaNumber = "";
	String loanType = "";
	String loanAmt = "";
	String lenderName = "";
	String closingDate = "";
	String status = "";
	String result = "";
	String transactionType = "";
	String transactionDate = "";
	String transactionStatus = "";

	propertyId = request.getParameter("propertyId");
	propertyName = request.getParameter("propertyName");
	fhaNumber = request.getParameter("fhaNumber");
	loanType = request.getParameter("loanType");
	loanAmt = request.getParameter("loanAmt");
	lenderName = request.getParameter("lenderName");
	closingDate = request.getParameter("closingDate");
	if(!StringUtils.isEmpty(request.getParameter("transactionType")))
	{
	transactionType = request.getParameter("transactionType");
	request.getSession().setAttribute("transactionType",transactionType);
	}
	if(!StringUtils.isEmpty(request.getParameter("transactionDate")))
	{
	transactionDate = request.getParameter("transactionDate");
	request.getSession().setAttribute("transactionDate",transactionDate);
	}
	if(!StringUtils.isEmpty(request.getParameter("transactionStatus")))
	{
	transactionStatus = request.getParameter("transactionStatus");
	//request.getSession().setAttribute("transactionStatus",transactionStatus);
	}
	
	
	status = request.getParameter("status");
	result = request.getParameter("result");
	
	if (!StringUtils.isEmpty(result)) {
		propertyId = result.replace("/", " > ");

	} else {
		result = propertyId;
	}
	String folderPatteren = request.getSession()
			.getAttribute("folderPatterens").toString();
//	System.out.println("folderPatteren--->"
		//	+ folderPatteren.replaceAll("\\[|\\]", ""));

	javax.naming.Context ctx = new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	  
	/* 	  List<String> html = folderBean.getFolderNameGridHTML(""+cid,"800025208"); 
	 request.getSession().setAttribute("folderData", html); */
%>



<script type="text/javascript">
   $(document).ready(function(){
	   setHeader('propertyDataSearch.jsp');
	   $( function() {
			$('.currency').formatCurrency();
		  } );
	
	  <%--  var data = '<%=html%>'; --%>
	  $(".headPageContainer").hide();
	  $(".userInformaiton").hide();	
	  $(".mainBlueHeading").hide();
	  
	   var propertyId = '<%=propertyId%>'.split(' > ').join('/');
	   
		  getFilesist(propertyId);
	   displayTreefolderStructure(propertyId);
	 

	  
	  	
	      	
   });
	var pathData="";
   function getFilesist(path){
	// alert("kfhdjfgj"+path);
	 
	
	    var propertyId='800025208';

	   	 var companyId = '<%=cid%>';
	   	 var userIdvalue='<%=uid%>';
	   	 var tbl = '';
	   	  var testData={
	   			 // "propertyId":$("#propertyId").val(),
	   			     "propertyId":path,
	   			  	     "propertyName":$("#propertyNm").val(),
	   			  	     "city":$("#city").val(),
	   			  	     "state":$("#state").val(),
	   			  	     "zip":$("#zip").val(),
	   			  	     "fhaNumber":$("#fhaNum").val(),
	   			  	     "loanType":$("#roleNameVal").val(),
	   			  	     "loanAmount":$("#loanAmt").val(),
	   			  	     "lenderName":$("#lenderNm").val(),
	   			  	     "startDate":$("#startDate").val(),
	   			  	     "endDate":$("#endDate").val(),	   			  	     
	   			  	     "loanTypeData":'',			  	     
	   			  	     "companyId":companyId
	   	     
	   	   };
	   	  
	   
	   	
	    
	   	 $.ajax({
	   		 
	   	  type : "POST",
	   	  contentType : "application/json",
	   		url : "<%=restURL%>/orcf/getPropertyDocumentList",
	         dataType : 'json',
	   	  timeout : 100000,
	   	  data : JSON.stringify(testData),
	   	  success : function(data) {
	   		  //console.log("SUCCESS: ", data);
	   		  if ($.fn.DataTable.isDataTable("#searchResTable")) {
				  $('#searchResTable').DataTable().clear().destroy();
				}
	   		  
	   		$('#getDocumentList').empty();
	   		  
	   		$('#getDocumentList').append(displayfolderstructure(path));
           
	   		  displayData(data,path);
          
	   		  	
/* 	   			$("#searchResTable").DataTable();
 */ 	   			
	   			
	   	  },
	   	  error : function(e) {
	   	   console.log("ERROR: ", e);
	   	       
	   	  },
	   	  done : function(e) {
	   		 
	   		//  tbl.fnClearTable(this);
	   	  }
	   	 
	   	 });
	   	/*  }else{
	   		 alert("Provide:"+message);
	    } */
	   	
	   	$('#getDocumentList').empty();
	
		 
		}
   
 

function getPropertyList(){
	 //$('#propertyList').empty();		
/* 	location.reload(); */
 
 var datatype="";

	 var companyId = '<%=cid%>';
	 var userIdvalue='<%=uid%>';
	 var tbl = '';
	  var testData={
			 // "propertyId":$("#propertyId").val(),
			 "propertyId":propertyId,
			  	     "propertyName":$("#propertyNm").val(),
			  	     "city":$("#city").val(),
			  	     "state":$("#state").val(),
			  	     "zip":$("#zip").val(),
			  	     "fhaNumber":$("#fhaNum").val(),
			  	     "loanType":$("#roleNameVal").val(),
			  	     "loanAmount":$("#loanAmt").val(),
			  	     "lenderName":$("#lenderNm").val(),
			  	     "startDate":$("#startDate").val(),
			  	     "endDate":$("#endDate").val(),
			  	     
			  	     "loanTypeData":datatype,			  	     
			  	     "companyId":companyId
	     
	   };
	  
/* 	  $("#searchResTable").DataTable().ajax.reload();
 */	// if(isAvailble == true){
	
 
	 $.ajax({
		 
	  type : "POST",
	  contentType : "application/json",
		url : "<%=restURL%>/orcf/getPropertyList",
      dataType : 'json',
	  timeout : 100000,
	  data : JSON.stringify(testData),
	  success : function(data) {
		  //console.log("SUCCESS: ", data);
		  if ($.fn.DataTable.isDataTable("#searchResTable")) {
				  $('#searchResTable').DataTable().clear().destroy();
				}
		  display(data);
		
			$("#searchResTable").DataTable();

	  },
	  error : function(e) {
	   console.log("ERROR: ", e);
	       
	  },
	  done : function(e) {
		 
		//  tbl.fnClearTable(this);
	  }
	 
	 });

	
	 $('#propertyList').empty();
	 
	}
 
 
function displayTreefolderStructure(propertyId){
	
	/* alert(propertyId) */
	
	var propertyPath=propertyId;

	/* $("#myField").html(propertyPath.split('/').join(' > ')); */
	
       var pathdatainfo=propertyPath.split('/')
        $('#myField').html('');
	   for(var x=0;x<pathdatainfo.length;x++){
		
	     $('#myField').append('<a id="edit'+x+'"  onclick="selectFolderData(this.text,\''+propertyPath+'\')" href="#myModal">'+pathdatainfo[x]+'</a>' + " > ");	
	   }
	
	   if(propertyId.charAt(0)!=("/"))   // if(!propertyId.startsWith("/"))//If Path contains dir 
	{
		   propertyId='/'+propertyId;
	}
	   if(propertyId.substring(propertyId.length-1)!='/')  // if(!propertyId.endsWith("/"))//If Path contains dir 
	   	{  
		   propertyId = propertyId+'/';
	   	}
	   
	  
	  
	   var s=[];
		var prop;
		var data;
	if((propertyId.split("/").length-1) > 2)
		   {	   
		  
    	prop=propertyId.split("/");
		data="/"+prop[1]+"/";
		$("#propertyData").html(prop[1]);
		  
		   var i;
			
			var temp='';
			
			   for(i=1;i<prop.length-1;i++){
			  
			    temp+="/"+prop[i];	 
			      
				s.push(temp+"/")
			   }
			       
		   }
	   else
		   {
			data=propertyId;
			 prop=propertyId.split("/");
			$("#propertyData").html(prop[1]);
			s.push(propertyId)
		 
		   }
// 	    alert(s) ;
	    $('#fileTreeDemo_3').fileTree({ root: '/',  expandedFolders: s, 
	   	 script: 'connectors/jqueryFolderTreeData.jsp?propertyId='+data, folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'One moment...' }, function(file) { 
	   					//alert(file);
	   		
	   	
	   	});
} 
 
function displayfolderstructure(propertyId){
	
	<%--  var propertyId = '<%=propertyId%>'.split(',').join('/') --%>
	  $('#getDocumentList').fileTree({ root: '/',
		   	 script: 'connectors/jqueryFolderTreeData.jsp?flag=10&propertyId='+propertyId ,folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'One moment...' }, function(file) { 
		   					//alert(file);
		   		
		   	
		   	}); 
} 
function display(data) {
	$.each(data.getPropertyList, function(i, item) {
	     $('#propertyList').append('<tr><td><a id="editB" onclick="hello();" href="#myModal">'+item.propertyName+'</a></td><td><a id="editB" href="#" onclick="hello()">'+item.propertyId+'</a></td><td><a id="editB" href="#" onclick="hello()">'+item.fhaNumber+'</a></td><td>'+item.city+'</td><td>'+item.state+'</td><td>'+item.zip+'</td><td>'+item.loanType+'</td></tr>');
	});
}

function selectFolder()
{
	
//var path=$("#myField").val();
//alert("path123")
//	 displayTreefolderStructure(path);
//	getFilesist(path);
	
}

function selectFolderData(data,path)
{
	var temp1='';
	var pathdatainfo=path.split('/')
	
    for(var x=0;x<pathdatainfo.length;x++){
		 if(pathdatainfo[x] !== ""){
		 temp1+="/"+pathdatainfo[x];
		 }
		 if( pathdatainfo[x] === data) 
		 {
		  break;
		 }
	 }
	
	//  alert("*****"+temp1) 
	
	 displayTreefolderStructure(temp1);
		getFilesist(temp1);
	
}

function displayData(data,propertyId) {
	var imageName;
	/* debugger; */
	//sampleTest(propertyId);    
/* 	$('#getDocumentList').append(displayfolderstructure(propertyId));
 */	

 if(data.getDocumentList != undefined){
 $.each(data.getDocumentList, function(i, item) {
		var fileNameExt = item.actualFileName.substr(item.actualFileName.lastIndexOf('.') + 1);
		if(fileNameExt.toLowerCase() === "pdf"){
			imageName="pdfViewer.gif";
		}
		else if(fileNameExt.toLowerCase() === "jpg" || fileNameExt.toLowerCase() === "jpeg"){
			imageName="jpegsma.jpg";
		}
		else if(fileNameExt.toLowerCase() === "doc" || fileNameExt.toLowerCase() === "docx"){
			imageName="docLatest.png";
		}
		else if(fileNameExt.toLowerCase() === "xls" || fileNameExt.toLowerCase() === "xlsx"){
			imageName="excel_file.png";
		}
		item.disposalDate === null  ?item.disposalDate='':item.disposalDate;
		item.closingDate === null  ?item.closingDate='':item.closingDate;
		item.documentType === null  ?item.documentType='':item.documentType;
	     $('#getDocumentList').append('<tr><td>	<a href="javascript:getPdf(\''+item.fileName+'\',\''+item.fileSize+'\',\''+item.version+'\');" >'+item.actualFileName+
	     '&nbsp;&nbsp; &nbsp;&nbsp;<img src="./images/'+imageName+'" alt="View Document" style="width:20px" border=0></a></td><td><a id="editB" href="#" onclick="hello()">'+
	     fileNameExt+'</a></td><td><a id="editB" href="#" onclick="hello()">'+item.version+'</a></td><td>'+item.documentType+'</td></td><td><a id="details" href="#" onclick="editDoc(\''+item.fileName+'\',\''+item.fileName+'\',\''+item.getIndexType+'\',\''+item.getIndexValue+'\',\''+item.getDocumentType+'\',\''+item.fileName+'\',\''+item.getDocId+'\',\''+item.version+'\',\''+item.getIndexTypeId+'\',\''+item.getDocTypeId+'\')">Details</a></td><td>'+
	     item.closingDate+'</td><td>'+item.disposalDate+'</td></tr>');
	}); 
 }
}

function sampleTest(propertyId){
	$('#getDocumentList').append(displayfolderstructure(propertyId));
}


function editDoc(id, indTyp, val, dcTyp, status, docId, version, indexTypeId, docTypeId, formAction) {
	  
	

	    var user = '<%=uid%>';
	    var com = '<%=cid%>';
	    var session = '<%=sessionid%>';
	    var userName = '<%=userName%>';


	    var Text = "./EditDocument?id=" + id + "&indTyp=" + indTyp + "&val=" + val + "&dcTyp=" + dcTyp +
	            "&userid=" + user + "&comid=" + com + "&sessionid=" + session + "&userName=" + userName +
	            "&status=" + status + "&docId=" + docId + "&version=" + version + "&docTypeId=" + docTypeId +
	            "&indexTypeId=" + indexTypeId + "&formAction=";

	 //   window.open = Text;
	    var randomnumber = Math.floor((Math.random()*100)+1); 
	    var pdfWindow=  window.open(Text,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=850,height=500')
	    pdfWindow.onbeforeunload = function(){
			$.ajax({
					type : "GET",
				    contentType : "application/json",
				   	url : "<%=restURL%>/role/deleteFile?id="+sessionStorage.getItem('resp'),
				   	timeout : 100000,
	            success: function(msg){
	                //alert("delete file status:    "+msg)
	            
	            

	            },
	         });
			var timer = setInterval(function () {
	            if (pdfWindow.closed) {
	                clearInterval(timer);	                
	                window.location.reload(); // Refresh the parent page
	            }
	        }, 1000);

		}

	}

<%-- function getPdf(filename) {
	
	var com = '<%=cid%>';
	var session = '<%=sessionid%>';
	var userName = '<%=userName%>';
	
	var id = filename;
	
	var Text = "./DisplayPdf?id="+id+"&comid="+com+"&sessionid="+session+"&userName="+userName;
	window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');	
} --%>

function getPdf(filename,fileSize,version) {
	var user = '<%= uid%>';
var com = '<%= cid%>';
var session = '<%= sessionid%>';
var userName = '<%= userName%>';
//var id = filename;
var downloadOriginal=false;

//Kiran Changes Starts
var fileNameExtension = filename.substr(filename.lastIndexOf('.') + 1);
var action="";


//Kiran Changes Starts
if(fileNameExtension=="pdf"){
	action="View Document";
}else{
	action="Download Document";
}
//var docId=filename.substr(filename.lastIndexOf('/')+1);
//var documentData=[];
//documentData=docId.split('.');

sessionStorage.setItem('sessLogCompId',com);
sessionStorage.setItem('sessLogSessid',session );

sessionStorage.setItem('sessLogRestUrl','<%=restURL%>' );

sessionStorage.setItem('sessLogUserid',user );
sessionStorage.setItem('sessLogver',version);
sessionStorage.setItem('sessLogdocid',filename ); 
var documentData={
		 "sessionId":session,
		 "userId":user,
		 "companyId":com,
		 "documentId":filename,
		 "version":version,
		 "action":action,
		 "description":action
}
$.ajax({
	type : "POST",
	contentType : "application/json",
	url : "<%=restURL%>/audit/saveAuditReport",
	dataType : 'json',
	timeout : 100000,
	data : JSON.stringify(documentData),
	success : function(data) {
		console.log("SUCCESS: ", data);
		
	},
	error : function(e) {
		console.log("ERROR: ", e);
	},
	done : function(e) {
		console.log("DONE");
	}
});

//Kiran Changes Ends



var fileSizedata=fileSize.substring(0,fileSize.length - 2); 
var bytedata=fileSize.substring(fileSize.length - 2,fileSize.length); 


if(bytedata.toLowerCase() == 'mb' && fileSizedata > 10)
	{
		downloadOriginal=true;
	}
	
var id = filename;

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
								var pdfurl1='viewer.html?file='+resp;
								console.log('pdf url...'+pdfurl1);
								var pdfWindow = window
									.open(
											pdfurl1,
											'',
											'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
								pdfWindow.onbeforeunload = function(){
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




  </script>
<!-- Bootstrap -->
<!--     <link href="css/bootstrap.min.css" rel="stylesheet">
 -->
<link href="css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


<!-- Get roles and rights -->




<!-- Include the Sidr JS -->
<script src="js/jquery.sidr.min.js"></script>

<script src="jscript/jquery.easing.js" type="text/javascript"></script>
<!-- <script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" /> -->
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
<style>
.jqueryFileTree LI.directory {
	background: url(css/images/directory1.png) left top no-repeat;
}

.jqueryFileTree LI.expanded {
	background: url(css/images/folder_open1.png) left top no-repeat;
}

UL.jqueryFileTree A {
	color: #0B3861;
	font-family: roboto;
	text-decoration: none;
	display: block;
	padding: 0px 2px 4px;
}
.inner-box {
     border: 0px solid #ccc !important; 
    border-radius: 0px;
}
</style>


</head>
<DIV id=preview_div
	style="DISPLAY: none; POSITION: absolute; BORDER-LEFT-COLOR: #777777"></DIV>


<body id="test">


	<!--- content Part --->
	<section> <!--  <div class="modal fade" id="myModal" >
    <div class="modal-dialog propertyPopup"> --> <!-- Modal content-->
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">&times;</button>

		</div>
		<div class="modal-body">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
					style="padding: 0px;">
					<div class="col-lg-4 col-md-4 col-sm-5 col-xs-5">
						<div class="inner-box">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="border:1px solid #ccc !important;">
								<table class="pull-left propertyDetails">
									<tr>
										<td><b id="propertyName" class="text-capitalize">Property
												Name : </b></td>
										<td><%=propertyName%></td>
									</tr>
							<% if(!StringUtils.isEmpty(fhaNumber)){ %>
									<tr>
										<td><p id="fhaNum" class="text-capitalize">FHA Number
												:</p></td>
										<td><%=fhaNumber%></td>
									</tr>
								<%} %>
									<tr>
										<td><p id="propertyId" class="text-capitalize">Property
												ID :</p></td>
										<td id="propertyData" ></td>
									</tr>
								<% if(!StringUtils.isEmpty(loanType)){ %>
									<tr>
										<td><p id="loanTypes" class="text-capitalize">Loan
												Types :</p></td>
										<td><%=loanType%></td>

									</tr>
									<%} %>
									<% if(!StringUtils.isEmpty(loanAmt)){ %>
							<tr>
							<td><p id ="loanAmt" class="text-capitalize">Loan Amount :    </p></td>
							<td class='currency'><%=loanAmt%></td>
							</tr>
							<tr>
							<%} %>
							<% if(!StringUtils.isEmpty(closingDate)){ %>
							<td><p id ="closingDate" class="text-capitalize">Closing Date :  </p></td>
							<td><%=closingDate%></td>
							</tr>
							<%} %>
							
							<% if(!StringUtils.isEmpty(lenderName)){ %>
							
							<tr>
							<td><p id ="lenderName" class="text-capitalize">Lender Name :  </p></td>
							<td><%=lenderName%></td>
							</tr>
							<%} %>
							<% if(!StringUtils.isEmpty(status)){ %>
							
							<tr>
							<td><p id ="PropertyStatus" class="text-capitalize">Property Status :  </p></td>
							<td><%=status%></td>
							</tr>
							<%} %>

								</table>
							</div>

							<hr class="grey-hr">
							<div class=" box-height">

								<div>
									<div class="leftscrollbar">
										<div style="" align="center" width="100%">
											<div
												style="float: right; margin-bottom: 5px; margin-right: 10px">

												<input type="hidden" id="foltxt" placeholder="Search"
													style="width: 330px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
													onkeyup="javascript:searchFolSel();" /> <input
													id="folderNameFView" name="folderNameFView"
													readonly="readonly" type="hidden" size=40
													onkeypress="setFolderPatteren(this.options[this.selectedIndex].innerHTML)">
											</div>

											<div class="example" id="folderView">
												<div id="fileTreeDemo_3" class="folderStruct table "></div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="col-lg-8 col-md-8 col-sm-7 col-xs-7"
						style="padding: 0px;">
						<div class="folderBorder">
							<img src="images/folder.png" border="0"> > ORCF Database >
							<%-- <%=propertyId%> --%>
							<label id="myField" name="myField"> </label>
						</div>
						<div class="">
							<div class="">
								<ul id="folderDetails"></ul>
								<div id="tableStyle1">

									<div class="table-responsive">
										<br />
										<!-- 	<table id="searchResTable" class="table table-bordered">
											<thead>
												<tr>
													<th> Name</th>
													<th>Type</th>
													<th>Dcument Type</th>
													<th>Version Number</th>
													<th>Document Details</th>
													<th>Closing Date</th>
													<th>Deposit Date</th>
												</tr>
											</thead> -->
										<table id="searchResTable" class="table table-bordered">
											<thead>
												<tr>
													<th>Actual FileName</th>
													<th>File Type</th>
													<th>Version</th>
													<th>DocumentType</th>
													<th>Document Details</th>
													<th>Closing Date</th>
													<th>Disposable Date</th>
                                                    <!-- <th>Disposal Date</th> -->
												</tr>
											</thead>
											<tbody id="getDocumentList">


											</tbody>
										</table>
									</div>
								</div>
							</div>

						</div>
					</div>


				</div>
			</div>
		</div>

	</div>

	<script>
	
	
    
      
      </script> <!--  </div>
  </div> --> <!--- content Part ---> <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 --> <!-- Include all compiled plugins (below), or include individual files as needed -->
	<!-- <script src="js/bootstrap.min.js"></script> -->
</body>
</html>