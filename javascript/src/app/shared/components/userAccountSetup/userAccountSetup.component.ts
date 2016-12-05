import { Component,EventEmitter,Input,Output } from '@angular/core';
import { UserAccountSetupService } from './UserAccountSetup.service'

@Component({
  selector: 'user-account-setup',
  templateUrl:'./userAccountSetup.component.html',
  styleUrls: ['./userAccountSetup.component.css'],
  providers: [UserAccountSetupService]
})

export class UserAccountSetupComponent{

  @Input() title: any;
  @Input() fhName: any;
  @Input() houseNo: any;
  @Input() yob: any;
  @Output() userAccountSetupStatus = new EventEmitter<any>();

  private userLocationData;

  constructor(private userAccountSetupService:UserAccountSetupService) {
  	this.userLocationData = {};
  }

  validateUser(){
  	this.userAccountSetupService.validateUser(this.fhName,this.houseNo,this.yob)
                           .subscribe(
                               userLocationData => {
                               	this.userLocationData = userLocationData;
                               	this.userAccountSetupStatus.emit(true);
                               }, //Bind to view
 							
                                err => {
                                    // Log errors if any
                                    console.log(err);
                                    this.userAccountSetupStatus.emit(false);
                                });
  }

}