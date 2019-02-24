window.onload = function() {
    loadLoginView();
}

function loadLoginView() {
    $.ajax({
        method   : "GET",
        url      : `http://localhost:8085/bank/login.view`,
        success  : function(data){
            doStuff(data);

            return data;
        },
        error    : function(){},
        complete : function(){}
      });
}

function doStuff(data) {
    $('#view').html(data);
    $('#login').on('click', login);
    $('#register').on('click', register);
}

function register() {
    $.ajax({
        method   : "GET",
        url      : `http://localhost:8085/bank/register.view`,
        success  : function(data){
            doReg(data); 
            return data;
        },
        error    : function(){},
        complete : function(){}
      });
}

function doReg(data) {
    $('#view').html(data);
    $('#login').on('click', loadLoginView);
    $('#rnewUser').on('click', newUser);
}

function login() {
    var user = {
        username: $('#un').val(),
        password: $('#pw').val()
    }
    $.ajax({
        method   : "POST",
        url      : `http://localhost:8085/bank/login`,
        data     : JSON.stringify(user),
        // done     : function(xhr, data) {
        //     console.log(JSON.parse(xhr.responseText));
        //     $('#view').text(xhr.responseText);
        // },
        // success  : function(xhr, data){
           
        // },
        // error    : function (xhr, data){
        //     if(xhr.status==404) {
        //         $('#log-error').text(xhr.responseText);
        //     }
        // },
        // complete : function(xhr){
        //     // console.log(JSON.parse(xhr.responseText));
        //     // $('#view').text(xhr.responseText);
        // }
      })
        .done(function(data){
            user = data;
            alert(data);})
        .fail(function(errMsg) {alert("This error thing works!");});   
}

function newUser() {

}