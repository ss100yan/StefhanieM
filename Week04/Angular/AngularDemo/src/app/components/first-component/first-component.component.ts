import { Component, OnInit } from '@angular/core';
import { SuperPet } from 'src/app/models/SuperPet';

/*
 *An Angular component contains a file for the view (HTML), a CSS stylesheet, a spec.ts file for testing, and a TypeScript which contains all of our component's logic. A component is a basic building block in Angular; it is an Angular directive which allows us to invoke Angular funtionality without breaking our frontend.

 When we generate a component, a class is created. That class is then annotated with what we refer to as a "decorator". A decorator contains meta data about a component. In this case, we have meta data about our component's CSS selector, the location of the template for our component (an HTML file), and the location of the stylesheet for this component (a CSS file).
 */
@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrls: ['./first-component.component.css']
})

/*
 *This is our class which is generated when we create a component. Yes, there are classes and interfaces in TypeScript.
 */
export class FirstComponentComponent implements OnInit {

  //This contructor keyword defines a constructor for this class.
  constructor() { }

  //Angular has what we refer to as "Lifecycle Hooks". These lifecycle hooks are used by the framework to manage the lifecycle of components.
  ngOnInit() {
  }

  /*
   *Let's create a SuperPet as a field within this FirstComponentComponent class:
   */

   superPet:SuperPet = new SuperPet(1, "Krypto", "Spotted", "Super Dog", 1000);

   messWithSuperPet(){
     //Using our setter
     this.superPet.setAge(4)

     //You must use "this" when referring to instance members of this class.
     //superPet.getAge() //WILL NOT WORK
   }

}
