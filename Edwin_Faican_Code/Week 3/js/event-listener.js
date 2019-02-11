document.getElementById("inner").addEventListener('click', function() {
    alert('INNER');
    //Stops remaining events from happening. 
    event.stopPropagation();
});

document.getElementById("middle").addEventListener('click', function() {
    alert('MIDDLE');
    event.stopPropagation();
});

document.getElementById("outer").addEventListener('click', function() {
    alert('OUTER');
});