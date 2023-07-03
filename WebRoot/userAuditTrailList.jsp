<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TransAccess Imaging</title>
<%@page import="java.util.*" %>
<%@page import="com.peniel.bus.vo.SessionLog" %>
    <script type="text/javascript" src="js/calendarDateInput.js"></script>

    <jsp:include page="includes/sessionHeader.jsp" />


    <%

        //int uid	= Integer.parseInt(request.getAttribute("userid").toString());
        String sessionid = request.getSession().getAttribute("sessionid").toString();
        int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
        //String userName = request.getAttribute("username").toString();

        String lastName = "";
        String firstName = "";

        HashMap hashMap = userInformation.getUserInformation(request);

        lastName = (String) hashMap.get("lastName");
        if(lastName== null) lastName="";
        firstName = (String) hashMap.get("firstName");
        if(firstName== null) firstName="";

        java.util.Date today = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());

        String startDate = request.getAttribute("startDate").toString();
        String endDate = request.getAttribute("endDate").toString();
    %>


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


<body onLoad="javascript:initialLoad();">

<form name="userAuditTrail" id ="userAuditTrail" method="POST" action="UserAuditTrail">

    <Table>
        <tr>
            <td align="right">Start Date:</td>
            <td align="left"><script>DateInput('startDate', true, 'DD-MON-YYYY', '<%= startDate %>')</script></td>
        </tr>
        <tr>
            <td align="right">End Date:</td>
            <td align="left"><script>DateInput('endDate', true, 'DD-MON-YYYY', '<%= endDate %>')</script></td>
        </tr>
        <tr>
            <td align="right">Type</td>
            <td align="left">
                <select name="type">
                    <option value="1">Updated Records</option>
                    <option value="2">New Records</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="searchButton">
            </td>
        </tr>
    </Table>
<input type="hidden" id ="cid" name="cid" value="<%=cid%>"/>
<input type="hidden" id ="sessionid" name="sessionid" value="<%=sessionid%>"/>
<input type="hidden" id ="confirmParam" name="confirmParam"/>
</form>

<table>
    <tr>
        <td colspan="7" align="center">Results between <%= startDate %> and <%= endDate %></td>
    </tr>
    <tr>
        <th>Date</th>
        <th>Doc Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Field Modified</th>
        <th>Old Value</th>
        <th>New Value</th>
    </tr>
    <%
        Vector sessionLogList = (Vector)request.getAttribute("sessionLogList");

        if(sessionLogList.size()  > 0){

            for(int i=0; i<sessionLogList.size(); i++){

                SessionLog sessionLog = (SessionLog)sessionLogList.get(i);

                String auditTrailDate = (String)sessionLog.getDtm();


                String lastNameVal = sessionLog.getLastName();
                String firstNameVal = sessionLog.getFirstName();
                String fieldModified = sessionLog.getFieldName();
                String oldValue = sessionLog.getOldValue();
                String newValue = sessionLog.getNewValue();
                String modDate = sessionLog.getDtm();
                int docId = sessionLog.getDocId();
    %>
    <tr>
        <td><font size="-2"><%= modDate %></font></td>
        <td align="center"><font size="-2"><%= docId %></font></td>
        <td><font size="-2"><%= firstNameVal %></font></td>
        <td><font size="-2"><%= lastNameVal %></font></td>
        <td><font size="-2"><%= fieldModified %></font></td>
        <td><font size="-2"><%= oldValue %></font></td>
        <td><font size="-2"><%= newValue %></font></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="7">No Results Available</td>
    </tr>
    <%
        }
    %>

</table>
<script language="javascript">

function initialLoad(){
	setHeader("userAuditTrail.jsp");
}
</script>

</form>
</body>

</html>
