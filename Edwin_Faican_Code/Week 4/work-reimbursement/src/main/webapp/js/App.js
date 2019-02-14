window.onload = function() {
    loadLoginView();
}

function loadLoginView() {
    var xhr = new XMLHttpRequest();
    var url = 'login.view';

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            console.log('Success');
            if(xhr.status === 200) {
                console.log('Inside');
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

function loadRegView() {
    //Implement loading register view. 
}