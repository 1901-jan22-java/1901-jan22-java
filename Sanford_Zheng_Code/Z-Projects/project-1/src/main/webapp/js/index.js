/**
 * LAGJLSDL:JHDKLJGHSKLDFHGK HOW DO I EVEN FINISH!@#?
 */
$(function () {
    loadLogin();
});

function loadLogin() {
    $.get('login.view', function (pageData) {
        $('#main-view').html(pageData);

        $('#loginButton').click(function () {
            console.log('login pushed!');
            $.post('login', JSON.stringify({
                username: $('#username').val(),
                password: $('#password').val()
            }), function (userData) {
                user = userData;
                $.get('home.view', function (homeData) {
                    $('#main-view').html(homeData);
                    $('#name').html(user.first_name + " " + user.last_name);
                    $('#username').html(user.username);
                    $('#email').html(user.email);
                    $('#role').html(user.role);
                });
            },'json');
        });

        $('#goToRegister').click(function () {
            console.log("go to register!");
            loadRegister();
        })
    });
}

function loadRegister() {
    $.get('register.view', function(pageData){
        $('#main-view').html(pageData);

        $('#registerButton').click(function () {
            $.post('register', JSON.stringify({
                username: $('#username').val(),
                password: $('#password').val(),
                first_name: $('#first_name').val(),
                last_name: $('#last_name').val(),
                email: $('#email').val(),
                role: $('#role').val()
            }), function () {
                loadLogin();
            },'json');
        });
    
        $('#goToLogin').click(function () {
            loadLogin();
        })
    });

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

        }, function () {
            $.get('reimbursement', function (data) {

            });
        });
    })
    $('#deny').click(function () {
        $.post('', {

        }, function () {

        });
    });
}

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

// function getIntoElement(id, url, processData) {
//     var xhr = new XMLHttpRequest();

//     xhr.onreadystatechange = function () {
//         if (xhr.readyState == 4) {
//             $(`#${id}`).html(processData(xhr.responseText));
//         }
//     }

//     xhr.open('GET', url);
//     xhr.send();
// };

// function getRequest(id, url, preprocess, after) {
//     $.get(url, function (data) {
//         var processed = typeof preprocess == 'function' && preprocess(data) || data;
//         $(`#${id}`).html(processed);
//         typeof after == 'function' && after();
//     });
// };