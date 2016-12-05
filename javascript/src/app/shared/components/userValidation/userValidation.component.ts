import { Component,EventEmitter,Input,Output } from '@angular/core';
import { UserValidationService } from './userValidation.service'

@Component({
  selector: 'user-validation',
  templateUrl:'./userValidation.component.html',
  styleUrls: ['./userValidation.component.css'],
  providers: [UserValidationService]
})

export class UserValidationComponent{

  @Input() fhName: any;
  @Input() houseNo: any;
  @Input() yob: any;
  @Output() userValidationStatus = new EventEmitter<any>();

  private userValidationData;
  private years = [];
  private numberOfYears = 100;

  constructor(private userValidationService:UserValidationService) {
  	this.userValidationData = {};
    this.populateYears();
  }

  populateYears(){
    let currentYear = new Date().getFullYear();
    //Set default to current year
    this.yob=currentYear;
    //populate default ste of years.
    for(let start=0;start<this.numberOfYears;start++){
       this.years.push(currentYear--);
    }

  }

  validateUser(){
  	this.userValidationService.validateUser(this.fhName,this.houseNo,this.yob)
                           .subscribe(
                               userValidationData => {
                               	this.userValidationData = userValidationData;
                               	this.userValidationStatus.emit(true);
                               }, //Bind to view
 							
                                err => {
                                    // Log errors if any
                                    console.log(err);
                                    this.userValidationStatus.emit(false);
                                });
  }

}