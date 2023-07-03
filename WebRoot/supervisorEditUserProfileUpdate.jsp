<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:useBean id="profileUpdate" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="profileUpdate" property="*" />




<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Transaccess Imaging Registration</title>
</head>

<body>
<jsp:include page="WEB-INF/header.jsp" />


<%
	//Take the request and process on the back end
	String verifyMessage = profileUpdate.processProfileUpdate(request);


 %>

<%

	String redirectURL = "supervisorGrid.jsp?sessionid=" + (String)request.getAttribute("sessionid");
    response.sendRedirect(redirectURL);

 %>



<table width="850" border="0" cellpadding="0" cellspacing="0" align="center">
  <!--DWLayoutTable-->
  <tr>
    <td width="587" height="137" valign="top"><%=verifyMessage %></td>
  </tr>
</table>

<jsp:include page="footer.jsp" />

</body>
</html>
