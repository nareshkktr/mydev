
// Imports
import { Injectable }     from '@angular/core';
import { Http} from '@angular/http';
import {Observable} from 'rxjs/Rx';


var Swagger = require('swagger-client');

@Injectable()
export class SwaggerService {

    private apiMetaData:any;
    private observer: Observable<any>;


     constructor () {
          console.log('initialize swaagger service');
     }

     // Fetch the user
    fetchAPIMetaData() : Observable<any> {

        if(this.apiMetaData){
          return new Observable(observer => {
              observer.next(this.apiMetaData);
          });
        }else{
            let observer = new Observable(observer =>{
              var self = this;
              var swagger = new Swagger({
                url: 'http://localhost:8080/api/swagger.json',
                success: function() {
                      self.apiMetaData = swagger;
                      observer.next(swagger);
                      observer.complete();
                }
              });
            });

            return observer;
        }
     }

}