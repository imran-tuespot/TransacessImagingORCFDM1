<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" type="text/css" href="css/stylelager.css"></link>
<script src="js/jQuery/1.11.3/jquery.min.js"></script>
		<link rel="stylesheet" href="css/jquery.dataTables.min.css" />  
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    					<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	
		<script src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
		   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 

  <script src="js/jQuery/jquery-ui.js"></script>
  <script src="js/bootstrap.min.js"></script>
 <title>Insert title here</title>
<style type="text/css">
.table > thead > tr > th, table-data thead tr {
    background-color: #7098CC;
    color: #fff !important;
}
.input-group {
    width: 20%;
    float: left;
    margin-bottom: 10px;
    border-radius: 4px;
}
.table-data tbody tr td img {
    float: none;
}
</style>
<%try{
if(request.getSession().getAttribute("appuserrole")!=null){
String appuserrole = (String)request.getSession().getAttribute("appuserrole");
   System.out.println("appuserrole "+appuserrole);
   int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
   String sessionid = request.getSession().getAttribute("sessionid").toString();
   int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
   String userName = request.getSession().getAttribute("username").toString();
   String companyFullName=request.getSession().getAttribute("companyFullname").toString();
   javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	String URL = (String) ctx.lookup("java:comp/env/URL");

   %>
   
</head>
<body>
<section>
        <div class="container-fluid">
        <div class="buttonAction">
		
		<a id="backBtn1" class="btn btn-success pull-right btn-orange width120" href="documentrepository.jsp" style="font-weight: bold;margin-top: 4px;">
			<div class="d-table">
				<div class="d-tbcell v-middle">
					<i class="zmdi_medium zmdi zmdi-caret-left-circle"></i>
				</div>
				<div class="p-left10 d-tbcell v-middle">Back</div>
			</div>
		</a>

	</div>
            <div class="row" style="height: 800px; border: 1px solid #a5a1a1;">

<div class="search-form">
               <!-- <br><p>The current document types are listed the dropdown below. they are also in your training documentation</p><br> -->
    <br><br>
    <div class="col-sm-4">
<div class="sidemenu">
                        <h4>Full Text Search in all IREMS Records</h4>
                        <span> You can search a record by entering any appropriate relevant keyword from the record in the adjoining box and clicking the Submit button.</span>
                        <!-- <p>Search for 421 different document<br> types in relation to an <br>IREMS Document</p> -->
                    </div>

</div>
                 <div class="col-sm-8">
				 
				 <form>
				 <div class="form-group">
							<div class="row">
								<label class="control-label col-sm-1"> </label>
								<div class="col-sm-8">

									<span id="result" style="color: red"></span>
								</div>
								
							</div>
						</div>
                        <!-- <div class="form-group">
                       
                        
                            <div class="row">
                                <label class="control-label col-sm-4">IREMS Number</label>
                                <div class="col-sm-4">
                                    <input style="height: 25px;" type="text" class="form-control" id="IREMS" name="IREMS">
                                </div>
                                <div class="col-sm-6"></div>
                            </div>
                        </div> -->
                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-4">Enter text you would like to search for <span class="requiredStar">*</span></label>
                                <div class="col-sm-5">
                                    <div style="float: left;width: 80%;"><input style="height: 25px;" type="text" class="form-control" id="Document" name="Document"></div>
                                   <div> <i class="fa fa-info-circle fa-2x tooltipsearch"><span class="tooltiptext">Accepts only alphanumeric values. Eg:012-EH014</span></i></div>
                                </div>
                                <div class="col-sm-6"></div>
                            </div>
                        </div>
                      
                        <div class="form-group">
                        
                            <div class="row">
                                <div class="col-sm-4">
                                </div>
                                <div class="col-sm-6" style="    text-align: left;margin-left: 2pc;">
                                 <button type="button" class="btn btn-success" onclick="searchbyId()"> Submit</button>
                    <input type="reset" class="btn resettable btn-danger" value="Reset"/>
                                </div>
                            </div>
                        </div>

                    </form>
				 
				 
				 
                       
                    </div>
               

               
 
  <br><br><br>

               
             
           
  <br>
 
 
               
             

<div id="datagrid" class="col-sm-12">
                    <form>


 <div class="search-tables" style="text-align: center;margin-top: 10px; ">
						<span id="displaymsg" style="font-weight: bold; color: orange;"  ></span>
               
               
                <div class="table-data">
                    <table id="myTable" class="table table-bordered" style="width: 865px;">
                        <thead>
                            <tr>
                               
                               <th style="width: 130px;">File Name</th>
											<th style="width: 66px;">IREMS #</th>
											<th style="width: 110px;">Document Type</th>
											<th style="width: 75px;">Version Total</th>
											<th style="width: 50px;">Details</th>
											<th style="width: 80px;">Creation Date</th>
											<th style="width: 80px;">Upload Source</th>
                            </tr>
                        </thead>
                        <tbody id="myTableList">
                           

                              
                        </tbody>
                    </table>
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
    jQuery.extend( jQuery.fn.dataTableExt.oSort, {
    	"date-uk-pre": function ( date ) {
    	           var eu_date, year;
    	           date = date.replace(" ", "");
    	                     
    	              eu_date = date.split('-');
    	           /*year (optional)*/
    	           if (eu_date[2]) {
    	               year = eu_date[2];
    	           } else {
    	               year = 0;
    	           }
    	             
    	           /*month*/
    	           var month = eu_date[0];
    	           if (month.length == 1) {
    	               month = 0+month;
    	           }
    	             
    	           /*day*/
    	           var day = eu_date[1];
    	           if (day.length == 1) {
    	               day = 0+day;
    	           }
    	             
    	           return (year + month + day) * 1;
    	       },

    	"date-uk-asc": function ( a, b ) {
    	   return ((a < b) ? -1 : ((a > b) ? 1 : 0));
    	},

    	"date-uk-desc": function ( a, b ) {
    	   return ((a < b) ? 1 : ((a > b) ? -1 : 0));
    	}
    	} );
    $(document).keypress(function(event){
		event.stopPropagation();
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '13'){
			//alert()
			
			if($('#Document').val()){
				searchbyId();
				return false;
				//$('.btn-success').click()
				
			}
			
		}
		
	});
    $(document).mousemove(function(event){
		  InitializeTimer();
	  });
    $(function(){
    	
    	setHeader('fullTextSearchallIREMSDocuments.jsp');
    	$("#loadingImage").hide();
    	$(".workingAreaBlueHeading").html('<div style="margin-top: 5px;">'+
    			'<img src="images/PPT.png " alt="PPT" style="width: 62px;     margin-left: -13%;position: absolute; transform: skewY(350deg);"/>'+
    			'<div> <p style="font-size: 14px;margin-top: 1px;color: black;text-transform: none;    font-weight: 400;"> &nbsp Typing in the Document Type of your choice<br> will show Enhanced Searching Capabilities.</p>'+
    				 ' </div> </div> ');
    	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
    	for (var i = 0; i < array_of_li.length; i++) {
    		 if(array_of_li[i].textContent.trim()=='Records Repository'){
        		array_of_li[i].setAttribute("class", "active");	
        	}
    	}
    });

    $('.resettable').click(function() {
       	if ($.fn.DataTable.isDataTable("#myTable")) {
   			  $('#myTable').DataTable().clear().destroy();
   			}
   });
    function searchbyId(){
    	 if ($.fn.DataTable.isDataTable("#myTable")) {
				  $('#myTable').DataTable().clear().destroy();
				}
    	var compId='<%= cid%>';
    	var docTypeId='';
    	var createDate='';
    	
    		var IREMS= '';
    		var Document= $('#Document').val();
    		/* if(IREMS!=''){
    			var reg = /^\d+$/;
    			if(reg.test(IREMS)&&IREMS.length==9){ */
    				if(Document!=''){
    				
    					var sessionid= '<%=sessionid%>';
    			
    			var str="keyWord="+Document+"&iremsNo="+IREMS+"&sessionId="+sessionid+"&compId="+compId+"&docTypeId="+docTypeId+"&createDate="+createDate;
    			$("#result").text("");
    			$("#loadingImage").show();
    			$.ajax({
    		 		type : "GET",
    		 		url : "<%=restURL%>/orcf/getDocumentsWithKeyword?"+str,
    		 		datType : "json",
    		 		//ContentType : "application/json; charset=utf-8",
    		 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
    		 		success : function(response) 
    		 		{
    		 			$("#loadingImage").hide();
    		 			if(response.key==200){
    		 				
    		 				
   				   		
   				   	 if(response.getDocumentsWithKeyword!=null&& response.commonword==null){
   				   	response=displayData(response);
				   		  }else{
				   			  if(response.commonword!=null){
				   				$("#result").text(response.commonword); 
				   			  }
				   			response=[];
				   		  }
   				   	
   				   		  
   				   		$("#myTable").dataTable({
   				   			
   							 //dom: 'lBfrtip',
   						       
   							  "order": [[ 4, "desc" ]],
   					          "deferRender":    true,
   					          "scroller":       true,
   					        
   					           "drawCallback": function(){
   					        	   // Update state of "Select all" control
   					        	  // updateDataTableSelectAllCtrl($("#myTable").DataTable());
   					        	},
   					        	"aoColumns": [
					                 null,
					                 null,
					                 null,
					                 null,
					                 null,
					                 { "sType": "date-uk" },
					                 null
					             ]
   					    
   					    });
    		 				
    		 				
    		 				/* $('#myTable tbody').empty();
    		 				if(response.getDocumentsWithKeyword.length>0){
    		 					
    		 				
    			 			console.log(response)
    			 			 $.each(response.getDocumentsWithKeyword,function(i,obj)
    			 	                { 
    			 				console.log(JSON.stringify(obj))
    			 				$('#myTable tbody').append(
    			 						 '<tr>'+
    			 						 '<td class="dataclr">'+obj.actualFileName+'<img onclick="getPdf(\''+obj.fileName+'\',\''+obj.version+'\')" src="images/pdfViewer.gif" alt=""></td>'+
    			 						 '<td>'+obj.documentType+'</td>'+
    			 						'<td class="dataclr cursorpointer" onclick="onClickDetails(\''+obj.fileName+'\')">Details</td>'+
    			 						 '<td class="dataclr">'+obj.createDate+'</td>'+
    			 						 '<td class="dataclr-1">'+obj.documentType+'</td> </tr> '
    			 						
    			 					);
    			 			
    			 	                	               	
    			 	                }); 
								}else{
									$('#myTable tbody').empty();
									$('#myTable tbody').append(
	    			 						 '<tr>'+
	    			 						
	    			 						 '<td  colspan="5" style="color=red">No Data Found</td> </tr> '
	    			 						
	    			 					);
    		 				} */		
    			 		  
    		 				
    		 			}else{
    		 				$("#myTable").dataTable({
       				   			
      					    
      					    });
    		 			}
    		 			
    		 		 
    		 		  },
    		 		 error : function(xhr, status, textError) 
    		 		     {
    		 			$("#loadingImage").hide();
    				     }
    		 		    }); 
    			
    			
    		
    		
    		
    				}else{
    		        	$("#result").text("Enter Search text  ");
    		}
    			/* }else{
    		        	$("#result").text("Enter Valid 9 Digit IREMS Number");
    		}
    		}else{
    			
    	        	$("#result").text("Enter IREMS Number");
    	        	
    		}
    		 */
    	
    	
    }
    function displayData(data) {
    	if(data.getDocumentsWithKeyword.length==5000){
    		$("#displaymsg").text("Search results have reached max limit of 5k records. please refine your search to get the best results !!");
    	}else{
    		$("#displaymsg").text("");
    	}
    	$.each(data.getDocumentsWithKeyword, function(i, obj) {
    		//$('#myTableList').append('<tr><td class="dataclr">'+obj.actualFileName+'<img class="cursorpointer" onclick="getPdf(\''+obj.fileName+'\',\''+obj.version+'\',\''+obj.actualFileName+'\')" src="images/pdfViewer.gif" alt=""></td><td>'+obj.documentType+'</td><td class="dataclr cursorpointer" onclick="onClickDetails(\''+obj.fileName+'\',\''+obj.documentType+'\',\''+obj.propertyName+'\')">Details</td><td class="dataclr">'+obj.createDate+'</td><td class="dataclr-1">'+obj.documentType+'</td> </tr> ');
    		// $('#myTableList').append('<tr><td class="dataclr"><div style="word-break: break-all;">'+obj.actualFileName+'<br>('+obj.fileSize+')<img class="cursorpointer" onclick="getPdf(\''+obj.fileName+'\',\''+obj.version+'\',\''+obj.actualFileName+'\',\''+obj.propertyName+'\')"  src="images/pdfViewer.gif" alt=""></div></td><td>'+obj.propertyName+'</td><td>'+obj.documentType+'</td><td class="text-center" style="width:40px">'+obj.total+'</td><td class="dataclr text-center cursorpointer" onclick="onClickDetails(\''+obj.fileName+'\',\''+obj.documentType+'\',\''+obj.propertyName+'\')"><img class="cursorpointer" style="width: 28px;" src="assets/img/DetailsIcon1.png"/></td><td class="dataclr">'+obj.createDate+'</td><td class="dataclr-1">'+obj.uploadSource+'</td> </tr> ');
    		 $('#myTableList').append('<tr><td class="dataclr" style="width: 130px;"><div style="word-break: break-all;">'+obj.actualFileName+'<br>('+obj.fileSize+')<img class="cursorpointer" onclick="getPdf(\''+obj.fileName+'\',\''+obj.version+'\',\''+obj.actualFileName+'\',\''+obj.propertyName+'\')" src="images/pdfViewer.gif" alt=""></div></td><td style="width: 66px;" class="text-center">'+obj.propertyName+'</td><td style="width: 110px;">'+obj.documentType+'</td><td class="text-center" style="width: 75px;">'+obj.total+'</td><td style="width: 50px;" class="dataclr cursorpointer text-center" onclick="onClickDetails(\''+obj.fileName+'\',\''+obj.documentType+'\',\''+obj.propertyName+'\')"><img class="cursorpointer" style="width: 28px;" src="assets/img/DetailsIcon1.png"/></td><td style="width: 80px;" class="dataclr text-center">'+obj.createDate+'</td><td style="width: 80px;" class="dataclr-1 text-center">'+obj.uploadSource+'</td> </tr> ');
               
    	});
    }
 
    function onClickDetails(name,documentType,propertyName){
    	var keyword=$('#Document').val();
        	
    		var compId='<%= cid%>';
    		var sessionid= '<%=sessionid%>';
    var str="id="+name+"&sessionId="+sessionid+"&comid="+compId+"&keyword="+keyword+"&documentType="+documentType+"&propertyName="+propertyName+ "&formAction=";
    var Text = "./EditDocument?"+str;
    var randomnumber = Math.floor((Math.random()*100)+1); 
    window.open(Text,"_blank",'PopUp'+randomnumber+'	 ,scrollbars=1,menubar=0,resizable=1,width=850,height=500')  
        }
    var theChild;
    function getPdf(filename,version,actualfilename,irems) {
		var keyword=$('#Document').val();
    	var user = '<%= uid%>';
    	var com = '<%= cid%>';
    	var session = '<%= sessionid%>';
    	var userName = '<%= userName%>';
    	var urlui= '<%=URL%>'
    	
    	
    		  if(theChild!=null)
    	        {
    	         if(!theChild.closed)
    	         {
    	          theChild.close();
    	         }
    	        }
    	        
    	    	
    	        theChild =window.open(urlui+'DisplayPdf?&sessionid='+session+'&id='+filename+'&keywordSearch='+keyword+'&userid='+user+'&userName='+userName+'&actualfilename='+actualfilename+'&irems='+irems,'popup','status=1,menubar=1,resizable=1,width=1000,height=800');
    	        theChild.onload = function(){ 
    	    	    /* my code */ 
    	    	    this.onbeforeunload = function(e){
    	    	    	console.log("onbeforeunload");
    	    	    	console.log(e); 
    	    	    	saveFormData(irems);
    	    	    	}
    	    	}
    	        var fileNameExtension = filename.substr(filename.lastIndexOf('.') + 1);   
    	var action="";
    	
    	if(fileNameExtension=="pdf"){
    		action="View Document";
    	}else{
    		action="Download Document";
    	}
    	var documentData={
    			 "sessionId":session,
    			 "userId":user,
    			 "companyId":com,
    			 "documentId":filename,
    			 "version":version,
    			 "action":action,
    			 "description":action
    	}
    	
    	
    	$.ajax({
    		type : "POST",
    		contentType : "application/json",
    		url : "<%=restURL%>/audit/saveAuditReport",
    		dataType : 'json',
    		timeout : 100000,
    		data : JSON.stringify(documentData),
    		success : function(data) {
    			console.log("SUCCESS: ", data);
    			
    		},
    		error : function(e) {
    			console.log("ERROR: ", e);
    			
    		},
    		done : function(e) {
    			console.log("DONE");
    		}
    	});
    }
    
    function saveFormData(irems) {
    	$.ajax({
    		type : "GET",
    		   contentType : "application/json",
    		  url :  "<%=restURL%>/role/deleteportfolio?id=<%= uid%>"+irems,
    		   async:true,
    		  timeout : 100000,
    		               success: function(msg){
    		                //   alert("delete file status:  viewer2  "+msg)
    		               },
    					    error:function(e){
    						   console.log("error in line 72--"+e);
    					   },
    		            });
    }
    
    function getPdf12(filename,version) {
		var keyword=$('#Document').val();
    	var user = '<%= uid%>';
    	var com = '<%= cid%>';
    	var session = '<%= sessionid%>';
    	var userName = '<%= userName%>';
    	var urlui= '<%=URL%>'
    	window.open(urlui+'DisplayPdf?&sessionid='+session+'&id='+filename+'&keywordSearch='+keyword+'&userid='+user+'&userName='+userName,'popup','width=1000,height=600');

    	var id = filename;
    	
    	var fileNameExtension = filename.substr(filename.lastIndexOf('.') + 1);
    	var action="";


    	
    	if(fileNameExtension=="pdf"){
    		action="View Document";
    	}else{
    		action="Download Document";
    	}
    	
    	var documentData={
    			 "sessionId":session,
    			 "userId":user,
    			 "companyId":com,
    			 "documentId":filename,
    			 "version":version,
    			 "action":action,
    			 "description":action
    	}
    	
    	
    	$.ajax({
    		type : "POST",
    		contentType : "application/json",
    		//url : "<%=restURL%>/audit/saveAuditReport",
    		dataType : 'json',
    		timeout : 100000,
    		data : JSON.stringify(documentData),
    		success : function(data) {
    			console.log("SUCCESS: ", data);
    			
    		},
    		error : function(e) {
    			console.log("ERROR: ", e);
    			
    		},
    		done : function(e) {
    			console.log("DONE");
    		}
    	});

    	
 

    					 var downloadOriginal=false;

    					
    					 	
    					
    					 var fileNameExt = id.substr(id.lastIndexOf('.') + 1);

    					 	if (fileNameExt == "doc" || fileNameExt == "docx"
    					 			|| fileNameExt == "xlsx" || fileNameExt == "xls"
    					 			|| fileNameExt == "jpg" || fileNameExt == "jpeg") {

    					 		var Text = "./DisplayText?id=" + id + "&userid=" + user + "&comid="
    					 				+ com + "&sessionid=" + session + "&userName=" + userName;
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

    					 	sessionStorage.setItem('downloadOriginal',downloadOriginal);
    					 	
    					 						var fPath = "<%=restURL%>/role/invokeFile?id="+id;
    					 						console.log("365..."+fPath);
    					 						$.ajax({					   		 
    					 						   	type : "GET",
    					 						    contentType : "application/json",
    					 						 //  	url : "<%=restURL%>/role/invokeFile?id="+id,
    					 						   	timeout : 100000,
    					 						   	success : function(resp) {
    					 						   
    					 						   		console.log("success getting file"+resp);
    					 						   		 sessionStorage.setItem('filename',"../../../../TransAccessImagingWS/role/downloadDocument?docId="+resp.substring(0,resp.lastIndexOf("_")));
    					 								
    					 								var pdfurl1='viewer.html?file='+resp+'&restURL=<%=restURL%>';
    					 								console.log('pdf url...'+pdfurl1);
    					 								var pdfWindow = window
    					 									.open(
    					 											pdfurl1,
    					 											'',
    					 											'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
    					 								pdfWindow.onbeforeunload = function(){
    					 									$.ajax({
    					 											type : "GET",
    					 										    contentType : "application/json",
    					 										   	url : "<%=restURL%>/role/deleteFile?id="+resp,
    					 										   	timeout : 100000,
    					 							                success: function(msg){
    					 							                    //alert("delete file status:    "+msg)
    					 							                },
    					 							             });
    					 									return null;
    					 								}
    					 								
    					 								
    					 						   	  },
    					 						   	  error : function(e) {
    					 						   	   console.log("ERROR: ", e);						   	       
    					 						   	  },
    					 						   	  done : function(e) {
    					 						   	  }
    					 						   	});							
    					 						
    					 		  <%-- var pdfurl = '<%=restURL%>'+"/role/ResponseBodyStreamFixed?id="+ id; --%>
    					 		  
    					 			
    					 	}									
    										
    }
   
    </script>
 <%}else{
	response.sendRedirect("index.jsp");
} 
}catch(Exception ie){
	response.sendRedirect("index.jsp");
}
%>
</body>
</html>