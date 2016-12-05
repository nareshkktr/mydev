import { Component,EventEmitter,Input,Output } from '@angular/core';
import { UserLocationSetupService } from './userLocationSetup.service'

@Component({
  selector: 'user-location-setup',
  templateUrl:'./userLocationSetup.component.html',
  styleUrls: ['./userLocationSetup.component.css'],
  providers: [UserLocationSetupService]
})

export class UserLocationSetupComponent{

  @Input() fhName: any;
  @Input() houseNo: any;
  @Input() yob: any;
  @Output() userLocationSetupStatus = new EventEmitter<any>();

  private userLocationData;

  constructor(private userLocationSetupService:UserLocationSetupService) {
  	this.userLocationData = {};
  }

  validateUser(){
  	this.userLocationSetupService.validateUser(this.fhName,this.houseNo,this.yob)
                           .subscribe(
                               userLocationData => {
                               	this.userLocationData = userLocationData;
                               	this.userLocationSetupStatus.emit(true);
                               }, //Bind to view
 							
                                err => {
                                    // Log errors if any
                                    console.log(err);
                                    this.userLocationSetupStatus.emit(false);
                                });
  }

}