import { Component,Input } from '@angular/core';
import { SignInService } from './signIn.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'sign-in',
  templateUrl:'./signIn.component.html',
  styleUrls: ['./signIn.component.css'],
  providers: [SignInService]
})

export class SignInComponent{

  private title="Sign In";
  private signInForm : any;

  constructor(private signInService:SignInService,fb: FormBuilder) {
    this.signInForm = fb.group({
      loginUserName: [null,Validators.required],
      loginUserPassword: [null,Validators.compose([Validators.required,Validators.minLength(8)])]
    });
  }
  
  @Input() loginUserName:string;
  @Input() loginUserPassword:string;
  
  signIn(){
  		this.loginUserName=undefined?"":this.loginUserName;
  		this.loginUserPassword=undefined?"":this.loginUserPassword;
  		
  		this.signInService.doSignIn(this.loginUserName,this.loginUserPassword).subscribe(result =>{
              console.log(JSON.parse(result));
              alert("Login Success");
        },
        error => {
              alert(error.statusText);
        });
  }
  
}