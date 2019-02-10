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