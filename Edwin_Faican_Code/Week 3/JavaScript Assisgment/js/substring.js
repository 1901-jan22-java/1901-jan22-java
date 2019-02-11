const substring = function(str, offset, length) {
    if(length > str.length) {
        alert('The length specified is longer than the string provided!');
        return 'blah1';
    } else if( ((length+offset) > str.length)) {
        alert('The offset and length declare a string outside of the bounds of the indices of the string provided.');
        return 'blah2';
    } else if(offset >= str.length) {
        alert('The offset is greater than or equal to the string length.');
        return 'blah3';
    }
    let result = '';
    for(let i=offset; result.length<length; i++) {
        result = result + str.charAt(i);
    }
    return result;
}