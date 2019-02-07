

for (var p in obj){
    //Without String interpalation (pain to type)
    console.log("The property " + p + "has the value " + obj[p]);
    //String interpalation
    console.log(`The property ${p} has the value ${obj[p]}`);
}

function anothertest(){
	return 0
}

anothertest();

var arrow = (a, b) => {
    return a + b;
}

/*
    guard operator - && 
*/

var session = 15616499;
var sesionuser = {user: 'josh', pass: 'fggn'};

var user = session && sesionuser;


//defualt operator - ||
//if the first operatand if truthy returns first

var base = 50000;
var raise = 40000;

var salory = raise || base;

// turnary same as java
var s = raise > 0 ? raise : base;