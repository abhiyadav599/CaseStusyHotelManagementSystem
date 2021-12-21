import { Component, OnInit } from '@angular/core';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create-guest',
  templateUrl: './create-guest.component.html',
  styleUrls: ['./create-guest.component.css']
})
export class CreateGuestComponent implements OnInit {

  guest : Guest = new Guest();

  constructor(private guestService: GuestService, 
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveGuest(){
    this.guestService.createGuest(this.guest).subscribe(data => {
      console.log(data);
      this.goToGuestList();
    },
    error => console.log(error));
  }
 
  goToGuestList(){
    this.router.navigate(['/guest']);
  }

  onSubmit() {
    console.log(this.guest);
    this.saveGuest();

  }

}
