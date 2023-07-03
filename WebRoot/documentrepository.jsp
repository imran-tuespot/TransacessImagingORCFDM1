<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
		 <link href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" />
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css" rel="stylesheet" type="text/css" />
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
<title>Insert title here</title>

<%try{
if(request.getSession().getAttribute("appuserrole")!=null){
String appuserrole = (String)request.getSession().getAttribute("appuserrole");
  
   int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
   String sessionid = request.getSession().getAttribute("sessionid").toString();
   int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
   String userName = request.getSession().getAttribute("username").toString();
   String companyFullName=request.getSession().getAttribute("companyFullname").toString();
   javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");

   %>
   
</head>
<body onLoad="initial_load()">
 <section>
        <div class="container-fluid">
            <div class="row" style="height: 420px; border: 1px solid #a5a1a1;">
			<div class="col-lg-12 text-center" style="margin-top: 30px;margin-bottom: 20px;color: #ff9900;    font-size: 20px;
    height: 80px;font-weight: normal;text-transform: capitalize;">
				 <div class="child-search">
<!--                 <p>Welcome to Imaging HUD Repository <br>Gateway to HUD Office of Multifamily Housing Records <br> Please see the Full-Text Search Guide link below to learn about<br> advance full-text search techniques -->
<!--                 </p> -->
<!-- <p style="font-size:20px">Welcome to Imaging HUD Repository <br>Gateway to HUD Office of Multifamily Housing Records </p> -->
<div class="col-lg-12" style="margin-top: 5px;margin-bottom: 5px;color: #ff9900;font-size: 22px;font-weight: bold;text-transform: capitalize;">
				<div class="text-center">Welcome to Imaging HUD Repository</div>
				<div class="text-center">Gateway to HUD Office Of Multifamily Housing Records</div>
			</div>
<hr style="width:500px;margin-top:1px;    margin-bottom: 0px;">
<div style="margin-top: 20px;">
<img src="images/PPT.png " alt="PPT" style="width: 62px;     margin-left: -22%;position: absolute;  transform: skewY(350deg);"/>
<div> 

<p style="font-size: 12px;margin-top: 1px;color: black;font-family: 'roboto';margin-top: -13px;"> Having trouble finding some Records? Don't worry,<br> the Helpdesk is here to assist.</p>
    </div>   
    </div>          
            </div>
			</div>
			
               <br>   <br>  <br><br><br>
               <div style="margin-left: -24px;font-size: 10px;margin-top: 39px;"><br><br><br><button style="border:0;" disabled> <font color="orange" size="5px">Search Methods</font> </button></div>
                <div align=center class="col-lg-12 "><div class="search-links">
                <br>
                   <!--  <a href="">Full-Text Search Guide</a><br> -->
             <a href="IREMSDocumentSearch.jsp"  style="padding-right: 6px; border-left: 3px solid #0A68B4;font-weight:bold"> &nbsp;iREMS Record Search</a><br>
             <br> 
             <a href="searchByIREMSNo.jsp" style="padding-right: 6px; border-left: 3px solid #0A68B4;font-weight:bold">&nbsp; Search by iREMS#</a><br>
                       <br>
					<a href="fullTextSearchallIREMSDocuments.jsp"  style="padding-right: 6px; border-left: 3px solid #0A68B4;font-weight:bold">&nbsp;Full Text Search in all iREMS Records</a><br>   <br>
					<a href="fullTextSearchlimitedIREMS.jsp"  style="padding-right: 6px; border-left: 3px solid #0A68B4;font-weight:bold">&nbsp;Full Text Search limited to iREMS#</a><br>   <br>
					  <br>
					<!-- <a href="Policylibrarysearch.html">Policy Library Search</a><br>
					<a href="">Find IREMS Folder</a><br>
					<a href="">State Document Search</a><br>
					<a href="">FAF Bond Refunder Search</a><br>
					<a href="">Browse IREMS Documents</a><br>
					<a href="">Browse HNM Documents</a><br>
					<a href="">Browse State Documents</a><br>
					<a href="">Browse FAF Bond Refunder Documents</a><br> -->
                </div>
				
              <!--  <p class="reporting">reporting</p>-->
            </div>
        </div>
		</div>
		</div>
    </section>



<script>
$(document).mousemove(function(event){
	  InitializeTimer();
});
function initial_load() {
	
	
	setHeader('documentrepository.jsp');
	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
		 if(array_of_li[i].textContent.trim()=='Records Repository'){
				array_of_li[i].setAttribute("class", "active");	
			} 	
		
	}
	
}
    </script>
    <%}else{
	response.sendRedirect("index.jsp");
}
	}catch(Exception ie){
		response.sendRedirect("index.jsp");
	}%>
</body>
</html>