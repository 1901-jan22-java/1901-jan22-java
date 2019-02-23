/**
 * LAGJLSDL:JHDKLJGHSKLDFHGK HOW DO I EVEN FINISH!@#?
 */
$(function () {
    getRequest('main-view', 'register.view', (a) => a);
    getRequest('data-view', 'user', processUsers);
});

function bindLogin() {
    $('#loginButton').click(function () {
        var un = $('#username').val();
        var pwd = $('#password').val();
        authenticate(un, pwd);
    });
    $('#goToRegister').click(function () {

    })
}

function bindRegister() {
    $('#registerButton').click(function () {
        $.post('register', {
            username: $('#username').val(),
            password: $('#password').val(),
            email: $('#email').val(),
            role: $('#role').val()
        }, function (data, status) {

        });
    });
    $('#goToLogin').click(function () {

    })
}

function bindEmployee() {
    $('#newReimbursement').click(function () {

    });
    $('#myReimbursements').click(function () {

    });
}

function bindManager() {
    $('#viewReimbursements').click(function () {

    });
    $('#approve').click(function () {
        $.post('', {

        }, function(){
            $.get('reimbursement');
        });
    })
    $('#deny').click(function () {
        $.post('', {

        }, function(){

        });
    });
}

function authenticate(username, password) {
    $.post('login', {
        username: username,
        password: password
    }, function (data) {
        user = JSON.parse(data);
        $('#data-view').html(obj);
    });
};

function getRequest(id, url, preprocess, after) {
    $.get(url, function (data) {
        var processed = typeof preprocess == 'function' && preprocess(data) || data;
        $(`#${id}`).html(processed);
        typeof after == 'function' && after();
    });
};

function processReimb(reimb) {
    var res = '<table>' +
        '<tr>' +
        '<th>ID</th>' +
        '<th>Amount</th>' +
        '<th>Submitted</th>' +
        '<th>Resolved</th>' +
        '<th>Description</th>' +
        '<th>Author</th>' +
        '<th>Resolver</th>' +
        '<th>Status</th>' +
        '<th>Type</th>' +
        '</tr>';
    for (let r of JSON.parse(reimb)) {

        res += `<tr><td>${r.id}</td>` +
            `<td>${r.amount}</td>` +
            `<td>${r.submitted}</td>` +
            `<td>${r.resolved || ""}</td>` +
            `<td>${r.description || ""}</td>` +
            `<td>${r.author}</td>` +
            `<td>${r.resolver || ""}</td>` +
            `<td>${r.status}</td>` +
            `<td>${r.type}</td></tr>`;

        if (r.status == "Pending") {
            res = `<a id="${r.id}">` + res + '</a>';
        }
    }
    res += '</table>';
    return res;
};

function processUsers(users) {
    var res = '<table>' +
        '<tr>' +
        '<th>Username</th>' +
        '<th>Password</th>' +
        '<th>Name</th>' +
        '<th>Email</th>' +
        '<th>Role</th>' +
        '</tr>';
    for (let u of JSON.parse(users)) {
        res += `<tr><td>${u.username}</td>` +
            `<td>${u.password}</td>` +
            `<td>${u.first_name}  ${u.last_name}</td>` +
            `<td>${u.email}</td>` +
            `<td>${u.role}</td></tr>`;
    }
    res += '</table>';
    return res;
};

function getIntoElement(id, url, processData) {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            $(`#${id}`).html(processData(xhr.responseText));
        }
    }

    xhr.open('GET', url);
    xhr.send();
};
