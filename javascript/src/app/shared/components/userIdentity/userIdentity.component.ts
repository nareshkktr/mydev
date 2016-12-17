import { Component,EventEmitter,Input,Output } from '@angular/core';
import { UserIdentityService } from './userIdentity.service'
import {Router} from '@angular/router';
@Component({
  selector: 'user-identity',
  templateUrl:'./userIdentity.component.html',
  styleUrls: ['./userIdentity.component.css'],
  providers: [UserIdentityService]
})

export class UserIdentityComponent{

  @Input() voterId: any;
  @Input() name: any;
  @Output() userIdentityStatus = new EventEmitter<any>();

  private userData;

  private eventResponse;

  constructor(private userIdentityService:UserIdentityService,private router: Router) {
  	this.userData = {};
  }

validateElectorInfo(){
	this.router.navigate(['../signUp/userValidation']);
}

  retreiveUser(){
  	this.userIdentityService.retreiveUser(this.voterId,this.name)
                           .subscribe(
                               userData => {
                               	this.userData = userData;
                               	this.eventResponse = {
                               		status: true,
                               		userData: this.userData
                               	}
                               	this.userIdentityStatus.emit(this.eventResponse);
                               }, //Bind to view
 							
                                err => {
                                    // Log errors if any
                                    console.log(err);
                                    this.eventResponse = {
                               			status: false,
                               			errorMsg: err
                               		}
                                    this.userIdentityStatus.emit(this.eventResponse);
                                });
  }

}