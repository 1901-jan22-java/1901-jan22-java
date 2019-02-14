window.onload = function () {
    $('#fibSub').on('click', Fibonacci);
    $('#reverseSub').on('click', reverse);
    $('#factorialSub').on('click', getFactorial);
    $('#evenNumberSub').on('click', getEven);
    $('#PalindromeSub').on('click', checkIfPalindrome);
    $('#PersonSub').on('click', personcreate);
    $('#desOrderSub').on('click', sortDesDigitsOfNum);
    $('#substringSub').on('click', substringfromInput);
    $('#Sub').on('click', reverse);
    $('#Sub').on('click', reverse);
};

/*
1. Fibonacci 
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function Fibonacci() {
    let n = $('#fibIn').val();
    $('#fibOut').html(`Result: ${FibonacciNum(n)}`);
}

function FibonacciNum(n) {
    if (n < 1) {
        return 0;
    } else if (n <= 2) {
        return 1;
    } 
    return FibonacciNum(n - 1) + FibonacciNum(n - 2);
}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

/*
function bubble(){
    let arr = [];
    let str = $('#bubbleIn').val();
    console.log(typeof(str));
}
*/
function bubbleSort(nums) {
    for(let i = 1; i < nums.length; i++)
    {
        if (nums[i] < nums[i - 1])
        {
            let swap = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = swap;
            i = 1;
        }
    }
    if (nums[1] < nums[0])
    {
        let swap = nums[1];
        nums[1] = nums[0];
        nums[0] = swap;
    }
    return nums;
}


/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.

*/
function reverse(){
    let str = $('#reverseIn').val();
    $('#reverseOut').html(`Result: ${reverseStr(str, str.length - 1).substring(str.length)}`);
}

function reverseStr(someStr, index){
    if (index < 0) return someStr;
    someStr += someStr[index];
    return reverseStr(someStr, index - 1);		
}
/*

4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.

*/
function getFactorial(){
    let num = $('#factorialIn').val();
    $('#factorialOut').html(`Result: ${factorial(num)}`);
}

function factorial(someNum) {
    if (someNum <= 1) return 1;
    return someNum * factorial(someNum - 1);
}
/*

5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.

*/

function substringfromInput(){
    let str = $('#substringIn').val();
    let offset = $('#substringOffset').val();
    let length = $('#substringLength').val();
    $('#substringOut').html(`Result: ${substring(str, length, offset)}`);
}

// not working, still needs logic fixes
function substring(someStr, length, offset){
    let sub = '';
    console.log(someStr);
    console.log(length);
    console.log(offset);
    if (offset + length < someStr.length && offset + length >= 0 && offset < someStr.length && offset >= 0){
        for (let i = offset; i < length; i++){
            sub += someStr[i];
        }
    } else if (offset + length < 0 || offset < 0) {
        alert('Your input cannot start below 0 and does not have a length below 0.');
    } else if (offset + length >= someStr.length || offset >= someStr.length) {
        alert(`Your input cannot start at or above the string's length and does not have a length above the string's length.`);
    }
    console.log(sub);
    return sub;
}
/*

6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.

*/
function getEven(){
    let num = $('#evenNumberIn').val();
    $('#evenNumberOut').html(`Result: ${isEven(num)}`);
}

function isEven(someNum){
    return (someNum & 1) == 0;
}
/*

7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false

*/
function checkIfPalindrome(){
    let str = $('#PalindromeIn').val();
    $('#PalindromeOut').html(`Result: ${isPalindrome(str)}`);
}

function isPalindrome(someStr) {
    for (let i = 0; i < str.length / 2; i++) {
        if (str[i] != str[str.length - i - 1])
            return false;
    }
    return true;
}
/*

8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *

9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.

*/
function traverseObject(someObj){

}
/*

10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.

*/
function deleteElement(someArr){

}
/*

11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.

*/

/*

12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);

*/
function Person(name, age) {
    this.name = name;
    this.age = age;
}
function personcreate(){
    let name = $('#PersonIn').val();
    let age = $('#PersonNumIn').val();
    var john = new Person(name, age);
    $('#PersonOut').html(`Result: ${typeof(john)}: ${JSON.stringify(john)}`);
}
/*

13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
 
*/

/*

14. Display the current time on the top right of your HTML page, 
updating every second

*/
var blickingCollon = false;
setInterval(function (){
    let hour = new Date().getHours();
    let minute = new Date().getMinutes();
    let ampm = 'am';
    if (hour > 11) ampm = 'pm';
    if (hour > 12) hour = hour - 12;
    if (hour == 0) hour = 12;
    if (hour < 10) hour = '0' + hour;
    if (minute < 10) minute = '0' + minute;
    if (blickingCollon){
        $('#currentTime').html(`<b>${hour}:${minute} ${ampm}</b>`);
    } else {
        $('#currentTime').html(`<b>${hour} ${minute} ${ampm}</b>`);     
    }
    blickingCollon = !blickingCollon;
}, 500);
/*

15.  Descending order
Your task is to make a function that can take any non-negative 
integer as a argument and return it with its digits in descending 
order. Essentially, rearrange the digits to create the highest possible number.
*/
function sortDesDigitsOfNum(){
    let num = $('#desOrderIn').val();
    $('#desOrderOut').html(`Result: ${descendingDigits(num)}`);
}

function descendingDigits(num){
    let numStr = '' + num;
    let arr = [];
    arr = numStr.split('');
    let str = bubbleSort(arr);
    let desDigits = '';
    for (let i = str.length - 1; i >= 0; i--) {
        desDigits += str[i];
    }
    return desDigits;
}
