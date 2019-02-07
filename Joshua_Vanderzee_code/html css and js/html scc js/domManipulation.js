window.onload = function unload() {
    document.getElementById('runfizz').addEventListener('click', runfizzbuss);
}

function runfizzbuss() {
    var n = document.getElementById('fbn').value;
    var values = fizzbuss(n);
    document.getElementById('busstable').removeAttribute('hidden');
    var tablebody = document.getElementById('bussTablebody');
    while(tablebody.hasChildNodes()){
        tablebody.removeChild(tablebody.firstChild);
    }
    for (let i = 0; i < values.length; i++) {
        let row = document.createElement('tr');
        let cell1 = document.createElement('td');
        let cell2 = document.createElement('td');
        cell1.innerHTML = i+1;
        cell2.innerText = values[i];
        row.appendChild(cell1);
        row.appendChild(cell2);
        tablebody.appendChild(row);
    }
}

function fizzbuss(n) {
    let arr = [];
    for (let i = 1; i <= n; i++) {
        if (i % 3 == 0 && i % 5 == 0)
            arr.push('FizzBuss');
        else if (i % 3 == 0)
            arr.push('Fizz');
        else if (i % 5 == 0)
            arr.push('Buss');
        else
            arr.push(`${i}`);
    }

    return arr;
}