/*
TypeScript is a superset of JS, meaning that any valid
JS code is also valid TS code, however TS code must be TRANSPILED into JS code.
(not compiled in the sense of turning our code into some sort of bytecode but transpiled turning our TS into valid vanilla JS to be interpreted by the browser)


-TS allows for strict typing, arrow notation, interfaces, classes, constructors, access modifers, properties, and modules

Strict typing is optional but it is encourage number, boolean, string, void, null, undefined, any, never


-



TYPES - TypeScript Allows for strict typing
*/
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var num = 10;
var bool = true;
var str = 'hello';
// For coercion
var coercion = num + str; // -- this is type coercion
//arrays
var arr = [1, 2, 3, 4, 5, 6, 7];
//any
var idk;
idk = 6;
idk = {};
idk = 'this is still ok to reassign';
//generic array type Array<elemType>
var arr2 = ['hello', 'world'];
arr2[1]; //accesss arrays
/* Tuple
Tuple types allow you to express an array where the type
of a fixed number of element is known, but need not be the same.
*/
var pair;
pair = [1, 'Genesis'];
//cannot switch order
//pair = ['genessis', 1];
/*
Enum
- a way of giving friendly names to set of numeric values

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
// Functions can have return types and param types
function add(a, b) {
    return a + b;
}
var n = add(1, 2);
//let wrong = add( 'hello' , 'world');
function neverType() {
    //this means that the end of the method is unreachable
    throw new Error('NEVER REACHES END OF THE METHOD STOP LOOKING');
}
function anotherNever() {
    while (true) {
    }
}
create({ name: 'Genesis' });
//create('Genesis'); //does not work
create(null);
/*
Type Assertions
-a way to tell the transpiler "hey i know what im doing"
- its like a type cast in other languages, but performs no special checking or restructuring of data. It is purely used by the transpiler
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
/*Classes
classes in TS are similiar to classes in most OOP languages properties are made
public by efault but can be made private.
-when a  member is private, it cannot be access from outside
of its containing class

-protected acts similarly to private, except members delcared protected can also be accessed in deriving classes
-public entities can be accessed anywhere

*/
var Point = /** @class */ (function () {
    //default constructor if not applied
    function Point(varX, varY) {
        this.x = varX; //must use "this" to refer to instance vars
        this.y = varY;
    }
    //in classes, functions are called methods and no longer use the function
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    return Point;
}());
var pointA = new Point(5, 10);
pointA.x = 10; //instance
console.log(pointA.getDistance());
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = 
        //constructors in derived sub classes must contain a call to super
        _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    Point3D.prototype.getDistance = function () {
        var dist = _super.prototype.getDistance.call(this);
        return Math.sqrt(dist * dist + this.z * this.z);
    };
    return Point3D;
}(Point));
var pointB = new Point3D(3, 4, 5);
