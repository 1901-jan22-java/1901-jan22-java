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
			console.log("I'm here!");
			if(this.readystate == 4){
				console.log(xhr.status);
				console.log(xhr.responseText);
			}
			
		};
		
		xhr.open("POST", "users");
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(json);
	});
}