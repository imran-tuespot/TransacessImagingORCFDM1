<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<jsp:useBean id="companyInformation" scope="request" class="com.peniel.beans.CompanyInformation" />
<jsp:useBean id="indexTypeBean" scope="request" class="com.peniel.beans.IndexTypeBean" />
<jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
		<script src="js/jQuery/jquery-1.8.2.min.js"></script>
		
         <link rel="stylesheet" href="css/jquery-ui.css">
		<!-- <script type="text/javascript" src="js/jquery-1.3.2.js" ></script>-->
		<!--  <script type="text/javascript" src="js/jQuery/jquery-1.7.1.js" ></script>-->		
		
		<script type="text/javascript" src="js/jquery.jmesa.js"></script>
		<script src="jscript/jquery-ui.js"></script>
		
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />			
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>
		
				
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script src="js/jquery.popupoverlay.js"></script>
		
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" /> 
		<link rel="stylesheet" type="text/css" href="css/search.css" /> 	
				

<title>TransAccess Imaging</title>

<jsp:include page="includes/sessionHeader.jsp" />


<% 
   
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
 // String contextLoginId = request.getParameter("contextLoginId").toString();
  
  HashMap companyHashMap = companyInformation.getcompanyInformation(request.getSession().getAttribute("comid").toString());
  String indexType = indexTypeBean.getIndexType(companyHashMap.get("defaultIndex").toString(),
  												request.getSession().getAttribute("comid").toString());
  												
  List<String> html = folderBean.getFolderNameGridHTML(""+cid,""); 
  request.getSession().setAttribute("folderData", html);	
  //String indexVals = indexTypeBean.getIndexVals(request.getAttribute("comid").toString());								
  //System.out.println("Index indexVals--->"+indexVals);  											
 %>

<script language="javascript">
$(function() {

	$.jmesa.addTableFacade('formId');
	$.jmesa.setMaxRowsToLimit('formId','12');
	$.jmesa.setPageToLimit('formId','1');
	$.jmesa.setOnInvokeAction('formId','onInvokeAction');
	$.jmesa.setOnInvokeExportAction('formId','onInvokeExportAction');
	
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

	// Initialize the plugin
      $('#my_popup').popup({color:'#000'});
      
      
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
    
	getdropdowns();
	setHeader('docMgmtSearchGrid.jsp');

});
	
               
//Global variable to store array elements for expanded folder
 var s = [];   
 var fView = "advView";

function onInvokeAction(id,action) {
	var compid = '<%= cid %>';
	var sessionid = '<%= sessionid %>';
	var userName = '<%= userName %>';
	
	var indexvar = ''; 
	var docvar = ''; 
	var indexval = '';
	var docStatus = ''; 
	
		
	var checkVals = '';
	var formId = document.getElementById("type").value;
	var queryString = "compid="+compid+"&"+"sessionid="+sessionid+"&"+"userName="+userName+"&formId="+formId;
	
	if(document.getElementById("indexval") != null){
		if(document.getElementById("indexval").value!= null){
			indexvar = document.getElementById("indextype").value; 
			docvar = document.getElementById("doctype").value; 
			indexval = document.getElementById("indexval").value; 
			docStatus = document.getElementById("docStatus").value;
	
			indexval = indexval.replace(" ", " or ");
						
			indexval = indexval.replace(",", " or "); 
			
			if(indexval.search(/or/) != '-1'){
				checkVals = '1';	
			}
			
			queryString += "&"+"indexvar="+indexvar+"&"+"docvar="+docvar+"&"+"indexval="+indexval+"&"+"docStatus="+docStatus;
		}
	}
	
	
	$('#my_popup').popup('show');
	var parameterString = createParameterStringForLimit(id);
	//msgbox_visible(true);
	$('#my_popup').popup('show');	

	var parameterString = createParameterStringForLimit(id);
    $.post("GetFiles?"+queryString+"&"+ parameterString, function(data) {
    	alert("query "+queryString+"&"+ parameterString);
    	//msgbox_visible(false);
    	$('#my_popup').popup('hide');    	
        $("#results").html(data)
 
    },"html");
}


	
	
   /* $.get("DocMgmtSearchGrid1?"+queryString+"&"+ parameterString, function(data) {
    alert("data "+data);
    	//msgbox_visible(false);
    	//$('#my_popup').popup('hide');
        //$("#results").html(data);
         alert("result "+data.);
           // $('#results').html(result);
 		 //displayTableRows();
    });*/
   


function onInvokeExportAction(id,action) {
	var compid = '<%= cid %>';
	var sessionid = '<%= sessionid %>';
	var userName = '<%= userName %>';
	
	var indexvar = ''; 
	var docvar = ''; 
	var indexval = '';
	var docStatus = ''; 
	
		
	var checkVals = '';
	var queryString = "compid="+compid+"&"+"sessionid="+sessionid+"&"+"userName="+userName;
	if(document.getElementById("indexval") != null){
		if(document.getElementById("indexval").value!= null){
			indexvar = document.getElementById("indextype").value; 
			docvar = document.getElementById("doctype").value; 
			indexval = document.getElementById("indexval").value; 
			docStatus = document.getElementById("docStatus").value;
	
			indexval = indexval.replace(" ", " or ");
						
			indexval = indexval.replace(",", " or "); 
			
			if(indexval.search(/or/) != '-1'){
				checkVals = '1';	
			}
			
			queryString += "&"+"indexvar="+indexvar+"&"+"docvar="+docvar+"&"+"indexval="+indexval+"&"+"docStatus="+docStatus;
		}
	}
	
	
	$('#my_popup').popup('show');
	var parameterString = createParameterStringForLimit(id);
	//alert("QueryString"+queryString);
    $.get("GetFiles?"+queryString+"&"+ parameterString, function(data) {
    	//msgbox_visible(false);
    	$('#my_popup').popup('hide');
        $("#results").html(data)
 		 //displayTableRows();
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

 

function displayTableRows()
{
/*alert("Inside display Tablerows");
	var theTable = document.getElementById('formId');
	var temp = "";
	var count = theTable.tBodies[2].rows.length;
	alert("Count "+count);
	for( var x = 0; x < theTable.tBodies[2].rows.length;) 
	{		
		if(count >= x)
		{			
			var cels1 = theTable.tBodies[2].rows[x].cells[5];
			var cels1_cont = theTable.tBodies[2].rows[x].cells[5].innerHTML;
			var cels1_version = theTable.tBodies[2].rows[x].cells[4].innerHTML;
			
			var row2 =  theTable.tBodies[2].rows[x++];
			var cels2 = theTable.tBodies[2].rows[x].cells[5];
			var cels2_cont = theTable.tBodies[2].rows[x].cells[5].innerHTML;
			var cels2_version = theTable.tBodies[2].rows[x].cells[4].innerHTML;
			
			if((cels1_cont === cels2_cont) && (cels1_version === cels2_version))
			{
				theTable.tBodies[2].rows[x].cells[0].innerHTML = "";
				theTable.tBodies[2].rows[x].cells[3].innerHTML = "";
				theTable.tBodies[2].rows[x].cells[4].style.display = "none";
				theTable.tBodies[2].rows[x].cells[5].style.display = "none";
				theTable.tBodies[2].rows[x].cells[6].innerHTML = "";					
			}			
		  }				
	 }*/
	
}
 function displayFolderView(rootDir)
{ 
	if(fView == "fView")
    {	
		$('#fileTreeDemo_4FView').fileTree({ root: rootDir,expandedFolders: s , script: 'connectors/browseFolderFilesUser.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'One moment...' }, function(file) { 
	});
	}
	else if(fView == "advView")
	{
		var startSet = '';
		startSet = document.getElementById('startSet').value;
		
		
		var totalSet = startSet.substring(0, startSet.indexOf("$", 0));
		
		
		startSet = startSet.substring(startSet.indexOf("$", 0) + 1, startSet.length);
		
		var nextSet = Number(startSet) + 10;
		if(nextSet < totalSet){
			var url = ' <a id="nextLnk" style="float: right;padding-right: 10px;padding-top:5px;" href=javascript:getNextDataSets("nexts",'+startSet+','+totalSet+');>Next <i class="zmdi zmdi-skip-next"></i></a>';
			
			document.getElementById('nextSet').style.display = 'block';
			document.getElementById('nextSet').innerHTML = url;
					
		} else {
			document.getElementById('nextSet').style.display = 'none';
			document.getElementById('nextSet').innerHTML = '';
		}
		
		if(Number(nextSet) > 10){
			var url = '<a style="float: left;padding-left: 10px;padding-top:7px;" href=javascript:getNextDataSets("previous",'+startSet+','+totalSet+');><i class="zmdi zmdi-skip-previous"></i>Previous</a>';
			if($('#nextLnk').is(':visible')) 
				document.getElementById('previousSet').style.display = 'inline';
			else
				document.getElementById('previousSet').style.display = 'block';
			document.getElementById('previousSet').innerHTML = url;
					
		} else {
			document.getElementById('previousSet').style.display = 'none';
			document.getElementById('previousSet').innerHTML = '';
		}
		$('#fileTreeDemo_4').fileTree({ root: rootDir,expandedFolders: s , script: 'connectors/searchResultUser.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'One moment...' }, function(file) { 
		});
	}
}
function displayFolderStructure()
{
      $('#fileTreeDemo_1FView').fileTree({ root: '/',
	 script: 'connectors/jqueryFolderSelection.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'One moment...' }, function(file) { 
				});
	
		$('#fileTreeDemo_1').fileTree({ root: '/',
	 script: 'connectors/jqueryFolderSelection.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'One moment...' }, function(file) { 
				});	
	
	
	
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

function getNextDataSets(pageMode,startSets,totalSet) {
	
	$('#my_popup').popup('show');
	//Make Submit button disabled
	document.getElementById('submitAdv').disabled = true;
	document.getElementById('submitClassic').disabled = true;
	document.getElementById('submitFolder').disabled = true;
	
	
	//Clear contents of file div
	document.getElementById('fileTreeDemo_4FView').innerHTML = "";
	//document.getElementById('fileTreeDemo_3').innerHTML = "";
	
	document.getElementById('fileTreeDemo_4').innerHTML = "";
	
	
	
	var user = '<%= uid%>';
	var compid = '<%= cid %>';
	var sessionid = '<%= sessionid %>';
	var userName = '<%= userName %>';
	
	var keywordSearch = '';
	
	var propertyType = '';
	
	var indexvar = ''; 
	var docvar = ''; 
	var foldervar ='';
	var indexval = ''; 
	var docStatus = '';
	
	
	var checkVals = '';
	var formId = document.getElementById("type").value;
	
	var queryString = "userid="+user+"&"+"compid="+compid+"&"+"sessionid="+sessionid+"&"+"userName="+userName+"&formId="+formId;

	if(document.getElementById("keywordSearch") != null){
		if(document.getElementById("keywordSearch").value!= null && document.getElementById("keywordSearch").value!= ""){
			keywordSearch = document.getElementById("keywordSearch").value;
		
			queryString += "&"+"keywordSearch="+keywordSearch;
		}
	}
	
	
	
	
	if(document.getElementById("indexval") != null){
		if(document.getElementById("indexval").value!= null ){
			indexvar = document.getElementById("indextype").value; 
			indexval = document.getElementById("indexval").value;				
			docvar = document.getElementById("doctype").value; 
			docStatus = document.getElementById("docStatus").value;
			propertyType = document.getElementById("propertytypeClassic").value;
			
			//alert("indexvar "+indexvar);
			if(fView == "fView")
			{
				foldervar = document.getElementById("folderNameFView").value; 
				
			}
			else if(fView == "advView")
			{
				foldervar = document.getElementById("folderName").value; 
				indexvar = document.getElementById("indextypeClassic").value;				
				indexval = document.getElementById("indexvalClassic").value;
				docvar = document.getElementById("doctypeClassic").value; 
				docStatus = document.getElementById("docStatusClassic").value;
				propertyType = document.getElementById("propertytype").value;
				
			}
			
			
			indexval = indexval.replace(" ", " or ");
			
			indexval = indexval.replace(",", " or "); 
			
			if(indexval.search(/or/) != '-1'){
				checkVals = '1';	
			}
			
			if(fView == "fView")
			{
				queryString += ""+"&indexvar=&docvar=&indexval=&docStatus=";
				queryString += ""+"&foldervar="+foldervar;
				
			}else{
				queryString += ""+"&indexvar="+indexvar+"&"+"docvar="+docvar+"&"+"foldervar="+foldervar+"&"+"indexval="+
								   indexval+"&"+"docStatus="+docStatus + "&"+"propertytype="+propertyType;				
			}
			//alert("queryString---------> "+queryString);
			
		}
	}
	
	
	
	var startSet = '';
	
	if(pageMode == 'previous') {
		startSet = Number(startSets) - 10;
	}
	
	if(pageMode == 'nexts'){
		startSet = Number(startSets) + 10;
	}
	
	startSet = totalSet +'$'+ startSet;
	
	if(startSet != '') queryString += "&startSet="+startSet;
		
	if(orderby != '') queryString += orderby;
	
	//alert("queryStr -->"+queryString);
	if(fView == "fView" || fView == "advView") //Folder View or Advanced View
	{	
 
			if(fView == "advView")
			{
				document.getElementById('noResults').style.display = 'none';
				//alert("query String in adv view "+queryString);
			}else if (fView == "fView")
			{
				 //alert("query String in folder view "+queryString);
				
				document.getElementById('noResultsFView').style.display = 'none';				
			}
				
			if(xmlhttp) { 
		    xmlhttp.open("POST","DocMgmtSearchFolders",true); 
		    xmlhttp.onreadystatechange  = handleFolderResponse;
		    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xmlhttp.send(queryString);
		} 
		
	}
	orderby = '';
 
} 

function getdropdowns()
{	  
    var comid = '<%= cid %>';
      
           $.ajax({
            type: "GET",
            url:"GetDocTypeDropdown?comid="+comid,
            dataType: "json",
            success: function (data) {
                $.each(data.docTypeData,function(i,obj)
                {
                 	var div_data="<option value="+obj.value+">"+obj.text+"</option>";
                	$(div_data).appendTo('#doctype'); 
                	$(div_data).appendTo('#doctypeClassic');
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
                	$(div_data).appendTo('#indextypeClassic');
                	
                });
                 
                }
          });
          	getPropertyValues('propertytype','propertytypeClassic');
          	//Rearrange the dropdown to display default index at the top
			update_select('indextype');
			update_select('indextypeClassic');          
}




function clearFields()
{
   if(fView != "fView" && fView != "advView") 
	{
	 	document.getElementById('indexval').value ="";
	 	document.getElementById('propertytypeClassic').value ="";	
	 	
	}
	else if(fView == "advView")
	{
		document.getElementById('folderName').value ="" ;
		document.getElementById('indexvalClassic').value =""; 
		document.getElementById('keywordSearch').value ="";
		document.getElementById('propertytype').value ="";
		
		//document.getElementById('propertytype').selectedIndex = 0; 
		document.getElementById('doctypeClassic').selectedIndex = 0;	 
	}
}

function validateForm()
{
	//var ddl = document.getElementById("propertytype");
 	//var propertyValue = ddl.options[ddl.selectedIndex].value;
    
    var propertyValue = document.getElementById("propertytype");    
    var ddl1 = document.getElementById("doctypeClassic");
    var docTypeValue = ddl1.options[ddl1.selectedIndex].value;
   
	if(fView == "fView" && document.getElementById('folderNameFView').value =="") 
	{
		jAlert("Please select folder.","Select Folder");
		return false;		
	}
	else if(fView == "advView"  && document.getElementById('folderName').value =="" 
			&& document.getElementById('indexvalClassic').value =="" 
			&& document.getElementById('keywordSearch').value ==""
			&& document.getElementById('propertytype').value ==""  
			&& docTypeValue == "All")
			/* && propertyValue == "Any" */ 
	{
	    jAlert("Please select at least one search criteria.","Select Criteria");
	    return false;
	}
	else if(fView != "fView" && fView != "advView" && document.getElementById('indexval').value =="" && document.getElementById('propertytypeClassic').value =="" ){
		    jAlert("Please select search criteria.","Select Criteria");
		    return false;
	}
	return true;
}

function getfiles() {
	
	if(!validateForm())
	{
		return;
	}
	//msgbox_visible(true);
	$('#my_popup').popup('show');
	//Make Submit button disabled
	document.getElementById('submitAdv').disabled = true;
	document.getElementById('submitClassic').disabled = true;
	document.getElementById('submitFolder').disabled = true;
	
	
	//Clear contents of file div
	document.getElementById('fileTreeDemo_4FView').innerHTML = "";
	//document.getElementById('fileTreeDemo_3').innerHTML = "";
	
	document.getElementById('fileTreeDemo_4').innerHTML = "";
	
	
	
	var user = '<%= uid%>';
	var compid = '<%= cid %>';
	var sessionid = '<%= sessionid %>';
	var userName = '<%= userName %>';
	
	var keywordSearch = '';
	
	var propertyType = '';
	
	var indexvar = ''; 
	var docvar = ''; 
	var foldervar ='';
	var indexval = ''; 
	var docStatus = '';
	
	
	var checkVals = '';
	var formId = document.getElementById("type").value;
	
	var queryString = "userid="+user+"&"+"compid="+compid+"&"+"sessionid="+sessionid+"&"+"userName="+userName+"&formId="+formId;

	if(document.getElementById("keywordSearch") != null){
		if(document.getElementById("keywordSearch").value!= null && document.getElementById("keywordSearch").value!= ""){
			keywordSearch = document.getElementById("keywordSearch").value;
		
			queryString += "&"+"keywordSearch="+keywordSearch;
		}
	}
	
	
	
	
	if(document.getElementById("indexval") != null){
		if(document.getElementById("indexval").value!= null ){
			indexvar = document.getElementById("indextype").value; 
			indexval = document.getElementById("indexval").value;				
			docvar = document.getElementById("doctype").value; 
			docStatus = document.getElementById("docStatus").value;
			propertyType = document.getElementById("propertytypeClassic").value;
			
			//alert("indexvar "+indexvar);
			if(fView == "fView")
			{
				foldervar = document.getElementById("folderNameFView").value; 
				
			}
			else if(fView == "advView")
			{
				foldervar = document.getElementById("folderName").value; 
				indexvar = document.getElementById("indextypeClassic").value;				
				indexval = document.getElementById("indexvalClassic").value;
				docvar = document.getElementById("doctypeClassic").value; 
				docStatus = document.getElementById("docStatusClassic").value;
				propertyType = document.getElementById("propertytype").value;
				
				
			}
			
			
			
			if(fView == "fView")
			{
				queryString += ""+"&indexvar=&docvar=&indexval=&docStatus=";
				queryString += ""+"&foldervar="+foldervar;
				
			}else{
				queryString += ""+"&indexvar="+indexvar+"&"+"docvar="+docvar+"&"+"foldervar="+foldervar+"&"
								 +"indexval="+indexval+"&"+"docStatus="+docStatus+ "&"+"propertytype="+propertyType;					
			}
			//alert("queryString---------> "+queryString);
			
		}
	}
	
		
	if(orderby != '') queryString += orderby;
	
	if(fView == "advView")
	{
		document.getElementById('noResults').style.display = 'none';
		//alert("query String in adv view "+queryString);
		if(xmlhttp) { 
    		xmlhttp.open("POST","DocMgmtAdvSearch",true); 
    		xmlhttp.onreadystatechange  = handleFolderResponse;
    		xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    		xmlhttp.send(queryString);
		} 
	}
	else if (fView == "fView")
	{
		 	//alert("query String in folder view "+queryString);				
			document.getElementById('noResultsFView').style.display = 'none';				
			if(xmlhttp) { 
		    xmlhttp.open("POST","DocMgmtSearchFolders",true); 
		    xmlhttp.onreadystatechange  = handleFolderResponse;
		    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xmlhttp.send(queryString);
		} 
	} 		
	else //Classic View
	{
			if(xmlhttp) { 
		    xmlhttp.open("POST","GetFiles",true); 
		    xmlhttp.onreadystatechange  = handleResponse;
		    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xmlhttp.send(queryString);
		} 
		
	}
 
} 

function handleResponse() {
	
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     // alert(xmlhttp.responseText);
        if (xmlhttp.responseText == "expired") { 
        //msgbox_visible(false);	
        $('#my_popup').popup('show');
        
        //Make submit button enabled
        //document.getElementById('submit').disabled = false;
        
        // alert("Session Expired...Please Login Again.");
        window.location = "index.jsp";
        } else {
     		DisplayData(xmlhttp.responseText);
     	}
     }    
     else {
        //alert(xmlhttp.status);
     }
   }
}

function handleFolderResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     // alert(xmlhttp.responseText);
        $('#my_popup').popup('hide');
     
        if (xmlhttp.responseText == "expired") { 
        //msgbox_visible(false);	
        // alert("Session Expired...Please Login Again.");
        window.location = "index.jsp";
        } else {
     	 DisplayFolderData(xmlhttp.responseText);
     	 //msgbox_visible(false);
     	 //document.getElementById('submit').disabled = false;
     	    	
     	}
     }    
     else {
       // alert(xmlhttp.status);
     }
   }
}


function DisplayData(data)
{
	//Make folder div invisible
	//document.getElementById('folderView').style.display = 'none';
	document.getElementById('fileView').style.display = 'none';
	//Make classic view div visible
	document.getElementById('results').style.display = 'block';	
	
	//msgbox_visible(false);
	$('#my_popup').popup('hide');	
	document.getElementById('submitAdv').disabled = false;
	document.getElementById('submitClassic').disabled = false;
	document.getElementById('submitFolder').disabled = false;
	
		
	var obj =  document.getElementById("results");
	obj.innerHTML = data;


	//displayTableRows();
	
}

function DisplayFolderData(startSet)
{
	//Make folder div visible in advanced search tab
	if(fView == "advView")
	{
	   // alert("In dispaly folder data advView")
		//document.getElementById('folderView').style.display = 'block';
		document.getElementById('fileView').style.display = 'block';
		var folderName = document.getElementById('folderName').value;	
		if (folderName == "")
		{
			folderName="/";
		}
		
	}
	else if(fView == "fView")
	{
		document.getElementById('fileViewFView').style.display = 'block';
		var folderName = document.getElementById('folderNameFView').value;
		
	}
	//Make classic view div invisible
	document.getElementById('results').style.display = 'none';	
	
	//msgbox_visible(false);	
	$('#my_popup').popup('hide');	
	document.getElementById('submitAdv').disabled = false;
	document.getElementById('submitClassic').disabled = false;
	document.getElementById('submitFolder').disabled = false;	
	
	document.getElementById('startSet').value = startSet;
	
	displayFolderView(folderName);
	
}

function getpdf1(id,docType,indexType,indexVal,folderVal,status,docTypeId,version,indexId,docId)
{
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var keywordSearch = '';
	
	if(document.getElementById("keywordSearch") != null){
		if(document.getElementById("keywordSearch").value!= null){
			keywordSearch = document.getElementById("keywordSearch").value;
		}
	}
	
	var Text = "./DisplayPdf?id="+id+"&userid="+user+"&comid="+com+"&sessionid="+session+"&userName="+userName+"&keywordSearch="+keywordSearch;
	var wnd = window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
	
	
    
	//var interval = setInterval('msgbox_visible(false)',2000);
	var inc = '1';
	var cookieCountVar = getCookie1('cookieCount');
	
	if(!cookieCountVar)
	{
		setCookie1('cookieCount',1,90,'transaccessImaging.com');
		//alert(" cookieCount set to 1 : "+getCookie1('cookieCount'));		
		
	}
		cookieCountVar = getCookie1('cookieCount');
		//alert("id "+id.replace(/^\/|\/$/g, ''));
		//set cookie and increment the cookie count		
		var cookieVal = id+'#'+docType+'#'+indexType+'#'+indexVal+'#'+folderVal+
		'#'+status+'#'+docTypeId+'#'+version+'#'+indexId+'#'+docId;
		if(cookieCountVar == 1)
		{
			//alert("Setting cookie for first time ");
		    setCookie1(user+'_'+cookieCountVar, cookieVal,90,'transaccessImaging.com');
			cookieValue = getCookie1(user+'_' +cookieCountVar);
			//alert("Cookie Value...."+cookieValue); 
			//alert(+cookieCountVar);
			cookieCountVar = +cookieCountVar + +inc;
			setCookie1('cookieCount',cookieCountVar,90,'transaccessImaging.com');
		}
		else
		{
			for(var k=1; k<= cookieCountVar; k++)
			{
				var oldCookie = getCookie1(user+'_'+k);
				var foundDuplicate ;
				if(oldCookie)
				{
					//If user is accessing same file do not set the cookie					
					if(oldCookie == cookieVal)			
					{
						//alert("Found duplicate at location "+ k);
						foundDuplicate = true;
						//Move the link(cookie) to the top
						//store duplicate cookie val in temp
						var temp = oldCookie;
						for(var l=k; l< cookieCountVar; l++)
						{
							var nextCookieVal = getCookie1(user+'_'+(l+1));
						 	setCookie1(user+'_'+l,nextCookieVal ,90,'transaccessImaging.com');
						}
						setCookie1(user+'_'+(cookieCountVar-1),temp ,90,'transaccessImaging.com');
					}
				}
			}
			if(!foundDuplicate)
			{
				//alert("Not found duplicate setting cookie");
				setCookie1(user+'_'+cookieCountVar, cookieVal,90,'transaccessImaging.com');
				cookieValue = getCookie1(user+'_' +cookieCountVar);
				cookieCountVar = +cookieCountVar + +inc;
				setCookie1('cookieCount',cookieCountVar,90,'transaccessImaging.com');
				//alert(" cookieCount set to"+getCookie1('cookieCount'));
			}
					
			
		}
	
	if(cookieCountVar == 11)
	{
		setCookie1('cookieCount',1,90,'transaccessImaging.com');
	}

}

function getpdf(id) {
	//var interval = setInterval('msgbox_visible(true)',0000);
	
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
		
	//var Text = "./DisplayPdf?id="+id+"&userid="+user+"&comid="+com+"&sessionid="+session+"&userName="+userName;
	//window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
	
	var keywordSearch = '';
	
	if(document.getElementById("keywordSearch") != null){
		if(document.getElementById("keywordSearch").value!= null){
			keywordSearch = document.getElementById("keywordSearch").value;
		}
	}
	
	var Text = "./DisplayPdf?id="+id+"&userid="+user+"&comid="+com+"&sessionid="+session+"&userName="+userName+"&keywordSearch="+keywordSearch;
	var wnd = window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
	
}


function editDoc(id,status,formAction) {
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	
	
	delCookie("INDEX_TYPE_1");
	delCookie("INDEX_VAL_1");
	delCookie("DOC_TYPE_1");
	delCookie("DOC_STATUS_1");
	delCookie("COOKIE_TRACKER");
		
	setCookie("DIV_CNT", divCnt);
	$('#my_popup').popup('hide');
	var Text = "./EditDocument?id="+id+"&comid="+com+"&sessionid="+session+"&status="+status+"&formAction=";
				
	window.location = Text;
	
}
function setCookie1(cname,cvalue,exdays,domain)
{
	//alert("Setting cookie " +cname +" val "+cvalue);
	var d = new Date();
	d.setTime(d.getTime()+(exdays*24*60*60*1000));
	var expires = "expires="+d.toGMTString();
	document.cookie = cname + "=" + cvalue + "; " + expires;
	document.cookie += "domain=" + domain + "; ";
} 


function setExpiration(cookieLife){
    var today = new Date();
    var expr = new Date(today.getTime() + cookieLife * 24 * 60 * 60 * 1000);
    return  expr.toGMTString();
}

function getCookie1(w){
//alert("getting cookie "+w);
	cName = "";
	pCOOKIES = new Array();
	pCOOKIES = document.cookie.split('; ');
	for(bb = 0; bb < pCOOKIES.length; bb++){
		NmeVal  = new Array();
		NmeVal  = pCOOKIES[bb].split('=');
		if(NmeVal[0] == w){
			cName = unescape(NmeVal[1]);
		}
	}
	return cName;
}

// Create a cookie with the specified name and value.
function setCookie(sName, sValue)
{
  document.cookie = sName + "=" + escape(sValue);
  // Expires the cookie in eight minutes
  var date = new Date();
  //alert('date 1 -->'+date.toUTCString());
  var currentMins = date.getMinutes();
  var expireMins = currentMins + 1;
  
  date.setMinutes(expireMins);
  
  //alert('date 2 -->'+date.toGMTString());
  document.cookie += ("; expires=" + date.toUTCString()); 
}


// Retrieve the value of the cookie with the specified name.
function getCookie(sName)
{
  // cookies are separated by semicolons
  var aCookie = document.cookie.split("; ");
  for (var i=0; i < aCookie.length; i++)
  {
    // a name/value pair (a crumb) is separated by an equal sign
    var aCrumb = aCookie[i].split("=");
    if (sName == aCrumb[0]) 
      return unescape(aCrumb[1]);
  }
  // a cookie with the requested name does not exist
  return null;
}


// Delete the cookie with the specified name.
function delCookie(sName)
{
  document.cookie = sName + "=; expires=Fri, 31 Dec 1999 23:59:59 GMT;";
}

var orderby = '';
function sortby(property)
{
	property = " LOWER(" + property + ")";
	var sVal = getSortValue(property);
	if(sVal == 0)
		property += " ASC";
	else
		property += " DESC";
		
	var order = property;
	orderby = "&orderby="+order;
	
	getfiles();
	
	setCookie("ORDER_BY",orderby);
  // alert(property);

}

function setSortValue(sortName,sortValue)
{
		var expires = new Date();
		expires.setMonth(expires.getMonth() + 4);
		setCookie(sortName,sortValue, new Date(expires), '/', '', '');
}

function getSortValue(property)
{
	var sortValue = getCookie("SORT_"+property);
	if(sortValue == null || sortValue == "0")
	{
		setSortValue("SORT_"+property,1);
		return 0;
	}
	else
	{
		setSortValue("SORT_"+property,0);
		return 1;
	}
}



var rowNbr;

function getIndexType(rowNumber){
	if(rowNumber == "1") {
		rowNbr = '';
	}
	else{
		rowNbr = rowNumber;
	}
	var docType = document.getElementById("doctype"+rowNbr).value;
	
	getIndexTypes(docType);
	
}


function getIndexTypes(docType) {
  var compid = '<%= cid %>';
  var queryString = "compid="+compid+"&docTypeId="+docType;
  	//alert ("query " +queryString);
  if(xmlhttp1) { 
     
    xmlhttp1.open("POST","GetIndexDropDown",true); 
    xmlhttp1.onreadystatechange  = handleServerResponse1;
    xmlhttp1.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp1.send(queryString);
  } 
}

function handleServerResponse1() {
   if (xmlhttp1.readyState == 4) {
     if(xmlhttp1.status == 200) {
     	parseindexstr(xmlhttp1.responseText);
     	// alert(xmlhttp.responseText);
     }    
     else {
        alert(xmlhttp1.status);
     }
   }
}


function parseindex(indexstr) {
	var row = indexstr.split('|');
	index.length = 0;
	for (var i=0; i<row.length-1; i++) {
	  var col = row[i].split('^');
	  index[i]= new Array(col[0],col[1]);
	  // alert(index[i][0]+"="+index[i][1]);
    }
    
    var selectbox = document.getElementById("indextype"+rowNbr);
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		selectbox.remove(i);
	}

    for (var i=0; i < index.length;++i){
		addOption(document.getElementById("indextype"+rowNbr), index[i][0], index[i][1]);
	}
	
}





var xmlhttp2 = new getXMLObject2();       //xmlhttp holds the ajax object

function getXMLObject2()  //XML OBJECT
{
   var xmlHttp2 = false;
   try {
     xmlHttp2 = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp2 = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp2 = false   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp2 && typeof XMLHttpRequest != 'undefined') {
     xmlHttp2 = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp2;  // Mandatory Statement returning the ajax object created
}
function getDocumentData(id)
{

    var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var queryString = "userid="+user+"&"+"compid="+com+"&"+"sessionid="+session+"&"+"userName="+userName+"&id="+id;

  if(xmlhttp2) { 
		    xmlhttp2.open("POST","GetDocumentData",true); 
		    xmlhttp2.onreadystatechange  = handleResponse2;
		    xmlhttp2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		   // alert(queryString);
		    xmlhttp2.send(queryString);
		    
		} 
}

function handleResponse2() {
   if (xmlhttp2.readyState == 4) {
   
     if(xmlhttp2.status == 200) { 
     	ParseDocData(xmlhttp2.responseText);     	
     }    
     else {
        alert(xmlhttp2.status);
     }
   }
}

function ParseDocData(text)
{
	  var row = text.split('^');
	  var Id = row[0];
	  var docType = row[1];
	  var indexType = row[2];
	  var indexVal = row[3];
	  var folderVal = row[4];
      var status = row[5];
      var docTypeId  = row[6];
      var version = row[7];
      var indexId = row[8];
      var docId = row[9];
      getpdf1(Id,docType,indexType,indexVal,folderVal,status,docTypeId,version,indexId,docId);
}


var xmlhttp3 = new getXMLObject3();       //xmlhttp holds the ajax object

function getXMLObject3()  //XML OBJECT
{
   var xmlHttp3 = false;
   try {
     xmlHttp3 = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp3 = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp3 = false   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp3 && typeof XMLHttpRequest != 'undefined') {
     xmlHttp3 = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp3;  // Mandatory Statement returning the ajax object created
}
function getFileDetails(id)
{
    //alert("id "+id);
	$('#my_popup').popup('show');
    var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var queryString = "userid="+user+"&"+"compid="+com+"&"+"sessionid="+session+"&"+"userName="+userName+"&id="+id;

  if(xmlhttp3) { 
		    xmlhttp3.open("POST","GetDocumentData",true); 
		    xmlhttp3.onreadystatechange  = handleResponse3;
		    xmlhttp3.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		   // alert(queryString);
		    xmlhttp3.send(queryString);
		    
		} 
}

function handleResponse3() {
   if (xmlhttp3.readyState == 4) {
   
     if(xmlhttp3.status == 200) { 
     	ParseFileData(xmlhttp3.responseText);     	
     }    
     else {
        alert(xmlhttp3.status);
     }
   }
}
function ParseFileData(text)
{
	  var row = text.split('^');
	  var Id = row[0];	 
      var docId = row[1];    
      editDoc(Id,'Active',docId,'');
}

function tabContent0()
{
		 fView="advView";						 
		 $('#flip-container').quickFlipper({ }, 0, 1);		
}

function tabContent1()
{
		 fView="cView";
		 $('#flip-container').quickFlipper({ }, 1, 1);
		
}
function tabContent2()
{
		 fView = "fView";
		 $('#flip-container').quickFlipper({ }, 2, 1);		
}

</script>

</head>

<body>
<!-- Add content to the popup -->
  <div id="my_popup">
	<div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em; opacity: 1; visibility: visible; display: inline-block; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
    <h4><i class="zmdi_large zmdi-settings zmdi-hc-spin"></i>Loading Contents...Please Wait...</h4>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;It will take few seconds.</p>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;Please wait while the contents are loading.</p>
    
	</div>
	
  </div>
  
    
<div id="flip-tabs" >
    <div class="tabbox">
		 <ul id="flip-navigation" >
		 
		 	   <li class="selected"><a href="#content1" id="tab-0" onclick="javascript:tabContent0()">Advanced Search<!-- <img id="advancedSearchImg" src="images/advancedSearchActive1.png" width="262px;" height="60px;"/>--></a></li>		 	   
              <li><a href="#content2" id="tab-1" onclick="javascript:tabContent1()">Classic Search<!-- <img id="classicViewImg" src="images/classicSearch.png" width="262px;" height="60px;"/>--></a></li>                                   
              <li ><a href="#content3" onclick="javascript:tabContent2()" id="tab-2"  >Browse Folders<!-- <img id="folderViewImg" src="images/folderSearch1.png" width="262px;" height="60px;"/>--></a></li>  
                                                 
          </ul>
     </div>
		<div id="flip-container" >
			<div  id="content1"> 
			<div align="center" style="height: auto; overflow: auto;">
				<div style="float: left;width:25%">
				<p style="color:green;font-size:16px;padding-left: 0px; padding-top: 0px;"><i class="zmdi_large zmdi-library" style="color: green;"></i>Document Repository</p>
				    	<div class="example" id="expand" style="display: block;">
								<div id="fileTreeDemo_1" class="folderStruct"></div>
						</div>
				</div>
				<div style = "float:left;width:73%;padding-left:20px;padding-top: 40px;" id = "moreRows">
				
				<div class="card" style="width: 100%; margin: 2px 10px 0px 0px; padding-left: 0px;">
				<div class="card-body card-padding" style="padding: 0px 6px 0px;background-color:#EDECEC;margin-bottom: 20px;">
								<table class="table" cellspacing="0">
									<tbody>
										<tr>
											<td>Property</td>
											<td><!-- 	<select class="selectText" style="overflow:auto;width:250px;"  id="propertytype" name="propertytype">
														<option value="Any"></option>
													</select>-->
													<input id="propertytype" name="propertytype"  type="text" size=41 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"  >											
											</td>
											<td></td>
										</tr>
										<tr>
											<td>Folder Name</td>
											<input type="hidden" id="defaultIndexType" value="<%=indexType%>" />
											<input type="hidden" id="myArr" />	
											<td> 
												<input id="folderName" name="folderName"  type="text"  size=41 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" >
											</td>
											<td>
												<input type="checkbox" id="chkResetFolder" name = "chkResetFolder" onclick="resetFolder(this)"/>&nbsp;&nbsp;Reset Folder</td>
										</tr>
										<tr>
											<td nowrap="">Keyword(s) To Search</td>
											<td>	<input id="keywordSearch" name="keywordSearch" type="text" size=41 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" >
											</td>
											<td>
												<!-- 	<input type="checkbox" id="fuzzySearch" name = "fuzzySearch" value="search" />&nbsp;&nbsp;Fuzzy Search--> </td>
										</tr>
										<tr>
											<td nowrap="">Document Status</td>
											<td><select class="selectText" style="overflow:auto;width:250px;" id="docStatusClassic" name="docStatusClassic">
												<option value="Active">Active</option>
												<option value="Inactive">Inactive</option>
												<option value="All">All</option>
												</select></td>
										</tr>
										<tr>
											<td nowrap="">Document Type</td>
											<td><select class="selectText" style="overflow:auto;width:250px;"  id="doctypeClassic" name="doctypeClassic" onChange = "getIndexType(1);">
												<option value="All">All</option>
												</select>
											</td>
											<td>
											</td>
										</tr>
										
										<tr>
											<td nowrap="">Index Type</td>
											<td><select class="selectText" id="indextypeClassic" name="indextypeClassic" style="width: 250px;">
											</select>
											</td>
											<td></td>											
										
										</tr>
										
										<tr>
											<td>Index Value</td>
											<td><input id="indexvalClassic" name="indexvalClassic"  type="text" size=41 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"  >
										</td>
										<td></td>
										</tr>
										<tr>
											<td style="text-align: right;" colspan="3">
											 <button type="submit" id="submitAdv" name="submit" class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 15px;"  type="button" onClick="javascript:getfiles()">
                									<i class="zmdi zmdi-check"></i> Submit
            								</button>
            								<button  id="clear" name="clear" class="btn btn-warning waves-effect waves-button waves-float" style="margin-right: 25px;" type="button" onClick="javascript:clearFields()">
                									<i class="zmdi zmdi-format-clear"></i> Clear
            								</button>
            								



            								
												<!-- <input id="submit" name="submit" class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 15px;"  type="button" onClick="javascript:getfiles()" value="Submit">
												<input id="clear" name="clear" class="btn btn-warning waves-effect waves-button waves-float" style="margin-right: 25px;" type="button" onClick="" value="Clear">-->											
																						
											</td>
											
											<td>
											</td>
											
										</tr>
										
									</tbody>
								</table>
</div>
</div>	
				 
				<table width= "100%" style="margin-left: 0px;" align="center" border=0>
					<tr>
						<td valign="top" align="center">
						
						<!-- <div class="messagewindow" id="messagewindowAdvView"
							style="DISPLAY: none; MARGIN: 0px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 60%; z-index: 4; text-align: center;">
							<h4>
								Retrieving data.. Please wait.
							</h4>
							<i class="zmdi_large zmdi-settings zmdi-hc-spin"></i>
						</div>-->
						
						
						<div class="messagewindow" id="noResults"
							style="DISPLAY: none; MARGIN: 0px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 60%; z-index: 4; text-align: center;">
							<h4>
								There were no results found.
							</h4>
						</div>
						
					<!-- 	<div class="example" id="folderView" style="display:none;float:left;width:50%">
									<div id="fileTreeDemo_3" class="demo effect5"></div>
						</div>-->
						<input type="hidden" id="startSet" value=""/>						
						<div class="example" id="fileView" style="display:none;float:left;width:100%">
								<div id="previousSet" style="height:30px;display:none;background: #E6E6E6 none repeat scroll 0% 0%;border-top: 3px solid #439639;"" ></div>
								<div id="nextSet" style="height:30px;display:none;background: #E6E6E6 none repeat scroll 0% 0%;border-top: 3px solid #439639;"><i class="zmdi zmdi-skip-next"></i></div>	
									<div id="fileTreeDemo_4" class="demo1 effect5"></div>
						</div>
						<br></tr>
						 
				</table>
</div>	
				 	
									 	
 </div>
		  
</div>		
					
<div id="content2">			
	<div id = "moreRows">				
		<div class="card" style="width: 95%; padding-left: 0px;">
			<div class="card-body card-padding" style="background-color:#EDECEC">
								<table class="table" cellspacing="0">
									<tbody>
									<tr>
											<td>Property</td>
											<td>	
													<input id="propertytypeClassic" name="propertytypeClassic"  type="text" size=49 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"  >											
											</td>
											<td></td>
										</tr>
										<tr>
											<td>Document Type</td>
											<td><select class="selectText" style="overflow:auto;width:300px;"  id="doctype" name="doctype" onChange = "getIndexType(1);">
												<option value="All">All</option>
												</select> 
											</td>
										</tr>
										<tr>
											<td>Index Type</td>
											<td> 
												<select class="selectText" id="indextype" name="indextype" style="width: 300px;">
												</select>
											</td>
										</tr>
										<tr>
											<td nowrap="">Index Value</td>
											<td><input id="indexval" name="indexval" type="text" size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" ></td>
										</tr>
										
										<tr>
											<td nowrap="">Document Status</td>
											<td><select class="selectText" style="overflow:auto;width:300px;" id="docStatus" name="docStatus">
												<option value="Active">Active</option>
												<option value="Inactive">Inactive</option>
												<option value="All">All</option>
												</select></td>
										</tr>
										<tr>
											<td ></td>
										
											<td style="text-align: left;" ><input id="submitClassic" name="submitClassic" class="btn btn-success waves-effect waves-button waves-float" style="margin-left: 165px;"  type="button" onClick="javascript:getfiles()" value="Submit">
												<input id="clear" name="clear" class="btn btn-warning waves-effect waves-button waves-float" style="margin-left: 15px;" type="button" onClick="javascript:clearFields()" value="Clear">											
											
											</td>
											
										</tr>
										
									</tbody>
								</table>
</div>
</div>
				 
				 
				<table width= "96%" align="center" border=0 style="margin-right: 30px;">
						<tr>
						<td valign="top" align="center">
						
						<form name='docSearch' id='docSearch' action="GetFiles" >	
						<input type="hidden" id="type" name= "type"	value="formId"/>			
						<div id="results">
						
						
						</div>
						</form>

						<div class="messagewindow" id="noResultsCView"
							style="DISPLAY: none; MARGIN: 0px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 60%; z-index: 4; text-align: center;">
							<h4>
								There were no results found.
							</h4>
						</div>
						
						<br></tr>
						
 
</table>
</div>	
				 	
									 	
 </div>
			
			<div id="content3">
				<div align="center" style="overflow: auto;">
				<div style="float: left;width:25%">
				    	<div class="example" id="expandFView" style="display: block;">
								<div id="fileTreeDemo_1FView" class="folderStruct"></div>
						</div>
				</div>
				<div style = "float:right;width:75%;">
						<div class="card" style="width: 90%; margin: 0px 30px 0px 0px; padding-left: 0px;">
				<div class="card-body card-padding" style="padding: 16px 6px 0px;background-color:#EDECEC;margin-bottom: 20px;">
								<table class="table" cellspacing="0">
									<tbody>
									
										<tr>
											<td>Folder Name</td>
											
											<td> 
												<input id="folderNameFView" name="folderNameFView"  type="text"  size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);">
											</td>
											<td>
												<input type="checkbox" id="chkResetFolder1" name = "chkResetFolder1" onclick="resetFolder(this)"/>&nbsp;&nbsp;Reset Folder</td>
										</tr>
										<tr>
											<td style="text-align: right;" colspan="2">
											<input id="submitFolder" name="submitFolder" class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 35px;"  type="button" onClick="javascript:getfiles()" value="Submit">
																						
											</td>
											
											<td>
											</td>
											
										</tr>
										
									</tbody>
								</table>
</div>
</div>	
							 <table width= "98%" align="left" border=0 >
								<tr>
						<td valign="top" align="left">
						
						<!-- <div class="messagewindow" id="messagewindowFView"
							style="DISPLAY: none; MARGIN: 0px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 60%; z-index: 4; text-align: center;">
							<h4>
								Retrieving data.. Please wait.
							</h4>
							<i class="zmdi_large zmdi-settings zmdi-hc-spin"></i>
						</div>-->
						
						
						<div class="messagewindow" id="noResultsFView"
							style="DISPLAY: none; MARGIN: 0px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 60%; z-index: 4; text-align: center;">
							<h4>
								There were no results found.
							</h4>
						</div>
						
					<!-- 	<div class="example" id="folderViewFView" style="display:none;float:left;width:50%">
									<div id="fileTreeDemo_3FView" class="demo"></div>
						</div>-->
						<div class="example" id="fileViewFView" style="display:none;float:left;">
									<div id="fileTreeDemo_4FView" class="filesView"></div>
						</div>
						<br></tr>
						 
				</table>	
							 			 

			</div>	
				 										 	
			 </div>			
			</div>			
		</div>
	</div>
	    <script type="text/javascript" src="js/jquery.mockjax.js"></script>
    	<script type="text/javascript" src="js/jquery.autocomplete.js"></script>
    	<script type="text/javascript" src="js/getPropertyValue.js"></script>
    
	</body>
</html>
