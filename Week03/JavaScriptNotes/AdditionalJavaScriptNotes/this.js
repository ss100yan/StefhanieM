/*
 * We'll now discuss the "this" keyword in JavaScript. So what is it? Well,
 * in JavaScript this keyword refers to whatever object it belongs to, meaning:
 * 
 * -when used alone, it refers to the global window object
 * -when used in a function, it refers to the global window object
 * -when used with event handlers, it refers to the HTML element that is the
 *  recipient of the event
 */

//EXAMPLES:

//the "this" keyword used alone:

var windowObject = this; //the value of windowObject is, indeed, the window
//used within a function

var bigFoot = "Bigfoot is real.";

function aFunc(){
	var bigFoot = "Bigfoot is a myth.";
	console.log(this.bigFoot); //this prints "Bigfoot is real" because the window object owns this function. JScript sucks.
}

aFunc();

//used within an event handler (within an HTML file, which is why this is
//throwing an error in this file)
{/* <button onclick="this.style.display='none'"> This Is Button Text </button> */}