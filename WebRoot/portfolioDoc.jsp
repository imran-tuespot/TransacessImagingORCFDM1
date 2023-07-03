<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List" %>
	<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/stylelager.css"></link>
<script src="js/jQuery/jquery-1.8.2.min.js"></script>
<link rel="stylesheet" href="css/jquery.dataTables.min.css" />
<!-- Include the Sidr JS -->
<script src="js/jquery.sidr.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="js/jQuery/jquery-ui.js"></script>




<title>Insert title here</title>
<style type="text/css">
.table>thead>tr>th, table-data thead tr {
	background-color: #7098CC;
	color: #fff !important;
}
thead tr {
    background-color: #7098CC;
    color: #fff !important;
}
table thead th, table thead td {
    padding: 10px 18px;
    border-bottom: 1px solid #111;
}
table thead th, table> tbody > tr > th, .table-bordered > tfoot > tr > th, table > thead > tr > td, table > tbody > tr > td, table > tfoot > tr > td {
    border: 1px solid #eee;
        padding: 8px 10px;
}
.input-group {
	width: 20%;
	float: left;
	margin-bottom: 10px;
	border-radius: 4px;
}
</style>
<%
String appuserrole = (String)request.getSession().getAttribute("appuserrole");
   System.out.println("appuserrole "+appuserrole);
   int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
   String sessionid = request.getSession().getAttribute("sessionid").toString();
   int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
   String userName = request.getSession().getAttribute("username").toString();
   String companyFullName=request.getSession().getAttribute("companyFullname").toString();
   List<String> nameslist = (ArrayList<String>)request.getAttribute("nameslist");
   List<String> namesold = (ArrayList<String>)request.getAttribute("namesold");
   String irems=request.getAttribute("irems").toString();
   String actualfilename=request.getAttribute("actualfilename").toString();
   System.out.println(nameslist);
   System.out.println(namesold);
   System.out.println(irems);
   System.out.println(actualfilename);
   javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	String URL = (String) ctx.lookup("java:comp/env/URL");
   %>

</head>
<body >

	<section>
	<div class="container-fluid">
		<div class="buttonAction">
	
<a download  href="<%=restURL%>/role/downloadportfolio?id=/<%=uid%><%=irems%>&originalName=<%=actualfilename %>"
				class="btn btn-success pull-right btn-orange width120"
				
				style="font-weight: bold; margin-top: 4px;    margin-right: 20px;">
				<div class="d-table">
					<div class="d-tbcell v-middle">
						<i class="zmdi_medium zmdi zmdi-caret-left-circle"></i>
					</div>
					<div class="p-left10 d-tbcell v-middle">Download All </div>
				</div>
			</a>
		

		</div>
		<div class="row" style="height: 800px;">

			<div class="search-form">
				
				<div class="col-sm-4">
					

				</div>
				<div class="col-sm-8">

					<form>
					<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-1"> </label>
								<div class="col-sm-8">
								<table>
								<thead>
								<tr>
								<th colspan="2">File Name</th>
								
								<th>Original FileName</th>
								</tr>
								</thead>
								
<%for(int i = 0; i<nameslist.size() ; i++){
if(nameslist.get(i)!=null){
%>
<tr>
 <td><a href="javascript:getPdf('<%=nameslist.get(i) %>');"><%= nameslist.get(i) %></a> </td>
 <td><a download  href="<%=restURL%>/role/downloadportfoliosingle?id=/<%=uid%><%=irems%>/<%=nameslist.get(i) %>" >Download</a> </td><td><%= namesold.get(i) %></td>
				 </tr>				
							<%  
}							
}
		    	    %>	
		    	   
		    	    </table>
								</div>
								
							</div>
						</div>
						
						

						
					</form>




				</div>




				<br>
				<br>
				<br> <br>
				<br>
				<br> <br>




				<div></div>
				<br>
				<div id="datagrid" class="col-sm-12">
					<form>
						<div class="search-tables" style="    text-align: center;margin-top: 10px; ">
						<span id="displaymsg" style="font-weight: bold; color: orange;"  ></span>

							<div class="table-data" >
							
								<div id="loadingImage"
									style="position: absolute; top: 50%; left: 0px; right: 0px; margin: auto; text-align: center">
									<img src="css/images/default.gif" />
								</div>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
	$("#loadingImage").hide();
	

    
    function getPdf(filename) {
    	var keyword='';
    	var user = '<%= uid%>';
    	var com = '<%= cid%>';
    	var version = 0;
    	var session = '<%= sessionid%>';
    	var userName = '<%= userName%>';
    	var urlui= '<%=URL%>';

    	var Text = './DisplayPdf1?&sessionid='+session+'&id='+filename+'&keywordSearch='+keyword+'&userid='+user+'&userName='+userName+'&irems='+<%=irems%>;
    	  var randomnumber = Math.floor((Math.random()*100)+1); 
    	  window.open(Text,"_blank",'PopUp'+randomnumber+'	 ,scrollbars=1,menubar=0,resizable=1,width=850,height=500')
    }
   /*  $(window).on('beforeunload', function() {
    	  saveFormData();
        return 'Your own message goes here...';
    }); */
   /*  window.onbeforeunload = function() {
        saveFormData();
        return null;
    }
 */
    

  
    </script>
	
</body>
</html>