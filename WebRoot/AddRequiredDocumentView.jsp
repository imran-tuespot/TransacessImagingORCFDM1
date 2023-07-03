<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />
<jsp:useBean id="projectDocumentBean" scope="request" class="com.peniel.beans.ProjectDocumentBean" />
<jsp:useBean id="companyInformation" scope="request" class="com.peniel.beans.CompanyInformation" />
<jsp:useBean id="indexTypeBean" scope="request" class="com.peniel.beans.IndexTypeBean" />

<%@page import="java.util.*"%>
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
  System.out.println("Inside view");
  String dateRange = request.getParameter("selectMonth");
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  System.out.println("dateRange date "+dateRange);
  
  String beginDate[] = dateRange.split(" To ");
  
  System.out.println("Begin date "+beginDate[0]);
  System.out.println("End date "+beginDate[1]);
  String htmlGrid = projectDocumentBean.getProjectDocumentHTML(cid,beginDate[0],beginDate[1]);
  HashMap companyHashMap = companyInformation.getcompanyInformation(request.getSession().getAttribute("comid").toString());
  String indexType = indexTypeBean.getIndexType(companyHashMap.get("defaultIndex").toString(),
  												request.getSession().getAttribute("comid").toString());
   
%>

<SCRIPT language="javascript">
function populateYearSelect() 
{ 
    d = new Date(); 
    curr_year = d.getFullYear(); 
    var i =0;
    while(curr_year-i >= 2009) 
    { 
        document.getElementById('selectYear').options[i+1] = new Option(curr_year-i,curr_year-i); 
        i++;
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


function checkWhiteSpaces(id,caption)
{
   	if(document.getElementById(id).value.indexOf(" ") > -1)
	{
		alert(""+caption+" can not contain spaces");
		document.getElementById(id).focus();
	}			
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

    </SCRIPT>
</head>


<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>

<jsp:include page="includes/sessionHeader.jsp" />


<body onLoad="initial_load()" >

<form name="upload" method="post" action="AddRequiredDocumentView.jsp">
<input type="hidden" id="editRowFlag" value="false" />
<div style="font-size:11px;font-family: Verdana;"></div>
  <TABLE align="center" width= "100%" border="0" id="dataTable">
    <thead><tr class="blueHeaderNoRound">
  		<th height="25px"></th>
  		<th height="25px" class="blueHeaderNoRoundText">No.</th>
 		<th height="25px" class="blueHeaderNoRoundText"><%=indexType%></th>
 		<th height="25px" class="blueHeaderNoRoundText">Entry Date</th>
 		<th height="25px" class="blueHeaderNoRoundText">Due Date</th>
 		<th height="25px" class="blueHeaderNoRoundText">Email</th>
 		
 </tr></thead>	
 		<%=htmlGrid %> 		
 </TABLE>
  
<div class="blueHeaderNoRound">
	<div class="blueHeaderNoRoundText">Prior Entries:</div>
</div>

<table align="center" width= "100%" >
	<tr>
		<td><h4>Select Year:</h4></td>
		<td ><h4>Select Date:</h4></td>
	</tr>
	<tr>
	<td>
		<select id="selectYear" onchange="javascript:selectDatesOfYear()"> 
	    <option value="NA">----   Select Year  ----</option> 
	    
		</select>  
		</td>
		<td>
		<select name="selectMonth" id="selectMonth" > 
	    <option value="NA">----   Select Date  ----</option> 
	    </select>  
		</td>
		<td>
		<input type="submit" id="btnView" value="View" onclick=""/> 
		</td>
	</tr>
</table>
</form>

<script language="javascript">

function initial_load() {
	setHeader('AddRequiredDocumentView.jsp');
	populateYearSelect();
	
}

</script>
</body>
</html>

