import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-update-guest',
  templateUrl: './update-guest.component.html',
  styleUrls: ['./update-guest.component.css']
})
export class UpdateGuestComponent implements OnInit {

  id!: number;
  guest: Guest = new Guest();
  constructor(private guestService: GuestService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.guestService.getGuestById(this.id).subscribe(data =>{
      this.guest = data;
    },error=> console.log(error));

  }
  onSubmit(){
    this.guestService.updateGuest(this.id, this.guest).subscribe( data =>{
      this.goToGuestList();
    },error => console.log(error));
  }

  goToGuestList(){
    this.router.navigate(['/guest']);
  }

}
