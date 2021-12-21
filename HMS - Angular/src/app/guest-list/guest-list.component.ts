import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';


@Component({
  selector: 'app-guest-list',
  templateUrl: './guest-list.component.html',
  styleUrls: ['./guest-list.component.css']
})
export class GuestListComponent implements OnInit {

  // guest : Guest = new Guest();
  guest!: Guest[];


  constructor(private guestService: GuestService, 
    private router: Router) { }

  ngOnInit(): void
  {
    this.getGuest();
  }

  private getGuest(){
    this.guestService.getGuestList().subscribe(data => {
      this.guest = data;
    });
  
  }

  updateGuest(id: number){
    this.router.navigate(['update-guest', id]);
  }

  deleteGuest(id: number){
    this.guestService.deleteGuest(id).subscribe( data => {
      console.log(data);
      this.getGuest();
    })
  }

  guestDetails(id: number){
    this.router.navigate(['guest-details', id]);
  }

  // {
  //   this.guest = [{
  //     "id":1,
  //     "firstName":"Abhi",
  //     "lastName":"yadav"
  //   },
  //   {
  //     "id":2,
  //     "firstName":"Abhi1",
  //     "lastName":"yadav1"
  //   }];
  // }

}
