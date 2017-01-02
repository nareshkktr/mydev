
// Imports
import { Injectable }     from '@angular/core';
import { Http} from '@angular/http';
import {Observable} from 'rxjs/Rx'

@Injectable()
export class SharedDataService {

    private data:any;


     constructor () {
          console.log('initialize shared data service');
     }

     setData(data:any): void{
       this.data = data;
     }

     getData():any{
       return this.data;
     }

}