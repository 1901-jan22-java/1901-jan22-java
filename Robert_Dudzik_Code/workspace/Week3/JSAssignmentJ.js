window.onload = function()
{
    document.getElementById('runFib').addEventListener('click', Fobonacci);
    document.getElementById('runSort').addEventListener('click', Bubble);
    document.getElementById('runRev').addEventListener('click', Rev);
    document.getElementById('runFac').addEventListener('click', Factorial);
    document.getElementById('runSub').addEventListener('click', SubString);
    document.getElementById('runEven').addEventListener('click', Modulos);
    document.getElementById('runPali').addEventListener('click', Palindrome);
    document.getElementById('runObj').addEventListener('click', ObjLiteral);
    document.getElementById('runSplice').addEventListener('click', SpliceElement);
    document.getElementById('runDelete').addEventListener('click', DeleteElement);
}

function DeleteElement()
{
    let arr = [ 1, 4, 3, 5, 8, 10];
    delete arr[3];
    $('#delOut').html(arr.length);
}
function SpliceElement()
{
    let arr = [ 1, 4, 3, 5, 8, 10];
    arr.splice(3, 1);
    $('#spliOut').html(arr.length);
}

function ObjLiteral()
{
    let obj = 
    {
        name : 'Robert',
        age : 21, 
        height : "5'8"
    };
    let answer = "";
    for(let i in obj)
    {
        answer = answer + obj[i] + ', ';
    }
    $('#objOut').html(answer);
}


function Fobonacci()
{
    let x = $('#fib').val();
    let prevNum = 0;
    let nextNum = 1;
    let sum = 0;
    for(let i = 1; i <= x; i++)
    {
        sum = prevNum + nextNum;
        prevNum = nextNum;
        nextNum = sum;
    }
    console.log(sum);
    $('#fibOut').html(sum);
}

function Palindrome()
{
    let x = $('#pali').val();
    let arr = x.split('');
    arr = arr.reverse();
    let answer = '';
    for(let i = 0; i < arr.length; i++)
    {
        answer = answer + arr[i];
    }
    console.log(answer);
    console.log(x);
    if(x === answer)
    {
        $('#paliOut').html('True');
    }
    else
    {
        $('#paliOut').html('False')
    }
}

function Rev()
{
    let x = $('#rev').val();
    let arr = x.split('');
    arr = arr.reverse();
    $('#revOut').html(arr);
}

function Modulos()
{
    let x = $('#checkEven').val();
    x = Number(x);
    while(x > 0)
    {
        x = x -2;
    } 
    if(x == 0)
    {
        $('#evenOut').html('True');
    }
    else
    {
        $('#evenOut').html('False');
    }
}

function Factorial()
{
    let x = $('#fac').val();
    function iFactorial(a)
    {
        if(a == 0)
        {
            return 1;
        }
        return a * iFactorial(a - 1);    
    }
   // let anser = iFactorial(x);
    $('#facOut').html(iFactorial(x));
}

function SubString()
{
    let string = $('#offStr').val();
    let offSet = $('#offOff').val();
    let len = $('#offLen').val();
    string = string.split('');
    if(string.length < offSet || string.length < Number(offSet) + Number(len))
    {
         alert('Out of bounds!');
    }
    else
    {
        let answer = [];
        console.log(string);
        console.log(string[offSet]);
        for(let i = 0; i < len; i++)
        {
            answer.push(string[Number(offSet) + i]);
            console.log(string[Number(offSet) + i]);
        }
        console.log(answer);
        $('#offOut').html(answer);
    }
   
}

function Bubble()
{
    let x = $('#sort').val();
    let arr = x.split(' ');
    for(let i = 0; i < arr.length - 1; i++)
    {
        for(let j = 0; j < arr.length - i; j++)
        {
            if(arr[j] > arr[j + 1])
            {
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    let answer = [];
    for(let z = 0; z < arr.length; z++)
    {   
        answer.push(arr[z]);
    }
    $('#sortOut').html(answer + ', ');
}