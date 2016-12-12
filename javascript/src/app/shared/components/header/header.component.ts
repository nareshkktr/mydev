import { Component, Optional,ViewEncapsulation } from '@angular/core';
import {MdDialog, MdDialogRef} from '@angular/material';

@Component({
  selector: 'myindia-header',
  templateUrl:'./header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent{
  title = 'My India';
  constructor(private _dialog: MdDialog) {};
  openChooseLocationDailog() {
    let dialogRef = this._dialog.open(LocationChangeDialogContent);
  }
}

@Component({
  selector: 'myindia-location-change',
  templateUrl:'./locationChange/header.location.change.component.html',
  styleUrls: ['./locationChange/header.location.change.component.css']
})

export class LocationChangeDialogContent {
  constructor(@Optional() public dialogRef: MdDialogRef<LocationChangeDialogContent>) { }
}