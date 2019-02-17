/*
Type Script is a superset of JS

*/

//Types - typeScript allows for strict typing
let num: number = 10;
let bool: boolean = true;
let str: string = 'hello world';

let coercion = num + str;

let arr: number[] = [1, 4, 2, 6];
let arr2: Array<string> = ['hello', 'world'];

//Tuples - allow you to express an array where the type of a fixed number of elements is known
// but need not be the same

let pair: [number, string];
pair = [1, 'Genesis'];
//cannot switch order

//Enums - a way of giving friendly names to sets of numeric values

enum Days {Monday, Tuesday, Wednesday, Thursday, Friday};
let today: Days = Days.Thursday;
today = 3;

//any

let idk: any;
idk = 6;
idk = 'hello';

// functions have return types and param types
function add(a: number, b: number): number {
    return a + b;
}

let n = add(1, 2);


function neverType(): never{
    //this means that the end of the method is unreachable
    throw new Error('never reaches the end of the method');
}

//Objects - A type that represents the non primative entities 
declare function create(o: object | null): void;

create({name: "Barry"});
create(null);


//angle bracket syntax
let something: any = "something is a string";
something = 10;
let len: number = (<string>something).length;

//Interfaces - defining an interface in TS allows you to type-check combinations
// of variables. they do not transpile to JS, they exist solely to help devs

interface User{
    id:  number;
    username: string;
    password: string;
    optional? : string;
    createAccount(): number;
}

let u1: User = {
    id: 1,
    username: 'testuser',
    password: '123',
    createAccount: () => {
        return 100;
    }
}

//Classes in ts are similar to classes in most OOP languages
//Properties are made public by default but can be made private or protected
//When a member is private, it cannot be accessed form outside of its containing class
//Protected acts similarly to private, except members declared protected can also be accessed in derived classes
//Public entities can be accessed anywhere

class Point{
    x: number;
    y: number;

    constructor(x: number, y: number){
        this.x = x;
        this.y = y;
    }

    getDistance(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

}

let pointA = new Point(5, 10);
pointA.x = 10;
console.log(pointA.getDistance());

class Point3D extends Point{
    z: number;

    constructor(x: number, y: number, z: number){
        super(x, y);
        this.z = z;
    }

    getDistance(){
        let dist = super.getDistance();
        return Math.sqrt(dist*dist + this.z*this.z);
    }
}

let pointB = new Point3D(3, 4, 5);

