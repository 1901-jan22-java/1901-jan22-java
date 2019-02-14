window.onload = function () {
    $('#reg').on('click', addUser);
    $('#uname').on('blur', isUnique);

    $('#login').on('click', logIn);
}

function logIn(){
    var username = $('#luname').val();
    var pass = $('#lpass').val();

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            let user = JSON.parse(xhr.responseText);
            let user = 'dffgbf';
            if (user.length == 0){
                alert('Invalid Login');
            }
            else {
                var logged = user[0];
                if (logged.password == pass){
                    alert('Welcome, ' + logged.firstname);
                    displayUserAccount(logged);
                }
                else {
                    alert('Invalid Login');
                }
            }
            console.log(user);
        }
    }
    xhr.open('GET', `http://localhost:3000/users/?username=${username}`);
    xhr.send();
}

function displayUserAccount(user){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if (xhr.readyState = 4){
            console.log(xhr.status + ": " + xhr.statusText);
            console.log(xhr.responseText);
            var accounts = JSON.parse(xhr.responseText);
            
            if (accounts.length == 0){
                $('body').html(`Hey ${user.firstname}, No accounts exist`);
            }
            else {
                var text = `You have ${accounts.length} account(s)\n`;
                for (let a of accounts) {
                    console.log(a);
                    text += 'Account has a balance of ' + a.balance;
                }
                $('body').html(text);
            }
        }
    }
    xhr.open('GET', `http://localhost:3000/accounts?userid=${user.id}`);
    xhr.send();
}

function addUser(){
    var fn = $('#fn').val();
    var ln = $('#ln').val();
    var username = $('#uname').val();
    var pw = $('#pass').val();

    var user = {
        firstname: fn,
        lastname: ln,
        username: username,
        password: pw
    };
    var json = JSON.stringify(user);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        if (xhr.readyState == 4){
            console.log(xhr.status);
            console.log(xhr.responseText);
        }
    }

    xhr.open('POST', `http://localhost:3000/users`);
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(json);
}

function isUnique(){
    var uname = $('#uname').val();
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            var user = JSON.parse(xhr.responseText);
            if (user.length != 0){
                $('#reg').attr('disabled', 'true');
                alert('User already exists')
            }
            else {
                $('#reg').removeAttr('disabled');
            }
            console.log(user);
        }
    }
    xhr.open('GET', `http://localhost:3000/users/?username=${uname}`);
    xhr.send();
}