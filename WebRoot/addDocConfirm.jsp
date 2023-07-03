<%@page import="com.peniel.beans.getDropD"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />

<jsp:setProperty name="userInformation" property="*" />
<%@page import="java.util.*"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<script src="js/jQuery/jquery-1.8.2.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />
		
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>
		<title>TransAccess Imaging</title>	
		
		<style type="text/css">
		div#expand{
		display:block;
		width:100%;
		}
		.example {
			float: left;
			
		}
		.folderStruct {
			width: 98%;
			height: 230px;
			border: solid 1px #BBB;
			background: #FFF;
			overflow: auto;
			padding: 5px;
		}
		#content{
		position:relative;
		}
		
		/*  #flip-tabs{  
		    width:850px;  
		      
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
		
	    #flip-navigation li.selected{
			border-width: 1px;
			border-style: solid;
			border-color: #999 #999 #FFF;			
			border-image: none;
			padding-top:10px;
			background-color: #FF9800;
			border-color: transparent;
			padding-bottom: 10px;
		}
		#flip-navigation li a{  
		    text-decoration:none; padding:10px;
		    margin-right:0px;  
		    color:#333; outline:none;  
		    font-family:roboto;font-size:13px;;  
		}  
		#flip-navigation li a:hover{  
		    color:#2196F3;  
		}  
		#flip-navigation li.selected a{  
			height: 25px;
			padding: 4px 11px 15px 9px;
			font-size: 14px;
			letter-spacing: normal;
			text-decoration: none;
			color: #333;
			border-bottom: medium none; 
			background-color: #FFF;
		}  
		#flip-container{    
		    width:830px;  
		    font-family:Geneva,Arial,Helvetica,sans-serif;
		    font-size:0.8em;  
		    overflow: visible;
			height: auto;
			margin-left:30px;
		}  
		.tabBox{
		background-color: #FFF;
		padding: 0px 6px;
		position: relative;
		border-bottom: 1px solid #999;
		height: 27px;
		margin-bottom: 20px;
		margin-top: 20px;
		height: 37px;

		}*/
				
		</style>
</head>

<jsp:include page="includes/sessionHeader.jsp" />


<% 
  System.out.println("*** addDocConfirm.jsp ***");
  String success = 	request.getParameter("success");
  String successAfterInsert = 	request.getParameter("successAfterInsert");
  System.out.println("success after uploading file ---> "+success);
  System.out.println("success after inserting record in DB ---> "+successAfterInsert);
  
  if (success.equalsIgnoreCase("yes") || successAfterInsert.equalsIgnoreCase("yes")) 
  {
  	success = "<font color=green><b>Document has been saved successfully.</b></font>";
  } 
  else if (success.equalsIgnoreCase("error")|| successAfterInsert.equalsIgnoreCase("no")) 
  {
  	success = "<font color=red><b>Error while adding document. Please contact system administrator.</b></font>";
  } else 
  {
  	success = "";
  }
  System.out.println("success after adding document --->"+success); 
 
  getDropD getDD = new getDropD();
  
  String doctype = request.getAttribute("doctype").toString();
  String indextype = request.getAttribute("indextype").toString();
  String folderName = request.getAttribute("folderName").toString();
  String propertytype = request.getAttribute("propertytype").toString();
 
  String docval = getDD.getDoctype(doctype);
  String indextypeval = getDD.getIndex(indextype); 
  String propertyTypeVal = getDD.getProperty(propertytype);
  String folderval = folderName;
  
  
  
  /*
  String[] docvalarr = docval.split("|");
  String[] indextypevalarr = indextypeval.split("|");
  
  String indextype1 = request.getAttribute("indextype1").toString();
 
  String indextype2 = request.getAttribute("indextype2").toString();
 
  String indextype3 = request.getAttribute("indextype3").toString();
 
  String indextype4 = request.getAttribute("indextype4").toString();
 */
  String indexval = request.getAttribute("indexval").toString();
/*
  String indexval1 = request.getAttribute("indexval1").toString();
 
  String indexval2 = request.getAttribute("indexval2").toString();
 
  String indexval3 = request.getAttribute("indexval3").toString();
 
  String indexval4 = request.getAttribute("indexval4").toString();
  */
  String fileName = request.getParameter("id").toString();	
  /*
  String indextypeval1 = getDD.getIndex(indextype1); 
  String indextypeval2 = getDD.getIndex(indextype2); 
  String indextypeval3 = getDD.getIndex(indextype3); 
  String indextypeval4 = getDD.getIndex(indextype4); 
  */ 
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  String cId = request.getSession().getAttribute("comid").toString();
  
  
  /*
  com.peniel.dao.CompanyDAO companyDao = new com.peniel.dao.CompanyDAO();
  Vector companyList = new Vector();
  com.peniel.bus.vo.Company company = new com.peniel.bus.vo.Company();
			
  companyList = companyDao.findById(cId);
  company = (com.peniel.bus.vo.Company) companyList.get(0);
  String companyName = company.getCompanyName();
  
  
  javax.naming.Context ctx = new javax.naming.InitialContext();
  String webFolder = (String) ctx.lookup("java:comp/env/webfolder");
  
  String strContextPath = request.getContextPath();
  */
  String filePath = request.getAttribute("filePath").toString();
  
  //HashMap hashMap = userInformation.getUserInformation(request);
  //System.out.println( "hashMap = " + hashMap );
  
%>

<body>

<div id="flip-tabs" >  
        
        
        <form name="upload" method="post" action="AddDocument" enctype="multipart/form-data">
        

		<table style="margin-top:20px;">
		<tr><td style='font-size:14px;color: green'>
		<font color=red><b><%=success%></b></font>
		</td></tr>
		</table>
        
        
        <div id="flip-container" >  
            <div id="summaryTab">  
            <div class="card" style="width: 95%; padding-left: 0px;">
					<div class="card-body card-padding" style="background-color:#EBEBEB;margin-bottom: 20px;min-height:400px;">		
					<table align="center" width= "700" >
						<tr height= '20'  align="right">
								<td>
								<%if(success.equalsIgnoreCase("error")){ %>
									<td><input type="button" id= "saveandnew" style="margin-right: 10px;" name="saveandnew" value="Add New" disabled="disabled" class="btn btn-success waves-effect waves-button waves-float">
								<%} else { %>
									
									<input type="button" name="saveandnew" value="Add New" style="margin-right: 10px;" class="btn btn-success waves-effect waves-button waves-float" onClick="location.href='addDoc.jsp';"> 
								<%} %>
								<input type="button" name="cancel" value="Cancel" class="btn btn-warning waves-effect waves-button waves-float" onClick="location.href='dashboard.jsp';"></td>
						</tr>
					</table>
		            	
								<table align="center" width= "100%" style="padding: 20px;margin-top: 20px;background-color: #FFF">
							<tr>
								<td colspan="2"><h4 class="tableHeader" style="padding-top: 10px;padding-bottom: 10px;">Please review entered values and save the document.</h4></td>
							</tr>	
							<tr valign=top>
							<td style="width: 40%">
								<div style="float: left;width: 100%">
								<table style="width: 100%;">
									<tr>
										<td style="border-bottom:1px solid #CCC">
										<h3 class="header" style="display: inline-block;">Property ID : </h3> 
								  			<label class="summaryLbl"><%=propertyTypeVal%></label>		
									  	</td>
								  	<tr>
									  	<td style="border-bottom:1px solid #CCC">								
									  	<h3 class="header" style="display: inline-block;">Document Type : </h3>
								  		<label class="summaryLbl"><%=docval%></label>
									  	</td>
								  	</tr>
								  	<tr>
									  	<td style="border-bottom:1px solid #CCC">
									  	<h3 class="header" style="display: inline-block;">Folder : </h3> 
									  	<label class="summaryLbl"><%=folderval%></label>
									  	</td>
									</tr>
									<tr>
									  	<td style="border-bottom:1px solid #CCC">
									<%String extension=filePath.substring(filePath.lastIndexOf(".") + 1);
									
									System.out.println("extension"+extension);
									if(extension.toLowerCase().equalsIgnoreCase("doc") || extension.toLowerCase().equalsIgnoreCase("docx")){
									 %>
									<label class="summaryLbl" style="margin-top: 20px;"> View Document <a href="javascript:getpdf('<%=filePath %>');"><img src="./images/doc.png" border="0" height="25px" width="25px"></a></label>
									<%}else if(extension.toLowerCase().equalsIgnoreCase("jpg") || extension.toLowerCase().equalsIgnoreCase("jpeg")){ %>
									<label class="summaryLbl" style="margin-top: 20px;"> View Document <a href="javascript:getpdf('<%=filePath %>');"><img src="./images/jpeg.png" border="0" height="25px" width="25px"></a></label>
									<%}else if(extension.toLowerCase().equalsIgnoreCase("xls") || extension.toLowerCase().equalsIgnoreCase("xlsx")){ %>
									<label class="summaryLbl" style="margin-top: 5px;"> View Document <a href="javascript:getpdf('<%=filePath %>');"><img src="./images/excel_file.png" border="0" height="25px" width="25px"></a></label>
									<%}else{ %>
									<label class="summaryLbl" style="margin-top: 20px;"> View Document <a href="javascript:getpdf('<%=filePath %>');"><img src="./images/pdfViewer.gif" border="0" height="25px" width="25px"></a></label>
									
									<%} %>
									  			  	</td>
									</tr>
								</table>
								</div>
								</td>
								<td style="width: 40%">
								<div class="or-spacer-vertical right">  
									<div class="mask">
									</div>
								</div>
								<div id="defaultProfile" style="float: right;width: 90%">
									<table width="350" cellpadding="0" cellspacing="0">
								<tr valign="top">
									<td width="200" style="border-bottom:1px solid #CCC">
										<h3 class="header">Index Type</h3>
									</td>
									<td width="200" style="border-bottom:1px solid #CCC" >
										<h3 class="header">Value   </h3>
									</td>
								</tr>
									
								<tr>
									<td><label class="summaryLbl" ><%=indextypeval%></label></td>
									<td><label class="summaryLbl" ><%=indexval%></label></td>
								</tr>
								
								<tr>
								<td >
								</td>
								<td ></td>
								</tr>
								
							
								</table>
								</div>
								</td>
								</tr>
								</table>
								</div>
            </div>
            </div>  
            
        </div>  
        
        </form>
        
        
    </div>
<script language="javascript">
$('document').ready(function(){
	setHeader('addDoc.jsp');
	 //Initialize slider menu
     $('#simple-menu').sidr();
     
  	$('.child').hide();
  	$('.parent').click(function() {
	 	$('.child').slideUp();
	 	$(this).find('ul').slideToggle();
  	});
  	$('#docManagementLi').click();	
});
	function getpdf(id) {		
		var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	
	

	var fileNameExt = id.substr(id.lastIndexOf('.') + 1);

		if (fileNameExt == "doc" || fileNameExt == "docx"
				|| fileNameExt == "xlsx" || fileNameExt == "xls"
				|| fileNameExt == "jpg" || fileNameExt == "jpeg") {

			var Text = "./DisplayText?id=" + id + "&userid=" + user + "&comid="
					+ com + "&sessionid=" + session + "&userName=" + userName;
			//window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
			var popout = window
					.open(
							Text,
							'_blank',
							'toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=15000, top=15000, width=50, height=50, visible=none',
							'');

			window.setTimeout(function() {
				popout.close();
			}, 8000);

		}

		else {

			var Text = "./DisplayPdf?id=" + id + "&userid=" + user + "&comid="
					+ com + "&sessionid=" + session + "&userName=" + userName;
			window
					.open(
							Text,
							'',
							'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');

		}
	}
</script>

</body>

</html>
