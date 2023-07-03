
<%
	// @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
%>
<%
	// @ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="folderBean" scope="request"
	class="com.peniel.beans.FolderBean" />

<%@page import="java.util.*"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/stylelager.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/jquery.tooltipster.min.js" type="text/javascript"></script>
<!-- Include the Sidr JS -->

<script src="jscript/jquery.easing.js" type="text/javascript"></script>




<script type="text/javascript" src="js/jquery.alerts.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />


<!-- Our main JS file -->
<link href="assets/css/style.css" rel="stylesheet" />

<link rel="stylesheet" href="css/bootstrap.css"></link>
<link rel="stylesheet" href="css/bootstrap-theme.min.css"></link>
<link rel="stylesheet" type="text/css" href="css/tooltipster.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>




<!-- 	<link rel="stylesheet" href="css/bp/custom_screen.css" type="text/css" media="screen, projection">
      <link rel="stylesheet" href="css/bp/print.css" type="text/css" media="print">
      <link rel="stylesheet" href="css/bp/fancy-type/screen.css" type="text/css" media="screen, projection">-->


<title>TransAccess Imaging</title>
<style type="text/css">
.panel-group .panel {
	width: 97%;
}
</style>

</head>





<body onLoad="initial_load()">














	<div class="panel-group" id="accordion1" role="tablist"
		aria-multiselectable="">
		<div class="panel panel-default">
			<div class="panel-heading-small" role="tab" id="headingUserOne">
				<h4 class="panel-title">
					<a role="button" data-toggle="collapse" data-parent="#accordion1"
						href="#collapseUserOne" aria-expanded="true"
						aria-controls="collapseUserOne" class=""> General/Technical
						Support <i class="zmdi_large zmdi-chevron-down"
						style="float: right;"></i>
					</a>
				</h4>
			</div>
			<div id="collapseUserOne" class="panel-collapse collapse "
				role="tabpanel" aria-labelledby="headingUserOne"
				aria-expanded="true" style="">
				<div class="panel-body">
					<div class="">

						<div class="">
							<!-- Home Page Section -->
							<section>
							<div class="container-fluid">
								<div class="row">


									<!-- Help section -->
									<div class="col-lg-12  section-width" id="help">
										<div class="container-fluid">
											<br>
											<div class="child-help">
												<p>For password or new account assistance please visit
													the FAQ section of the portal.</p>
												<p>
													If you have any general questions or need assistance with
													TransAccess please <br>contact your local TransAccess
													Records Management (POC) Point of Contact.
												</p>

												<br>
												<p>
													If you are reporting a technical issue with TransAccess,
													please email <br>helpdesk@penielsolutions.com and cc:
													your local POC and Jeanne King.
												</p>
												<br>
												<p>Please follow the template provided below and attach
													a screenshot of the error itself.</p>


											</div>

											<div>
												<br> <br>
												<div style="margin-left: 13%; text-align: left;">
													<div class="cal-lg-2"></div>
													<div class="cal-lg-6">
														<div>
															<b> Header:</b>
															<ul>

																<li>[To: Helpdesk@PenielSolutions.com]</li>
																<li>[Cc: (Your Supervisor's
																	Email),Jeanne.M.King@Hud.gov]</li>
																<li>[Subject: (Include Brief description of the
																	problem)]</li>
																<li>[Include Supporting Document
																	(Attachment/Screenshot)]</li>

															</ul>
														</div>

														<div>
															<b> Body:</b>
															<ul>

																<li>[Your Name, First & Last]</li>
																<li>[User Name, MFHD/Hxxxxx]</li>
																<li>[Phone Number, (xxx) xxx-xxxx]</li>
																<li>[Supervisor's Name, First & Last]</li>
																<li>[Detailed description of the problem being
																	reported]</li>
															</ul>
															<br>
														</div>

													</div>
												</div>
												<div class="child-help">
													<p></p>
													Your questions & concerns will be answered in a timely
													manner. Here at PSL we count on your cooperation and
													feedback to assure your daily routine runs as smooth as
													possible. We look forward to working with you.
												</div>
												<br> <br>
											</div>
										</div>
									</div>
								</div>
							</div>

							</section>
						</div>
					</div>
				</div>


			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading-small" role="tab" id="headingUsertwo">
				<h4 class="panel-title">
					<a role="button" data-toggle="collapse" data-parent="#accordion1"
						href="#collapseTwo" aria-expanded="false"
						aria-controls="collapseTwo" class=""> Errant Record Removal
						Assistance <i class="zmdi_large zmdi-chevron-down"
						style="float: right;"></i>
					</a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse in"
				role="tabpanel" aria-labelledby="headingUserOne"
				aria-expanded="false" style="">
				<div class="panel-body">
					<h1>Need Assistance Removing Errant Records ?</h1>
					<div>




						<div class="card"
							style="width: 95%; margin: 0px 0px 0px 0px; padding-left: 0px;">
							<div class="card-body card-padding"
								style="background-color: #FFFFFF; overflow: auto">

								<div
									style="width: 50%; float: left; border-right: 2px dotted #8C8888;">
									<table align="center" width="100%" class="summaryTable">
										<tbody>
											<tr>
												<td style="width: 35%"><h4 class="header">Property</h4></td>
												<td><span href="" id="trigger"><label
														class="infoLbl">8********</label></span></td>
											</tr>


											<tr>
												<td><h4 class="header">Document Type</h4></td>
												<td><label class="infoLbl">1199A Direct Deposit</label></td>
											</tr>

											<tr>
												<td>Document Status</td>
												<td><label class="infoLbl">Active</label></td>
											</tr>




										</tbody>
									</table>
								</div>
								<div
									style="background-color: rgb(255, 255, 255); width: 50%; float: right; height: auto;  max-height: 220px; text-align: left;">
									<table class="summaryTable" style="min-width: 320px">
										<tbody>
											<tr>
												<td style="padding-bottom: 10px;" colspan="2"><h4
														class="tableHeader">Version History</h4></td>
											</tr>
											<tr>
												<td><h4 class="header"
														style="display: inline; padding-right: 10px;">View
														Version No.</h4></td>
												<td><label
													style="display: inline; padding-right: 10px;"
													class="infoLbl">0</label> <a><img
														src="./images/pdfViewer.gif" border="0" height="25px"
														width="25px"></a></td>
											</tr>

										</tbody>
									</table>
								</div>

							</div>
						</div>
<br><br>
						<p style="    text-align: left;">If you notice a mistake after uploading and need the Record removed, don't worry..
						 Just provide us with the necessary information below and your request will be reviewed at the end of the Week. <br/>
						 <b>*The Details link will provide the required information.*</b> <br/>
						Once you confirm all your information is correct, 
						submit this form and you will receive a group automated 
						follow-up email for your Manager to confirm the removal is necessary.</p>

					</div>

<div class="row">
<div class="col-sm-2">
</div>
	<div class="col-sm-10">
	
					<form>
					<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-1"> </label>
								<div class="col-sm-8">

									<span id="result" style="color: red"></span>
								</div>
								
							</div>
						</div>
						
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3">IREMS/Property Number <span class="requiredStar">*</span></label>
								<div class="col-sm-4">

									<input style="height: 25px;" type="text" class="form-control"
										id="iremsnumber" name="IREMS">
								</div>
								<div class="col-sm-6"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3">Document Type: <span class="requiredStar">*</span></label>
								<div class="col-sm-4">
									<select id="doctype" style="height: 25px; width: 223px;">
										<option value="" selected="" disabled="">Select Type of Search</option>

									</select>

								</div>
								<div class="col-sm-6"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3">Version Number: <span class="requiredStar">*</span> </label>
								
								<div class="col-sm-5">
                                    <div style="float: left;width: 80%;"><input style="height: 25px;" type="text" class="form-control" id="version" name="version"></div>
                                    <div> <i class="fa fa-info-circle fa-2x tooltipsearch" aria-hidden="true" ><span class="tooltiptext">Accepts only numeric values. Eg:0,1,2...</span></i></div>
                                </div>
								<div class="col-sm-6"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3">Managers Email: <span class="requiredStar">*</span> </label>
								
								<div class="col-sm-5">
                                    <div style="float: left;width: 80%;"><input style="height: 25px;" type="text" class="form-control" id="managersEmail" name="managersEmail"></div>
                                    <div> <i class="fa fa-info-circle fa-2x tooltipsearch" aria-hidden="true" ><span class="tooltiptext">Accepts only alphanumeric values. Eg:012-EH014</span></i></div>
                                </div>
								<div class="col-sm-6"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3">Brief Description of Problem: <span class="requiredStar">*</span> </label>
								
								<div class="col-sm-5">
                                    <div style="float: left;width: 80%;">
                                    <textarea style="resize:none;" id="description" class="form-control" rows="3"   maxlength="1000"></textarea>
                                    </div>
                                    <div> <i class="fa fa-info-circle fa-2x tooltipsearch" aria-hidden="true" ><span class="tooltiptext">Accepts only alphanumeric values. Eg:012-EH014</span></i></div>
                                </div>
								<div class="col-sm-6"></div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="row">
								 <div class="col-sm-3">
						 <span style="color:#009cd1"><b>Demonstration</b></span> <br>
							 <img onclick="myFunctionvideo()" src="images/VIDIMG1.jpg" title="Tutorial: Signing-In with Multifactor Authentication" style="cursor: pointer;" >
							 </div>
								<div class="col-sm-9">
								<br>
                                   <div class="text-left" style="margin-left: 45px;">
						
							
							<button type="button" class="btn btn-success"
								onclick="saveRequest()">Submit</button>
							<input type="reset" style="color:#fff !important;border color:#ff9900 !important;background-color:#ff9900 !important;" class="btn resettable"
								value="Reset" />
								
						</div>
                                </div>
							</div>
						</div>

						
					</form>
				</div>
				</div>
				</div>
			</div>
		</div>









		<script language="javascript">
		 function myFunctionvideo() {
			  popupvideo("videos/Record_Removal_Demo.mp4",'Test Frame',700, 500)
			}
		 function popupvideo(url, title, w, h) {
			  var left = (screen.width/2)-(w/2);
			  var top = (screen.height/2)-(h/2);
			  return window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
			} 
			$(document).mousemove(function(event) {
				InitializeTimer();
			});
			function validateEmail(email) 
			{  
				if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))  
				  {  
				    return true; 
				  } 
			   
			    return false;

			}
			function validatenumber(phone)  
			{  

				if( /^[0-9]/.test(phone))
				{
					return true;
				}
				return false;
			 
			}
			
			function initial_load() {
				getDocTypes();
				setHeader('help.jsp');
				var array_of_li = document.querySelectorAll("ul.tab-nav li");
				for (var i = 0; i < array_of_li.length; i++) {

					if (array_of_li[i].textContent.trim() == 'Help') {
						array_of_li[i].setAttribute("class", "active");
					}

				}

			}

			/**
			 * Module for displaying "Waiting for..." dialog using Bootstrap
			 *
			 * @author Eugene Maslovich <ehpc@em42.ru>
			 */

			var waitingDialog = waitingDialog
					|| (function($) {
						'use strict';

						// Creating modal dialog's DOM
						var $dialog = $('<div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-hidden="true" style="padding-top:15%; overflow-y:visible;">'
								+ '<div class="modal-dialog modal-m">'
								+ '<div class="modal-content">'
								+ '<div class="modal-header"><h3 style="margin:0;"></h3></div>'
								+ '<div class="modal-body">'
								+ '<div class="progress progress-striped active" style="margin-bottom:0;"><div class="progress-bar" style="width: 100%"></div></div>'
								+ '</div>' + '</div></div></div>');

						return {
							/**
							 * Opens our dialog
							 * @param message Custom message
							 * @param options Custom options:
							 * 				  options.dialogSize - bootstrap postfix for dialog size, e.g. "sm", "m";
							 * 				  options.progressType - bootstrap postfix for progress bar type, e.g. "success", "warning".
							 */
							show : function(message, options) {
								// Assigning defaults
								if (typeof options === 'undefined') {
									options = {};
								}
								if (typeof message === 'undefined') {
									message = 'Uploading Files!  Please Wait...';
								}
								var settings = $.extend({
									dialogSize : 'm',
									progressType : '',
									onHide : null
								// This callback runs after the dialog was hidden
								}, options);

								// Configuring dialog
								$dialog.find('.modal-dialog').attr('class',
										'modal-dialog').addClass(
										'modal-' + settings.dialogSize);
								$dialog.find('.progress-bar').attr('class',
										'progress-bar');
								if (settings.progressType) {
									$dialog.find('.progress-bar').addClass(
											'progress-bar-'
													+ settings.progressType);
								}
								$dialog.find('h3').text(message);
								// Adding callbacks
								if (typeof settings.onHide === 'function') {
									$dialog.off('hidden.bs.modal').on(
											'hidden.bs.modal', function(e) {
												settings.onHide.call($dialog);
											});
								}
								// Opening dialog
								$dialog.modal();
							},
							/**
							 * Closes dialog
							 */
							hide : function() {
								$dialog.modal('hide');
							}
						};

					})(jQuery);
		</script>
</body>

</html>
