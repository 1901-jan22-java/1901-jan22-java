window.onload = function() {
    loadLoginView();
}

function loadLoginView(){
    let xhr = new XMLHttpRequest;
    xhr.onreadystatechange = function(){
        if (xhr.readyState = 4){
            $('#view').html(xhr.responseText);
            $('#gotosubmit').on('click', loadRegisterView);
            $('#createUser').on('click', loadRegisterView);
            $('#login').on('click', login);
        }
    }
    xhr.open('GET', 'login.view');
    xhr.send();
}

function loadRegisterView(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            $('#view').html(xhr.responseText);
            $('#gotoreg').on('click', loadLoginView);
            $('#gologin').on('click', loadLoginView);
            //$('#register').on('click', register);
        }
    }
    xhr.open('GET', 'register.view');
    xhr.send();
}

function login(){
    let user = {
        username: $('#username').val(),
        password: $('#pass').val(),
    };

    let json = JSON.stringify(user);
    console.log(json);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            if (xhr.status == 200) {
                console.log(xhr.responseText);
                $('#view').html(xhr.responseText);
                //loadHomeData(1);
            }
            else if (xhr.status == 406) {
                console.log("Invalid Login");
            } else {
                console.log("Invalid Password");
            }
        }
    }
    xhr.open('POST', 'login');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(json);
}