/*All objects in JavaScript inherit from a prototype. We refer to this as prototypal
 * inheritance. Don't, however, confuse prototypal inheritance with class inheritance;
 * the two are fundamentally different.
 * 
 * When an object inherits from a class, it inherits its own copies of the class' methods
 * and fields. When an object inherits from a prototype, on the other hand, it doesn't
 * inherit its own copies of the prototype's functions and variables. Rather, JavaScript
 * creates a link between the prototype and the child object and travels up the "prototype
 * chain" to find any functions and variables which exist for objects of the prototype.
 * 
 * So how do we take advantage of prototypal inheritance? By using a JavaScript function
 * as a constructor!
 * 
 * EXAMPLE:
 */

//This creates a function called Fabulous, which we'll use as a constructor. And, yes, it's
//typical to begin your function name with a capital letter if you intended to use it as a
//prototype for objects. We can even add properties to it.
function Movie() {

};

// Now let's create a JavaScript object using our Movie prototype.
let m = new Movie();

// ...And let's alter the prototype by adding some properties to it:
Movie.prototype.id = 0;
Movie.prototype.name = "";
Movie.prototype.rating = 0;
//We can even add functions as properties:
Movie.prototype.message = function() {
	console
			.log("Come see me. I promise not to be worse than the Last Airbender or Death Note live action film.");
}

// Now we can access that property on all objects which inherit from the
// Movie prototype!
m.message(); // This will print the message we defined above! Ntoe that this property is a function, so we must use the "()" to invoke it.

// So let's try creating a new function that has a constructor that takes
// parameters:
function Genre(id, name) {
	
}

// And create a new object which inherits from it:
let g = new Genre(1, "Bad Horror Film");

//Now here's the catch: We can't access these properties like we did with the other ones.
//In fact, if we try to access them this way, they'll be undefined! Because, duh, they're
//parameters...not properties...
g.id; // undefined
g.name; //undefined

// In order to access these properties, we have to give our Genre some methods using its prototype:
Genre.prototype.purr = function() {
	console.log("Puuurrrr!");
}

//And make socks purr:
socks.purr();

/*
 * Note that prototypal inheritance can be powerful and, therefore, dangerous! You can alter
 * a prototype after an object has been created, and that object which inherits from this 
 * prototype will, indeed, gain access to the prototype's new properties.
 */

//Okay. But what about subclasses? That is to say, can I make an object of another class
//inherit from my Cat "class"? Yes! Let's start by creating a new class:
function ACatInAHat(hats, trouble){
	this.hats = hats;
	this.trouble= trouble;
}

//And create an object of type ACatInAHat:
let badKitty = new ACatInAHat(1, 'So Much');

/*
 * Now we can use the Object.create() function. This function creates a new object, but it uses
 * an existing object as the prototype of the newly created object.
 */
ACatInAHat = Object.create(Cat);

//As of ECMAScript 2015, you can create classes in JavaScript. These "classes", however, are nothing but lies since they work over the existing prototypal inheritance and constructor functions...
class AClass {
	constructor(value1, value2){
		this.value1 = value1;
		this.value2 = value2;
	}
}

class BClass extends AClass {
	constructor(v1, v2){
		super(v1, v2);
	}
}