//Implement HTML input/output. 

const factorial = function(n) {
    if(n === 0 || n === 1) {
        return 1;
    }
    return fact(n, n-1);
}

const fact = function(n, m) {
    if(m === 1) {
        return n;
    }
    return n * fact(m, m-1);
}