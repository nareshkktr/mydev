import { Component,Input } from '@angular/core';
import { HomeService } from './home.service'


@Component({
  selector: 'home',
  templateUrl:'./home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [HomeService]
})

export class HomeComponent{
  @Input() searchTerm: any;
  items:Array<any>;

  constructor(private homeService:HomeService) {}

  searchRepo(){
  	 
  	 alert(this.homeService.getRepositories(this.searchTerm));
                           // .subscribe(
                           //     items => this.items = items.items, //Bind to view
                           //      err => {
                           //          // Log errors if any
                           //          console.log(err);
                           //      });

     
  }

}