/*
guard operator - &&
takes 2 operands
if the first op is truthy, the operator returns the second operand
not returning just true or false, but the operand itself
otherwise it returns the first operand
*/

var currentSession = 1982714;
var sessionUser = {usernamd: 'gab12', password:'123'};

var user = currentSession && sessionUser;

/*
default operator - ||
if the first operand is truthy, we return it
otherwise we return the second operand
*/

var base = 35000;
var raise = 40000;
var salary = raise || base;

