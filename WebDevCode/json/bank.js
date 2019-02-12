window.onload = function(){
    $('#register').on('click', addUser);
    $('#uname').on('blur', isUnique);
    $('#login').on('click', logIn);
}

function addUser(){

    var fn = $('#fn').val();
    var ln = $('#ln').val();
    var un = $('#uname').val();
    var pw = $('#pass').val();

    var user = {
        firstName : fn, 
        lastName : ln,
        username : un, 
        password : pw
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

function isUnique(){
    var uname = $('#uname').val();
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
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
    xhr.open("GET", `http://localhost:3000/users?username=${uname}`);
    xhr.send();
}
function displayUserAccots(user)





function logIn(){
    var username = $('unamelog').val();
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
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
    xhr.open("GET", `http://localhost:3000/users?username=${uname}`);
    xhr.send();
}