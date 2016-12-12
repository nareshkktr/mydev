import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { MaterialModule } from '@angular/material';


import { HeaderComponent,LocationChangeDialogContent} from './shared/components/header/header.component';
import { FooterComponent } from './shared/components/footer/footer.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { SignUpComponent } from './shared/components/signUp/signUp.component';
import { UserIdentityComponent } from './shared/components/userIdentity/userIdentity.component';
import { UserValidationComponent } from './shared/components/userValidation/userValidation.component';
import { UserLocationSetupComponent } from './shared/components/userLocationSetup/userLocationSetup.component';
import { UserAccountSetupComponent } from './shared/components/userAccountSetup/userAccountSetup.component';
import { SearchResultsComponent } from './shared/components/searchResults/searchResults.component';


import { SwaggerService } from './shared/services/swagger.service';
import { AppComponent } from './app.component';
import { AppRoutes } from './app.routes';





@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LocationChangeDialogContent,
    FooterComponent,
    HomeComponent,
    AboutComponent,
    SignUpComponent,
    UserIdentityComponent,
    UserValidationComponent,
    UserLocationSetupComponent,
    UserAccountSetupComponent,
    SearchResultsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(AppRoutes),
    MaterialModule.forRoot(),
  ],
  entryComponents: [LocationChangeDialogContent],
  providers: [SwaggerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
