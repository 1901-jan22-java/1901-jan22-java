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
/* CLASSES
classes in TS are similar to classes in most OOP languages
properties are made public by defauly but can be made private
or protected
- when a member is private, it cannot be accessed from outside
of its containing class
- protected acts similarly to private, except members declared
protected can also be accessed in deriving classes
- public entities can be accessed anywhere
 */
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x; //must use "this" to refer to instance vars
        this.y = y;
    }
    //in classes, functions are called methods and no longer use the function keyword
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    return Point;
}());
var pointA = new Point(5, 10);
pointA.x = 10;
console.log(pointA.getDistance());
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = 
        //constructors in derived(sub) classes must contain a call to super
        _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    //overriding Point's getDistance(). must be of same return type
    Point3D.prototype.getDistance = function () {
        var dist = _super.prototype.getDistance.call(this);
        return Math.sqrt(dist * dist + this.z * this.z);
    };
    return Point3D;
}(Point));
var pointB = new Point3D(3, 4, 5);
//understanding private 
var Animal = /** @class */ (function () {
    function Animal(name) {
        this.name = name;
    }
    Animal.prototype.getName = function () {
        return this.name;
    };
    Animal.prototype.setName = function (name) {
        this.name = name;
    };
    return Animal;
}());
var animal = new Animal('Puppy');
//console.log(animal.name); //will not work; name is private
console.log(animal.getName()); //works. using Encapsulation***
//animal.name = 'Tomcat'; //same; still does not work
animal.setName('Tomcat');
//understanding protected 
var Person = /** @class */ (function () {
    function Person(name) {
        this.name = name;
    }
    return Person;
}());
var Employee = /** @class */ (function (_super) {
    __extends(Employee, _super);
    function Employee(name, department) {
        var _this = _super.call(this, name) || this;
        _this.department = department;
        return _this;
    }
    Employee.prototype.getElevatorPitch = function () {
        return "Hello, my name is " + this.name + " and I work\n        in " + this.department + ".";
    };
    return Employee;
}(Person));
var emp1 = new Employee("John", "Sales");
//console.log(emp1.name); //cannot access name directly outside of subclass
console.log(emp1.getElevatorPitch()); //works fine
/* READONLY modifier
    You can make properties read only.
    These properties must be initialized at their declaration or in the constructor
    Allows you to work in a functional way(unexpected mutation is bad)
    Can use modifier in interfaces as well. Can be initialized but not reassigned
*/
var Car = /** @class */ (function () {
    function Car() {
        this.numWheels = 4;
    }
    return Car;
}());
var c1 = new Car();
//c1.brand = 'Honda'; //does not work as car is created without brand
console.log(c1.numWheels); //can access
console.log(c1.brand);
// c1.numWheels = 10; // reassignment will not work
var Car2 = /** @class */ (function () {
    function Car2(brand) {
        this.numWheels = 4;
        this.brand = brand;
    }
    return Car2;
}());
var c2 = new Car2('Honda'); //can be set via constructor
var c3 = new Car2('Toyota');
//c2.brand = 'Hyundai'; //still not able to be reassigned
/*  STATIC
Thus far, we've only discussed instance members of a class. But it's important
to note that we have static members, which are visible on the class itself
and not instances
*/
var Calculator = /** @class */ (function () {
    function Calculator() {
    }
    Calculator.add = function (a, b) {
        return a + b;
    };
    Calculator.subtract = function (a, b) {
        return a - b;
    };
    return Calculator;
}());
var numb = Calculator.add(10, 3);
/* ABSTRACT CLASS
Abstract classes are base classes from which other classes may be derived. They
may not be instantiated directly. Unlike an interface, an abstract class may
contain implementation details for its members. The abstract keyword is used
to define abstract classes as well as abstract methods within an abstract class
Methods within an abstract class that are marked abstract have no implementation
and must be implemented in derived classes; they must use the abstract keyword;
*/
var Account = /** @class */ (function () {
    function Account() {
    }
    return Account;
}());
var CheckingAccount = /** @class */ (function (_super) {
    __extends(CheckingAccount, _super);
    function CheckingAccount() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    CheckingAccount.prototype.generateReports = function () {
        console.log('concrete');
    };
    return CheckingAccount;
}(Account));
