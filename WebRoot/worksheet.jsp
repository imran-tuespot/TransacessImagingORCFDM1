<!-- Header image and css/js will be included by sitemesh decorator (/WEB-INF/decorators.xml)-->

<html>
    <head>
        <title>Worksheet JMesa Example</title>
         <script type="text/javascript" src="js/jquery-1.3.min.js" ></script>
		<script type="text/javascript" src="js/jquery.jmesa.js"></script>
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		
		<link rel="stylesheet" type="text/css" href="css/styleSheet.css"></link>
		
		 <!-- jmesa css -->
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" type="text/css" href="css/example.css"></link>

      <!-- blueprint framework 
      <link rel="stylesheet" href="css/bp/custom_screen.css" type="text/css" media="screen, projection">
      <link rel="stylesheet" href="css/bp/print.css" type="text/css" media="print">
      <link rel="stylesheet" href="css/bp/fancy-type/screen.css" type="text/css" media="screen, projection">-->
      
    </head>
    
    <body>
	<jsp:include page="includes/sessionHeader.jsp" />

                <hr class="space"/>

        <p>
            ${saveResults}
        </p>

        <form name="presidentsForm" id="presidentsForm" action="/NewDocTypeController">
            <!-- required in PresidentController and to put "active" css class on hyperlink of current example (/decorators/main.jsp) -->
            <input type="hidden" name="type" value="worksheet"/>

            ${presidents}
        </form>

        <hr class="space"/>
        
        <script type="text/javascript">
            function onInvokeAction(id) {
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }

            // custom validation
            function validateFirstName(val) {
               if (val == 'foo') {
                  return false;
               }

               return true;
            }
        </script>
    </body>
</html>
