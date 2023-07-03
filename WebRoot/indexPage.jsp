<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Landing page</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="css/app.css"></link>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <script src="js/jQuery/1.11.3/jquery.min.js"></script> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>
<link
	href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" />

<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<script
	src="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.4.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.flash.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.print.min.js"></script>
<script src="js/jQuery/jquery-ui.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->




<script>
    
    
function selectActiveClass(){
	//alert("select")
	//selectActiveClass();
	$("#loanTypePropertyList .divSelecttt button").on("click", function() {
	//	alert("type")
		//$(this).removeClass("active");
		 $("#loanTypePropertyList .divSelecttt button").removeClass("active");
	
		$(this).addClass("active");
	//	alert("iiiii")
		
    });
}

 
    function display(data) {
    	$.each(data.getPropertyList, function(i, item) {
    		if(!item.city){
    			item.city='';
    		}else(item.city=='null' || item.city=="null" || item.city==null)?item.city='':item.city;
    		
    		
    		if(!item.state){
    			item.state='';
    		}else(item.state=='null' || item.state=="null" || item.state==null)?item.state='':item.state;
    		
    		
    		if(!item.zip){
    			item.zip='';
    		}else(item.zip=='null' || item.zip=="null" || item.zip==null)?item.zip='':item.zip;
    		
    		
 		   item.propertyStatus ==null?item.propertyStatus='':item.propertyStatus; 
 			$('#propertyList').append('<tr><td><a id="editC" onclick="hello(\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');" href="#myModal">'+item.propertyName+'</a></td><td><a id="editA" onclick="hello(\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');">'+item.propertyId+'</a></td><td><a id="editB" onclick="hello12(\''+item.propertyId+'\',\''+item.propertyName+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');">'+item.fhaNumber+'</a></td><td>'+item.city+'</td><td>'+item.state+'</td><td>'+item.zip+'</td><td>'+item.loanType+'</td><td>'+item.propertyStatus+'</td></tr>');
    	});
    }
    function hello(propertyId,propertyName,fhaNumber,loanType){
    	
        var randomnumber = Math.floor((Math.random()*100)+1); 
        window.open("propertyDataSearch.jsp?propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=1000,height=500');

    }

    function hello12(propertyId,propertyName,fhaNumber,loanType){
    	
    	/* var res = id + "\\" +type;
    	
    	alert("res"+res);
    	 */

    	 var randomnumber = Math.floor((Math.random()*1000)+1); 
    	    window.open("propertyDataSearch.jsp?propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=1000,height=500');

    }

    
    </script>



<!-- Get roles and rights -->




<!-- Include the Sidr JS -->
<script src="js/jquery.sidr.min.js"></script>

<script src="jscript/jquery.easing.js" type="text/javascript"></script>
<!-- <script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" /> -->
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />

</head>
<DIV id=preview_div
	style="DISPLAY: none; POSITION: absolute; BORDER-LEFT-COLOR: #777777"></DIV>


<body>


	<!--- content Part --->
	<section>

	<div class="container-fluid">
		<div class="row" style="border: 1px solid #a5a1a1;">
		
			<div class="col-lg-12"
				style="margin-top: 30px; margin-bottom: 20px; color: #ff9900; font-size: 22px; font-weight: bold; text-transform: capitalize;">
				<div class="text-center"></div>
			</div>






		</div>
	</div>



	</div>








	<!--- Part3 - Search Results---->
	<div id="searchResults" class="borderAll">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="row">

						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div id="tableStyle1" style="display: none;">

								<div class="table-responsive">
									<br />
									<table id="searchResTable" class="table table-bordered">
										<thead>
											<tr>
												<th>Property Name</th>
												<th>Property ID</th>
												<th>Associated FHA Number</th>
												<th>City</th>
												<th>State</th>
												<th>Zip</th>
												<th>Type of Loan</th>
												<th>Property Status</th>
											</tr>
										</thead>
										<tbody id="propertyList">
											<!-- 	<tr>
													<td class="color-blue">1</td>
													<td class="color-blue">1</td>
													<td class="color-blue">1</td>
													<td>1</td>
													<td>1</td>
													<td>1</td>
													<td>1</td>
												</tr> -->
										</tbody>
									</table>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!--- Part3 - Search Results----> </section>

	<script>


    $(document).ready(function(){
    	 $(document).mousemove(function(event){
   		  InitializeTimer();
   	  });
    	
    	var uri = window.location.toString();
    	if (uri.indexOf("?") > 0) {
    	    var clean_uri = uri.substring(0, uri.indexOf("?"));
    	    window.history.replaceState({}, document.title, clean_uri);
    	}
    	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
		for (var i = 0; i < array_of_li.length; i++) {
		if(i == 0)
			array_of_li[i].setAttribute("class", "active");	
			
		}
    	setHeader('indexPage.jsp');
    	$("#searchResults").hide();
    	
    	
    	
    
    
    

    
    </script>


</body>


</html>