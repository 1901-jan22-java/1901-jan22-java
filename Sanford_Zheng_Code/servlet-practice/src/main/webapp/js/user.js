window.onload = function () {
    $('#goToSubmit').click(function () {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                $('#view div').attr("hidden=\"true\"");
                $('#view').html(xhr.responseText);
            }
        }

        xhr.open("GET", "loadRegView");
        xhr.send();
    });
};