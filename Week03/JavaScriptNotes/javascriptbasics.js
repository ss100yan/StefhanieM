/*There are 3 different ways to declare a variable in JavaScript. We can use the "var", "let", or "const" keywords like so:
*/

var a = 4
let b = 'stuff'
const c = 76

/*The "var" keyword hoists a variable's declaration to the top of its scope and allows you to redeclare the variable within the same scope.

The "let" keyword does NOT hoist a variable's declaration to the top of its scope. In fact, it lexically scopes a variable. It also prevents you from redeclaring that variable.

The "const" keyword also does NOT hoist a variable's declaration to the top of its scope, so it lexically scopes a variable as well. It also prevents you from redeclaring a variable AND assigning any other value to the reference.
*/

/*There are several different data types in JavaScript. We have:

*function
*undefined
*null
*boolean
*object
*number
*string
*symbol

Let's take a look at each one in more detail:
*/

//Functions are objects that can be passed to other functions and assigned to variables.
let f = function aFunc(){
    console.log('This is a function, yo.')
}

//In order to invoke this function, we must do the following:

f() //Use the reference as the function.

//When a variable is undefined in JavaScript, the variable exists but has not yet been assigned a value.
var u = undefined

const n = null

var b = true

var obj = new Object()

//OR

var obj = {}

var num = 7

var str = 'string'

//Closures

function Christina(hair, dress, shoes){
    this.hair = hair
    this.dress = dress
    this.shoes = shoes

    return {
        getHair: function(){return hair},
        setHair: function(newHair){hair = newHair},
        getDress: function(){return dress},
        setDress: function(newDress){dress = newDress},
        getShoes: function(){return shoes},
        setShoes: function(newShoes){shoes = newShoes}

    }
}

let me = new Christina('afro', 'lotta dresses', 'new shoes')

//Hoisting

var myVar = 4

function hoistMe(){
    console.log(myVar)
    var myVar = 5 //This is hoisted
    //let myVar = 5 //This DOES NOT get hoisted
    //const myVar = 5 //Nor DOES this
}

//Prototypal Inheritance

function turnDown(){}

let forWhat = new turnDown()

turnDown.prototype.prop1 = 'new prop'

/*
 * forWhat inherits from turnDown, so it can access      any property that is on the prototype chain.
 */
console.log(forWhat.prop1)