const objLiteral = function(obj) {
    for(let a in obj) {
        console.log(`Property: ${a}, Value: ${obj[a]}`)
    }
}