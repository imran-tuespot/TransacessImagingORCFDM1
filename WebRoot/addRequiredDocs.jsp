<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<jsp:useBean id="projectDocumentBean" scope="request" class="com.peniel.beans.ProjectDocumentBean" />
<jsp:useBean id="companyInformation" scope="request" class="com.peniel.beans.CompanyInformation" />
<jsp:useBean id="indexTypeBean" scope="request" class="com.peniel.beans.IndexTypeBean" />

<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.peniel.dao.ProjectDocumentDAO"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<link rel="stylesheet" href="css/ui.all.css" type="text/css" media="screen" /> 
		
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script> 
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>
		
		<title>Add Required Documents</title>
  
 <%
		/*Set set = hashMap.entrySet();
		
		// Get an iterator
		Iterator it = set.iterator();
		
		while(it.hasNext()) 
		{
			Map.Entry me = (Map.Entry)it.next();			
			System.out.println(""+me.getKey() +" "+ me.getValue());
		} 	*/
  Calendar calendar = GregorianCalendar.getInstance();     
  calendar.add(Calendar.MONTH, -1);
  calendar.set(Calendar.DAY_OF_MONTH,                 
  calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); 
  Date beginingDt = calendar.getTime();  
  SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

  String beginDate = date_format.format(beginingDt);   
         
  calendar.setTime(beginingDt);
  calendar.add(Calendar.DATE, 42);	    
  Date endDt = calendar.getTime(); 
  String endDate = date_format.format(endDt);  
  
  calendar.setTime(new Date()); 
  Date todaysDt = calendar.getTime(); 
  
  if(todaysDt.after(endDt))
  {
  
  	//set new begin date as 1st of current month
  	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); 
    beginingDt = calendar.getTime();  
    beginDate = date_format.format(beginingDt); 
    calendar.setTime(beginingDt);
    
  	calendar.add(Calendar.DATE, 42);	    
  	endDt = calendar.getTime(); 
   	endDate = date_format.format(endDt);   	
  }
   System.out.println("begin date "+beginDate);
   System.out.println("end date "+endDate);
%>

<SCRIPT language="javascript">

  today=new Date();
  //Set 1 day in milliseconds
  one_day=1000*60*60*24;
  
  beginDt = new Date('<%= beginingDt %>');
  endDt = new Date('<%= endDt %>');
  mx = Math.ceil((endDt.getTime() -today.getTime())/(one_day));
  mv = Math.ceil((today.getTime()-beginDt.getTime())/(one_day));
 
  var minDt = '-'+(mv-1)+'D';
  var maxDt = '+'+(mx-1)+'D';		  

$(function()
{
  	 var pickerOpts = 
  	 {  
   	 	dateFormat:"yy-mm-dd", //four digit year
   	 	buttonImage: 'images/calendar.png',         
  	 	buttonImageOnly: true,
  	 	minDate: minDt,
  	 	maxDate: maxDt  	 	       	 	
    };
    
   	var pickerOpts1 = 
   	{  
	   	 dateFormat:"yy-mm-dd", //four digit year
	   	 buttonImage: 'images/calendar.png',         
	  	 buttonImageOnly: true,
	  	 minDate: minDt       	 	
   	};
  	 $("#datepicker").datepicker(pickerOpts);  
  	 $("#datepicker1").datepicker(pickerOpts1);    
       	      			
});		

function populateYearSelect() 
{ 
    d = new Date(); 
    curr_year = d.getFullYear(); 
    for(var i=0; i<3; i++)
    { 
        document.getElementById('selectYear').options[i+1] = new Option(curr_year-i,curr_year-i); 
        
    } 
} 

function daysInMonth(iMonth, iYear)
{
	return 32 - new Date(iYear, iMonth, 32).getDate();
}

function selectDatesOfYear()
{
	var year = $('#selectYear').val();	            
    var selectMonth = document.getElementById('selectMonth'); 
              
    for(var i = 0; i < 12; i++) 
    {
	   var lastDate = daysInMonth(i,year);	   
	   var strOption = year+"-"+(i+1)+"-1   To   "+year+"-"+(i+1)+"-"+lastDate;
       selectMonth.options[i+1] = new Option(strOption);       
    } 
}

function toggle_visibility(divid,lnkid) 
{
   var expandableCol = document.getElementById(divid);
   var divs = expandableCol.getElementsByTagName('div');
	   
   for (var j = 0; j < divs.length; j++) 
   {     
    divs[j].bgcolor = '#CCCCCC';
      if(divs[j].style.display == 'none')
         divs[j].style.display = 'block';
      else if(divs[j].style.display == 'block')
         	divs[j].style.display = 'none';
   }   
	 
   var x = document.getElementById(lnkid);
   if (x.innerHTML == '[+] Expand ')
      x.innerHTML = '[-] Collapse ';
   else
      x.innerHTML = '[+] Expand ';
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

function checkWhiteSpaces(id,caption)
{
   	if(document.getElementById(id).value.indexOf(" ") > -1)
	{
		alert(""+caption+" can not contain spaces");
		document.getElementById(id).focus();
	}			
}	

function numAndLettersOnly(evt) {
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

function clearSelection()
{
  
  document.getElementById("projectNumber").value = "";
  document.getElementById("datepicker").value = "";
  document.getElementById("datepicker1").value = "";
  document.getElementById("email1").value = "";
  document.getElementById("email2").value = "";
  document.getElementById("email3").value = "";
  document.getElementById("email4").value = "";
}
		 
function checkBoxValidate(cb) 
{
   try {           
    
    var table = document.getElementById('dataTable');
    var mytablebody = table.getElementsByTagName("tbody")[0];    
    var rowCount = mytablebody.rows.length;
    var CheckdBox = false;
     
     for(var i=0; i< rowCount; i++) 
     {
     	var myrow = mytablebody.getElementsByTagName("tr")[i];
	    var mycel = myrow.getElementsByTagName("td")[0]; 
      	var chkbox = mycel.getElementsByTagName("input")[0];
      	//var id = 'checkbox'+(i+1);       	
        var rowNumber = myrow.getElementsByTagName("td")[1].innerHTML; 
        var id = 'checkbox'+rowNumber;
           if (null != chkbox && true == document.getElementById(id).checked) 
	       {         	
	       		CheckdBox = true;
				document.getElementById(id).checked = false;
				
				if (cb == rowNumber) 
				{
					document.getElementById(id).checked = true;
					//showButtons('dataTable');
					document.getElementById("delete").disabled=false;
					document.getElementById("btnedit").disabled=false;
					document.getElementById("saveandnew").disabled=true;				
		     	}
			}
		
     }
     if(CheckdBox == false)
     {
     	document.getElementById("delete").disabled=true;
		document.getElementById("btnedit").disabled=true;
		document.getElementById("saveandnew").disabled=false;
     }   
      }catch(e) {
         alert(e);
     }     
	
	//Clear selection in DocumentType listbox
    clearSelection();
        
}

function _setStyle(element, declaration) {
   if (declaration.charAt(declaration.length-1)==';')
     declaration = declaration.slice(0, -1);
   var k, v;
   var splitted = declaration.split(';');
   for (var i=0, len=splitted.length; i<len; i++) {
      k = rzCC(splitted[i].split(':')[0]);
      v = splitted[i].split(':')[1];
      eval("element.style."+k+"='"+v+"'");

   }
 }


function addRow(tableID) 
{	
      var table = document.getElementById(tableID);
      var rowCount = table.rows.length;         
      var row = table.insertRow(rowCount);
      var count = getMax(rowCount,1);
      //Doesn't work for IE         
      //row.setAttribute('style','font-size:11px;font-family: Verdana;');
     // _setStyle(row, 'font-size:11px;font-family: Verdana');
     
     
     //use browser sniffing to determine if IE or Opera (ugly, but required)
 	/* var isOpera, isIE = false;
 	 alert(typeof(window.opera));
  	 if(typeof(window.opera) != 'undefined')
  	 {
  	 	isOpera = true;
  	 }
     if(!isOpera && navigator.userAgent.indexOf('Internet Explorer'))
     {
     	isIE = true;
  	 }
   		var styleData = 'font-size:11px;font-family: Verdana'
    	if(!isIE)
    	{
    		//use the correct DOM Method
    		alert("Not IE");
    		row.setAttribute('style','font-size:11px;font-family: Verdana;'); 
   		} else 
   		{
    		//use the .cssText hack
    		alert("IE");
    		row.style.setAttribute('cssText', styleData);
    	}
    */
     
      //tempEl.style.setAttribute('cssText', 'left:150px; top:150px;', 0);

      
      var cell1 = row.insertCell(0);
      var element1 = document.createElement("input");
      
      element1.setAttribute('type','checkbox');
	  element1.setAttribute('id',"checkbox"+count);
      element1.setAttribute('name',"ckbox");
      element1.onclick = new Function("checkBoxValidate(" + count + ")");
      
     // element1.setAttribute('onclick',"javascript:checkBoxValidate("+count+");");
      element1.checked = false;
      cell1.appendChild(element1);

      var cell2 = row.insertCell(1);
      cell2.innerHTML = count;
      
      var cell3 = row.insertCell(2);
      cell3.setAttribute('id',"projectNumber"+count);
      cell3.innerHTML = document.getElementById("projectNumber").value;
      
      var cell4 = row.insertCell(3);
      cell4.setAttribute('id',"entryDate"+count);
      cell4.innerHTML = document.getElementById("datepicker").value;
      
      var cell5 = row.insertCell(4);
      cell5.setAttribute('id',"dueDate"+count);
      cell5.innerHTML = document.getElementById("datepicker1").value;
      
	  var cell6 = row.insertCell(5);  
	  var element3 = document.createElement("div");   
	  //element3.setAttribute('id',"divEmail"+count);
	  element3.id = "divEmail"+count;
	  
	  var togglelink = document.createElement("a");
	 // togglelink.setAttribute('href',"javascript:toggle_visibility('divEmail"+count+"','lnkEmail"+count +"');");
	  togglelink.href = "javascript:toggle_visibility('divEmail" + count +"','lnkEmail"+count + "')";
	  
	  var togglediv = document.createElement("div");
	  //togglediv.setAttribute('id',"lnkEmail"+count );
	  togglediv.id = "lnkEmail"+count;
	  
	  plustext = document.createTextNode("[-] Collapse");
	  togglediv.appendChild(plustext);				 
	  togglelink.appendChild(togglediv);
	  element3.appendChild(togglelink);
	  cell6.appendChild(element3);
	  for(i=1; i <= 4; i++)
	  {
	  	if(document.getElementById("email"+i).value != "")
	  	{
			var col = document.getElementById("divEmail"+count);
			var rowItem = document.createElement("div");
			//rowItem.setAttribute('style',"display:block");
			rowItem.style.setAttribute('cssText',"display:block");
			col.appendChild(rowItem);
			rowItem.innerHTML = document.getElementById("email"+i).value;
		}			
	 }		
		//Make buttons visible			
		if(document.getElementById("delete").style.display == "none")
			document.getElementById("delete").style.display="block";
		if(document.getElementById("btnedit").style.display == "none")
			document.getElementById("btnedit").style.display="block";			
     }
        
function editRow(tableID)
{ 		
  var table = document.getElementById(tableID);
  var mytablebody = table.getElementsByTagName("tbody")[0];
  var rowCount = mytablebody.rows.length;	  
          
  //Set the editRow flag
  document.getElementById('editRowFlag').value = "true";
  
  //Make delete disabled
  document.getElementById("delete").disabled=true;
  document.getElementById("projectNumber").disabled=true;
  //Make save enabled
  document.getElementById("saveandnew").disabled=false;
  //Make edit disabled
  document.getElementById("btnedit").disabled=true;
  
  
  	
	for(var i=0; i<rowCount; i++) 
	{
	    var myrow = mytablebody.getElementsByTagName("tr")[i];
	    var mycel = myrow.getElementsByTagName("td")[0];               
	    var chkbox = mycel.getElementsByTagName("input")[0];
	        
	    if(null != chkbox && true == chkbox.checked) 
	    {
	    	var rowNumber = myrow.getElementsByTagName("td")[1].innerHTML; 
	    	var id = 'projectNumber'+rowNumber; 
	    	document.getElementById("projectNumber").value = document.getElementById(id).innerHTML;
	    	
	    	var queryEntryDate = document.getElementById('entryDate'+rowNumber).innerHTML;	    	
	    	if(queryEntryDate !== 'null' )
	    	{
	    		dateParts = queryEntryDate.match(/(\d+)/g);     
	    		realEntryDate = new Date(dateParts[0], dateParts[1] - 1, dateParts[2]); 
	    		$('#datepicker').datepicker('setDate', realEntryDate); 
	    	}
	    	
	    	var queryDueDate = document.getElementById('dueDate'+rowNumber).innerHTML;	    	
	    	if(queryDueDate !== 'null' )
	    	{	   
	    		dateParts = queryDueDate.match(/(\d+)/g);    
		    	realDueDate = new Date(dateParts[0], dateParts[1] - 1, dateParts[2]); 
		    	$('#datepicker1').datepicker('setDate', realDueDate);   
	    	} 
	    		    	   	
	    	var emailsdiv = document.getElementById('divEmail'+rowNumber);                	
	    	var responsiblePartyEmails = emailsdiv.getElementsByTagName('div');                	
	    }
	 }	                  
   
	for(i=1; i < responsiblePartyEmails.length; i++)
	{									
		for(j=1; j <= 4; j++)
		{	
			if(i === j)				
				document.getElementById('email'+j).value = responsiblePartyEmails[i].innerHTML;        
	    }  
	} 
		              			
	
}
 		
function deleteRow(tableID) 
{
  //Make delete disabled
  document.getElementById("delete").disabled=true;
  //Make save enabled
  document.getElementById("saveandnew").disabled=false;
  //Make edit disabled
  document.getElementById("btnedit").disabled=true;
      try 
      {           
       var table = document.getElementById(tableID);
       var mytablebody = table.getElementsByTagName("tbody")[0];
       var rowCount = mytablebody.rows.length;

       for(var i=0; i<rowCount; i++) 
       {
         	var myrow = mytablebody.getElementsByTagName("tr")[i];
			var mycel = myrow.getElementsByTagName("td")[0];
            var chkbox = mycel.getElementsByTagName("input")[0];
          
            if(null != chkbox && true == chkbox.checked) 
            {
           	   //var rowNumber = myrow.getElementsByTagName("td")[1].innerHTML;
               table.deleteRow((i+1));
               rowCount--;
               i--;
        	 }
        
	         //Clear selection in DocumentType listbox
	         clearSelection();
	      
	         if(rowCount == 0)
	         {
	          	//Make buttons invisible
				if(document.getElementById("delete").style.display == "block")
					document.getElementById("delete").style.display="none";
				if(document.getElementById("btnedit").style.display == "block")
					document.getElementById("btnedit").style.display="none";			
	         } 
       }
      }catch(e) {
          alert("exception in delete row"+e);
      }
 }
    
function getRecordInfo(tableID) 
{
     try {           
     var table = document.getElementById(tableID);
     var mytablebody = table.getElementsByTagName("tbody")[0];
     var rowCount = mytablebody.rows.length;

     for(var i=0; i<rowCount; i++) 
     {
         var myrow = mytablebody.getElementsByTagName("tr")[i];
		 var mycel = myrow.getElementsByTagName("td")[0];               
         var chkbox = mycel.getElementsByTagName("input")[0];
        
         if(null != chkbox && true == chkbox.checked) 
         {
         	var rowNumber = myrow.getElementsByTagName("td")[1].innerHTML; 
         	var id = 'projectNumber'+rowNumber;
         	 
             return document.getElementById(id).innerHTML;                
      	}
     
     }
     }catch(e) {
         alert(e);
     }
} 		
 		
function showButtons(tableID)
{
	 try 
	 {       
         var table = document.getElementById(tableID);
         var mytablebody = table.getElementsByTagName("tbody")[0];
         if(typeof(mytablebody) != 'undefined')
         {
         	var rowCount = mytablebody.rows.length; 			
            if(rowCount >= 1)
           	{
            	//Make buttons visible
				if(document.getElementById("delete").style.display == "none")
					document.getElementById("delete").style.display="block";
				if(document.getElementById("btnedit").style.display == "none")
					document.getElementById("btnedit").style.display="block";
					
								
	        } 
         }
       }
       catch(e) {
           alert(e);
       }
}

function validateEmail(elementId){  
   var elementValue = document.getElementById(elementId).value; 
   var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;   
   if(elementValue != "" && !emailPattern.test(elementValue))
   {
   		alert("Please enter valid email address");
   		document.getElementById(elementId).focus();
   }   
 }  

    </SCRIPT>
</head>


<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>

<jsp:include page="includes/sessionHeader.jsp" />

<% 
     
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  
  String lastName = "";
  String firstName = "";
  HashMap companyHashMap = companyInformation.getcompanyInformation(request.getSession().getAttribute("comid").toString());
  String indexType = indexTypeBean.getIndexType(companyHashMap.get("defaultIndex").toString(),
  												request.getSession().getAttribute("comid").toString());
 
  HashMap hashMap = userInformation.getUserInformation(request);
   
  lastName = (String) hashMap.get("lastName");
  if(lastName== null) lastName="";
  firstName = (String) hashMap.get("firstName"); 
  if(firstName== null) firstName="";  
  
  java.util.Date today = new java.util.Date();
  java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
  String htmlGrid = projectDocumentBean.getProjectDocumentHTML(cid,beginDate,endDate);  
  %>

<body onLoad="initial_load()" >

<form name="upload" method="post" action="AddRequiredDocumentView.jsp">
<input type="hidden" id="editRowFlag" value="false" />
<div style="font-size:11px;font-family: Verdana;" align="right">* Projects entered in past 6 Weeks.  </div>
  <TABLE  style="font-size:11px;font-family: Verdana;" align="center" width= "100%" border="0"  id="dataTable">
   <thead>
    <tr class="blueHeaderNoRound">
  		<th height="25px"></th>
  		<th height="25px" class="blueHeaderNoRoundText">No.</th>
 		<th height="25px" class="blueHeaderNoRoundText"><%=indexType%></th>
 		<th height="25px" class="blueHeaderNoRoundText">Entry Date</th>
 		<th height="25px" class="blueHeaderNoRoundText">Due Date</th>
 		<th height="25px" class="blueHeaderNoRoundText">Email</th>
 		
 	</tr>
 </thead>	
 		<%= htmlGrid %> 
 		
 </TABLE>
  

<table align="center" width= "100%" >
<tr align="right">
<td width="85%"></td>
<td><input type="button" id="btnedit"  value="Edit" onclick="javascript:editRow('dataTable')"  style = "display:none"/> </td>
<td><input type="button" id="delete"  value="Delete" onclick="deleteData()" style = "display: none"></td> 

</tr>
</table>

  <div class="blueHeaderNoRound">
  	<div class="blueHeaderNoRoundText">Required Documents:</div>	
  </div>  
  
 <table align="center" width= "100%" border="0" CELLSPACING="2" cellpadding="2">
<tr valign=top>
<td width=25%  >

<h4><%=indexType%></h4>  
  <input type=text id="projectNumber" size="25" value="" tabindex="1" onkeypress="return numAndLettersOnly(event)" onblur="javascript:checkWhiteSpaces('projectNumber','Project Number');"/>
 <br></br>
 </td>
 <td width=25% >
<h4>Current Date:</h4>  
 <input type="text" size="25" id="datepicker" tabindex="2"/> 
 <br></br>
 </td>
 <td width=25% >
 <h4>Due Date:</h4>  
 <input type="text" size="25"  id="datepicker1" tabindex="3" /> <!-- <img src="images/calendar.png" alt="" width="25" height="25" /> --> 

</td>
 <td width=25% >
<div id="divDocStatus">
<h4>Responsible Party Emails:</h4>  
<input type="text" size="25" id="email1"  tabindex="4" onblur="javascript:validateEmail('email1')"/><br></br>
<input type="text" size="25" id="email2"  tabindex="5" /><br></br>
<input type="text" size="25" id="email3" tabindex="6" /><br></br>
<input type="text" size="25" id="email4"  tabindex="7" /><br></br>
</div></td>
<!--
<td width=45% rowspan="2" >
<div id="divDocStatus">
<h4>Due Date:</h4>  
 <input type="text" size="15"  id="datepicker1" />
</div></td>


<td width=47% rowspan="2" >
<div id="divDocStatus">
<h4>Document Type</h4>  
  <select style='font-size:11px;font-family: Verdana;' id="doctype" name="doctype" id="doctype"  size="10" multiple="multiple">   
  </select>  
</div></td> -->
</table>


<table align="center" width= "100%" >
<tr align="right">
<td >&nbsp;<input type="button" id="saveandnew" tabindex="8"  name="saveandnew" value="Save & Add New" onClick="javascript:saveForm();" >

<input type="button" name="cancel" id="cancel" value="Cancel" tabindex="9" onClick="javascript:onCancel();"/></td>
</tr>
</table>

<div class="blueHeaderNoRound">
	<div class="blueHeaderNoRoundText">Prior Entries:</div>
</div>

<table align="center" width= "100%" >
	<tr>
		<td width="35%"><h4>Select Year:</h4></td>
		<td width="45%" ><h4>Select Date:</h4></td>
		<td width="40%"></td>
	</tr>
	<tr>
	<td width="35%">
		<select id="selectYear"  onchange="javascript:selectDatesOfYear()"> 
	    <option value="NA" >----   Select Year  ----</option> 
	    
		</select>  
	</td>
	<td width="45%">
		<select name="selectMonth" id="selectMonth"> 
	    <option value="NA">----   Select Date  ----</option> 
	    </select>  
	</td>
	<td width="40%">
		<input type="submit" id="btnView"  value="View" /> 
	</td>
	</tr>
</table>
</form>
<div class="blueHeaderNoRound">
	<div class="blueHeaderNoRoundText">Audit Trail:</div>
</div>

<table align="center" width= "100%" >

<tr>
<td></td>
<td ><h4>Date</h4></td>
<td ><h4>UserId</h4></td>
<td ><h4>Last Name</h4></td>
<td ><h4>First Name</h4></td>
</tr>

<tr>
<td></td>
<td ><p><%= timestamp%></p></td>
<td ><p><%= userName %></p></td>
<td ><p><%= lastName %></p></td>
<td ><p><%= firstName %></p></td>
</tr>
</table>

<script language="javascript">

function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try 
   {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); // For Old Microsoft Browsers
   }
   catch (e) {
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
	//getdropdowns();
	
	setHeader('addRequiredDocs.jsp');
	showButtons('dataTable');
	document.getElementById("delete").disabled=true;
	document.getElementById("btnedit").disabled=true;
	populateYearSelect();
	
}

var index = new Array();
var documentdata = new Array();
var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object
function getdropdowns() 
{
	var compid = '<%= cid %>';
	var queryString = "compid="+compid;	
	if(xmlhttp) 
	{ 
	    xmlhttp.open("POST","GetDropDown",true); 
	    xmlhttp.onreadystatechange  = handleServerResponse;
	    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlhttp.send(queryString);
	} 
}

function handleServerResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	parseData(xmlhttp.responseText);
      }    
     else {
        alert(xmlhttp.status);
     }
   }
}

function parseData(data) 
{
	var row = data.split('$');
	var indexstr = row[0];
	var docstr = row[1];
	var countStr = row[2];
	
	parsedocstr(docstr);	
}
function parsedocstr(docstr) 
{
	var row = docstr.split('|');
	documentdata.length = 0;
	for (var i=0; i<row.length-1; i++) {
	  var col = row[i].split('^');
	  documentdata[i]= new Array(col[0],col[1]);	  
    }
    
    for (var i=0; i < documentdata.length;++i){
    addOption(document.getElementById("doctype"), documentdata[i][0], documentdata[i][1]);
    }
    
}

function addOption(selectbox,text,value )
{
	var optn = document.createElement("OPTION");
	optn.text = text;
	optn.value = value;
	selectbox.options.add(optn);
}

function onCancel(){
	clearSelection();
	//In save mode
	if(document.getElementById("editRowFlag").value  == "true")
	{
		document.getElementById("editRowFlag").value  = "false";
	}
	//Make all checkboxes unchecked
   try 
   {         
	    var table = document.getElementById('dataTable');
	    var mytablebody = table.getElementsByTagName("tbody")[0];    
	    var rowCount = mytablebody.rows.length;
   
	     for(var i=0; i< rowCount; i++) 
	     {
	     	var myrow = mytablebody.getElementsByTagName("tr")[i];
		    var mycel = myrow.getElementsByTagName("td")[0]; 
	      	var chkbox = mycel.getElementsByTagName("input")[0];
	      	var rowNumber = myrow.getElementsByTagName("td")[1].innerHTML; 
	        var id = 'checkbox'+rowNumber;
	           if (null != chkbox && true == document.getElementById(id).checked) 
		       {         	
		       		document.getElementById(id).checked = false;			
			   }		
	     }
     
     }catch(e) {
         alert(e);
     } 	
	document.getElementById("projectNumber").disabled=false;
}


/************************************DELETE***********************************************/
var xmlhttp2 = new getXMLObject();       //xmlhttp holds the ajax object
function deleteData() {
if(confirm("Are you sure you want to delete the entry?"))
{
	var compid = '<%= cid %>';
	var projectId = getRecordInfo('dataTable');
	var mode = "delete";
	
	var queryString2 = "mode=delete&cId="+compid+"&projectId="+projectId;
	
	if(xmlhttp2) { 
	    xmlhttp2.open("POST","AddRequiredDocument",true); 
	    xmlhttp2.onreadystatechange  = handleDeleteResponse;
	    xmlhttp2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlhttp2.send(queryString2);
	  }
 } 
}
function handleDeleteResponse() 
{
	if (xmlhttp2.readyState == 4) 
	{
	     if(xmlhttp2.status == 200) 
	     {
	     	parseDeleteData(xmlhttp2.responseText);
	     }    
	     else {
	        alert(xmlhttp2.status);
	     }
   }
}

function parseDeleteData(data) {
	if(data == "yes")
	{ 	
		deleteRow('dataTable');		
		alert("Project "+document.getElementById("projectNumber").value+" is deleted successfully!");		
	}
	else
	{
		alert("Project "+document.getElementById("projectNumber").value+" can not be deleted.");
	}
	
}
/************************************SAVE***********************************************/
function validateForm()
{	
	//Check if project number field contains value
	if(document.getElementById('projectNumber').value == "" ) 
	{
		alert("Enter Project Number Field.");
		return false;		
	}
	else if(document.getElementById('datepicker').value == "" ) 
	{
		alert("Enter Entry Date Field.");
		return false;		
	}
	else if(document.getElementById('datepicker1').value == "" ) 
	{
		alert("Enter Due Date Field.");
		return false;		
	}
	else if(document.getElementById('email1').value == "" && document.getElementById('email2').value == ""
			&& document.getElementById('email3').value == "" && document.getElementById('email4').value == "" ) 
	{
		alert("Enter Responsible Party Email.");
		return false;		
	}	
	else if(document.getElementById('projectNumber').value != "" ) 
	{
		//Check for repeated entry but exclude this check
		//if it is in edit mode.
		if(document.getElementById('editRowFlag').value === 'false')
		{
			var table = document.getElementById('dataTable');
	        var mytablebody = table.getElementsByTagName("tbody")[0];
	        if(typeof(mytablebody) != 'undefined')
	        {
	          var rowCount = mytablebody.rows.length;         	
	          for(var i=0; i<rowCount; i++) 
	          {
	              var myrow = mytablebody.getElementsByTagName("tr")[i];
				  var projectNumber = myrow.getElementsByTagName("td")[2].innerHTML; 
				  if(document.getElementById('projectNumber').value === projectNumber)  
				  {
					alert("This Entry Already Exists! Please Edit Existing Entry.");
					return false;
				  }             
	     	 }
	     	}
     	}
     				
	}
	
	return true;
	
}
var xmlhttp1 = new getXMLObject();       //xmlhttp holds the ajax object
function saveForm() 
{
	//Make delete disabled
  	document.getElementById("delete").disabled=true;
    //Make edit disabled
  	document.getElementById("btnedit").disabled=true;
  	
	if(validateForm())
	{
		if(document.getElementById("editRowFlag").value  == "true")
		{
			var mode = "edit";	
		}
		else
		{
			var mode = "save";	
		}
		var compid = '<%= cid %>';
		var projectId = document.getElementById("projectNumber").value;
				
		var entryDate = document.getElementById('datepicker').value;
		var dueDate = document.getElementById('datepicker1').value;
		var emails;
		
		if(document.getElementById('email1').value != "")
		    emails = document.getElementById('email1').value + ",";
		if(document.getElementById('email2').value != "")
			emails += document.getElementById('email2').value + ",";
		if(document.getElementById('email3').value != "")
		{
			emails += document.getElementById('email3').value + ",";
		}
		if(document.getElementById('email4').value != "")
			emails += document.getElementById('email4').value;
		
		
		var queryString1 = "mode="+mode+"&cId="+compid+"&projectId="+projectId+
						   "&entryDate="+entryDate+"&dueDate="+dueDate+"&emails="+emails;
		
		if(xmlhttp1) 
		{ 
		    xmlhttp1.open("POST","AddRequiredDocument",true); 
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
     	parseProjectDocumentData(xmlhttp1.responseText);
      }    
     else 
     {
        alert(xmlhttp1.status);
     }
   }
}

function parseProjectDocumentData(data) 
{
	if(data == "yes")
	{ 	
		if(document.getElementById("editRowFlag").value  == "true")
		{
			document.getElementById("editRowFlag").value  = "false";
			alert("Project "+document.getElementById("projectNumber").value+" is edited successfully!");
			addRow('dataTable');
			deleteRow('dataTable');
				
		}
		else
		{
			alert("Project "+document.getElementById("projectNumber").value+" is added successfully!");
			addRow('dataTable');
			//location.reload(); 
		 	clearSelection();
		}
	 	
	}
 else
    {	
		if(document.getElementById("editRowFlag").value  == "true")
		{
			document.getElementById("editRowFlag").value  = "false";
			alert("Project "+document.getElementById("projectNumber").value+" can not be edited.");
		}
		else
		
			alert("Project "+document.getElementById("projectNumber").value+" can not be added.");				
	}
	document.getElementById("projectNumber").disabled=false;
	
}

String.prototype.trim = function () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}
</script>
</body>
</html>

