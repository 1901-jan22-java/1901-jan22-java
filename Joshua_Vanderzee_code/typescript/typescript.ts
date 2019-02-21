let num: number = 10;
let bool: boolean = true;
let str: string = "hello world";

let arr: number[] = [1,5,16,1,61,51];
let arr2: Array<string> = ["hello", "world"];
arr[2];

let pair: [number,string]; 
pair = [1,"josh"];

enum Days {Mon, Tue,Wed,Thu,Fri};
let today = Days.Thu;

let idk: any;
idk = 5;
idk = {};
idk = 'This is fine to reassign';

//functions
function add(a: number, b:number):number {
    return a + b;
}

let n = add(1 ,2);

function neverType():never{
    throw new console.error('never reaches end of method');
    
}

function anotherNever():never {
    while(true){

    }
}

function voidType():void {

}

//objects

function create(a: object | null):void {

}

create({name: "josh"});
//create("josh"); // does not work
create(null);

let something:any = "this is a string";
let len:number = (<string>something).length;