window.onload = function() {
    loadLoginView();
}

function loadLoginView() {
    var xhr = new XMLHttpRequest();
    var url = 'login.view';

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                $('#view').html(xhr.responseText);
                $('#login').on('click', login);
                $('#register').on('click', loadRegView);
            } else {
                console.log("Redirect to an error page.");
                $('#view').html(xhr.responseText);
            }
        } 
    }

    xhr.open('GET', url);
    xhr.send();
}

function login() {
    console.log('We are here!');
    $('#log-error').text("");

    var user = {
        username: $('#un').val(),
        pass: $('#pw').val()
    };

    var json = JSON.stringify(user);

    var xhr = new XMLHttpRequest();
    var url = 'login';

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                console.log()
                loadWelcomeView(xhr.responseText);
            } else {
                console.log(xhr.status);
                $('#log-error').text('Username/Password incorrect!');
            }
        }
    }
     xhr.open('POST', url);
     xhr.send(json);
}

function loadRegView() {
    var xhr = new XMLHttpRequest();
    var url = 'register.view';

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                $('#view').html(xhr.responseText);
                $('#newUser').on('click', newUser);
                $('#login').on('click', loadLoginView);
            } else {
                $('#view').html(xhr.responseText);
            }
        } 
    }

    xhr.open('GET', url);
    xhr.send();
}

function newUser() {
    $('#un-error').html("");
    $('#em-error').html("");
    let userRole;
    if($('#rle').is(":checked")) {
        console.log("It sees the first as checked.");
        userRole = $('#rlelabel').text();
    } else {
        console.log("It sees the second as checked. ")
        userRole = $('#rlflabel').text();
    } 

    var user = {
        firstname: $('#fn').val(),
        lastname: $('#ln').val(),
        username: $('#un').val(),
        pass: $('#pw').val(),
        email: $('#em').val(),
        role: userRole
    };

    var json = JSON.stringify(user);
    console.log(json);
    var xhr = new XMLHttpRequest();
    var url = 'newUser';

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            if(xhr.status === 201) {
                $('#view').html(xhr.responseText);
            } else if(xhr.status === 409) {
                console.log('Username already exists.');
                $('#un-error').html(xhr.responseText);
            } else if(xhr.status === 418) {
                console.log('Email already exists.');
                $('#em-error').html(xhr.responseText);
            }
        }
    }

    xhr.open('POST', url);
    xhr.send(json);
}

function loadWelcomeView(user) {
    console.log(user);
    var xhr = new XMLHttpRequest();
    var url = 'home.view';

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                console.log('We are in here.');
                $('#view').html(xhr.responseText);
                var u = JSON.parse(user);
                $('#welcome').text(`Welcome, ${u.firstname}!`);
                $('#info').text(`Name: ${u.firstname} ${u.lastname}, Username: ${u.username}, Email: ${u.email}, Role: ${u.role}`);
                $('#addReimb').on('click', showAdd);
            } else {
                $('#view').html(xhr.responseText);
            }
        } 
    }

    xhr.open('GET', url);
    xhr.send();
}

function showAdd() {
    var xhr = new XMLHttpRequest();
    var url = 'newReimb.view';

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                $('#options').html(xhr.responseText);
                $('#addnewreimb').on('click', submitReimb);
            } else {
                console.log("Redirect to an error page.");
                $('#view').html(xhr.responseText);
            }
        } 
    }

    xhr.open('GET', url);
    xhr.send();
}

//Need to find a way to retain user information between functions. 
function submitReimb() {
    var reimb = {
        author: 2,
        reimbAmount: $('#amount').val(),
        type: $('#type').val(),
        desc: $('#desc').val(),
    };

    var json = JSON.stringify(reimb);
    console.log(json);
    var xhr = new XMLHttpRequest();
    var url = 'addReimb';

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            if(xhr.status === 201) {
                $('#options').html("Success!");
                console.log(xhr.responseText);
            } else if(xhr.status === 409) {
                console.log('Something conflicted');
                $('#un-error').html(xhr.responseText);
            } else if(xhr.status === 418) {
                console.log('Semething else went wrong.');
                $('#em-error').html(xhr.responseText);
            }
        }
    }

    xhr.open('POST', url);
    xhr.send(json);
}