window.onload = function() {
    //Apply an event listener to button so that when it is clicked, the function runFizzbuzz is invoked. 
    document.getElementById('runFizz').addEventListener('click', runFizzbuzz);
}

function fizzbuzz(n) {
    //Take a number n and print out 1-n replacing every multiple of 3 with fizz, multiple of 5 with buzz and multiple with both with fizzbuzz. 
    let arr = [];

    for(let i=1; i <=n; i++) {
        if(i%3 === 0) {
            if(i%5 === 0) {
                arr.push('fizzbuzz');
            } else {
                arr.push('fizz');
            }
        } else if(i%5 === 0) {
            arr.push('buzz');
        } else {
            arr.push(i);
        }
    }
    return arr;
}
var i = 0;

function runFizzbuzz() {
    let n = document.getElementById("fbn").value;
    let values = fizzbuzz(n);
    document.getElementById('buzz-table').removeAttribute('hidden');

    //Empty table before adding new rows. 
    var tableBody = document.getElementById('buzz-table-body');
    while(tableBody.hasChildNodes()) {
        tableBody.removeChild(tableBody.firstChild);
    }

    //Fill table with new rows. 
    for(let i=0; i<values.length; i++) {
        let row = document.createElement('tr');
        let data1 = document.createElement('td');
        let data2 = document.createElement('td');

        row.appendChild(data1);
        row.appendChild(data2);

        data1.innerHTML = (i+1);
        data2.innerText = values[i];

        document.getElementById('buzz-table-body').appendChild(row);
    }
}


