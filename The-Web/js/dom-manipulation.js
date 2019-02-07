window.onload = function(){
    console.log("js page loaded");
}

function fizzBuzz(n){
    /*
        Take in a number n, and print out 1-n replacing every multiple of 3 with "fizz", 
        every multiple of 5 with "buzz", and every multiple of both 3 and 5 with "fizzbuzz"
    */
    
    var nums = [n];

    for(i = 0; i < n; i++)
    {
        if(i%3 == 0)
            nums[i] = "fizz";
        else
        {
            if(i%5 == 0)
            {
                nums[i] = "buzz";
            }
            else
            {
                if(i%3 == 0 && i%5 == 0)
                    nums[i] = "fizzbuzz";
                else
                    nums[i] = i;
            }
        }

        console.log(nums[i]);
    }
}