import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService, private snack:MatSnackBar) { }

  public user = {
    username:'',
    password:''
  };

  ngOnInit(): void {
  }

  formSubmit(){
    console.log(this.user);
    if(this.user.username == '' || this.user.username == null ){
      // alert('user is required');
      this.snack.open('username required','ok');
      return;
    }
    //add user
    this.userService.addUser(this.user).subscribe(
      (data)=>{
        console.log(data);
        alert("success");
      },
      (error)=>{
        console.log(error);
        alert("error");
        // this.snack.open(" Try Again ;(", '',{
        //   duration:3000,
        // })
      }
    );
  }

}
