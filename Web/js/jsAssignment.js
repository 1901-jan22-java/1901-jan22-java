window.onload = function(){
    console.log("Page Loaded");
    currTime();
    // document.getElementById('run-fib').addEventListener('click', runFibonacci);
    // document.getElementById('run-bubblesort').addEventListener('click', runBubbleSort);
    document.getElementById('run-reverse').addEventListener('click', () => {runReverseString(); clearFields();});
    // document.getElementById('run-factorial').addEventListener('click', runFactorial);
    // document.getElementById('run-substring').addEventListener('click', runSubString);
    // document.getElementById('run-even-number').addEventListener('click', runEvenNumber);
    document.getElementById('run-palindrome').addEventListener('click', () => {runIsPalindrome(); clearFields();});
    // document.getElementById('run-object-literal').addEventListener('click', runObjectLiteral);
    document.getElementById('run-delete-element').addEventListener('click', runDeleteElement);
    document.getElementById('run-splice-element').addEventListener('click', runSpliceElement);
    // document.getElementById('run-define-contructor').addEventListener('click', runDefineContructor);
    // document.getElementById('run-desc-order').addEventListener('click', runDescOrder);
}

var arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

function clearFields() {
    document.getElementById("number-input").value = "";
    document.getElementById("string-input").value = "";
}

// 1. Fibonacci 
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.



// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.


// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
// var reverseString = (str) => {
//     var arr = str.split('');
//     var revStr = arr.reverse().join('');
//     return revStr;
// }

var runReverseString = () => {
    let str = document.getElementById('string-input').value;
    var reverseString = (str) => {
        var arr = str.split('');
        var revStr = arr.reverse().join('');
        return revStr;
    }
    document.getElementById('reverse-answer').append(reverseString(str));
}


// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.


// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.


// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.


// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false.
var runIsPalindrome = () => {
    let str = document.getElementById('string-input').value;
    var isPalindrome = (str) => {
        let lower = str.toLowerCase();
        let revStr = lower.split('').reverse().join('');
        return revStr === lower ? true : false;
    }
    document.getElementById('palindrome-answer').append(isPalindrome(str));
}


// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.


// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
var runDeleteElement = () => {
    var deleteElement = (arr) => {
        console.log(arr.length);
        delete arr[2];
        console.log(arr.length);
        return arr;
    }
    document.getElementById('delete-element-answer').append(deleteElement(arr) + "  -----  Array Length: " + arr.length);
}


// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
var runSpliceElement = () => {
    var spliceElement = (arr) => {
     console.log(arr.length);
     arr.splice(2, 1);
     console.log(arr.length);
     return arr;
    }
    document.getElementById('splice-answer').append(spliceElement(arr) + "  -----  Array Length: " + arr.length);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
//     var john = new Person("John", 30); 


// 14. Display the current time on the top right of your HTML page, 
// updating every second.
var currTime = () => {
   time = new Date();
   hours = time.getHours();
   minutes = time.getMinutes();
   seconds = time.getSeconds(); 
   minutes = checkTime(minutes);
   seconds = checkTime(seconds);
   document.getElementById("time").innerHTML = hours + ":" + minutes + ":" + seconds;
   var t = setTimeout(function(){ currTime() }, 500);
}

var checkTime = (ms) => {
    if(ms < 10){
        ms = "0" + ms;
    }
    return ms;
}


// 15.  Descending order
// Your task is to make a function that can take any non-negative 
// integer as a argument and return it with its digits in descending 
// order. Essentially, rearrange the digits to create the highest possible number.
