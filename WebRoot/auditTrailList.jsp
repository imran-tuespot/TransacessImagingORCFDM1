<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TransAccess Imaging</title>
<%@page import="java.util.*" %>	
<%@page import="com.peniel.bus.vo.SessionLog" %>
	

<style type="text/css">

		body {
		font: 70.5% 'Lucida Grande', Verdana, Arial, Sans-Serif;
		color: #444;
		text-align: left;
		margin: 0 0 6px;
	
		}


		p {
		margin:10px 10px 10px 10px;
		font-family:Arial, Helvetica, sans-serif;
		color:#fff;
		font-size:12px;

		}
		
		.totalCount{
		
		margin:10px 10px 10px 10px;
		font-family:Arial, Helvetica, sans-serif;
		color:#ccc;
		font-size:12px;
		
		}
		
		.label{
		font-family:Verdana;
		font-size:15px;
		color:black;
		
		}


</style>
				
</head>

<jsp:include page="includes/sessionHeader.jsp" />


<body onLoad="javascript:initialLoad();">

<form name="auditTrail" id ="auditTrail" method="POST" action="">



<table align="center" width= "843" >
	<tr>
	<td>
	<div style="overflow:auto; width:842px; height: 400px;"> 
		<table align="center" width= "841" >
		<tr>
		<td>
		</td>
		<td colspan='7' style='font-size:12px;font-family: Verdana;color: #5F0000'><b>Audit Trail:</b>
		<br>
		<hr />
		</td>
		<td>
		</td>
		</tr>
		
		<tr>
		<td>
		</td>
		<td style='font-size:12px;font-family: Verdana;'><b>Date</b></td>
		<td style='font-size:12px;font-family: Verdana;'><b>Last Name</b></td>
		<td style='font-size:12px;font-family: Verdana;'><b>First Name</b></td>
		<td style='font-size:12px;font-family: Verdana;'><b>Field Modified</b></td>
		<td style='font-size:12px;font-family: Verdana;'><b>Old Value</b></td>
		<td style='font-size:12px;font-family: Verdana;'><b>New Value</b></td>
		<td>
		</td>
		</tr>
		
		<tr>
		<td>
		</td>
		<td colspan=7><hr></td>
		
		<td>
		</td>
		</tr>
		
		<%
		Vector sessionLogList = new Vector();
		sessionLogList = (Vector)request.getAttribute("sessionLogList");
		
		if(sessionLogList.size()  > 0){

			for(int i=0; i<sessionLogList.size(); i++){
		
				SessionLog sessionLog = (SessionLog)sessionLogList.get(i);
				
				String auditTrailDate = (String)sessionLog.getDtm();
				
								
				String lastName = (String) sessionLog.getLastName();
				String firstName = (String) sessionLog.getFirstName();
				String fieldModified = (String)sessionLog.getFieldName();
				String oldValue = (String)sessionLog.getOldValue();
				String newValue = (String) sessionLog.getNewValue();
		
		%>
				<tr>
				<td>
				</td>
				<%if(auditTrailDate == null) auditTrailDate=""; %>
				<td style='font-size:12px;font-family: Verdana;'><%=auditTrailDate %></td>
				
				<%if(lastName == null || "null".equals(lastName)) lastName=""; %>
				<td style='font-size:12px;font-family: Verdana;'><%=lastName %></td>
				
				<%if(firstName == null || "null".equals(firstName)) firstName=""; %>
				<td style='font-size:12px;font-family: Verdana;'><%=firstName %></td>
				
				<%if(fieldModified == null) fieldModified=""; %>
				<td style='font-size:12px;font-family: Verdana;'><%=fieldModified %></td>
				
				<%if(oldValue == null) oldValue=""; %>
				<td style='font-size:12px;font-family: Verdana;'><%=oldValue %></td>
				
				<%if(newValue == null) newValue=""; %>
				<td style='font-size:12px;font-family: Verdana;'><%=newValue %></td>
				
				<td>
				</td>
				</tr>
				
				<tr>
				<td>
				</td>
				<td colspan=7><hr></td>
				
				<td>
				</td>
				</tr>
		<%	}
		 }else{
		%>	
			<tr align=center>
			<td colspan= 8>No more data available for Audit Trail.
			</td>
			</tr>
		<%} %>
			
		</table>
	</div>
	</td>
  </tr>
</table>  		

<script language="javascript">

function initialLoad(){
	setHeader("auditTrailList.jsp");
}
</script>




</form>
</body>

</html>
