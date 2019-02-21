window.onload = function(){
	console.log("Loaded app");
	loadLoginView();
	
}

function loadLoginView(){
	//retrieve login.html partial and replace #view with it
	//then add event listeners for functionality 
	
	//send request using AJAX
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//only place to deal with response
		if(xhr.readyState == 4){
			$('#view').html(xhr.responseText);
			$('#createUser').on('click', loadRegisterView);
		}
	}
	xhr.open("GET", "login.view");
	xhr.send();
	
}

function loadRegisterView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//only place to deal with response
		if(xhr.readyState == 4){
			$('#view').html(xhr.responseText);
			$('#goToLogin').on('click', loadLoginView);
		}
	}
	xhr.open("GET", "register.view");
	xhr.send();
}