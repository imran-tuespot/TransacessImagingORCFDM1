<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.*"%>

<html>
	<head>
	<script type="text/javascript" src="js/jquery-1.3.min.js" ></script>
		<script type="text/javascript" src="js/jquery.jmesa.js"></script>
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>
	<script type="text/javascript" src="js/jquery.canvasjs.min.js"></script>
<script type="text/javascript">
	function initial_load(){
	 var chart = new CanvasJS.Chart("chartContainer", {
		theme: "theme2",//theme1
		title:{
			text: "Property IDs for Managers - Report"              
		},
		animationEnabled: true,   // change to true
		data: [              
		{
			// Change type to "bar", "splineArea", "area", "spline", "pie",etc.
			type: "pie",
			dataPoints: [
				{ label: "Steve Evans",  y: 10  },
				{ label: "Karl Robinson", y: 15  },
				{ label: "Justin Edinburgh", y: 25  },
				{ label: "Joe Clark",  y: 30  },
				{ label: "Phil Brown",  y: 28  },
				{ label: "Robert Brown",  y: 21  },
				{ label: "Donna Pickens",  y: 18  }
				
				
			]
		}
		]
	});
	chart.render();
	 document.getElementById('reportImg').src = "images/ReportDisabled.png";
	 document.getElementById('reportGraphImg').src = "images/ReportGraphActive.png";	
	 		 $('#flip-container').quickFlipper({ }, 1, 1);
	 
}
function tabContent0()
{
		 document.getElementById('reportImg').src = "images/ReportActive.png";
		 document.getElementById('reportGraphImg').src = "images/ReportGraphDisabled.png";		 
		
		 $('#flip-container').quickFlipper({ }, 0, 1);
		
		
}
function tabContent1()
{
 	
		
		 document.getElementById('reportImg').src = "images/ReportDisabled.png";
		 document.getElementById('reportGraphImg').src = "images/ReportGraphActive.png";	
		
		 $('#flip-container').quickFlipper({ }, 1, 1);
		
}
 function onInvokeAction(id) {
     $.jmesa.setExportToLimit(id, '');
     $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
 }
 function onInvokeExportAction(id) {
     var parameterString = $.jmesa.createParameterStringForLimit(id);
     location.href = 'PresidentController?type=basicExport&' + parameterString;
 }
</script>
<style type="text/css">
	
		/*#flip-tabs{  
		    width:800px;  
		    position:relative;  
		}  
		#flip-navigation{  
		    list-style:none;  
		    margin: 0px 0px 8px;
		    padding: 6px 0px 8px;
		    text-align: left;
		    width: 800px;
		
		}  
		#flip-navigation li{   
		    display:inline;   
		}  
		#flip-navigation li a{  
		    text-decoration:none;    
		    margin-right:0px;  
		    background:#f9f9f9;  
		    color:#333; outline:none;  
		    font-family:Arial;font-weight:bold; font-size:9px; text-transform:uppercase;  
		}  
		#flip-navigation li a:hover{  
		    background:#999;   
		    color:#f0f0f0;  
		}  
		#flip-navigation li.selected a{  
		    background:#999;  
		    color:#f0f0f0;  
		}  
		#flip-container{    
		    width:800px;  
		    font-family:Geneva,Arial,Helvetica,sans-serif;
		    font-size:0.8em;  
		}  
		#flip-container div{   
		}  */
				
		</style>
		<title>Property Report</title>
		<meta name="pageHeading" content='Imaging Registration' />
		
		<jsp:include page="includes/sessionHeader.jsp" />
		
	</head>

	<body>
	<div id="flip-tabs" >  
        <ul id="flip-navigation" >  
              <li class="selected"><a href="#content" onclick="javascript:tabContent0()" id="tab-0"  ><img id="reportImg" src="images/ReportActive.png" width="195px;" height="70px;"/></a></li>  
              <li><a href="#folderTab" id="tab-1" onclick="javascript:initial_load()"><img id="reportGraphImg" src="images/ReportGraphDisabled.png" width="195px;" height="70px;"/></a></li>  
                                   
        </ul>  
        
        <form name="presidentsForm" action="./PresidentController">
        
        <div id="flip-container" >  
             
					<div  id="content"> <!--  Content for First tab -->
						<p>Content for first tab</p>
						 <input type="hidden" name="type" value="basicExport"/>

            			${presidents}
					</div>
					<div  id="folderTab" > <!--  Content for Secon tab -->
						<div id="chartContainer" style="height: 300px; width: 100%;"></div>						
					</div>				
					
			
		</div>
		</form>	
		</div>
	

</body>
</html>

