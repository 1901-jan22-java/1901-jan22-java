window.onload = function(){
	loadLoginView();
}

function loadLoginView(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
            $('#logIn').on('click', logIn);
        }   
    }
    xhr.open("GET", "login.view");
    xhr.send();
}

function logIn(){
    var user = {
        username: $('#username').val(), 
        password: $('#pw').val()};

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
              $('#view').html(xhr.responseText);    
            }
            else if(xhr.status == 418){
                console.log(xhr.responseText);
                alert("Wrong login!");
            }
            else{
                loadHomeView();
            }
        }
    }
    xhr.open("POST", "login");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);

}
function loadHomeView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		$('#view').html(xhr.responseText);
	}
	xhr.open("GET", "home.view");
	xhr.send();
}