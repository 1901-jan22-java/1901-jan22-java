/**
 * 
 */
window.onload = function () {
	console.log("working");
    $('#getAjaxReq').on('click', getReq);
}

function getReq(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if (xhr.readyState = 4){
        	$('#res').html(`${xhr.responseText}`);
            console.log(xhr.status + ": " + xhr.statusText);
            console.log(xhr.responseText);
        }
    }
    xhr.open('GET', `http://localhost:8085/hello-servlets/helloservlet`);
    xhr.send();
}