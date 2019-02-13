window.onload = function(){
    $('#register').on('click', addUser);
    $('#uname').on('blur', isUnique);
    $('#logIn').on('click', logIn);
}

var logIn = () => {
    var username = $('#unamelog').val();
    var password = $('#passLog').val();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            var user = JSON.parse(xhr.responseText);
            if(user.length = 0){
                alert("Invalid Credentials");
            } else {
                var logged = user[0];
                if(logged.password == password){
                    alert("Welcome " + logged.firstname);
                    displayUserAccounts(logged);
                } else {
                    alert("Invalid Credentials");
                }
            }
        }
        xhr.open("GET", `http://localhost:3000/users?username=${username}`);
        xhr.send();
    }
}

var displayUserAccounts = (user) => {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            console.log(xhr.status + ": " + xhr.statusText);
            console.log(xhr.getAllResponseHeaders);
            var accounts = JSON.parse(xhr.responseText);

            if(accounts.length == 0){
                $('body').html(`Hey ${user.firsname}, you don't have any accounts! Let's change that.`);
            } else {
                var text = `You have ${accounts.length} accounts:`
                for(let a of accounts){
                    text += `<br>Account no.${a.id} has a balance of ${a.balance}`
                }
                $('body').html(text);
            }
        }
    }
    xhr.open("GET", `http://localhost:3000/accounts?userId=${user.id}`);
    xhr.send();
}

var addUser = () => {
    var fn = $('#fn').val();
    var ln = $('#ln').val();
    var un = $('#uname').val();
    var pw = $('#pass').val();

    var user = {
        firstname: fn,
        lastname: ln,
        username: un,
        password: pw    
    }

    var json = JSON.stringify(user);
    console.log(user);
    console.log(json);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            console.log(xhr.status);
            console.log(xhr.responseText);
        }
    }

    xhr.open("POST", "http://localhost:3000/users");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function getByUsername(uname){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){

    }
    xhr.open("GET", `http://localhost:3000/users?username=${uname}`);
    xhr.send();
}

function isUnique(){
    var uname = $('#uname').val();
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            var user = JSON.parse(xhr.responseText);
            if(user.length != 0){
                $('#register').attr('disabled', 'true');
                alert("Sorry username is taken, try again");
            } else {
                $('#register').removeAttr('disabled');
            }
        }
    }
    xhr.open("GET", `http://localhost:3000/users?username=${uname}`);
    xhr.send();
}
