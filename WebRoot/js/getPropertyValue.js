	var indices = [];
	var  indicesArray = [];
function getPropertyValues(autocompleteId,autocompleteId1){

	$.ajax({
        type: "POST",
	    url: './GetPropertyValues',
	    data: '',
	    dataType:'json',
	    success: function(data) {
	    	indices = data[0];
	        //alert("data "+data[0]);
	        indicesArray = $.map(indices, function (value, key) { return { value: value, data: key }; });

		   
		    // Initialize ajax autocomplete:
		    $('#'+autocompleteId).autocomplete({
		        lookup: indicesArray,
		        lookupFilter: function(suggestion, originalQuery, queryLowerCase) {
		        	
		            var re = new RegExp('\^' + $.Autocomplete.utils.escapeRegExChars(queryLowerCase), 'i');

		            return re.test(suggestion.value);
		        }
		       /* onSelect: function(suggestion) {
		            $('#selction-ajax').html('You selected: ' + suggestion.value + ', ' + suggestion.data);
		        },
		        onHint: function (hint) {
		            $('#autocomplete-ajax-x').val(hint);
		        },
		        onInvalidateSelection: function() {
		            $('#selction-ajax').html('You selected: none');
		        }*/
		    });
		    
		    $('#'+autocompleteId1).autocomplete({
		        lookup: indicesArray,
		        lookupFilter: function(suggestion, originalQuery, queryLowerCase) {
		        	
		            var re = new RegExp('\^' + $.Autocomplete.utils.escapeRegExChars(queryLowerCase), 'i');

		            return re.test(suggestion.value);
		        }
		       
		    });
		   
		      //$('#my_popup').popup('hide');

	    }
	});	

	
}


