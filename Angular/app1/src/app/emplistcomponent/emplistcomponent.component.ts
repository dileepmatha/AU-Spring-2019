import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Service1Service } from '../service1.service';
import { PARAMETERS } from '@angular/core/src/util/decorators';
@Component({
  selector: 'app-emplistcomponent',
  templateUrl: './emplistcomponent.component.html',
  styleUrls: ['./emplistcomponent.component.css']
})
export class EmplistcomponentComponent implements OnInit {
  
  emp : string[] = ['e1','e2','e3','e4','e5','e6']; 
  emp_id : number  = 0;
  users : object;
  flag : boolean = false;
  @Input() num: number;
  constructor(private route: ActivatedRoute, private emp_service: Service1Service) {
    this.route.params.subscribe(params => this.emp_id = params.id)
  }
  ngOnInit() {
    this.emp_service.get_users().subscribe(data => {
      this.users = data;
    })
  }
  onClick(){
    this.flag = true;
  }
}
