// Imports
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Rx';

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { SwaggerService } from '../../../services/swagger.service';


@Injectable()
export class LocationSearchResultsService {

     // Resolve HTTP using the constructor
     constructor (private SwaggerService:SwaggerService) {} 
     
 
     locationSearch() : Observable<any> {
        let observer = new Observable(observer =>{
              this.SwaggerService.fetchAPIMetaData().subscribe(services =>{
                   services.location.getPopularLocations(function(results){
                           observer.next(results.data);
                           observer.complete();
                   },function(error){
                       observer.next(error.data);
                       observer.complete();
                   }); 
              },
              error =>{
                  observer.error(error);
              });
        });
               return observer;
     }
     

     locationSearchByInput(searchText:string) : Observable<any> {
        let observer = new Observable(observer =>{
              this.SwaggerService.fetchAPIMetaData().subscribe(services =>{
                   services.location.getSearchResultsByLocationName({searchTerm:searchText},function(results){
                           observer.next(results.data);
                           observer.complete();
                   },function(error){
                       observer.next(error.data);
                       observer.complete();
                   }); 
              },
              error =>{
                  observer.error(error);
              });
        });
               return observer;
     }
}