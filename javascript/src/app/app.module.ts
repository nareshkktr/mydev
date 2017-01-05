import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { MaterialModule } from '@angular/material';
import { LayoutModule } from 'ng2-flex-layout';
import { HeaderComponent,LocationChangeDialogContent} from './shared/components/header/header.component';
import { FooterComponent } from './shared/components/footer/footer.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { SignInComponent } from './shared/components/signIn/signIn.component';
import { UserIdentityComponent } from './shared/components/userIdentity/userIdentity.component';
import { UserValidationComponent } from './shared/components/userValidation/userValidation.component';
import { UserLocationSetupComponent } from './shared/components/userLocationSetup/userLocationSetup.component';
import { UserAccountSetupComponent } from './shared/components/userAccountSetup/userAccountSetup.component';
import { SearchResultsComponent } from './shared/components/searchResults/searchResults.component';
import { SignUpComponent } from './shared/components/signUp/signUp.component';

import { SwaggerService } from './shared/services/swagger.service';
import { SharedDataService } from './shared/services/sharedData.service';
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
SignInComponent,
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
LayoutModule,
ReactiveFormsModule,
RouterModule.forRoot(AppRoutes),
MaterialModule.forRoot(),
],
entryComponents: [LocationChangeDialogContent],
providers: [SwaggerService,SharedDataService],
bootstrap: [AppComponent]
})
export class AppModule { }