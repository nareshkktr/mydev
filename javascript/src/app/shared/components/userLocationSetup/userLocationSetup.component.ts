import { Component,EventEmitter,Input,Output } from '@angular/core';
import { UserLocationSetupService } from './userLocationSetup.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router} from '@angular/router';

import { SharedDataService } from '../../services/sharedData.service';

@Component({
  selector: 'user-location-setup',
  templateUrl:'./userLocationSetup.component.html',
  styleUrls: ['./userLocationSetup.component.css'],
  providers: [UserLocationSetupService]
})

export class UserLocationSetupComponent{

  @Input() locationInfo: any;

  private userLocationData;

  private userLocationSetupForm: any;

  constructor(private userLocationSetupService:UserLocationSetupService,fb: FormBuilder
    ,private sharedDataService:SharedDataService,private router:Router) {
  	
    if(this.sharedDataService.getData() && this.sharedDataService.getData().locations){
      this.userLocationData = this.sharedDataService.getData();
    }
    else{
      this.router.navigate(['../signUp/userIdentity']);
    }
    this.userLocationSetupForm = fb.group({
      locationInfo: [null,Validators.required]
    });

  }

  saveLocation(){
  	this.userLocationSetupService.saveLocation(this.locationInfo).subscribe(result =>{
              this.sharedDataService.setData(result);
              this.router.navigate(['../signUp/userValidation']);
        },
        error => {
              alert(error.statusText);
        });
  }
  }

}