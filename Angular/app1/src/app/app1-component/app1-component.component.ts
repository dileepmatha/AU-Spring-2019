import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-app1-component',
  templateUrl: './app1-component.component.html',
  styleUrls: ['./app1-component.component.css','../app.component.css']
})
export class App1ComponentComponent implements OnInit {

  myName: string;
  new_date: Date;   
  cmp : string[] = ['Acco','hyd','scr','www'];
  temp: boolean;
  constructor() {
    this.myName="Dileep";
    this.new_date = new Date();
    this.temp = true;
   }
  ngOnInit() {
  }
  get_name(){
    this.myName = "Dileep Matha";
  }
  button_fn(){
    alert("Hello Dileep");
  }
}
