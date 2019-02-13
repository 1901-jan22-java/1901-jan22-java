window.onload = function(){
    $('#addUser').on('click', addUser);
}

function addUser(){
    var user = {
        username: $('#username').val(), 
        password: $('#password').val(), 
        data: $('#bio').val()
    };
    var json = JSON.stringify(user);

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        //here is where we do things with our response.
        //but what do we want to respond with? 
        if(xhttp.readyState==4){
            if(xhttp.status == 201){
                console.log('successfully added user');
                //bring user to login page
            }   
            else if(xhttp.status == 409){
                //add field for error messages to let user know something went wrong
                
            }
            else{
                //take to error page
            }
            
        }
    }
    xhttp.open("POST", "users");
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(json);

}
