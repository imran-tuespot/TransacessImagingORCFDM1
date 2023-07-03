
jQuery(function(){
	$("#uploadandremove").hide();
	 var reg = /^\d+$/;
	var count=0;
	var counter=0;
	var fomdataglobal=new FormData();
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
var fileNameExt = data.files[0].name.substr(data.files[0].name.lastIndexOf('.') + 1);  


            if(fileNameExt == "pdf" || fileNameExt == "PDF"){
            	
              if($('#myTablebody').children('tr').length<16){
            filestoupload++;
            var indextypeid = "indextype_"+ filestoupload;
            var tagid = "tag"+ filestoupload;
            var IREMS = "iremsnumber"+filestoupload;
            var doctypeid = "doctype"+filestoupload;
            var folderid = "folderNameFViewData"+filestoupload;
            //var indexvalid = "indexval"+filestoupload;
            var indexvalid = "indexval"+filestoupload;
            var progressid = "progress"+filestoupload;
            var statusid = "status"+filestoupload;
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
            console.log("rowas"+$('#myTablebody').children('tr').length);
           
            fomdataglobal.append('file'+filestoupload,data.files[0])
         //  if(filestoupload < uploadFileSize) {
/*            var tpl = jQuery('<li class="working" id=li_'+filestoupload+'><div id=div_'+filestoupload+'><div class="widthName"><p><a>'+data.files[0].name+'</a></p></div>'+
            		
            		'<div class="widthSize">' + formatFileSize(data.files[0].size) + '</div>'+
            		 ' <div class="widthIREMS"><input style="width: 100%;" " id='+IREMS+' name='+IREMS+'> </input></div>'+
                    ' <div class="widthdoc"><select " id='+doctypeid+' name='+doctypeid+'> </select></div>'+
                  '<div class="widthProgress profress-bar"  id='+progressid+' name='+progressid+'> </div>'+
                  '<div style="display:none" id=bar'+progressid+' name=bar'+progressid+' class="progress-bar stripes animated reverse slower"><div class="progress-bar-inner"></div></div>'+
                    '<div class="widthStatus" id='+statusid+' name='+statusid+'>Pending</div>'+
                    ' <div class="widthActions">'+
                    '<button type="button" id='+filestoupload+' class="  btn-success btn-upload" ><i class="fa fa-upload" aria-hidden="true"></i> Upload</button>'+
                   
                    '<button type="button" class="deletedoc btn-upload" style="    color: #fff;background-color:#ff9900;"><i class="fa fa-trash" aria-hidden="true"></i> Remove</button>'+
                   '</div> '+
             ' </li></div>');*/
            
            
           var tpl = jQuery( '<tr class="working" id=li_'+filestoupload+'><td id=div_'+filestoupload+' style="    width: 26px;"><div class="widthName"><p ><a style="font-size: 13px;">'+data.files[0].name+'</a></p></div></td>'+
            		
            		'<td><div class="widthSize">' + formatFileSize(data.files[0].size) + '</div></td>'+
            		 '<td class="width130"> <div  class="widthIREMS"><input style="width: 100%;" id='+IREMS+' onchange=iremschange("'+filestoupload+'") name="verifyd '+IREMS+'"> <img onclick="autopopulate('+filestoupload+')" id=img'+filestoupload+' style="display:none;cursor: pointer;margin-right: 5px;height: 12px; position: absolute;left: 46%; margin-top: 7px;" src="images/AutoArr1.png" > </input></div></td>'+
                    ' <td><div class="widthdoc"><select style="    width: 118px;" id='+doctypeid+' name='+doctypeid+'> </select></div></td>'+
                  '<td><div class="widthProgress profress-bar"  id='+progressid+' name='+progressid+'> </div>'+
                  '<div style="display:none" id=bar'+progressid+' name=bar'+progressid+' class="widthbarprogress progress-bar stripes animated reverse slower"><div class="progress-bar-inner"></div></div></td>'+
                    '<td><div class="widthStatus" id='+statusid+' name='+statusid+'>Pending</div></td>'+
                    '<td> <div class="widthActions">'+
                    '<button type="button" id='+filestoupload+' class="  btn-success btn-upload" ><i class="fa fa-upload" aria-hidden="true"></i> Upload</button>'+
                   
                    '<button type="button" id=file'+filestoupload+' class="deletedoc btn-upload" ><i class="fa fa-trash" aria-hidden="true"></i> Remove</button>'+
                   '</div> </td>'+
             ' </tr>');
            
            
         /*   var tpl11 = jQuery('<tr class="working"><td><p><a>'+data.files[0].name+'</a></p></td>'+
            '<td>'+ formatFileSize(data.files[0].size) + '</td>'+
            '<td class="bdr"><div><input style="width: 100%;" " id='+IREMS+' name='+IREMS+'> </input></div></td>'+
            '<td class="options"><select id='+doctypeid+' name='+doctypeid+'></select></td>'+
            
            '<td> <div class="profress-bar"id='+progressid+' name='+progressid+'>Pross</div></td>'+
            '<td><div id='+statusid+' name='+statusid+'>Pending</td>'+
            '<td><div class="actions">'+
                   ' <button type="button" class="btn btn-success"><i class="fa fa-upload" aria-hidden="true"></i> Upload</button>'+
                    '<button type="button" class="btn deletedoc btn-danger" style="border color:#ff9900;background-color:#ff9900;"><i class="fa fa-trash" aria-hidden="true"></i> Remove</button>'+
                '</div> </td></tr>');
            */
            
            
            filedetection(filestoupload,fomdataglobal);
            tpl.find('.btn-success').click(function(){
            	//console.log($(this).attr('id'))
            	
            	singlefileupload12($(this).attr('id'),fomdataglobal);
            	
            })
            
          
             $("#allSubmit").click(function (event) {

	        
	        event.preventDefault();

	        fire_ajax_submit(filestoupload,fomdataglobal);

	    });
            // Append the file name and file size
      //  }else
        	/*{
        	
        	alert ("Upload files count can`t exceed 5.");
        	}*/
           
//            tpl.find('p a').text(data.files[0].name)
//            .append('<div style="float: left; position: absolute;left: 10px; width: 85px; bottom: -20px;">' + formatFileSize(data.files[0].size) + '</div>');
//            
            tpl.find('p a').attr("title",data.files[0].name);
           // tpl.find('p a').title("my title");
            // Add the HTML to the UL element
           // data.context = $('#myTable tbody').append(tpl);
            data.context = tpl.appendTo("#myTable tbody");
            // Initialize the knob plugin
           // ul.find('#bar').knob();
            jQuery(".deletedoc").on('click',function() {
            	
            	var selectId= $(this).attr('id');
            	console.log(selectId.substr(4,4));
            	$('#li_'+selectId.substr(4,4)).remove();
            	fomdataglobal.delete($(this).attr('id'));

                tpl.remove();//Remove the file from the list
                var fileSize = tpl.find('i').html();
                //alert("file Size "+deformatFileSize(fileSize));
                //totalFileSize = totalFileSize - 
                requestRemoved = true;

        	
        });

            
            
            if ($('#myTablebody').children('tr').length>1)
         	{
        		
             	 $("#uploadandremove").show();
         	
         	}else{
         		 $("#uploadandremove").hide();
         	}
            jQuery("#reset_btn").on('click',function() {
            	
            		window.location.reload();

            	
            });
            jQuery("#dataremove").on('click',function() {
            	var fileindex=$("#fileuploadId").val()
            	if(fileindex!=''){
            		fomdataglobal.delete(fileindex);
            		$("#fileuploadId").val('');
            	}
            	
            	console.log("fileuploadIdscript:"+$("#fileuploadId").val()	)
        		//window.location.reload();

        	
        });
            
            //Take default index type
           // getDropDowns1("iremsnumber",IREMS);
            getDropDowns1("documentType",doctypeid);
//            getDropDowns1("indexType",indextypeid);
//            getDropDowns1("indexValue",indexvalid);
//            getDropDowns1("folderId",folderid);
//            getDefaultIndexVal(indexvalid);
         //  getDefaultfolderVal(folderid);
            //getDefaultCheckboxVal(checkboxid,hiddencheckboxid);

            //If the sum of all the file sizes exceeds limit
            totalFileSize = totalFileSize + data.files[0].size;
            console.log("totalFileSize"+totalFileSize)
            /*if(totalFileSize > 100000000)
            {
                alert("Reached Limit: Total file size "+totalFileSize);

            }*/
         
        
           /* if (  $("#userName").val() === "PRODUCTION")*/ 
//            if (  $("#userName").val().toUpperCase().indexOf("PRODUCTION") != -1)
//        	{
//            	$('#folderData'+filestoupload).hide();
//            	$(".col-sm-1").css("padding-left","20px");
//        	}
        	
         
            var namesplit=fileName.split("_");
           if(namesplit.length>1){
        	   var iremsno=namesplit[0];
        	   var propertyTypeNamefrom=namesplit[1];
        	   if(reg.test(iremsno)&&iremsno.length==9){
        		  
        	         $('#'+IREMS).val(namesplit[0]);
        	         
        	         $('#img'+filestoupload).css("display", "initial");
        	         console.log(namesplit[1].split(".")[0].replace(/\s\s+/g, ' '));
        	         $('#'+doctypeid+ ' option:contains(' + namesplit[1].split(".")[0].replace(/\s\s+/g, ' ') + ')').attr('selected', 'selected');
        	            }  
        	   if(propertyTypeNamefrom.lastIndexOf('(')!=-1){
        		   var version = propertyTypeNamefrom.match(/\(([^)]+)\)/)
        		   if(reg.test(version[1])){
        			  var doctypeversionname= propertyTypeNamefrom.split('(');
        			  $('#'+doctypeid+ ' option:contains(' +doctypeversionname[0].trim().replace(/\s\s+/g, ' ') + ')').attr('selected', 'selected'); 
        			  var docIdgetting= $('#'+doctypeid).find(":selected").val();
        			  if($('#'+doctypeid+' option[value="'+docIdgetting+'"]').attr("disabled") ||  $('#'+doctypeid+' option[value="'+docIdgetting+'"]').prop("disabled"))
 					 {
        				  $('#'+doctypeid).find($('option')).attr('selected',false)
        				  document.getElementById('#'+doctypeid).selectedIndex = "-1";
 					  }
        		   }
        		   
        	   }else{
        		   $('#'+doctypeid+ ' option:contains(' +propertyTypeNamefrom.split(".")[0].replace(/\s\s+/g, ' ') + ')').attr('selected', 'selected'); 
        		   var docIdgetting= $('#'+doctypeid).find(":selected").val();
     			  if($('#'+doctypeid+' option[value="'+docIdgetting+'"]').attr("disabled") ||  $('#'+doctypeid+' option[value="'+docIdgetting+'"]').prop("disabled"))
					 {
     				 $('#'+doctypeid).find($('option')).attr('selected',false)
     				 document.getElementById('#'+doctypeid).selectedIndex = "-1";
     				 // 
					  }
        	   }
           }
			
           /* var fileNameExt = fileName.substr(fileName.lastIndexOf('.') + 1);  
            
            if(fileNameExt == "pdf" || fileNameExt == "PDF"){
            	      	
            	$('#'+textdata).hide();
            	$('#'+checkboxid).hide();
            	$('#'+hiddencheckboxid).hide();            
            	
            }*/
         //   var folderNameFView =document.getElementById('folderNameFView').value;
		    
		 //   alert("folderNameFView123"+folderNameFView);
           
            jQuery("#upload_btn").show();
                  
            jQuery("#upload_btn").css("left","48%");
            jQuery("#reset_btn").prop('disabled', false);
           // jQuery("#instructionsDiv").hide();
            //jQuery("#reset_btn").show();
            //jQuery("#progress").show();

        
               	
        }else{
        	$('#messageshow').text('Max file limit is 16 only')
        }
            }else{
            	$('#messageshow').text('Upload only PDF files')
            }
        },
        

        progress: function(e, data){
        	//console.log("naveen")
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
        },
      
        always: function (e, data) {console.log("--always--");}

    });
    $('#upload').bind('fileuploadcompleted', function (e, data) {
    	alert('llllllll');
    });
   
     
    jQuery('#upload').bind('fileuploadsubmit', function (e, data) {
       var folderNameFView = $("#folderNameFView");
  
       
       var folder = $("#folderNameFView");
       
       var propertytype = $("#propertytype");
      
     /*  alert("propertytype"+propertytype);
       
       propertytype="7901";
       
       alert("propertytype12"+propertytype);
        	*/
     var hiddencheckbox =jQuery('input[type=checkbox]');

     var filecount= $("#filecount").val();
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
           inputs.push(filecount);
       }
 
       inputs.push(filecount);
       console.log("inputs"+inputs)
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
		$("option[value='1007']").attr("disabled", "disabled");
		$("option[value='1008']").attr("disabled", "disabled");
		$("option[value='886']").attr("disabled", "disabled");
		
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
		$("option[value='426']").attr("disabled", "disabled");
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
			
	}else 	if(type === "iremsnumber")
	{
		var e = document.getElementById("iremsnumber");
		var numIREMS = e.options[e.selectedIndex].text;
		
	
		jQuery('#iremsnumber option').clone().appendTo('#'+id);
		
		var dd = document.getElementById(id);

		for (var i = 0; i < dd.options.length; i++) {
			 if (dd.options[i].text === numIREMS) {		    	
		        dd.selectedIndex = i;
		        break;
		    }
		}
		
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
		
		 $(dd).find('option:selected').remove();
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
