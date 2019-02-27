function substring(someStr, length, offset){
    var str;
    if(offset < 0){
       alert("Offset is less than zero");
     }
    else if(offset+length > someStr.length){
       alert("Offset is greater than length of the string");
     }
    else{
       return str.substr(offset, offset+length);
    }
 }
 substring("abcdefg", 5, 2);