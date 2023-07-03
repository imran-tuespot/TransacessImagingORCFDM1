<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<jsp:useBean id="docTypeBean" scope="request" class="com.peniel.beans.DocTypeBean" />

<%@page import="java.util.*"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-control" content="no-cache">
<!-- <script type="text/javascript" src="js/jQuery/jquery-1.8.2.min.js"></script> -->
		<script src="js/jQuery/1.11.3/jquery.min.js"></script> 
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>
				<script type="text/javascript" src="js/jquery-ui.min.js"></script>
		<link href="js/jquery-editable-select.css" rel="stylesheet">
		<script src="js/jquery-editable-select.js"></script>
		<script src="js/jquery.popupoverlay.js"></script>
				
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>     	
<!-- 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<link rel="stylesheet" href="css/ui.all.css" type="text/css" media="screen" /> 
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<!-- <script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script> -->
		<title>Add Document Type</title>
<%
javax.naming.Context ctx1 = 	new javax.naming.InitialContext();
String restURL = (String) ctx1.lookup("java:comp/env/restCommonUrl");
int companyid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
%>
<SCRIPT language="javascript">
// function dataChanged(){
// 	alert($("#folderSelect").val());	
// }
var doctypefolderArray=[];
function checkSelectedDocType(){
	//alert("==="+$("#DocTypeMaster option:selected").text());
	if($("#DocTypeMaster option:selected").text()=="Production"){
		$("#folderSelect").html("");
		$(".es-list").css("margin-left","-150");
	$("#folderSelect").show();	
	document.getElementById('folderSelect').value="";
	
	}else {
		$("#folderSelect").html("");
		$("#folderSelect").hide();	
		document.getElementById('folderSelect').value="";
	}

}

function getDocTypeMasterDropdown(){
	   var companyIdValue= '<%= companyid %>';
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getDocTypeMasterDropdown?companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				 $('#my_popup').popup('hide');
				 $("#DocTypeMaster").html("");
					 $("#textError").empty();
					 $("#DocTypeMaster").append("<option value='' selected disabled>Select Document Type</option>");
				for(i=0;i<data.response.length;i++){
				       $("#DocTypeMaster").append("<option value='"+data.response[i].docTypeMasterId+"'><b>"+data.response[i].docTypeMasterDesc+"</b></option>");
				       
				      } 
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
}

function getFoldersForDocType(){
	   var companyIdValue= '<%= companyid %>';
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getFoldersForDocType?companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				 $('#my_popup').popup('hide');
				 $("#folderSelect").html("");
					 $("#textError").empty();
					 $("#folderSelect").append("<option value='' selected disabled></option>");
				 for(i=0;i<data.response.length;i++){
				       $("#folderSelect").append("<option value='"+data.response[i].subFolderId+"'>"+data.response[i].folderName+"</option>");
						 doctypefolderArray.push(data.response[i].folderName);
				      } 
				$('#folderSelect').editableSelect();
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
}

function numAndLettersOnly(evt) 
{
      evt = (evt) ? evt : event;
      var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
         ((evt.which) ? evt.which : 0));
      if ((charCode > 32 && (charCode < 65 || charCode > 90) &&
         (charCode < 97 || charCode > 122) &&                  // Letters Only
         (charCode > 31 && (charCode < 45 || charCode > 45 && charCode < 48 || charCode > 57)))){
         jAlert("Enter letters, numbers and '-' sign only.");
         return false;
      }
      return true;
    }


function getMax(rowcount,col)
{			
	var maxRowVal = 1;
	$("table#dataTable tr").each(function( i )
    {
		$("td", this).each(function( j ) 
		{
		  	if(j==col)
		  	{
		         maxRowVal = parseInt($(this).text())+1;			   			     
		    } 		     
	  	});
	});
	return maxRowVal;			
}



function clearSelection()
{
  document.getElementById("documentType").value = "";
}

		 
function checkBoxValidate(cb) 
{
    var table = document.getElementById('dataTable');
    var mytablebody = table.getElementsByTagName("tbody")[0];
    var rowCount = mytablebody.rows.length;
		
     for(var i=0; i< rowCount; i++) 
     {
      	var id = 'checkbox'+(i+1);       	
        	
       if (document.getElementById(id).checked == true) 
       {         	
			document.getElementById(id).checked = false;
			if (cb == (i+1)) 
			{
					document.getElementById(id).checked = true;
	     	}
		}
     }           
	
	//Clear selection in DocumentType listbox
    clearSelection();
        
}

/*function addRow(tableID) 
{	
	 // alert("Inside add row");
      var table = document.getElementById(tableID);
      var rowCount = table.rows.length;         
      var row = table.insertRow(rowCount);
      var count = getMax(rowCount,0);         
      row.setAttribute('style','font-size:11px;font-family: Roboto;');
     
      var cell1 = row.insertCell(0);
      cell1.innerHTML = count;
      
      var cell2 = row.insertCell(1);
      cell2.setAttribute('id',"indexType"+count);
      cell2.innerHTML = document.getElementById("indexType").value;
      
      var cell3 = row.insertCell(2);
      cell3.setAttribute('id',"deleteIndexType"+count);
      var deletelink = document.createElement("a");
	  deletelink.setAttribute('href',"javascript:deleteRow('"+count+"','"+document.getElementById("indexType").value+"');");
	
	  var deleteImage = document.createElement("i");
	  deleteImage.className = "zmdi_large zmdi-delete";
	  deletelink.appendChild(deleteImage);
	  cell3.appendChild(deletelink);
	  
	
     
 }   */
function deleteRow(mode,docType) 
{	
	
	
	/*var conf = confirm("Do you want to delete an document Type");
	
	if (conf==true)
	  {
	    //alert("Storing rowId in sessvar" + rowID)
	   //sessvars.rowID = { val: rowID};
	   //alert("Stored "+sessvars.rowID["val"]);
	   deleteIndextype(indexTypeName);
	 	
	  }*/
	  jConfirm('Do you want to delete '+docType+' document type?', 'Confirmation Dialog', function(r) {
	  if (r==true)
	  {
	    	saveForm(mode,docType,'');	 	
	  }
	});
}       
 

    </SCRIPT>
 
</head>


<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>

<jsp:include page="includes/sessionHeader.jsp" />


<% 
     
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  String cid	= request.getSession().getAttribute("comid").toString();
  String userName = request.getSession().getAttribute("username").toString();
  String htmlGrid = docTypeBean.getDocumentTypeGridHTML(cid);  
  //System.out.println("htmlGrid....... "+htmlGrid);
  %>

<body onLoad="initial_load()" >
<!-- Add content to the popup -->
  <div id="my_popup">
	<div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em; opacity: 1; visibility: visible; display: inline-block; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
    <h4><i class="zmdi_large zmdi-settings zmdi-hc-spin"></i> Loading Contents...Please Wait...</h4>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;It will take few seconds.</p>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;Please wait while the contents are loading.</p>
    
	</div>
	
  </div> 
	
		
  
<form name="upload" method="post" style="margin-bottom: 60px;">
<input type="hidden" id="editRowFlag" value="false" />
<div class="card" style="width: 95%;  padding-left: 0px;margin-top:20px;">
	<div class="card-body card-padding" style="background-color:#EDECEC;margin-bottom: 20px;">
		
 		<table align="center" style="width: 100%"> 
			<tr valign="middle">
				<td align="left" style="width: 20%;" >
						New Document Type 
				</td>
				<td align="left">
  						<input type=text id="documentType" size="38" value="" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onkeypress="return numAndLettersOnly(event)" />
 				</td>
 				<td>
 				<select style="width:189px;margin-top: 10px;margin-bottom: 10px;margin-right: 150px;margin-left: 0px;height: 24px;" onchange="checkSelectedDocType()" name="DocTypeMaster" id="DocTypeMaster" class="selectText">
									  			</select>
 				</td>
 				<td>
        <select name="folderSelect" placeholder="Select Folder" id="folderSelect" style="margin-left:-150;height: 24px;width:200px" class="selectText">
		</select>   

 				</td>
 			</tr>
 			<tr><td>&nbsp;</td></tr>
  			<tr>
 				<td align="right">

 				</td>
				<td style="text-align: center;" colspan="2">
					<input id="saveBtn" type="button" class="btn btn-success" style="margin-right:15px" name="saveandnew" value="Save & Add New" onClick="javascript:saveForm('add','','');" >

					<input type="button" class="btn btn-warning" name="cancel" value="Cancel" onClick="javascript:onCancel();"/></td>
			</tr>

		</table>
	</div>
</div>
<div  style="height:80%;overflow: auto;">
					
<TABLE align="center" style="width:95%" id="dataTable" class="TFtable">
    <thead><tr style="font-size: 0.8em;  padding: 5px 0px; text-transform: uppercase; background-color: #000066; text-align:left; color: #ffffff;  font-family:Geneva, Arial, Helvetica, sans-serif; font-weight: 500;">
  		 <th height="25px" class="blueHeaderNoRoundText">Type No.</th>
 		<th height="25px" class="blueHeaderNoRoundText">Document Type</th>
 		<th height="25px" class="blueHeaderNoRoundText">Delete</th>
 				
 </tr></thead>	
 <tbody id="documentTable">
 		<%= htmlGrid %> 
 </tbody>	
 </TABLE>
</div>  
 
</form>
<div style="display:none; "   id="contextMenu">
        <table id="contextMenu"  border="0" cellpadding="0" cellspacing="10" 
            style="font-family: roboto;
				font-size: 11px;
				background: #EEE;
				padding: 10px;border: thin solid #808080; cursor: default;" width="160px" 
            bgcolor="White" >
            <tr>
                <td style="padding: 5px;">
                    <a id="newDocType" class="ContextItem">New Document Type</a>
                </td>
            </tr>
           <!-- Temporary Disabled   <tr> 
                <td style="padding: 5px;">
                <a  id="editDocType" class="ContextItem">Edit Document Type</a>
                </td>
            </tr>-->
            <tr>
                <td style="padding: 5px;">
                    <a id="deleteDocType" class="ContextItem">Delete Document Type</a>
                </td>
            </tr>
        </table>
  </div>

<script language="javascript">


function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try 
   {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); // For Old Microsoft Browsers
   }
   catch (e) 
   {
     try 
     {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp = false;   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}


function initial_load() {
	$("#folderSelect option:selected").removeAttr("selected");
	$("#DocTypeMaster option:selected").removeAttr("selected");
	 getDocTypeMasterDropdown();	
	 getFoldersForDocType();
	 $("#folderSelect").hide();	
	setHeader('newDocType.jsp');
	// Initialize the plugin
      $('#my_popup').popup({color:'#000'});
      
      //Initialize slider menu
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
	//  $('#adminWizardLi').click();
	  $("#adminWizardLi").collapse('toggle'); 
	 	
}

function onCancel(){
	//clearSelection();
	window.location="dashboard.jsp";
	
}

/************************************SAVE***********************************************/
function validateForm(mode)
{	
	//Check if document type field contains value
	if(document.getElementById('documentType').value == "" && mode == "add") 
	{
		jAlert("Enter document type field.");
		return false;		
	}else if(document.getElementById('DocTypeMaster').value=="" && mode == "add"){
		jAlert("Enter document type.");
		return false;
    }else if($("#DocTypeMaster option:selected").text()=="Production" && mode == "add"){
    	if(document.getElementById('folderSelect').value=="")	{
			jAlert(" Enter/Select Folder.");
			return false;
	}
    } else if(document.getElementById('documentType').value != "" && mode == "add") 
	{
		//Check for repeated entry 
			var table = document.getElementById('dataTable');
	        var mytablebody = table.getElementsByTagName("tbody")[0];
	        if(typeof(mytablebody) != 'undefined')
	        {
	          var rowCount = mytablebody.rows.length;         	
	          for(var i=0; i<rowCount; i++) 
	          {
	              var myrow = mytablebody.getElementsByTagName("tr")[i];
				  var documentType = myrow.getElementsByTagName("td")[1].innerHTML; 
				  if(document.getElementById('documentType').value.toUpperCase() === documentType.toUpperCase())  
				  {
					jAlert("Document type already exists!");
					return false;
				  }             
	     	 }
	     	
     	   }
     				
	}
	
	return true;
	
}

var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object
function deleteDocumenttype(documentTypeName) 
{	
		var compid = '<%= cid %>';
		
		var queryString1 = "cId="+compid+"&documentType="+documentTypeName;
		//alert("queryString1 "+queryString1);
		if(xmlhttp) 
		{ 
		    xmlhttp.open("POST","DeleteDocumentType",true); 
		    xmlhttp.onreadystatechange  = handleResponseFromDelete;
		    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xmlhttp.send(queryString1);
		} 
	 
}

function handleResponseFromDelete() 
{
   if (xmlhttp.readyState == 4) 
   {
     if(xmlhttp.status == 200) 
     {
     	parseDataFromDelete(xmlhttp.responseText);
      }    
     else 
     {
        //alert(xmlhttp.status);
     }
   }
}

function parseDataFromDelete(data) 
{
	if(data != "no")
	{ 	
		jAlert("Document Type is deleted successfully!");		
		document.getElementById("documentTable").innerHTML = data;
		
		//window.location.reload(true);//skip the chache and reload the page from server
		//alert(sessvars.rowID["val"]);
	    //document.getElementById("dataTable").deleteRow(sessvars.rowID["val"]);	 	
	}
    else
    {	
		jAlert("Document Type "+document.getElementById('documentType').value+" can not be deleted, it might have associated documents.");
	}
}


var xmlhttp1 = new getXMLObject();       //xmlhttp holds the ajax object
function saveForm(mode,newDocType,oldDocType) 
{
	if(validateForm(mode))
	{
		document.getElementById('saveBtn').disabled = true;
		var compid = '<%= cid %>';
		var doctypemaster=$("#DocTypeMaster option:selected").val();
		//var selectFolder=document.getElementById("folderSelect").;
		var selectFolder="";
		var folderId=0;
		if($(".es-list .es-visible").val()!=undefined){
			selectFolder=$(".es-list .es-visible").text();
			folderId=$(".es-list .es-visible").val();
		}else{
			selectFolder=document.getElementById("folderSelect").value;
		//	alert("new folder==="+selectFolder);
		}
 		var newFolderFlag=0;
 		if(jQuery.inArray(selectFolder,doctypefolderArray)==-1){
 			newFolderFlag=1;
 		}
		//alert("newFolderFlag=="+newFolderFlag)
		if(newDocType == '')
			newDocType = document.getElementById("documentType").value;		
		
		var queryString1 = "cId="+compid+"&mode="+mode+"&documentType="+newDocType+"&oldDocType="+oldDocType+"&doctypemaster="+doctypemaster+"&selectfolder="+selectFolder+"&newFolderFlag="+newFolderFlag+"&folderId="+folderId;
		//alert("queryString1 "+queryString1);
		
		$('#my_popup').popup('show');
		if(xmlhttp1) 
		{ 
		    xmlhttp1.open("POST","AddDocumentType",true); 
		    xmlhttp1.onreadystatechange  = handleResponse;
		    xmlhttp1.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xmlhttp1.send(queryString1);
		} 
		initial_load();
	 }
}

function handleResponse() 
{
   if (xmlhttp1.readyState == 4) 
   {
   	document.getElementById('saveBtn').disabled = false;
    	   
     if(xmlhttp1.status == 200) 
     {
    	// alert("xmlhttp1.responseText----"+xmlhttp1.responseText);
     	parseDocumentData(xmlhttp1.responseText);
     	$('#my_popup').popup('hide');
      }    
     else 
     {
        //alert(xmlhttp1.status);
     }
   }
}

function parseDocumentData(data) 
{
	var success = data.substring(0,data.lastIndexOf("^"));
    var mode = data.substring(data.lastIndexOf('^')+1,data.length);
   // alert ("success "+success)
	if(success != "no" && mode == "add")
	{ 			//alert("hiii"+document.getElementById("documentType").value);
		jAlert("Document Type "+document.getElementById("documentType").value+" is added successfully!");
		document.getElementById('documentType').value = "";		
		document.getElementById("documentTable").innerHTML = success; 	
		return;
	}
    else if (success == "no" && mode == "add")
    {	
		jAlert("Document Type "+document.getElementById("documentType").value+" can not be added.");				
	}
	else if(success != "no" && mode == "delete")
	{ 			
		jAlert("Document Type is deleted successfully!");		
		document.getElementById("documentTable").innerHTML = success;
		
	}
    else if(success == "no" && mode == "delete")
    {	
		jAlert("Document Type "+document.getElementById('documentType').value+" can not be deleted, it might have associated documents.");
	}else if(success != "no" && mode == "edit")
	{ 			
		jAlert("Document Type is edited successfully!");		
		document.getElementById("documentTable").innerHTML = success;
		
	}
    else if(success == "no" && mode == "edit")
    {	
		jAlert("Document Type can not be edited.");
	}
	
	
}

String.prototype.trim = function () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}

document.onmouseup = myMouseDownHandler;

    function myMouseDownHandler() {
		document.getElementById('contextMenu').style.display = 'none'; 
    }
function showContextMenu(obj,e,control,doctype)
{
	e.preventDefault();
	var x = $("#"+obj).position();
 	var posx =  x.left +120 +'px'; //Left Position of element
    var posy = x.top+ 20 + 'px'; //Top Position of li            
    //alert("x: " + posx + " y: " + posy);
    document.getElementById(control).style.position = 'absolute';
    document.getElementById(control).style.display = 'block';
    document.getElementById(control).style.left = posx;
    document.getElementById(control).style.top = posy;
            
                       
	document.getElementById('newDocType').onclick = function() {
	//alert("You are creating under "+path);
	document.getElementById(control).style.display = 'none';
	jPrompt('Please enter document type', 'New Document Type', 'New Document Type', function(docTypeName) {
   	if( docTypeName)     			
   		if(docTypeName != null)
   		{
   			document.getElementById("documentType").value = docTypeName;	    		
   			saveForm('add',docTypeName,'');
   		}
	});
	};
	
	
	/*document.getElementById('editDocType').onclick = function() {
	document.getElementById(control).style.display = 'none';
	
	jPrompt('Please enter document type', 'Edit Document Type', 'Edit Document Type', function(docTypeName) {
   	if( docTypeName)     			
     			if(docTypeName != null)
     			{
     				document.getElementById("documentType").value = docTypeName;       				
     			  // jAlert("You have entered "+docTypeName+ " as new name");       			
     			    saveForm('edit',docTypeName,doctype);
     			}
	});
	};*/
	
	
	document.getElementById('deleteDocType').onclick = function() {
	//alert("You are deleting folder "+path+"/");	
	
	jConfirm('Do you want to delete ' +doctype+' document type?', 'Confirmation Dialog', function(confirmDelete) {
 		//jAlert('Confirmed: ' + confirmDelete, 'Confirmation Results');
 		if(confirmDelete == true)
		{
		    document.getElementById("documentType").value = doctype;	  	    
			document.getElementById(control).style.display = 'none';
			//deleteDocumenttype(doctype);
			saveForm('delete',doctype,'');
		}
	});
	};
}

</script>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Success message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeModal()">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body text-center">
        Document(s) Assigned Successfully
        <div class="clearfix"></div>
        <br />
        <button class="btn btn-success btn-orange width120" onclick="closeModal()">Close</button>
      </div>
    </div>
  </div>
</div>	

</body>
</html>

