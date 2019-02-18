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
                loadEmployeeView(xhr.responseText);
            } else if(xhr.status === 202) {
                loadManagerView(xhr.responseText);
            } else {
                $('#log-error').text('Username/Password incorrect!');
            }
        }
    }
     xhr.open('POST', url);
     xhr.setRequestHeader("Content-type", "application/json");
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
                if(userRole == 'employee') {
                    loadEmployeeView(user);
                } else {
                    leadManagerView(user);
                }
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
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function loadEmployeeView(user) {
    console.log(user);
    var xhr = new XMLHttpRequest();
    var url = 'employeeHome.view';

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

function loadManagerView(user) {
    console.log(user);
    var xhr = new XMLHttpRequest();
    var url = 'managerHome.view';

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                console.log('We are in here.');
                $('#view').html(xhr.responseText);
                var u = JSON.parse(user);
                $('#welcome').text(`Welcome, ${u.firstname}!`);
                $('#info').text(`Name: ${u.firstname} ${u.lastname}, Username: ${u.username}, Email: ${u.email}, Role: ${u.role}`);
                $('#reviewReimb').on('click', showRev);
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
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

//Implement behavior to refresh reimbursment list without adding to the list over and over. 
function showRev() {
    var xhr = new XMLHttpRequest();
    var url = 'reviewReimb';

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                var reimbs = JSON.parse(xhr.responseText);
                console.log(reimbs);
                for(let i=0; i<reimbs.length; i++) {
                    $('#data').append(`<tr><td><a id="resolve">Select</a></td><td>${reimbs[i].author}</td><td>${reimbs[i].reimbAmount}</td><td>${reimbs[i].type}</td><td>${reimbs[i].desc}</td><td>${new Date(reimbs[i].submitted)}</td>></tr>`);
                }
            } else {
                console.log("Redirect to an error page.");
                $('#view').html(xhr.responseText);
            }
        } 
    }

    xhr.open('GET', url);
    xhr.send();
}