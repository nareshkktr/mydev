// Imports
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Rx';

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { SwaggerService } from '../../services/swagger.service';

@Injectable()
export class UserIdentityService {
     // Resolve HTTP using the constructor
     constructor (private SwaggerService:SwaggerService) {}
     

     // Fetch the user
     retreiveUser(voterId:any,name:any) : Observable<any> {
        let retreiveUserReq={idCardNo:voterId,userName:name,idCardType:'VOTER ID'};
        let observer = new Observable(observer =>{
              this.SwaggerService.fetchAPIMetaData().subscribe(services =>{
                   services.user.getUserByVoterIdAndName({body:retreiveUserReq},function(results){
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