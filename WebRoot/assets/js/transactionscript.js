/*$(function(){

    var ul = $('#upload ul');

    $('#drop a').click(function(){
        // Simulate a click on the file input button
        // to show the file browser dialog
        $(this).parent().find('input').click();
    });

    // Initialize the jQuery File Upload plugin
    $('#upload').fileupload({

        // This element will accept file drag/drop uploading
        dropZone: $('#drop'),

        // This function is called when a file is added to the queue;
        // either via the browse button, or via drag/drop:
        add: function (e, data) {

            var tpl = $('<li class="working"><input type="text" value="0" data-width="48" data-height="48"'+
                ' data-fgColor="#0788a5" data-readOnly="1" data-bgColor="#3e4043" /><p></p><span></span></li>');

            // Append the file name and file size
            tpl.find('p').text(data.files[0].name)
                         .append('<i>' + formatFileSize(data.files[0].size) + '</i>');

            // Add the HTML to the UL element
            data.context = tpl.appendTo(ul);

            // Initialize the knob plugin
            tpl.find('input').knob();

            // Listen for clicks on the cancel icon
            tpl.find('span').click(function(){

                if(tpl.hasClass('working')){
                    jqXHR.abort();
                }

                tpl.fadeOut(function(){
                    tpl.remove();
                });

            });

            // Automatically upload the file once it is added to the queue
            var jqXHR = data.submit();
        },

        progress: function(e, data){

            // Calculate the completion percentage of the upload
            var progress = parseInt(data.loaded / data.total * 100, 10);

            // Update the hidden input field and trigger a change
            // so that the jQuery knob plugin knows to update the dial
            data.context.find('input').val(progress).change();

            if(progress == 100){
                data.context.removeClass('working');
            }
        },

        fail:function(e, data){
            // Something has gone wrong!
            data.context.addClass('error');
        }

    });

    // Prevent the default action when a file is dropped on the window
    $(document).on('drop dragover', function (e) {
        e.preventDefault();
    });

    // Helper function that formats the file sizes
    function formatFileSize(bytes) {
        if (typeof bytes !== 'number') {
            return '';
        }

        if (bytes >= 1000000000) {
            return (bytes / 1000000000).toFixed(2) + ' GB';
        }

        if (bytes >= 1000000) {
            return (bytes / 1000000).toFixed(2) + ' MB';
        }

        return (bytes / 1000).toFixed(2) + ' KB';
    }

});*/




jQuery(function(){
	
	var count=0;
	var counter=0;
	
	 var ul = jQuery('#upload ul#uploadedFiles');
     var uploadFileSize = $("#uploadFileSize").val();
    var filestoupload = 0;     
    var totalFileSize = 0;
    jQuery('#drop #browse_btn').click(function(){
        // Simulate a click on the file input button
        // to show the file browser dialog
    	jQuery(this).parent().find('input').click();
    });

    // Initialize the jQuery File Upload plugin
    jQuery('#upload').fileupload({
 
        // This element will accept file drag/drop uploading
        dropZone: jQuery('#drop'),

        
      
       
        // This function is called when a file is added to the queue;
        // either via the browse button, or via drag/drop:
        add: function (e, data) {
        	
        	
        	
            filestoupload++;
            var indextypeid = "indextype_"+ filestoupload;
            var tagid = "tag"+ filestoupload;
            var doctypeid = "doctype"+filestoupload;
            var transtypeid = "transactiontype"+filestoupload;
            var transdate = "transactionDate"+filestoupload;
            var transStatusid = "transactionStatus"+filestoupload;            
            var folderid = "folderNameFViewData"+filestoupload;
            //var indexvalid = "indexval"+filestoupload;
            var indexvalid = "indexval"+filestoupload;
            var fileid = "file"+filestoupload;
            var linkid = "lnk"+filestoupload;
            var checkboxid = "checkboxdata"+filestoupload;
            var hiddencheckboxid = "hiddencheckbox"+filestoupload;
            var textdata = "textdata"+filestoupload;
            var jqXHR;
            var requestRemoved = false;
            var activeRequest = true;
            var flag=false;
            var fileName = data.files[0].name;
            var param = "this.id,"+filestoupload;  
       
                      
         //  if(filestoupload < uploadFileSize) {
            var tpl = jQuery('<li class="working"><div id=div_'+filestoupload+'><p id= '+fileid+'><a style="padding-left: 10px;" id='+linkid+' data-toggle="tooltip" title="" data-placement="bottom" ><i style="float: left"></i></a></p><div style="float:none; clear: both;position: absolute; bottom: 2px; margint-top: 5px; left: 10px;" class=""><input type="checkbox" id='+checkboxid+' name='+checkboxid+' value="apple" /><div style="display:inline-block;margin-bottom:5px; " id='+textdata+'>Do you want to convert this document to PDF?</div>'+
            		'<input type="hidden" id='+hiddencheckboxid+' name='+hiddencheckboxid+' value="" /> </div>'+  
            	/*	'<input type="hidden" id="hiddencheckboxid" name="hiddencheckboxid" value="" /> </div>'+ */                 
                	' </select>'+
                    ' <div style="float:left; width: 105px; margin-left: 100px;  class=""><select style="width: 100px;" id='+doctypeid+' name='+doctypeid+'> </select></div>'+
                    ' <div hidden style="float:left; width: 105px; " class="" style="display: none;"><select style="width: 100px;"  id='+indextypeid+' name='+indextypeid+' > </select></div>'+
                    ' <div style="float:left; width: 105px;" class=""><select style="width: 100px;"  id='+indexvalid+' name='+indexvalid+' > </select></div>'+
                    ' <div style="float:left; width: 105px;" class=""><select style="width: 100px;" id='+transtypeid+' name='+transtypeid+'> </select></div>'+
                    
                    ' <div style="float:left; width: 105px;" class=""><select style="width: 100px;" id='+transStatusid+' name='+transStatusid+'> </select></div>'+
                    ' <div style="float:left; width: 135px; " class=""> <input style="width: 132px;" class="inputbox" placeholder="Select Transaction Date" type="text" id='+transdate+' name = '+transdate+' value=""  ></input> </div>'+
                    //' <div class="col-sm-3"> <input style="width: 100%;"  class="inputbox" placeholder="Index Value" type="text" id='+indexvalid+' name = '+indexvalid+' value=""></input><a title="Add Index" style="display:inline-block;padding-left:10px;" id=add_'+indexvalid+' onclick=addRow('+param+')><i class="zmdi zmdi-plus"></i></a></div>'+
                 //   ' <div class="col-sm-2"> <input style="width: 100%;"  class="inputbox" placeholder="Index Value Required" type="text" id='+indexvalid+' name = '+indexvalid+' value="" class="required" ></input> </div>'+
                    ' <div style="float:left; width: 105px;" class="" id=folderData'+filestoupload+'><select style="width: 100px;" id='+folderid+' name='+folderid+' onchange="ChooseContact('+folderid+')"> </select></div>'+
                    ' <div style="float:left; width: 50px; text-align:center;position: relative;" class=""><span style="width: 50px; " title="Remove file" class="removefile"></span><span style="width: 100px;" class="loading"></span></div> '+
                    ' </li></div>');
            // Append the file name and file size
      //  }else
        	/*{
        	
        	alert ("Upload files count can`t exceed 5.");
        	}*/
           
            tpl.find('p a').text(data.files[0].name)
            .append('<div style="float: left; position: absolute;left: 10px; width: 85px; bottom: 25px;">' + formatFileSize(data.files[0].size) + '</div>');
            
            tpl.find('p a').attr("title",data.files[0].name);
           // tpl.find('p a').title("my title");
            // Add the HTML to the UL element
            data.context = tpl.appendTo(ul);
            
            // Initialize the knob plugin
           // ul.find('#bar').knob();

            // Listen for clicks on the cancel icon
            tpl.find('span').click(function(){

                tpl.remove();//Remove the file from the list
                var fileSize = tpl.find('i').html();
                //alert("file Size "+deformatFileSize(fileSize));
                //totalFileSize = totalFileSize - 
                requestRemoved = true;
                if (jQuery('#uploadedFiles li').length == 0)
            	{
            	  jQuery("#upload_btn").hide();
            	  jQuery("#cancel_btn").hide();
            	
            	}
            });
            $(function() {
        		
        	    $('input[name="transactionDate'+filestoupload+'"]').daterangepicker({
        	        singleDatePicker: true,
        	     
        	        showDropdowns: true,
        	        yearRange: '-100y:c+nn',
        	        locale: {
        	            format: 'MM-DD-YYYY'
        	          },
        	        
        	    }, 
        	    function(start, end, label) {
        	        var years = moment().diff(start, 'years');
        	        //alert("You are " + years + " years old.");
        	    });
        	    $('#transactionDate'+filestoupload).val(""); 
        	});
            
            //Take default index type
            //getDropDowns(doctypeid,indextypeid);
            getDropDowns1("documentType",doctypeid);
            getDropDowns1("indexType",indextypeid);
            getDropDowns1("indexValue",indexvalid);
            getDropDowns1("transactionType",transtypeid);
            getDropDowns1("transactionStatus",transStatusid);          
            
            
            getDropDowns1("folderId",folderid);
            getDefaultIndexVal(indexvalid);
            getDefaulttransDateVal(transdate);
         //  getDefaultfolderVal(folderid);
            //getDefaultCheckboxVal(checkboxid,hiddencheckboxid);

            //If the sum of all the file sizes exceeds limit
            totalFileSize = totalFileSize + data.files[0].size;
            /*if(totalFileSize > 100000000)
            {
                alert("Reached Limit: Total file size "+totalFileSize);

            }*/
         
        
           /* if (  $("#userName").val() === "PRODUCTION")*/ 
            if (  $("#userName").val().toUpperCase().indexOf("PRODUCTION") != -1)
        	{
            	$('#folderData'+filestoupload).hide();
            	$(".col-sm-1").css("padding-left","20px");
        	}
        	
          

            
            var fileNameExt = fileName.substr(fileName.lastIndexOf('.') + 1);  
            
            if(fileNameExt == "pdf" || fileNameExt == "PDF"){
            	      	
            	$('#'+textdata).hide();
            	$('#'+checkboxid).hide();
            	$('#'+hiddencheckboxid).hide();            
            	
            }
            var folderNameFView =document.getElementById('folderNameFView').value;
		    
		 //   alert("folderNameFView123"+folderNameFView);
            setfilecount();//sribala
            jQuery("#upload_btn").show();
            jQuery("#cancel_btn").show();          
            jQuery("#upload_btn").css("left","48%");
            jQuery("#reset_btn").prop('disabled', false);
           // jQuery("#instructionsDiv").hide();
            //jQuery("#reset_btn").show();
            //jQuery("#progress").show();

           
            jQuery("#reset_btn").on('click',function() {
            	if (jQuery('#uploadedFiles li').length > 0)
            	{
            		jQuery('#uploadedFiles li').remove();
            		 jQuery("#upload_btn").hide();
            		 jQuery("#cancel_btn").hide();
                     jQuery("#reset_btn").prop('disabled', true);

            	}
            });
            
            // Automatically upload the file once it is added to the queue       
            
            jQuery("#upload_btn").on('click',function() {
        	   
        	   if(tpl.hasClass('working'))
        	   {
               		activeRequest = true;
               }
        	   else{
        		   activeRequest = false;
        	   }
        	  	
        	   getDefaultCheckboxVal(checkboxid,hiddencheckboxid);  	
        	 
        	   var isValid = true;

        	          $('input[type="text"]').each(function() {

        	              if ($.trim($(this).val()) == '') {

        	                  isValid = false;

        	                  $(this).css({

        	                     // "border": "1px solid red",

        	                    //  "background": "#FFCECE"
        	                	   "border": "",

         	                      "background": ""

        	                  });

        	              }

        	              else {

        	                  $(this).css({

        	                      "border": "",

        	                      "background": ""

        	                  });

        	              }

        	          });

        	          if (isValid == false)

        	        	  flag=false;
        	          else

        	        	  flag=true;

        	   
        	   
        	   
        	   
        	   
        	   
            	//if(check1() && !requestRemoved && activeRequest)
        	  
        	   if(check1() && verifyIndex() &&  !requestRemoved && activeRequest /*&& flag*/)
            	{
        		   
        		   data.context.addClass('processing');
        		//alert("Submitting data");
            		 jqXHR = data.submit()
            		.success(function (result, textStatus, jqXHR) {
            		//alert(result+"kkk")
            			if(result == "fail")
            			{
            				counte++;
            				data.context.addClass('error');
            				data.context.removeClass('processing');
            			}
            			else
        				{
            				counter++;
            			 //alert("Success result "+result+" textStatus "+textStatus+" jqXHR "+jqXHR);
        				 data.context.removeClass('working');
        				 setTimeout(function() {
        				 data.context.removeClass('processing');
        				 },2000);
        				}
            			
            			if(filestoupload === counter){  
            				waitingDialog.hide();
            				

            			}

                    })
                    .error(function (jqXHR, textStatus, errorThrown){
                    	//waitingDialog.hide();
                    	data.context.addClass('error');
        				data.context.removeClass('processing');
                         //alert("Error ");
                    });
            		
            	}
              });
            
            jQuery("#lnk"+filestoupload).on('click',function() {
        	   previewImage(data);           
             });      	
           
        },
        

        progress: function(e, data){
            // Calculate the completion percentage of the upload
            var progress = parseInt(data.loaded / data.total * 100, 10);
            var percent = Math.round((data.loaded / data.total * 100));
            $('#progressBar').attr('aria-valuenow', percent).css('width', percent + '%').text(percent + '%');
            // Update the hidden input field and trigger a change
            // so that the jQuery knob plugin knows to update the dial
           
        	//alert("Inside progress"+progress);

          // ul.find('#bar').val(progress).change();
            //li.find('#progress').val(progress).change();
          /*  jQuery('#progress').removeClass('running').delay(progress/5).queue(function(next){
            	jQuery(this).addClass('running');
		        next();
		    });*/


            if(progress == 100){
            	
               // data.context.removeClass('working');
              //  jQuery("#upload_btn").prop("disabled",true);

            }
        },

       
        
        fail:function(e, data){
            // Something has gone wrong!
            data.context.addClass('error');
        },
        success:function (e, data) {
        	//alert("Call back after success"); 
			data.context.removeClass('working');
         },
       submit: function (e, data) {
    	   //data.context.removeClass('working');
        }
            

    });

     
    jQuery('#upload').bind('fileuploadsubmit', function (e, data) {
       var folderNameFView = $("#folderNameFView");
  
       
       var folder = $("#folderNameFView");
       
       var propertytype = $("#propertytype");
      // var indextype = $('[id^="indextype"]');
       
     /*  alert("propertytype"+propertytype);
       
       propertytype="7901";
       
       alert("propertytype12"+propertytype);
        	*/
     var hiddencheckbox =jQuery('input[type=checkbox]');

     var filecount= $("#filecount").val();//sribala
       var inputs = data.context.find(':input');
       
       var hiddens = jQuery('input[type=hidden]');
       var files = jQuery('input[type=file]');
       
       for(var l=0; l< propertytype.length; l++)
       {
           inputs.push(propertytype[l]);
       } 
      
       for(var k=0; k< folderNameFView.length; k++)
       {
           inputs.push(folderNameFView[k]);
       }    
       
       for(var m=0; m< hiddencheckbox.length; m++)
       {
           inputs.push(hiddencheckbox[m]);
       }  
      
       for(var i=0; i< files.length; i++)
       {
           inputs.push(files[i]);
       }     
       for(var j=0; j< hiddens.length; j++)
       {
           inputs.push(hiddens[j]);
           inputs.push(filecount);//sribala
       }
 
       inputs.push(filecount); //sribala
    data.formData = inputs.serializeArray();
    });
    
    // Prevent the default action when a file is dropped on the window
    jQuery(document).on('drop dragover', function (e) {

        e.preventDefault();
    });

    
   
    //Helper function to preview the files
    function previewImage(pData){
    	var fileType = pData.files[0].type;

		var imageDisplayArea = $("#imageDisplayArea");
        var fileDisplayArea = $("#fileDisplayArea");
         
    	var reader = new FileReader();
    	reader.readAsDataURL(pData.files[0]); 
        fileDisplayArea.data = "";
        imageDisplayArea.src = "";
    	if(fileType == "application/pdf")
    	{	 
            $("#imageDisplayArea").hide();
            $("#docDisplayArea").hide();

            $("#fileDisplayArea").show();
	    	reader.onload = function(event) {
	    		 var dataURL = reader.result;
	    		 //alert("dataurl "+dataURL);
	    		 $("#fileDisplayArea").attr('data', dataURL);
	    	};
	    	$('#slide').popup('show');

    	}else if (fileType == "image/png" || fileType == "image/jpeg")
    	{
            $("#fileDisplayArea").hide();
            $("#imageDisplayArea").show();
    
	    	reader.onload = function(event) {
	    		
	    		 var dataURL = reader.result;
	    		// alert("dataURL "+dataURL);
	    		 $("#imageDisplayArea").attr('src', dataURL);
	    	};
   		
    	}
    	else if(fileType == "application/vnd.openxmlformats-officedocument.wordprocessingml.document" ||
    			fileType == "application/vnd.openxmlformats-officedocument.presentationml.presentation" ||
    			fileType == "application/msword")
    	{
    		//alert("Open word file");         

    		reader.onload = function(event) {
	    		 var dataURL = reader.result;
	    		 $("#docDisplayArea").attr('href', dataURL);
	    		 $("#docDisplayArea").show();
	    		// alert("docDisplayArea "+$("#docDisplayArea"));
	    		 var myLink = document.getElementById('docDisplayArea');
	    		 myLink.click();
	    		 //$("#docDisplayArea").click();
	       };
    		
            
	    	
    	}
    	else
    	{
    		alert("File type is not supported!")
    	}
    }
    
    // Helper function that formats the file sizes
    function formatFileSize(bytes) {
        if (typeof bytes !== 'number') {
            return '';
        }

        if (bytes >= 1000000000) {
            return (bytes / 1000000000).toFixed(2) + ' GB';
        }

        if (bytes >= 1000000) {
            return (bytes / 1000000).toFixed(2) + ' MB';
        }

        return (bytes / 1000).toFixed(2) + ' KB';
    }



//Helper function that gets bytes from the file sizes
function deformatFileSize(fileSize) {
	var number = fileSize.split(' ');
    if (number[1].indexOf('GB') != -1) {
        return (number[0] * 1000000000 );
    }
    if (number[1].indexOf('MB') != -1) {
        return (number[0] * 1000000 );
    }
    if (number[1].indexOf('KB') != -1) {
        return (number[0] * 1000 );
    }

   
}

});

function getDropDowns1(type,id)
{
	
	
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
		
	}

	else if(type === "transactionType")
	{
		var e = document.getElementById("transactiontype");
		var strDocType = e.options[e.selectedIndex].text;
		
		jQuery('#transactiontype option').clone().appendTo('#'+id);
		
		var dd = document.getElementById(id);

		for (var i = 0; i < dd.options.length; i++) {
			 if (dd.options[i].text === strDocType) {		    	
		        dd.selectedIndex = i;
		        break;
		    }
		}
		
	}
	
	else if(type === "transactionStatus")
	{
		
		var ee = document.getElementById("transactionStatus");
		var strDocType = ee.options[ee.selectedIndex].text;
	jQuery('#transactionStatus option').clone().appendTo('#'+id);
		
		var dd = document.getElementById(id);

		for (var i = 0; i < dd.options.length; i++) {
			 if (dd.options[i].text === strDocType) {		    	
		        dd.selectedIndex = i;
		        break;
		    }
		}
		
/*		jQuery('#transactionStatus option').clone().appendTo('#'+id);
*/		
//		 $('#'+id).append($("<option/>", {
//		        value: 'Approved',
//		        text: 'Approved'
//		    }));
//		 $('#'+id).append($("<option/>", {
//		        value: 'Denied',
//		        text: 'Denied'
//		    }));
//		 $('#'+id).append($("<option/>", {
//		        value: 'Approved with Changes',
//		        text: 'Approved with Changes'
//		    }));
//		 $('#'+id).append($("<option/>", {
//			    value: 'Select Transaction Status',
//			    text: 'Select Transaction Status'
//					}));
		/* $("#transactionStatus option").clone().appendTo('#'+id);*/
   
 		}
		
		else if (type === "indexValue")
	{
		var e1 = document.getElementById("indexvalues");
		var strIndexType = e1.options[e1.selectedIndex].text;
		//alert("strIndexType"+strIndexType)
		jQuery('#indexvalues option').clone().appendTo('#'+id);
		
		/*if(document.getElementById(id).options.length > 1)
			document.getElementById(id).selectedIndex =1;*/
		var dd = document.getElementById(id);
		
		 //$(dd).find('option:selected').remove();
		for (var i = 0; i < dd.options.length; i++) {
		    if(dd.options[i].value === 'Select FHA Number' ){		
			 $(dd).find('option:selected').remove();
			}
		   if (String(dd.options[i].text) === String(strIndexType)) {
		        dd.selectedIndex = i;
		        break;
		    }
		
		}
		
	}
	
	else if (type === "indexType")
	{
		var e1 = document.getElementById("indextype");
		var strIndexType = e1.options[e1.selectedIndex].text;
		
		jQuery('#indextype option').clone().appendTo('#'+id);
		
		/*if(document.getElementById(id).options.length > 1)
			document.getElementById(id).selectedIndex =1;*/
		var dd = document.getElementById(id);

		for (var i = 0; i < dd.options.length; i++) {
		if(typeof dd.options[i].text != 'undefined' && dd.options[i].text){		
		    if (String(dd.options[i].text) === String(strIndexType)) {
		        dd.selectedIndex = i;
		        break;
		    }
		}
		}
		
	}
	
	else if (type === "folderId")
	{
	
		var strIndexType = $("#folderNameFView").val();
		var count=0;
		
	//	alert("folderNameFView"+strIndexType);
		
		jQuery('#folderNameFViewData option').clone().appendTo('#'+id);
	/*	
		if(document.getElementById(id).options.length > 1)
			document.getElementById(id).selectedIndex =1;
		*/
		var dd = document.getElementById(id);
	
		//alert( dd.options.length);
		for (var i = 0; i < dd.options.length; i++) {
			//alert(dd.options[i].text.toUpperCase());
		    if (dd.options[i].text.toUpperCase() === strIndexType.toUpperCase()) {
		    	dd.selectedIndex = i;
		    	count++;
		       break;
		    }
		    	   
		}
		
		if(count === 0)
			{
			var optn = document.createElement("OPTION"); 
			optn.text=strIndexType;  
			optn.value=strIndexType;   
			dd.add(optn);
			for (var i = 0; i < dd.options.length; i++) {
				//alert(dd.options[i].text.toUpperCase());
			    if (dd.options[i].text.toUpperCase() === strIndexType.toUpperCase()) {
			    	dd.selectedIndex = i;
			    
			       break;
			    }
			    	   
			}
					
			}
	}
}

function getDefaultIndexVal(id)
{
	var indexval = $("#indexvalues").val();
	
	
	
	if(indexval === "" || indexval === null)
		{
	var folderNameFView = $("#folderNameFView").val();
	//alert("folderNameFViewbac"+folderNameFView);
	
	 
		  
		  var arr = folderNameFView.split('/');
		  indexval=arr[2];
		  
		}
	//	alert("indexval"+indexval);
		
	$('#'+id).val(indexval);
		  
}

function getDefaulttransDateVal(id)
{
var transdate = $("#transactionDate").val();
		
		
	$('#'+id).val(transdate);

}



function getDefaultfolderVal(id)
{
		
	/*var folderNameFView = $("#folderNameFView").val();
	alert("folderNameFView123"+folderNameFView);
	
	  var e1 = $("#"+id);
		var strIndexType = e1.options[e1.selectedIndex].text;
		*/
		
		if(document.getElementById(id).options.length > 1)
			document.getElementById(id).selectedIndex =1;
		var dd = document.getElementById(id);

	
}


function ChooseContact(data) {
	
	

	//alert("date123");
	var e = document.getElementById(data);
	var strDocType = e.options[e.selectedIndex].text;
	
	//alert(strDocType);
	}
function ChoosedataType(data) {
	
	

	//alert("date");
	var e = document.getElementById(data);
	var strDocType = e.options[e.selectedIndex].text;
	
	//alert(strDocType);
	}


function getDefaultCheckboxVal(checkboxid,hiddencheckboxid)
{
    var index = $('[id^="'+checkboxid+'"]');
	var checkedindexvalue =  $(index).is(":checked");
	$('#'+hiddencheckboxid).val(checkedindexvalue);
	//alert(checkedindexvalue + hiddencheckboxid);
		
	
}
function getDropDowns(doctypeid,indextypeid,indextypeid1){
	//alert("indextypeid "+indextypeid);
	alert("kjhkjstrDocType")
	var e = document.getElementById("doctype");
	var strDocType = e.options[e.selectedIndex].text;
	var e1 = document.getElementById("indextype");
	var strIndexType = e1.options[e1.selectedIndex].text;
	
	
	jQuery('#doctype option').clone().appendTo('#'+doctypeid);
	
	var dd = document.getElementById(doctypeid);

	for (var i = 0; i < dd.options.length; i++) {
	    if (dd.options[i].text === strDocType) {
	        dd.selectedIndex = i;
	        break;
	    }
	}
	
	
	jQuery('#indextype option').clone().appendTo('#'+indextypeid);
	if(document.getElementById(indextypeid).options.length > 1)
		document.getElementById(indextypeid).selectedIndex =1;
	
	jQuery('#indexvalues option').clone().appendTo('#'+indexvalid);
	if(document.getElementById(indexvalid).options.length > 1)
		document.getElementById(indexvalid).selectedIndex =1;
	
	
}

function setPropertyFolder() {
	
	alert("heello");
	
	
	/*
	var folderid=$('#'+folderid).val();
	
	alert("folderid"+folderid);
	
	    document.getElementById("folderNameFView").value =folderid;
	    alert( document.getElementById("folderNameFView").value);
	    
	    getDefaultIndexVal(indexvalid);
	    */
	    
	}
function addRow(id,rowNum) {
	var divId = $("#"+id).parent().parent().attr('id');

    var intId = ($("#"+divId+" > div").length-4) + 1;
    var fieldWrapper = $("<div style=\"float:right;clear:both;width:488px;\" class=\"row\" id=\"field" + intId + "\"/>");
    var indexTypeSelect = $("<div style=\"padding-left: 0px;\" class=\"col-sm-5\"><select style=\"width: 100%;\"  id=\"indextype_"+rowNum+"_"+intId+"\" name=\"indextype_"+rowNum+"_"+intId+"\" /></div>");
    var fName = $("<div style=\"padding-left: 0px;\" class=\"col-sm-5\"><input id=\"indexval"+rowNum+"_"+intId+"\" name=\"indexval"+rowNum+"_"+intId+"\" style=\"width: 100%;\"  type=\"text\" value=\"\" /></div>");

    var removeButton = $("<div style=\"padding-left: 0px;\" class=\"col-sm-1\"><a style=\"display: inline-block; padding-left: 0px;\"><i class=\"zmdi zmdi-minus\"></i></a></div>");
    removeButton.click(function() {
        $(this).parent().remove();
    });
    fieldWrapper.append(indexTypeSelect);
    fieldWrapper.append(fName);
    fieldWrapper.append(removeButton);
    $("#"+divId).append(fieldWrapper);
    getDropDowns1("indexType","indextype_"+rowNum+"_"+intId)
	
}   
