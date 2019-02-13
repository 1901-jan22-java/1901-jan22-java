function fibn() {
    $('#resfib').html(fib($('#infib').val()));
}

const fib = function(n) {
    if(n == 0) {
        return 0;
    }
    let fib1 = 0;
    let fib2 = 1;
    let tenp = 0;
    for(let i=1; i<n; i++) {
        temp = fib1;
        fib1 = fib2;
        fib2 = temp + fib2;
    }
    return fib2;
}
