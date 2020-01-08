import { Component, OnInit } from '@angular/core';
import { SuperPet } from 'src/app/models/SuperPet';
import { SuperpetService } from 'src/app/services/superpet.service';

@Component({
  selector: 'app-angular-directives',
  templateUrl: './angular-directives.component.html',
  styleUrls: ['./angular-directives.component.css']
})
export class AngularDirectivesComponent implements OnInit {

  visible:boolean = false;
  //Let's create a SuperPet array to iterate over using ngFor.
  superPets:SuperPet[] = [new SuperPet(1, 'Pekachu', 'Yellow', 'Thunder', 2), new SuperPet(2, 'Firemander', 'Orange', 'Fire', 4), new SuperPet(3, 'Plant Monster', 'Aqua/Green', 'Nature', 1), new SuperPet(4, 'Pokaball Monster', 'Color of a Pokaball', 'Self Destruction', 1), new SuperPet(5, 'Ultimate Alien Pokamon', 'White', 'Being Stronger Than All Other Pokamon', 100)]

  styleObject = {
    color:"lavenderblush",
    backgroundColor:"cadetblue"
  }

  //Tight Coupling. The Angular Directives Component class depends on this SuperPetService object for it's functionality. If I must change the constructor for the SuperPetService class, I will have to return here and manually change this code.
  // superPetService:SuperpetService = new SuperpetService(new SuperPet(1, "annoying", "some color", "powerful", 78));
  
  /*
   *Recall that Angular services can be injected into other components. Let's try injecting our SuperService into this component:

   NOTE: When we declare our SuperService object here, we are also creating it as a property on this AngularDirectivesComponent class. This is a fast way of creating a property on a class and declaring a parameter within our constructor.

   Let's talk a bit about the idea of Dependency Injection (DI). Dependency injection is a design pattern which attempts to eliminate tight coupling within applications. Under ordinary circumstances, a class is tightly coupled with its dependency's implementation, meaning that a change in the dependency's implementation would necessitate a change in the dependent class' implementation.
   */
  constructor(private superPetService:SuperpetService) { }

  ngOnInit() {
    this.getSuperPets();
  }

  toggleVisibility(){
    this.visible = !this.visible;
  }

  changeStyle(){
    this.styleObject.color="cadetblue";
    this.styleObject.backgroundColor="lavenderblush";
  }

  /*
   *When using Angular, the standard for handling asynchronous requests is using Observables. Observables come from the RxJS (Reactive Extensions for JavaScript) library. They are preferred over Promises (something that is supported in ECMAScript (ES6)).

   What is the difference between a Promise and an Observable? While both Promises and Observables provide ways of handling asynchronous requests...

   Promises...
   -Are not cancellable.
   -Promises can only be resolved once, so you cannot await a stream    of data over a period of time.
   -Supported in ECMAScript (ES6)
   -Require that you pass error handling off to the next Promise if     you're chaining your promises.
   -Promises are eager; they will be immediately resolved.

   Observables, on the other hand...
   -Are cancellable.
   -Can be resolved multiple times, so you CAN await a stream over a    data over a period of time.
   -Are the Angular standard.
   -Observables are lazy, so they won't be resolved until we "subscribe".
   */
  getSuperPets(){
    this.superPetService.getAllSuperPets().subscribe(
      //This is a handler function for the payload (data received in our response body)
      data => {
        console.log(data);
        this.superPets = data;
      },
      //This is a handler function for any errors; if something should go wrong with our request, this is triggered.
      error => {
        console.log("Whoops! Something went wrong with your request!");
      }
    );
  }

}
