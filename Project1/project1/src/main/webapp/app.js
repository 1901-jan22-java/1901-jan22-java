window.onload = function(){
	console.log("Loaded app");
	loginView();
}

function loginView(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
            $('#login').on('click', logIn);
        }   
    }
    xhr.open("GET", "login.view");
    xhr.send();
}

function userView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "userHome.view");
	xhr.send();
}

function logIn(){
    var user = {
        username: $('#username').val(), 
        password: $('#pass').val()};
    var json = JSON.stringify(user);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                console.log("success")
              $('#view').html(userView);    
            }
            else if(xhr.status == 418){
                console.log(xhr.responseText);
                alert("Wrong login!");
            }
            else{
                //some other error, likely send to error page
            }
        }
    }
    xhr.open("POST", "login");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}