window.onload = function(){
	loadView();
}

function loadView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystate = function(){
		if(xhr.readyState==4 && xhr.status==200){
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "home");
	xhr.send();
}