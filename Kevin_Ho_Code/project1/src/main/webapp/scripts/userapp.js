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
            	loadHomeView(xhr.responseText);
            	$('#addReimb').on('click', addReimb);
            }
            else if(xhr.status == 201){
            	loadManagerView(xhr.responseText);
            	$('#addReimb').on('click', addReimb);
//            	$('#resolveReimb').on('click', resolve);
            }
            else if(xhr.status == 409){
                //encountered known problem (wrong password/user not in system)
                console.log(xhr.responseText);
                $('#error').html("Wrong login!!");
                $('#error').css('color', 'red');
            }
            else{
                //some other error, likely send to error page
                $('#error').html("What in gods name did you do");            	
            }
        }
    }
    xhr.open("POST", "logIn");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function loadHomeView(user){
	console.log("home view");
	var info = JSON.parse(user);
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
            $('#name').html($(info.firstName)+" "+$(info.lastName));
        	$('#addReimb').on('click', loadAddReimbView);
        }
    }
    xhr.open("GET", "partials/home.html");
    xhr.send();
}

function loadManagerView(user){
	console.log("manager view");
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
        	$('#addReimb').on('click', loadAddReimbView);
        	$('#resolve').on('click', resolve);
        }
    }
    xhr.open("GET", "partials/homeManager.html");
    xhr.send();
}

function loadAddReimbView(){
    console.log("load reimb view function");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
        	$('#addReimb').on('click', addReimb);
            $('#goToHome').on('click', loadHomeView);
        }   
    }
    xhr.open("GET", "partials/reimbRegister.html");
    xhr.send();
}


function addReimb(){
	var reimb = {
			amount: $('amount'),
			description: $('description'),
			author: $('author'),
			typeId: $('typeId')
		};

    var json = JSON.stringify(reimb);
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
            	alert("im gay");
            }
        }
    }
    xhr.open("POST", "addReimb");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function addUser(){
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
	            	alert("lamseaoiwme");
	            }
	        }
	    }
	    xhr.open("POST", "registerUser");
	    xhr.setRequestHeader("Content-type", "application/json");
	    xhr.send(json);
}