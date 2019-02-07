window.onload = function(){
    //apply an event listener to my button so that when it is clicked,
    //the function runFizzBuzz() is invoked
    document.getElementById('runFizz').addEventListener('click',runFizzBuzz);

}
i=0;
function fizzBuzz(n){
    /*
        Take in a number n, and print out 1-n replacing every multiple of 3 with "fizz", 
        every multiple of 5 with "buzz", and every multiple of both 3 and 5 with "fizzbuzz"
    */
    
    var nums = [];

    for(i = 1; i <= n; i++)
    {
        if(i%3 == 0 && i%5 == 0)
            nums.push("fizzbuzz");
        else
        {
            if(i%5 == 0)
                nums.push("buzz");
            else
            {
                if(i%3 == 0)
                    nums.push("fizz");
                else
                    nums.push(i);
            }
        }
    }
    return nums;
}

function runFizzBuzz(){
    var n = document.getElementById('fbn').value;
    var values = fizzBuzz(n);

    //for each element in our fizzbuzz array, do the following
    document.getElementById('buzzTable').removeAttribute('hidden');

    //empty the table before adding new rows
    var tableBody = document.getElementById('buzzTableBody');
    while(tableBody.hasChildNodes()){
        tableBody.removeChild(tableBody.firstChild);
    }

    for(let i = 0; i < values.length; i++){
        //create tr and 2 td elements
        let row = document.createElement('tr');
        let cell1 = document.createElement('td');
        let cell2 = document.createElement('td');

        //add text to the td elements
        cell1.innerHTML = i+1;
        cell1.innerHTML = values[i];

        //append td to tr
        row.appendChild(cell1);
        row.appendChild(cell2);

        //append row to table
        document.getElementById('buzzTableBody').appendChild(row);
    }
}