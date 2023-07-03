<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link href="assets/css/style.css" rel="stylesheet" />
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>	
		<style type="text/css">
		.mrgcls{
		padding: 0;
    padding-bottom: 18px;}
    .row{min-height:260px;}
		</style>
<title>Insert title here</title>
<% 
if(request.getSession().getAttribute("appuserrole")!=null){
	 javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String URL = (String) ctx.lookup("java:comp/env/URL");
	%>
	

<script language="javascript">
$(document).mousemove(function(event){
	  InitializeTimer();
});
function initial_load() {
	
	setHeader('Training.jsp');
	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
	if(array_of_li[i].textContent.trim()=='Training'){
		array_of_li[i].setAttribute("class", "active");	
	} 
	}
	
}

function openWindow(){
  window.open('<%=URL%>'+"MultiFamily_User_Manual_v10.pdf","_blank","toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=600,height=400");
}
</script>


</head>
<body onLoad="initial_load()" >
 <div class="panel-group" id="accordion" style="text-align: left;">
 <div class="panel panel-default">
                            <div class="panel-heading">
                               <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                        &nbsp;<span style="color: #0A68B4;"><b> Helpful Document(s)</b></span></a>
                                </h5>
                            </div>
                            <div id="collapse1" class="panel-collapse collapse">
                                <div class="panel-body">
                                <ul>
                                <li>
                                 <a class="cursorpointer" onclick="javascript:openWindow();">User Manual</a>
                               
                                </li>
                                </ul>
                                </div>
                            </div>
                        </div>
                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               <h5 class="panel-heading-small">
                                    <a style="color: #0A68B4;" data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                                        &nbsp; <b>Helpful Video(s)</b></a>
                                </h5>
                            </div>
            
            
            
            
            
            
            
            
            
            
			<div id="collapse2" class="panel-collapse collapse">
                                <div class="panel-body">
                                
                                
                                     <div class="row">
                                 <div class="container">
                                 
                                
                                
                                <div padding=0 class="mrgcls col-lg-5 col-md-5 col-sm-6">
				<video width="100%" poster="images/RU-Tmbl1.bmp" controls> <source
					src="images/Using_Multifactor_Authentication_2021.mp4" type="video/mp4">
				<source src="movie.ogg" type="video/ogg"> Your browser does	not support the video tag. </video>
			</div>
                                
             
  <div class="col-lg-4 col-md-4 col-sm-6">
  <br><br><br>
<div align="center" style="margin:7px"><h3>Signing-On Using Multifactor Authentication</h3></div>
<br>
<div align="center"><p align="left" style="font-size:100%;">This tutorial video will walk users through the steps of signing into Multifamily TransAccess using Multifactor Authentication.
</p></div>
</div>      
     </div> 
     </div> 
                                
                                
                               <div class="row">
                                 <div class="container">
                                 
                                
                                
                                <div padding=0 class="mrgcls col-lg-5 col-md-5 col-sm-6">
				<video width="100%" poster="images/RU-Tmbl1.bmp" controls> <source
					src="images/Record_Uploading_2021.mp4" type="video/mp4">
				<source src="movie.ogg" type="video/ogg"> Your browser does
				not support the video tag. </video>
			</div>
                                
             
  <div class="col-lg-4 col-md-4 col-sm-6">
  <br><br><br>
<div align="center" style="margin:7px"><h3>Record Uploading Tutorial</h3></div>
<br>
<div align="center"><p align="left" style="font-size:100%;">This tutorial video will assist users by providing them with the basics for uploading records within TransAccess.</p></div>
</div>      
     </div> 
     </div>        
	<div class="row" height=250>
      <div class="container">
        <div padding=0 class="mrgcls col-lg-5 col-md-5 col-sm-6">
				<video width="100%" poster="images/RU-Tmbl1.bmp" controls> <source
					src="images/Record_Searching_2021.mp4" type="video/mp4">
				<source src="movie.ogg" type="video/ogg"> Your browser does
				not support the video tag. </video>
		</div>
		 <div class="col-lg-4 col-md-4 col-sm-6">
		 <br><br><br>
<div align="center" style="margin:7px"><h3>Record Retrieval Tutorial</h3></div>
<br>
<div align="center"><p align="left" style="font-size:100%;">
This tutorial video will walk users through the 4 search methods that are used for retrieving your uploaded records within TransAccess.</p>
</div>
</div>      
     </div> 
     </div>  
     <div class="row" height=250>
      <div class="container">
        <div padding=0 class="mrgcls col-lg-5 col-md-5 col-sm-6">
				<video width="100%" poster="images/RU-Tmbl1.bmp" controls> <source
					src="videos/Record_Removal_Demo.mp4" type="video/mp4">
				<source src="movie.ogg" type="video/ogg"> Your browser does
				not support the video tag. </video>
		</div>
		 <div class="col-lg-4 col-md-4 col-sm-6">
		 <br><br><br>
<div align="center" style="margin:7px"><h3>Errant Record Removal</h3></div>
<br>
<div align="center"><p align="left" style="font-size:100%;">
 This tutorial video will assist users by demonstrating the complete process of submitting an Errant Record Removal request. 
</p>
</div>
</div>      
     </div> 
     </div>
		<!-- 	<div class="row" height=250>
      <div class="container">
        <div padding=0 class="mrgcls col-lg-5 col-md-5 col-sm-6">
				<video width="100%"  controls> <source
					src="videos/Intro_LoginTutorial.mp4" type="video/mp4">
				<source src="movie.ogg" type="video/ogg"> Your browser does
				not support the video tag. </video>
			</div>
			 <div class="col-lg-4 col-md-4 col-sm-6">
			 <br><br><br>
<div align="center" style="margin:7px"><h3>Intro & Login Tutorial</h3></div>
<br>
<div align="center"><p align="left" style="font-size:100%;">
This tutorial video will introduce users to the login screen for TransAccess, and go through the process of resetting a password.</p>
</div>
</div>      
     </div> 
     </div>  -->
			<div class="row" height=250>
      <div class="container">
        <div padding=0 class="mrgcls col-lg-5 col-md-5 col-sm-6">
				<video width="100%" poster="images/RU-Tmbl1.bmp" controls> <source
					src="images/Dashboard_Navigation 2021.mp4" type="video/mp4">
				<source src="movie.ogg" type="video/ogg"> Your browser does
				not support the video tag. </video>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
			<br><br><br>
<div align="center" style="margin:13px"><h3>Dashboard Navigation Tutorial</h3></div>
<br>
<div align="center"><p align="left" style="font-size:100%;">
This tutorial video will briefly visit each tab available within TransAccess.</p>
</div>
</div>      
     </div> 
     </div> 
			
                                </div>
                            </div>
                        </div>
                        </div>
                        

</body>
<%}else{
	response.sendRedirect("index.jsp");
} %>
</html>