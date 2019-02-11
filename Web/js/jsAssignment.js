window.onload = function(){
    console.log("Page Loaded");
    currTime();
    document.getElementById('run-fib').addEventListener('click', () => {runFibonacci(); clearFields();});
    document.getElementById('run-bubble-sort').addEventListener('click', () => {runBubbleSort();});
    document.getElementById('run-reverse').addEventListener('click', () => {runReverseString(); clearFields();});
    document.getElementById('run-factorial').addEventListener('click', () => {runFactorial(); clearFields();});
    document.getElementById('run-even-number').addEventListener('click', () => {runEvenNumber(); clearFields();});
    document.getElementById('run-palindrome').addEventListener('click', () => {runIsPalindrome(); clearFields();});
    document.getElementById('run-delete-element').addEventListener('click', () => {runDeleteElement();  clearFields();});
    document.getElementById('run-splice-element').addEventListener('click', () => {runSpliceElement();  clearFields();});
    // document.getElementById('run-define-contructor').addEventListener('click', runDefineContructor);
    document.getElementById('run-desc-order').addEventListener('click', () => {runDescOrder(); clearFields();});
}


var clearFields = () => {
    document.getElementById("number-input").value = "";
    document.getElementById("string-input").value = "";
}

var clearAnswer = (id) => {
    document.getElementById(id).innerHTML = "";
}

// 1. Fibonacci 
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
var runFibonacci = () => {
    let num = document.getElementById('number-input').value;
    var nthFib = (num) => {
        let fibArr = [];
        let num1 = 0;
        let num2 = 1;
        for(let i = 1; i <= num; i++){
            fibArr.push(num1);
            let sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return fibArr.pop();
    }
    document.getElementById('fib-answer').innerHTML = (nthFib(num));
}


// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
var runBubbleSort = () => {
    let arr = document.getElementById('string-input').value.split(', ');
    var bubbleSort = (array) => {
        let num = 0;
        for(let i = 0; i < arr.length; i++){
            for(let j = 0; j < arr.length; j++){
                if(arr[j-1] > arr[j]){
                    num = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = num;
                }
            }
        }
        return array;
    }
    document.getElementById('bubblesort-answer').innerHTML = (bubbleSort(arr));
}

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
    document.getElementById('reverse-answer').innerHTML = (reverseString(str));
}


// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
var runFactorial = () => {
    let num = document.getElementById('number-input').value;
    var factorial = (num) => {
        if(num == 0){
            return 1;
        } else {
            return num * factorial(num-1);
        }
    }
    document.getElementById('factorial-answer').innerHTML = (factorial(num));
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
var runEvenNumber = () => {
    let num = document.getElementById('number-input').value;
    var evenNum = (num) => {
        if((num & 1) == 0){
            return true;
        }
        return false;
    }
    document.getElementById('evennum-answer').innerHTML = (evenNum(num));
}

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
    document.getElementById('palindrome-answer').innerHTML = (isPalindrome(str));
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
    let arr = document.getElementById('string-input').value.split(', ');
    var deleteElement = (array) => {
        console.log(arr.length);
        delete arr[2];
        console.log(arr.length);
        return array;
    }
    document.getElementById('delete-element-answer').innerHTML = (deleteElement(arr) + "  -----  Array Length: " + arr.length);
}


// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
var runSpliceElement = () => {
    let arr = document.getElementById('string-input').value.split(', ');
    var spliceElement = (array) => {
     console.log(arr.length);
     arr.splice(2, 1);
     console.log(arr.length);
     return array;
    }
    document.getElementById('splice-answer').innerHTML = (spliceElement(arr) + "  -----  Array Length: " + arr.length);
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
   var run = setTimeout(function(){ currTime(); }, 500);
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

var runDescOrder = () => {
    let num  =  document.getElementById('number-input').value
    var descOrder = (num) => {
        if(num > 0){
            let numArr = String(num).split('');
            let sortedNum = numArr.sort((a, b) => b-a ).join('');
        return sortedNum;
        } else {
            return "No Negative Numbers!"
        }
    }
    document.getElementById('desc-order-answer').innerHTML = (descOrder(num));
}
