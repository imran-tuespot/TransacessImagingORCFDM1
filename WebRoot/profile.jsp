<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />

<%@page import="java.util.*"%>

<html>
	<head>
	<style>
		select:focus {
	box-shadow: none !important;border-width: 1px;
border-style: solid;
border-color: rgb(77, 144, 254);
border-image: initial;}
	table.audittab tr:nth-child(even) {background-color: #f2f2f2;}
	table.audittab tbody,tr,td {font-size:12px;font-family:roboto;}
	p.auditclass  {font-size:12px !important;font-family:roboto !important;}

	
	</style>
		<title>Profile Information</title>
		<meta name="pageHeading" content='Imaging Registration' />
		<!-- <script type="text/javascript" src="js/jquery-1.2.6.min.js"></script>-->		
		<link rel="stylesheet" href="css/bootstrap.css"></link>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		
		<script src="js/jQuery/1.11.3/jquery.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    					<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>			
		
		<%javax.naming.Context ctx = 	new javax.naming.InitialContext();
String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
String URL = (String) ctx.lookup("java:comp/env/URL"); %>


		
		
	</head>
	

	<body onLoad="initial_load()">	
	
	
	
	<script type="text/javascript">
	function oncancel()
	{
		history.back(-1);
	}
	 $(document).mousemove(function(event){
		  InitializeTimer();
	  });
	 function setUserValues(){
			var user_id =JSON.parse(sessionStorage.getItem("roles")).user_id;
		$('#userid').val(JSON.parse(sessionStorage.getItem("roles")).user_id);
		$('#comId').val(JSON.parse(sessionStorage.getItem("roles")).company_ID);
		getUserDeatails(user_id);
			}
			var myobj=null;
		function getUserDeatails(user_id){
			var token=sessionStorage.getItem("token");
			myobj="";
			 $.ajax({
		         type: "POST",
		         url:"<%=restURL%>role/myProfile?userid="+user_id,
		         dataType: "json",
		         headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
		         success: function (data) {
		        	 myobj=data.resp;
		        	 
		        	 $('#email').val(data.resp.email.trim());
		        	 $('#username').val(data.resp.username.trim());
		        	 $('#address1').val(data.resp.address1);
		        	 $('#address2').val(data.resp.address2);
		        	 $('#city').val(data.resp.city);
		        	 $('#first_name').val(data.resp.first_NAME);
		        	 $('#last_name').val(data.resp.last_NAME);
		        	// $('#ticketTitle').val(data.otp);
		        	 $('#cellPhone').val(data.resp.cell_PHONE);
		        	 $('#state').val(data.resp.state.trim());
		        	 $('#AUTH_ID').val(data.resp.auth_ID);
		        	 $('#zip').val(data.resp.zip);
		        	 $('#otpVal').val(data.resp.otp);
		        	 $('input[name=otp][value='+data.resp.otp+']').attr('checked', true); 
		        	 var rolename=JSON.parse(sessionStorage.getItem("roles")).role_NAME;
		        	 $('#userRole').val(rolename);
		            
		             } 
		       });
		}
	function initial_load()
	{
    	getHeaderusername();

		setUserValues();
		getStates();
		var array_of_li =  document.querySelectorAll("ul.tab-nav li");
		
		for (var i = 0; i < array_of_li.length; i++) {
			 if(array_of_li[i].textContent.trim()=='My Profile'){
					array_of_li[i].setAttribute("class", "active");	
				}  
		/* if(i == 8){
			array_of_li[i].setAttribute("class", "active");	
		} */			
		}
		setHeader("myProfile.jsp");	
		//Initialize slider menu
     	$('#simple-menu').sidr();
      
	  	$('.child').hide();
	  	$('.parent').click(function() {
// 		 	$('.child').slideUp();
// 		 	$(this).find('ul').slideToggle();
	  		var status=$(this).find('ul').is(":hidden");
			var child1 =$('.child1').find('li').is(":hidden");
			var child2 =$('.child2').find('li').is(":hidden");
			var child3 =$('.child3').find('li').is(":hidden");
			var child4 =$('.child4').find('li').is(":hidden");
		
			if(status){
				if(!child1){ $('.child1').parent().find('ul').slideUp();}
				if(!child2){ $('.child2').parent().find('ul').slideUp();}
				if(!child3){ $('.child3').parent().find('ul').slideUp();}
				if(!child4){ $('.child4').parent().find('ul').slideUp();}
				$(this).find('ul').slideDown();	
			}else{
				$(this).find('ul').slideUp();
			}
	  	});
      		
		var msg = "na";
        if(msg != "")
        {
        	document.getElementById('err').style.display = 'block';        	
        }
        
          var otp = '';
        if(otp=='E'){
      
        	$("#emailotp").prop("checked", true);
        	$('#otpVal').val('E');
        }else if(otp=='M') {
        	
        	$("#mobileotp").prop("checked", true);
        	$('#otpVal').val('M');
        }
	}

	function fnOTP(otpchanged){
			$("#otpVal").val(otpchanged);
			if(otpchanged=='M' && $("#cellPhone").val()== ""){
				alert("Mobile Number is required");

				
			}
		}


			;	

	function fnGetLandNo(){
		var num= Math.floor(1000000 + Math.random() * 9000000);
	return '770'+num;
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
	
	var otpval=$("#otpVal").val();
	if(otpval=='M' && $("#cellPhone").val()== ""){
		alert("Mobile Number is required");
		return false;
	}

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
	
	 if(document.getElementById('cellPhone').value != "" &&  !validatePhone(document.getElementById('cellPhone').value)) 
	{  
  		alert("Not a valid phone number. Please enter phone number in XXX-XXX-XXXX format");
 		return false;
	}
	 
	    mobileChange='no';
	    if(document.getElementById('cellPhone').value != myobj.cell_PHONE){
	    	mobileChange='yes';
	    }
	  if(document.getElementById('email').value != myobj.email){
	  	mobileChange='yes';
	  }
	    
	if(otpval != myobj.otp){
		mobileChange='yes';
	}
	    if(mobileChange=='yes'){
	    	document.getElementById('button2').disabled = true;
			mobleChange();
		}else{
			document.getElementById('button2').disabled = true;
	    document.registrationForm.submit();
		}
	//updateUser();
}

function updateUser(){
	var token=sessionStorage.getItem("token");
	
	var input =
	 $.ajax({
        type: "POST",
        url:"<%=restURL%>role/updateProfile?userid="+user_id,
        dataType: "json",
        headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
        success: function (data) {
       			
 console.log(data);
           
            } 
      });
}
function mobleChange(){
	var mnumber=document.getElementById('cellPhone').value;
 	
 	if($("#otpVal").val()=='E'||!mnumber){
 		mnumber=fnGetLandNo();
 	}

	var email=document.getElementById('email').value;
	var userid =JSON.parse(sessionStorage.getItem("roles")).user_id;
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "<%=restURL%>role/saveTwillouser",
		dataType : 'json',
		timeout : 100000,
	  data:JSON.stringify({'email':email,'phone':mnumber,'ccode':'+91','userId':userid,'not':'nosms'}),
		success : function(data) {
			
			if(data.key=="200"){
				document.getElementById('AUTH_ID').value=data.authId;
				document.registrationForm.submit();
				 
			}else if(data.key=="201"){
				 // jAlert(data.status.message, 'Error');
				alert(data.message.message)
				//$("#popup_error").text(data.status.message);
			}else if(data.key=="500"){
				 //jAlert(data.message, 'Error');
				//$("#popup_error").text(data.message);
				alert(data.message)
			}

			  
			//$('#myModal').modal('show');
		
		},
		error : function(e) {
			console.log(e);
		},
		done : function(e) {
			console.log("DONE");
		}
		
});
}
function getStates(){
	var token=sessionStorage.getItem("token");
	 $.ajax({
         type: "POST",
         url:"<%=restURL%>rmshd/getStates",
         dataType: "json",
         headers: {  'Access-Control-Allow-Origin': '*','Authorization': 'Bearer '+token  },
         success: function (data) {
         	//alert("619::"+data.docTypeData[0].value);
         		

             $.each(data.states,function(i,obj)
             		
             {                	
             	var	div_data="<option value="+obj.dropdown_id+">"+obj.dropdown_name+"</option>";
             	$(div_data).appendTo('#state'); 
             	
             });
            
             } 
       });
}
</script>
	<div id="err" class="" style ='display:none;margin-top: 10px;'>
		
	</div>
		
		<div id ="noChangeMsg" style ='display:none;' >
			No Changes Occurred.
		</div>

		</b>	

		<form name="registrationForm" method="post" action="./MyProfile"  >
		
		
		<div align="center" style="margin:20px;">
		
											
<p style="color:green;font-size:16px;text-align: left;margin-bottom:10px;margin-left: 10px;"><i class="zmdi_large zmdi-file"></i></i>Registered User Information For </p>
		
		
		
		
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          	Account Information  &nbsp&nbsp<span style = "font-size: 11px;    font-weight: normal;    border-left: 3px #fff solid;">&nbsp&nbsp General details about your account</span>
        </a>
      </h4>
    </div>
    
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
      
      <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
			<div class="card-body card-padding" style="padding: 16px 6px 0px;background-color:#EDECEC">
					<table class="table" cellspacing="0">
						<tbody>
							<tr>
								<td>User Name <span class="requiredStar">*</span></td>
								<td>
									
									<input disabled size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"    type="text" id="username" name="username" maxlength="25"  readonly="readonly" tabindex="1" />
								</td>
							</tr>
							<!-- <tr>
								<td>User Login ID <span class="requiredStar">*</span></td>
								<td> 
									<input disabled size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="username" name="username" maxlength="25"  tabindex="2" /></td>												
								</td>
							</tr> -->
							<tr>
								<td>Email</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="email" name="email" maxlength="100"  tabindex="3" /></td>
							</tr>
							
							<tr>
								<td>Role</td>
								<!-- <td><select disabled="disabled" id="userRole" name="userRole" style="overflow:auto;width:300px;" tabindex="4" >
				                     
				                    </select></td> -->
			<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="userRole" name="userRole" maxlength="100"  tabindex="3"  disabled/></td>
				                    
							</tr>
							<!-- <tr>
								<td>Alternate Email</td>
								<td> 
								
									<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="secondEmail" name="secondEmail"    maxlength="100" tabindex="5" />
								</td>
							</tr> -->
							<!-- <tr>
								<td>Job Title</td>
								
								
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="jobTitle" name="jobTitle" maxlength="25"  tabindex="6" /></td>
							</tr>
							 -->
							<tr>
								<td>First Name <span class="requiredStar">*</span></td>
								
								
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="first_name" name="first_name" maxlength="25"   onkeypress="return LettersOnly(event)" tabindex="7" /></td>
							</tr>
							<tr>
								<td>Last Name <span class="requiredStar">*</span></td>
								<td> 
									
								
									<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="last_name" name="last_name" maxlength="25"  tabindex="8" />
								</td>
							</tr>
							<!-- <tr>
								<td>Status</td>
								<td><input disabled="disabled" size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" readonly="readonly" id="status" name="status" maxlength="25"  tabindex="9" /></td>
							</tr>
							
							<tr>
								<td>Password Status</td>
								<td>
								
								<input disabled="disabled" size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="password_status" name="password_status" maxlength="25"  tabindex="10" readonly="readonly"/></td>
							</tr> -->
							<tr>
								<td>Accept Emails</td>
								<td> 
										
 									<div><input type="checkbox" id="acceptMails" name ="acceptMails" value="acceptEmails" tabindex="11"  />	
 									</div>				

								</td>
							</tr>
						</tbody>
					</table>
					</div>
				</div>
      </div>
    </div>
  </div>
  
  
  
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Geographic Information &nbsp&nbsp<span style = "font-size: 11px;    font-weight: normal;    border-left: 3px #fff solid;">&nbsp&nbsp Address & Phone details</span>
        </a>
      </h4>
    </div>
    
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
      <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
			<div class="card-body card-padding" style="padding: 16px 6px 0px;background-color:#EDECEC">
					<table class="table" cellspacing="0">
						<tbody>
						<tr>
								<td>Street Address</td>
								<td>
								<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="address1" name="address1" size="38" maxlength="150"  tabindex="12" /></td>
							</tr>
							<tr>
								<td>City</td>
								<td>
								
								<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="city" name="city" maxlength="10"  maxlength="150" tabindex="13" /></td>
							</tr>
							<tr>
								<td >State</td>
								
								<td><select id="state" name="state"  style="overflow:auto;width:300px;" tabindex="14">
			                       <option value="" selected="" disabled="">Select State</option>
			                         </select>
			                      </td>
							</tr>
							<tr>
								<td>Zip</td>
								<td>
								
								<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="zip" name="zip" maxlength="6"  maxlength="150" tabindex="15" /></td>
							</tr>
							
							
							<tr>
								<td>Mobile Number</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="cellPhone" name="cellPhone" maxlength="25"  tabindex="17" /></td>
							</tr>
							
						</tbody>
					</table>
			</div>
		</div>
						
      </div>
    </div>
  </div>
    <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingFour">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="#collapseFour">
         Multifactor Authentication &nbsp&nbsp<span style = "font-size: 11px;    font-weight: normal;    border-left: 3px #fff solid;">&nbsp&nbsp A unique One-Time-Password will be delivered to the mode you choose (Email / Mobile)</span>
        </a>
      </h4>
    </div>
    
    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
      <div class="panel-body">
      <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
			<div class="card-body card-padding" style="padding: 16px 6px 0px;background-color:#EDECEC">
					<table class="table" cellspacing="0">
						<tbody>
						<tr>
							<td>	<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="radio" onClick="fnOTP('E')"; id="emailotp" name="otp"   value="E"  />
								&nbsp;&nbsp;&nbsp; Email OTP 
								</td>
								
							</tr>
							<tr>
							<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" onClick="fnOTP('M')";  type="radio" id="mobileotp" name="otp"  value="M" />
							&nbsp;&nbsp;&nbsp;	Mobile OTP</td>
								
								
							</tr>					
						</tbody>
					</table>
			</div>
		</div>
						
      </div>
    </div>
  </div>
  
  <!-- <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          Audit Trail &nbsp&nbsp<span style = "font-size: 11px;    font-weight: normal;    border-left: 3px #fff solid;">&nbsp&nbsp Provides a collection of past events taken by the user</span>
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div style="overflow-x:scroll;overflow-y:scroll;height:300;font-size:12px !important"  class="panel-body auditclass">
      
      </div>
    </div>
  </div> -->
</div>
	<table>
	<tr>
			<td>
			<input type="hidden" name="sessionid"  value="<%=(String)request.getSession().getAttribute("sessionid") %>"/>
		     <input type="hidden" name="userid" id="userid"  />
		     <input type="hidden" name="comId" id="comId"  /> 
		     <input type="hidden" name="AUTH_ID" id="AUTH_ID"  /> 
		     <input type="hidden" name="oldEmail" id="oldEmail"  />
		     <input type="hidden" name="oldFirstName" id="oldFirstName"  />				     
		     <input type="hidden" name="oldLastName" id="oldLastName"  />
		     <input type="hidden" name="oldSecondEmail" id="oldSecondEmail"  />	
		     <input type="hidden" name="status" value="A"/>
		     
		     <input type="hidden" name="OTP" id="otpVal" />
		     	
			</td>
		
			<td style="text-align: right;">
				<input name="button2" id="button2" class="btn btn-success waves-effect waves-button waves-float" style="margin-left: 665px;"  type="button" onclick="javascript:validate_form();"	value='Save'>
				<!-- <input name="button" id="button" class="btn btn-warning waves-effect waves-button waves-float" style="margin-left: 15px;" type="button" value='Cancel' onclick="javascript:onCancel()"> -->											
						
			</td>
						
			</tr>
	
	</table>	
		
		
				
		
	</div>		 
				 
				 
				 
				 
						
		<table width="95%" align="center" cellpadding="1" cellspacing="1">
			
		<tr>
		
		 <td colspan="2">
		 
		   <div align="right">
		     <input type="hidden" name="sessionid"  value="<%=(String)request.getSession().getAttribute("sessionid") %>"/>
		     <input type="hidden" name="userid"  />
		     <input type="hidden" name="comid"  />
		  <!--    <input type="button"  name="button2" id="button2" onclick="javascript:validateForm();"
					value='Save'
					class="Btn1" onmouseover="this.className='Btn2'"
					onmouseout="this.className='Btn1'" />
		     
		     
		     <input type="button" name="button" id="button"
					value='Cancel' onclick="javascript:oncancel()" />		-->		  
	       </div></td>
	
		</tr>				
  </table>


</form>		

</body>
</html>

