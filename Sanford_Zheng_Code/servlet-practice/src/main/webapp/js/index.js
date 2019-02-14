window.onload = function () {
    loadLoginView();
};

function loadRegisterView() {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            console.log("I made it");
            if (this.status > 199 && this.status < 300) {
                $('#view').html(xhr.responseText);
                $('#register').click(registerUser());
                $('#goToLogin').click(loadLoginView());
            } else {
                // ERROR HERE!
            }
        }
    }

    xhr.open("GET", "register.view");
    xhr.send();
}

function loadLoginView() {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            if (this.status > 199 && this.status < 300) {
                $('#view').html(xhr.responseText);
                $('#login').click(loginUser());
                $('#goToRegister').click(loadRegisterView());
            } else {
                // ERROR HERE!
            }
        }
    }

    xhr.open("GET", "login.view");
    xhr.send();
}

function registerUser() {
    var user = JSON.stringify({
        username: $('#username').val(),
        password: $("#password").val(),
        data: $("#bio").val()
    })
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            if (this.status > 199 && this.status < 300) {
                loadLoginView();
            } else {
                // REDIRECT TO ERROR HERE!
            }
        }
    }

    xhr.open("POST", "register");
    xhr.setRequestHeader("Content-type", "application/json")
    xhr.send(user);
}

function loginUser() {
    var user = JSON.stringify({
        username: $('#username').val(),
        password: $('#password').val()
    })
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            if (this.status > 199 && this.status < 300) {
                // REDIRECT TO UI HERE OR SOMETHING!
            } else {
                // REDIRECT TO ERROR HERE!
            }
        }
    }

    xhr.open("POST", "login");
    xhr.setRequestHeader("Content-type", "application/json")
    xhr.send(user);
}