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
  
  private locationTypes: any;
  
  private userParentLocationData: any;
  
  private showParentLocationRow: any;
  private userGuid:any;
  private serviceResponse: any;

  constructor(private userLocationSetupService:UserLocationSetupService,fb: FormBuilder
    ,private sharedDataService:SharedDataService,private router:Router) {
  	
    if(this.sharedDataService.getData() && this.sharedDataService.getData().locations){
    this.showParentLocationRow=false;
     this.userParentLocationData ={};
     this.userGuid = this.sharedDataService.getData().userGuid;
      this.userLocationData = this.sharedDataService.getData();
      this.locationTypes = Object.keys(this.userLocationData.locations);
      for(let i=0;i<this.locationTypes.length;i++){
      }
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
  			  this.userParentLocationData=result.parentLocations[0];

  			  result["userGuid"]=this.userGuid;
  			  result["childLocationData"]=this.locationInfo;
  			  result["userParentLocationData"]=this.userParentLocationData;
              this.serviceResponse=result;
              this.showParentLocationRow=true;
              this.sharedDataService.setData(result);
              this.router.navigate(['../signUp/userAccountSetup']);
        },
        error => {
              alert(error.statusText);
        });
  }
  
  confirmLocation(){
  		
  		this.router.navigate(['../signUp/userAccountSetup']);
  }
  }