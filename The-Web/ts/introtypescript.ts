/* 
 * TypeScript is a super set of JS, meaning that any valid JS code is also valid TS code,
 * however TS code must be TRANSPILED into JS code. 
 * 
 */

// typing
let num = 10;
let bool: boolean = true;
let str: string = 'hello-world';

// type coercion
let coercion = num + str;

// array
let arr: number[] = [1, 4, 5, 6];

// generic array
let arr2: Array<string> = ['hello', 'world'];
arr2[1];

// 
let pair: [number, string];
pair = [1, 'there is a 1 in here somewhere'];

enum Day { Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday };
let today: Day = Day.Tuesday;
today = 3;

let idk: any;
idk = 6;

// functions can have return type and parameter types
function add(a: number, b: number): number {
    return a + b;
}

function neverType(): never {
    throw new Error("never reaches end of method");
}

function anotherNever(): never {
    while (true) {

    }
}

function voidType(): void {
    // return 4; // cannot return this
}

/*  OBJECTS

    Object is a type that represents the non-primitive entities (everything that 
        is not a number, string, boolean, symbol, null, undefined)

    Object.create()
*/

declare function create(o: object | null): void;

create({ name: "name1" });
// create("name2"); // does not work
create(null);

/*  Type Assertions
    
    - a way to tell the transpiler "hey I know what I"m doing"
    - its like a type cast in other languages, but performs no
    special checking or resturcturing of data. It is purely used
    by the transpiler
*/

let something: any = "something is a string";
something = 10
let len: number = (<string>something).length;


/*  Interfaces
        Definingan interface in TS allows you to type-check combinations
        of variables. They do not transpile to JS.
        They exist solely to help developers.
*/
interface User {
    id: number;
    username: string;
    password: string;
    optional?: string;
    createAccount(): number;
}

let u1: User = {
    id: 1,
    username: 'testUser',
    password: '123',
    createAccount: function () {
        return 100;
    }
}

/* CLASSES
    - Class in TS are similar to classes in most OOP languages properties are made
    public by default but can be made private or protected
    - when a number is private, it cannot be accessed from out of its containing class
    - protected acts similarly to private, except members declared protected can also 
    be accessed in deriving classes.
    - public entities can be accessed anywhere
*/
class Point {
    x: number;
    y: number;

    constructor(x: number, y: number) {
        this.x = x
        this.y = y
    }

    getDistance() {
        return Math.sqrt(Math.pow(this.x, 2) * Math.pow(this.y, 2))
    }
}

let pointA = new Point(5, 10);
console.log(pointA.getDistance())
pointA.x = 10;
pointA.y = 5;
console.log(pointA.getDistance())

class Point3D extends Point {
    z: number;

    constructor(x: number, y: number, z: number) {
        super(x, y)
        this.z = z
    }

    getDistance() {
        let d = super.getDistance();
        return Math.sqrt(Math.pow(this.z, 2) + Math.pow(d, 2))
    }
}

class Animal {
    private name: string;

    constructor(name: string) {
        this.name = name;
    }

    getName(): string{
        return this.name;
    }

    setName(name: string): void{
        this.name = name;
    }
}



