window.onload = function(){
    //apply an event listener to my button so that when it is clicked, 
    //the function runFizzBuzz() is invoked
    document.getElementById('runFizz')
        .addEventListener('click', runFizzBuzz);
}

/*
DOM MANIPULATION AND SELECTION 
- interact with DOM elements using JavaScript

Finding Elements 
document.getElementById(id)
document.getElementsByTagName(name)
document.getElementsByClassName(name)

Changing Elements 
e.innerHTML = 
e.[attribute] =
e.setAttribute(attr, value);
e.style

Addding/deleting elements 
document.createElement
e.appendChild
e.removeChild
e.replaceChild 
document.write(text)

various relationships between elements used to navigate:
parentNode, childNodes[index], firstChild, lastChild, nextSibling, previousSibling

EVENT HANDLING
- Events are occurrences in our clientside environment that we can 
respond to progarammatically 

Types of events 
input - blur, change, select, submit, reset, keydown, keypress, keyup..
mouse - mousedown, mouseover, mouseout, mouseup
click - click, dblclick
load - onload, onrelease, onerror

Event listeners
- in line
(in html)
<div onclick = "doThings"><div>
(in JS)
function doThings(){ // some functinoality }
--> not preffered; tightly couples your script 

- method 
[element].onclick = function(){ //some functionality}

- event listener -> long form 
[element].addEventListener(event, function, [useCapture])
- event = type of event 
- function = can be defined in the parameter but is usually a call 
to a separate function. If you are calling a function from 
the param, do NOT use (), this will immediately invoke the function 
and will render the event listener useless 
- useCapture - optional. default = false. This is how your listener
will deal with event propagation, or how functions will be carried 
out in the event of more than one event listener being applied to a 
particular element (think nested elements, each with their own event
listener). useCapture = true means that the events will "capture 
inwards", or the listener applied to the outermost element will 
happen first then propagate inwards. Whereas useCapture = false, the
default option, means that events will "bubble outwards", or the 
event applied to this particular element will happen first, 
then the events applied to the parent elements 


*/


function fizzBuzz(n){
    /*
        Take in a number n, and print out 1-n replacing every multiple of 3 with "fizz", 
        every multiple of 5 with "buzz", and every multiple of both 3 and 5 with "fizzbuzz"
    */
   var arr = [];
   for(var i = 1; i <= n; i++){
    if(i%15==0) arr.push('FizzBuzz');
    else if(i%5==0) arr.push('Buzz');
    else if(i%3==0) arr.push('Fizz');
    else arr.push(i);
   } 
    return arr;
}

function runFizzBuzz(){
    var n = document.getElementById('fbn').value;
    var values = fizzBuzz(n);


    document.getElementById('buzzTable')
        .removeAttribute('hidden');

    //empty table before adding new rows 
    var tableBody = document.getElementById('buzzTableBody');
    while(tableBody.hasChildNodes()){
        tableBody.removeChild(tableBody.firstChild);
    }

    //for each element in our fizzbuzz array, do the following
    for(let i = 0; i < values.length; i++){
        //create tr and 2 td elements 
        let row = document.createElement('tr');
        let cell1 = document.createElement('td');
        let cell2 = document.createElement('td');

        //add text to the td elements 
        cell1.innerHTML = i+1;
        cell2.innerText = values[i];

        //append td to tr 
        row.appendChild(cell1);
        row.appendChild(cell2);

        //append row to table 
        tableBody.appendChild(row);
    }
}