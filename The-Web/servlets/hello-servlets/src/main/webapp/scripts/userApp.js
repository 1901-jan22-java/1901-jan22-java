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
    xhr.open("GET", "login.view");
    xhr.send();
}

function logIn(){
    var user = {
        username: $('#username').val(), 
        password: $('#password').val()};
    var json = JSON.stringify(user);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4)
        	if(xhr.status == 200){
        		console.log(xhr.responseText);
        		var user = JSON.parse();
        		alert(`Welcome, ${user.username}!!!!`);
        	}
        	else if(xhr.status == )
    }
    xhr.open("POST", "login");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);

}

function loadRegisterView(){
    //function to load view to add new user
    console.log("load register view function");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
            $('#goToLogin').on('click', loadLoginView);
        }   
    }
    xhr.open("GET", "register.view");
    xhr.send();
}
