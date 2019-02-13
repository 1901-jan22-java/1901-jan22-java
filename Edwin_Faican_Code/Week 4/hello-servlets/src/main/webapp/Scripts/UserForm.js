window.onload = function() {
	$('#addUser').on('click', newUser);
}


function newUser() {
	var user = {
			username : $('#username').val(),
			password : $('#password').val(),
			data : $('#bio').val()
	};
	
	var json = JSON.stringify(user);
	
	
	var url = 'users';
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4) {
			if(xhr.status === 201) {
				console.log('Successfully Added User!');
				console.log(xhr.status);
				console.log(xhr.responseText);
			} else if(xhr.status === 409){
				console.log('User already exists!');
			} else {
				console.log('Take to error page! We done goofed!');
			}	
		}
	}
	
	xhr.open('POST', url);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);
}
