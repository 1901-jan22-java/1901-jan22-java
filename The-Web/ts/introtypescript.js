/*
 * TypeScript is a super set of JS, meaning that any valid JS code is also valid TS code,
 * however TS code must be TRANSPILED into JS code.
 *
 */
var __extends = (this && this.__extends) || (function () {
  var extendStatics = function (d, b) {
    extendStatics = Object.setPrototypeOf ||
      ({
          __proto__: []
        }
        instanceof Array && function (d, b) {
          d.__proto__ = b;
        }) ||
      function (d, b) {
        for (var p in b)
          if (b.hasOwnProperty(p)) d[p] = b[p];
      };
    return extendStatics(d, b);
  };
  return function (d, b) {
    extendStatics(d, b);

    function __() {
      this.constructor = d;
    }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
  };
})();
// typing
var num = 10;
var bool = true;
var str = 'hello-world';
// type coercion
var coercion = num + str;
// array
var arr = [1, 4, 5, 6];
// generic array
var arr2 = ['hello', 'world'];
arr2[1];
// 
var pair;
pair = [1, 'there is a 1 in here somewhere'];
var Day;
(function (Day) {
  Day[Day["Monday"] = 0] = "Monday";
  Day[Day["Tuesday"] = 1] = "Tuesday";
  Day[Day["Wednesday"] = 2] = "Wednesday";
  Day[Day["Thursday"] = 3] = "Thursday";
  Day[Day["Friday"] = 4] = "Friday";
  Day[Day["Saturday"] = 5] = "Saturday";
  Day[Day["Sunday"] = 6] = "Sunday";
})(Day || (Day = {}));;
var today = Day.Tuesday;
today = 3;
var idk;
idk = 6;
// functions can have return type and parameter types
function add(a, b) {
  return a + b;
}

function neverType() {
  throw new Error("never reaches end of method");
}

function anotherNever() {
  while (true) {}
}

function voidType() {
  // return 4; // cannot return this
}
create({
  name: "name1"
});
// create("name2"); // does not work
create(null);
/*  Type Assertions
    
    - a way to tell the transpiler "hey I know what I"m doing"
    - its like a type cast in other languages, but performs no
    special checking or resturcturing of data. It is purely used
    by the transpiler
*/
var something = "something is a string";
something = 10;
var len = something.length;
var u1 = {
  id: 1,
  username: 'testUser',
  password: '123',
  createAccount: function () {
    return 100;
  }
};
/* CLASSES
    - Class in TS are similar to classes in most OOP languages properties are made
    public by default but can be made private or protected
    - when a number is private, it cannot be accessed from out of its containing class
    - protected acts similarly to private, except members declared protected can also
    be accessed in deriving classes.
    - public entities can be accessed anywhere
*/
var Point = /** @class */ (function () {
  function Point(x, y) {
    this.x = x;
    this.y = y;
  }
  Point.prototype.getDistance = function () {
    return Math.sqrt(Math.pow(this.x, 2) * Math.pow(this.y, 2));
  };
  return Point;
}());
var pointA = new Point(5, 10);
console.log(pointA.getDistance());
pointA.x = 10;
pointA.y = 5;
console.log(pointA.getDistance());
var Point3D = /** @class */ (function (_super) {
  __extends(Point3D, _super);

  function Point3D(x, y, z) {
    var _this = _super.call(this, x, y) || this;
    _this.z = z;
    return _this;
  }
  Point3D.prototype.getDistance = function () {
    var d = _super.prototype.getDistance.call(this);
    return Math.sqrt(Math.pow(this.z, 2) + Math.pow(d, 2));
  };
  return Point3D;
}(Point));
