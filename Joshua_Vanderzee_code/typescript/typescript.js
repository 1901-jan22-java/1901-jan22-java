var num = 10;
var bool = true;
var str = "hello world";
var arr = [1, 5, 16, 1, 61, 51];
var arr2 = ["hello", "world"];
arr[2];
var pair;
pair = [1, "josh"];
var Days;
(function (Days) {
    Days[Days["Mon"] = 0] = "Mon";
    Days[Days["Tue"] = 1] = "Tue";
    Days[Days["Wed"] = 2] = "Wed";
    Days[Days["Thu"] = 3] = "Thu";
    Days[Days["Fri"] = 4] = "Fri";
})(Days || (Days = {}));
;
var today = Days.Thu;
var idk;
idk = 5;
idk = {};
idk = 'This is fine to reassign';
//functions
function add(a, b) {
    return a + b;
}
var n = add(1, 2);
function neverType() {
    throw new console.error('never reaches end of method');
}
function anotherNever() {
    while (true) {
    }
}
function voidType() {
}
//objects
function create(a) {
}
create({ name: "josh" });
//create("josh"); // does not work
create(null);
var something = "this is a string";
var len = something.length;
