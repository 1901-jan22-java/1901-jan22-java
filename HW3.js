function fibonacci(n){
    if(num<=1)return 1;
    return fibonacci(num-1)+fibonacci(num-2);
}

function bubbleSort(arr){
    var i;
    var temp;
    for(i=0;i<arr.length;i++){
        for(var j=i+1;j<arr.length;j++){
            if(arr[i]>arr[j]){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    return arr;
}
function reverseString(str){
    var newString="";
    for(var i=str.length-1;i>=0;i--){
        newString=newString+str.charAt(i)
    }
    return str;
}
function factorial(n){
    if(n===0)return 1;
    return n*factorial(n+1);
}
function subString(str,length,offset){
    var newString=str.splice(offset,offset+length);
    return newString;
}
function evenNumber(n){
    if(Number.isInteger(n/2)){
        return true;
    }
    else
    return false;
}
function palindrome(str){
if(str===str.reverse()){
    return true;
}
else
return false;
}
function printShapes(shape,height,character){

switch(shape){
    case "square":
    for(var i=0;i<height;i++){
        for(var j=0;j<height;j++){
             console.log(character);
             console.log("");
        }
    }
    break;
    case "rectangle":
    for(var h=0;h<height;i++){
        for(var w=0;w<height-2;w++){
            console.log(character);
            console.log("");
        }
    }
    case "triangle":
    for(var h=0;h<height;h++){
        for(var j=0;j<=h;j++){
            console.log(character);
            console.log("");
        }
    }
    case "diamond":
    var len=(height+1)/2
    var sp=height-1;
 for(var i=0;i<height;i++){
     for(var j=0;j<sp;j++)
         console.log(" ");
     for(var p=0;p<i;p++)
        console.log("* ")
// new line
sp--;
 }
}
}
 function traverseObj(ob){
   for(let key in user){
       console.log(user[key]);
   }
 }

 function spliceElement(arr){
     console.log(arr.length);
     newArr=arr.splice(3,3);
     console.log(newArr.length);
 }
 function person(name,age){
     return{
         name:name,
         age:age
     };
     function displayTime(){
        var today = new Date();
        var hour = today.getHours();
        var mins = today.getMinutes();
        var secs = today.getSeconds();

        if (secs <=9){
            secs = "0" + secs
        }

        var TotalTime = hour + ":" + mins + ":" + secs;

        if (document.layers) { 
            document.layers.time.document.write(TotalTime); 
            document.layers.time.document.close(); 
        }else if (document.all) { 
            time.innerHTML = TotalTime; 
        } 

        setTimeout("UpdateTime()", 1000) 
     }
 }
 function descendingOrder(n){
if(n/10<1){
    return n;
}
var num=n.toString();
var high;

var temp;
for(var i=0;i<num.length;i++){
    var a=parseInt(num.charAt(i));
    high.push(a);
}
for(var k=0;k<high.length-1;k++){
if(high[k]<high[k+1]){
    temp=high[k]
    high[k]=high[k+1];
    high[k+1]=temp;
}

 }
return high;
}
