
function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}


function SelectDropDownValue(selValue,dropctrl)
{
	//var nID = document.getElementById(NextCtrl);
	var cDrop = document.getElementById(dropctrl);
	if(cDrop == null || cDrop.length <=0)
		return;
		
	for(var i=0;i<cDrop.length; i++)		
	{
		if(	selValue == cDrop[i].text)
		{
			cDrop.selectedIndex = i;
			//alert(cDrop.selectedIndex);
			break;
		}		
	}
		
}


function checkIAndIISameTitles(textCtrl1,textCtrl2)
{
	var tCtrl = document.getElementById(textCtrl1);
	var tCtr2 = document.getElementById(textCtrl2);
	
	if(tCtrl == null || tCtr2 == null )
		return;
	
	if (tCtrl.value != "" && tCtr2.value != "")	
	{
		if (tCtrl.value  == tCtr2.value)
		return false;
	}
	
	return true;
}


function SelectTextValue(selValue,textctrl)
{
	var tCtrl = document.getElementById(textctrl);
	if(tCtrl == null )
		return;

	//alert(selValue);
	
	tCtrl.value = selValue;
		
	//alert(tCtrl.value);	
}

function SetCheckValues(form)
{
	
	var elem = form.elements;
	for(var i = 0; i < elem.length; i++)
	{
		if(elem[i].name.toLowerCase().search('chk_') != -1 )
		{
			if(document.getElementById(elem[i].name) != null)
			{
				if(document.getElementById(elem[i].name) != null)
				{
					if( document.getElementById(elem[i].name).checked == true)
						document.getElementById(elem[i].name).value= "Y";
					else
						document.getElementById(elem[i].name).value= "N";
				}	
			}
			
		}
		/*
		else if(elem[i].name.toLowerCase().search('check_') != -1 )
		{
			if(document.getElementById(elem[i].name+'_Y') != null || document.getElementById(elem[i].name+'_N') != null)
			{
				if( document.getElementById(elem[i].name+'_Y').value == 'on')
					document.getElementById(elem[i].name+'_Y').value= "Y";
				else
					document.getElementById(elem[i].name+'_Y').value= "N";
			}	
		}
		*/
		 
		
	} 

}

function ShowHide(id)
{

    div = document.getElementById(id);

    if (div == null)
        return;

    if (div.style.visibility == 'hidden')
    {
        div.style.visibility = 'visible';
        div.style.display='';
    }
    else
    {
        div.style.visibility = 'hidden';
        div.style.display='none';

    }
		
}

function MoveNext(NextCtrl, sText, nCount)
{

	var nID = document.getElementById(NextCtrl);
	var cID = document.getElementById(sText);
		
	if(cID != null && cID.value.length == nCount && nID != null)
		nID.focus();

}


function IsNumeric(sText)
{
   var ValidChars = "0123456789.";
   var IsNumber=true;
   var Char;

 
   for (i = 0; i < sText.length && IsNumber == true; i++) 
      { 
      Char = sText.charAt(i); 
      if (ValidChars.indexOf(Char) == -1) 
         {
         IsNumber = false;
         }
      }
   return IsNumber;
   
}

function IsNumericSame(sText)
{

	if(sText == "0000000000")return false;
	if(sText == "1111111111")return false;
	if(sText == "2222222222")return false;
	if(sText == "3333333333")return false;
	if(sText == "4444444444")return false;
	if(sText == "5555555555")return false;
	if(sText == "6666666666")return false;
	if(sText == "7777777777")return false;
	if(sText == "8888888888")return false;
	if(sText == "9999999999")return false;
	
	return true;
	
	/*
   var IsNumberSame=true;
   var Char;
   
   if(sText.length > 0)
   {
   		Char = sText.charAt(0);
      	if (sText.indexOf(Char) == -1) 
        {
         return true;
        }
   		
   } 
   
   for (i = 1; i < sText.length && IsNumber == true; i++) 
      { 
      	Char = sText.charAt(i);
      	Char1 = sText.charAt(i+1); 
      	if (ValidChars.indexOf(Char) == -1) 
        {
         IsNumber = false;
        }
      }
   return IsNumber;
   */
   
}



ContentInfo = "";
topColor = "#808080"
subColor = "#C0C0C0"

var mouse_X;
var mouse_Y;

var tip_active = 0;


function update_tip_pos(){

		document.getElementById('ToolTip').style.left = mouse_X + 20;
		document.getElementById('ToolTip').style.top  = mouse_Y;
}


var ie = document.all?true:false;
if (!ie) document.captureEvents(Event.MOUSEMOVE)
document.onmousemove = getMouseXY;

function getMouseXY(e) {
if (ie) { // grab the x-y pos.s if browser is IE
mouse_X = event.clientX + document.body.scrollLeft;
mouse_Y = event.clientY + document.body.scrollTop;
}
else { // grab the x-y pos.s if browser is NS
mouse_X = e.pageX;
mouse_Y = e.pageY;
}
if (mouse_X < 0){mouse_X = 0;}
if (mouse_Y < 0){mouse_Y = 0;}

if(tip_active){update_tip_pos();}
}


function EnterContent(TTitle, TContent){

ContentInfo = '<table border="0" width="120" cellspacing="0" cellpadding="0">'+
'<tr><td width="100%" bgcolor="#000000">'+

'<table border="0" width="100%" cellspacing="1" cellpadding="0">'+
'<tr><td width="100%" bgcolor='+topColor+'>'+

'<table border="0" width="90%" cellspacing="0" cellpadding="0" align="center">'+
'<tr><td width="100%">'+

'<font class="tooltiptitle">&nbsp;'+TTitle+'</font>'+

'</td></tr>'+
'</table>'+

'</td></tr>'+

'<tr><td width="100%" bgcolor='+subColor+'>'+

'<table border="0" width="90%" cellpadding="0" cellspacing="1" align="center">'+

'<tr><td width="100%">'+

'<font class="tooltipcontent">'+TContent+'</font>'+

'</td></tr>'+
'</table>'+

'</td></tr>'+
'</table>'+

'</td></tr>'+
'</table>';

}




function tip_it(which, TTitle, TContent){

	
	if(which){
	
		update_tip_pos();
	
		tip_active = 1;
		
		document.getElementById('ToolTip').style.visibility = "visible";
		
		EnterContent(TTitle, TContent);
		
		document.getElementById('ToolTip').innerHTML = ContentInfo;
	
	}else{
	
		tip_active = 0;
	
		document.getElementById('ToolTip').style.visibility = "hidden";
	}

}


function chkNumeric(objName,minval,maxval,comma,period,hyphen)
{
// only allow 0-9 be entered, plus any values passed
// (can be in any order, and don't have to be comma, period, or hyphen)
// if all numbers allow commas, periods, hyphens or whatever,
// just hard code it here and take out the passed parameters
var checkOK = "0123456789" + comma + period + hyphen;
var checkStr = objName;
var allValid = true;
var decPoints = 0;
var allNum = "";

for (i = 0;  i < checkStr.value.length;  i++)
{
ch = checkStr.value.charAt(i);
for (j = 0;  j < checkOK.length;  j++)
if (ch == checkOK.charAt(j))
break;
if (j == checkOK.length)
{
allValid = false;
break;
}
if (ch != ",")
allNum += ch;
}
if (!allValid)
{       
alertsay = "Please enter only these values \""
alertsay = alertsay + checkOK + "\" in the \"" + checkStr.name + "\" field."
//alert(alertsay);
return (false);
}

// set the minimum and maximum
var chkVal = allNum;
var prsVal = parseInt(allNum);
if (chkVal != "" && !(prsVal >= minval && prsVal <= maxval))
{
alertsay = "Please enter a value greater than or "
alertsay = alertsay + "equal to \"" + minval + "\" and less than or "
alertsay = alertsay + "equal to \"" + maxval + "\" in the \"" + checkStr.name + "\" field."
//alert(alertsay);
return (false);
}
}

function chkNumeric1(fname,objName,minval,maxval,comma,period,hyphen)
{
// only allow 0-9 be entered, plus any values passed
// (can be in any order, and don't have to be comma, period, or hyphen)
// if all numbers allow commas, periods, hyphens or whatever,
// just hard code it here and take out the passed parameters
var checkOK = "0123456789" + comma + period + hyphen;
var checkStr = objName;
var allValid = true;
var decPoints = 0;
var allNum = "";

for (i = 0;  i < checkStr.value.length;  i++)
{
ch = checkStr.value.charAt(i);
for (j = 0;  j < checkOK.length;  j++)
if (ch == checkOK.charAt(j))
break;
if (j == checkOK.length)
{
allValid = false;
break;
}
if (ch != ",")
allNum += ch;
}
if (!allValid)
{       
alertsay = "Please enter only these values \""
alertsay = alertsay + checkOK + "\" in the \"" + fname + "\" field."
//alert(alertsay);
return (false);
}

// set the minimum and maximum
var chkVal = allNum;
var prsVal = parseInt(allNum);
if (chkVal != "" && !(prsVal >= minval && prsVal <= maxval))
{
alertsay = "Please enter a value greater than or "
alertsay = alertsay + "equal to \"" + minval + "\" and less than or "
alertsay = alertsay + "equal to \"" + maxval + "\" in the \"" + checkStr.name + "\" field."
//alert(alertsay);
return (false);
}
}

function validateEmail(str)
{

                var at="@"
                var dot="."
                var lat=str.indexOf(at)
                var lstr=str.length
                var ldot=str.indexOf(dot)
                if (str.indexOf(at)==-1){
                   //alert("Invalid E-mail ID")
                   return false
                }
                if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
                   //alert("Invalid E-mail ID")
                   return false
                }
                if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
                    //alert("Invalid E-mail ID")
                    return false
                }
                 if (str.indexOf(at,(lat+1))!=-1){
                    //alert("Invalid E-mail ID")
                    return false
                 }
                 if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
                    //alert("Invalid E-mail ID")
                    return false
                 }
                 if (str.indexOf(dot,(lat+2))==-1){
                    //alert("Invalid E-mail ID")
                    return false
                 }
                
                 if (str.indexOf(" ")!=-1){
                    //alert("Invalid E-mail ID")
                    return false
                 }
                 return true                                    


}


function setCookie(name, value, expires, path, domain, secure) {
  var curCookie = name + "=" + escape(value) +
      ((expires) ? "; expires=" + expires.toGMTString() : "") +
      ((path) ? "; path=" + path : "") +
      ((domain) ? "; domain=" + domain : "") +
      ((secure) ? "; secure" : "");
  document.cookie = curCookie;
}

function getCookie(name) {
  var dc = document.cookie;
  var prefix = name + "=";
  var begin = dc.indexOf("; " + prefix);
  if (begin == -1) {
    begin = dc.indexOf(prefix);
    if (begin != 0) return null;
  } else
    begin += 2;
  var end = document.cookie.indexOf(";", begin);
  if (end == -1)
    end = dc.length;
  return unescape(dc.substring(begin + prefix.length, end));
}


function deleteCookie(name, path, domain) {
  if (getCookie(name)) {
    document.cookie = name + "=" +
    ((path) ? "; path=" + path : "") +
    ((domain) ? "; domain=" + domain : "") +
    "; expires=Thu, 01-Jan-70 00:00:01 GMT";
  }
}


function IsNumeric(sText)
{
   var ValidChars = "0123456789.";
   var IsNumber=true;
   var Char;

 
   for (i = 0; i < sText.length && IsNumber == true; i++) 
      { 
      Char = sText.charAt(i); 
      if (ValidChars.indexOf(Char) == -1) 
         {
         IsNumber = false;
         }
      }
   return IsNumber;
   
   }
