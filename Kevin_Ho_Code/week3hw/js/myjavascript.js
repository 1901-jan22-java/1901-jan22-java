window.onload = function(){
    $('#question1').on('click', runfib);
    $('#question2').on('click', runBubbleSort);
    $('#question3').on('click', runReverseStr);
/*    $('#question4').on('click', factorial);
    $('#question5').on('click', substring);
    $('#question6').on('click', isEven);
    $('#question7').on('click', isPalindrome);
    $('#question9').on('click', traverseObject);
    $('#question10').on('click', deleteElement);
    $('#question11').on('click', spliceElement);
    $('#question12').on('click', Person);
    $('#question13').on('click', getPerson);
*/
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function() {
            this.classList.toggle("active");

            var panel = this.nextElementSibling;
            if (panel.style.display === "block")
                panel.style.display = "none";
            else 
                panel.style.display = "block";
        });
    }

}


//question 4
function factorial(someNum){
    if(someNum == 1)
        return 1;
    else
        return someNum * factorial(someNum-1);
}

//question 5
function substring(someStr, length, offset){
    if(length > someStr.length){
        alert("length is greater than string length");
        return "";
    }
    else if(offset > someStr.length || offset+length > someStr.length){
        alert("trying to access numbers outside of string length");
        return "";
    }
    return someStr.substring(offset, offset+length);
}

//question 6
function isEven(someNum){
/*  runs into too much recursion problem  
    if(someNum == 1)
        return false;
    else if(someNum == 0)
        return true;
    else 
        return isEven(someNum-2);*/

    while(someNum > 0)
        someNum -= 2;
    return someNum == 0;
}

//question 7
function isPalindrome(someStr){
    var startIndex = 0;
	var endIndex = someStr.length-1;
    
    while(startIndex < endIndex)
	{
	    if(someStr.charAt(startIndex) != someStr.charAt(endIndex))
		    return false;
		
	    startIndex++;
		endIndex--;
	}
		
	return true;
}

//question 9
function traverseObject(someObj){
    for(let x of someObj)
    {
        console.log(x);
    }
}

//question 10
function deleteElement(someArr){
    console.log(someArr.length);
    delete someArr[3];
    console.log(someArr.length);
}

//question 11
function spliceElement(someArr){
    console.log(someArr.length);
    someArr.splice(3);
    console.log(someArr.length);
}

//question 12
function Person(name, age){
    this.name = name;
    this.age = age;

}

//question 13
function getPerson(name, age){
    return {name : name, age : age};
}

//question 1
function runfib(){
    var n = $('#ques1').val();
    var values = fib(n);
    
    $("#answer1").parent().find("p").slice(1).remove();

    var answer = document.createElement("p");
    answer.innerHTML = values;
    $("#answer1").append(answer);
}
function fib(n){
    var numbers = [];
    numbers.push(0);
    numbers.push(1);
    for(var i = 2; i < n; i++)
        numbers.push(numbers[i-2]+numbers[i-1]);
    return numbers[numbers.length-1];
}

//question 2
function runBubbleSort(){
    var x = [6, 5, 8, 9, 1, 2, 4, 3, 7];

    $("#answer2").parent().find("p").slice(2).remove();

    var answer = document.createElement("p");
    answer.innerHTML = bubbleSort(x);
    $("#answer2").append(answer);
}
function bubbleSort(numArray){
    var index = numArray.length;
		while(index >= 0)
		{
			for(var i = 0; i < index; i++)
			{
				if(numArray[i] > numArray[i+1])
				{
					var temp = numArray[i];
					numArray[i] = numArray[i+1];
					numArray[i+1] = temp;
				}
			}
			index--;
        }
    return numArray;
}

//question 3
function runReverseStr(){
    var n = $('#ques3').val();
    
    $("#answer3").parent().find("p").slice(1).remove();

    var answer = document.createElement("p");
    answer.innerHTML = reverseStr(n);
    $("#answer3").append(answer);
}
function reverseStr(someStr){
    var str = "";
    for(var i = someStr.length-1; i >=0; i--)
        str += someStr.charAt(i);
    return str;
}
