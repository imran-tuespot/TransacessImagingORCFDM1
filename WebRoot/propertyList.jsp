<!-- Header image and css/js will be included by sitemesh decorator (/WEB-INF/decorators.xml)-->

<html>
    <head>
        <title>Worksheet JMesa Example</title>
        <!--  <script type="text/javascript" src="js/jquery-1.3.min.js" ></script>-->
        <script src="js/jQuery/jquery-1.8.2.min.js"></script>   
        <!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	     
		<script type="text/javascript" src="js/jquery.jmesa.js"></script>
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		
		<link rel="stylesheet" type="text/css" href="css/styleSheet.css"></link>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		 <!-- jmesa css -->
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" type="text/css" href="css/example.css"></link>
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />  

     
      	<jsp:include page="includes/sessionHeader.jsp" />
      <script type="text/javascript">
      $(document).ready(function () {
		
		setHeader('propertyList.jsp');	
		//Initialize slider menu
      	$('#simple-menu').sidr();
      
	  	$('.child').hide();
	  	$('.parent').click(function() {
		 	$('.child').slideUp();
		 	$(this).find('ul').slideToggle();
	  	});
	  	//$('#adminWizardLi').click();	 	
	  	$("#adminWizardLi").collapse('toggle');
				
		});
      
      
      </script>
    </head>
    
    <body>
		
		
        <form name="propertyListForm" id="propertyListForm" action="PropertyList">
            <input type="hidden" name="type" value="worksheet"/>            
            
            <div style='overflow:auto; width:850px;'>
            	${propertyList}
            </div>             
            
        </form>

    
        <script type="text/javascript">
        	function getDetails(id, sessionid){
        		document.propertyListForm.method="post";
    			document.propertyListForm.action = "editProperty.jsp?sessionid="+sessionid+"&id="+id;
    			document.propertyListForm.submit(); 
        	}
        	
        	function removeProperty(id, sessionid){
        		if(confirm('Are you sure you want to remove this property?')){
        		
        			document.propertyListForm.method="post";
    				document.propertyListForm.action = "PropertyList?sessionid="+sessionid+"&id="+id+"&remove=yes";
    				document.propertyListForm.submit();
        		}
        		 
        	}
        
            function onInvokeAction(id) {
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
			
			            
        </script>
    </body>
</html>
