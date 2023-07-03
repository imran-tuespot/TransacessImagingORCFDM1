<html>
    
    <head>
        <title>Basic JMesa Example</title>
        <script type="text/javascript" src="js/jquery-1.3.min.js" ></script>
		<script type="text/javascript" src="js/jquery.jmesa.js"></script>
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		
		<link rel="stylesheet" type="text/css" href="css/styleSheet.css"></link>
		
		 <!-- jmesa css -->
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" type="text/css" href="css/example.css"></link>

      <!-- blueprint framework -->
      <link rel="stylesheet" href="css/bp/custom_screen.css" type="text/css" media="screen, projection">
      <link rel="stylesheet" href="css/bp/print.css" type="text/css" media="print">
      <!--[if lt IE 8]><link rel="stylesheet" href="css/bp/ie.css" type="text/css" media="screen, projection"><![endif]-->
      <link rel="stylesheet" href="css/bp/fancy-type/screen.css" type="text/css" media="screen, projection">
      
      
		<jsp:include page="includes/sessionHeader.jsp" />
		  <script type="text/javascript">
		  	
            function onInvokeAction(id) {
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
            function onInvokeExportAction(id) {
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                location.href = 'PropertyController?type=basicExport&' + parameterString;
            }
        </script>
</head>
    
    <body>
	<div id="main">
		<div id="historyNavGrid" class="grid-12wide grid-noRgtMargin">
				<div class="contextBar">
					<table class="cb-table">
						<tbody>
							<tr>
								<td class="cb-left">
								<span cmp="true" id="comp-historyNav" class="comp-HistoryNav"> 
								<p class="navBreadcrumbs">
									<a href="">Admin</a>&nbsp;<span
										class="carrot"></span><a href="" >Property Reports</a>&nbsp;<span class="carrot"></span>
								</p>	
								</span>	
								</td>
							<td class="cb-right">
							<table class="pageTools" border="0" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<td class="print firstIcon"><a href="#" class="iLayerLink"
											onclick="javascript:jsCBDPrintPage();return false">
											<dl	class="icon">
													<dt class="linkIcon">&nbsp;</dt>
													<dd class="linkText">Print page&nbsp;&nbsp;</dd>
											</dl>
										</a>
										</td>
										<td class="download lastIcon"><a href="#"
											class="iLayerLink"
											onclick="jsCBDgoToUrl('/us/OfxWelcome');;return false"
											><dl class="icon">
													<dt class="linkIcon">&nbsp;</dt>
													<dd class="linkText">Download&nbsp;&nbsp;</dd>
												</dl>
										</a>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
						</tr>
						</tbody>
					</table>
				</div>
		</div>
		<div id="pageHeader">
				<h1 class="option2">Property Report</h1>
		</div>
		<div style="border-bottom: 1px solid #ccc"></div>

	</div>
	<strong class="large">Property List</strong>
        
        <form name="presidentsForm" action="./PropertyController" method="get">
            <!-- required in PresidentController and to put "active" css class on hyperlink of current example (/decorators/main.jsp) -->
            <input type="hidden" name="type" value="basicExport"/>

            ${presidents}
              <input type="submit" value="Submit">
        </form>
        
        <hr class="space"/>
        
      
        
    </body>
    
</html>
