// 1
fib = {
    list: [1, 1],
    calc: function (n) {
        if (typeof n !== 'number') return n;
        if (this.list[n] != null) return this.list[n];
        for (let i = this.store.length; i <= n; i++) {
            this.list[i] = this.list[i - 1] + this.list[i - 2];
        }
        return this.list[n];
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
// Do not go too high... space complexity will not scale down
// number can only hold so much
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
                res += '\n';
            }
            break;
        case ('Triangle'):
            for (let i = 0; i < h; i++) {
                res += c.repeat(i + 1);
                res += '\n';
            }
            break;
        case ('Diamond'):

            for (let i = 0; i < h; i++) {
                if (i < h / 2) {
                    res += ' '.repeat(Math.floor(h / 2) - i) + c.repeat(2 * i + 1);
                } else {
                    res += ' '.repeat(i - Math.floor(h / 2)) + c.repeat(2 * (h - i) - 1);
                }
                res += '\n';
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
    if (arr.length > 2) arr[2] = null;
    console.log(arr.length);
    return arr;
}
// 11
function spliceElement(arr) {
    console.log(arr.length);
    if (arr.length > 2) arr2 = arr.splice(2, 1);
    console.log(arr.length);
    return arr;
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
        res += (''+i).repeat(count[i]);
    }
    return parseInt(res);
}