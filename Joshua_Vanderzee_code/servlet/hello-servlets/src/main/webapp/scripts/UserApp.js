window.onload = function () {
    loadLogInView();
}

function loadRegisterView(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            $('#view').html(xhr.responseText);
            $('#gotoreg').on('click', loadLogInView);
            $('#register').on('click', register);
        }
    }
    xhr.open('GET', 'register.view');
    xhr.send();
}

function register(){

}

function loadLogInView(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            $('#view').html(xhr.responseText);
            $('#gotosubmit').on('click', loadRegisterView);
            $('#login').on('click', login);
        }
    }
    xhr.open('GET', 'login.view');
    xhr.send();
}

function login(){
    var user = {
        username: $('#username').val(),
        password: $('#pw').val(),

    };

    let json = JSON.stringify(user);

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            if (xhr.status == 200) {
                console.log("Logged in");
                let user = JSON.parse(xhr.responseText);
                alert(`Welcome ${user['username']}`);
            }
            else if (xhr.status == 418) {
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
