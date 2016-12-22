import { Component,EventEmitter,Input,Output } from '@angular/core';
import { UserLocationSetupService } from './userLocationSetup.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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

  private userLocationSetupForm: any;

  constructor(private userLocationSetupService:UserLocationSetupService,fb: FormBuilder) {
  	this.userLocationData = {};
    this.userLocationSetupForm = fb.group({
      locationInfo: [null,Validators.required]
    });
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