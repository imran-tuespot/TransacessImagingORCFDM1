<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<jsp:useBean id="propertyInformation" scope="request" class="com.peniel.beans.PropertyInformation" />
<jsp:setProperty name="propertyInformation" property="*" />
<%@page import="java.util.*"%>


<html>
	<head>
		<title>Transaccess Imaging Administrator Edit User Profile</title>
		<meta name="pageHeading" content='Imaging Registration' />
		<link rel="stylesheet" href="css/bootstrap.css"></link>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<script src="js/jQuery/1.11.3/jquery.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>		
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" /> 	
	
	</head>	
	
	
	<% 	
		HashMap hashMap = propertyInformation.getPropertyDetails(request);
		Set set = hashMap.entrySet();
      	Iterator iterator = set.iterator();
      	while(iterator.hasNext()) {
         	Map.Entry mentry = (Map.Entry)iterator.next();
         	System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
         	System.out.println(mentry.getValue());
      }
      	

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
	
	<jsp:include page="includes/sessionHeader.jsp" />
	
<body onLoad="initial_load()">	
	
<script type="text/javascript">

function validateForm()
{	
	document.getElementById('button2').disabled = true;
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
    	document.registrationForm.submit();
	
}


function onCancel()
{
	location.href='PropertyList?type=worksheet&sessionid=<%=request.getSession().getAttribute("sessionid")%>';

}

function initial_load()
	{
		 setHeader("editProperty.jsp");	
		   //Initialize slider menu
      	$('#simple-menu').sidr();
      
	  	$('.child').hide();
	  	$('.parent').click(function() {
		 	$('.child').slideUp();
		 	$(this).find('ul').slideToggle();
	  	});
	  	$('#adminWizardLi').click();	 	
	
		var sessId = '<%=request.getSession().getAttribute("sessionid")%>';
		var userId = '<%=hashMap.get("userId") %>';
		
		var msg = '<%=successMsg%>';
        if(msg != "")
        {
        	document.getElementById('err').style.display = 'block';        	
        }
		
	}
	
		
	
</script>
	<div id="err" class="err" style ='display:none;'>
		<%=successMsg %>
	</div>
	
		
		<div id ="noChangeMsg" style ='display:none;' >
			No Changes Occurred.
		</div>


<form name="registrationForm" method="post" action="./EditProperty"  >

<div align="center" style="margin:20px;">
					<p style="color:green;font-size:16px;text-align: left;margin-bottom:10px;"><i class="zmdi_large zmdi-edit"></i>Edit Property</p>
		<div class="card" style="width: 95%;padding-left: 0px;">
			<div class="card-body card-padding" style="background-color:#EDECEC">
				<table class="table" cellspacing="0">
					<tbody>
						<tr>
							<td>Property ID <span class="requiredStar">*</span></td>
							<%
								String propertyId = (String) hashMap.get("propertyId");					 			
							 %>
							<td>
								<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"    type="text" id="propertyId" name="propertyId" onblur="javascript:checkDuplicateProperty()"  value="<%=propertyId %>" maxlength="150" tabindex="1" />
							</td>
						</tr>
						<tr>
							<td>Property Name <span class="requiredStar">*</span></td>
							<%
								String propertyName = (String) hashMap.get("propertyName");					 			
							 %>
							<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"   type="text" id="propertyName" name="propertyName"  value="<%=propertyName %>" maxlength="150" tabindex="2" /></td>
						</tr>
						<tr>
							<td>Property City</td>
							<%
								String city = (String) hashMap.get("city");					 			
							 %>
							<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="city" name="city"  value="<%=city %>" tabindex="3" /></td>
						</tr>
						<tr>
							<td>Property State</td>
							
							
							<td> 
								<select class="selectText" style="overflow:auto;width:300px;" name="state" id="state" tabindex="4">
										<%=hashMap.get("stateList") %>

								</select>				
							</td>
						</tr>
						<tr>
							<td>Property Zip</td>
							<%
								String zip = (String) hashMap.get("zip");					 			
							 %>
							<td><input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="zip" name="zip" maxlength="6" value="<%=zip %>" tabindex="5" /></td>
						</tr>
						<tr>
							<td ><input type="hidden" id="id" name="id" value="<%=(String)request.getParameter("id") %>"/></td>
						
							<td style="text-align: left;">
								<input name="button2" id="button2" class="btn btn-success waves-effect waves-button waves-float" style="margin-left: 165px;"  type="button" onclick="javascript:validateForm();" value="Save">
								<input name="button" id="button" class="btn btn-warning waves-effect waves-button waves-float" style="margin-left: 15px;" type="button" value="Cancel" onclick="javascript:onCancel();">											
							
							</td>
							
						</tr>
						
					</tbody>
				</table>
</div>
</div>
	</div>		 
			<table align="center" width="100%">
				<tr>
				 	<td colspan="2">
				 
					  <div align="right">
					    <input type="hidden" name="sessionid" value="<%=(String)request.getSession().getAttribute("sessionid") %>" />
					    <input type="hidden" name="userid" value="<%=hashMap.get("userId") %>" />
					   
					    <input type="hidden" name="comId" id="comId" value="<%=hashMap.get("comId") %>" /> 
					   			 
			          </div></td>

				</tr>
			</table>
		</form>		
	</body>
</html>
