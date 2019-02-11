window.onload = function(){
    $('#register').on('click', addUser);
    $('#uname').on('blur', isUnique);
    $(`#login`).on('click', logIn)
}

function addUser(){
    var fn = $('#fn').val();
    var ln = $('#ln').val();
    var un = $('#uname').val();
    var pw = $('#pass').val();

    var user= {
        firstName : fn,
        lasName : ln,
        username : un,
        password : pw
    }

var json = JSON.stringify(user);
console.log(user);
console.log(json);

var xhr = new XMLHttpRequest();

xhr.onreadystatechange = function(){
    if(xhr.readystate == 4){
        console.log(xhr.status);
        console.log(xhr.responseText);
    }
}

xhr.open("POST", "http://localhost:3000/users");
xhr.setRequestHeader("Content-type", "application/json");
xhr.send(json);

}

function isUnique(){
    var uname = $('#uname').val();
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            var user = JSON.parse(xhr.responseText);
            if(user.length != 0){
                $('#submit').attr('disabled', 'true');
                alert('Sorry! That username is taken! Please try another');
            } else{
                $('#submit').attr('diabled','fasle');
            }
        }
    }
    xhr.open('GET', `http://localhost:3000/users?username=${uname}`);
    xhr.send(); 
}

function logIn(){
    var username = $('#unamelog').val();
    var password = $('#passlog').val();

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            var user = JSON.parse(xhr.responseText);
            if(user.length != 0){
                alert('Sorry! Invalid credentials!');
            } else{
                var logged = user[0];
                if(logged.password == password) {
                    alert('Welcome, ' + logged.firstName);
                    displayUserAccounts(logged);
                }
                else {
                    alert("Invalid credentials!")
                }
            }
     
        }
        
    }
    xhr.open('GET', `http://localhost:3000/users?username=${username}`);
    xhr.send();
}
   
function displayUserAccounts(user){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            console.log(xhr.status + ": " + xhr.statusText);
            console.log(xhr.getAllResponseHeaders);
            var accounts = JSON.parse(xhr.responseText);

            if(accounts.lenght == 0){
                $('body').html(`Hey ${user.firstName}, you don't have any accounts`);

            }else {
                var text = `You have ${accounts.length} account(s):`;
                for(let a of accounts){
                    text += `Account No.${a.id} has a balance of ${a.balance}`;
                }
                $('body').html(text);
            }
        }
    }
    xhr.open('GET', `http://localhost:3000/accounts?account=${user.id}`);
    xhr.send();
}
