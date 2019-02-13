window.onload = function(){
	loadLogInView();
}

function logIn(){
    //function to log user in 
}

function loadRegisterView(){
    //function to load view to add new user
    console.log("load register view function");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
        }   
    }
    xhr.open("GET", "register.view");
    xhr.send();
}

function loadLogInView(){
	console.log("load login view");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		    $('#goToSubmit').on('click', loadRegisterView);
		}
	}
	xhr.open("GET", "login.view");
	xhr.send();
}