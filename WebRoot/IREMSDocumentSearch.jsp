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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="js/jQuery/jquery-ui.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
  <script src="js/bootstrap.min.js"></script>




<title>Insert title here</title>
<style type="text/css">
#datepicker {
	margin: 0;
}

.table>thead>tr>th, table-data thead tr {
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

			<a id="backBtn1"
				class="btn btn-success pull-right btn-orange width120"
				href="documentrepository.jsp"
				style="font-weight: bold; margin-top: 4px;">
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
                <br><br>
                <div class="col-sm-4">
				<div class="sidemenu">
                        <h4>IREMS Record Search</h4>
                        <span> You can search a record by providing any of the following; the iREMS#,
Document Type, relevant keywords from the record, or by providing the creation date.</span>
                    </div>
				
				</div>
				<div class="col-sm-8 mtop20">
					<form>
					<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-1"> </label>
								<div class="col-sm-8">

									<span id="result" style="color: red"></span>
								</div>
								
							</div>
						</div>
						
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3">IREMS Number </label>
								<div class="col-sm-4">

									<input style="height: 25px;" type="text" class="form-control"
										id="IREMS" name="IREMS">
								</div>
								<div class="col-sm-6"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3">Document Type </label>
								<div class="col-sm-4">
									<select id="doctype" style="height: 25px; width: 175px;">
										<option value="" selected="" disabled="">Select Type of Search</option>

									</select>

								</div>
								<div class="col-sm-6"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3">Document text </label>
								
								<div class="col-sm-5">
                                    <div style="float: left;width: 80%;"><input style="height: 25px;" type="text" class="form-control" id="Documenttxt" name="Documenttxt"></div>
                                    <div> <i class="fa fa-info-circle fa-2x tooltipsearch" aria-hidden="true" ><span class="tooltiptext">Accepts only alphanumeric values. Eg:012-EH014</span></i></div>
                                </div>
								<div class="col-sm-6"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3">Create Date </label>
								<div class="col-sm-4">
									<div id="datepicker" class="input-group date"
										data-date-format="mm-dd-yyyy">
										<input class="form-control" type="text"
											style="height: 28px; background: #edecec;" readonly /> <span
											class="input-group-addon calstyle"><i
											class="glyphicon glyphicon-calendar"
											style="font-size: 22px; color: #0d529f;"></i></span>
									</div>
								</div>
								<div class="col-sm-6"></div>
							</div>
						</div>


						<div class="sub-btns text-left">
							<button type="button" class="btn btn-success"
								onclick="searchbyId()">Submit</button>
							<input type="reset" class="btn resettable btn-danger"
								value="Reset" />
						</div>
					</form>
				</div>


				<br>
				<br>
				<br> <br>





				<div id="datagrid" class="col-sm-12">

					<form>

						
 <div class="search-tables" style="text-align: center;margin-top: 10px; ">
						<span id="displaymsg" style="font-weight: bold; color: orange;"  ></span>
               

							<div class="table-data">
								<table id="myTable" class="table table-bordered"
									style="width: 865px;">
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
									<tbody>



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
				
				var docTypeId=$('#doctype').find(":selected").val();
    	
    		var IREMS= $('#IREMS').val();
    		var Documenttext= $('#Documenttxt').val();
    		var fromDate = $('#datepicker').datepicker('getDate');
    		
    		if(IREMS!=''||docTypeId !=''||Documenttext!=''||fromDate!='Invalid Date'){
				
				
					searchbyId();
					return false;
					//$('.btn-success').click()
					
				}
				
			}
			
		});
    $('.resettable').click(function() {
    	$('#datepicker').datepicker('setDate', null);
    	if ($.fn.DataTable.isDataTable("#myTable")) {
			  $('#myTable').DataTable().clear().destroy();
			}
});
    $(document).mousemove(function(event){
		  InitializeTimer();
	  });
	
    $(function() {
    	
    	setHeader('IREMSDocumentSearch.jsp');
    	$("#loadingImage").hide();
    	$(".workingAreaBlueHeading").html('<div style="margin-top: 5px;">'+
    			'<img src="images/PPT.png " alt="PPT" style=" width: 62px;     margin-left: -13%;position: absolute;  transform: skewY(350deg);"/>'+
    			'<div> <p style="font-size: 14px;margin-top: 1px;color: black;text-transform: none;    font-weight: 400;"> &nbsp  Typing in the Document Type of your choice<br> will show Enhanced Searching Capabilities.</p>'+
    				 ' </div> </div> ');
    	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
    	for (var i = 0; i < array_of_li.length; i++) {
    		if(array_of_li[i].textContent.trim()=='Records Repository'){
    		array_of_li[i].setAttribute("class", "active");	
    	}
    		
    	}
		$("#datepicker").datepicker({
			 endDate:new Date(),
            autoclose: true,
            dateFormat: 'mm-dd-yy',
           
            endDate:new Date()
        }).on("changeDate", function (e) {
        	$("#result").text("");
        	});
		getDocTypes();
    });
   
    function searchbyId(){
    	if ($.fn.DataTable.isDataTable("#myTable")) {
			  $('#myTable').DataTable().clear().destroy();
			}
    	var compId='<%= cid%>';
    	var docTypeId=$('#doctype').find(":selected").val();
    	var createDate='';
    	
    		var IREMS= $('#IREMS').val();
    		var Documenttext= $('#Documenttxt').val();
    		var fromDate = $('#datepicker').datepicker('getDate');
    		
    		if(IREMS!=''||docTypeId !=''||Documenttext!=''||fromDate!='Invalid Date'){
    			if(!IREMS){
    				IREMS='';
    			}
    			if(!docTypeId){
    				docTypeId='';
    			}
    			if(!Documenttext){
    				Documenttext='';
    			}
    			   var regexp = /^[a-zA-Z0-9-_]+$/;
    				if(IREMS==''||(IREMS!=null&&regexp.test(IREMS)&&IREMS.length>2)){
    					
    		/* if(IREMS!=''){
    			var reg = /^[a-z0-9]+$/i;
    			if(reg.test(IREMS)){
    				if(docTypeId !=''){
    					if(Documenttext!=''){ */
    			    		if(fromDate!='Invalid Date'){
    			    			createDate=fromDate.getMonth()+1+"-"+fromDate.getDate()+"-"+fromDate.getFullYear();
    			    		}else{
    			    			createDate='';
    			    		}
    					var sessionid= '<%=sessionid%>';
    			
    			var str="keyWord="+Documenttext+"&iremsNo="+IREMS+"&sessionId="+sessionid+"&compId="+compId+"&docTypeId="+docTypeId+"&createDate="+createDate;
    			$("#result").text("");
    			$("#loadingImage").show();
    			$.ajax({
    		 		type : "GET",
    		 		url : "<%=restURL%>/orcf/getDocumentsInSearch?"+str,
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
					             ],
					             "columnDefs": [ 
					            	 { "width": "130px" },
			                        { "width": "66px" },
				            	    { "width": "110px" },
				            	    { "width": "75px" },
				            	    { "width": "50px" },
				            	    { "width": "80px" },
				            	    { "width": "80px" }
				            	  
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
	    			 						
	    			 						 '<td  colspan="5" style="color:red">No Data Found</td> </tr> '
	    			 						
	    			 					);
    		 				} */		
    			 		  
    		 				
    		 			}else{
    		 				/* $('#myTable tbody').empty();
    		 				$('#myTable tbody').append(
			 						 '<tr>'+
			 						
			 						 '<td  colspan="5" style="color:red">No Data Found</td> </tr> '
			 						
			 					); */
    		 				$("#myTable").dataTable({
      				   		
     					    
     					    });
    		 			}
    		 			
    		 		 
    		 		  },
    		 		 error : function(xhr, status, textError) 
    		 		     {
    		 			$("#loadingImage").hide();
    				     }
    		 		    }); 
    			
    			
    		
    		
    			    	/* 	}else{
    			    			$("#result").text("Select Create Date ");	
    			    		}
    			    		}else{
    			    			$("#result").text("Enter Document text ");
    			    			
    			    		}
    				}else{
    					$("#result").text("Select Document Type");	
    		}
    			 }else{
    		        	$("#result").text("Enter Valid IREMS Number");
    		} */
    		}else{
    			
    	        	$("#result").text("Enter Valid IREMS Number");
    	        	
    		} 
    		
    		}else{
    			$("#result").text("Please provide at least one field");	
    		}
    	
    }

    function getDocTypes(){
    	var comid='<%= cid%>'
    	 $.ajax({
             type: "GET",
             
             url:"<%=restURL%>/orcf/getDocType?companyId="+comid,
             dataType: "json",
             success: function (data) {
             	//alert("619::"+data.docTypeData[0].value);
             		

                 $.each(data.response,function(i,obj)
                 		
                 {                	
                 	var	div_data="<option value="+obj.docTypeMasterId+">"+obj.docTypeMasterDesc+"</option>";
                 	$(div_data).appendTo('#doctype'); 
                 	
                 });
                
                 } 
           });
    }
    
    function displayData(data) {
    	if(data.getDocumentsWithKeyword.length==5000){
    		$("#displaymsg").text("Search results have reached max limit of 5k records. please refine your search to get the best results !!");
    	}else{
    		$("#displaymsg").text("");
    	}
      	     	
      	$.each(data.getDocumentsWithKeyword, function(i, obj) {
      		 $('#myTable tbody').append('<tr><td class="dataclr" style="width: 130px;"><div style="word-break: break-all;">'+obj.actualFileName+'<br>('+obj.fileSize+')<img class="cursorpointer" onclick="getPdf(\''+obj.fileName+'\',\''+obj.version+'\',\''+obj.actualFileName+'\',\''+obj.propertyName+'\')" src="images/pdfViewer.gif" alt=""></div></td><td style="width: 66px;" class="text-center">'+obj.propertyName+'</td><td style="width: 110px;">'+obj.documentType+'</td><td class="text-center" style="width: 75px;">'+obj.total+'</td><td style="width: 50px;" class="dataclr cursorpointer text-center" onclick="onClickDetails(\''+obj.fileName+'\',\''+obj.documentType+'\',\''+obj.propertyName+'\')"><img class="cursorpointer" style="width: 28px;" src="assets/img/DetailsIcon1.png"/></td><td style="width: 80px;" class="dataclr text-center">'+obj.createDate+'</td><td style="width: 80px;" class="dataclr-1 text-center">'+obj.uploadSource+'</td> </tr> ');
               
      	});
      }
      function onClickDetails(name,documentType,propertyName){
      	var keyword=$('#Documenttxt').val();
  		var compId='<%= cid%>';
  		var sessionid= '<%=sessionid%>';
  var str="id="+name+"&sessionId="+sessionid+"&comid="+compId+"&keyword="+keyword+"&documentType="+documentType+"&propertyName="+propertyName+ "&formAction=";
  var Text = "./EditDocument?"+str;
  var randomnumber = Math.floor((Math.random()*100)+1); 
  window.open(Text,"_blank",'PopUp'+randomnumber+'	 ,scrollbars=1,menubar=0,resizable=1,width=850,height=500')  
      }
      var theChild;
    function getPdf(filename,version,actualfilename,irems) {
		var keyword=$('#Documenttxt').val();
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
    	theChild.onload = function(){ 
    	    /* my code */ 
    	    this.onbeforeunload = function(e){
    	    	/* console.log("onbeforeunload");
    	    	console.log(e); */
    	    	saveFormData(irems);
    	    	}
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