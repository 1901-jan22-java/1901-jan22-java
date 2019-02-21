interface User{
    id: number;
    username: string;
    password: string;
    optional?: string;
    createAccount(): number;
}

let u1: User = {
    id: 1,
    username: "josh",
    password: 'dfgbfg',
    createAccount: () => {
        return 100;
    }
}

class Point{
    x: number;
    y: number;

    constructor(x: number, y: number){
        this.x = x; //must use this key word to refer to instance
        this.y = y;
    }

    getDistance(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
}

let pointA = new Point(5,10);
pointA.x = 10;
console.log(pointA.getDistance());

class Point3D extends Point{
    z: number;

    constructor(x: number, y: number, z:number){
        super(x,y);
        this.z = z;
    }

    getDistance(){
        let dist = super.getDistance();
        return Math.sqrt(dist*dist + this.z*this.z);
    }
}

let pointB = new Point3D(3,4,5);