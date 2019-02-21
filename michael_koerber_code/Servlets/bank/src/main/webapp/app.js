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
		}
	}
	xhr.open("GET", "login.view");
	xhr.send();
	
}

function logIn(){
    var user = {
        username: $('#username').val(), 
        password: $('#pw').val()};
    var json = JSON.stringify(user);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                //logged in successfully
              $('#view').html(xhr.responseText);    
            }
            else if(xhr.status == 418){
                //encountered known problem (wrong password/user not in system)
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