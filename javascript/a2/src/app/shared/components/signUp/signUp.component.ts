import { Component,ViewEncapsulation } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'sign-up',
  templateUrl:'./signUp.component.html',
  styleUrls: ['./signUp.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class SignUpComponent{

 tabLinks = [
    {label: 'Elector Identity Info', link: 'userIdentity'},
    {label: 'Validate Elector Info', link: 'userValidation'},
    {label: 'Location Info', link: 'userLocationSetup'},
    {label: 'Account Info', link: 'userAccountSetup'},
  ];
  
  activeLinkIndex = 0;

  constructor(private router: Router) {
    this.activeLinkIndex =
        this.tabLinks.indexOf(this.tabLinks.find(tab => router.url.indexOf(tab.link) != -1));
  }
}