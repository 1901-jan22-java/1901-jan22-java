window.onload = function() {
	$('#servlet').click(function() {
		// WHAT DO I DO!??
		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && status < 300 && status > 199) {
				var v = xhr.responseText;
				console.log(`Good job! ${v}`);
			}
		};

		xhr.open("GET", "http://localhost:8085/servlet-practice/world");
		xhr.send();
	});

	$('#getUsers').click(function() {
		// WHAT DO I DO!??
		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && status < 300 && status > 199) {
				var v = xhr.responseText;
				console.log(`Good job! ${v}`);
			}
		};

		xhr.open("GET", "users");
		xhr.send();
	});

	$('#addUser').click(function() {
		var user = {
				username: $('#username').val(),
				password: $('#password').val(),
				data: $('#bio').val()
		}
		var json = JSON.stringify(user);
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			console.log(this.readyState + " " + this.status);
			if(this.readyState == 4){
				if(xhr.status == 201){
					console.log(xhr.status);
					console.log(xhr.responseText);
				} else if( xhr.status == 409) {
					
				} else {
					
				}
			}
			
		};
		
		xhr.open("POST", "users");
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(json);
	});
}