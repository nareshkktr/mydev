// Imports
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Rx';

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { SwaggerService } from '../../services/swagger.service';

@Injectable()
export class UserValidationService {
     // Resolve HTTP using the constructor
     constructor (private SwaggerService:SwaggerService) {}
     

     // Fetch the user
     validateUser(referenceName:any,yob:any,referenceType:string,userGuid: any) : Observable<any> {
        let validateUserReq={referenceName:referenceName,yearOfBirth:yob,referenceType:referenceType,userGuid:userGuid};
        let observer = new Observable(observer =>{  
              this.SwaggerService.fetchAPIMetaData().subscribe(services =>{
                   services.user.getUserByVoterReferenceAndAge({body:validateUserReq},function(results){
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