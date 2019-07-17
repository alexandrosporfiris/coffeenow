var currentUrl = window.location.href;

// main modal for messages
var mainModal = $("#logoutModal");

// edit buttons for datatables
var editButton = $("#editMainTableRowCFN"),
	deleteButton = $("#deleteMainTableRowCFN"),
	newButton = $("#addMainTableRowCFN");

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

// function to ask user yes or no for a destructive action
function yesNo(url, message = ""){
	mainModal.find(".modal-content").html('<form id="yesNoFormCFN" action="'+url+'">'+((message == "")? language_JSON[locale]["areYouSure"] : message)+'<button class="btn btn-success btn-sm yes"><span class="text-white-50">'+language_JSON[locale]["yes"]+'</span></button><button class="btn btn-danger btn-sm no"><span class="text-white-50">'+language_JSON[locale]["no"]+'</span></button></form>');
	mainModal.modal('show');
}

$(document).ready(function() {
	
	// handling yes click of a yesNoFormCFN, generated by function yesNo
	$(document).on("click", "#yesNoFormCFN .yes", function(e){
		$("#yesNoFormCFN").submit();
	});
	
	// handling no click of a yesNoFormCFN, generated by function yesNo
	$(document).on("click", "#yesNoFormCFN .no", function(e){
		mainModal.modal('hide');
		$("#yesNoFormCFN").remove();
	});
	
	// productcategories/extrascategories DATATABLE	needs specific order of columns :
	// 1. id 
	// 2. parent id
	// 3. title
	// anything else after that
	var table = $('.dataTableCFN').DataTable({
		orderFixed: [1, 'asc'],
		select: {
			style: 'single'
		},
		info: false,
		responsive: true,
        rowGroup: {
			startRender: function ( rows, group ) {
				var ids = rows.data().pluck(0);
				var titles = rows.data().pluck(2);
				var title = "";
				var i = rows.data().length;
				for(i; i >= 0; i-- ){
					if( ids[i] == group ) title = titles[i];
				}
				return $('<tr/>')
                    .append( '<td colspan="'+rows.columns().count()+'">'+group+' - '+title+'</td>' );
			},
			endRender: null,
            dataSrc: 1
        },
		columnDefs: [
			{ responsivePriority: 1, targets: "titleHeaderCFN" }
		]
	});
	
	// ON DATATABLE ROW SELECT
	table.on( 'select', function( event, data, type, indexes ) {
		
		let selectedRow = table[ type ]( indexes ).nodes().to$();
		
		editButton.removeAttr("disabled");
		
		deleteButton.removeAttr("disabled");
		deleteButton.attr("onclick", "yesNo('administrator/dashboard/productcategories/delete/"+ selectedRow.find(".rowIdCFN").html() +"')");
		
		
	});
	
	// ON DATATABLE ROW DESELECT
	table.on( 'deselect', function( event, data, type, indexes ) {
		
		editButton.attr("disabled","");
		
		deleteButton.attr("disabled","");
		deleteButton.removeAttr("onclick");
		
	});
	
	// injecting logout form on click
	$(document).on("click", "#userMenuCNF", function(){
		mainModal.find(".modal-content").html('<div class="modal-header"><h5 class="modal-title" id="logoutModalLabel">'+ language_JSON[locale]["logoutAsk"] +'</h5><button class="close" type="button" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div><div class="modal-body">'+ language_JSON[locale]["logoutInfo"] +'</div><div class="modal-footer"><button class="btn btn-secondary" type="button" data-dismiss="modal">'+ language_JSON[locale]["cancel"] +'</button><a class="btn btn-primary" href="administrator/dashboard/logout">'+ language_JSON[locale]["logout"] +'</a></div>');
	});
	
});
