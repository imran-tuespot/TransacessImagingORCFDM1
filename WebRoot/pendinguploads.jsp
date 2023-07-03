<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script src="js/jQuery/jquery-1.8.2.min.js"></script>

<script type="text/javascript" src="js/jQuery/1.11.3/jquery.min.js" ></script>	
<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
<script type="text/javascript" src="js/jQuery/jquery.qtip.min.js" ></script>		

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
<link rel="stylesheet" href="css/jquery.dataTables.min.css" />  
	

<link rel="stylesheet" type="text/css" href="css/styleSheet.css" />
 <script src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script> -->

<script src="js/jQuery/1.11.3/jquery.min.js"></script>

<!-- <script type="text/javascript" src="js/jQuery/1.11.3/jquery.min.js" ></script>-->	
<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
<script type="text/javascript" src="js/jQuery/jquery.qtip.min.js" ></script>		

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
<link rel="stylesheet" href="css/jquery.dataTables.min.css" />  
	

<link rel="stylesheet" type="text/css" href="css/styleSheet.css" />
 <script src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
<script src="js/bootstrap.min.js"></script>


 


        
 
  



		<title>Pending Uploads</title>
<style type="text/css">
#uploadandremove{
    right: 0;
    position: absolute;
    margin-top: 43px;
    left: 37%;
    text-align: center;
     z-index: 1; 
}
#myTable{    margin-top: 69px;}
#myTable_wrapper{    padding: 10px;}
.table > thead > tr > th,table-data thead tr {
    background-color: #7098CC;
    color: #fff !important;
}
.upload-remove-buttons{
    text-align: right;
    margin-right: 10px;
}
</style>

<%try{ 
	 String appuserrole = (String)request.getSession().getAttribute("appuserrole");
if(request.getSession().getAttribute("userid")!=null&&(appuserrole.equals("ADMIN")||appuserrole.equals("COORDINATOR"))){
	System.out.println("appuserrole "+appuserrole);
	int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
	String sessionid = request.getSession().getAttribute("sessionid").toString();
	int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
	String userName = request.getSession().getAttribute("username").toString();
	String companyFullName=request.getSession().getAttribute("companyFullname").toString();
	javax.naming.Context ctx = 	new javax.naming.InitialContext();
		String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
		String URL = (String) ctx.lookup("java:comp/env/URL");
	 String repositoryOCR= (String) ctx.lookup("java:comp/env/repositoryOCR");


 

%>



		
</head>

<jsp:include page="includes/sessionHeader.jsp" />

<body onLoad="initial_load()">

	
								<select  name="doctype" id="doctype" class="selectText" style="display:none">
								    				<option value="" selected>Select Document Type</option>
								  				</select>	
								  				<select style="display:none" name="iremsnumber" id="iremsnumber" class="selectText" onchange="getFhaNumbersbyProperty(this.value);">
									    			<option value="" selected>Select IREMS </option>
									  			</select>




  
 
		
		
	
		
<br>

<div  class="search-tables">
<div id="uploadandremove" class="upload-remove-buttons">
                        <button type="button" id="allSubmit" onclick="updateAll()" class="btn btn-success"><i class="fa fa-upload" aria-hidden="true"></i> Update all</button>
                        <button id="reset_btn" type="button" onclick="deleteAll()" class="btn" style="color:#fff !important;border color:#ff9900 !important;background-color:#ff9900 !important;" ><i class="fa fa-trash" aria-hidden="true"></i> Delete all</button>
                    </div>
                <div><span id="result" style="color:red"></span></div>
                <div class="table-data">
                    <table id="myTable" class="table paginated table-bordered" style="width: 865px;">
                        <thead>
                            <tr>
                                <th></th>
                                <th>File Name</th>
                                <th>Size</th>
                                <th>IREMS #</th>
                                <th>Document Type</th>
                                <th>Status</th>
                                <th>Delete</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody id="getDocumentList">
                           
                        </tbody>
                    </table>
                    <div id="loadingImage"
							style="position: absolute; top: 40%; left: 0px; right: 0px; margin: auto; text-align: center">
							<img src="css/images/default.gif" />
						</div>
                </div>
            </div>
<!-- <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
    
      Modal content
     
      <div class="modal-content" style="border-radius: 8px;">
        <div class="modal-header" style="background-color: #7098CC;">
         
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" style="color:#fff">Confirm delete</h4> 
        </div> 
        <span id="myModalmsg" style="color:red"></span>
        <div class="modal-body">
          <p>Are you sure do you want to delete ?</p>
        </div>
        <div class="modal-footer" style="text-align: center;">
          
          <button type="button" style="padding: 4px 9px; border: none;" onclick="deletedocConfime()" class="  btn-success btn-upload">Yes</button>
        <button type="button"  style="padding: 4px 9px; border: none;color: #fff;background-color:#ff9900;" data-dismiss="modal">No</button>
         
        </div>
      </div>
      
    </div>
  </div> -->
  

<script type="text/javascript">
var theChild;
 function getPdf(filename,version) {
	 var keyword='';
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var urlui= '<%=URL%>'
	<%-- var version = '<%= versionNum%>'; --%>
	var id = filename;
	
	//Kiran Changes Starts
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
	

	 if(theChild!=null)
     {
      if(!theChild.closed)
      {
       theChild.close();
      }
     }
     
 	
     theChild =window.open(urlui+'DisplayPdf?&sessionid='+session+'&id='+filename+'&keywordSearch='+keyword+'&userid='+user+'&userName='+userName,'popup','menubar=1,resizable=1,width=1000,height=600');

	}									
										


 
</script>
<script language="javascript">

var alldocdtls=[];

function displayData(data) {
	

	
	$.each(data.response, function(i, obj) {
		
	     $('#getDocumentList').append('<tr id=li_'+i+'><td><div ><img onclick="getPdf(\''+obj.filewithPath+'\',\''+obj.version+'\')" src="images/pdfViewer.gif" alt="" class="cursorpointer pdffile"></div></td><td style="width: 200px;word-break: break-all;">'+obj.filename+'</td><td>'+obj.filesize+'</td><td class="bdr"> <div ><input id=propertyID'+i+' type="text" value='+obj.irems+'></div> </td><td class="options"><select  style="width: 70%;" id=docId'+i+'></select></td><td>Pending</td><td  style="text-align: center;"><i style="font-size: 14px;" class="fa fa-trash cursorpointer" onclick=deletedoc('+i+','+obj.docId+','+obj.version+') aria-hidden="true"></i></td><td><button id="up_'+i+'" class="btn btn-success cursorpointer" onclick="editdoc(\''+i+'\',\''+obj.docId+'\',\''+obj.filename+'\',\''+obj.filewithPath+'\')" >Update</button></td></tr>');
	   
	     getDropDowns1("documentType","docId"+i);
	     $('#docId'+i).val(obj.docTypId);
	     
	});
	alldocdtls=data.response;
}
function getPdf12(filename,version) {
	var keyword='';
	var user = '<%= uid%>';
	var com = '<%= cid%>';
	var session = '<%= sessionid%>';
	var userName = '<%= userName%>';
	var urlui= '<%=URL%>'
	window.open(urlui+'DisplayPdf?&sessionid='+session+'&id='+filename+'&keywordSearch='+keyword+'&userid='+user+'&userName='+userName,'popup','width=1000,height=600');
}
function getdropdowns()
{
	 
    var comid = '<%= cid %>';
      
         
         $.ajax({
             type: "GET",
             //url:"GetDocTypeDropdown?comid=1&doctypeId=1",
             url:"<%=restURL%>/orcf/getDocType?companyId="+comid,
             dataType: "json",
             success: function (data) {
             	//alert("619::"+data.docTypeData[0].value);
             		

                 $.each(data.response,function(i,obj)
                 		
                 {                	
                 	var	div_data="<option value="+obj.docTypeMasterId+">"+obj.docTypeMasterDesc+"</option>";
                 	$(div_data).appendTo('#doctype'); 
                 	
                 });
                 getPendingfiles();
                 } 
            
           });
          
        
         
          
}



function getPendingfiles(){
	 $("#loadingImage").show();
	 $("#uploadandremove").hide();
	 var uid = '<%= uid %>';
	 var comid = '<%= cid %>';
	 $.ajax({
	 		type : "GET",
	 	 url:"<%=restURL%>/orcf/pendingUploads?userId="+uid+"&status='P'&companyId="+comid,
	 		datType : "json",
	 		//ContentType : "application/json; charset=utf-8",
	 		// data:{"userId":1,"status":"P", "companyId":12 },
	 		success : function(data) 
	 		{
	 			console.log(data.response)
	 			//$('#myTable tbody').empty();
	 			 $("#loadingImage").hide();
		   		  if ($.fn.DataTable.isDataTable("#myTable")) {
					  $('#myTable').DataTable().clear().destroy();
					}
		   		  if(data.response!=null){
		   			data=displayData(data);
		   		  }else{
		   			data=[];
		   		  }
		   	
		   		  
		   		$("#myTable").dataTable({
		   			
					 //dom: 'lBfrtip',
				       
					 // "order": [[ 6, "desc" ]],
			          "deferRender":    true,
			          "scroller":       true,
			        
			           "drawCallback": function(){
			        	   // Update state of "Select all" control
			        	  // updateDataTableSelectAllCtrl($("#myTable").DataTable());
			        	},
			        	"sPaginationType":"full_numbers"
			    
			    }); 
		   		if ($('#getDocumentList').children('tr').length>1)
	         	{
	        		
	             	 $("#uploadandremove").show();
	         	
	         	}else{
	         		 $("#uploadandremove").hide();
	         	}
	 		  
	 		  },
	 		 error : function(xhr, status, textError) 
	 		     {
			     }
	 		    });
       
    
}

function deletedoc(index,id,version){
	
	var selectid=[];
	var selectversion=[];
	
	
	jConfirm('Are you sure do you want to delete ?', 'Confirm Deletion', function(r) {
		   if(r){
			   selectid.push(id);
				selectversion.push(version);
			   deletedocConfimed(index,selectid,selectversion);  
		   }
		});
	$('#popup_ok').val("Yes");
	$('#popup_cancel').val("No");
}

function deleteAll(){
	jConfirm('Are you sure do you want to delete ?', 'Confirm Deletion', function(r) {
		   if(r){
	var alldocIdsDelete=[];
	var allversionsDelete=[];
	$.each(alldocdtls,function(i,obj){                	
		 alldocIdsDelete.push(obj.docId);
		 allversionsDelete.push(obj.version);
            });
	alldeletedocConfimed(alldocIdsDelete,allversionsDelete);
		   }
	});
$('#popup_ok').val("Yes");
$('#popup_cancel').val("No");
}
function alldeletedocConfimed(docid,version){
	
	var uid= '<%=uid%>';
	var cid='<%= cid %>'
	var str="user_id="+uid+"&version="+version+"&compId="+cid+"&docId="+docid;
		
	
	$.ajax({
 		type : "GET",
 		url : "<%=restURL%>/orcf/deletePendingDocument?"+str,
 		datType : "json",
 		//ContentType : "application/json; charset=utf-8",
 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
 		success : function(response) 
 		{
 			if(response.key==200){
 				
 				$('#result').text('Documents are deleted successfully').css("color", "green");
 				window.location.reload();
 				
 			}else{
 				$('#myModalmsg').text('Documents are not deleted').css("color", "red");
 				alert(response.Status);
 			}
 			
 		 
 		  },
 		 error : function(xhr, status, textError) 
 		     {
 			$('#myModalmsg').text('Documents are not deleted').css("color", "red");
		     }
 		    }); 

}

function deletedocConfimed(index,docid,version){
	
		var uid= '<%=uid%>';
		var cid='<%= cid %>'
		var str="user_id="+uid+"&version="+version+"&compId="+cid+"&docId="+docid;
			
		
		$.ajax({
	 		type : "GET",
	 		url : "<%=restURL%>/orcf/deletePendingDocument?"+str,
	 		datType : "json",
	 		//ContentType : "application/json; charset=utf-8",
	 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
	 		success : function(response) 
	 		{
	 			if(response.key==200){
	 				
	 				
	 				$('#result').text('Document deleted successfully').css("color", "green"); 
	 				 setTimeout(function(){ $('#li_'+index).remove();
		        	  $("#result").text("");
		        	  if ($('#getDocumentList').children('tr').length>1)
			         	{
			             	 $("#uploadandremove").show();
			         	
			         	}else{
			         		 $("#uploadandremove").hide();
			         	}
	 				}, 2000); 
	 				
	 				
	 			}else{
	 				$('#result').text('Document not deleted').css("color", "red"); 
	 				alert(response.Status);
	 			}
	 			
	 		 
	 		  },
	 		 error : function(xhr, status, textError) 
	 		     {
	 			$('#result').text('Document not deleted').css("color", "red"); ;
			     }
	 		    }); 
	
}
var regexp = /^(800)(\s*[\_]\s*)?\d{6}$/;
function updateAll(){
	var allpropertyIDs=[];
	var alldocumentType=[];
	var filenamelist=[];
	var filewithPathList=[];
	var alldocIds=[];
	var statusloop=false;
	for(var i=0;i<$('#getDocumentList').children('tr').length;i++){
		 $('#propertyID'+i).css("border", "1px solid rgb(169,169,169)");
		 $('#docId'+i).css("border", "1px solid rgb(169,169,169)");
			var doctype= $('#docId'+i).find(":selected").val();
			var propertyselectiongetting=$('#propertyID'+i).val();
			if(regexp.test(propertyselectiongetting)){
				allpropertyIDs.push(propertyselectiongetting);
			}else{
				 statusloop=true;
				 $('#propertyID'+i).css("border", "1px solid red");
			}
			if(doctype){
				alldocumentType.push(doctype);
			}else{
				 statusloop=true;
					 $('#docId'+i).css("border", "1px solid red");
				}
			
			 filenamelist.push(alldocdtls[i].filename);
			 filewithPathList.push(alldocdtls[i].filewithPath);
			 alldocIds.push(alldocdtls[i].docId);
			
			
	}
	if(!statusloop){
		saveAlldocs(alldocIds,allpropertyIDs,alldocumentType,filenamelist,filewithPathList);
	
	}
	
}
function saveAlldocs(alldocIds,allpropertyIDs,alldocumentType,filenamelist,filewithPathList){
	
	 
	
	 var uid = '<%= uid %>';
	 var sessionid= '<%=sessionid%>';
	 var cid='<%= cid %>';

	// $("#up_"+id).attr("disabled", "disabled");
				
		var str="propertyID="+allpropertyIDs+"&documentType="+alldocumentType+"&sessionId="+sessionid+"&companyId="+cid+"&docId="+alldocIds+"&userId="+uid+"&filename="+filewithPathList+"&actualFileName="+encodeURIComponent(filenamelist);
			
		
		$.ajax({
	 		type : "GET",
	 		url : "<%=restURL%>/orcf/savePendingDocuments?"+str,
	 		datType : "json",
	 		//ContentType : "application/json; charset=utf-8",
	 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
	 		success : function(response) 
	 		{
	 			if(response.key==200){
	 				$('#result').text('Documents details saved successfully').css("color", "green"); 
	 				 setTimeout(function(){ 
		        	  $("#result").text("");
		        	  window.location.reload();
	 				}, 2000); 
	 				
	 				
	 			}else{
	 				alert(response.Status);
	 				//$("#up_"+id).removeAttr("disabled");
	 			}
	 			
	 		 
	 		  },
	 		 error : function(xhr, status, textError) 
	 		     {
	 			//$("#up_"+id).removeAttr("disabled")
			     }
	 		    }); 
		
		
}

function editdoc(id,docId,actualFileName,filewithPath){
	
	 
	 var uid = '<%= uid %>';
	var filenamelist= [];
	filenamelist.push(actualFileName);
	var documentType = $('#docId'+id).find(":selected").val();
	var propertyID= $('#propertyID'+id).val();
	console.log(propertyID!='')
	if(propertyID!=''){
		 
		   
		  if(regexp.test(propertyID)&&propertyID.length>2){
			  if(documentType!=''){
	 $("#up_"+id).attr("disabled", "disabled");
				var sessionid= '<%=sessionid%>';
		var cid='<%= cid %>'
		var str="propertyID="+propertyID+"&documentType="+documentType+"&sessionId="+sessionid+"&companyId="+cid+"&docId="+docId+"&userId="+uid+"&filename="+filewithPath+"&actualFileName="+encodeURIComponent(filenamelist);
			
		
		$.ajax({
	 		type : "GET",
	 		url : "<%=restURL%>/orcf/savePendingDocuments?"+str,
	 		datType : "json",
	 		//ContentType : "application/json; charset=utf-8",
	 		//data :JSON.stringify({propertyID:propertyID,documentType:documentType,sessionId:sessionid,companyId: cid,docId:docId}) ,
	 		success : function(response) 
	 		{
	 			if(response.key==200){
	 				$('#result').text('Document details saved successfully').css("color", "green"); 
	 				 setTimeout(function(){ $('#li_'+id).remove();
		        	  $("#result").text("");
		        	  if ($('#getDocumentList').children('tr').length>1)
			         	{
			             	 $("#uploadandremove").show();
			         	
			         	}else{
			         		 $("#uploadandremove").hide();
			         	}
	 				}, 2000); 
	 				
	 			}else{
	 				alert(response.Status);
	 				$("#up_"+id).removeAttr("disabled");
	 			}
	 			
	 		 
	 		  },
	 		 error : function(xhr, status, textError) 
	 		     {
	 			$("#up_"+id).removeAttr("disabled")
			     }
	 		    }); 
		
		
	
	
	
			}else{
	        	$("#result").text("Select Document Type ");
	        	$("#up_"+id).removeAttr("disabled")
	}
		 }else{
	        	$("#result").text("Enter Valid IREMS #");
	} 
	}else{
		
        	$("#result").text("Enter IREMS #");
        	$("#up_"+id).removeAttr("disabled")
        	
	}
	
}
function getDropDowns1(type,id)
{
	$("#result").text("");
	
	if(type === "documentType")
	{
		var e = document.getElementById("doctype");
		var strDocType = e.options[e.selectedIndex].text;
		
		
		jQuery('#doctype option').clone().appendTo('#'+id);
		
		var dd = document.getElementById(id);

		for (var i = 0; i < dd.options.length; i++) {
			 if (dd.options[i].text === strDocType) {
				 
		        dd.selectedIndex = i;
		        break;
		    }
		}
		$("option[value='1007']").attr("disabled", "disabled");
		$("option[value='1008']").attr("disabled", "disabled");
		$("option[value='886']").attr("disabled", "disabled");
		$("option[value='426']").attr("disabled", "disabled");
		//$("option[value='899']").attr("disabled", "disabled");
		$("option[value='915']").attr("disabled", "disabled");
		$("option[value='920']").attr("disabled", "disabled");
		$("option[value='930']").attr("disabled", "disabled");
		$("option[value='939']").attr("disabled", "disabled");
		$("option[value='940']").attr("disabled", "disabled");
		$("option[value='954']").attr("disabled", "disabled");
		$("option[value='997']").attr("disabled", "disabled");
		$("option[value='1002']").attr("disabled", "disabled");
		$("option[value='1013']").attr("disabled", "disabled");
		$("option[value='1018']").attr("disabled", "disabled");
		$("option[value='1025']").attr("disabled", "disabled");
		$("option[value='1026']").attr("disabled", "disabled");
		
		$("option[value='1059']").attr("disabled", "disabled");
		$("option[value='1061']").attr("disabled", "disabled");
		$("option[value='1078']").attr("disabled", "disabled");
		$("option[value='1081']").attr("disabled", "disabled");
		$("option[value='1143']").attr("disabled", "disabled");
		$("option[value='1165']").attr("disabled", "disabled");
		$("option[value='920']").attr("disabled", "disabled");
		$("option[value='35']").attr("disabled", "disabled");
		$("option[value='486']").attr("disabled", "disabled");
		$("option[value='584']").attr("disabled", "disabled");
		$("option[value='404']").attr("disabled", "disabled");
		$("option[value='284']").attr("disabled", "disabled");
		$("option[value='285']").attr("disabled", "disabled");
		$("option[value='399']").attr("disabled", "disabled");
		$("option[value='575']").attr("disabled", "disabled");
		$("option[value='144']").attr("disabled", "disabled");
		$("option[value='240']").attr("disabled", "disabled");
		$("option[value='465']").attr("disabled", "disabled");
		$("option[value='1049']").attr("disabled", "disabled");
		$("option[value='143']").attr("disabled", "disabled");
		$("option[value='487']").attr("disabled", "disabled");
		$("option[value='638']").attr("disabled", "disabled");
		$("option[value='406']").attr("disabled", "disabled");
		$("option[value='281']").attr("disabled", "disabled");
		$("option[value='397']").attr("disabled", "disabled");
		$("option[value='566']").attr("disabled", "disabled");
		$("option[value='568']").attr("disabled", "disabled");
		$("option[value='313']").attr("disabled", "disabled");
		$("option[value='279']").attr("disabled", "disabled");
		$("option[value='541']").attr("disabled", "disabled");
		$("option[value='278']").attr("disabled", "disabled");
		//$("option[value='550']").attr("disabled", "disabled");
		$("option[value='612']").attr("disabled", "disabled");
		$("option[value='241']").attr("disabled", "disabled");
		$("option[value='449']").attr("disabled", "disabled");
		$("option[value='305']").attr("disabled", "disabled");
		$("option[value='437']").attr("disabled", "disabled");
		$("option[value='443']").attr("disabled", "disabled");
		$("option[value='586']").attr("disabled", "disabled");
		$("option[value='743']").attr("disabled", "disabled");
		$("option[value='292']").attr("disabled", "disabled");
		$("option[value='432']").attr("disabled", "disabled");
		$("option[value='360']").attr("disabled", "disabled");
		$("option[value='573']").attr("disabled", "disabled");
		$("option[value='543']").attr("disabled", "disabled");
		$("option[value='605']").attr("disabled", "disabled");
		$("option[value='182']").attr("disabled", "disabled");
	    $("option[value='365']").attr("disabled", "disabled");
		$("option[value='630']").attr("disabled", "disabled");
		$("option[value='392']").attr("disabled", "disabled");
		$("option[value='601']").attr("disabled", "disabled");
		$("option[value='546']").attr("disabled", "disabled");
		$("option[value='560']").attr("disabled", "disabled");
		$("option[value='529']").attr("disabled", "disabled");
		$("option[value='489']").attr("disabled", "disabled");
		$("option[value='448']").attr("disabled", "disabled");
		$("option[value='326']").attr("disabled", "disabled");
		$("option[value='394']").attr("disabled", "disabled");
		$("option[value='527']").attr("disabled", "disabled");
		$("option[value='309']").attr("disabled", "disabled");
		$("option[value='280']").attr("disabled", "disabled");
		$("option[value='391']").attr("disabled", "disabled");
		$("option[value='108']").attr("disabled", "disabled");
		$("option[value='599']").attr("disabled", "disabled");
		$("option[value='490']").attr("disabled", "disabled");
		$("option[value='286']").attr("disabled", "disabled");
		$("option[value='447']").attr("disabled", "disabled");
		$("option[value='304']").attr("disabled", "disabled");
		$("option[value='467']").attr("disabled", "disabled");
		$("option[value='760']").attr("disabled", "disabled");
		$("option[value='548']").attr("disabled", "disabled");
		$("option[value='644']").attr("disabled", "disabled");
		$("option[value='315']").attr("disabled", "disabled");
		$("option[value='393']").attr("disabled", "disabled");
		$("option[value='518']").attr("disabled", "disabled");
		$("option[value='731']").attr("disabled", "disabled");
		$("option[value='411']").attr("disabled", "disabled");
		$("option[value='186']").attr("disabled", "disabled");
		$("option[value='542']").attr("disabled", "disabled");
		$("option[value='597']").attr("disabled", "disabled");
		$("option[value='459']").attr("disabled", "disabled");
		$("option[value='287']").attr("disabled", "disabled");
		$("option[value='390']").attr("disabled", "disabled");
		$("option[value='574']").attr("disabled", "disabled");
		$("option[value='533']").attr("disabled", "disabled");
		$("option[value='488']").attr("disabled", "disabled");
		$("option[value='591']").attr("disabled", "disabled");
		$("option[value='395']").attr("disabled", "disabled");
		$("option[value='549']").attr("disabled", "disabled");
		$("option[value='166']").attr("disabled", "disabled");
		$("option[value='485']").attr("disabled", "disabled");
		$("option[value='564']").attr("disabled", "disabled");
		$("option[value='389']").attr("disabled", "disabled");
		$("option[value='585']").attr("disabled", "disabled");
		$("option[value='502']").attr("disabled", "disabled");
		$("option[value='276']").attr("disabled", "disabled");
		$("option[value='516']").attr("disabled", "disabled");
		$("option[value='636']").attr("disabled", "disabled");
		$("option[value='13']").attr("disabled", "disabled");
		$("option[value='215']").attr("disabled", "disabled");
		$("option[value='116']").attr("disabled", "disabled");
		$("option[value='598']").attr("disabled", "disabled");
		$("option[value='203']").attr("disabled", "disabled");
		$("option[value='70']").attr("disabled", "disabled");
		$("option[value='398']").attr("disabled", "disabled");
		$("option[value='400']").attr("disabled", "disabled");
		$("option[value='387']").attr("disabled", "disabled");
		$("option[value='209']").attr("disabled", "disabled");
		$("option[value='68']").attr("disabled", "disabled");
		$("option[value='600']").attr("disabled", "disabled");
		$("option[value='375']").attr("disabled", "disabled");
		$("option[value='161']").attr("disabled", "disabled");
		$("option[value='754']").attr("disabled", "disabled");
		$("option[value='160']").attr("disabled", "disabled");
		$("option[value='403']").attr("disabled", "disabled");
		$("option[value='274']").attr("disabled", "disabled");
		$("option[value='249']").attr("disabled", "disabled");
		$("option[value='388']").attr("disabled", "disabled");
		$("option[value='29']").attr("disabled", "disabled");
		$("option[value='685']").attr("disabled", "disabled");
		$("option[value='121']").attr("disabled", "disabled");
		$("option[value='333']").attr("disabled", "disabled");
		$("option[value='273']").attr("disabled", "disabled");
		$("option[value='74']").attr("disabled", "disabled");
		$("option[value='126']").attr("disabled", "disabled");
		$("option[value='753']").attr("disabled", "disabled");
		$("option[value='76']").attr("disabled", "disabled");
		$("option[value='376']").attr("disabled", "disabled");
		$("option[value='200']").attr("disabled", "disabled");
		$("option[value='85']").attr("disabled", "disabled");
		$("option[value='426']").attr("disabled", "disabled");
		$("option[value='89']").attr("disabled", "disabled");
		$("option[value='57']").attr("disabled", "disabled");
		$("option[value='131']").attr("disabled", "disabled");
		$("option[value='86']").attr("disabled", "disabled");
		$("option[value='772']").attr("disabled", "disabled");
		$("option[value='84']").attr("disabled", "disabled");
		$("option[value='1087']").attr("disabled", "disabled");
		$("option[value='2128']").attr("disabled", "disabled");
		
	}
	
}


	  $(document).mousemove(function(event){
		  InitializeTimer();
	  });


function initial_load() {
	
	setHeader('pendinguploads.jsp');
	$(".workingAreaBlueHeading").html('<div style="margin-top: 5px;">'+
	'<img src="images/PPT.png " alt="PPT" style=" width: 62px;     margin-left: -14%;position: absolute;  transform: skewY(350deg);"/>'+
	'<div> <p style="font-size: 14px;margin-top: 1px;color: black;text-transform: none;    font-weight: 400;"> Any Records found in Pending Uploads did not successfully upload.<br> Review the information & try again.</p>'+
		 ' </div> </div> ');
	getdropdowns();

	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
		 if(array_of_li[i].textContent.trim()=='Pending Uploads'){
     		array_of_li[i].setAttribute("class", "active");	
     	}
		
	}
//	getPendingfiles();
}





	</script>
<%}else{
	response.sendRedirect("index.jsp");
} 
}catch(IllegalStateException ie){
	response.sendRedirect("index.jsp");
}
%>
</body>


</html>