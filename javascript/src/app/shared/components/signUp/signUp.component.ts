import { Component,Input } from '@angular/core';

@Component({
  selector: 'sign-up',
  templateUrl:'./signUp.component.html',
  styleUrls: ['./signUp.component.css']
})

export class SignUpComponent{

  @Input() userIdentity:any;
  private progressAction:String;
  private userData:any;
  private title="Sign Up";

  constructor() {
  	this.progressAction = "userIdentity";
  }

  userIdentityStatus(response: any) {
   	if(response.status){
   		this.userData = response.userData.items;
   		this.progressAction='userValidation';
   	}
  }

  userValidationStatus(status: boolean){
  	if(status){
  		this.progressAction='userLocationSetup';
  	}
  }
  
  userLocationSetupStatus(status:boolean){
  	if(status){
  		this.progressAction='userAccountSetup';
  	}
  }

  userAccountSetupStatus(status:boolean){
  	if(status){
  		this.progressAction='';
  		//Redirect to home pge..
  	}
  }

}