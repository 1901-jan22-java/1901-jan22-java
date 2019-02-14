window.onload = function() {
	loadLoginView();
}

function loadLoginView() {
	console.log('This is happening');
	var xhr = new XMLHttpRequest();
	var url = 'login.view';
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4 && xhr.status === 200) {
			$('#view').html(xhr.responseText);
			console.log("We have done it mates!");
			$('#login').on('click', login);
			$('#go-to-submit').on('click', loadRegisterView);
		}
	}
	
	xhr.open('GET', url);
	xhr.send();
	
}

function login() {
	var user = {
			username : $('#un').val(),
			password : $('#pw').val()
	};
	
	var json = JSON.stringify(user);
	
	
	var url = 'login';
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4) {
			if(xhr.status === 200) {
				$('#view').html(xhr.responseText);
				console.log('Successfully Found User!');
				console.log(xhr.status);
				console.log(xhr.responseText);
			} else if(xhr.status === 404){
				console.log('Username/Password is incorrect!');
			} else {
				console.log('Take to error page! We done goofed!');
			}	
		}
	}
	
	xhr.open('POST', url);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);
}

function loadRegisterView() {
	var xhr = new XMLHttpRequest();
	var url = 'register.view';
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4 && xhr.status === 200) {
			$('#view').html(xhr.responseText);
			$('#login').on('click', loadLoginView);
			console.log("We have done it!");
		}
	}
	
	xhr.open('GET', url);
	xhr.send();
}