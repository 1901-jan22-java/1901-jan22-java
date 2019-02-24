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
            $.post('login', JSON.stringify({
                username: $('#username').val(),
                password: $('#password').val()
            }), function (userData) {
                // LOAD USER HOME VIEW
                user = userData;
                $.get('home.view', function (homeData) {
                    $('#main-view').html(homeData);
                    $('#firstname').html(user.first_name);
                    $('#name').html(user.first_name + " " + user.last_name);
                    $('#username').html(user.username);
                    $('#email').html(user.email);
                    $('#role').html(user.role);
                    // LOAD RELEVANT DATA VIEW
                    if (user.role == 'Employee') {
                        loadEmployeeView();
                    } else if (user.role == 'Finance Manager') {
                        loadManagerView();
                    }
                });
            }, 'json');
        });

        $('#goToRegister').click(function () {
            loadRegister();
        })
    });
}

function loadRegister() {
    $.get('register.view', function (pageData) {
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
            }, 'json');
        });

        $('#goToLogin').click(function () {
            loadLogin();
        })
    });

}

function loadEmployeeView() {
    loadReimbursement();
    var res = "<input type=\"button\" id=\"new-reimb\" class=\"my-button\" value=\"Request New Reimbursement\">";
    $('#role-options').html(res);

    $('#new-reimb').click(function () {
        loadReimbursement();
    });
    
    // We'll see if we need this
    // $('#myReimbursements').click(function () {

    // });
}

function loadManagerView() {
    loadReimbursement();
    var res = "<input type=\"button\" id=\"approve-reimb\" class=\"my-button\" value=\"Approve\">" +
        "<input type=\"button\" id=\"deny-reimb\" class=\"my-button\" value=\"Deny\">";
    $('#role-options').html(res);
    $('#approve-reimb').click(function () {
        // GET ALL SELECTED USERS HERE
        var selected = $('.selected').val();
        console.log(selected);
        loadReimbursement();
    })
    $('#deny-reimb').click(function () {
        // GET ALL SELECTED USERS HERE
        var selected = $('.selected').val();
        console.log(selected);
        loadReimbursement();
    });

    // We'll see if we need this
    // $('#viewReimbursements').click(function () {

    // });
}

function loadReimbursement(){
    $.post('reimbursement', JSON.stringify(user), function (data) {
        reimb = data;
        $('#data-view').html(processReimb(reimb));
        applyReimb();
    },'json');
}

// Testing purposes
function loadAllReimb() {
    $.get('reimbursement', function (data) {
        reimb = data;
        $('#data-view').html(processReimb(data));
        applyReimb();
    },'json');
}

function processReimb(data) {
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
    for (let r of data) {

        if (r.status == "Pending") {
            res += '<tr class=\"selectable\">';
        } else{
            res += '<tr>'
        }
        res += `<td>${r.id}</td>` +
            `<td>${r.amount}</td>` +
            `<td>${r.submitted}</td>` +
            `<td>${r.resolved || ""}</td>` +
            `<td>${r.description || ""}</td>` +
            `<td>${r.author}</td>` +
            `<td>${r.resolver || ""}</td>` +
            `<td>${r.status}</td>` +
            `<td>${r.type}</td></tr>`;
    }
    res += '</table>';
    return res;
};

function applyReimb(){
    $("tr.selectable td").click(function(){
        $(this).parent().toggleClass('selected');
    });
}

// FOR ADMIN PURPOSES
function processUsers(data) {
    var res = '<table>' +
        '<tr>' +
        '<th>Username</th>' +
        '<th>Password</th>' +
        '<th>Name</th>' +
        '<th>Email</th>' +
        '<th>Role</th>' +
        '</tr>';
    for (let u of data) {
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