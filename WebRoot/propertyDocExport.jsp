<!-- Header image and css/js will be included by sitemesh decorator (/WEB-INF/decorators.xml)-->

<html>
    
    <head>
        <title>Property Document Report</title>
        <!-- <script type="text/javascript" src="js/jquery-1.3.min.js" ></script>-->
       	<script src="js/jQuery/jquery-1.8.2.min.js"></script>       
		<script type="text/javascript" src="js/jquery.jmesa.js"></script>
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		
		 <!-- jmesa css -->
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
	
      
      
		<jsp:include page="includes/sessionHeader.jsp" />
		
		<% 
   
		  String sessionid = request.getSession().getAttribute("sessionid").toString();
		  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
		   											
		%>
 
		  <script type="text/javascript">
            function onInvokeAction(id) {
                $.jmesa.setExportToLimit(id, '');
               // $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
               
               var parameterString = $.jmesa.createParameterStringForLimit(id);
                var propertyId = '<%=request.getAttribute("propertyId")%>';
                location.href = './PropertyDocumentReport?type=propertyDocExport&propertyId='+propertyId +'&'+ parameterString;
            }
            function onInvokeExportAction(id) {
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                var propertyId = '<%=request.getAttribute("propertyId")%>';
                location.href = './PropertyDocumentReport?type=propertyDocExport&propertyId='+propertyId +'&'+ parameterString;
                
            }            
            
        </script>
		
    </head>

<body onLoad="getPropertyValues('propertyId')">

	<form name="presidentsForm" action="./PropertyDocumentReport" method="get">
		<!--  <input type="hidden" name="type" value="propertyDocExport"/>
            
            Property ID :<input id="propertyId" name="propertyId" />
            
            <input type="submit" name="submit" value="Submit"/>
            <div style='overflow:auto; width:850px;'>
            	${properties}
            </div>-->



		<div align="center" style="margin:20px;overflow: auto;">
			<p
				style="color:green;font-size:16px;text-align: left;margin-bottom:10px;">
				<i class="zmdi_large zmdi-present-to-all"></i>Documents List for a Property
			</p>

			<div class="card"
				style="width: 95%; margin: 20px 30px 20px 20px; padding-left: 0px;">
				<div class="card-body card-padding"
					style="padding: 16px 6px 0px;background-color:#EDECEC;margin-bottom: 20px;">
					<table class="table" cellspacing="0">
						<tbody>

							<tr>
								<td>Property ID</td>
					
								<td><input id="propertyId" name="propertyId" size="50"
									style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"
									type="text">
									
									<!-- <select class="selectText" style="overflow:auto;width:250px;" id="propertyId" name="propertyId">
										<option value="Any"></option>
									</select>-->
								</td>


							</tr>
							<tr>
								<td style="text-align: right;" colspan="2"><input
									class="btn btn-success waves-effect waves-button waves-float"
									style="margin-right: 15px;" type="submit" name="submit"
									value="Submit"> <input
									class="btn btn-warning waves-effect waves-button waves-float"
									type="button" name="cancel" value="Cancel"
									onClick="javascript:oncancel();" /></td>

								<td></td>

							</tr>

						</tbody>
					</table>
				</div>
			</div>


		
				<div style="overflow: auto; width: 780px; float: left; margin-left: 20px;">${properties}</div>
		
		<input type="hidden" name="type" value="propertyDocExport"/>
		</div>
	</form>
	<script type="text/javascript" src="js/jquery.mockjax.js"></script>
    <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
    <script type="text/javascript" src="js/getPropertyValue.js"></script>
    
</body>

</html>
