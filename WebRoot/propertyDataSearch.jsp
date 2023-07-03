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
<!-- 	<link rel="stylesheet" href="connectors/style.min.css" />	 -->
	<script type="text/javascript"
	src="js/jquery.formatCurrency-1.4.0.min.js"></script>

<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<!-- <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
<!--  <script src="js/jQuery/jquery-ui.js"></script> --sribala-->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.7/jstree.min.js"></script>
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
		propertyId = result;

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
/****************sribala changes***********************/
var jstreeFolderData;
var pathObj;
$(function() {
  	
	var propertyIdval='<%=propertyId%>';
	var propid;
	var propArray=propertyIdval.split('/');
	if(propertyIdval.match("^/")){
	propid='/'+propArray[1]+'/';
	$("#propertyData").html(propArray[1]);
	}else {
		propid='/'+propArray[0]+'/';
		$("#propertyData").html(propArray[0]);
		propertyIdval='/'+propertyIdval;
	}	
	var cid='<%=cid%>';
	if(propid != '/Legacy Data/'){ 
	$.ajax({
	   		 
	   	  type : "GET",
	   	  contentType : "application/json",
	   		url : "<%=restURL%>/orcf/getJSTreeFolderJson?propertyId="+propid+"&path="+propertyIdval+"&compId="+cid,
	         dataType : 'json',
	   	  timeout : 100000,
	   	  success : function(data) {
	   		  jsTreeFolderData = data.response;
	   	  $('#jstree').jstree({
	   	           'core': {
              'data': jsTreeFolderData
          }
      }).on('open_node.jstree', function (e, data) {
    	  openTheNode(data);
	      }).on('activate_node.jstree', function(event, data) {
	    	  $('#jstree').jstree(true).toggle_node(this);
	    	  activateTheNode(data);
			}).on('open_all.jstree', function(event, data) {
		    	  $('#jstree').jstree(true).toggle_node(this);
	    	  activateTheNode(data);
			}).on('changed.jstree', function (e, data) {
				  //var path = data.instance.get_path(data.node,'/');
				 /*  alert('Selected: ' + path);  */
				})	
       
	   	  },
   	  error : function(e) {
   	   console.log("ERROR: ", e);
   	       
   	  },
   	  done : function(e) {
   		            	   	  }
   
 });	
	
	   }
	});
	
	function createTree(){
		$('#subFolderData').empty();
		$('#subFolderData').append('<div id = "showOnlyFolders"></div>');
		console.log(children);
		$('#showOnlyFolders').jstree({
				'core': {
					'data': children
				}
			}).on('activate_node.jstree', function(event, data) {
		    	  $('#jstree').jstree(true).toggle_node(this);
						onSubFolderActive(data)
		})
			}
	
	function myFunc(id, index) {
		
		var sampleData = JSON.parse(JSON.stringify(jsTreeFolderData));
		
		var nodes = $("#jstree").jstree(true).get_selected("full", true);
		$('#jstree').jstree(true).toggle_node(this);
		$.each(nodes,function(i, node){
			$('#jstree').jstree(true).toggle_node(this);
		  if(node.children.length >= 0){
		    $("#tableArea").hide();
		    $("#subFolderData").show();
		  }
		  else{
			    $("#subFolderData").hide();
			    $("#tableArea").show();
		  }  
		});
		
		
		children = sampleData.filter(function(item) {
				return item.parent == id;
			});
		
			children.map(function(item) {
				delete item.parent
			})
			
			
			
			jsTreeFolderData.map(function(item) {
			if (item.id == id) {
				item.state = { "selected": true, "opened": true }
			} else {
				item.state = { "selected": false, "opened": false }
			}
		});
			
		
			
		pathObj  = pathObj.slice(0, index+1);
		var innerHtml = '';
		var count = 0;
		for (var i in pathObj) {
			innerHtml += '<span onclick = "myFunc(' + pathObj[i].pathId + ',' + count + ')">' + pathObj[i].pathString + '></span>'
			count++;
		}
		if(children.length > 0) {
			children.map(function(item){
			delete item.parent
			})
			createTree()
		} else {
			var path = '/';
			for (var i in pathObj) {
				/* path += pathObj[i].pathString + '/'; */
				 var str = pathObj[i].pathString;
				 var n = str.indexOf('(');
				 var part = str.substring(0,n);
				 path += part + '/';
				 
				 
				count++;
			}
			getFilesist(path);
		}
		if(children.length >0){
			  /* alert("child") */
		    $("#tableArea").hide();
		    $("#subFolderData").show();
		  }
		  else{
			  /* alert("no") */
			    $("#subFolderData").hide();
			    $("#tableArea").show();
		  }
		$('#myField').empty();
		$('#myField').append(innerHtml);
		$('#data').empty();
		$('#data').append('<div id = "jstree"></div>');
		$('#jstree').jstree({
			'core': {
				'data': jsTreeFolderData
			}
		}).on('open_node.jstree', function (e, data) {
    	  $('#jstree').jstree(true).toggle_node(this);	  		
    	  openTheNode(data)
	}).on('activate_node.jstree', function(event, data) {
  	    $('#jstree').jstree(true).toggle_node(this);
		activateTheNode(data);
	});
	}
	
	
	function openTheNode(data){
		var res = jsTreeFolderData.filter(function(item) {
				return item.state.selected == true && item.state.opened == true;
			})
			
			if (data.node.id == res[0].parent) {
			var sampleData = JSON.parse(JSON.stringify(jsTreeFolderData));
		children = sampleData.filter(function(item) {
				return item.parent == res[0].id;
			});
		
			
			console.log(children);
				pathObj = [];
				var path = data.instance.get_path(data.node, '/');
				/* alert() */
				var pathArr = path.split('/');
				var temp2 = JSON.parse(JSON.stringify(data.node.parents));
				temp2.pop();
				var tempPathIdArr = temp2;
				
				var pathIdArr = tempPathIdArr.reverse();
				for (var i = 0; i < pathIdArr.length; i++) {
					var tem1 = {
						pathString: pathArr[i],
						pathId: pathIdArr[i]
					}
					pathObj.push(tem1);
				}
				pathObj.push(
					{
						pathString: pathArr[pathArr.length - 1],
						pathId: data.node.id
					}
				)
				var innerHtml = '';
				var counter = 0;
				for (var i in pathObj) {
					innerHtml += '<span onclick = "myFunc(' + pathObj[i].pathId + ',' + counter + ')">' + pathObj[i].pathString + '></span>'
					counter++;
				}
				innerHtml += '<span onclick = "myFunc(' + res[0].id + ',' + counter + ')">' + res[0].text + '></span>'
				pathObj.push(
						{
							pathString: res[0].text,
							pathId: res[0].id
						}
					)
				$('#myField').empty();
				$('#myField').append(innerHtml);
				/* createTree(); */
			}
			

	console.log(pathObj);
		}
	
	

	function activateTheNode(data){

		var nodes = $("#jstree").jstree(true).get_selected("full", true);
		$('#jstree').jstree(true).toggle_node(this);
		$.each(nodes,function(i, node){
			$('#jstree').jstree(true).toggle_node(this);
		  if(node.children.length >0){
			  /* alert("child") */
		    $("#tableArea").hide();
		    $("#subFolderData").show();
		  }
		  else{
			  /* alert("no") */
			    $("#subFolderData").hide();
			    $("#tableArea").show();
		  }  
		});
		
		
		var sampleData = JSON.parse(JSON.stringify(jsTreeFolderData));
		children = sampleData.filter(function(item) {
				return item.parent == data.node.id;
			});
			children.map(function(item){
			delete item.parent
			})
			
			pathObj = [];
			var path = data.instance.get_path(data.node, '/');
			var pathArr = path.split('/');
			var temp2 = JSON.parse(JSON.stringify(data.node.parents));
			temp2.pop();
			var tempPathIdArr = temp2;
			var pathIdArr = tempPathIdArr.reverse();
			for (var i = 0; i < pathIdArr.length; i++) {
				var tem1 = {
					pathString: pathArr[i],
					pathId: pathIdArr[i]
				}
				pathObj.push(tem1);
			}
			pathObj.push(
				{
					pathString: pathArr[pathArr.length - 1],
					pathId: data.node.id
				}
			)
			if(children.length > 0) {
			children.map(function(item){
			delete item.parent
			})
			createTree()
		} else {
			var path = '/';
			for (var i in pathObj) {
				/* path += pathObj[i].pathString + '/'; */
				 var str = pathObj[i].pathString;
				 var n = str.indexOf('(');
				 var part = str.substring(0,n);
				 path += part + '/';
				 
				 
				count++;
			}
			getFilesist(path);
		}
			var innerHtml = '';
			var count = 0;
			for (var i in pathObj) {
				innerHtml += '<span onclick = "myFunc(' + pathObj[i].pathId + ',' + count + ')">' + pathObj[i].pathString + '></span>'
				count++;
			}
			$('#myField').empty();
			$('#myField').append(innerHtml);
		}
	
	function onSubFolderActive(data){
		func2(data.node.id)
		//activateTheNode(data);
		}
	
	
	
	
	function func2(id){
		
		var sampleData = JSON.parse(JSON.stringify(jsTreeFolderData));
		var res = sampleData.filter(function(item) {
			return item.id == id;
		});
		children = sampleData.filter(function(item) {
				return item.parent == id;
			});
			children.map(function(item){
			delete item.parent
			})
			if(children.length > 0) {
			children.map(function(item){
			delete item.parent
			})
			createTree()
		} else {
			var path = '/';
			for (var i in pathObj) {
				/* path += pathObj[i].pathString + '/'; */
				 var str = pathObj[i].pathString;
				 var n = str.indexOf('(');
				 var part = str.substring(0,n);
				 path += part + '/';
				//alert(str)
				 
				count++;
			}
			var str = res[0].text;
			 var n = str.indexOf('(');
			 var part = str.substring(0,n);
			 path += part + '/';
			// alert("path ..  "+path)
			getFilesist(path);
		}
			if(children.length >0){
				  /* alert("child") */
			    $("#tableArea").hide();
			    $("#subFolderData").show();
			  }
			  else{
				  /* alert("no") */
				    $("#subFolderData").hide();
				    $("#tableArea").show();
			  }
			jsTreeFolderData.map(function(item) {
				if (item.id == id) {
					item.state = { "selected": true, "opened": true }
				} else {
					item.state = { "selected": false, "opened": false }
				}
			});
			var innerHtml = '';
			var count = 0;
			for (var i in pathObj) {
				innerHtml += '<span onclick = "myFunc(' + pathObj[i].pathId + ',' + count + ')">' + pathObj[i].pathString + '></span>'
				count++;
			}
			$('#myField').empty();
			$('#myField').append(innerHtml);
			// $('#getDocumentList').empty();
			// $('#getDocumentList').append('<div id = "getData"></div>');
			$('#data').empty();
			$('#data').append('<div id = "jstree"></div>');
			$('#jstree').jstree({
				'core': {
					'data': jsTreeFolderData
				}
			}).on('open_node.jstree', function(event, data) {
		    	  $('#jstree').jstree(true).toggle_node(this);
							openTheNode(data)

		}).on('activate_node.jstree', function(event, data) {
	    	  $('#jstree').jstree(true).toggle_node(this);
							activateTheNode(data);
		});
			// $('#getData').jstree({
			// 	'core': {
			// 		'data': getDocumentList
			// 	}
			// });
		}
		
	
	
	
	
 	   
/* function displayFolderPathInHeader(data){
	var path = data.instance.get_path(data.node,'/');
    var splitSlash=[];
    	splitSlash=path.split("/");
    	var formPath="";
      	  var displayPath="";
    	for(i=0;i<splitSlash.length;i++){
    		var temp = splitSlash[i].substring(0,splitSlash[i].lastIndexOf("(")); 
    		
    		formPath+=temp.trim()+"/";
    	}
    	   	   
    	return formPath;
} */

 
/* function displayTreefolderStructure(propertyId){
	
	
	var propertyPath=propertyId;

	
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
}  */
/****************sribala changes***********************/

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
	  	      	
   });
	var pathData="";
   function getFilesist(path){
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
	   		  
	   		if(data) {
				$("#showLoading").show();
				setTimeout(function () {
			        // Do Something Here
			        // Then recall the parent function to
			        // create a recursive loop.

						$("#showLoading").hide();
			   		  displayData(data,path);
			    }, 1000);
	   		} else {
	   			alert("fasle")
	   		}
          
	  	  },
	   	  error : function(e) {
	   	   console.log("ERROR: ", e);
	   	       
	   	  },
	   	  done : function(e) {
	   		 
	   	  }
	   	 
	   	 });
	  	   	
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
		 
	  }
	 
	 });

	
	 $('#propertyList').empty();
	 
	}
 
 

 

function display(data) {
	$.each(data.getPropertyList, function(i, item) {
	     $('#propertyList').append('<tr><td><a id="editB" onclick="hello();" href="#myModal">'+item.propertyName+'</a></td><td><a id="editB" href="#" onclick="hello()">'+item.propertyId+'</a></td><td><a id="editB" href="#" onclick="hello()">'+item.fhaNumber+'</a></td><td>'+item.city+'</td><td>'+item.state+'</td><td>'+item.zip+'</td><td>'+item.loanType+'</td></tr>');
	});
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
	
	// displayTreefolderStructure(temp1);
		//getFilesist(temp1);
	
}

function displayData(data,propertyId) {
	var imageName;
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
	//$('#getDocumentList').append(displayfolderstructure(propertyId));
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
								var pdfurl1='viewer.html?file='+resp+'&restURL=<%=restURL%>';
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
						
				
	}
}




  </script>
<!-- Bootstrap -->
<!--     <link href="css/bootstrap.min.css" rel="stylesheet">
 -->
<link href="css/style.css" rel="stylesheet">

<!-- Include the Sidr JS -->
<script src="js/jquery.sidr.min.js"></script>

<script src="jscript/jquery.easing.js" type="text/javascript"></script>

<script type="text/javascript" src="js/jquery.alerts.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
<style>
    .folderArea { 
         	width: 300px; 
         	overflow: auto; 
     float: left; 
    padding-top: 15px; 
            } 
        	#jstree {
    text-align: left;
    float: left;}
    
    #jstree ul li {
    background:  url(css/images/folder_open1.png) left top no-repeat;
        display: table-row-group;
    }
    #jstree ul {
    	list-style: none;
    	padding-left: 12px;
    }
    #jstree ul li a { padding-left: 25px; }
    #showOnlyFolders ul li {
    background:  url(css/images/folder_open1.png) left top no-repeat;
        display: table-row-group;
    }
    #showOnlyFolders ul {
    	list-style: none;
    	padding-left: 12px;
    }
    #showOnlyFolders ul li a { padding-left: 25px; }
    #myField > span { 
    	cursor: pointer;
    	color: #0165f5;
    	}
    	
    	#myField > span:last-of-type {
    		color: #40bf28;
    		pointer-event: none;
    		font-weight: bold; 
    	}
    	#jstree ul li a.jstree-clicked {
    	color: #40bf28;
    	}
    	
    	section.tableArea {
  position: relative;
  border: 1px solid #000;
  padding-top: 37px;
  background: #737373;
}

.containerTable {
  overflow-y: auto;
  height: 400px;
      background: #fff;
}
.containerTable table {
  border-spacing: 0;
  width:100%;
}
.containerTable td + td {
  border-left:1px solid #eee;
  text-align: center;
}
.containerTable td, .containerTable th {
  border-bottom:1px solid #eee;
  background: rgb(247, 247, 247);
  color: #000;
  padding: 10px 0px;
}
.containerTable th {
  height: 0;
  line-height: 0;
  padding-top: 0;
  padding-bottom: 0;
  color: transparent !important;
  border: none;
  white-space: nowrap;
}
.containerTable th div{
  position: absolute;
  background: transparent;
      color: #fff;
    padding: 9px 2px;
    top: 1px;
  line-height: normal;
  border-left: 1px solid rgba(255, 255, 255, 0.58);
}
.containerTable th:first-child div{
  border: none;
}
#showOnlyFolders ul {
	border: 1px solid #ccc;
	padding: 20px;
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
									<%-- <% if(!StringUtils.isEmpty(loanAmt) && loanAmt!=null && loanAmt!="null" ){ %> --%>
							<tr>
							<td><p id ="loanAmt" class="text-capitalize">Loan Amount :    </p></td>
							<td class='currency'><%=loanAmt%></td>
							</tr>
							<tr>
							<%-- <%} %> --%>
							<%-- <% if(!StringUtils.isEmpty(closingDate)){ %> --%>
							<td><p id ="closingDate" class="text-capitalize">Closing Date :  </p></td>
							<td><%=closingDate%></td>
							</tr>
							<%-- <%} %> --%>
							
							<%-- <% if(!StringUtils.isEmpty(lenderName) ){
						    %> --%>
							<tr>
							<td><p id ="lenderName" class="text-capitalize">Lender Name :  </p></td>
							<td><%=lenderName%></td>
							</tr>
							<%-- <%} %> --%>
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

											<div class="folderArea" id="folderView">
												<div id="data" class="demo">
												<div id="jstree"></div><!--class="folderStruct table "-->
												</div>
<%-- 												<jsp:include page='jsTree.jsp'/> --%>
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
							<div id="myField" name="myField"> </div>
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
										<div id = 'subFolderData' style="text-align: left;">
										<div id="showOnlyFolders"></div>
										</div>
										<section class="tableArea" id="tableArea" style="background:#5689d2 !important">
											  <div class="containerTable">
										<table id="searchResTable" class="">
											<thead>
												<tr class="header">
													<th>Actual FileName
														<div>Actual FileName</div>
													</th>
													<th>File Type
														<div>File Type</div>
													</th>
													<th>Version
														<div>Version</div>
													</th>
													<th>DocumentType
														<div>DocumentType</div>
													</th>
													<th>Document Details
														<div>Document Details</div>
													</th>
													<th>Closing Date
														<div>Closing Date</div>
													</th>
													<th>Disposable Date
														<div>Disposable Date</div>
													</th>
                                                    <!-- <th>Disposal Date</th> -->
												
												</tr>
											</thead>
											<tbody id="getDocumentList">
												<tr id="getData"></tr>
												
											</tbody>
										</table>
										
										
											  </div>
										</section>
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