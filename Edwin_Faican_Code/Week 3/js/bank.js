window.onload = function() {
    $('#register').on('click', addUser);
    $('#un').on('blur',isUnique);
    $('#login').on('click', login);
}

function addUser() {
    var fn = $('#fn').val();
    var ln = $('#nn').val();
    var un = $('#un').val();
    var pass = $('#pass').val();

    var user = {
        firstname : fn,
        lastname : ln,
        username : un,
        password : pass
    };
    var json = JSON.stringify(user);


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

function isUnique(un) {
    var un = $('#un').val();
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4){
            var user = JSON.parse(xhr.responseText);
            if(user.length != 0){
                $('#register').attr('disabled', 'true');
                alert('Sorry! That username is taken! Please try another');
            }
            else{
                $('#register').removeAttr('disabled');
            }
        }
    }

    xhr.open("GET", `http://localhost:3000/users?username=${un}`);
    xhr.send();

}

function login() {
    var un = $('#unl').val();
    var pass = $('#passl').val();
    var xhr = new XMLHttpRequest();
    console.log(pass);
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4){
            var user = JSON.parse(xhr.responseText);
            var logged = user[0];
            if(user.length != 0){
                console.log(logged.password);
                if(logged.password == pass) {
                    console.log('You have logged in! Welcome, ' + logged.firstname + '!');
                    displayUserAccounts(logged);
                }
            }
            else{
                alert('Invalid credentials');
            }
        }
    }

    xhr.open("GET", `http://localhost:3000/users?username=${un}`);
    xhr.send();

}

function displayUserAccounts(userId) {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4) {
            console.log(xhr.status);
            console.log(xhr.getAllResponseHeaders);

            var accounts = JSON.parse(xhr.responseText);

            if(accounts.length == 0) {
                $('body').html(`Hey ${user.firstname}, you don't have any accounts! Let's chnge that!`);
            } else {
                var text = `You have ${accounts.length} account(s)`;
                for(let a of accounts){
                    text += `<br>Account No.${a.id} has a balance of ${a.balance}</br>`;
                }
                $('body').html(text);
            }
        }
    }

    xhr.open("GET", `http://localhost:3000/accounts?userId=${userId}`);
    xhr.send();
}