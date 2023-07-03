var companyID ;
var urlLink;
function showListOFFilesOFDocSearch(cid,restURL){
	/*$("#loanTypePropertyList .btnPropty").on("click", function() {
		 $("#loanTypePropertyList .btnPropty").removeClass("active");
		$(this).addClass("active");
		
  });*/
	companyID = cid;
	urlLink = restURL;
	debugger;
 	$.ajax({
 		  type : "GET",
 		  contentType : "application/json",
 		  url : restURL+"/orcf/getDocCount?companyId="+cid,
 		  dataType : 'json',
 		  timeout : 100000,
 		  success : function(data) {
 		  console.log("SUCCESS: ", JSON.stringify(data));
 		  console.log("data.FILESCOUNT:"+data.FILESCOUNT);
 		  debugger;
 		  console.log("countOfLoanType:"+JSON.stringify(data.LoanTypePropertiesList));
 		  	$("#filesCount").append("<b>"+data.FILESCOUNT+"</b> files");
 		 	$("#propertiesCount").append("<b>"+data.PROPERTYCOUNT+"</b> properties");
 			$("#loanCount").append("<b>"+data.LOANTYPECOUNT+"</b> loans");
 			for(var i=0;i<data.LoanTypePropertiesList.length;i++){
 			//	$("#loanTypePropertyList").append("<tr><td class='text-left'><b> &nbsp;&nbsp;&nbsp;&nbsp;"+data.LoanTypePropertiesList[i].countOFProperties+"</b></td><td class='text-left padding15'><a id='datagg' onclick=javascript:getPropertyListDoc('"+data.LoanTypePropertiesList[i].loanType+"')>"+data.LoanTypePropertiesList[i].loanType+" properties<br></a></td></tr>");
 				$("#loanTypePropertyList").append("<div style='display:inline-block;'><button class='btnPropty' id='"+data.LoanTypePropertiesList[i].loanType+"' onclick=javascript:getPropertyListDoc('"+data.LoanTypePropertiesList[i].loanType+"')>&nbsp;&nbsp;&nbsp;&nbsp;<b>"+data.LoanTypePropertiesList[i].countOFProperties+"</b>&nbsp;&nbsp;&nbsp;&nbsp;"+data.LoanTypePropertiesList[i].loanType+" Properties </button></div>");
 			} 		
 		  },
 		  error : function(e) {
 		   console.log("ERROR: ", e);
 		   displayRights(e);
 		  },
 		  done : function(e) {
 		   console.log("DONE");
 		  }
 		 });
	}



function getPropertyListDoc(value1){
	//alert( urlLink);
	//$('#shareFilesBtn').hide();
	$('#showAlert').text('');
	$("#searchResTableProp").show();
	$("#searchResTable_wrapper").hide();
	$("#loanTypePropertyList .btnPropty").on("click", function() {
		 $("#loanTypePropertyList .btnPropty").removeClass("active");
		$(this).addClass("active");
		
 });
	

	$.ajax({
		  type : "GET",
		  contentType : "application/json",
		  url : urlLink+"/orcf/getLoanTypeProperties?loanType="+value1+"&companyId="+companyID,
		  dataType : 'json',
		  timeout : 100000,
		  success : function(data) {
		  debugger;
		  console.log("SUCCESS    : ", JSON.stringify(data));
			$("#propertyListProp").empty();
			$("#tableStyle1").show();
			//if ($.fn.DataTable.isDataTable("#searchResTableProp")) {
				  $('#searchResTableProp').DataTable().clear().destroy();
				//}
			display(data);
			$("#searchResTableProp").dataTable({
				 dom: 'lBfrtip',
			        buttons: [
			            'excelHtml5',
			            'pdfHtml5'
			        ],
				  "order": [[ 1, "asc" ]],
		          "deferRender": true,
		          
		    
		    }); 
			$("#searchResTableProp").dataTable();
			$("#searchResTableProp_length").css('margin-left','156px');
//			$('.buttons-excel').css('margin-left', '136px');
			$("#searchResTableProp_wrapper").css('padding','10px 0px');
		  },
		  error : function(e) {
		   console.log("ERROR: ", e);
		   displayRights(e);
		  },
		  done : function(e) {
		   console.log("DONE");
		   tbl.fnClearTable(this);
		  }
		 });
	
	
function display(data) {
	console.log('..............'+JSON.stringify(data));
	
	$.each(data.loantypeList, function(i, item) {
		debugger;
		if(!item.city){
			item.city='';
		}else(item.city=='null' || item.city=="null" || item.city==null)?item.city='':item.city;
		
		
		if(!item.state){
			item.state='';
		}else(item.state=='null' || item.state=="null" || item.state==null)?item.state='':item.state;
		
		
		if(!item.zip){
			item.zip='';
		}else(item.zip=='null' || item.zip=="null" || item.zip==null)?item.zip='':item.zip;

			$('#propertyListProp').append(
					'<tr><td><a id="editB" onclick="hello(\'' + item.propertyID + 
					'\',\'' + item.propertyName	+ '\',\'' + item.associativeFhaNumber + '\',\''
					+ item.loanType	+ '\');" href="#/">' + item.propertyName
							+ '</a></td><td><a id="editB" onclick="hello(\''
							+ item.propertyID + '\',\'' + item.propertyName
							+ '\',\'' + item.associativeFhaNumber + '\',\''
							+ item.loanType + '\');">' + item.propertyID
							+ '</a></td><td><a id="editB" onclick="hello12(\''
							+ item.propertyID + '\',\'' + item.propertyName
							+ '\',\'' + item.associativeFhaNumber + '\',\''
							+ item.loanType + '\',\'' + item.propertyID
							+ '\',\'' + item.associativeFhaNumber + '\');">'
							+ item.associativeFhaNumber + '</a></td><td>' + item.city
							+ '</td><td>' + item.state + '</td><td>' + item.zip
							+ '</td><td>' + item.loanType + '</td></tr>');

		});
	}
	
	
	
	
	
	
	
}
