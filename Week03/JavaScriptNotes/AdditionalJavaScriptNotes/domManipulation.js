/*
 * So who wants to have some fun with JavaScript? I do! Let's start by defining
 * DOM manipulation.
 * 
 * But what's a DOM? As you may or may not know (but you should since we
 * theoretically talked about it when we covered HTML), DOM stands for
 * "Document Object Model". A Document Object Model is a representation of all
 * of the elements on a web page. You can think of it as a family tree that
 * contains all of the document's HTML elements and details their lineage.
 * 
 * Now that we've got that covered, let's jump right into DOM manipulation.
 * We'll start by simply selecting elements on a web page using the various
 * JavaScript functions which allow us to grab elements to manipulate them.
 * 
 * We can get elements by:
 * 
 * -id (using the getElementById function)
 * -class name (using the getElementByClassName function)
 * -name (using the getElementByName function)
 * -tag name (using the getElementByTagName function)
 * 
 * EXAMPLES:
 */

//This grabs an element on a page that has the id "theBoyWhoLived"; it also
//grabs Mr. Potter.
document.getElementById("banner");
document.getElementById("body");

// This grabs an element on a page that has the class name "classOf3000"
// document.getElementByClass("classOf3000");

// This grabs an element on a page that has the name "Christina"; I think you
// get the point now, right?
// document.getElementByName("Christina");

// You can also grab several elements at once! This, for instance, grabs all of
// elements that have the class name "class1a"
document.getElementsByClassName("class1a");

// So what do we do with these elements once we've grabbed them? Store them
// in variables.

var heroes = document.getElementsByClassName("class1a");
const banner = document.getElementById("banner");
const navvy = document.getElementById("navvy");
const usernameError = document.getElementById("usernameError");
const passwordError = document.getElementById("passwordError");
const submitButton = document.getElementById("submitForm");

// Alright. So we have all of these elements stored. But that's boring, right?
// Let's try manipulating these elements to have some fun. We'll start by
// using JavaScript to directly alter their attributes and inner HTML.

// This changes the element's inner HTML.
// banner.innerHTML = "I'm Harry's new inner HTML. Check me out!";

// This changes the color of the text within the element to red.
// banner.style.color = "red";

// This changes the element's background color to blue
// wizard.style.backgroundColor= "blue";

// Okay. So we can change our elements' attributes. Big whoop. Let's do
// something
// more exciting. How about creating a new element and adding it to the page?
// We can do so by using the createElement() and append() functions. Take a
// look:

// We use the createElement function and specify that we want to create a div
let div = document.createElement("div");

// And we can then append this new element to an existing element. Let's pretend
// that we have an existing div that has the id "myDiv"

let existingDiv = document.getElementById("myDiv");
// existingDiv.append(div); //and, voila, we have appended our new div to the
// DOM!

// We can also set new attributes for these elements using the setAttribute()
// function

// This changes the background-color property of the style attribute to "blue";
// in layman's terms, the div's background color is now blue
// existingDiv.setAttribute("style", "background-color: blue");

//This gives the newly created div an id of "someId"
div.setAttribute("id", "someId");

// What happens, however, when we no longer want an element on the page? Can
// we remove it? Totes. We'll just use the removeChild() function. Note that
// this function is actually called on the element's parent node. In other
// words,
// we have to locate the element's parent node in order to remove the element.
// Yes, this is a bit circuitous.

// Removing the div we added:
// div.parentNode.removeChild(div);

// NOTE: There's also a way to directly remove the child of an element. If an
// element has a direct child, you can remove said element by invoking the
// removeChild(childObjectHere) function on the parent element.

/*
 * Buuuut...that's still pretty boring, right? We want to dynamically alter our
 * DOM based on events on the frontend. In order to do so, we'll need to take
 * advantage of events and event listeners!
 * 
 * In JavaScript and HTML, an event is something that happens to an element on
 * our frontend. Using JavaScript, we can react to these events! More
 * specifically, we can bind our JavaScript functions to events on our frontend.
 * 
 * There are several events you can respond to in JavaScript. A few of these
 * events include:
 * 
 * onclick onload onmouseover onkeydown
 * 
 * EXAMPLE:
 */

// Some HTML element on our frontend
// <button onclick="someFunc()">This Is A Button</button>
// Our JavaScript function as defined in our script. This function changes
// the background color of some body element (which is identified by the
// id "body")
function hideBanner() {
	let banner = document.getElementById("banner");
	if (banner.hidden === false) {
		banner.setAttribute("hidden", "true");
	}
}

function showBanner() {
	let banner = document.getElementById("banner");
	banner.removeAttribute("hidden");
}

function validateUsername() {
	if (document.getElementsByName("username")[0].value.length < 10) {
		usernameError.removeAttribute("hidden");
		submitButton.setAttribute("disabled", "true");
	} else {
		usernameError.setAttribute("hidden", "true");
		submitButton.removeAttribute("disabled");
	}

}

function validatePassword() {
	if (document.getElementsByName("password")[0].value.length < 10) {
		passwordError.removeAttribute("hidden");
		submitButton.setAttribute("disabled", "true");
	} else {
		passwordError.setAttribute("hidden", "true");
		submitButton.removeAttribute("disabled");
	}
}

// Of course, adding the event to our HTML element as an attribute isn't the
// only way to make our JavaScript respond to an event. We can optionally
// use event listeners! An event listener, well, listens for certain events
// on our frontend and executes a acallback function that has been passed to
// it.

// EXAMPLE:

let body = document.getElementById("body");

// This adds an event listener to the onclick event on the body. Notice that
// you don't need the "on" portion of the event name when passing the event
// to the addEventListner() function.
banner.addEventListener("click", hideBanner);
navvy.addEventListener("click", showBanner);
// body.addEventListener("click", someFunc);

// I'll also note that you can pass in a function declaration as well. This,
// for example, is equally valid:

// body.addEventListener("click", function(){
// body.setAttribute("style", "background-color:red");
// })

// In both cases, we're passing a function to another function. We call this
// function that is being passed in as a parameter a callback function. This
// function's purpose is to be called within the outer function.

/*
 * The addEventListener also takes a third parameter of the boolean data type.
 * If this third parameter isn't passed in, it is assumed to be false, in which
 * case the event handlers will be run on the innermost of nested elements and
 * then travel up to this element's ancestors. This is called BUBBLING.
 * 
 * EXAMPLE:
 */

// If we run the following code, the first alert we'll get is the alert
// associated
// with the innermost element's onclick event. This is the default behavior for
// event propagation in JavaScript.
// <div onclick="alert('This is a div')">
// <div onclick="alert('This is an inner div')">
// <p onclick="alert('This is the innermost element')">Yo!</p>
// </div>
// </div>
// NOTE: Though bubbling is the default behavior for event propagation in
// JavaScript, we can stop bubbling by using the event.stopPropagation()
// function:
// <div onclick="alert('This is a div')">
// <div onclick="alert('This is an inner div')">
// <p onclick="event.stopPropagation()">Yo!</p>
// </div>
// </div>
// But is bubbling your only option? Nope. If we revisit our addEventListener()
// function and pass in a value of true for the third parameter, event handlers
// will instead be run from the outtermost element to the innermost element.
// We call this CAPTURING.
// Let's create our event listener, passing in a value of true for our third
// parameter. This tells JavaScript to use capturing instead.
let body2 = document.getElementById("body");
// body.addEventListener("click", someFunc, true);

// So now if we were to click on the innermost element, the handler would run
// the event on the outer div first and move inward.
// <div onclick="alert('This is a div')">
// <div onclick="alert('This is an inner div')">
// <p onclick="alert('I be the innermost element, matey!')">Yo!</p>
// </div>
// </div>
