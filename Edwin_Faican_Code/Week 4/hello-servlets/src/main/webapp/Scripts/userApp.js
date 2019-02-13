window.onload = function() {
	$('#login').on('click', login);
	$('#go-to-submit').on('click', loadRegisterView);
}

function login() {
	
}

function loadRegisterView() {
	var xhr = new XMLHttpRequest();
	var url = 'loadRegView';
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4 && xhr.status === 200) {
			$('#view').html(xhr.responseText);
			console.log("We have done it!");
		}
	}
	
	xhr.open('GET', url);
	xhr.send();
}