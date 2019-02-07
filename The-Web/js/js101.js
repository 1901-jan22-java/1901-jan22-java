/*
JavaScript is a scripting language used for 
client side operations 

Do note, however, that there are many frameworks 
that allow the server-side use of JS. It's known 
as a client-side language because it can be 
interpreted from the browser

- loosely typed  - we do not declare variable types, 
  they are dynamically allocated based on the assignment
  of the varable. We declare variables with one of 
  the three keywords
  - let - allows for block scope
  - var - does not distinguish between block and function scope
  - const - does not allow vars to be reassigned
- var scopes 
  - global - accessible throughout the entirety of the script
  and through the console in the browser. Globally scoped
  variables are declared outside of any function or block
  OR they have just never been declared and their declaration
  is "hoisted" to the top of the page, making them global
  - function 
  - block - only with the use of let or const 
- datatypes include number, string, boolean, objects, 
  undefined, NaN (debatable bc typeOf(NaN) = number)
- if..else, returns, switch, try..catch, do..while, 
for, breaks, continue, while 
- TRUTHY AND FALSY
    - because JS is loosely typed, we have to be able to 
    assign everything a true or false identity so that they 
    can be evaluated as conditions in control statements 
    - FALSY - false, null, 0, undefined, NaN, ""
    - TRUTHY - everything else 
- Type coersion - the process that JS takes to bring data
from one type to another to compare the actual value as opposed 
to the datatype 




*/

var a = 5;
var b = 'this is a string with single quotes';
var c = "this is a string with double quotes. both work";
//var no = "this is a string';
var obj = {
    name : 'Genesis Bonds',
    job : 'Senior Trainer', 
    bio : 'I really like food'
};

obj.name;
obj["name"];
obj["about me"] = "this is how we can create and access properties " + 
   "of our objects with spaces in their names; not that you should "+ 
   "ever do that..";
obj.age = 100;

//FOR... IN LOOP - iterate through properties of an object 
for(var p in obj){
    console.log("The property " + p + " has the value " + obj[p]);
    //STRING INTERPOLATION `` to inject JS variables directly into strings
    console.log(`The property ${p} has the value ${obj[p]}`);
    console.log(`${2 + 10*93809}`);
}

//FOR... OF LOOP  - enhanced for in java


function test(){
    return 0;
}

function anotherTest(str){
    console.log(str);
}

var func = function(a, b){
    return a + b;
}
func();

//ARROW NOTATIONS "fat arrow" =>
var arrow = (a, b) => {return a + b;}
arrow(3, 4);

//////////////////////////////////
/*
Guard operator - &&
- takes 2 operands 
- if the first op is TRUTHY, the operator returns the second operand
- NOT returning just true or false, its returning the operand itself 
- otherwise it returns the first operand 
*/
var currentSession = 1982714;
var sessionUser = {username: 'gab12', password: '123'};

var user  = currentSession && sessionUser;

/*
Default operator - || 
if the first operand is truthy, return it 
else, we return the second operand
*/
var base = 35000;
var raise = 40000;

var salary = raise || base;

       //[expression]? [T] : [F]
var s = (raise > 0) ? raise : base;






