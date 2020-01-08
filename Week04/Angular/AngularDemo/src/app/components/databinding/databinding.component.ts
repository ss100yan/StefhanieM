import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

  secretMessage:string = "You didn't hear this from me, but...";
  buttonText:string = "Hide Text";
  visibility:boolean = false;
  userInput:string = "";

  constructor() { }

  ngOnInit() {
  }

  toggleVisibility(){
    if(this.visibility === false){
      this.buttonText = "Show Text";
    }else{
      this.buttonText = "Hide Text";
    }
    this.visibility = !this.visibility;
  }

}
