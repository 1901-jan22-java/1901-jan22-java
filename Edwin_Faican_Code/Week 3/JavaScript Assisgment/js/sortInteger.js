const sortInteger = function(num) {
    if(num < 0) {
        alert('This only accepts positive integers.');
        return null;
    }
    let snum = "" + num;
    console.log(snum);
    let temp = "";
    for(let i=0; i<snum.length; i++) {
        for(let j=0; j<snum.length; j++) {
            if(snum.charAt(j) < snum.charAt(j+1)) {
                snum = snum.substring(0,j) + snum.charAt(j+1) + snum.charAt(j) + snum.substring(j+2);
            }
        }
    }
    return parseInt(snum,10);
}

function high() {
    $('#reshigh').html(sortInteger($('#inhigh').val()));
}