// Imports
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Rx';

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { SwaggerService } from '../../services/swagger.service';


@Injectable()
export class SignInService {

     // Resolve HTTP using the constructor
     constructor (private SwaggerService:SwaggerService) {} 

     doSignIn(loginUserName:string,loginUserPassword:string) : Observable<any> {
     	let signInRequest={loginUserName:loginUserName,password:loginUserPassword};
        let observer = new Observable(observer =>{
              this.SwaggerService.fetchAPIMetaData().subscribe(services =>{
                   services.account.login({body:signInRequest},function(results){
                           observer.next(results.data);
                           observer.complete();
                   },function(error){
                       observer.error(error);
                   }); 
              },
              error =>{
                  observer.error(error);
              });
        });
            return observer;
     }
}