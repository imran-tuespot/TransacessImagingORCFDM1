<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<jsp:useBean id="propertyInformation" scope="request" class="com.peniel.beans.PropertyInformation" />
<jsp:setProperty name="propertyInformation" property="*" />
<%@page import="java.util.*"%>

<html>
	<head>
		<title>Property Information</title>
		<meta name="pageHeading" content='Imaging Registration' />
		<script src="js/jQuery/jquery-1.8.2.min.js"></script>  
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
		    
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />  
		
		<jsp:include page="includes/sessionHeader.jsp" />
		
	</head>

	<body onLoad="initial_load()">	
	
	
	<%
		String successMsg = "";
		successMsg = request.getParameter("successMsg");
		if("".equals(successMsg) || successMsg == null){
				successMsg = "";
				
		}
		else
		{
			if("true".equals(successMsg)){
				successMsg = "New property has been successfully registered.";
			} else if("false".equals(successMsg))	{
				successMsg = "Error while adding property.";
			}
		}
		
		
	%>
	<script type="text/javascript">
	function oncancel()
	{
		history.back(-1);
	}
	
	
	function initial_load()
	{
	//Initialize slider menu
      	$('#simple-menu').sidr();
      
	  	$('.child').hide();
	  	$('.parent').click(function() {
		 	$('.child').slideUp();
		 	$(this).find('ul').slideToggle();
	  	});
	  	$('#adminWizardLi').click();	 	
	  	
		var array_of_li =  document.querySelectorAll("ul.tab-nav li");
		for (var i = 0; i < array_of_li.length; i++) {
		if(i == 2)
			array_of_li[i].setAttribute("class", "active");	
			
		}
		setHeader("addProperty.jsp");	
		
	
		
		var msg = '<%=successMsg%>';
        if(msg != "")
        {
        	document.getElementById('err').style.display = 'block';        	
        }
	}

function getXMLObject()  //XML OBJECT
	{
	   var xmlHttp = false;
	   try 
	   {
	     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); // For Old Microsoft Browsers
	   }
	   catch (e) {
	     try 
	     {
	       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");  // For Microsoft IE 6.0+
	     }
	     catch (e2) {
	       xmlHttp = false;   // No Browser accepts the XMLHTTP Object then false
	     }
	   }
	   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
	     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
	   }
	   return xmlHttp;  // Mandatory Statement returning the ajax object created
	}
var index = new Array();
var documentdata = new Array();
var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object
function checkDuplicateProperty() 
{
	var compid = <%= request.getSession().getAttribute("comid").toString()%>;
	
	var propertyId = document.getElementById('propertyId').value;
	var queryString = "compid="+compid+"&propertyId="+propertyId;	
	//alert("query "+queryString);
	if(xmlhttp) 
	{ 
	    xmlhttp.open("POST","CheckDuplicateProperty",true); 
	    xmlhttp.onreadystatechange  = handleServerResponse;
	    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlhttp.send(queryString);
	} 
	
	}

function handleServerResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	parseData(xmlhttp.responseText);
      }    
     else {
        //alert(xmlhttp.status);
     }
   }
}

function parseData(data) 
{
	if(data == 'exist')
	{
		jAlert("Property Id already exists. Please enter another property.","Duplicate Property Error");
		document.getElementById('button2').disabled = true;		
		
		//document.getElementById('propertyId').focus();		
	}
	else
	{
		document.getElementById('button2').disabled = false;	
	}
	
}

	
function validateForm()
{	
	if(document.getElementById('propertyId').value == "" ) 
	{
		jAlert("Enter Property ID Field.","Missing Property ID");
		return false;		
	}
	if(document.getElementById('propertyName').value == "" ) 
	{
		jAlert("Enter Property Name Field.","Missing Property Name");
		return false;		
	}
		document.getElementById('button2').disabled = true;		
    	document.registrationForm.submit();

	
}


//-->
</script>
	<div id="err" class="err" style ='display:none;'>
		<%=successMsg %>
	</div>
		
		<div id ="noChangeMsg" style ='display:none;' >
			No Changes Occurred.
		</div>

		</b>	

		<form name="registrationForm" method="post" action="./AddProperty"  >

		
		<div align="center" style="margin:20px;">
					<p style="color:green;font-size:16px;text-align: left;margin-bottom:10px;padding-left:10px;"><i class="zmdi_large zmdi-present-to-all"></i>Add Property</p>
		<div class="card" style="width: 95%;padding-left: 0px;">
			<div class="card-body card-padding" style="background-color:#EDECEC">
					<table class="table" cellspacing="0">
						<tbody>
							<tr>
								<td>Property ID <span class="requiredStar">*</span></td>
								<td>
									<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"    type="text" id="propertyId" name="propertyId" onblur="javascript:checkDuplicateProperty()"  value="" maxlength="150" tabindex="1" />
								</td>
							</tr>
							<tr>
								<td>Property Name <span class="requiredStar">*</span></td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="propertyName" name="propertyName"  value="" maxlength="150" tabindex="2" /></td>
							</tr>
							<tr>
								<td>Property City</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="city" name="city"  value="" tabindex="3" /></td>
							</tr>
							<tr>
								<td>Property State</td>
								<td> 
									<select class="selectText" style="overflow:auto;width:300px;" tabindex="4" id="state" name="state">
										<option value="AL">Alabama</option>
										<option value="AK">Alaska</option>
										<option value="AZ">Arizona</option>
										<option value="AR">Arkansas</option>
										<option value="CA">California</option>
										<option value="CO">Colorado</option>
										<option value="CT">Connecticut</option>
										<option value="DE">Delaware</option>
										<option value="DC">District Of Columbia</option>
										<option value="FL">Florida</option>
										<option value="GA">Georgia</option>
										<option value="HI">Hawaii</option>
										<option value="ID">Idaho</option>
										<option value="IL">Illinois</option>
										<option value="IN">Indiana</option>
										<option value="IA">Iowa</option>
										<option value="KS">Kansas</option>
										<option value="KY">Kentucky</option>
										<option value="LA">Louisiana</option>
										<option value="ME">Maine</option>
										<option value="MD">Maryland</option>
										<option value="MA">Massachusetts</option>
										<option value="MI">Michigan</option>
										<option value="MN">Minnesota</option>
										<option value="MS">Mississippi</option>
										<option value="MO">Missouri</option>
										<option value="MT">Montana</option>
										<option value="NE">Nebraska</option>
										<option value="NV">Nevada</option>
										<option value="NH">New Hampshire</option>
										<option value="NJ">New Jersey</option>
										<option value="NM">New Mexico</option>
										<option value="NY">New York</option>
										<option value="NC">North Carolina</option>
										<option value="ND">North Dakota</option>
										<option value="OH">Ohio</option>
										<option value="OK">Oklahoma</option>
										<option value="OR">Oregon</option>
										<option value="PA">Pennsylvania</option>
										<option value="RI">Rhode Island</option>
										<option value="SC">South Carolina</option>
										<option value="SD">South Dakota</option>
										<option value="TN">Tennessee</option>
										<option value="TX">Texas</option>
										<option value="UT">Utah</option>
										<option value="VT">Vermont</option>
										<option value="VA">Virginia</option>
										<option value="WA">Washington</option>
										<option value="WV">West Virginia</option>
										<option value="WI">Wisconsin</option>
										<option value="WY">Wyoming</option>
									</select>				
								</td>
							</tr>
							<tr>
								<td>Property Zip</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="zip" name="zip" maxlength="6" value="" tabindex="5" /></td>
							</tr>
							
							 <!-- <!-- <tr>
								<td>FHA Number</td>
								<td> 
									<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="fhaNum" name="fhaNum"  value="" tabindex="2" /></td>												
								</td>
							</tr>
							<tr>
								<td>Lender Name</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="accountExec" name="accountExec"  value="" maxlength="150" tabindex="6" /></td>
							</tr>
							
							
							<tr>
								<td>Loan Amount</td>
								<td> 
									<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="lenderNum" name="lenderNum"  value="" maxlength="150" tabindex="7" />
								</td>
							</tr>
							<tr>
								<td>Loan  Type</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="lenderName" name="lenderName"  value="" tabindex="8" /></td>
							</tr>
							 --> 
							<!-- <tr>
								<td>Form Num</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="servicerNum" name="servicerNum"  value="" maxlength="150" tabindex="9" /></td>
							</tr>
							<tr>
								<td>Form Name</td>
								<td> 
									<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="servicerName" name="servicerName"  value="" tabindex="10" />
								</td>
							</tr>
							
							
														
							<tr>
								<td>Congressional Area</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="congressionalArea" name="congressionalArea"  value="" maxlength="150" tabindex="11" /></td>
							</tr> -->
							<!-- <tr>
								<td>Trouble Code</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="troubleCode" name="troubleCode" value="" tabindex="13" /></td>
							</tr><tr>
								<td>Reac Score</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="reacScore" name="reacScore"  value="" maxlength="150" tabindex="14" /></td>
							</tr><tr>
								<td>Active Deac Assignment</td>
								<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="activeDeacAssignment" name="activeDeacAssignment"  value="" tabindex="15" /></td>
							</tr>-->
							<tr>
								<td ></td>
							
								<td style="text-align: left;">
									<input name="button2" id="button2" class="btn btn-success waves-effect waves-button waves-float" style="margin-left: 165px;"  type="button" onclick="javascript:validateForm();" value="Save">
									<input name="button" id="button" class="btn btn-warning waves-effect waves-button waves-float" style="margin-left: 15px;" type="button" value='Cancel' onclick="javascript:oncancel()">											
								
								</td>
								
							</tr>
							
						</tbody>
					</table>
</div>
</div>
	</div>		 		 
				 
						
		<table width="95%" align="center" cellpadding="1" cellspacing="1">
			
		<tr>
		
		 <td colspan="2">
		 
		   <div align="right">
		     <input type="hidden" name="sessionid" value="<%=(String)request.getSession().getAttribute("sessionid") %>" />
		     <input type="hidden" name="userid" value="<%=request.getSession().getAttribute("userid") %>" />
		     <input type="hidden" name="comid" value="<%=request.getSession().getAttribute("comid").toString() %>" />
		  
	       </div></td>
	
		</tr>				
  </table>


</form>		

</body>
</html>

