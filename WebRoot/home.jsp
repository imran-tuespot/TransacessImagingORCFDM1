<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.commons.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<%

	String timeout = "";
	if(!StringUtils.isBlank((String)request.getParameter("timeout")))
  	{
  		if("yes".equals((String)request.getParameter("timeout"))){
  			timeout = "Session Timed Out, please log back in to continue";
  		}	
  	}
	  javax.naming.Context ctx = 	new javax.naming.InitialContext();
		String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	
	
%>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TransAccess Imaging</title>
<script src="js/jQuery/jquery-1.8.2.min.js"></script>


 <script type="text/javascript" src="js/jQuery/1.11.3/jquery.min.js" ></script>
<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
<script type="text/javascript" src="js/FHA.js" ></script>	
<script type="text/javascript" src="js/jQuery/jquery.qtip.min.js" ></script>		
<link rel="stylesheet" type="text/css" href="css/jquery.qtip.min.css" />


<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />

	

<link rel="stylesheet" type="text/css" href="css/styleSheet.css" />
<link rel="stylesheet" type="text/css" href="css/app.css" />
<link rel="stylesheet" href="css/material-design-iconic-font.css">   

<!-- <script
	src="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"></script>
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/dataTables.buttons.min.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.flash.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.html5.min.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.print.min.js"></script> 
   -->
   <script type="text/javascript">
       window.history.forward();
        function noBack() {
            window.history.forward();
        }
        history.pushState(null, null, location.href);
        window.onpopstate = function () {
            history.go(1);
        }; 
      
      /*  $(document).ready(function() {
           window.history.pushState(null, "", window.location.href);        
           window.onpopstate = function() {
               window.history.pushState(null, "", window.location.href);
           };
       }); */
    </script> 
     
 
 </head>

<body onLoad="initial()"  onpageshow="if (event.persisted) noBack();" onunload="">



<div class="headPageContainer">
<div id="ghUtilBar" class="">
<div id="ghMainUtil">
<div id="ghClientSegment"></div></div></div>

		<table width="930" height="44" border="0" cellpadding="0" cellspacing="0">
		  <!--DWLayoutTable-->
		  <tr>
			<td  style="padding-left: 10px"><img src="css/images/fhalogo.png " alt='TransAccess Imaging - Document Viewer.' width="156" height="80" style="margin-left:-10px;"/></td>
			<td  rowspan="3" style="width:100%;color:#0A68B4">
			<div class="" style="font-size:32px;margin-left:35px;text-align:right;">
			 RMS Help Desk
			<div style="font-size:13px;margin-left:2%;text-align:right;" class="text-center">Powered by TransAccess (PSL)</div>
			 </div>
			</td>
			<td width="500" style="padding-right: 10px" valign="bottom"><div align="right">
<!-- 			 <img src="images/imaging2.jpg" alt="Imaging" width="133" height="53">
 -->			</div></td>
		  </tr>
		</table>

  
 <img src="images/homePageImage.jpg" alt="Working" width="930" height="150"></div>

<div class="blueHeading">
 <!-- <div width="530" align="center">
<br>
Greetings Multifamily TransAccess Users, October 18th, HUD will send a short 13-Question survey to your email. Please take a moment to give us your thoughts &amp; feedback. From PSL, Your Feedback has been amazing, <br>thank you for your time and have a great rest of your day!

<br>
<br></div>  -->
	<div align="center">Existing User Login </div>
	<!-- <div align="center" style="color:red">Training Site </div>  -->
</div>





<div class="mainContentAreaContainer" style="    padding-bottom: 0; ">
<div class="card" style="width:50%;margin-left: 25%;    margin-bottom: 8px;">
<div class="card-body card-padding" style="padding-bottom: 0px;background-color: #FDFDFE;border-radius: 2px;box-shadow: 0px 1px 4px 0px #777;">
  <form name="getfile" id="getfile" onKeyPress="">
				<div>
					 <div class="rowSetting" style="padding-bottom: 1px;border-bottom: 2px solid #F90;">
						 <div class="fg-line">
						 <div style="float: left;">
						  <i class="zmdi_large zmdi-lock-outline" style="color:green;padding-left:0px;"></i><h3 class="pageHeader" style="display:inline"> Sign In </h3> 
							
						 </div>
							 <div style="    text-align: right;">
							 <img onclick="myFunctionvideo()" src="images/VIDIMG1.jpg" title="Tutorial: Signing-In with Multifactor Authentication" style="margin-right: 25px;cursor: pointer;" >
							<br><span style="color:#009cd1"><b>Login Instructions</b></span> 
							 </div>
						 </div>
					 </div>
						<div class="rowSetting" style="padding-top: 20px;">			
								
							<div class="fg-line">
                                   <input id="username" name="username"  class="form-control input-lg" style="background-color:#FDFDFE" placeholder="User Name *" type="text" onfocus="javascript:addClass();" onblur="">
                             </div>
							
						</div>

						<div class="rowSetting">						
								
								<div class="fg-line">
                                </div>							
						</div>
						<div style="height: 19px;"></div>
						<div class="rowSetting">								
								<div class="checkbox m-b-15">
	                                <label>
	                                    <input id="remember" name="remember" type="checkbox" checked="">
	                                    <i class="input-helper"></i>
	                                   Remember my login ID
	                                </label>
                            	</div>
								</div>
							
						</div>

					   
						<div class="rowSetting">
						
						<br>
						<table class="table" width="400">
						<tbody><tr>
						<td width="30%">
						</h4></td>
					
						<td width="35%">
						
						</td>
						</tr>
						</tbody></table>
								
							
							
								
						<br><br>	
				   </div>

			</form>
</div></div>
<div style="    text-align: center;">
 <a href="http://www.TransAccessGCR.com/">
<img src="images/LOGO_GC Combo4.png" alt="Peniel Solutions, LLC" width="330" height="">
</a> 
<!--  <img src="images/LOGO_GC Combo3.png" alt="Peniel Solutions, LLC" width="267" height=""> -->
</div>
</div>




<div class="footer" style="padding: 0; "> 

	<div class="footerPadding">
	<p style="font-size:0.9em;">This computer system, including all related equipment, networks, and network devices (specifically including Internet access) contains data belonging to the U.S. Government, and is provided for authorized U.S. Government use only. Access requires the use of one or more Multi-factor Authentication methods, which ties the account to an authorized user, validated by either account number and password or PIV ID card and PIN that must never be shared with anyone at any time. Doing so increases the risk of access by an unauthorized person posing as you. Authorized personnel will treat information about HUD computing resources (i.e., system names, technologies employed, etc.) as sensitive and will not reveal it to unauthorized personnel. This computer may be monitored for all lawful purposes, including ensuring that its use is authorized, to facilitate protection against unauthorized access, and to verify operational security. During monitoring, information may be examined, recorded, copied and used for authorized purposes. All activities and information, including personal information, associated with the use of this system may be monitored. Use of this computer system, authorized or unauthorized, constitutes consent to monitoring. Misuse or unauthorized use may subject you to criminal prosecution. Evidence of unauthorized use collected during monitoring may be used for administrative, criminal, or other adverse action. Use of this system implies understanding of these terms and conditions. Authority: U.S. Federal Criminal Code (18 USC 1030. Fraud and Related Activity with Computers) and HUD Information Technology Security Policy 2400.25.</p>	    
	    
	<p>&nbsp;</p>
	
	</div>

</div>





</body>

</html>
