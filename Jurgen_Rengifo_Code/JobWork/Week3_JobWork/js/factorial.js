function runFactor(){
    var n = document.getElementById('fbn').value;
    $("#runProgram").parent().find("p").slice(1).remove();
    var answer = document.createElement("p");
    answer.innerHTML = factorial(n);
    $("#runProgram").append(answer);
}
function factor(someNum) {
    if (someNum < 0) 
          return -1;
    else if (someNum == 0) 
        return 1;
    else {
        return (someNum * factor(someNum - 1));
    }
    return someNum;
  }