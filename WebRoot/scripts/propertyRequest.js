
function resetLoanInformationForADD(){
		document.getElementById("loanErrorForNew").innerHTML  = "";
			$("#efhaNumber").val("");
			$("#eloanAmount").val("");
			$("#elistOfLoanTypes").val("");
			$("#elenderName").val("");
			$("#eendDate").val("");
			$("#eterminationDate").val("");
		
		}

function saveLoanInformationForEdit(addNewForm) {

	 $('#editLoanSuccessMessage').empty();
	var companyIdValue = globalCompanyId;
	var userIdvalue = globalUserId;
	var isAvailble = true;
	var message = "Please enter the parameters::";
	var x = document.getElementById("elistOfLoanTypes");
	for (var i = 0; i < x.options.length; i++) {
		if (x.options[i].selected == true) {
			var loanTypesId = x.options[i].value;
		}
	}
	if ($("#efhaNumber").val().trim() == "") {
		isAvailble = false;
		message += "FHA Number, ";
	}
	if ($("#eloanAmount").val().trim() == "") {
		isAvailble = false;
		message += "Loan Amount, ";
	}
	if ($("#elenderName").val().trim() == "") {
		isAvailble = false;
		message += "Lender Name, ";
	}
	if ($("#eendDate").val().trim() == "") {
		isAvailble = false;
		message += "Closing Date,";
	}

	if (loanTypesId == "Select Loan Type" || loanTypesId == "") {
		isAvailble = false;
		message += "Loan Type ,";
	}

	if (new Date($("#eendDate").val()).getTime() > new Date($(
			"#eterminationDate").val()).getTime()) {
		isAvailble = false;
		message += "Termination date should be greater than Closing Date";
	} else if (new Date($("#eendDate").val()).getTime() < new Date($(
			"#eterminationDate").val()).getTime()) {

	} else {
	}

	if (isAvailble == true) {
		
		var testData = {
			"companyId" : companyIdValue,
			"propertyId" : parseInt(globalPId),
			"loanTypeId" : parseInt(loanTypesId),
			"fhaNumber" : $("#efhaNumber").val(),
			"loanAmount" : $("#eloanAmount").val(),
			"lenderName" : $("#elenderName").val(),
			"closingDate" : $("#eendDate").val(),
			"userId" : userIdvalue,
			"terminationDate" : $("#eterminationDate").val()
		};
		console.log("810:::" + JSON.stringify(testData));
		 document.getElementById("loanErrorForNew").innerHTML= "";
		$.ajax({
					type : "POST",
					contentType : "application/json",
					url : globalRestUrl + "/orcf/addLoanInfo",
					dataType : 'json',
					timeout : 100000,
					data : JSON.stringify(testData),
					success : function(data) {
						console.log("......1100......" + JSON.stringify(data));
						$("#tagscloud" + count).hide();
						if (data.key == 200) {
							$('#btnEdit').hide();
							// btnEdit2
							$('#btnEdit2').hide();
							$('#editLoanInfo').empty();
							var propertyID = parseInt(globalPId);
							/*
							 * logic for loading property infor with loan data
							 * updated
							 */
							console.log(propertyID);
							var companyIdValue = globalCompanyId;
							$
									.ajax({
										type : "GET",
										contentType : "application/json",
										url : globalRestUrl
												+ "/orcf/getEditPropertyInfo?propertyId="
												+ propertyID,
										dataType : 'json',
										timeout : 100000,
										success : function(data) {
											console
													.log("getEditProppertyInfo success : 718 "
															+ JSON
																	.stringify(data));
											$("#successmsg").hide();
											$("#editmsg").hide();
											// $("#editloanUpdateSuccess").hide();
											getData(
													data.PropertyDataInfo.state,
													data.PropertyDataInfo.propertyTypeId);

											$('#epropertyId')
													.val(
															data.PropertyDataInfo.propertyId);
											$('#epropertyName')
													.val(
															data.PropertyDataInfo.propertyName);
											$('#ecity').val(
													data.PropertyDataInfo.city);
											$('#estate')
													.val(
															data.PropertyDataInfo.state);
											$('#ezip').val(
													data.PropertyDataInfo.zip);

											$
													.ajax({
														type : "GET",
														contentType : "application/json",
														url : globalRestUrl
																+ "/orcf/getLoanTypes?companyId="
																+ globalCompanyId,
														dataType : 'json',
														timeout : 100000,
														success : function(lt) {
															if (data.LoandataInfo) {
																datalenth = data.LoandataInfo.length - 1;
																for (var z = 0; z < data.LoandataInfo.length; z++) {
																	for (i = 0; i < lt.response.length; i++) {
																		if (loanTypeId == lt.response[i].loanTypeId) {
																			$(
																					"#elistOfLoanTypes"
																							+ z)
																					.append(
																							"<option selected value='"
																									+ lt.response[i].loanTypeId
																									+ "'><b>"
																									+ lt.response[i].loanType
																									+ "</b></option>");
																		} else {
																			$(
																					"#elistOfLoanTypes"
																							+ z)
																					.append(
																							"<option value='"
																									+ lt.response[i].loanTypeId
																									+ "'><b>"
																									+ lt.response[i].loanType
																									+ "</b></option>");
																		}
																	}
																}
															} else {
																for (i = 0; i < lt.response.length; i++) {
																	if (loanTypeId == lt.response[i].loanTypeId) {
																		$(
																				"#elistOfLoanTypes"
																						+ z)
																				.append(
																						"<option selected value='"
																								+ lt.response[i].loanTypeId
																								+ "'><b>"
																								+ lt.response[i].loanType
																								+ "</b></option>");
																	} else {
																		$(
																				"#elistOfLoanTypes"
																						+ z)
																				.append(
																						"<option value='"
																								+ lt.response[i].loanTypeId
																								+ "'><b>"
																								+ lt.response[i].loanType
																								+ "</b></option>");
																	}
																}
															}
														},
														error : function(e) {
															console.log(
																	"ERROR: ",
																	e);
															displayModules(e);
														},
														done : function(e) {
															console.log("DONE");
														}
													});
											var datalenth = 0;

											if (data.LoandataInfo) {
												for (var x = 0; x < data.LoandataInfo.length; x++) {

													var appendData = "<div class='card' style='width: 95%; padding-left: 0px; position: relative; background: #fff; box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15); border-top: 1px solid rgba(0, 0, 0, 0.15); margin-bottom: 30px;'>"
															+ "<div	style='background-color: #EDECEC; padding: 23px 26px; box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);'>"
															+ "<div style='text-align: center; font-size: 16px;'>Loan Information</div>"
															+ "<div style='text-align: center;' id='editloanUpdateSuccess"
															+ x
															+ "'>"
															+ "<h4 style='color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;' id='editLoanSuccessMessage"
															+ x
															+ "'></h4>"
															+ "</div>"
															+ "<div style='text-align: center;' id='editloanUpdateSuccess'>"
															+ "<h4 style='color: rgb(0, 128, 0); border-bottom: 1px dotted rgb(0, 128, 0); padding: 8px; margin-bottom: 20px;' id='editLoanSuccessMessage'></h4>"
															+ "</div>"
															+ "<table class='table loanTable' cellspacing='0'>"
															+ "<tbody>"
															+ "<tr>"
															+ "<td class='wisth200'>Associated FHA Number <span class='requiredStar'>*</span></td>"
															+ "<td colspan='3'><div></div>"
															+ "<input class='tableInputselectStyle123' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='efhaNumber"
															+ x
															+ "' name='propertyId' maxlength='150'  value="
															+ data.LoandataInfo[x].fhaNumber
															+ "  onfocus='getFilesist(\""
															+ data.PropertyDataInfo.propertyId
															+ "\",\""
															+ data.LoandataInfo[x].fhaNumber
															+ "\",\""
															+ x
															+ "\")'> <span id='textMsg"
															+ x
															+ "' style='color: red;'></span></td>"
															+ "</tr>"
															+ "<tr>"
															+ "<td class='wisth200'>Loan Type<span class='requiredStar'>*</span></td>"
															+ "<td>"
															+ "<select id='elistOfLoanTypes"
															+ x
															+ "' class='tableInputselectStyle123 selectLoanTypeclass'><option>Select Loan Type</option></select></td>"
															+ "</tr>"
															+ "<tr>"
															+ "<td class='wisth200'>Loan Amount <span class='requiredStar'>*</span></td>"
															+ "<td colspan='3'>"
															+ "<div></div>"
															+ "<input class='tableInputselectStyle123' size='50' currency style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='eloanAmount"
															+ x
															+ "' name='eloanAmount' value="
															+ data.LoandataInfo[x].loanAmount
															+ " />"
															+ "</td>"
															+ "</tr>"
															+ "<tr>"
															+ "<td class='wisth200'>Lender Name <span class='requiredStar'>*</span></td>"
															+ "<td colspan='3'><div></div>"
															+ "<input class='tableInputselectStyle123' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='elenderName"
															+ x
															+ "' name='city' value="
															+ data.LoandataInfo[x].lenderName
															+ " >"
															+ "</td>"
															+ "</tr>"
															+ "<tr>"
															+ "<td class='wisth200'>Closing Date <span class='requiredStar'>*</span></td>"
															+ "<td>"
															+ "<input id='eendDate"
															+ x
															+ "' type='text'  value="
															+ data.LoandataInfo[x].closingDate
															+ " class='form-control tableInputselectStyle12345 endDate col-sm-12 inputStyle1' placeholder='Closing Date' style='width: 100%'>"
															+ "<div>"
															+ "<div class='col-sm-8 posiRelavtive'>"

															+ "</div>"
															+ "</div>"
															+ "</td>"
															+ "</tr>"
															+ "<tr>"
															+ "<td class='wisth200'>Termination Date</td>"
															+ "<td>"
															+ "<input id='eterminationDate"
															+ x
															+ "' type='text'  value="
															+ data.LoandataInfo[x].terminationDate
															+ " class='form-control tableInputselectStyle12345 endDate col-sm-12 inputStyle1' placeholder='Termination Date' style='width: 100%'>"
															+ "<div class='form-group row'>"
															+ "<div class='col-sm-8 posiRelavtive'>"
															+ "</div>"
															+ "</div>"
															+ "</td>"
															+ "</tr>"
															+ "<td></td>"
															+ "<td style='text-align: left;'><input name='button2' id='button2' class='btn btn-success waves-effect waves-button waves-float' style='margin-left: 20px;' type='button' value='Update' onclick='updateLoanDataIdInfo(\""
															+ data.LoandataInfo[x].loanDataId
															+ "\",\""
															+ x
															+ "\")'>";
													if (x == data.LoandataInfo.length - 1) {
														/*
														 * save and add new loan
														 * in edit
														 */
														appendData = appendData
																+ "<input name='button2' id='btnEdit2' class='btn btn-success waves-effect waves-button waves-float' style='margin-left: 15px;' type='button' value='Update & Add a New Loan'  onClick ='saveLoanInformationAndAddNewLoanInEdit(\""
																+ data.LoandataInfo[x].loanDataId
																+ "\",\"" + x
																+ "\")'>";
													}
													+"</td>" + "</tr>"
															+ "</tbody>"
															+ "</table>"
															+ "</div>"
													if (x == data.LoandataInfo.length - 1) {
														appendData = appendData /*
																				 * + "<div
																				 * id='LoanEditTextBoxContainer'
																				 * style='background-color:
																				 * #EDECEC;
																				 * padding:
																				 * 23px
																				 * 26px;
																				 * box-shadow:
																				 * 0px
																				 * 2px
																				 * 2px
																				 * rgba(0,
																				 * 0,
																				 * 0,
																				 * 0.3);'></div>";
																				 */
													}
													+"</div>" + "</div>";
													$('#editLoanInfo').append(
															appendData);
													// $('#editloanUpdateSuccess').append("<h5
													// style='color:
													// green;'>Loan Details
													// Updated
													// Successfully</h5>");
													$('#editLoanSuccessMessage').append("Loan Details Added Successfully!");
													$('#editLoanSuccessMessage'+index).fadeIn(5000);
													 $('#editLoanSuccessMessage'+index).fadeOut(3000);
													$('#btnEdit').hide();
													var datahtml = $(
															'#editLoanInfo')
															.html();

													if (datalenth != x) {
														$('#editLoanInfo')
																.clone(true)
																/*
																 * get a clone
																 * of the
																 * element and
																 * from it
																 */
																.find(
																		'#btnEdit') /*
																					 * retrieve
																					 * the
																					 * button,
																					 * then
																					 */
																.remove() /*
																			 * remove
																			 * it,
																			 */
																.end() /*
																		 * return
																		 * to
																		 * the
																		 * previous
																		 * selection
																		 * and
																		 */
																.html();
													}
													var loanTypeId = data.LoandataInfo[x].loanTypeId;
													// append last new loan form
													// at the end of for loop
													// when
													// if($('#editLoanInfo').children().length>0){

													// sfsfsf
													/*
													 * To add a new empty loan
													 * form after saving first
													 * one
													 */
													var appendData = "<div class='card' style='width: 95%; padding-left: 0px; position: relative; background: #fff; box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15); border-top: 1px solid rgba(0, 0, 0, 0.15); margin-bottom: 30px;'>"
															+ "<div	style='background-color: #EDECEC; padding: 23px 26px; box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);'>"
															+ "<div style='text-align: center; font-size: 16px;'>Loan Information</div>"
															+ "<table class='table loanTable' cellspacing='0'>"
															+ "<tbody>"
															+ "<tr>"
															+ "<td class='wisth200'> Associated FHA Number  <span class='requiredStar'>*</span></td>"
															+ "<td colspan='3'><div></div>"
															+ "<input class='tableInputselectStyle123' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='efhaNumber' name='efhaNumberEdit' maxlength='150'  value='' onfocus='duplicateFhanumberCheck(\""
															+ $("#epropertyId")
																	.val()
															+ "\",\""
															+ this.value
															+ "\",\""
															+ x
															+ "\")'>"
															+ "<span id='textMsg' style='color: red;'></span></td>"
															+ "</tr>"
															+ "<tr>"
															+ "<td class='wisth200'>Loan Type<span class='requiredStar'>*</span></td>"
															+ "<td>"
															+ "<select id='elistOfLoanTypes' class='tableInputselectStyle123 selectLoanTypeclass'><option>Select Loan Type</option></select></td>"
															+ "</tr>"
															+ "<tr>"
															+ "<td class='wisth200'>Loan Amount <span class='requiredStar'>*</span></td>"
															+ "<td colspan='3'>"
															+ "<div></div>"
															+ "<input class='tableInputselectStyle123  currency' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='eloanAmount' name='eloanAmount' value='' />"
															+ "</td>"
															+ "</tr>"
															+ "<tr>"
															+ "<td class='wisth200'>Lender Name <span class='requiredStar'>*</span></td>"
															+ "<td colspan='3'><div></div>"
															+ "<input class='tableInputselectStyle123' size='50' style='box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);' type='text' id='elenderName' name='elenderName' value='' >"
															+ "</td>"
															+ "</tr>"
															+ "<tr>"
															+ "<td class='wisth200'>Closing Date <span class='requiredStar'>*</span></td>"
															+ "<td>"
															+ "<input id='eendDate' type='text'  value='' class='form-control tableInputselectStyle12345 endDate col-sm-12 inputStyle1' placeholder='Closing Date' style='width: 100%'>"
															+ "</td>"
															+ "</tr>"

															+ "<tr>"
															+ "<td class='wisth200'>Termination Date</td>"
															+ "<td>"
															+ "<input id='eterminationDate' type='text'  value='' class='form-control tableInputselectStyle12345 endDate col-sm-12 inputStyle1' placeholder='Termination Date' style='width: 100%'>"
															+ "<div class='form-group row'>"
															+ "<div class='col-sm-8 posiRelavtive'>"
															+ "</div>"
															+ "</div>"
															+ "</td>"
															+ "</tr>"

															+ "<td></td>"
															+ "<td style='text-align: left;'><input name='button2' id='button2' class='btn btn-success waves-effect waves-button waves-float' style='margin-left: 20px;' type='button' value='Save' onclick='saveLoanInformationForEdit(false)'>";
													appendData = appendData
															+ "<input name='button2' id='btnEdit' class='btn btn-success waves-effect waves-button waves-float' style='margin-left: 15px;' type='button' value='Save & Add a New Loan'  onClick ='saveLoanInformationForEdit(true)'>"
															+ "<input name='button' id='resetButton' class='btn btn-warning waves-effect waves-button waves-float' style='margin-left: 15px;' type='button' value='Reset' onclick='resetLoanInformation()'>"
															+ "</td>" + "</tr>"
															+ "</tbody>"
															+ "</table>"
															+ "</div>"
															+ "</div>"
															+ "</div>";
													if (addNewForm) {
														if (x == data.LoandataInfo.length - 1) {
															$('#editLoanInfo')
																	.append(
																			appendData);
															$('#btnEdit2')
																	.hide();
															var companyIdValue = globalCompanyId;
															// alert(companyIdValue);
															$
																	.ajax({
																		type : "GET",
																		contentType : "application/json",
																		url : globalRestUrl
																				+ "/orcf/getLoanTypes?companyId="
																				+ companyIdValue,
																		dataType : 'json',
																		timeout : 100000,
																		success : function(
																				lt) {
																			// alert('getLoanTypes
																			// success..');
																			for (i = 0; i < lt.response.length; i++) {
																				$(
																						"#elistOfLoanTypes")
																						.append(
																								"<option value='"
																										+ lt.response[i].loanTypeId
																										+ "'><b>"
																										+ lt.response[i].loanType
																										+ "</b></option>");
																			}
																		},
																		error : function(
																				e) {
																			console
																					.log(
																							"ERROR: ",
																							e);
																			displayModules(e);
																		},
																		done : function(
																				e) {
																			console
																					.log("DONE");
																		}
																	});
															/* New Loan FOrm end */
														} else {
															$('#btnEdit')
																	.show();
															// $('#editLoanInfo').append("dsfdsafdsafdsafa");
														}
													}
												}
											}
										},
										error : function(e) {
											console.log("ERROR: ", e);
											// displayModules(e);
										},
										done : function(e) {
											console.log("DONE");
										}
									});
						}
						},
					error : function(e) {
						console.log("ERROR: ", e);
					},
					done : function(e) {
						console.log("DONE");
					}
				});
	} else {
		/* if(message.endsWith(",")){ */
		if (message.substring(message.length - 1) == ',') {
			message = message.substring(0, message.length - 1);
		}
		 document.getElementById("loanErrorForNew").innerHTML= message ; 
	}
}

function saveLoanInformationAndAddNewLoanInEdit(loanDataId, index) {
	loanDataId = loanDataId;
	$('#editLoanSuccessMessage'+index).empty();
	var companyIdValue = globalCompanyId;
	var userIdvalue = globalUserId;
	var isAvailble = true;
	var message = "Please enter the parameters::";
	count = index;
	var x = $("#elistOfLoanTypes" + index);
	if (x.options) {
		for (var i = 0; i < x.options.length; i++) {
			if (x.options[i].selected == true) {
				var loanTypesId = x.options[i].value;
			}
		}
	}
	if ($("#efhaNumber" + index).val().trim() == "") {
		isAvailble = false;
		message += "FHA Number, ";
	}
	if ($("#eloanAmount" + index).val().trim() == "") {
		isAvailble = false;
		message += "Loan Amount, ";
	}
	if ($("#elenderName" + index).val().trim() == "") {
		isAvailble = false;
		message += "Lender Name, ";
	}
	if ($("#eendDate" + index).val().trim() == "") {
		isAvailble = false;
		message += "Closing Date,";
	}
	if (loanTypesId == "Select Loan Type" || loanTypesId == "") {
		isAvailble = false;
		message += "Loan Type ,";
	}
	if ($("#eloanAmount" + index).val() == "$0"
			|| $("#eloanAmount" + index).val() == "$0.00") {
		isAvailble = false;
		message += "Loan amount should be greater than $0 ,";
	}

	if (new Date($("#eendDate" + index).val()).getTime() > new Date($(
			"#eterminationDate" + index).val()).getTime()) {
		isAvailble = false;
		message += "Termination date should be greater than Closing Date";
	} else if (new Date($("#eendDate" + index).val()).getTime() < new Date($(
			"#eterminationDate" + index).val()).getTime()) {

	} else {
	}

	if (isAvailble == true) {

		var updateLoanData = {
			"companyId" : parseInt(globalCompanyId),
			"propertyId" : parseInt(globalPId),
			"loanTypeId" : parseInt($(
					'#elistOfLoanTypes' + index + ' :selected').val()),
			"fhaNumber" : $("#efhaNumber" + index).val(),
			"loanAmount" : $("#eloanAmount" + index).val(),
			"lenderName" : $("#elenderName" + index).val(),
			"closingDate" : $("#eendDate" + index).val(),
			"userId" : globalUserId,
			"loanDataId" : loanDataId,
			"terminationDate" : $("#eterminationDate" + index).val()
		};
		document.getElementById("textErrEditLoan" + count).innerHTML = "";

		$.ajax({
					type : "PUT",
					contentType : "application/json",
					url : globalRestUrl + "/orcf/updateLoanDataInfo",
					dataType : 'json',
					timeout : 100000,
					data : JSON.stringify(updateLoanData),
					success : function(data) {
						console.log("Success:" + JSON.stringify(data));
						if (data.key == 200) {
							// loanDataObject = data;
							// add new form
							$('#btnEdit').hide();
							$("#editLoanSuccessMessage" + index).append("<i class='zmdi_medium zmdi-check'></i> <span style='padding-left: 8px;'> Loan Details Updated Successfully </span></h4>");
							$("#editLoanSuccessMessage" + index).fadeIn(5000);
							$('#editLoanSuccessMessage'+index).fadeOut(3000);
							$("#button2").attr('value', 'Update');
							var div = $("<div />");
							div
									.html(GetDynamicTextBoxForEdit((parseInt(index) + 1)));
							$("#LoanEditTextBoxContainer").append(div);
							/* ---sdf-sd-fsd-f */
							$
									.ajax({
										type : "GET",
										contentType : "application/json",
										url : globalRestUrl
												+ "/orcf/getLoanTypes?companyId="
												+ globalCompanyId,
										dataType : 'json',
										timeout : 100000,
										success : function(data) {
											// $('#elistOfLoanTypes'+index+'
											// :selected').val()
											// alert(index+"----"+JSON.stringify(data)+"===="+$("#elistOfLoanTypes"+(index+1)).val());
											for (i = 0; i < data.response.length; i++) {
												$(
														"#elistOfLoanTypes"
																+ (parseInt(index) + 1))
														.append(
																"<option value='"
																		+ data.response[i].loanTypeId
																		+ "'>"
																		+ "<b>"
																		+ data.response[i].loanType
																		+ "</b></option>");
												console.log()
											}
										},
										error : function(e) {
											console.log("ERROR: ", e);
										},
										done : function(e) {
											console.log("DONE");
										}
									});

						}
					},
					error : function(e) {
						console.log("ERROR: ", e);
					},
					done : function(e) {
						console.log("DONE");
					}
				});

	} else {
		if (message.substring(message.length - 1) == ',') {
			message = message.substring(0, message.length - 1);
		}
		document.getElementById("textErrEditLoan" + count).innerHTML = message;
	}
}

var globalLoanFlag = false;
function addNewLoanInformationInEdit(index, newLoan) {
	var count = index;
	// alert(count+'addNewLoanInformationInEdit');
	$('#editLoanSuccessMessage'+ count).empty();
	var companyIdValue = globalCompanyId;
	var userIdvalue = globalUserId;
	var isAvailble = true;

	var message = "Please enter the parameters::";
	var x = document.getElementById("elistOfLoanTypes" + count);
	for (var i = 0; i < x.options.length; i++) {
		if (x.options[i].selected == true) {
			var loanTypesId = x.options[i].value;
		}
	}
	if ($("#efhaNumber" + count).val().trim() == "") {
		isAvailble = false;
		message += "FHA Number, ";
	}
	if ($("#eloanAmount" + count).val().trim() == "") {
		isAvailble = false;
		message += "Loan Amount, ";
	}
	if ($("#elenderName" + count).val().trim() == "") {
		isAvailble = false;
		message += "Lender Name, ";
	}
	if ($("#eendDate" + count).val().trim() == "") {
		isAvailble = false;
		message += "Closing Date,";
	}
	if (loanTypesId == "Select Loan Type" || loanTypesId == "") {
		isAvailble = false;
		message += "Loan Type ,";
	}

	if (isAvailble == true) {
		var testData = {
			"companyId" : companyIdValue,
			"propertyId" : parseInt(globalPId),
			"loanTypeId" : parseInt(loanTypesId),
			"fhaNumber" : $("#efhaNumber" + count).val(),
			"loanAmount" : $("#eloanAmount" + count).val(),
			"lenderName" : $("#elenderName" + count).val(),
			"closingDate" : $("#eendDate" + count).val(),
			"userId" : userIdvalue,
			"terminationDate" : $("#eterminationDate" + count).val()
		};
		
		document.getElementById("loanError" + count).innerHTML  = "";

		$.ajax({
					type : "POST",
					contentType : "application/json",
					url : globalRestUrl + "/orcf/addLoanInfo",
					dataType : 'json',
					timeout : 100000,
					data : JSON.stringify(testData),
					success : function(data) {

						if (data.key == 200) {
							$("#resetButton" + count).hide();
							globalLoanFlag = true;
							$("#editLoanSuccessMessage" + count).append("<i class='zmdi_medium zmdi-check'></i> <span style='padding-left: 8px;'> Loan Details Added Successfully </span></h4>");
							$("#editLoanSuccessMessage" + count).fadeIn(5000);
							$('#editLoanSuccessMessage'+ count).fadeOut(3000);
							//$("#editLoanSuccessMessage" + count).append("");
							if (newLoan) {
								$("#btnAdd" + count).hide();
								$("#btnSave" + count).val('Update');
								var div = $("<div />");
								div.html(GetDynamicTextBoxForEdit(""));
								$("#LoanEditTextBoxContainer").append(div);

								$
										.ajax({
											type : "GET",
											contentType : "application/json",
											url : globalRestUrl
													+ "/orcf/getLoanTypes?companyId="
													+ globalCompanyId,
											dataType : 'json',
											timeout : 100000,
											success : function(data) {

												for (i = 0; i < data.response.length; i++) {
													$(
															"#elistOfLoanTypes"
																	+ (count + 1))
															.append(
																	"<option value='"
																			+ data.response[i].loanTypeId
																			+ "'><b>"
																			+ data.response[i].loanType
																			+ "</b></option>");
												}
											},
											error : function(e) {
												console.log("ERROR: ", e);
											},
											done : function(e) {
												console.log("DONE");
											}
										});
							}
						} else {
							$("#successLoanMessage" + count).hide();
							if (loanFlag != 100) {
								var loanChangeMsg = "Please Change the FHA Number";
								document.getElementById("changeLoanMessage"
										+ count).innerHTML = loanChangeMsg;
								$('#changeLoanMessage' + count).delay(2000)
										.fadeOut();
							}
							$("#disabletrdynamic" + count).show();

							loanFlag = 0;
						}
					},
					error : function(e) {
						console.log("ERROR: ", e);
					},
					done : function(e) {
						console.log("DONE");
					}
				});
	} else {
		/* if(message.endsWith(",")){ */
		if (message.substring(message.length - 1) == ',') {
			message = message.substring(0, message.length - 1);
		}
		document.getElementById("loanError" + count).innerHTML = message;
	}

}

/*
 * function addNewLoanInformationInEdit(index){ // debugger; var count = index;
 * //alert(count+'addNewLoanInformationInEdit'); var companyIdValue=
 * globalCompanyId; var userIdvalue= globalUserId; var isAvailble = true;
 * 
 * $("#editLoanSuccessMessage"+index).hide(); var message="Please enter the
 * parameters::"; var x=document.getElementById("elistOfLoanTypes"+count); for
 * (var i = 0; i < x.options.length; i++) { if(x.options[i].selected ==true){
 * var loanTypesId=x.options[i].value; } }
 * if($("#efhaNumber"+count).val().trim()==""){ isAvailble= false; message +=
 * "FHA Number, "; } if($("#eloanAmount"+count).val().trim()==""){ isAvailble=
 * false; message += "Loan Amount, "; }
 * if($("#elenderName"+count).val().trim()==""){ isAvailble= false; message +=
 * "Lender Name, "; } if($("#eendDate"+count).val().trim()==""){ isAvailble=
 * false; message += "Closing Date,"; } if(loanTypesId=="Select Loan Type" ||
 * loanTypesId==""){ isAvailble= false; message += "Loan Type ,"; }
 * 
 * 
 * if(isAvailble == true){ var testData={ "companyId":companyIdValue,
 * "propertyId":parseInt(globalPId), "loanTypeId":parseInt(loanTypesId),
 * "fhaNumber":$("#efhaNumber"+count).val(),
 * "loanAmount":$("#eloanAmount"+count).val(),
 * "lenderName":$("#elenderName"+count).val(),
 * "closingDate":$("#eendDate"+count).val(), "userId":userIdvalue };
 * 
 * 
 * $.ajax({ type : "POST", contentType : "application/json", url :
 * globalRestUrl+"/orcf/addLoanInfo", dataType : 'json', timeout : 100000, data :
 * JSON.stringify(testData), success : function(data) { if(data.key==200){
 * $("#btnAdd").hide(); $("#editLoanSuccessMessage"+count).append("<i
 * class='zmdi_medium zmdi-check'></i> <span style='padding-left: 8px;'> Loan
 * Details Updated Successfully </span></h4>"); var div = $("<div />");
 * div.html(GetDynamicTextBoxForEdit(""));
 * $("#LoanEditTextBoxContainer").append(div);
 * 
 * $.ajax({ type : "GET", contentType : "application/json", url :
 * globalRestUrl+"/orcf/getLoanTypes?companyId="+companyIdValue, dataType :
 * 'json', timeout : 100000, success : function(data) { alert(count+"-----");
 * for(i=0;i<data.response.length;i++){ $("#elistOfLoanTypes"+count).append("<option
 * value='"+data.response[i].loanTypeId+"'><b>"+data.response[i].loanType+"</b></option>"); } },
 * error : function(e) { console.log("ERROR: ", e); }, done : function(e) {
 * console.log("DONE"); } });
 * 
 * 
 * }else{ $("#successLoanMessage"+count).hide(); if(loanFlag != 100){ var
 * loanChangeMsg="Please Change the FHA Number";
 * document.getElementById("changeLoanMessage"+count).innerHTML = loanChangeMsg ; }
 * $("#disabletrdynamic"+count).show();
 * 
 * loanFlag=0; } }, error : function(e) { console.log("ERROR: ", e); }, done :
 * function(e) { console.log("DONE"); } }); }else{ if(message.endsWith(",")){
 * message = message.substring(0, message.length - 1); }
 * document.getElementById("loanError"+count).innerHTML = message ; }
 *  }
 */

function GetDynamicTextBoxForEdit(value) {

	count++;

	return '<div  id="dynamicDiv'
			+ count
			+ '" style="border-top:1px solid #000;margin-bottom:15px;margin-top:15px;"></div>'
			+ '<div  id="dynamicDiv1'
			+ count
			+ '" style="text-align:center;font-family: Geneva,Arial,Helvetica,roboto !important;color: green;font-size: 16px;">Loan Information</div>'
			+ '<input name = "DynamicTextBox" type="hidden" value = "'
			+ value
			+ '" />&nbsp;'
			+ '<input type="hidden" value="Remove" class="remove" />'
			+ "<div style='text-align: center;' id='editloanUpdateSuccess"
			+ count
			+ "'>"
			+ "<h4 style='color: rgb(0, 128, 0);  padding: 8px; margin-bottom: 20px;' id='editLoanSuccessMessage"
			+ count
			+ "'></h4>"
			+ "</div>"
			+ '<div style="text-align:center;" id="changeMessage'
			+ count
			+ '">'
			+ ' <span id="changeLoanMessage'
			+ count
			+ '" style="color: red;"></span>'
			+ ' </div>'
			+ '<div style="text-align:center;" id="tagscloud'
			+ count
			+ '">'
			+ ' <span id="loanError'
			+ count
			+ '" style="color: red;"></span>'
			+ ' </div>'
			+ '<table id="dynamicTable'
			+ count
			+ '"   class="table loanTable" cellspacing="0">'
			+ ' <tbody>'
			+ ' <tr>'
			+ ' <td class="wisth200">Associated FHA Number <span class="requiredStar">*</span></td>'
			+ '<td colspan="3"> <span id="textMsg'
			+ count
			+ '" style="color: red;margin-left: 10px;"></span><br>'
			+ '  <input size="50" class="tableInputselectStyle123 loanStyle" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="efhaNumber'
			+ count
			+ '" name="propertyId"  value="" maxlength="150"  onkeyup="duplicateFhanumberCheck('
			+ count
			+ ',false)"><br/>'
			+ '</td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td class="wisth200">Loan Type<span class="requiredStar">*</span></td>'
			+ ' <td>'
			+ '<select id="elistOfLoanTypes'
			+ count
			+ '" class="tableInputselectStyle123  selectLoanTypeclass loanStyle">'
			+ ' <option value="">Select Loan Type</option>'
			+ ' </select>'
			+ '</td> '
			+ '</tr>'
			+ '<tr>'
			+ ' <td class="wisth200">Loan Amount<span class="requiredStar">*</span></td>'
			+ '<td colspan="3">'
			+ '<input size="50"  maxlength="15" class="tableInputselectStyle123 form-control currency loanStyle" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="eloanAmount'
			+ count
			+ '" name="city" value="" >'
			+ '</td>'
			+ '</tr>'
			+ '<tr>'
			+ ' <td class="wisth200">Lender Name<span class="requiredStar">*</span></td>'
			+ ' <td colspan="3">'
			+ '  <input size="50"  class="tableInputselectStyle123 loanStyle" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);" type="text" id="elenderName'
			+ count
			+ '" name="city" value="">'
			+ '</td>'
			+ '</tr>'
			+ '<tr>'
			+ ' <td class="wisth200">Closing Date <span class="requiredStar">*</span></td>'
			+ ' <td>'
			+ ' <input id="eendDate'
			+ count
			+ '"  type="text" class="form-control tableInputselectStyle123 loanStyle endDate col-sm-12 inputStyle1" placeholder="Closing Date" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"  >'
			+ '</td>'
			+ '  </tr>'

			+ '<tr>'
			+ ' <td class="wisth200">Termination Date <span class="requiredStar"></span></td>'
			+ ' <td>'
			+ ' <input id="eterminationDate'
			+ count
			+ '"  type="text" class="form-control tableInputselectStyle123 loanStyle endDate col-sm-12 inputStyle1" placeholder="Termination Date" style="box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.3);"  >'
			+ '</td>'
			+ '  </tr>'

			+ '<tr id="disabletrdynamic'
			+ count
			+ '">'
			+ ' <td></td>'
			+ '<td>'
			+ '<input name="button2" id="btnSave'
			+ count
			+ '" class="btn btn-success waves-effect waves-button waves-float" style="margin-left: 20px;" type="button" value="Save" onClick ="addNewLoanInformationInEdit('
			+ count
			+ ',false)">'
			+ '<input name="button2" id="btnAdd'
			+ count
			+ '" class="btn btn-success waves-effect waves-button waves-float" style="margin-left: 15px;" type="button" value="Save & Add a New Loan"  onClick ="addNewLoanInformationInEdit('
			+ count
			+ ',true)">'
			+ '<input name="button" id="resetButton'
			+ count
			+ '" class="btn btn-warning waves-effect waves-button waves-float" style="margin-left: 15px;" type="button" value="Reset" onclick="resetLoanInformation('
			+ count + ')" > ' + '</td>' +

			'</tr>' + '</tbody>' + '</table>'
}

function getData(stateCode, propertyTypeId) {

	/* To get the list of states */
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : globalRestUrl + "/orcf/getStates",
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			for (i = 0; i < data.response.length; i++) {
				if (stateCode == data.response[i].stateCode) {
					$("#elistStates").append(
							"<option selected value='"
									+ data.response[i].stateCode + "'><b>"
									+ data.response[i].stateName
									+ "</b></option>");
				} else {
					$("#elistStates").append(
							"<option value='" + data.response[i].stateCode
									+ "'><b>" + data.response[i].stateName
									+ "</b></option>");
				}
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayModules(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});

	// to get the list of property type
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : globalRestUrl + "/orcf/getPropertyTypes?companyId="
				+ globalCompanyId,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			for (i = 0; i < data.response.length; i++) {
				if (propertyTypeId == data.response[i].propertyTypeId) {
					$("#elstFruits345").append(
							"<option selected value='"
									+ data.response[i].propertyTypeId + "'><b>"
									+ data.response[i].propertyType
									+ "</b></option>");
				} else {

					$("#elstFruits345").append(
							"<option value='" + data.response[i].propertyTypeId
									+ "'><b>" + data.response[i].propertyType
									+ "</b></option>");
				}
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayModules(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}
