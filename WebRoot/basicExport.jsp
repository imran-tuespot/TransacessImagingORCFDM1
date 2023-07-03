<!-- Header image and css/js will be included by sitemesh decorator (/WEB-INF/decorators.xml)-->

<html>
    
    <head>
        <title>Property Report</title>
        <!-- <script type="text/javascript" src="js/jquery-1.3.min.js" ></script>-->
        <script src="js/jQuery/jquery-1.8.2.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	
		<script type="text/javascript" src="js/jquery.jmesa.js"></script>
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		
		 <!-- jmesa css -->
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" type="text/css" href="css/example.css"></link>

      <!-- blueprint framework 
      <link rel="stylesheet" href="css/bp/custom_screen.css" type="text/css" media="screen, projection">
      <link rel="stylesheet" href="css/bp/print.css" type="text/css" media="print">-->
      <!--[if lt IE 8]><link rel="stylesheet" href="css/bp/ie.css" type="text/css" media="screen, projection"><![endif]-->
     <!--  <link rel="stylesheet" href="css/bp/fancy-type/screen.css" type="text/css" media="screen, projection">-->
      
      
		<jsp:include page="includes/sessionHeader.jsp" />
	
		
    </head>
    
    <body onLoad="initial_load()">
        
        <strong class="large">Property List</strong>
        
        <form name="presidentsForm" action="./PropertyReport" method="get">
            <!-- required in PresidentController and to put "active" css class on hyperlink of current example (/decorators/main.jsp) -->
            <input type="hidden" name="type" value="basicExport"/>
            
            <div style='overflow:auto; width:850px;'>
            	${properties}
            </div>
              
        </form>
        
        <hr class="space"/>
        
      	  <script type="text/javascript">
            function onInvokeAction(id) {
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
            function onInvokeExportAction(id) {
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                location.href = './PropertyReport?type=basicExport&' + parameterString;
            }
            function initial_load()
            {
            setHeader('basicExport.jsp');
      
		      //Initialize slider menu
		     	$('#simple-menu').sidr();
		      
			  	$('.child').hide();
			  	$('.parent').click(function() {
				 	$('.child').slideUp();
				 	$(this).find('ul').slideToggle();
			  	});
            }
        </script>
        
    </body>
    
</html>
