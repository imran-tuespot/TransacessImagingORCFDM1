function stopRKey(evt) 
{
	var evt = evt = (evt) ? evt : (window.event) ? event : null;
	if (evt)
    {
    	var charCode = (evt.charCode) ? evt.charCode :
                       ((evt.keyCode) ? evt.keyCode :
                       ((evt.which) ? evt.which : 0));
	    var specialChars="~!#$%^&*<>'";

		if(specialChars.indexOf(String.fromCharCode(charCode))!=-1)
	  	{
			return false;
	  	}
	} 
}

function validate_required(field,alerttxt)
{
    with (field)
    {
        if (value==null||value=="")
        {
            alert(alerttxt);
            return false;
        }
        else
        {
            return true
        }
    }

}
// Removes Leading whitespaces
function LTrim( value ) { 
		 
		var re = /\s*((\S+\s*)*)/; 
		return value.replace(re, "$1"); 
		 
	} 
	 
	// Removes ending whitespaces 
	function RTrim( value ) { 
		 
		var re = /((\s*\S+)*)\s*/; 
		return value.replace(re, "$1"); 
		 
	} 
	 
	// Removes leading and ending whitespaces 
	function trim( value ) { 
		 
		return LTrim(RTrim(value)); 
		 
	} 
	 
