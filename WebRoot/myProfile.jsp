<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html>
	<head>
	<%javax.naming.Context ctx = 	new javax.naming.InitialContext();
String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
String URL = (String) ctx.lookup("java:comp/env/URL"); %>


	
		<title> My Profile</title>
		<meta name="pageHeading" content='Imaging Registration' />
		
		<script type="text/javascript" src="js/jquery-1.2.6.min.js"></script>		
		<script type="text/javascript" src="js/animatedcollapse.js"></script>
		<script type="text/javascript">

animatedcollapse.addDiv('auditTrail', 'fade=1,height=800px')

animatedcollapse.ontoggle=function($, divobj, state){ //fires each time a DIV is expanded/contracted
	//$: Access to jQuery
	//divobj: DOM reference to DIV being expanded/ collapsed. Use "divobj.id" to get its ID
	//state: "block" or "none", depending on state
}

animatedcollapse.init();

function setUserValues(){
	var user_id =JSON.parse(sessionStorage.getItem("roles")).user_id;
$('#userid').val(JSON.parse(sessionStorage.getItem("roles")).user_id);
$('#comId').val(JSON.parse(sessionStorage.getItem("roles")).company_ID);
getUserDeatails(user_id);
	}
	
function getUserDeatails(user_id){
	var token=sessionStorage.getItem("token");
	
	 $.ajax({
         type: "POST",
         url:"<%=restURL%>role/myProfile?userid="+user_id,
         dataType: "json",
         headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
         success: function (data) {
        			
        	 $('#email').val(data.email);
        	 $('#username').val(data.username);
        	 $('#address1').val(data.address1);
        	 $('#address2').val(data.address2);
        	 $('#city').val(data.city);
        	 $('#first_name').val(data.first_NAME);
        	 $('#last_name').val(data.last_NAME);
        	
        	
        	 
        	// $('#ticketTitle').val(data.otp);
        	 $('#state').val(data.state);
        	 $('#zip').val(data.zip);
        	// $('#ticketTitle').val(data.status);
            
            
             } 
       });
}
</script>

	</head>
	<body  onload="setUserValues()">
	
	
	<%-- <% 
		
		HashMap hashMap = userInformation.getUserInformation(request);
				
		String successMsg = "";
		successMsg = request.getParameter("successMsg");
		if("".equals(successMsg) || successMsg == null){
				successMsg = "";
		}
		
		String noChangeMsg = "";
		
		String htmlAuditTrail = userInformation.getUserAuditTrail(hashMap.get("userId").toString());
	%> --%>
	
	



	<script type="text/javascript">
	function checkForNull()
	{
	    alert("Inside");
		/*setHeader("myProfile.jsp");
		alert("IN");
		var counter = document.registrationForm.elements.length;
		
		for(var i = 0;i < counter;i++)
		{
			if(document.registrationForm.elements[i].value == "null")
			{
				alert(document.registrationForm.elements[i].value);
				document.registrationForm.elements[i].value = "";
			
			}
		}*/
	}
	
	function LettersOnly(evt) 
{
      var textBoxObj = document.getElementById('first_name');
       evt = (evt) ? evt : event;
       var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
          ((evt.which) ? evt.which : 0));
       if (charCode != 39 &&(charCode > 32 && (charCode < 65 || charCode > 90) &&
          (charCode < 97 || charCode > 122)))              // Letters Only
                
       {       	 
         	alert("Please enter letters only.");
         	return false;         
          
       }
       
       if (textBoxObj.value.length > 39) 
       {          
        	var val = textBoxObj.value.substring(0,40);  
       		textBoxObj.value = "";
       		textBoxObj.value = val;
       		alert("First Name can not exceed 40 characters"); 
       		
       } 
       
       return true;
     }
function validateEmail(email) 
{  
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))  
	  {  
	    return (true); 
	  } 
   
    return (false);

}

function validateZip(zip)
{
	if( /(^\d{5}$)|(^\d{5}-\d{4}$)/.test(zip))
	{
		return true;
	}
	return false;
}

function validatePhone(phone)  
{  

	if( /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(phone))
	{
		return true;
	}
	return false;
 
}  


function validate_form()
{
   
    if ( document.registrationForm.first_name.value == "" )
    {
        alert ( "Please fill in the FIRST NAME field." );
        return false;
    }
    else if ( document.registrationForm.last_name.value == "" )
    {
        alert ( "Please fill in the LAST NAME field." );
        return false;
    }
    else if ( document.registrationForm.email.value == "" )
    {
        alert ( "Please fill in the EMAIL field." );
        return false;
    }
     if(!validateEmail(document.getElementById('email').value)) 
	{  
  		alert("Not a valid e-mail address");
 		return false;
	}
	 if(document.getElementById('zip').value != "" &&!validateZip(document.getElementById('zip').value)) 
	{  
  		alert("Not a valid zip code");
 		return false;
	}
	 if(document.getElementById('phone_no').value !="" && !validatePhone(document.getElementById('phone_no').value)) 
	{  
  		alert("Not a valid phone number. Please enter phone number in XXX-XXX-XXXX format");
 		return false;
	}
	 if(document.getElementById('cellPhone').value != "" && !validatePhone(document.getElementById('cellPhone').value)) 
	{  
  		alert("Not a valid phone number. Please enter phone number in XXX-XXX-XXXX format");
 		return false;
	}
    if(document.getElementById('secondEmail').value != "" && !validateEmail(document.getElementById('secondEmail').value)) 
	{  
  		alert("Not a valid alternate email.");
 		return false;
	}
    
    var valueChange = 'no';
    
   <%--  if(document.getElementById('username').value != '<%=hashMap.get("username")%>'){
    	valueChange = 'yes';
    }
    
    if(document.getElementById('email').value != '<%=hashMap.get("email")%>'){
    	  		
		if(!validateEmail(document.getElementById('email').value)) 
		{  
   			alert("Not a valid e-mail address");
  			return false;
		}else
		{
			valueChange = 'yes';
		} --%>	
  		
    }
  
   
    
   
    
    
    if(valueChange == 'no'){
    	document.getElementById('noChangeMsg').style.display = 'block';    
    } else 
    {
	   	document.registrationForm.last_name.value = document.registrationForm.last_name.value.replace(/'/g, "''");
		document.registrationForm.first_name.value = document.registrationForm.first_name.value.replace(/'/g, "''");
		document.registrationForm.city.value = document.registrationForm.city.value.replace(/'/g, "''");
		document.registrationForm.address1.value = document.registrationForm.address1.value.replace(/'/g, "''");
		document.registrationForm.address2.value = document.registrationForm.address2.value.replace(/'/g, "''");
		document.registrationForm.jobTitle.value = document.registrationForm.jobTitle.value.replace(/'/g, "''");
		
	    document.registrationForm.submit();
    }	

}


</script>
	
	
	
	
		
	<br />
	<%-- 	<b><%=successMsg %> --%>
		<div id ="noChangeMsg" style ='display:none;' >
			No Changes Occurred.
		</div>

		</b>
	
	

		<form name="registrationForm" method="post" action="./MyProfile"  >
		
		<div class="blueHeaderNoRound">
			<div class="blueHeaderNoRoundText">Account information</div>
		</div>

		<br />
		<table width="100%" border="0" align="center">
				<tr>
				  <td  ><div class="requiredStar">* Required</div></td>
				  <td align="left">&nbsp;</td>
				  <td  >&nbsp;</td>
				  <td align="left">&nbsp;</td>
		  </tr>
				<tr>
				<td width="115"  ><p>User Name <span class="requiredStar">*</span></p></td>
				
				<td width="323" align="left">
					
					<input size="30" style="color:gray" type="text" id="username" name="username" maxlength="25"  readonly="readonly"/>                  </td>
                  <td width="119"  ><p>User Login ID <span class="requiredStar">*</span></p></td>
				  <td width="325" align="left">
					<input size="30" type="text" style="color:gray" id="username" name="username" maxlength="25"  readonly="readonly"/>                  </td>
          </tr>
                  <tr>  
                    
                      
					<td ><p>Email <span class="requiredStar">*</span></p></td><td align="left">
					<input type="text" id="email" name="email" size="30" maxlength="100"  tabindex="1"/>
                      </td>
                    <td ><p>Role</p></td>				
				<td align="left">
					<select disabled="disabled" id="userRole" name="userRole">
                      
                    </select>					</td>
                  </tr>
                  
                  
                  
				<tr>
					<td >
						<p>First Name <span class="requiredStar">*</span></p></td>
						<td align="left">
						<input type="text" size="30" id="first_name" name="first_name" maxlength="25"  tabindex="3"  onkeypress="return LettersOnly(event)"/>				  </td>
					<td >							
						<p>Last Name <span class="requiredStar">*</span></p></td>
						<td align="left">
						<input type="text" size="30" id="last_name" name="last_name" maxlength="25"  tabindex="5" onkeypress="return LettersOnly(event)"/>				  </td>
				</tr>

			<tr>
					<td >
					  <p>Status</p></td>
					<td align="left">
				  	<input type="text" style="color:gray" size="30" readonly="readonly" id="status" name="status" maxlength="25" />					</td>
					<td >							
						<p>Password Status</p></td>
						<td align="left">
						<%-- <% String pwdsts = (String) hashMap.get("password_status");
						if(pwdsts != null && pwdsts.compareTo("A")==0)
							pwdsts = "Active";
						else
							pwdsts = "Disabled";
						 %> --%>
						<input type="text" style="color:gray" size="30" readonly="readonly" id="password_status" name="password_status" maxlength="25"/>					</td>
		  </tr>
					
		<tr>
			<td >
			  <p>Accept Emails</p></td>
			<td align="left">
				<%-- <% String acceptMails = (String) hashMap.get("accept_mails");
				   String role =  (String)hashMap.get("role");	
				   String showAcceptMails = "";
					System.out.println("role "+role);
				if(role != null && (role.compareTo("ADMIN")!=0 && role.compareTo("POWERUSER")!=0))
					showAcceptMails = "disabled=\"disabled\" ";
				
					
				if(acceptMails != null && acceptMails.compareTo("Y")==0)
					acceptMails = "checked";
				else
					acceptMails = "";
				 %> --%>
		  	<input type="checkbox" id="acceptMails" name ="acceptMails" value="acceptEmails"  />					
		  	</td>
		</tr>							
								
				<tr><td></td><td></td></tr>
		  </table>
				
				<br />
				
				<div class="blueHeaderNoRound">
					<div class="blueHeaderNoRoundText">Geographic Information</div>
				</div>
				
				<br />
				
				<table width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
				
				<tr>
					<td width="115" >
				  <p>Street Address</p></td>
						 
					<td width="321" align="left">
						<input type="text" id="address1" name="address1" size="38" maxlength="150"  tabindex="6"/>
				  <span class="Star">&nbsp;</span></td>
				  
				  <td width="123" >
				  <p>ZIP</p></td>
						 
				  <td width="328" align="left">
			      <input type="text" id="zip" name="zip" maxlength="5" tabindex="10"/></td>
				</tr>
				<tr>
				<td><p>&nbsp;</p></td>
				 
					<td align="left">
						<input type="text" id="address2" name="address2" size="38" tabindex="7" />					</td>
						
						<td width="123" >
				  <p>Phone </p></td>
						 
				  <td width="328" align="left">
                  <input size="30" type="text" id="phone_no" name="phone_no" maxlength="50"  tabindex="11"/></td>
				</tr>
				
				<tr>
					<td >
						<p>City					</p></td>
						
				  <td align="left">
						<input size="30" type="text" id="city" name="city" maxlength="10"  tabindex="8" onkeypress="return LettersOnly(event)"/></td>
						
					<td width="123" >
				  <p>Mobile Phone</p></td>
						 
					<td width="328" align="left">
                  <input size="30" type="text" id="cellPhone" name="cellPhone" maxlength="25"  tabindex="12"/></td>
				</tr>
				<tr>
					<td ><p>State </p></td>
					
				  <td size="25" align="left"><select id="state" name="state" tabindex="9" >
                      </select></td>
					<td >
						<p>&nbsp;</p></td>
						 
				  <td align="left">&nbsp;</td>
				</tr>
				</table>

				
				<table width="100%" align="center" cellpadding="1" cellspacing="1">
				
				<tr>
				
				 <td colspan="2">
				 
				   <div align="right">
<%-- 				     <input type="hidden" name="sessionid" value="<%=(String)request.getSession().getAttribute("sessionid") %>" /> --%>
				     <input type="hidden" id="userid" name="userid" value="" />
				     <input type="hidden" name="comId" id="comId" value="" /> 
				     
				     <input type="hidden" name="oldEmail" id="oldEmail" value="" />
				     <input type="hidden" name="oldFirstName" id="oldFirstName" value="" />				     
				     <input type="hidden" name="oldLastName" id="oldLastName" value="" />
				     		     
				     
				     <input type="button" name="button2" id="button2" onclick="javascript:validate_form();"
							value='Save'
							class="Btn1" 
							 />
				     
				     
				     <input type="button" name="button" id="button"
							value='Cancel' onclick="javascript:onCancel()" />				  
			       </div></td>

					
				</tr>
				
		  </table>

		<input type="hidden" name="status" value="A"/>
		
		
		
		
<div class="blueHeaderNoRound">
  	<div class="blueHeaderNoRoundText">Audit Trail: <a href="javascript:animatedcollapse.toggle('auditTrail')"><img src="images/auditTrail.png" alt="View More" border =0 width=20 height=20 /></a> </div>
</div>

<br />

<center>
</center>

<center>
	<%-- <%= htmlAuditTrail%> --%>
</center>
		
		</form>
		
		
	</body>
</html>
