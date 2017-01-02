import { Component,EventEmitter,Input,Output } from '@angular/core';
import { UserValidationService } from './userValidation.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router} from '@angular/router';

import { SharedDataService } from '../../services/sharedData.service';

@Component({
  selector: 'user-validation',
  templateUrl:'./userValidation.component.html',
  styleUrls: ['./userValidation.component.css'],
  providers: [UserValidationService]
})

export class UserValidationComponent{

  @Input() referenceName: any;
  @Input() yob: any;

  private userValidationData;
  private years = [];
  private numberOfYears = 100;
  private userValidationForm: any;
  private referenceNameText: string;
  private referenceType : string;
  private userGuid: any;

  constructor(private userValidationService:UserValidationService,fb: FormBuilder,
    private sharedDataService:SharedDataService,private router: Router) {

    console.log(this.sharedDataService.getData());
    if(this.sharedDataService.getData() && this.sharedDataService.getData().referenceType){
      this.referenceType = this.sharedDataService.getData().referenceType;
      this.userGuid = this.sharedDataService.getData().userGuid;
      this.referenceNameText = "Enter the Elector's "+this.referenceType+" name";
    }
    else{
      this.router.navigate(['../signUp/userIdentity']);
    }

  	this.userValidationData = {};
    this.populateYears();
    this.userValidationForm = fb.group({
      referenceName: [null,Validators.required],
      year: [null,Validators.required]
    });

  }

  populateYears(){
    let currentYear = new Date().getFullYear();
    //populate default ste of years.
    for(let start=0;start<this.numberOfYears;start++){
       this.years.push(currentYear--);
    }

  }

  validateUser(){
  	  this.userValidationService.validateUser(this.referenceName,this.yob,this.referenceType,this.userGuid).subscribe(result =>{
              this.sharedDataService.setData(result);
              this.router.navigate(['../signUp/userLocationSetup']);
              
        },
        error => {
              alert(error.statusText);
        });
  }

}