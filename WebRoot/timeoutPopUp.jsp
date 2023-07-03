<html>
<head>



</head>
<%@page import="com.peniel.beans.SessionBean"%>

<SCRIPT LANGUAGE = "JavaScript">

var sessId = '<%=request.getSession().getAttribute("sessionid") %>';

var divObj = document.getElementById("timeoutMsg");

var secs
var timerID = null
var timerRunning = false
var delay = 1000

function InitializeTimer()
{
    // Set the length of the timer, in seconds
    secs = 3000
    StopTheClock()
    StartTimer()
}


function StopTheClock()
{
    if(timerRunning)
        clearTimeout(timerID);
    timerRunning = false;
}

function StartTimer()
{
    
    if (secs==0)
    {
      /*  var divObj = document.getElementById("timeoutMsg");
        divObj.innerHTML = "";
        divObj.innerHTML = "Your Session has expired.";
      */
       closeWindow(); 
        
    }
    else
    {
        //self.status = secs;
        
        secs = secs - 1;
       
        timerRunning = true;
        var timer = secs, minutes, seconds;
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        var disecs = minutes + ":" + seconds;

        if (--timer < 0) {
            timer = secs;
        }
        
        var divObj = document.getElementById("timeoutMsg");
        divObj.innerHTML = "If you would like to remain in your Session, Please, choose 'Continue Session'. Otherwise, you will be logged off due to<br> inactivity in <b>"+disecs+"</b>.";
        
        
        timerID = self.setTimeout("StartTimer()", delay)
    }
}

function closeWindow(){
	StopTheClock();
	
	window.close();
	
	if(secs == 0)
	{
		window.opener.location = "logout.jsp?sessionid="+sessId+"&timeout=yes";
	}
	else
	{
		<%
		
		SessionBean.updateSessionTime((String)request.getParameter("sessionid"));
		%>
		window.opener.InitializeTimer();
		
	}

}

function cancelCloseWindow()
{
	window.close();
	window.opener.location = "logout.jsp?sessionid="+sessId+"&timeout=yes";

}


</SCRIPT>


<body onLoad="InitializeTimer()" onunload="closeWindow()">
<div>
<h1 style="    text-align: center;"><b>Session Timeout</b></h1>
<div align="left" style="float: left; margin-top: -6px; margin-right: 20px;">
<img alt="" src="images/Alert1.png" style="height: 70px;">
</div>
<div align="right">

<div id="timeoutMsg" style="font-family:Geneva, Arial, Helvetica, sans-serif; text-align: left;font-size:0.8em;" ></div> 
</div>
</div>
<div>
<div align="right" style="margin: 20px">
 <input type="image" style="width:100px;height: 37px;" src="images/AttButtNo2.png" value="CANCEL" onClick="javascript:cancelCloseWindow();"/>
  
  <input type="image" style="width:150px;height: 37px;" src="images/AttButtYes2.png" value="OK" onClick="javascript:closeWindow();"/>
  &nbsp;&nbsp;&nbsp;
 </div>
</div>
</body>
</html>
