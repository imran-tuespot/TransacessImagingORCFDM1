<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

   <link rel="stylesheet" href="css/jquery-ui.css">
		<!-- <script type="text/javascript" src="js/jquery-1.3.2.js" ></script>
		<script src="https://code.jquery.com/jquery-1.8.2.min.js"></script>	-->	
		<script src="js/jQuery/jquery-1.8.2.min.js"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
		
		<script src="jscript/jquery-ui.js"></script>
			
		<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>		
				
		<script type="text/javascript" src="js/jmesa.js"></script>
		<script src="js/jquery.popupoverlay.js"></script>
		

<title>TransAccess Imaging</title>



<jsp:include page="includes/sessionHeader.jsp"/>


<%

    int uid = Integer.parseInt(request.getSession().getAttribute("userid").toString());
    String sessionid = request.getSession().getAttribute("sessionid").toString();
    int cid = Integer.parseInt(request.getSession().getAttribute("comid").toString());
    String userName = request.getSession().getAttribute("username").toString();
    javax.naming.Context ctx = 	new javax.naming.InitialContext();
	String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");



%>

<script language="javascript">

function findElementInArray(arr, val) {
    var len = arr.length;
    var from = 0;
    for (; from < len; from++) {
        if (arr[from] === val)
            return from;
    }
    return -1;
}
function onInvokeAction(id, action) {

    var compid = '<%= cid %>';
    var sessionid = '<%= sessionid %>';
    var userName = '<%= userName %>';

    var indexvar = '';
    var docvar = '';
    var indexval = '';
    var docStatus = '';

    var indexvar2 = '';
    var docvar2 = '';
    var indexval2 = '';
    var docStatus2 = '';

    var indexvar3 = '';
    var docvar3 = '';
    var indexval3 = '';
    var docStatus3 = '';

    var indexvar4 = '';
    var docvar4 = '';
    var indexval4 = '';
    var docStatus4 = '';

    var indexvar5 = '';
    var docvar5 = '';
    var indexval5 = '';
    var docStatus5 = '';

    var checkVals = '';
    var queryString = "compid=" + compid + "&" + "sessionid=" + sessionid + "&" + "userName=" + userName;

    if (document.getElementById("indexval") != null) {
        if (document.getElementById("indexval").value != null) {
            indexvar = document.getElementById("indextype").value;
            docvar = document.getElementById("doctype").value;
            indexval = document.getElementById("indexval").value;
            docStatus = document.getElementById("docStatus").value;

            indexval = indexval.replace(" ", " or ");

            indexval = indexval.replace(",", " or ");

            if (indexval.search(/or/) != '-1') {
                checkVals = '1';
            }

            queryString += "&" + "indexvar=" + indexvar + "&" + "docvar=" + docvar + "&" + "indexval=" + indexval + "&" + "docStatus=" + docStatus;
        }
    }

    if (document.getElementById("indexval2") != null) {
        if (document.getElementById("indexval2").value != null) {
            indexvar2 = document.getElementById("indextype2").value;
            docvar2 = document.getElementById("doctype2").value;
            indexval2 = document.getElementById("indexval2").value;
            docStatus2 = document.getElementById("docStatus2").value;

            indexval2 = indexval2.replace(" ", " or ");

            indexval2 = indexval2.replace(",", " or ");

            if (indexval2.search(/or/) != '-1') {
                checkVals = '1';
            }

            queryString += "&" + "indexvar2=" + indexvar2 + "&" + "docvar2=" + docvar2 + "&" + "indexval2=" + indexval2 + "&" + "docStatus2=" + docStatus2;
        }
    }

    if (document.getElementById("indexval3") != null) {
        if (document.getElementById("indexval3").value != null) {
            indexvar3 = document.getElementById("indextype3").value;
            docvar3 = document.getElementById("doctype3").value;
            indexval3 = document.getElementById("indexval3").value;
            docStatus3 = document.getElementById("docStatus3").value;

            indexval3 = indexval3.replace(" ", " or ");

            indexval3 = indexval3.replace(",", " or ");

            if (indexval3.search(/or/) != '-1') {
                checkVals = '1';
            }

            queryString += "&" + "indexvar3=" + indexvar3 + "&" + "docvar3=" + docvar3 + "&" + "indexval3=" + indexval3 + "&" + "docStatus3=" + docStatus3;
        }
    }

    if (document.getElementById("indexval4") != null) {
        if (document.getElementById("indexval4").value != null) {
            indexvar4 = document.getElementById("indextype4").value;
            docvar4 = document.getElementById("doctype4").value;
            indexval4 = document.getElementById("indexval4").value;
            docStatus4 = document.getElementById("docStatus4").value;

            indexval4 = indexval4.replace(" ", " or ");

            indexval4 = indexval4.replace(",", " or ");

            if (indexval4.search(/or/) != '-1') {
                checkVals = '1';
            }

            queryString += "&" + "indexvar4=" + indexvar4 + "&" + "docvar4=" + docvar4 + "&" + "indexval4=" + indexval4 + "&" + "docStatus4=" + docStatus4;
        }
    }

    if (document.getElementById("indexval5") != null) {
        if (document.getElementById("indexval5").value != null) {
            indexvar5 = document.getElementById("indextype5").value;
            docvar5 = document.getElementById("doctype5").value;
            indexval5 = document.getElementById("indexval5").value;
            docStatus5 = document.getElementById("docStatus5").value;

            indexval5 = indexval5.replace(" ", " or ");

            indexval5 = indexval5.replace(",", " or ");

            if (indexval5.search(/or/) != '-1') {
                checkVals = '1';
            }

            queryString += "&" + "indexvar5=" + indexvar5 + "&" + "docvar5=" + docvar5 + "&" + "indexval5=" + indexval5 + "&" + "docStatus5=" + docStatus5;
        }
    }


    var fuzzySearch = document.getElementById("fuzzySearch").checked;

    if (checkVals == '1') {
        fuzzySearch = 'true';
        //document.getElementById("fuzzySearch").checked = 'true';
    }

    queryString += "&" + "fuzzySearch=" + fuzzySearch;

    msgbox_visible(true);

    var parameterString = createParameterStringForLimit(id);
    //alert("QueryString"+queryString);
    $.get("DocDownloadSearchGrid?" + queryString + "&" + parameterString, function(data) {
        msgbox_visible(false);
        $("#results").html(data)

    });

}

var xmlhttp = new getXMLObject();       //xmlhttp holds the ajax object
function getXMLObject() { //XML OBJECT {
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

var xmlhttp1 = new getXMLObject1();       //xmlhttp holds the ajax object
function getXMLObject1() { //XML OBJECT {
    var xmlHttp1 = false;
    try {
        xmlHttp1 = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
    }
    catch (e) {
        try {
            xmlHttp1 = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
        }
        catch (e2) {
            xmlHttp1 = false   // No Browser accepts the XMLHTTP Object then false
        }
    }
    if (!xmlHttp1 && typeof XMLHttpRequest != 'undefined') {
        xmlHttp1 = new XMLHttpRequest();        //For Mozilla, Opera Browsers
    }
    return xmlHttp1;  // Mandatory Statement returning the ajax object created
}


// Start Load Here
function initial_load() {
    getdropdowns();
    // session();
    setHeader('docDownloadSearchGrid.jsp');
    //Initialize slider menu
      	$('#simple-menu').sidr();
      
	  	$('.child').hide();
	  	$('.parent').click(function() {
		 	$('.child').slideUp();
		 	$(this).find('ul').slideToggle();
	  	});
	  	$('#docManagementLi').click();

}

function getdropdowns() {
    var compid = '<%= cid %>';
    var queryString = "compid=" + compid;

    if (xmlhttp) {
        // xmlhttp.open("GET",URL,true);
        xmlhttp.open("POST", "GetDropDown", true);
        xmlhttp.onreadystatechange = handleServerResponse;
        xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

        xmlhttp.send(queryString);
    }
}

// callback for server response
function handleServerResponse() {
    if (xmlhttp.readyState == 4) {
        if (xmlhttp.status == 200) {
            parseData(xmlhttp.responseText);
            // alert(xmlhttp.responseText);
        }
        else {
            alert(xmlhttp.status);
        }
    }
}

var countData = new Array();
var index = new Array();
var documentdata = new Array();

var rowCnt = 1;
var divCnt = 1;
var removeCnt = 0;


var que = [];
que.push(2);
que.push(3);
que.push(4);
que.push(5);

function parseData(data) {
    var row = data.split('$');
    var indexstr = row[0];
    var docstr = row[1];
    var countStr = row[2];


    parseindexstr(indexstr);
    //parseCountStr(countStr);

    var indexVal1 = getCookie("INDEX_VAL_1");
    if (indexVal1 != '' && indexVal1 != null && indexVal1 != 'null') document.getElementById("indexval").value = indexVal1;

    parsedocstr(docstr);

    var indexVal2 = getCookie("INDEX_VAL_2");
    if (indexVal2 != '' && indexVal2 != null && indexVal2 != 'null') {
        ////divCnt = 1;
        que.push(2);
        showRow();
    }

    var indexVal3 = getCookie("INDEX_VAL_3");
    if (indexVal3 != '' && indexVal3 != null && indexVal3 != 'null') {
        //divCnt = 2;
        que.push(3);
        showRow();
    }

    var indexVal4 = getCookie("INDEX_VAL_4");
    if (indexVal4 != '' && indexVal4 != null && indexVal4 != 'null') {
        //divCnt = 3;

        que.push(4);
        showRow();
    }

    var indexVal5 = getCookie("INDEX_VAL_5");
    if (indexVal5 != '' && indexVal5 != null && indexVal5 != 'null') {
        //divCnt = 4;

        que.push(5);
        showRow();
    }

    var cookieTracker = getCookie("COOKIE_TRACKER");
    if (cookieTracker == "Y") {
        getfiles();
    }

    delCookie("COOKIE_TRACKER");

}

// Parse the String (pipe delimited) and put them into the
function parseindexstr(indexstr) {
    var cookieIndexType = getCookie("INDEX_TYPE_1");
    var row = indexstr.split('|');
    index.length = 0;
    for (var i = 0; i < row.length - 1; i++) {
        var col = row[i].split('^');
        index[i] = new Array(col[0], col[1]);
        // alert(index[i][0]+"="+index[i][1]);
        addOption(document.getElementById("indextype"), index[i][0], index[i][1], cookieIndexType);
    }

//    for (var i = 0; i < index.length; ++i) {
//        addOption(document.getElementById("indextype"), index[i][0], index[i][1], cookieIndexType);
//    }
}

function parsedocstr(docstr) {
    var cookieDocType = getCookie("DOC_TYPE_1");
    var row = docstr.split('|');
    documentdata.length = 0;
    for (var i = 0; i < row.length - 1; i++) {
        var col = row[i].split('^');
        documentdata[i] = new Array(col[0], col[1]);
        // alert(documentdata[i][0]+"="+documentdata[i][1]);
        addOption(document.getElementById("doctype"), documentdata[i][0], documentdata[i][1], cookieDocType);
    }

//    for (var i = 0; i < documentdata.length; i++) {
//        addOption(document.getElementById("doctype"), documentdata[i][0], documentdata[i][1], cookieDocType);
//    }

}


function parseCountStr(countStr) {
    var row = countStr.split('|');
    countData.length = 0;
    for (var i = 0; i < row.length - 1; i++) {
        var col = row[i].split('^');
        countData[i] = new Array(col[0], col[1], col[2]);
        // alert(index[i][0]+"="+index[i][1]);
    }

    var totalCount = document.getElementById('totalCount');


    for (var i = 0; i < countData.length; ++i) {
        //addOption(document.getElementById("indextype"), index[i][0], index[i][1]);
        //totalCount.innerHTML = "Total Number of Projects: "+ countData[i][0] +"      Total Number of Documents: "+ countData[i][1] +"   |   Total Number of Pages: "+ countData[i][2];

        totalCount.innerHTML = "Total Number of Projects: " + countData[i][0];
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode("Total Number of Documents: " + countData[i][1]));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode('\u00A0'));
        totalCount.appendChild(document.createTextNode("Total Number of Pages: " + countData[i][2]));
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode("Total Number of Documents: " + countData[i][1]);
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode('\u00A0');
//        totalCount.appendChild(emptySpace);
//
//        var emptySpace = document.createTextNode("Total Number of Pages: " + countData[i][2]);
//        totalCount.appendChild(emptySpace);

    }
}


function addOption(selectbox, text, value, cookieValue) {
    var optn = document.createElement("OPTION");
    optn.text = text;
    optn.value = value;
    if (value == cookieValue)
        optn.selected = true;
    selectbox.options.add(optn);
}


function showRow() {

    divCnt++;

    var quePop = que.shift();
    if (quePop != null) {
        rowCnt = quePop;
    }

    var cookieIndexType = getCookie("INDEX_TYPE_" + rowCnt);
    var cookieIndexVal = getCookie("INDEX_VAL_" + rowCnt);
    var cookieDocType = getCookie("DOC_TYPE_" + rowCnt);
    var cookieDocStatus = getCookie("DOC_STATUS_" + rowCnt);

    var tooltip = 'Use Project Numbers for Value. Examples : 105-22021, 105..';
    var moreRows = document.getElementById("moreRows");

    var innerDiv = document.createElement("div");
    innerDiv.id = rowCnt;

    var table = document.createElement("table");
    table.id = 'table' + rowCnt;

    var tbody = document.createElement("tbody");
    tbody.id = 'tbody' + tbody;

    var tr = document.createElement("tr");
    tr.id = 'tr' + rowCnt;

    var td3 = document.createElement("td");

    // Populate Doctype dropdown box using data from AJAX call.
    var oSelect = document.createElement("select");
    oSelect.id = "doctype" + rowCnt;


    var oOption = document.createElement("option");
    var t = document.createTextNode("All");
    oOption.setAttribute("value", "All");
    oOption.appendChild(t);
    oSelect.appendChild(oOption);

    for (var i = 0; i < documentdata.length - 1; ++i) {
        var val = documentdata[i][1];
        var txt = documentdata[i][0];
        var oOption = document.createElement("option");
        var t = document.createTextNode(txt);
        oOption.setAttribute("value", val);
        oOption.appendChild(t);
        oSelect.appendChild(oOption);
    }
    oSelect.onchange = function() {
        getIndexType(rowCnt);
    }

    td3.appendChild(oSelect);
    tr.appendChild(td3);

    var td1 = document.createElement("td");

    // Populate IndexType dropdown box using data from AJAX call.
    var oSelect1 = document.createElement("select");
    oSelect1.id = "indextype" + rowCnt;
    //oSelect1.style.fontSize = "12px";
    //oSelect1.style.fontFamily = "Verdana";
    //oSelect1.style.color = "blue";

    for (var i = 0; i < index.length; ++i) {
        var val1 = index[i][1];
        var txt1 = index[i][0];
        var oOption1 = document.createElement("option");
        var t1 = document.createTextNode(txt1);
        oOption1.setAttribute("value", val1);
        if (val1 == cookieIndexType) oOption1.setAttribute("selected", true);
        oOption1.appendChild(t1);
        oSelect1.appendChild(oOption1);
    }
    td1.appendChild(oSelect1);
    tr.appendChild(td1);


    var td2 = document.createElement("td");

    var input = document.createElement("input");
    input.id = "indexval" + rowCnt;
    //input.style.fontSize = "12px";
    //input.style.fontFamily = "Verdana";
    //input.style.color = "blue";
    input.size = "12";
    if (cookieIndexVal != '' && cookieIndexVal != null && cookieIndexVal != 'null') {
        input.value = cookieIndexVal;
    }
    //input.onmouseover = function() {showToolTip(event,'Use Project Numbers for Value. Examples : 105-22021, 105..');return false };
    //input.onmouseout = function() {hideToolTip();};

    td2.appendChild(input);
    tr.appendChild(td2);


    var td31 = document.createElement("td");

    var oSelect1 = document.createElement("select");
    oSelect1.id = "docStatus" + rowCnt;
    //oSelect1.style.fontSize = "12px";
    //oSelect1.style.fontFamily = "Verdana";
    //oSelect1.style.color = "blue";

    var oOption1 = document.createElement("option");

    var t1 = document.createTextNode("Active");
    oOption1.setAttribute("value", "Active");
    if ("Active" == cookieDocStatus) oOption1.setAttribute("selected", true);
    oOption1.appendChild(t1);
    oSelect1.appendChild(oOption1);

    var oOption2 = document.createElement("option");
    var t2 = document.createTextNode("Inactive");
    oOption2.setAttribute("value", "Inactive");
    if ("Inactive" == cookieDocStatus) oOption2.setAttribute("selected", true);
    oOption2.appendChild(t2);
    oSelect1.appendChild(oOption2);

    var oOption3 = document.createElement("option");
    var t3 = document.createTextNode("All");
    oOption3.setAttribute("value", "All");
    if ("All" == cookieDocStatus) oOption3.setAttribute("selected", true);
    oOption3.appendChild(t3);
    oSelect1.appendChild(oOption3);

    td31.appendChild(oSelect1);
    tr.appendChild(td31);


    var td4 = document.createElement("td");
    td4.id = 'td4' + rowCnt;

    var emptySpace = document.createTextNode('\u00A0');
    td4.appendChild(emptySpace);

    var emptySpace = document.createTextNode('\u00A0');
    td4.appendChild(emptySpace);

    var removeLink = document.createElement("a");
    removeLink.setAttribute('href', 'javascript:removeRow(' + innerDiv.id + ')');
    removeLink.style.fontSize = "12px";
    removeLink.style.fontFamily = "Verdana";
    //removeLink.style.color = "Red";


    //var linkText = document.createTextNode('Remove Row  ');
    var rImg = document.createElement("img");
    rImg.setAttribute('src', 'images/trashcan.png');
    rImg.setAttribute('alt', 'Remove Row');
    rImg.setAttribute('border', '0');


    removeLink.appendChild(rImg);
    td4.appendChild(removeLink);

    tr.appendChild(td4);

    document.getElementById('show').style.display = 'none';
    //document.getElementById('submit').style.display = 'none';

    //Display:none for rows apart from rowCnt
    for (var i = 2; i < 6; i++) {
        if (i != rowCnt) {
            if (document.getElementById(i) != null) {

                var inDiv = document.getElementById(i);

                var innerDivRows = document.getElementById('inside' + i);

                if (innerDivRows != null) {
                    //document.getElementById('submit'+i).style.display='none';
                    document.getElementById('show' + i).style.display = 'none';

                }
            }
        }
    }

    var td5 = document.createElement('td');
    td5.setAttribute('colspan', '2');
    td5.id = 'td5' + rowCnt;

    // Create div for Submit button and Add Row link
    var inner2Div = document.createElement('div');

    inner2Div.id = 'inside' + rowCnt;

    //var emptySpace = document.createTextNode('    ');
    var emptySpace = document.createTextNode('\u00A0');
    inner2Div.appendChild(emptySpace);

    var emptySpace = document.createTextNode('\u00A0');
    inner2Div.appendChild(emptySpace);

    var emptySpace = document.createTextNode('\u00A0');
    inner2Div.appendChild(emptySpace);


    if (divCnt < 5) {
        var addLink = document.createElement("a");
        addLink.id = 'show' + rowCnt;
        addLink.setAttribute('href', 'javascript:showRow()');
        addLink.style.fontSize = "12px";
        addLink.style.fontFamily = "Verdana";
        //addLink.style.color = "Red";

        var oImg = document.createElement("img");
        oImg.setAttribute('src', 'images/addRow.png');
        oImg.setAttribute('alt', 'Add Row');
        oImg.setAttribute('border', '0');
        //var linkText = document.createTextNode('Add Row');
        addLink.appendChild(oImg);

        inner2Div.appendChild(addLink);

    }

    td5.appendChild(inner2Div);

    tr.appendChild(td5);

    tbody.appendChild(tr);

    table.appendChild(tbody);

    innerDiv.appendChild(table);
    moreRows.appendChild(innerDiv);


}

function removeRow(param) {
    divCnt--;

    var moreRowsRemove = document.getElementById("moreRows");

    var innerDivRow = document.getElementById(param);

    moreRowsRemove.removeChild(innerDivRow);

    if ((document.getElementById('2') == null) && (document.getElementById('3') == null) && (document.getElementById('4') == null) && (document.getElementById('5') == null)) {

        document.getElementById('show').style.display = 'block';
        //document.getElementById('submit').style.display = 'block';

        rowCnt = 1;
    }

    // No Change if a row is deleted from middle and is not the last row.

    var existingNoOfDivs = moreRowsRemove.getElementsByTagName('div');

    var cnt;
    for (var j = 0; j < existingNoOfDivs.length; j++) {

        var searchStr = existingNoOfDivs[j].id;

        searchStr = findElementInArray(searchStr, "inside");
        if (searchStr == '-1') {
            cnt = existingNoOfDivs[j].id;
        }
    }

    // Remove Submit Button and Add Row Link from all the divs.

    for (var i = 2; i < 6; i++) {
        var inDiv = document.getElementById(i);

        if (inDiv != null) {

            var td5 = document.getElementById('td5' + i);
            if (td5 != null) {
                td5.innerHTML = '';
            }


        }
    }

    // Put Submit Button and Add Row Link to the last div
    var innerDivRow = document.getElementById(cnt);
    if (innerDivRow != null) {

        var td5 = document.getElementById('td5' + cnt);
        td5.setAttribute('colspan', '2');

        // Create div for Submit button and Add Row link
        var inner2Div = document.createElement('div');

        inner2Div.id = 'inside' + cnt;

        var emptySpace = document.createTextNode('\u00A0');
        inner2Div.appendChild(emptySpace);

        var emptySpace = document.createTextNode('\u00A0');
        inner2Div.appendChild(emptySpace);

        var emptySpace = document.createTextNode('\u00A0');
        inner2Div.appendChild(emptySpace);


        var addLink = document.createElement("a");
        addLink.id = 'show' + cnt;
        addLink.style.fontSize = "12px";
        addLink.style.fontFamily = "Verdana";
        //addLink.style.color = "red";
        addLink.setAttribute('href', 'javascript:showRow()');

        //var linkText = document.createTextNode('Add Row');
        var rImg = document.createElement("img");
        rImg.setAttribute('src', 'images/addRow.png');
        rImg.setAttribute('alt', 'Add Row');
        rImg.setAttribute('border', '0');

        addLink.appendChild(rImg);
        inner2Div.appendChild(addLink);

        td5.appendChild(inner2Div);

    }

    delCookie("INDEX_TYPE_" + param);
    delCookie("INDEX_VAL_" + param);
    delCookie("DOC_TYPE_" + param);
    delCookie("DOC_STATUS_" + param);

    que.push(param);
}


function getfiles() {

    var queryString = getfilesTypeQuery();

    alert("queryStr -->"+queryString);

    if (xmlhttp) {
        xmlhttp.open("POST", "DocDownloadSearchGrid", true);
        xmlhttp.onreadystatechange = handleResponse;
        xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp.send(queryString);
    }

    orderby = '';

}
function getfilesTypeQuery() {

    msgbox_visible(true);

    var user = '<%= uid%>';
    var compid = '<%= cid %>';
    var sessionid = '<%= sessionid %>';
    var userName = '<%= userName %>';

   // var checkVals = isFuzzy(1) + isFuzzy(2) + isFuzzy(3) + isFuzzy(4) + isFuzzy(5);
    var queryString = "userid=" + user + "&" + "compid=" + compid + "&" + "sessionid=" + sessionid + "&" + "userName=" + userName;

    queryString += submitx(1);
    /*queryString += submitx(2);
    queryString += submitx(3);
    queryString += submitx(4);
    queryString += submitx(5);*/

    /*var fuzzySearch = document.getElementById("fuzzySearch").checked;

    if (checkVals > 0) {
        fuzzySearch = 'true';
    }

    queryString += "&" + "fuzzySearch=" + fuzzySearch;*/

    if (orderby != '') queryString += orderby;

    //alert("queryStr -->"+queryString);

    return queryString;
}

function submitx(index) {
    if (index == 1)
        index = "";
    if (document.getElementById("indexval" + index) != null && document.getElementById("indexval" + index).value != null) {
        var indexvar = document.getElementById("indextype" + index).value;
        var docvar = document.getElementById("doctype" + index).value;
        var docStatus = document.getElementById("docStatus" + index).value;

        var indexval = document.getElementById("indexval" + index).value;
        indexval = indexval.replace(" ", " or ");
        indexval = indexval.replace(",", " or ");
        return  "&indexvar" + index + "=" + indexvar + "&docvar" + index + "=" + docvar +
                "&indexval" + index + "=" + indexval + "&docStatus" + index + "=" + docStatus;
    }
}
function isFuzzy(index) {
    if (index == 1)
        index = "";
//    var indexobj = $("indexval" + index);
    var indexobj = document.getElementById("indexval" + index);
    if (indexobj != null && indexobj.value != null) {
        var indexval = indexobj.value;
        indexval = indexval.replace(" ", " or ");
        indexval = indexval.replace(",", " or ");
        if (indexval.search(/or/) != '-1') {
            return 1;
        }
    }
    return 0;
}

// submit files to display
function submitFileDownloadSet() {
    msgbox_visible(true);

    var user = '<%= uid%>';
    var compid = '<%= cid %>';
    var sessionid = '<%= sessionid %>';
    var userName = '<%= userName %>';

   // var checkVals = isFuzzy(1) + isFuzzy(2) + isFuzzy(3) + isFuzzy(4) + isFuzzy(5);
    var queryString = "userid=" + user + "&" + "compid=" + compid + "&" + "sessionid=" + sessionid + "&" + "userName=" + userName;

    queryString += submitx(1);
   /* queryString += submitx(2);
    queryString += submitx(3);
    queryString += submitx(4);
    queryString += submitx(5);*/

  /*  var fuzzySearch = document.getElementById("fuzzySearch").checked;

    if (checkVals > 0) {
        fuzzySearch = 'true';
    }

    queryString += "&" + "fuzzySearch=" + fuzzySearch;*/

    if (orderby != '')
        queryString += orderby;

    var queryString = getfilesTypeQuery();
    var cookieDocStatus = getCookie("SELECTED_DOCUMENTS");
    var newCookieStatus = "";

    for (var i = 1; i < 500; i++) {
        var elem = document.getElementById("row-" + i);
        // do something with contained elem
        if (elem != null) {
            if (cookieDocStatus != null && cookieDocStatus.length > 0) {
                var elements = cookieDocStatus.split("-");
                if (elem.checked) { // add to list
                    var addToList = findElementInArray(elements, elem.value);
                    if (addToList == -1) {
                        cookieDocStatus += "-" + elem.value;
                    }
                } else { // remvove from list
                    var removeFromList = findElementInArray(elements, elem.value);
                    if (removeFromList != -1) {
                        elements.splice(removeFromList, 1);
                        cookieDocStatus = elements.join("-");
                    }
                }
            } else {
                cookieDocStatus = elem.value;
            }
        } else {
            break;
        }
    }

    setCookie("SELECTED_DOCUMENTS", cookieDocStatus);

    if (xmlhttp) {
        xmlhttp.open("POST", "DocDownloadFile", true);
        xmlhttp.onreadystatechange = handleResponse;
        xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp.send(queryString);
    }

    alert("You will receive an email when the files are ready to download. If you want to" +
          " download a different set of files please close the browser and login to the system again");
}

function handleResponse() {

    if (xmlhttp.readyState == 4) {
        if (xmlhttp.status == 200) {
            // alert(xmlhttp.responseText);
            if (xmlhttp.responseText == "expired") {
                msgbox_visible(false);
                // alert("Session Expired...Please Login Again.");
                window.location = "index.jsp";
            } else {
            	document.getElementById('submit2').style.display = "block";
                DisplayData(xmlhttp.responseText);
            }
        }
        else {
            //alert(xmlhttp.status);
        }
    }
}


function DisplayData(data) {
    var initTable = "";
    initTable += "<form name='dynFormNm' id='dynFormId' method='POST' >";
    initTable += data;
    initTable += "</form>";

    msgbox_visible(false);
    var obj = document.getElementById("results");
    obj.innerHTML = initTable;
	displayTableRows();

}
function displayTableRows()
{
	var theTable = document.getElementById('formId');
	var count = theTable.tBodies[2].rows.length;
	
	for( var x = 0; x < theTable.tBodies[2].rows.length;) 
	{		
		if(count >= x)
		{			
			var cels1 = theTable.tBodies[2].rows[x].cells[4];
			var cels1_cont = theTable.tBodies[2].rows[x].cells[4].innerHTML;
			var cels1_version = theTable.tBodies[2].rows[x].cells[3].innerHTML;
			
			var row2 =  theTable.tBodies[2].rows[x++];
			var cels2 = theTable.tBodies[2].rows[x].cells[4];
			var cels2_cont = theTable.tBodies[2].rows[x].cells[4].innerHTML;
			var cels2_version = theTable.tBodies[2].rows[x].cells[3].innerHTML;
			
			if((cels1_cont === cels2_cont) && (cels1_version === cels2_version))
			{
				theTable.tBodies[2].rows[x].cells[0].innerHTML = "";
				theTable.tBodies[2].rows[x].cells[3].style.display = "none";
				theTable.tBodies[2].rows[x].cells[4].style.display = "none";
								
			}			
		  }				
	 }
	
}

function getpdf(id) {

    var interval = setInterval('msgbox_visible(true)', 0000);

    var user = '<%= uid%>';
    var com = '<%= cid%>';
    var session = '<%= sessionid%>';
    var userName = '<%= userName%>';

    //var Text = //"./DisplayPdf?id=//" + id + "&userid=" + user + "&comid=" + com + "&sessionid=" + session + "&userName=" + userName;
  //  window.open(Text, '', 'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes');
	 
<%-- 	    var pdfurl = '<%=uiURL%>'+"/DisplayPdf?id="+ id;
 --%>		 
		 //alert("pdfurl"+pdfurl)
		 var pdfurl = '<%=restURL%>'+"/role/ResponseBodyStreamFixed?id="+ id;

		var Text = "displayPdf.html";
		
		 sessionStorage.setItem('pdfurl',pdfurl);
				
		 window
				.open(
						pdfurl,
						'',
						'width=900,height=800,menubar=no,status=yes,location=no,toolbar=no,scrollbars=yes'); 
			
    var interval = setInterval('msgbox_visible(false)', 2000);
}


function editDoc(id, indTyp, val, dcTyp, status, docId, version, indexTypeId, docTypeId, formAction) {

    var user = '<%= uid%>';
    var com = '<%= cid%>';
    var session = '<%= sessionid%>';
    var userName = '<%= userName%>';


    delCookie("INDEX_TYPE_1");
    delCookie("INDEX_TYPE_2");
    delCookie("INDEX_TYPE_3");
    delCookie("INDEX_TYPE_4");
    delCookie("INDEX_TYPE_5");
    delCookie("INDEX_VAL_1");
    delCookie("INDEX_VAL_2");
    delCookie("INDEX_VAL_3");
    delCookie("INDEX_VAL_4");
    delCookie("INDEX_VAL_5");
    delCookie("DOC_TYPE_1");
    delCookie("DOC_TYPE_2");
    delCookie("DOC_TYPE_3");
    delCookie("DOC_TYPE_4");
    delCookie("DOC_TYPE_5");
    delCookie("DOC_STATUS_1");
    delCookie("DOC_STATUS_2");
    delCookie("DOC_STATUS_3");
    delCookie("DOC_STATUS_4");
    delCookie("DOC_STATUS_5");
    delCookie("COOKIE_TRACKER");

    setCookie("DIV_CNT", divCnt);

    var Text = "./EditDocument?id=" + id + "&indTyp=" + indTyp + "&val=" + val + "&dcTyp=" + dcTyp +
            "&userid=" + user + "&comid=" + com + "&sessionid=" + session + "&userName=" + userName +
            "&status=" + status + "&docId=" + docId + "&version=" + version + "&docTypeId=" + docTypeId +
            "&indexTypeId=" + indexTypeId + "&formAction=";

    window.location = Text;

}


// Create a cookie with the specified name and value.
function setCookie(sName, sValue) {
    document.cookie = sName + "=" + escape(sValue);
    // Expires the cookie in eight minutes
    var date = new Date();
    //alert('date 1 -->'+date.toUTCString());
    var currentMins = date.getMinutes();
    var expireMins = currentMins + 1;

    date.setMinutes(expireMins);

    //alert('date 2 -->'+date.toGMTString());
    document.cookie += ("; expires=" + date.toUTCString());
}


// Retrieve the value of the cookie with the specified name.
function getCookie(sName) {
    // cookies are separated by semicolons
    var aCookie = document.cookie.split("; ");
    for (var i = 0; i < aCookie.length; i++) {
        // a name/value pair (a crumb) is separated by an equal sign
        var aCrumb = aCookie[i].split("=");
        if (sName == aCrumb[0])
            return unescape(aCrumb[1]);
    }
    // a cookie with the requested name does not exist
    return null;
}


// Delete the cookie with the specified name.
function delCookie(sName) {
    document.cookie = sName + "=; expires=Fri, 31 Dec 1999 23:59:59 GMT;";
}

var orderby = '';
function sortby(property) {
    property = " LOWER(" + property + ")";
    var sVal = getSortValue(property);
    if (sVal == 0)
        property += " ASC";
    else
        property += " DESC";

    var order = property;
    orderby = "&orderby=" + order;

    getfiles();

    setCookie("ORDER_BY", orderby);
    // alert(property);

}

function setSortValue(sortName, sortValue) {
    var expires = new Date();
    expires.setMonth(expires.getMonth() + 4);
    setCookie(sortName, sortValue, new Date(expires), '/', '', '');
}

function getSortValue(property) {
    var sortValue = getCookie("SORT_" + property);
    if (sortValue == null || sortValue == "0") {
        setSortValue("SORT_" + property, 1);
        return 0;
    }
    else {
        setSortValue("SORT_" + property, 0);
        return 1;
    }
}

function msgbox_visible(val) {
    var e = document.getElementById('messagewindow');
    if (val == true) {
        e.style.display = 'block';
    } else {
        e.style.display = 'none';
    }
}


var rowNbr;

function getIndexType(rowNumber) {

    if (rowNumber == "1") {
        rowNbr = '';
    }
    else {
        rowNbr = rowNumber;
    }
    var docType = document.getElementById("doctype" + rowNbr).value;

    getIndexTypes(docType);

}


function getIndexTypes(docType) {
    var compid = '<%= cid %>';
    var queryString = "compid=" + compid + "&docTypeId=" + docType;

    if (xmlhttp1) {

        xmlhttp1.open("POST", "GetIndexDropDown", true);
        xmlhttp1.onreadystatechange = handleServerResponse1;
        xmlhttp1.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp1.send(queryString);
    }
}

function handleServerResponse1() {
    if (xmlhttp1.readyState == 4) {
        if (xmlhttp1.status == 200) {
            parseindex(xmlhttp1.responseText);
            // alert(xmlhttp.responseText);
        }
        else {
            alert(xmlhttp1.status);
        }
    }
}


function parseindex(indexstr) {
    var row = indexstr.split('|');
    index.length = 0;
    for (var i = 0; i < row.length - 1; i++) {
        var col = row[i].split('^');
        index[i] = new Array(col[0], col[1]);
        // alert(index[i][0]+"="+index[i][1]);
    }

    var selectbox = document.getElementById("indextype" + rowNbr);
    var i;
    for (i = selectbox.options.length - 1; i >= 0; i--) {
        selectbox.remove(i);
    }

    for (var i = 0; i < index.length; ++i) {
        addOption(document.getElementById("indextype" + rowNbr), index[i][0], index[i][1]);
    }
}

function clearFields()
{  
	 	document.getElementById('indexval').value ="";
	 	
}
</script>

</head>

<body onLoad="initial_load()">

<br/>
<center><!-- div id ="totalCount" style="font-size: 0.8em;"></div--></center>
<br/>
<div id="moreRows">
<div class="card" style="width: 95%; padding-left: 0px;">
			<div class="card-body card-padding" background-color:#EDECEC">
								<table class="table" cellspacing="0">
									<tbody>
										<tr>
											<td>Document Type</td>
											<td><select class="selectText" style="overflow:auto;width:300px;"  id="doctype" name="doctype" onChange = "getIndexType(1);">
												<option value="All">All</option>
												</select> 
											</td>
										</tr>
										<tr>
											<td>Index Type</td>
											<td> 
												<select class="selectText" id="indextype" name="indextype" style="width: 300px;">
												</select>
											</td>
										</tr>
										<tr>
											<td nowrap="">Index Value</td>
											<td><input id="indexval" name="indexval" type="text" size=50 style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" ></td>
										</tr>
										
										<tr>
											<td nowrap="">Document Status</td>
											<td><select class="selectText" style="overflow:auto;width:300px;" id="docStatus" name="docStatus">
												<option value="Active">Active</option>
												<option value="Inactive">Inactive</option>
												<option value="All">All</option>
												</select></td>
										</tr>
										<tr>
											<td ></td>
										
											<td style="text-align: left;" ><input  class="btn btn-success waves-effect waves-button waves-float" style="margin-left: 165px;"  input id="submit" name="submit" type="button" onClick="javascript:getfiles()" value="Submit">
												<input id="clear" name="clear" class="btn btn-warning waves-effect waves-button waves-float" style="margin-left: 15px;" type="button" onClick="javascript:clearFields()" value="Clear">											
											
											</td>
											
										</tr>
										
									</tbody>
								</table>
</div>
</div>

<!-- <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
        <td width="789" height="74" valign="top">

            <fieldset>
                <legend>Select Search Criteria</legend>
                <div id="moreRows">


                    <table border=0>
                        <tr>
                            <td colspan='4'/>
                            <td align=right style='font-size:10px;font-family: Verdana;'><input type="checkbox"
                                                                                                id="fuzzySearch"
                                                                                                name="fuzzySearch"
                                                                                                value="search"/><font
                                    size="1">Fuzzy Search</font>&nbsp;<IMG src="images/informationIcon.png"
                                                                           onMouseOver="showToolTip(event,'Fuzzy Search uses partial text for search in the Value. Example : 105 or 22021 ');return false"
                                                                           onMouseOut="hideToolTip()"/></td>


                        </tr>

                        <tr>
                            <td><h4>Document Type</h4></td>
                            <td><h4>Index Type</h4></td>
                            <td><h4>Value &nbsp;<IMG src="images/informationIcon.png"
                                                     onMouseOver="showToolTip(event,'Use Project Numbers for Value. Examples : 105-22021, 105..');return false"
                                                     onMouseOut="hideToolTip()"/></h4></td>

                            <td colspan='3'><h4>Status</h4></td>

                        </tr>

                        <tr>
                            <td align=left>
                                <select id="doctype" name="doctype" onChange="getIndexType(1);">
                                    <option value="All">All</option>
                                </select></td>

                            <td align=left>
                                <select id="indextype" name="indextype">
                                </select></td>
                            <td align=left>
                                <input id="indexval" name="indexval" type="text" size=12></td>

                            <td align=left>
                                <select id="docStatus" name="docStatus">
                                    <option value="Active">Active</option>
                                    <option value="Inactive">Inactive</option>
                                    <option value="All">All</option>
                                </select></td>


                            <td align=center>
                                <a href="#" id="show" style="display: block;font-size:12px;font-family: Verdana;"
                                   onClick="javascript:showRow();return true;"><IMG src="images/addRow.png" border="0"
                                                                                    alt="Add Row"/></a></td>

                        </tr>
                    </table>
                </div>
            </fieldset>
        </td>
        <td width="61" valign="bottom">
            <input id="submit" name="submit" type="button" onClick="javascript:getfiles()" value="Submit">
        </td>
    </tr>
</table>-->



<table width="100%" align="center" border=0>
    <tr>
        <td valign="top" align="center"><br><br>
            <script type="text/javascript">
                addTableFacadeToManager('formId');
                setMaxRowsToLimit('formId', '15');
                setPageToLimit('formId', '2');
            </script>
            <div class=messagewindow id=messagewindow
                 style="DISPLAY: none; MARGIN: 0px 0px 0px 0px; WIDTH: 100%; border: 0px solid #ff0000; height: 60%; z-index: 4; text-align: center;">
                <!-- Start - put your content here --->
                <h4>
                    Retrieving data.. Please wait.
                </h4>
                <IMG src="images/progress.gif" width="32" height="32" alt=""/>
                <!-- End   - put your content here --->
            </div>

            <div id="results">&nbsp;</div>
            <br>
        </td>
        </tr>
        <tr style="align:right">
        <td>
            <input id="submit2" class="btn btn-success waves-effect waves-button waves-float" style="display: block; float: right; margin-right: 20px; margin-bottom: 20px;" name="submit" type="button" onClick="javascript:submitFileDownloadSet()" value="Submit">
        </td>
    	</tr>
    <div id="bubble_tooltip">
        <div class="bubble_top"><span></span></div>
        <div class="bubble_middle"><span id="bubble_tooltip_content"></span></div>
        <div class="bubble_bottom"></div>
    </div>
</table>
</div>

</body>

</html>
