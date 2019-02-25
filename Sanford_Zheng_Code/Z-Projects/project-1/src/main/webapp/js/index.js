/**
 * LAGJLSDL:JHDKLJGHSKLDFHGK HOW DO I EVEN FINISH!@#?
 */
$(function () {
    loadLogin();
    bindLogout();
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
                console.log(user);
                $.get('home.view', function (homeData) {
                    $('#main-view').html(homeData);
                    $('#firstname').html(user.first_name);
                    $('#name').html(user.first_name + " " + user.last_name);
                    $('#username').html(user.username);
                    $('#email').html(user.email);
                    $('#role').html(user.role);

                    // Filter not working correctly now (event issue/maybe functionality)
                    // $('#search-reimb-button').bind('enterKey', function () {
                    //     var toShow = [];
                    //     var target = $('#search-reimb-table').val();
                    //     if (target != "") {
                    //         for (let r of reimb) {
                    //             for (let valProp in Object.values(r)) {
                    //                 if (valProp == target) {
                    //                     toShow.push(r);
                    //                 }
                    //             }
                    //         }
                    //     } else {
                    //         toShow = reimb;
                    //     }
                    //     $('#data-view').html(processReimb(toShow));
                    //     applyReimb();
                    // });

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
        $.get('userroles', function (rolesData) {
            res = '';
            for (let r of rolesData) {
                res += `<option value="${r}">${r}</option>`;
            }
            $('#user-role').html(res);
        }, 'json')

        $('#registerButton').click(function () {
            $.post('register', JSON.stringify({
                username: $('#username').val(),
                password: $('#password').val(),
                first_name: $('#first_name').val(),
                last_name: $('#last_name').val(),
                email: $('#email').val(),
                role: $('#user-role').val()
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
        $('#new-reimb-form').removeClass('hide');
    });

    $('#reimb-close').click(function () {
        $('new-reimb-form').addClass('hide');
    });

    $.get('reimbtypes', function (typeData) {
        var res = "";
        for (let t of typeData) {
            res += `<option value="${t}">${t}</option>`;
        }
        $('#reimb-type').html(res);
    }, 'json');

    $('#reimb-create').click(function () {
        $.ajax({
            type: 'PUT',
            url: 'reimbursement',
            data: JSON.stringify({
                author: user,
                reimbs: [{
                    amount: $('#reimb-amount').val(),
                    description: $('#reimb-description').val(),
                    type: $('#reimb-type').val()
                }]
            }),
            success: function (data) {
                reimb = data;
                $('#data-view').html(processReimb(reimb));
                applyReimb();
            }
        });
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
        // GET ALL SELECTED REIMBURSEMENTS HERE
        var selected = getSelected();
        console.log(user);
        console.log(selected);
        $.post('approve', JSON.stringify({
            resolver: user,
            reimbs: selected
        }), function (data) {
            reimb = data;
            $('#data-view').html(processReimb(reimb));
            applyReimb();
        });
    })
    $('#deny-reimb').click(function () {
        // GET ALL SELECTED REIMBURSEMENTS HERE
        var selected = getSelected();
        console.log(user);
        console.log(selected);
        $.post('deny', JSON.stringify({
            resolver: user,
            reimbs: selected
        }), function (data) {
            reimb = data;
            $('#data-view').html(processReimb(reimb));
            applyReimb();
        });
    });

    // We'll see if we need this
    // $('#viewReimbursements').click(function () {

    // });
}

function getSelected() {
    return $('.selected td:nth-child(1)').map(function () {
        return Number.parseInt(this.innerHTML);
    }).toArray();
}

function bindLogout() {
    $('#logout-button').click(function () {
        console.log('logout')
        $.post('logout', JSON.stringify(user), function () {
            delete user;
            delete reimb;
            loadLogin();
        });
    });
}

function loadReimbursement() {
    $.post('reimbursement', JSON.stringify(user), function (data) {
        reimb = data;
        $('#data-view').html(processReimb(reimb));
        applyReimb();
    }, 'json');
}


function processReimb(data) {
    var res = '<table id = "reimb-view">' +
        '<tr>' +
        '<th id="reimb-table-id">ID</th>' +
        '<th id="reimb-table-amount">Amount</th>' +
        '<th id="reimb-table-submitted">Submitted</th>' +
        '<th id="reimb-table-resolved">Resolved</th>' +
        '<th id="reimb-table-description">Description</th>' +
        '<th id="reimb-table-author">Author</th>' +
        '<th id="reimb-table-resolver">Resolver</th>' +
        '<th id="reimb-table-status">Status</th>' +
        '<th id="reimb-table-type">Type</th>' +
        '</tr>';
    for (let r of data) {

        if (user.role == 'Finance Manager' && r.status == "Pending") {
            res += '<tr class=\"selectable\">';
        } else {
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

function simpleCompare(a, b) {
    if (a > b) {
        return 1;
    } else if (a < b) {
        return -1;
    }
    return 0;
};

function applyReimb() {
    $("tr.selectable td").click(function () {
        $(this).parent().toggleClass('selected');
    });

    $('#reimb-table-id').click(function () {
        reimb.sort((a, b) => {
            if (a.id > b.id) {
                return 1;
            } else if (a.id < b.id) {
                return -1;
            }
            return 0;
        });
        $('#data-view').html(processReimb(reimb));
        applyReimb();
    });
    $('#reimb-table-amount').click(function () {
        reimb.sort((a, b) => {
            if (a.amount > b.amount) {
                return 1;
            } else if (a.amount < b.amount) {
                return -1;
            }
            return 0;
        });
        $('#data-view').html(processReimb(reimb));
        applyReimb();
    });
    $('#reimb-table-submitted').click(function () {
        reimb.sort((a, b) => {
            if (a.submitted > b.submitted) {
                return 1;
            } else if (a.submitted < b.submitted) {
                return -1;
            }
            return 0;
        });
        $('#data-view').html(processReimb(reimb));
        applyReimb();
    });
    $('#reimb-table-resolved').click(function () {
        reimb.sort((a, b) => {
            if (a.resolved > b.resolved) {
                return 1;
            } else if (a.resolved < b.resolved) {
                return -1;
            }
            return 0;
        });
        $('#data-view').html(processReimb(reimb));
        applyReimb();
    });
    $('#reimb-table-description').click(function () {
        reimb.sort((a, b) => {
            if (a.description > b.description) {
                return 1;
            } else if (a.description < b.description) {
                return -1;
            }
            return 0;
        });
        $('#data-view').html(processReimb(reimb));
        applyReimb();
    });
    $('#reimb-table-author').click(function () {
        reimb.sort((a, b) => {
            if (a.author > b.author) {
                return 1;
            } else if (a.author < b.author) {
                return -1;
            }
            return 0;
        });
        $('#data-view').html(processReimb(reimb));
        applyReimb();
    });
    $('#reimb-table-resolver').click(function () {
        reimb.sort((a, b) => {
            if (a.resolver > b.resolver) {
                return 1;
            } else if (a.resolver < b.resolver) {
                return -1;
            }
            return 0;
        });
        $('#data-view').html(processReimb(reimb));
        applyReimb();
    });
    $('#reimb-table-status').click(function () {
        reimb.sort((a, b) => {
            if (a.status > b.status) {
                return 1;
            } else if (a.status < b.status) {
                return -1;
            }
            return 0;
        });
        $('#data-view').html(processReimb(reimb));
        applyReimb();
    });
    $('#reimb-table-type').click(function () {
        reimb.sort((a, b) => {
            if (a.type > b.type) {
                return 1;
            } else if (a.type < b.type) {
                return -1;
            }
            return 0;
        });
        $('#data-view').html(processReimb(reimb));
        applyReimb();
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

// Testing purposes
// Delete when done
// function loadAllReimb() {
//     $.get('reimbursement', function (data) {
//         reimb = data;
//         $('#data-view').html(processReimb(data));
//         applyReimb();
//     }, 'json');
// }