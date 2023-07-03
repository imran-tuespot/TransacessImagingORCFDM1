  
    var app = angular.module('addDocModule', []);
    app.controller('getItemsCtrl', function getItemCount($scope, $http, $window) {
    	$scope.binder = [];
    	/* Capability: Add New Binder: Records Management: NARA Processing Enabled
    		 Req. ID. AINPR1.0.4 */
    	

    	/* Capability: Add New Binder: Records Management: NARA Processing Enabled
    		 Req. ID. AINPR1.0.5 */
    	$scope.items =  [{binderId: 'binder1',startDateId:'stDate1',tagId:'tag1'}];
    	$scope.focusVar = true;

    	
    	$scope.type = {"type":"documentType"};
    	 $http({
    	    url: "ClassicSearch", method: 'POST',
    	    data: $scope.type 	    
        }).success(function(responseJson) {  
    		$scope.stDate1 = responseJson;

    	});
    	
    	
    	$scope.addNewItem = function(id){
    		var currVal = $scope.binder[id];
    		if(currVal != undefined)
    		{
    			var newItemNo = $scope.items.length+1;
    			$scope.items.push({binderId: 'binder'+newItemNo,startDateId:'stDate'+newItemNo,tagId:'tag'+newItemNo});
    			$scope.focusVar = true;	
    			$scope.$apply();
    			var dateId = 'stDate'+newItemNo;
     			getDocumentType(dateId);        		
    		}		
    		
    	}
    	/* Capability: Add New Binder: Records Management: NARA Processing Enabled
    		 Req. ID. AINPR1.0.7 */
    	$scope.checkDuplicate = function(id)
    	{		
    		var itemCount = $scope.items.length;
    		var currVal = $scope.binder[id];
    		if (currVal != undefined)
    		{
    			for(var i=1; i<itemCount; i++)
    			{
    				var itemId = $scope.items[i-1].binderId;
    				//alert("itemId = "+itemId);

    				var itemVal = $scope.binder[itemId];
    				//alert("currVal "+currVal);
    				//alert("itemVal "+itemVal);
    				
    				if(currVal === itemVal )
    				{
    					/* Capability: Add New Binder: Records Management: NARA Processing Enabled
    					 Req. ID. AINPR1.0.7 AINPR1.0.8 Restrict duplicate binders being added to the system */
    					
    					swal("Error!", "Duplicate Item!", "error");
    				    angular.element( document.querySelector( '#'+id) ).css('borderColor', 'red');				
    					//Disable submit
    					$scope.isSubmitDisabled = true;
    					return false;
    				}
    			    angular.element( document.querySelector( '#'+id) ).css('borderColor', '#CCC');

    			}
    			$scope.isSubmitDisabled = false;
    			
    			return true;			
    		}
    	}
    	
    	
    	$scope.removeAll = function() {
    		//alert("Inside removall");
    		$scope.binderData = [];
    		var itemCount = $scope.items.length;
    		
    		for(var i=1; i<itemCount; i++)
    		{
    			$scope.binder['binder'+i] = "";
    			$scope.binder['stDate'+i] = ""; // 2015-05-23
    			$scope.binder['tag'+i] = "";	
    			
    		}
    		$scope.items =  [{binderId: 'binder1',startDateId:'stDate1',tagId:'tag1'}];
    		$scope.binder['binder1'] = "";
    		$scope.binder['stDate1'] = new Date().toISOString().split("T")[0]; // 2015-05-23
    		$scope.binder['tag1'] = "";	
    	}
    	
    	$scope.addRecordToBinder = function()
    	{
    		$scope.binderData = [];

    		var itemCount = $scope.items.length;
    		alert("Itemcount = "+itemCount);
    		
    		//	$scope.binderData.push({binderTypeId:binderType,retentionPeriod:retentionPeriod});
    		
    		for(var i=1; i<= itemCount; i++)
    		{
    			//alert("i= "+i);
    			var itemId = $scope.items[i-1].binderId;
    			var tagId = $scope.items[i-1].tagId;
    			var startDateId = $scope.items[i-1].startDateId;
    			
    			
    			var itemVal = $scope.binder[itemId];
    			var tagVal = $scope.binder[tagId];
    			var startDateVal = $scope.binder[startDateId];
    			
    			alert("itemVal "+itemVal );
    			alert("tagval "+tagVal);
    			alert("startDateVal "+startDateVal);
    			if(itemVal != undefined && itemVal.length < 10)
    			{
    				/* Capability: Add New Binder: Records Management: NARA Processing Enabled
    				 Req. ID. AINPR1.0.9 Provide error message upon inputting erroneous binder no. */
    				
    				swal("Error!", "Please enter correct item number!", "error");
            		angular.element( document.querySelector( '#'+itemId) ).css('borderColor', 'red');

    				return false;
    			}	
    			//if(itemVal !=undefined && itemVal.length == 10)
    				//$scope.binderData.push({itemId: itemVal,startDateId:startDateVal,tagId:tagVal,binderTypeId:binderType,retentionPeriod:retentionPeriod});

    		}	
    		
    		alert("sending data");
    		$http({
    			url : "AddRecordToBinder",
    			method : 'POST',
    			data: $scope.binderData
    		}).success(function(responseJson) {
    			alert("response "+responseJson);
    			swal("Success!", "All records are successfully inserted in binder"+responseJson, "success");
    			//$window.location.href = 'insertAssetConfirmation.jsp?boxNumber='+responseJson;
    			//$scope.removeAll();			

    		}).
            error(function(data, status) {
            	
            	alert("data len "+data.length);
            	for(var i=0;i<data.length;i++)
            	{
    			    alert("duplicate record item id "+data[i].id);
            		angular.element( document.querySelector( '#'+data[i].id) ).css('borderColor', 'red');
            		// result += data[i].id  + ', ';
            	}
            	
              });
    	}
    	
    	

    	

    	
    	

    	$scope.shouldShow = function()
    	{
    		if($scope.retentionPeriod > 0)
    		{

    			return true;
    		}
    		else{

    			return false;
    		}
    	    $scope.$apply();

    		
    	}

    });
    
    app.controller('getDropdownCtrl',function getDropdowns($scope,$http)
    {    
    	$scope.type = {"type":"documentType"};
		 $http({
	 	    url: "ClassicSearch", method: 'POST',
	 	    data: $scope.type 	    
	     }).success(function(responseJson) {  
			$scope.documentType = responseJson;
		});
	 
   
		 $scope.type = {"type":"indexType"};
		 $http({
	 	    url: "ClassicSearch", method: 'POST',
	 	    data: $scope.type 	    
	     }).success(function(responseJson) {  
			$scope.indexType = responseJson;
		}); 		
    	
	});
    
    
/*Controller to get folder names: Folder names are stored in session
  variable which in turn are accessed by connector script jqueryFolderSelection.jsp
 */
    
    app.controller('GetBindersCtrl', function($scope, $http) {
    	$scope.init = function () {
    		 $http({
    		 	    url: "GetBinders", method: 'POST'
    		     }).success(function() { 
    			});

    	};

    });

jQuery(function(){
	
    var ul = jQuery('#upload ul#uploadedFiles');

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
            //var indextypeid = "indextype"+ filestoupload;
            var tagid = "tag"+ filestoupload;
            var doctypeid = "doctype"+filestoupload;
            var indexvalid = "indexval"+filestoupload;
            var fileid = "file"+filestoupload;
            var linkid = "lnk"+filestoupload;
            var jqXHR;
            var requestRemoved = false;
            var activeRequest = true;
            var fileName = data.files[0].name;
             
            /* Capability: Add New File: Content Management: Individual or Batch File
			  Req. Id: ANFPR1.0.8 Select document type determined by Administrator and enter index value
             		   ANFPR1.0.9 Enter additional metadata into tag field*/
            
            var tpl = jQuery('<li class="working"><div class="span2"><p  id= '+fileid+'><a id='+linkid+' data-toggle="tooltip" title="" data-placement="bottom" ></a></p></div>'+                    
                	/*' <div class="span3" id= div'+indextypeid+ '><select id= '+indextypeid+'  name='+indextypeid+'>	'+*/
                	' </select></div>'+
                    ' <div class="span3"><select id='+doctypeid+' name='+doctypeid+' > </select></div>'+
                    ' <div class="span3"> <input class="inputbox" placeholder="Index Value" type="text" id='+indexvalid+' name = '+indexvalid+' value=""></input></div>'+
                    ' <div class="span3"><input class="inputbox" placeholder="Tags" type="text" id= '+tagid+'  name='+tagid+'></input></div>	'+
                    ' <div class="span1"><span></span></div></li>');
            // Append the file name and file size
           
            tpl.find('p a').text(data.files[0].name)
            .append('<i>' + formatFileSize(data.files[0].size) + '</i>');
            
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
            	}
            });
            
            //getDropDowns(indextypeid,doctypeid);   
            //Take default index type
            getDropDowns(doctypeid);
            
            //If the sum of all the file sizes exceeds limit
            totalFileSize = totalFileSize + data.files[0].size;
            if(totalFileSize > 100000000)
            {
                alert("Limit ");

            }
            
            jQuery("#upload_btn").show();
            jQuery("#reset_btn").prop('disabled', false);
            jQuery("#instructionsDiv").hide();
            //jQuery("#reset_btn").show();
            //jQuery("#progress").show();

            
            // Automatically upload the file once it is added to the queue
           /* var jqXHR = data.submit();*/
            
            /* Capability: Add New File: Content Managment: Individual or Batch File
			 Req Id: ANFPR1.0.5  ANFPR1.0.7 */
            
            jQuery("#upload_btn").on('click',function() {
        	   
        	   if(tpl.hasClass('working'))
        	   {
               		activeRequest = true;
               }
        	   else{
        		   activeRequest = false;
        	   }
        	   
        	   
            	//if(check1() && !requestRemoved && activeRequest)
        	   if(check1() && !requestRemoved && activeRequest)
            	{
            		 jqXHR = data.submit()
            		.success(function (result, textStatus, jqXHR) {
                                   			
            			if(result == "fail")
            	            data.context.addClass('error');

                    })
                    .error(function (jqXHR, textStatus, errorThrown){
                         alert("Error ");
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
            // Update the hidden input field and trigger a change
            // so that the jQuery knob plugin knows to update the dial
           
        	//alert("Inside progress"+progress);

          // ul.find('#bar').val(progress).change();
           
            jQuery('#progress').removeClass('running').delay(progress/5).queue(function(next){
            	jQuery(this).addClass('running');
		        next();
		    });
           /* data.context.find('#bar').val(progress).change();*/


            if(progress == 100){
            	
                data.context.removeClass('working');
              //  jQuery("#upload_btn").prop("disabled",true);

            }
        },

        /* Capability: Add New File: Content Management: Individual or Batch File
		   Req. Id: ANFPR1.0.5 Upload file and display on screen indicator for 
		   successful/unsuccessful file upload */
        
        fail:function(e, data){
            // Something has gone wrong!
            data.context.addClass('error');
        },
       submit: function (e, data) {
        	//alert("Call back after submit"); 
        }
            

    });

     
    jQuery('#upload').bind('fileuploadsubmit', function (e, data) {
       var inputs = data.context.find(':input');
       var hiddens = jQuery('input[type=hidden]');
       var files = jQuery('input[type=file]');
       for(var i=0; i< files.length; i++)
       {
           inputs.push(files[i]);
       }     
       for(var j=0; j< hiddens.length; j++)
       {
           inputs.push(hiddens[j]);
       }
   /* if (dataArray.filter(function () {
            return !this.value && jQuery(this).prop('required');
        }).first().focus().length) {
        data.context.find('upload_btn').prop('disabled', false);
        return false;
    }*/
    data.formData = inputs.serializeArray();
    });
    
    // Prevent the default action when a file is dropped on the window
    jQuery(document).on('drop dragover', function (e) {

        e.preventDefault();
    });

    
    /* Capability: Add New File: Content Management: Individual or Batch File
	  Req. Id: ANFPR1.0.6 Preview uploaded files
     		   ANFPR1.0.7 Display error message for unsupported file. */
    
    //Helper function to preview the files
    function previewImage(pData){
    	var fileType = pData.files[0].type;
		var imageDisplayArea = jQuery("#imageDisplayArea");
        var fileDisplayArea = jQuery("#fileDisplayArea");
         
    	var reader = new FileReader();
    	reader.readAsDataURL(pData.files[0]); 
        fileDisplayArea.data = "";
        imageDisplayArea.src = "";
    	if(fileType == "application/pdf")
    	{	 
            jQuery("#imageDisplayArea").hide();
            jQuery("#fileDisplayArea").show();

	    	reader.onload = function(event) {
	    		 var dataURL = reader.result;
	    		 jQuery("#fileDisplayArea").attr('data', dataURL);
	    	};
	    	jQuery('#slidelnk').click();

    	}else if (fileType == "image/png" || fileType == "image/jpeg")
    	{
            jQuery("#fileDisplayArea").hide();
            jQuery("#imageDisplayArea").show();
    
	    	reader.onload = function(event) {
	    		 var dataURL = reader.result;
	    		 jQuery("#imageDisplayArea").attr('src', dataURL);
	    	};
	    	jQuery('#slidelnk').click();

    		
    	}
    	else if(fileType == "application/vnd.openxmlformats-officedocument.wordprocessingml.document" ||
    			fileType == "application/vnd.openxmlformats-officedocument.presentationml.presentation" ||
    			fileType == "application/msword")
    	{
    		jQuery("#fileDisplayArea").hide();
            jQuery("#imageDisplayArea").hide();
            jQuery("#pptdisplayArea").hide();
            jQuery("#docDisplayArea").show();
            
	    	reader.onload = function(event) {
	    		 var dataURL = reader.result;
	    		 alert("dataURL "+dataURL);
	    		 jQuery("#docDisplayArea").attr('href', dataURL);
	    };
	    	jQuery('#slidelnk').click();
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

function getDocumentType(doctypeid){
	var e = document.getElementById("doctypeDef");
	var strDocType = e.options[e.selectedIndex].text;
	
		
	//var textToFind = 'Document Type2';
	var dd = document.getElementById(doctypeid);

	for (var i = 0; i < dd.options.length; i++) {
	    if (dd.options[i].text === strDocType) {
	        dd.selectedIndex = i;
	        break;
	    }
	}
	
}
