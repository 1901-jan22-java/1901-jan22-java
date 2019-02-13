window.onload = function () {
    $('#servlet').click(function () {
        // WHAT DO I DO!??
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (this.readyState == 4 && status < 300 && status > 199) {
                var v = xhr.responseText;
                console.log(`Good job! ${v}`);
            }
        };

        xhr.open("GET", "http://localhost:8085/servlet-practice/world");
        xhr.send();
    });
    $('#getUsers').click(function () {
        // WHAT DO I DO!??
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (this.readyState == 4 && status < 300 && status > 199) {
                var v = xhr.responseText;
                console.log(`Good job! ${v}`);
            }
        };

        xhr.open("GET", "http://localhost:8085/servlet-practice/users");
        xhr.send();
    });
}