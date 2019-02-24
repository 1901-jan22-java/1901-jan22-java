window.onload = function () {
    loadLoginView();
}

function loadLoginView() {
    var xhr = new XMLHttpRequest();
    var url = 'login.view';
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                $('#view').html(xhr.responseText);
                $('#login').on('click', login);
                $('#register').on('click', loadRegView);
            } else if (xhr.status === 300) {
                var user = JSON.parse(xhr.responseText);
                user.role = user.role.toUpperCase();
                if (user.role == 'EMPLOYEE') {
                    loadEmployeeView(xhr.responseText);
                } else if (user.role == 'FINANCE MANAGER') {
                    loadManagerView(xhr.responseText);
                }
            } else {
                var user = JSON.parse(xhr.responseText);
                user.role = user.role.toUpperCase();
                if (user.role == 'EMPLOYEE') {
                    loadEmployeeView(xhr.responseText);
                } else if (user.role == 'FINANCE MANAGER') {
                    loadManagerView(xhr.responseText);
                }
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function login() {
    $('#log-error').text("");

    var user = {
        username: $('#un').val(),
        pass: $('#pw').val()
    };

    var json = JSON.stringify(user);

    var xhr = new XMLHttpRequest();
    var url = 'login';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 300) {
                var user = JSON.parse(xhr.responseText);
                user.role = user.role.toUpperCase();
                if (user.role == 'EMPLOYEE') {
                    console.log("We are about to load the new view.");
                    loadEmployeeView(xhr.responseText);
                } else if (user.role == 'FINANCE MANAGER') {
                    console.log("We are about to load the new view.");
                    loadManagerView(xhr.responseText);
                }
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

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
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

    var user = {
        firstname: $('#fn').val(),
        lastname: $('#ln').val(),
        username: $('#un').val(),
        email: $('#em').val(),
    };

    var json = JSON.stringify(user);
    //console.log(json);
    var xhr = new XMLHttpRequest();
    var url = 'newUser';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 201) {
                console.log("We have sent you a message with a temporary password.");
                loadLoginView();
            } else if (xhr.status === 409) {
                console.log('Username already exists.');
                $('#un-error').html(xhr.responseText);
            } else if (xhr.status === 418) {
                console.log('Email already in use by an employee.');
                $('#em-error').html(xhr.responseText);
            } else if (xhr.status === 403) {
                $('#em-error').html(xhr.responseText);
            }
        }
    }

    xhr.open('POST', url);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function loadEmployeeView(user) {
    console.log("We are within the load view function.");
    var xhr = new XMLHttpRequest();
    var url = 'employeeHome.view';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            console.log("We return with a status of: " + xhr.status);
            if (xhr.status === 200) {
                console.log(xhr.responseText);
                $('#view').html(xhr.responseText);
                $('#nav-options').append(`<li class="nav-item" id="addReimb"> <button class="nav-link" >Request Reimbursement</a> </li>`);
                $('#nav-options').append(`<li class="nav-item" id="reviewReimb"> <button class="nav-link" >Review Submitted</a> </li>`);
                $('#nav-options').append(`<li class="nav-item" id="acctSettings"> <button class="nav-link" >Account</a> </li>`);
                $('#nav-options').append(`<li class="nav-item" id="logout"> <button class="nav-link" >Logout</a> </li>`);
                var u = JSON.parse(user);
                $('#welcome').text(`Welcome, ${u.firstname}!`);
                //$('#info').text(`Name: ${u.firstname} ${u.lastname}, Username: ${u.username}, Email: ${u.email}, Role: ${u.role}`);
                $('#addReimb').on('click', showAdd);
                $('#reviewReimb').on('click', showSub);
                $('#acctSettings').on('click', showAcct);
                $('#logout').on('click', logout);
                showSub();
            } else {
                $('#view').html(xhr.responseText);
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}


function showSub() {
    var xhr = new XMLHttpRequest();
    var url = 'userReimb.view'

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                $('#options').html(xhr.responseText);
                populateReimbs();
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function populateReimbs() {
    $('#thedata').empty();
    $('#thedata').html(`<table id="reimbs" class="table table-dark"></table>`);
    var xhr = new XMLHttpRequest();
    var url = 'userReimbs';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var reimburs = JSON.parse(xhr.responseText);
                $('#reimbs').DataTable({
                    data: reimburs,
                    dataSrc: "",
                    destroy: true,
                    columns: [{
                            title: "Id",
                            data: "reimbId"
                        },
                        {
                            title: "Manager",
                            data: "resolver_firstname",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                return `${full.resolver_firstname} ${full.resolver_lastname}`;
                            }
                        },
                        {
                            title: "Amount",
                            data: "reimbAmount",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                return `$${full.reimbAmount}`;
                            }
                        },
                        {
                            title: "Type",
                            data: "type"
                        },
                        {
                            title: "Description",
                            data: "desc"
                        },
                        {
                            title: "Status",
                            data: "status"
                        },
                        {
                            title: "Date Submitted",
                            data: "submitted",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                return `${new Date(full.submitted).toLocaleString()}`;
                            }
                        },
                        {
                            title: "Date Resolved",
                            data: "resolved",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                if (full.resolved === 0) {
                                    return `------`;
                                } else {
                                    return `${new Date(full.resolved).toLocaleString()}`;
                                }
                            },
                        }
                    ]
                });
            } else {
                $('#options').html(xhr.responseText);
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function showAcct() {
    var xhr = new XMLHttpRequest();
    var url = 'accountSettings.view'

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                $('#options').html(xhr.responseText);
                showInfo();
                $('#changeun').on('click', showChangeUN);
                $('#changepw').on('click', showChangePW);
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function showInfo() {
    var xhr = new XMLHttpRequest();
    var url = 'userInfo'

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var user = JSON.parse(xhr.responseText);
                $('#un').text(user.username);
                $('#email').text(user.email);
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function showChangeUN() {
    var xhr = new XMLHttpRequest();
    var url = 'userChange.view'

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                $('#options').html(xhr.responseText);
                $('#change-user').on('click', changeUsername);
                $('#return').on('click', showAcct);
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}


function changeUsername() {
    $('#un-error').html("");
    var user = {
        username: $('#un').val()
    };

    var json = JSON.stringify(user);
    var xhr = new XMLHttpRequest();
    var url = 'changeUser';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert('Username changed Successfully');
                $('#nav-options').empty();
                loadLoginView();
            } else if (xhr.status === 403) {
                $('#un-error').text(xhr.responseText);
            }
        }
    }

    xhr.open('POST', url);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function showChangePW() {
    var xhr = new XMLHttpRequest();
    var url = 'passChange.view'

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                $('#options').html(xhr.responseText);
                $('#change-pass').on('click', changePassword);
                $('#return').on('click', showAcct);
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function changePassword() {
    $('#pw-error').html("");
    if ($('#pw1').val() != $('#pw2').val()) {
        $('#pw-error').text('Passwords do not match');
    } else if(verifyPass($('#pw').val())) {
        $('#pw-error').text('Old Password is incorrect');
    } else {
        var user = {
            pass: $('#pw2').val()
        };

        var json = JSON.stringify(user);
        var xhr = new XMLHttpRequest();
        var url = 'changeUser';

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    alert('Password changed Successfully');
                    $('#nav-options').empty();
                    loadLoginView();
                } else if (xhr.status === 400) {
                    $('#pw-error').text(xhr.responseText);
                }
            }
        }

        xhr.open('POST', url);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send(json);
    }
}

function verifyPass(passw) {
    var user = {
        pass: passw,
    };

    var json = JSON.stringify(user);
    var xhr = new XMLHttpRequest();
    var url = 'verifyPass';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                return true;
            } else if (xhr.status === 400) {
                return false;
            }
        }
    }

    xhr.open('POST', url);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function loadManagerView(user) {
    var xhr = new XMLHttpRequest();
    var url = 'managerHome.view';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                $('#view').html(xhr.responseText);
                $('#nav-options').append(`<li class="nav-item" id="allReimbs"> <button class="nav-link" >View All</a> </li>`);
                $('#nav-options').append(`<li class="nav-item" id="reviewReimb"> <button class="nav-link" >Review Pending</a> </li>`);
                $('#nav-options').append(`<li class="nav-item" id="acctSettings"> <button class="nav-link" >Account</a> </li>`);
                $('#nav-options').append(`<li class="nav-item" id="logout"> <button class="nav-link" >Logout</a> </li>`);
                var u = JSON.parse(user);
                $('#welcome').text(`Welcome, ${u.firstname}!`);
                //$('#info').text(`Name: ${u.firstname} ${u.lastname}, Username: ${u.username}, Email: ${u.email}, Role: ${u.role}`);
                showRev();
                $('#allReimbs').on('click', showAll);
                $('#reviewReimb').on('click', showRev);
                $('#acctSettings').on('click', showAcct);
                $('#logout').on('click', logout);
            } else {
                $('#view').html(xhr.responseText);
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function logout() {
    $('#nav-options').empty();
    var xhr = new XMLHttpRequest();
    var url = 'logout';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                loadLoginView();
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();

}

function showAll() {
    $('#options').empty();
    $('#options').html(`<table id="reimbs" class="table table-dark"></table>`);

    var xhr = new XMLHttpRequest();
    var url = 'viewAll';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var reimburs = JSON.parse(xhr.responseText);
                $('#reimbs').DataTable({
                    data: reimburs,
                    dataSrc: "",
                    destroy: true,
                    columns: [{
                            title: "Id",
                            data: "reimbId"
                        },
                        {
                            title: "Manager",
                            data: "resolver_firstname",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                return `${full.resolver_firstname} ${full.resolver_lastname}`;
                            }
                        },
                        {
                            title: "Employee",
                            data: "author_firstname",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                return `${full.author_firstname} ${full.author_lastname}`;
                            }
                        },
                        {
                            title: "Amount",
                            data: "reimbAmount",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                return `$${full.reimbAmount}`;
                            }
                        },
                        {
                            title: "Type",
                            data: "type"
                        },
                        {
                            title: "Description",
                            data: "desc"
                        },
                        {
                            title: "Status",
                            data: "status"
                        },
                        {
                            title: "Date Submitted",
                            data: "submitted",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                return `${new Date(full.submitted).toLocaleString()}`;
                            }
                        },
                        {
                            title: "Date Resolved",
                            data: "resolved",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                if (full.resolved === 0) {
                                    return `------`;
                                } else {
                                    return `${new Date(full.resolved).toLocaleString()}`;
                                }
                            },
                        }
                    ]
                });
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

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                $('#options').html(xhr.responseText);
                $('#addnewreimb').on('click', submitReimb);
            } else {
                $('#view').html(xhr.responseText);
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function submitReimb() {
    var reimb = {
        reimbAmount: $('#amount').val(),
        type: $('#type').val(),
        desc: $('#desc').val(),
    };

    var json = JSON.stringify(reimb);
    var xhr = new XMLHttpRequest();
    var url = 'addReimb';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 201) {
                showSub();
            } else if (xhr.status === 400) {
                $('#reimb-error').text(xhr.responseText);
            }
        }
    }

    xhr.open('POST', url);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function showRev() {
    $('#options').empty();
    $('#options').html(`<table id="reimbs" class="table table-dark table-hover"></table>`)

    var xhr = new XMLHttpRequest();
    var url = 'reviewReimb';

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var reimburs = JSON.parse(xhr.responseText);
                console.log(reimburs);
                $('#reimbs').DataTable({
                    data: reimburs,
                    dataSrc: "",
                    destroy: true,
                    columns: [{
                            title: "Id",
                            data: "reimbId"
                        },
                        {
                            title: "Employee",
                            data: "author_firstname",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                return `${full.author_firstname} ${full.author_lastname}`;
                            }
                        },
                        {
                            title: "Amount",
                            data: "reimbAmount",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                return `$${full.reimbAmount}`;
                            }
                        },
                        {
                            title: "Type",
                            data: "type"
                        },
                        {
                            title: "Description",
                            data: "desc"
                        },
                        {
                            title: "Status",
                            data: "status"
                        },
                        {
                            title: "Date Submitted",
                            data: "submitted",
                            "className": "left",
                            "render": function (data, type, full, meta) {
                                return `${new Date(full.submitted).toLocaleString()}`;
                            }
                        }
                    ]
                });
                $('tbody tr:not(.dropdown-menu)').on('click', resolution);
            } else {
                $('#view').html(xhr.responseText);
            }
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function resolution() {
    var reimb = {
        reimbId: $(this).find('td:nth-child(1)').text(),
        reimbAmount: $(this).find('td:nth-child(3)').text(),
        type: $(this).find('td:nth-child(4)').text(),
        desc: $(this).find('td:nth-child(5)').text(),
    }

    $('#type').html(`Reimbursement type: ${reimb.type}`);
    $('#authorandid').html(`Author: ${$(this).find('td:nth-child(2)').text()} -- Reimbursement Id: ${reimb.reimbId}`);
    $('#amount').html(`${reimb.reimbAmount}`);
    $('#description').html(reimb.desc);
    $('#datetime').html($(this).find('td:nth-child(7)').text());


    $('#myModal').modal();
    $('#approve, #deny').on('click', function () {
        var resolution = $(this).text();
        if (resolution == 'Approve') {
            reimb.statusid = 2;
        } else {
            reimb.statusid = 3;
        }
        reimb.reimbAmount = reimb.reimbAmount.substring(1)
        var json = JSON.stringify(reimb);

        var xhr = new XMLHttpRequest();
        var url = 'resolve';

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    showRev();
                }
            }
        }

        xhr.open('POST', url);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send(json);

    });



}