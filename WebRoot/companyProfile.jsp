<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<jsp:useBean id="companyInformation" scope="request" class="com.peniel.beans.CompanyInformation" />
<jsp:setProperty name="companyInformation" property="*" />
<%@page import="java.util.*"%>

<html>
	<head>
		<title> Company Profile</title>
		<meta name="pageHeading" content='Imaging Registration' />
		<link rel="stylesheet" href="css/bootstrap.css"></link>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<script src="js/jQuery/1.11.3/jquery.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>			
		
		<jsp:include page="includes/sessionHeader.jsp" />
		
	</head>

	<body onLoad="initial_load()">	
	
	
	<% HashMap hashMap = companyInformation.getCompanyInformation(request);
	  String sessionid =(String) request.getSession().getAttribute("sessionid");
	
		/*Set set = hashMap.entrySet();
		
		// Get an iterator
		Iterator it = set.iterator();
		
		while(it.hasNext()) 
		{
			Map.Entry me = (Map.Entry)it.next();			
			System.out.println(""+me.getKey() +" "+ me.getValue());
		} 	*/
				
		String successMsg = "";
		successMsg = request.getParameter("successMsg");
		if("".equals(successMsg) || successMsg == null){
				successMsg = "";
		}
		
		String noChangeMsg = "";
		
	%>
	<script type="text/javascript">
	function oncancel()
	{
		//history.back(-1);
		window.location="dashboard.jsp";
	}
	
	
	function initial_load()
	{
		setHeader("companyProfile.jsp");
		//Initialize slider menu
      	$('#simple-menu').sidr();
      
	  	$('.child').hide();
	  	$('.parent').click(function() {
		 	$('.child').slideUp();
		 	$(this).find('ul').slideToggle();
	  	});
	  	
		var msg = '<%=successMsg%>';
        if(msg != "")
        {
        	document.getElementById('err').style.display = 'block';        	
        }		
		getdropdowns();		
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
/*function getdropdowns() 
{

	
	var queryString = "compid="+compid;	
	//alert("query "+queryString);
	if(xmlhttp) 
	{ 
	    xmlhttp.open("POST","GetDropDown",true); 
	    xmlhttp.onreadystatechange  = handleServerResponse;
	    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlhttp.send(queryString);
	} 
}*/

function getdropdowns()
{
	var comid = <%= request.getSession().getAttribute("comid").toString()%>
      
          
           $.ajax({
            type: "GET",
            url:"GetIndexTypeDropdown?comid="+comid,
            dataType: "json",
            success: function (data) {
            
                $.each(data.indexTypeData,function(i,obj)
                {
                 	var div_data="<option value="+obj.value+">"+obj.text+"</option>";
                	var indexType = <%=hashMap.get("defaultIndex")%>
                	//alert("Index Type "+indexType);
                	//alert("text "+obj.value);
					if(obj.value == indexType){
						div_data="<option value="+obj.value+" selected>"+obj.text+"</option>";
					}
						
                	$(div_data).appendTo('#indextype'); 
                	
                });
                 
                }
          });
}

function handleServerResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     	parseData(xmlhttp.responseText);
      }    
     else {
        alert(xmlhttp.status);
     }
   }
}

function parseData(data) 
{
	var row = data.split('$');
	var indexstr = row[0];
	//var docstr = row[1];
	//var countStr = row[2];
	
	parseindexstr(indexstr);
}
function parseindexstr(indexstr) {
	var indexType = <%=hashMap.get("defaultIndex")%>
	//alert("Index "+indexType);
	var selected = false;
	var row = indexstr.split('|');
	index.length = 0;
	for (var i=0; i<row.length-1; i++) {
	  var col = row[i].split('^');
	  index[i]= new Array(col[0],col[1]);
	   //alert(index[i][0]+"="+index[i][1]);
    }
    for (var i=0; i < index.length;++i){
    //alert("index "+index[i][1]+ " indexType "+indexType);
    
    	if(index[i][1] == indexType)
    	{
    		selected = true;
    	}
    	else
    		selected = false;
		addOption(document.getElementById("indextype"), index[i][0], index[i][1],selected);
	}
} 

function addOption(selectbox,text,value,selected )
{	
	var optn = document.createElement("OPTION");
	optn.text = text;
	optn.value = value;
	optn.selected = selected;
	selectbox.options.add(optn);
}
	
function validateForm()
{	

	if(document.getElementById('companyName').value == "" ) 
	{
		alert("Enter Company Name Field.");
		return false;		
	}

	 var valueChange = 'no';
	 if(document.getElementById('companyName').value != '<%=hashMap.get("companyName")%>'){
    	valueChange = 'yes';
    }
    <%String address1 = (String)hashMap.get("address1");
      if(address1 == null) address1="";	
    %>
    if(document.getElementById('address1').value != '<%=address1%>'){
    	valueChange = 'yes';
    }
    <%String address2 = (String)hashMap.get("address2");
      if(address2 == null) address2="";	
    %>
    if(document.getElementById('address2').value != '<%=address2%>'){
    	valueChange = 'yes';
    }
    <%String city = (String)hashMap.get("city");
      if(city == null) city="";	
    %>
    if(document.getElementById('city').value != '<%=city%>'){
    	valueChange = 'yes';
    }
    
       
    <%String companyState = (String)hashMap.get("stateList");
      if(companyState == null) companyState="";	
    %>
    if(document.getElementById('state').value != '<%=companyState%>'){
    	valueChange = 'yes';
    }
    
    <%String zip = (String)hashMap.get("zip");
      if(zip == null) zip="";	
    %>
    if(document.getElementById('zip').value != '<%=zip%>'){
    	valueChange = 'yes';
    } 
       
   
    if(valueChange == 'no'){
    	document.getElementById('noChangeMsg').style.display = 'block';    
    } else {
    	document.getElementById('button2').disabled = true;
    	document.registrationForm.submit();
    }	
    
}

</script>
		<div id="err" class="success_msg" style ='display:none;'>
		<%=successMsg %>
		</div>
		<div id ="noChangeMsg" style ="display:none;">
			No Changes Occurred.
		</div>

		</b>	

<form name="registrationForm" method="post" action="./CompanyProfile"  >
		
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Company Details
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body" style="padding: 20px 0px;">
      <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
	  	<div class="card-body card-padding" style="background-color:#EDECEC;min-height: 200px;">
        <table width="100%" border="0" align="center" style="border-collapse: separate; border-spacing: 10px;">
				<tr>
				  <td  ><div class="requiredStar">* Required</div></td>
				  <td align="left">&nbsp;</td>
				  <td  >&nbsp;</td>
				  <td align="left">&nbsp;</td>
		  </tr>
		  <tr>
				
				<td width="25%"  ><p>Company Name <span class="requiredStar">*</span></p></td>				
				<td align="left">	
				<% String strValue = (String) hashMap.get("companyName"); if(strValue== null) strValue="";  %>				
				<input  disabled size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"  type="text" id="companyName" name="companyName"  value="<%=strValue %>" maxlength="150" tabindex="1" />  </td>
		 </tr>
		
          
		<tr>
			<td>
		    <p>Street Address</p></td>
				 
			<td align="left">
		    <% strValue = (String) hashMap.get("address1"); if(strValue== null) strValue=""; %>
		   	<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="address1" name="address1"  maxlength="150"  value="<%=strValue %>" tabindex="2"/>
		   	<span class="Star">&nbsp;</span>
		   	</td>		   			  		  
		</tr>
		<tr>
		<td><p>&nbsp;</p></td>
		 
	     <td align="left">
				<%  strValue = (String) hashMap.get("address2"); if(strValue== null) strValue="";  %>
				<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="address2" name="address2" value="<%=strValue %>"   tabindex="3" />	</td>	
					
		</tr>
		
		 <tr>
		 	<td><p>City</p></td>				
	 		<td align="left">	
	 			<% strValue = (String) hashMap.get("city"); if(strValue== null) strValue="";  %>							
				<input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"  type="text" id="city" name="city" maxlength="10" value="<%=strValue %>" tabindex="4" />
			</td>
		 </tr>
		 
		<tr>
		<td ><p>State </p></td>			
		  	<td  align="left">
		  	<select style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);width: 304px;"  id="state" name="state" tabindex="5" >
            	<%=hashMap.get("stateList") %>
            </select>
            </td>
		</tr>
		<tr>
		  <td width="123">	  
		   <p>ZIP</p></td>
				 
		   <td width="328" align="left"><% strValue = (String) hashMap.get("zip"); if(strValue== null) strValue="";  %>
		    <% strValue = (String) hashMap.get("zip"); if(strValue== null) strValue=""; %>
	       <input size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="zip" name="zip" maxlength="5" value="<%=strValue %>"  tabindex="6"/></td>		
		</tr>
		
		</table>
		</div>
		</div>
	   </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a  role="button" data-toggle="collapse"  href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          Indexing Information
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body" style="padding: 20px 0px;">
      <div class="card" style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
	  	<div class="card-body card-padding" style="background-color:#EDECEC;min-height: 120px;">
      
        <table width="100%" border="0" align="center">
			<tr>
				<td width="25%"  ><p>Default Index Type  <span class="requiredStar">*</span></p></td>				
				<td width="75%" align="left">	
					<select style='font-size:11px;font-family: Verdana;width: 300px' id="indextype" name="indextype" size="4" >   
	  				</select>
				</td >
		    </tr>    
		    <tr>
		
		 <td colspan="2">
		 
		     <input type="hidden" name="sessionid" value="<%=(String)request.getSession().getAttribute("sessionid") %>" />
		     <input type="hidden" name="userid" value="<%=request.getSession().getAttribute("userid") %>" />
		     <input type="hidden" name="comid" value="<%=request.getSession().getAttribute("comid").toString() %>" />
		     		  
	       </td>
	
		</tr>			      
		</table>
		</div>
		</div>
		
								
		
	 </div>
    </div>
  </div>
  <div align="right" style="padding:20px">
			<input type="button" name="button2" id="button2" onclick="javascript:validateForm();"
					value='Save' style="margin-right:10px"
					class="btn btn-success"  />		     
		     
		     <input type="button" name="button" id="button"
					value='Cancel' class="btn btn-warning" onclick="javascript:oncancel()" />		
		</div>
</div>
		


</form>		

</body>
</html>

