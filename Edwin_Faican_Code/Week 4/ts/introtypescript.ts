/*
Typescript is a superset of JavaScript. 
*/

//Types 
let num: number = 10;
//Now the below will not work because num has a type!
//num = 'hello';
let bool: boolean = true;
let str: string = 'Hello';

let coersion = num + str; //<-- This is still type coersion

let arr: number[] = [1,5,6,7];

//Generic array type Array<elemType>
let arr2: Array<string> = ['help', 'send'];

//'any' typing
let idk: any;
idk = 6;
idk = {};
idk = 'This is still ok to reassign';

//Tuple
let pair: [number,string];
pair = [1, 'Edwin'];

//Enums
enum Days {Monday, Tuesday, Wednesday, Thursday, Friday};
let today: Days = Days.Thursday;
today = 3;

//Functions can have return types and param types
function add(a: number, b: number): number{
    return a + b;
}

let n = add(3,2);

//'never' type
function neverType(): never {
    //The end of the method is unreachable. 
    throw new Error('never reaches end of method');
}

function anotherNever(): never {
    while(true) {

    }
}

//'void' type
function voidType(): void {
    //No return in here. 
}

//Objects
declare function create(o:Object | null): void;

create({name: 'Edwin'});
//Will not work -> create('Edwin');
create(null);

//Type Assertion
let something: any = "something is a string";
let len: number = (<string>something).length;

//Interfaces only exist to aid in type-checking. 
//They do not get included in transpilation process. 
interface User{
    id: number;
    username: string;
    password: string;
    optional?: string; //Does not have to be a property. 

    createAccount(): number; //functions can be peroperties.
};

//Objects created using an interface as a guideline ARE included in transpilation. 
let u1: User = {
    id: 1,
    username: 'test user',
    password: '123',
    createAccount: () => {
        return 200;
    }
};

//Classes in TS
class Point{
    x: number;
    y: number;

    constructor(x: number,y: number){
        this.x = x;
        this.y = y;
    }

    getDistance(){
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2)); 
    }
}

let pointA = new Point(5, 10);
pointA.x = 10;
console.log(pointA.getDistance());

class Point3D extends Point{
    z: number;

    constructor(x: number, y: number, z: number) {
        super(x,y);
        this.z = z;
    }

    getDistance() {
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2));
    }
}

let pointB = new Point3D(2,4,6);
console.log(pointB.getDistance());