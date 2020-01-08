/*
 * JavaScript has three scopes: global, local, and block scope.
 * -global variables are accessible from anywhere in your code; any variable
 *  that is declared outside of the scope of a function is globally scoped
 * -local variables are only accessible within the scope of the functions in
 *  which they are declared; this is also called functional scope since local
 *  scope is created by functions in JavaScript
 * -block-scoped variables are accessible only within the blocks in which they
 *  are declared; in order to create a block-scoped variable, you must use the
 *  "let" keyword, which became available after the release of the ECMAScript
 *  6 standards
 */

/*
 * Fun Fact: In JavaScript, variables with the same name can be created at
 * multiple layers of nested scopes. In these cases, local variables will
 * take precedence over global variables. This is called "shadowing" because
 * the inner variable is said to be shadowing the outer variable! 
 * For instance:
 */

let a = 5;

function turnUp(){
	//This is valid in JavaScript. When JavaScript looks for the variable
	//a, it will prioritize this locally declared variable.
	let a = "Turn down for what!";
}

//But be careful! The following code doesn't produce the same result:

let a = 5;

function turnUpAgain(){
	a = "Turn down for what? For accidentally declaring a gloabl variable. That's what.";
}

//So what's the problem? Variables declared without a keyword such as "let" or
//"var" are by default global variables. In other words, assigning "a" a new
//value in this case will absolutely overwrite the existing a's value. Ooops!

//NOTE: If you use "strict mode", the linter will throw an error when you attempt
//to assign a value to a variable without first declaring your variable with the "var"
//or "let" keyword. P.S. Strict mode is for the weak, weaklings!

//...Or for reasonable people who have realized just how silly JavaScript is.

/*
 * Now let's talk about...variable hoisting!
 * 
 * JavaScript variables are comprised of two elements: declarations and
 * assignments.
 * 
 * A declaration includes a keyword such as "let" or "var" and a variable name.
 * 
 * An assignment entails using the assignment operator to actually set a variable
 * equal to some value.
 */

var macaroni; //variable declaration

macaroni = 7; //variable assignment (also known as a variable definition)

let macaroni = "Less macaroni! More cheese! Too much macaroni!"; //variable declaration and assignment

//So why the emphasis on variable declarations versus assignments? Because
//all variable declarations (NOT assignments) in JavaScript are moved to the
//top of their scopes (global, local, etc.). This is referred to as "hoisting"
//since these variable declarations are literally hoisted to the top of their
//scopes.

//EXAMPLE

console.log(boy); //at this point, boy is undefined; because of variable hoisting,
                  //however, it has technically been declared since its declaration
                  //has been moved to the top of its scope

var boy = "good"; //note that this declaration is accompanied by an assignment; this
                  //is not moved to the top of its scope; ONLY declarations are moved
                  //to the tops of their scopes

//So why does this work? Because JavaScript actually interprets the code
//as such:

var boy; //variable declaration is hoisted to the top

console.log(boy); //the variable boy is declared but undefined

boy = "good"; //the variable is assigned a value

/*
 * Hoisting also affects function declarations (NOT function expressions).
 * But what's the difference between the two? Have a look:
 */

function chaChaSlide() {} //function declaration

var catDaddy = function() {}; //function expression

/*
 * Note that you can distinguish a function declaration from a function
 * expression by looking at the "function" keyword's position. If function
 * is the first thing in the statement, a function is being declared. If not,
 * you're looking at a function expression.
 * 
 * All of this to say:
 * 
 * Function declarations (yes, functions' bodies are included) are hoisted
 * to the tops of their scopes as well. In fact, function declarations take
 * precedence over variable declarations. So, in essence, you CAN invoke a 
 * function before you've technically declared it.
 * 
 * NOTE: Interestingly enough, variable assignments take priority over
 * function declarations. Check it out:
 */

var thoseMeddlingKids = function() { //function expression and variable assignment
	console.log("Ruh-oh");
};

function thoseMeddlingKids(){ //function declaration
	console.log("And I would have gotten away with it too if it weren't" +
			" for- Yeah. We get it. Whose mans is this anyway, officer?");
}

thoseMeddlingKids(); //So which one gets called here? As it turns out, this
                     //prints "Ruh-oh". That's because the variable assignment
                     //takes precedence over the function declaration. Gee,
                     //JavaScript sure is strange. :(