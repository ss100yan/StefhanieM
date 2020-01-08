/*
 * What are closures? Closures:
 * 1) Allow an inner function to access an enclosing function's variables
 * 2) Allow an inner function to preserve (closure) an enclosing function's 
 * scope chain when this enclosing function is executed
 *    
 * EXAMPLE:
 */ 

var x = function cake(){
	      var flour = true;
	      var cornMill = false;
	      var cupsSugar = 1;
	      
	    	function bake(){
	      	var heat = 350;
	      	console.log("Oh yeah. Bake that cake at " + heat + "!");
	      	console.log(flour);
	      	console.log(cornMill);
	      	console.log("Cups of Sugar: " + cupsSugar);
	      	
	      	heat++;
	      	flour = !flour;
	      	cornMill = !cornMill;
	      	cupsSugar++;
	      }
	      
	      return bake;
	    }
/*So our inner function bake has the following scope chains:
 * 1)It has access to its own scope (the variable "heat" in this case)
 * 2)It has access to the enclosing function's variables (so "flour" and
 *   "cornMill") because it encloses them when the outer function is executed
 * 3)It has access to any global variables that are defined
 */ 

//Notice that the above function returns a function. This means that the value
//of x is the function bake(), making x a function. As a result, we can write
// x() to execute bake().

//It's also worth noting that the value of x is not the execution of the bake
//function but rather the function itself. In other words, "bake" -- not "bake()"
//is returned.
 
/*
 * Now that we've formally defined closures, let's see them in action. Let's
 * invoke our inner function using x:
 */ 

x(); //invoking our inner function the first time
x(); //invoking our inner function the second time
x(); //and, finally, invoking our inner function a third time

//Let's see what each of these calls to the inner function print!

//When we invoke the inner function the first time, we get:

/*
 * *Oh yeah. Bake that cake at 350!
 * true
 * false
 * 1
 */

//So the value of heat, which is defined in the inner function, is 350.
//The value of flour, which has been preserved from our outer function, is true.
//The value of cornMill, which has been preserved from our inner function, is false.
//The value of cupsSguar, which has been closured as well, is 1

//When invoke the inner function the second time, we get:

/*
 * Oh yeah. Bake that cake at 350.
 * false
 * true
 * 2
 */

//Note that heat's value hasn't changed. That's because heat's scope is the
//inner function. As a result, it is redeclared each time the inner function
//is run, so its value is not preserved.

//flour's value, on the other hand, was closured and altered within the inner
//function, so its value became false when the inner function was first executed.

//Like flour, cornMill was closured and altered within the inner function,
//which is why its value became true when the inner function was first executed.

//Like flour and cornMill, cupsSugar was closured and incremented within the
//inner function on its last run, so its value is 2 when printed.

//And when we invoke the inner function the third time, we get:

/*
 * Oh yeah. Bake that cake at 350.
 * true
 * false
 * 3
 */ 

//Again, heat is redeclared each time the inner function executes, so its
//value when printed is still 350.

//flour has been closured, so its state is preserved, which is why it now
//prints as true

//cornMill has been closured, so its state is preserved, which is why it now
//prints as false

//cupsSugar has been closured, so its state is preserved, which is why it now
//prints as 3

/*
 * NOTE: If we had defined the cake() function and then assigned it to multiple
 * variables, each variable would have closured the outer function's variables
 * when the outer function was executed.
 * 
 * Understand that this means that each of the enclosing variables enclosured
 * the outer function's variables independent of each other. As a result,
 * if I were to create a variable y that holds the inner function and call it
 * once, the value of cupsSugar, for instance, would be 1 when printed.
*/

/*
 * BUT WAIT! There's more! Closures are also super useful when you want to
 * privatize the members of a JavaScript "class" (read: function that is being
 * used as a class because JavaScript doesn't really have classes...)
 * 
 * Have a look at this:
 */

function Christina(){
	var lname = "Russ";
	var hobby = "ice cream";
	var hairTexture = "4a";
	
	//Notice that I'm returning an object which contains multiple objects.
	//Each of these objects is equal to some function. Each of these functions
	//is an inner function that closures the variables from the outer
	//function, thus preserving the outer function's scope.
	
	//This use of closures effectively privatizes the variables lname, hobby,
	//and hairTexture; that is to say, they can't be directly accessed. They
	//can only be accessed via the variables which are equal to some inner
	//functions, which all "members" of the Christina class will have access
	//to.
	return {
		getLastName:function(){
			return lname;
		}, //we use a comma because we are returning multiple objects (which
		   //have been set equal to functions!)
		
		setLastName:function(lastName){
			lname = lname;
		},
	
		getHobby:function(){
			return hobby;
		},
		
		setHobby:function(newHobby){
			hobby = newHobby;
		},
		
		getHairTexture:function(){
			return hairTexture;
		},
		
		setHairTexture:function(newHairTexture){
			hairTexture = newHairTexture;
		}
	}
}

//Let's see how the class we've defined above works:

let me = new Christina(); //instantiate a new Christina

me.getLastName(); //prints "Russ"

me.setLastName("Momoa"); //sets last name to "Momoa"
me.getLastName(); //prints "Momoa"