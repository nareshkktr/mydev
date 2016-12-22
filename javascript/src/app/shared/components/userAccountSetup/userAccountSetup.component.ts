import { Component,EventEmitter,Input,Output } from '@angular/core';
import { UserAccountSetupService } from './UserAccountSetup.service';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

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
  private userAccountSetupForm: any;

  constructor(private userAccountSetupService:UserAccountSetupService,fb: FormBuilder) {
  	this.userLocationData = {};
    this.userAccountSetupForm = fb.group({
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