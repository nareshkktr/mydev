
// Imports
import { Injectable }     from '@angular/core';
import { Http} from '@angular/http';
import {Observable} from 'rxjs/Rx';


var Swagger = require('swagger-client');

@Injectable()
export class SwaggerService {

    private apiMetaData:any;
    static instance: SwaggerService;


     constructor () {
          console.log('initialize swaagger service');
          this.fetchAPIMetaData().subscribe(services => {
                                          this.apiMetaData = services;
                                       },
                                       err => {
                                        // Log errors if any
                                           Observable.throw(err);
                                        }
                              );
     }

     // Fetch the user
    fetchAPIMetaData() : Observable<any> {

        if(this.apiMetaData){
            return Observable.of(this.apiMetaData);
        }else{
            return Observable.of(new Swagger({
              url: 'http://localhost:8080/api/swagger.json',
              success: function() {
                    console.log("sucess");
                }
            }));
        }

     }

}