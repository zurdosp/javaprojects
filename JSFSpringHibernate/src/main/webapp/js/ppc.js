
function show_popup() {
	PF('dlg').show();
	window.setTimeout( hide_popup('dlg'), 2000 );
}

function hide_popup(idElement) {
	PF(idElement).hide();
}

function submitRequest() {
	//PF('dlg').hide();
	PF('msgWait').show();
}

function handleLoginRequest(xhr, status, args) {
	PF('msgWait').hide();
	if (args.validationFailed) {
		PF('msgErrorUserPass').show();
		PF('dlg').jq.effect("shake", {
			times : 5
		}, 100);
	} else {
		PF('dlg').hide();
		$('#loginLink').fadeOut();
	}
}

