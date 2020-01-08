import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { SuperPet } from '../models/SuperPet';
import { Observable } from 'rxjs';

/*
 *An Angular service is another type of Angular directive that does not require a view. Hence the reason our service does not have a template or a style sheet. Services are instead used to lend some functionality to other components. Another benefit of using services is that they are reusable as we can inject them into many different components.

 Note that "Injectable" decorator that marks this service. This decorator specifies that we may inject this service into another component via dependency injection.
 */
@Injectable({
  providedIn: 'root'
})
export class SuperpetService {

  // constructor(private superPet:SuperPet) { }

  /*
   *If you're using Angular, the framework provides an abstraction over AJAX. This abstraction is a part of the HttpClientModule. This module allows you to make HTTP requests easily (or, at the very least, more easily than you can using AJAX yourself).
   */
  constructor(private http:HttpClient){}

  getAllSuperPets(){
    /*
     *Our HttpClient returns an Observable, but a generic Observable by default. In Angular, we can enforce a type on our Observable.
     */
    return this.http.get("http://localhost:8088/ServletDemo/hello") as Observable<SuperPet[]>;
  }

}
