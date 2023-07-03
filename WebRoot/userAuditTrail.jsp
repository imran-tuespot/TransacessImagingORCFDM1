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
    <link rel="stylesheet" href="css/bubble-tooltip.css" media="screen"/>
    <link rel="stylesheet" type="text/css" href="css/jmesa.css" />
    <script src="js/jQuery/jquery-1.8.2.min.js"></script>  
    <!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>  
    	
    	<script type="text/javascript" src="js/jquery.jmesa.js"></script>
		<script src="jscript/jquery-ui.js"></script>
    
    <script type="text/javascript" src="js/calendarDateInput.js"></script>
    <script type="text/javascript" src="js/bubble-tooltip.js"></script>
    <script type="text/javascript" src="js/jmesa.js"></script>
    
   <!-- <script type="text/javascript" src="js/jquery-1.2.2.pack.js"></script>
    <script src="https://code.jquery.com/jquery-1.8.2.min.js"></script>-->
    <script src="js/jquery.popupoverlay.js"></script>
     <%
     System.out.println("Inside userAudit");
        /*String sessionid = request.getAttribute("sessionid").toString();
        int comid = Integer.parseInt(request.getAttribute("comid").toString());*/
        String sessionid = (String)request.getSession().getAttribute("sessionid");
        System.out.println("session id------> "+sessionid);
        int comid = Integer.parseInt(request.getSession().getAttribute("comid").toString());
        System.out.println("comid------> "+comid);
        
    %>
 <jsp:include page="includes/sessionHeader.jsp"/>
   
    <script language="javascript">

    function initialLoad() {
    // Initialize the plugin
      $('#my_popup').popup({color:'#000'});
    $.jmesa.addTableFacade('formId');
	$.jmesa.setMaxRowsToLimit('formId','12');
	$.jmesa.setPageToLimit('formId','1');
	$.jmesa.setOnInvokeAction('formId','onInvokeAction');
	$.jmesa.setOnInvokeExportAction('formId','onInvokeExportAction');
	
        setHeader("userAuditTrail.jsp");
        //Initialize slider menu
      	$('#simple-menu').sidr();
      
	  	$('.child').hide();
	  	$('.parent').click(function() {
		 	$('.child').slideUp();
		 	$(this).find('ul').slideToggle();
	  	});
	  	$('#reportsLi').click();
      
    }

        var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object

        function onInvokeAction(id,action5) {
            var parameterString = createParameterStringForLimit(id);
            getListing(parameterString);
        }

        function getfiles() {
            getListing("");
        }

        function getListing(query) {
            var queryString = buildQueryString();

            if (query.length > 0) {
                queryString = queryString + "&" + query;
            }

            //msgbox_visible(true);
            $('#my_popup').popup('show');
            
            if (xmlhttp) {
                xmlhttp.open("POST", "UserAuditTrail", true);
                xmlhttp.onreadystatechange = handleResponse;
                xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                xmlhttp.send(queryString);
            }
        }

        function buildQueryString() {
            var type = document.getElementById('type').value;
            var startDate = document.getElementsByName('startDate')[0].value;
            var endDate = document.getElementsByName('endDate')[0].value;
            var comid = document.getElementById('comid').value;
            var sessionid = document.getElementById('sessionid').value;

            document.getElementById('type1').value = type;
            document.getElementById('startDate1').value = startDate;
            document.getElementById('endDate1').value = endDate;

            return "startDate=" + startDate + "&endDate=" + endDate + "&type=" + type + "&comid=" + comid +
                    "&sessionid=" + sessionid;

        }

        function handleResponse() {
            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {
                    // alert(xmlhttp.responseText);
                    if (xmlhttp.responseText == "expired") {
                        //msgbox_visible(false);
                        $('#my_popup').popup('hide');
                        
                        window.location = "index.jsp";
                        $("#results").html(data)
                    } else {
                        DisplayData(xmlhttp.responseText);
                    }
                }
                else {
                    alert(xmlhttp.status);
                }
            }
        }

        function DisplayData(data)
        {
            var initTable = "";
            initTable +="<form name='dynFormNm' id='dynFormId' method='POST' >";
            initTable +=data;
            initTable +="</form>";

            pdfButton_visible(true);
            //msgbox_visible(false);
            $('#my_popup').popup('hide');
            
            var obj =  document.getElementById("results");
            obj.innerHTML = initTable;
        }

        function msgbox_visible(val) {
            var e = document.getElementById('messagewindow');
            if (val == true) {
                e.style.display = 'block';
            } else {
                e.style.display = 'none';
            }
        }

        function pdfButton_visible(val) {
            var e = document.getElementById('BuildPDF');
            if (val == true) {
                e.style.display = 'block';
            } else {
                e.style.display = 'none';
            }
        }

        function getXMLObject()  //XML OBJECT
        {
           var xmlHttp = false;
           try {
             xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
           }
           catch (e) {
             try {
               xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
             }
             catch (e2) {
               xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
             }
           }
           if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
             xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
           }
           return xmlHttp;  // Mandatory Statement returning the ajax object created
        }
       
    </script>

   
   
</head>


<body onLoad="initialLoad()">


<!-- Add content to the popup -->
  <div id="my_popup">
	<div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em; opacity: 1; visibility: visible; display: inline-block; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
    <h4><i class="zmdi_large zmdi-settings zmdi-hc-spin"></i>Loading Contents...Please Wait...</h4>
    <p style="margin-left:40px;margin-bottom: 0px">It will take few seconds.</p>
    <p style="margin-left:40px;margin-bottom: 0px">Please wait while the contents are loading.</p>
    
	</div>
	
  </div>

<form action="javascript:onsubmitform();">
<div class="card" style="width: 95%; padding-left: 0px;padding-top:20px;">
			<div class="card-body card-padding" style="background-color: rgb(237, 236, 236);">
    <table>
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
            <td align="right">Type:</td>
            <td align="left">
                <select name="type" id="type">
                    <option value="1">Updated Records</option>
                    <option value="2">New Records</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center" style="padding-top:20px;">
                <input class="btn btn-success waves-effect waves-button waves-float" type="submit" onClick="javascript:getfiles()" name="searchButton" id="searchButton" value="Search Audit Records">
            </td>
        </tr>
    </table>
    </div>
    </div>
    <input type="hidden" id="comid" name="comid" value="<%=comid%>"/>
    <input type="hidden" id="sessionid" name="sessionid" value="<%=sessionid%>"/>
    <input type="hidden" id="confirmParam" name="confirmParam"/>
</form>

<div id="BuildPDF" style="DISPLAY: none; ">
<form action="UserAuditTrailPdf" method="POST">
    <table>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" class="btn btn-warning waves-effect waves-button waves-float" name="BuildPDFButton" value="Download PDF File">
            </td>
        </tr>
    </table>
    <input type="hidden" id="endDate1" name="endDate" value=""/>
    <input type="hidden" id="startDate1" name="startDate" value=""/>
    <input type="hidden" id="type1" name="type" value=""/>
    <input type="hidden" id="comid1" name="comid" value="<%=comid%>"/>
    <input type="hidden" id="sessionid1" name="sessionid" value="<%=sessionid%>"/>
    <input type="hidden" id="confirmParam1" name="confirmParam"/>
</form>
</div>

<td valign="top" align="center"><!-- <script type="text/javascript" >
	addTableFacadeToManager('formId');
	setMaxRowsToLimit('formId','25');
	setPageToLimit('formId','2');
</script> -->

<div class=messagewindow id=messagewindow
     style="DISPLAY: none; MARGIN: 0px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 60%; z-index: 4; text-align: center;">
    <h4>
        Retrieving data.. Please wait.
    </h4>
    <IMG src="images/progress.gif" width="32" height="32" alt=""/>
</div>

<div id="results">
</div>

</body>

</html>
