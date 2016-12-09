import { Component,Input } from '@angular/core';

import { SwaggerService } from '../../services/swagger.service';

import { Router } from '@angular/router';

@Component({
  selector: 'myindia-header',
  templateUrl:'./header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent{

  @Input() searchText: string;
  title = 'My India';

  constructor(private router: Router) {}

  search(){
  	//if(this.searchText.length > 3){
  		 this.router.navigate(['./search',this.searchText]);
	//}
  }
}