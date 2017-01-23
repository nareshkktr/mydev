import { Component, Optional,ViewEncapsulation,Input } from '@angular/core';
import {MdDialog, MdDialogRef} from '@angular/material';
import { LocationSearchResultsService } from './locationChange/locationSearchResults.service';
import { Router } from '@angular/router';

@Component({
  selector: 'myindia-header',
  templateUrl:'./header.component.html',
  styleUrls: ['./header.component.css'],
  encapsulation: ViewEncapsulation.Emulated 
})

export class HeaderComponent{
  title = 'My India';
  constructor(private _dialog: MdDialog,private router: Router) {};
  openChooseLocationDailog() {
    let dialogRef = this._dialog.open(LocationChangeDialogContent);
  };
  
  @Input() gloablSearhText: string;
  
  globalSearch(){
  	if(this.gloablSearhText.length >=3){
  		 this.router.navigate(['./search',this.gloablSearhText]);
	}
  }
}

@Component({
  selector: 'myindia-location-change',
  templateUrl:'./locationChange/header.location.change.component.html',
  styleUrls: ['./locationChange/header.location.change.component.css'],
  providers: [LocationSearchResultsService]
})

export class LocationChangeDialogContent {
 private searchResults: any;
  constructor(private LocationSearchResultsService:LocationSearchResultsService,@Optional() public dialogRef: MdDialogRef<LocationChangeDialogContent>) { 
  this.locationSearch();
  }
   locationSearch(){
  	  	this.LocationSearchResultsService.locationSearch().subscribe(results =>{
              this.searchResults = JSON.parse(results);
        },
        error => {
              console.log('Search Error'+error);
        });
  }
  @Input() locationText:string;
  locationSearchByInput(){
   if(this.locationText.length >=3){
  	this.LocationSearchResultsService.locationSearchByInput(this.locationText).subscribe(results =>{
              this.searchResults = JSON.parse(results);
        },
        error => {
              console.log('Search Error'+error);
        });
       }
       else if(this.locationText.length <1){
       		this.searchResults=[];
       }
       else if(this.locationText.length ==0){
       		this.locationSearch();
       }
  }

  setLocationSelected(locationName){
  }
  setLocation(){
  }
}
