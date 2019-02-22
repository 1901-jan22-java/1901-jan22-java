/**
 * LAGJLSDL:JHDKLJGHSKLDFHGK HOW DO I EVEN FINISH!@#?
 */
window.onload = () => {
    fetchView('main-view', 'login.view')
    fetchView('data-view', 'user')
}

function fetchView(id, url) {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4){
            $(`#${id}`).html(xhr.responseText);
        }
    }

    xhr.open('GET', url);
    xhr.send();
}