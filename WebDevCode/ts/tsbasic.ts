/*
TypeScript is a superset of JS, meaning that any valid
JS code is also valid TS code, however TS code must be TRANSPILED into JS code.
(not compiled in the sense of turning our code into some sort of bytecode but transpiled turning our TS into valid vanilla JS to be interpreted by the browser)


-TS allows for strict typing, arrow notation, interfaces, classes, constructors, access modifers, properties, and modules

Strict typing is optional but it is encourage number, boolean, string, void, null, undefined, any, never 


-



TYPES - TypeScript Allows for strict typing
*/

let num: number = 10;
let bool: boolean = true;
let str: string = 'hello'; 


// For coercion
let coercion = num + str; // -- this is type coercion


//arrays

let arr: number[] = [1,2,3,4,5,6,7];


//any

let idk: any;
idk = 6;
idk = {};
idk = 'this is still ok to reassign';



//generic array type Array<elemType>
let arr2: Array<string> = ['hello', 'world'];
arr2[1]; //accesss arrays



/* Tuple
Tuple types allow you to express an array where the type
of a fixed number of element is known, but need not be the same.
*/

let pair: [number, string];
pair =  [1, 'Genesis'];
//cannot switch order
//pair = ['genessis', 1];


/*
Enum
- a way of giving friendly names to set of numeric values

*/


enum Days {Monday, Tuesday, Wednesday, Thursday, Friday};
let today: Days = Days.Thursday;
today = 3;




// Functions can have return types and param types
function add(a: number, b: number): number{
    return a + b;
}
let n = add(1 , 2);
//let wrong = add( 'hello' , 'world');

function neverType(): never{

    //this means that the end of the method is unreachable
    throw new Error('NEVER REACHES END OF THE METHOD STOP LOOKING');

}

function anotherNever(): never{
    while(true){

    }
}

//OBJECTS

/*
object is a type that represents the non primitive entities (everything that is not a number, string, boolean, symbol, null, undefined)
Object.create

*/

declare function create(o: object | null): void;

create({name: 'Genesis'});
//create('Genesis'); //does not work
create(null);


/*
Type Assertions
-a way to tell the transpiler "hey i know what im doing"
- its like a type cast in other languages, but performs no special checking or restructuring of data. It is purely used by the transpiler
*/


//angle-bracket syntax
let something: any = "something is a string";
let len: number =(<string>something).length;


/*INTERFACES
Defining an interface in TS allows you to type-check combination of variables. They do not transpile to JS. They exist solely to help developers


*/

interface User{
id: number;
username: string;
password: string;
optional? : string; // does not have to be a property
createAccount(): number;


}

let u1: User = {
    id: 1,
    username: 'testuser',
    password: '123',
    createAccount: () =>
    {
        return 100;
    }
}


/*Classes
classes in TS are similiar to classes in most OOP languages properties are made
public by efault but can be made private.
-when a  member is private, it cannot be access from outside
of its containing class

-protected acts similarly to private, except members delcared protected can also be accessed in deriving classes
-public entities can be accessed anywhere

*/


class Point{
x: number;
y: number;


//default constructor if not applied
constructor(varX: number, varY: number)
{
this.x=varX; //must use "this" to refer to instance vars
this.y=varY;
}


//in classes, functions are called methods and no longer use the function
getDistance(){ //from 0,0
    return Math.sqrt(this.x*this.x + this.y*this.y);
}



}

let pointA = new Point( 5 , 10);
pointA.x = 10; //instance
console.log(pointA.getDistance());

class Point3D extends Point{
    z:number;

    constructor(x: number, y: number, z: number){
        //constructors in derived sub classes must contain a call to super
        super(x,y);
        this.z = z;


    }
    getDistance(){
        let dist = super.getDistance();
        return Math.sqrt(dist*dist + this.z * this.z);



    }

}


let pointB = new Point3D(3, 4, 5);