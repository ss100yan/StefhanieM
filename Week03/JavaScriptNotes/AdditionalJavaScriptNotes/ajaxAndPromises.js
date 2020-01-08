/*
 * One of the biggest benefits of using JavaScript is the responsiveness it
 * adds to our web pages. We can easily respond to events on our frontend and
 * manipulate the DOM using some basic JavaScript functions.
 * 
 * But the magic of JavaScript doesn't end there. We can also use JavaScript
 * to make asynchronous requests to servers. And why would we want to do such
 * a thing? To fetch information while allowing our scripts to continue
 * executing, thereby improving user experience.
 * 
 * So how do we make these asynchronous requests? By using AJAX and Promises.
 * 
 * AJAX stands for Asynchronous JavaScript and XML. It allows us to make
 * asynchronous requests to servers using a special object called an 
 * XMLHttpRequest. We can create a new XMLHttpRequest by writing the following:
 */

let xhr = new XMLHttpRequest();

/*
 * We can (optionally) combine Promises with the XMLHttpRequest object. A
 * JavaScript Promise provides a way of handling data that has been retrieved
 * asynchronously. We can create a new Promise by writing the following:
 */

let prom = new Promise();

//But that's a boring Promise. Promises can take a function called an executor
//function as a parameter, and this executor takes two callback functions as 
//parameters that we refer to as "resolve" and "reject". Let's go ahead and
//pass these callback functions into our Promise's constructor:

//P.S. The "=>" is often referred to as arrow notation; it just provides a shorter
//way of declaring a function. You should also note that if you declare a function
//using arrow notation, that function will not bind the "this" keyword to objects
//instantiated using this function.
let prom = new Promise((resolve, reject) =>{
//Do stuff with your callback functions here.
});

//So let's see how we can combine these two objects to get some data from
//a resource!

function get(url){
	//This function will return a Promise object to the caller.
	return new Promise((resolve, reject) =>{
	
	//The XMLHttpRequest has a ready state of 0 here, indicating that an 
	//XMLHttpRequest has been created.
	let xhr = new XMLHttpRequest();
	
	//The onreadystatechange is a property of the XMLHttpRequest object. More
	//specifically, it's an event handler (like onclick, onscroll, etc.) that
	//executes a callback function each time the XMLHttpRequest's ready state
	//changes.
	xhr.onreadystatechange = function(){
		//We must check that the ready state is 4, which means that the response
		//has been populated on the server side. A ready state of 3 indicates that
		//the request has been received and is being populated.
		if(xhr.readyState == 4){
			//We must also check that the status of the response is 200 (OK).
			if(xhr.status == 200){
				//If the readyState is 4 and the status is 200, we can call our
				//resolve callback function. Within this function, we'll call
				//the JSON.parse function, which parses the response as a JavaScript
				//object
				resolve(JSON.parse(xhr.response));
			}
			//If the ready state is 4 but the status isn't 200...
			else{
				//We call our reject callback function, which constructs an
				//Error object with an error message of our choosing.
				reject(Error("Something went wrong with the request."));
			}
		}
	}
	
	//The XMLHttpRequest has a ready state of 1 here, indicating that the
	//request has been opened.
	xhr.open("GET", url);
	//The XMLHttpRequest has a ready state of 2 here, indicating that it has
	//been sent.
	xhr.send();
	
	});
}

//But when working with Promises, you can't just simply access the data that
//has been returned however you please. You can only access this data within
//a Promise by using the .then() function. Let's take a look:

function getAllPolkamans(){
	let url = "./FetchPolkamans";
	
	get(url).then((data) => {
		//Do stuff with the data you received... Note that this is the
		//only place you can access the data that has been received.
	}).catch((error) => {
		//Or print an error message because something went wrong...
	});
}
