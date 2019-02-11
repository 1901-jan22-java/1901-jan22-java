window.onload = function() {
    $('#go').on('click', getSWS);
}

function getSW() {
    let id = $('#swID').val();
    var url = `https://newton.now.sh/simplify/${id}/`;

    //AJAX
    //Create new XMLHttps Object
    var xhr = new XMLHttpRequest();

    //Define onreadystatechange Function
    //Define what we want to do with the request but does not have to be written directly after step 1
    //But is common to indicate that after we send out request, we move on with whatever code comes next. 
    xhr.onreadystatechange = function(){
        console.log('This is the readystate: ' + xhr.readyState);
        if(xhr.readyState === 4 && xhr.status === 200) {
            console.log('Successfully recieved response: ' + xhr.responsetext);
            var math = JSON.parse(xhr.responseText);
            $('#output').html(math.result);
        }
    }

    //Open the request
    xhr.open('GET', url); //(METHOD, URL, ASYNCHRONOUS, USERNAME, PASSWORD);

    //Send the request
    xhr.send();
}


//Syntactically shorter way of sending a request using jQuery.
function getSWS() {
    var id = $('#swID').val();
    $.ajax({
        method   : "GET",
        url      : `http://localhost:3000/users/${id}/`,
        success  : function(data){
            doStuff(data);
            return data;
        },
        error    : function(){},
        complete : function(){}
      });
}

const doStuff = function(data) {
    console.log(data);
    //console.log('Successfully recieved response: ' + data.responsetext);
     ///var pokemon = JSON.parse(data);
     $('#output').html(data.firstname + ' ' + data.lastname);
}