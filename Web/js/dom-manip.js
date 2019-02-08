window.onload = function(){
    console.log("Page Loaded");
    document.getElementById("runFizz").addEventListener('click', runFizzBuzz);
}
//Event Listener

var fizzBuzz = (n) => {
    let arr = [];
    for(let i = 1; i <= n; i++){
        if(i % 3 == 0 && i % 5 ==0){
            arr.push("FizzBuzz")
        } else if(i % 3 == 0){
            arr.push("Fizz")
        } else if(i %5 == 0){
            arr.push("Buzz")
        } else {
            arr.push(i)
        }
    }
    return arr;
}


var runFizzBuzz = () => {
    var n = document.getElementById('fbn').value;
    var values = fizzBuzz(n);

    document.getElementById('buzzTable').removeAttribute('hidden');

    var tableBody = document.getElementById('buzzTableBody');
    while(tableBody.hasChildNodes()){
        tableBody.removeChild(tableBody.firstChild);
    }

    for(let i = 0; i < values.length; i++){
        let row = document.createElement('tr');
        let cell1 = document.createElement('td');
        let cell2 = document.createElement('td');

        cell1.innerHTML = i + 1;
        cell2.innerText = values[i];

        row.appendChild(cell1);
        row.appendChild(cell2);

        document.getElementById('buzzTableBody').appendChild(row);
    }
};

