window.onload = function(){
   loadLoginView();
}

function loadLoginView(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
            $('#goToSubmit').on('click', loadRegisterView);
            $('#logIn').on('click', logIn);
        }   
    }
    xhr.open("GET", "partials/logIn.html");
    xhr.send();
}

function loadRegisterView(){
    //function to load view to add new user
    console.log("load register view function");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
        	$('#addUser').on('click', addUser);
            $('#goToLogin').on('click', loadLoginView);
        }   
    }
    xhr.open("GET", "partials/register.html");
    xhr.send();
}

function logIn(){
    var user = {
        username: $('#username').val(), 
        password: $('#password').val()};
    var json = JSON.stringify(user);
	
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                //logged in successfully
            	$('#view').html(xhr.responseText);
            }
            else if(xhr.status == 409){
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

function addUser(){
	console.log("clicked");
	if($('#roleId').attr('checked'))
	{
		var user = {
	        username: $('#username').val(), 
	        password: $('#password').val(),
	        firstName: $('firstName').val(),
	        lastName: $('lastName').val(),
	        email: $('#email').val(),
	        roleId: 1
		};
	}
	else
	{
		var user = {
		        username: $('#username').val(), 
		        password: $('#password').val(),
		        firstName: $('#firstName').val(),
		        lastName: $('#lastName').val(),
		        email: $('#email').val(),
		        roleId: 0
			};
	}
	    var json = JSON.stringify(user);

	    var xhr = new XMLHttpRequest();
	    xhr.onreadystatechange = function(){
	        if(xhr.readyState == 4){
	            if(xhr.status == 201){
	                //logged in successfully
	            	$('#view').html(xhr.responseText);
	            }
	            else if(xhr.status == 409){
	                //failed to log in
	            	$('#view').html(xhr.responseText);
	            }
	            else{
	                //some other error, likely send to error page
	            }
	        }
	    }
	    xhr.open("POST", "registerUser");
	    xhr.setRequestHeader("Content-type", "application/json");
	    xhr.send(json);
}