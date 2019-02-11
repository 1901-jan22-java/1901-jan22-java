const printShape = function(shape, height, char) {
    shape = shape.toUpperCase();
    switch(shape) {
        case 'DIAMOND' : diamond(height, char); break;
        case 'SQUARE'  : square(height, char); break;
        case 'TRIANGLE': triangle(height, char); break;
    }
}

function diamond(height, char) {
    let line = char;
    let spaces = Math.floor(height/2) -1;
    let chars = 0;

    for(let i=0; i<=Math.floor(height/2); i++) {
        for(let j=0; j<=spaces; j++) {
            line = ' ' + line ;
        }
        spaces--;
        for(let k=1; k<=chars; k++) {
            line = line + char + char;
        }
        chars++;
        console.log(line);
        line = char;
    }
    spaces = 0;
    chars = Math.floor(height/2) - 1;
    for(let i=0; i<=Math.floor(height/2) - 1; i++) {
        for(let j=0; j<=spaces; j++) {
            line = ' '  + line;
        }
        spaces++;
        for(let k=1; k<=chars; k++) {
            line = line + char + char;
        }
        chars--;
        console.log(line);
        line = char;
    }
}

function square(height, char) {
    let line = '';

    for(let i=1; i<=height; i++) {
        line = line + char;
    }
    for(let i=1; i<=height; i++) {
        console.log(line);
    }
}

function triangle(height, char) {
    let line = '';

    for(let i=1; i<=height; i++) {
        line = line + char;
        console.log(line);
    }
}