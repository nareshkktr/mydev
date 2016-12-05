// Imports
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Rx';

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class UserValidationService {
     // Resolve HTTP using the constructor
     constructor (private http: Http) {}
     // private instance variable to hold base url
     private gihubAPIUrl = 'https://api.github.com/search/repositories'; 

     // Fetch the user
     validateUser(fhName:any,houseNo:any,yob:any) : Observable<any> {

         // ...using get request
         return this.http.get(this.gihubAPIUrl+"?q="+fhName)
                        // ...and calling .json() on the response to return data
                         .map((res:Response) => res.json())
                         //...errors if any
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error'));

     }

}