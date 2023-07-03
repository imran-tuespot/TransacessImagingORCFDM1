<%// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />

<%@page import="java.util.*"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <script src="js/jquery.tooltipster.min.js" type="text/javascript"></script>
		<!-- Include the Sidr JS -->
    	<script src="js/jquery.sidr.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<script src="jscript/jquery.easing.js" type="text/javascript"></script>
		<script src="jscript/jqueryFileTree.js" type="text/javascript"></script>
		<link href="css/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />
		
	<!-- 	<link rel="stylesheet" type="text/css" href="css/jmesa.css"></link>
		<link rel="stylesheet" href="css/bubble-tooltip.css" media="screen" />
		<script type="text/javascript" src="js/bubble-tooltip.js"></script>
		<script type="text/javascript" src="js/jquery.quickflip.js" ></script>
		<script src="assets/js/jquery.ui.widget.js"></script>
		<script src="assets/js/jquery.iframe-transport.js"></script>
		<script src="assets/js/jquery.fileupload.js"></script>
		<script src="assets/js/jquery.popupoverlay.js"></script>
			
		
		<script type="text/javascript" src="js/jquery.alerts.js" ></script>		
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />  -->
		
		
	     <!-- Our main JS file -->
		<link href="assets/css/style.css" rel="stylesheet" />
		
		<link rel="stylesheet" href="css/bootstrap.css"></link>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
		<link rel="stylesheet" type="text/css" href="css/tooltipster.css" />
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>	
		
		
		
		
	<!-- 	<link rel="stylesheet" href="css/bp/custom_screen.css" type="text/css" media="screen, projection">
      <link rel="stylesheet" href="css/bp/print.css" type="text/css" media="print">
      <link rel="stylesheet" href="css/bp/fancy-type/screen.css" type="text/css" media="screen, projection">-->
		

		<title>TransAccess Imaging</title>
		<style type="text/css">
		
		div#expand{
		display:block;
		width:100%;
		}
		.example {
			float: left;
			
		}
		.panel-body{
		    text-align: left;
		}
		/* .folderStruct {
			margin-top:20px;
			width: 98%;
			height: 100%;
			border: solid 1px #BBB;
			background: #FFF;
			overflow: auto;
			padding: 5px;
		} */
			.folderStruct {
			width: 98%;
			height: 230px;
			border: solid 1px #BBB;
			background: #FFF;
			overflow: auto;
			padding: 5px;
		}
		#content{
		position:relative;
		}
		
		  #flip-tabs{  
		    width:850px;  
		      
		} 
		#flip-navigation{  
		    list-style:none;  
		    margin: 0px 0px 8px;
		    padding: 6px 0px 8px;
		    text-align: left;
		    width: 800px;
		
		}  
		#flip-navigation li{   
		    display:inline;  
		}  
		
	    #flip-navigation li.selected{
			border-width: 1px;
			border-style: solid;
			border-color: #999 #999 #FFF;			
			border-image: none;
			padding-top:9px;
			background-color: #FF9800;
			border-color: transparent;
			padding-bottom: 11px;
		}
		#flip-navigation li a{  
		    text-decoration:none; padding:10px;
		    margin-right:0px;  
		    color:#333; outline:none;  
		    font-family:roboto;font-size:13px;;  
		}  
		#flip-navigation li a:hover{  
		    color:#2196F3;  
		}  
		#flip-navigation li.selected a{  
			height: 25px;
			padding: 4px 11px 15px 9px;
			font-size: 14px;
			letter-spacing: normal;
			text-decoration: none;
			color: #333;
			border-bottom: medium none; 
			background-color: #FFF;
		}  
		#flip-container{    
		    width:850px;  
		    font-family: roboto;
		    font-size:0.8em;  
		    overflow: visible;
			height: auto;
		}  
		.tabBox{
		background-color: #FFF;
		padding: 0px 6px;
		position: relative;
		border-bottom: 1px solid #999;
		height: 27px;
		margin-bottom: 20px;
		margin-top: 20px;
		height: 37px;

		}				
		</style>
</head>



 <% try{
if(request.getSession().getAttribute("appuserrole")!=null){
  int uid	= Integer.parseInt(request.getSession().getAttribute("userid").toString());
  String sessionid = request.getSession().getAttribute("sessionid").toString();
  int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());
  String userName = request.getSession().getAttribute("username").toString();
  
  String appuserrole = (String)request.getSession().getAttribute("appuserrole");
  System.out.println("appuserrole "+appuserrole);
  javax.naming.Context ctx1 = 	new javax.naming.InitialContext();
		String restURL = (String) ctx1.lookup("java:comp/env/restCommonUrl");
  
   //String folderPatteren=request.getSession().getAttribute("folderPatterens").toString();
   // System.out.println("folderPatteren--->"+folderPatteren.replaceAll("\\[|\\]", ""));
   
    /* List<String> list=new ArrayList<String>();
  
  String folderPatteren=null;
  
  Map accessPatteren= (Map)request.getSession().getAttribute("accessPatteren");
  System.out.println("accessPatteren--->"+accessPatteren);
  
  Iterator entries = accessPatteren.entrySet().iterator();
  while (entries.hasNext()) {
      Map.Entry entry = (Map.Entry) entries.next();
     if(!entry.getValue().toString().equalsIgnoreCase("ReadOnly")){
    	  list.add((String)entry.getKey());
      
  }
  }
  folderPatteren=list.toString();  
  System.out.println("folderPatteren--->"+folderPatteren.replaceAll("\\[|\\]", "")); 

   */
  java.util.Date today = new java.util.Date();
  java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
  //String html = folderBean.getFolderNameGridHTML(""+cid); 
  //request.getSession().setAttribute("folderData", html);	
  
   /*  List<String> html = folderBean.getPropertyNameGridHTML(""+cid,folderPatteren.replaceAll("\\[|\\]","").replaceAll(",\\s","|")); 
  request.getSession().setAttribute("folderData", html); */

%>


<DIV id=preview_div style="DISPLAY: none; POSITION: absolute ; BORDER-LEFT-COLOR: #777777"></DIV>


<jsp:include page="includes/sessionHeader.jsp" />

<body onLoad="initial_load()" >




<div class="">

<div class="workingAreaBlueHeading">
			<div align="center"><div id="headertext"><i class="zmdi_large zmdi-settings-square my_popup_open"></i> Frequently asked questions</div>		</div>
		  </div>
	
<div class="">
	 <!-- FAQ Page Section -->
    <section class="Faq section-width" id="faq">
        <div class="container-fluid">
            <div class="">

                <p style="text-align: left;"><span>Click on the <b>question</b> and the <b>answer</b> should expand below it.</span></p><br>
                <div class="questions">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                        &nbsp;
Where do I find the instruction for uploading files ?</a>
                                </h5>
                            </div>
                            <div id="collapse1" class="panel-collapse collapse">
                                <div class="panel-body">
                            The instructions for uploading are located in the tab 'DROPBOX'. Instructions are as follows:
<ul>

<!-- <li>Any files uploaded without IREMS OR Document Type can be found in pending uploads.</li>
<li>Pending uploaded can be located in the 'PENDING UPLOADS' Tab.</li>
<li>Only Portable Document Format files (PDF) are allowed.</li>
<li>You can drag & drop from your desktop on this website.</li> -->

   <li>Only Portable Document Format files (PDF) are allowed</li>
                        <li>Max (16) files per upload</li>
						<li>Max file size (500MB)</li>
                        <li>Filename format is as follows 'iREMS#_DocumentType'</li>
                         <li>You can drag &amp; droprecords from your desktop</li>
                        <li>Any records uploaded without IREMS # OR Document Type will be found in Pending Uploads</li>
                        <li>A session will timeout during extended idle periods (~20Min)</li>
                        <li>To confirm all records were uploaded successfully, please review Pending Uploads</li>
                       
</ul> 
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                                       &nbsp;  How do I reset my password ?</a>
                                </h5>
                            </div>
                            <div id="collapse2" class="panel-collapse collapse">
                                <div class="panel-body">&nbsp;&nbsp; Resetting your password is very simple and can be accomplished by heading to the login page located at this URL "https://recordsmanagement.transaccessimaging.com", and then choosing the 'Forgot Password' button located next to the 'Submit' button. On the next page you will be asked to enter in your User Login ID in the available field. Once complete, click the 'Go' button, and if you have a registered account that matches the entered Login ID, an email will be sent to you with instructions contained within on how to reset your password. 
                                                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                                        &nbsp; When can I expect a record to appear in the repository ?</a>
                                </h5>
                            </div>
                            <div id="collapse3" class="panel-collapse collapse">
                                <div class="panel-body">&nbsp;&nbsp;Once a record is successfully processed into the repository, the record will be made immediately available for review.  

                                </div>
                            </div>
                        </div>
                          <div class="panel panel-default">
                            <div class="panel-heading">
                               <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse33">
                                        &nbsp;  How do I report technical Issue ?</a>
                                </h5>
                            </div>
                            <div id="collapse33" class="panel-collapse collapse">
                                <div class="panel-body"> 
                                 &nbsp;&nbsp;If you are having trouble within the Portal, please view the tab 'HELP'. There will be instructions in the help menu on how to address the problem. You may also send an email to 'helpdesk@PenielSolutions.com' with a detailed description of the problem, and a screenshot for visual representation. 

                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">
                                        &nbsp; How do I locate my uploaded records ?</a>
                                </h5>
                            </div>
                            <div id="collapse4" class="panel-collapse collapse">
                                <div class="panel-body">&nbsp;&nbsp;To find your recently uploaded records, click the tab 'Record Repository'. Within Record Repository you will notice that there are multiple ways to finding a record. It is recommended that you choose whichever method works best for you.
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">
                                        &nbsp;  Are there any tips and tricks that may be helpful navigating the site ?</a>
                                </h5>
                            </div>
                            <div id="collapse5" class="panel-collapse collapse">
                                <div class="panel-body">&nbsp;&nbsp; If you are in need of some additional assistance while navigating the site, feel free to visit the tab 'Training'. The training page will provide you with some walkthrough videos on how key functions of the Portal work.
                                </div>
                            </div>
                        </div> 
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse6">
                                         &nbsp; I am an active user, but my team member is not and can't access the site. How do they gain access ?</a>
                                </h5>
                            </div>
                            <div id="collapse6" class="panel-collapse collapse">
                                <div class="panel-body"> &nbsp;&nbsp;To gain access to the site the user would need to reach out to their Administrator. Admin is the only user role with the access capable of modifying and creating user accounts.
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse7">
                                         &nbsp;  How do I download a report of user uploaded records to email ?</a>
                                </h5>
                            </div>
                            <div id="collapse7" class="panel-collapse collapse">
                                <div class="panel-body">&nbsp;&nbsp; To download a report of user uploaded records, that can be found on the 'HOME' tab. On the home tab you will notice a link that reads 'Upload Record Report', click on that link. From there you be asked to provide a date range to locate the desired records, after that date range is set choose the button 'Get Report'. Once the list of records appear you will generate a report by clicking 'Excel Export'.
                                  
                                </div>
                            </div>
                        </div>
                         <div class="panel panel-default">
                            <div class="panel-heading">
                               <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse8">
                                         &nbsp;  Why am I unable to upload a record ? </a>
                                </h5>
                            </div>
                            <div id="collapse8" class="panel-collapse collapse">
                                <div class="panel-body">&nbsp;&nbsp; A user is unable to upload a record if they do not have the appropriate access. The roles required to upload records include: ADMIN, and COORDINATOR. 
If you do have the correct access and you are still unable to upload a record, please reach out to your Administrator for further assistance.
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               <h5 class="panel-heading-small">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse9">
                                         &nbsp;  Who do I contact for editing or correcting an existing IREM# or Doc Type ?</a>
                                </h5>
                            </div>
                            <div id="collapse9" class="panel-collapse collapse">
                                <div class="panel-body">&nbsp;&nbsp;  For assistance with editing a record you will need to reach out to a user with the appropriate access. That would be either an ADMINISTRATOR or COORDINATOR.

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- FAQ Page Section End-->
	
	</div>
	</div>
<script language="javascript">
$(document).mousemove(function(event){
	  InitializeTimer();
});
function initial_load() {
	
	setHeader('faq.jsp');
	var array_of_li =  document.querySelectorAll("ul.tab-nav li");
	for (var i = 0; i < array_of_li.length; i++) {
		 if(array_of_li[i].textContent.trim()=='Faq'){
			array_of_li[i].setAttribute("class", "active");	
		}  
		
		
	}
	
	
}










/**
 * Module for displaying "Waiting for..." dialog using Bootstrap
 *
 * @author Eugene Maslovich <ehpc@em42.ru>
 */

var waitingDialog = waitingDialog || (function ($) {
    'use strict';

	// Creating modal dialog's DOM
	var $dialog = $(
		'<div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-hidden="true" style="padding-top:15%; overflow-y:visible;">' +
		'<div class="modal-dialog modal-m">' +
		'<div class="modal-content">' +
			'<div class="modal-header"><h3 style="margin:0;"></h3></div>' +
			'<div class="modal-body">' +
				'<div class="progress progress-striped active" style="margin-bottom:0;"><div class="progress-bar" style="width: 100%"></div></div>' +
			'</div>' +
		'</div></div></div>');

	return {
		/**
		 * Opens our dialog
		 * @param message Custom message
		 * @param options Custom options:
		 * 				  options.dialogSize - bootstrap postfix for dialog size, e.g. "sm", "m";
		 * 				  options.progressType - bootstrap postfix for progress bar type, e.g. "success", "warning".
		 */
		show: function (message, options) {
			// Assigning defaults
			if (typeof options === 'undefined') {
				options = {};
			}
			if (typeof message === 'undefined') {
				message = 'Uploading Files!  Please Wait...';
			}
			var settings = $.extend({
				dialogSize: 'm',
				progressType: '',
				onHide: null // This callback runs after the dialog was hidden
			}, options);

			// Configuring dialog
			$dialog.find('.modal-dialog').attr('class', 'modal-dialog').addClass('modal-' + settings.dialogSize);
			$dialog.find('.progress-bar').attr('class', 'progress-bar');
			if (settings.progressType) {
				$dialog.find('.progress-bar').addClass('progress-bar-' + settings.progressType);
			}
			$dialog.find('h3').text(message);
			// Adding callbacks
			if (typeof settings.onHide === 'function') {
				$dialog.off('hidden.bs.modal').on('hidden.bs.modal', function (e) {
					settings.onHide.call($dialog);
				});
			}
			// Opening dialog
			$dialog.modal();
		},
		/**
		 * Closes dialog
		 */
		hide: function () {
			$dialog.modal('hide');
		}
	};

})(jQuery);

</script>

</body>
<%
}else{
	response.sendRedirect("index.jsp");
}
}catch(Exception ie){
	response.sendRedirect("index.jsp");
}
%>

</html>
