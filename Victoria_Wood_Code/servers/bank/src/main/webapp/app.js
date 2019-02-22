window.onload = function(){
	console.log("Loaded App");
	loadLoginView();
}

function loadLoginView(){
	//retrieve login.html partial and replace view with it
	//then add event listeners for functionality
	
	//send request using AJAX
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			$('#view').html(xhr.responseText);
			$('#goToSubmit').on('click', loadRegisterView);
			$('#logIn').on('click', logIn)
		}
	}
	
	xhr.open("GET", "login.view");
	xhr.send();
}

function loadRegisterView(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			$('#view').html(xhr.responseText);
			$('#goToLogin').on('click', loadLoginView);
		}
	}
	
	xhr.open("GET", "register.view");
	xhr.send();
}

function logIn(){
	var user = {
			username : $('#username').val(),
			password : $('#pass').val()
	};
	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			var u = JSON.parse(xhr.responseText);
			console.log(u)
			if(u == null){
				alert("Wrong Username or Password");
				// can create hidden message that shows when username/pwd is incorrect
			} else{
				loadUserHome();
			}
		}
	}
	
	xhr.open("POST", "login");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);
}

function loadUserHome() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		$('#view').html(xhr.responseText);
	}
	xhr.open("GET", "home.view");
	xhr.send();
}