
$.ajaxSetup ({
    // Disable caching of AJAX responses
    cache: false
});

/* envia o formulario informado. previne 'double submit' */
/* é necessário setar a variável global 'formIsSubmitted=false' no documento  */
function submitForm(idFormulario){

	if( !formIsSubmitted ){
		formIsSubmitted = true;
		document.getElementById(idFormulario).submit();
	} else {
		alert("Dados já enviados. Aguarde a resposta da solicitação.");
	}

}

function onlyDecimal(campo){
	
	var digits="0123456789,";  
	var campo_temp;
    for (var i=0;i<campo.value.length;i++){  
        campo_temp=campo.value.substring(i,i+1);
        
        if (digits.indexOf(campo_temp)==-1){  
            campo.value = campo.value.substring(0,i);  
        }
        
	    if( campo.value.indexOf(",") > 0 ){
	    	decimalPart = campo.value.substring( campo.value.indexOf(",")+1, campo.value.length );

	    	if( decimalPart.length > 2 ){
	    		campo.value = campo.value.substring(0, campo.value.length-1 );
	    	}
	    	
	    } 

    }
    
} 

function onlyNumbers(campo){
	
	var digits="0123456789";  
	var campo_temp;
    for (var i=0;i<campo.value.length;i++){  
        campo_temp=campo.value.substring(i,i+1);
        if (digits.indexOf(campo_temp)==-1){  
            campo.value = campo.value.substring(0,i);  
        }  
    }  	
}

/*limpa o formulario informado*/
/*diferente de RESET do form (que restaura o estado inicial)*/
/* tambem chama a funcao de limpar os erros ao final */

function clearForm(idFormulario) {

	var form = document.getElementById(idFormulario);
	var control, controls = form.elements;
	for ( var i = 0, iLen = controls.length; i < iLen; i++) {
		control = controls[i];
		// Don't change value of submit or reset or buttons
		if (control.type != 'submit' && control.type != 'reset' && control.type != 'button') {
			if (control.tagName.toLowerCase() == 'select') {
				for ( var j = 0, jLen = control.options.length; j < jLen; j++) {
					control.options[j].defaultSelected = false;
				}
			} else if (control.defaultChecked) {
				control.defaultChecked = false;
			} else if (control.name == 'id'){
				control.defaultValue = 0;
			} else {
				control.defaultValue = '';
			}
		}
	}

	// Now reset the form
	form.reset();

	//clear errors
	clearErrors();

}


/*limpa os erros dos formulários em todos os 'span' que tiverem 'error' em seu id*/
function clearErrors(){

  //clear errors
  var inputs = document.getElementsByTagName("span");
  for (x=0;x<=inputs.length;x++){
    myname = inputs[x].getAttribute("id");
    if(myname.indexOf("error") > -1){
    	remove(myname);
       }
  }
}
  /* funcoes para paginacao */
  /* passar o nome do formlario */
  
  function pageDown(actualPage, idFormulario){
		document.getElementById("pagina").value = actualPage - 1;
	document.getElementById(idFormulario).submit();
}

function pageUp(actualPage, idFormulario){
	document.getElementById("pagina").value = actualPage + 1;
	document.getElementById(idFormulario).submit();
}

/* retorna as chaves de um objeto javascript do tipo mapa */

function getKeys(obj){
    var keys = [];
    for(var key in obj){
        if(obj.hasOwnProperty(key)){
            keys.push(key);
        }
    }
    return keys;
}


/* troca o estado de todas as checkboxes do documento baseado no estado do elemento checkbox passado */
function toggleAllCheckBoxes(element){

	var allInputs = document.getElementsByTagName("input");
	for (var i = 0, max = allInputs.length; i < max; i++){
	    if (allInputs[i].type == 'checkbox'){
	    	allInputs[i].checked = element.checked;
	    }
	}
}

