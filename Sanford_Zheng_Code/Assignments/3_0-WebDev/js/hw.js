
// 1
fib = {
    list: [1, 1],
    calc: function (n) {
        if (typeof n !== 'number') return n;
        if (fib.list[n] != null) return fib.list[n];
        for (let i = fib.list.length; i <= n; i++) {
            fib.list[i] = fib.list[i - 1] + fib.list[i - 2];
        }
        return fib.list[n];
    }
};

// 2
function bubbleSort(arr) {
    if (!(arr instanceof Array)) return arr;
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) {
                let temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}

// 3
function reverseStr(s) {
    if (!(typeof s === 'string' || s instanceof String)) {
        console.log("this is not a string");
        return s;
    }

    var arr = s.split("");

    for (let i = 0, j = s.length - 1, temp = ""; i < s.length / 2; i++, j = s.length - 1 - i) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    s = arr.join("");
    return s;
}

// 4
factorial = {
    list: [1, 1],
    calc: function (n) {
        if (typeof n !== 'number') return n;
        if (n > 170) return Number.POSITIVE_INFINITY;
        if (this.list[n] != null) return this.list[n];

        for (let i = this.list.length; i <= n; i++) {
            this.list[i] = this.list[i - 1] * i;
        }

        return this.list[n];
    },
    recursion: function (n) {
        if (typeof n !== 'number') return n;
        if (n > 170) return Number.POSITIVE_INFINITY;
        if (this.list[n] != null) return this.list[n];

        return factorial.helper(n);
    },
    helper: function (n) {
        if (n < 2) return 1;
        if (factorial.list[n] != null)
            return factorial.list[n];
        factorial.list[n] = factorial.helper(n - 1) * n;
        return factorial.list[n];
    }
}

// 5
function substring(someStr, length, offset) {
    if (typeof someStr !== 'string' && !(someStr instanceof String) ||
        typeof length !== 'number' || typeof offset !== 'number' ||
        length + offset > someStr.length || length < 0 || offset < 0) {
        alert("Invalid inputs.");
        return;
    }
    return someStr.substr(offset, length);
}

// 6
function isEven(n) {
    return n - Math.floor(n / 2) * 2 === 0;
}

// 7
function isPalindrome(str) {
    if (!str instanceof String || typeof str !== 'string') return false;
    var arr = str.split('');
    for (let i = 0, j = str.length - 1; i < str.length / 2; i++, j--) {
        if (arr[i] !== arr[j]) return false;
    }
    return true;
}

// 8

function printShape(s, h, c) {
    // if ()
    var res = "";
    switch (s) {
        case ('Square'):
            for (let i = 0; i < h; i++) {
                res += c.repeat(h);
                res += '\n<br>';
            }
            break;
        case ('Triangle'):
            for (let i = 0; i < h; i++) {
                res += c.repeat(i + 1);
                res += '\n<br>';
            }
            break;
        case ('Diamond'):

            for (let i = 0; i < h; i++) {
                if (i < h / 2) {
                    res += '&nbsp;'.repeat(Math.floor(h / 2) - i) + c.repeat(2 * i + 1);
                } else {
                    res += '&nbsp;'.repeat(i - Math.floor(h / 2)) + c.repeat(2 * (h - i) - 1);
                }
                res += '\n<br>';
            }
            break;
        default:
            alert("Invalid Shape!");
    }
    return res;
}

// 9
function traverseObject(obj) {
    var res = "";
    for (var p in obj) {
        res += p + " " + obj[p] + '\n';
    }
    return res;
}

// 10
function deleteElement(arr) {
    console.log(arr.length);
    if (arr.length > 2) delete arr[2];
    console.log(arr.length);
    return arr;
}
// 11
function spliceElement(arr) {
    console.log(arr.length);
    if (arr.length > 2) arr2 = arr.splice(2, 1);
    console.log(arr.length);
    return arr2;
}
// 12
function Person(name, age) {
    this.name = name;
    this.age = age;
}
// 13
var peopleObj = {
    list: [new Person('John', 30)],
    getPerson: function (name, age) {
        for (var p in this.list) {
            if (this.list[p].name === name && this.list[p].age === age) {
                return this.list[p];
            }
        }
        return null;
    }
}

// 14
setInterval(() => {
    var date = new Date();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();
    var ampm = 'AM';
    if (hours > 12) {
        hours -= 12;
        ampm = 'PM';
    }
    if (hours == 0) {
        hours = 12;
    }
    if (minutes < 10) {
        minutes = '0' + minutes;
    }
    if (seconds < 10) {
        seconds = '0' + seconds;
    }
    $("#time").html(`${hours}:${minutes}:${seconds} ${ampm}`);
}, 1000);

// 15
function biggestNumWith(num) {
    if (typeof num !== 'number') return num;
    var str = num.toString().split("");
    var count = new Array(10).fill(0);
    for (let c of str) {
        count[c]++;
    }
    var res = "";
    for (let i = 9; i >= 0; i--) {
        res += ('' + i).repeat(count[i]);
    }
    return parseInt(res);
}

$("#q1-button").click(function (){
    var input = Number.parseInt($('#q1-input').val());
    console.log(input);
    var output = fib.calc(input);
    console.log(output);
    $('#q1-output').html(`${output}`);
});
$("#q2-button").click(function (){
    var input = $('#q2-input').val().split(',');
    console.log(input);
    var output = bubbleSort(input);
    console.log(output);
    $('#q2-output').html(`${output}`);
});
$("#q3-button").click(function (){
    var input = $('#q3-input').val();
    console.log(input);
    var output = reverseStr(input);
    console.log(output);
    $('#q3-output').html(`${output}`);
});
$("#q4-button").click(function (){
    var input = Number.parseInt($('#q4-input').val());
    console.log(typeof input);
    var output = factorial.calc(input);
    console.log(output);
    $('#q4-output').html(`${output}`);
});
$("#q5-button").click(function (){
    var input1 = $('#q5-input1').val();
    var input2 = Number.parseInt($('#q5-input2').val());
    var input3 = Number.parseInt($('#q5-input3').val());
    console.log(typeof input1);
    console.log(typeof input2);
    console.log(typeof input3);
    var output = substring(input1, input2, input3);
    console.log(output);
    $('#q5-output').html(`${output}`);
});
$("#q6-button").click(function (){
    var input = Number.parseInt($('#q6-input').val());
    console.log(input);
    var output = isEven(input);
    console.log(output);
    $('#q6-output').html(`${output}`);
});
$("#q7-button").click(function (){
    var input = $('#q7-input').val();
    console.log(input);
    var output = isPalindrome(input);
    console.log(output);
    $('#q7-output').html(`${output}`);
});
$("#q8-button").click(function (){
    var i1 = $('#q8-input1').val();
    var i2 = Number.parseInt($('#q8-input2').val());
    var i3 = $('#q8-input3').val();

    console.log(i1);
    console.log(i2);
    console.log(i3);
    
    var output = printShape(i1, i2, i3);
    console.log(output);
    $('#q8-output').html(`${output}`);
});

// TODO: Implement more questions
// 10
$("#q10-button").click(function (){
    var input = $('#q10-input').val().split(',');
    console.log(input);
    var output = deleteElement(input);
    console.log(output);
    $('#q10-output').html(`${output}`);
});


$("#q15-button").click(function (){
    var i1 = Number.parseInt($('#q15-input').val());
    console.log(i1);
    var output = biggestNumWith(i1);
    console.log(output);
    $('#q15-output').html(`${output}`);
});