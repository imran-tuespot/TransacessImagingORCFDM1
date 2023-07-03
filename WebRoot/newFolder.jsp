<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />

<%@page import="java.util.*"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-control" content="no-cache">
		<script src="js/jQuery/jquery-1.8.2.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" /> 
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style type="text/css">
			.example {
			float: left;
			width:100%;
			
		}
		.folderStruct {
			width: 98%;
			border: solid 1px #BBB;
			background: #FFF;
			overflow: auto;
			padding: 5px;
			height:auto;
			min-height: 320px;
		}
		
		</style>
		
		<title>Add New Folder</title>




<SCRIPT language="javascript">
function oncancel()
{
	history.back(-1);

}

function numAndLettersOnly(evt) 
{
       evt = (evt) ? evt : event;
       var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
          ((evt.which) ? evt.which : 0));
       if (charCode > 32 && (charCode < 65 || charCode > 90) &&
          (charCode < 97 || charCode > 122) &&                  // Letters Only
          (charCode > 31 && (charCode < 45 || charCode > 45 && charCode < 47 || charCode > 57))) //Numbers and - sign
         
       {
          jAlert("Enter folder full path separated by /");
          return false;
       }
       return true;
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
  List<String> html = folderBean.getPropertyNameGridHTML(cid,"");
  request.getSession().setAttribute("folderData", html);	
    
  System.out.println("html....... "+html);
  %>

<body onLoad="initial_load()" >

<form name="upload" method="post" >

  <div align="center" style="margin:10px;">
					<p style="color:green;font-size:16px;text-align: left;margin-bottom:10px;margin-left:10px;"><i class="zmdi_large zmdi-present-to-all"></i>Add Folder</p>
  
 	<div class="card" style="width: 95%;  padding-left: 0px;">
		<div class="card-body card-padding" style="padding: 16px 6px 0px;background-color:#EDECEC;margin-bottom: 20px;">
			 <table class="table" cellspacing="0">
					<tbody>									
							<tr>
								<td>Folder Name</td>
											
								<td> 
										<input id="folderName" name="folderName"  size="50" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" onkeypress="return numAndLettersOnly(event)">
								</td>
								<td style="width: 45%;">
								<!-- <div class="checkbox m-b-15">
                              			<label>
                                  			<input id="chkPublicFolder" name="chkPublicFolder" checked="" type="checkbox">
                                  				<i class="input-helper"></i> Private Folder
                               		</label>
                         				</div> -->
                         		</td>
								</tr>
								<tr>
									<td style="text-align: right;" colspan="3">
									<input class="btn btn-success waves-effect waves-button waves-float" style="margin-right: 15px;" id="saveandnew"  name="saveandnew" value="Save" onClick="javascript:saveForm('add','');"  type="button">
									<input class="btn btn-warning waves-effect waves-button waves-float" type="button" name="cancel" value="Cancel" onClick="javascript:oncancel();"/>
														
									</td>
									
									<td>
									</td>
									
								</tr>
										
							</tbody>
					</table>
</div>
</div>
							
  <div class="card" style="width: 95%;  padding-left: 0px;">
					<div class="card-body card-padding"  style="padding: 16px 6px 20px;background-color:#EBEBEB;overflow: auto">    
						<div style="padding: 10px; min-height: 360px;" align="center" width= "100%">
								<div style="float: right;margin-bottom:5px;margin-right:10px">
								
								<input type="text" id="foltxt" placeholder="Search" style="width: 330px; box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onkeyup="javascript:searchFolSel();"/>
								
							<input id="folderNameFView" name="folderNameFView" readonly="readonly" type="text"  size=40 onkeypress="setFolderPatteren(this.options[this.selectedIndex].innerHTML)"></div> 
						
							<div class="example" id="folderView">
								<div  id="fileTreeDemo_3" class="folderStruct table table-bordered"></div>
							</div>	
					</div>
				</div>
</div> 
 
</div>

<TABLE align="center" width= "100%" id="dataTable" class="TFtable">
    
 	
 		
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
	
	setHeader('newFolder.jsp');
	var data = '<%=html%>';
    var s = [];   
    var dataArray = data.split(',');
   
    for(var i=0; i< dataArray.length;i++)
    {
        if((dataArray[i].split("/").length-1) === 2)
        {
            //alert(dataArray[i] +"  "+(dataArray[i].split("/").length-1));
        
        	var str =  dataArray[i];
        	//alert("Pushing "+ str);
        	s.push(str);
        }
       
    }  
	/* $('#fileTreeDemo_3').fileTree({ root: '/',expandedFolders: s , script: 'connectors/jqueryFolderTree.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'Un momento...' }, function(file) { 
					//alert(file);
	});
	 */
	 
	  $('#fileTreeDemo_3').fileTree({ root: '/',
			 script: 'connectors/jqueryFolderTree.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'One moment...' }, function(file) { 
							//alert(file);
				 
			});
	
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
	 // $('#adminWizardLi').click();
	  $("#adminWizardLi").collapse('toggle'); 
	
	
}

function onCancel(){
	clearSelection();
	
}

/************************************SAVE***********************************************/
function validateForm()
{	
	//Check if Folder field contains value
	var fname = document.getElementById('folderName').value;
	if(fname == "" ) 
	{
		jAlert("Enter Folder Field.");
		return false;		
	}
	
	
	
	return true;
	
}

var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object
function deleteFolder(indexTypeName) 
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
	if(data == "yes")
	{ 	
		jAlert("Index Type is deleted successfully!");	
		window.location.reload(true);//skip the chache and reload the page from server
		//alert(sessvars.rowID["val"]);
	    //document.getElementById("dataTable").deleteRow(sessvars.rowID["val"]);
		
	 	
	}
    else
    {	
		alert("Index Type "+document.getElementById('indexType').value+" might have documents associated with it.");
	}
	//$.unblockUI();
}


var xmlhttp1 = new getXMLObject();       //xmlhttp holds the ajax object
function saveForm(mode,path) 
{
   document.getElementById('saveandnew').disabled = true;

	if(validateForm())
	{
	
		var compid = '<%= cid %>';
		var folderName = document.getElementById("folderName").value;		
		var queryString1 = "cId="+compid+"&folderName="+folderName+"&mode="+mode+"&path="+path;
		//alert("queryString1 "+queryString1);
		if(xmlhttp1) 
		{ 
		    xmlhttp1.open("POST","AddFolder",true); 
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
     if(xmlhttp1.status == 200) 
     {
     	parseData(xmlhttp1.responseText);
      }    
     else 
     {
        alert(xmlhttp1.status);
     }
   }
   document.getElementById('saveandnew').disabled = false;
}

function parseData(data) 
{
    var success = data.substring(0,data.lastIndexOf("^"));
    var mode = data.substring(data.lastIndexOf('^')+1,data.length);
    
	if(success == "yes" && mode == "add")
	{ 			
		jAlert("Folder "+document.getElementById("folderName").value+" is added successfully!");
		document.getElementById('folderName').value="";		
		//window.location.reload(true);//skip the chache and reload the page from server
			
	}
	else if(success == "no" && mode == "add")
    {	
		jAlert("Folder "+document.getElementById("folderName").value+" can not be added.");				
	}
	else if(success == "yes" && mode == "delete")
	{ 			
		jAlert("Folder "+document.getElementById("folderName").value+" is deleted successfully!");
		document.getElementById('folderName').value="";		
		//window.location.reload(true);//skip the chache and reload the page from server
			
	}
	else if(success == "no" && mode == "delete")
    {	 
		jAlert("Folder "+document.getElementById("folderName").value+" can not be deleted.");				
	}
	else if(success == "yes" && mode == "edit")
	{ 			
		jAlert("Folder edited successfully!");
		document.getElementById('folderName').value="";		
		
		//window.location.reload(true);//skip the chache and reload the page from server 	
	}
	else if(success == "no" && mode == "edit")
    {	
		jAlert("Folder can not be edited.");				
	}
	if(success == "yes")
	{
	var data = '<%=html%>';
		var s = [];   
	    var dataArray = data.split(',');
	   
	    for(var i=0; i< dataArray.length;i++)
	    {
	        if((dataArray[i].split("/").length-1) === 2)
	        {
	            //alert(dataArray[i] +"  "+(dataArray[i].split("/").length-1));	        
	        	var str =  dataArray[i];
	        	//alert("Pushing "+ str);
	        	s.push(str);
	        }
	       
	    }  
/* 		$('#fileTreeDemo_3').fileTree({ root: '/',expandedFolders: s , script: 'connectors/jqueryFolderTree.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'Un momento...' }, function(file) { 
 */					//alert(file);
					  $('#fileTreeDemo_3').fileTree({ root: '/',
	 script: 'connectors/jqueryFolderTree.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'One moment...' }, function(file) { 
					//alert(file);
		
	
	});
	}
}

String.prototype.trim = function () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}

function searchFolSel()
{
	      var input = document.getElementById('foltxt').value.toLowerCase();
	      len = input.length;
	      output = $("div.folderStruct a");
	      if(len > 2 ) {
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

