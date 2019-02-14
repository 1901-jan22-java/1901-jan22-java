/*
TypeScript is a superset of JS, meaning that any valid
JS code is also valid TS code, however TS code must be
TRANSPILED into JS code.
(not compiled, in the sense of turning our code into some
    sort of bytecode but transpiled turning our TS into
    valid vanilla JS to be interpreted by the browser)

- TS allows for strict typing, arrow notation, interfaces,
classes, constructors, access modifiers, properties, and
modules

- Strict typing is optional but it is encouraged
- number, boolean, string, void, null, undefined, any, never
*/
//TYPES - TypeScript allows for strict typing
var num = 10;
//num = 'this is a string';
var bool = true;
var str = 'hello world';
var coercion = num + str; //this is type coercion
//arrays
var arr = [1, 5, 6, 7];
//any
var idk;
idk = 6;
idk = {};
idk = 'this is still ok to reassign';
//generic array type Array<elemType>
var arr2 = ['hello', 'world'];
arr2[1]; //access arrays
/*   Tuple:
Tuple types allow you to express an array where
the type of a fixed number of elements is known,
but need not be the same
*/
var pair;
pair = [1, 'Genesis'];
//cannot switch order
//pair = ['genesis', 1];
/*
Enum
- a way of giving friendly names to sets of numeric values
*/
var Days;
(function (Days) {
    Days[Days["Monday"] = 0] = "Monday";
    Days[Days["Tuesday"] = 1] = "Tuesday";
    Days[Days["Wednesday"] = 2] = "Wednesday";
    Days[Days["Thursday"] = 3] = "Thursday";
    Days[Days["Friday"] = 4] = "Friday";
})(Days || (Days = {}));
;
var today = Days.Thursday;
today = 3;
//functions can have return types and param types
function add(a, b) {
    return a + b;
}
var n = add(1, 2);
//let wrong = add('hello', 'world');
function neverType() {
    //this means that the end of the method is unreachable
    throw new Error('never reaches end of method');
}
function anotherNever() {
    while (true) {
    }
}
function voidType() {
    //return 4;// cannot return anything
}
create({ name: 'Genesis' });
//create('Genesis'); //does not work
create(null);
/*
Type Assertions
- a way to tell the transpiler "hey i know what im doing"
- its like a type cast in other languages, but performs
no special checking or restructuring of data. it is purely
used by the transpiler
*/
//angle-bracket syntax
var something = "something is a string";
var len = something.length;
var u1 = {
    id: 1,
    username: 'testuser',
    password: '123',
    createAccount: function () {
        return 100;
    }
};
