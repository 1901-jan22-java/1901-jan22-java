const isEven = function(n) {
    if(n == 0) {
        return true;
    }
    return isOdd(n-1);
}

const isOdd = function(n) {
    if(n == 0) {
        return false;
    }

    return isEven(n-1);
}

