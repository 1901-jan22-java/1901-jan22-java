const palindrome = function(str) {
    let stack = [];
    let half = Math.floor(str.length/2);
    if(str.length%2 != 0) {
        str = str.substring(0,half) +  str.substring(half +1);
    }

    for(let i=0; i<half; i++) {
        stack.push(str.charAt(i));
    }

    for(let i=0; i<half; i++) {
        if(str.charAt(half+i) != stack.pop()) {
            return false;
        }
    }
    return true;
}