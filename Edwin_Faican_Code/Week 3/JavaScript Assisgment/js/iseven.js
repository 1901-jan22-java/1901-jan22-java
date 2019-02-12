const isEven = function(n) {
    let num = Math.floor(n/2);
    if(num*2 == n) {
        return 'true';
    } else {
        return 'false';
    }
}

function even() {
    $('#reseven').html(isEven($('#ineven').val()));
}