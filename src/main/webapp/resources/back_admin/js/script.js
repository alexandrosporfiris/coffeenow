var currentUrl = window.location.href;
var mainModal = $("#logoutModal"); // main modal for messages
var toolsSidebar = $("#newOrUpdateItemCardCFN"); // form container
var toolsSidebarSwitch = $("#newOrUpdateItemCardCFN .switch");
var actionLayer = $("#actionLayer-98");

// fix language redirect url, which cannot work correctly because of base meta tag
function languageUri(param){
	
	// remove any query params
	if ( currentUrl.indexOf("?") ) {
		let urlParts = currentUrl.split("?");
		currentUrl = urlParts[0];
	}
	
	// check for slash at the end and remove it
	if (currentUrl.charAt(currentUrl.length - 1) == "/") 
		currentUrl = currentUrl.substr(0, currentUrl.length - 1);
	
	// add clicked link href to final url
	currentUrl = currentUrl + param;
	
	window.location = currentUrl;
	
}

// function to ask user yes or no with a modal for an action
function yesNo(
	yesUrl, 
	openModal = false, 
	headerMessage = "", 
	bodyMessage = language_JSON[locale]["areYouSure"], 
	yesButtonText = language_JSON[locale]["yes"], 
	noButtonText = language_JSON[locale]["no"]
)
{
	mainModal.find(".modal-content")
	.html(
		'<div class="modal-header"><h5 class="modal-title" id="logoutModalLabel">'
		+ headerMessage +
		'</h5><button class="close" type="button" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div><div class="modal-body">'
		+ bodyMessage +
		'</div><div class="modal-footer"><form id="yesNoFormCFN" action="'
		+ yesUrl +
		'"><button type="button" class="btn btn-danger yes"><span class="text-white">'
		+ yesButtonText +
		'</span></button><button type="button" class="btn btn-primary no"><span class="text-white">'
		+ noButtonText +
		'</span></button></form></div>'
	);
	if ( openModal ) mainModal.modal('show');
}

// function for general purpose modal messages
function inform(message, openModal = true){
	mainModal.find(".modal-content")
	.html(
		'<div class="modal-header"><h5 class="modal-title" id="logoutModalLabel">'
		+ language_JSON[locale]["attention"] +
		'</h5><button class="close" type="button" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div><div class="modal-body">'
		+ message +
		'</div><div class="modal-footer"><form id="yesNoFormCFN"><button type="button" class="btn btn-primary no"><span class="text-white">'
		+ language_JSON[locale]["close"] +
		'</span></button></form></div>'
	);
	if ( openModal ) mainModal.modal('show');
}

// handling yes click of a yesNoFormCFN, generated by function yesNo
$(document).on("click", "#yesNoFormCFN .yes", function(e){
	$("#yesNoFormCFN").submit();
});
// handling no click of a yesNoFormCFN, generated by function yesNo
$(document).on("click", "#yesNoFormCFN .no", function(e){
	mainModal.modal('hide');
	$("#yesNoFormCFN").remove();
});

// injecting logout form in modal on click
$(document).on("click", "#userMenuLogoutCNF", function(e){
	
	e.preventDefault;
	yesNo(
		$(this).attr("href"), 
		false, 
		language_JSON[locale]["logoutAsk"],
		language_JSON[locale]["logoutInfo"],
		language_JSON[locale]["logout"],
		language_JSON[locale]["cancel"]
	)
	
});

// handle the clicking of the "open/close tools sidebar"
$(document).on("click", "#newOrUpdateItemCardCFN .switch", function(e){
	if ( toolsSidebar.hasClass("expandedCFN") ) {
		actionLayer.trigger("click");
	}
	else {
		actionLayer.removeClass("hidden");
		toolsSidebar.addClass("expandedCFN");
	}
});

$(document).ready(function() {
	// init multi select dropdowns
	$('.multipleSelectCFN_JS').multiselect({
		buttonClass: 'btn btn-secondary btn-sm',
		maxHeight: 200,
		includeSelectAllOption: true,
		enableFiltering: true,
		numberDisplayed : 3,
		enableCaseInsensitiveFiltering: true
	});
});

// windows has loaded, remove loader
$(window).on('load', function(){
	$("#contentPreLoaderCFN").remove();
});