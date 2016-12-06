import { Component } from '@angular/core';

@Component({
  selector: 'myindia-footer',
  template:`
    <h1>{{title}}</h1>
  `
})

export class FooterComponent{
  title = 'footer';

}