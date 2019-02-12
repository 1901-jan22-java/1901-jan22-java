function revStr() {
    $('#resrev').html(reverseString($('#inrev').val()));
}

const reverseString = function(str) {
    for(let i=str.length; i>0; i--) {
        str = str.substring(1,i) + str.substring(0,1) + str.substring(i);
    }
    return str;
}