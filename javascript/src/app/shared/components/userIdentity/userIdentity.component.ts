import { Component,EventEmitter,Input,Output } from '@angular/core';
import { UserIdentityService } from './userIdentity.service'
import {Router} from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'user-identity',
  templateUrl:'./userIdentity.component.html',
  styleUrls: ['./userIdentity.component.css'],
  providers: [UserIdentityService]
})

export class UserIdentityComponent{

  private userIdentityForm: any;

  @Input() electorID :string;
  @Input() electorName: string;

  constructor(private userIdentityService:UserIdentityService,private router: Router,fb: FormBuilder) {
    this.userIdentityForm = fb.group({
      electorID: [null,Validators.required],
      electorName: [null,Validators.required]
    });
  }

  validateElectorInfo(){
  	this.router.navigate(['../signUp/userValidation']);
  }

  retreiveUser(){

    this.userIdentityService.retreiveUser(this.electorID,this.electorName).subscribe(result =>{
              console.log(JSON.parse(result));
              this.router.navigate(['../signUp/userValidation']);
              alert("Login Success");
        },
        error => {
              alert(error.statusText);
        });
  }

}