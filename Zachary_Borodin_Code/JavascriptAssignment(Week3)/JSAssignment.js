window.onload = function(){
    document.getElementById('runFibBtn').addEventListener('click',runFib);
    document.getElementById('BubbleBtn').addEventListener('click',BubbleSort)
    $('#RevBtn').on('click',ReverseString);
    $('#FacBtn').on('click',Factorial);
    $('#EvenBtn').on('click',Even);
    $('#PalBtn').on('click',Palindrome);
    $('#IterateBtn').on('click',traverseObject);
    $('#DelEleBtn').on('click',DeleteElement);
    $('#SplEleBtn').on('click',SpliceElement);
    $('#SSBtn').on('click',Substring);
}

//1 Find the Nth Fibonacci Number
function Fibonacci (x){
    if(x<0){
        return -1;
    }
    let arr = [1,1]
    for(let i=2; i<x; i++){
        arr.push(arr[i-1] + arr[i-2]);
    }
    let ans = arr[x-1];
    return ans;
}

function runFib(){
    var n = document.getElementById('Fib').value;
    let answer = Fibonacci(n);
    console.log(answer);
    $('#FibOut').html(answer);  
}

//2. Bubble sort an inputed array
function BubbleSort(){
    var n = document.getElementById('Bub').value;
    let arr = n.split(" ");
    var swap;
    var answer =[];
		for(let i=0; i<arr.length-1; i++) { 
			swap = false;
			for(let j=0;j<arr.length-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					//swap the 2 elements
					let temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap = true;	
                }
            
			
        }  
    }
    for(let z =0; z<arr.length; z++) {
        console.log(arr[z]);
        answer.push(arr[z]);
    }
    $('#BubbleOut').html(answer + ",");
}

//3. Reverse a string input
function ReverseString(){
    var x = $('#Rev').val();
   // console.log(x);
    var arr = x.split("");
    console.log(arr);
    var answer=[];
    for(let i=arr.length; i >=0;i--){
        answer.push(arr[i]);
    }
    $('#RevOut').html(answer);
}
//4. Find factorial of given number
function Factorial(){
    var z = $('#Fac').val();
    var ans2 = 1;
    for(let i=z; i>1; i--){
        ans2 = ans2 * i;
    }
    console.log(ans2);
    $('#FacOut').html(ans2);

}

//5. Print a substring of a given string
function Substring(){
    var x = $('#SS1').val();
    var arr = x.split("");
    var lower = $('#SS2').val();
    var upper = $('#SS3').val();
    if(lower <0){
        alert("Invalid lower index");
    }
    if(upper > x.length-1){
      alert("Invalid Upper index");
    }
    if(upper < lower){
       alert("upper index cannot be greater than lower index");
    }
    var ans=[];
    for(i=lower; i<=upper; i++){
      ans.push(arr[i]);
    }
    var res = ans.join("");
    console.log(res);
    $('#SSO').html(res);
}   

//6. Determine if number is even without %
function Even(){
    var z = $('#Even').val();
    var ans;
    while(z >0){
        z = z-2
    }
    if(z == 0){
        ans = "True"
    }
    else {
        ans = "False";
    }
    $('#EvenOut').html(ans);
}

//7. Determine if a string is a palindrome
function Palindrome(){
    var z = $('#Pal').val();
    var arr = z.split("");
    //console.log(arr);
    var rev = [];
    for(let i=arr.length-1;i>=0;i--){
        rev.push(arr[i]);
    }
    var first = arr.join("");
    var second = rev.join("");
    console.log(first);
    console.log(second);
    var result;
    if(first == second){
        result = "True"
    }
    else{
        result = "False"
    }

    $('#PalOut').html(result);


}
//9. Iterate through the properties of an object
function traverseObject(){
    var person={
        name: "Zach",
        age: 23,
        major: "CS"
    };

    var answer ="";
    for( x in person){
        console.log( x + " has the value :" + person[x]);
       answer += (x + " has the value :" + person[x] + "<br>");
    }
    $('#IterateOut').html(answer);
}

//10 Delete the third element
function DeleteElement(){
    var z = $('#DelEle').val();
    var arr =[];
    arr = z.split(" ");
    var ans1 = arr.length;
    $('#DelEleOut1').html(ans1);
    delete arr[2];
    var ans2 = arr.length;
    $('#DelEleOut2').html(ans2);
}

//11. Splice the third element
function SpliceElement(){
    var z = $('#SplEle').val();
    var arr =[];
    arr = z.split(" ");
    var ans1 = arr.length;
    $('#SplEleOut1').html(ans1);
    //console.log(arr);
    arr.splice(2,1);
    var ans2 = arr.length;
    $('#SplEleOut2').html(ans2);
}

