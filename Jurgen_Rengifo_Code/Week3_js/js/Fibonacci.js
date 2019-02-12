window.onload = function(){
  $('#question1').on('click', runfib);
  $('#question2').on('click', runBubbleSort);
  $('#question3').on('click', runReverseStr);
  $('#question4').on('click', runFactorial);
  $('#question5').on('click', runSubstring);
  $('#question6').on('click', runIsEven);
  $('#question7').on('click', runIsPalindrome);
  $('#question9').on('click', runTraverseObject);
  $('#question10').on('click', runDeleteElement);

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
//fibonacci
function runfib(){
  var input = $('#ques1').val();
  var output = fib(input);
  $('#answer1').append(output);
}
function fib(n){
  var numbers = [];
  numbers.push(0);
  numbers.push(1);
  for(var i = 2; i < n; i++)
      numbers.push(numbers[i-2]+numbers[i-1]);
  return numbers[numbers.length-1];
}
//bubblesort
function runBubbleSort(){
  var input = [5, 8, 2, 4, 1, 23, 11, 16, 2, 7];
  var output = bubbleSort(input);
  $('#answer2').append(output);
}
function bubbleSort(arr){
    let temp = 0;
    for(let i=0; i<arr.length-1; i++) {
        for(let j=0; j<arr.length-1; j++) {
            if(arr[j] > arr[j+1]) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    return arr;
}
//reverse string
function runReverseStr(){
  var input = $('#ques3').val();
  var output = reverseStr(input);
  $('#answer3').append(output);
}
function reverseStr(str){
  var reverseStr = "";
  for (var i = str.length - 1; i >= 0; i--) {
      reverseStr += str[i];
  }
  return reverseStr;
}
//factorial
function runFactorial(){
  var input = $('#ques4').val();
  var output = factor(input);
  $('#answer4').append(output);
}
function factor(someNum){
  if (someNum < 0) 
    return -1;
  if(someNum == 1)
      return 1;
  else
      return someNum * factor(someNum-1);
}
//substring
function runSubstring(){
  var input1 = $('#ques5a').val();
  var input2 = Number.parseInt($('#ques5b').val());
  var input3 = Number.parseInt($('#ques5c').val());
  var output = substring(input1, input2, input3);
  $('#answer5').append(output);
}
function substring(someStr, length, offset){
  var str = "";
  for(let i = offset; i <= length; i++)
      str += someStr.charAt(i);
  return str;
}
//check if even
function runIsEven(){
  var input = $('#ques6').val();
  var output = isEven(input);
  $('#answer6').append(output);
}
function isEven(someNum){
  if (someNum % 2 == 0){
    return(true);
  }
 else{
    return(false);    
  }
}
//palindrome
function runIsPalindrome(){
  var input = $('#ques7').val();
  var output = isPalindrome(input);
  $('#answer7').append(output);
}
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
//Tranverse object
function runTraverseObject(){
  var n = $('#ques9').val();
  var obj = n.split(",");
  traverseObject(n);
}
function traverseObject(someObj){
  for(let x of someObj)
  {
      var answer = document.createElement("p");
      answer.innerHTML = x;
      $("#answer9").append(answer);
  }
}
//delete an elemnet
function runDeleteElement(){
  var input = $('#ques10').val();
  var output = deleteElement(input);
  $('#answer10').append(output);
}
function deleteElement(someArr){
  delete someArr[3];
}
//constructor
class Person {
  constructor(name, age) {
      this.newName = name;
      this.newAge = age;
  }
  get name() {
      return this.newName;
  }
  get age() {
      return this.newAge;
  }
};