import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData = {
    username: '',
    password: ''
  };
  // username = 'javainuse'
  // password = ''
  // invalidLogin = false

  constructor(private snack: MatSnackBar,
    private login: LoginService,
    private router: Router) { }

  ngOnInit(): void {
  }

  formSubmit() {

    if (this.loginData.username.trim() == '' || this.loginData.username == null) {
      this.snack.open("username required!!", '', {
        duration: 3000,
      });
      return;
    }
    if (this.loginData.password.trim() == '' || this.loginData.password == null) {
      this.snack.open("password required!!", '', {
        duration: 3000,
      });
      return;
    }

    // request to server to generate token
    this.login.generateToken(this.loginData).subscribe(
      (data: any) => {
        console.log('success');
        console.log(data);

        //login

        this.login.loginUser(data.token);

        this.login.getCurrentUser().subscribe((user: any) => {
          this.login.setUser(user);
          console.log(user);

          //redirect ...ADMIN: admin-dashboard
          //redirect ...Manager: manager-dashboard
          if (this.login.getUserRole() == 'OWNER') {
            //Admin Dashboard
            // window.location.href='/owner'
            this.router.navigate(['/owner'])
          } else if (this.login.getUserRole() == 'MANAGER') {
            //Manager Dashboard
            // window.location.href='/manager'
            this.router.navigate(['/manager'])
          }  else if (this.login.getUserRole() == 'RECEPTION') {
            //Manager Dashboard
            // window.location.href='/receptionist'
            this.router.navigate(['/receptionist'])
          }else {
            this.login.logout();
          }
        });
      },
      (error) => {
        console.log('error');
        console.log(error);
        this.snack.open("Invalid Details!!! | Try Again ;(", '',{
          duration:3000,
        })
      }
    );

    // checkLogin() {
    //   if (this.loginservice.authenticate(this.username, this.password)
    //   ) {
    //     this.router.navigate([''])
    //     this.invalidLogin = false
    //   } else
    //     this.invalidLogin = true
    // }
  }


}
