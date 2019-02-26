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
			$('#login').on('click', login);
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
function login(){
	var name = $('#username').val();
	var pass = $('#pass').val();
	var user = {
			username: name,
			password: pass
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			//received login response.
			var user = JSON.parse(xhr.responseText);
			console.log(user);
			if(user == null){
				//invalid creds
				$('#message').html('<i>Invalid credentials... please try again</i>');
				$('#message').removeAttr('hidden');
				
			}
			else{
				goHome();
			}
		}
	}
	xhr.open("POST", "login");
	xhr.send(JSON.stringify(user));
}


function goHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status==200){
				$('#view').html(xhr.responseText);
			}
		}
	}
	xhr.open("GET", "home");
	xhr.send();
}