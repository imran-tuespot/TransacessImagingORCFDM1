<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

		<title></title>
<% String appuserrole = (String)request.getSession().getAttribute("appuserrole");
   System.out.println("appuserrole "+appuserrole);
   
%>
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

/*function displayPlsReview(sessionid, mode){
	var url = "DisplayPlsReview?sessionid="+sessionid+"&mode="+mode;
	window.open(url,'','width=900,height=450,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
}*/

</script>
		
</head>

<jsp:include page="includes/sessionHeader.jsp" />


<body onLoad="initial()">


<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
  <!--DWLayoutTable-->
  <tr>
  
    <td width="50%" height="60" valign="top">
    
		<div class="smallBlueHeaderNoRound"> User Management</div>
	
		<div class="smallSectionText" style="height:130px">
		
			<div class="smallSectionTextPadding">
				<a href="supervisorGrid.jsp">User Management & Access Control</a> - Manage users and their data visibility
			</div>
		</div>
	</td>
    <td width="50%" valign="top">
		<div class="smallBlueHeaderNoRound">Document Management</div>
		<div class="smallSectionText" style="height:130px">
			<div class="smallSectionTextPadding">
			<a href="addDoc.jsp">Add New Document</a> - Allows the creation of a new document for TransAccess Imaging
			<!-- <br><br>
			<a href="addBatch.jsp?sessionid=<%//=request.getAttribute("sessionid") %>">Batch Upload</a> - Allows bulk uploads with zip files-->
			<br><br>
			<a href="docMgmtSearchGrid.jsp">Manage Documents</a> - Manages information pertaining to existing documents, Edit Profile, Remove Document From View, and Replace Existing Document. <br>
			<br><br>
			</div>
		</div>
					
	</td>
  </tr>
  <tr>
    <td height="57" valign="top">
		<div class="smallBlueHeaderNoRound">Company Profile</div>
		<div class="smallSectionText"  style="height:180px">
			<div class="smallSectionTextPadding">
				<a href="companyProfile.jsp">Company Profile</a> - Manage configuration settings pertaining to the company's preferences and best-practices
				
			</div>
		</div>
	 </td>
    <td valign="top">
		<div class="smallBlueHeaderNoRound" >Audit Reports</div>		
		<div class="smallSectionText" style="height:180px">
			<div class="smallSectionTextPadding">
		  		<a href="userAuditTrail.jsp">Audit Reports</a> - Presents an audit report illustrating document modifications, document creation activity.
		  		<br><br>
                <a href="UserAudit">User Report</a> - List of all active users on the platform.
                <br><br>
                <a href="./PropertyReport?type=basicExport&maxRows=15">List all properties</a> - List of all active properties for this company.
                <br><br>
                <a href="propertyDocExport.jsp">List documents for property</a> - List of all documents for a property.
                <br><br>

                </div>
		</div>
	</td>
  </tr>
  <tr>
    <td height="46" valign="top">
		<div class="smallBlueHeaderNoRound">Document Wizard</div>
		
		<div class="smallSectionText" style="height:130px">
			<div class="smallSectionTextPadding">
				<a href="docDownloadSearchGrid.jsp">Download Document Selector</a> - Allows the download of a select set of documents from TransAccess Imaging
				<br><br>
				
			</div>
		</div>
	</td>
    
    <!-- td valign="top">
		<div class="smallBlueHeaderNoRound">Send E-Mails</div>
		
		<div class="smallSectionText">
			<div class="smallSectionTextPadding">
				<a href="sendMails.jsp?sessionid=<%//=request.getAttribute("sessionid") %>">Send E-Mails</a> - Presents a wizard to send mails to all registered users.		  		  
			</div>
		</div>
	</td-->
	
	<td valign="top">
		<div class="smallBlueHeaderNoRound">Administrator Wizard</div>
		
		<div class="smallSectionText" style="height:130px">
			<div class="smallSectionTextPadding">
				<a href="addProperty.jsp">Add Property</a> - Presents a wizard to add list of required properties.
				<br><br>				
				 Add <a id="id_link" href="newIndexType.jsp">Index</a>   <a href="NewDocType">Document Type</a>
				 <a href="newFolder.jsp">Folder</a> <a href="inactiveFHANumbers.jsp">Inactive Project Numbers</a>
			</div>
		</div>
	</td>
  </tr>
  </tr>  
 <!-- <tr>
    <td height="46" valign="top">
		<div class="smallBlueHeaderNoRound">Document Download Wizard</div>

		<div class="smallSectionText">
			<div class="smallSectionTextPadding">
				<a href="docDownloadSearchGrid.jsp?sessionid=<%//=request.getAttribute("sessionid") %>">Download Document Selector</a> - Allows the download of a select set of documents from TransAccess Imaging
			</div>
		</div>
	</td>

  </tr>-->
</table>





</body>

</html>
