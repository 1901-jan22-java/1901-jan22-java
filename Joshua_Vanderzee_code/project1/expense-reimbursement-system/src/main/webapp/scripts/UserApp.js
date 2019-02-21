window.onload = function () {
    loadLogInView();
}

function loadRegisterView(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            $('#view').html(xhr.responseText);
            $('#gotoreg').on('click', loadLogInView);
            $('#register').on('click', register);
        }
    }
    xhr.open('GET', 'register.view');
    xhr.send();
}

function register(){

}

function loadLogInView(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            $('#view').html(xhr.responseText);
            $('#gotosubmit').on('click', loadRegisterView);
            $('#login').on('click', login);
        }
    }
    xhr.open('GET', 'login.view');
    xhr.send();
}

function login(){
    let ErsUser = {
        ersUsername: $('#username').val(),
        ersPassword: $('#pw').val(),
    };

    let json = JSON.stringify(ErsUser);
    console.log(json);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            if (xhr.status == 200) {
                $('#view').html(xhr.responseText);
                loadHomeData(1);
            }
            else if (xhr.status == 406) {
                console.log("Invalid Login");
            } else {
                console.log("Invalid Password");
            }
        }
    }
    xhr.open('POST', 'login');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(json);
}

function loadHomeData(page, type){
    let dataInfo = {
        homeType: $('#role').val(),
        page: page,
        filter: type
    }

    let json = JSON.stringify(dataInfo);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            if (xhr.status == 200) {
                let tableData = JSON.parse(xhr.responseText);
                console.log(tableData);
                let info = ``;
                for (let infoItem of tableData) {
                    console.log(infoItem);
                    info += '<tr>';
                    info += `<td>${infoItem.reimb_ID}</td>`;
                    info += `<td>$${infoItem.reimb_amount}</td>`;
                    info += `<td>${infoItem['reimbAuthor'].userFirstName}</td>`;
                    info += `<td>${infoItem['reimbAuthor'].userLastName}</td>`;
                    if (infoItem.reimb_Status == 'Pending') {
                        info += `<td><button type="button" class="btn btn-success">${infoItem.reimb_Status}</button></td>`;
                    } else {
                        if (infoItem.reimb_Status == 'Approved') {
                            info += `<td>${infoItem.reimb_Status}</td>`;
                        } else {
                            info += `<td>${infoItem.reimb_Status}</td>`;
                        }
                    }
                    info += `<td>${infoItem.reimb_Type}</td>`;
                    info += '</tr>';
                }
                $('#data').append(info);
                $('#data').on('click', 'button', function(){
                    console.log(`Status info: ${this.parentElement.previousSibling.previousSibling.previousSibling.previousSibling.innerHTML}`);
                });
            }
            else if (xhr.status == 406) {
                console.log("Invalid Login");
            } else {
                console.log("Invalid Password");
            }
        }
    }
    xhr.open('POST', 'home');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(json);
}
