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
	}
	xhr.open("GET", "login.view");
	xhr.send();
	
}