<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation"/>
<jsp:setProperty name="userInformation" property="*"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>TransAccess Imaging</title>
    <%@page import="java.util.*" %>
    <%@page import="com.peniel.bus.vo.SessionLog" %>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%@ page import="com.peniel.bus.vo.AppUser" %>
    <link rel="stylesheet" href="css/bubble-tooltip.css" media="screen"/>
    <link rel="stylesheet" type="text/css" href="css/jmesa.css" />

    <script type="text/javascript" src="js/calendarDateInput.js"></script>
    <script type="text/javascript" src="js/bubble-tooltip.js"></script>
    <script type="text/javascript" src="js/jmesa.js"></script>
    <script type="text/javascript" src="js/jquery-1.2.2.pack.js"></script>

</head>

<%
    Calendar calendar = GregorianCalendar.getInstance();
    calendar.add(Calendar.MONTH, -1);
    calendar.set(Calendar.DAY_OF_MONTH,
            calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
    Date beginingDt = calendar.getTime();
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

    String beginDate = date_format.format(beginingDt);

    Object appUserVectorObj = request.getParameter("appUserVector");
    Vector<AppUser> userVector;
    if (appUserVectorObj instanceof Vector) {
        userVector = (Vector<AppUser>)appUserVectorObj;
    } else {
        userVector = new Vector<AppUser>();
    }

%>

<body onLoad="javascript:doNothing();">

<script language="javascript">

    function initialLoad() {
        setHeader("userAuditTrail.jsp");
    }
</script>

<form action="javascript:onsubmitform();">
    <Table>
        <tr>
            <td align="right">Start Date:</td>
            <td align="left">
                <script>DateInput('startDate', true, 'DD-MON-YYYY')</script>
            </td>
        </tr>
        <tr>
            <td align="right">End Date:</td>
            <td align="left">
                <script>DateInput('endDate', true, 'DD-MON-YYYY')</script>
            </td>
        </tr>
        <tr>
            <td align="right">Type</td>
            <td align="left">
                <select name="type" id="type">
                    <option value="1">Updated Records</option>
                    <option value="2">New Records</option>
                </select>
            </td>
        </tr>
        <%

        %>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" onClick="javascript:getfiles()" name="searchButton" id="searchButton" value="Search Audit Records">
            </td>
        </tr>
    </Table>
</form>

<table>
    <tr>
        <td>Name</td>
        <td>user Name</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <%
        for (AppUser appUser : userVector) {
    %>
    <tr>
        <td><%= appUser.getLastName() %>, <%= appUser.getFirstName() %></td>
        <td><%= appUser.getUsername() %></td>
        <td><%= appUser.getRole() %></td>
        <td><%= appUser.getStatus() %></td>
    </tr>
    <%
        }

    %>
</table>


</body>

</html>
