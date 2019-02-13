 
                         $('#fib_but').on              ('click', call_fib);//fibonacci  
    document.getElementById('fib_but').addEventListener('click', call_fib);
                         $('#rev_but').on              ('click', call_rev);//reverse string 
    document.getElementById('rev_but').addEventListener('click', call_rev);
                         $('#bub_but').on              ('click', call_bub);//bubble sort  
    document.getElementById('bub_but').addEventListener('click', call_bub);
                         $('#fct_but').on              ('click', call_fct);//factorial
    document.getElementById('fct_but').addEventListener('click', call_fct);
                         $('#evn_but').on              ('click', call_evn);//even check  
    document.getElementById('evn_but').addEventListener('click', call_evn);
                         $('#pal_but').on              ('click', call_pal);//palindrome check  
    document.getElementById('pal_but').addEventListener('click', call_pal);
                         $('#obj_but').on              ('click', call_obj);//obj info  
    document.getElementById('obj_but').addEventListener('click', call_obj);
                         $('#del_but').on              ('click', call_del);//delete element
    document.getElementById('del_but').addEventListener('click', call_del);
                         $('#spl_but').on              ('click', call_spl);//splice element  
    document.getElementById('spl_but').addEventListener('click', call_spl);
                         $('#sha_but').on              ('click', call_sha);//print shape  
    document.getElementById('sha_but').addEventListener('click', call_sha);

function call_fib()     { $('#fib_out').html(fib          ($('#fib_in').val()));            }
function call_rev()     { $('#rev_out').html(reverseStr   ($('#rev_in').val()));            }
function call_bub()     { $('#bub_out').html(bubbleSort   ($('#bub_in').val()));            }
function call_fct()     { $('#fct_out').html(factorial    ($('#fct_in').val()));            }
function call_evn()     { $('#evn_out').html(isEven       ($('#evn_in').val()));            }
function call_pal()     { $('#pal_out').html(isPalindrome ($('#pal_in').val()));            }
function call_obj()     { $('#obj_out').html(travObject   ($('#obj_in').val()));            }
function call_del()     { $('#del_out').html(deleteElement($('#del_in').val()));            }
function call_spl()     { $('#spl_out').html(spliceElement($('#spl_in').val()));            }
function call_sha()     { $('#sha_out').html(printShape   ($('#sha_in').val()));            }

function stringToArray(string)
{
  var array = string.split(','); return array;
}

function fib(num) 
{
  if(num<=0){ return 0;}
  if(num==1){ return 1;}
  return fib(num - 1) + fib(num - 2)
}

function reverseStr(someStr) 
{
    var newString = "";
    for (var i = someStr.length - 1; i >= 0; i--) {
        newString += someStr[i];
    }
    return newString;
}

function bubbleSort(arrayString)
{
  numArray = stringToArray(arrayString.toString());
  count = 0; //will count if next element is sorted
  index = 1; //will start from 2nd element

    while(count<numArray.length-1)
    {
            
      if(index==numArray.length){
        count = 0; 
        index = 1;
      }
      
      temp_holder = numArray[index];
          
          console.log(numArray[index] < numArray[index-1]);
      
      if(numArray[index] < numArray[index-1])
            {
        numArray[index] = numArray[index-1];
        numArray[index-1] = temp_holder;
      }
      else{
        count++;
      }
      
      index++;
    }
     
  return numArray.toString();
}

function factorial(someNum)
{
  output = someNum;
		while( output > 1 ){
			someNum = someNum * (output-1);
			output--;
		}
  return someNum;
}

function isEven( num)
	{
		numFloor = Math.floor( num / 2);
		
		if ( (num / 2) - numFloor == 0)
		{
		
			return true;
		}
		
		return 'false';
}

function isPalindrome(someStr)
{
  someStr = someStr.replace(/[^0-9a-z]/gi, "");
  toBeReached = Math.floor(someStr.length/2);
  flag = true;
  
  if(someStr.charAt(0)==someStr.charAt(someStr.length-1))
  {
    
        for (j = 1; j < toBeReached; j++) 
        {   
       
            var a = someStr.charAt(j);
            var b = someStr.charAt((someStr.length-1)-j);
          
            if(a!=b) 
            {
   
              return 'false';
            }
        }
  }
  else 
  {

    return 'false';
  }
 
  return flag;
}

function travObject(object1)
{
  console.log(object1);
}

function deleteElement(input)
{
  someArr = stringToArray(input.toString());
  console.log(someArr.length);
  delete someArr[3]
  console.log(someArr.length);
  return "arr:["+someArr+"]"+' | size:'+someArr.length;
}

function spliceElement(input)
{
  someArr = stringToArray(input.toString());
  console.log(someArr.length);
  someArr.splice(3,1);
  console.log(someArr.length);
  return "arr:["+someArr+"]"+' | size:'+someArr.length;
}

function printShape(input)
{
  array = stringToArray(input.toString());

  shape = array[0];
  height = parseInt(array[1],10);
  character = String(array[2]);
  var shapeOut = '';
  buildingBlock = '';
  
     switch(shape)
    {
      case 'Square':   for(i=0; i<height; i++)
                       {
                           for(j=0; j<height; j++)
                           {
                               buildingBlock += character;
                           }
                           buildingBlock+="\n";
                           shapeOut+=buildingBlock;
                           buildingBlock = '';
                       }
        
                        break;

      case'Triangle':  for(i=0; i<height; i++)
                       {
                         for(j=0; j<i+1; j++)
                         {
                           buildingBlock += character;
                         } 
                         buildingBlock+="\n";
                       }
                        shapeOut+=buildingBlock;
                        break;
 
        
        
      case 'Diamond':   pad = '';
                        padSize = 0;
                        revArray = [];
        
                        barSize = 0;
                        
                        mid = Math.floor(height/2)
                        decCount = mid;
                        incCount = 0;
        
                        for(i=0; i<height; i++)
                        {
                          if(i<mid+1)
                            {
                              item = i*2+1;
                              revArray.push(item);
                       
                              for(j=0; j<i+1+incCount; j++)
                              {
                                 buildingBlock+=character;
                              } incCount++
                            }
                           
                          if(i>mid)
                            {
                              decCount--;
                              barsize = revArray[decCount]
                              
                              for(j=0; j<barsize; j++)
                          
                              buildingBlock+=character;
                            }
                          padSize = (height - buildingBlock.length)/2;
                        
                          for(j=0; j<padSize; j++)
                          {
                              pad+= " ";
                          }
                          buildingBlock = pad + buildingBlock + pad + "\n";
                          shapeOut+=buildingBlock;
                          buildingBlock = ''; pad = ''
                        }
                       
                        break;
                        
    }
    shapeOut = shapeOut;
    //console.log(shapeOut='ooo');
  return shapeOut.toString();
}
  