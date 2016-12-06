# MyIndia - UI

This project was generated with [angular-cli](https://github.com/angular/angular-cli) version 1.0.0-beta.17.

## Development server
Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive/pipe/service/class`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/). 
Before running the tests make sure you are serving the app via `ng serve`.

## Deploying to Github Pages

Run `ng github-pages:deploy` to deploy to Github Pages.

## Further help

To get more help on the `angular-cli` use `ng --help` or go check out the [Angular-CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

# Project Specific

This section highlights the UI frameworks used for My India project. 

  - Angular 2 framework
  - Typescript
  - HTML 5 & CSS
  - Webpack for Module Bundler
  - Web Component frameworks ??
  - Angular CLI
  - npm as package manager

### Folder Structure & Organization

We have followed the folder organization & file structure suggested in [John Papa's Blog](https://johnpapa.net/angular-2-styles/). 

```
index.html
README.md
app/
│   config.js  ## brunch config file
│   main.js    ## bootstraping root module
│
└───politician
│   │   politicians.js   
│   │   politicians.component.js
│   │   politicians.service.js
|   |    politicians-list.component.js
|   |    politicians-list.component.html
|   |    politicians-list.component.css
└───shared
|    |───header
│       │   header.component.js
│       │   header.component.html
│       │   ...
```

- Folders inside app/ are organized by features. 
- Each feature folder is self contained with its services, component , css and html files.
- If there are features/components shared across whole application it is placed inside shared folder.
- Naming conventions include .component, .service as an indication of the type of the file contents.
- We use descriptive naming for list, detail etc as appropriate.
- If there are services used across application it will be inside shared folder under a sub folder called service.


# More content coming soon.... Stay Tuned..
