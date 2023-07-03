<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

		<script src="js/jQuery/1.11.3/jquery.min.js"></script>

<!-- <script type="text/javascript" src="js/jQuery/1.11.3/jquery.min.js" ></script>-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css" rel="stylesheet" type="text/css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>	
<script type="text/javascript" src="js/jQuery/jquery.qtip.min.js" ></script>		

<link rel="stylesheet" href="css/jquery.dataTables.min.css" />  
	

<link rel="stylesheet" type="text/css" href="css/styleSheet.css" />
 <script src="js/bootstrap/3.3.5/jquery.dataTables.min.js"></script>
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
       <script src="js/bootstrap.min.js"></script>
  
  <script src="js/searchFilter.js"></script>
 <title>Insert title here</title>
<style type="text/css">
a:hover, a:focus {
    color: #fff;
    text-decoration: none;
}
#myTable_info, #myTable_length{
float: left !important;}
#myTable_paginate, #myTable_filter{
float: right !important;}
.table > thead > tr > th, table-data thead tr {
    background-color: #7098CC;
    color: #fff !important;
}
.buttons-excel{
position: absolute;
    margin-top: -49px;
    right: 37.5%;
    color: #fff;
    background: #4caf50;
}
.input-group {
    width: 20%;
    float: left;
    margin-bottom: 10px;
    border-radius: 4px;
}
</style>
<% try{
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

   %>
   
</head>
<body>
<section class="upload-document">
        <div class="container-fluid">
<br>            			<div class="child-upload-docs" style="text-align: left;  margin-left: 10px;">
            
                                <h4 style="color: #0a68b4;">Upload Record Report</h4>
				<hr>
				<div>
This Report provides a list of all records uploaded in the date range provided, by User.<br>
The Fields include: (File Name, iREMS #, Document Type, Upload Date, Process Date) 
</div><br>
				<div class="upload-dates col-sm-12">
				<div >
				<span id="result" style="color:red"></span></div>
				
				</div>
                <div class="upload-dates col-sm-12">
                
                    <div id="datepicker" class="input-group date" data-date-format="mm-dd-yyyy">
                        <input class="form-control" placeholder="From Date *" type="text" style="z-index: 1;height: 28px;background: #edecec;" readonly />
                        <span class="input-group-addon calstyle"><i class="glyphicon glyphicon-calendar" style="font-size: 22px;color: #0d529f;"></i></span>
                    </div>

                    <div id="datepicker2" class="input-group date" data-date-format="mm-dd-yyyy">
                        <input class="form-control" placeholder="To Date *" type="text" style="z-index: 1;height: 28px;background: #edecec;" readonly />
                        <span class="input-group-addon calstyle"><i class="glyphicon glyphicon-calendar" style="font-size: 22px;color: #0d529f;" ></i></span>
                    </div>
                    <div><button type="button" class="btn btn-success" onclick="getFiles()" style="margin-right: 20px; background-color: #4caf50;color: #fff;float: left;">Get Report</button></div> 
                    <div class="export">
                        <button type="button" style="float: left;    background-color: #4caf50;color: #fff;" class="btn btn-success"  onclick="fnExcelReport();"><i class="fa fa-share-square-o" aria-hidden="true"></i>Excel Export</button>
                    </div>
                </div>
                <br>
                 <br>
                  <br>
                <div class='row' style="width: 100%">
                <div class="table-data">
                
                    <table id="myTable" class="table table-bordered">
                        <thead>
                            <tr>
                                <th>File Name </th>
                                <th>IREMS #</th>
                                <th>Document Type</th>
                                <th>Upload Date</th>
                                <th>Process Date</th>
                            </tr>
                        </thead>
                        <tbody id="getDocumentList">
                            
                        </tbody>
                    </table>
                     <div id="loadingImage"
							style="position: absolute; top: 50%; left: 0px; right: 0px; margin: auto; text-align: center">
							<img src="css/images/default.gif" />
						</div>
                    </div>
                </div>
            </div>
        </div>
    </section>
   
	<script>
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
	$(document).mousemove(function(event){
		  InitializeTimer();
	  });
    $(function() {
    	$("#loadingImage").hide();
    	 InitializeTimer();
    	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
    	for (var i = 0; i < array_of_li.length; i++) {
    	if(i == 0)
    		array_of_li[i].setAttribute("class", "active");	
    		
    	}
       
        $("#datepicker").datepicker({
        	endDate:new Date(),
            autoclose: true,
            dateFormat: 'mm-dd-yy'
        	
        }).on("changeDate", function (e) {
        	$('#datepicker2').datepicker('setDate', null);
        	$("#result").text("");
        	$('#datepicker2').datepicker({ autoclose: true}).datepicker('setStartDate', e.date).focus();
        	//$("#datepicker2").datepicker( "option", "startDate", new Date() );
        	});
		$("#datepicker2").datepicker({
            autoclose: true,
            dateFormat: 'dd-mm-yy',
           
            endDate:new Date()
        }).on("changeDate", function (e) {
        	
        	$("#result").text("");
        	});
		$('#myTable').hide();
		initial_load();
    });
    function initial_load() {
    	
  

    	/* var array_of_li =  document.querySelectorAll("ul.tab-nav li");
    	for (var i = 0; i < array_of_li.length; i++) {
    	if(i == 2)
    		array_of_li[i].setAttribute("class", "active");	
    		
    	} */
    	
    	
    	
    	
    	
    }
    
    
    function getFiles()
    {
    	if ($.fn.DataTable.isDataTable("#myTable")) {
			  $('#myTable').DataTable().clear().destroy();
			}
    	//$(".buttons-excel").css("position", "initial").css("background", "none");
    	var fromDate = $('#datepicker').datepicker('getDate');
    	var toDate = $('#datepicker2').datepicker('getDate');
    if(fromDate!='Invalid Date'){
    		if(toDate!='Invalid Date'){
    			var datef=fromDate.getMonth()+1+"-"+fromDate.getDate()+"-"+fromDate.getFullYear();
    	    	var dates=toDate.getMonth()+1+"-"+toDate.getDate()+"-"+toDate.getFullYear();
    	var user_id= '<%=uid%>';
		var compId='<%= cid %>'
		   	var param="user_id="+user_id+"&compId="+compId+"&fromDate="+datef+"&toDate="+dates;
		$("#loadingImage").show();
    	$.ajax({
    	 		type : "GET",
    	 	 url:"<%=restURL%>/orcf/getUserUploadReport?"+param,
    	 		datType : "json",
    	 		//ContentType : "application/json; charset=utf-8",
    	 		// data:{"userId":1,"status":"P", "companyId":12 },
    	 		success : function(data) 
    	 		{
    	 			$("#loadingImage").hide();
    	 			
    	 			
  		   		  if(data.uploadUserReport!=undefined){
  		   			data=displayData(data);
  		   		  }else{
  		   			data=[];
  		   		  }
  		   		$('#myTable').show();
  		   		  
  		   		$("#myTable").dataTable({
  		   		  dom: 'lBfrtip',
			        buttons: [
			        	{ extend : 'excelHtml5',
			        		title:"Upload Record Report",
			        		text:"Excel Export",
			        		filename:"Upload Record Report",
			        		messageTop:"From "+datef+" to "+dates
			        	}
				        ],
  				       
  					  "order": [[ 2, "desc" ]],
  			          "deferRender":    true,
  			          "scroller":       true,
  			        "aoColumns": [
		                 null,
		                 null,
		                 null,
		                 { "sType": "date-uk" },
		                 { "sType": "date-uk" }
		             ]
  			        
  			           
  			    
  			    }); 
  		   		
  		   	
    	 			
    	 			$("#result").text("");
    	 			 /* $.each(response.uploadUserReport,function(i,obj)
    		 	                { 
    		 				console.log(JSON.stringify(obj))
    		 				$('#myTable tbody').append(
    		 					'<tr><td>'+obj.actualFilename+'</td>'+
    		 						'<td>'+obj.propertyId+'</td>'+
    		 						'<td>'+obj.documentTypedesc+'</td>'+
    		 						'<td>'+obj.uploadDate+'</td>'+
//     		 						'<td>Uploaded</td>'+
//     		 						'<td>'+obj.userName+'</td>'+
    		 						'<td>'+obj.processDate+'</td>'+
                                   '</tr>');
    		 			
    		 	                	               	
    		 	                }); */
    	 			
    	 		  
    	 		  },
    	 		 error : function(xhr, status, textError) 
    	 		     {
    	 			$("#loadingImage").hide();
    			     }
    	 		    });
    		}else{
        		$("#result").text("Select To Date");	
        	}
    	}else{
    		$("#result").text("Select From Date");	
    	}
    }
    
    function displayData(data) {
    	
    	$.each(data.uploadUserReport, function(i, obj) {
    		
    	     $('#getDocumentList').append('<tr><td><div style="word-break: break-all;">'+obj.actualFilename+'</div></td><td>'+obj.propertyId+'</td><td>'+obj.documentTypedesc+'</td><td>'+obj.uploadDate+'</td><td>'+obj.processDate+'</td></tr>');
    	     //getDropDowns1("documentType","docId"+i);
    	});
    }
    function fnExcelReport()
    {
    	var rowCount = $('#myTable tr').length;
    
/*     	var htmls = "";
        var uri = 'data:application/vnd.ms-excel;base64,';
        var template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'; 
        var base64 = function(s) {
            return window.btoa(unescape(encodeURIComponent(s)))
        };

        var format = function(s, c) {
            return s.replace(/{(\w+)}/g, function(m, p) {
                return c[p];
            })
        };

        htmls = document.getElementById('myTable');

        var ctx = {
            worksheet : 'Worksheet',
            table : htmls
        }


        var link = document.createElement("a");
        link.download = "export.xls";
        link.href = uri + base64(format(template, ctx));
        link.click();
    	  */
    	  if(rowCount>1){
        var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
        var textRange; var j=0;
        tab = document.getElementById('myTable'); // id of table

        for(j = 0 ; j < tab.rows.length ; j++) 
        {     
            tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
            //tab_text=tab_text+"</tr>";
        }

        tab_text=tab_text+"</table>";
        tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
        tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
        tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

        var ua = window.navigator.userAgent;
        var msie = ua.indexOf("MSIE "); 

        if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
        {
            txtArea1.document.open("txt/html","replace");
            txtArea1.document.write(tab_text);
            txtArea1.document.close();
            txtArea1.focus(); 
            sa=txtArea1.document.execCommand("SaveAs",true,"Reports.xls");
        }  
        else                 //other browser not tested on IE 11
            sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

        return (sa);
    	  }else{
      		$("#result").text("No Rows in Table");	
      	}
    }
    </script>
    <iframe id="txtArea1" name="naveen" style="display:none"></iframe>
    <%}else{
	response.sendRedirect("index.jsp");
} 
}catch(IllegalStateException ie){
	response.sendRedirect("index.jsp");
}
%>
</body>
</html>