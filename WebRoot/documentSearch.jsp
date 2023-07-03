<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="formInformation" scope="request" class="com.peniel.beans.FormInformation" />
<jsp:setProperty name="formInformation" property="*" />
<%@page import="java.util.*"%>
<%@page import="java.lang.*"%>
<html lang="en">
  <head>
  <!--   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> -->
    
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <!--  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->
   <script src="js/bootstrap/3.3.5/jquery.min.js"></script>
    
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>FHA Number Search</title>
    <link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<!-- <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" /> -->
		<link rel="stylesheet" href="css/jquery.dataTables.min.css" />  
				<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
				<link rel="stylesheet" href="css/font-awesome.min.css">
		<!-- <script src="js/jQuery/1.11.3/jquery.min.js"></script> -->
		<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
		<script
	src="js/bootstrap/3.3.5/jquery.min.js"></script>
		<script src="js/bootstrap/3.3.5/bootstrap.min.js"></script>	
		<!--  <link href="https://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" /> -->
        <link
	href="css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" />
          <script src="js/jquery.popupoverlay.js"></script>
        <!--  <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> -->
        <script src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
         <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 
      

  <!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
  <!-- <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
  <script src="js/jQuery/jquery-ui.js"></script>
  
  <script
	src="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"></script>
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/dataTables.buttons.min.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.flash.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script> 
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.html5.min.js"></script> 
	 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.print.min.js"></script> 
     <script src="js/dataTables.checkboxes.min.js"></script>
        <script src="js/jQuery/jquery.tablecheckbox.js"></script>
     
  
  <script src="js/searchFilter.js"></script>
         <script>
         var docidselected=[];
         var documentIdszipped=[];
         var actualfileNames=[];
         var docversions=[];
         var fhaSearchtable;
         var rows_selected=[];
         var zipFilePath;
         var checkboxids=[];
  $( function() {
    $( "#startDate" ).datepicker({
    	
        onSelect: function (selected) {
            var dt = new Date(selected);
            dt.setDate(dt.getDate() + 1);
            $("#endDate").datepicker("option", "minDate", dt);
        }
 } );
  } );
  $( function() {
	    $( "#endDate" ).datepicker({
	    
	        onSelect: function (selected) {
	            var dt = new Date(selected);
	            dt.setDate(dt.getDate() - 1);
	            $("#startDate").datepicker("option", "maxDate", dt);
	        }
	    });
	  } );
  
  $( function() {
	    $( "#transStartDate" ).datepicker({
	    	
	        onSelect: function (selected) {
	            var dt = new Date(selected);
	            dt.setDate(dt.getDate() + 1);
	            $("#transEndDate").datepicker("option", "minDate", dt);
	        }
	 } );
	  } );
	  $( function() {
		    $( "#transEndDate" ).datepicker({
		    
		        onSelect: function (selected) {
		            var dt = new Date(selected);
		            dt.setDate(dt.getDate() - 1);
		            $("#transStartDate").datepicker("option", "maxDate", dt);
		        }
		    });
		  } );
  </script>
    <% String appuserrole = (String)request.getSession().getAttribute("appuserrole");
   System.out.println("appuserrole "+appuserrole);
   int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
   String sessionid = request.getSession().getAttribute("sessionid").toString();
   int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
   String userName = request.getSession().getAttribute("username").toString();
   javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
	String companyFullName=request.getSession().getAttribute("companyFullname").toString();
	System.out.println("Company Full Name::#########"+companyFullName);
	
	HashMap hashMap = formInformation.getFormInformation(appuserrole, "",cid+"" );
   	%>		
   <script type="text/javascript">
   $(document).ready(function(){
	   setHeader('documentSearch.jsp');
	   var array_of_li =  document.querySelectorAll("ul.tab-nav li");
		for (var i = 0; i < array_of_li.length; i++) {
		if(i == 0)
			array_of_li[i].setAttribute("class", "active");	
			
		}
	   $("#searchResTable").css("display", "none");
		$("#searchResTableProp").css("display", "none");
		//$('#my_popup').popup('hide');
	   getDocumentType();
	   getTransactionType();
	   getTransactionStatus();
	   $('#my_popup').popup('hide');
	   showListOFFilesOFDocSearch(<%=cid%>,'<%=restURL%>');
	   getLoanTypes();
	   
   });
   
   function getLoanTypes(){
	   var companyId=<%= cid %>;
	   $.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getLoanTypes?companyId="+companyId,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {  
			       for(i=0;i<data.response.length;i++){
			    	   $("#loanType").append("<option value='"+data.response[i].loanType+"'><b>"+data.response[i].loanType+"</b></option>");
			      } 
			    		},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		     });
   }
   
   function getDocumentType(){
	   
	   var companyIdValue= '<%= cid %>';
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getDocumentTypes?companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
			       for(i=0;i<data.response.length;i++){
			         $("#docType").append("<option value='"+data.response[i].documentType+"'><b>"+data.response[i].documentType+"</b></option>");
			      }  
			   },
			error : function(e) {
				
			},
			done : function(e) {
				console.log("DONE");
			}
		}); 
   }
   
 function getTransactionStatus(){
	   
	   var companyIdValue= '<%= cid %>';
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getTransactionStatus?companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
			       for(i=0;i<data.response.length;i++){
			         $("#transactionStatus").append("<option value='"+data.response[i].transactionStatusDesc+"'><b>"+data.response[i].transactionStatusDesc+"</b></option>");
			      }  
			   },
			error : function(e) {
				console.log("error");	
			},
			done : function(e) {
				console.log("DONE");
			}
		}); 
   }
   
   function onChangeOfSelectDoc(){
	   var array=[];
	   for(i=0;i<checkboxids.length;i++){
	   array=((checkboxids[i]).split("+"));
 	   var docIdWithpath=array[0];
        documentIdszipped.push(docIdWithpath);
 	   docidselected.push(docIdWithpath+"$");
 	   actualfileNames.push(array[1]);
 	   docversions.push(array[3]);
	   }
	}
   
    function checkZipSize(){
    	$('#emailAlert').text('');
    var companyId = '<%=cid%>';
   	 var userId='<%=uid%>';
   	 var userName = '<%= userName%>';
   	onChangeOfSelectDoc();
  	   $("#selectedFilesToZip").empty();    	
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/audit/zipFiles?companyId="+companyId+"&userId="+userId+"&userName="+userName+"&fileNames="+docidselected+"&actualfileNames="+actualfileNames,
			dataType : 'json',
			timeout : 100000,
			success : function(data) { 
				    if(data.status=="success"){
				    	$('#showAlert').text('');
				    	 zipFilePath=(data.zipFilePath).replace(/\\/g,"/");
				    	 getUsersListforEmail(actualfileNames,userId,userName,companyId);
				    } else{
					$('#showAlert').text(data.status);
					docidselected=[];
			        documentIdszipped=[];
			        actualfileNames=[];
			        docversions=[];
			        zipFilePath="";
				    }
				    
			    		},
			error : function(e) {
				console.log("ERROR: ",e);
				//alert("error in sharing files");
			},
			done : function(e) {
				console.log("DONE");
				//alert("done");
			}
		     });
 
   }
  function saveAuditTrailSessionLog(emailSentToUsers,companyId,userId){
	  var documentData={
				 "session":'<%=sessionid%>',
				 "userId":userId,
				 "companyId":companyId,
				 "docIdsZipped":documentIdszipped,
				 "docVersions":docversions,
				 "emailSentToUsers":emailSentToUsers
		}
			$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/audit/saveAuditForDocsZipMailed",
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
	   $('#my_popup').popup('hide');
		$('#emailAlert').css('color','darkgreen');
	  $('#emailAlert').text("Email sent successfully");
	  $("#userForEmail option:selected").prop("selected", false);

	  }
  function closeShareFiles(){
	  $('#shareFiles').modal('toggle');
	    docidselected=[];
        documentIdszipped=[];
        actualfileNames=[];
        docversions=[];
        rows_selected=[];
        zipFilePath="";
       checkboxids=[];
       //fhaSearchtable.$('input').removeAttr( 'checked' );
       getFilesist();
  }
   function zipAndSendEmail(){
	   var companyId = '<%=cid%>';
	   	 var userId='<%=uid%>';
	   	 var userName = '<%= userName%>';
    var emailSentToUsers=[];
	var selectedUsersForEmail=[];
	if($('select[name=userForEmail] option:selected').size()==0){
		$('#emailAlert').css('color','red');
		$('#emailAlert').text('Please select atleast one user to email');
		
	} else{
		$('#my_popup').popup('show');
		$('#emailAlert').css('color','darkgreen');
		$('#emailAlert').text('');
	$('#userForEmail>option:selected').each(function() {
		  selectedUsersForEmail.push(($(this).val()));
		  emailSentToUsers.push($(this).text());
		  });
	   
	   $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "<%=restURL%>/audit/emailZip?selectedUsersForEmail="+selectedUsersForEmail+"&companyId="+companyId+"&userName="+userName+"&userId="+userId+"&zipFilePath="+zipFilePath,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {  
					  saveAuditTrailSessionLog(emailSentToUsers,companyId,userId);
			    		},
			error : function(e) {
				console.log("ERROR: ", e);
				//alert("error in getting userlist");
			},
			done : function(e) {
				console.log("DONE");
				//alert("done");
			}
		     });
	}
	   
   }
   function getUsersListforEmail(actualfileNames,userId,userName,companyId){
       			   $.ajax({
					type : "POST",
					contentType : "application/json",
					url : "<%=restURL%>/audit/getUsersForEmailDropdown?companyId="+companyId,
					dataType : 'json',
					timeout : 100000,
					success : function(data) {  
					       for(i=0;i<data.usersListForEmail.length;i++){
					    	   $("#userForEmail").append("<option value='"+data.usersListForEmail[i].email+"' >"+data.usersListForEmail[i].firstName+" "+data.usersListForEmail[i].lastName+"</b></option>");
					      } 
					    		},
					error : function(e) {
						console.log("ERROR: ", e);
					//	alert("error in getting userlist");
					},
					done : function(e) {
						console.log("DONE");
					//	alert("done");
					}
				     });
			   
			   
			   $("#selectedFilesToZip").empty();
			   for(i=0;i<actualfileNames.length;i++){
		           $("#selectedFilesToZip").append("<tr><td id='fileid' >"+actualfileNames[i]+"</td></tr>");
		           
		       }
			 $("#shareFiles").show();
		 		 
			}
 function getTransactionType(){
	   
	   var companyIdValue= '<%= cid %>';
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "<%=restURL%>/orcf/getTransactionTypes?companyId="+companyIdValue,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
			       for(i=0;i<data.response.length;i++){
			         $("#propertyType").append("<option value='"+data.response[i].transactionTypeId+"'><b>"+data.response[i].transactionType+"</b></option>");
			      }  
			   },
			error : function(e) {
				
			},
			done : function(e) {
				console.log("DONE");
			}
		}); 
   }
   

function clearFields(type){
	$("#propertyId").val('');
	$("#propertyNm").val('');
	$("#fhaNum").val('');
	$("#docType").val('');
    $("#loanAmt").val('');
    $("#lenderNm").val('');
	$("#startDate").val('');
	$("#endDate").val('')
	//$("#documentStatus").val('');
	$("#loanType").val('');
 	$("#transactionStatus").val('');
	$("#transactionType").val('');
	$("#transactionDate").val('');
	$("#transStartDate").val('');	
	$("#transEndDate").val('');	
       $("#propertyType").val('');
}

function clearResults(){
	//$("#getDocumentList").empty();
	$("#tableStyle1").hide();
}
function getFilesist(){
	$('#my_popup').popup('show');
	$('#basic').css("display","block");
/* $('#my_popup').popup('show');	
	$('#my_popup_background').css("z-index","999999");
	$('#basic').css("display","block"); */
	$('#shareFilesBtn').show();
	$('#showAlert').text('');
	$("#searchResTableProp_wrapper").hide();
	$("#searchResTable").show();
	$('#my_popup').popup('show');
	
	   
	   	 var companyId = '<%=cid%>';
	   	 var userIdvalue='<%=uid%>';
	   	 var tbl = '';
	   	  var testData={
	   			         "propertyId":$("#propertyId").val(),
	   				     "propertyName":$("#propertyNm").val(),
	   			  	      "fhaNumber":$("#fhaNum").val(),
	   			  	      "docType":$("#docType").val(),
	   			  	     "loanType":$("#loanType").val(),
	   			  	     "loanAmount":$("#loanAmt").val(),
	   			  	     "lenderName":$("#lenderNm").val(),
	   			  	     "startDate":$("#startDate").val(),
	   			  	     "endDate":$("#endDate").val(),	   			  	     
	   			  	     "loanTypeData":'',			  	     
	   			  	     "companyId":companyId,
	   			  		 "propertyType":$("#propertyType").val(),
	   				 	 "transactionType":$("#propertyType").val(),
	   				  "transStartDate":$("#transStartDate").val(),	
		  	   			  "transEndDate":$("#transEndDate").val(),				  	   
		  	    		 "transactionStatus":$("#transactionStatus").val(),
	   			  	    "status":$("#documentStatus").val()
	   	     
	   	   };
	   	  
	   /* 	  $("#searchResTable").DataTable().ajax.reload();
	    */	// if(isAvailble == true){
	   	
	    
	   	 $.ajax({
	   		 
	   	  type : "POST",
	   	  contentType : "application/json",
	   		url : "<%=restURL%>/orcf/getDocumentList",
	         dataType : 'json',
	   	  timeout : 100000,
	   	  data : JSON.stringify(testData),
	   	  success : function(data) {
	   		 $('#my_popup').popup('hide');
	   		$("#tableStyle1").show();
	   		   console.log("SUCCESS:::::"+JSON.stringify(data));
	   		  if ($.fn.DataTable.isDataTable("#searchResTable")) {
				  $('#searchResTable').DataTable().clear().destroy();
				}
	   		data=displayData(data);
	   		  
	   		$("#searchResTable").dataTable({
	   			
				 dom: 'lBfrtip',
			        buttons: [
			        	{ extend : 'excelHtml5'
			        	},
			        		{extend : 'pdfHtml5',
		                orientation : 'landscape',
		                pageSize : 'LEGAL',
		               // text : '<i class="fa fa-file-pdf-o"></i>'
		                titleAttr : 'PDF'
		            } ,{
		                text: 'Share Files',
		                className: "sharefilesbtn",
		                action: function ( e, dt, node, config ) {
		                	checkIfDocumentsSelected();
		                }
		            }
				        ],
				  "order": [[ 6, "asc" ]],
		          "deferRender":    true,
		          "scroller":       true,
		          'rowCallback': function(row, data, dataIndex){
		              // Get row ID
		              var rowId = data[0];

		              // If row ID is in the list of selected row IDs
		              if($.inArray(rowId, rows_selected) !== -1){
		                 $(row).find('input[type="checkbox"]').prop('checked', true);
		                 $(row).addClass('selected');
		              }
		           },
		           "drawCallback": function(){
		        	   // Update state of "Select all" control
		        	   updateDataTableSelectAllCtrl($("#searchResTable").DataTable());
		        	}
		    
		    }); 
	   		
	   		/* $("#searchResTable").dataTable({
				  "order": [[ 6, "asc" ]],
		          "deferRender": true
		    
		    }); */ 
		    fhaSearchtable=	$("#searchResTable").DataTable();
			$("#searchResTable_length").css('margin-left', '240px');
			/* $('.buttons-excel').css('margin-left', '136px'); */
			$("#searchResTable_wrapper").css('padding','10px 0px');
			//$("#searchResTable_wrapper").html('<button type="button" id="shareFilesBtn" style="bottom: -35;left: -100;border-top-width: -1;margin-top: 1px;border-top-width: 0px;" class="btn btn-success waves-effect waves-button waves-float f-family center-block" onclick="checkIfDocumentsSelected();" class="btn btn-info btn-lg"  >Share Files</button>');
			// Handle click on "Select all" control
			$('thead input[name="select_all"]', fhaSearchtable.table().container()).on('click', function(e){
			   if(this.checked){
			      $('#searchResTable tbody input[type="checkbox"]:not(:checked)').trigger('click');
			   } else {
			      $('#searchResTable tbody input[type="checkbox"]:checked').trigger('click');
			   }

			   // Prevent click event from propagating to parent
			   e.stopPropagation();
			});

	   	  },
	   	  error : function(e) {
	   	   console.log("ERROR: ", e);
	   	       
	   	  },
	   	  done : function(e) {
	   		 
	   		//  tbl.fnClearTable(this);
	   	  }
	   	 
	   	 });
	   	/*  }else{
	   		 alert("Provide:"+message);
	    } */
	   	
	  	$('#getDocumentList').empty();
	
		 
		}
//Handle table draw event
/* $("#searchResTable").Datatable().on('draw', function(){
   // Update state of "Select all" control
   updateDataTableSelectAllCtrl(table);
}); */
 

function displayData(data) {
	
	var imageName;
	
	$.each(data.getDocumentList, function(i, item) {
		if(item.actualFileName!=null){
		var fileNameExt = item.actualFileName.substr(item.actualFileName.lastIndexOf('.') + 1);
		console.log("actualFileName:"+fileNameExt);
		if(fileNameExt.toLowerCase() === "pdf"){
			imageName="pdfViewer.gif";
		}
		else if(fileNameExt.toLowerCase() === "jpg" || fileNameExt.toLowerCase() === "jpeg"){
			imageName="jpegsma.jpg";
		}
		else if(fileNameExt.toLowerCase() === "doc" || fileNameExt.toLowerCase() === "docx"){
			imageName="docLatest.png";
		}
		else if(fileNameExt.toLowerCase() === "xls" || fileNameExt.toLowerCase() === "xlsx"){
			imageName="excel_file.png";
		}
				
		}
		item.lenderName=='null'|| null ?item.lenderName='':item.lenderName == null ? item.lenderName='':item.lenderName;
		item.loanAmount=='null'|| null ?item.loanAmount='':item.loanAmount == null ? item.loanAmount='':item.loanAmount;
		item.disposalDate === null  ?item.disposalDate='':item.disposalDate;
		item.actualFileName === null  ?item.actualFileName='':item.actualFileName;
		item.closingDate === null  ?item.closingDate='':item.closingDate;
		console.log("597::::::::::;:"+item.lenderName);
		console.log("598::::::::::;:"+item.loanAmount);
	     $('#getDocumentList').append('<tr><td><input type="checkbox" name="selectDoc" id="selectDoc'+i+'\" class="selectDoc" onclick="checkSelection('+i+');\" name="selectDoc" value="'+item.fileName+'+'+item.actualFileName+'+'+item.folderName+'+'+item.version+'"></td><td><a href="javascript:getPdf(\''+item.fileName+'\',\''+item.fileSize+'\',\''+item.version+'\');" >'+item.actualFileName+'&nbsp;&nbsp; ('+item.fileSize+')  &nbsp;&nbsp;<img class="displayFolderList" src="./images/'+imageName+'" alt="View Document" style="width:20px" border=0></a><br><span style="line-height: 2.5;"><a id="docSearc'+i+'" onclick="documentdata(\''+i+'\',\''+item.folderName+'\',\''+item.propertyName+'\',\''+item.indexValue+'\',\''+item.loanType+'\',\''+item.loanAmount+'\',\''+item.lenderName+'\',\''+item.closingDate+'\',\''+item.status+'\');" href="#myModal">'+item.folderName+'</a></span></br></td>><td>'+item.documentType+'</td></td><td><a id="details" onclick="editDoc(\''+item.fileName+'\',\''+item.fileName+'\',\''+item.getIndexType+'\',\''+item.getIndexValue+'\',\''+item.getDocumentType+'\',\''+item.fileName+'\',\''+item.getDocId+'\',\''+item.version+'\',\''+item.getIndexTypeId+'\',\''+item.getDocTypeId+'\')">Details</a></td><td>'+item.status+'</td><td>'+item.closingDate+'</td><td>'+item.disposalDate+'</td></tr>');
	});
}

function documentdata(i,propertyId,propertyName,fhaNumber,loanType,loanAmt,lenderName,closingDate,status){
	
	//alert(propertyId+"propertyId")
	if(propertyId != '/Legacy Data/'){
    var randomnumber = Math.floor((Math.random()*100)+1); 
   // window.open("propertyDataSearch.jsp?propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=850,height=500');
    window.open("propertyDataSearch.jsp?propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType+"&loanAmt="+loanAmt+"&lenderName="+lenderName+"&closingDate="+closingDate+"&status="+status,"_blank",'PopUp'+randomnumber+',toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=1,width=850,height=500');
	   
}	
	else
		{		
		// $('#myModal').removeAttr("href");
	
		 $('#docSearc'+i).attr("disabled","disabled").css('cursor','default');
		}
	
}

//function editDoc(id, indTyp, val, dcTyp, status, docId, version, indexTypeId, docTypeId, formAction) {
	  
	function editDoc(id, indTyp, val, dcTyp, status, docId, version, indexTypeId, docTypeId, formAction) {

	    var user = '<%= uid%>';
	    var com = '<%= cid%>';
	    var session = '<%= sessionid%>';
	    var userName = '<%= userName%>';


	/*     delCookie("INDEX_TYPE_1");
	    delCookie("INDEX_TYPE_2");
	    delCookie("INDEX_TYPE_3");
	    delCookie("INDEX_TYPE_4");
	    delCookie("INDEX_TYPE_5");
	    delCookie("INDEX_VAL_1");
	    delCookie("INDEX_VAL_2");
	    delCookie("INDEX_VAL_3");
	    delCookie("INDEX_VAL_4");
	    delCookie("INDEX_VAL_5");
	    delCookie("DOC_TYPE_1");
	    delCookie("DOC_TYPE_2");
	    delCookie("DOC_TYPE_3");
	    delCookie("DOC_TYPE_4");
	    delCookie("DOC_TYPE_5");
	    delCookie("DOC_STATUS_1");
	    delCookie("DOC_STATUS_2");
	    delCookie("DOC_STATUS_3");
	    delCookie("DOC_STATUS_4");
	    delCookie("DOC_STATUS_5");
	    delCookie("COOKIE_TRACKER"); */

	 /*    setCookie("DIV_CNT", divCnt); */

	    var Text = "./EditDocument?id=" + id + "&indTyp=" + indTyp + "&val=" + val + "&dcTyp=" + dcTyp +
	            "&userid=" + user + "&comid=" + com + "&sessionid=" + session + "&userName=" + userName +
	            "&status=" + status + "&docId=" + docId + "&version=" + version + "&docTypeId=" + docTypeId +
	            "&indexTypeId=" + indexTypeId + "&formAction=";

	   // window.location = Text;
	   // window.open(Text);
	    var randomnumber = Math.floor((Math.random()*100)+1); 
/* 	    window.open(Text,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=no,location=no,resizable=1,width=950,height=800')
 */	    
   window.open(Text,"_blank",'PopUp'+randomnumber+'	 ,scrollbars=1,menubar=0,resizable=1,width=850,height=500')   

}
<%-- function getPdf(filename) {
	
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	
	var id = filename;
	
	var Text = "./DisplayPdf?id="+id+"&comid="+com+"&sessionid="+session+"&userName="+userName;
	window.open(Text,'','width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');	
} --%>


function getPdf(filename,fileSize,version) {

var user = '<%= uid%>';
var com = '<%= cid%>';
var session = '<%= sessionid%>';
var userName = '<%= userName%>';
var downloadOriginal=false;
var fileNameExtension = filename.substr(filename.lastIndexOf('.') + 1);
var action="";

//Kiran Changes Starts
if(fileNameExtension=="pdf"){
	action="View Document";
}else{
	action="Download Document";
}
var docId=filename;
var documentData=[];
//documentData=docId.split('.');
sessionStorage.setItem('sessLogCompId',com);
sessionStorage.setItem('sessLogSessid',session );

sessionStorage.setItem('sessLogRestUrl','<%=restURL%>' );

sessionStorage.setItem('sessLogUserid',user );
sessionStorage.setItem('sessLogver',version);
sessionStorage.setItem('sessLogdocid',docId ); 
var documentData={
		 "sessionId":session,
		 "userId":user,
		 "companyId":com,
		 "documentId":docId,
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

//Kiran Changes Ends

var fileSizedata=fileSize.substring(0,fileSize.length - 2); 
var bytedata=fileSize.substring(fileSize.length - 2,fileSize.length); 


if(bytedata.toLowerCase() == 'mb' && fileSizedata > 10)
	{
		downloadOriginal=true;
	}
	
var id = filename;

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

<%-- 	else {

		// var Text = "./DisplayPdf?id=" + id + "&userid=" + user + "&comid="
			//	+ com + "&sessionid=" + session + "&userName=" + userName;
		 
		  var pdfurl = '<%=restURL%>'+"/role/ResponseBodyStreamFixed?id="+ id;
		 
		// alert("pdfurl"+pdfurl)
		
		var Text = "displayPdf.html";
		
		 sessionStorage.setItem('pdfurl',pdfurl);
		 sessionStorage.setItem('filename',id);
				
		 window
				.open(
						pdfurl,
						'',
						'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes'); 
						
						

	} --%>
	
	else {

	sessionStorage.setItem('downloadOriginal',downloadOriginal);
	
						var fPath = "<%=restURL%>/role/invokeFile?id="+id;
						console.log("365..."+fPath);
						$.ajax({					   		 
						   	type : "GET",
						    contentType : "application/json",
						   	url : "<%=restURL%>/role/invokeFile?id="+id,
						   	timeout : 100000,
						   	success : function(resp) {
						   		console.log("success getting file"+resp);
						   		//sessionStorage.setItem('filename',"../../../../TransAccessImagingWS/role/downloadOriginal?id=FHA232/webtest1/"+resp);
						   		 sessionStorage.setItem('filename',"../../../../TransAccessImagingWS/role/downloadDocument?docId="+resp.substring(0,resp.lastIndexOf("_")));
								//var pdfurl1='viewer.html?file='+resp;
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
		  
			//var Text = "displayPdf.html";
			
			//sessionStorage.setItem('filename',id);
					
			/*  window
					.open(
							Text,
							'',
							'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');  */
		/* 					
			window
				.open(
						pdfurl1,
						'',
						'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes'); */
				
	}
}

function getPropertyList(type){
	
		
 var datatype="";
 

 if(type.length > 1){
	 
	 datatype=type;
 }
 else{
	 
	 datatype=$("#loanType").val();
 }
	 var companyId = '<%=cid%>';
	 var userIdvalue='<%=uid%>';
	 var tbl = '';
	  var testData={
			         "propertyId":$("#propertyId").val(),
			  	     "propertyName":$("#propertyNm").val(),
			  	     "city":$("#city").val(),
			  	     "state":$("#state").val(),
			  	     "zip":$("#zip").val(),
			  	     "fhaNumber":$("#fhaNum").val(),
			  	     "loanType":$("#roleNameVal").val(),
			  	     "loanAmount":$("#loanAmt").val(),
			  	     "lenderName":$("#lenderNm").val(),
			  	     "startDate":$("#startDate").val(),
			  	     "endDate":$("#endDate").val(),
			  	      "documentStatus":$("#documentStatus").val(),
			  	     "loanTypeData":datatype,			  	     
			  	     "companyId":companyId
	     
	   };

	 $.ajax({
		 
	  type : "POST",
	  contentType : "application/json",
		url : "<%=restURL%>/orcf/getPropertyList",
      dataType : 'json',
	  timeout : 100000,
	  data : JSON.stringify(testData),
	  success : function(data) {
		  
		  /* console.log("SUCCESS    : ", data.getPropertyList.length); */
			$("#propertyList").empty();
			$("#tableStyle1").show();
			if ($.fn.DataTable.isDataTable("#searchResTable")) {
				  $('#searchResTable').DataTable().clear().destroy();
				}
			display(data);
			var tbl = $("#searchResTable").dataTable();
	  },
	  error : function(e) {
	   console.log("ERROR: ", e);
	       
	  },
	  done : function(e) {
		 
		  tbl.fnClearTable(this);
	  }
	 
	 });
	/*  }else{
		 alert("Provide:"+message);
 } */
	 $('#propertyList').empty();
	 
	 
	}
	
	
	
function display(data) {
	// debugger;
	    $.each(data.getPropertyList, function(i, item) {
		   (item.city=='null' || item.city=="null" || item.city==null)?item.city='':item.city;
		   (item.state=='null' || item.state=="null" || item.state==null)?item.state='':item.state;
		   (item.zip=='null' || item.zip=="null" || item.zip==null)?item.zip='':item.zip;
		   (item.documentStatus ==null || item.documentStatus =='null' || item.documentStatus =="null")?item.documentStatus='':item.documentStatus;
		
		$('#propertyList').append('<tr><td><a id="editB" onclick="hello(\''+item.propertyId+'\',\''+stripEndQuotes(item.propertyName)+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');" href="#myModal">'+stripEndQuotes(item.propertyName)+'</a></td><td><a id="editB" onclick="hello(\''+item.propertyId+'\',\''+stripEndQuotes(item.propertyName)+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');">'+item.propertyId+'</a></td><td><a id="editB" onclick="hello(\''+item.propertyId+'\',\''+stripEndQuotes(item.propertyName)+'\',\''+item.fhaNumber+'\',\''+item.loanType+'\');">'+item.fhaNumber+'</a></td><td>'+item.city+'</td><td>'+item.state+'</td><td>'+item.zip+'</td><td>'+item.loanType+'</td><td>'+item.documentStatus+'</td></tr>');

		   console.log("item.city==null:"+item.city==null);
		   console.log("item.city=='null':"+item.city == 'null');
		   console.log("item.city=='null': 2"+item.city );
		
	});
}


 function hello(propertyId,propertyName,fhaNumber,loanType){
	// alert("propertyId"+propertyId);
	 if(propertyId != '/Legacy Data/'){
    var randomnumber = Math.floor((Math.random()*100)+1); 
    window.open("propertyDataSearch.jsp?propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=1000,height=500');
	 }
	 else
		{		
		 $('#myModal').removeAttr("href");
		}
	 
}
function stripEndQuotes(s){
	var t=s.length;
	if (s.charAt(0)=='"') s=s.substring(1,t--);
	if (s.charAt(--t)=='"') s=s.substring(0,t);
	return s;
}
function hello12(propertyId,propertyName,fhaNumber,loanType){
	/* var res = id + "\\" +type;
	
	alert("res"+res);
	 */

	 var randomnumber = Math.floor((Math.random()*100)+1); 
	    window.open("propertyDataSearch.jsp?propertyId="+propertyId+"&propertyName="+propertyName+"&fhaNumber="+fhaNumber+"&loanType="+loanType,"_blank",'PopUp'+randomnumber+',scrollbars=1,menubar=0,resizable=1,width=1000,height=500');

}


function handleSelect(type)
{
	if(type=="property"){
		   $( "#selectArea option:selected" ).text();
		   window.location.href = 'propertySearch.jsp';
	   }else if(type=="document"){
		   $( "#selectArea option:selected" ).text();
		   window.location.href = 'documentSearch.jsp';
	   }else if(type=="transaction"){
		   $( "#selectArea option:selected" ).text();
		   window.location.href = 'transactionSearch.jsp';
	   }
}
//--------------------------------
// Handle click on checkbox

 function checkSelection(i){
	var $row = $("#selectDoc" + i).closest('tr');
	var checkboxid="#selectDoc" + i;
	if($(checkboxid).is(":checked")){
		checkboxids.push($(checkboxid).val());
	}else {
		checkboxids=jQuery.grep(checkboxids, function(value) {
			  return value != $(checkboxid).val();
	});
	}
   // Get row data
   var data = fhaSearchtable.row($row).data();

   // Get row ID
   var rowId = data[0];

   // Determine whether row ID is in the list of selected row IDs 
   var index = $.inArray(rowId, rows_selected);

   // If checkbox is checked and row ID is not in list of selected row IDs
   if(this.checked && index === -1){
      rows_selected.push(rowId);

   // Otherwise, if checkbox is not checked and row ID is in list of selected row IDs
   } else if (!this.checked && index !== -1){
      rows_selected.splice(index, 1);
   }

   if(this.checked){
      $row.addClass('selected');
   } else {
      $row.removeClass('selected');
   }

   // Update state of "Select all" control
   updateDataTableSelectAllCtrl(fhaSearchtable);

   // Prevent click event from propagating to parent
   /* e.stopPropagation(); */
 }

// Handle click on table cells with checkboxes
$('#searchResTable').on('click', 'tbody td, thead th:first-child', function(e){
   $(this).parent().find('input[type="checkbox"]').trigger('click');
});


// Handle form submission event 
//$('#frm-example').on('submit', function(e){
function checkIfDocumentsSelected()	{
	  if($(".selectDoc:checked").length==0){
			$('#showAlert').text("Please Select Atleast One Document To Share");
	  }
	  if($(".selectDoc:checked").length!=0){
		  checkZipSize();
	   }

}
function updateDataTableSelectAllCtrl(table){
		
	   var $table             = table.table().node();
	   var $chkbox_all        = $('tbody input[type="checkbox"]', $table);
	   var $chkbox_checked    = $('tbody input[type="checkbox"]:checked', $table);
	   var chkbox_select_all  = $('thead input[name="select_all"]', $table).get(0);

	   // If none of the checkboxes are checked
	   if($chkbox_checked.length === 0){
	      chkbox_select_all.checked = false;
	      if('indeterminate' in chkbox_select_all){
	         chkbox_select_all.indeterminate = false;
	      }

	   // If all of the checkboxes are checked
	   } else if ($chkbox_checked.length === $chkbox_all.length){
	      chkbox_select_all.checked = true;
	      if('indeterminate' in chkbox_select_all){
	         chkbox_select_all.indeterminate = false;
	      }

	   // If some of the checkboxes are checked
	   } else {
	      chkbox_select_all.checked = true;
	      if('indeterminate' in chkbox_select_all){
	         chkbox_select_all.indeterminate = true;
	      }
	   }
	}



  </script>
    <!-- Bootstrap -->
<!--     <link href="css/bootstrap.min.css" rel="stylesheet">
 -->    <link href="css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
    <!--SRIBALA-->
    .mdlbdy label{vertical-align: top;}
.mdlbdy input{vertical-align: top;margin-left: 20px;border: 1px solid #ccc;border-radius: 5px;padding: 5px 5px;}
.submitbtn {text-align: center;margin-top: 15px;}
.modal-header{background-color: #7098CC;
	    color: #fff;}
.modal-title{color:white;}
.close{color: #fff;opacity: 1;}
.modal-content{width: 85%;margin: auto;}
.mdlbdy select{border: 1px solid #ccc;border-radius: 5px;width: 220px;
    height: 105px;}
table.dataTable.select tbody tr,
table.dataTable thead th:first-child {
  cursor: pointer;
}
    .btnPropty:active,.btnPropty:focus,.btnPropty:hover{
        border: 2px solid #ff9800 !important;
       }
  
      .btnPropty.active{
       border: 2px solid #ff9800 !important;
       }
  
    
	.btnPropty{
    background: transparent;
    padding: 10px 0px;
    margin-right: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: -2px 3px 4px #ccc;
    margin-bottom: 20px;
    width: 200px;
	}
	
	.fullarticle { 
  		display: none;
	}
	.panel-body{
		text-align: left;
		padding-left: 15px;
	}
	.modal {
	  text-align: center;
	  padding: 0!important;
	}
	.workingArea {
    
    border: 0px solid #867171 !important;    
    box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.9) !important;
}
	.modal:before {
	  content: '';
	  display: inline-block;
	  height: 100%;
	  vertical-align: middle;
	  margin-right: -4px;
	}
	.modal-dialog {
	  display: inline-block;
	  text-align: left;
	  vertical-align: middle;
	}
	.buttonAction {
		position: absolute;
	    top: 14px;
	    right: 20px;

	}
	.applicationMainContentAreaContainer { position: relative; }
	table.dataTable thead th {
	    background-color: #7098CC;
	    color: #fff;
	}
	#moduleLists_filter input {
		height: 35px;
	    border: 1px solid #ccc;
	    box-shadow: inset 0 0 3px #ccc;
	}
	#moduleLists_length select {
		padding: 10px;
	    border: 1px solid #ccc;
	    box-shadow: inset 0 0 3px #ccc;
	}
	.dataTables_filter { margin-bottom: 10px; }
	
	.dt-buttons {
    left: 0px !important;
    
    position: absolute !important;
}


a.dt-button.buttons-excel.buttons-html5 {
   
background: #4ba34b !important;
    border: 1px solid #ddd  !important;
    padding: 4px 20px  !important;
    vertical-align: -webkit-baseline-middle !important;
    color: #fff  !important;
    border-radius: 6px  !important;

}

a.sharefilesbtn{
background: #4ba34b !important;
    border: 1px solid #ddd  !important;
    padding: 4px 20px  !important;
    vertical-align: -webkit-baseline-middle !important;
    color: #fff  !important;
    border-radius: 6px  !important;   
}

a.sharefilesbtn span{
    margin-left: -15;
    margin-right: -15;
}

a.dt-button.buttons-pdf.buttons-html5{

background: #4ba34b !important;
    border: 1px solid #ddd  !important;
    padding: 4px 20px  !important;
    vertical-align: -webkit-baseline-middle !important;
    color: #fff  !important;
    border-radius: 6px  !important;
    
}
	
	</style>	
	
<!-- Get roles and rights -->			
		
		
		
		
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
    	
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<!-- <script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" /> -->
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" /> 
    
  </head>
  <DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>
  
    <jsp:include page="includes/sessionHeader.jsp" />
 
  <body>
    
	<!--- Header ----->
	<!-- <header id="transMenu">
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		  <div class="row">
		  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>                        
			  </button>
			  <a class="navbar-brand" href="#">Office of Residential Care Facilities Document Management System<br> <sub class="pull-right mtop10">Powered by Transaccess(PSL)</sub></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
			  
			  <ul class="nav navbar-nav navbar-right">
				<li><a href="#"> My Profile</a></li>
				<li><a href="#"> Home</a></li>
				<li><a href="#"> Admin</a></li>
				<li><a href="#"> Logout</a></li>
			  </ul>
			</div>
			</div>
			</div>
		  </div>
		</nav>
	</header> -->
	<!--- Header ----->
	
	<!--- content Part --->
	<section>
	 <div class="container-fluid">
		<div class="row" style="border: 1px solid #a5a1a1;">
		<div class="col-lg-12" style="margin-top: 30px;margin-bottom: 20px;color: #ff9900;font-size: 22px;font-weight: bold;text-transform: capitalize;">
				<div class="text-center">Welcome To <%=companyFullName %> </div>
				<div class="text-center" >Document Management System </div>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-6">
					<div class="text-left" id="propertiesCount" style="font-size: 14px;font-weight: bold;margin-top: 15px;margin-bottom: 30px; color: #0A68B4;">The System Currently Contains: </div>
				</div>
				<div class="col-lg-6">
				<div class="text-right" id="filesCount" style="font-size: 14px;font-weight: bold;margin-bottom:30px;margin-top: 15px;color: #0A68B4;">The System Currently Contains: </div>
				</div>
			</div>
			<div class="col-lg-12">
				<div style="text-align:left;margin-bottom: 15px;margin-left:15px;font-size: 14px;font-weight:bold;">Total Properties by Loan type</div>
					<div style="display:table;" id="loanTypePropertyList">
					</div>
			</div>
		</div>
	</div>
	      <!--  <div class="container-fluid">
		<div class="row" style="border: 1px solid #a5a1a1;padding: 30px 0px;">
			<div class="col-lg-12">
				<div class="col-lg-6">
					<div class="text-center" id="propertiesCount" style="font-size: 14px;font-weight: bold;">The System Currently Containes :</div>
				</div>
				<div class="col-lg-6">
				<div class="text-center" id="filesCount" style="font-size: 14px;font-weight: bold;">The System Currently Containes :</div>
				</div>
			</div>
			<div class="col-lg-12" style="margin-top: 30px;margin-bottom: 20px;color: #0A68B4;font-size: 25px;">
				<div class="text-center">Welcome to office of Residential Care Facilities </div>
				<div class="text-center" style="font-weight: bold;">Document Management System </div>
			</div>
			<div class="col-lg-12">
				<div style="text-align:left;margin-bottom: 15px;margin-left: 40px;font-size: 14px;font-weight:bold;">Total Properties by Loan type</div>
				
					<div style="display:table;" id="loanTypePropertyList">
						
					
					</div>
					
					
			</div>
			
		</div>
	</div> -->
		<!--- Part1 ---->
		<!-- 	<div id="welcomeArea" class="borderAll">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="text-center">
								<h5>Welcome to the Office of Residential Care Facilities Document Management System</h5>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
							<br />
							<ul class="list-none pleft0">
								<li class="text-capitalize"><p id ="filesCount">the system currently containes : </span></li>
								<li class="text-capitalize"><p id ="propertiesCount">the system currently containes : </p></li>
								<li class="text-capitalize"><p id ="loanCount">the system currently containes : </p></li>	
								<table class="pull-left">
								<tr>
							<td><p id ="propertiesCount" class="text-capitalize">the system currently containes : </p></td>
						
							</tr>
							<tr>
							<td><p id ="filesCount"  class="text-capitalize">the system currently containes : </p></td>
							
							</tr>
							
							<tr>
							<td><p id ="loanCount" class="text-capitalize">the system currently containes :  </p></td>
							
							</tr>
							
							</table>						</ul>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 pull-right">
							<div class="pull-right">
							<div class="f-family" ><h5><b>Total properties by Loan type</b></h5></div>
							<div style="cursor: pointer;">
								<ul class="list-none pleft0 pull-right">
									<li><h6 class="text-primary margin5" id="loanTypePropertyList"></h6></li>
								</ul>
								<table><h6 class="text-primary margin5" id="loanTypePropertyList"></h6></table>
							</div>
							</div>
						</div>
					</div>
				</div>
			</div> -->
		 <!--- Part1 ---->
		   <div id="my_popup">
	<div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em;  display: none; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
    <h4><i class="zmdi_large zmdi-settings zmdi-hc-spin"></i> Loading Contents...Please Wait...</h4>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;It will take few seconds.</p>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;Please wait while the contents are loading.</p>
    
	</div>
	
  </div>
		<!--- Part2 - Search ---->
			<div id="searchArea" class="borderAll" style="margin-top: 25px;">
				<div class="container-fluid">
					<div class="row">
						<br />
						<div class="col-lg-offset-4 col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<div class="text-center">
								<h5><b class="f-family">FHA Number Search</b></h4>
							</div>							
						</div>
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<div class="pull-right">
								<label><h5 class="f-family">Search Type</h4></label>
								<select id="selectArea" class="selectArea"  onchange="javascript:handleSelect(this.value)">
									<option value="document" selected>FHA Number Search</option>
									<option value="property" >Property Name Search</option>								
								   <option value="transaction">Transaction Search</option>			
								</select>
							</div>
						</div>
						<div class="clearfix"></div>
						<hr class="hrStyle1"/>
										<br />
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 propertysearchForm">
							
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" style="padding-right:20px;">
									<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">FHA Number</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="fhaNum" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle" >Property ID</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="propertyId" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Property Name</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="propertyNm" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Type of Document</label>
											<div class="col-sm-8 posiRelavtive">
											  <select  id="docType" class="selectArea width100per"> <!-- multiple -->
											  	<option value="" selected disabled>Select Type of Search</option>
												<!-- <option>Mortgage Note</option>								
												<option>Regulatory Agreement-Owner</option>								
												<option>Security Agreement</option>
												<option>Closing Memorandum</option>	 -->
																				
											  </select>
											</div>
										</div>
									 <div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Transaction Type</label>
											<div class="col-sm-8 posiRelavtive">
											  <select id="propertyType" class="selectArea width100per"> <!-- multiple -->
											 	<option value="" selected disabled>Select Type of Search</option>
											  </select>
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Transaction Date Range</label>
											<div class="col-sm-8 posiRelavtive">
												<div class="row">
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														 <input id="transStartDate"  type="text" class="form-control col-sm-12 inputStyle1" placeholder="Start" style=width: 100%" >
													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											  			<input id="transEndDate" type="text" class="form-control col-sm-12 inputStyle1" placeholder="End" style=width: 100%">
													</div>
												</div>
												
												</div>
										</div>
										
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" style="padding-left:20px;">
										
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Lender Name</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="lenderNm" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>										
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Loan Type</label>
											<div class="col-sm-8 posiRelavtive">
											  <select id="loanType" class="selectArea width100per"> <!-- multiple -->
											  	<option value="" selected disabled>Select Type of Search</option>
												<!-- <option>241a</option>								
												<option>223a7</option>								
												<option>232i</option>
												<option>223f</option>	
												<option>232nc</option>
												<option>223d</option> -->									
											  </select>
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Loan Amount</label>
											<div class="col-sm-8 posiRelavtive">
											  <span class="glyphicon glyphicon-search searchIcon"></span>
											  <input id="loanAmt" type="search" class="form-control inputStyle" placeholder="Search">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Closing Date Range</label>
											<div class="col-sm-8 posiRelavtive">
												<div class="row">
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
<!-- 														<label class="control-label col-sm-12 lablestyle">Start</label>
 -->														<input id="startDate" type="text" class="form-control col-sm-12 inputStyle1" placeholder="Start" style=width: 100%" >
												
													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
<!-- 														<label class="control-label col-sm-12 lablestyle">End</label>
 -->											  			<input id="endDate" type="text" class="form-control col-sm-12 inputStyle1" placeholder="End" style=width: 100%">
											
													</div>
												</div>
												
												</div>
										</div>	
										
										<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Document Status</label>
											<div class="col-sm-8 posiRelavtive">
											  <select id="documentStatus" class="selectArea width100per"> <!-- multiple -->
											  	<!-- <option value="" selected disabled>All</option> -->
												<option value ="Active">Active</option>								
												<option value ="Inactive" >Inactive</option>								
																				
											  </select>
											</div>
										</div>	
										  	<div class="form-group row">
											<label class="control-label col-sm-3 lablestyle">Transaction Status</label>
											<div class="col-sm-8 posiRelavtive">
											  <select id="transactionStatus" class="selectArea width100per"> 
											  	<option value="" selected disabled>Select Transaction Status</option>
<!-- 												<option >Approved</option>								 -->
<!-- 												<option>Denied</option>		 -->
<!-- 												<option>Approved with Changes</option>								 -->
																				
											  </select>
											</div>
										</div> 
										
									</div>	
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">		
										<br />
										<button class="btn btn-success waves-effect waves-button waves-float f-family center-block" onclick="javascript:getFilesist();"><i class="fa fa-check"></i>  Search</button>
										<button class="btn btn-warning waves-effect waves-button waves-float f-family center-block" onclick="javascript:clearFields(this);"><i class="fa fa-close"></i>  Reset</button>		
										<br />							
									</div>
								</div>
						</div>
					</div>
				</div>
			</div>	
		<!--- Part2 - Search ---->
		
		<!--- Part3 - Search Results---->
			<!-- <div id="searchResults" class="borderAll">
				<div class="container-fluid">
					<div class="">
						<div class="">
							<div class="row">
								<div class="col-lg-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<h5 class="text-left"><b>Search Results</b></h5>
								</div>
								<div class="col-lg-6 col-lg-6 col-md-6 col-sm-6 col-xs-12 pull-right">
									<button class="btn btn-warning waves-effect waves-button waves-float f-family pull-right" onclick="clearResults()"><i class="fa fa-close"></i> &nbsp; Clear Results</button>
								</div>
								<div class="clearfix"></div>
									<hr class="hrStyle1"/>
										<br />
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			                    <div id="tableStyle1" style="display: none;">
			
									<div class="table-responsive">
										
										<table id="searchResTable" class="table table-bordered">
											<thead>
											
													<tr>
													<th>Atual FileName</th>
													<th>File Type</th>
													<th>Version</th>
													<th>DocumentType</th>
													<th>Document Details</th>
													<th>closing date</th>
													
												
												</tr>
											</thead>
											<tbody id="getDocumentList">
												<tr>
													<td class="color-blue">1</td>
													<td class="color-blue">1</td>
													<td class="color-blue">1</td>
													<td>1</td>
													<td>1</td>
													<td>1</td>
													<td>1</td>
												</tr>
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
			 -->
			 <div id="searchResults" class="borderAll">
				<div class="container-fluid">
					<div class="">
						<div class="">
							<div class="row">
								<div class="col-lg-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<h5 class="text-left"><b>Search Results</b></h5>
								</div>
								<div class="col-lg-6 col-lg-6 col-md-6 col-sm-6 col-xs-12 pull-right">
									<button class="btn btn-warning waves-effect waves-button waves-float f-family pull-right" onclick="clearResults()"><i class="fa fa-close"></i> &nbsp; Clear Results</button>
								</div>
								<div class="clearfix"></div>
									<hr class="hrStyle1"/>
										<br />
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			                    <div id="tableStyle1" style="display: none;">
			
									<div class="table-responsive">
										<table id="searchResTableProp" style="width:100% !important" class="table table-bordered">
									 	<thead>
												<tr>
													<th>Property Name</th>
													<th>Property ID</th>
													<th>Associated FHA Numberr</th>
													<th>City</th>
													<th>State</th>
													<th>Zip</th>
													<th>Type of Loan</th>
													
												</tr>
											</thead>
											<tbody id="propertyListProp">

									
											</tbody>
										</table>
										</div>	
										<div id="sharefilesBtnDiv" class="table-responsive">
										<div >
											<label id="showAlert" style="color:red;font-weight:Bold"></label>
										</div>
										
											<table id="searchResTable" class="table table-bordered">
									 	<thead>
												<tr>
         										<th><input class="select_all" name = "select_all" value="1" type="checkbox"></th>
													<th>FileName & Path </th>
													<!-- <th>File Type</th>
													<th>Version</th> -->
													<th>Document Type</th>
													<th>Document Details</th>
													<th>Document Status</th>
													<th>Closing Date</th>
													<th>Disposable Date</th>
												</tr>
											</thead>
											<tbody id="getDocumentList">

									
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
				
		<!--- Part3 - Search Results---->				
		
  <!-- Modal -->
  
  </section>
  
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog propertyPopup">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          
        </div>
        <div class="modal-body">
        <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        	<div id="treeview5" class="treeview">
        	<ul class="list-group">
        	<li class="list-group-item node-treeview5 node-selected" data-nodeid="0" style="color:#FFFFFF;background-color:#428bca;">
        	<span class="icon expand-icon glyphicon glyphicon-chevron-down">
        	</span><span class="icon node-icon glyphicon glyphicon-bookmark">
        	</span>Parent 1</li>
        	<li class="list-group-item node-treeview5" data-nodeid="1" style="color:undefined;background-color:undefined;">
        	<span class="indent">
        	</span><span class="icon expand-icon glyphicon glyphicon-chevron-right">
        	</span><span class="icon node-icon glyphicon glyphicon-bookmark">
        	</span>Child 1</li><li class="list-group-item node-treeview5" data-nodeid="4" style="color:undefined;background-color:undefined;">
        	<span class="indent">     	</span>
        	<span class="icon glyphicon"></span><span class="icon node-icon glyphicon glyphicon-bookmark"></span>Child 2</li><li class="list-group-item node-treeview5" data-nodeid="5" style="color:undefined;background-color:undefined;"><span class="icon glyphicon"></span><span class="icon node-icon glyphicon glyphicon-bookmark"></span>Parent 2</li><li class="list-group-item node-treeview5" data-nodeid="6" style="color:undefined;background-color:undefined;"><span class="icon glyphicon"></span><span class="icon node-icon glyphicon glyphicon-bookmark"></span>Parent 3</li><li class="list-group-item node-treeview5" data-nodeid="7" style="color:undefined;background-color:undefined;"><span class="icon glyphicon"></span><span class="icon node-icon glyphicon glyphicon-bookmark"></span>Parent 4</li><li class="list-group-item node-treeview5" data-nodeid="8" style="color:undefined;background-color:undefined;"><span class="icon glyphicon"></span><span class="icon node-icon glyphicon glyphicon-bookmark"></span>Parent 5</li></ul></div>
        	<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
        	<div class="folderBorder">
        	FHA Number
        	</div>
        	<div class="">
        		<div class="">
			                    <div id="tableStyle1" >
			
									<div class="table-responsive">
										<br />
										<table id="searchResTable" class="table table-bordered">
											<thead>
												<tr>
													<th> Name</th>
													<th>Type</th>
													<th>Dcument Type</th>
													<th>Version Number</th>
													<th>Document Details</th>
													<th>Closing Date</th>
													<th>Deposit Date</th>
												</tr>
											</thead>
											<tbody id="88">
									 	<tr>
													<td class="color-blue">1</td>
													<td class="color-blue">1</td>
													<td class="color-blue">1</td>
													<td>1</td>
													<td>1</td>
													<td>1</td>
													<td>1</td>
												</tr> 
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
        
      </div>
      
    </div>
  </div>
  
	
	<!--- content Part --->
	 <div style='display:none'>
  <div id="dialog-modal" style="" title="Basic modal dialog">
    <p>Loading</p>
    </div>
<div>
  </div>
</div>  
<!--- Part1 ---->
		   <div class="modal fade" id="myModal" role="dialog" id="my_popup">
		   <h1>test..</h1>
	<div tabindex="-1"  role="dialog" aria-hidden="false" data-popup-initialized="true" id="basic" class="well popup_content" style="max-width: 44em;  display: none; outline: medium none; text-align: left; position: relative; vertical-align: middle;">
    <h4><i class="zmdi_large zmdi-settings zmdi-hc-spin"></i> Loading Contents...Please Wait...</h4>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;It will take few seconds.</p>
    <p style="margin-left:40px;margin-bottom: 0px">&nbsp;&nbsp;Please wait while the contents are loading.</p>
    
	</div> 
	</div>
	
	<!-- share Files -->	
 <div id="shareFiles" class="modal" role="dialog">
    <div class="modal-dialog" style="width:750px;">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" onclick="closeShareFiles();" data-dismiss="modal">&times;</button>
          <div class="modal-title text-center" style="font-weight: bold;font-size: 16px;">Share Documents</div>
        </div>
        <div class="modal-body mdlbdy">
                            <label id="emailAlert" style="font-weight:bold;font-size:14px;align:center;margin-left: 135px;" ></label>
          <form     style="margin-left: 93px;">
          <div class="col-lg-12 ncol-sm-12 col-md-12 col-xs-12">
          	<div class="col-lg-3 col-sm-6 col-md-6 col-xs-6">
          	<label style="font-weight:bold;margin-top: 36px;" class="required">User&nbsp;<span style='color:red;'>*</span></label>
          	</div>
          	<div class="col-lg-4 col-lg-offest-3 col-sm-6 col-md-6 col-xs-6">
          	 <select id="userForEmail" class="userForEmail" name="userForEmail" tabindex="5" multiple="multiple" >
            </select>
          	</div>
          </div>
          <div>
          	<table style="    padding-top: 20px;margin-left: 20px;">
			<tr>
			<td >
			<label style="font-weight:bold;">Selected Files</label>
			</td>
			</tr>
			<tbody id="selectedFilesToZip">
			</tbody>    
           </table>
          </div>
            
           

        <div class="submitbtn">
              <button type="button" style="margin-left: -100;" onclick="zipAndSendEmail();" class="btn btn-success">Zip and Send Email</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
	<!-- <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div> -->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 -->    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- <script src="js/bootstrap.min.js"></script> -->
  </body>
</html>