import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuestListComponent } from './guest-list/guest-list.component';
import { CreateGuestComponent } from './create-guest/create-guest.component';
import { UpdateGuestComponent } from './update-guest/update-guest.component';
import { GuestDetailsComponent } from './guest-details/guest-details.component';
import { StaffListComponent } from './staff-list/staff-list.component';
import { StaffDetailsComponent } from './staff-details/staff-details.component';
import { UpdateStaffComponent } from './update-staff/update-staff.component';
import { CreateStaffComponent } from './create-staff/create-staff.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { ManagerDashboardComponent } from './manager/manager-dashboard/manager-dashboard.component';
import { ReceptionistComponent } from './receptionist/receptionist/receptionist.component';
import { AdminGuardGuard } from './admin-guard.guard';
import { NormalGuardGuard } from './normal-guard.guard';
import { ReceptionGuardGuard } from './reception-guard.guard';

const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full' },

  { path: 'signup', component: SignupComponent, pathMatch: 'full' },
  { path: 'login', component: LoginComponent, pathMatch: 'full' },
  { path: 'guest', component: GuestListComponent, pathMatch: 'full' },
  { path: 'create-guest', component: CreateGuestComponent, pathMatch: 'full' },
  { path: 'update-guest/:id', component: UpdateGuestComponent, pathMatch: 'full' },
  { path: 'guest-details/:id', component: GuestDetailsComponent, pathMatch: 'full' },
  { path: 'staff', component: StaffListComponent},
  { path: 'create-staff', component: CreateStaffComponent, pathMatch: 'full' },
  { path: 'update-staff/:code', component: UpdateStaffComponent, pathMatch: 'full' },
  { path: 'staff-details/:code', component: StaffDetailsComponent, pathMatch: 'full' },
  { path: 'owner', component: DashboardComponent, pathMatch: 'full', canActivate: [AdminGuardGuard] },
  { path: 'manager', component: ManagerDashboardComponent, pathMatch: 'full', canActivate: [NormalGuardGuard] },
  { path: 'receptionist', component: ReceptionistComponent, pathMatch: 'full', canActivate: [ReceptionGuardGuard] }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }