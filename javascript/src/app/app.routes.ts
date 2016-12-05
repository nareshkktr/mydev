import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { SignUpComponent } from './shared/components/signUp/signUp.component';


export const AppRoutes = [
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'signUp', component: SignUpComponent },
  { path: '', component: HomeComponent }
];