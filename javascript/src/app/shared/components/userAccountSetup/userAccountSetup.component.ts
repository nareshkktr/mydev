import { Component,EventEmitter,Input,Output } from '@angular/core';
import { UserAccountSetupService } from './UserAccountSetup.service';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

import { SharedDataService } from '../../services/sharedData.service';

import {Router} from '@angular/router';

@Component({
  selector: 'user-account-setup',
  templateUrl:'./userAccountSetup.component.html',
  styleUrls: ['./userAccountSetup.component.css'],
  providers: [UserAccountSetupService]
})

export class UserAccountSetupComponent{

  @Input() loginUserEmail: any;
  @Input() loginUserName: any;
  @Input() loginUserPassword: any;
  @Input() loginUserConfirmPassword: any;

  private userGuid:any;
  private childLocation:any;
  private parentLocation:any;  

  private userAccountSetupForm: any;

  constructor(private userAccountSetupService:UserAccountSetupService,fb: FormBuilder,
    private sharedDataService:SharedDataService,private router:Router) {

    if(this.sharedDataService.getData())
    {
    
      this.userGuid = this.sharedDataService.getData().userGuid;
      this.childLocation = this.sharedDataService.getData().childLocationData;
      this.parentLocation = this.sharedDataService.getData().userParentLocationData;
    }else{
       this.router.navigate(['../signUp/userIdentity']);
    }
  	
    this.userAccountSetupForm = fb.group({
      loginUserEmail: [null,Validators.required],
      loginUserName: [null,Validators.required],
      loginUserPassword: [null,Validators.compose([Validators.required,Validators.minLength(8),Validators.pattern('^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*(),./?]).*$')])],
      loginUserConfirmPassword: [null,Validators.compose([Validators.required,this.validateConfirmPwd(this)])]
    });
  }

  validateConfirmPwd(obj: any) {

    return function(input: FormControl) {
      return input.value == obj.loginUserPassword ?
          null :
          {validateConfirmPwd: {
            valid: false
          }};
    };

  }

  createAccount(){
    this.userAccountSetupService.createAccount(this.loginUserEmail,this.loginUserName,this.loginUserPassword,this.userGuid,this.childLocation,this.parentLocation).subscribe(result =>{
              this.sharedDataService.setData(result);
              this.router.navigate(['../signUp/userValidation']);
        },
        error => {
              alert(error.statusText);
        });
  }

}