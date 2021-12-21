import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { MatButtonModule } from '@angular/material/button'

import { GuestListComponent } from './guest-list/guest-list.component';
import { CreateGuestComponent } from './create-guest/create-guest.component';
import { FormsModule } from '@angular/forms';
import { UpdateGuestComponent } from './update-guest/update-guest.component';
import { GuestDetailsComponent } from './guest-details/guest-details.component';
import { StaffListComponent } from './staff-list/staff-list.component';
import { StaffDetailsComponent } from './staff-details/staff-details.component';
import { CreateStaffComponent } from './create-staff/create-staff.component';
import { UpdateStaffComponent } from './update-staff/update-staff.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { HomeComponent } from './home/home.component';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { authInterceptorProviders } from './auth.interceptor';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { ManagerDashboardComponent } from './manager/manager-dashboard/manager-dashboard.component';
import { ReceptionistComponent } from './receptionist/receptionist/receptionist.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatRadioModule} from '@angular/material/radio';

@NgModule({
  declarations: [
    AppComponent,
    GuestListComponent,
    CreateGuestComponent,
    UpdateGuestComponent,
    GuestDetailsComponent,
    StaffListComponent,
    StaffDetailsComponent,
    CreateStaffComponent,
    UpdateStaffComponent,
    NavbarComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    DashboardComponent,
    ManagerDashboardComponent,
    ReceptionistComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatDatepickerModule,
    MatRadioModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
