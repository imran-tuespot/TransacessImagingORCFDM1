<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<jsp:useBean id="indexTypeBean" scope="request" class="com.peniel.beans.IndexTypeBean" />

<%@page import="java.util.*"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-control" content="no-cache">
		<script src="js/jQuery/jquery-1.8.2.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<link rel="stylesheet" href="css/ui.all.css" type="text/css" media="screen" /> 
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<!-- <script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script> -->
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" /> 
		
		<title>Add Index Type</title>

<SCRIPT language="javascript">
function numAndLettersOnly(evt) 
{
       evt = (evt) ? evt : event;
       var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
          ((evt.which) ? evt.which : 0));
       if (charCode > 31 && (charCode < 65 || charCode > 90) &&
          (charCode < 97 || charCode > 122) &&                  // Letters Only
          (charCode > 31 && (charCode < 45 || charCode > 45 && charCode < 48 || charCode > 57))) //Numbers and - sign
         
       {
          alert("Enter letters, numbers and '-' sign only.");
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
  document.getElementById("indexType").value = "";
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
function deleteRow(rowID,indexTypeName) 
{	
	
	
	/*var conf = confirm("Do you want to delete an Index Type");
	
	if (conf==true)
	  {
	    //alert("Storing rowId in sessvar" + rowID)
	   //sessvars.rowID = { val: rowID};
	   //alert("Stored "+sessvars.rowID["val"]);
	   deleteIndextype(indexTypeName);
	 	
	  }*/
	  jConfirm('Do you want to delete an Index Type?', 'Confirmation Dialog', function(r) {
	  if (r==true)
	  {
	    	deleteIndextype(indexTypeName);	 	
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
  String htmlGrid = indexTypeBean.getIndexTypeGridHTML(cid);  
  //System.out.println("htmlGrid....... "+htmlGrid);
  %>

<body onLoad="initial_load()" >

<form name="upload" method="post" >
<input type="hidden" id="editRowFlag" value="false" />
<div class="card" style="width: 95%;  padding-left: 0px;margin-top:20px;">
	<div class="card-body card-padding" style="background-color:#EDECEC;margin-bottom: 20px;">
		
 		<table align="center" style="width: 100%"> 
			<tr valign="middle">
				<td align="left" style="width: 20%;" >
						Add New Index Type 
				</td>
				<td align="left">
  						<input type=text id="indexType" size="50" value="" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onkeypress="return numAndLettersOnly(event)" />
 				</td>
 			</tr>
 			<tr>
 				<td align="right">

 				</td>
				<td style="text-align: right;" colspan="2">
					<input id="saveBtn" type="button" class="btn btn-success" style="margin-right:15px" name="saveandnew" value="Save & Add New" onClick="javascript:saveForm();" >

					<input type="button" class="btn btn-warning" name="cancel" value="Cancel" onClick="javascript:onCancel();"/></td>
			</tr>

		</table>
	</div>
</div>
						
<TABLE align="center" style="width:95%" id="dataTable" class="TFtable">
    <thead><tr style="font-size: 0.8em;  padding: 5px 0px; text-transform: uppercase; background-color: #000066; text-align:left; color: #ffffff;  font-family:Geneva, Arial, Helvetica, sans-serif; font-weight: 500;">
  		 <th height="25px" class="blueHeaderNoRoundText">Index No.</th>
 		<th height="25px" class="blueHeaderNoRoundText">Index Type</th>
 		<th height="25px" class="blueHeaderNoRoundText">Delete</th>
 				
 </tr></thead>	
 <tbody id="indexTable">
 		<%= htmlGrid %> 
 </tbody>	
 </TABLE>
  
 
</form>


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
	
	setHeader('newIndexType.jsp');
	
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
function validateForm()
{	
	//Check if index type field contains value
	if(document.getElementById('indexType').value == "" ) 
	{
		jAlert("Enter Index Type Field.");
		return false;		
	}
	
	else if(document.getElementById('indexType').value != "" ) 
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
				  var indexType = myrow.getElementsByTagName("td")[1].innerHTML; 
				  
				  
				  if(document.getElementById('indexType').value.toUpperCase() === indexType.toUpperCase())  
				  {
					jAlert("This Entry Already Exists!");
					return false;
				  }             
	     	 }
	     	
     	   }
     				
	}
	
	return true;
	
}

var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object
function deleteIndextype(indexTypeName) 
{	
		var compid = '<%= cid %>';
		
		var queryString1 = "cId="+compid+"&indexType="+indexTypeName;
		//alert("queryString1 "+queryString1);
		if(xmlhttp) 
		{ 
		    xmlhttp.open("POST","DeleteIndexType",true); 
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
		jAlert("Index Type is deleted successfully!");		
		document.getElementById("indexTable").innerHTML = data;
		
		//window.location.reload(true);//skip the chache and reload the page from server
		//alert(sessvars.rowID["val"]);
	    //document.getElementById("dataTable").deleteRow(sessvars.rowID["val"]);	 	
	}
    else
    {	
		jAlert("Index Type "+document.getElementById('indexType').value+" can not be deleted, it might have associated documents.");
	}
	//$.unblockUI();
}


var xmlhttp1 = new getXMLObject();       //xmlhttp holds the ajax object
function saveForm() 
{
	if(validateForm())
	{
		document.getElementById('saveBtn').disabled = true;
		var compid = '<%= cid %>';
		var indexType = document.getElementById("indexType").value;		
		
		var queryString1 = "cId="+compid+"&indexType="+indexType;
		//alert("queryString1 "+queryString1);
		if(xmlhttp1) 
		{ 
		    xmlhttp1.open("POST","AddIndexType",true); 
		    xmlhttp1.onreadystatechange  = handleResponse;
		    xmlhttp1.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xmlhttp1.send(queryString1);
		} 
	 }
}

function handleResponse() 
{
   if (xmlhttp1.readyState == 4) 
   {
   		document.getElementById('saveBtn').disabled = false;
   	
	     if(xmlhttp1.status == 200) 
	     {
	     	parseProjectDocumentData(xmlhttp1.responseText);
	      }    
	     else 
	     {
	        //alert(xmlhttp1.status);
	     }
   }
}

function parseProjectDocumentData(data) 
{
	if(data != "no")
	{ 			
		jAlert("Index Type "+document.getElementById("indexType").value+" is added successfully!");
		document.getElementById('indexType').value = "";
		document.getElementById("indexTable").innerHTML = data;	 	
	}
    else
    {	
		jAlert("Index Type "+document.getElementById("indexType").value+" can not be added.");				
	}
	
	
}

String.prototype.trim = function () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}
</script>
</body>
</html>

