import { Component } from '@angular/core';

@Component({
  selector: 'myindia-header',
  templateUrl:'./header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent{
  title = 'My India';

  constructor() {}

}