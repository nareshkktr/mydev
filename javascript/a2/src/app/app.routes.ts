import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { SignInComponent } from './shared/components/signIn/signIn.component';
import { SearchResultsComponent } from './shared/components/searchResults/searchResults.component';
import { SignUpComponent } from './shared/components/signUp/signUp.component';
import {SIGNUP_FLOW_ROUTES} from './shared/components/signUp/routes';

export const AppRoutes = [
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'signIn', component: SignInComponent },
  { path: 'signUp', component: SignUpComponent },
  { path: 'search/:term', component: SearchResultsComponent },
  { path: '', component: HomeComponent },
  { path: 'signUp', component: SignUpComponent, children: SIGNUP_FLOW_ROUTES},
];