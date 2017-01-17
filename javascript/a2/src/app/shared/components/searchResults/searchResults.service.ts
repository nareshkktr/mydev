// Imports
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Rx';

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { SwaggerService } from '../../services/swagger.service';

@Injectable()
export class SearchResultsService {

     // Resolve HTTP using the constructor
     constructor (private SwaggerService:SwaggerService,private http: Http) {} 

     // Fetch the user
     search(searchText:string) : Observable<any> {
        let observer = new Observable(observer =>{
              this.SwaggerService.fetchAPIMetaData().subscribe(services =>{
                   services.search.getAllGlobalSearchResults({searchTerm:searchText},function(results){
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
        // var deferred = new Promise(function(resolve, reject){ 
        //     self.SwaggerService.fetchAPIMetaData().subscribe(services => {
        //             services.search.getAllGlobalSearchResults({searchTerm:searchText},function(results){
        //                     resolve(results.data);
        //             },function(error){
        //                     reject(error);
        //             });
        //    },
        //    err => {
        //         // Log errors if any
        //         reject(err);
        //     });
        // });


        return observer;
       
     }

}