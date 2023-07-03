<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.peniel.beans.SessionBean"%>
<%@page import="org.apache.commons.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

   
<head>
<script type="text/javascript" src="js/jQuery/1.11.3/jquery.min.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Transaccess Imaging Logout</title>
 <script type="text/javascript">
 
 $(document).ready(function() {
		sessionStorage.removeItem("token");
		sessionStorage.removeItem("roles");
	sessionStorage.removeItem("username");
	window.location="index.jsp";
	 window.history.forward();
     function noBack() {
     	
         window.history.forward();
     }
     history.pushState(null, null, location.href);
     window.onpopstate = function () {
         history.go(1);
     };
 }); 
/*  $(document).ready(function() {
     window.history.pushState(null, "", window.location.href);        
     window.onpopstate = function() {
         window.history.pushState(null, "", window.location.href);
     };
 }); */
        
    </script>
</head>

<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">


</body>
</html>
