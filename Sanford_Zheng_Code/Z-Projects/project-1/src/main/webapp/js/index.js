/**
 * LAGJLSDL:JHDKLJGHSKLDFHGK HOW DO I EVEN FINISH!@#?
 */
$(function () {
    getIntoElement('main-view', 'login.view', (a) => a);
    getIntoElement('data-view', 'reimbursement', processReimb);
});

function getIntoElement(id, url, processData) {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            $(`#${id}`).html(processData(xhr.responseText));
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function loadLoginView(user) {
    $('#username').html(user.username);
    $('#name').html(user.first_name + ' ' + user.last_name);
    $('#email').html(user.email);
    $('#role').html(user.role);
}

function processReimb(reimb) {
    var res = '<table>' +
        '<tr>' +
        '<th>ID</th>' +
        '<th>Amount</th>' +
        '<th>Submitted</th>' +
        '<th>Resolved</th>' +
        '<th>Descrption</th>' +
        '<th>Author</th>' +
        '<th>Resolver</th>' +
        '<th>Status</th>' +
        '<th>Type</th>' +
        '</tr>';
    for (let r of JSON.parse(reimb)) {

        res += `<tr><td>${r.id}</td>` +
            `<td>${r.amount}</td>` +
            `<td>${r.submitted}</td>` +
            `<td>${r.resolved}</td>` +
            `<td>${r.description}</td>` +
            `<td>${r.author}</td>` +
            `<td>${r.resolver}</td>` +
            `<td>${r.status}</td>` +
            `<td>${r.type}</td></tr>`;

        if (r.status == "Pending") {
            res = `<a id="${r.id}">` + res + '</a>';
        }
    }
    res += '</table>';
    return res;
}

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
}