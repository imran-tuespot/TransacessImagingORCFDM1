<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<jsp:useBean id="companyInformation" scope="request" class="com.peniel.beans.CompanyInformation" />
<jsp:useBean id="indexTypeBean" scope="request" class="com.peniel.beans.IndexTypeBean" />
<jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />
<jsp:useBean id="userInformation" scope="request" class="com.peniel.beans.UserInformation" />
<jsp:setProperty name="userInformation" property="*" />


<%@page import="java.util.*"%>

<html>
  <head>
  <jsp:include page="includes/sessionHeader.jsp" />
  
    		<title> My Files</title>
    		

<% 
   
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  
  HashMap companyHashMap = companyInformation.getcompanyInformation(request.getSession().getAttribute("comid").toString());
  String indexType = indexTypeBean.getIndexType(companyHashMap.get("defaultIndex").toString(),
  												request.getSession().getAttribute("comid").toString());
  												
  List<String> html = folderBean.getFolderNameGridHTML(""+cid,""); 
  request.getSession().setAttribute("folderData", html);									
  //System.out.println("Index type--->"+indexType);  												
 %>
    <script language="javascript">
    
//Global variable to store array elements for expanded folder
 var s = [];   
    function initial_load() {  	
    var data = '<%=html%>'    
	setHeader('myFiles.jsp');
	getFrequentFileHTML();
    }
    
    
    function getCookie1(w){
	//alert("getting cookie "+w);
	cName = "";
	pCOOKIES = new Array();
	pCOOKIES = document.cookie.split('; ');
	for(bb = 0; bb < pCOOKIES.length; bb++){
		NmeVal  = new Array();
		NmeVal  = pCOOKIES[bb].split('=');
		if(NmeVal[0] == w){
			cName = unescape(NmeVal[1]);
		}
	}
	return cName;
}
    
    function getFrequentFileHTML()
    {
 	var userid = '<%=uid%>';
 	var cookieCountVar = getCookie1('cookieCount');
	//alert("cookieCountVar "+cookieCountVar);
	if(cookieCountVar)
	{
	   document.getElementById('frequentRows').style.display = 'block';
		for(var i=1; i <= 10; i++)
		{
		    //alert("getting cookie "+userid+'_'+i);
		    var linkText = getCookie1(userid+'_'+i);
		  	if(linkText)
		    {
		        //alert("linktext "+linkText);
			    idAndDocType = linkText.split('#');
				
				//alert("id = "+idAndDocType[0]);
				//alert("docType= "+idAndDocType[1]);
				//alert("indexType= "+idAndDocType[2]);
				//alert("indexVal= "+idAndDocType[3]);
				var fName;
				var f = idAndDocType[4];
				var status = idAndDocType[5];
				var docTypeId = idAndDocType[6];
				var version = idAndDocType[7];
				var indexId = idAndDocType[8];
				var docId = idAndDocType[9];
					
			
				if(f)
				{
					f = f.substring(0, f.length - 1);
					var n = f.lastIndexOf("/"); 
					fName = f.substring(n+1, f.length);					
				}
				
				
				document.getElementById('link'+i).href= "javascript:getpdf("+"'/"+idAndDocType[0]+"/');";
				document.getElementById('link'+i).innerHTML = idAndDocType[1];
				document.getElementById('row'+i).style.display = "block"; // show
				//document.getElementById('link'+i).style='width:300px';	
				
				document.getElementById('folder'+i).style.display = "block"; // show
				document.getElementById('folder'+i).innerHTML = fName;	
				document.getElementById('col2'+i).title = f;			
				
				document.getElementById('indexType'+i).style.display = "block"; // show
				document.getElementById('indexType'+i).innerHTML = idAndDocType[2];
				//document.getElementById('indexType'+i).style='width:150px';
				
				document.getElementById('indexValue'+i).innerHTML = idAndDocType[3];
				//document.getElementById('indexValue'+i).style='width:150px';
				
				document.getElementById('detailLink'+i).href= "javascript:editDoc("+"'/"+idAndDocType[0]+"/','"+idAndDocType[2]+
				"','"+idAndDocType[3]+"','"+idAndDocType[1]+"','"+status+"','"+docId+"','"+version+"','"+indexId+"','"+docTypeId+"','');";
				document.getElementById('detailLink'+i).innerHTML = "Details";
				
				//This is required for width setting of columns
				document.getElementById('row'+i).style = 'width:700px';				
				
				
			 }else
			 {
				document.getElementById('row'+i).style.display = "none"; // hide
				document.getElementById('indexType'+i).style.display = "none"; // hide
			 }
			
		}
	}
	else
	{
		document.getElementById('noResults').style.display = 'block';
	
		for(var i=1; i <= 10; i++)
		{
			document.getElementById('row'+i).style.display = "none"; // hide
			document.getElementById('indexType'+i).style.display = "none"; // hide
		}
	}
	
 }
    
    </script>
  </head>
  
 <body onLoad="initial_load()">


<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
<tr>
							<td width="789" valign="top">
							<div class="messagewindow" id="noResults"
							style="DISPLAY: none; MARGIN: 0px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 60%; z-index: 4; text-align: center;">
							<h4>
									There are no frequently accessed files.
							</h4>
							</div>
							<div id = "frequentRows" style="display: none">	
									<fieldset>
										<legend>Frequently Accessed Files </legend>
										
									<table border=0 >
										
										
										<tr>
											<td width="300px"><h4>Document Type<h4></td>
											<td width="200px"><h4>Folder<h4></td>
											<td width="150px"><h4>Index Type<h4></td>
											<td width="150px"><h4>Value<h4></td>
											<td width="150px"><h4>Details<h4></td>
																			
										</tr>
										
										<tr id="row1" >
											<td    style='width:300px'>
													<a id='link1' href='' style='font-size:12px;font-family: Verdana;' > file # 1</a>											
											</td>
											<td id="col21"    style='width:150px'>
													<label id="folder1" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td     style='width:150px'>
													<label id="indexType1" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td    style='width:150px'>
												<label id="indexValue1" style='font-size:12px;font-family: Verdana;width:"150px'></label>								
											</td>
											<td    style='width:150px'>
													<a id='detailLink1' href='' style='font-size:12px;font-family: Verdana;' > </a>											
											</td>																					
										
										</tr>
										<tr id="row2" style='font-size:12px;font-family: Verdana;'>
											<td    align=left width="250px">
													<a id='link2' href=''  style='font-size:12px;font-family: Verdana;'> file # 2</a>											
											</td>
											<td  id="col22"   style='width:150px'>
													<label id="folder2" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexType2" style='font-size:12px;font-family: Verdana;'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexValue2" style='font-size:12px;font-family: Verdana;' ></label>												
																							
											</td>	
											<td    style='width:150px'>
													<a id='detailLink2' href='' style='font-size:12px;font-family: Verdana;' > </a>											
											</td>	
																			
										</tr>
										<tr id="row3" >
											<td  width="250px"  align=left>
													<a id='link3' href='' style='font-size:12px;font-family: Verdana;' > file # 3</a>											
											</td>
											<td  id="col23"   style='width:150px'>
													<label id="folder3" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexType3" style='font-size:12px;font-family: Verdana;'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexValue3" style='font-size:12px;font-family: Verdana;'></label>											
											</td>	
											<td    style='width:150px'>
													<a id='detailLink3' href='' style='font-size:12px;font-family: Verdana;' > </a>											
											</td>	
																			
										</tr>
										<tr id="row4" >
											<td width="250px"   align=left >
													<a id='link4' href=''  style='font-size:12px;font-family: Verdana;'> file # 4</a>											
											</td>
											<td id="col24"    style='width:150px'>
													<label id="folder4" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexType4" style='font-size:12px;font-family: Verdana;'></label>													
						
											</td>	
											<td     width="150px">
												<label id="indexValue4" style='font-size:12px;font-family: Verdana;' ></label>								
																							
											</td>	
											<td    style='width:150px'>
													<a id='detailLink4' href='' style='font-size:12px;font-family: Verdana;' > </a>											
											</td>	
																			
										</tr>
										<tr id="row5" >
											<td width="250px"   align=left >
													<a id='link5' href='' style='font-size:12px;font-family: Verdana;'> file # 5</a>											
											</td>
											<td  id="col25"   style='width:150px'>
													<label id="folder5" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexType5" style='font-size:12px;font-family: Verdana;'></label>													
						
											</td>	
											<td     width="150px">
												<label id="indexValue5" style='font-size:12px;font-family: Verdana;'></label>								
																							
											</td>	
											<td    style='width:150px'>
													<a id='detailLink5' href='' style='font-size:12px;font-family: Verdana;' > </a>											
											</td>	
																			
										</tr>
										<tr id="row6" >
											<td   width="250px"   align=left >
													<a id='link6' href='' style='font-size:12px;font-family: Verdana;'> file # 6</a>											
											</td>
											<td  id="col26"   style='width:150px'>
													<label id="folder6" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td      width="150px" >
													<label id="indexType6" style='font-size:12px;font-family: Verdana;' ></label>													
						
											</td>	
											<td      width="150px" >
													<label id="indexValue6" style='font-size:12px;font-family: Verdana;'></label>								
																							
											</td>	
											<td    style='width:150px'>
													<a id='detailLink6' href='' style='font-size:12px;font-family: Verdana;' > </a>											
											</td>	
																			
										</tr>
										<tr id="row7" >
											<td   width="250px"   align=left >
													<a id='link7' href='' style='font-size:12px;font-family: Verdana;' > file # 7</a>											
											</td>
											<td  id="col27"   style='width:150px'>
													<label id="folder7" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexType7" style='font-size:12px;font-family: Verdana;'></label>													
						
											</td>	
											<td id="col27"    width="150px">
													<label id="indexValue7" style='font-size:12px;font-family: Verdana;' ></label>								
																							
											</td>	
											<td    style='width:150px'>
													<a id='detailLink7' href='' style='font-size:12px;font-family: Verdana;' > </a>											
											</td>	
																			
										</tr>
										<tr id="row8" >
											<td   width="250px"   align=left >
													<a id='link8' href='' style='font-size:12px;font-family: Verdana;'> file #8</a>											
											</td>
											<td id="col28"    style='width:150px'>
													<label id="folder8" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexType8" style='font-size:12px;font-family: Verdana;'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexValue8" style='font-size:12px;font-family: Verdana;'></label>								
										
											</td>	
											<td    style='width:150px'>
													<a id='detailLink8' href='' style='font-size:12px;font-family: Verdana;' > </a>											
											</td>	
																			
										</tr>
										<tr id="row9" >
											<td  width="250px"    align=left >
													<a id='link9' href='' style='font-size:12px;font-family: Verdana;'> file # 9</a>											
											</td>
											<td id="col29"    style='width:150px'>
													<label id="folder9" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexType9" style='font-size:12px;font-family: Verdana;'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexValue9" style='font-size:12px;font-family: Verdana;'></label>								
											
											</td>	
											<td    style='width:150px'>
													<a id='detailLink9' href='' style='font-size:12px;font-family: Verdana;' > </a>											
											</td>	
																			
										</tr>
										<tr id="row10" >
											<td   width="250px"   align=left>
													<a id='link10' href='' style='font-size:12px;font-family: Verdana;'> file # 10</a>											
											</td>
											<td  id="col210"   style='width:150px'>
													<label id="folder10" style='font-size:12px;font-family: Verdana;width:150px'></label>													
						
											</td>	
											<td     width="150px">
													<label id="indexType10" style='font-size:12px;font-family: Verdana;'></label>													
						
											</td>	
											<td     width="150px">
												<label id="indexValue10" style='font-size:12px;font-family: Verdana;'></label>								
				
											</td>	
											<td    style='width:150px'>
													<a id='detailLink10' href='' style='font-size:12px;font-family: Verdana;' > </a>											
											</td>	
																			
										</tr>
									  </table>
									  
								</fieldset>	
								</div>
							</td>
						  </tr>
						  </table>
						    </body>
</html>
