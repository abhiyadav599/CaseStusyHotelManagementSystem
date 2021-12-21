import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Staff } from '../staff';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-create-staff',
  templateUrl: './create-staff.component.html',
  styleUrls: ['./create-staff.component.css']
})
export class CreateStaffComponent implements OnInit {

  staff : Staff = new Staff();

  constructor(private staffService: StaffService, 
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveStaff(){
    this.staffService.createStaff(this.staff).subscribe(data => {
      console.log(data);
      this.goToGuestList();
    },
    error => console.log(error));
  }
 
  goToGuestList(){
    this.router.navigate(['/staff']);
  }

  onSubmit() {
    console.log(this.staff);
    this.saveStaff();

  }


}
