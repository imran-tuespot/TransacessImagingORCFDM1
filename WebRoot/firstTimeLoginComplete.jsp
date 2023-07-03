<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


 
 

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Transaccess Imaging Registration</title>
<style type="text/css">
@import url( css/transaccessstylesheet.css );
</style>

</head>
<%

javax.naming.Context ctx = 	new javax.naming.InitialContext();
String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");

%>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"
          integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
          crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){

 //alert("localStorage.getItem():"+localStorage.getItem("userName"));
 var setPasswordData={ "username":localStorage.getItem("userName"),
   "code":localStorage.getItem("password") //,
 //  "userSession":localStorage.getItem("userSession")
  }
 //alert(JSON.stringify(setPasswordData));
 
 $.ajax({
       type : "POST",
       contentType : "application/json",
       url:"<%=restURL%>role/resetPassword?username="+sessionStorage.getItem('idOfUserName')+"&code="+sessionStorage.getItem('code'),
       dataType : 'json',
       timeout : 100000,
     //  data : JSON.stringify(setPasswordData),
       success : function(data) {
       console.log("SUCCESS: ", data);
     
      $("#confermationMessage").append(data.message);
        
       },
       error : function(e) {
        console.log("ERROR: ", e);
       // alert("12313122error");
       // displayRights(e);
       },
       done : function(e) {
        console.log("DONE");
       }
      });

 });



</script>

<style type="text/css">

p {
  margin:10px 10px 10px 10px;
  font-family:Arial, Helvetica, sans-serif;
  color:#fff;
  font-size:12px;

  }
  
  .username{
  
  margin:10px 10px 10px 10px;
  font-family:Arial, Helvetica, sans-serif;
  color:#ccc;
  font-size:12px;
  
  }


</style>


<body>

<table width="850" align="center" border="0" cellspacing="0" cellpadding="0">
 <tr>
  <td width="190" valign="middle" style='font-size:10px;font-family: Verdana;color:#706F6F'>
    <img src="css/images/fhalogo.png" alt='TransAccess Imaging - Document Viewer.'/>  </td>
  <td width="660" valign="bottom" >  
  </td>
 </tr>
 <tr>
  <td colspan=2 >
   <hr />
   
  </td>
 </tr>
 <tr>
  <td height="40" colspan=2 valign="top" > 

  <table width="850" border="0" cellpadding="0" cellspacing="0">
    <!--DWLayoutTable-->
    <tr>
   <td width="215" height="22" valign="top"></td>
      <td width="215">&nbsp;
   
   
   
   </td>
    </tr>
  </table>
  
  </td>
 </tr>
    

</table>


<table width="850" border="0" cellpadding="0" cellspacing="0" align="center">
  <!--DWLayoutTable-->
  <tr>
    <td width="60%" height="57" valign="top"  style="font-size: 17px;
    color: green;" id ="confermationMessage"></td>
  </tr>
  <tr>
    <td valign="bottom"><a href="index.jsp">Click Here To Login</a></td>
  </tr>
  
</table>

<jsp:include page="footer.jsp" />

</body>
</html>