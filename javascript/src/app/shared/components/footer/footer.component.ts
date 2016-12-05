import { Component } from '@angular/core';

@Component({
  selector: 'footer',
  template:`
    <h1>{{title}}</h1>
  `
})

export class FooterComponent{
  title = 'footer';

}