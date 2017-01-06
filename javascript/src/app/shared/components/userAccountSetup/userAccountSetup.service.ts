// Imports
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Rx';

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { SwaggerService } from '../../services/swagger.service';

@Injectable()
export class UserAccountSetupService {
     // Resolve HTTP using the constructor
     constructor (private SwaggerService:SwaggerService) {}
     

     // Create tha ccount
     createAccount(loginUserEmail:any,username:any,password:any,userguid:any,childLocation:any,parentLocation:any) : Observable<any> {
        let retreiveUserReq={emailAddress:loginUserEmail,loginUserName:username,password:password,userGuid:userguid,childLocation:childLocation,parentLocation:parentLocation};
        let observer = new Observable(observer =>{
              this.SwaggerService.fetchAPIMetaData().subscribe(services =>{
                   services.account.createAccount({body:retreiveUserReq},function(results){
                           observer.next(results.obj);
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