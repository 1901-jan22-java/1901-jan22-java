window.onload = function () {
    $('#addUser').on('click', addUser);
}

function addUser(){
    var user = {
        username: $('#username').val(),
        password: $('#password').val(),
        data: $('#bio').val()
    };

    var json = JSON.stringify(user);

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4){
            if (xhr.status == 201)
            {
                console.log('User added sucessfully');
            } else if (xhr.status == 409) {
                
            } else {

            }
            console.log(xhr.status);
            console.log(xhr.responseText);
            $('#val').html(xhr.responseText)
        }
    }
    xhr.open('POST', 'users');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(json);
}