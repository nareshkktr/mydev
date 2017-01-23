import {Routes} from '@angular/router';

import { UserIdentityComponent } from '../userIdentity/userIdentity.component';
import { UserValidationComponent } from '../userValidation/userValidation.component';
import { UserLocationSetupComponent } from '../userLocationSetup/userLocationSetup.component';
import { UserAccountSetupComponent } from '../userAccountSetup/userAccountSetup.component';

export const SIGNUP_FLOW_ROUTES: Routes = [
  {path: 'signUp', redirectTo: 'userIdentity', pathMatch: 'full'},
  {path: 'userIdentity', component: UserIdentityComponent},
  {path: 'userValidation', component: UserValidationComponent},
  {path: 'userLocationSetup', component: UserLocationSetupComponent},
  {path: 'userAccountSetup', component: UserAccountSetupComponent}
];
