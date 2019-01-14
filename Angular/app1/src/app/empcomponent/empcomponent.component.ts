import { Component, OnInit, Input } from '@angular/core';
// import { Service1Service } from '../service1.service';
// import { PARAMETERS } from '@angular/core/src/util/decorators';
// import { ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-empcomponent',
  templateUrl: './empcomponent.component.html',
  styleUrls: ['./empcomponent.component.css']
})
export class EmpcomponentComponent implements OnInit {
  users: object;
  num : number = 2;
  constructor( ) {
  }

  ngOnInit() {
    
  }

}
