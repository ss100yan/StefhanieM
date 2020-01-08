function get(url){
	let divvy = document.getElementById("apiDiv");

	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			movies = JSON.parse(xhr.responseText);

			for(let m in movies["Search"]){
				let img = document.createElement('img');
				img.src = movies["Search"][m]["Poster"];
				img.style.borderRadius = "5px";
				divvy.append(img);
			}
		}
	}
	
	xhr.open("GET", url);
	xhr.setRequestHeader("X-RapidAPI-Host", "movie-database-imdb-alternative.p.rapidapi.com");
	xhr.setRequestHeader("X-RapidAPI-Key", "2f530a3db3msh028512351081690p171600jsnf425ee1b906c");
	xhr.send();
}

function post(url){
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4 && xhr.status === 200){
			return JSON.parse(xhr.responseText);
		}
	}
	
	xhr.open("POST", url);
	xhr.send();
}

function propagateDBMovies(){
	let url = "https://localhost:8088/ServletDemo/getflixapi/movie/all";

}

function propagateAPIMovies(searchTerm){
	let url = "https://movie-database-imdb-alternative.p.rapidapi.com/?s="+searchTerm;
	this.get(url);
}

window.onload = function(){
	this.propagateAPIMovies('avenger');
}