window.onload = function(){
	$('#goToSubmit').on('click', loadRegisterView);
	$('#logIn').on('click',logIn);
}

function logIn(){
	
}

function loadRegisterView(){
	console.log("Load register view function");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
        if(xhr.readyState==4 && xhr.status == 200){
        	$("#view").html(xhr.responseText);
        }
	}
	xhr.open("GET", "loadRegView");
	xhr.send();
}