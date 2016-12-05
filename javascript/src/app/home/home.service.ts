// Imports
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Rx';
import { SwaggerService } from '../shared/services/swagger.service'

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class HomeService {
     // Resolve HTTP using the constructor
     constructor (private http: Http,private swaggerService:SwaggerService) {

         console.log('initalize home service');
     }
     // private instance variable to hold base url
     private gihubAPIUrl = 'http://localhost:8080/api/account/login'; 

     private services:any;

     // Fetch all existing repositories
     getRepositories(searchTerm:any) : any {

         // ...using get request
         /* return this.http.get(this.gihubAPIUrl+"?q="+searchTerm)
                        // ...and calling .json() on the response to return data
                         .map((res:Response) => res.json())
                         //...errors if any
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
        */
            let requestBody = {
                loginUserName: "kasi",
                password: "kasi"
            };
            this.swaggerService.fetchAPIMetaData().subscribe(
                                       services => {
                                           this.services = services;
                                           let requestBody ={
                                                 loginUserName: "kasi",
                                                 password: "kasi"
                                            }
                                            this.services.account.login({body:JSON.stringify(requestBody)}).then(function(data){
                                                alert(data);
                                                return data.asObservable();
                                            },function(err){
                                              alert(err);
                                            });
                                       },
                                       err => {
                                        // Log errors if any
                                           Observable.throw(err);
                                        }
                                );

           // let servicces = this.swaggerService.fetchAPIMetaData()
           //                     .subscribe(
           //                             services => this.services = services,
           //                             err => {
           //                              // Log errors if any
           //                              console.log(err);
           //                              }
           //                      );
          //  this.services.account.login(requestBody);
           // return this.http.post(this.gihubAPIUrl,requestBody).map((res:Response) => res.json()) // ...and calling .json() on the response to return data
           //               .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
     
        }
     

}