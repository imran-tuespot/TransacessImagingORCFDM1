<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery-1.2.2.pack.js"></script>
		<script type="text/javascript" src="js/jquery.bgiframe.pack.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type='text/javascript' src='js/jquery.bgiframe.min.js'></script>
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script type="text/javascript" src="js/FHA.js"></script>
		<title></title>
<% 
	int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  	String sessionid = request.getSession().getAttribute("sessionid").toString();
  	int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
    String appuserrole = (String)request.getSession().getAttribute("appuserrole");

%>
<script type="text/javascript" src="js/jquery-1.3.2.js" ></script>
<script type="text/javascript" src="js/jquery.quickflip.js" ></script>


		
</head>

<jsp:include page="includes/sessionHeader.jsp" />


<body onLoad="initial()">
<div id="flip-tabs" >  
        <ul id="flip-navigation" >  
            <li class="selected"><a href="#" onclick="javascript:changeContent()" id="tab-0"  >User Management</a></li>  
            <li><a href="#" id="tab-1" >Document Management</a></li>  
            <li><a href="#" id="tab-2" >Company Profile</a></li>  
            <li><a href="#" id="tab-3" >Audit Reports</a></li>             
            <li><a href="#" id="tab-4" >Company Profile</a></li>  
            <li><a href="#" id="tab-5" >Document Wizard</a></li>  
            <li><a href="#" id="tab-6" >E-mails</a></li>  
            
        </ul>  
        
        <div id="flip-container" >  
            <div>  
					<div  id="content"> <!--  Content for User Management tab -->
					<table align="center">
							<tr align="center">								
								<td style='font-size:11px;font-family: Verdana;color: green' ><b></b></td>
							</tr>
							<tr>
							  <td>							  
								  <form name="advancedSearch">
								    <p>First Name: 
								      <input type="text" name="fnameSearch" />
								  		&nbsp;&nbsp;&nbsp;&nbsp; Last Name:
								  	  <input type="text" name="lnameSearch" />  
								      <input type="button" class="button" name="searchByName" value="Search" onClick="getAdvancedSearchUsers()" />
								  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								      <input type="button" class="button" name="registration" value="New Users" onClick="location.href='registration.jsp?sessionid=<%=request.getAttribute("sessionid")%>'" >
								      </p>
								  </form>  
							  </td>
							  </tr>
							</table>
						<table align="center">
							<tr>
							  <td >
							  <div id="div_links" style="font-size: 10pt;"></div>
							  </td>
							</tr>
						</table>
														
						<center>
							<div id="results"></div>
						</center>
					<!-- <a href="includes/supervisorGridInclude.jsp?sessionid=<%=sessionid%>&userid=<%=uid %>&comid=<%=cid%>&appuserrole=<%=appuserrole%>">User Management & Access Control</a> - Manage users and their data visibility-->
					</div>
            </div>  
            <div>  
            
                <!--Put Content for second tab here-->  
            </div>  
            <div>  
                <!--Put Content for third tab here-->  
            </div> 
            <div>  
                <!--Put Content for second tab here-->  
            </div>  
            <div>  
                <!--Put Content for third tab here-->  
            </div>  
            <div>  
                <!--Put Content for second tab here-->  
            </div>  
            <div>  
                <!--Put Content for third tab here-->  
            </div>   
        </div>  
    </div> 
<!-- 
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
  
    <td width="50%" height="60" valign="top">
    
		<div class="smallBlueHeaderNoRound"> User Management</div>
	
		<div class="smallSectionText">
		
			<div class="smallSectionTextPadding">
				<a href="supervisorGrid.jsp?sessionid=<%=request.getAttribute("sessionid") %>">User Management & Access Control</a> - Manage users and their data visibility
			</div>
		</div>
	</td>
    <td width="50%" valign="top">
		<div class="smallBlueHeaderNoRound">Document Management</div>
		<div class="smallSectionText">
			<div class="smallSectionTextPadding">
			<a href="addDoc.jsp?sessionid=<%=request.getAttribute("sessionid") %>">Add New Document</a> - Allows the creation of a new document for TransAccess Imaging
			<br><br>
			<a href="addBatch.jsp?sessionid=<%=request.getAttribute("sessionid") %>">Batch Upload</a> - Allows bulk uploads with zip files
			<br><br>
			<a href="docMgmtSearchGrid.jsp?sessionid=<%=request.getAttribute("sessionid") %>">Manage Documents</a> - Manages information pertaining to existing documents, Edit Profile, Remove Document From View, and Replace Existing Document. <br>
			<br><br>
			</div>
		</div>
					
	</td>
  </tr>
  <tr>
    <td height="57" valign="top">
		<div class="smallBlueHeaderNoRound">Company Profile</div>
		<div class="smallSectionText"  style="height:100px">
			<div class="smallSectionTextPadding">
				<a href="companyProfile.jsp?sessionid=<%=request.getAttribute("sessionid") %>">Company Profile</a> - Manage configuration settings pertaining to the company's preferences and best-practices
				
			</div>
		</div>
	 </td>
    <td valign="top">
		<div class="smallBlueHeaderNoRound" >Audit Reports</div>		
		<div class="smallSectionText" style="height:100px">
			<div class="smallSectionTextPadding">
		  		<a href="userAuditTrail.jsp?sessionid=<%=request.getAttribute("sessionid") %>">Audit Reports</a> - Presents an audit report illustrating document modifications, document creation activity.
		  		<br><br>
                <a href="UserAudit?sessionid=<%=request.getAttribute("sessionid") %>">User Report</a> - List of all active users on the platform.
                </div>
		</div>
	</td>
  </tr>
  <tr>
    <td height="46" valign="top">
		<div class="smallBlueHeaderNoRound">Document Wizard</div>
		
		<div class="smallSectionText">
			<div class="smallSectionTextPadding">
				<a href="docDownloadSearchGrid.jsp?sessionid=<%=request.getAttribute("sessionid") %>">Download Document Selector</a> - Allows the download of a select set of documents from TransAccess Imaging
				<br><br>
				<a href="addRequiredDocs.jsp?sessionid=<%=request.getAttribute("sessionid") %>">Add Required Documents</a> - Presents a wizard to add list of required documents.
				<br><br>				
				 Add <a id="id_link" href="newIndexType.jsp?sessionid=<%=request.getAttribute("sessionid")%>">Index</a>   <a href="NewDocType?sessionid=<%=request.getAttribute("sessionid")%>">Document Type</a>
				 <a href="newFolder.jsp?sessionid=<%=request.getAttribute("sessionid")%>">Folder</a>
			</div>
		</div>
	</td>
    
    <td valign="top">
		<div class="smallBlueHeaderNoRound">Send E-Mails</div>
		
		<div class="smallSectionText">
			<div class="smallSectionTextPadding">
				<a href="sendMails.jsp?sessionid=<%=request.getAttribute("sessionid") %>">Send E-Mails</a> - Presents a wizard to send mails to all registered users.		  		  
			</div>
		</div>
	</td>
  </tr>  
 
</table>
-->
<script language=javascript>
function hideLink(id)
{
	var link_ref = document.getElementById(id);
	link_ref.style.display = 'none';
}

function initial() 
{
setHeader('admin.jsp');


	var role = "POWERUSER";
	if ( role === "<%= appuserrole %>") 
	{
		hideLink('id_link');
	}
}
$('document').ready(function(){  
    //initialize quickflip  
    $('#flip-container').quickFlip();  

    $('#flip-navigation li a').each(function(){  
        $(this).click(function(){  
            $('#flip-navigation li').each(function(){  
                $(this).removeClass('selected');  
            });  
            $(this).parent().addClass('selected');  
            //extract index of tab from id of the navigation item  
            var flipid=$(this).attr('id').substr(4);  
            //Flip to that content tab  
            $('#flip-container').quickFlipper({ }, flipid, 1);  

            return false;  
        });  
    });  
});  


function changeContent() {
var sessionId = '<%=request.getAttribute("sessionid") %>';
var userid = '<%=request.getAttribute("userid") %>';
var comid = '<%=request.getAttribute("comid") %>';
var appuserrole = '<%=request.getSession().getAttribute("appuserrole") %>';

getUsers();
  /* $('#content').load('includes/supervisorGridInclude.jsp?sessionid=' + encodeURIComponent(sessionId)
    +'&userid='+encodeURIComponent(userid)
    +'&comid='+encodeURIComponent(comid)
    +'&appuserrole='+encodeURIComponent(appuserrole)    
    );*/
}

</script>

<script language="javascript">
/*Javascript for supervisorGrid-user management */
var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object
var xmlhttp1 = new getXMLObject();       //xmlhttp holds the ajax object

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
getUsers();
addTableFacadeToManager('formId');
	setMaxRowsToLimit('formId','15');
	setPageToLimit('formId','2');

function getUsers() {
getUserLinks();

var compid = '<%= cid %>';

if(xmlhttp) { 
    xmlhttp.open("POST","GetSupervisorGrid",true); 
    xmlhttp.onreadystatechange  = handleResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("companyId=" + compid);
  } 
} 

function getUserLinks() {
if(xmlhttp1) { 

    xmlhttp1.open("POST","GetSupervisorGridLinks",true); 
    xmlhttp1.onreadystatechange  = handleLinkResponse;
    xmlhttp1.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp1.send();
  } 
} 

function handleLinkResponse() {

	
   if (xmlhttp1.readyState == 4 && xmlhttp1.status == 200) {
   		//alert(xmlhttp1.responseText);
		document.getElementById("div_links").innerHTML = xmlhttp1.responseText;
     }    
}


function getAdvancedSearchUsers() {

var compid = '<%= cid %>';
var fname = document.advancedSearch.fnameSearch.value;
var lname = document.advancedSearch.lnameSearch.value;

	if(fname == "" && lname == "")
	{
		alert("Please fill in either a FIRST NAME or a LAST NAME!");
	}
	else
	{
		if(xmlhttp) 
		{ 
		    xmlhttp.open("POST","GetSupervisorGrid",true); 
		    xmlhttp.onreadystatechange  = handleResponse;
		    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xmlhttp.send("companyId=" + compid + "&firstName=" + fname + "&lastName=" + lname);
	 	} 
	}
} 


function getAlphabetSearchUsers(lname) {

var compid = '<%= cid %>';
var fname = '';
//document.advancedSearch.lnameSearch.value = lname;
	if(xmlhttp) 
	{ 

		xmlhttp.open("POST","GetSupervisorGrid",true); 
		xmlhttp.onreadystatechange  = handleResponse;
		xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xmlhttp.send("companyId=" + compid + "&firstName=" + fname + "&lastName=" + lname);
	} 
} 

function setSortValue(sortName,sortValue)
{
		var expires = new Date();
		expires.setMonth(expires.getMonth() + 4);
		setCookie(sortName,sortValue, new Date(expires), '/', '', '');
}

function getSoryValue(property)
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

function sortby(property)
{
	property = " LOWER(" + property + ")";
	var compid = '<%= cid %>';
	var fname = document.advancedSearch.fnameSearch.value;
	var lname = document.advancedSearch.lnameSearch.value;
	var sVal = getSoryValue(property);
	if(sVal == 0)
		property += " ASC";
	else
		property += " DESC";
		
	var order = property;
	var sFilter = "companyId=" + compid + "&firstName=" + fname + "&lastName=" + lname + "&orderby=" + order ;
	//alert(sFilter);
	
	if(xmlhttp) 
	{ 
		xmlhttp.open("POST","GetSupervisorGrid",true); 
		xmlhttp.onreadystatechange  = handleResponse;
		xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xmlhttp.send(sFilter);
	} 

  // alert(property);

}

function handleResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	DisplayData(xmlhttp.responseText);
     }    
     else {
        alert(xmlhttp.status);
     }
   }
}



function editUserProfile(userId)
{
	location.href="supervisorEditUserProfile.jsp?sessionid=<%=sessionid%>&guestUserId=" + userId;
}

function showUserProfile(userId)
{
	location.href="supervisorShowUserProfile.jsp?sessionid=<%=sessionid%>&guestUserId=" + userId;
}

function DisplayData(data)
{
	var initTable = "";
	initTable +="<form name='dynFormNm' id='dynFormId' method='POST' >";
	initTable +=data; 
	initTable +="</form>";
		
	var obj =  document.getElementById("results");
	obj.innerHTML = initTable;
	

}
function onInvokeAction(id,action) {
	
	var compid = '<%= cid %>';
	var parameterString = createParameterStringForLimit(id);
    
    $.get("GetSupervisorGrid?companyId="+ compid + "&" + parameterString, 
    function(data) 
    {

        $("#results").html(data)
 
    });
    
}

function TableFacadeManager() { 
}

TableFacadeManager.tableFacades = new Object();

TableFacadeManager.addTableFacade = function(tableFacade) {
    TableFacadeManager.tableFacades[tableFacade.limit.id] = tableFacade;
}

TableFacadeManager.getTableFacade = function(id) {
    return TableFacadeManager.tableFacades[id];
}

function TableFacade(id) {
    this.limit = new Limit(id);
    this.worksheet = new Worksheet();
}



function Worksheet() {
    this.save;
    this.filter;
}

function Limit(id) {
    this.id = id;
    this.page;
    this.maxRows;
    this.sortSet = new Array();
    this.filterSet = new Array();
    this.exportType;
}



function Sort(position, property, order) {
    this.position = position;
    this.property = property;
    this.order = order;
}

function Filter(property, value) {
    this.property = property;
    this.value = value;
}

Limit.prototype.getId = function() {
    return this.id;
}

Limit.prototype.setId = function(id) {
    this.id = id;
}

Limit.prototype.getPage = function() {
    return this.page;
}

Limit.prototype.setPage = function(page) {
    this.page = page;
}

Limit.prototype.getMaxRows = function() {
    return this.maxRows;
}

Limit.prototype.setMaxRows = function(maxRows) {
    this.maxRows = maxRows;
}

Limit.prototype.getSortSet = function() {
    return this.sortSet;
}

Limit.prototype.addSort = function(sort) {
    this.sortSet[this.sortSet.length] = sort;
}

Limit.prototype.setSortSet = function(sortSet) {
    this.sortSet = sortSet;
}

Limit.prototype.getFilterSet = function() {
    return this.filterSet;
}

Limit.prototype.addFilter = function(filter) {
    this.filterSet[this.filterSet.length] = filter;
}

Limit.prototype.setFilterSet = function(filterSet) {
    this.filterSet = filterSet;
}

Limit.prototype.getExport = function() {
    return this.exportType;
}

Limit.prototype.setExport = function(exportType) {
    this.exportType = exportType;
}

/*other helper methods*/

TableFacade.prototype.createHiddenInputFields = function(form) {
    var limit = this.limit;
    
    var exists = $(form).find(':hidden[@name=' + limit.id + '_p_]').val();
    if (exists) {
        return false;
    }
    
    if (this.worksheet.save) {
        $(form).append('<input type="hidden" name="' + limit.id + '_sw_" value="true"/>');
    }
    
    if (this.worksheet.filter) {
        $(form).append('<input type="hidden" name="' + limit.id + '_fw_" value="true"/>');
    }
    
    /* tip the API off that in the loop of working with the table */
    $(form).append('<input type="hidden" name="' + limit.id + '_tr_" value="true"/>');
    
    /* the current page */
    $(form).append('<input type="hidden" name="' + limit.id + '_p_" value="' + limit.page + '"/>');
    $(form).append('<input type="hidden" name="' + limit.id + '_mr_" value="' + limit.maxRows + '"/>');
    
    /* the sort objects */
    var sortSet = limit.getSortSet();
    $.each(sortSet, function(index, sort) {
        $(form).append('<input type="hidden" name="' + limit.id + '_s_'  + sort.position + '_' + sort.property + '" value="' + sort.order + '"/>');
    });
    
    /* the filter objects */
    var filterSet = limit.getFilterSet();
    $.each(filterSet, function(index, filter) {
        $(form).append('<input type="hidden" name="' + limit.id + '_f_' + filter.property + '" value="' + filter.value + '"/>');
    });
    
    return true;
}

TableFacade.prototype.createParameterString = function() {
    var limit = this.limit;
    
    var url = '';
    
    /* the current page */
    url += limit.id + '_p_=' + limit.page;
    
    /* the max rows */
    url += '&' + limit.id + '_mr_=' + limit.maxRows;
    
    /* the sort objects */
    var sortSet = limit.getSortSet();
    $.each(sortSet, function(index, sort) {
        url += '&' + limit.id + '_s_' + sort.position + '_' + sort.property + '=' + sort.order;
    });
    
    /* the filter objects */
    var filterSet = limit.getFilterSet();
    $.each(filterSet, function(index, filter) {
        url += '&' + limit.id + '_f_' + filter.property + '=' + encodeURIComponent(filter.value);
    });
    
    /* the export */
    if (limit.exportType) {
        url += '&' + limit.id + '_e_=' + limit.exportType;
    }
    
    /* tip the API off that in the loop of working with the table */
    url += '&' + limit.id + '_tr_=true';
    
    if (this.worksheet.save) {
        url += '&' + limit.id + '_sw_=true';
    }
    
    if (this.worksheet.filter) {
        url += '&' + limit.id + '_fw_=true';
    }
    
    return url;
}

/* convenience methods so do not have to manually work with the api */

function addTableFacadeToManager(id) {
    var tableFacade = new TableFacade(id);
    TableFacadeManager.addTableFacade(tableFacade);	
}

function setSaveToWorksheet(id) {
    TableFacadeManager.getTableFacade(id).worksheet.save='true';
}

function setFilterToWorksheet(id) {
    TableFacadeManager.getTableFacade(id).worksheet.filter='true';
    setPageToLimit(id, '1');
}

function setPageToLimit(id, page) {
	TableFacadeManager.getTableFacade(id).limit.setPage(page);
}

function setMaxRowsToLimit(id, maxRows) {
    TableFacadeManager.getTableFacade(id).limit.setMaxRows(maxRows);
    setPageToLimit(id, '1');
}

function addSortToLimit(id, position, property, order) {
    /*First remove the sort if it is set on the limit, 
    and then set the page back to the first one.*/
    removeSortFromLimit(id, property);
    removeAllSortsFromLimit(id);
    setPageToLimit(id, '1');
    
    var limit = TableFacadeManager.getTableFacade(id).limit;
    var sort = new Sort(position, property, order); 
    limit.addSort(sort);
}

function removeSortFromLimit(id, property) {
    var limit = TableFacadeManager.getTableFacade(id).limit;
    var sortSet = limit.getSortSet();
    $.each(sortSet, function(index, sort) {
        if (sort.property == property) {
            sortSet.splice(index, 1);
            return false;
        }
    });
}

function removeAllSortsFromLimit(id) {
    var limit = TableFacadeManager.getTableFacade(id).limit;
    limit.setSortSet(new Array());
    setPageToLimit(id, '1');
}

function getSortFromLimit(id, property) {
    var limit = TableFacadeManager.getTableFacade(id).limit;
    var sortSet = limit.getSortSet();
    $.each(sortSet, function(index, sort) {
        if (sort.property == property) {
            return sort;
        }
    });
}

function addFilterToLimit(id, property, value) {
    /*First remove the filter if it is set on the limit, 
    and then set the page back to the first one.*/
    removeFilterFromLimit(id, property);
    setPageToLimit(id, '1');
    
    var limit = TableFacadeManager.getTableFacade(id).limit;
    var filter = new Filter(property, value); 
    limit.addFilter(filter);
}

function removeFilterFromLimit(id, property) {
    var limit = TableFacadeManager.getTableFacade(id).limit;
    var filterSet = limit.getFilterSet();
    $.each(filterSet, function(index, filter) {
        if (filter.property == property) {
            filterSet.splice(index, 1);
            return false;
        }
    });
}

function removeAllFiltersFromLimit(id) {
    var tableFacade = TableFacadeManager.getTableFacade(id);
    
    var limit = tableFacade.limit;
    limit.setFilterSet(new Array());
    setPageToLimit(id, '1');
    
    var worksheet = tableFacade.worksheet;
    worksheet.filter = null;
}

function getFilterFromLimit(id, property) {
    var limit = TableFacadeManager.getTableFacade(id).limit;
    var filterSet = limit.getFilterSet();
    $.each(filterSet, function(index, filter) {
        if (filter.property == property) {
            return filter;
        }
    });
}

function setExportToLimit(id, exportType) {
    TableFacadeManager.getTableFacade(id).limit.setExport(exportType);
}

function createHiddenInputFieldsForLimit(id) {
    var tableFacade = TableFacadeManager.getTableFacade(id);
    var form = getFormByTableId(id);
    tableFacade.createHiddenInputFields(form);
}

function createHiddenInputFieldsForLimitAndSubmit(id) {
	
    var tableFacade = TableFacadeManager.getTableFacade(id);
    var form = getFormByTableId(id);
    var created = tableFacade.createHiddenInputFields(form);
    if (created) {
    	form.submit();
    }
}

function createParameterStringForLimit(id) {
    var tableFacade = TableFacadeManager.getTableFacade(id);
    return tableFacade.createParameterString();
}

function getFormByTableId(id) {
    var node = document.getElementById(id);
    var found = false;
    while (!found) {
        node = node.parentNode;
        if (node.nodeName == 'FORM') {
            found = true;
            return node;
        }
    }
}

/* Special Effects */

var dynFilter;

function DynFilter(filter, id, property) {
    this.filter = filter;
    this.id = id;
    this.property = property;
}

function createDynFilter(filter, id, property) {
    if (dynFilter) {
        return;
    }
    
    dynFilter = new DynFilter(filter, id, property);
    
    var cell = $(filter);
    var width = cell.width() + 1;
    var originalValue = cell.text();
    
    cell.html('<div id="dynFilterDiv"><input id="dynFilterInput" name="filter" style="width:' + width + 'px" value="' + originalValue + '" /></div>');
    
    var input = $('#dynFilterInput');
    input.focus();
    
    $(input).keypress(function(event) {
        if (event.keyCode == 13) { // press the enter key 
            var changedValue = input.val();
            cell.html(changedValue);
            addFilterToLimit(dynFilter.id, dynFilter.property, changedValue);
            onInvokeAction(dynFilter.id);
            dynFilter = null;
        }
    });
    
    $(input).blur(function() {
        var changedValue = input.val();
        cell.html(changedValue);
        addFilterToLimit(dynFilter.id, dynFilter.property, changedValue);
        dynFilter = null;
    });
}

function createDynDroplistFilter(filter, id, property, options) {
    if (dynFilter) {
        return;
    }

    dynFilter = new DynFilter(filter, id, property);
    
    if ($('#dynFilterDroplistDiv').size() > 0) {
        return; // filter already created
    }
    
    /* The cell that represents the filter. */
    var cell = $(filter);
    
    /* Get the original filter value and width. */
    var originalValue = cell.text();
    var width = cell.width();
    
    /* Need to first get the size of the arrary. */
    var size = 1;
    $.each(options, function() {
        size++;
        if (size > 10) {
            size = 10;
            return false;
        }
    });
    
    /* Create the dynamic select input box. */
    cell.html('<div id="dynFilterDroplistDiv" style="top:17px">');
    
    var html = '<select id="dynFilterDroplist" name="filter" size="' + size + '">';
    html += '<option value=""> </option>';
    $.each(options, function(key, value) {
        if (key == originalValue) {
            html += '<option selected="selected" value="' + key + '">' + value + '</option>';
        } else {
        html += '<option value="' + key + '">' + value + '</option>';
        }
    });
    
    html += '</select>';

    var div = $('#dynFilterDroplistDiv');
    div.html(html);

    var input = $('#dynFilterDroplist');

    /* Resize the column if it is not at least as wide as the column. */    
    var selectWidth = input.width();
    if (selectWidth < width) {
        input.width(width + 5); // always make the droplist overlap some
    }

    input.focus();

    var originalBackgroundColor = cell.css("backgroundColor");
    cell.css({backgroundColor:div.css("backgroundColor")});

    /* Something was selected or the clicked off the droplist. */

    $(input).change(function() {
        var changedValue = $("#dynFilterDroplistDiv option:selected").val();
        cell.text(changedValue);
        addFilterToLimit(dynFilter.id, dynFilter.property, changedValue);
        onInvokeAction(dynFilter.id);
        dynFilter = null;
    });

    $(input).blur(function() {
        var changedValue = $("#dynFilterDroplistDiv option:selected").val();
        cell.text(changedValue);
        $('#dynFilterDroplistDiv').remove();
        cell.css({backgroundColor:originalBackgroundColor});
        dynFilter = null;
    });
}

/* Create a dropshadow for the tables */
function addDropShadow(imagesPath, theme) {
    if (!theme) {
        theme = 'jmesa';
    }
    $('div.' + theme + ' .table')
    .wrap("<div class='wrap0'><div class='wrap1'><div class='wrap2'><div class='dropShadow'></div></div></div></div>")
    .css({'background': 'url(' + imagesPath + 'shadow_back.gif) 100% repeat'});
    
    $('.' + theme + ' div.wrap0').css({'background': 'url(' + imagesPath + 'shadow.gif) right bottom no-repeat', 'float':'left'});
    $('.' + theme + ' div.wrap1').css({'background': 'url(' + imagesPath + 'shadow180.gif) no-repeat'});
    $('.' + theme + ' div.wrap2').css({'background': 'url(' + imagesPath + 'corner_bl.gif) -18px 100% no-repeat'});
    $('.' + theme + ' div.dropShadow').css({'background': 'url(' + imagesPath + 'corner_tr.gif) 100% -18px no-repeat'});
    
    $('div.' + theme).append('<div style="clear:both">&nbsp;</div>');
}

/* Worksheet */

var wsColumn;

function WsColumn(column, id, uniqueProperties, property) {
    this.column = column;
    this.id = id;
    this.uniqueProperties = uniqueProperties;
    this.property = property;
}

function createWsColumn(column, id, uniqueProperties, property) {
    if (wsColumn) {
        return;
    }

    wsColumn = new WsColumn(column, id, uniqueProperties, property);
    
    var cell = $(column);
    var width = cell.width();
    var originalValue = cell.text();
    
    cell.parent().width(width); // set the outer width to avoid dynamic column width changes
    
    cell.html('<div id="wsColumnDiv"><input id="wsColumnInput" maxlength="255" name="column" style="width:' + (width + 1) + 'px" value="' + originalValue + '"/></div>');
    
    var input = $('#wsColumnInput'); 
    input.focus();
    
    $('#wsColumnInput').keypress(function(event) {
        if (event.keyCode == 13) { // press the enter key 
            var changedValue = input.val();
            cell.html(changedValue);
            if (changedValue != originalValue) {
                submitWsColumn(originalValue, changedValue);
            }
            wsColumn = null;
        }
    });
    
    $('#wsColumnInput').blur(function() {
        var changedValue = input.val();
        cell.html(changedValue);
        if (changedValue != originalValue) {
            submitWsColumn(originalValue, changedValue);
        }
        wsColumn = null;
    });
}

function submitWsCheckboxColumn(column, id, uniqueProperties, property) {
    wsColumn = new WsColumn(column, id, uniqueProperties, property);
    
    var checked = column.checked;
    
    var changedValue = 'unchecked';
    if (checked) {
        changedValue = 'checked';
    }
    
    var originalValue = 'unchecked';
    if (!checked) { // the first time the original value is the opposite
        originalValue = 'checked';
    }
    
    submitWsColumn(originalValue, changedValue);
    
    wsColumn = null;
}

function submitWsColumn(originalValue, changedValue) {
    var data = '{ "id" : "' + wsColumn.id + '"';
    
    data += ', "cp_" : "' + wsColumn.property + '"';
    
    var props = wsColumn.uniqueProperties;
    $.each(props, function(key, value) {
        data += ', "up_' + key + '" : "' + value + '"';
    });
    
    data += ', "ov_" : "' + originalValue + '"';
    data += ', "cv_" : "' + changedValue + '"';
    
    data += '}'
    
    $.post('jmesa.wrk?', eval('(' + data + ')'), function(data) {});    
}




</script>

<style type="text/css">
#flip-tabs{  
    width:800px;  
    margin:10px auto; position:relative;  
}  
#flip-navigation{  
    list-style:none;  
    margin: 0px 0px 8px;
    padding: 6px 0px 8px;
    text-align: left;
    width: 800px;
    border-bottom: 4px solid #999;

}  
#flip-navigation li{   
    display:inline;   
}  
#flip-navigation li a{  
    text-decoration:none; padding:10px;   
    margin-right:0px;  
    background:#f9f9f9;  
    color:#333; outline:none;  
    font-family:Arial;font-weight:bold; font-size:9px; text-transform:uppercase;  
}  
#flip-navigation li a:hover{  
    background:#999;   
    color:#f0f0f0;  
}  
#flip-navigation li.selected a{  
    background:#999;  
    color:#f0f0f0;  
}  
#flip-container{    
    width:800px;  
    font-family:Geneva,Arial,Helvetica; font-size:8px;  
}  
#flip-container div{   
   /* background:#fff;  */
}  
</style>



</body>

</html>
