function getRandomChuckJokes(url){
	let xhr = new XMLHttpRequest(); //ready state is 0
	
	//This property defines a callback function which will be called
	//each time the ready state changes.
	xhr.onreadystatechange = function() {
		//Check that the ready state is 4 and that the status is 200 (OK)
		if(xhr.readyState === 4 && xhr.status === 200){
			console.log(xhr.responseText);
			
			//Let's parse our JSON so that we can use what we get back as a JavaScript
			//object.
			let json = JSON.parse(xhr.responseText);
			
			
			let body = document.querySelector("body");
			//enhanced for loop in JavaScript
			for(let j of json.value){
				let h3 = document.createElement("h3");
				h3.innerHTML = j.joke;
				body.append(h3);
			}
		}
	}
	
	xhr.open("GET", url); //ready state is 1
	xhr.send(); //ready state is 2
}

//Anything in here will be called/occur when the window is loaded.
window.onload = function(){
	getRandomChuckJokes("http://api.icndb.com/jokes/random/8");
}